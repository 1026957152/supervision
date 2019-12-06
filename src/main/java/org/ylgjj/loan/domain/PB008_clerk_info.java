package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "PB008")

public class PB008_clerk_info {

    @Id
    private String operid;

    private String centerid;

    private String instcode;

    private String opcode;
    private String optype;
    private String opname;

    private String oprole;
    private String tmprole;

    private Date begdate;

    private Date enddate;

    private String opstat;


    private String certinum;

    private String headship;

    private String validflag;

    public String getOperid() {
        return operid;
    }

    public void setOperid(String operid) {
        this.operid = operid;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getInstcode() {
        return instcode;
    }

    public void setInstcode(String instcode) {
        this.instcode = instcode;
    }

    public String getOpcode() {
        return opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getOptype() {
        return optype;
    }

    public void setOptype(String optype) {
        this.optype = optype;
    }

    public String getOpname() {
        return opname;
    }

    public void setOpname(String opname) {
        this.opname = opname;
    }

    public String getOprole() {
        return oprole;
    }

    public void setOprole(String oprole) {
        this.oprole = oprole;
    }

    public String getTmprole() {
        return tmprole;
    }

    public void setTmprole(String tmprole) {
        this.tmprole = tmprole;
    }

    public Date getBegdate() {
        return begdate;
    }

    public void setBegdate(Date begdate) {
        this.begdate = begdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getOpstat() {
        return opstat;
    }

    public void setOpstat(String opstat) {
        this.opstat = opstat;
    }

    public String getCertinum() {
        return certinum;
    }

    public void setCertinum(String certinum) {
        this.certinum = certinum;
    }

    public String getHeadship() {
        return headship;
    }

    public void setHeadship(String headship) {
        this.headship = headship;
    }

    public String getValidflag() {
        return validflag;
    }

    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
