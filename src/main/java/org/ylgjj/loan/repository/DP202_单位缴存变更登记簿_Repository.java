package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.DP008_institution_detail_单位明细账;
import org.ylgjj.loan.domain.DP202_单位缴存变更登记簿;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP202_单位缴存变更登记簿_Repository extends JpaRepository<DP202_单位缴存变更登记簿, Integer> {


    List<DP202_单位缴存变更登记簿> findByTransdate不可为空交易日期(LocalDate n);

    List<DP202_单位缴存变更登记簿> findByUnitcustid不可为空单位客户号(String unitnum);

    List<DP202_单位缴存变更登记簿> findByUnitaccnum不可为空单位账号(String s);

    List<DP202_单位缴存变更登记簿> findByTransdate不可为空交易日期Between(LocalDate ldt_jsrq, LocalDate ldt_ksrq);

    List<DP202_单位缴存变更登记簿> findByUnitaccnum不可为空单位账号In(List<String> dp);
}
