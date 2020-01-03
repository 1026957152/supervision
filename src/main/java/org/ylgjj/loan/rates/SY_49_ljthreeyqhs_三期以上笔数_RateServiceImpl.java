package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.domain.LN006_贷款分期还款计划;

import org.ylgjj.loan.enumT.E_LN006_贷款分期还款计划_curseqStatusEnum;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.*;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static org.ylgjj.loan.rates.SY__test_______________________176_dkzcspsj_贷款最长审批时间_HistoryerviceImpl.run统计周期编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_49_ljthreeyqhs_三期以上笔数_RateServiceImpl extends RateServiceBaseImpl{

    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_49_ljthreeyqhs_三期以上笔数;


    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;
    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private LN005_贷款分户信息_Repository LN005Ln005_贷款分户信息Repository;
    @Autowired
    private LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;



    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //
    public void process(LocalDate beginDate,LocalDate endDate) {
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


        List<String> list = Arrays.asList(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期,E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还).stream().map(E->E.getText()).collect(Collectors.toList());

        List<LN006_贷款分期还款计划> ln006_贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByCurseqstate本期状态In(list);

        Map<String,List<LN006_贷款分期还款计划>> ln006_贷款分期还款计划Map = ln006_贷款分期还款计划s.stream().collect(Collectors.groupingBy(e->e.getLoancontrcode0合同代码()));
        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByLoandate放款日期BetweenOrderByLoandate放款日期Desc(beginDate,endDate);
        System.out.println("-----------------------------"+ ln003_合同信息s.size());

/*
        Map<String,LN005_贷款分户信息> ln005_贷款分户信息Map = LN005Ln005_贷款分户信息Repository.findAll()
                .stream().collect(Collectors.toMap(e->e.getLoancontrcode合同代码(),e->e));
*/

        List<Triplet<Long,LocalDate,LocalDate>> triplets_date =  run统计周期编码(LocalDate.now().minusDays(100),LocalDate.now(), 统计周期编码.H__01_每日);


        List<Triplet<LocalDate,Long,Long>> sourceList = triplets_date.stream().map(e->{

            System.out.println("11现在处理的日期是  1111111"+ e.getValue2());

            Long totlal = ln003_合同信息s.stream().mapToLong(f->{
                List<LN006_贷款分期还款计划> ln006_贷款分期还款计划s_ = ln006_贷款分期还款计划Map.get(f.getLoancontrcode合同代码());
                if(ln006_贷款分期还款计划s_ != null){
                    Long count_逾期归还 = ln006_贷款分期还款计划s_
                            .stream()
                            .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                            .filter(x->x.getRepaydate1还款日期().isAfter(e.getValue1()))
                            //     .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                            .count();

                    Long count_逾期 = ln006_贷款分期还款计划s_
                            .stream()

                            .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                            .filter(x->x.getEnddate0终止日期().isBefore(e.getValue1()))
                            //   .filter(x->x.getRepaydate1还款日期().isAfter(e.getValue1()))
                            //     .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                            .count();
                    if(count_逾期归还+count_逾期>3){
                        return 1;
                    }else{
                        return 0;
                    }
                }else{
                    return 0;
                }

            }).sum();

            return Triplet.with(e.getValue1(),totlal,totlal);

        }).collect(Collectors.toList());





        Long num = 0l;


        List<Triplet<LocalDate,Long,Long>> triplets = new ArrayList<>();
        for(Triplet<LocalDate,Long,Long> triplet: sourceList){

            num += triplet.getValue1();

            triplets.add(Triplet.with(triplet.getValue0(),triplet.getValue1().longValue(),num));
        }

        triplets.stream().forEach(e->{
            System.out.println("-----------"+ e.toString());
        });






      //  save(triplets);
        RateAnalysisStream rateAnalysisStream = new RateAnalysisStream();
        rateAnalysisStream.setBeginDate(beginDate);
        rateAnalysisStream.setEndDate(endDate);
        rateAnalysisStream.setDuration(timer.getTime());

        System.out.println();
        return rateAnalysisStream;

    }






    @Transactional
    public void save(List<Triplet<LocalDate,Long,Long>> triplets) {
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



        h1.setLjthreeyqhs_三期以上笔数_NUMBER_18_0(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf(rateHistory_环比);

        h1.setLjhbthreeyqhs_环比三期以上笔数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf(rateHistory_同比);

        h1.setLjsnthreeyqhs_同比三期以上笔数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());



    }
    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
/*        if(rateHistories.size()==0) return;Double rateHistory_环比 = rateHistories_环比
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
                .mapToDouble(e->e.getDoubleValue()).sum();*/

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



        h1.setLjthreeyqhs_三期以上笔数_NUMBER_18_0(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf(rateHistory_环比);

        h1.setLjhbthreeyqhs_环比三期以上笔数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf(rateHistory_同比);

        h1.setLjsnthreeyqhs_同比三期以上笔数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }

}
