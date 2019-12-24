package org.ylgjj.loan.domain_flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "analysis_table")
public class AnalysisTable extends BaseDomain {

    @Column(name = "target_no")
    private String targetNo;

    @Column(name = "update_Date")
    private LocalDate updateTime;

    @Column(name = "seq_no")
    private Integer seq;
    private LocalDate analysedBeginDate;
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

    public void setUpdateTime(LocalDate updateTime) {

        this.updateTime = updateTime;
    }

    public LocalDate getUpdateTime() {
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
