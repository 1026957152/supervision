package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "DP030")

public class DP030_单位缓缴登记簿 {

    @Id

    @Column(name = "apprnum")
    private String apprnum审批号; //YYYYMMDD+流水号		0:不可为空





    @Column(name = "transdate")
    private Date transdate不可为空交易日期;

    @Column(name = "unitaccnum")
    private String unitaccnum_单位账号;

    @Column(name = "begdate")
    private String begdate_可为空_开始日期;

    @Column(name = "enddate")
    private String enddate_不可为空_截止日期;


    @Column(name = "basenum")
    private String basenum_不可为空_缴存基数;
    @Column(name = "postpayflag")
    private String postpayflag_不可为空_缓缴标志; //0-正常,1-缓缴,2提前终止	0:不可为空




    @Column(name = "authfilenum")
    private String authfilenum_可为空_批准文号;

    @Column(name = "postreason")
    private String postreason_可为空_缓缴原因;

    public String getApprnum审批号() {
        return apprnum审批号;
    }

    public void setApprnum审批号(String apprnum审批号) {
        this.apprnum审批号 = apprnum审批号;
    }

    public Date getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(Date transdate不可为空交易日期) {
        this.transdate不可为空交易日期 = transdate不可为空交易日期;
    }

    public String getUnitaccnum_单位账号() {
        return unitaccnum_单位账号;
    }

    public void setUnitaccnum_单位账号(String unitaccnum_单位账号) {
        this.unitaccnum_单位账号 = unitaccnum_单位账号;
    }

    public String getBegdate_可为空_开始日期() {
        return begdate_可为空_开始日期;
    }

    public void setBegdate_可为空_开始日期(String begdate_可为空_开始日期) {
        this.begdate_可为空_开始日期 = begdate_可为空_开始日期;
    }

    public String getEnddate_不可为空_截止日期() {
        return enddate_不可为空_截止日期;
    }

    public void setEnddate_不可为空_截止日期(String enddate_不可为空_截止日期) {
        this.enddate_不可为空_截止日期 = enddate_不可为空_截止日期;
    }

    public String getBasenum_不可为空_缴存基数() {
        return basenum_不可为空_缴存基数;
    }

    public void setBasenum_不可为空_缴存基数(String basenum_不可为空_缴存基数) {
        this.basenum_不可为空_缴存基数 = basenum_不可为空_缴存基数;
    }

    public String getPostpayflag_不可为空_缓缴标志() {
        return postpayflag_不可为空_缓缴标志;
    }

    public void setPostpayflag_不可为空_缓缴标志(String postpayflag_不可为空_缓缴标志) {
        this.postpayflag_不可为空_缓缴标志 = postpayflag_不可为空_缓缴标志;
    }

    public String getAuthfilenum_可为空_批准文号() {
        return authfilenum_可为空_批准文号;
    }

    public void setAuthfilenum_可为空_批准文号(String authfilenum_可为空_批准文号) {
        this.authfilenum_可为空_批准文号 = authfilenum_可为空_批准文号;
    }

    public String getPostreason_可为空_缓缴原因() {
        return postreason_可为空_缓缴原因;
    }

    public void setPostreason_可为空_缓缴原因(String postreason_可为空_缓缴原因) {
        this.postreason_可为空_缓缴原因 = postreason_可为空_缓缴原因;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
