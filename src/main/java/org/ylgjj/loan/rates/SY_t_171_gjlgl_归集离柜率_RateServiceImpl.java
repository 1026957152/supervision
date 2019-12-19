package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.domain_zongfu.Mi107_业务日志;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_业务类型_综服_HX;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository.LN004_合同状态信息Repository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;
import org.ylgjj.loan.repository_zhongfu.Mi107_业务日志_Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_t_171_gjlgl_归集离柜率_RateServiceImpl extends RateServiceBaseImpl {

    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_171_gjlgl_归集离柜率;

    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Autowired
    private Mi107_业务日志_Repository mi107_业务日志_repository;

    public Long 归集(LocalDate localDate) {
        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5875_灵活就业人员缴存,
                E_业务类型_综服_HX.E_5351_缴存预约,
                E_业务类型_综服_HX.E_5486_预缴入账,
                E_业务类型_综服_HX.E_5487_补缴入账,
                E_业务类型_综服_HX.E_5858_单位暂存款登记,
                E_业务类型_综服_HX.E_5859_单位缴存入账


        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).count();

    }

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
        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByLoandate放款日期BetweenOrderByLoandate放款日期Desc(LocalDate.now().minusDays(20000),LocalDate.now());
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Triplet<LocalDate,Integer,Long>> sourceList =ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getLoandate放款日期())).entrySet()
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

        return rateAnalysisStream;

    }






    @Transactional
    public void save(List<Triplet<LocalDate,Integer,Long>> triplets) {
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
