package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class DP034_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    @Column(name = "apprnum")
    private String apprnum审批号; //YYYYMMDD+流水号		0:不可为空

    @Column(name = "hostsernum")
    private String hostsernum_不可为空_主机流水号; //


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;







}
