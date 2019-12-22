package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.AnalysisStream;
import org.ylgjj.loan.domain_flow.CollectHistory;
import org.ylgjj.loan.domain_flow.StreamHistory;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface CollectHistoryRepository extends JpaRepository<CollectHistory, Integer> {


    List<CollectHistory> findByIndexNo(String 指标编码);

    List<CollectHistory> findByIndexNoAndBeginDateBetweenOrderByBeginDateDesc(String 指标编码, LocalDate ldt_ksrq, LocalDate ldt_jsrq);
}
