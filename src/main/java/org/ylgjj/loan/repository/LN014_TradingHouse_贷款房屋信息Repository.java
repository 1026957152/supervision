package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.LN0014_Trading_house_贷款房屋信息;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN014_TradingHouse_贷款房屋信息Repository extends JpaRepository<LN0014_Trading_house_贷款房屋信息, Integer> {


    LN0014_Trading_house_贷款房屋信息 findByLoancontrcode0合同代码(String loancontrcode);

}
