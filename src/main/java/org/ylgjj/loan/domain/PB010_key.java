package org.ylgjj.loan.domain;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


public class PB010_key implements Serializable {
    private static final long serialVersionUID = 1L;



    @Column(name = "CENTERID")
    private String CENTERID_不可为空_城市中心代码;



    @Column(name = "bankcode")
    private String bankcode_不可为空_银行代码;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getCENTERID_不可为空_城市中心代码() {
        return CENTERID_不可为空_城市中心代码;
    }

    public void setCENTERID_不可为空_城市中心代码(String CENTERID_不可为空_城市中心代码) {
        this.CENTERID_不可为空_城市中心代码 = CENTERID_不可为空_城市中心代码;
    }
}

