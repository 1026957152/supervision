package org.ylgjj.loan.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.FD045_资金划转业务登记文件;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface FD045_资金划转业务登记文件Repository extends JpaRepository<FD045_资金划转业务登记文件, Integer> {


    //List<FD045_资金划转业务登记文件> findByTRANSDATE不可为空交易日期(LocalDate now, LocalDate now1);

    List<FD045_资金划转业务登记文件> findByTRANSFERAMT不可为空划转金额Between(double doubleValue, double doubleValue1);

    List<FD045_资金划转业务登记文件> findByTRANSDATE不可为空交易日期Between(LocalDate ldt_ksrq, LocalDate ldt_jsrq);
}
