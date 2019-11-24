package org.ylgjj.loan.domain;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


public class PB017_public_flowing_key implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String centerid;


    @Id
    private Date transdate;
    @Id
    private Integer hostsernum;

    @Id
    private String busisernumseq;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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


    public Integer getHostsernum() {
        return hostsernum;
    }

    public void setHostsernum(Integer hostsernum) {
        this.hostsernum = hostsernum;
    }

    public String getBusisernumseq() {
        return busisernumseq;
    }

    public void setBusisernumseq(String busisernumseq) {
        this.busisernumseq = busisernumseq;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    ;





}

