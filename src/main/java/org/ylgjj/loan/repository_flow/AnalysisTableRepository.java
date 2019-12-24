package org.ylgjj.loan.repository_flow;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.AnalysisTable;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface AnalysisTableRepository extends JpaRepository<AnalysisTable, Integer> {


    AnalysisTable findByTargetNo(String 指标编码);

    Page<AnalysisTable> findByOrderBySeqAsc(Pageable pageable);

    void deleteByTargetNo(String targetNo);
}
