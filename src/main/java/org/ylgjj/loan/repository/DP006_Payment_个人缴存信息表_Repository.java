package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.DP006_Payment_个人缴存信息表;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP006_Payment_个人缴存信息表_Repository extends JpaRepository<DP006_Payment_个人缴存信息表, Integer> {


    DP006_Payment_个人缴存信息表 findByCustid个人客户号(String custid);


}
