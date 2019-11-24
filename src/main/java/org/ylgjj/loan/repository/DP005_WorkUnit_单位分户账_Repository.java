package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.DP005_work_unit_单位分户账;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP005_WorkUnit_单位分户账_Repository extends JpaRepository<DP005_work_unit_单位分户账, Integer> {



    DP005_work_unit_单位分户账 findByUnitaccnum单位账号(String unitaccnum);

}
