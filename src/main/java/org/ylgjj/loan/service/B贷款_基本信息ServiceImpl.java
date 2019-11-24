package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.util.个人Utils;

import java.util.Arrays;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("B贷款_基本信息ServiceImpl")
public class B贷款_基本信息ServiceImpl {


    @Autowired
    private CM002Repository cm002Repository;
    @Autowired
    private DP034_公积金开销户登记簿_Repository dp034_公积金开销户登记簿_repository;


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
    private DW025_公积金提取审核登记表_Repository dW025__公积金提取审核登记表_Repository;

    @Autowired
    private DP007_individual_sub_account_个人分户账_Repository dp007_individual_sub_account个人分户账Repository;
    @Autowired
    private DP006_Payment_个人缴存信息表_Repository dp006_payment_个人缴存信息表_repository;


    @Autowired
    private LN003_Contract_info_Repository ln003_contract_info_repository;


    @Autowired
    private DP204_个人缴存变更登记簿_Repository dp204_个人缴存变更登记簿_repository;
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


    // TODO S_140_SEQ_贷款余额_AND_0302000801
    public Output S_140_SEQ_贷款余额_AND_0302000801(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_140_SEQ_贷款余额_AND_0302000801.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_141_SEQ_贷款余额__5年以内含___AND_0302000802
    public Output S_141_SEQ_贷款余额__5年以内含___AND_0302000802(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_141_SEQ_贷款余额__5年以内含___AND_0302000802.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_142_SEQ_贷款余额__5年以上___AND_0302000803
    public Output S_142_SEQ_贷款余额__5年以上___AND_0302000803(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_142_SEQ_贷款余额__5年以上___AND_0302000803.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }


    // TODO S_143_SEQ_异地贷款余额_AND_0302000804
    public Output S_143_SEQ_异地贷款余额_AND_0302000804(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_143_SEQ_异地贷款余额_AND_0302000804.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }




    // TODO S_151_SEQ_发放户数_AND_0302002001
    public Output S_151_SEQ_发放户数_AND_0302002001(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_151_SEQ_发放户数_AND_0302002001.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;

    }
    // TODO S_152_SEQ_发放户数__5年以内含___AND_0302002002
    public Output S_152_SEQ_发放户数__5年以内含___AND_0302002002(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_152_SEQ_发放户数__5年以内含___AND_0302002002.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;

    }

    // TODO S_153_SEQ_发放户数__5年以上___AND_0302002003
    public Output S_153_SEQ_发放户数__5年以上___AND_0302002003(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_153_SEQ_发放户数__5年以上___AND_0302002003.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_154_SEQ_发放户数__贷款年限___AND_0302002005
    public Output S_154_SEQ_发放户数__贷款年限___AND_0302002005(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_154_SEQ_发放户数__贷款年限___AND_0302002005.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_贷款时缴存年限_HX_EX.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_155_SEQ_发放户数__担保方式新___AND_0302002006(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_155_SEQ_发放户数__担保方式新___AND_0302002006.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_担保方式_HX_EX.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_156_SEQ_发放户数__单位性质___AND_0302002007(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_156_SEQ_发放户数__单位性质___AND_0302002007.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_157_SEQ_发放户数__非本市缴存职工开户年限___AND_0302002008(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_157_SEQ_发放户数__非本市缴存职工开户年限___AND_0302002008.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;
        个人Utils.非本市缴存职工("");

        Arrays.stream(E_开户年限_HX_EX.values()).forEach(e->{
        });
        return null;
    }



    // TODO S_158_SEQ_发放户数__贷款次数___AND_0302002009
    public Output S_158_SEQ_发放户数__贷款次数___AND_0302002009(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_158_SEQ_发放户数__贷款次数___AND_0302002009.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        个人Utils.非本市缴存职工("");
        Arrays.stream(E_贷款次数_HX_EX.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_159_SEQ_发放户数__借款人年龄___AND_0302002010(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_159_SEQ_发放户数__借款人年龄___AND_0302002010.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        个人Utils.非本市缴存职工("");
        Arrays.stream(E_贷款次数_HX_EX.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_160_SEQ_发放户数__还款方式___AND_0302002011(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_160_SEQ_发放户数__还款方式___AND_0302002011.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        个人Utils.非本市缴存职工("");
        Arrays.stream(E_还款方式_HX_EX.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_161_SEQ_发放户数__贷款金额与房屋价格占比___AND_0302002012(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_161_SEQ_发放户数__贷款金额与房屋价格占比___AND_0302002012.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;

        Arrays.stream(E_贷款金额与房屋价格占比_HX_EX.values()).forEach(e->{
        });
        return null;
    }



    // TODO
    public Output S_162_SEQ_发放户数__资金来源___AND_0302002013(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_162_SEQ_发放户数__资金来源___AND_0302002013.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_资金来源_HX_EX.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_163_SEQ_发放户数__贷款用途___AND_0302002014(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_163_SEQ_发放户数__贷款用途___AND_0302002014.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_贷款用途_HX_EX.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_164_SEQ_发放户数__缴存人数___AND_0302002015(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_164_SEQ_发放户数__缴存人数___AND_0302002015.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
/*        Arrays.stream(缴存人数.values()).forEach(e->{
        });*/

        return null;
    }

    // TODO
    public Output S_165_SEQ_发放户数__贷款时缴存年限___AND_0302002016(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_165_SEQ_发放户数__贷款时缴存年限___AND_0302002016.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_贷款时缴存年限_HX_EX.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_166_SEQ_发放户数__收入水平___AND_0302002018(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_166_SEQ_发放户数__收入水平___AND_0302002018.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(住建部编码_收入水平.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_167_SEQ_当年发放异地贷款笔数_AND_0302002019(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_167_SEQ_当年发放异地贷款笔数_AND_0302002019.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;
        return null;
    }
    // TODO
    public Output S_168_SEQ_累计发放异地贷款笔数_AND_0302002020(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_168_SEQ_累计发放异地贷款笔数_AND_0302002020.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        return null;
    }





    // TODO
    public Output S_215_SEQ_历史累计发放户数_AND_0302012001(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_215_SEQ_历史累计发放户数_AND_0302012001.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_216_SEQ_历史累计发放户数__5年以内含___AND_0302012002(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_216_SEQ_历史累计发放户数__5年以内含___AND_0302012002.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_217_SEQ_历史累计发放户数__5年以上___AND_0302012003(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_217_SEQ_历史累计发放户数__5年以上___AND_0302012003.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_218_SEQ_存量贷款笔数_AND_0302012004(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_218_SEQ_存量贷款笔数_AND_0302012004.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO  笔数0
    public Output S_219_SEQ_存量贷款笔数__缴存状态___AND_0302012009(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_219_SEQ_存量贷款笔数__缴存状态___AND_0302012009.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_缴存状态_HX_EX.values()).forEach(e->{
        });
        return null;
    }


















    // TODO 贷款笔数 S_231_SEQ_历史累计结清户数__逾期___AND_0302012204
    public Output S_231_SEQ_历史累计结清户数__逾期___AND_0302012204(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_231_SEQ_历史累计结清户数__逾期___AND_0302012204.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });

        return null;
    }
}
