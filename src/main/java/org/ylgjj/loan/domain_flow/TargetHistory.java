package org.ylgjj.loan.domain_flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "target_history")

public class TargetHistory extends BaseDomain{


    private String no;
    private String targetNo;
    private LocalDate date;
    private LocalDate endDate;

    private Long seqNum;

    private Long longValue;
    private double doubleValue;
    private long deltaLongValue;
    private Double deltaDoubleValue;


    public TargetHistory() {
    }

    public TargetHistory(LocalDate date, StatisticalIndexCodeEnum s1Seq暂存款笔数And0301000101) {

        this.date = date;
        this.targetNo = s1Seq暂存款笔数And0301000101.get指标编码();

    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTargetNo() {
        return targetNo;
    }

    public void setTargetNo(String indexNo) {
        this.targetNo = indexNo;
    }


    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }



    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }



    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public void setDeltaLongValue(Long diffLongValue) {
        this.deltaLongValue = diffLongValue;
    }

    public long getDeltaLongValue() {
        return deltaLongValue;
    }

    public void setDeltaDoubleValue(Double deltaDoubleValue) {
        this.deltaDoubleValue = deltaDoubleValue;
    }

    public Double getDeltaDoubleValue() {
        return deltaDoubleValue;
    }
}
