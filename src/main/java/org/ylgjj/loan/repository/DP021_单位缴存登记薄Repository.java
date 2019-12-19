package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.DP021_单位缴存登记簿;
import org.ylgjj.loan.domain.DP030_单位缓缴登记簿;

import java.time.LocalDate;
import java.util.List;


/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP021_单位缴存登记薄Repository extends JpaRepository<DP021_单位缴存登记簿, Integer> {


    List<DP021_单位缴存登记簿> findByUnitaccnum单位账号(String unitaccnum单位账号);

    List<DP021_单位缴存登记簿> findByRegdate不可为空登记日期(LocalDate n);

    List<DP021_单位缴存登记簿> findByRegdate不可为空登记日期Between(LocalDate beginDate, LocalDate endDate);

    List<DP021_单位缴存登记簿> findByInaccdate不可为空入账日期BetweenOrderByInaccdate不可为空入账日期Desc(LocalDate minusDays, LocalDate now);

}
