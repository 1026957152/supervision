package org.ylgjj.loan.domain_flow;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "analysis_table")
public class AnalysisTable extends BaseDomain {

    @Column(name = "target_no")
    private String targetNo;

    @Column(name = "update_Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @Column(name = "seq_no")
    private Integer seq;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate analysedBeginDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate analysedEndDate;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getTargetNo() {
        return targetNo;
    }

    public void setTargetNo(String indexNo) {
        this.targetNo = indexNo;
    }

    public void setUpdateTime(LocalDateTime updateTime) {

        this.updateTime = updateTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setAnalysedBeginDate(LocalDate analysedBeginDate) {
        this.analysedBeginDate = analysedBeginDate;
    }

    public LocalDate getAnalysedBeginDate() {
        return analysedBeginDate;
    }

    public void setAnalysedEndDate(LocalDate analysedEndDate) {
        this.analysedEndDate = analysedEndDate;
    }

    public LocalDate getAnalysedEndDate() {
        return analysedEndDate;
    }
}
