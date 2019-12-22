package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.CM001_单位基本资料表;
import org.ylgjj.loan.domain.DP005_单位分户账;
import org.ylgjj.loan.domain.DP202_单位缴存变更登记簿;
import org.ylgjj.loan.enumT.E_DP005_单位分户账_单位账户类型;
import org.ylgjj.loan.enumT.E_DP202_单位缴存变更登记簿_变更类型;
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
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_13_ljjzzcdws_建制正常单位数_RateServiceImpl extends RateServiceBaseImpl{


    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_16_ljjzhjdws_建制缓缴单位数;


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Autowired
    private CM001_单位基本资料表Repository cm001_单位基本资料表Repository;

    @Autowired
    private DP005_单位分户账_Repository dp005_单位分户账_repository;

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

        List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = dp202_单位缴存变更登记簿_repository.findAll();

        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = cm001_单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e->e.getUnitcustid单位客户号(), e->e));

        //   Map<String,DP004_单位缴存信息表> dp004_单位缴存信息表s = dp004_单位缴存信息表_repository.findAll().stream().collect(Collectors.toMap(e->e.getUnitaccnum单位账号(), e->e));

        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();

        List<DP005_单位分户账> dp005_单位分户账s = dp005_单位分户账_repository
                .findByClsaccdate销户日期BetweenOrderByClsaccdate销户日期Desc(LocalDate.now().minusDays(20000),LocalDate.now());

        Map<String,DP005_单位分户账> dp005_单位分户账Map = dp005_单位分户账s.stream().filter(x->x.getUnitacctype_单位账户类型().equals(E_DP005_单位分户账_单位账户类型.普通.getText()))
                .collect(Collectors.toMap(e->e.getUnitcustid_单位客户号(),e->e));



        //  System.out.println("-----------------------------"+ ln003_合同信息s.size());




        List<Triplet<LocalDate,Integer,Long>> sourceList =dp202_单位缴存变更登记簿s
                .stream()
                .map(e->{
                    return Pair.with(e,dp005_单位分户账Map.get(e.getUnitcustid不可为空单位客户号()));
                })
/*                .filter(e->
                        e.getValue1().getUnitaccstate_单位账户状态().equals(E_DP005_单位分户账_单位账户状态.封存.getText()))*/
                //.filter(e->!e.getUnitaccstate_单位账户状态().equals(E_DP005_单位分户账_单位账户状态.销户.getText()))
                .collect(Collectors.groupingBy(e->e.getValue0().getTransdate不可为空交易日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{

                    System.out.println("stream---------"+e.getKey());
                    return Triplet.with(e.getKey(),
                            e.getValue()
                                    .stream()
                                    .mapToInt(x->{
                                        if(x.getValue0().getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_4_封存.getText())
                                        || x.getValue0().getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_5_正常状态销户.getText())
                                       //         || x.getValue1().
                                  //      || x.getValue0().getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_6_正常状态转出.getText())
                                   //             || x.getValue0().getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_7_正常状态被合并.getText())
                                                    ){
                                            return -1;
                                        }
                                        if(
                                            //    x.getValue0().getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_3_转入后正常状态.getText())||
                                        x.getValue0().getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_2_启封.getText())){

                                            return +1;
                                        }
                                        return 0;
                                    })
                                    .sum()


                            ,0L);
                }).collect(Collectors.toList());







        List<Triplet<LocalDate,Integer,Long>> sourceList_开户 = dp005_单位分户账s
                .stream()
                .filter(x->x.getUnitacctype_单位账户类型().equals(E_DP005_单位分户账_单位账户类型.普通.getText()))
                .collect(Collectors.groupingBy(x->x.getOpnaccdate开户日期()))
                .entrySet()
                .stream()
                .map(e->{

                    return Triplet.with(e.getKey(),e.getValue().size(),0L);
                }).collect(Collectors.toList());


        List<Triplet<LocalDate,Integer,Long>> sourceList_销户 = dp005_单位分户账s
                .stream()
                .filter(x->x.getUnitacctype_单位账户类型().equals(E_DP005_单位分户账_单位账户类型.普通.getText()))
                .collect(Collectors.groupingBy(x->x.getClsaccdate销户日期()))
                .entrySet()
                .stream()
                .map(e->{
                    return Triplet.with(e.getKey(),e.getValue().size(),0L);
                }).collect(Collectors.toList());



        sourceList_销户.addAll(sourceList_开户);
        sourceList_销户.addAll(sourceList);


        List<Triplet<LocalDate,Integer,Long>> sourceList_last = sourceList_销户.stream().collect(Collectors.groupingBy(e->e.getValue0()))
                .entrySet().stream().map(e->{
                    ;
            return Triplet.with(e.getKey(),e.getValue().stream().mapToInt(x->x.getValue1()).sum(),0L);
        }).collect(Collectors.toList());



        Long num = 0L;

        List<Triplet<LocalDate,Integer,Long>> triplets = new ArrayList<>();
        for(Triplet<LocalDate,Integer,Long> triplet: sourceList_last){

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


        h1.setLjjzzcdws_建制正常单位数_NUMBER_18_0(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/(rateHistory_环比!=0? rateHistory_环比:-1));

        h1.setLjhbjzzcdws_环比建制正常单位数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/(rateHistory_同比!=0? rateHistory_同比:-1));

        h1.setLjsnjzzcrs_同比建制正常人数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());




    }









    public void process_() {

        Map<String,List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map = dp202_单位缴存变更登记簿_repository.findAll().stream().collect(Collectors.groupingBy(e->e.getUnitaccnum不可为空单位账号()));

        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = cm001_单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e->e.getUnitcustid单位客户号(), e->e));

        //   Map<String,DP004_单位缴存信息表> dp004_单位缴存信息表s = dp004_单位缴存信息表_repository.findAll().stream().collect(Collectors.toMap(e->e.getUnitaccnum单位账号(), e->e));

        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        Map<String,List<DP005_单位分户账>> dp005_单位分户账Map = dp005_单位分户账_repository
                .findByClsaccdate销户日期BetweenOrderByClsaccdate销户日期Desc(LocalDate.now().minusDays(20000),LocalDate.now())
                .stream().collect(Collectors.groupingBy(e->e.getUnitcustid_单位客户号()));

        //  System.out.println("-----------------------------"+ ln003_合同信息s.size());




        List<Triplet<LocalDate,Integer,Long>> sourceList = null;//
         cm001_单位基本资料表Repository
                .findAll()
                .stream()
                .map(e->{
                    DP005_单位分户账 dp005_单位分户账 = dp005_单位分户账Map.get(e.getUnitcustid单位客户号())
                            .stream()
                            .filter(x->x.getUnitacctype_单位账户类型().equals(E_DP005_单位分户账_单位账户类型.普通.getText()))
                            .findFirst().get();
                    return Triplet.with(e,dp005_单位分户账,dp202_单位缴存变更登记簿Map.get(dp005_单位分户账.getUnitaccnum单位账号()));
                })
/*                .filter(e->
                        e.getValue1().getUnitaccstate_单位账户状态().equals(E_DP005_单位分户账_单位账户状态.封存.getText()))*/
                //.filter(e->!e.getUnitaccstate_单位账户状态().equals(E_DP005_单位分户账_单位账户状态.销户.getText()))

                .collect(Collectors.toList())
                .stream()
                .mapToInt(e->{

                    if(e.getValue1().getClsaccdate销户日期().isBefore(LocalDate.now())){
                        return 0;
                    }

                    if(e.getValue1().getOpnaccdate开户日期().isAfter(LocalDate.now())){
                        Optional<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿Optional = e.getValue2()
                                .stream()
                                .filter(x->x.getTransdate不可为空交易日期().isBefore(LocalDate.now()) || x.getTransdate不可为空交易日期().equals(LocalDate.now()))
                                .filter(x->x.getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_5_正常状态销户.getText()))
                                .filter(x->x.getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_4_封存.getText()))
                                .sorted(Comparator.comparingLong(x->x.getTransdate不可为空交易日期().toEpochDay()))
                                .findFirst();
                        if(dp202_单位缴存变更登记簿Optional.isPresent()){
                            return 0;
                        }else{
                            return 0;
                          /*  if(e.getValue1().getUnitaccstate_单位账户状态().equals(E_DP005_单位分户账_单位账户状态.正常)){
                                return 1;
                            }else{
                                return 0;
                            }*/
                        }

                    }else{
                        return 0;
                    }


                });

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



        h1.setLjjzzcdws_建制正常单位数_NUMBER_18_0(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/(rateHistory_环比!=0? rateHistory_环比:-1));

        h1.setLjhbjzzcdws_环比建制正常单位数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/(rateHistory_同比!=0? rateHistory_同比:-1));

        h1.setLjsnjzzcrs_同比建制正常人数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());




    }

}
