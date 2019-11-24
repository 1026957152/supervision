package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.DP007_individual_sub_account_个人分户账;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP007_individual_sub_account_个人分户账_Repository extends JpaRepository<DP007_individual_sub_account_个人分户账, Integer> {


    DP007_individual_sub_account_个人分户账 findByAccnum个人账号(String accnum);


}
