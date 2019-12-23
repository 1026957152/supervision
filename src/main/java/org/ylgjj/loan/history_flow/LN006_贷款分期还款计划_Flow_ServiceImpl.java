package org.ylgjj.loan.history_flow;


import org.javatuples.Quartet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_LN101_贷款明细账_资金来源;
import org.ylgjj.loan.enumT.E_LN006_贷款分期还款计划_curseqStatusEnum;
import org.ylgjj.loan.enumT.H_LN101_贷款明细_结算方式;
import org.ylgjj.loan.domain_flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Math.abs;
import static org.ylgjj.loan.history_flow.DP021_单位缴存登记簿_Flow_HistoryerviceImpl.run统计周期编码;
import static org.ylgjj.loan.history_flow.DP021_单位缴存登记簿_Flow_HistoryerviceImpl.run统计周期编码Quartet;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("LN006_贷款分期还款计划_Flow_ServiceImpl")
public class LN006_贷款分期还款计划_Flow_ServiceImpl extends BaseServiceImpl{


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
    private LoanHistoryRepository loanHistoryRepository;



    boolean initComplte = false;
    List<LN003_合同信息> ln003_合同信息s = null;





    //TODO 历史倒推
    // TODO S_140_SEQ_贷款余额_AND_0302000801
    public void 历史倒推_某一日的贷款(LocalDate beginDateTotal,LocalDate endDateTotal) {





        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/*
        if(!initComplte){
            ln003__合同信息s = ln003_contract_info_repository.findAll();
            ln003_contract_info_合同信息Map = ln003_contract_info_repository.findAll().stream().
                    collect(Collectors.toMap(e->e.getLoancontrcode合同代码(),a->a));

            List<LN005_lone_sub_account_贷款分户信息> ln005_lone_sub_account_贷款分户信息s = lN005_lone_sub_accountRepository.findAll().stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).collect(Collectors.toList());
            ln005_lone_sub_account_贷款分户信息Map = ln005_lone_sub_account_贷款分户信息s.stream().collect(Collectors.toMap(e->e.getLoancontrcode合同代码(),e->e));

            ln0014_trading_house_贷款房屋信息Map = ln014_tradingHouse_贷款房屋信息Repository.findAll().stream().collect(Collectors.toMap(e->e.getLoancontrcode0合同代码(),e->e));

            ln008_borrower_info_借款人信息Map = lN008_借款人类型Repository.findAll().stream().filter(e->e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText()))
                    .collect(Collectors.groupingBy(e->e.getLoancontrcode合同代码()));
            initComplte= true;
        }


        */



        List<LN006_贷款分期还款计划> ln006__贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByRepaydate1还款日期Between(beginDateTotal,endDateTotal);

        List<String> dps=  ln006__贷款分期还款计划s.stream().map(e->e.getLoanaccnum0贷款账号()).collect(Collectors.toList());



        //Map<String,List<LN008_借款人信息>> ln008_借款人信息Map = null;
        Map<String, LN003_合同信息> ln003_合同信息Map =  ln003_合同信息Map(dps);
        Map<String, List<LN005_贷款分户信息>>  ln005_贷款分户信息Map = ln005_贷款分户信息Map(dps);
        Map<String, LN014_贷款房屋信息> ln014_贷款房屋信息Map = ln014_贷款房屋信息Map(dps);
        Map<String,List<LN008_借款人信息>> ln008_借款人信息Map = ln008_借款人信息Map(dps);

        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_107_SEQ_回收额_AND_0302000201);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue5().getAgentbankcode_经办银行())).entrySet().forEach(uuu -> {

/*                StatisticalIndexCodeEnum.S_169_SEQ_回收户数_AND_0302002101
                StatisticalIndexCodeEnum.S_124_SEQ_回收利息_AND_0302000401
                StatisticalIndexCodeEnum.S_107_SEQ_回收额_AND_0302000201;*/

                    LoanHistory loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_107_SEQ_回收额_AND_0302000201);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setSeqNum(t.getValue0());

                    loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);


                });


            });







        });




        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_169_SEQ_回收户数_AND_0302002101);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s,
                            ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue5().getAgentbankcode_经办银行())).entrySet().forEach(uuu -> {

/*                StatisticalIndexCodeEnum.S_169_SEQ_回收户数_AND_0302002101
                StatisticalIndexCodeEnum.S_124_SEQ_回收利息_AND_0302000401
                StatisticalIndexCodeEnum.S_107_SEQ_回收额_AND_0302000201;*/

                    LoanHistory loanHistory =new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_169_SEQ_回收户数_AND_0302002101);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().size());  //
                    loanHistoryRepository.save(loanHistory);


                });


            });







        });







        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_169_SEQ_回收户数_AND_0302002101);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue5().getAgentbankcode_经办银行())).entrySet().forEach(uuu -> {

/*                StatisticalIndexCodeEnum.S_169_SEQ_回收户数_AND_0302002101
                StatisticalIndexCodeEnum.S_124_SEQ_回收利息_AND_0302000401
                StatisticalIndexCodeEnum.S_107_SEQ_回收额_AND_0302000201;*/

                    LoanHistory loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_169_SEQ_回收户数_AND_0302002101);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().size());  //
                    loanHistoryRepository.save(loanHistory);


                });


            });







        });




        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_124_SEQ_回收利息_AND_0302000401);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue5().getAgentbankcode_经办银行())).entrySet().forEach(uuu -> {

/*                StatisticalIndexCodeEnum.S_169_SEQ_回收户数_AND_0302002101
                StatisticalIndexCodeEnum.S_124_SEQ_回收利息_AND_0302000401
                StatisticalIndexCodeEnum.S_107_SEQ_回收额_AND_0302000201;*/



                    LoanHistory loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_124_SEQ_回收利息_AND_0302000401);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);



                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_108_SEQ_回收额__正常___AND_0302000202);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


/*                StatisticalIndexCodeEnum.S_170_SEQ_回收户数__正常___AND_0302002102
                StatisticalIndexCodeEnum.S_125_SEQ_回收利息__正常___AND_0302000402
                StatisticalIndexCodeEnum.S_108_SEQ_回收额__正常___AND_0302000202;*/
                    LoanHistory loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_108_SEQ_回收额__正常___AND_0302000202);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.正常归还.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);




                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_170_SEQ_回收户数__正常___AND_0302002102);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                 loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_170_SEQ_回收户数__正常___AND_0302002102);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.正常归还.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);




                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_125_SEQ_回收利息__正常___AND_0302000402);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory
                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_125_SEQ_回收利息__正常___AND_0302000402);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.正常归还.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);




                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_109_SEQ_回收额__逾期___AND_0302000203);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_109_SEQ_回收额__逾期___AND_0302000203);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);




                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_171_SEQ_回收户数__逾期___AND_0302002103);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory


                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_171_SEQ_回收户数__逾期___AND_0302002103);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);




                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_126_SEQ_回收利息__逾期___AND_0302000403);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_126_SEQ_回收利息__逾期___AND_0302000403);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);




                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_172_SEQ_回收户数__提前还本___AND_0302002104);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory/*                StatisticalIndexCodeEnum.S_172_SEQ_回收户数__提前还本___AND_0302002104
                StatisticalIndexCodeEnum.S_127_SEQ_回收利息__提前还本___AND_0302000404
                StatisticalIndexCodeEnum.S_110_SEQ_回收额__提前还本___AND_0302000204;*/



                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_172_SEQ_回收户数__提前还本___AND_0302002104);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);





                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_172_SEQ_回收户数__提前还本___AND_0302002104);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory/*                StatisticalIndexCodeEnum.S_172_SEQ_回收户数__提前还本___AND_0302002104
                StatisticalIndexCodeEnum.S_127_SEQ_回收利息__提前还本___AND_0302000404
                StatisticalIndexCodeEnum.S_110_SEQ_回收额__提前还本___AND_0302000204;*/



                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_172_SEQ_回收户数__提前还本___AND_0302002104);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);





                });


            });







        });

        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_127_SEQ_回收利息__提前还本___AND_0302000404);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_127_SEQ_回收利息__提前还本___AND_0302000404);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);






                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_111_SEQ_回收额__正常还清___AND_0302000205);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory/*                StatisticalIndexCodeEnum.S_173_SEQ_回收户数__正常还清___AND_0302002105
                StatisticalIndexCodeEnum.S_128_SEQ_回收利息__正常还清___AND_0302000405
                StatisticalIndexCodeEnum.S_111_SEQ_回收额__正常还清___AND_0302000205;*/ /// TODO ??????????????
                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_111_SEQ_回收额__正常还清___AND_0302000205);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);






                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_173_SEQ_回收户数__正常还清___AND_0302002105);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_173_SEQ_回收户数__正常还清___AND_0302002105);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);





                });


            });







        });



        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_111_SEQ_回收额__正常还清___AND_0302000205);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory/*                StatisticalIndexCodeEnum.S_174_SEQ_回收户数__提前还清___AND_0302002106
                StatisticalIndexCodeEnum.S_129_SEQ_回收利息__提前还清___AND_0302000406
                StatisticalIndexCodeEnum.S_112_SEQ_回收额__提前还清___AND_0302000206;*/
                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_111_SEQ_回收额__正常还清___AND_0302000205);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前全部.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);







                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_173_SEQ_回收户数__正常还清___AND_0302002105);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_173_SEQ_回收户数__正常还清___AND_0302002105);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前全部.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);







                });


            });







        });



        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_173_SEQ_回收户数__正常还清___AND_0302002105);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_173_SEQ_回收户数__正常还清___AND_0302002105);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前全部.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);







                });


            });







        });
        
        
        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_128_SEQ_回收利息__正常还清___AND_0302000405);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                  loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_128_SEQ_回收利息__正常还清___AND_0302000405);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前全部.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);




                });


            });







        });





        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_115_SEQ_回收额__5年以内含___AND_0302000210);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory/*                StatisticalIndexCodeEnum.S_132_SEQ_回收利息__5年以下含___AND_0302000410
                StatisticalIndexCodeEnum.S_115_SEQ_回收额__5年以内含___AND_0302000210;*/
                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_115_SEQ_回收额__5年以内含___AND_0302000210);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue5().getLoanterm_贷款期限()< 5*13)
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);




                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_132_SEQ_回收利息__5年以下含___AND_0302000410);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_132_SEQ_回收利息__5年以下含___AND_0302000410);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue5().getLoanterm_贷款期限()< 5*13)
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);




                });


            });







        });







        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_115_SEQ_回收额__5年以内含___AND_0302000210);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory/*                StatisticalIndexCodeEnum.S_133_SEQ_回收利息__5年以上___AND_0302000411
                StatisticalIndexCodeEnum.S_116_SEQ_回收额__5年以上___AND_0302000211;*/
                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_115_SEQ_回收额__5年以内含___AND_0302000210);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue5().getLoanterm_贷款期限()> 5*13)
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);




                });


            });







        });




        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_132_SEQ_回收利息__5年以下含___AND_0302000410);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_132_SEQ_回收利息__5年以下含___AND_0302000410);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->z.getValue5().getLoanterm_贷款期限()> 5*13)
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);



                });


            });







        });




        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_117_SEQ_回收额__现金___AND_0302000212);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory  /*              StatisticalIndexCodeEnum.S_117_SEQ_回收额__现金___AND_0302000212;
                StatisticalIndexCodeEnum.S_118_SEQ_回收额__冲还贷___AND_0302000213;*/

                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_117_SEQ_回收额__现金___AND_0302000212);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()

                            .filter(z->{
                                return z.getValue4().stream().map(g->g.getSettlemode不可为空_结算方式().equals(H_LN101_贷款明细_结算方式.E_2_现金)).count()>0;
                            })
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);



                });


            });







        });



        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_118_SEQ_回收额__冲还贷___AND_0302000213);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_118_SEQ_回收额__冲还贷___AND_0302000213);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()

                            .filter(z->{
                                return z.getValue4().stream().map(g->g.getSettlemode不可为空_结算方式().equals(H_LN101_贷款明细_结算方式.E_4_委托扣款)).count()>0;
                            })
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);


                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_113_SEQ_回收额__本行回收___AND_0302000207);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory/*
                StatisticalIndexCodeEnum.S_175_SEQ_回收户数__本行回收___AND_0302002107
                StatisticalIndexCodeEnum.S_130_SEQ_回收利息__本行回收___AND_0302000407
                StatisticalIndexCodeEnum.S_113_SEQ_回收额__本行回收___AND_0302000207;
*/

                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_113_SEQ_回收额__本行回收___AND_0302000207);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .filter(z->{
                                return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                            })
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);


                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_175_SEQ_回收户数__本行回收___AND_0302002107);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory/*
                StatisticalIndexCodeEnum.S_175_SEQ_回收户数__本行回收___AND_0302002107
                StatisticalIndexCodeEnum.S_130_SEQ_回收利息__本行回收___AND_0302000407
                StatisticalIndexCodeEnum.S_113_SEQ_回收额__本行回收___AND_0302000207;
*/
                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_175_SEQ_回收户数__本行回收___AND_0302002107);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->{
                                return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                            })
                            //  .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);


                });


            });







        });



        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_130_SEQ_回收利息__本行回收___AND_0302000407);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory/*
                StatisticalIndexCodeEnum.S_175_SEQ_回收户数__本行回收___AND_0302002107
                StatisticalIndexCodeEnum.S_130_SEQ_回收利息__本行回收___AND_0302000407
                StatisticalIndexCodeEnum.S_113_SEQ_回收额__本行回收___AND_0302000207;
*/
                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_130_SEQ_回收利息__本行回收___AND_0302000407);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->{
                                return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                            })
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);



                });


            });







        });




        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_114_SEQ_回收额__他行回收___AND_0302000208);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory/*
                StatisticalIndexCodeEnum.S_175_SEQ_回收户数__本行回收___AND_0302002107
                StatisticalIndexCodeEnum.S_130_SEQ_回收利息__本行回收___AND_0302000407
                StatisticalIndexCodeEnum.S_113_SEQ_回收额__本行回收___AND_0302000207;
*/

/*                StatisticalIndexCodeEnum.S_176_SEQ_回收户数__他行回收___AND_0302002108
                StatisticalIndexCodeEnum.S_131_SEQ_回收利息__他行回收___AND_0302000408
                StatisticalIndexCodeEnum.S_114_SEQ_回收额__他行回收___AND_0302000208;*/


                            loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_114_SEQ_回收额__他行回收___AND_0302000208);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .filter(z->{
                                return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                            })
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);



                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_176_SEQ_回收户数__他行回收___AND_0302002108);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_176_SEQ_回收户数__他行回收___AND_0302002108);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->{
                                return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                            })
                            //  .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .count());  //
                    loanHistoryRepository.save(loanHistory);



                });


            });







        });


        triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_131_SEQ_回收利息__他行回收___AND_0302000408);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的贷款余额;
                List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(beginDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if(ln101_贷款明细账_account.isPresent()){
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                }else{
                    return null;
                }
            }).collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
                String 机构编码 = eee.getKey();


                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue3().get(0).getUnitaccnum_1_单位账号())).entrySet().forEach(uuu -> {


                    LoanHistory                loanHistory = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_131_SEQ_回收利息__他行回收___AND_0302000408);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                    loanHistory.setValue贷款金额(uuu.getValue().stream()
                            .filter(z->{
                                return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                            })
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                    loanHistoryRepository.save(loanHistory);



                });


            });







        });














    }




















































































    //TODO 历史倒推
    // TODO S_140_SEQ_贷款余额_AND_0302000801
    public void 流水_历史还款明细(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<LN006_贷款分期还款计划> ln006__贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByRepaydate1还款日期(localDate);

        List<String> dps=  ln006__贷款分期还款计划s.stream().map(e->e.getLoanaccnum0贷款账号()).collect(Collectors.toList());



        //Map<String,List<LN008_借款人信息>> ln008_借款人信息Map = null;
        Map<String, LN003_合同信息> ln003_合同信息Map =  ln003_合同信息Map(dps);
        Map<String, List<LN005_贷款分户信息>>  ln005_贷款分户信息Map = ln005_贷款分户信息Map(dps);
        Map<String, LN014_贷款房屋信息> ln014_贷款房屋信息Map = ln014_贷款房屋信息Map(dps);
        Map<String,List<LN008_借款人信息>> ln008_借款人信息Map = ln008_借款人信息Map(dps);



        //   List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期Between(ldt_ksrq,ldt_jsrq);


        ln006__贷款分期还款计划s.stream().map(e-> {



            //TODO        获得某一日的贷款余额;
            List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);
            Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
            if(ln101_贷款明细账_account.isPresent()){
                LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode0合同代码());

                return Sextet.with(e,
                        ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                        ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                        ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                        ln101_贷款明细账_s, ln003__合同信息);
            }else{
                return null;
            }
        }) .collect(Collectors.groupingBy(e -> e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee -> {

            // TODO 按照 银行
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue5().getAgentbankcode_经办银行())).entrySet().forEach(o -> {


              //  S_212_SEQ_历史累计逾期本息_AND_0302010701("0302","0302010701","历史累计逾期本息"," ","18","01","bm_khjg","机构","bm_yhbm","银行名称"," "," ","1","01",false),
                 //       S_213_SEQ_历史累计逾期本金_AND_0302010702("0302","0302010702","历史累计逾期本金"," ","18","01","bm_khjg","机构","bm_yhbm","银行名称"," "," ","1","01",false),
                   //     S_214_SEQ_历史累计逾期利息_AND_0302010703("0302","0302010703","历史累计逾期利息"," ","18","01","bm_khjg","机构","bm_yhbm","银行名称"," "," ","1","01",false),



                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_212_SEQ_历史累计逾期本息_AND_0302010701);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getEnddate0终止日期().isBefore(localDate))
                        .filter(x->x.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                        .filter(x->x.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))

                        .mapToDouble(x->x.getValue0().getPlanint本期应还利息0().add(x.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_213_SEQ_历史累计逾期本金_AND_0302010702);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getEnddate0终止日期().isBefore(localDate))
                        .filter(x->x.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                        .filter(x->x.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))

                        .mapToDouble(x->x.getValue0().getPlanprin0本期应还本金().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);

                loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_214_SEQ_历史累计逾期利息_AND_0302010703);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getEnddate0终止日期().isBefore(localDate))
                        .filter(x->x.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                        .filter(x->x.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))

                        .mapToDouble(x->x.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);
            });

        });

    }







    //
    public void run_() {

        流水_还款明细( LocalDate.now().minusDays(3),LocalDate.now());

    }
    public void 流水_还款明细(LocalDate beginDateTotal,LocalDate endDateTotal) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");



        List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期Between(beginDateTotal,endDateTotal);
        List<String> dps=  ln101_贷款明细账_s.stream().map(e->e.getLoancontrcode不可为空_合同代码()).collect(Collectors.toList());


        logger.debug("--LN101_贷款明细账_account-------{}-------------",dps);
        //   List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期Between(ldt_ksrq,ldt_jsrq);


        //Map<String,List<LN008_借款人信息>> ln008_借款人信息Map = null;
        Map<String, LN003_合同信息> ln003_合同信息Map =  ln003_合同信息Map(dps);
        Map<String, List<LN005_贷款分户信息>>  ln005_贷款分户信息Map = ln005_贷款分户信息Map(dps);
        Map<String, LN014_贷款房屋信息> ln014_贷款房屋信息Map = ln014_贷款房屋信息Map(dps);
        Map<String,List<LN008_借款人信息>> ln008_借款人信息Map = ln008_借款人信息Map(dps);


        List<Quartet<Long,LocalDate,LocalDate,StatisticalIndexCodeEnum>> triplets = run统计周期编码Quartet(beginDateTotal,endDateTotal,
                StatisticalIndexCodeEnum.S_118_SEQ_回收额__冲还贷___AND_0302000213);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();
            ln101_贷款明细账_s
                    .stream()
                    .filter(x->x.getTransdate不可为空交易日期().equals(beginDate) || x.getTransdate不可为空交易日期().equals(endDate))
                  //  .filter(x->x.getTransdate不可为空交易日期().isAfter(beginDate) && x.getTransdate不可为空交易日期().isBefore(endDate))
                    .collect(Collectors.toList()).stream().map(e -> {


                //TODO        获得某一日的贷款余额;
                //    List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);
                Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
                if (ln101_贷款明细账_account.isPresent()) {
                    LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode不可为空_合同代码());

                    return Sextet.with(e,
                            ln005_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln014_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln008_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                            ln101_贷款明细账_s, ln003__合同信息);
                } else {
                    return null;
                }
            }).collect(Collectors.groupingBy(e -> e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee -> {

                // TODO 按照 银行
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue5().getAgentbankcode_经办银行())).entrySet().forEach(o -> {


                    //  S_212_SEQ_历史累计逾期本息_AND_0302010701("0302","0302010701","历史累计逾期本息"," ","18","01","bm_khjg","机构","bm_yhbm","银行名称"," "," ","1","01",false),
                    //       S_213_SEQ_历史累计逾期本金_AND_0302010702("0302","0302010702","历史累计逾期本金"," ","18","01","bm_khjg","机构","bm_yhbm","银行名称"," "," ","1","01",false),
                    //     S_214_SEQ_历史累计逾期利息_AND_0302010703("0302","0302010703","历史累计逾期利息"," ","18","01","bm_khjg","机构","bm_yhbm","银行名称"," "," ","1","01",false),


                    //S_118_SEQ_回收额__冲还贷___AND_0302000213("0302","0302000213","回收额（冲还贷）"," ","08","01","bm_khjg","机构","bm_yhbm","银行名称"," "," ","1","01",false),

                    LoanHistory loanHistory = new LoanHistory(beginDate, t.getValue3());

                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex银行名称(o.getKey()); // 银行名称
                    loanHistory.setSeqNum(t.getValue0()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getTransdate不可为空交易日期().equals(beginDate))
                        .filter(x->x.getValue0().getFundsource不可为空_资金来源().equals(E_LN101_贷款明细账_资金来源.住房公积金.getText()))
                       // .filter(x->x.getValue0().getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期归还.getText()))

                        .mapToDouble(x->x.getValue0().getTransamt不可为空_交易金额().doubleValue()).sum());
                    loanHistoryRepository.save(loanHistory);


                });

            });

        });


    }
}
