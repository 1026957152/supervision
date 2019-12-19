package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.LN006_贷款分期还款计划;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN006_贷款分期还款计划Repository extends JpaRepository<LN006_贷款分期还款计划, Integer> {



    List<LN006_贷款分期还款计划> findByLoancontrcode0合同代码(String loancontrcode);

    List<LN006_贷款分期还款计划> findByLoancontrcode0合同代码AndBegdate0开始日期After(String loancontrcode合同代码, LocalDate start18月);

    List<LN006_贷款分期还款计划> findByRepaydate1还款日期(LocalDate localDate);

    List<LN006_贷款分期还款计划> findByLoancontrcode0合同代码OrderByBegdate0开始日期Asc(String loancontrcode合同代码);

    List<LN006_贷款分期还款计划> findByRepaydate1还款日期Between(LocalDate beginDateTotal, LocalDate endDateTotal);

    List<LN006_贷款分期还款计划> findByCurseqstate本期状态In(List<String> list);

/*
    List<LN006_RepaymentPlan> findByLoancontrcodeAndCurseqstate(String loancontrcode, String text);
    List<LN006_RepaymentPlan> findByLoancontrcodeAndCurseqstateOrderByBegdateAsc(String loancontrcode, String text);*/
}
