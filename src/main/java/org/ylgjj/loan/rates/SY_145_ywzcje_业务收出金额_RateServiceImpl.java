package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Fn032_会计凭证历史流水;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.E_科目字典_HX;
import org.ylgjj.loan.repository.Fn032_会计凭证历史流水_Repository;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository.LN004_合同状态信息Repository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

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
public class SY_145_ywzcje_业务收出金额_RateServiceImpl extends RateServiceBaseImpl {

    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_145_ywzcje_业务收出金额;


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;
    @Autowired
    private Fn032_会计凭证历史流水_Repository fn032_会计凭证历史流水_repository;


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



        List<String> strins = Arrays.asList(E_科目字典_HX.E_411_业务支出_业务支出_411000_1_411000,
                E_科目字典_HX.E_41101_住房公积金利息支出_业务支出__住房公积金利息支出_411001_2_411000,
                E_科目字典_HX.E_41102_归集手续费支出_业务支出__归集手续费支出_411002_2_411000,
                E_科目字典_HX.E_41103_委托贷款手续费支出_业务支出__委托贷款手续费支出_411003_2_411000
        ).stream().map(e->e.get科目号()).collect(Collectors.toList());

        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<Fn032_会计凭证历史流水> ln003_合同信息s = fn032_会计凭证历史流水_repository
                .findBySubcode不可为空科目控制字InAndTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(strins,LocalDate.now().minusDays(20000),LocalDate.now());
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Triplet<LocalDate,Integer,Double>> sourceList =ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getTransdate不可为空交易日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    System.out.println("stream---------"+e.getKey());
                    return Triplet.with(e.getKey(),e.getValue().size(),0D);
                }).collect(Collectors.toList());

        Double num = 0D;

        List<Triplet<LocalDate,Integer,Double>> triplets = new ArrayList<>();
        for(Triplet<LocalDate,Integer,Double> triplet: sourceList){

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
        Double rateHistory = rateHistories.stream().mapToDouble(e->e.getDoubleValue()).sum();



/*        List<RateHistory> rateHistories_环比 = rateHistoryRepository
                .findByIndexNoAndDateBetweenOrderByDateDesc(e_指标_rate_sy.get编码(),ldt_ksrq_环比_begin,ldt_ksrq_环比_end);
        List<RateHistory> rateHistories_同比 = rateHistoryRepository
                .findByIndexNoAndDateBetweenOrderByDateDesc(e_指标_rate_sy.get编码(),ldt_ksrq_同比_begin,ldt_ksrq_同比_end);
        if(rateHistories.size()==0) return;Double rateHistory_环比 = rateHistories_环比.stream().mapToDouble(e->e.getDoubleValue()).sum();
        Double rateHistory_同比 = rateHistories_同比.stream().mapToDouble(e->e.getDoubleValue()).sum();;*/






        h1.setYwzcje_业务收出金额_NUMBER_18_2(rateHistory);

/*        BigDecimal bigDecimal = BigDecimal.valueOf(rateHistory_环比);

        h1.setLjhbffdkje_累计环比发放贷款金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf(rateHistory_同比);

        h1.setLjsnffdkje_累计同比发放贷款金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());*/

    }
    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
Double rateHistory = rateHistories
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToDouble(e->e.getDoubleValue()).sum();

        h1.setYwzcje_业务收出金额_NUMBER_18_2(rateHistory);



    }
}
