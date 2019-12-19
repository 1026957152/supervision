package org.ylgjj.loan.history;


import org.javatuples.Septet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.repository_flow.YourHistoryRepository;
import org.ylgjj.loan.util.DateUtilsss;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ZY总中心HistoryerviceImpl")
public class ZY总中心HistoryerviceImpl {


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
    private PB017_public_flowing公共流水登记簿Repository public_flowing公共流水登记簿Repository;


    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    private LN005_贷款分户信息_Repository lN005_贷款分户信息RepositoryLN005;


    @Autowired
    private YourHistoryRepository yourHistoryRepository;


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;



    @Autowired
    private TR100_转移接续登记簿Repository tr100_转移接续登记簿Repository;

    @Autowired
    private TR003_转移人账户信息_Repository tr003_转移人账户信息_repository;

    @Autowired
    private TR002_联系函基础信息_Repository tr002_联系函基础信息_repository;





    boolean initComplte = false;
    List<DP004_单位缴存信息表> dp004__单位缴存信息表s = null;

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
    Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;
    Map<String, List<LN008_借款人信息>> ln008_borrower_info_借款人信息Map = null;

    //TODO 历史倒推

    public List<Septet<DP004_单位缴存信息表,
            CM001_单位基本资料表,
            DP005_单位分户账,

            List<DP021_单位缴存登记簿>,
            List<DW025_公积金提取审核登记表>,

            List<DP008_单位明细账>,
            List<DP202_单位缴存变更登记簿>>> 历史倒推_某一日的缴存(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!initComplte) {
            //     dp005_workUnit_单位分户账_repository.findAll();
            dp004__单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findAll();
            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));
            dp005_work_unit_单位分户账Map = dp005__单位分户账_repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitaccnum单位账号(), a -> a));


            initComplte = true;


        }


        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(localDate);
        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP008_单位明细账> DP008_单位明细账s = dp008__单位明细账_repository.findByTransdate不可为空交易日期(localDate);


        List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);

        Map<String, List<DP021_单位缴存登记簿>> dp021_单位缴存登记簿Map
                = dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum单位账号()));
        Map<String, List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum单位账号()));

        Map<String, List<DP008_单位明细账>> DP008_单位明细账Map
                = DP008_单位明细账s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum不可为空单位账号()));


        Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map
                = dp202_单位缴存变更登记簿s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum不可为空单位账号()));

        //List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期Between(ldt_ksrq,ldt_jsrq);


        List<Septet<DP004_单位缴存信息表,
                CM001_单位基本资料表, DP005_单位分户账,
                List<DP021_单位缴存登记簿>, List<DW025_公积金提取审核登记表>,

                List<DP008_单位明细账>,
                List<DP202_单位缴存变更登记簿>
                >> pairs =
                dp004__单位缴存信息表s.stream().collect(Collectors.toList()).stream().map(e -> {
                    //TODO        获得某一日的缴存列表;


                    DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                    return Septet.with(e,
                            cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                            dp005__单位分户账,
                            dp021_单位缴存登记簿Map.get(e.getUnitaccnum单位账号()),
                            dw025_公积金提取审核登记表Map.get(e.getUnitaccnum单位账号()),

                            DP008_单位明细账Map.get(e.getUnitaccnum单位账号()),
                            dp202_单位缴存变更登记簿Map.get(e.getUnitaccnum单位账号()));
                }).collect(Collectors.toList());

        return pairs;
    }


    //TODO 存储统计信息
    @Transactional
    public void saveHistoryOneTime(LocalDate n, List<Septet<
            DP004_单位缴存信息表,
            CM001_单位基本资料表, DP005_单位分户账,

            List<DP021_单位缴存登记簿>,
            List<DW025_公积金提取审核登记表>,
            List<DP008_单位明细账>,
            List<DP202_单位缴存变更登记簿>>> inputs) {




/*
        StatisticalIndexCodeEnum.S_232_SEQ_贷款发放占缴存额比重__月___AND_0302020101("0302","0302020101","贷款发放占缴存额比重（月）"," ","19","03"," "," "," "," "," "," ","1"," ",false),
                StatisticalIndexCodeEnum.S_233_SEQ_住房公积金运用率__月___AND_0302020201("0302","0302020201","住房公积金运用率（月）"," ","19","03"," "," "," "," "," "," ","1"," ",false),
                StatisticalIndexCodeEnum.S_234_SEQ_住房公积金个贷率__月___AND_0302020301("0302","0302020301","住房公积金个贷率（月）"," ","19","03"," "," "," "," "," "," ","1"," ",false),
                StatisticalIndexCodeEnum.S_235_SEQ_住房公积金个贷逾期率__月___AND_0302020401("0302","0302020401","住房公积金个贷逾期率（月）"," ","19","03"," "," "," "," "," "," ","1"," ",false),
                StatisticalIndexCodeEnum.S_236_SEQ_住房公积金个贷增长率__月___AND_0302020501("0302","0302020501","住房公积金个贷增长率__月）"," ","19","03"," "," "," "," "," "," ","1"," ",false),


                StatisticalIndexCodeEnum.S_79_SEQ_住房公积金缴存率_AND_0301020101("0301","0301020101","住房公积金缴存率"," ","06","06"," "," "," "," "," "," ","1"," ",true),
                StatisticalIndexCodeEnum.S_80_SEQ_住房公积金覆盖率_AND_0301020201("0301","0301020201","住房公积金覆盖率"," ","06","06"," "," "," "," "," "," ","1"," ",true),
                StatisticalIndexCodeEnum.S_81_SEQ_住房公积金归集增长率_AND_0301020301("0301","0301020301","住房公积金归集增长率"," ","06","06"," "," "," "," "," "," ","1"," ",true),
                StatisticalIndexCodeEnum.S_82_SEQ_提取额占缴存额比重_AND_0301020401("0301","0301020401","提取额占缴存额比重"," ","06","06"," "," "," "," "," "," ","1"," ",true),
                StatisticalIndexCodeEnum.S_83_SEQ_住房公积金使用率_AND_0301020501("0301","0301020501","住房公积金使用率"," ","06","03"," "," "," "," "," "," ","1"," ",true),
*/










                inputs.stream().collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {
            String 机构编码 = eee.getKey();


            List<DW025_公积金提取审核登记表> aa = new ArrayList();
            eee.getValue().stream().map(ff -> {
                List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = ff.getValue4();
                return dw025_公积金提取审核登记表s == null ? new ArrayList<DW025_公积金提取审核登记表>() : dw025_公积金提取审核登记表s;
            }).forEach(e -> aa.addAll(e));


            // TODO 按照 经济类型
            aa.stream().collect(Collectors.groupingBy(e -> e.getDrawreason_提取原因())).entrySet().forEach(o -> {
                String indexNo = StatisticalIndexCodeEnum.S_37_SEQ_提取人数__提取原因___AND_0301003911.get指标编码();
                LoanHistory loanHistory = loanHistoryRepository.findByIndexNoAndDateAndIndex机构编码AndIndex提取原因(indexNo, n, 机构编码, o.getKey());
                if (loanHistory == null) {
                    loanHistory = new LoanHistory(n);
                    loanHistory.setIndexNo(indexNo);
                }

                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称

/*
                loanHistory.setValue缴存人数(uuu.getValue().stream().count());  //
                loanHistory.setValue缴存额总额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //

                loanHistory.setValue提取人数(uuu.getValue().stream().count());  //
                loanHistory.setValue提取总额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //


                loanHistory.setValue销户单位数(uuu.getValue().stream().count());  //
                loanHistory.setValue封存单位数(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //
*/

                loanHistoryRepository.save(loanHistory);


            });




        });
    }


    //TODO 存储统计信息
    public void saveHistorySpan(LocalDate ldt_ksrq, LocalDate js) {
        // LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq, js);


        for (int i = 0; i <= abs(num); i++) {
            LocalDate n = ldt_ksrq.minusDays(i);

            List<Septet<DP004_单位缴存信息表, CM001_单位基本资料表, DP005_单位分户账,

                    List<DP021_单位缴存登记簿>, List<DW025_公积金提取审核登记表>,

                    List<DP008_单位明细账>,
                    List<DP202_单位缴存变更登记簿>>> aa = 历史倒推_某一日的缴存(n);
            saveHistoryOneTime(n, aa);
        }
    }


   //
    public void run() {

       // DateUtils.truncate(LocalDate.now(), Calendar.DAY_OF_MONTH);
      //  DateUtils.ceiling(LocalDate.now(), Calendar.DAY_OF_MONTH);

        // DateUtils.truncate();
        saveHistorySpan(LocalDate.now(), LocalDate.now().minusDays(5));
    }

    }
