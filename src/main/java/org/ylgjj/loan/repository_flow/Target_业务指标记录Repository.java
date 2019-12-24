package org.ylgjj.loan.repository_flow;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.Target_业务指标记录;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface Target_业务指标记录Repository extends JpaRepository<Target_业务指标记录, Integer> {


    Target_业务指标记录 findByXmbm(String xmbm);

}
