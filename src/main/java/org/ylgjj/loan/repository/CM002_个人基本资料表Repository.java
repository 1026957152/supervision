package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.CM002_个人基本资料表;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface CM002_个人基本资料表Repository extends JpaRepository<CM002_个人基本资料表, Integer> {



    List<CM002_个人基本资料表> findByCertinum(String certinum);
}
