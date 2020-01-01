package org.ylgjj.loan.rates;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.domain.LN006_贷款分期还款计划;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.enumT.E_LN006_贷款分期还款计划_curseqStatusEnum;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository.LN006_贷款分期还款计划Repository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_130_yqdkje_逾期贷款金额_RateServiceImpl {
    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_130_yqdkje_逾期贷款金额;


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");






    //
    public void process() {


        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findAll();

        System.out.println("-----------LN003_合同信息 "+ ln003_合同信息s.size());
        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<String> list = Arrays.asList(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期,E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还).stream().map(E->E.getText()).collect(Collectors.toList());
        List<LN006_贷款分期还款计划> ln006_贷款分期还款计划s =
                ln006_贷款分期还款计划Repository.findByCurseqstate本期状态In(list);
        System.out.println("--------LN006_贷款分期还款计划---------------------"+ ln006_贷款分期还款计划s.size());


        Map<String,List<LN006_贷款分期还款计划>> ln = ln006_贷款分期还款计划s.stream().collect(Collectors.groupingBy(e->e.getLoancontrcode0合同代码()));
        List<Triplet<LocalDate,Integer,Long>> sourceList =ln006_贷款分期还款计划s.stream().collect(Collectors.groupingBy(e->e.getRepaydate1还款日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    System.out.println("stream---------"+e.getKey());
                    return Triplet.with(e.getKey(),e.getValue().size(),0L);
                }).collect(Collectors.toList());






        for(int i=0; i< 5; i++){
            int finalI = i;
            Double yqbj = ln003_合同信息s.stream()
                    //.filter(e->e.getLoandate放款日期().isAfter())
                    .mapToDouble(e->{
                        List<LN006_贷款分期还款计划> ln006_贷款分期还款计划s1 = ln.get(e.getLoancontrcode合同代码());
                        if(ln006_贷款分期还款计划s1!= null){

                            LocalDate current = LocalDate.now().minusDays(finalI);

                            Map<String,List<LN006_贷款分期还款计划>> ln006_贷款分期还款计划s2 = ln006_贷款分期还款计划s1
                                    .stream()
                                    .filter(x->x.getEnddate0终止日期().isBefore(current))
                                    .collect(Collectors.groupingBy(x->E_LN006_贷款分期还款计划_curseqStatusEnum.fromString(x.getCurseqstate本期状态()).getText()));

                            List<LN006_贷款分期还款计划> l_逾期 = ln006_贷款分期还款计划s2.get(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText());
                            List<LN006_贷款分期还款计划> l_逾期归还 = ln006_贷款分期还款计划s2.get(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText());

                            if(l_逾期!= null){
                                LN006_贷款分期还款计划 ln006_贷款分期还款计划 = l_逾期.stream()
                                        //.filter(x->x.getEnddate0终止日期().isAfter(current))
                                        .sorted(Comparator.comparingLong(x->x.getEnddate0终止日期().toEpochDay()))
                                        .findFirst().get();
                                return ln006_贷款分期还款计划.getInitialbal0期初余额().doubleValue()+
                                        ln006_贷款分期还款计划.getOweprin本期未还本金0().doubleValue()-
                                        ln006_贷款分期还款计划.getPlanprin0本期应还本金().doubleValue();

                            }else

                            if(l_逾期归还!= null){
                                Optional<LN006_贷款分期还款计划> ln006_贷款分期还款计划Optional = l_逾期归还.stream()
                                        .filter(x->x.getRepaydate1还款日期().isAfter(current))
                                        .sorted(Comparator.comparingLong(x->x.getEnddate0终止日期().toEpochDay())).findFirst();

                                if(ln006_贷款分期还款计划Optional.isPresent()){
                                    return ln006_贷款分期还款计划Optional.get().getInitialbal0期初余额().doubleValue();
                                }else{
                                    return 0;
                                }
                            }else{
                                return 0;
                            }


                        }else{
                            return 0;
                        }



                    }).sum();
            System.out.println(LocalDate.now().minusDays(finalI)+"--------逾期本金------"+yqbj);
        }
/*

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
*/










    }



    public void processTest() {


        List<LN006_贷款分期还款计划> ln006_贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByCurseqstate本期状态In(null);



        List<Triplet<LocalDate, Integer,Double>>  value_逾期归还 = ln006_贷款分期还款计划s
                .stream()
                .filter(e->e.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                .collect(Collectors.groupingBy(e->e.getRepaydate1还款日期()))
                .entrySet()
                .stream()

                .map(f->{


                    Double count_逾期归还 = f.getValue()
                            .stream()
                            .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                            .filter(x->x.getRepaydate1还款日期().isAfter(f.getKey()))
                            //     .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                            .mapToDouble(x->x.getInitialbal0期初余额().doubleValue()).sum();

                    return Triplet.with( f.getKey(), f.getValue().size(),count_逾期归还);

                }).collect(Collectors.toList());



        List<Triplet<LocalDate, Integer,Double>> value_逾期 = ln006_贷款分期还款计划s
                .stream()
                .filter(e->e.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                .collect(Collectors.groupingBy(e->e.getEnddate0终止日期()))
                .entrySet()
                .stream()

                .map(f->{


                    Double count_逾期 = f.getValue()
                            .stream()

                            .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                            .filter(x->x.getEnddate0终止日期().isBefore(f.getKey()))
                            //   .filter(x->x.getRepaydate1还款日期().isAfter(e.getValue1()))
                            //     .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                            .mapToDouble(x->x.getInitialbal0期初余额().doubleValue()).sum();
                    ;
                    return Triplet.with( f.getKey(), f.getValue().size(),count_逾期);

                }).collect(Collectors.toList());



        Map<String,List<LN006_贷款分期还款计划>> ln = ln006_贷款分期还款计划s.stream().collect(Collectors.groupingBy(e->e.getLoancontrcode0合同代码()));
        List<Triplet<LocalDate,Integer,Long>> sourceList =ln006_贷款分期还款计划s.stream().collect(Collectors.groupingBy(e->e.getRepaydate1还款日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    System.out.println("stream---------"+e.getKey());
                    return Triplet.with(e.getKey(),e.getValue().size(),0L);
                }).collect(Collectors.toList());






/*

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
*/










    }
    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
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

/*        if(rateHistories.size()==0) return;Long rateHistory_环比 = rateHistories_环比
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
                .mapToLong(e->e.getLongValue()).sum();*/


        h1.setYqdkje_逾期贷款金额_NUMBER_18_2(rateHistory);


    }

}


/*


        for(int i=0; i< 5; i++){
        int finalI = i;
        Double yqbj = ln003_合同信息s.stream()
        //.filter(e->e.getLoandate放款日期().isAfter())
        .mapToDouble(e->{
        List<LN006_贷款分期还款计划> ln006_贷款分期还款计划s1 = ln.get(e.getLoancontrcode合同代码());
        if(ln006_贷款分期还款计划s1!= null){

        LocalDate current = LocalDate.now().minusDays(finalI);

        Map<String,List<LN006_贷款分期还款计划>> ln006_贷款分期还款计划s2 = ln006_贷款分期还款计划s1
        .stream()
        .filter(x->x.getEnddate0终止日期().isBefore(current))
        .collect(Collectors.groupingBy(x->E_LN006_贷款分期还款计划_curseqStatusEnum.fromString(x.getCurseqstate本期状态()).getText()));

        List<LN006_贷款分期还款计划> l_逾期 = ln006_贷款分期还款计划s2.get(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText());
        List<LN006_贷款分期还款计划> l_逾期归还 = ln006_贷款分期还款计划s2.get(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText());

        if(l_逾期!= null){
        LN006_贷款分期还款计划 ln006_贷款分期还款计划 = l_逾期.stream()
        //.filter(x->x.getEnddate0终止日期().isAfter(current))
        .sorted(Comparator.comparingLong(x->x.getEnddate0终止日期().toEpochDay()))
        .findFirst().get();
        return ln006_贷款分期还款计划.getInitialbal0期初余额().doubleValue()+
        ln006_贷款分期还款计划.getOweprin本期未还本金0().doubleValue()-
        ln006_贷款分期还款计划.getPlanprin0本期应还本金().doubleValue();

        }else

        if(l_逾期归还!= null){
        Optional<LN006_贷款分期还款计划> ln006_贷款分期还款计划Optional = l_逾期归还.stream()
        .filter(x->x.getRepaydate1还款日期().isAfter(current))
        .sorted(Comparator.comparingLong(x->x.getEnddate0终止日期().toEpochDay())).findFirst();

        if(ln006_贷款分期还款计划Optional.isPresent()){
        return ln006_贷款分期还款计划Optional.get().getInitialbal0期初余额().doubleValue();
        }else{
        return 0;
        }
        }else{
        return 0;
        }


        }else{
        return 0;
        }



        }).sum();
        System.out.println(LocalDate.now().minusDays(finalI)+"--------逾期本金------"+yqbj);
        }*/
