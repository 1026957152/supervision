package org.ylgjj.loan.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ylgjj.loan.domain.PB017_public_flowing公共流水登记簿;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by zhao yuan on 01/10/2015.
 */
public interface PB017_公共流水登记簿_Repository extends JpaRepository<PB017_public_flowing公共流水登记簿, Integer> {


    PB017_public_flowing公共流水登记簿 findByTransdateAndHostsernum(Date transdate, Integer hostsernum);




    List<PB017_public_flowing公共流水登记簿> findByTransdate(Date transdate);




    @Query(
            value = "select count(*) as cc,ACCINSTCODE as accinstcode, TRANSCHANNEL AS transchannel,SUMMARYCODE AS summarycode,(select SUMMARYDES from  pb002 where pb002.SUMMARYCODE=pb017.SUMMARYCODE) AS desciption   from pb017 where TRANSDATE >= :beginDate and TRANSDATE <= :endDate group by ACCINSTCODE,TRANSCHANNEL,SUMMARYCODE",
            nativeQuery = true)
    List<PB017公共流水登记簿Dto> findByChannel(@Param("beginDate") LocalDate beginDate,@Param("endDate") LocalDate endDate);

    public static interface PB017公共流水登记簿Dto {

        String getAccinstcode();
        Long getCc();
        String getTranschannel();

        String getSummarycode();
        String getDesciption();
    }
}
