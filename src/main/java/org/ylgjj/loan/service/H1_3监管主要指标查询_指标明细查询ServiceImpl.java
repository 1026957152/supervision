package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_contract_info_合同信息;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.output.H1_4监管主要指标查询_离柜率查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.HX摘要码信息表;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.rate.HX_Rate环比同比HistoryerviceImpl;
import org.ylgjj.loan.repository.*;

import java.util.Arrays;
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
    private HX_Rate环比同比HistoryerviceImpl hx_rate环比同比Historyervice;

    @Autowired
    private DP004_unit_payment_info_单位缴存信息表_Repository dp004UnitPaymentInfo_单位缴存信息表_repository;




    public ReturnResult 逾期监管汇总查询(String zjbzxbm) {
        return null;
    }



    public Output H_1_2_监管主要指标查询_指标明细查询(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        H1_2监管主要指标查询_公积金中心主要运行情况查询 h1 = new H1_2监管主要指标查询_公积金中心主要运行情况查询();
        h1.setLjjzzdws_建制总单位数_NUMBER_18_2((Integer)hx_rate环比同比Historyervice.SY_1_ljjzzdws_建制总单位数(ksrq,jsrq).get(E_指标_RATE_SY.SY_1_ljjzzdws_建制总单位数));
        h1.setLjhbjzzdws_环比建制总单位数_NUMBER_18_0((Integer)hx_rate环比同比Historyervice.SY_1_ljjzzdws_建制总单位数(ksrq,jsrq).get(E_指标_RATE_SY.SY_2_ljhbjzzdws_环比建制总单位数));
        h1.setLjsnjzzdws_同比建制总单位数_NUMBER_18_0((Integer)hx_rate环比同比Historyervice.SY_1_ljjzzdws_建制总单位数(ksrq,jsrq).get(E_指标_RATE_SY.SY_3_ljsnjzzdws_同比建制总单位数));

        Output output = new Output();

        output.setData(Arrays.asList(h1));
        return output;

    }


    public Output H_1_4_监管主要指标查询_离柜率明细查询(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {

        H1_4监管主要指标查询_离柜率查询 h1_4监管主要指标查询_离柜率查询 = new H1_4监管主要指标查询_离柜率查询();

        Output output = new Output();

        output.setData(Arrays.asList(h1_4监管主要指标查询_离柜率查询));
        return output;
    }

    public Output H_1_2_监管主要指标查询_公积金中心主要运行情况查询(String ksrq, String jsrq) {
        H1_2监管主要指标查询_公积金中心主要运行情况查询 h1 = new H1_2监管主要指标查询_公积金中心主要运行情况查询();
        h1.setLjjzzdws_建制总单位数_NUMBER_18_2((Integer)hx_rate环比同比Historyervice.SY_1_ljjzzdws_建制总单位数(ksrq,jsrq).get(E_指标_RATE_SY.SY_1_ljjzzdws_建制总单位数));
        h1.setLjhbjzzdws_环比建制总单位数_NUMBER_18_0((Double)hx_rate环比同比Historyervice.SY_1_ljjzzdws_建制总单位数(ksrq,jsrq).get(E_指标_RATE_SY.SY_2_ljhbjzzdws_环比建制总单位数));
        h1.setLjsnjzzdws_同比建制总单位数_NUMBER_18_0((Double)hx_rate环比同比Historyervice.SY_1_ljjzzdws_建制总单位数(ksrq,jsrq).get(E_指标_RATE_SY.SY_3_ljsnjzzdws_同比建制总单位数));





        h1.setLjhbjzfcrs_环比建制封存人数_NUMBER_18_0((Double)hx_rate环比同比Historyervice.SY_1_ljjzzdws_建制总单位数(ksrq,jsrq).get(E_指标_RATE_SY.SY_3_ljsnjzzdws_同比建制总单位数));

        Output output = new Output();

        output.setData(Arrays.asList(h1));
        return output;
    }
}
