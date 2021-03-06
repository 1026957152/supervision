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
@Table(name = "stream_history")

public class StreamHistory extends BaseDomain{

/*    @Column(name = "no")
    private String no;*/

    @Column(name = "date")
    private LocalDate date;



    private LocalDate endDate;

    private String targetNo;
    private Integer intValue;
    private double doubleValue;

    private Long seqNum;
    private String dimension1;
    private String dimension2;
    private Long deltaLongValue;
    private String dimension3;
    private Double deltaDoubleValue;
    private Long longValue;
    public StreamHistory(LocalDate n) {
        this.date = n;
    }
    public StreamHistory(LocalDate n, StatisticalIndexCodeEnum index) {

    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public StreamHistory() {
    }



    public StreamHistory(LocalDate beginDate, LocalDate endDate, StatisticalIndexCodeEnum s1Seq暂存款笔数And0301000101) {
        this.date = beginDate;
        targetNo = s1Seq暂存款笔数And0301000101.get指标编码();
        this.endDate = endDate;
    }

    public StreamHistory(Long value0, LocalDate beginDate, LocalDate endDate, StatisticalIndexCodeEnum statisticalIndexCodeEnum) {
        this.seqNum = value0;
        this.date = beginDate;
        targetNo = statisticalIndexCodeEnum.get指标编码();
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

    public String getTargetNo() {
        return targetNo;
    }

    public void setTargetNo(String indexNo) {
        this.targetNo = indexNo;
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

    public void setDeltaLongValue(Long deltaLongValue) {
        this.deltaLongValue = deltaLongValue;
    }

    public Long getDeltaLongValue() {
        return deltaLongValue;
    }

    public void setDimension3(String dimension3) {
        this.dimension3 = dimension3;
    }

    public String getDimension3() {
        return dimension3;
    }

    public void setDeltaDoubleValue(Double deltaDoubleValue) {
        this.deltaDoubleValue = deltaDoubleValue;
    }

    public Double getDeltaDoubleValue() {
        return deltaDoubleValue;
    }
}
