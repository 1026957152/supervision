package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.flow.RateAnalysisStream;
import org.ylgjj.loan.flow.RateAnalysisTable;
import org.ylgjj.loan.flow.StreamHistory;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface RateAnalysisTableRepository extends JpaRepository<RateAnalysisTable, Integer> {


    RateAnalysisTable findByIndexNo(String 指标编码);

}
