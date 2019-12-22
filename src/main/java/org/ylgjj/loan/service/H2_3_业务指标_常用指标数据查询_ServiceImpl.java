package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain_flow.TargetHistory;
import org.ylgjj.loan.output.H2_3业务指标_多维度查询;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.pojo.*;
import org.ylgjj.loan.repository_flow.TargetHistoryRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class H2_3_业务指标_常用指标数据查询_ServiceImpl {

    @Autowired
    private TargetHistoryRepository targetHistoryRepository;



    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Output_data H_2_3_业务指标_常用指标数据查询(QueryH_2_3_业务指标_常用指标数据查询 query) {


        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(), df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(), df);
        LocalDate ldt_ksrq_环比_begin  = ldt_ksrq.minusMonths(1);
        LocalDate ldt_ksrq_环比_end  = ldt_jsrq.minusMonths(1);


        LocalDate ldt_ksrq_同比_begin  = ldt_ksrq.minusYears(1);
        LocalDate ldt_ksrq_同比_end  = ldt_jsrq.minusYears(1);

        StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.fromString指标编码(query.getXmbm_指标编码());
        统计周期编码.fromString(statisticalIndexCodeEnum.get统计周期());



        List<TargetHistory> rateHistories = targetHistoryRepository
                .findByTargetNoAndDateBetweenOrderByDateDesc(statisticalIndexCodeEnum.get指标编码(),ldt_ksrq,ldt_jsrq);

        List<TargetHistory> rateHistories_环比 = targetHistoryRepository
                .findByTargetNoAndDateBetweenOrderByDateDesc(statisticalIndexCodeEnum.get指标编码(),ldt_ksrq_环比_begin,ldt_ksrq_环比_end);
        List<TargetHistory> rateHistories_同比 = targetHistoryRepository
                .findByTargetNoAndDateBetweenOrderByDateDesc(statisticalIndexCodeEnum.get指标编码(),ldt_ksrq_同比_begin,ldt_ksrq_同比_end);

















        E_指标单位_SY_EX e_指标单位_sy_ex = E_指标单位_SY_EX.fromString(statisticalIndexCodeEnum.get项目单位());
        H2_3业务指标_多维度查询 h2_3业务指标_多维度查询 = new H2_3业务指标_多维度查询();

        if(rateHistories.size() != 0){

            if(e_指标单位_sy_ex == E_指标单位_SY_EX.H_01_元 ||e_指标单位_sy_ex == E_指标单位_SY_EX.H_05_平方米 ){
                Integer 当前 = 0;
                Double 环比 = 0d;
                Double 同比 =0d;

                TargetHistory rateHistory_环比 = rateHistories_环比.get(0);
                TargetHistory rateHistory_同比 = rateHistories_同比.get(0);
                TargetHistory rateHistory = rateHistories.get(0);

                BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory.getLongValue().intValue()-rateHistory_环比.getLongValue().intValue()+0D)/rateHistory_环比.getLongValue().intValue());

                环比 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

                bigDecimal = BigDecimal.valueOf((rateHistory.getLongValue().intValue()-rateHistory_同比.getLongValue().intValue()+0D)/rateHistory_同比.getLongValue().intValue());

                同比 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                h2_3业务指标_多维度查询.setBqz_本期值_long(当前.toString());
                h2_3业务指标_多维度查询.setHbl_环比值_String(环比.toString());
                h2_3业务指标_多维度查询.setTbl_同比值_String(同比.toString());

            }

            if(e_指标单位_sy_ex == E_指标单位_SY_EX.H_02_个 ||e_指标单位_sy_ex == E_指标单位_SY_EX.H_03_户 || e_指标单位_sy_ex == E_指标单位_SY_EX.H_04_笔 ){
                Integer 当前 = 0;
                Double 环比 = 0d;
                Double 同比 =0d;

                TargetHistory rateHistory_环比 = rateHistories_环比.get(0);
                TargetHistory rateHistory_同比 = rateHistories_同比.get(0);
                TargetHistory rateHistory = rateHistories.get(0);

                BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory.getDoubleValue()-rateHistory_环比.getDoubleValue())/rateHistory_环比.getDoubleValue());

                环比 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

                bigDecimal = BigDecimal.valueOf((rateHistory.getDoubleValue()-rateHistory_同比.getDoubleValue())/rateHistory_同比.getDoubleValue());

                同比 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                h2_3业务指标_多维度查询.setBqz_本期值_long(当前.toString());
                h2_3业务指标_多维度查询.setHbl_环比值_String(环比.toString());
                h2_3业务指标_多维度查询.setTbl_同比值_String(同比.toString());
            }



        }else{

        }




        Output_data output = new Output_data();
        output.setData(h2_3业务指标_多维度查询);
        output.setSuccess(true);
        return output;
    }




/*

        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(), df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(), df);


        List<Triplet<Long,LocalDate,LocalDate>> triplets = HistoryServiceImpl.run统计周期编码(ldt_ksrq,ldt_jsrq,statisticalIndexCodeEnum);

        Triplet<Long,LocalDate,LocalDate> triplet_0 = triplets.get(0);

        Triplet<Long,LocalDate,LocalDate> triplet_2 = triplets.get(triplets.size()-1);*/
}
