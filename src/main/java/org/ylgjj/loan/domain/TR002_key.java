package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class TR002_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    @Column(name = "lxhbh")
    private String lxhbh_不可为空_联系函编号;


    @Column(name = "jylx")
    private String jylx_不可为空_交易类型;


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getLxhbh_不可为空_联系函编号() {
        return lxhbh_不可为空_联系函编号;
    }

    public void setLxhbh_不可为空_联系函编号(String lxhbh_不可为空_联系函编号) {
        this.lxhbh_不可为空_联系函编号 = lxhbh_不可为空_联系函编号;
    }

    public String getJylx_不可为空_交易类型() {
        return jylx_不可为空_交易类型;
    }

    public void setJylx_不可为空_交易类型(String jylx_不可为空_交易类型) {
        this.jylx_不可为空_交易类型 = jylx_不可为空_交易类型;
    }
}
