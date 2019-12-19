package org.ylgjj.loan.repository_flow;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.LoanHistory;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LoanHistoryRepository extends JpaRepository<LoanHistory, Integer> {


    LoanHistory findByDate(LocalDate n);

    LoanHistory findByDateAndIndex机构编码AndIndex提取原因(LocalDate n, String 机构编码, String key);

    LoanHistory findByIndexNoAndDateAndIndex机构编码AndIndex提取原因(String indexNo, LocalDate n, String 机构编码, String key);

    List<LoanHistory> findByIndexNo(String name);

    List<LoanHistory> findByIndexNoAndDateBetween(String 指标编码, LocalDate ldt_ksrq, LocalDate ldt_jsrq);

    Page<LoanHistory> findByIndexNo(String 指标编码, Pageable pageable);
}
