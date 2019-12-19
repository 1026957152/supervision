package org.ylgjj.loan.service;


import org.apache.commons.lang3.time.DateUtils;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.DW025_公积金提取审核登记表;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.history.ZYCommonHistoryerviceImpl;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.util.个人Utils;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.ValueRange;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.*;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("B提取ServiceImpl")
public class B提取ServiceImpl {


    @Autowired
    private CM002_个人基本资料表Repository cm002个人基本资料表Repository;


    @Autowired
    private LN008_借款人类型Repository lN008_借款人类型Repository;

    @Autowired
    private LN014_贷款房屋信息Repository ln014__贷款房屋信息Repository;
    @Autowired
    private LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;




    @Autowired
    private DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;


    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private DW025_公积金提取审核登记表_Repository dW025_公积金提取审核登记表_Repository;

    @Autowired
    private DP007_个人分户账_Repository dp007_individual_sub_account个人分户账Repository;
    @Autowired
    private DP006_个人缴存信息表_Repository dp006__个人缴存信息表_repository;


    @Autowired
    private LoanHistoryRepository yourHistoryRepository;


    @Autowired
    private LN005_贷款分户信息_Repository lN005_贷款分户信息RepositoryLN005;
    @Autowired
    private DW145_提取结算登记薄_Repository dw145_提取结算登记薄_repository;



    @Autowired
    private CM081_sms_短信密码签订登记簿_Repository cm081_sms_短信密码签订登记簿_repository;

    @Autowired
    private DP004_单位缴存信息表_Repository dp004_unit_payment_info单位缴存信息表Repository;

    @Autowired
    private DP005_单位分户账_Repository dp005__单位分户账_repository;

    @Autowired
    private CM001_单位基本资料表Repository cm001单位基本资料表Repository;
    @Autowired
    private DP008_单位明细账_Repository dp008__单位明细账_repository;
    @Autowired
    private DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;
    @Autowired
    private PB017_public_flowing公共流水登记簿Repository public_flowing公共流水登记簿Repository;


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;
    @Autowired
    private ZYCommonHistoryerviceImpl zyCommonHistoryervice;


    //TODO 提取金额，提取原因，提取人账户号，提取人单位号，提取人机构号，提取人身份证号
    public Triplet 当日情况_提取_动作(String unitnum, LocalDate 日期) {

        long count = dp202_单位缴存变更登记簿_repository.count();
        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+count);

        List<DW025_公积金提取审核登记表> dp021_单位缴存登记薄s = dW025_公积金提取审核登记表_Repository.findByTransdate交易日期(日期);
        Optional<DW025_公积金提取审核登记表> dp202_单位缴存变更登记簿 = dp021_单位缴存登记薄s.stream().filter(e->e.getTransdate交易日期().isBefore(日期.plusDays(1))).findFirst();


/*        if(dp202_单位缴存变更登记簿.isPresent()){
            return dp202_单位缴存变更登记簿.get().getFinchgnum_不可为空_财政变更人数();
        }*/
        Triplet<List<String>,Double,Integer> aa = new Triplet<List<String>,Double,Integer>(null,1d,1);







        return aa;
    }


    // TODO ??? S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203
    public Output S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203.name();
        个人Utils.非本市缴存职工("");


/*        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__06_每年;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_开户年限_HX_EX.values()).forEach(e->{
        });
        return null;
    }
    // TODO S_20_SEQ_提取金额__收入水平___AND_0301003204
    public Output S_20_SEQ_提取金额__收入水平___AND_0301003204(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_20_SEQ_提取金额__收入水平___AND_0301003204.name();
        个人Utils.非本市缴存职工("");


/*        指标分类编码.H_25_收入水平分析;
        统计周期编码.H__01_每日;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });

        Arrays.stream(E_住建部编码_收入水平.values()).forEach(e->{

        });

        return null;
    }



    // TODO S_23_SEQ_提取金额__非本市缴存职工___AND_0301003207
    public Output S_23_SEQ_提取金额__非本市缴存职工___AND_0301003207(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_23_SEQ_提取金额__非本市缴存职工___AND_0301003207.name();
        dW025_公积金提取审核登记表_Repository.findAll();
        个人Utils.非本市缴存职工("");

/*        指标分类编码.H_04_提取分析;
        统计周期编码.H__01_每日;*/
        //  SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });

        return null;
    }




    // TODO S_24_SEQ_提取人次__收入水平___AND_0301003208
    public Output S_24_SEQ_提取人次__收入水平___AND_0301003208(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_24_SEQ_提取人次__收入水平___AND_0301003208.name();
        dW025_公积金提取审核登记表_Repository.findAll();


/*        指标分类编码.H_25_收入水平分析;
        统计周期编码.H__03_每月;*/
       // SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });


        // TODO 每类型多少个人
        Arrays.stream(E_住建部编码_收入水平.values()).forEach(e->{

        });
        return null;
    }




    // TODO S_36_SEQ_提取人数_AND_0301003901
    public Output S_36_SEQ_提取人数_AND_0301003901(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_36_SEQ_提取人数_AND_0301003901.name();
        dW025_公积金提取审核登记表_Repository.findAll();
/*        统计周期编码.H__03_每月;

        // TODO 每类型多少个人

        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;*/
        // SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });

        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    public static List<LocalDate> getDatesBetweenUsingJava8(
            LocalDate startDate, LocalDate endDate) {

        //先週の月曜日から土曜日までの１週間分をStringのリストで取得
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        ZonedDateTime monday =
                ZonedDateTime.now().minusWeeks(1).with(MONDAY);

        List<String> dates =
                IntStream.range(0,7)
                        .mapToObj(i -> monday.plusDays(i).format(datePattern))
                                .collect(Collectors.toList());

//指定した月の１日から月末までの日付けをStringリストで取得//ZonedDateはない
        LocalDate dec = LocalDate.parse("2014/12/01",datePattern);
        List<String> dates__ =
                IntStream.range(0, dec.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth())
                        .mapToObj(i -> dec.plusDays(i).format(datePattern))
                        .collect(Collectors.toList());//2015/12/01　〜 2015/12/31












        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // TODO S_37_SEQ_提取人数__提取原因___AND_0301003911
    public Output S_37_SEQ_提取人数__提取原因___AND_0301003911(String dimension1, String dimension2, String dimension3, 统计周期编码 period, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {

        LocalDate ldt_ksrq = LocalDate.parse(ksrq,df);
        LocalDate ldt_jsrq = LocalDate.parse(ksrq,df);


        if(period.equals(统计周期编码.H__01_每日)) {
            long count = ldt_ksrq.until(ldt_jsrq,ChronoUnit.DAYS);
            List<LocalDate> dates =
                    IntStream.range(0, Long.valueOf(count).intValue())
                            .mapToObj(i -> ldt_ksrq.plusDays(i))
                            .collect(Collectors.toList());//2015/12/01　〜 2015/12/31

        }





        if(period.equals(统计周期编码.H__03_每月)) {
            long count = ldt_ksrq.until(ldt_jsrq,ChronoUnit.MONTHS);
            List<Pair<LocalDate,LocalDate>> dates =
                    IntStream.range(0, Long.valueOf(count).intValue())
                            .mapToObj(i -> {
                                LocalDate now = ldt_ksrq.plusMonths(i);
                                LocalDate monthBegin = LocalDate.now().withDayOfMonth(1);
                                LocalDate monthEnd = LocalDate.now().plusMonths(1).withDayOfMonth(1).minusDays(1);
                                return Pair.with(monthBegin,monthEnd);
                            } )
                            .collect(Collectors.toList());//2015/12/01　〜 2015/12/31

        }


        if(period.equals(统计周期编码.H__06_每年)) {
            long count = ldt_ksrq.until(ldt_jsrq,ChronoUnit.YEARS);
            List<LocalDate> dates =
                    IntStream.range(0, Long.valueOf(count).intValue())
                            .mapToObj(i -> ldt_ksrq.plusMonths(i))
                            .collect(Collectors.toList());//2015/12/01　〜 2015/12/31

            LocalDate now = LocalDate.now(); // 2015-11-23
            LocalDate firstDay = now.with(firstDayOfYear()); // 2015-01-01
            LocalDate lastDay = now.with(lastDayOfYear()); // 2015-12-31
        }


        if(period.equals(统计周期编码.H__04_每季)) {
            long count = ldt_ksrq.until(ldt_jsrq,ChronoUnit.MONTHS);
            List<LocalDate> dates =
                    IntStream.range(0, Long.valueOf(count/3).intValue())
                            .mapToObj(i -> ldt_ksrq.plusMonths(i*3))
                            .collect(Collectors.toList());//2015/12/01　〜 2015/12/31
        }

        if(period.equals(统计周期编码.H__02_每周)) {
            long count = ldt_ksrq.until(ldt_jsrq,ChronoUnit.WEEKS);
            List<LocalDate> dates =
                    IntStream.range(0, Long.valueOf(count).intValue())
                            .mapToObj(i -> ldt_ksrq.plusWeeks(i))
                            .collect(Collectors.toList());//2015/12/01　〜 2015/12/31
            LocalDate today = LocalDate.now(); // 2015-11-23

            LocalDate monday = today.with(previousOrSame(MONDAY));
            LocalDate sunday = today.with(nextOrSame(SUNDAY));
        }



/*                List<String> dates =
                IntStream.range(0, dec.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth())
                        .mapToObj(i -> dec.plusDays(i).format(datePattern))
                        .collect(Collectors.toList());//2015/12/01　〜 2015/12/31

        */



        if(period.equals(统计周期编码.H__01_每日)){

            ValueRange r = ldt_ksrq.range(ChronoField.MONTH_OF_YEAR);



            DateUtils.ceiling(ldt_ksrq, Calendar.DAY_OF_MONTH);

            Date ceiling_ldt_jsrq = DateUtils.ceiling(java.sql.Date.valueOf(ldt_jsrq), Calendar.DAY_OF_MONTH);


        }
        String name = StatisticalIndexCodeEnum.S_37_SEQ_提取人数__提取原因___AND_0301003911.get指标编码();



        List<LoanHistory> loanHistories = yourHistoryRepository.findByIndexNo(name);


        Map<String,List<LoanHistory>> a = loanHistories.stream().collect(Collectors.groupingBy(e->e.getIndex机构编码()));

/*            Streams.mapWithIndex(studentList.stream(),(t, index)->{
                System.out.println(t.getName());
                System.out.println(index);
                return t.getName();
            }).count();*/

/*        统计周期编码.H__03_每月;

        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
         SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });

        Arrays.stream(E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()).forEach(e->{
        });


        List<Map> mmmm = new ArrayList<>();
        a.entrySet().stream().map(e->{


            return e.getValue().stream().collect(Collectors.groupingBy(g->g.getIndex提取原因())).entrySet().stream().map(h->{


                Map maps = new LinkedHashMap();
                maps.put("target",name);
                maps.put("dimension1",e.getKey());
                maps.put("dimension2",h.getKey());

/*                for(int i= 0 ; i< h.getValue().size(); i++){
                    maps.put("value"+i,h.getValue().get(i).getValue贷款笔数()+"="+h.getValue().get(i).getDate());

                }*/
                List<Triplet<Integer,LocalDate,LocalDate>> rangDates = null;
                if(period.equals(统计周期编码.H__03_每月)) {
                    long count = ldt_ksrq.until(ldt_jsrq,ChronoUnit.MONTHS);
                    rangDates =
                            IntStream.range(0, Long.valueOf(count).intValue()+1)
                                    .mapToObj(i -> {
                                        System.out.println("------------rangDates--i-----i----i--"+i);
                                        LocalDate now = ldt_ksrq.plusMonths(i);
                                        LocalDate monthBegin = now.withDayOfMonth(1);
                                        LocalDate monthEnd = now.plusMonths(1).withDayOfMonth(1).minusDays(1);
                                        return Triplet.with(i,monthBegin,monthEnd);
                                    } )
                                    .collect(Collectors.toList());//2015/12/01　〜 2015/12/31

                }


                System.out.println("------------rangDates-------------"+rangDates.toString());
                List<Triplet<Integer,LocalDate, LocalDate>> finalRangDates = rangDates;
                Map<Triplet<Integer,LocalDate, LocalDate>,List<LoanHistory>> historyMap =  h.getValue().stream().collect(Collectors.groupingBy(j->{

                    for(Triplet<Integer,LocalDate, LocalDate> localDatePair :finalRangDates){
                        if((j.getDate().isAfter(localDatePair.getValue1()) && j.getDate().isBefore(localDatePair.getValue2()) )
                                || j.getDate().isEqual(localDatePair.getValue1()) || j.getDate().isEqual(localDatePair.getValue2()) )
                            return localDatePair;
                    }
                    return null;

                    }));


                historyMap.entrySet().forEach(mappp->{

                    maps.put("value"+mappp.getKey().getValue0(),mappp.getValue().stream().map(ll->ll.getId()+"-"+ll.getDate()).collect(Collectors.toList()));
                });





              /*  IntStream.range(0, h.getValue().size())
                        .forEach(i -> {

                            LoanHistory loanHistory = h.getValue().get(i);
                            maps.put("value"+i,loanHistory.getId() + "-" +loanHistory.getValue贷款笔数()+"="
                                    +loanHistory.getDate());

                        });
*/
                return maps;

            }).collect(Collectors.toList());





        }).collect(Collectors.toList()).forEach(e->{
            mmmm.addAll(e);
        });

        Output output = new Output();
        output.setData(mmmm);
        output.setSuccess(true);
        return output;
    }
    // TODO S_38_SEQ_提取人次_AND_0301004001
    public Output S_38_SEQ_提取人次_AND_0301004001(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_38_SEQ_提取人次_AND_0301004001.name();
        dW025_公积金提取审核登记表_Repository.findAll();
/*        统计周期编码.H__03_每月;

        // TODO 每类型多少个人

        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;//
    }

    // TODO S_39_SEQ_提取人次__提取原因___AND_0301004011
    public Output S_39_SEQ_提取人次__提取原因___AND_0301004011(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_39_SEQ_提取人次__提取原因___AND_0301004011.name();
        dW025_公积金提取审核登记表_Repository.findAll();
       // 统计周期编码.H__03_每月;

        // TODO 每类型多少个人
        Arrays.stream(E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()).forEach(e->{
        });
        return null;
    }



    // TODO S_53_SEQ_提取本金_AND_0301007601
    public Output S_53_SEQ_提取本金_AND_0301007601(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_53_SEQ_提取本金_AND_0301007601.name();
        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人
        E_DP021_单位缴存登记簿_缴存类型 E = E_DP021_单位缴存登记簿_缴存类型.正常全额补缴;
        E = E_DP021_单位缴存登记簿_缴存类型.正常全额补缴;
        E = E_DP021_单位缴存登记簿_缴存类型.不定额补缴;



/*        指标分类编码.H_04_提取分析;

        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;//
    }

    // TODO
    public Output S_54_SEQ_提取本金__跨中心转出___AND_0301007602(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_54_SEQ_提取本金__跨中心转出___AND_0301007602.name();
        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人

/*        E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.异地单位转移;
        E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.异地贷款提取;
        E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.异地转移;


        指标分类编码.H_04_提取分析;

        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;//
    }


    // TODO
    public Output S_55_SEQ_提取本金__提取原因___AND_0301007611(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_55_SEQ_提取本金__提取原因___AND_0301007611.name();
        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人



       // 指标分类编码.H_04_提取分析;
       // SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()).forEach(e->{
        });
        return null;//
    }


    // TODO
    public Output S_56_SEQ_提取利息_AND_0301007701(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_56_SEQ_提取利息_AND_0301007701.name();
        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人

/*        指标分类编码.H_04_提取分析;

        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;//
    }

    // TODO
    public Output S_57_SEQ_提取利息__提取原因___AND_0301007711(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_57_SEQ_提取利息__提取原因___AND_0301007711.name();
        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人


/*        指标分类编码.H_04_提取分析;

        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()).forEach(e->{
        });

        return null;//
    }


    // TODO
    public Output S_58_SEQ_外部转入金额_AND_0301007801(String dimension1, String dimension2, String dimension3, 统计周期编码 period, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {



        String name = StatisticalIndexCodeEnum.S_58_SEQ_外部转入金额_AND_0301007801.name();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人





    //
/*
        指标分类编码.H_03_汇补缴分析;
        SY_项目单位.H_01_元_金额价格;
*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });






        LocalDate ldt_ksrq = LocalDate.parse(ksrq,df);
        LocalDate ldt_jsrq = LocalDate.parse(jsrq,df);




        System.out.println("------------------------- index no index "+ valueOf1.get指标编码()+ldt_ksrq+ "__"+ldt_jsrq);

        List<LoanHistory> histories = loanHistoryRepository.findByIndexNoAndDateBetween(valueOf1.get指标编码(),ldt_ksrq,ldt_jsrq);

        System.out.println("------------------------- index no index "+ histories);

        Map<String,List<LoanHistory>> a = histories.stream().collect(Collectors.groupingBy(e->e.getIndex机构编码()));

/*            Streams.mapWithIndex(studentList.stream(),(t, index)->{
                System.out.println(t.getName());
                System.out.println(index);
                return t.getName();
            }).count();*/

/*        统计周期编码.H__03_每月;

        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
         SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });

        Arrays.stream(E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()).forEach(e->{
        });


        List<Map> mmmm = new ArrayList<>();
        a.entrySet().stream().map(e->{


            return e.getValue().stream().collect(Collectors.groupingBy(g->g.getIndex经济类型())).entrySet().stream().map(h->{


                Map maps = new LinkedHashMap();
                maps.put("target",name);
                maps.put("dimension1",e.getKey());
                maps.put("dimension2",h.getKey());

/*                for(int i= 0 ; i< h.getValue().size(); i++){
                    maps.put("value"+i,h.getValue().get(i).getValue贷款笔数()+"="+h.getValue().get(i).getDate());

                }*/
                List<Triplet<Integer,LocalDate,LocalDate>> rangDates = null;
                if(period.equals(统计周期编码.H__03_每月)) {
                    long count = ldt_ksrq.until(ldt_jsrq,ChronoUnit.MONTHS);
                    rangDates =
                            IntStream.range(0, Long.valueOf(count).intValue()+1)
                                    .mapToObj(i -> {
                                        System.out.println("------------rangDates--i-----i----i--"+i);
                                        LocalDate now = ldt_ksrq.plusMonths(i);
                                        LocalDate monthBegin = now.withDayOfMonth(1);
                                        LocalDate monthEnd = now.plusMonths(1).withDayOfMonth(1).minusDays(1);
                                        return Triplet.with(i,monthBegin,monthEnd);
                                    } )
                                    .collect(Collectors.toList());//2015/12/01　〜 2015/12/31

                }


                System.out.println("------------rangDates-------------"+rangDates.toString());
                List<Triplet<Integer,LocalDate, LocalDate>> finalRangDates = rangDates;
                Map<Triplet<Integer,LocalDate, LocalDate>,List<LoanHistory>> historyMap =  h.getValue().stream().collect(Collectors.groupingBy(j->{

                    for(Triplet<Integer,LocalDate, LocalDate> localDatePair :finalRangDates){
                        if((j.getDate().isAfter(localDatePair.getValue1()) && j.getDate().isBefore(localDatePair.getValue2()) )
                                || j.getDate().isEqual(localDatePair.getValue1()) || j.getDate().isEqual(localDatePair.getValue2()) )
                            return localDatePair;
                    }
                    return null;

                }));


                historyMap.entrySet().forEach(mappp->{

                    maps.put("value"+mappp.getKey().getValue0(),mappp.getValue().stream().map(ll->ll.getId()+"-"+ll.getDate()).collect(Collectors.toList()));
                });





              /*  IntStream.range(0, h.getValue().size())
                        .forEach(i -> {

                            LoanHistory loanHistory = h.getValue().get(i);
                            maps.put("value"+i,loanHistory.getId() + "-" +loanHistory.getValue贷款笔数()+"="
                                    +loanHistory.getDate());

                        });
*/
                return maps;

            }).collect(Collectors.toList());





        }).collect(Collectors.toList()).forEach(e->{
            mmmm.addAll(e);
        });

        Output output = new Output();
        output.setData(mmmm);
        output.setSuccess(true);
        return output;

    }

    // TODO ？？？
    public Output S_59_SEQ_外部转出金额__本金___AND_0301007901(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_59_SEQ_外部转出金额__本金___AND_0301007901.name();
        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人

/*        指标分类编码.H_04_提取分析;
        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return   zyCommonHistoryervice.commom(dimension1,dimension2,dimension3,valueOf,valueOf1,ksrq,jsrq);

    }


    // TODO
    public Output S_60_SEQ_外部转出金额__利息___AND_0301007902(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_60_SEQ_外部转出金额__利息___AND_0301007902.name();
        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人

/*
        指标分类编码.H_04_提取分析;

        SY_项目单位.H_01_元_金额价格;
*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return   zyCommonHistoryervice.commom(dimension1,dimension2,dimension3,valueOf,valueOf1,ksrq,jsrq);

    }





    // TODO
    public Output S_65_SEQ_归集余额_AND_0301008101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_65_SEQ_归集余额_AND_0301008101.name();
        dp006__个人缴存信息表_repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人


/*        指标分类编码.H_03_汇补缴分析;

        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }




    // TODO
    public Output S_71_SEQ_历史累计提取额_AND_0301010701(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_71_SEQ_历史累计提取额_AND_0301010701.name();
        dp006__个人缴存信息表_repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人


       // 指标分类编码.H_05_历史累计分析;
        //SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_72_SEQ_历史累计提取额__提取原因___AND_0301010711
    public Output S_72_SEQ_历史累计提取额__提取原因___AND_0301010711(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_72_SEQ_历史累计提取额__提取原因___AND_0301010711.name();
        dp006__个人缴存信息表_repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人


        //指标分类编码.H_05_历史累计分析;
        //SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()).forEach(e->{
        });
        return null;
    }





    // TODO S_75_SEQ_历史累计提取人数_AND_0301011001
    public Output S_75_SEQ_历史累计提取人数_AND_0301011001(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_75_SEQ_历史累计提取人数_AND_0301011001.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        // TODO 每类型多少个人

       // 指标分类编码.H_05_历史累计分析;
      //  SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO S_76_SEQ_历史累计提取人数__提取原因___AND_0301011002
    public Output S_76_SEQ_历史累计提取人数__提取原因___AND_0301011002(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_76_SEQ_历史累计提取人数__提取原因___AND_0301011002.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        // TODO 每类型多少个人

     //   指标分类编码.H_05_历史累计分析;
     //   SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()).forEach(e->{
        });

        return null;
    }



}
