package org.ylgjj.loan.history;


import org.javatuples.Septet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.domain_flow.LoanHistory;
import org.ylgjj.loan.outputenum.HX摘要码信息表;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.repository_flow.YourHistoryRepository;
import org.ylgjj.loan.util.DateUtilsss;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ZYdwjcdjb贷款流水HistoryerviceImpl")
public class ZYdwjcdjb贷款流水HistoryerviceImpl {


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
    Map<String, DP004_单位缴存信息表> dp004_unit_payment_info_单位缴存信息表Map = null;

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



/*


            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue1().getUnitkind_单位性质())).entrySet()
                    .stream().forEach(uuu->{
                LoanHistory loanHistory = new LoanHistory(n);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称




                uuu.getValue().stream().forEach(ff->{
                    List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = ff.getValue6();
                    List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = ff.getValue3();
                    List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = ff.getValue4();
                    List<DP008_单位明细账> DP008_单位明细账s = ff.getValue5();
                });









*/
/*
                loanHistory.setValue缴存人数(uuu.getValue().stream().count());  //
                loanHistory.setValue缴存额总额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //

                loanHistory.setValue提取人数(uuu.getValue().stream().count());  //
                loanHistory.setValue提取总额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //


                loanHistory.setValue销户单位数(uuu.getValue().stream().count());  //
                loanHistory.setValue封存单位数(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //
*//*







                loanHistoryRepository.save(loanHistory);
            });
*/




/*            // TODO 按照 贷款年限计算
            eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue0().getApploanterm_贷款申请年限())).entrySet()
                    .stream().forEach(uuu->{
                LoanHistory loanHistory = new LoanHistory(n);
                loanHistory.setIndex银行名称(机构编码); // 机构名称
                loanHistory.setIndex贷款申请年限(uuu.getKey()); // 银行名称



                loanHistory.setValue贷款笔数(uuu.getValue().stream().count());  //
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //

                loanHistoryRepository.save(loanHistory);
            });*/


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

   //
    public void runTest() {
        runTest_____(LocalDate.now().minusDays(1000),LocalDate.now());
    }


    public void runTest_____(LocalDate ldt_ksrq, LocalDate js) {

        long num = DateUtilsss.until( ldt_ksrq,js);

        DP004_单位缴存信息表 dp004__单位缴存信息表 = dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号("201000001726");
       // List<DP004_unit_payment_info_单位缴存信息表> dp004_unit_payment_info_单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findAll();
        List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = dp202_单位缴存变更登记簿_repository.findByUnitaccnum不可为空单位账号("201000001726");


        List<DP004_单位缴存信息表> dp004__单位缴存信息表s = new ArrayList<>();
        dp004__单位缴存信息表s.add(dp004__单位缴存信息表);
        IntStream.range(0,1).forEach(count-> {

            System.out.println("----------"+count);
            List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(dp004__单位缴存信息表s.get(count).getUnitaccnum单位账号());



            IntStream.range(0,Long.valueOf(num).intValue()).forEach(i-> {
                LocalDate n = js.minusDays(i);
               // DP021_单位缴存登记簿_flowing(dp021_单位缴存登记簿s.stream().filter(e->e.getDptype_缴存类型().equals("1")).collect(Collectors.toList()), n);
                DP202_单位缴存变更登记簿_flowing(dp202_单位缴存变更登记簿s,n);

            });

        });

    }







    public DP021_单位缴存登记簿 DP021_单位缴存登记簿_flowing(List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s, LocalDate n) {

        System.out.println("------- 正在处理 的时间"+n);
       // dp004_unit_payment_info_单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号(dp004_unit_payment_info_单位缴存信息表.getUnitaccnum单位账号());



      //  Map<String,List<DP021_单位缴存登记簿>>   dp021_单位缴存登记簿Map_flow =  dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));

        Map<Boolean,List<DP021_单位缴存登记簿>> a = dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(x->x.getRegdate不可为空登记日期().isBefore(n)));

        System.out.println("--分开的----- 之前的"+(a.get(true).size()));
        System.out.println("--分开的----- 之前的"+(a.get(false) == null));
        //System.out.println("--分开的----- 之前的"+(a.get(true).size() ==0? null : a.get(true).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //   System.out.println("--分开的----- 之h偶的"+(a.get(false)  ==null? "null" : a.get(false).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //List<DP021_单位缴存登记簿> greaterList = ee.getValue().stream().filter(x->x.getRegdate不可为空登记日期().isBefore(n)).collect(Collectors.toList());

        if(a.get(true).isEmpty()){
            System.out.println("------- 返回时空的啊啊啊啊");
            return null;
        }


        DP021_单位缴存登记簿 lastContact = Collections.max(a.get(true),
                Comparator.comparing(DP021_单位缴存登记簿::getRegdate不可为空登记日期));

        System.out.println("------- 找的一个最近的登记表啊啊"+lastContact.getRegdate不可为空登记日期());
        System.out.println("------- 应交人数 "+lastContact.getCmpaynum_本月汇缴人数());
        System.out.println("------- 缴存基数 "+lastContact.getBasenum_缴存基数());
        return lastContact;



/*
        dp021_单位缴存登记簿Map_flow.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),ee->{
            //Date maxDate = ee.getValue().stream().map(u -> u.getRegdate不可为空登记日期()).max(LocalDate::compareTo).get();

            Map<Boolean,List<DP021_单位缴存登记簿>> a = ee.getValue().stream().collect(Collectors.groupingBy(x->x.getRegdate不可为空登记日期().isBefore(n)));

            System.out.println("--分开的----- 之前的"+(a.get(true).size()));
            System.out.println("--分开的----- 之前的"+(a.get(false) == null));
            //System.out.println("--分开的----- 之前的"+(a.get(true).size() ==0? null : a.get(true).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
         //   System.out.println("--分开的----- 之h偶的"+(a.get(false)  ==null? "null" : a.get(false).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
            //List<DP021_单位缴存登记簿> greaterList = ee.getValue().stream().filter(x->x.getRegdate不可为空登记日期().isBefore(n)).collect(Collectors.toList());

            if(a.get(true).isEmpty()){
                System.out.println("------- 返回时空的啊啊啊啊");
                return null;
            }


            DP021_单位缴存登记簿 lastContact = Collections.max(a.get(true),
                    Comparator.comparing(DP021_单位缴存登记簿::getRegdate不可为空登记日期));

            System.out.println("------- 找的一个最近的登记表啊啊"+lastContact.getRegdate不可为空登记日期());
            return lastContact;
        }));*/


/*        private String basenum_缴存基数;
        private String paychgflag_汇缴额变化标志;
        private String lmpaynum_上月汇缴人数;
        private String lmpayamt_上月汇缴金额;
        private String cmpaynum_本月汇缴人数;
        private BigDecimal cmpayamt_本月汇缴金额;
        private String peoplenum_人数;
        private String monpayamt_月应缴金额;
        private BigDecimal upaytotamt_应缴总额;*/
        //   List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(localDate);

    }
    public DP202_单位缴存变更登记簿 DP202_单位缴存变更登记簿_flowing(List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s, LocalDate n) {

        System.out.println("------- 正在处理 的时间"+n);
        // dp004_unit_payment_info_单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号(dp004_unit_payment_info_单位缴存信息表.getUnitaccnum单位账号());



        //  Map<String,List<DP021_单位缴存登记簿>>   dp021_单位缴存登记簿Map_flow =  dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));

        Map<Boolean,List<DP202_单位缴存变更登记簿>> a = dp202_单位缴存变更登记簿s.stream().collect(Collectors.groupingBy(x->x.getTransdate不可为空交易日期().isBefore(n)));

        System.out.println("--分开的----- 之前的"+(a.get(true).size()));
        System.out.println("--分开的----- 之前的"+(a.get(false) == null));
        //System.out.println("--分开的----- 之前的"+(a.get(true).size() ==0? null : a.get(true).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //   System.out.println("--分开的----- 之h偶的"+(a.get(false)  ==null? "null" : a.get(false).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //List<DP021_单位缴存登记簿> greaterList = ee.getValue().stream().filter(x->x.getRegdate不可为空登记日期().isBefore(n)).collect(Collectors.toList());

        if(a.get(true).isEmpty()){
            System.out.println("------- 返回时空的啊啊啊啊");
            return null;
        }


        DP202_单位缴存变更登记簿 lastContact = Collections.max(a.get(true),
                Comparator.comparing(DP202_单位缴存变更登记簿::getTransdate不可为空交易日期));




/*        private double bfchgbasenum_不可为空_变更前基数;
        private double afchgbasenum_不可为空_变更后基数;
        private String propchgtype_可为空_比例变更类型;*/
/*  propchgtype		"0-无变化,
          1-正常比例,
          2-高比例,
          3-特殊比例"	1:_可为空_比例变更类型*/
/*        private double bfchgunitprop不可为空_变更前单位比例;
        private double afchgunitprop不可为空_变更后单位比例;
        private double bfchgindiprop不可为空_变更前个人比例;
        private double afchgindiprop不可为空_变更后个人比例;*/
        System.out.println("------- 找的一个最近的登记表啊啊"+lastContact.getTransdate不可为空交易日期());
        System.out.println("------- getAfchgbasenum_不可为空_变更后基数 "+lastContact.getAfchgbasenum_不可为空_变更后基数());
        System.out.println("------- getAfchgunitprop不可为空_变更后单位比例 "+lastContact.getAfchgunitprop不可为空_变更后单位比例());
        return lastContact;



/*
        dp021_单位缴存登记簿Map_flow.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),ee->{
            //Date maxDate = ee.getValue().stream().map(u -> u.getRegdate不可为空登记日期()).max(LocalDate::compareTo).get();

            Map<Boolean,List<DP021_单位缴存登记簿>> a = ee.getValue().stream().collect(Collectors.groupingBy(x->x.getRegdate不可为空登记日期().isBefore(n)));

            System.out.println("--分开的----- 之前的"+(a.get(true).size()));
            System.out.println("--分开的----- 之前的"+(a.get(false) == null));
            //System.out.println("--分开的----- 之前的"+(a.get(true).size() ==0? null : a.get(true).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
         //   System.out.println("--分开的----- 之h偶的"+(a.get(false)  ==null? "null" : a.get(false).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
            //List<DP021_单位缴存登记簿> greaterList = ee.getValue().stream().filter(x->x.getRegdate不可为空登记日期().isBefore(n)).collect(Collectors.toList());

            if(a.get(true).isEmpty()){
                System.out.println("------- 返回时空的啊啊啊啊");
                return null;
            }


            DP021_单位缴存登记簿 lastContact = Collections.max(a.get(true),
                    Comparator.comparing(DP021_单位缴存登记簿::getRegdate不可为空登记日期));

            System.out.println("------- 找的一个最近的登记表啊啊"+lastContact.getRegdate不可为空登记日期());
            return lastContact;
        }));*/


/*        private String basenum_缴存基数;
        private String paychgflag_汇缴额变化标志;
        private String lmpaynum_上月汇缴人数;
        private String lmpayamt_上月汇缴金额;
        private String cmpaynum_本月汇缴人数;
        private BigDecimal cmpayamt_本月汇缴金额;
        private String peoplenum_人数;
        private String monpayamt_月应缴金额;
        private BigDecimal upaytotamt_应缴总额;*/
        //   List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(localDate);

    }
    public DP008_单位明细账 DP008_单位明细账_flowing(List<DP008_单位明细账> DP008_单位明细账s, LocalDate n) {

        System.out.println("------- 正在处理 的时间"+n);
        // dp004_unit_payment_info_单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号(dp004_unit_payment_info_单位缴存信息表.getUnitaccnum单位账号());



        //  Map<String,List<DP021_单位缴存登记簿>>   dp021_单位缴存登记簿Map_flow =  dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));

        Map<Boolean,List<DP008_单位明细账>> a = DP008_单位明细账s.stream().collect(Collectors.groupingBy(x->x.getTransdate不可为空交易日期().isBefore(n)));

        System.out.println("--分开的----- 之前的"+(a.get(true).size()));
        System.out.println("--分开的----- 之前的"+(a.get(false) == null));
        //System.out.println("--分开的----- 之前的"+(a.get(true).size() ==0? null : a.get(true).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //   System.out.println("--分开的----- 之h偶的"+(a.get(false)  ==null? "null" : a.get(false).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //List<DP021_单位缴存登记簿> greaterList = ee.getValue().stream().filter(x->x.getRegdate不可为空登记日期().isBefore(n)).collect(Collectors.toList());

        if(a.get(true).isEmpty()){
            System.out.println("------- 返回时空的啊啊啊啊");
            return null;
        }


        DP008_单位明细账 lastContact = Collections.max(a.get(true),
                Comparator.comparing(DP008_单位明细账::getTransdate不可为空交易日期));

        System.out.println("------- 找的一个最近的登记表啊啊"+lastContact.getTransdate不可为空交易日期());

        System.out.println("------- 单位余额 "+lastContact.getBal_0_不可为空_余额());
        return lastContact;



/*
        dp021_单位缴存登记簿Map_flow.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),ee->{
            //Date maxDate = ee.getValue().stream().map(u -> u.getRegdate不可为空登记日期()).max(LocalDate::compareTo).get();

            Map<Boolean,List<DP021_单位缴存登记簿>> a = ee.getValue().stream().collect(Collectors.groupingBy(x->x.getRegdate不可为空登记日期().isBefore(n)));

            System.out.println("--分开的----- 之前的"+(a.get(true).size()));
            System.out.println("--分开的----- 之前的"+(a.get(false) == null));
            //System.out.println("--分开的----- 之前的"+(a.get(true).size() ==0? null : a.get(true).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
         //   System.out.println("--分开的----- 之h偶的"+(a.get(false)  ==null? "null" : a.get(false).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
            //List<DP021_单位缴存登记簿> greaterList = ee.getValue().stream().filter(x->x.getRegdate不可为空登记日期().isBefore(n)).collect(Collectors.toList());

            if(a.get(true).isEmpty()){
                System.out.println("------- 返回时空的啊啊啊啊");
                return null;
            }


            DP021_单位缴存登记簿 lastContact = Collections.max(a.get(true),
                    Comparator.comparing(DP021_单位缴存登记簿::getRegdate不可为空登记日期));

            System.out.println("------- 找的一个最近的登记表啊啊"+lastContact.getRegdate不可为空登记日期());
            return lastContact;
        }));*/


/*        private String basenum_缴存基数;
        private String paychgflag_汇缴额变化标志;
        private String lmpaynum_上月汇缴人数;
        private String lmpayamt_上月汇缴金额;
        private String cmpaynum_本月汇缴人数;
        private BigDecimal cmpayamt_本月汇缴金额;
        private String peoplenum_人数;
        private String monpayamt_月应缴金额;
        private BigDecimal upaytotamt_应缴总额;*/
        //   List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(localDate);

    }







    public DP021_单位缴存登记簿 DP021_单位缴存登记簿_flowing_按月给值(List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s, LocalDate n) {

        System.out.println("------- 正在处理 的时间"+n);
        // dp004_unit_payment_info_单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号(dp004_unit_payment_info_单位缴存信息表.getUnitaccnum单位账号());



        //  Map<String,List<DP021_单位缴存登记簿>>   dp021_单位缴存登记簿Map_flow =  dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));

        Map<Boolean,List<DP021_单位缴存登记簿>> a = dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(x->x.getRegdate不可为空登记日期().isBefore(n)));

        System.out.println("--分开的----- 之前的"+(a.get(true).size()));
        System.out.println("--分开的----- 之前的"+(a.get(false) == null));
        //System.out.println("--分开的----- 之前的"+(a.get(true).size() ==0? null : a.get(true).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //   System.out.println("--分开的----- 之h偶的"+(a.get(false)  ==null? "null" : a.get(false).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //List<DP021_单位缴存登记簿> greaterList = ee.getValue().stream().filter(x->x.getRegdate不可为空登记日期().isBefore(n)).collect(Collectors.toList());

        if(a.get(true).isEmpty()){
            System.out.println("------- 返回时空的啊啊啊啊");
            return null;
        }


        DP021_单位缴存登记簿 lastContact = Collections.max(a.get(true),
                Comparator.comparing(DP021_单位缴存登记簿::getRegdate不可为空登记日期));

        System.out.println("------- 找的一个最近的登记表啊啊"+lastContact.getRegdate不可为空登记日期());
        System.out.println("------- 缴存人数 "+lastContact.getPeoplenum_人数());
        System.out.println("------- 缴存基数 "+lastContact.getBasenum_缴存基数());
        return lastContact;



/*
        dp021_单位缴存登记簿Map_flow.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),ee->{
            //Date maxDate = ee.getValue().stream().map(u -> u.getRegdate不可为空登记日期()).max(LocalDate::compareTo).get();

            Map<Boolean,List<DP021_单位缴存登记簿>> a = ee.getValue().stream().collect(Collectors.groupingBy(x->x.getRegdate不可为空登记日期().isBefore(n)));

            System.out.println("--分开的----- 之前的"+(a.get(true).size()));
            System.out.println("--分开的----- 之前的"+(a.get(false) == null));
            //System.out.println("--分开的----- 之前的"+(a.get(true).size() ==0? null : a.get(true).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
         //   System.out.println("--分开的----- 之h偶的"+(a.get(false)  ==null? "null" : a.get(false).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
            //List<DP021_单位缴存登记簿> greaterList = ee.getValue().stream().filter(x->x.getRegdate不可为空登记日期().isBefore(n)).collect(Collectors.toList());

            if(a.get(true).isEmpty()){
                System.out.println("------- 返回时空的啊啊啊啊");
                return null;
            }


            DP021_单位缴存登记簿 lastContact = Collections.max(a.get(true),
                    Comparator.comparing(DP021_单位缴存登记簿::getRegdate不可为空登记日期));

            System.out.println("------- 找的一个最近的登记表啊啊"+lastContact.getRegdate不可为空登记日期());
            return lastContact;
        }));*/


/*        private String basenum_缴存基数;
        private String paychgflag_汇缴额变化标志;
        private String lmpaynum_上月汇缴人数;
        private String lmpayamt_上月汇缴金额;
        private String cmpaynum_本月汇缴人数;
        private BigDecimal cmpayamt_本月汇缴金额;
        private String peoplenum_人数;
        private String monpayamt_月应缴金额;
        private BigDecimal upaytotamt_应缴总额;*/
        //   List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(localDate);

    }






    public void DP202_单位缴存变更登记簿_flowing_当日动作(List<DP021_单位缴存登记簿> dp005_work_unit_单位分户账s, LocalDate n) {
        System.out.println("------- 正在处理 的时间"+n);
        // dp004_unit_payment_info_单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号(dp004_unit_payment_info_单位缴存信息表.getUnitaccnum单位账号());
        List<DP021_单位缴存登记簿> a = dp005_work_unit_单位分户账s.stream().filter(x->x.getRegdate不可为空登记日期().equals(n)).collect(Collectors.toList());


            List<DP021_单位缴存登记簿> bbb = a.stream().filter(e->{
                return e.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.不定额补缴.getText())
                        || e.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常全额补缴.getText())
                        || e.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常差额补缴.getText());
            }).collect(Collectors.toList());

        System.out.println("------- 补缴人数"+bbb.stream().mapToInt(e->e.getPeoplenum_人数()).sum());
            System.out.println("------- 补缴金额"+bbb.stream().mapToDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()).sum());

        List<DP021_单位缴存登记簿> ccc = a.stream().filter(e->{
            return e.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText());
                    }).collect(Collectors.toList());
        System.out.println("------- 实缴人次"+ccc.stream().mapToInt(e->e.getCmpaynum_本月汇缴人数()).sum());
        System.out.println("------- 实缴金额"+ccc.stream().mapToDouble(e->e.getPeoplenum_人数().doubleValue()).sum());
        System.out.println("------- 实缴人次"+ccc.stream().mapToInt(e->e.getCmpaynum_本月汇缴人数()).sum());


/*
        未缴人数

        应缴人数	0301	默认标签	json返回
        实缴人数	0301	默认标签	json返回
*/

    }
    public void DP021_单位缴存登记簿_flowing_当日动作(List<DP005_单位分户账> dp005__单位分户账s, LocalDate n) {
        System.out.println("------- 正在处理 的时间"+n);
        // dp004_unit_payment_info_单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号(dp004_unit_payment_info_单位缴存信息表.getUnitaccnum单位账号());
        Optional<DP005_单位分户账> a = dp005__单位分户账s.stream().filter(x->x.getOpnaccdate开户日期().equals(n)).findAny();

        if(a.isPresent()){
            System.out.println("------- 开户"+a.get().getOpnaccdate开户日期());
        }else{
            System.out.println("------- 没有开户 ");
        }
    }
    public void DP008_单位明细账_flowing_当日动作(List<DP008_单位明细账> DP008_单位明细账s, LocalDate n) {

        System.out.println("------- 正在处理 的时间"+n);




        List<DP008_单位明细账> a = DP008_单位明细账s.stream().filter(x->x.getTransdate不可为空交易日期().equals(n)).collect(Collectors.toList());

/*        H_227_9160_提取公积金("9160","提取公积金"),
                H_228_9161_提取销户("916","提取销户"),
        H_33_1228_部分提取("1228","部分提取"),
                H_34_1229_销户提取("1229","销户提取"),
                H_35_1231_年度结息("123","年度结息"),
                H_36_1233_销户结息("1233","销户结息"),*/

        List<String> aa  =Arrays.asList(HX摘要码信息表.H_10_1028_部分提取,
                HX摘要码信息表.H_11_1029_销户提取,
                HX摘要码信息表.H_12_1030_销户提取利息,
                HX摘要码信息表.H_13_1031_零额销户).stream().map(e->e.get编码()).collect(Collectors.toList());

       // List<DP008_单位明细账> dp021_单位缴存登记簿s = dp008单位明细账Repository.findBySummarycode不可为空摘要代码In(aa);


        List<DP008_单位明细账> bbb = a.stream().filter(e->{
            return aa.contains(e.getSummarycode不可为空摘要代码());


        }).collect(Collectors.toList());

        System.out.println("------- 提取人数"+bbb.stream().mapToLong(e->e.getPeoplenum_0_不可为空_人数()).sum());
        System.out.println("------- 提取金额"+bbb.stream().mapToDouble(e->e.getAmt_0_不可为空_发生额()).sum());



        List<String> bb  =Arrays.asList(HX摘要码信息表.H_32_1227_异地转入).stream().map(e->e.get编码()).collect(Collectors.toList());

        List<DP008_单位明细账> cc = a.stream().filter(e->{
            return aa.contains(e.getSummarycode不可为空摘要代码());


        }).collect(Collectors.toList());
        System.out.println("------- 异地转入人数"+bbb.stream().mapToLong(e->e.getPeoplenum_0_不可为空_人数()).sum());
        System.out.println("------- 异地转入金额"+bbb.stream().mapToDouble(e->e.getAmt_0_不可为空_发生额()).sum());



    }











/*    外部转入人数
    外部转出人数
    外部转入金额
    外部转出金额(本金)
    外部转出金额(利息)
    提取本金(跨中心转出)
    历史累计外部转入额
    历史累计外部转出额*/








    public void flowByUnitNumber(String aa) {


        dp004__单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findAll();


        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findAll();

        Map<String,List<DP021_单位缴存登记簿>>   dp021_单位缴存登记簿Map_flow =  dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));



        dp021_单位缴存登记簿Map_flow.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),ee->{
            //Date maxDate = ee.getValue().stream().map(u -> u.getRegdate不可为空登记日期()).max(LocalDate::compareTo).get();
            if(ee.getValue().isEmpty()){
                return null;
            }
            DP021_单位缴存登记簿 lastContact = Collections.max(ee.getValue(), Comparator.comparing(DP021_单位缴存登记簿::getRegdate不可为空登记日期));
            return lastContact;
        }));


/*        private String basenum_缴存基数;
        private String paychgflag_汇缴额变化标志;
        private String lmpaynum_上月汇缴人数;
        private String lmpayamt_上月汇缴金额;
        private String cmpaynum_本月汇缴人数;
        private BigDecimal cmpayamt_本月汇缴金额;
        private String peoplenum_人数;
        private String monpayamt_月应缴金额;
        private BigDecimal upaytotamt_应缴总额;*/
     //   List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(localDate);

    }

    //TODO ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？获取当前的一个状态
    public void saveHistoryOneTime(LocalDate localDate) {

        //从时间变化的列表中，抽取变化时记录的 状态。



/*        private String basenum_缴存基数;
        private String paychgflag_汇缴额变化标志;
        private String lmpaynum_上月汇缴人数;
        private String lmpayamt_上月汇缴金额;
        private String cmpaynum_本月汇缴人数;
        private BigDecimal cmpayamt_本月汇缴金额;
        private String peoplenum_人数;
        private String monpayamt_月应缴金额;
        private BigDecimal upaytotamt_应缴总额;*/
        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(localDate);








/*        private BigDecimal bal_提取前的余额;*/
        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);



/*        private Integer peoplenum_人数;
        private BigDecimal lbal_上笔余额;
        private BigDecimal bal_余额;*/
        List<DP008_单位明细账> DP008_单位明细账s = dp008__单位明细账_repository.findByTransdate不可为空交易日期(localDate);


























/*        private double bfchgbasenum_不可为空_变更前基数;
        private double afchgbasenum_不可为空_变更后基数;
        private String propchgtype_可为空_比例变更类型;*/
/*  propchgtype		"0-无变化,
          1-正常比例,
          2-高比例,
          3-特殊比例"	1:_可为空_比例变更类型*/
/*        private double bfchgunitprop不可为空_变更前单位比例;
        private double afchgunitprop不可为空_变更后单位比例;
        private double bfchgindiprop不可为空_变更前个人比例;
        private double afchgindiprop不可为空_变更后个人比例;*/
        List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);



    }








    public void 流水_单位缴存(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!initComplte) {
            //     dp005_workUnit_单位分户账_repository.findAll();
            dp004__单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findAll();
            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));
            dp005_work_unit_单位分户账Map = dp005__单位分户账_repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitaccnum单位账号(), a -> a));
            dp004_unit_payment_info_单位缴存信息表Map = dp004__单位缴存信息表s.stream().collect(Collectors.toMap(e->e.getUnitaccnum单位账号(), a->a));

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











        dp005__单位分户账_repository.findAll().stream().map(e -> {
            //TODO        获得某一日的缴存列表;


            DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


            return Septet.with(e,
                    cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                    dp021_单位缴存登记簿Map.get(e.getUnitaccnum单位账号()),
                    dp004_unit_payment_info_单位缴存信息表Map.get(e.getUnitaccnum单位账号()),
                    dw025_公积金提取审核登记表Map.get(e.getUnitaccnum单位账号()),

                    DP008_单位明细账Map.get(e.getUnitaccnum单位账号()),
                    dp202_单位缴存变更登记簿Map.get(e.getUnitaccnum单位账号()));
        })              .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                //      S_66_SEQ_暂存款余额_AND_0301008102

                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()


                        .mapToDouble(d->{


                            return d.getValue0().getBal_余额().doubleValue()+
                                    d.getValue2().stream()
                                            .filter(x->x.getInaccdate不可为空入账日期().isAfter(localDate))
                                            .mapToDouble(x->{
                                if(x.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText())){
                                    return x.getUpaytotamt_应缴总额().doubleValue();
                                }else{
                                    return -x.getUprepayamt_预缴户转出金额().doubleValue();
                                }
                            }).sum();


                        }).sum()
                );  //
                loanHistoryRepository.save(loanHistory);






             //   S_4_SEQ_未缴单位数_AND_0301000301("0301","0301000301","未缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                //        S_5_SEQ_实存单位数_AND_0301000401("0301","0301000401","实存单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),



                loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_4_SEQ_未缴单位数_AND_0301000301);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex经济类型(o.getKey()); // 银行名称
                loanHistory.setIntValue(o.getValue().stream()


                        .filter(d->{


                            return d.getValue2().stream()

                                            .filter(x->x.getInaccdate不可为空入账日期().equals(localDate))
                                            .filter(x->x.getBegym_开始年月().equals(localDate))

                                            .mapToInt(x->{
                                                if(x.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText())){
                                                    return 0;
                                                }else{
                                                    return 1;
                                                }
                                            }).sum()> 0;


                        }).count()
                );  //
                loanHistoryRepository.save(loanHistory);



                loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_5_SEQ_实存单位数_AND_0301000401);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex经济类型(o.getKey()); // 银行名称
                loanHistory.setIntValue(o.getValue().stream()


                        .filter(d->{


                            return d.getValue2().stream()

                                    .filter(x->x.getInaccdate不可为空入账日期().equals(localDate))
                                    .filter(x->x.getBegym_开始年月().equals(localDate))

                                    .mapToInt(x->{
                                        if(x.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText())){
                                            return 1;
                                        }else{
                                            return 0;
                                        }
                                    }).sum()> 0;


                        }).count()
                );  //
                loanHistoryRepository.save(loanHistory);
            });


        });









        dp021_单位缴存登记簿s.stream().collect(Collectors.toList()).stream().map(e -> {
                    //TODO        获得某一日的缴存列表;


                    DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                    return Septet.with(e,
                            cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                            dp005__单位分户账,
                            dp004_unit_payment_info_单位缴存信息表Map.get(e.getUnitaccnum单位账号()),
                            dw025_公积金提取审核登记表Map.get(e.getUnitaccnum单位账号()),

                            DP008_单位明细账Map.get(e.getUnitaccnum单位账号()),
                            dp202_单位缴存变更登记簿Map.get(e.getUnitaccnum单位账号()));
                })

                        .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                    // TODO 按照 经济类型
                    eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                       // S_2_SEQ_实缴单位数_AND_0301000201("0301","0301000201","实缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                          //      S_3_SEQ_实缴单位数__按年___AND_0301000202("0301","0301000202","实缴单位数(按年)"," ","01","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),

                                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201);


                        loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                        loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                        loanHistory.setIntValue(o.getValue().stream()

                                .filter(x->x.getValue0().getEndym_截止年月().equals(localDate.with(TemporalAdjusters.firstDayOfMonth())))
                                .filter(x->x.getValue0().getBegym_开始年月().equals(localDate.with(TemporalAdjusters.lastDayOfMonth())))
                                .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                        loanHistoryRepository.save(loanHistory);

                        loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_3_SEQ_实缴单位数__按年___AND_0301000202);


                        loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                        loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                        loanHistory.setIntValue(o.getValue().stream()

                                .filter(x->x.getValue0().getEndym_截止年月().equals(localDate.with(TemporalAdjusters.firstDayOfMonth())))
                                .filter(x->x.getValue0().getBegym_开始年月().equals(localDate.with(TemporalAdjusters.lastDayOfMonth())))
                                .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                        loanHistoryRepository.save(loanHistory);


















                     //   S_66_SEQ_暂存款余额_AND_0301008102("0301","0301008102","暂存款余额"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),


                       // S_11_SEQ_缴暂存款净额_AND_0301001001("0301","0301001001","缴暂存款净额"," ","03","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1"," ",false),

                        //S_1_SEQ_暂存款笔数_AND_0301000101("0301","0301000101","暂存款笔数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","04",true),


                        loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101);


                        loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                        loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                        loanHistory.setIntValue(o.getValue().stream()

                                .filter(x->x.getValue0().getEndym_截止年月().equals(localDate.with(TemporalAdjusters.firstDayOfMonth())))
                                .filter(x->x.getValue0().getBegym_开始年月().equals(localDate.with(TemporalAdjusters.lastDayOfMonth())))
                                .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                                .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                        loanHistoryRepository.save(loanHistory);



                        loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_11_SEQ_缴暂存款净额_AND_0301001001);


                        loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                        loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                        loanHistory.setDoubleValue(o.getValue().stream()

                                .filter(x->x.getValue0().getEndym_截止年月().equals(localDate.with(TemporalAdjusters.firstDayOfMonth())))
                                .filter(x->x.getValue0().getBegym_开始年月().equals(localDate.with(TemporalAdjusters.lastDayOfMonth())))
                                //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                                //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                                .mapToDouble(x->{
                                    if(x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText())){
                                        return x.getValue0().getUpaytotamt_应缴总额().doubleValue();
                                    }else{
                                        return -x.getValue0().getUprepayamt_预缴户转出金额().doubleValue();
                                    }

                                }).sum()
                                );  //
                        loanHistoryRepository.save(loanHistory);
                    });


                });


    }





}
