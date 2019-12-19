package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.TR100_转移接续登记簿;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
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
public class SY_67_ljwbzrje_外部转入金额_RateServiceImpl extends RateServiceBaseImpl{

    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_64_wbzrje_外部转入金额;
    @Autowired
    private TR100_转移接续登记簿Repository tr100_转移接续登记簿Repository;

    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;
    @Autowired
    private DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;
    @Autowired
    private DP007_个人分户账_Repository dp007_个人分户账_repository;
    @Autowired
    private DP093_冻结解冻登记簿_Repository dp093_冻结解冻登记簿_repository;

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
        List<TR100_转移接续登记簿> ln003_合同信息s = tr100_转移接续登记簿Repository
                .findByJyrq不可为空交易日期BetweenOrderByJyrq不可为空交易日期Desc(beginDate,endDate);
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Triplet<LocalDate,Double,Double>> sourceList =ln003_合同信息s
                .stream()
                //  .filter(e->e.getDcflag不可为空_借贷标志().equals(E_LN101_贷款明细账_借贷标志.E_2_贷方.getText()))
                //    .filter( e->e.getLoanfundtype不可为空_贷款资金类型().equals(E_LN101_贷款明细账_贷款资金类型.E_02_正常利息.getText()))
                .collect(Collectors.groupingBy(e->e.getTransdate不可为空交易日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    ;
                    System.out.println("stream---------"+e.getKey());
                    return Triplet.with(e.getKey(),
                            e.getValue().stream().mapToDouble(x->{
   /*                             if(x.getLoanfundtype不可为空_贷款资金类型().equals(E_LN101_贷款明细账_贷款资金类型.E_))
                                    return +1;
                                if(x.getFrztype_不可为空_冻结类型().equals(E_DP093_冻结解冻登记表_冻结业务标志.E_1_解冻))
                                    return -1; // 之前 是 满的，现在空了*/
                                return x.getAmt_不可为空_金额();
                            }).sum()
                            ,0D);
                }).collect(Collectors.toList());

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












        save(triplets);
        RateAnalysisStream rateAnalysisStream = new RateAnalysisStream();
        rateAnalysisStream.setBeginDate(beginDate);
        rateAnalysisStream.setEndDate(endDate);
        rateAnalysisStream.setDuration(timer.getTime());

        System.out.println();
        return rateAnalysisStream;

    }






    @Transactional
    public void save(List<Triplet<LocalDate,Double,Double>> triplets) {
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
        Double rateHistory_环比 = rateHistories_环比.stream().mapToDouble(e->e.getDoubleValue()).sum();
        Double rateHistory_同比 = rateHistories_同比.stream().mapToDouble(e->e.getDoubleValue()).sum();;
        Double rateHistory = rateHistories.stream().mapToDouble(e->e.getDoubleValue()).sum();



        h1.setLjwbzrje_外部转入金额_NUMBER_18_2(rateHistory.intValue());

        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/rateHistory_环比.intValue());

        h1.setLjhbwbzrje_环比外部转入金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/rateHistory_同比.intValue());

        h1.setLjsnwbzrje_同比外部转入金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());



    }

}
