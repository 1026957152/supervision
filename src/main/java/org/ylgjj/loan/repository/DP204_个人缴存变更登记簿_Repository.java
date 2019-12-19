package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.DP202_单位缴存变更登记簿;
import org.ylgjj.loan.domain.DP204_个人缴存变更登记簿;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP204_个人缴存变更登记簿_Repository extends JpaRepository<DP204_个人缴存变更登记簿, Integer> {


    List<DP204_个人缴存变更登记簿> findByTransdate不可为空交易日期(LocalDate n);

    List<DP204_个人缴存变更登记簿> findByTransdate不可为空交易日期Between(LocalDate ldt_jsrq, LocalDate ldt_ksrq);

    List<DP204_个人缴存变更登记簿> findByAccnum不可为空个人账号(String accnum个人账号);

    List<DP204_个人缴存变更登记簿> findByAccnum不可为空个人账号In(List<String> dp);

    List<DP204_个人缴存变更登记簿> findByTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(LocalDate minusDays, LocalDate now);

}
