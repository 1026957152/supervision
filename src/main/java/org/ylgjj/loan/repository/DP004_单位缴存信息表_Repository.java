package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.DP004_单位缴存信息表;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP004_单位缴存信息表_Repository extends JpaRepository<DP004_单位缴存信息表, Integer> {


    DP004_单位缴存信息表 findByUnitaccnum单位账号(String unitaccnum);

    List<DP004_单位缴存信息表> findByUnitaccnum单位账号In(List<String> dp);
}
