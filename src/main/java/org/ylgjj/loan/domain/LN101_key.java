package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class LN101_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }




    @Column(name = "seqno")
    private String seqno不可为空_序号;

    @Column(name = "loancontrcode")
    private String loancontrcode不可为空_合同代码;

    public String getSeqno不可为空_序号() {
        return seqno不可为空_序号;
    }

    public void setSeqno不可为空_序号(String seqno不可为空_序号) {
        this.seqno不可为空_序号 = seqno不可为空_序号;
    }

    public String getLoancontrcode不可为空_合同代码() {
        return loancontrcode不可为空_合同代码;
    }

    public void setLoancontrcode不可为空_合同代码(String loancontrcode不可为空_合同代码) {
        this.loancontrcode不可为空_合同代码 = loancontrcode不可为空_合同代码;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
