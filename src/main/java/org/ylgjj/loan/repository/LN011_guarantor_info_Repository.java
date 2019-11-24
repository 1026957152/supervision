package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.LN011_guarantor_info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN011_guarantor_info_Repository extends JpaRepository<LN011_guarantor_info, Integer> {


    List<LN011_guarantor_info> findByLoancontrcode(String loancontrcode);

    List<LN011_guarantor_info> findByCustid(String custid);
}
