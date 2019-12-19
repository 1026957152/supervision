package org.ylgjj.loan.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN003_合同信息_Repository extends JpaRepository<LN003_合同信息, Integer> {


   // List<LN003_contract_info_合同信息> findByLoandateBetween(Date startDate, Date endDate);
    LN003_合同信息 findByLoancontrcode合同代码(String loancontrcode);

    List<LN003_合同信息> findByLoandate放款日期(LocalDate n);

    List<LN003_合同信息> findByOwecnt欠还次数GreaterThanEqual(int i);

    List<LN003_合同信息> findByOwecnt欠还次数GreaterThanEqualAndOwecnt欠还次数LessThan(Integer 逾期次数_floor, Integer 逾期次数_ceiling, Pageable of);


/* @Query(value = "SELECT * FROM reg_step_log WHERE email_has_sent = ?1 and opt_time >= ?2 and opt_time <= ?3",
         nativeQuery = true)*/
Page<LN003_合同信息> findByOwecnt欠还次数GreaterThanEqualAndOwecnt欠还次数LessThanAndLoandate放款日期Between(Integer 逾期次数_floor, Integer 逾期次数_ceiling, LocalDate ldt_ksrq, LocalDate ldt_jsrq, Pageable of);

 List<LN003_合同信息> findByLoandate放款日期Between(LocalDate ldt_jsrq, LocalDate ldt_ksrq);

    List<LN003_合同信息> findByLoancontrcode合同代码In(List<String> dp);

    List<LN003_合同信息> findByOrderByLoandate放款日期Desc();


    List<LN003_合同信息> findByLoandate放款日期BetweenOrderByLoandate放款日期Desc(LocalDate minusDays, LocalDate now);
}
