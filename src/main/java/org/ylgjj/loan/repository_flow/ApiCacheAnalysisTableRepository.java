package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.ApiCacheAnalysisTable;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface ApiCacheAnalysisTableRepository extends JpaRepository<ApiCacheAnalysisTable, Integer> {


    ApiCacheAnalysisTable findByIndexNo(String 服务编号);
}
