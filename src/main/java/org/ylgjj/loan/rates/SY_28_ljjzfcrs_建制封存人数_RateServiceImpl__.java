package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.DP204_个人缴存变更登记簿;
import org.ylgjj.loan.enumT.E_DP007_个人分户账_个人账户状态;
import org.ylgjj.loan.enumT.E_DP204_个人缴存变更登记簿_变更类型;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.enumT.E_dp007_个人分户账_类型;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.统计周期编码;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_28_ljjzfcrs_建制封存人数_RateServiceImpl__ extends RateServiceBaseImpl {

    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_28_ljjzfcrs_建制封存人数;

    public void realTime() {

        Long count = dp007_个人分户账_repository
                .countByIndiacctype个人账户类型AndIndiaccstate个人账户状态(E_dp007_个人分户账_类型.E_1_正常.getText(),
                        E_DP007_个人分户账_个人账户状态.封存.getText());
        saveAccLongRealtime(count,LocalDate.now(),e_指标_rate_sy);

    }

   // //
    public void groupProcess(){
        process(LocalDate.parse("2015-10-01",df),LocalDate.now());
        transfer累计ToPro(LocalDate.parse("2015-10-01",df),e_指标_rate_sy,Long.class.getName());

    }
    public void process(LocalDate beginDate,LocalDate endDate) {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        StopWatch timer = new StopWatch();
        timer.start();
        if(true || rateAnalysisTable.getAanalysedEndDate()== null){

            deleteAll(e_指标_rate_sy);
            deleteReduction_流水还原(e_指标_rate_sy);
            deleteReduction_流水还原_Pro(e_指标_rate_sy);

            RateAnalysisStream rateAnalysisStream = history(beginDate,endDate);
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisTable.setAanalysedBeginDate(rateAnalysisStream.getBeginDate());
            rateAnalysisTable.setAanalysedEndDate(rateAnalysisStream.getEndDate());
            updateRateTable(rateAnalysisTable,rateAnalysisStream);
        }else{
            //     if(rateAnalysisTable.getAanalysedEndDate().is)
            RateAnalysisStream rateAnalysisStream = history(rateAnalysisTable.getAanalysedEndDate(),LocalDate.now());
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisTable.setAanalysedBeginDate(rateAnalysisStream.getBeginDate());
            rateAnalysisTable.setAanalysedEndDate(rateAnalysisStream.getEndDate());
            updateRateTable(rateAnalysisTable,rateAnalysisStream);
        }


    }


    public RateAnalysisStream history(LocalDate beginDate,LocalDate endDate) {


        List<DP204_个人缴存变更登记簿> ln003_合同信息s = dp204_个人缴存变更登记簿_repository
                .findByTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(beginDate.minusDays(1),endDate.plusDays(1));
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Pair<LocalDate,Long>> sourceList =ln003_合同信息s
                .stream()
           //     .filter(e->e.get().equals(E_DP034_公积金开销户登记簿_账户标志.E_2_个人户.getText()))
                .collect(Collectors.groupingBy(e->e.getTransdate不可为空交易日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    ;
                    System.out.println("stream---------"+e.getKey());
                    return Pair.with(e.getKey(),
                            e.getValue().stream().mapToLong(x->{
                                if(x.getChgtype_不可为空_变更类型().equals(E_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                    return +1;
                                if(x.getChgtype_不可为空_变更类型().equals(E_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                    return -1;
                                return 0;
                            }).sum());
                }).collect(Collectors.toList());


        saveDeltaLong(sourceList,e_指标_rate_sy);

        return new RateAnalysisStream(beginDate,endDate);

    }






    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
if(rateHistories.size()==0) return;

        Triplet<Long,Long,Long> triplet = queryLong本期值(e_指标_rate_sy,rateHistories,rateHistories_环比,rateHistories_同比);

        Long rateHistory_环比 =triplet.getValue1();
        Long rateHistory_同比 = triplet.getValue2();
        Long rateHistory = triplet.getValue0();


        h1.setLjjzfcrs_建制封存人数_NUMBER_18_0(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf(rateHistory_环比);

        h1.setLjhbjzfcrs_环比建制封存人数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf(rateHistory_同比);

        h1.setLjsnjzfcrs_同比建制封存人数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());



    }

}
