package org.ylgjj.loan.history_flow;


import org.javatuples.Sextet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.LoaneeTypeEnum;
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

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("LN101_贷款明细账_Flow_ServiceImpl")
public class LN101_贷款明细账_Flow_ServiceImpl {


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
    private LoanHistoryRepository loanHistoryRepository;



    boolean initComplte = false;
    List<LN003_合同信息> ln003__合同信息s = null;
    Map<String, LN005_贷款分户信息> ln005_lone_sub_account_贷款分户信息Map = null;
    Map<String, LN014_贷款房屋信息> ln0014_trading_house_贷款房屋信息Map = null;
    Map<String,List<LN008_借款人信息>> ln008_borrower_info_借款人信息Map = null;
    Map<String, LN003_合同信息> ln003_contract_info_合同信息Map = null;



























































































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
