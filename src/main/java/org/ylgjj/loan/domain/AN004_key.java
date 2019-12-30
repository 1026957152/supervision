package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class AN004_key implements Serializable {
    private static final long serialVersionUID = 1L;




    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    @Column(name = "TRANSDATE")
    private String transdate不可为空交易日期;


    @Column(name = "hostsernum")
    private String hostsernum_不可为空_业务流水号;

    @Column(name = "BATCHSEQ")
    private String BATCHSEQ_不可为空_批量包批次号;



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
