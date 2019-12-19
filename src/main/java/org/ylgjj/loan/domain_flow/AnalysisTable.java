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

    @Column(name = "index_no")
    private String indexNo;
    private LocalDate updateTime;
    private Integer seq;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
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
}
