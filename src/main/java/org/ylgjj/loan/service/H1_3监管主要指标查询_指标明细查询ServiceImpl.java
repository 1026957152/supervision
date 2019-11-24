package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_contract_info_合同信息;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.outputenum.HX摘要码信息表;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.*;

import java.util.Date;
import java.util.List;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H1_3监管主要指标查询_指标明细查询ServiceImpl")
public class H1_3监管主要指标查询_指标明细查询ServiceImpl {

    @Autowired
    private AN004Repository an004Repository;

    @Autowired
    private DP030_单位缓缴登记簿_Repository dp030_单位缓缴登记簿_repository;

    @Autowired
    private PB010_bank_info_大行信息表Repository pb010_bank_info_大行信息表Repository;

    @Autowired
    private PB017_public_flowing公共流水登记簿Repository pb017_public_flowing公共流水登记簿Repository;


    @Autowired
    private LN003_Contract_info_Repository ln003_contract_info_repository;

    @Autowired
    private DP004_unit_payment_info_单位缴存信息表_Repository dp004UnitPaymentInfo_单位缴存信息表_repository;



    public Page<LN003_contract_info_合同信息> queryAdvice(Pageable pageable) {
       // List<LN003_contract_info_合同信息> ln003_contract_info_合同信息s =  ln003_contract_info_repository.findByLoandateBetween(new Date(),new Date());


        return null;
    }
    public ReturnResult 逾期监管汇总查询(String zjbzxbm) {
        return null;
    }



    public Output H_1_2_监管主要指标查询_指标明细查询(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {


        return null;
    }



}
