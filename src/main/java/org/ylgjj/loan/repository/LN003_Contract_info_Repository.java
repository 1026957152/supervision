package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.LN003_contract_info_合同信息;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN003_Contract_info_Repository extends JpaRepository<LN003_contract_info_合同信息, Integer> {


   // List<LN003_contract_info_合同信息> findByLoandateBetween(Date startDate, Date endDate);
    LN003_contract_info_合同信息 findByLoancontrcode合同代码(String loancontrcode);

    List<LN003_contract_info_合同信息> findByLoandate放款日期(LocalDate n);

    List<LN003_contract_info_合同信息> findByOwecnt欠还次数GreaterThanEqual(int i);

}
