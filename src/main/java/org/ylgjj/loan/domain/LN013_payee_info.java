package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "LN013")

public class LN013_payee_info {

    @Id
    private String loancontrcode;

    private String payeetype;
    private String payeename;
    private String bankname;
    private String contactnumber;
    private String openbankname;
    private String payeebankaccnum;

    private String kfsaccinstcode;

    private String certitype;
    private String certinum;

    public String getLoancontrcode() {
        return loancontrcode;
    }

    public void setLoancontrcode(String loancontrcode) {
        this.loancontrcode = loancontrcode;
    }

    public String getPayeetype() {
        return payeetype;
    }

    public void setPayeetype(String payeetype) {
        this.payeetype = payeetype;
    }

    public String getPayeename() {
        return payeename;
    }

    public void setPayeename(String payeename) {
        this.payeename = payeename;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getOpenbankname() {
        return openbankname;
    }

    public void setOpenbankname(String openbankname) {
        this.openbankname = openbankname;
    }

    public String getPayeebankaccnum() {
        return payeebankaccnum;
    }

    public void setPayeebankaccnum(String payeebankaccnum) {
        this.payeebankaccnum = payeebankaccnum;
    }

    public String getKfsaccinstcode() {
        return kfsaccinstcode;
    }

    public void setKfsaccinstcode(String kfsaccinstcode) {
        this.kfsaccinstcode = kfsaccinstcode;
    }

    public String getCertitype() {
        return certitype;
    }

    public void setCertitype(String certitype) {
        this.certitype = certitype;
    }

    public String getCertinum() {
        return certinum;
    }

    public void setCertinum(String certinum) {
        this.certinum = certinum;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;








}
