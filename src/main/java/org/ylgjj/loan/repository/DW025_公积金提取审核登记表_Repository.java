package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.DP202_单位缴存变更登记簿;
import org.ylgjj.loan.domain.DW025_公积金提取审核登记表;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DW025_公积金提取审核登记表_Repository extends JpaRepository<DW025_公积金提取审核登记表, Integer> {


   // List<DW025_公积金提取审核登记表> findTop19ByAccnum个人账号OrderByTransdate交易日期Desc(String accnum_个人账号);

    List<DW025_公积金提取审核登记表> findByTransdate交易日期(LocalDate 日期);

    List<DW025_公积金提取审核登记表> findByTransdate交易日期Between(LocalDate ldt_jsrq, LocalDate ldt_ksrq);

    List<DW025_公积金提取审核登记表> findByUnitaccnum单位账号(String unitaccnum单位账号);

    List<DW025_公积金提取审核登记表> findByUnitaccnum单位账号In(List<String> dp);

    List<DW025_公积金提取审核登记表> findByTransdate交易日期BetweenOrderByTransdate交易日期Desc(LocalDate minusDays, LocalDate now);



    //  List<DW025_withdraw_verify_公积金提取审核登记表> findByAccnum个人账号AndTransdate交易日期After(String accnum个人账号, LocalDate start);
}
