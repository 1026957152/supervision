package org.ylgjj.loan.history_stream;


import org.javatuples.Quartet;
import org.javatuples.Triplet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.*;
import org.ylgjj.loan.enumT.*;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class HistoryServiceImpl {

    protected transient Logger logger = LoggerFactory.getLogger(getClass());
    // @PersistenceContext
    protected EntityManager em;

    protected DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMM");
    DateTimeFormatter df_never = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    protected CollectHistoryRepository collectHistoryRepository;

    @Autowired
    protected TargetHistoryRepository targetHistoryRepository;
    @Autowired
    protected AnalysisTableRepository analysisTableRepository;


    @Autowired
    protected StreamHistoryRepository streamHistoryRepository;

    @Autowired
    protected DP008_单位明细账_Repository dp008__单位明细账_repository;

    @Autowired
    protected DP004_单位缴存信息表_Repository dp004_单位缴存信息表_repository;
    @Autowired
    protected DP030_单位缓缴登记簿_Repository dp030_单位缓缴登记簿_repository;

    @Autowired
    protected DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;
    @Autowired
    protected DP204_个人缴存变更登记簿_Repository dp204_个人缴存变更登记簿_repository;
    @Autowired
    protected LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;

    @Autowired
    protected DP093_冻结解冻登记簿_Repository dp093_冻结解冻登记簿_repository;
    @Autowired
    protected DP034_公积金开销户登记簿_Repository dp034_公积金开销户登记簿_repository;

    @Autowired
    protected AnalysisStreamRepository analysisStreamRepository;


    @Autowired
    protected TargetAnalysisTableRepository targetAnalysisTableRepository;
    @Autowired
    protected PB008_clerk_info_Repository pb008_柜员信息表_repository;


    public static List<Triplet<Long,LocalDate,LocalDate>> run统计周期编码(LocalDate beginDate, LocalDate endDate, StatisticalIndexCodeEnum statisticalIndexCodeEnum) {


        统计周期编码 t = 统计周期编码.fromString(statisticalIndexCodeEnum.get统计周期());

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

    public static List<Triplet<Long,LocalDate,LocalDate>> run统计周期编码(LocalDate beginDate, LocalDate endDate, 统计周期编码 t) {



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


    public static List<Quartet<Long,LocalDate,LocalDate,StatisticalIndexCodeEnum>> run统计周期编码Quartet(LocalDate beginDate, LocalDate endDate, StatisticalIndexCodeEnum statisticalIndexCodeEnum) {


        统计周期编码 t = 统计周期编码.fromString(statisticalIndexCodeEnum.get统计周期());

        System.out.println(" 统计周期编码 是啊啊啊——————"+ t.toString());
        if(t == 统计周期编码.H__01_每日){
            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.DAYS)).intValue()).mapToObj(i->{
                LocalDate tmp = beginDate.plusDays(i);
                return Quartet.with(Integer.valueOf(i).longValue(),tmp,tmp,statisticalIndexCodeEnum);
            }).collect(Collectors.toList());

        }
        if(t == 统计周期编码.H__02_每周){

            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.DAYS)).intValue()).mapToObj(i->{
                LocalDate tmp = beginDate.plusWeeks(i);
                LocalDate monthBegin = tmp.with(DayOfWeek.MONDAY);
                LocalDate monthEnd = tmp.with(DayOfWeek.SUNDAY);;
                return Quartet.with(LocalDate.now().until(beginDate, ChronoUnit.WEEKS),monthBegin,monthEnd,statisticalIndexCodeEnum);
            }).collect(Collectors.toList());

        }
        if(t == 统计周期编码.H__03_每月){



            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.MONTHS)).intValue()).mapToObj(i->{
                LocalDate tmp = beginDate.plusMonths(i);
                // 该月第一天
                LocalDate firstDay = tmp.with(TemporalAdjusters.firstDayOfMonth());
                // 该月最后一天
                LocalDate lastDay = tmp.with(TemporalAdjusters.lastDayOfMonth());
                return Quartet.with(LocalDate.now().until(beginDate, ChronoUnit.MONTHS),firstDay,lastDay,statisticalIndexCodeEnum);
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
                return Quartet.with(LocalDate.now().until(beginDate, ChronoUnit.MONTHS),monthBegin,monthEnd,statisticalIndexCodeEnum);
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
                return Quartet.with(LocalDate.now().until(beginDate, ChronoUnit.MONTHS)/2,monthBegin,monthEnd,statisticalIndexCodeEnum);
            }).collect(Collectors.toList());



        }
        if(t == 统计周期编码.H__06_每年){

            return IntStream.rangeClosed(0,Long.valueOf(beginDate.until(endDate, ChronoUnit.MONTHS)).intValue()).mapToObj(i->{
                LocalDate tmp = beginDate.plusMonths(i);

                LocalDate monthBegin = null;
                LocalDate monthEnd = null;
                beginDate.plusYears(1);

                // 该月第一天
                LocalDate firstDay = beginDate.with(TemporalAdjusters.firstDayOfYear());
                // 该月最后一天
                LocalDate lastDay = beginDate.with(TemporalAdjusters.lastDayOfYear());

                return Quartet.with(LocalDate.now().until(beginDate, ChronoUnit.YEARS)/2,firstDay,lastDay,statisticalIndexCodeEnum);
            }).collect(Collectors.toList());



        }

        return null;
    }









    @Autowired
    protected DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;


    @Autowired
    protected DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;
    @Autowired
    protected PB007_机构信息表_Repository pb007_机构信息表_repository;
    @Autowired
    protected PB011_银行信息表Repository pb011_银行信息表Repository;


    @Autowired
    protected DW025_公积金提取审核登记表_Repository dw025_公积金提取审核登记表_repository;

    @Autowired
    protected DP007_个人分户账_Repository dp007_个人分户账_repository;
    @Autowired
    protected DP006_个人缴存信息表_Repository dp006_个人缴存信息表_repository;
    @Autowired
    protected LN014_贷款房屋信息Repository ln014__贷款房屋信息Repository;
    @Autowired
    protected LN008_借款人类型Repository ln008_借款人类型Repository;


    @Autowired
    protected LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    protected DP009_个人明细账_Repository dp009_个人明细账_repository;


    @Autowired
    protected DW145_提取结算登记薄_Repository dw145_提取结算登记薄_repository;


    @Autowired
    protected CM081_sms_短信密码签订登记簿_Repository cm081_sms_短信密码签订登记簿_repository;

    @Autowired
    protected DP004_单位缴存信息表_Repository dp004_unit_payment_info单位缴存信息表Repository;

    @Autowired
    protected DP005_单位分户账_Repository dp005__单位分户账_repository;

    @Autowired
    protected CM001_单位基本资料表Repository cm001单位基本资料表Repository;
    @Autowired
    protected DP008_单位明细账_Repository dp008_单位明细账_repository;

    @Autowired
    protected PB017_公共流水登记簿_Repository public_flowing公共流水登记簿Repository;


    @Autowired
    protected LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    protected LN005_贷款分户信息_Repository ln005_贷款分户信息_repository;




    @Autowired
    protected TR100_转移接续登记簿Repository tr100_转移接续登记簿Repository;

    @Autowired
    protected TR003_转移人账户信息_Repository tr003_转移人账户信息_repository;

    @Autowired
    protected TR002_联系函基础信息_Repository tr002_联系函基础信息_repository;


    @Autowired
    protected ConfigRepository configRepository;



    public static <T> List<List<T>> chopped(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }






    Map<String, DP005_单位分户账> dp005_单位分户账Map = null;
    public Map<String, DP005_单位分户账> dp005_单位分户账MapAll() {


        if(dp005_单位分户账Map == null){

            dp005_单位分户账Map =  dp005__单位分户账_repository.findAll()
                    .stream()
                    .filter(e->e.getUnitacctype_单位账户类型().equals(E_DP005_单位分户账_单位账户类型.普通.getText()))
                    .collect(Collectors.toMap(e -> e.getUnitaccnum单位账号(),e->e));
        }
        return dp005_单位分户账Map;
    }

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
    public Map<String, CM001_单位基本资料表> cm001_单位基本资料表MapAll() {
        if(cm001_单位基本资料表Map == null){

            cm001_单位基本资料表Map =  cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(),e->e));
        }
        return cm001_单位基本资料表Map;
    }

    public Map<String, DP005_单位分户账> dp005_单位分户账Map(List<String> dp) {



        return chopped(dp,1000).stream().map(x->{
            return dp005__单位分户账_repository.findByUnitaccnum单位账号In(x)
                    .stream().collect(Collectors.toList());
        }).flatMap(s -> s.stream()).collect(Collectors.toMap(r -> r.getUnitaccnum单位账号(), r -> r));

/*
        List<MyObject> list = services.stream()
                .flatMap()
                .collect(Collectors.toList());*/


    }


    Map<String, DP007_个人分户账> dp007_个人分户账Map = null;
    public Map<String, DP007_个人分户账> dp007_个人分户账MapAll() {


        if(dp007_个人分户账Map == null){

            dp007_个人分户账Map =  dp007_个人分户账_repository.findAll()
                    .stream()
                    .filter(e->e.getIndiacctype_个人账户类型().equals(E_dp007_个人分户账_类型.E_1_正常.getText()))
                    .collect(Collectors.toMap(e -> e.getAccnum_个人账号(),e->e));
        }
        return dp007_个人分户账Map;
    }



    public Map<String, DP007_个人分户账> dp007_个人分户账Map(List<String> dp) {


        return  dp007_个人分户账_repository.findAll().stream().collect(Collectors.toMap(e->e.getAccnum_个人账号(),a->a));


    }



    public Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map(List<String> dp) {
        //  List<DP005_单位分户账> dp005_单位分户账Map = dp005_workUnit_单位分户账_repository.findByUnitaccnum单位账号In(dp);


        List<DP005_单位分户账> dp005_单位分户账Map = chopped(dp,1000).stream().map(x->{
            return dp005__单位分户账_repository.findByUnitaccnum单位账号In(x)
                    .stream().collect(Collectors.toList());
        }).flatMap(s -> s.stream()).collect(Collectors.toList());

        //    .stream().collect(Collectors.toMap(x -> x.getUnitaccnum单位账号(), x -> x));

        return chopped(dp005_单位分户账Map.stream().map(x -> x.getUnitcustid_单位客户号()).distinct().collect(Collectors.toList()),1000).stream().map(x->{
            return cm001单位基本资料表Repository.findByUnitcustid单位客户号In(x)
                    .stream().collect(Collectors.toList());
        }).flatMap(s -> s.stream()).collect(Collectors.toMap(r -> r.getUnitcustid单位客户号(), r -> r));


    }


    public Map<String, DP004_单位缴存信息表> dp004_单位缴存信息表Map(List<String> dp) {

        return  dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号In(dp)
                .stream().collect(Collectors.toMap(x -> x.getUnitaccnum单位账号(), x -> x));
    }




    public Map<String, List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map(List<String> dp) {

        return              dw025_公积金提取审核登记表_repository.findByUnitaccnum单位账号In(dp)
                .stream().collect(Collectors.groupingBy(x -> x.getUnitaccnum单位账号()));
    }


    public Map<String, List<DP008_单位明细账>> dp008_单位明细账Map(List<String> dp) {


        return dp008_单位明细账_repository.findByUnitaccnum不可为空单位账号In(dp)
                .stream().collect(Collectors.groupingBy(x -> x.getUnitaccnum不可为空单位账号()));

    }

    public Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map(List<String> dp) {
        return dp202_单位缴存变更登记簿_repository.findByUnitaccnum不可为空单位账号In(dp)
                .stream().collect(Collectors.groupingBy(x -> x.getUnitaccnum不可为空单位账号()));

    }


    public Map<String, List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map(List<String> dp) {
        return dp204_个人缴存变更登记簿_repository.findByAccnum不可为空个人账号In(dp)
                .stream().collect(Collectors.groupingBy(x -> x.getAccnum不可为空个人账号()));

    }


    public Map<String, List<DP009_个人明细账>> dp009_个人明细账Map(List<String> dp) {
        List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByAccnum不可为空个人账号In(dp);


        return dp009_个人明细账s.stream().collect(Collectors.groupingBy(e -> e.getAccnum不可为空个人账号()));




    }

    public Map<String, List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map(List<String> dp) {
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByAccnum个人账号In(dp);

        return dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e -> e.getAccnum个人账号()));


    }




    public Map<String, List<LN005_贷款分户信息>> ln005_贷款分户信息Map(List<String> dp) {
        List<LN005_贷款分户信息> dp022_个人缴存登记簿s = ln005_贷款分户信息_repository.findByloancontrcode合同代码In(dp);


        return dp022_个人缴存登记簿s.stream()
                // .filter(e->e.getLoanacctype_贷款分户类型().equals("01"))
                .collect(Collectors.groupingBy(e -> e.getLoancontrcode合同代码()));



    }
    public Map<String, LN005_贷款分户信息> ln005_贷款分户信息MapAll() {
        List<LN005_贷款分户信息> ln005__贷款分户信息s =
                ln005_贷款分户信息_repository.findAll()
                        .stream()
                        .filter(bb->bb.getLoanacctype_贷款分户类型()
                                .equals(E_LN005_贷款分户信息_贷款分户类型.E_01_正常贷款.getText()))
                        .collect(Collectors.toList());

        ln005__贷款分户信息s.stream().collect(Collectors.groupingBy(e->e.getLoancontrcode合同代码())).entrySet().forEach(e->{
            if(e.getValue().size()> 1){
                System.out.println("------------------- 存在  合同号相同的 贷款分帐户（正常贷款");
                System.out.println("------------------- 存在  合同号相同的 贷款分帐户（正常贷款"+e.getValue().toString());
            }
        });
        return ln005__贷款分户信息s.stream().collect(Collectors.toMap(e->e.getLoancontrcode合同代码(), e->e));


    }


//    List<LN005_贷款分户信息> ln005__贷款分户信息s = lN005_贷款分户信息RepositoryLN005.findAll().stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).collect(Collectors.toList());



    public Map<String, LN014_贷款房屋信息> ln014_贷款房屋信息MapAll(List<String> dp) {
        Map<String,LN014_贷款房屋信息> ln014_贷款房屋信息Map =  ln014__贷款房屋信息Repository.findAll().stream().collect(Collectors.toMap(e->e.getLoancontrcode0合同代码(), e->e));

        return ln014_贷款房屋信息Map;


    }

    public Map<String, LN014_贷款房屋信息> ln014_贷款房屋信息Map(List<String> dp) {
        List<LN014_贷款房屋信息> dp022_个人缴存登记簿s = ln014__贷款房屋信息Repository.findByLoancontrcode0合同代码In(dp);
        Map<String,LN014_贷款房屋信息> ln014_贷款房屋信息Map =  ln014__贷款房屋信息Repository.findAll().stream().collect(Collectors.toMap(e->e.getLoancontrcode0合同代码(), e->e));

        return dp022_个人缴存登记簿s.stream().collect(Collectors.toMap(e -> e.getLoancontrcode0合同代码(),e->e));


    }
    public Map<String, List<LN008_借款人信息>> ln008_借款人信息Map(List<String> dp) {
        List<LN008_借款人信息> dp022_个人缴存登记簿s = ln008_借款人类型Repository.findByloancontrcode合同代码In(dp);


        return dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e -> e.getLoancontrcode合同代码()));


    }
    public Map<String, List<LN008_借款人信息>> ln008_借款人信息MapAll(List<String> dp) {

        Map<String,List<LN008_借款人信息>> ln008_借款人信息Map = ln008_借款人类型Repository.findAll().stream().filter(e->e.getLoaneetype_借款人类型().equals(E_LN008_借款人信息_借款人类型.借款人.getText()))
                .collect(Collectors.groupingBy(e->e.getLoancontrcode合同代码()));
        return ln008_借款人信息Map;


    }
    public Map<String, LN003_合同信息> ln003_合同信息Map(List<String> dp) {
        List<LN003_合同信息> dp022_个人缴存登记簿s = ln003_合同信息_repository.findByLoancontrcode合同代码In(dp);

        return dp022_个人缴存登记簿s.stream().collect(Collectors.toMap(e -> e.getLoancontrcode合同代码(),e->e));


    }



    Map<String, PB007_机构信息表> pb007_机构信息表Map = null;
    public Map<String, PB007_机构信息表> pb007_机构信息表Map() {

        if(pb007_机构信息表Map == null){

            pb007_机构信息表Map =  pb007_机构信息表_repository.findAll().stream().collect(Collectors.toMap(e -> e.getInstCode(),e->e));
        }
        return pb007_机构信息表Map;
    }


    Map<String, PB011_银行信息表> pb011_银行信息表Map = null;

    public Map<String, PB011_银行信息表> pb011_银行信息表Map() {

        if(pb011_银行信息表Map == null){

            pb011_银行信息表Map =  pb011_银行信息表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getBankcode(),e->e));
        }
        return pb011_银行信息表Map;
    }

    Map<String, PB008_柜员信息表> pb008_柜员信息表Map = null;

    public Map<String, PB008_柜员信息表> pb008_柜员信息表Map() {

        if(pb008_柜员信息表Map == null){

            pb008_柜员信息表Map =  pb008_柜员信息表_repository.findAll().stream().collect(Collectors.toMap(e -> e.getOpcode().trim(),e->e));
        }
        return pb008_柜员信息表Map;
    }




    Map<String, Config> configMap = null;
    public Map<String, Config> configMap() {

        if(configMap == null){

            configMap =  configRepository.findAll().stream().collect(Collectors.toMap(e -> e.getName(),e->e));
        }
        return configMap;
    }

    @Transactional
    public void updateRateTable(AnalysisTable rateAnalysisTable, AnalysisStream rateAnalysisStream) {
        rateAnalysisStream.setIndexNo(rateAnalysisTable.getTargetNo());
        analysisStreamRepository.save(rateAnalysisStream);

        rateAnalysisTable.setUpdateTime(LocalDateTime.now());
        analysisTableRepository.save(rateAnalysisTable);

    }



    @Transactional
    protected void delete(String targetNo) {
        analysisTableRepository.deleteByTargetNo(targetNo);
    }
}
