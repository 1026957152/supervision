package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN101_贷款明细账;
import org.ylgjj.loan.enumT.E_LN101_贷款明细账_交易状态;
import org.ylgjj.loan.enumT.E_LN101_贷款明细账_借贷标志;
import org.ylgjj.loan.enumT.E_LN101_贷款明细账_贷款资金类型;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.统计周期编码;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.ylgjj.loan.history_stream.HistoryServiceImpl.run统计周期编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_58_ljhslx_累计回收利息_RateServiceImpl extends RateServiceBaseImpl{



    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_58_ljhslx_累计回收利息;



    public void trans() {
        planProcess(LocalDate.parse("2015-10-01",df),LocalDate.now());
        //  deleteReduction_流水还原_Pro(e_指标_rate_sy);
        transfer本年累计ToPro(e_指标_rate_sy, Long.class.getName());

    }


    public void process() {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        StopWatch timer = new StopWatch();
        timer.start();
        if(rateAnalysisTable.getAanalysedEndDate()== null){

            rateHistoryRepository.deleteByIndexNo(e_指标_rate_sy.get编码());

            RateAnalysisStream rateAnalysisStream = history(LocalDate.now().minusDays(20000),LocalDate.now(),true);
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisTable.setAanalysedBeginDate(rateAnalysisStream.getBeginDate());
            rateAnalysisTable.setAanalysedEndDate(rateAnalysisStream.getEndDate());
            updateRateTable(rateAnalysisTable,rateAnalysisStream);
        }else{
            //     if(rateAnalysisTable.getAanalysedEndDate().is)
            RateAnalysisStream rateAnalysisStream = history(rateAnalysisTable.getAanalysedEndDate(),LocalDate.now(),true);
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisTable.setAanalysedBeginDate(rateAnalysisStream.getBeginDate());
            rateAnalysisTable.setAanalysedEndDate(rateAnalysisStream.getEndDate());
            updateRateTable(rateAnalysisTable,rateAnalysisStream);
        }


    }



    public RateAnalysisStream history(LocalDate beginDate,LocalDate endDate,Boolean acc) {




        List<LN101_贷款明细账> ln003_合同信息s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(beginDate.minusDays(1),endDate.plusDays(1));
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Pair<LocalDate,Double>> sourceList =ln003_合同信息s
                .stream()
                .filter(e->e.getDcflag不可为空_借贷标志().equals(E_LN101_贷款明细账_借贷标志.E_2_贷方.getText()))
                .filter( e->e.getLoanfundtype不可为空_贷款资金类型().equals(E_LN101_贷款明细账_贷款资金类型.E_02_正常利息.getText()))

                .collect(Collectors.groupingBy(e->e.getTransdate不可为空交易日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    ;
                    System.out.println("stream---------"+e.getKey());
                    return Pair.with(e.getKey(),
                            e.getValue().stream().mapToDouble(x->{
   /*                             if(x.getLoanfundtype不可为空_贷款资金类型().equals(E_LN101_贷款明细账_贷款资金类型.E_))
                                    return +1;
                                if(x.getFrztype_不可为空_冻结类型().equals(E_DP093_冻结解冻登记表_冻结业务标志.E_1_解冻))
                                    return -1; // 之前 是 满的，现在空了*/
                                return x.getTransamt不可为空_交易金额().doubleValue();
                            }).sum());
                }).collect(Collectors.toList());



        List<Pair<LocalDate,Double>> triplets_accumul = new ArrayList<>();
        Double num = 0D;
        for(Pair<LocalDate,Double> triplet: sourceList){
            num += triplet.getValue1();
            triplets_accumul.add(Pair.with(triplet.getValue0(),num));
        }




        if(acc){
            saveDeltaDouble(sourceList,e_指标_rate_sy);

        }else{
            saveAccDouble(triplets_accumul,e_指标_rate_sy);

        }


        return new RateAnalysisStream(beginDate,endDate);

    }





    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
if(rateHistories.size()==0) return;





        Triplet<Double,Double,Double> triplet = queryDouble期末(e_指标_rate_sy,rateHistories,rateHistories_环比,rateHistories_同比);


        Double rateHistory_环比 =triplet.getValue1();
        Double rateHistory_同比 = triplet.getValue2();
        Double rateHistory = triplet.getValue0();



        h1.setLjhslx_累计回收利息_NUMBER_18_2(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf(rateHistory_环比);

        h1.setLjhbhslx_累计环比回收利息_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf(rateHistory_同比);

        h1.setLjsnhslx_累计同比回收利息_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }





















    public void planProcess(LocalDate beginDate, LocalDate endDate) {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        //  RateAnalysisStream rateAnalysisStream = history(LocalDate.now().minusDays(20000),LocalDate.now());
        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDate,endDate, 统计周期编码.H__03_每月);

        for(Triplet<Long,LocalDate,LocalDate> triplet:triplets){

            StopWatch timer = new StopWatch();
            timer.start();
            RateAnalysisStream rateAnalysisStream = historyPlan(triplet.getValue1(),triplet.getValue2());
            if(rateAnalysisStream!= null){
                rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());
                rateAnalysisStream.setDuration(timer.getTime());
                //rateAnalysisTable.setAanalysedBeginDate(rateAnalysisStream.getBeginDate());
                rateAnalysisTable.setAanalysedEndDate(rateAnalysisStream.getEndDate());
                updateRateTable(rateAnalysisTable,rateAnalysisStream);
            }
        }

    }

    public RateAnalysisStream historyPlan(LocalDate beginDate,LocalDate endDate) {

        System.out.println("处理数据---------"+beginDate.toString()+"--"+endDate.toString());

        List<LN101_贷款明细账> ln003_合同信息s = ln101_贷款明细账_repository
                .findByTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(beginDate.minusDays(1),endDate.plusDays(1));
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Pair<LocalDate,Double>> sourceList =ln003_合同信息s
                .stream()
                .filter(x->x.getTransstate不可为空_交易状态().equals(E_LN101_贷款明细账_交易状态.E_0_正常.getText()))
                .filter(x->x.getDcflag不可为空_借贷标志().equals(E_LN101_贷款明细账_借贷标志.E_2_贷方.getText()))

                .filter(x->x.getLoanfundtype不可为空_贷款资金类型().equals(E_LN101_贷款明细账_贷款资金类型.E_02_正常利息.getText())||
                        x.getLoanfundtype不可为空_贷款资金类型().equals(E_LN101_贷款明细账_贷款资金类型.E_12_应收利息.getText()))
                //     .filter(e->e.get().equals(E_DP034_公积金开销户登记簿_账户标志.E_2_个人户.getText()))
                .collect(Collectors.groupingBy(e->e.getTransdate不可为空交易日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    ;
                    System.out.println("stream---------"+e.getKey());
                    return Pair.with(e.getKey(),
                            e.getValue().stream()

                                    .mapToDouble(x->{

                                return x.getTransamt不可为空_交易金额().doubleValue();
                            }).sum());
                }).collect(Collectors.toList());


        saveDeltaDouble(sourceList,e_指标_rate_sy);

        if(sourceList.isEmpty())
            return null;
        return new RateAnalysisStream(beginDate,endDate);
    }

}
