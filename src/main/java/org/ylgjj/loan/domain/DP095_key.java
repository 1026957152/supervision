package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class DP095_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    @Column(name = "accflag")
    private String accflag_不可为空_账户标志; //1-预缴户,2-个人公积金	0:不可为空	账户标志


    @Column(name = "accinstcode")
    private String accinstcode_不可为空_账户机构; //YYYYMMDD+流水号		0:不可为空

    @Column(name = "calintdate")
    private String calintdate_不可为空_结息日期; //


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;







}
