package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.flow.AnalysisStream;
import org.ylgjj.loan.flow.RateHistory;
import org.ylgjj.loan.flow.StreamHistory;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface RateHistoryRepository extends JpaRepository<RateHistory, Integer> {


    List<RateHistory> findByIndexNo(String 指标编码);

    List<RateHistory> findByIndexNoAndDateBetweenOrderByDateDesc(String 编码, LocalDate ldt_ksrq, LocalDate ldt_jsrq);

}
