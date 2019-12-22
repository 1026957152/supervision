package org.ylgjj.loan.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.FN090_账户变动通知文件;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface FN090_账户变动通知文件_Repository extends JpaRepository<FN090_账户变动通知文件, Integer> {




    List<FN090_账户变动通知文件> findByBankaccnum不可为空账号(String s);

    List findByBankaccnum不可为空账号OrderByTransdate不可为空写入日期Desc(String s);

    Page<FN090_账户变动通知文件> findByBankaccnum不可为空账号OrderByTransdate不可为空写入日期Desc(String s, Pageable of);

    Page<FN090_账户变动通知文件> findByBankaccnum不可为空账号OrderByTransdate不可为空写入日期DescBankhostsernum不可为空银行主机流水号Desc(String bankaccnum_不可为空_银行账号, Pageable of);

    List<FN090_账户变动通知文件> findByTransdate不可为空写入日期Between(LocalDate ldt_ksrq, LocalDate ldt_jsrq);

    Page<FN090_账户变动通知文件> findByTransdate不可为空写入日期AndBankaccnum不可为空账号OrderByTransdate不可为空写入日期DescBankhostsernum不可为空银行主机流水号Desc(LocalDate plusDays, String bankaccnum_不可为空_银行账号, Pageable of);

}
