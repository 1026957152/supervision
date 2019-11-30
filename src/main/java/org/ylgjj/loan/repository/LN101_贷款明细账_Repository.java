package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.LN101_贷款明细账_account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN101_贷款明细账_Repository extends JpaRepository<LN101_贷款明细账_account, Integer> {

/*
    List<LN101_贷款明细账_account> findByTransdateAfter(Date time);

    List<LN101_贷款明细账_account> findByTransdateAfterOrderByTransdateDesc(Date time);

    List<LN101_贷款明细账_account> findByTransdateAfterOrderByTransdateAsc(Date time);

    List<LN101_贷款明细账_account> findTop50ByOrderByTransdateDesc();

    List<LN101_贷款明细账_account> findTop1000ByOrderByTransdateDesc();


    List<LN101_贷款明细账_account> findTop50ByTransdateAfterOrderByTransdateAsc(Date time);

    List<LN101_贷款明细账_account> findTop50ByTransdateBeforeOrderByTransdateAsc(Date time);

    List<LN101_贷款明细账_account> findTop50ByTransdateAfter(Date time);

    List<LN101_贷款明细账_account> findTop400ByTransdateAfter(Date time);

    List<LN101_贷款明细账_account> findTop5000ByOrderByTransdateDesc();

    List<LN101_贷款明细账_account> findTop10000ByOrderByTransdateDesc();

    List<LN101_贷款明细账_account> findByTransdateBetweenOrderByTransdateDesc(Date start, Date end);*/

    List<LN101_贷款明细账_account> findByTransdate不可为空交易日期(LocalDate n);

    List<LN101_贷款明细账_account>  findByTransdate不可为空交易日期Between(LocalDate ldt_ksrq, LocalDate ldt_jsrq);

}
