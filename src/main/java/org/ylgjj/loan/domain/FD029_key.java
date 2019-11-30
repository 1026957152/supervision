package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class FD029_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    @Column(name = "centerid")
    private String centerid_不可为空_城市中心代码;

    @Column(name = "depocode")
    private String depocode_不可为空_存单编码;


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;







}
