package org.ylgjj.loan.repository_flow;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.AnalysisTable;
import org.ylgjj.loan.domain_flow.TargetAnalysisTable;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface TargetAnalysisTableRepository extends JpaRepository<TargetAnalysisTable, Integer> {


    TargetAnalysisTable findByIndexNo(String 指标编码);

    Page<TargetAnalysisTable> findByOrderBySeqAsc(Pageable pageable);
}
