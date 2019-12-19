
package org.ylgjj.loan.repository_zhongfu;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_zongfu.Mi029_综合服务个人用户基础信息表;
import org.ylgjj.loan.domain_zongfu.Mi0312_渠道用户登录ID辅助控制表;

import java.util.List;


/**
 * Created by zhao yuan on 01/10/2015.
 */

public interface Mi0312_渠道用户登录ID辅助控制表_Repository extends JpaRepository<Mi0312_渠道用户登录ID辅助控制表, Integer> {


    List<Mi0312_渠道用户登录ID辅助控制表> findByDatemodifiedGreaterThanEqualOrderByDatemodifiedDesc(String s);

    List<Mi0312_渠道用户登录ID辅助控制表> findByOrderByDatemodifiedDesc();


}

