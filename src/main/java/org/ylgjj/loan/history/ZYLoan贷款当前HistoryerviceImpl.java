package org.ylgjj.loan.history;


import org.javatuples.Quartet;
import org.javatuples.Sextet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_LN006_贷款分期还款计划_curseqStatusEnum;
import org.ylgjj.loan.enumT.LoaneeTypeEnum;
import org.ylgjj.loan.domain_flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.repository_flow.YourHistoryRepository;
import org.ylgjj.loan.util.DateUtilsss;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ZYLoan贷款当前HistoryerviceImpl")
public class ZYLoan贷款当前HistoryerviceImpl {


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



    boolean initComplte = false;
    List<LN003_合同信息> ln003__合同信息s = null;
    Map<String, LN005_贷款分户信息> ln005_lone_sub_account_贷款分户信息Map = null;
    Map<String, LN014_贷款房屋信息> ln0014_trading_house_贷款房屋信息Map = null;
    Map<String,List<LN008_借款人信息>> ln008_borrower_info_借款人信息Map = null;




    //TODO 历史倒推
    // TODO S_140_SEQ_贷款余额_AND_0302000801
    public List<Sextet<LN003_合同信息, LN005_贷款分户信息, LN014_贷款房屋信息,
            List<LN008_借款人信息>,
            List<LN101_贷款明细账>,
            List<LN006_贷款分期还款计划>>> 历史倒推_某一日的贷款(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(!initComplte){
            ln003__合同信息s = ln003_合同信息_repository.findAll();
            List<LN005_贷款分户信息> ln005__贷款分户信息s = lN005_贷款分户信息RepositoryLN005.findAll().stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).collect(Collectors.toList());
            ln005_lone_sub_account_贷款分户信息Map = ln005__贷款分户信息s.stream().collect(Collectors.toMap(e->e.getLoancontrcode合同代码(), e->e));

            ln0014_trading_house_贷款房屋信息Map = ln014__贷款房屋信息Repository.findAll().stream().collect(Collectors.toMap(e->e.getLoancontrcode0合同代码(), e->e));

            ln008_borrower_info_借款人信息Map = lN008_借款人类型Repository.findAll().stream().filter(e->e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText()))
                    .collect(Collectors.groupingBy(e->e.getLoancontrcode合同代码()));
            initComplte= true;
        }




        //   List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期Between(ldt_ksrq,ldt_jsrq);


        return ln003__合同信息s.stream().map(e-> {

            //TODO        获得某一日的贷款余额;
            List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);
            Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();

            List<LN006_贷款分期还款计划> ln006__贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByLoancontrcode0合同代码(e.getLoancontrcode合同代码());


            if(ln101_贷款明细账_account.isPresent()){
                return Sextet.with(e,
                        ln005_lone_sub_account_贷款分户信息Map.get(e.getLoancontrnum_借款合同号()),
                        ln0014_trading_house_贷款房屋信息Map.get(e.getLoancontrnum_借款合同号()),
                        ln008_borrower_info_借款人信息Map.get(e.getLoancontrnum_借款合同号()),
                        ln101_贷款明细账_s, ln006__贷款分期还款计划s);
            }else{
                return null;
            }
        }).collect(Collectors.toList()).stream().filter(ee->ee!= null).collect(Collectors.toList());


    }








    //也是按照放款的一个流水在进行啊啊。
    //TODO 存储统计信息
    public void saveHistoryOneTime(LocalDate n, List<Sextet<LN003_合同信息,
            LN005_贷款分户信息,
            LN014_贷款房屋信息,
            List<LN008_借款人信息>,
            List<LN101_贷款明细账>,List<LN006_贷款分期还款计划>>> inputs) {



        inputs.stream().collect(Collectors.groupingBy(e->e.getValue0().getInstcode_机构代码())).entrySet().forEach(eee->{
            String 机构编码 = eee.getKey();







           // S_240_SEQ_共同借款人人数_AND_0302040003("0302","0302040003","共同借款人人数"," ","17","03","bm_khjg","机构"," "," "," "," ","0","02",false),
                  //  S_241_SEQ_贷款购房建筑面积_AND_0302040004("0302","0302040004","贷款购房建筑面积"," ","17","03","bm_khjg","机构"," "," "," "," ","1","05",false),


                  //  S_242_SEQ_贷款购房建筑总价_AND_0302040005("0302","0302040005","贷款购房建筑总价"," ","17","03","bm_khjg","机构"," "," "," "," ","1","01",false),;

            LoanHistory loanHistory_ = new LoanHistory(n,StatisticalIndexCodeEnum.S_240_SEQ_共同借款人人数_AND_0302040003);
            loanHistory_.setIndex机构编码(机构编码); // 机构名称
            loanHistory_.setIndex银行名称(eee.getKey()); // 银行名称
            loanHistory_.setValue贷款金额(eee.getValue().stream().mapToDouble(j->{

                return  j.getValue3().stream()
                        .filter(o-> o.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.共同借款人.getText()))
                        .count();
            }).sum());  //
            loanHistoryRepository.save(loanHistory_);



            loanHistory_ = new LoanHistory(n,StatisticalIndexCodeEnum.S_241_SEQ_贷款购房建筑面积_AND_0302040004);
            loanHistory_.setIndex机构编码(机构编码); // 机构名称
            loanHistory_.setIndex银行名称(eee.getKey()); // 银行名称
            loanHistory_.setValue贷款金额(eee.getValue().stream().mapToDouble(j->{

                return  j.getValue2().getTnhousearea不可为空_购房面积().doubleValue();
            }).sum());  //
            loanHistoryRepository.save(loanHistory_);


            loanHistory_ = new LoanHistory(n,StatisticalIndexCodeEnum.S_242_SEQ_贷款购房建筑总价_AND_0302040005);
            loanHistory_.setIndex机构编码(机构编码); // 机构名称
            loanHistory_.setIndex银行名称(eee.getKey()); // 银行名称
            loanHistory_.setValue贷款金额(eee.getValue().stream().mapToDouble(j->{
                return  j.getValue2().getBuyhouseamt_0_购房房款总额_成交价().doubleValue();
            }).sum());
            loanHistoryRepository.save(loanHistory_);
/*

            StatisticalIndexCodeEnum.S_140_SEQ_贷款余额_AND_0302000801
            StatisticalIndexCodeEnum.S_141_SEQ_贷款余额__5年以内含___AND_0302000802
            StatisticalIndexCodeEnum.S_142_SEQ_贷款余额__5年以上___AND_0302000803
            StatisticalIndexCodeEnum.S_143_SEQ_异地贷款余额_AND_0302000804
            StatisticalIndexCodeEnum.S_144_SEQ_贷款余额__逾期期次___AND_0302000808





                    StatisticalIndexCodeEnum.S_145_SEQ_目前逾期本息_AND_0302000901
                    StatisticalIndexCodeEnum.S_146_SEQ_目前逾期本金_AND_0302000902
                    StatisticalIndexCodeEnum.S_147_SEQ_目前逾期利息_AND_0302000903
                    StatisticalIndexCodeEnum.S_148_SEQ_目前逾期本息__按期次分类___AND_0302000911
                    StatisticalIndexCodeEnum.S_149_SEQ_目前逾期本金__按期次分类___AND_0302000912
                    StatisticalIndexCodeEnum.S_150_SEQ_目前逾期利息__按期次分类___AND_0302000913

                    StatisticalIndexCodeEnum.S_181_SEQ_目前逾期户数_AND_0302002301
                    StatisticalIndexCodeEnum.S_182_SEQ_目前逾期户数__按期次分类___AND_0302002311




            StatisticalIndexCodeEnum.S_218_SEQ_存量贷款笔数_AND_0302012004
                    StatisticalIndexCodeEnum.S_219_SEQ_存量贷款笔数__缴存状态___AND_0302012009


                              StatisticalIndexCodeEnum.S_134_SEQ_应收本息_AND_0302000601
            StatisticalIndexCodeEnum.S_135_SEQ_应收本金_AND_0302000602
            StatisticalIndexCodeEnum.S_136_SEQ_应收利息_AND_0302000603


                        StatisticalIndexCodeEnum.S_137_SEQ_逾期本息__本期发生___AND_0302000701;
                    StatisticalIndexCodeEnum.S_138_SEQ_逾期本金__本期发生___AND_0302000702;
                    StatisticalIndexCodeEnum.S_139_SEQ_逾期利息__本期发生___AND_0302000703;


*/



          //  S_238_SEQ_贷款职工人数__收入水平___AND_0302040001("0302","0302040001","贷款职工人数(收入水平)","贷款职工人数(收入水平包含低收入、中收入、高收入)","25","06","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","0","02",true),

          //  S_239_SEQ_贷款职工人数__新房__二手房___AND_0302040002("0302","0302040002","贷款职工人数(新房、二手房)","贷款职工人数(新房、二手房)","26","06","bm_khjg","机构","bm_bi_fwxz","房屋性质"," "," ","0","02",true),


                    // TODO 按照 收入水平 S_238_SEQ_贷款职工人数__收入水平___AND_0302040001
                    eee.getValue().stream().collect(Collectors.groupingBy(a->{
                        return a.getValue3().stream()
                                .filter(j->j.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人))
                                .findFirst().get().getBasenum_0_缴存基数();
                    })).entrySet()
                            .stream().forEach(uuu->{

                        uuu.getValue().stream().map(p->p.getValue4().stream().map(j->j.getLoanbal不可为空_账户余额()));
                        LoanHistory loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_238_SEQ_贷款职工人数__收入水平___AND_0302040001);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex收入水平(uuu.getKey().toString()); // 银行名称
                        loanHistory.setIntValue(uuu.getValue().stream().mapToLong(j->{
                            return  j.getValue3().stream()
                                    .filter(o-> o.getLoanopchgtype_0_借款人变更类型().equals("n")).count();
                        }).sum());
                        loanHistoryRepository.save(loanHistory);
                    });

            // TODO 按照 收入水平 S_238_SEQ_贷款职工人数__收入水平___AND_0302040001
            eee.getValue().stream().collect(Collectors.groupingBy(a->{
                return a.getValue2().getHousetype_0_房屋类型().equals(LoaneeTypeEnum.借款人.getText());

            })).entrySet()
                    .stream().forEach(uuu->{

                uuu.getValue().stream().map(p->p.getValue4().stream().map(j->j.getLoanbal不可为空_账户余额()));
                LoanHistory loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_239_SEQ_贷款职工人数__新房__二手房___AND_0302040002);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex收入水平(uuu.getKey().toString()); // 银行名称
                loanHistory.setIntValue(uuu.getValue().stream().mapToLong(j->{
                    return  j.getValue3().stream()
                            .filter(o-> o.getLoanopchgtype_0_借款人变更类型().equals("n")).count();
                }).sum());
                loanHistoryRepository.save(loanHistory);
            });




                    // TODO 按照 放款银行计算
            eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue0().getAgentbankcode_经办银行())).entrySet()
                    .stream().forEach(uuu->{

                        uuu.getValue().stream().map(p->p.getValue4().stream().map(j->j.getLoanbal不可为空_账户余额()));


                //   StatisticalIndexCodeEnum.S_143_SEQ_异地贷款余额_AND_0302000804;



                        /*                StatisticalIndexCodeEnum.S_145_SEQ_目前逾期本息_AND_0302000901
                StatisticalIndexCodeEnum.S_146_SEQ_目前逾期本金_AND_0302000902
                StatisticalIndexCodeEnum.S_147_SEQ_目前逾期利息_AND_0302000903*/
                LoanHistory loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_145_SEQ_目前逾期本息_AND_0302000901);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(j->{
                    return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                            o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                            mapToDouble(p->p.getPlanprin0本期应还本金().add(p.getPlanint本期应还利息0()).doubleValue()).sum();
                }).sum());  //
                loanHistoryRepository.save(loanHistory);



                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_146_SEQ_目前逾期本金_AND_0302000902);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(j->{
                    return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                            o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                            mapToDouble(p->p.getPlanprin0本期应还本金().doubleValue()).sum();
                }).sum());  //
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_147_SEQ_目前逾期利息_AND_0302000903);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(j->{
                    return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                            o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                            mapToDouble(p->p.getPlanprin0本期应还本金().doubleValue()).sum();
                }).sum());  //
                loanHistoryRepository.save(loanHistory);



                //                StatisticalIndexCodeEnum.S_181_SEQ_目前逾期户数_AND_0302002301
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_181_SEQ_目前逾期户数_AND_0302002301);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款笔数(uuu.getValue().stream().mapToDouble(j->{
                    return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                            o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                            mapToDouble(p->p.getPlanprin0本期应还本金().doubleValue()).count();
                }).count());  //
                loanHistoryRepository.save(loanHistory);







            //    StatisticalIndexCodeEnum.S_140_SEQ_贷款余额_AND_0302000801;
            //    StatisticalIndexCodeEnum.S_141_SEQ_贷款余额__5年以内含___AND_0302000802;
             //   StatisticalIndexCodeEnum.S_142_SEQ_贷款余额__5年以上___AND_0302000803;



                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_140_SEQ_贷款余额_AND_0302000801);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(j->{
                    return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                            o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                            mapToDouble(p->p.getInitialbal0期初余额().doubleValue()).count();
                }).count());

                //
                loanHistoryRepository.save(loanHistory);



                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_142_SEQ_贷款余额__5年以上___AND_0302000803);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(c->c.getValue0().getLoanterm_贷款期限()>5*12)
                        .mapToDouble(j->{
                    return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                            o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                            mapToDouble(p->p.getInitialbal0期初余额().doubleValue()).count();
                }).count());  //
                loanHistoryRepository.save(loanHistory);





                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_141_SEQ_贷款余额__5年以内含___AND_0302000802);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(c->c.getValue0().getLoanterm_贷款期限()>5*12)
                        .mapToDouble(j->{
                            return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                                    o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                                    mapToDouble(p->p.getInitialbal0期初余额().doubleValue()).count();
                        }).count());  //
                loanHistoryRepository.save(loanHistory);




                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_181_SEQ_目前逾期户数_AND_0302002301);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(c->c.getValue0().getLoanterm_贷款期限()>5*12)
                        .mapToDouble(j->{
                            return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                                    o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                                    mapToDouble(p->p.getInitialbal0期初余额().doubleValue()).count();
                        }).count());  //
                loanHistoryRepository.save(loanHistory);



                //StatisticalIndexCodeEnum.S_181_SEQ_目前逾期户数_AND_0302002301

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_181_SEQ_目前逾期户数_AND_0302002301);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款笔数(uuu.getValue().stream()

                        .mapToDouble(j->{
                            return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                                    o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                                    mapToDouble(p->p.getInitialbal0期初余额().doubleValue()).count();
                        }).count());
                //
                loanHistoryRepository.save(loanHistory);











/*                StatisticalIndexCodeEnum.S_105_SEQ_当年发放异地贷款金额_AND_0302000120
                StatisticalIndexCodeEnum.S_106_SEQ_累计发放异地贷款总额_AND_0302000121*/


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_105_SEQ_当年发放异地贷款金额_AND_0302000120);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setDoubleValue(uuu.getValue().stream()
                        .filter(i->i.getValue0().getOthplacflag不可为空_异地标志().equals("1"))
                        .filter(i->i.getValue0().getLoandate放款日期().equals(n))
                        .mapToDouble(j->{
                            return  j.getValue0().getLoanamt_贷款金额().doubleValue();
                        }).sum());
                loanHistoryRepository.save(loanHistory);




                //S_167_SEQ_当年发放异地贷款笔数_AND_0302002019("0302","0302002019","当年发放异地贷款笔数"," ","09","06","bm_khjg","机构"," "," "," "," ","0"," ",false),
                //        S_168_SEQ_累计发放异地贷款笔数_AND_0302002020("0302","0302002020","累计发放异地贷款笔数"," ","09","03","bm_khjg","机构"," "," "," "," ","0"," ",false),

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_167_SEQ_当年发放异地贷款笔数_AND_0302002019);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款笔数(uuu.getValue()
                        .stream()
                        .filter(i->i.getValue0().getOthplacflag不可为空_异地标志().equals("1"))

                        .filter(i->i.getValue0().getLoandate放款日期().equals(n))

                      .count());
                loanHistoryRepository.save(loanHistory);

                //   StatisticalIndexCodeEnum.S_143_SEQ_异地贷款余额_AND_0302000804;





              //  StatisticalIndexCodeEnum.S_143_SEQ_异地贷款余额_AND_0302000804("0302","0302000804","异地贷款余额"," ","13","01","bm_khjg","机构"," "," "," "," ","1"," ",true),

                        loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_143_SEQ_异地贷款余额_AND_0302000804);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setDoubleValue(uuu.getValue()
                        .stream()
                        .filter(i->i.getValue0().getOthplacflag不可为空_异地标志().equals("1"))

                        .filter(i->i.getValue0().getLoandate放款日期().equals(n))

                        .mapToDouble(x->x.getValue1().getCurbal_当前余额().doubleValue()).sum());
                loanHistoryRepository.save(loanHistory);


            });




/*            StatisticalIndexCodeEnum.S_148_SEQ_目前逾期本息__按期次分类___AND_0302000911
            StatisticalIndexCodeEnum.S_149_SEQ_目前逾期本金__按期次分类___AND_0302000912
            StatisticalIndexCodeEnum.S_150_SEQ_目前逾期利息__按期次分类___AND_0302000913*/

                    // TODO 按照 放款银行计算
                    eee.getValue().stream().collect(Collectors.groupingBy(
                            j->{
                                return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                                        o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                                        mapToDouble(p->p.getPlanprin0本期应还本金().doubleValue()).count();
                            }
                    )).entrySet()
                            .stream().forEach(uuu->{

                        LoanHistory loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_145_SEQ_目前逾期本息_AND_0302000901);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex逾期次数(uuu.getKey().intValue()); // 银行名称
                        loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(j->{
                            return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                                    o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                                    mapToDouble(p->p.getPlanprin0本期应还本金().add(p.getPlanint本期应还利息0()).doubleValue()).sum();
                        }).sum());  //
                        loanHistoryRepository.save(loanHistory);



                        loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_146_SEQ_目前逾期本金_AND_0302000902);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex逾期次数(uuu.getKey().intValue()); // 银行名称
                        loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(j->{
                            return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                                    o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                                    mapToDouble(p->p.getPlanprin0本期应还本金().doubleValue()).sum();
                        }).sum());  //
                        loanHistoryRepository.save(loanHistory);

                        loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_147_SEQ_目前逾期利息_AND_0302000903);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex逾期次数(uuu.getKey().intValue()); // 银行名称
                        loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(j->{
                            return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                                    o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                                    mapToDouble(p->p.getPlanprin0本期应还本金().doubleValue()).sum();
                        }).sum());  //
                        loanHistoryRepository.save(loanHistory);





                    //    StatisticalIndexCodeEnum.S_182_SEQ_目前逾期户数__按期次分类___AND_0302002311

                                //                StatisticalIndexCodeEnum.S_181_SEQ_目前逾期户数_AND_0302002301
                        loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_182_SEQ_目前逾期户数__按期次分类___AND_0302002311);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex逾期次数(uuu.getKey().intValue()); // 银行名称
                        loanHistory.setValue贷款笔数(uuu.getValue().stream().mapToDouble(j->{
                            return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                                    o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                                    mapToDouble(p->p.getPlanprin0本期应还本金().doubleValue()).count();
                        }).count());  //
                        loanHistoryRepository.save(loanHistory);


                        //  StatisticalIndexCodeEnum.S_144_SEQ_贷款余额__逾期期次___AND_0302000808

                        loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_144_SEQ_贷款余额__逾期期次___AND_0302000808);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex逾期次数(uuu.getKey().intValue()); // 银行名称
                        loanHistory.setValue贷款笔数(uuu.getValue().stream().mapToDouble(j->{
                            return  j.getValue5().stream().filter(o-> o.getRepaydate1还款日期().isAfter(n) &&
                                    o.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.未还.getText())).
                                    mapToDouble(p->p.getInitialbal0期初余额().doubleValue()).count();
                        }).count());  //
                        loanHistoryRepository.save(loanHistory);
                    });
                    });




/*
           StatisticalIndexCodeEnum.S_151_SEQ_发放户数_AND_0302002001
                    StatisticalIndexCodeEnum.S_152_SEQ_发放户数__5年以内含___AND_0302002002
            StatisticalIndexCodeEnum.S_153_SEQ_发放户数__5年以上___AND_0302002003
            StatisticalIndexCodeEnum.S_154_SEQ_发放户数__贷款年限___AND_0302002005
StatisticalIndexCodeEnum.S_160_SEQ_发放户数__还款方式___AND_0302002011
            StatisticalIndexCodeEnum.S_155_SEQ_发放户数__担保方式新___AND_0302002006

            StatisticalIndexCodeEnum.S_163_SEQ_发放户数__贷款用途___AND_0302002014


            StatisticalIndexCodeEnum.S_93_SEQ_发放额__购房面积___AND_0302000107
            StatisticalIndexCodeEnum.S_237_SEQ_发放人数__购房面积___AND_0302030001
            StatisticalIndexCodeEnum.S_161_SEQ_发放户数__贷款金额与房屋价格占比___AND_0302002012
            StatisticalIndexCodeEnum.S_101_SEQ_发放额__贷款金额与房屋价格占比___AND_0302000115
            StatisticalIndexCodeEnum.S_94_SEQ_发放额__单位性质___AND_0302000108
            StatisticalIndexCodeEnum.S_156_SEQ_发放户数__单位性质___AND_0302002007

            StatisticalIndexCodeEnum.S_95_SEQ_发放额__非本市缴存职工开户年限___AND_0302000109
            StatisticalIndexCodeEnum.S_157_SEQ_发放户数__非本市缴存职工开户年限___AND_0302002008
            StatisticalIndexCodeEnum.S_158_SEQ_发放户数__贷款次数___AND_0302002009
            StatisticalIndexCodeEnum.S_97_SEQ_发放额__贷款次数___AND_0302000111

            StatisticalIndexCodeEnum.S_165_SEQ_发放户数__贷款时缴存年限___AND_0302002016
            StatisticalIndexCodeEnum.S_103_SEQ_发放额__贷款时缴存年限___AND_0302000117



            StatisticalIndexCodeEnum.S_98_SEQ_发放额__借款人年龄___AND_0302000112
            StatisticalIndexCodeEnum.S_159_SEQ_发放户数__借款人年龄___AND_0302002010

            StatisticalIndexCodeEnum.S_162_SEQ_发放户数__资金来源___AND_0302002013
            StatisticalIndexCodeEnum.S_164_SEQ_发放户数__缴存人数___AND_0302002015
*/







    }










    //TODO 存储统计信息
    public void saveHistorySpan(LocalDate ldt_ksrq,LocalDate js) {
        LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq,year_before);

        List<Map<String, Map<String,List<Quartet<String,String,Integer,Double>>>>> list = new ArrayList();

        for(int i=0; i<=abs(num); i++) {
            LocalDate n = ldt_ksrq.minusDays(i);

            List<Sextet<LN003_合同信息, LN005_贷款分户信息, LN014_贷款房屋信息,
                    List<LN008_借款人信息>,
                    List<LN101_贷款明细账>,List<LN006_贷款分期还款计划>>>  aa = 历史倒推_某一日的贷款(n);
            saveHistoryOneTime(n,aa);
        }
    }




    public void run() {
        saveHistorySpan(LocalDate.now(),null);
    }




















    //TODO ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？获取当前的一个状态
    public void saveHistoryOneTime(LocalDate localDate) {

        //从时间变化的列表中，抽取变化时记录的 状态。


        //private BigDecimal loanbal不可为空_账户余额;
        List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);


    }
}
