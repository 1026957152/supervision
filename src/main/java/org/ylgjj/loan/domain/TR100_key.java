package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class TR100_key implements Serializable {
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

;







}
