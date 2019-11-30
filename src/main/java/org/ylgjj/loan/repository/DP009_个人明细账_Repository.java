package org.ylgjj.loan.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.DP009_个人明细账;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP009_个人明细账_Repository extends JpaRepository<DP009_个人明细账, Integer> {


    List<DP009_个人明细账> findByTransdate不可为空交易日期(LocalDate localDate);
}
