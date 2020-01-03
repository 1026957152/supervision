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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_7_ljjzfxhdws_建制非销户单位数_RateServiceImpl  extends RateServiceBaseImpl{


    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_7_ljjzfxhdws_建制非销户单位数;


    public void realTime() {
        Long count_ = dp005_单位分户账_repository
                .countByUnitacctype单位账户类型(E_DP005_单位分户账_单位账户类型.普通.getText());
        Long count = dp005_单位分户账_repository
                .countByUnitacctype单位账户类型AndUnitaccstate单位账户状态(E_DP005_单位分户账_单位账户类型.普通.getText(), E_DP005_单位分户账_单位账户状态.销户.getText());
        saveAccLongRealtime(count_-count,LocalDate.now(),e_指标_rate_sy);

    }
   // @PostConstruct
    public void groupProcess(){
        process(LocalDate.parse("2015-10-01",df),LocalDate.now());

        transfer累计ToPro(LocalDate.parse("2015-10-01",df),e_指标_rate_sy,Long.class.getName());
    }
    //   //
    public void process(LocalDate beginDate, LocalDate endDate) {
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

            RateAnalysisStream rateAnalysisStream =  history(beginDate,endDate);
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


        List<DP005_单位分户账> dp005_单位分户账s = dp005_单位分户账_repository
                .findByClsaccdate销户日期BetweenOrderByClsaccdate销户日期Desc(beginDate,endDate);



        List<Triplet<LocalDate,Integer,Long>> sourceList_开户 = dp005_单位分户账s
                .stream()
                .filter(x->x.getUnitacctype单位账户类型().equals(E_DP005_单位分户账_单位账户类型.普通.getText()))
                .collect(Collectors.groupingBy(x->x.getOpnaccdate开户日期()))
                .entrySet()
                .stream()
                .map(e->{

                    return Triplet.with(e.getKey(),e.getValue().size(),1L);
                }).collect(Collectors.toList());


        List<Triplet<LocalDate,Integer,Long>> sourceList_销户 = dp005_单位分户账s
                .stream()
                .filter(x->x.getUnitacctype单位账户类型().equals(E_DP005_单位分户账_单位账户类型.普通.getText()))
                .collect(Collectors.groupingBy(x->x.getClsaccdate销户日期()))
                .entrySet()
                .stream()
                .map(e->{
                    return Triplet.with(e.getKey(),-e.getValue().size(),-1L);
                }).collect(Collectors.toList());



        sourceList_销户.addAll(sourceList_开户);


        List<Pair<LocalDate,Long>> sourceList_last = sourceList_销户.stream().collect(Collectors.groupingBy(e->e.getValue0()))
                .entrySet().stream().map(e->{
                    ;
                    return Pair.with(e.getKey(),e.getValue().stream().mapToLong(x->x.getValue1()).sum());
                }).collect(Collectors.toList());




        saveDeltaLong(sourceList_last,e_指标_rate_sy);

        return new RateAnalysisStream(beginDate,endDate);

    }














    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
        Triplet<Long,Long,Long> triplet = queryLong期末(e_指标_rate_sy,rateHistories,rateHistories_环比,rateHistories_同比);

        Long rateHistory_环比 =triplet.getValue1();
        Long rateHistory_同比 = triplet.getValue2();
        Long rateHistory = triplet.getValue0();


        h1.setLjjzfxhdws_建制非销户单位数_NUMBER_18_0(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/(rateHistory_环比!=0? rateHistory_环比:-1));

        h1.setLjhbjzfxhdws_环比建制非销户单位数_NUMBER_18_0(bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/(rateHistory_同比!=0? rateHistory_同比:-1));

        h1.setLjsnjzfxhdws_同比建制非销户单位数_NUMBER_18_0(bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());




    }




}
