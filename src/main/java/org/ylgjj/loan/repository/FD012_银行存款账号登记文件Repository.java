package org.ylgjj.loan.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.FD012_银行存款账号登记文件;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface FD012_银行存款账号登记文件Repository extends JpaRepository<FD012_银行存款账号登记文件, Integer> {


    List<FD012_银行存款账号登记文件> findByTRANSDATE不可为空交易日期Before(LocalDate ldt_jsrq);
}
