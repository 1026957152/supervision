package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.repository.*;

import java.util.Arrays;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("B贷款_基本信息_总体ServiceImpl")
public class B贷款_基本信息_总体ServiceImpl {


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



    // TODO 贷款笔数
    public Output S_232_SEQ_贷款发放占缴存额比重__月___AND_0302020101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_232_SEQ_贷款发放占缴存额比重__月___AND_0302020101.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;

        return null;
    }

    // TODO 贷款笔数
    public Output S_233_SEQ_住房公积金运用率__月___AND_0302020201(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_233_SEQ_住房公积金运用率__月___AND_0302020201.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        return null;
    }


    // TODO 贷款笔数 S_234_SEQ_住房公积金个贷率__月___AND_0302020301
    public Output S_234_SEQ_住房公积金个贷率__月___AND_0302020301(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_234_SEQ_住房公积金个贷率__月___AND_0302020301.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        return null;
    }

    // TODO 贷款笔数 S_235_SEQ_住房公积金个贷逾期率__月___AND_0302020401
    public Output S_235_SEQ_住房公积金个贷逾期率__月___AND_0302020401(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_235_SEQ_住房公积金个贷逾期率__月___AND_0302020401.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        return null;
    }

    // TODO 贷款笔数
    public Output S_236_SEQ_住房公积金个贷增长率__月___AND_0302020501(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_236_SEQ_住房公积金个贷增长率__月___AND_0302020501.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        return null;
    }



    // TODO 人数
    public Output S_237_SEQ_发放人数__购房面积___AND_0302030001(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_237_SEQ_发放人数__购房面积___AND_0302030001.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;
        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_住建部编码_购房面积.values()).forEach(e->{
        });

        return null;
    }


    // TODO 人数 S_238_SEQ_贷款职工人数__收入水平___AND_0302040001
    public Output S_238_SEQ_贷款职工人数__收入水平___AND_0302040001(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_238_SEQ_贷款职工人数__收入水平___AND_0302040001.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;
        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_住建部编码_收入水平.values()).forEach(e->{
        });
        return null;
    }


    // TODO 人数 S_239_SEQ_贷款职工人数__新房__二手房___AND_0302040002
    public Output S_239_SEQ_贷款职工人数__新房__二手房___AND_0302040002(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_239_SEQ_贷款职工人数__新房__二手房___AND_0302040002.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;
        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_房屋性质.values()).forEach(e->{
        });
        return null;
    }




    // TODO 人数 S_240_SEQ_共同借款人人数_AND_0302040003
    public Output S_240_SEQ_共同借款人人数_AND_0302040003(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_240_SEQ_共同借款人人数_AND_0302040003.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        return null;
    }


    // TODO 面积平米 S_241_SEQ_贷款购房建筑面积_AND_0302040004
    public Output S_241_SEQ_贷款购房建筑面积_AND_0302040004(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_241_SEQ_贷款购房建筑面积_AND_0302040004.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        return null;
    }

    // TODO 价格金额
    public Output S_242_SEQ_贷款购房建筑总价_AND_0302040005(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_242_SEQ_贷款购房建筑总价_AND_0302040005.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        return null;
    }
}
