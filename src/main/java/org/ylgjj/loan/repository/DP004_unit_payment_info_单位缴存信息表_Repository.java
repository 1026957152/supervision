package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.DP004_unit_payment_info_单位缴存信息表;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP004_unit_payment_info_单位缴存信息表_Repository extends JpaRepository<DP004_unit_payment_info_单位缴存信息表, Integer> {


    DP004_unit_payment_info_单位缴存信息表 findByUnitaccnum单位账号(String unitaccnum);
}
