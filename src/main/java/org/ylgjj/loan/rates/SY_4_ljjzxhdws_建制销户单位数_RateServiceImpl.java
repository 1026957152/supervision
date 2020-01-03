package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.DP005_单位分户账;
import org.ylgjj.loan.enumT.E_DP005_单位分户账_单位账户状态;
import org.ylgjj.loan.enumT.E_DP005_单位分户账_单位账户类型;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.统计周期编码;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.ylgjj.loan.history_stream.HistoryServiceImpl.run统计周期编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_4_ljjzxhdws_建制销户单位数_RateServiceImpl extends RateServiceBaseImpl{


    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_4_ljjzxhdws_建制销户单位数;
    public void realTime(){
        process(LocalDate.parse("2015-10-01",df),LocalDate.now());
        Long count = dp005_单位分户账_repository
                .countByUnitacctype单位账户类型AndUnitaccstate单位账户状态(E_DP005_单位分户账_单位账户类型.普通.getText(), E_DP005_单位分户账_单位账户状态.销户.getText());
        saveAccLongRealtime(count,LocalDate.now(),e_指标_rate_sy);

    }

    public void groupProcess(){
       process(LocalDate.parse("2015-10-01",df),LocalDate.now());

        transfer累计ToPro(LocalDate.parse("2015-10-01",df),e_指标_rate_sy,Long.class.getName());
    }






    public void process(LocalDate beginDate, LocalDate endDate) {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        StopWatch timer = new StopWatch();
        timer.start();
        if(true|| rateAnalysisTable.getAanalysedEndDate()== null){
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

        List<DP005_单位分户账> ln003_合同信息s = dp005_单位分户账_repository
                .findByClsaccdate销户日期BetweenOrderByClsaccdate销户日期Desc(beginDate.minusDays(1),endDate.plusDays(1));

        System.out.println("-----------------------------"+ ln003_合同信息s.size());




        List<Pair<LocalDate,Long>> sourceList =ln003_合同信息s
                .stream()
                .filter(e->e.getUnitacctype单位账户类型().equals(E_DP005_单位分户账_单位账户类型.普通.getText()))
                //.filter(e->!e.getUnitaccstate_单位账户状态().equals(E_DP005_单位分户账_单位账户状态.销户.getText()))
                .collect(Collectors.groupingBy(e->e.getOpnaccdate开户日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    System.out.println("stream---------"+e.getKey());
                    return Pair.with(e.getKey(),e.getValue().stream().count());
                }).collect(Collectors.toList());


            saveDeltaLong(sourceList,e_指标_rate_sy);



        return new RateAnalysisStream(beginDate,endDate);

    }












    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
if(rateHistories.size()==0) return;

        Triplet<Long,Long,Long> triplet = queryLong期末(e_指标_rate_sy,rateHistories,rateHistories_环比,rateHistories_同比);

        Long rateHistory_环比 =triplet.getValue1();
        Long rateHistory_同比 = triplet.getValue2();
        Long rateHistory = triplet.getValue0();


        System.out.println("-==="+e_指标_rate_sy.get名称());
        System.out.println("-=rateHistory=="+rateHistory);
        System.out.println("-=optionalRateHistory_环比=="+rateHistory_环比);
        System.out.println("-=optionalRateHistory_同比=="+rateHistory_同比);

        h1.setLjjzxhdws_建制销户单位数_NUMBER_18_0(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf(rateHistory_环比);

        h1.setLjhbjzxhdws_环比建制销户单位数_NUMBER_18_0(bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf(rateHistory_同比);

        h1.setLjsnjzxhdws_同比建制销户单位数_NUMBER_18_0(bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());



    }




}
