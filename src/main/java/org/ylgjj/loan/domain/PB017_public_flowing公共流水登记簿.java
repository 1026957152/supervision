package org.ylgjj.loan.domain;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;



@IdClass(PB017_public_flowing_key.class)
@Entity

@Table(name = "PB017")

public class PB017_public_flowing公共流水登记簿 {

    public Integer getHostsernum() {
        return hostsernum;
    }

    public void setHostsernum(Integer hostsernum) {
        this.hostsernum = hostsernum;
    }

    @Id

    private String centerid;


    @Id
    private Date transdate;
    @Id
    private Integer hostsernum;

    @Id
    private String busisernumseq;



    private String inputop;
    private String chkop;
    private String summarycode不可为空摘要码;

    public String getSummarycode不可为空摘要码() {
        return summarycode不可为空摘要码;
    }

    public void setSummarycode不可为空摘要码(String summarycode不可为空摘要码) {
        this.summarycode不可为空摘要码 = summarycode不可为空摘要码;
    }

    public String getChkop() {
        return chkop;
    }

    public void setChkop(String chkop) {
        this.chkop = chkop;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public Date getTransdate() {
        return transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }



    public String getBusisernumseq() {
        return busisernumseq;
    }

    public void setBusisernumseq(String busisernumseq) {
        this.busisernumseq = busisernumseq;
    }

    public String getInputop() {
        return inputop;
    }

    public void setInputop(String inputop) {
        this.inputop = inputop;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}

