package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.CollectHistory;
import org.ylgjj.loan.domain_flow.TargetHistory;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface TargetHistoryRepository extends JpaRepository<TargetHistory, Integer> {


    List<TargetHistory> findByTargetNo(String 指标编码);

    List<TargetHistory> findByTargetNoAndDateBetweenOrderByDateDesc(String 指标编码, LocalDate ldt_ksrq, LocalDate ldt_jsrq);


}
