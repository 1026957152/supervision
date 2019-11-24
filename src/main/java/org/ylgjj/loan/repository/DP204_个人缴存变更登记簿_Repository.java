package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.DP202_单位缴存变更登记簿;
import org.ylgjj.loan.domain.DP204_个人缴存变更登记簿;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP204_个人缴存变更登记簿_Repository extends JpaRepository<DP204_个人缴存变更登记簿, Integer> {


    List<DP204_个人缴存变更登记簿> findByTransdate不可为空交易日期(LocalDate n);
}
