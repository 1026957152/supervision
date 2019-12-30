package org.ylgjj.loan.domain_flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "rate_history")

public class RateHistory extends BaseDomain{


    @Column(name = "date")
    private LocalDate date;



    private LocalDate endDate;

    private String indexNo;
    private Integer intValue;
    private double doubleValue;
    private Long seqNum;
    private String dimension1;
    private String dimension2;
    private Long longValue;
    private Long deltaLongValue;
    private Double deltaDoubleValue;
    public RateHistory(LocalDate n) {
        this.date = n;
    }
    public RateHistory(LocalDate n, StatisticalIndexCodeEnum index) {

    }

    public RateHistory() {
    }



    public RateHistory(LocalDate beginDate, LocalDate endDate, StatisticalIndexCodeEnum s1Seq暂存款笔数And0301000101) {
        this.date = beginDate;
        indexNo = s1Seq暂存款笔数And0301000101.get指标编码();
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



    public LocalDate getDate() {
        return date;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Long getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }

    public void setDimension1(String dimension1) {
        this.dimension1 = dimension1;
    }

    public String getDimension1() {
        return dimension1;
    }

    public void setDimension2(String dimension2) {
        this.dimension2 = dimension2;
    }

    public String getDimension2() {
        return dimension2;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getDeltaLongValue() {
        return deltaLongValue;
    }

    public void setDeltaLongValue(Long deltaLongValue) {
        this.deltaLongValue = deltaLongValue;
    }

    public Double getDeltaDoubleValue() {
        return deltaDoubleValue;
    }

    public void setDeltaDoubleValue(Double deltaDoubleValue) {
        this.deltaDoubleValue = deltaDoubleValue;
    }
}
