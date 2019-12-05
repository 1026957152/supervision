package org.ylgjj.loan.history;


import org.javatuples.Quartet;
import org.javatuples.Sextet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_LN_CurrentSequencePaymentStatusEnum;
import org.ylgjj.loan.enumT.LoaneeTypeEnum;
import org.ylgjj.loan.flow.LoanHistory;
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

@Service("ZYLoan贷款状态明细HistoryerviceImpl")
public class ZYLoan贷款状态明细HistoryerviceImpl {


    @Autowired
    private CM002_个人基本资料表Repository cm002个人基本资料表Repository;
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
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    private LN005_lone_sub_accountRepository lN005_lone_sub_accountRepository;
    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;



    boolean initComplte = false;
    List<LN003_contract_info_合同信息> ln003_contract_info_合同信息s = null;
    Map<String,LN005_lone_sub_account_贷款分户信息> ln005_lone_sub_account_贷款分户信息Map = null;
    Map<String,LN0014_Trading_house_贷款房屋信息> ln0014_trading_house_贷款房屋信息Map = null;
    Map<String,List<LN008_borrower_info_借款人信息>> ln008_borrower_info_借款人信息Map = null;




    //TODO 历史倒推
    // TODO S_140_SEQ_贷款余额_AND_0302000801
    public void 历史倒推_某一日的贷款(LocalDate n) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(!initComplte){
            ln003_contract_info_合同信息s = ln003_contract_info_repository.findAll();
            List<LN005_lone_sub_account_贷款分户信息> ln005_lone_sub_account_贷款分户信息s = lN005_lone_sub_accountRepository.findAll().stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).collect(Collectors.toList());
            ln005_lone_sub_account_贷款分户信息Map = ln005_lone_sub_account_贷款分户信息s.stream().collect(Collectors.toMap(e->e.getLoancontrcode合同代码(),e->e));

            ln0014_trading_house_贷款房屋信息Map = ln014_tradingHouse_贷款房屋信息Repository.findAll().stream().collect(Collectors.toMap(e->e.getLoancontrcode0合同代码(),e->e));

            ln008_borrower_info_借款人信息Map = lN008_借款人类型Repository.findAll().stream().filter(e->e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText()))
                    .collect(Collectors.groupingBy(e->e.getLoancontrcode合同代码()));
            initComplte= true;
        }








        LoanHistory loanHistory_ = new LoanHistory(n,StatisticalIndexCodeEnum.S_240_SEQ_共同借款人人数_AND_0302040003);






         Double a = ln004_合同状态信息Repository.findAll().stream().map(e-> {

            //TODO        获得某一日的贷款余额;
            List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(n);
            Optional<LN101_贷款明细账_account> ln101_贷款明细账_account = ln101_贷款明细账_accounts.stream().findFirst();

            List<LN006_RepaymentPlan_贷款分期还款计划> ln006_repaymentPlan_贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByLoancontrcode0合同代码(e.getLoancontrcode());


            if(ln101_贷款明细账_account.isPresent()){
                return Sextet.with(e,
                        ln005_lone_sub_account_贷款分户信息Map.get(e.getLoancontrcode()),
                        ln0014_trading_house_贷款房屋信息Map.get(e.getLoancontrcode()),
                        ln008_borrower_info_借款人信息Map.get(e.getLoancontrcode()),
                        ln101_贷款明细账_accounts,ln006_repaymentPlan_贷款分期还款计划s);
            }else{
                return null;
            }
        }).collect(Collectors.toList()).stream().filter(ee->ee!= null)
                .collect(Collectors.groupingBy(e->e.getValue0().getLoancontrcode())).entrySet().stream()

                 .filter(x->x.getValue().stream().filter(f->f.getValue0().getTransdate().equals(n)).count()>0)
                 .mapToDouble(x->x.getValue().get(0).getValue2().getHousetype_0_房屋类型().length()).max().getAsDouble();


        loanHistory_.setDoubleValue(a);  //
        loanHistoryRepository.save(loanHistory_);
















        a = ln004_合同状态信息Repository.findAll().stream().map(e-> {

            //TODO        获得某一日的贷款余额;
            List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(n);
            Optional<LN101_贷款明细账_account> ln101_贷款明细账_account = ln101_贷款明细账_accounts.stream().findFirst();

            List<LN006_RepaymentPlan_贷款分期还款计划> ln006_repaymentPlan_贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByLoancontrcode0合同代码(e.getLoancontrcode());


            if(ln101_贷款明细账_account.isPresent()){
                return Sextet.with(e,
                        ln005_lone_sub_account_贷款分户信息Map.get(e.getLoancontrcode()),
                        ln0014_trading_house_贷款房屋信息Map.get(e.getLoancontrcode()),
                        ln008_borrower_info_借款人信息Map.get(e.getLoancontrcode()),
                        ln101_贷款明细账_accounts,ln006_repaymentPlan_贷款分期还款计划s);
            }else{
                return null;
            }
        }).collect(Collectors.toList()).stream().filter(ee->ee!= null)
                .collect(Collectors.groupingBy(e->e.getValue0().getLoancontrcode())).entrySet().stream()

                .filter(x->x.getValue().stream().filter(f->f.getValue0().getTransdate().equals(n)).count()>0)
                .mapToDouble(x->x.getValue().get(0).getValue2().getHousetype_0_房屋类型().length()).max().getAsDouble();


        loanHistory_.setDoubleValue(a);  //
        loanHistoryRepository.save(loanHistory_);
    }

















    //TODO 存储统计信息
    public void saveHistorySpan(LocalDate ldt_ksrq,LocalDate js) {
        LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq,year_before);

        List<Map<String, Map<String,List<Quartet<String,String,Integer,Double>>>>> list = new ArrayList();

        for(int i=0; i<=abs(num); i++) {
            LocalDate n = ldt_ksrq.minusDays(i);

          历史倒推_某一日的贷款(n);
        }
    }




    public void run() {
        saveHistorySpan(LocalDate.now(),null);
    }




















    //TODO ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？获取当前的一个状态
    public void saveHistoryOneTime(LocalDate localDate) {

        //从时间变化的列表中，抽取变化时记录的 状态。


        //private BigDecimal loanbal不可为空_账户余额;
        List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);



    }
}
