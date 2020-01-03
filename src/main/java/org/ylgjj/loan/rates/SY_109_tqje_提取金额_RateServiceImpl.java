package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.DW025_公积金提取审核登记表;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.DW025_公积金提取审核登记表_Repository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import javax.annotation.PostConstruct;
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
public class SY_109_tqje_提取金额_RateServiceImpl extends RateServiceBaseImpl {


    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_109_tqje_提取金额;




    public void groupProcess(){


        process(LocalDate.parse("2015-10-01",df),LocalDate.now());


        transfer本期值ToPro(e_指标_rate_sy,Double.class.getName());
    }


  //  //
    public void process(LocalDate localDate,LocalDate endDate) {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        StopWatch timer = new StopWatch();
        timer.start();
        if(true || rateAnalysisTable.getAanalysedEndDate()== null){
            System.out.println("__________________ 正在存量进行分析");
            deleteReduction_流水还原(e_指标_rate_sy);
            deleteReduction_流水还原_Pro(e_指标_rate_sy);

            RateAnalysisStream rateAnalysisStream = history(localDate,endDate);
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisTable.setAanalysedBeginDate(rateAnalysisStream.getBeginDate());
            rateAnalysisTable.setAanalysedEndDate(rateAnalysisStream.getEndDate());
            updateRateTable(rateAnalysisTable,rateAnalysisStream);
        }else{
            System.out.println("__________________ 正在增量更新");

            //     if(rateAnalysisTable.getAanalysedEndDate().is)
            RateAnalysisStream rateAnalysisStream = history(rateAnalysisTable.getAanalysedEndDate(),LocalDate.now());
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisTable.setAanalysedBeginDate(rateAnalysisStream.getBeginDate());
            rateAnalysisTable.setAanalysedEndDate(rateAnalysisStream.getEndDate());
            updateRateTable(rateAnalysisTable,rateAnalysisStream);
        }


    }

    public RateAnalysisStream history(LocalDate beginDate,LocalDate endDate) {



        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dw025_公积金提取审核登记表_repository.findByTransdate交易日期BetweenOrderByTransdate交易日期Desc(beginDate.minusDays(1),endDate.plusDays(1));
        System.out.println("------------------DW025_公积金提取审核登记表-----------"+ dw025_公积金提取审核登记表s.size());


        List<Pair<LocalDate,Double>> source_delta =dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e->e.getTransdate交易日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    System.out.println("stream---------"+e.getKey());
                    Double tqje = e.getValue().stream().mapToDouble(f->f.getDrawamt_提取金额().doubleValue()).sum();
                    return Pair.with(e.getKey(),tqje);
        }).collect(Collectors.toList());




        saveDeltaDouble(source_delta,e_指标_rate_sy);

        return new RateAnalysisStream(beginDate,endDate);
    }






    @Transactional
    public void save(List<Triplet<LocalDate,Double,Double>> triplets) {
        triplets.stream().forEach(e->{

            RateHistory rateHistory = rateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(),e.getValue0());
            if(rateHistory== null){
                rateHistory = new RateHistory(e.getValue0(),e_指标_rate_sy);
                rateHistory.setDeltaDoubleValue(e.getValue1());
                rateHistoryRepository.save(rateHistory);

                System.out.println("-----------"+ e.toString());
            }

        });

    }



    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
if(rateHistories.size()==0) return;


        Triplet<Double,Double,Double> triplet = queryDouble本期值(e_指标_rate_sy,rateHistories,rateHistories_环比,rateHistories_同比);

        Double rateHistory_环比 =triplet.getValue1();
        Double rateHistory_同比 = triplet.getValue2();
        Double rateHistory = triplet.getValue0();


        h1.setTqje_提取金额_NUMBER_18_2(rateHistory);

        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/(rateHistory_环比!=0? rateHistory_环比:-1));

        h1.setHbtqje_环比提取金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/(rateHistory_同比!=0? rateHistory_同比:-1));

        h1.setSntqje_同比提取金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }


}
