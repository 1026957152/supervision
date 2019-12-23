package org.ylgjj.loan.service;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.DP202_单位缴存变更登记簿;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.domain_flow.LoanHistory;
import org.ylgjj.loan.history.ZYCommonHistoryerviceImpl;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.util.个人Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("B开户ServiceImpl")
public class B开户ServiceImpl {


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
    private ZYCommonHistoryerviceImpl zyCommonHistoryervice;


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
    private DP008单位明细账Repository dp008单位明细账Repository;
    @Autowired
    private LoanHistoryRepository loanHistoryRepository;


/*    3434	单位开户
42	单位转移(转出)
42	单位转移(转入)
1393	单位销户
310	预缴退缴
14954	预缴转移(转出)
14954	预缴转移(转入)
1393	单位预缴销户
182906	部分提取
37481	销户提取
2159	零额销户
27957	个人转移(转出)
27957	个人转移(转入)
21830	个人并户(并出)
21830	个人并户(并入)
87576	预缴入账
234946	汇缴入账
12018	正常全额补缴入账
45392	不定额补缴入账
1476	调账(调出)
1476	调账(调入)
660	异地转入
21962	年度结息
266	异地单位转移
5556	协助司法扣划账户金额
41179	柜台还款
23339	公积金代扣*/
    //TODO 管理部机构号，单位机构号，单位状态，缴存比例，缴存人数,余额
    public Triplet 当日情况_机构_状态(String unitnum, LocalDate 日期) {

        long count = dp202_单位缴存变更登记簿_repository.count();
        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+count);

        List<DP202_单位缴存变更登记簿> dp021_单位缴存登记薄s =null;// dp008_institution_detail_单位明细账_repository.findById(日期);
        Optional<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿 = dp021_单位缴存登记薄s.stream().filter(e->e.getTransdate不可为空交易日期().isBefore(日期.plusDays(1))).findFirst();

        dp202_单位缴存变更登记簿_repository.findByUnitcustid不可为空单位客户号(unitnum);

        dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(unitnum);

/*        if(dp202_单位缴存变更登记簿.isPresent()){
            return dp202_单位缴存变更登记簿.get().getFinchgnum_不可为空_财政变更人数();
        }*/


        Triplet<List<String>,Double,Integer> aa = new Triplet<List<String>,Double,Integer>(null,1d,1);
        return aa;
    }
    //TODO 管理部机构号，单位机构号，单位状态，缴存比例，
    public Triplet 当日情况_机构_动作( LocalDate 日期) {

        long count = dp202_单位缴存变更登记簿_repository.count();
        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+count);

      /*  List<DP202_单位缴存变更登记簿> dp021_单位缴存登记薄s = dW025_公积金提取审核登记表_Repository.findByTransdate交易日期Desc(日期);
        Optional<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿 = dp021_单位缴存登记薄s.stream().filter(e->e.getTransdate不可为空交易日期().isBefore(日期.plusDays(1))).findFirst();


        if(dp202_单位缴存变更登记簿.isPresent()){
            return dp202_单位缴存变更登记簿.get().getFinchgnum_不可为空_财政变更人数();
        }*/
        Triplet<List<String>,Double,Integer> aa = new Triplet<List<String>,Double,Integer>(null,1d,1);
        return aa;
    }


    // TODO ???
    public Output S_21_SEQ_新开户职工数__非本市缴存职工___AND_0301003205(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_21_SEQ_新开户职工数__非本市缴存职工___AND_0301003205.name();
        dW025__公积金提取审核登记表_Repository.findAll();
        Arrays.stream(E_住建部编码_收入水平.values()).forEach(e->{
        });

        dp034_公积金开销户登记簿_repository.findAll();
        个人Utils.非本市缴存职工("");

/*        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__06_每年;*/
      //  SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_开户年限_HX_EX.values()).forEach(e->{

        });
        return null;
    }

    // TODO
    public Output S_31_SEQ_新增人数_AND_0301003601(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_31_SEQ_新增人数_AND_0301003601.name();
        dp034_公积金开销户登记簿_repository.findAll();


/*        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__01_每日;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{

        });

        return null;

    }
    // TODO S_32_SEQ_新增人数__非本市缴存职工___AND_0301003602
    public Output S_32_SEQ_新增人数__非本市缴存职工___AND_0301003602(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_32_SEQ_新增人数__非本市缴存职工___AND_0301003602.name();
        dp034_公积金开销户登记簿_repository.findAll();
        个人Utils.非本市缴存职工("");
        // TODO 每类型多少个人

/*        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__01_每日;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        return null;
    }


    // TODO S_33_SEQ_封存人数_AND_0301003701
    public Output S_33_SEQ_封存人数_AND_0301003701(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_33_SEQ_封存人数_AND_0301003701.name();
        dp204_个人缴存变更登记簿_repository.findAll();


/*        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__01_每日;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        // TODO 每类型多少个人
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_34_SEQ_销户人数_AND_0301003801
    public Output S_34_SEQ_销户人数_AND_0301003801(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_34_SEQ_销户人数_AND_0301003801.name();
        dp034_公积金开销户登记簿_repository.findAll();
/*        H公积金开销户登记簿_开销户标志.销户;
        // TODO 每类型多少个人

        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }
    // TODO S_34_SEQ_销户人数_AND_0301003801
    public Output S_35_SEQ_历史累计销户人数_AND_0301003802(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_35_SEQ_历史累计销户人数_AND_0301003802.name();
        dp034_公积金开销户登记簿_repository.findAll();
/*        统计周期编码.H__05_半年;
        H公积金开销户登记簿_开销户标志.销户;
        // TODO 每类型多少个人


        指标分类编码.H_05_历史累计分析;
        统计周期编码.H__03_每月;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }






    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // TODO ??????????
    public Output S_40_SEQ_外部转入人数_AND_0301004101(String dimension1, String dimension2, String dimension3, 统计周期编码 period, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_40_SEQ_外部转入人数_AND_0301004101.name();
        //dW025_公积金提取审核登记表_Repository.findAll();
/*        统计周期编码.H__03_每月;

        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
        SY_项目单位.H_02_个_人数;*/

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
                    long count = ldt_ksrq.until(ldt_jsrq, ChronoUnit.MONTHS);
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

    // TODO ??????????
    public Output S_41_SEQ_外部转出人数_AND_0301004201(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_41_SEQ_外部转出人数_AND_0301004201.name();

        //dW025_公积金提取审核登记表_Repository.findAll();
/*        统计周期编码.H__03_每月;

        // TODO 每类型多少个人
ZYCommonHistoryerviceImpl

        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return   zyCommonHistoryervice.commom(dimension1,dimension2,dimension3,valueOf,valueOf1,ksrq,jsrq);

    }



    // TODO ??????????
    public Output S_42_SEQ_实存人数_AND_0301005101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_42_SEQ_实存人数_AND_0301005101.name();
        //dW025_公积金提取审核登记表_Repository.findAll();

        // TODO 每类型多少个人



/*        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__01_每日;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_43_SEQ_开户总人数_AND_0301005201(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_43_SEQ_开户总人数_AND_0301005201.name();
/*        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码.H__01_每日;
        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__01_每日;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_44_SEQ_正常总人数_AND_0301005301(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_44_SEQ_正常总人数_AND_0301005301.name();
/*        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码.H__01_每日;
        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__01_每日;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }


    // TODO S_45_SEQ_封存总人数_AND_0301005401
    public Output S_45_SEQ_封存总人数_AND_0301005401(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_45_SEQ_封存总人数_AND_0301005401.name();
/*        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码.H__01_每日;
        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__01_每日;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }
    // TODO
    public Output S_46_SEQ_销户总人数_AND_0301005501(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_46_SEQ_销户总人数_AND_0301005501.name();
/*        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码.H__01_每日;
        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__01_每日;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO S_47_SEQ_冻结总人数_AND_0301005601
    public Output S_47_SEQ_冻结总人数_AND_0301005601(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_47_SEQ_冻结总人数_AND_0301005601.name();
/*        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码.H__01_每日;
        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__01_每日;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }



    // TODO S_77_SEQ_历史累计单位账户数_AND_0301011003
    public Output S_77_SEQ_历史累计单位账户数_AND_0301011003(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_77_SEQ_历史累计单位账户数_AND_0301011003.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        // TODO 每类型多少个人

/*
        指标分类编码.H_05_历史累计分析;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_78_SEQ_历史累计个人账户数_AND_0301011004
    public Output S_78_SEQ_历史累计个人账户数_AND_0301011004(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_78_SEQ_历史累计个人账户数_AND_0301011004.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        // TODO 每类型多少个人

/*
        指标分类编码.H_05_历史累计分析;
        SY_项目单位.H_02_个_人数;
*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }




    // TODO S_79_SEQ_住房公积金缴存率_AND_0301020101
    public Output S_79_SEQ_住房公积金缴存率_AND_0301020101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_79_SEQ_住房公积金缴存率_AND_0301020101.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;

        //指标分类编码.H_06_归集指标;


        return null;


    }
    // TODO
    public Output S_80_SEQ_住房公积金覆盖率_AND_0301020201(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_80_SEQ_住房公积金覆盖率_AND_0301020201.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;
       // 指标分类编码.H_06_归集指标;
        return null;
    }


    // TODO
    public Output S_81_SEQ_住房公积金归集增长率_AND_0301020301(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_81_SEQ_住房公积金归集增长率_AND_0301020301.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;

       // 指标分类编码.H_06_归集指标;
        return null;
    }

    // TODO S_82_SEQ_提取额占缴存额比重_AND_0301020401
    public Output S_82_SEQ_提取额占缴存额比重_AND_0301020401(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_82_SEQ_提取额占缴存额比重_AND_0301020401.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;

        //指标分类编码.H_06_归集指标;
        return null;
    }



    // TODO S_86_SEQ_新开户职工数__收入水平___AND_0301020506
    public Output S_86_SEQ_新开户职工数__收入水平___AND_0301020506(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_86_SEQ_新开户职工数__收入水平___AND_0301020506.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;


/*        指标分类编码.H_25_收入水平分析;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_住建部编码_收入水平.values()).forEach(e->{
        });
        return null;
    }
}
