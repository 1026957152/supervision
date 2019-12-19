package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.DP008_单位明细账;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.repository.DP008_单位明细账_Repository;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import javax.transaction.Transactional;
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
public class SY_164_gjzbs_归集总笔数_RateServiceImpl extends RateServiceBaseImpl {

    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_164_gjzbs_归集总笔数;

    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private DP008_单位明细账_Repository dp008_单位明细账_repository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");




    //
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
        List<DP008_单位明细账> ln003_合同信息s = dp008_单位明细账_repository.findByTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(beginDate,endDate);
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Triplet<LocalDate,Integer,Long>> sourceList =ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getTransdate不可为空交易日期())).entrySet()
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

/*        List<RateHistory> rateHistories_环比 = rateHistoryRepository
                .findByIndexNoAndDateBetweenOrderByDateDesc(e_指标_rate_sy.get编码(),ldt_ksrq_环比_begin,ldt_ksrq_环比_end);
        List<RateHistory> rateHistories_同比 = rateHistoryRepository
                .findByIndexNoAndDateBetweenOrderByDateDesc(e_指标_rate_sy.get编码(),ldt_ksrq_同比_begin,ldt_ksrq_同比_end);
        Integer rateHistory_环比 = rateHistories_环比.stream().mapToInt(e->e.getLongValue().intValue()).sum();
        Integer rateHistory_同比 = rateHistories_同比.stream().mapToInt(e->e.getLongValue().intValue()).sum();;
        */

        Integer rateHistory = rateHistories.stream().mapToInt(e->e.getLongValue().intValue()).sum();



        h1.setGjzbs_归集总笔数_NUMBER_18_0(rateHistory);
        h1.setWtgjzbs_网厅归集总笔数_NUMBER_18_0(rateHistory);
/*
        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/rateHistory_环比.intValue());

        h1.setLjhbffdkje_累计环比发放贷款金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/rateHistory_同比.intValue());

        h1.setLjsnffdkje_累计同比发放贷款金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
*/

    }





}
