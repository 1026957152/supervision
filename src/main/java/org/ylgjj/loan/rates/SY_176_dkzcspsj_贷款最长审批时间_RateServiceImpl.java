package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.domain.LN004_合同状态信息;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_LN003_合同信息_合同状态;
import org.ylgjj.loan.flow.RateAnalysisStream;
import org.ylgjj.loan.flow.RateAnalysisTable;
import org.ylgjj.loan.flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_176_dkzcspsj_贷款最长审批时间_RateServiceImpl extends RateServiceBaseImpl {
    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_176_dkzcspsj_贷款最长审批时间;
    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;
    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;

    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");






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



        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<LN004_合同状态信息> ln003_合同信息s = ln004_合同状态信息Repository.findByTransdateBetweenOrderByTransdateDesc(beginDate,endDate);
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Triplet<LocalDate,Integer,Integer>> sourceList =ln003_合同信息s
                .stream()
                .filter(e->e.getLoancontrstate().equals(E_LN003_合同信息_合同状态.放款.getText()) || e.getLoancontrstate().equals(E_LN003_合同信息_合同状态.合同终止.getText()))

                .collect(Collectors.groupingBy(e->e.getTransdate())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    ;
                    System.out.println("stream---------"+e.getKey());
                    return Triplet.with(e.getKey(),
                            e.getValue().stream().mapToInt(x->{
                                if(x.getLoancontrstate().equals(E_LN003_合同信息_合同状态.放款.getText())){
                                    return +1;
                                }

                                if(x.getLoancontrstate().equals(E_LN003_合同信息_合同状态.合同终止.getText())){
                                    return -1; // 之前 是 满的，现在空了

                                }else{
                                    return 0;
                                }

                            }).sum()
                            ,0);
                }).collect(Collectors.toList());

        Integer num = 0;

        List<Triplet<LocalDate,Integer,Integer>> triplets = new ArrayList<>();
        for(Triplet<LocalDate,Integer,Integer> triplet: sourceList){

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

        return rateAnalysisStream;

    }






    @Transactional
    public void save(List<Triplet<LocalDate,Integer,Integer>> triplets) {
        triplets.stream().forEach(e->{

            RateHistory rateHistory = new RateHistory();
            rateHistory.setIndexNo(e_指标_rate_sy.get编码());
            rateHistory.setLongValue(e.getValue2().longValue());
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
        Long rateHistory_环比 = rateHistories_环比.stream().mapToLong(e->e.getLongValue()).sum();
        Long rateHistory_同比 = rateHistories_同比.stream().mapToLong(e->e.getLongValue()).sum();;
        Long rateHistory = rateHistories.stream().mapToLong(e->e.getLongValue()).sum();


        h1.setDkzcspsj_贷款最长审批时间_NUMBER_18_2(rateHistory.intValue());



    }

}
