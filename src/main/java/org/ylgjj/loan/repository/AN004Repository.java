package org.ylgjj.loan.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.AN004_单位基本资料表;
import org.ylgjj.loan.domain.CM001_单位基本资料表;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface AN004Repository extends JpaRepository<AN004_单位基本资料表, Integer> {


    Page<AN004_单位基本资料表> findAllByOrderByTransdate不可为空交易日期Desc(Pageable of);
}
