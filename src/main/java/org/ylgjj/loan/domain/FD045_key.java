package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class FD045_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    @Column(name = "CENTERID")
    private String CENTERID_不可为空_城市中心代码;


    @Column(name = "TRANSDATE")
    private LocalDate TRANSDATE不可为空交易日期;

    @Column(name = "HOSTSERNUM")
    private String HOSTSERNUM_不可为空_主机流水号;


    public String getCENTERID_不可为空_城市中心代码() {
        return CENTERID_不可为空_城市中心代码;
    }

    public void setCENTERID_不可为空_城市中心代码(String CENTERID_不可为空_城市中心代码) {
        this.CENTERID_不可为空_城市中心代码 = CENTERID_不可为空_城市中心代码;
    }

    public LocalDate getTRANSDATE不可为空交易日期() {
        return TRANSDATE不可为空交易日期;
    }

    public void setTRANSDATE不可为空交易日期(LocalDate TRANSDATE不可为空交易日期) {
        this.TRANSDATE不可为空交易日期 = TRANSDATE不可为空交易日期;
    }

    public String getHOSTSERNUM_不可为空_主机流水号() {
        return HOSTSERNUM_不可为空_主机流水号;
    }

    public void setHOSTSERNUM_不可为空_主机流水号(String HOSTSERNUM_不可为空_主机流水号) {
        this.HOSTSERNUM_不可为空_主机流水号 = HOSTSERNUM_不可为空_主机流水号;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
