package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.StreamHistory;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface StreamHistoryRepository extends JpaRepository<StreamHistory, Integer> {


    List<StreamHistory> findByTargetNo(String 指标编码);

    List<StreamHistory> findByTargetNoAndDateBetweenOrderByDateDesc(String 指标编码, LocalDate localDate_begin, LocalDate localDate_end);

}
