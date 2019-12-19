package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_zongfu.Mi107_业务日志;
import org.ylgjj.loan.enumT.H单位公积金缴存登记簿_入账状态;
import org.ylgjj.loan.output.H4_1业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.outputenum.E_业务类型_综服_HX;
import org.ylgjj.loan.outputenum.HX摘要码信息表;
import org.ylgjj.loan.pojo.QueryH_4_1_业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.repository.DP008单位明细账Repository;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;
import org.ylgjj.loan.repository.PB010_bank_info_大行信息表Repository;
import org.ylgjj.loan.repository_zhongfu.Mi107_业务日志_Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summarizingDouble;

/**
 * Created by silence yuan on 2015/7/25.
 */
// TODO 按渠道分配，如何区分托收是否按渠道分配
@Service
public class H4_1_业务统计_获取各渠道业务统计数据ServiceImpl {

    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private Mi107_业务日志_Repository mi107_业务日志_repository;
    @Autowired
    private DP008单位明细账Repository dp008单位明细账Repository;



    public Output H_4_1_业务统计_获取各渠道业务统计数据(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df);

        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findByDatemodifiedBetween(ldt_ksrq,ldt_jsrq);
        List<String> aa  =  null;//Arrays.asList(HX摘要码信息表.HX__85_S_预缴入账_1213,
/*
                HX摘要码信息表.HX__86_S_汇缴入账_1219,
                HX摘要码信息表.HX__87_S_正常全额补缴入账_1220,
                HX摘要码信息表.HX__89_S_不定额补缴入账_1222).stream().map(e->e.get编码()).collect(Collectors.toList());
*/



        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5887_提前还款
        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).collect(Collectors.toList());




        List<DP008_单位明细账> dp021_单位缴存登记簿s = dp008单位明细账Repository.findBySummarycode不可为空摘要代码In(aa);


        List<DP008_单位明细账> dp021_单位缴存登记簿s_peried = dp008单位明细账Repository.findBySummarycode不可为空摘要代码InAndTransdate不可为空交易日期Between(aa,ldt_ksrq,ldt_jsrq);
        double 发生额_提取= dp021_单位缴存登记簿s.stream().mapToDouble(e->e.getAmt_0_不可为空_发生额()).sum();

        double 比例_提取 = dp021_单位缴存登记簿s_peried.size() / dp021_单位缴存登记簿s.size();






        List<H4_1业务统计_获取各渠道业务统计数据> contents =  mi107_业务日志s.stream().collect(Collectors.groupingBy(e->e.getChanneltype())).entrySet()
                .stream().map(e->{
            H4_1业务统计_获取各渠道业务统计数据 h4_1业务统计_获取各渠道业务统计数据 = new H4_1业务统计_获取各渠道业务统计数据();
            DoubleSummaryStatistics 归集 = 归集(query);
            h4_1业务统计_获取各渠道业务统计数据.setBlqdmc_办理渠道_varchar_20(e.getKey());
            h4_1业务统计_获取各渠道业务统计数据.setGjbs_归集_Int(dp021_单位缴存登记簿s.size());
            h4_1业务统计_获取各渠道业务统计数据.setGjje_归集金额_Double(发生额_提取);
            h4_1业务统计_获取各渠道业务统计数据.setGjzb_归集占比_Double(比例_提取);


            h4_1业务统计_获取各渠道业务统计数据.setDkbs_贷款笔数_Int(Long.valueOf(归集.getCount()).intValue());
            h4_1业务统计_获取各渠道业务统计数据.setDkje_贷款金额_Double(归集.getSum());
            h4_1业务统计_获取各渠道业务统计数据.setDkzb_贷款占比_Double(1.0D);

            h4_1业务统计_获取各渠道业务统计数据.setDktqhkbs_提前还贷笔数_Int(Long.valueOf(归集.getCount()).intValue());
            h4_1业务统计_获取各渠道业务统计数据.setDktqhkje_提前还贷金额_Double(归集.getSum());
            h4_1业务统计_获取各渠道业务统计数据.setDktqhkzb_提前还贷占比_Double(1.0D);


            h4_1业务统计_获取各渠道业务统计数据.setTqywchdbs_提取业务偿还贷笔数_Int(Long.valueOf(归集.getCount()).intValue());
            h4_1业务统计_获取各渠道业务统计数据.setTqywchdje_提取业务偿还贷金额_Double(归集.getSum());
            h4_1业务统计_获取各渠道业务统计数据.setTqywchdzb_提取业务偿还贷占比_Double(1.0D);

                    return h4_1业务统计_获取各渠道业务统计数据;
        }).collect(Collectors.toList());


   //     List<String> aa  =  null;//Arrays.asList(HX摘要码信息表.HX__85_S_预缴入账_1213,
/*
                HX摘要码信息表.HX__86_S_汇缴入账_1219,
                HX摘要码信息表.HX__87_S_正常全额补缴入账_1220,
                HX摘要码信息表.HX__89_S_不定额补缴入账_1222).stream().map(e->e.get编码()).collect(Collectors.toList());
*/




   /*     return dp021_单位缴存登记簿s.stream().filter(e->e.getInaccstate_入账状态().equals(H单位公积金缴存登记簿_入账状态.入账.getText()))
                .collect(summarizingDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()));*/


        Output output = new Output();
        output.setData(contents);
        return output;
    }







    public DoubleSummaryStatistics 贷款(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = null;//dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(query.getKsrq(),query.getJsrq());
        return dp021_单位缴存登记簿s.stream().filter(e->e.getInaccstate_入账状态().equals(H单位公积金缴存登记簿_入账状态.入账.getText()))
                .collect(summarizingDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()));

    }



    public DoubleSummaryStatistics 归集(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = null;//dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(query.getKsrq(),query.getJsrq());
        return dp021_单位缴存登记簿s.stream().filter(e->e.getInaccstate_入账状态().equals(H单位公积金缴存登记簿_入账状态.入账.getText()))
                .collect(summarizingDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()));

    }


    public Output cache(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df);

        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findByDatemodifiedBetween(ldt_ksrq,ldt_jsrq);






        List<String> 核心业务_归集  =  Arrays.asList(HX摘要码信息表.H_22_1213_预缴入账,
                HX摘要码信息表.H_24_1219_汇缴入账,
                HX摘要码信息表.H_169_9101_单位正常汇缴入账,
                HX摘要码信息表.H_171_9103_单位预缴转汇缴入账,
                HX摘要码信息表.H_25_1220_正常全额补缴入账,
                HX摘要码信息表.H_26_1221_正常差额补缴入账,
                HX摘要码信息表.H_27_1222_不定额补缴入账,
                HX摘要码信息表.H_167_4005_财政单位汇补缴确认).stream().map(e->e.get编码()).collect(Collectors.toList());
        List<String> 综服渠道_缴存 = Arrays.asList(
                E_业务类型_综服_HX.E_5875_灵活就业人员缴存,
                E_业务类型_综服_HX.E_5818_缴存比例调整,
                E_业务类型_综服_HX.E_5813_缴存基数调整,
                E_业务类型_综服_HX.E_5866_单位缴存登记及建账,
                E_业务类型_综服_HX.E_5867_单位缴存登记信息变更,
                E_业务类型_综服_HX.E_5868_单位缴存登记注销,
                E_业务类型_综服_HX.E_5862_缴存任证打印
        ).stream().map(e->e.get编码()).collect(Collectors.toList());







        List<String> 核心业务_提取业务偿还贷  =  Arrays.asList(HX摘要码信息表.H_227_9160_提取公积金,
                HX摘要码信息表.H_228_9161_提取销户,
                HX摘要码信息表.H_10_1028_部分提取,
                HX摘要码信息表.H_11_1029_销户提取,
                HX摘要码信息表.H_33_1228_部分提取,

                HX摘要码信息表.H_34_1229_销户提取).stream().map(e->e.get编码()).collect(Collectors.toList());


        List<String> 综服渠道_提取业务偿还贷 = Arrays.asList(
                E_业务类型_综服_HX.E_5368_偿还公积金贷款提取,
                E_业务类型_综服_HX.E_5393_偿还商业贷提取
                ).stream().map(e->e.get编码()).collect(Collectors.toList());






        List<String> 核心业务_贷款  =  Arrays.asList(HX摘要码信息表.H_96_2421_贷款风险核定).stream().map(e->e.get编码()).collect(Collectors.toList());
        List<String> 综服渠道_贷款 = Arrays.asList(
                E_业务类型_综服_HX.E_5087_贷款受理,
                E_业务类型_综服_HX.E_5342_贷款预约
        ).stream().map(e->e.get编码()).collect(Collectors.toList());



        List<String> 核心业务_贷款_提前还贷  =  Arrays.asList(HX摘要码信息表.H_96_2421_贷款风险核定).stream().map(e->e.get编码()).collect(Collectors.toList());

        List<String> 综服渠道_贷款_提前还贷 = Arrays.asList(
                E_业务类型_综服_HX.E_5887_提前还款
        ).stream().map(e->e.get编码()).collect(Collectors.toList());






        List<String> 综服渠道_业务s_归集 = Arrays.asList(
                E_业务类型_综服_HX.E_5887_提前还款
        ).stream().map(e->e.get编码()).collect(Collectors.toList());


        mi107_业务日志s.stream().filter(e->综服渠道_业务s_归集.contains(e.getTranstype())).collect(Collectors.toList());




        List<DP008_单位明细账> dp021_单位缴存登记簿s = dp008单位明细账Repository.findBySummarycode不可为空摘要代码In(核心业务_归集);
        List<DP008_单位明细账> dp021_单位缴存登记簿s_peried = dp008单位明细账Repository.findBySummarycode不可为空摘要代码InAndTransdate不可为空交易日期Between(核心业务_归集,ldt_ksrq,ldt_jsrq);
        double 发生额_提取= dp021_单位缴存登记簿s.stream().mapToDouble(e->e.getAmt_0_不可为空_发生额()).sum();
        double 比例_提取 = dp021_单位缴存登记簿s_peried.size() / dp021_单位缴存登记簿s.size();






        List<H4_1业务统计_获取各渠道业务统计数据> contents =  mi107_业务日志s.stream().collect(Collectors.groupingBy(e->e.getChanneltype())).entrySet()
                .stream().map(e->{
                    H4_1业务统计_获取各渠道业务统计数据 h4_1业务统计_获取各渠道业务统计数据 = new H4_1业务统计_获取各渠道业务统计数据();
                    DoubleSummaryStatistics 归集 = 归集(query);
                    h4_1业务统计_获取各渠道业务统计数据.setBlqdmc_办理渠道_varchar_20(e.getKey());
                    h4_1业务统计_获取各渠道业务统计数据.setGjbs_归集_Int(dp021_单位缴存登记簿s.size());
                    h4_1业务统计_获取各渠道业务统计数据.setGjje_归集金额_Double(发生额_提取);
                    h4_1业务统计_获取各渠道业务统计数据.setGjzb_归集占比_Double(比例_提取);


                    h4_1业务统计_获取各渠道业务统计数据.setTqywchdbs_提取业务偿还贷笔数_Int(Long.valueOf(归集.getCount()).intValue());
                    h4_1业务统计_获取各渠道业务统计数据.setTqywchdje_提取业务偿还贷金额_Double(归集.getSum());
                    h4_1业务统计_获取各渠道业务统计数据.setTqywchdzb_提取业务偿还贷占比_Double(1.0D);




                    h4_1业务统计_获取各渠道业务统计数据.setDkbs_贷款笔数_Int(Long.valueOf(归集.getCount()).intValue());
                    h4_1业务统计_获取各渠道业务统计数据.setDkje_贷款金额_Double(归集.getSum());
                    h4_1业务统计_获取各渠道业务统计数据.setDkzb_贷款占比_Double(1.0D);

                    h4_1业务统计_获取各渠道业务统计数据.setDktqhkbs_提前还贷笔数_Int(Long.valueOf(归集.getCount()).intValue());
                    h4_1业务统计_获取各渠道业务统计数据.setDktqhkje_提前还贷金额_Double(归集.getSum());
                    h4_1业务统计_获取各渠道业务统计数据.setDktqhkzb_提前还贷占比_Double(1.0D);



                    return h4_1业务统计_获取各渠道业务统计数据;
                }).collect(Collectors.toList());





        Output output = new Output();
        output.setData(contents);
        return output;
    }



}
