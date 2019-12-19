package org.ylgjj.loan.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.Fn032_会计凭证历史流水;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface Fn032_会计凭证历史流水_Repository extends JpaRepository<Fn032_会计凭证历史流水, Integer> {


    List<Fn032_会计凭证历史流水> findByTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(LocalDate minusDays, LocalDate now);

    List<Fn032_会计凭证历史流水> findBySubcode不可为空科目控制字InAndTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(List<String> strins, LocalDate minusDays, LocalDate now);
}
