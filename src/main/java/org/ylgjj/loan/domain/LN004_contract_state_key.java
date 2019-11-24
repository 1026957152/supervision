package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class LN004_contract_state_key implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id

    private String loancontrcode;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getApprnum() {
        return apprnum;
    }

    public void setApprnum(String apprnum) {
        this.apprnum = apprnum;
    }

    public String getLoancontrstate() {
        return loancontrstate;
    }

    public void setLoancontrstate(String loancontrstate) {
        this.loancontrstate = loancontrstate;
    }

    @Id

    private String apprnum;
    @Id
    private String loancontrstate;

    public String getLoancontrcode() {
        return loancontrcode;
    }

    public void setLoancontrcode(String loancontrcode) {
        this.loancontrcode = loancontrcode;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;







}
