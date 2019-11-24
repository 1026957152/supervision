package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.CM001_单位基本资料表;
import org.ylgjj.loan.domain.DP021_单位缴存登记簿;
import org.ylgjj.loan.domain.DW145_提取结算登记簿;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DW145_提取结算登记薄_Repository extends JpaRepository<DW145_提取结算登记簿, Integer> {


    DW145_提取结算登记簿 findByApprnum审批号0(String apprnum_审批号);

    List<DW145_提取结算登记簿> findByTRANSDATE交易日期0(LocalDate n);

}
