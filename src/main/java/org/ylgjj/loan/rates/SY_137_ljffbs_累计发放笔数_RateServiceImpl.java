package org.ylgjj.loan.rates;



import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.flow.RateAnalysisStream;
import org.ylgjj.loan.flow.RateAnalysisTable;
import org.ylgjj.loan.flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository_flow.RateAnalysisStreamRepository;
import org.ylgjj.loan.repository_flow.RateAnalysisTableRepository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.time.StopWatch;
/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_137_ljffbs_累计发放笔数_RateServiceImpl extends RateServiceBaseImpl{


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;

    @Autowired
    private RateAnalysisTableRepository rateAnalysisTableRepository;


    @Autowired
    private RateAnalysisStreamRepository rateAnalysisStreamRepository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

 //   NumberFormat nf = NumberFormat.getPercentInstance();
   //
   DecimalFormat df_ = new DecimalFormat("#.00");


    public void process() {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(E_指标_RATE_SY.SY_137_ljffbs_累计发放笔数.get编码());

        if(rateAnalysisTable == null){
            return;
        }

        updateRateTable(rateAnalysisTable,history());

    }


    public RateAnalysisStream update() {


        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(E_指标_RATE_SY.SY_137_ljffbs_累计发放笔数.get编码());

        if(rateAnalysisTable.getUpdateTime() == null){
            return null;
        }
        StopWatch timer = new StopWatch();
        timer.start();

        LocalDate beginDate = rateAnalysisTable.getUpdateTime();
        LocalDate endDate = LocalDate.now();
        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByLoandate放款日期BetweenOrderByLoandate放款日期Desc(beginDate,endDate);
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



        timer.stop();
        RateAnalysisStream rateAnalysisStream = new RateAnalysisStream();
        rateAnalysisStream.setBeginDate(beginDate);
        rateAnalysisStream.setEndDate(endDate);
        rateAnalysisStream.setDuration(timer.getTime());

        System.out.println();
        return rateAnalysisStream;






    }

    public RateAnalysisStream history() {


        StopWatch timer = new StopWatch();
        timer.start();

        LocalDate beginDate =  LocalDate.now().minusDays(20000);
        LocalDate endDate = LocalDate.now();
        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByLoandate放款日期BetweenOrderByLoandate放款日期Desc(beginDate,endDate);
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

        timer.stop();
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
            rateHistory.setIndexNo(E_指标_RATE_SY.SY_137_ljffbs_累计发放笔数.get编码());
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
                .findByIndexNoAndDateBetweenOrderByDateDesc(E_指标_RATE_SY.SY_137_ljffbs_累计发放笔数.get编码(),ldt_ksrq,ldt_jsrq);

        List<RateHistory> rateHistories_环比 = rateHistoryRepository
                .findByIndexNoAndDateBetweenOrderByDateDesc(E_指标_RATE_SY.SY_137_ljffbs_累计发放笔数.get编码(),ldt_ksrq_环比_begin,ldt_ksrq_环比_end);
        List<RateHistory> rateHistories_同比 = rateHistoryRepository
                .findByIndexNoAndDateBetweenOrderByDateDesc(E_指标_RATE_SY.SY_137_ljffbs_累计发放笔数.get编码(),ldt_ksrq_同比_begin,ldt_ksrq_同比_end);
        RateHistory rateHistory_环比 = rateHistories_环比.get(0);
        RateHistory rateHistory_同比 = rateHistories_同比.get(0);
        RateHistory rateHistory = rateHistories.get(0);

        h1.setLjffbs_累计发放笔数_NUMBER_18_0(rateHistory.getLongValue());

        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory.getLongValue().intValue()-rateHistory_环比.getLongValue().intValue()+0D)/rateHistory_环比.getLongValue().intValue());


        h1.setLjhbffbs_累计环比发放笔数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.getLongValue().intValue()-rateHistory_同比.getLongValue().intValue()+0D)/rateHistory_同比.getLongValue().intValue());

        h1.setLjsnffbs_累计同比发放笔数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
