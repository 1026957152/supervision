package org.ylgjj.loan.repository_flow;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.LoanCache;

import java.time.LocalDate;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LoanCacheRepository extends JpaRepository<LoanCache, Integer> {


    Page<LoanCache> findByDqyqcs当前逾期次数intGreaterThanEqualAndDqyqcs当前逾期次数intLessThanAndDkffrq发放日期StringBetween(Integer 逾期次数_floor, Integer 逾期次数_ceiling, LocalDate ldt_ksrq, LocalDate ldt_jsrq, Pageable of);


}
