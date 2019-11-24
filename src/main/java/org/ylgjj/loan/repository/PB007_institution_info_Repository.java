package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.PB007_institution_info;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PB007_institution_info_Repository extends JpaRepository<PB007_institution_info, Integer> {


    PB007_institution_info findByInstCode(String s);

}
