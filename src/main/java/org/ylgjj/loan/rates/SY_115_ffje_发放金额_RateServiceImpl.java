package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.enumT.E_LN003_合同信息_放款标志;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_115_ffje_发放金额_RateServiceImpl extends RateServiceBaseImpl{


    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_115_ffje_发放金额_本期值;


    public void trans() {
        process(LocalDate.parse("2015-10-01",df),LocalDate.now());

        transfer本期值ToPro(e_指标_rate_sy, Double.class.getName());
    }


    public void process(LocalDate beginDate,LocalDate endDate) {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        StopWatch timer = new StopWatch();
        timer.start();
        if(true ||rateAnalysisTable.getAanalysedEndDate()== null){
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



        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByLoandate放款日期BetweenOrderByLoandate放款日期Desc(LocalDate.now().minusDays(20000),LocalDate.now());
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Pair<LocalDate,Double>> triplets_delta =ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getLoandate放款日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    System.out.println("stream---------"+e.getKey());
                    return Pair.with(e.getKey(),e.getValue()
                            .stream()
                            .filter(x->x.getLoanflag().equals(E_LN003_合同信息_放款标志.E_1_是.getText()))
                            .mapToDouble(x->x.getLoanamt_贷款金额().doubleValue()).sum());
                }).collect(Collectors.toList());




        saveDeltaDouble(triplets_delta,e_指标_rate_sy);

        return new RateAnalysisStream(beginDate,endDate);

    }






    @Transactional
    public void save(List<Triplet<LocalDate,Double,Double>> triplets) {
        triplets.stream().forEach(e->{
            RateHistory rateHistory = rateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(),e.getValue0());
            if(rateHistory== null) {
                rateHistory = new RateHistory(e.getValue0(), e_指标_rate_sy);
                rateHistory.setDeltaDoubleValue(e.getValue1());
                rateHistoryRepository.save(rateHistory);
            }
            System.out.println("-----------"+ e.toString());
        });

    }

    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
if(rateHistories.size()==0) return;

        Triplet<Double,Double,Double> triplet = queryDouble本期值(e_指标_rate_sy,rateHistories,rateHistories_环比,rateHistories_同比);

        Double rateHistory_环比 =triplet.getValue1();
        Double rateHistory_同比 = triplet.getValue2();
        Double rateHistory = triplet.getValue0();


        h1.setFfje_发放金额_NUMBER_18_2(rateHistory);

        System.out.println("-------------setFfje_发放金额_NUMBER_18_2:"+rateHistory);
        System.out.println("-------------rateHistory_环比:"+rateHistory_环比);
        System.out.println("-------------rateHistory_同比:"+rateHistory_同比);

        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/(rateHistory_环比!=0? rateHistory_环比:-1));

        h1.setHbffje_环比发放金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/(rateHistory_同比!=0? rateHistory_同比:-1));

        h1.setSnffje_同比发放金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }


}
