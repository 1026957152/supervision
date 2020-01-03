package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.outputenum.E_HISTORY_数据来源;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface RateHistoryRepository extends JpaRepository<RateHistory, Integer> {


    List<RateHistory> findByIndexNo(String 指标编码);

    List<RateHistory> findByIndexNoAndDateBetweenOrderByDateDesc(String 编码, LocalDate ldt_ksrq, LocalDate ldt_jsrq);

    List<RateHistory> findByDateBetweenOrderByDateDesc(LocalDate ldt_ksrq, LocalDate ldt_jsrq);

    RateHistory findByIndexNoAndDate(String 编码, LocalDate value0);

    @Transactional
    @Modifying
    void deleteByIndexNo(String 编码);

    RateHistory findByIndexNoAndDateAndType(String 编码, LocalDate value1, String fill);


    @Transactional
    @Modifying
    void deleteByIndexNoAndType(String 编码, String reduction_流水还原);
    @Transactional
    @Modifying
    void deleteByIndexNoAndTypeIn(String 编码, List<String> asList);


}
