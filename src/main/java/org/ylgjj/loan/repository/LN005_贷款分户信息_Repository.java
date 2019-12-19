package org.ylgjj.loan.repository;

import org.ylgjj.loan.domain.LN005_贷款分户信息;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN005_贷款分户信息_Repository extends JpaRepository<LN005_贷款分户信息, Integer> {


    List<LN005_贷款分户信息> findByloancontrcode合同代码(String loancontrcode_合同代码);


    List<LN005_贷款分户信息> findByloancontrcode合同代码In(List<String> dp);
}
