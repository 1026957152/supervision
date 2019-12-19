package org.ylgjj.loan.history;


import org.javatuples.Quartet;
import org.javatuples.Sextet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_LN006_贷款分期还款计划_curseqStatusEnum;
import org.ylgjj.loan.enumT.H_LN101_贷款明细_结算方式;
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

@Service("ZYLoan还款明细HistoryerviceImpl")
public class ZYLoan还款明细HistoryerviceImpl {


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
    Map<String, LN003_合同信息> ln003_contract_info_合同信息Map = null;




    //TODO 历史倒推
    // TODO S_140_SEQ_贷款余额_AND_0302000801
    public List<Sextet<LN006_贷款分期还款计划, LN005_贷款分户信息, LN014_贷款房屋信息,
                List<LN008_借款人信息>,
                List<LN101_贷款明细账>, LN003_合同信息>> 历史倒推_某一日的贷款(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(!initComplte){
            ln003__合同信息s = ln003_合同信息_repository.findAll();
            ln003_contract_info_合同信息Map = ln003_合同信息_repository.findAll().stream().
                    collect(Collectors.toMap(e->e.getLoancontrcode合同代码(),a->a));

            List<LN005_贷款分户信息> ln005__贷款分户信息s = lN005_贷款分户信息RepositoryLN005.findAll().stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).collect(Collectors.toList());
            ln005_lone_sub_account_贷款分户信息Map = ln005__贷款分户信息s.stream().collect(Collectors.toMap(e->e.getLoancontrcode合同代码(), e->e));

            ln0014_trading_house_贷款房屋信息Map = ln014__贷款房屋信息Repository.findAll().stream().collect(Collectors.toMap(e->e.getLoancontrcode0合同代码(), e->e));

            ln008_borrower_info_借款人信息Map = lN008_借款人类型Repository.findAll().stream().filter(e->e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText()))
                    .collect(Collectors.groupingBy(e->e.getLoancontrcode合同代码()));
            initComplte= true;
        }

        List<LN006_贷款分期还款计划> ln006__贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByRepaydate1还款日期(localDate);


        //   List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期Between(ldt_ksrq,ldt_jsrq);


        return ln006__贷款分期还款计划s.stream().map(e-> {



            //TODO        获得某一日的贷款余额;
            List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);
            Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
            if(ln101_贷款明细账_account.isPresent()){
                LN003_合同信息 ln003__合同信息 = ln003_contract_info_合同信息Map.get(e.getLoancontrcode0合同代码());

                return Sextet.with(e,
                        ln005_lone_sub_account_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                        ln0014_trading_house_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                        ln008_borrower_info_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                        ln101_贷款明细账_s, ln003__合同信息);
            }else{
                return null;
            }
        }).collect(Collectors.toList()).stream().filter(ee->ee!= null).collect(Collectors.toList());


    }











    //也是按照放款的一个流水在进行啊啊。
    //TODO 存储统计信息
    public void saveHistoryOneTime(LocalDate n, List<Sextet<LN006_贷款分期还款计划,
            LN005_贷款分户信息,
            LN014_贷款房屋信息,
            List<LN008_借款人信息>,
            List<LN101_贷款明细账>,
            LN003_合同信息>> inputs) {

        inputs.stream().collect(Collectors.groupingBy(e->e.getValue5().getInstcode_机构代码())).entrySet().forEach(eee->{
            String 机构编码 = eee.getKey();



           // StatisticalIndexCodeEnum.S_88_SEQ_发放额_AND_0302000101
           // StatisticalIndexCodeEnum.S_89_SEQ_发放额__5年以内含___AND_0302000102
          //  StatisticalIndexCodeEnum.S_90_SEQ_发放额__5年以上___AND_0302000103
            //StatisticalIndexCodeEnum.S_91_SEQ_发放额__贷款年限___AND_0302000105
            //StatisticalIndexCodeEnum.S_102_SEQ_发放额__还款方式___AND_0302000116
            //StatisticalIndexCodeEnum.S_92_SEQ_发放额__担保方式新___AND_0302000106













                    // TODO 按照 放款银行计算
            eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue5().getAgentbankcode_经办银行())).entrySet()
                    .stream().forEach(uuu->{



/*                StatisticalIndexCodeEnum.S_169_SEQ_回收户数_AND_0302002101
                StatisticalIndexCodeEnum.S_124_SEQ_回收利息_AND_0302000401
                StatisticalIndexCodeEnum.S_107_SEQ_回收额_AND_0302000201;*/

                LoanHistory loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_107_SEQ_回收额_AND_0302000201);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_169_SEQ_回收户数_AND_0302002101);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().size());  //
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_124_SEQ_回收利息_AND_0302000401);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);





/*                StatisticalIndexCodeEnum.S_170_SEQ_回收户数__正常___AND_0302002102
                StatisticalIndexCodeEnum.S_125_SEQ_回收利息__正常___AND_0302000402
                StatisticalIndexCodeEnum.S_108_SEQ_回收额__正常___AND_0302000202;*/
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_108_SEQ_回收额__正常___AND_0302000202);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                                .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.正常归还.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_170_SEQ_回收户数__正常___AND_0302002102);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.正常归还.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_125_SEQ_回收利息__正常___AND_0302000402);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.正常归还.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);




/*                StatisticalIndexCodeEnum.S_171_SEQ_回收户数__逾期___AND_0302002103
                StatisticalIndexCodeEnum.S_126_SEQ_回收利息__逾期___AND_0302000403
                StatisticalIndexCodeEnum.S_109_SEQ_回收额__逾期___AND_0302000203;*/
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_109_SEQ_回收额__逾期___AND_0302000203);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_171_SEQ_回收户数__逾期___AND_0302002103);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_126_SEQ_回收利息__逾期___AND_0302000403);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);



/*                StatisticalIndexCodeEnum.S_172_SEQ_回收户数__提前还本___AND_0302002104
                StatisticalIndexCodeEnum.S_127_SEQ_回收利息__提前还本___AND_0302000404
                StatisticalIndexCodeEnum.S_110_SEQ_回收额__提前还本___AND_0302000204;*/
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_110_SEQ_回收额__提前还本___AND_0302000204);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_172_SEQ_回收户数__提前还本___AND_0302002104);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_127_SEQ_回收利息__提前还本___AND_0302000404);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


/*                StatisticalIndexCodeEnum.S_173_SEQ_回收户数__正常还清___AND_0302002105
                StatisticalIndexCodeEnum.S_128_SEQ_回收利息__正常还清___AND_0302000405
                StatisticalIndexCodeEnum.S_111_SEQ_回收额__正常还清___AND_0302000205;*/ /// TODO ??????????????
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_111_SEQ_回收额__正常还清___AND_0302000205);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_173_SEQ_回收户数__正常还清___AND_0302002105);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_128_SEQ_回收利息__正常还清___AND_0302000405);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前部分.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);






/*                StatisticalIndexCodeEnum.S_174_SEQ_回收户数__提前还清___AND_0302002106
                StatisticalIndexCodeEnum.S_129_SEQ_回收利息__提前还清___AND_0302000406
                StatisticalIndexCodeEnum.S_112_SEQ_回收额__提前还清___AND_0302000206;*/
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_111_SEQ_回收额__正常还清___AND_0302000205);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前全部.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_173_SEQ_回收户数__正常还清___AND_0302002105);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前全部.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_128_SEQ_回收利息__正常还清___AND_0302000405);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue0().getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.提前全部.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);





/*                StatisticalIndexCodeEnum.S_132_SEQ_回收利息__5年以下含___AND_0302000410
                StatisticalIndexCodeEnum.S_115_SEQ_回收额__5年以内含___AND_0302000210;*/
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_115_SEQ_回收额__5年以内含___AND_0302000210);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue5().getLoanterm_贷款期限()< 5*13)
                       // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_132_SEQ_回收利息__5年以下含___AND_0302000410);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue5().getLoanterm_贷款期限()< 5*13)
                       // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);






/*                StatisticalIndexCodeEnum.S_133_SEQ_回收利息__5年以上___AND_0302000411
                StatisticalIndexCodeEnum.S_116_SEQ_回收额__5年以上___AND_0302000211;*/
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_115_SEQ_回收额__5年以内含___AND_0302000210);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue5().getLoanterm_贷款期限()> 5*13)
                        // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_132_SEQ_回收利息__5年以下含___AND_0302000410);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->z.getValue5().getLoanterm_贷款期限()> 5*13)
                        // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);



  /*              StatisticalIndexCodeEnum.S_117_SEQ_回收额__现金___AND_0302000212;
                StatisticalIndexCodeEnum.S_118_SEQ_回收额__冲还贷___AND_0302000213;*/

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_117_SEQ_回收额__现金___AND_0302000212);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()

                        .filter(z->{
                            return z.getValue4().stream().map(g->g.getSettlemode不可为空_结算方式().equals(H_LN101_贷款明细_结算方式.E_2_现金)).count()>0;
                        })
                        // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_118_SEQ_回收额__冲还贷___AND_0302000213);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()

                        .filter(z->{
                            return z.getValue4().stream().map(g->g.getSettlemode不可为空_结算方式().equals(H_LN101_贷款明细_结算方式.E_4_委托扣款)).count()>0;
                        })
                        // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);




























/*
                StatisticalIndexCodeEnum.S_175_SEQ_回收户数__本行回收___AND_0302002107
                StatisticalIndexCodeEnum.S_130_SEQ_回收利息__本行回收___AND_0302000407
                StatisticalIndexCodeEnum.S_113_SEQ_回收额__本行回收___AND_0302000207;
*/

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_113_SEQ_回收额__本行回收___AND_0302000207);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                       // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .filter(z->{
                            return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                        })
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_175_SEQ_回收户数__本行回收___AND_0302002107);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->{
                            return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                        })
                      //  .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_130_SEQ_回收利息__本行回收___AND_0302000407);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->{
                            return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                        })
                       // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);






/*                StatisticalIndexCodeEnum.S_176_SEQ_回收户数__他行回收___AND_0302002108
                StatisticalIndexCodeEnum.S_131_SEQ_回收利息__他行回收___AND_0302000408
                StatisticalIndexCodeEnum.S_114_SEQ_回收额__他行回收___AND_0302000208;*/


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_114_SEQ_回收额__他行回收___AND_0302000208);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .filter(z->{
                            return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                        })
                        .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_176_SEQ_回收户数__他行回收___AND_0302002108);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex银行名称(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream()
                        .filter(z->{
                            return z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                        })
                        //  .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                        .count());  //
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_131_SEQ_回收利息__他行回收___AND_0302000408);
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
    }










    //TODO 存储统计信息
    public void saveHistorySpan(LocalDate ldt_ksrq,LocalDate js) {
        LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq,year_before);

        List<Map<String, Map<String,List<Quartet<String,String,Integer,Double>>>>> list = new ArrayList();

        for(int i=0; i<=abs(num); i++) {
            LocalDate n = ldt_ksrq.minusDays(i);

            List<Sextet<LN006_贷款分期还款计划, LN005_贷款分户信息, LN014_贷款房屋信息,
                    List<LN008_借款人信息>,
                    List<LN101_贷款明细账>,
                    LN003_合同信息>>  aa = 历史倒推_某一日的贷款(n);
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














    //TODO 存储统计信息
    public void 历史累计saveHistorySpan(LocalDate ldt_ksrq,LocalDate js) {

/*
        StatisticalIndexCodeEnum.S_186_SEQ_历史累计回收额_AND_0302010201
                StatisticalIndexCodeEnum.S_187_SEQ_历史累计回收额__正常___AND_0302010202
                StatisticalIndexCodeEnum.S_188_SEQ_历史累计回收额__逾期___AND_0302010203
                StatisticalIndexCodeEnum.S_189_SEQ_历史累计回收额__提前还本___AND_0302010204
                StatisticalIndexCodeEnum.S_190_SEQ_历史累计回收额__正常还清___AND_0302010205
                StatisticalIndexCodeEnum.S_191_SEQ_历史累计回收额__提前还清___AND_0302010206
                StatisticalIndexCodeEnum.S_192_SEQ_历史累计回收额__本行回收___AND_0302010207
                StatisticalIndexCodeEnum.S_193_SEQ_历史累计回收额__他行回收___AND_0302010208
                StatisticalIndexCodeEnum.S_194_SEQ_历史累计回收额__5年以内含___AND_0302010210
                StatisticalIndexCodeEnum.S_195_SEQ_历史累计回收额__5年以上___AND_0302010211
                StatisticalIndexCodeEnum.S_196_SEQ_历史累计回收额__现金___AND_0302010212
                StatisticalIndexCodeEnum.S_197_SEQ_历史累计回收额__冲还贷___AND_0302010213
*/




                LocalDate year_before = ldt_ksrq.minusDays(5);

    }

























    //TODO 历史倒推
    // TODO S_140_SEQ_贷款余额_AND_0302000801
    public void 流水_历史还款明细(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(!initComplte){
            ln003__合同信息s = ln003_合同信息_repository.findAll();
            ln003_contract_info_合同信息Map = ln003_合同信息_repository.findAll().stream().
                    collect(Collectors.toMap(e->e.getLoancontrcode合同代码(),a->a));

            List<LN005_贷款分户信息> ln005__贷款分户信息s = lN005_贷款分户信息RepositoryLN005.findAll().stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).collect(Collectors.toList());
            ln005_lone_sub_account_贷款分户信息Map = ln005__贷款分户信息s.stream().collect(Collectors.toMap(e->e.getLoancontrcode合同代码(), e->e));

            ln0014_trading_house_贷款房屋信息Map = ln014__贷款房屋信息Repository.findAll().stream().collect(Collectors.toMap(e->e.getLoancontrcode0合同代码(), e->e));

            ln008_borrower_info_借款人信息Map = lN008_借款人类型Repository.findAll().stream().filter(e->e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText()))
                    .collect(Collectors.groupingBy(e->e.getLoancontrcode合同代码()));
            initComplte= true;
        }

        List<LN006_贷款分期还款计划> ln006__贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByRepaydate1还款日期(localDate);


        //   List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期Between(ldt_ksrq,ldt_jsrq);


        ln006__贷款分期还款计划s.stream().map(e-> {



            //TODO        获得某一日的贷款余额;
            List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);
            Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
            if(ln101_贷款明细账_account.isPresent()){
                LN003_合同信息 ln003__合同信息 = ln003_contract_info_合同信息Map.get(e.getLoancontrcode0合同代码());

                return Sextet.with(e,
                        ln005_lone_sub_account_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                        ln0014_trading_house_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                        ln008_borrower_info_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
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







    //TODO 历史倒推
    // TODO S_140_SEQ_贷款余额_AND_0302000801
    public void 流水_还款明细(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!initComplte) {
            ln003__合同信息s = ln003_合同信息_repository.findAll();
            ln003_contract_info_合同信息Map = ln003_合同信息_repository.findAll().stream().
                    collect(Collectors.toMap(e -> e.getLoancontrcode合同代码(), a -> a));

            List<LN005_贷款分户信息> ln005__贷款分户信息s = lN005_贷款分户信息RepositoryLN005.findAll().stream().filter(bb -> bb.getLoanacctype_贷款分户类型().equals("01")).collect(Collectors.toList());
            ln005_lone_sub_account_贷款分户信息Map = ln005__贷款分户信息s.stream().collect(Collectors.toMap(e -> e.getLoancontrcode合同代码(), e -> e));

            ln0014_trading_house_贷款房屋信息Map = ln014__贷款房屋信息Repository.findAll().stream().collect(Collectors.toMap(e -> e.getLoancontrcode0合同代码(), e -> e));

            ln008_borrower_info_借款人信息Map = lN008_借款人类型Repository.findAll().stream().filter(e -> e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText()))
                    .collect(Collectors.groupingBy(e -> e.getLoancontrcode合同代码()));
            initComplte = true;
        }


        List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);


        //   List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期Between(ldt_ksrq,ldt_jsrq);


        ln101_贷款明细账_s.stream().map(e -> {


            List<LN006_贷款分期还款计划> ln006__贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByRepaydate1还款日期(localDate);

            //TODO        获得某一日的贷款余额;
            //    List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);
            Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();
            if (ln101_贷款明细账_account.isPresent()) {
                LN003_合同信息 ln003__合同信息 = ln003_contract_info_合同信息Map.get(e.getLoancontrcode不可为空_合同代码());

                return Sextet.with(e,
                        ln005_lone_sub_account_贷款分户信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                        ln0014_trading_house_贷款房屋信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
                        ln008_borrower_info_借款人信息Map.get(ln003__合同信息.getLoancontrnum_借款合同号()),
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

                LoanHistory loanHistory = new LoanHistory(localDate, StatisticalIndexCodeEnum.S_118_SEQ_回收额__冲还贷___AND_0302000213);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
/*                loanHistory.setDoubleValue(o.getValue().stream()

                        .filter(x->x.getValue0().getEnddate0终止日期().isBefore(localDate))
                        .filter(x->x.getValue0().getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期.getText()))
                        .filter(x->x.getValue0().getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期归还.getText()))

                        .mapToDouble(x->x.getValue0().getPlanint本期应还利息0().add(x.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum());  //*/
                loanHistoryRepository.save(loanHistory);


            });

        });

    }
}
