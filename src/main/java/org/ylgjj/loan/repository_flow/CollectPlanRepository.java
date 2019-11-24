package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.flow.CollectPlan;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface CollectPlanRepository extends JpaRepository<CollectPlan, Integer> {


    List<CollectPlan> findByCreateDateBetween(LocalDateTime ldt_ksrq, LocalDateTime ldt_jsrq);



}
