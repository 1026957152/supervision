
package org.ylgjj.loan.repository_zhongfu;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_zongfu.Mi0312_渠道用户登录ID辅助控制表;
import org.ylgjj.loan.domain_zongfu.Mi107_业务日志;

import java.time.LocalDate;
import java.util.List;


/**
 * Created by zhao yuan on 01/10/2015.
 */

public interface Mi107_业务日志_Repository extends JpaRepository<Mi107_业务日志, Integer> {


    List<Mi107_业务日志> findByDatemodifiedBetween(LocalDate ldt_ksrq, LocalDate ldt_jsrq);
}

