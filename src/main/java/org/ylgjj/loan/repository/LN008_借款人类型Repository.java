package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.LN008_borrower_info_借款人信息;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN008_借款人类型Repository extends JpaRepository<LN008_borrower_info_借款人信息, Integer> {



    List<LN008_borrower_info_借款人信息> findByAccnum1账号(String accnum);


    List<LN008_borrower_info_借款人信息> findByloancontrcode合同代码(String loancontrcode合同代码);

}
