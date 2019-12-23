package org.ylgjj.loan.history_flow;


import org.javatuples.Quartet;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.domain_flow.LoanHistory;
import org.ylgjj.loan.outputenum.E_TABLE_HX;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.repository_flow.YourHistoryRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("DP021_单位缴存登记簿_Flow_HistoryerviceImpl")
public class DP021_单位缴存登记簿_Flow_HistoryerviceImpl {


    @Autowired
    private CM002_个人基本资料表Repository cm002个人基本资料表Repository;
    @Autowired
    private DP034_公积金开销户登记簿_Repository dp034_公积金开销户登记簿_repository;


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
    private DW025_公积金提取审核登记表_Repository dW025__公积金提取审核登记表_Repository;

    @Autowired
    private DP007_个人分户账_Repository dp007_individual_sub_account个人分户账Repository;
    @Autowired
    private DP006_个人缴存信息表_Repository dp006__个人缴存信息表_repository;


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private DP009_个人明细账_Repository dp009_个人明细账_repository;


    @Autowired
    private DP204_个人缴存变更登记簿_Repository dp204_个人缴存变更登记簿_repository;
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
    private PB017_公共流水登记簿_Repository public_flowing公共流水登记簿Repository;


    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    private LN005_贷款分户信息_Repository lN005_贷款分户信息RepositoryLN005;


    @Autowired
    private YourHistoryRepository yourHistoryRepository;


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;



    @Autowired
    private TR100_转移接续登记簿Repository tr100_转移接续登记簿Repository;

    @Autowired
    private TR003_转移人账户信息_Repository tr003_转移人账户信息_repository;

    @Autowired
    private TR002_联系函基础信息_Repository tr002_联系函基础信息_repository;





    boolean initComplte = false;
    List<DP004_单位缴存信息表> dp004__单位缴存信息表s = null;
    Map<String, DP004_单位缴存信息表> dp004_unit_payment_info_单位缴存信息表Map = null;

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
    Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;
    Map<String, List<LN008_借款人信息>> ln008_borrower_info_借款人信息Map = null;




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


    //
    public void test() {

        List<Triplet<Long,LocalDate,LocalDate>> t = run统计周期编码( LocalDate.now().minusDays(3),LocalDate.now(),StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);

        System.out.println( t+"dddddddddddddddddd");
    }


   //
    public void run_() {

       流水_单位缴存spanTimeSpan( LocalDate.now().minusDays(2),LocalDate.now());

    }


    Map<String,List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map = null;
    Map<String,List<DP008_institution_detail_单位明细账>> dp008_institution_detail_单位明细账Map = null;
    Map<String,List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map = null;
    Map<String,List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map = null;

    Map<String,List<DP009_个人明细账>> dp009_个人明细账Map = null;
    Map<String,List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map = null;


    public void 流水_单位缴存spanTimeSpan(LocalDate beginDateTotal, LocalDate endDateTotal) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期Between(beginDateTotal.minusDays(1),endDateTotal.plusDays(1));
        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = dp021_单位缴存登记簿s.stream().map(e->e.getUnitaccnum单位账号()).collect(Collectors.toList());
        dp021_单位缴存登记簿s.forEach(e->{
            System.out.println("登记日期 "+e.getRegdate不可为空登记日期());
        });

        List<E_TABLE_HX> maps = new ArrayList();

        maps.add(E_TABLE_HX.CM001_单位基本资料表);
        maps.add(E_TABLE_HX.dp005_单位分户账Map);
/*        maps.add(E_TABLE_HX.dw025_公积金提取审核登记表Map);
        maps.add(E_TABLE_HX.dp008_单位明细账Map);
        maps.add(E_TABLE_HX.dp202_单位缴存变更登记簿Map);*/
        maps.add(E_TABLE_HX.DP204_个人缴存变更登记簿);
        maps.add(E_TABLE_HX.DP009_个人明细账);
        maps.add(E_TABLE_HX.DP022_个人缴存登记簿);


        if(maps.contains(E_TABLE_HX.dp005_单位分户账Map)){
            dp005_work_unit_单位分户账Map = dp005__单位分户账_repository.findByUnitaccnum单位账号In(dp)
                    .stream().collect(Collectors.toMap(x->x.getUnitaccnum单位账号(),x->x));

        }
        if(maps.contains(E_TABLE_HX.CM001_单位基本资料表)){
            cm001_单位基本资料表Map = cm001单位基本资料表Repository
                    .findByUnitcustid单位客户号In(dp005_work_unit_单位分户账Map.values().stream().map(x->x.getUnitcustid_单位客户号()).collect(Collectors.toList()))
                    .stream().collect(Collectors.toMap(f->f.getUnitcustid单位客户号(),x->x));
        }




        System.out.println("--------------------"+ dp);



        maps.add(E_TABLE_HX.dp004_单位缴存信息表Map);
        if(maps.contains(E_TABLE_HX.dp004_单位缴存信息表Map)){
            dp004_unit_payment_info_单位缴存信息表Map = dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号In(dp)
                    .stream().collect(Collectors.toMap(x->x.getUnitaccnum单位账号(),x->x));
        }



        if(maps.contains(E_TABLE_HX.dw025_公积金提取审核登记表Map)){
            dw025_公积金提取审核登记表Map =
                    dW025__公积金提取审核登记表_Repository.findByUnitaccnum单位账号In(dp)
                            .stream().collect(Collectors.groupingBy(x->x.getUnitaccnum单位账号()));
        }



        if(maps.contains(E_TABLE_HX.dp008_单位明细账Map)){
/*            dp008_institution_detail_单位明细账Map =
                    dp008__单位明细账_repository.findByUnitaccnum单位账号In(dp)
                            .stream().collect(Collectors.groupingBy(x->x.getU()));*/
        }


        if(maps.contains(E_TABLE_HX.dp202_单位缴存变更登记簿Map)){
            dp202_单位缴存变更登记簿Map = dp202_单位缴存变更登记簿_repository.findByUnitaccnum不可为空单位账号In(dp)
                    .stream().collect(Collectors.groupingBy(x->x.getUnitaccnum不可为空单位账号()));
        }

        if(maps.contains(E_TABLE_HX.DP204_个人缴存变更登记簿)){
            dp204_个人缴存变更登记簿Map = dp204_个人缴存变更登记簿_repository.findByAccnum不可为空个人账号In(dp)
                    .stream().collect(Collectors.groupingBy(x->x.getAccnum不可为空个人账号()));
        }





        if(maps.contains(E_TABLE_HX.DP009_个人明细账)){

            List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByAccnum不可为空个人账号In(dp);


            dp009_个人明细账Map= dp009_个人明细账s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));

        }



        if(maps.contains(E_TABLE_HX.DP022_个人缴存登记簿)){
            List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByAccnum个人账号In(dp);

            dp022_个人缴存登记簿Map
                    = dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum个人账号()));

        }










        //StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102



/*

        List<Triplet<Long,LocalDate,LocalDate>> triplets =
                run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp021_单位缴存登记簿s



                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate) ||
                            x.getInaccdate不可为空入账日期().equals(beginDate) || x.getInaccdate不可为空入账日期().equals(endDate) )


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_work_unit_单位分户账 dp005_work_unit_单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());
                CM001_单位基本资料表 cm001_单位基本资料表 = cm001_单位基本资料表Map.get(dp005_work_unit_单位分户账.getUnitcustid_单位客户号());
                ;


                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_work_unit_单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);

                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                    loanHistory.setSeqNum(t.getValue0()); // 银行名称

                    loanHistory.setDoubleValue(o.getValue().stream()
                            // .filter(w->w.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            //   .filter(w->w.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))

                            .mapToDouble(d->{

                                return d.getValue0().getFactpayamt_实际缴款金额().doubleValue() - d.getValue0().getUprepayamt_预缴户转出金额().doubleValue();


                            }).sum()
                    );
                    loanHistoryRepository.save(loanHistory);

                });


            });

        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201);
        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp021_单位缴存登记簿s

                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_work_unit_单位分户账 dp005_work_unit_单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());
                CM001_单位基本资料表 cm001_单位基本资料表 = cm001_单位基本资料表Map.get(dp005_work_unit_单位分户账.getUnitcustid_单位客户号());
                ;

                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_work_unit_单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    // S_2_SEQ_实缴单位数_AND_0301000201("0301","0301000201","实缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    //      S_3_SEQ_实缴单位数__按年___AND_0301000202("0301","0301000202","实缴单位数(按年)"," ","01","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),

                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201);
                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                    loanHistory.setIntValue(o.getValue().stream()
                            .filter(x->x.getValue0().getInaccdate不可为空入账日期().isAfter(beginDate) && x.getValue0().getInaccdate不可为空入账日期().isBefore(endDate))
                           .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                                .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    loanHistoryRepository.save(loanHistory);
                });
            });

        });

        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_3_SEQ_实缴单位数__按年___AND_0301000202);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_work_unit_单位分户账 dp005_work_unit_单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                CM001_单位基本资料表 cm001_单位基本资料表 = cm001_单位基本资料表Map.get(dp005_work_unit_单位分户账.getUnitcustid_单位客户号());


                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_work_unit_单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {



                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_3_SEQ_实缴单位数__按年___AND_0301000202);
                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                    loanHistory.setIntValue(o.getValue().stream()
                            .filter(x->x.getValue0().getInaccdate不可为空入账日期().isAfter(beginDate) && x.getValue0().getInaccdate不可为空入账日期().isBefore(endDate))

                            //   .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            //   .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    loanHistoryRepository.save(loanHistory);


















                    //   S_66_SEQ_暂存款余额_AND_0301008102("0301","0301008102","暂存款余额"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),


                    // S_11_SEQ_缴暂存款净额_AND_0301001001("0301","0301001001","缴暂存款净额"," ","03","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1"," ",false),

                    //S_1_SEQ_暂存款笔数_AND_0301000101("0301","0301000101","暂存款笔数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","04",true),


                    loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101);


                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setIntValue(o.getValue().stream()

                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    loanHistoryRepository.save(loanHistory);



                    loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_11_SEQ_缴暂存款净额_AND_0301001001);


                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setDoubleValue(o.getValue().stream()

                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            .mapToDouble(x->{
                                if(x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText())){
                                    return x.getValue0().getUpaytotamt_应缴总额().doubleValue();
                                }else{
                                    return -x.getValue0().getUprepayamt_预缴户转出金额().doubleValue();
                                }

                            }).sum()
                    );  //
                    loanHistoryRepository.save(loanHistory);
                });


            });







        });
*/


        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_单位分户账 dp005_单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());

                CM001_单位基本资料表 cm001_单位基本资料表 = cm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());


                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {




                    //   S_66_SEQ_暂存款余额_AND_0301008102("0301","0301008102","暂存款余额"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),


                    // S_11_SEQ_缴暂存款净额_AND_0301001001("0301","0301001001","缴暂存款净额"," ","03","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1"," ",false),

                    //S_1_SEQ_暂存款笔数_AND_0301000101("0301","0301000101","暂存款笔数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","04",true),


                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101);


                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setIntValue(o.getValue().stream()

                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    loanHistoryRepository.save(loanHistory);



                    loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_11_SEQ_缴暂存款净额_AND_0301001001);


                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setDoubleValue(o.getValue().stream()

                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            .mapToDouble(x->{
                                if(x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText())){
                                    return x.getValue0().getUpaytotamt_应缴总额().doubleValue();
                                }else{
                                    return -x.getValue0().getUprepayamt_预缴户转出金额().doubleValue();
                                }

                            }).sum()
                    );  //
                    loanHistoryRepository.save(loanHistory);
                });


            });







        });



        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_11_SEQ_缴暂存款净额_AND_0301001001);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                CM001_单位基本资料表 cm001_单位基本资料表 = cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号());


                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005__单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {





                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_11_SEQ_缴暂存款净额_AND_0301001001);


                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setDoubleValue(o.getValue().stream()

                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            .mapToDouble(x->{
                                if(x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText())){
                                    return x.getValue0().getUpaytotamt_应缴总额().doubleValue();
                                }else{
                                    return -x.getValue0().getUprepayamt_预缴户转出金额().doubleValue();
                                }

                            }).sum()
                    );  //
                    loanHistoryRepository.save(loanHistory);
                });


            });







        });





        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();




            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;


                DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                return Triplet.with(e,
                        cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                        dp005__单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    // S_2_SEQ_实缴单位数_AND_0301000201("0301","0301000201","实缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    //      S_3_SEQ_实缴单位数__按年___AND_0301000202("0301","0301000202","实缴单位数(按年)"," ","01","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),

                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201);


                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setIntValue(o.getValue().stream()

                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    loanHistoryRepository.save(loanHistory);


                });


            });




        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_3_SEQ_实缴单位数__按年___AND_0301000202);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();




            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;


                DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                return Triplet.with(e,
                        cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                        dp005__单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    // S_2_SEQ_实缴单位数_AND_0301000201("0301","0301000201","实缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    //      S_3_SEQ_实缴单位数__按年___AND_0301000202("0301","0301000202","实缴单位数(按年)"," ","01","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),


                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_3_SEQ_实缴单位数__按年___AND_0301000202);


                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setIntValue(o.getValue().stream()

                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    loanHistoryRepository.save(loanHistory);


                });


            });




        });

        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_11_SEQ_缴暂存款净额_AND_0301001001);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();




            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;


                DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                return Triplet.with(e,
                        cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                        dp005__单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    // S_2_SEQ_实缴单位数_AND_0301000201("0301","0301000201","实缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    //      S_3_SEQ_实缴单位数__按年___AND_0301000202("0301","0301000202","实缴单位数(按年)"," ","01","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),


                    LoanHistory loanHistory  =  new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_11_SEQ_缴暂存款净额_AND_0301001001);


                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setDoubleValue(o.getValue().stream()

                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            .mapToDouble(x->{
                                if(x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText())){
                                    return x.getValue0().getFactpayamt_实际缴款金额().doubleValue();
                                }else{
                                    return -x.getValue0().getUprepayamt_预缴户转出金额().doubleValue();
                                }

                            }).sum()
                    );  //
                    loanHistoryRepository.save(loanHistory);


                });


            });




        });





        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();




            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;


                DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                return Triplet.with(e,
                        cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                        dp005__单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    // S_2_SEQ_实缴单位数_AND_0301000201("0301","0301000201","实缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    //      S_3_SEQ_实缴单位数__按年___AND_0301000202("0301","0301000202","实缴单位数(按年)"," ","01","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),


                    //      S_66_SEQ_暂存款余额_AND_0301008102

                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);

                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setDoubleValue(o.getValue().stream()


                            .mapToDouble(d->{


                                return d.getValue0().getFactpayamt_实际缴款金额().doubleValue()-
                                        d.getValue0().getUprepayamt_预缴户转出金额().doubleValue();


                            }).sum()
                    );  //
                    loanHistoryRepository.save(loanHistory);


                });


            });




        });





/*
        return Septet.with(e,
                cm001_单位基本资料表Map.get(dp005_work_unit_单位分户账.getUnitcustid_单位客户号()),
                dp021_单位缴存登记簿Map.get(e.getUnitaccnum单位账号()),
                dp004_unit_payment_info_单位缴存信息表Map.get(e.getUnitaccnum单位账号()),
                dw025_公积金提取审核登记表Map.get(e.getUnitaccnum单位账号()),

                dp008_institution_detail_单位明细账Map.get(e.getUnitaccnum单位账号()),
                dp202_单位缴存变更登记簿Map.get(e.getUnitaccnum单位账号()));
    })              .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {
*/


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_4_SEQ_未缴单位数_AND_0301000301);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();




            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;


                DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                return Triplet.with(e,
                        cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                        dp005__单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    // S_2_SEQ_实缴单位数_AND_0301000201("0301","0301000201","实缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    //      S_3_SEQ_实缴单位数__按年___AND_0301000202("0301","0301000202","实缴单位数(按年)"," ","01","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),


                    //      S_66_SEQ_暂存款余额_AND_0301008102

                    LoanHistory loanHistory   = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_4_SEQ_未缴单位数_AND_0301000301);

                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex经济类型(o.getKey()); // 银行名称
                    loanHistory.setIntValue(o.getValue().stream()


                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .filter(d->d.getValue0().getInaccdate不可为空入账日期().isAfter(beginDate)
                                        && d.getValue0().getInaccdate不可为空入账日期().isBefore(endDate))

                            .collect(Collectors.groupingBy(x->x.toString())).entrySet().size()
                    );  //
                    loanHistoryRepository.save(loanHistory);



                });


            });




        });












    }





}
