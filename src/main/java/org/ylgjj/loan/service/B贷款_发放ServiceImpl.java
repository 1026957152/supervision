package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.util.个人Utils;

import java.util.Arrays;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("B贷款_发放ServiceImpl")
public class B贷款_发放ServiceImpl {


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



    // TODO
    public Output S_88_SEQ_发放额_AND_0302000101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_88_SEQ_发放额_AND_0302000101.name();

     //   String name = 统计指标编码.H__88__发放额__0302__0302000101__指标说明__TT__指标分类__07__统计周期__01__bm_khjg__机构__bm_yhbm__银行名称__维度三__TT__TT__显示精度__1__项目单位__01.name();


        dp021_单位缴存登记薄Repository.findAll();
/*
        统计周期编码 A =统计周期编码.H__01_每日;
        指标分类编码.H_07_发放额及户数分析;
        SY_项目单位.H_01_元_金额价格;
*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });

        return null;
    }
    // TODO S_89_SEQ_发放额__5年以内含___AND_0302000102
    public Output S_89_SEQ_发放额__5年以内含___AND_0302000102(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_89_SEQ_发放额__5年以内含___AND_0302000102.name();

        name=统计指标编码.H__89__发放额__5年以内含____0302__0302000102__指标说明__TT__指标分类__07__统计周期__01__bm_khjg__机构__bm_yhbm__银行名称__维度三__TT__TT__显示精度__1__项目单位__01.name();

        dp021_单位缴存登记薄Repository.findAll();


        统计周期编码 A =统计周期编码.H__01_每日;
      //  指标分类编码.H_07_发放额及户数分析;
     //   SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_90_SEQ_发放额__5年以上___AND_0302000103
    public Output S_90_SEQ_发放额__5年以上___AND_0302000103(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_90_SEQ_发放额__5年以上___AND_0302000103.name();
        统计指标编码 B =null;
        B=统计指标编码.H__90__发放额__5年以上____0302__0302000103__指标说明__TT__指标分类__07__统计周期__01__bm_khjg__机构__bm_yhbm__银行名称__维度三__TT__TT__显示精度__1__项目单位__01;

        dp021_单位缴存登记薄Repository.findAll();



        统计周期编码 A =统计周期编码.H__01_每日;
       // 指标分类编码.H_07_发放额及户数分析;
        //SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_91_SEQ_发放额__贷款年限___AND_0302000105
    public Output S_91_SEQ_发放额__贷款年限___AND_0302000105(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_91_SEQ_发放额__贷款年限___AND_0302000105.name();
        统计指标编码 B =null;
        B=统计指标编码.H__91__发放额__贷款年限____0302__0302000105__指标说明__TT__指标分类__22__统计周期__03__bm_khjg__机构__bm_bi_dknx__贷款年限__维度三__TT__TT__显示精度__1__项目单位__TT;


        dp021_单位缴存登记薄Repository.findAll();


        统计周期编码 A =统计周期编码.H__03_每月;


        //指标分类编码.H_22_贷款年限分析;
        //SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_贷款年限.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_92_SEQ_发放额__担保方式新___AND_0302000106
    public Output S_92_SEQ_发放额__担保方式新___AND_0302000106(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_92_SEQ_发放额__担保方式新___AND_0302000106.name();

        统计指标编码 B =null;
        B=统计指标编码.H__92__发放额__担保方式新____0302__0302000106__指标说明__TT__指标分类__23__统计周期__03__bm_khjg__机构__bm_bi_dkdblx__担保方式新__维度三__TT__TT__显示精度__0__项目单位__TT;

        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;

       // 指标分类编码.H_23_担保方式分析;
        //SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_担保方式_HX_EX.values()).forEach(e->{
        });

        return null;
    }

    // TODO
    public Output S_93_SEQ_发放额__购房面积___AND_0302000107(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_93_SEQ_发放额__购房面积___AND_0302000107.name();
        统计指标编码 B =null;
        B=统计指标编码.H__93__发放额__购房面积____0302__0302000107__指标说明__TT__指标分类__20__统计周期__03__bm_khjg__机构__bm_bi_gfmj__购房面积__维度三__TT__TT__显示精度__1__项目单位__TT;


        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;

       // 指标分类编码.H_20_购房面积分析;
        //SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_住建部编码_购房面积.values()).forEach(e->{
        });

        return null;
    }

    // TODO
    public Output S_94_SEQ_发放额__单位性质___AND_0302000108(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_94_SEQ_发放额__单位性质___AND_0302000108.name();

        统计指标编码 B =null;
        B=统计指标编码.H__94__发放额__单位性质____0302__0302000108__指标说明__TT__指标分类__23__统计周期__03__bm_khjg__机构__bm_dwjjlx__单位性质__维度三__TT__TT__显示精度__0__项目单位__TT;

        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;

       // 指标分类编码.H_23_担保方式分析;
       // SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO
    public Output S_95_SEQ_发放额__非本市缴存职工开户年限___AND_0302000109(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_95_SEQ_发放额__非本市缴存职工开户年限___AND_0302000109.name();
        统计指标编码 B =null;
        B=统计指标编码.H__95__发放额__非本市缴存职工开户年限____0302__0302000109__指标说明__TT__指标分类__23__统计周期__06__bm_khjg__机构__bm_bi_khnx__开户年限__维度三__TT__TT__显示精度__0__项目单位__TT;
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;
        个人Utils.非本市缴存职工("");


/*        指标分类编码.H_23_担保方式分析;
        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_开户年限_HX_EX.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_96_SEQ_发放额__缴存人数___AND_0302000110(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_96_SEQ_发放额__缴存人数___AND_0302000110.name();
        dp021_单位缴存登记薄Repository.findAll();

        个人Utils.非本市缴存职工("");
        统计指标编码 B =null;
        B=统计指标编码.H__96__发放额__缴存人数____0302__0302000110__指标说明__TT__指标分类__23__统计周期__03__bm_khjg__机构__bm_bi_jcrs__缴存人数__维度三__TT__TT__显示精度__0__项目单位__TT;


        dp021_单位缴存登记薄Repository.findAll();

        //指标分类编码.H_23_担保方式分析;
        统计周期编码 A =统计周期编码.H__03_每月;
        //SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
/*        Arrays.stream(缴存人数.values()).forEach(e->{
        });*/

        return null;
    }



    // TODO
    public Output S_97_SEQ_发放额__贷款次数___AND_0302000111(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_97_SEQ_发放额__贷款次数___AND_0302000111.name();
        统计指标编码 B =null;
        B=统计指标编码.H__97__发放额__贷款次数____0302__0302000111__指标说明__TT__指标分类__23__统计周期__03__bm_khjg__机构__bm_bi_dkcs__贷款次数__维度三__TT__TT__显示精度__0__项目单位__TT;


    dp021_单位缴存登记薄Repository.findAll();




      //  指标分类编码.H_23_担保方式分析;
        统计周期编码 A =统计周期编码.H__03_每月;
       // SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
/*        Arrays.stream(贷款次数.values()).forEach(e->{
        });*/
return null;
    }
    // TODO
    public Output S_98_SEQ_发放额__借款人年龄___AND_0302000112(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_98_SEQ_发放额__借款人年龄___AND_0302000112.name();
        统计指标编码 B =null;
        B=统计指标编码.H__98__发放额__借款人年龄____0302__0302000112__指标说明__TT__指标分类__23__统计周期__03__bm_khjg__机构__bm_bi_khnx__开户年限__维度三__TT__TT__显示精度__0__项目单位__TT;

        dp021_单位缴存登记薄Repository.findAll();




       // 指标分类编码.H_23_担保方式分析;
        统计周期编码 A =统计周期编码.H__03_每月;
       // SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
/*        Arrays.stream(借款人年龄.values()).forEach(e->{
        });*/

return  null;
    }


    // TODO
    public Output S_99_SEQ_发放额__贷款用途___AND_0302000113(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_99_SEQ_发放额__贷款用途___AND_0302000113.name();
        统计指标编码 B =null;
        B=统计指标编码.H__99__发放额__贷款用途____0302__0302000113__指标说明__TT__指标分类__23__统计周期__03__bm_khjg__机构__bm_bi_dkyt__贷款用途__维度三__TT__TT__显示精度__0__项目单位__TT;

        dp021_单位缴存登记薄Repository.findAll();


      //  指标分类编码.H_23_担保方式分析;
        统计周期编码 A =统计周期编码.H__03_每月;
       // SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_贷款用途_HX_EX.values()).forEach(e->{
        });
        return  null;
    }





    // TODO S_100_SEQ_发放额__资金来源___AND_0302000114
    public Output S_100_SEQ_发放额__资金来源___AND_0302000114(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_100_SEQ_发放额__资金来源___AND_0302000114.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_资金来源_HX_EX.values()).forEach(e->{
        });

        return null;
    }

    // TODO S_101_SEQ_发放额__贷款金额与房屋价格占比___AND_0302000115
    public Output S_101_SEQ_发放额__贷款金额与房屋价格占比___AND_0302000115(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_101_SEQ_发放额__贷款金额与房屋价格占比___AND_0302000115.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_贷款金额与房屋价格占比_HX_EX.values()).forEach(e->{
        });

        return null;
    }


    // TODO S_102_SEQ_发放额__还款方式___AND_0302000116
    public Output S_102_SEQ_发放额__还款方式___AND_0302000116(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_102_SEQ_发放额__还款方式___AND_0302000116.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_还款方式_HX_EX.values()).forEach(e->{
        });

        return null;
    }



    // TODO S_103_SEQ_发放额__贷款时缴存年限___AND_0302000117
    public Output S_103_SEQ_发放额__贷款时缴存年限___AND_0302000117(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_103_SEQ_发放额__贷款时缴存年限___AND_0302000117.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_贷款时缴存年限_HX_EX.values()).forEach(e->{
        });

        return null;
    }

    // TODO
    public Output S_104_SEQ_发放额__收入水平___AND_0302000119(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_104_SEQ_发放额__收入水平___AND_0302000119.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_住建部编码_收入水平.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_105_SEQ_当年发放异地贷款金额_AND_0302000120(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_105_SEQ_当年发放异地贷款金额_AND_0302000120.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;
        return null;
    }

    // TODO
    public Output S_106_SEQ_累计发放异地贷款总额_AND_0302000121(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_106_SEQ_累计发放异地贷款总额_AND_0302000121.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        return null;
    }




    // TODO
    public Output S_183_SEQ_历史累计发放额_AND_0302010101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_183_SEQ_历史累计发放额_AND_0302010101.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_184_SEQ_历史累计发放额__5年以内含___AND_0302010102(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_184_SEQ_历史累计发放额__5年以内含___AND_0302010102.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_185_SEQ_历史累计发放额__5年以上___AND_0302010103
    public Output S_185_SEQ_历史累计发放额__5年以上___AND_0302010103(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_185_SEQ_历史累计发放额__5年以上___AND_0302010103.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }
}
