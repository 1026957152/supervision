package org.ylgjj.loan.repository;

import org.ylgjj.loan.domain.LN001_申请审批信息;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN001_申请审批信息Repository extends JpaRepository<LN001_申请审批信息, Integer> {


    LN001_申请审批信息 findByApprnum(String apprnum_审批号);

}
