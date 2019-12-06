package org.ylgjj.loan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "LN002")

public class LN002 {



    @Id

    private String loancontrcode;

    private Integer seqnum;

    private String loanchgtype;

    private BigDecimal loanamt;
    private Integer loanterm;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loandate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date attermdate;

    public String getLoancontrcode() {
        return loancontrcode;
    }

    public void setLoancontrcode(String loancontrcode) {
        this.loancontrcode = loancontrcode;
    }


    public Integer getSeqnum() {
        return seqnum;
    }

    public void setSeqnum(Integer seqnum) {
        this.seqnum = seqnum;
    }

    public String getLoanchgtype() {
        return loanchgtype;
    }

    public void setLoanchgtype(String loanchgtype) {
        this.loanchgtype = loanchgtype;
    }

    public BigDecimal getLoanamt() {
        return loanamt;
    }

    public void setLoanamt(BigDecimal loanamt) {
        this.loanamt = loanamt;
    }

    public Integer getLoanterm() {
        return loanterm;
    }

    public void setLoanterm(Integer loanterm) {
        this.loanterm = loanterm;
    }

    public Date getLoandate() {
        return loandate;
    }

    public void setLoandate(Date loandate) {
        this.loandate = loandate;
    }

    public Date getAttermdate() {
        return attermdate;
    }

    public void setAttermdate(Date attermdate) {
        this.attermdate = attermdate;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
