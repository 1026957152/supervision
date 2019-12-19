package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.PB007_机构信息表;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PB007_机构信息表_Repository extends JpaRepository<PB007_机构信息表, Integer> {


    PB007_机构信息表 findByInstCode(String s);

}
