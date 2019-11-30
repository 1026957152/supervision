package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class TR077_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    @Column(name = "instance")
    private long instance_不可为空_实例号;//

    @Column(name = "zjhm")
    private String zjhm_不可为空_证件号码;//


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;

    public long getInstance_不可为空_实例号() {
        return instance_不可为空_实例号;
    }

    public void setInstance_不可为空_实例号(long instance_不可为空_实例号) {
        this.instance_不可为空_实例号 = instance_不可为空_实例号;
    }

    public String getZjhm_不可为空_证件号码() {
        return zjhm_不可为空_证件号码;
    }

    public void setZjhm_不可为空_证件号码(String zjhm_不可为空_证件号码) {
        this.zjhm_不可为空_证件号码 = zjhm_不可为空_证件号码;
    }
}
