package org.ylgjj.loan.domain_flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.ylgjj.loan.outputenum.E_HISTORY_数据来源;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
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

    private Double doubleValue;
    private Long seqNum;
    private String dimension1;
    private String dimension2;
    private Long longValue;
    private Long deltaLongValue;
    private Double deltaDoubleValue;
    private String type;

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

    public RateHistory(LocalDate value0, E_指标_RATE_SY e_指标_rate_sy) {
        this.date = value0;
        this.indexNo = e_指标_rate_sy.get编码();
    }

    public RateHistory(LocalDate now, E_指标_RATE_SY e_指标_rate_sy, E_HISTORY_数据来源 e_history_数据来源) {
        this.date = now;
        this.indexNo = e_指标_rate_sy.get编码();
        this.type = e_history_数据来源.get编码();
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



    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
