package org.ylgjj.loan.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.TR002_联系函基础信息;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface TR002_联系函基础信息_Repository extends JpaRepository<TR002_联系函基础信息, Integer> {


    //List<TR002_联系函基础信息> findByLxhlrrq不可为空联系函录入日期After(LocalDate minusDays);

}
