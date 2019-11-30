package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.flow.CollectPlan;
import org.ylgjj.loan.flow.业务指标记录;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface 业务指标记录Repository extends JpaRepository<业务指标记录, Integer> {


    List<业务指标记录> findByXmbm(String xmbm);

}
