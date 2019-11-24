package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.CM001_单位基本资料表;
import org.ylgjj.loan.domain.DP021_单位缴存登记簿;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.UnitManagementAccountRepository;
import org.ylgjj.loan.util.DateUtilsss;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("B基本信息ServiceImpl")
public class B基本信息ServiceImpl {


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

    @Autowired
    private UnitManagementAccountRepository unitManagementAccountRepository;
    @PostConstruct
    @Transactional
    public void S_83_SEQ_住房公积金使用率_AND_0301020501__() {

        long count = dp021_单位缴存登记薄Repository.count();



        LocalDate start = LocalDate.parse("2018-08-28");
        LocalDate end = LocalDate.parse("2018-09-30");

        LocalDate now = LocalDate.now();
        LocalDate year_before = now.minusYears(1);
        long num = DateUtilsss.until(year_before);


        for(int i=0; i<=num; i++){
            LocalDate n = now.minusDays(i);
/*            private LocalDateTime regdate不可为空登记日期;
            @Column(name = "inaccdate")
            private LocalDateTime inaccdate不可为空入账日期;*/


           // findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);

            List<DP021_单位缴存登记簿> dp021_单位缴存登记薄s = null;// dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(n);
           // dp021_单位缴存登记薄s.stream().map(e->e.getFactpayamt_实际缴款金额()).collect(Static);

            DoubleSummaryStatistics ageSummary = dp021_单位缴存登记薄s.stream()
                    .collect(Collectors.summarizingDouble(p -> p.getFactpayamt_实际缴款金额().doubleValue()));
        }


/*        cm001.stream().forEach(e->{

            System.out.println("-----"+e.getLicensenum_营业执照号码());
            UnitManagementAccount unitManagementAccount =  new UnitManagementAccount();
            unitManagementAccount.setAgencyId(e.getAgentinstcode_经办机构());
            unitManagementAccountRepository.save(unitManagementAccount);
        });*/
    }

    @PostConstruct
    @Transactional
    public void S_83_SEQ_住房公积金使用率_AND_0301020501() {
        long count = dp021_单位缴存登记薄Repository.count();
        System.out.println("--dp021_单位缴存登记薄Repository---"+count);
        count = dp004_unit_payment_info单位缴存信息表Repository.count();
        System.out.println("--dp004_unit_payment_info单位缴存信息表Repository---"+count);
        Page<CM001_单位基本资料表> cm001 = cm001单位基本资料表Repository.findAll(PageRequest.of(10,10));

        System.out.println("--dp004_unit_payment_info单位缴存信息表Repository---"+cm001.toString());
/*        cm001.stream().forEach(e->{

            System.out.println("-----"+e.getLicensenum_营业执照号码());
            UnitManagementAccount unitManagementAccount =  new UnitManagementAccount();
            unitManagementAccount.setAgencyId(e.getAgentinstcode_经办机构());
            unitManagementAccountRepository.save(unitManagementAccount);
        });*/
    }


    // TODO S_83_SEQ_住房公积金使用率_AND_0301020501
    public Output S_83_SEQ_住房公积金使用率_AND_0301020501(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_83_SEQ_住房公积金使用率_AND_0301020501.name();
        dp021_单位缴存登记薄Repository.findAll();

        统计周期编码 A =统计周期编码.H__03_每月;
        //指标分类编码.H_06_归集指标;
        return null;
    }

    // TODO
    public Output S_84_SEQ_职工人数__收入水平___AND_0301020502(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_84_SEQ_职工人数__收入水平___AND_0301020502.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;

       // 指标分类编码.H_06_归集指标;
       // SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_收入水平.values()).forEach(e->{
        });

        return null;
    }




    // TODO
    public Output S_87_SEQ_当年缴存人数__收入水平___AND_0301020507(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_87_SEQ_当年缴存人数__收入水平___AND_0301020507.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__06_每年;

     //   指标分类编码.H_25_收入水平分析;
     //   SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_收入水平.values()).forEach(e->{
        });

        return null;
    }
}
