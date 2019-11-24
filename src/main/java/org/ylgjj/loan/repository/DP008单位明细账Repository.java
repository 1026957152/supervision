package org.ylgjj.loan.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.DP008_单位明细账;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP008单位明细账Repository extends JpaRepository<DP008_单位明细账, Integer> {


    List<DP008_单位明细账> findBySummarycodeIn(List<String> aa);

    List<DP008_单位明细账> findBysummarycode不可为空摘要代码InAndsummarycode不可为空摘要代码Between(List<String> aa, LocalDate ldt_ksrq, LocalDate ldt_jsrq);



}
