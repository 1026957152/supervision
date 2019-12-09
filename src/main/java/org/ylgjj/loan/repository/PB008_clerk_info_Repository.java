package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.PB008_柜员信息表;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PB008_clerk_info_Repository extends JpaRepository<PB008_柜员信息表, Integer> {


    PB008_柜员信息表 findByOperid(String approveop);
}
