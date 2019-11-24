package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.LN013_payee_info;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN013_payee_Repository extends JpaRepository<LN013_payee_info, Integer> {


    LN013_payee_info findByLoancontrcode(String loancontrcode);


}
