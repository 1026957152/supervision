package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.LN009_抵押物信息mortgager_goods_info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN009_抵押物信息_mortgager_goods_info_Repository extends JpaRepository<LN009_抵押物信息mortgager_goods_info, Integer> {


    List<LN009_抵押物信息mortgager_goods_info> findTop100By();


}
