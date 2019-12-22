package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class LN005_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    @Column(name = "loancontrcode")
    private String loancontrcode合同代码;

    @Column(name = "loanacctype")
    private String loanacctype_贷款分户类型;
    /*
        loanacctype		"01-正常贷款,
                02-逾期贷款,
                03-应收利息(表内),
    13-应收利息(表外),
    18-表外罚息"	0:不可为空	贷款分户类型*/

    @Column(name = "loanaccnum")
    private String loanaccnum_贷款账号;

    public String getLoancontrcode合同代码() {
        return loancontrcode合同代码;
    }

    public void setLoancontrcode合同代码(String loancontrcode合同代码) {
        this.loancontrcode合同代码 = loancontrcode合同代码;
    }

    public String getLoanacctype_贷款分户类型() {
        return loanacctype_贷款分户类型;
    }

    public void setLoanacctype_贷款分户类型(String loanacctype_贷款分户类型) {
        this.loanacctype_贷款分户类型 = loanacctype_贷款分户类型;
    }

    public String getLoanaccnum_贷款账号() {
        return loanaccnum_贷款账号;
    }

    public void setLoanaccnum_贷款账号(String loanaccnum_贷款账号) {
        this.loanaccnum_贷款账号 = loanaccnum_贷款账号;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
