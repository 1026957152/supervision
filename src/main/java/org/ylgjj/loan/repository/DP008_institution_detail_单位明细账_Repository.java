package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.DP007_individual_sub_account_个人分户账;
import org.ylgjj.loan.domain.DP008_institution_detail_单位明细账;
import org.ylgjj.loan.domain.DP202_单位缴存变更登记簿;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP008_institution_detail_单位明细账_Repository extends JpaRepository<DP008_institution_detail_单位明细账, Integer> {


    List<DP008_institution_detail_单位明细账> findByTransdate不可为空交易日期(LocalDate 日期);

}
