package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.DP008_单位明细账;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP008_单位明细账_Repository extends JpaRepository<DP008_单位明细账, Integer> {


    List<DP008_单位明细账> findByTransdate不可为空交易日期(LocalDate 日期);

    List<DP008_单位明细账> findByUnitaccnum不可为空单位账号(String unitaccnum单位账号);

    List<DP008_单位明细账> findByUnitaccnum不可为空单位账号In(List<String> unitaccnum单位账号);

    List<DP008_单位明细账> findByTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(LocalDate minusDays, LocalDate now);
}
