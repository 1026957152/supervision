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

@Table(name = "LN001")

public class LN001_approval_process {

















    @Id
    private String apprnum;
    private String apprbusitype;
    private String apprtype;
    private String authtype;
    private String appop;
    private Date appdate;

    private String chkop;
    private Date chkdate;
    private String approveop;

    private Date approvedate;
    private Date appfinishdate;
    private Date appcanceldate;
    private String apprstate;
    private Integer instance;


    public String getApprnum() {
        return apprnum;
    }

    public void setApprnum(String apprnum) {
        this.apprnum = apprnum;
    }

    public String getApprbusitype() {
        return apprbusitype;
    }

    public void setApprbusitype(String apprbusitype) {
        this.apprbusitype = apprbusitype;
    }

    public String getApprtype() {
        return apprtype;
    }

    public void setApprtype(String apprtype) {
        this.apprtype = apprtype;
    }

    public String getAuthtype() {
        return authtype;
    }

    public void setAuthtype(String authtype) {
        this.authtype = authtype;
    }

    public String getAppop() {
        return appop;
    }

    public void setAppop(String appop) {
        this.appop = appop;
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    public String getChkop() {
        return chkop;
    }

    public void setChkop(String chkop) {
        this.chkop = chkop;
    }

    public Date getChkdate() {
        return chkdate;
    }

    public void setChkdate(Date chkdate) {
        this.chkdate = chkdate;
    }

    public String getApproveop() {
        return approveop;
    }

    public void setApproveop(String approveop) {
        this.approveop = approveop;
    }

    public Date getApprovedate() {
        return approvedate;
    }

    public void setApprovedate(Date approvedate) {
        this.approvedate = approvedate;
    }

    public Date getAppfinishdate() {
        return appfinishdate;
    }

    public void setAppfinishdate(Date appfinishdate) {
        this.appfinishdate = appfinishdate;
    }

    public Date getAppcanceldate() {
        return appcanceldate;
    }

    public void setAppcanceldate(Date appcanceldate) {
        this.appcanceldate = appcanceldate;
    }

    public String getApprstate() {
        return apprstate;
    }

    public void setApprstate(String apprstate) {
        this.apprstate = apprstate;
    }

    public Integer getInstance() {
        return instance;
    }

    public void setInstance(Integer instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
