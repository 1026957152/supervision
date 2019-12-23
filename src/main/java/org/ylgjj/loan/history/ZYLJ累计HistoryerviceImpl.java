package org.ylgjj.loan.history;


import org.javatuples.Octet;
import org.javatuples.Septet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.domain_flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.util.DateUtilsss;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ZY累计HistoryerviceImpl")
public class ZYLJ累计HistoryerviceImpl {


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
    private DP009_个人明细账_Repository dp009_个人明细账_repository;


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;


    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");



    boolean initComplte = false;
    List<DP004_单位缴存信息表> dp004__单位缴存信息表s = null;

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;

    List<DP005_单位分户账> dp005__单位分户账s = null;
    Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;
    Map<String, List<LN008_借款人信息>> ln008_borrower_info_借款人信息Map = null;

    //TODO 历史倒推

    public List<Septet<DP021_单位缴存登记簿,
            CM001_单位基本资料表,
            DP005_单位分户账,


            DP004_单位缴存信息表,
            List<DW025_公积金提取审核登记表>,

            List<DP008_单位明细账>,
            List<DP202_单位缴存变更登记簿>>> 历史倒推_某一日的缴存(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!initComplte) {
            //     dp005_workUnit_单位分户账_repository.findAll();
            dp004__单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findAll();
            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));

            dp005__单位分户账s = dp005__单位分户账_repository.findAll();
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


        return dp021_单位缴存登记簿s.stream().collect(Collectors.toList()).stream().map(e -> {
            //TODO        获得某一日的缴存列表;


            DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


            return Septet.with(e,
                    cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                    dp005__单位分户账,
                    new DP004_单位缴存信息表(),


                    dw025_公积金提取审核登记表Map.get(e.getUnitaccnum单位账号()),

                    DP008_单位明细账Map.get(e.getUnitaccnum单位账号()),
                    dp202_单位缴存变更登记簿Map.get(e.getUnitaccnum单位账号()));
        }).collect(Collectors.toList());

    }




    public void 流水_单位开销户(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!initComplte) {
            //     dp005_workUnit_单位分户账_repository.findAll();
            dp004__单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findAll();
            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));

            dp005__单位分户账s = dp005__单位分户账_repository.findAll();
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
        })



           //     .filter(e->e.getValue0().getInaccdate不可为空入账日期().equals(n))

                .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

             // TODO 按照 经济类型
             eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                 //   S_77_SEQ_历史累计单位账户数_AND_0301011003("0301","0301011003","历史累计单位账户数"," ","05","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","03",true),
                 //         S_78_SEQ_历史累计个人账户数_AND_0301011004("0301","0301011004","历史累计个人账户数"," ","05","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","03",true),


                 LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_77_SEQ_历史累计单位账户数_AND_0301011003);


                 loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                 loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                 loanHistory.setDoubleValue(o.getValue().stream()

                         .filter(x->x.getValue2().getOpnaccdate开户日期().equals(localDate)).count());  //
                 loanHistoryRepository.save(loanHistory);




                 //  S_13_SEQ_开户总单位数_AND_0301002101("0301","0301002101","开户总单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                 loanHistory = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_13_SEQ_开户总单位数_AND_0301002101);
                 loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                 loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                 loanHistory.setIntValue(
                         o.getValue().stream()
                                 .filter(p->{
                                     return p.getValue2().getOpnaccdate开户日期().equals(localDate);
                                 }).count()
                 );
                 loanHistoryRepository.save(loanHistory);


             });


         });





    }







    List<DP006_个人缴存信息表> dp006__个人缴存信息表s = null;
    Map<String, DP006_个人缴存信息表> dp006_payment_个人缴存信息表Map = null;


    Map<String,CM002_个人基本资料表> cm002_个人基本资料表Map = null;
    Map<String, DP007_个人分户账> dp007_individual_sub_account_个人分户账Map = null;



    @Autowired
    private DP093_冻结解冻登记簿_Repository dp093_冻结解冻登记簿_repository;


    public void 流水_个人开销户(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(!initComplte){
            dp006__个人缴存信息表s = dp006__个人缴存信息表_repository.findAll();

            cm002_个人基本资料表Map = cm002个人基本资料表Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccname_个人姓名(), a->a));
            dp007_individual_sub_account_个人分户账Map = dp007_individual_sub_account个人分户账Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccnum_个人账号(),a->a));

            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));

            initComplte= true;
        }


        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByRegdate登记日期(localDate);
        List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByTransdate不可为空交易日期(localDate);
        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);

        Map<String,List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map
                = dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum个人账号()));
        Map<String,List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));

        Map<String,List<DP009_个人明细账>> dp009_个人明细账Map
                = dp009_个人明细账s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));


        Map<String,List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map
                = dp204_个人缴存变更登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));



         dp006__个人缴存信息表s.stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;


            DP007_个人分户账 dp005_work_unit_单位分户账 = dp007_individual_sub_account_个人分户账Map.get(e.getAccnum个人账号());


            return Octet.with(e,
                    cm001_单位基本资料表Map.get(dp005_work_unit_单位分户账.getUnitaccnum_单位账号()),
                    cm002_个人基本资料表Map.get(dp005_work_unit_单位分户账.getCustid_个人客户号()),
                    dp005_work_unit_单位分户账,
                    dp022_个人缴存登记簿Map.get(e.getAccnum个人账号()),
                    dw025_公积金提取审核登记表Map.get(e.getAccnum个人账号()),
                    dp009_个人明细账Map.get(e.getAccnum个人账号()),
                    dp204_个人缴存变更登记簿Map.get(e.getAccnum个人账号()));
        })
                 .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


               // S_35_SEQ_历史累计销户人数_AND_0301003802("0301","0301003802","历史累计销户人数"," ","05","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",true),

                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_35_SEQ_历史累计销户人数_AND_0301003802);


                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue3().getClsaccdate销户日期().equals(localDate)).count());  //
                loanHistoryRepository.save(loanHistory);




            });


        });





    }

    public void 流水_冻结解冻(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(!initComplte){
            dp006__个人缴存信息表s = dp006__个人缴存信息表_repository.findAll();

            cm002_个人基本资料表Map = cm002个人基本资料表Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccname_个人姓名(), a->a));
            dp007_individual_sub_account_个人分户账Map = dp007_individual_sub_account个人分户账Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccnum_个人账号(),a->a));

            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));

            initComplte= true;
        }


        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByRegdate登记日期(localDate);
        List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByTransdate不可为空交易日期(localDate);
        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);

        Map<String,List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map
                = dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum个人账号()));
        Map<String,List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));

        Map<String,List<DP009_个人明细账>> dp009_个人明细账Map
                = dp009_个人明细账s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));


        Map<String,List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map
                = dp204_个人缴存变更登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));



        dp093_冻结解冻登记簿_repository.findAll().stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;


            DP007_个人分户账 dp005_work_unit_单位分户账 = dp007_individual_sub_account_个人分户账Map.get(e.getFrzaccnum_不可为空_冻结账户账号());


            return Octet.with(e,
                    cm001_单位基本资料表Map.get(dp005_work_unit_单位分户账.getUnitaccnum_单位账号()),
                    cm002_个人基本资料表Map.get(dp005_work_unit_单位分户账.getCustid_个人客户号()),
                    dp005_work_unit_单位分户账,
                    dp022_个人缴存登记簿Map.get(e.getFrzaccnum_不可为空_冻结账户账号()),
                    dw025_公积金提取审核登记表Map.get(e.getFrzaccnum_不可为空_冻结账户账号()),
                    dp009_个人明细账Map.get(e.getFrzaccnum_不可为空_冻结账户账号()),
                    dp204_个人缴存变更登记簿Map.get(e.getFrzaccnum_不可为空_冻结账户账号()));
        })
                .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


               // S_47_SEQ_冻结总人数_AND_0301005601("0301","0301005601","冻结总人数"," ","02","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),

                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_47_SEQ_冻结总人数_AND_0301005601);


                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getTransdate不可为空交易日期().equals(localDate)).count());  //
                loanHistoryRepository.save(loanHistory);




            });


        });





    }

    public void 流水_个人提取(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(!initComplte){
            dp006__个人缴存信息表s = dp006__个人缴存信息表_repository.findAll();
            dp006_payment_个人缴存信息表Map = dp006__个人缴存信息表s.stream().collect(Collectors.toMap(e->e.getAccnum个人账号(), a->a));
            cm002_个人基本资料表Map = cm002个人基本资料表Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccname_个人姓名(), a->a));
            dp007_individual_sub_account_个人分户账Map = dp007_individual_sub_account个人分户账Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccnum_个人账号(),a->a));

            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));

            initComplte= true;
        }


        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByRegdate登记日期(localDate);
        List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByTransdate不可为空交易日期(localDate);
        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);

        Map<String,List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map
                = dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum个人账号()));
        Map<String,List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));

        Map<String,List<DP009_个人明细账>> dp009_个人明细账Map
                = dp009_个人明细账s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));


        Map<String,List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map
                = dp204_个人缴存变更登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));



        dw025_公积金提取审核登记表s.stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;


            DP007_个人分户账 dp005_work_unit_单位分户账 = dp007_individual_sub_account_个人分户账Map.get(e.getAccnum个人账号());


            return Octet.with(e,
                    cm001_单位基本资料表Map.get(dp005_work_unit_单位分户账.getUnitaccnum_单位账号()),
                    cm002_个人基本资料表Map.get(dp005_work_unit_单位分户账.getCustid_个人客户号()),
                    dp005_work_unit_单位分户账,
                    dp022_个人缴存登记簿Map.get(e.getAccnum个人账号()),
                    dp006_payment_个人缴存信息表Map.get(e.getAccnum个人账号()),
                    dp009_个人明细账Map.get(e.getAccnum个人账号()),
                    dp204_个人缴存变更登记簿Map.get(e.getAccnum个人账号()));
        })
                .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {

              //  S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203("0301","0301003203","提取人数（非本市缴存职工）"," ","02","06","bm_khjg","机构","bm_bi_khnx","开户年限"," "," ","0"," ",true),
                       // S_20_SEQ_提取金额__收入水平___AND_0301003204("0301","0301003204","提取金额(收入水平)","提取金额(收入水平包含低收入、中收入、高收入)","25","01","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","1"," ",true),


                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getTransdate交易日期().equals(localDate)).count());  //
                loanHistoryRepository.save(loanHistory);





            });
            // TODO 按照 收入水平
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue5().getBasenum_缴存基数().toString())).entrySet().forEach(o -> {

                //  S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203("0301","0301003203","提取人数（非本市缴存职工）"," ","02","06","bm_khjg","机构","bm_bi_khnx","开户年限"," "," ","0"," ",true),
                // S_20_SEQ_提取金额__收入水平___AND_0301003204("0301","0301003204","提取金额(收入水平)","提取金额(收入水平包含低收入、中收入、高收入)","25","01","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","1"," ",true),



                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_20_SEQ_提取金额__收入水平___AND_0301003204);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex收入水平(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getTransdate交易日期().equals(localDate))
                        .mapToDouble(x->x.getValue0().getDrawamt_提取金额().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


              //  S_24_SEQ_提取人次__收入水平___AND_0301003208("0301","0301003208","提取人次(收入水平)","提取人次(收入水平包含低收入、中收入、高收入)","25","03","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","0"," ",true),

                loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_24_SEQ_提取人次__收入水平___AND_0301003208);
                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex收入水平(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getTransdate交易日期().equals(localDate))
                        .map(x->x.getValue0().getDrawamt_提取金额().doubleValue()).count());  //
                loanHistoryRepository.save(loanHistory);

            });

        });





    }





    public void 流水_逾期水平(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(!initComplte){
            dp006__个人缴存信息表s = dp006__个人缴存信息表_repository.findAll();
            dp006_payment_个人缴存信息表Map = dp006__个人缴存信息表s.stream().collect(Collectors.toMap(e->e.getAccnum个人账号(), a->a));
            cm002_个人基本资料表Map = cm002个人基本资料表Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccname_个人姓名(), a->a));
            dp007_individual_sub_account_个人分户账Map = dp007_individual_sub_account个人分户账Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccnum_个人账号(),a->a));

            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));

            initComplte= true;
        }


        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByRegdate登记日期(localDate);
        List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByTransdate不可为空交易日期(localDate);
        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);

        Map<String,List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map
                = dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum个人账号()));
        Map<String,List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));

        Map<String,List<DP009_个人明细账>> dp009_个人明细账Map
                = dp009_个人明细账s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));


        Map<String,List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map
                = dp204_个人缴存变更登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));



        dw025_公积金提取审核登记表s.stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;


            DP007_个人分户账 dp005_work_unit_单位分户账 = dp007_individual_sub_account_个人分户账Map.get(e.getAccnum个人账号());


            return Octet.with(e,
                    cm001_单位基本资料表Map.get(dp005_work_unit_单位分户账.getUnitaccnum_单位账号()),
                    cm002_个人基本资料表Map.get(dp005_work_unit_单位分户账.getCustid_个人客户号()),
                    dp005_work_unit_单位分户账,
                    dp022_个人缴存登记簿Map.get(e.getAccnum个人账号()),
                    dp006_payment_个人缴存信息表Map.get(e.getAccnum个人账号()),
                    dp009_个人明细账Map.get(e.getAccnum个人账号()),
                    dp204_个人缴存变更登记簿Map.get(e.getAccnum个人账号()));
        })
                .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {

                //  S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203("0301","0301003203","提取人数（非本市缴存职工）"," ","02","06","bm_khjg","机构","bm_bi_khnx","开户年限"," "," ","0"," ",true),
                // S_20_SEQ_提取金额__收入水平___AND_0301003204("0301","0301003204","提取金额(收入水平)","提取金额(收入水平包含低收入、中收入、高收入)","25","01","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","1"," ",true),


                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getTransdate交易日期().equals(localDate)).count());  //
                loanHistoryRepository.save(loanHistory);





            });
            // TODO 按照 收入水平
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue5().getBasenum_缴存基数().toString())).entrySet().forEach(o -> {

                //  S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203("0301","0301003203","提取人数（非本市缴存职工）"," ","02","06","bm_khjg","机构","bm_bi_khnx","开户年限"," "," ","0"," ",true),
                // S_20_SEQ_提取金额__收入水平___AND_0301003204("0301","0301003204","提取金额(收入水平)","提取金额(收入水平包含低收入、中收入、高收入)","25","01","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","1"," ",true),



                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_20_SEQ_提取金额__收入水平___AND_0301003204);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex收入水平(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getTransdate交易日期().equals(localDate))
                        .mapToDouble(x->x.getValue0().getDrawamt_提取金额().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                //  S_24_SEQ_提取人次__收入水平___AND_0301003208("0301","0301003208","提取人次(收入水平)","提取人次(收入水平包含低收入、中收入、高收入)","25","03","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","0"," ",true),

                loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_24_SEQ_提取人次__收入水平___AND_0301003208);
                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex收入水平(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getTransdate交易日期().equals(localDate))
                        .map(x->x.getValue0().getDrawamt_提取金额().doubleValue()).count());  //
                loanHistoryRepository.save(loanHistory);

            });

        });





    }


    //TODO 存储统计信息
    @Transactional
    public void saveHistoryOneTime(LocalDate n, List<Septet<
            DP021_单位缴存登记簿,
            CM001_单位基本资料表,
            DP005_单位分户账,


            DP004_单位缴存信息表,
            List<DW025_公积金提取审核登记表>,

            List<DP008_单位明细账>,
            List<DP202_单位缴存变更登记簿>>> inputs) {

        inputs.stream()
                .filter(e->e.getValue0().getInaccdate不可为空入账日期().equals(n))

                .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {
            String 机构编码 = eee.getKey();

            //StatisticalIndexCodeEnum.S_67_SEQ_历史累计归集额_AND_0301010101("0301","0301010101","历史累计归集额"," ","05","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),
            // StatisticalIndexCodeEnum.S_68_SEQ_历史累计补缴额_AND_0301010201("0301","0301010201","历史累计补缴额"," ","05","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


               // S_73_SEQ_历史累计归集人数_AND_0301010801("0301","0301010801","历史累计归集人数"," ","05","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",true),
                    //    S_74_SEQ_历史累计补缴人数_AND_0301010901("0301","0301010901","历史累计补缴人数"," ","05","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",true),



                        LoanHistory loanHistory  = new LoanHistory(n,StatisticalIndexCodeEnum.S_73_SEQ_历史累计归集人数_AND_0301010801);


                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()
                        .filter(x->x.getValue0().getInaccstate_入账状态().equals("1"))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.不定额补缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常全额补缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常差额补缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.异地转入.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);




                        loanHistory  = new LoanHistory(n,StatisticalIndexCodeEnum.S_67_SEQ_历史累计归集额_AND_0301010101);


                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()
                        .filter(x->x.getValue0().getInaccstate_入账状态().equals("1"))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.不定额补缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常全额补缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常差额补缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.异地转入.getText()))
                        .mapToDouble(cc->cc.getValue0().getFactpayamt_实际缴款金额().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);







                loanHistory  = new LoanHistory(n,StatisticalIndexCodeEnum.S_74_SEQ_历史累计补缴人数_AND_0301010901);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()
                        .filter(x->x.getValue0().getInaccstate_入账状态().equals("1"))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.不定额补缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常全额补缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常差额补缴.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);





                loanHistory  = new LoanHistory(n,StatisticalIndexCodeEnum.S_68_SEQ_历史累计补缴额_AND_0301010201);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()
                        .filter(x->x.getValue0().getInaccstate_入账状态().equals("1"))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.不定额补缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常全额补缴.getText()))
                        .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常差额补缴.getText()))
                        .mapToDouble(cc->cc.getValue0().getFactpayamt_实际缴款金额().doubleValue()).sum());  //
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


            List<Septet<DP021_单位缴存登记簿,
                    CM001_单位基本资料表,
                    DP005_单位分户账,


                    DP004_单位缴存信息表,
                    List<DW025_公积金提取审核登记表>,

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
















    //TODO 存储统计信息
    public void saveHistorySpan_______(LocalDate ldt_ksrq, LocalDate js) {
        // LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq, js);


        for (int i = 0; i <= abs(num); i++) {
            LocalDate n = ldt_ksrq.minusDays(i);


            List<Septet<DP021_单位缴存登记簿,
                    CM001_单位基本资料表,
                    DP005_单位分户账,


                    DP004_单位缴存信息表,
                    List<DW025_公积金提取审核登记表>,

                    List<DP008_单位明细账>,
                    List<DP202_单位缴存变更登记簿>>> aa = 历史倒推_某一日的缴存(n);
            saveHistoryOneTime(n, aa);
        }
    }
}
