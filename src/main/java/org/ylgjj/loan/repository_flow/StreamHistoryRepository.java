package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.flow.AnalysisStream;
import org.ylgjj.loan.flow.StreamHistory;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface StreamHistoryRepository extends JpaRepository<StreamHistory, Integer> {


    List<StreamHistory> findByIndexNo(String 指标编码);
}
