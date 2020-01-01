package org.ylgjj.loan.rates;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.domain.LN004_合同状态信息;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository.LN004_合同状态信息Repository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class __test_SY_168_dkzbs_贷款总笔数_RateServiceImpl________________ extends RateServiceBaseImpl{


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Output commom(String dimension1, String dimension2, String dimension3, 统计周期编码 period, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_176_SEQ_回收户数__他行回收___AND_0302002108.name();


        String name_ = StatisticalIndexCodeEnum.S_177_SEQ_结清户数_AND_0302002201.name();



        List<LN004_合同状态信息> ln004_合同状态信息s = ln004_合同状态信息Repository.findAll();



        ln004_合同状态信息s.stream().collect(Collectors.groupingBy(e->e.getLoancontrcode())).entrySet()
                .stream().forEach(e->{
                    e.getValue().stream().filter(x->x.getLoancontrcode() != "").count();

                    RateHistory rateHistory = new RateHistory();

                    rateHistoryRepository.save(rateHistory);

        });

        Output output = new Output();
        output.setData(null);
        output.setSuccess(true);
        return output;
    }






    public void process() {




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


        RateHistory rateHistory = new RateHistory();
        rateHistory.setIndexNo(E_指标_RATE_SY.SY_177_dkpjspts_贷款平均审批天数.get编码());
        rateHistoryRepository.save(rateHistory);







    }


    public static void  main(String[] argus) {









/*
        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByLoandate放款日期Between(LocalDate.now().minusDays(100),LocalDate.now());


        List<Pair<LocalDate,Integer>> sourceList =ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getLoandate放款日期())).entrySet()
                .stream().map(e->{
                    return Pair.with(e.getKey(),e.getValue().size());
                }).collect(Collectors.toList());


        sourceList.stream().count();*/

/*
        Map<LocalDate,Pair<LocalDate,Integer>> maps = sourceList.stream().collect(Collectors.toMap(e->e.getValue0(),e->e));

        */


        long count = LocalDate.now().until(LocalDate.now().minusDays(10), ChronoUnit.DAYS);
        Map<LocalDate,Integer>  mps =  new HashMap();
        Integer num = 0;
        for(long i = count; i > 0; i++) {

            System.out.println("----------------"+ i);

/*            num += maps.get(LocalDate.now().minusDays(i)).getValue1();
            mps.put(LocalDate.now(), num);*/
        }
        List<Triplet<Long,LocalDate,LocalDate>> triplets =  run统计周期编码(LocalDate.now().minusDays(100),LocalDate.now(),统计周期编码.H__03_每月);

        System.out.println("----------------"+ triplets.toString());


        Triplet<Long,LocalDate,LocalDate> one = run统计周期编码_mini(LocalDate.now().minusDays(180),LocalDate.now(), 统计周期编码.H__05_半年);
        System.out.println("---------run统计周期编码_mini-------"+ one.toString());
    }











        public static Integer  period(LocalDate localDate,统计周期编码 p) {


        LocalDate arch = LocalDate.now();


        long count = LocalDate.now().until(LocalDate.now().minusDays(1), ChronoUnit.DAYS);
        Map<LocalDate,Integer>  mps =  new HashMap();
        Integer num = 0;
        for(long i = count; i > 0; i++) {

            System.out.println("----------------"+ i);

/*            num += maps.get(LocalDate.now().minusDays(i)).getValue1();
            mps.put(LocalDate.now(), num);*/
        }

        return 0;
    }


    public static List<Triplet<Long,LocalDate,LocalDate>> run统计周期编码(LocalDate beginDate, LocalDate endDate, 统计周期编码 t ) {


        //统计周期编码 t = 统计周期编码.fromString(statisticalIndexCodeEnum.get统计周期());

        System.out.println(" 统计周期编码 是啊啊啊——————"+ t.toString());
        if(t == 统计周期编码.H__01_每日){
            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.DAYS)).intValue()).mapToObj(i->{
                LocalDate tmp = beginDate.plusDays(i);
                return Triplet.with(Integer.valueOf(i).longValue(),tmp,tmp);
            }).collect(Collectors.toList());

        }
        if(t == 统计周期编码.H__02_每周){

            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.WEEKS)).intValue()).mapToObj(i->{
                LocalDate tmp = beginDate.plusWeeks(i);
                LocalDate monthBegin = tmp.with(DayOfWeek.MONDAY);
                LocalDate monthEnd = tmp.with(DayOfWeek.SUNDAY);;
                return Triplet.with(Integer.valueOf(i).longValue(),monthBegin,monthEnd);
            }).collect(Collectors.toList());

        }
        if(t == 统计周期编码.H__03_每月){



            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.MONTHS)).intValue()).mapToObj(i->{
                LocalDate tmp = beginDate.plusMonths(i);
                // 该月第一天
                LocalDate firstDay = tmp.with(TemporalAdjusters.firstDayOfMonth());
                // 该月最后一天
                LocalDate lastDay = tmp.with(TemporalAdjusters.lastDayOfMonth());
                return Triplet.with(Integer.valueOf(i).longValue(),firstDay,lastDay);
            }).collect(Collectors.toList());

        }

        if(t == 统计周期编码.H__04_每季){

            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.MONTHS)).intValue()).mapToObj(i->{
                LocalDate tmp = beginDate.plusMonths(i);

                LocalDate monthBegin = null;
                LocalDate monthEnd = null;
                if(tmp.getMonthValue() <4){
                    monthBegin = tmp.withMonth(1).with(TemporalAdjusters.firstDayOfMonth());
                    monthEnd = tmp.withMonth(3).with(TemporalAdjusters.lastDayOfMonth());;
                }
                if(tmp.getMonthValue() <7 && tmp.getMonthValue()> 3){
                    monthBegin = tmp.withMonth(4).with(TemporalAdjusters.firstDayOfMonth());
                    monthEnd = tmp.withMonth(6).with(TemporalAdjusters.lastDayOfMonth());;
                }
                if(tmp.getMonthValue() <10 && tmp.getMonthValue()> 6){
                    monthBegin = tmp.withMonth(7).with(TemporalAdjusters.firstDayOfMonth());
                    monthEnd = tmp.withMonth(9).with(TemporalAdjusters.lastDayOfMonth());;
                }

                if(tmp.getMonthValue() <13 && tmp.getMonthValue()> 9){
                    monthBegin = tmp.withMonth(10).with(TemporalAdjusters.firstDayOfMonth());
                    monthEnd = tmp.withMonth(12).with(TemporalAdjusters.lastDayOfMonth());;
                }else{

                }
                return Triplet.with(LocalDate.now().until(beginDate, ChronoUnit.MONTHS),monthBegin,monthEnd);
            }).collect(Collectors.toList());


        }
        if(t == 统计周期编码.H__05_半年){

            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.DAYS)).intValue()).mapToObj(i->{
                LocalDate tmp = beginDate.plusMonths(i);

                LocalDate monthBegin = null;
                LocalDate monthEnd = null;
                if(tmp.getMonthValue() <6){
                    monthBegin = tmp.withMonth(1).with(TemporalAdjusters.firstDayOfMonth());
                    monthEnd = tmp.withMonth(5).with(TemporalAdjusters.lastDayOfMonth());;
                }else{
                    monthBegin = tmp.withMonth(6).with(TemporalAdjusters.firstDayOfMonth());
                    monthEnd = tmp.withMonth(12).with(TemporalAdjusters.lastDayOfMonth());;
                }
                return Triplet.with(LocalDate.now().until(beginDate, ChronoUnit.MONTHS)/2,monthBegin,monthEnd);
            }).collect(Collectors.toList());



        }
        if(t == 统计周期编码.H__06_每年){

            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.YEARS)).intValue()).mapToObj(i->{
                LocalDate tmp = beginDate.plusMonths(i);

                LocalDate monthBegin = null;
                LocalDate monthEnd = null;
                beginDate.plusYears(1);

                // 该月第一天
                LocalDate firstDay = beginDate.with(TemporalAdjusters.firstDayOfYear());
                // 该月最后一天
                LocalDate lastDay = beginDate.with(TemporalAdjusters.lastDayOfYear());

                return Triplet.with(Integer.valueOf(i).longValue(),firstDay,lastDay);
            }).collect(Collectors.toList());



        }

        return null;
    }
    public static Triplet<Long,LocalDate,LocalDate> run统计周期编码_mini(LocalDate beginDate, LocalDate endDate, 统计周期编码 t ) {


        //统计周期编码 t = 统计周期编码.fromString(statisticalIndexCodeEnum.get统计周期());

        System.out.println(" 统计周期编码 是啊啊啊——————"+ t.toString());
        if(t == 统计周期编码.H__01_每日){

            Long p = Long.valueOf(endDate.until(beginDate, ChronoUnit.DAYS));
            System.out.println(" how long ———"+ p);
            LocalDate tmp = endDate.plusDays(p);

            return Triplet.with(p ,tmp,tmp);

        }

        if(t == 统计周期编码.H__03_每月){

            //LocalDate lastDay = endDate.with(TemporalAdjusters.lastDayOfMonth());
            System.out.println("-----------begin date"+ beginDate);
            Long p = Long.valueOf(endDate.until(beginDate, ChronoUnit.MONTHS));

            // 该月第一天

            // 该月最后一天
            LocalDate firstDay_beginDate = beginDate.with(TemporalAdjusters.firstDayOfMonth());
            LocalDate firstDay_endDate = endDate.with(TemporalAdjusters.firstDayOfMonth());
            Long p_index = Long.valueOf(firstDay_endDate.until(firstDay_beginDate, ChronoUnit.MONTHS));



            LocalDate tmp = beginDate;
            LocalDate firstDay_ = tmp.with(TemporalAdjusters.firstDayOfMonth());
            LocalDate lastDay_ = tmp.with(TemporalAdjusters.lastDayOfMonth());
            return Triplet.with(p_index,firstDay_,lastDay_);




        }

        if(t == 统计周期编码.H__02_每周){
            System.out.println("-----------begin date"+ beginDate);


            // 该月第一天

            // 该月最后一天
            LocalDate firstDay_beginDate = beginDate.with(DayOfWeek.MONDAY);
            LocalDate firstDay_endDate = endDate.with(DayOfWeek.MONDAY);
            Long p_index = Long.valueOf(firstDay_endDate.until(firstDay_beginDate, ChronoUnit.WEEKS));



            LocalDate tmp = beginDate;
            LocalDate firstDay_ = tmp.with(DayOfWeek.MONDAY);
            LocalDate lastDay_ = tmp.with(DayOfWeek.SUNDAY);
            return Triplet.with(p_index,firstDay_,lastDay_);




        }
        if(t == 统计周期编码.H__06_每年){


            System.out.println("-----------begin date"+ beginDate);


            // 该月第一天

            // 该月最后一天
            LocalDate firstDay_beginDate = beginDate.with(TemporalAdjusters.firstDayOfYear());
            LocalDate firstDay_endDate = endDate.with(TemporalAdjusters.firstDayOfYear());
            Long p_index = Long.valueOf(firstDay_endDate.until(firstDay_beginDate, ChronoUnit.YEARS));



            LocalDate tmp = beginDate;
            LocalDate firstDay_ = tmp.with(TemporalAdjusters.firstDayOfYear());
            LocalDate lastDay_ = tmp.with(TemporalAdjusters.lastDayOfYear());
            return Triplet.with(p_index,firstDay_,lastDay_);




        }

        if(t == 统计周期编码.H__04_每季){

/*
            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.MONTHS)).intValue()).mapToObj(i->{

                return Triplet.with(LocalDate.now().until(beginDate, ChronoUnit.MONTHS),monthBegin,monthEnd);
            }).collect(Collectors.toList());

*/


            LocalDate tmp = beginDate;

            LocalDate monthBegin = null;
            LocalDate monthEnd = null;
            if(tmp.getMonthValue() <4){
                monthBegin = tmp.withMonth(1).with(TemporalAdjusters.firstDayOfMonth());
                monthEnd = tmp.withMonth(3).with(TemporalAdjusters.lastDayOfMonth());;
            }
            if(tmp.getMonthValue() <7 && tmp.getMonthValue()> 3){
                monthBegin = tmp.withMonth(4).with(TemporalAdjusters.firstDayOfMonth());
                monthEnd = tmp.withMonth(6).with(TemporalAdjusters.lastDayOfMonth());;
            }
            if(tmp.getMonthValue() <10 && tmp.getMonthValue()> 6){
                monthBegin = tmp.withMonth(7).with(TemporalAdjusters.firstDayOfMonth());
                monthEnd = tmp.withMonth(9).with(TemporalAdjusters.lastDayOfMonth());;
            }

            if(tmp.getMonthValue() <13 && tmp.getMonthValue()> 9){
                monthBegin = tmp.withMonth(10).with(TemporalAdjusters.firstDayOfMonth());
                monthEnd = tmp.withMonth(12).with(TemporalAdjusters.lastDayOfMonth());;
            }else{

            }

            LocalDate firstDay_beginDate = beginDate.with(TemporalAdjusters.firstDayOfMonth());
            LocalDate firstDay_endDate = endDate.with(TemporalAdjusters.firstDayOfMonth());
            Long p_index = Long.valueOf(firstDay_endDate.until(firstDay_beginDate, ChronoUnit.MONTHS))/3;

            return Triplet.with(p_index,monthBegin,monthEnd);
        }


        if(t == 统计周期编码.H__05_半年){

/*
            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.DAYS)).intValue()).mapToObj(i->{

                return Triplet.with(LocalDate.now().until(beginDate, ChronoUnit.MONTHS)/2,monthBegin,monthEnd);
            }).collect(Collectors.toList());
*/

            LocalDate tmp = beginDate;

            LocalDate monthBegin = null;
            LocalDate monthEnd = null;
            System.out.println(" current date "+ tmp.toString());

            if(tmp.getMonthValue() <7){
                monthBegin = tmp.withMonth(1).with(TemporalAdjusters.firstDayOfMonth());
                monthEnd = tmp.withMonth(6).with(TemporalAdjusters.lastDayOfMonth());;
            }else{
                monthBegin = tmp.withMonth(7).with(TemporalAdjusters.firstDayOfMonth());
                monthEnd = tmp.withMonth(12).with(TemporalAdjusters.lastDayOfMonth());;
            }
            LocalDate firstDay_ = tmp.with(TemporalAdjusters.firstDayOfYear());
            LocalDate lastDay_ = tmp.with(TemporalAdjusters.lastDayOfYear());


            LocalDate firstDay_beginDate = beginDate.with(TemporalAdjusters.firstDayOfMonth());
            LocalDate firstDay_endDate = endDate.with(TemporalAdjusters.firstDayOfMonth());
            Long p_index = Long.valueOf(firstDay_endDate.until(firstDay_beginDate, ChronoUnit.MONTHS))/6;



            return Triplet.with(p_index,monthBegin,monthEnd);
        }

        /*



*/

        return null;
    }

}
