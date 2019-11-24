package org.ylgjj.loan.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.ylgjj.loan.domain.*;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface CustomerService {


    Page<CM002_个人基本资料表> queryCustomer(Pageable pageable);

    Page<CM001_单位基本资料表> queryAdvice(Pageable pageable);

    Page<LN002> queryLoans(Pageable pageable);

    Page<LN008_borrower_info_借款人信息> queryLoanee(Pageable pageable);

    ReturnResult queryLoanee(Query query);
}
