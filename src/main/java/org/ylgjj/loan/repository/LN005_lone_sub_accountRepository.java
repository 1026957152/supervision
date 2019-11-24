package org.ylgjj.loan.repository;

import org.ylgjj.loan.domain.LN005_lone_sub_account_贷款分户信息;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN005_lone_sub_accountRepository extends JpaRepository<LN005_lone_sub_account_贷款分户信息, Integer> {


    List<LN005_lone_sub_account_贷款分户信息> findByloancontrcode合同代码(String loancontrcode_合同代码);


}
