package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_zongfu.Mi107_业务日志;
import org.ylgjj.loan.enumT.H单位公积金缴存登记簿_入账状态;
import org.ylgjj.loan.output.H4_1业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.outputenum.E_业务类型_综服_HX;
import org.ylgjj.loan.outputenum.E_交易码_HX;
import org.ylgjj.loan.outputenum.E_渠道_核心_调整_HX;
import org.ylgjj.loan.outputenum.HX摘要码信息表;
import org.ylgjj.loan.pojo.Output_totalcount;
import org.ylgjj.loan.pojo.QueryH_4_1_业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.repository.DP008单位明细账Repository;
import org.ylgjj.loan.repository.PB017_公共流水登记簿_Repository;
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
    private PB017_公共流水登记簿_Repository pb017_公共流水登记簿_repository;


    @Autowired
    private Mi107_业务日志_Repository mi107_业务日志_repository;
    @Autowired
    private DP008单位明细账Repository dp008单位明细账Repository;




    public Output_totalcount H_4_1_业务统计_获取各渠道业务统计数据(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df);



        List<PB017_公共流水登记簿_Repository.PB017公共流水登记簿Dto> objects = pb017_公共流水登记簿_repository.findByChannel(ldt_ksrq,ldt_jsrq);



        Output_totalcount output = new Output_totalcount();
        output.setTotalcount(1);
        output.setData(objects.stream().collect(Collectors.groupingBy(e->e.getFirstname())).entrySet()
                            .stream().map(e->{


                                H4_1业务统计_获取各渠道业务统计数据 h4_1业务统计_获取各渠道业务统计数据 = new H4_1业务统计_获取各渠道业务统计数据();
                             //   DoubleSummaryStatistics 归集 = 归集(query);
                                h4_1业务统计_获取各渠道业务统计数据.setBlqdmc_办理渠道_varchar_20(E_渠道_核心_调整_HX.fromOld(e.getKey()).get名称());


                                Integer count = e.getValue().stream().filter(x->{
                                    return 归集_核心(null).contains(x.getLastname());
                                }).mapToInt(x->x.getCc().intValue()).sum();
                                Double value = e.getValue().stream().filter(x->{
                                    return 归集_核心(null).contains(x.getLastname());
                                }).mapToInt(x->x.getCc().intValue()).sum()+0d;

                                h4_1业务统计_获取各渠道业务统计数据.setGjbs_归集_Int(count);
                                h4_1业务统计_获取各渠道业务统计数据.setGjje_归集金额_Double(value);
                                h4_1业务统计_获取各渠道业务统计数据.setGjzb_归集占比_Double(1.0d);


                                Integer count_贷款 = e.getValue().stream().filter(x->{
                                    return 归集_核心(null).contains(x.getLastname());
                                }).mapToInt(x->x.getCc().intValue()).sum();
                                Double value_贷款 = e.getValue().stream().filter(x->{
                                    return 归集_核心(null).contains(x.getLastname());
                                }).mapToInt(x->x.getCc().intValue()).sum()+0d;

                                h4_1业务统计_获取各渠道业务统计数据.setDkbs_贷款笔数_Int(count_贷款);
                                h4_1业务统计_获取各渠道业务统计数据.setDkje_贷款金额_Double(value_贷款);
                                h4_1业务统计_获取各渠道业务统计数据.setDkzb_贷款占比_Double(1.0D);


                                Integer count_提前还贷 = e.getValue().stream().filter(x->{
                                    return 归集_核心(null).contains(x.getLastname());
                                }).mapToInt(x->x.getCc().intValue()).sum();
                                Double value_提前还贷 = e.getValue().stream().filter(x->{
                                    return 归集_核心(null).contains(x.getLastname());
                                }).mapToInt(x->x.getCc().intValue()).sum()+0d;

                                h4_1业务统计_获取各渠道业务统计数据.setDktqhkbs_提前还贷笔数_Int(count_提前还贷);
                                h4_1业务统计_获取各渠道业务统计数据.setDktqhkje_提前还贷金额_Double(value_提前还贷);
                                h4_1业务统计_获取各渠道业务统计数据.setDktqhkzb_提前还贷占比_Double(1.0D);

                                Integer count_提取业务偿还贷 = e.getValue().stream().filter(x->{
                                    return 归集_核心(null).contains(x.getLastname());
                                }).mapToInt(x->x.getCc().intValue()).sum();
                                Double value_提取业务偿还贷 = e.getValue().stream().filter(x->{
                                    return 归集_核心(null).contains(x.getLastname());
                                }).mapToInt(x->x.getCc().intValue()).sum()+0d;
                                h4_1业务统计_获取各渠道业务统计数据.setTqywchdbs_提取业务偿还贷笔数_Int(count_提取业务偿还贷);
                                h4_1业务统计_获取各渠道业务统计数据.setTqywchdje_提取业务偿还贷金额_Double(value_提取业务偿还贷);
                                h4_1业务统计_获取各渠道业务统计数据.setTqywchdzb_提取业务偿还贷占比_Double(1.0D);

                                return h4_1业务统计_获取各渠道业务统计数据;



                }).collect(Collectors.toList()));

        ;



        output.setSuccess(true);
        return output;
    }
























    public Output H_4_1_业务统计_获取各渠道业务统计数据_BACK(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {
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

        List<PB017_公共流水登记簿_Repository.PB017公共流水登记簿Dto> objects = pb017_公共流水登记簿_repository.findByChannel(ldt_ksrq,ldt_jsrq);


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






        List<String> 核心业务_归集  =  Arrays.asList(
                HX摘要码信息表.H_22_1213_预缴入账,
                HX摘要码信息表.H_24_1219_汇缴入账,
                HX摘要码信息表.H_169_9101_单位正常汇缴入账,
                HX摘要码信息表.H_171_9103_单位预缴转汇缴入账,
                HX摘要码信息表.H_25_1220_正常全额补缴入账,
                HX摘要码信息表.H_26_1221_正常差额补缴入账,
                HX摘要码信息表.H_27_1222_不定额补缴入账,
                HX摘要码信息表.H_167_4005_财政单位汇补缴确认

        ).stream().map(e->e.get编码()).collect(Collectors.toList());
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

    public List<String> 冲还贷_核心(LocalDate localDate) {
        //   List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5368_偿还公积金贷款提取

        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return 业务s;

    }
    public  List<String> 归集_核心(LocalDate localDate) {

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5875_灵活就业人员缴存,
                E_业务类型_综服_HX.E_5351_缴存预约,
                E_业务类型_综服_HX.E_5486_预缴入账,
                E_业务类型_综服_HX.E_5487_补缴入账,
                E_业务类型_综服_HX.E_5858_单位暂存款登记,
                E_业务类型_综服_HX.E_5859_单位缴存入账


        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return 业务s;

    }
    public List<String> 提取还款_提前还款(LocalDate localDate) {

        List<String> 业务s = Arrays.asList(
                E_交易码_HX.HX__120805_提前还款登记撤销_ln_10011000


        ).stream().map(e->e.getPF03TRANCODE()).collect(Collectors.toList());
        return 业务s;



    }
    public List<String> 提取_核心(LocalDate localDate) {
        List<String> 业务s = Arrays.asList(

                E_业务类型_综服_HX.E_5367_物业费提取,
                E_业务类型_综服_HX.E_5368_偿还公积金贷款提取,
                E_业务类型_综服_HX.E_5372_租房提取,
                E_业务类型_综服_HX.E_5373_其他住房消费类提取,
                E_业务类型_综服_HX.E_5391_住宅专项维修基金提取,
                E_业务类型_综服_HX.E_5392_贷款首付提取,
                E_业务类型_综服_HX.E_5393_偿还商业贷提取
        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return 业务s;
    }
    public List<String> 信息变更_核心(LocalDate localDate) {

        List<String> 业务s = Arrays.asList(

                E_交易码_HX.HX__122030_借款人基本信息变更_ln_10000000,
                E_交易码_HX.HX__160006_变更单位全部基本资料_cm_10111000,
                E_交易码_HX.HX__160011_变更单位常用基本资料_cm_10111000,
                E_交易码_HX.HX__160015_变更个人基本资料_cm_10111000,
                E_交易码_HX.HX__160115_网厅个人基本资料变更_cm_10000000,
                E_交易码_HX.HX__168010_网厅单位基本资料变更_cm_10111000,
                E_交易码_HX.HX__168110_新网厅单位资料变更_cm_10000000,
                E_交易码_HX.HX__430006_个人查询密码变更_qr_10111000,
                E_交易码_HX.HX__430010_单位查询密码变更_qr_10111000,
                E_交易码_HX.HX__430207_查询机单位密码变更_qr_10000000,
                E_交易码_HX.HX__110069_网厅缴存基数变更_dp_10100000,
                E_交易码_HX.HX__111020_个人基数变更_dp_10111000,
                E_交易码_HX.HX__111036_自由职业者协议变更_dp_10111000,
                E_交易码_HX.HX__111039_军转干部协议变更_dp_10111000,
                E_交易码_HX.HX__115022_网厅单位比例变更_dp_10000000,
                E_交易码_HX.HX__111041_委托收款合同变更_dp_10111000,
                E_交易码_HX.HX__116002_灵活就业人员缴存基数变更_dp_11111000,
                E_交易码_HX.HX__116003_灵活就业人员缴存比例变更_dp_11111000,

                E_交易码_HX.HX__120100_抵押人变更_ln_10000000,
                E_交易码_HX.HX__120101_抵押物变更_ln_10000000,

                E_交易码_HX.HX__120108_质押人变更_ln_10100000,
                E_交易码_HX.HX__120109_质押物变更_ln_10000000,
                E_交易码_HX.HX__120149_借款人变更_ln_10111000,
                E_交易码_HX.HX__120153_还款方式变更_ln_10111000,


                E_交易码_HX.HX__121401_担保方式变更_ln_10111000,
                E_交易码_HX.HX__121501_公积金担保变更_ln_10111000,
                E_交易码_HX.HX__121502_保人关系变更_ln_10000000,
                E_交易码_HX.HX__121023_开发商保证金开户银行信息变更_ln_10111000,
                E_交易码_HX.HX__122030_借款人基本信息变更_ln_10000000,
                E_交易码_HX.HX__120385_贷后信息变更查询_ln_10011000



        ).stream().map(e->e.getPF03TRANCODE()).collect(Collectors.toList());



        return 业务s;
    }
    public List<String> 缴存基数_核心(LocalDate localDate) {

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5813_缴存基数调整
        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return 业务s;
    }

}
