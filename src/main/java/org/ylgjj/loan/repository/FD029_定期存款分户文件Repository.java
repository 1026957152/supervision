package org.ylgjj.loan.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.FD029_定期存款分户文件;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface FD029_定期存款分户文件Repository extends JpaRepository<FD029_定期存款分户文件, Integer> {


    List<FD029_定期存款分户文件> findByTransdate不可为空交易日期Before(LocalDate plusDays);

}
