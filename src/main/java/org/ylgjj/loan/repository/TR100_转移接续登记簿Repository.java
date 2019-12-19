package org.ylgjj.loan.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.TR100_转移接续登记簿;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface TR100_转移接续登记簿Repository extends JpaRepository<TR100_转移接续登记簿, Integer> {



    List<TR100_转移接续登记簿> findByTransdate不可为空交易日期After(LocalDate minusDays);

    List<TR100_转移接续登记簿> findByJyrq不可为空交易日期BetweenOrderByJyrq不可为空交易日期Desc(LocalDate minusDays, LocalDate now);


}
