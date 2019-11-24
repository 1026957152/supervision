package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.CM081_sms_短信密码签订登记簿;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface CM081_sms_短信密码签订登记簿_Repository extends JpaRepository<CM081_sms_短信密码签订登记簿, Integer> {


    List<CM081_sms_短信密码签订登记簿> findByPubaccnum通用帐号0(String certinum);

}
