package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SY_112_ljtqje_累计提取金额_RateServiceImpl extends RateServiceBaseImpl {


    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_112_ljtqje_累计提取金额;

    public void groupProcess() {
        process(LocalDate.parse("2015-10-01", df), LocalDate.now());


        transfer本年累计ToPro(e_指标_rate_sy, Double.class.getName());


    }
    //  //
    public void process(LocalDate localDate,LocalDate endDate) {
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
            RateAnalysisStream rateAnalysisStream = history(localDate,endDate);
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



        List<DW025_公积金提取审核登记表> ln003_合同信息s = dw025_公积金提取审核登记表_repository.findByTransdate交易日期BetweenOrderByTransdate交易日期Desc(LocalDate.now().minusDays(20000),LocalDate.now());
        System.out.println("------------------DW025_公积金提取审核登记表-----------"+ ln003_合同信息s.size());


        List<Pair<LocalDate,Double>> sourceList =ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getTransdate交易日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    System.out.println("stream---------"+e.getKey());
                    Double tqje = e.getValue().stream().mapToDouble(f->f.getDrawamt_提取金额().doubleValue()).sum();
                    return Pair.with(e.getKey(),tqje);
                }).collect(Collectors.toList());

        Double num = 0D;

        List<Pair<LocalDate,Double>> triplets_acc = new ArrayList<>();
        for(Pair<LocalDate,Double> triplet: sourceList){

            num += triplet.getValue1();
            triplets_acc.add(Pair.with(triplet.getValue0(),num));
        }






        saveAccDouble(triplets_acc,e_指标_rate_sy);

        return new RateAnalysisStream(beginDate,endDate);
    }






    @Transactional
    public void save(List<Triplet<LocalDate,Double,Double>> triplets) {
        triplets.stream().forEach(e->{
            RateHistory rateHistory = rateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(),e.getValue0());
            if(rateHistory== null) {
                rateHistory = new RateHistory(e.getValue0(), e_指标_rate_sy);
                rateHistory.setDoubleValue(e.getValue2());
                rateHistoryRepository.save(rateHistory);
            }
            System.out.println("-----------"+ e.toString());
        });

    }




    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, String ksrq, String jsrq) {


        LocalDate ldt_ksrq = LocalDate.parse(ksrq, df);
        LocalDate ldt_jsrq = LocalDate.parse(jsrq, df);
        LocalDate ldt_ksrq_环比_begin  = ldt_ksrq.minusMonths(1);
        LocalDate ldt_ksrq_环比_end  = ldt_jsrq.minusMonths(1);


        LocalDate ldt_ksrq_同比_begin  = ldt_ksrq.minusYears(1);
        LocalDate ldt_ksrq_同比_end  = ldt_jsrq.minusYears(1);





        List<RateHistory> rateHistories = rateHistoryRepository
                .findByIndexNoAndDateBetweenOrderByDateDesc(e_指标_rate_sy.get编码(),ldt_ksrq,ldt_jsrq);

        List<RateHistory> rateHistories_环比 = rateHistoryRepository
                .findByIndexNoAndDateBetweenOrderByDateDesc(e_指标_rate_sy.get编码(),ldt_ksrq_环比_begin,ldt_ksrq_环比_end);
        List<RateHistory> rateHistories_同比 = rateHistoryRepository
                .findByIndexNoAndDateBetweenOrderByDateDesc(e_指标_rate_sy.get编码(),ldt_ksrq_同比_begin,ldt_ksrq_同比_end);
        if(rateHistories.size()==0) return;Double rateHistory_环比 = rateHistories_环比.stream().mapToDouble(e->e.getDoubleValue()).sum();
        Double rateHistory_同比 = rateHistories_同比.stream().mapToDouble(e->e.getDoubleValue()).sum();;
        Double rateHistory = rateHistories.stream().mapToDouble(e->e.getDoubleValue()).sum();



        h1.setLjtqje_累计提取金额_NUMBER_18_2(rateHistory);

        BigDecimal bigDecimal = BigDecimal.valueOf(rateHistory_环比);

        h1.setLjhbtqje_累计环比提取金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf(rateHistory_同比);

        h1.setLjsntqje_累计同比提取金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());




    }

    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
if(rateHistories.size()==0) return;Double rateHistory_环比 = rateHistories_环比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToDouble(e->e.getDoubleValue()).sum();

        Double rateHistory_同比 = rateHistories_同比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToDouble(e->e.getDoubleValue()).sum();;
        Double rateHistory = rateHistories
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToDouble(e->e.getDoubleValue()).sum();

/*        if(rateHistories.size()==0) return;Long rateHistory_环比 = rateHistories_环比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToLong(e->e.getLongValue()).sum();
        Long rateHistory_同比 = rateHistories_同比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToLong(e->e.getLongValue()).sum();;
        Long rateHistory = rateHistories
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToLong(e->e.getLongValue()).sum();*/


        h1.setLjtqje_累计提取金额_NUMBER_18_2(rateHistory);

        BigDecimal bigDecimal = BigDecimal.valueOf(rateHistory_环比);

        h1.setLjhbtqje_累计环比提取金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf(rateHistory_同比);

        h1.setLjsntqje_累计同比提取金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }


}
