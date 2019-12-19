package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN101_贷款明细账;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.repository.LN101_贷款明细账_Repository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_124_ljhsje_累计回收金额_RateServiceImpl extends RateServiceBaseImpl {


    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_124_ljhsje_累计回收金额;


    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");



    public void process() {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        history();
        //   updateRateTable(rateAnalysisTable,history());

    }

    public RateAnalysisStream history() {
        StopWatch timer = new StopWatch();
        timer.start();
        LocalDate beginDate =  LocalDate.now().minusDays(20000);
        LocalDate endDate = LocalDate.now();


        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<LN101_贷款明细账> ln003_合同信息s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(beginDate,endDate);
        System.out.println("-----------------------------"+ ln003_合同信息s.size());

        List<Triplet<LocalDate,Integer,Double>> triplets = ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getTransdate不可为空交易日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{

                    double diff = e.getValue().stream()
                            //       .filter(x->x.getDcflag不可为空_借贷标志().equals("1"))
                            .mapToDouble(x->{

                                if(x.getDcflag不可为空_借贷标志().equals("2")){
                                    return x.getTransamt不可为空_交易金额().doubleValue();
                                }

                                return 0;

                            })
                            .sum();

                    return Triplet.with(e.getKey(),e.getValue().size(),diff);
                }).collect(Collectors.toList());

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
    public void save(List<Triplet<LocalDate,Integer,Double>> triplets) {
        triplets.stream().forEach(e->{

            RateHistory rateHistory = new RateHistory();
            rateHistory.setIndexNo(e_指标_rate_sy.get编码());
            rateHistory.setDoubleValue(e.getValue2());
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


        h1.setLjhsje_累计回收金额_NUMBER_18_2(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/rateHistory_环比.intValue());

        h1.setLjhbhsje_累计环比回收金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/rateHistory_同比.intValue());

        h1.setLjsnhsje_累计同比回收金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());



    }



}
