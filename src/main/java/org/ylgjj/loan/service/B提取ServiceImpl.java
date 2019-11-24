package org.ylgjj.loan.service;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.DP202_单位缴存变更登记簿;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.enumT.E_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.util.个人Utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("B提取ServiceImpl")
public class B提取ServiceImpl {


    @Autowired
    private CM002Repository cm002Repository;


    @Autowired
    private LN008_借款人类型Repository lN008_借款人类型Repository;

    @Autowired
    private LN014_TradingHouse_贷款房屋信息Repository ln014_tradingHouse_贷款房屋信息Repository;
    @Autowired
    private LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;




    @Autowired
    private DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;


    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private DW025_公积金提取审核登记表_Repository dW025_公积金提取审核登记表_Repository;

    @Autowired
    private DP007_individual_sub_account_个人分户账_Repository dp007_individual_sub_account个人分户账Repository;
    @Autowired
    private DP006_Payment_个人缴存信息表_Repository dp006_payment_个人缴存信息表_repository;


    @Autowired
    private LN003_Contract_info_Repository ln003_contract_info_repository;


    @Autowired
    private LN005_lone_sub_accountRepository lN005_lone_sub_accountRepository;
    @Autowired
    private DW145_提取结算登记薄_Repository dw145_提取结算登记薄_repository;



    @Autowired
    private CM081_sms_短信密码签订登记簿_Repository cm081_sms_短信密码签订登记簿_repository;

    @Autowired
    private DP004_unit_payment_info_单位缴存信息表_Repository dp004_unit_payment_info单位缴存信息表Repository;

    @Autowired
    private DP005_WorkUnit_单位分户账_Repository dp005_workUnit_单位分户账_repository;

    @Autowired
    private CM001_单位基本资料表Repository cm001单位基本资料表Repository;
    @Autowired
    private DP008_institution_detail_单位明细账_Repository dp008_institution_detail_单位明细账_repository;
    @Autowired
    private DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;
    @Autowired
    private PB017_public_flowing公共流水登记簿Repository public_flowing公共流水登记簿Repository;




    //TODO 提取金额，提取原因，提取人账户号，提取人单位号，提取人机构号，提取人身份证号
    public Triplet 当日情况_提取_动作(String unitnum, LocalDate 日期) {

        long count = dp202_单位缴存变更登记簿_repository.count();
        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+count);

        List<DP202_单位缴存变更登记簿> dp021_单位缴存登记薄s = dW025_公积金提取审核登记表_Repository.findByTransdate交易日期(日期);
        Optional<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿 = dp021_单位缴存登记薄s.stream().filter(e->e.getTransdate不可为空交易日期().isBefore(日期.plusDays(1))).findFirst();


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

        Arrays.stream(住建部编码_收入水平.values()).forEach(e->{

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
        Arrays.stream(住建部编码_收入水平.values()).forEach(e->{

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
    // TODO S_37_SEQ_提取人数__提取原因___AND_0301003911
    public Output S_37_SEQ_提取人数__提取原因___AND_0301003911(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_37_SEQ_提取人数__提取原因___AND_0301003911.name();
        dW025_公积金提取审核登记表_Repository.findAll();
/*        统计周期编码.H__03_每月;

        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
         SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });

        Arrays.stream(E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()).forEach(e->{
        });
        return null;
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
        E_单位缴存登记簿_缴存类型 E = E_单位缴存登记簿_缴存类型.正常全额补缴;
        E = E_单位缴存登记簿_缴存类型.正常全额补缴;
        E = E_单位缴存登记簿_缴存类型.不定额补缴;



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
    public Output S_58_SEQ_外部转入金额_AND_0301007801(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_58_SEQ_外部转入金额_AND_0301007801.name();
        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人


/*
        指标分类编码.H_03_汇补缴分析;
        SY_项目单位.H_01_元_金额价格;
*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;//

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
        return null;
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

        return null;
    }





    // TODO
    public Output S_65_SEQ_归集余额_AND_0301008101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_65_SEQ_归集余额_AND_0301008101.name();
        dp006_payment_个人缴存信息表_repository.findAll();
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
        dp006_payment_个人缴存信息表_repository.findAll();
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
        dp006_payment_个人缴存信息表_repository.findAll();
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
