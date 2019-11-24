package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.LN102_bank_withholding;
import org.ylgjj.loan.domain.PaymentSupplurs_NoEntiry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface LN102_bank_withholdingRepository extends JpaRepository<LN102_bank_withholding, Integer>, JpaSpecificationExecutor<LN102_bank_withholding> {



        @Query(value = "select SUM(DP007.BAL),(select PB007.INSTNAME from PB007 where DP007.ACCINSTCODE =PB007.INSTCODE )  from DP007  GROUP BY DP007.ACCINSTCODE ?#{#pageable}",
                countQuery = "SELECT count(PB007.ACCINSTCODE) FROM DP007  GROUP BY DP007.ACCINSTCODE",
                nativeQuery = true)
        Page<PaymentSupplurs_NoEntiry> findSuplurs(Pageable pageable);


}
