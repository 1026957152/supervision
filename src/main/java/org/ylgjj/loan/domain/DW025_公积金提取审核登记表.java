package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "DW025")

public class DW025_公积金提取审核登记表 {

    @Id
    @Column(name = "apprnum")
    private String apprnum_审批号;

    @Column(name = "transdate")
    private LocalDate transdate交易日期;

    @Column(name = "custid")
    private String custid_客户号;

    @Column(name = "apprstate")
    private String apprstate_审批状态;

    @Column(name = "drawreason")
    private String drawreason_提取原因;


    @Column(name = "drawamt")
    private BigDecimal drawamt_提取金额;
    @Column(name = "inputamt")
    private BigDecimal inputamt_初审金额;
    @Column(name = "bal")
    private BigDecimal bal_提取前的余额;
    @Column(name = "accnum")
    private String accnum个人账号;


    @Column(name = "accname")
    private String accname_姓名;
    @Column(name = "drawcertinum")
    private String drawcertinum_提取人身份证号;

    public String getAccname_姓名() {
        return accname_姓名;
    }

    public void setAccname_姓名(String accname_姓名) {
        this.accname_姓名 = accname_姓名;
    }

    public String getDrawcertinum_提取人身份证号() {
        return drawcertinum_提取人身份证号;
    }

    public void setDrawcertinum_提取人身份证号(String drawcertinum_提取人身份证号) {
        this.drawcertinum_提取人身份证号 = drawcertinum_提取人身份证号;
    }

    public String getApprnum_审批号() {
        return apprnum_审批号;
    }
    public void setApprnum_审批号(String apprnum_审批号) {
        this.apprnum_审批号 = apprnum_审批号;
    }
    public LocalDate getTransdate交易日期() {
        return transdate交易日期;
    }

    public void setTransdate交易日期(LocalDate transdate交易日期) {
        this.transdate交易日期 = transdate交易日期;
    }

    public String getCustid_客户号() {
        return custid_客户号;
    }

    public void setCustid_客户号(String custid_客户号) {
        this.custid_客户号 = custid_客户号;
    }

    public String getApprstate_审批状态() {
        return apprstate_审批状态;
    }

    public void setApprstate_审批状态(String apprstate_审批状态) {
        this.apprstate_审批状态 = apprstate_审批状态;
    }

    public String getDrawreason_提取原因() {
        return drawreason_提取原因;
    }

    public void setDrawreason_提取原因(String drawreason_提取原因) {
        this.drawreason_提取原因 = drawreason_提取原因;
    }

    public BigDecimal getDrawamt_提取金额() {
        return drawamt_提取金额;
    }

    public void setDrawamt_提取金额(BigDecimal drawamt_提取金额) {
        this.drawamt_提取金额 = drawamt_提取金额;
    }

    public BigDecimal getInputamt_初审金额() {
        return inputamt_初审金额;
    }

    public void setInputamt_初审金额(BigDecimal inputamt_初审金额) {
        this.inputamt_初审金额 = inputamt_初审金额;
    }

    public BigDecimal getBal_提取前的余额() {
        return bal_提取前的余额;
    }

    public void setBal_提取前的余额(BigDecimal bal_提取前的余额) {
        this.bal_提取前的余额 = bal_提取前的余额;
    }

    public String getAccnum个人账号() {
        return accnum个人账号;
    }

    public void setAccnum个人账号(String accnum个人账号) {
        this.accnum个人账号 = accnum个人账号;
    }

    public DW025_公积金提取审核登记表() {

    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
