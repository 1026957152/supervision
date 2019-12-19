package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.DP030_单位缓缴登记簿;
import org.ylgjj.loan.domain.DP034_公积金开销户登记簿;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP034_公积金开销户登记簿_Repository extends JpaRepository<DP034_公积金开销户登记簿, Integer> {


    List<DP034_公积金开销户登记簿> findByTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(LocalDate minusDays, LocalDate now);

}
