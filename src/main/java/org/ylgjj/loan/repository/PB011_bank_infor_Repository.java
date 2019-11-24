package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.PB011_bank_info;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PB011_bank_infor_Repository extends JpaRepository<PB011_bank_info, Integer> {


    PB011_bank_info findByBankcode(String agentbankcode);


}
