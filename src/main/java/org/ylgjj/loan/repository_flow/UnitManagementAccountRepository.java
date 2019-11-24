package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.flow.Collect;
import org.ylgjj.loan.flow.UnitManagementAccount;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface UnitManagementAccountRepository extends JpaRepository<UnitManagementAccount, Integer> {


    List<UnitManagementAccount> findByCreateDateBetween(LocalDateTime ldt_ksrq, LocalDateTime ldt_jsrq);



}
