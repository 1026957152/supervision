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
@Table(name = "api_cache_analysis_table")
public class ApiCacheAnalysisTable extends BaseDomain {

    @Column(name = "index_no")
    private String indexNo;
    private LocalDate updateTime;
    private Integer seq;
    private String content;
    private String name;
    private String path;
    private String lastId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
    }

    public String getLastId() {
        return lastId;
    }
}
