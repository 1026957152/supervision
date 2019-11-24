package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.CM001_单位基本资料表;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface CM001_单位基本资料表Repository extends JpaRepository<CM001_单位基本资料表, Integer> {


    CM001_单位基本资料表 findByUnitcustid单位客户号(String unitcustid_单位客户号);


}
