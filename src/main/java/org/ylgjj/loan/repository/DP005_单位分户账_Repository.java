package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.DP005_单位分户账;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP005_单位分户账_Repository extends JpaRepository<DP005_单位分户账, Integer> {



    DP005_单位分户账 findByUnitaccnum单位账号(String unitaccnum);

    List<DP005_单位分户账> findByUnitaccnum单位账号In(List<String> dp);

    List<DP005_单位分户账> findByOpnaccdate开户日期BetweenOrderByOpnaccdate开户日期Desc(LocalDate minusDays, LocalDate now);

    List<DP005_单位分户账> findByClsaccdate销户日期BetweenOrderByClsaccdate销户日期Desc(LocalDate minusDays, LocalDate now);

    Long countByUnitacctype单位账户类型AndUnitaccstate单位账户状态(String text,String text2);

    Long countByUnitacctype单位账户类型(String text);
}
