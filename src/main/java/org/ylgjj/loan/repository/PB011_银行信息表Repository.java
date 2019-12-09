package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.PB011_银行信息表;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PB011_银行信息表Repository extends JpaRepository<PB011_银行信息表, Integer> {


    PB011_银行信息表 findByBankcode(String agentbankcode);


}
