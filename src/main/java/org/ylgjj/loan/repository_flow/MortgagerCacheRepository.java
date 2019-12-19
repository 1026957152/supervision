package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.MortgagerCache;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface MortgagerCacheRepository extends JpaRepository<MortgagerCache, Integer> {


    List<MortgagerCache> findByDkffrq发放日期Between(LocalDate ldt_ksrq, LocalDate ldt_jsrq);

}
