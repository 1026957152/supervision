package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface ProRateHistoryRepository extends JpaRepository<ProRateHistory, Integer> {


    List<ProRateHistory> findByIndexNo(String 指标编码);

    List<ProRateHistory> findByIndexNoAndDateBetweenOrderByDateDesc(String 编码, LocalDate ldt_ksrq, LocalDate ldt_jsrq);

    List<ProRateHistory> findByDateBetweenOrderByDateDesc(LocalDate ldt_ksrq, LocalDate ldt_jsrq);

    ProRateHistory findByIndexNoAndDate(String 编码, LocalDate value0);

    @Transactional
    @Modifying
    void deleteByIndexNo(String 编码);


    @Transactional
    @Modifying
    void deleteByDate(LocalDate parse);
}
