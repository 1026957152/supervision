package org.ylgjj.loan.flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "analysis_stream")

public class AnalysisStream extends BaseDomain {



    @Column(name = "index_no")
    private String indexNo;
    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private String no;
    private String status;
    private LocalDate endDate;
    private LocalDate beginDate
            ;


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setBeginDateTime(LocalDateTime beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    public LocalDateTime getBeginDateTime() {
        return beginDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
