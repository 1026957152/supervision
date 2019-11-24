package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain.DP021_单位缴存登记簿;
import org.ylgjj.loan.domain.DP022_个人缴存登记簿;

import java.util.List;


/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface DP022_个人缴存登记薄Repository extends JpaRepository<DP022_个人缴存登记簿, Integer> {


    List<DP022_个人缴存登记簿> findByAccnum个人账号(String accnum_个人账号);


    DP022_个人缴存登记簿 findTop1ByAccnum个人账号(String accnum_个人账号);

    DP022_个人缴存登记簿 findTop1ByAccnum个人账号OrderByRegdate登记日期Desc(String accnum个人账号);

    List<DP022_个人缴存登记簿> findTop4ByAccnum个人账号OrderByRegdate登记日期Desc(String accnum个人账号);


    //   List<DP022_个人缴存登记簿> findByAccnum个人账号AfterBegym开始年月(String accnum个人账号);

}
