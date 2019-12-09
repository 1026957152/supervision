package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class FD032_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    @Column(name = "centerid")
    private String centerid_CENTERID_不可为空_城市中心代码;//




    @Column(name = "depocode")
    private String depocode_DEPOCODE_不可为空_存单编码;//

    @Column(name = "transdate")
    private java.sql.Date transdate_TRANSDATE_不可为空_交易日期;//

    @Column(name = "hostsernum")
    private long hostsernum_HOSTSERNUM_不可为空_主机流水号;//



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getCenterid_CENTERID_不可为空_城市中心代码() {
        return centerid_CENTERID_不可为空_城市中心代码;
    }

    public void setCenterid_CENTERID_不可为空_城市中心代码(String centerid_CENTERID_不可为空_城市中心代码) {
        this.centerid_CENTERID_不可为空_城市中心代码 = centerid_CENTERID_不可为空_城市中心代码;
    }

    public String getDepocode_DEPOCODE_不可为空_存单编码() {
        return depocode_DEPOCODE_不可为空_存单编码;
    }

    public void setDepocode_DEPOCODE_不可为空_存单编码(String depocode_DEPOCODE_不可为空_存单编码) {
        this.depocode_DEPOCODE_不可为空_存单编码 = depocode_DEPOCODE_不可为空_存单编码;
    }

    public Date getTransdate_TRANSDATE_不可为空_交易日期() {
        return transdate_TRANSDATE_不可为空_交易日期;
    }

    public void setTransdate_TRANSDATE_不可为空_交易日期(Date transdate_TRANSDATE_不可为空_交易日期) {
        this.transdate_TRANSDATE_不可为空_交易日期 = transdate_TRANSDATE_不可为空_交易日期;
    }

    public long getHostsernum_HOSTSERNUM_不可为空_主机流水号() {
        return hostsernum_HOSTSERNUM_不可为空_主机流水号;
    }

    public void setHostsernum_HOSTSERNUM_不可为空_主机流水号(long hostsernum_HOSTSERNUM_不可为空_主机流水号) {
        this.hostsernum_HOSTSERNUM_不可为空_主机流水号 = hostsernum_HOSTSERNUM_不可为空_主机流水号;
    }
}
