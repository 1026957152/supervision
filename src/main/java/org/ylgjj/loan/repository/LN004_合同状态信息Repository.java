package org.ylgjj.loan.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.LN004_合同状态信息;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN004_合同状态信息Repository extends JpaRepository<LN004_合同状态信息, Integer> {


    List<LN004_合同状态信息> findByLoancontrcode(String loancontrcode合同代码);

    List<LN004_合同状态信息> findByTransdateBetween(LocalDate minusDays, LocalDate now);

    List<LN004_合同状态信息> findByTransdateBetweenOrderByTransdateDesc(LocalDate minusDays, LocalDate now);

    List<LN004_合同状态信息> findByLoancontrcodeIn(List<String> list);
}
