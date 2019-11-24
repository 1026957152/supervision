package org.ylgjj.loan.repository;


import org.ylgjj.loan.domain.PB017_public_flowing公共流水登记簿;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PB017_public_flowing公共流水登记簿Repository extends JpaRepository<PB017_public_flowing公共流水登记簿, Integer> {


    PB017_public_flowing公共流水登记簿 findByTransdateAndHostsernum(Date transdate, Integer hostsernum);

    List<PB017_public_flowing公共流水登记簿> findByTransdate(Date transdate);
}
