package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.DP007_个人分户账;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.enumT.E_DP093_冻结解冻登记表_冻结业务标志;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP007_个人分户账_Repository extends JpaRepository<DP007_个人分户账, Integer> {


    DP007_个人分户账 findByAccnum个人账号(String accnum);


    List<DP007_个人分户账> findByOpnaccdate开户日期BetweenOrderByOpnaccdate开户日期Desc(LocalDate minusDays, LocalDate now);

    Long countByIndiacctype个人账户类型AndBal余额GreaterThan(String text, int i);

    Long countByIndiacctype个人账户类型AndIndiaccstate个人账户状态(String text, String id);

    Long countByIndiacctype个人账户类型AndFrzflag冻结标志(String text, E_DP093_冻结解冻登记表_冻结业务标志 e0冻结);

    Long countByIndiacctype个人账户类型(String text);
}
