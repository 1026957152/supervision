package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.DP005_单位分户账;
import org.ylgjj.loan.enumT.E_DP005_单位分户账_单位账户状态;
import org.ylgjj.loan.enumT.E_DP005_单位分户账_单位账户类型;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.repository.DP004_单位缴存信息表_Repository;
import org.ylgjj.loan.repository.DP005_单位分户账_Repository;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
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
public class SY_1_ljjzzdws_建制总单位数_RateServiceImpl extends RateServiceBaseImpl{


    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_1_ljjzzdws_建制总单位数;

    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private DP004_单位缴存信息表_Repository dp004_单位缴存信息表_repository;
    @Autowired
    private DP005_单位分户账_Repository dp005_单位分户账_repository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");




    //@PostConstruct
    public void process() {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }

        updateRateTable(rateAnalysisTable,history());

    }

    public RateAnalysisStream history() {
        StopWatch timer = new StopWatch();
        timer.start();
        LocalDate beginDate =  LocalDate.now().minusDays(20000);
        LocalDate endDate = LocalDate.now();


     //   Map<String,DP004_单位缴存信息表> dp004_单位缴存信息表s = dp004_单位缴存信息表_repository.findAll().stream().collect(Collectors.toMap(e->e.getUnitaccnum单位账号(), e->e));

        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<DP005_单位分户账> ln003_合同信息s = dp005_单位分户账_repository
                .findByOpnaccdate开户日期BetweenOrderByOpnaccdate开户日期Desc(beginDate,endDate);

        System.out.println("-----------------------------"+ ln003_合同信息s.size());




        List<Triplet<LocalDate,Integer,Long>> sourceList =ln003_合同信息s
                .stream()
                .filter(e->e.getUnitacctype_单位账户类型().equals(E_DP005_单位分户账_单位账户类型.普通.getText()))
                .filter(e->!e.getUnitaccstate_单位账户状态().equals(E_DP005_单位分户账_单位账户状态.销户.getText()))
                .collect(Collectors.groupingBy(e->e.getOpnaccdate开户日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    System.out.println("stream---------"+e.getKey());
                    return Triplet.with(e.getKey(),e.getValue().size(),0L);
        }).collect(Collectors.toList());

        Long num = 0L;

        List<Triplet<LocalDate,Integer,Long>> triplets = new ArrayList<>();
        for(Triplet<LocalDate,Integer,Long> triplet: sourceList){

            num += triplet.getValue1();
            triplet.setAt2(num);
            triplets.add(Triplet.with(triplet.getValue0(),triplet.getValue1(),num));
        }

        triplets.stream().forEach(e->{
            System.out.println("-----------"+ e.toString());
        });






        save(triplets);
        RateAnalysisStream rateAnalysisStream = new RateAnalysisStream();
        rateAnalysisStream.setBeginDate(beginDate);
        rateAnalysisStream.setEndDate(endDate);
        rateAnalysisStream.setDuration(timer.getTime());

        System.out.println();
        return rateAnalysisStream;

    }






    @Transactional
    public void save(List<Triplet<LocalDate,Integer,Long>> triplets) {
        triplets.stream().forEach(e->{

            RateHistory rateHistory = new RateHistory();
            rateHistory.setIndexNo(e_指标_rate_sy.get编码());
            rateHistory.setLongValue(e.getValue2());
            rateHistory.setDate(e.getValue0());
            rateHistoryRepository.save(rateHistory);

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
        if(rateHistories.size()==0) return;Long rateHistory_环比 = rateHistories_环比.stream().mapToLong(e->e.getLongValue()).sum();
        Long rateHistory_同比 = rateHistories_同比.stream().mapToLong(e->e.getLongValue()).sum();;
        Long rateHistory = rateHistories.stream().mapToLong(e->e.getLongValue()).sum();


        h1.setLjjzzdws_建制总单位数_NUMBER_18_2(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/(rateHistory_环比!=0? rateHistory_环比:-1));

        h1.setLjhbjzzdws_环比建制总单位数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/(rateHistory_同比!=0? rateHistory_同比:-1));

        h1.setLjsnjzzdws_同比建制总单位数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());




    }




    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<RateHistory> rateHistories, List<RateHistory> rateHistories_环比, List<RateHistory> rateHistories_同比) {

/*
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
*/

        if(rateHistories.size()==0) return;Long rateHistory_环比 = rateHistories_环比
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
                .mapToLong(e->e.getLongValue()).sum();


        h1.setLjjzzdws_建制总单位数_NUMBER_18_2(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/(rateHistory_环比!=0? rateHistory_环比:-1));
        h1.setLjhbjzzdws_环比建制总单位数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/(rateHistory_同比!=0? rateHistory_同比:-1));
        h1.setLjsnjzzdws_同比建制总单位数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());



    }


}
