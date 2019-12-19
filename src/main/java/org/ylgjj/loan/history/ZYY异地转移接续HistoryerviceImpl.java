package org.ylgjj.loan.history;


import org.javatuples.Quintet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.H_TR100_转移接续登记簿_交易类型;
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

@Service("ZY异地转移接续HistoryerviceImpl")
public class ZYY异地转移接续HistoryerviceImpl {


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

    @Autowired
    private TR077_转移接续临时表Repository tr077_转移接续临时表Repository;




    boolean initComplte = false;

    List<TR100_转移接续登记簿> tr100_转移接续登记簿s = null;
    Map<String, TR003_转移人账户信息> tr003_转移人账户信息Map = null;
    Map<String, TR002_联系函基础信息> tr002_联系函基础信息Map = null;

    Map<String, List<TR077_转移接续临时表>> tr077_转移接续临时表Map = null;

    Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;
    List<DP004_单位缴存信息表> dp004__单位缴存信息表s = null;

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
    //TODO 历史倒推
    List<TR003_转移人账户信息> tr003_转移人账户信息s = null;
    Map<String, DP007_个人分户账> dp007_individual_sub_account_个人分户账Map = null;
   // List<TR100_转移接续登记簿> tr100_转移接续登记簿Stream = tr100_转移接续登记簿s.stream().filter(e->e.getJyrq_不可为空_交易日期().equals(loca));


    public List<Quintet<TR003_转移人账户信息,
            TR003_转移人账户信息,
            TR002_联系函基础信息,
            List<TR077_转移接续临时表>,
            CM001_单位基本资料表>> 历史倒推_某一日的缴存(LocalDate localDate) {
       // DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!initComplte) {

            tr003_转移人账户信息s = tr003_转移人账户信息_repository.findAll();

            List<TR002_联系函基础信息> tr002_联系函基础信息s = tr002_联系函基础信息_repository.findAll();

            tr100_转移接续登记簿s = tr100_转移接续登记簿Repository.findByTransdate不可为空交易日期After(LocalDate.now().minusDays(50));

            tr003_转移人账户信息Map = tr003_转移人账户信息s.stream().collect(Collectors.toMap(e -> e.getLxhbh_不可为空_联系函编号(), a -> a));
            tr002_联系函基础信息Map = tr002_联系函基础信息s.stream().collect(Collectors.toMap(e -> e.getLxhbh_不可为空_联系函编号(), a -> a));

            dp004__单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findAll();
            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));



            dp007_individual_sub_account_个人分户账Map = dp007_individual_sub_account个人分户账Repository.findAll().
                    stream().collect(Collectors.toMap(e->{
                        if(e.getAccnum_个人账号()== null){
                            System.out.println("-------------"+e.toString());
                        }

                        return e.getAccnum_个人账号();
            },a->a));





            dp005_work_unit_单位分户账Map = dp005__单位分户账_repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitaccnum单位账号(), a -> a));

            initComplte = true;
        }




        System.out.println("--------找到的时间："+localDate);

DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

        return tr003_转移人账户信息s.stream().filter(e->LocalDate.parse(e.getJyrq_不可为空_交易日期(),df).equals(localDate)).map(i -> {

            TR002_联系函基础信息 tr002_联系函基础信息 = tr002_联系函基础信息Map.get(i.getLxhbh_不可为空_联系函编号());

            tr002_联系函基础信息.getYgrzh_不可为空_原个人账号();



                    CM001_单位基本资料表 cm001_单位基本资料表 = null;
            DP005_单位分户账 dp005__单位分户账 = null;
                    if(tr002_联系函基础信息.getJylx_不可为空_交易类型().equals(H_TR100_转移接续登记簿_交易类型.转入_1.getText())){
                        dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(tr002_联系函基础信息.getDwzh_可为空_单位账号());


            }else{
                        tr002_联系函基础信息.getYgrzh_不可为空_原个人账号();
                        DP007_个人分户账 dp007__个人分户账 = dp007_individual_sub_account_个人分户账Map.
                                get(tr002_联系函基础信息.getYgrzh_不可为空_原个人账号().trim());
                       // dp007_individual_sub_account_个人分户账 = dp007_individual_sub_account个人分户账Repository.findByAccnum个人账号(tr002_联系函基础信息.getYgrzh_不可为空_原个人账号());
                    //    System.out.println("getYgrzh_不可为空_原个人账号 :"+ tr002_联系函基础信息.getYgrzh_不可为空_原个人账号()+":");

                       // System.out.println("getUnitaccnum_单位账号 :"+ dp007_individual_sub_account_个人分户账.getUnitaccnum_单位账号()+":");


                        dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(dp007__个人分户账.getUnitaccnum_单位账号());



                    }
            cm001_单位基本资料表 = cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号());

     /*               if(tr002_联系函基础信息.getJylx_不可为空_交易类型().equals(H_TR100_转移接续登记簿_交易类型.转出_2)){
                        dp005_work_unit_单位分户账 = dp005_work_unit_单位分户账Map.get(tr002_联系函基础信息.getYdw());
                    }*/
           // DP005_work_unit_单位分户账 dp005_work_unit_单位分户账 = dp005_work_unit_单位分户账Map.get({tr002_联系函基础信息.getDwzh_可为空_单位账号());
           // System.out.println("--------找到的包包dp005_work_unit_单位分户账 ："+dp005_work_unit_单位分户账.toString());

            List<TR077_转移接续临时表> tr077_转移接续临时表s = new ArrayList();//tr077_转移接续临时表Map.get(i.getLxhbh_不可为空_联系函编号());
            return Quintet.with(i, i,
                    tr002_联系函基础信息,
                    tr077_转移接续临时表s, cm001_单位基本资料表);
        }).collect(Collectors.toList());




    }


    //TODO 存储统计信息
    @Transactional
    public void saveHistoryOneTime(LocalDate n, List<Quintet<TR003_转移人账户信息,
            TR003_转移人账户信息,
            TR002_联系函基础信息,
            List<TR077_转移接续临时表>,
            CM001_单位基本资料表>> inputs) {
        inputs.stream().forEach(ee->{
            System.out.println("----------联系函号码-------"+ee.getValue0().getLxhbh_不可为空_联系函编号());
            System.out.println("----------联系函号码-------"+ee.getValue2().getLxhbh_不可为空_联系函编号());
/*            if(ee.getValue0().getJylx_不可为空_交易类型().equals(H_TR100_转移接续登记簿_交易类型.转入_1.getText())){

            }else{
                System.out.println("----------getZybj_不可为空_转移本金-------"+ee.getValue0().getZybj_不可为空_转移本金());
                System.out.println("----------getZylx_不可为空_转移利息-------"+ee.getValue0().getZylx_不可为空_转移利息());
            }*/
            System.out.println("----------getZybj_不可为空_转移本金-------"+ee.getValue0().getZybj_不可为空_转移本金());
            System.out.println("----------getZylx_不可为空_转移利息-------"+ee.getValue0().getZylx_不可为空_转移利息());

                System.out.println("-----------------"+ee.getValue4().getUnitaccname_单位名称());


        });
       inputs.stream().collect(Collectors.groupingBy(e -> e.getValue4().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {
            String 机构编码 = eee.getKey();

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(a -> a.getValue4().getUnitkind_单位性质())).entrySet()
                    .stream().forEach(uuu -> {
                LoanHistory loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_58_SEQ_外部转入金额_AND_0301007801);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称
                //外部转入金额
                loanHistory.setDoubleValue(uuu.getValue().stream().
                        filter(k -> k.getValue0().getJylx_不可为空_交易类型().equals(H_TR100_转移接续登记簿_交易类型.转入_1.getText())).
                        mapToDouble(cc -> {
                            return cc.getValue1().getZybj_不可为空_转移本金()+cc.getValue1().getZylx_不可为空_转移利息();
                        }).sum()); // 银行名称

                loanHistoryRepository.save(loanHistory);

                // 1-转入,2-转出




                //外部转入人数
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_40_SEQ_外部转入人数_AND_0301004101);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称

                loanHistory.setIntValue( uuu.getValue().stream().
                        filter(k -> k.getValue0().getJylx_不可为空_交易类型().equals(H_TR100_转移接续登记簿_交易类型.转入_1.getText())).
                        count()); // 银行名称

                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_41_SEQ_外部转出人数_AND_0301004201);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称

                loanHistory.setIntValue(uuu.getValue().stream().
                        filter(k -> k.getValue0().getJylx_不可为空_交易类型().equals(H_TR100_转移接续登记簿_交易类型.转出_2.getText())).
                        count()); // 银行名称
                loanHistoryRepository.save(loanHistory);





                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_59_SEQ_外部转出金额__本金___AND_0301007901);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称

                loanHistory.setDoubleValue(uuu.getValue().stream().
                        filter(k -> k.getValue0().getJylx_不可为空_交易类型().equals(H_TR100_转移接续登记簿_交易类型.转出_2.getText())).
                        mapToDouble(cc -> cc.getValue1().getZybj_不可为空_转移本金()).sum()); // 银行名称
                loanHistoryRepository.save(loanHistory);

                //外部转出金额(本金)


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_60_SEQ_外部转出金额__利息___AND_0301007902);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称

                loanHistory.setDoubleValue(uuu.getValue().stream().
                        filter(k -> k.getValue0().getJylx_不可为空_交易类型().equals(H_TR100_转移接续登记簿_交易类型.转出_2.getText())).
                        mapToDouble(cc -> cc.getValue1().getZylx_不可为空_转移利息()).sum()); // 银行名称
                loanHistoryRepository.save(loanHistory);


                //外部转出金额(利息)


/*                提取本金(跨中心转出)
                历史累计外部转入额
                        历史累计外部转出额
                                       StatisticalIndexCodeEnum.S_70_SEQ_历史累计外部转出额_AND_0301010601;
                StatisticalIndexCodeEnum.S_69_SEQ_历史累计外部转入额_AND_0301010501;


                        */


                loanHistoryRepository.save(loanHistory);
            });


        });
    }

    //TODO 存储统计信息
    public void 历史累计saveHistorySpan(LocalDate ldt_ksrq, LocalDate js) {
        // LocalDate year_before = ldt_ksrq.minusDays(5);
     //   StatisticalIndexCodeEnum.S_69_SEQ_历史累计外部转入额_AND_0301010501
              //  StatisticalIndexCodeEnum.S_70_SEQ_历史累计外部转出额_AND_0301010601

    }


    //TODO 存储统计信息
    public void saveHistorySpan(LocalDate ldt_ksrq, LocalDate js) {
        // LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq, js);


        System.out.println("-------------------:"+ num);
        for (int i = 0; i <= abs(num); i++) {
            LocalDate n = ldt_ksrq.minusDays(i);

            List<Quintet<TR003_转移人账户信息,
                    TR003_转移人账户信息,
                    TR002_联系函基础信息,
                    List<TR077_转移接续临时表>,
                    CM001_单位基本资料表>> aa = 历史倒推_某一日的缴存(n);
            saveHistoryOneTime(n, aa);
        }
    }


   //
    public void run() {
        saveHistorySpan(LocalDate.now().minusDays(20), LocalDate.now());
    }




}











