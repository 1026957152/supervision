package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.outputenum.E_逾期期次_HX;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.outputenum.E_银行编码_H;
import org.ylgjj.loan.repository.*;

import java.util.Arrays;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("B贷款_逾期ServiceImpl")
public class B贷款_逾期ServiceImpl {


    @Autowired
    private CM002_个人基本资料表Repository cm002个人基本资料表Repository;
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

    // TODO
    public Output S_137_SEQ_逾期本息__本期发生___AND_0302000701(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_137_SEQ_逾期本息__本期发生___AND_0302000701.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }




    // TODO S_138_SEQ_逾期本金__本期发生___AND_0302000702
    public Output S_138_SEQ_逾期本金__本期发生___AND_0302000702(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_138_SEQ_逾期本金__本期发生___AND_0302000702.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_139_SEQ_逾期利息__本期发生___AND_0302000703
    public Output S_139_SEQ_逾期利息__本期发生___AND_0302000703(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_139_SEQ_逾期利息__本期发生___AND_0302000703.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }





    // TODO
    public Output S_108_SEQ_回收额__正常___AND_0302000202(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_144_SEQ_贷款余额__逾期期次___AND_0302000808.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_逾期期次_HX.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_145_SEQ_目前逾期本息_AND_0302000901(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_145_SEQ_目前逾期本息_AND_0302000901.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }
    // TODO
    public Output S_146_SEQ_目前逾期本金_AND_0302000902(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_146_SEQ_目前逾期本金_AND_0302000902.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }
    // TODO
    public Output S_147_SEQ_目前逾期利息_AND_0302000903(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_147_SEQ_目前逾期利息_AND_0302000903.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_148_SEQ_目前逾期本息__按期次分类___AND_0302000911(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_148_SEQ_目前逾期本息__按期次分类___AND_0302000911.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        Arrays.stream(E_逾期期次_HX.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_149_SEQ_目前逾期本金__按期次分类___AND_0302000912(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_149_SEQ_目前逾期本金__按期次分类___AND_0302000912.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        Arrays.stream(E_逾期期次_HX.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_150_SEQ_目前逾期利息__按期次分类___AND_0302000913(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_150_SEQ_目前逾期利息__按期次分类___AND_0302000913.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        Arrays.stream(E_逾期期次_HX.values()).forEach(e->{
        });
        return null;
    }




    // TODO
    public Output S_181_SEQ_目前逾期户数_AND_0302002301(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_181_SEQ_目前逾期户数_AND_0302002301.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_182_SEQ_目前逾期户数__按期次分类___AND_0302002311(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_182_SEQ_目前逾期户数__按期次分类___AND_0302002311.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });

        Arrays.stream(E_逾期期次_HX.values()).forEach(e->{
        });
        return null;
    }



    // TODO
    public Output S_212_SEQ_历史累计逾期本息_AND_0302010701(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_212_SEQ_历史累计逾期本息_AND_0302010701.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_213_SEQ_历史累计逾期本金_AND_0302010702(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_213_SEQ_历史累计逾期本金_AND_0302010702.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_214_SEQ_历史累计逾期利息_AND_0302010703(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_214_SEQ_历史累计逾期利息_AND_0302010703.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        Arrays.stream(E_银行编码_H.values()).forEach(e->{
        });
        return null;
    }


}
