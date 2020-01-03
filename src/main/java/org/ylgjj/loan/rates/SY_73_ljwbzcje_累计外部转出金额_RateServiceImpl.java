package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.TR100_转移接续登记簿;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_73_ljwbzcje_累计外部转出金额_RateServiceImpl extends RateServiceBaseImpl{

    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_70_wbzcje_外部转出金额;

    public void trans() {
        process(LocalDate.parse("2015-10-01",df),LocalDate.now());

        transfer累计ToPro(LocalDate.parse("2015-10-01", df), e_指标_rate_sy, Double.class.getName());
    }


    public void process(LocalDate beginDate,LocalDate endDate) {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        StopWatch timer = new StopWatch();
        timer.start();
        if(rateAnalysisTable.getAanalysedEndDate()== null){

            rateHistoryRepository.deleteByIndexNo(e_指标_rate_sy.get编码());

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




        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<TR100_转移接续登记簿> ln003_合同信息s = tr100_转移接续登记簿Repository
                .findByJyrq不可为空交易日期BetweenOrderByJyrq不可为空交易日期Desc(beginDate.minusDays(1),endDate.plusDays(1));
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Pair<LocalDate,Double>> sourceList =ln003_合同信息s
                .stream()
                //   .filter(e->e.get().equals(E_LN101_贷款明细账_借贷标志.E_2_贷方.getText()))
                //    .filter( e->e.getLoanfundtype不可为空_贷款资金类型().equals(E_LN101_贷款明细账_贷款资金类型.E_02_正常利息.getText()))
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
                                return x.getAmt_不可为空_金额();
                            }).sum());
                }).collect(Collectors.toList());

/*
        Double num = 0D;

        List<Triplet<LocalDate,Double,Double>> triplets = new ArrayList<>();
        for(Triplet<LocalDate,Double,Double> triplet: sourceList){

            num += triplet.getValue1();
            triplet.setAt2(num);
            triplets.add(Triplet.with(triplet.getValue0(),triplet.getValue1(),num));
        }

        triplets.stream().forEach(e->{
            System.out.println("-----------"+ e.toString());
        });

*/







        saveDeltaDouble(sourceList,e_指标_rate_sy);



        return new RateAnalysisStream(beginDate,endDate);


    }





    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
if(rateHistories.size()==0) return;

        Triplet<Double,Double,Double> triplet = queryDouble期末(e_指标_rate_sy,rateHistories,rateHistories_环比,rateHistories_同比);

        Double rateHistory_环比 =triplet.getValue1();
        Double rateHistory_同比 = triplet.getValue2();
        Double rateHistory = triplet.getValue0();


        h1.setLjwbzcje_累计外部转出金额_NUMBER_18_2(rateHistory.intValue());

        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/(rateHistory_环比!=0? rateHistory_环比:-1));

        h1.setLjhbwbzcje_累计环比外部转出金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/(rateHistory_同比!=0? rateHistory_同比:-1));

        h1.setLjsnwbzcje_累计环比外部转出金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());


    }

}
