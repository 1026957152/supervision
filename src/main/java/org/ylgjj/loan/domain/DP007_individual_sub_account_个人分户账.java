package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "DP007")//归集子系统

public class DP007_individual_sub_account_个人分户账 {

    @Id
    @Column(name = "accnum")
    private String accnum个人账号;

    @Column(name = "unitaccnum")
    private String unitaccnum_单位账号;

    @Column(name = "custid")
    private String custid_个人客户号;

    @Column(name = "accname")
    private String accname_姓名;

    @Column(name = "certitype")
    private String certitype_证件类型;

    @Column(name = "certinum")
    private String certinum_证件号码;

    @Column(name = "indiacctype")
    private String indiacctype_个人账户类型;

    @Column(name = "indiaccstate")
    private String indiaccstate_个人账户状态;

    @Column(name = "frzflag")
    private String frzflag_冻结标志;

    //开户日期
    @Column(name = "opnaccdate")
    private Date opnaccdate_开户日期;

    @Column(name = "clsaccdate")
    private Date clsaccdate_销户日期;

    @Column(name = "lasttransdate")
    private Date lasttransdate_上笔发生日期;

    @Column(name = "lastdrawdate")
    private Date lastdrawdate_上笔提取日期;

    @Column(name = "begintdate")
    private Date begintdate_起息日期;

    @Column(name = "trustdate")
    private Date trustdate_托管日期;


    @Column(name = "lastbal")
    private BigDecimal lastbal_上日余额;


    @Column(name = "frzamt")
    private BigDecimal frzamt;

    @Column(name = "stpayamt")
    private BigDecimal stpayamt;


    @Column(name = "keepbal")
    private BigDecimal keepbal;

    @Column(name = "bal")
    private BigDecimal bal_余额;


    @Column(name = "accinstcode")
    private String accinstcode;



    public String getAccinstcode() {
        return accinstcode;
    }

    public void setAccinstcode(String accinstcode) {
        this.accinstcode = accinstcode;
    }

    public String getAccnum_个人账号() {
        return accnum个人账号;
    }

    public void setAccnum_个人账号(String accnum_个人账号) {
        this.accnum个人账号 = accnum_个人账号;
    }

    public String getUnitaccnum_单位账号() {
        return unitaccnum_单位账号;
    }

    public void setUnitaccnum_单位账号(String unitaccnum_单位账号) {
        this.unitaccnum_单位账号 = unitaccnum_单位账号;
    }

    public String getCustid_个人客户号() {
        return custid_个人客户号;
    }

    public void setCustid_个人客户号(String custid_个人客户号) {
        this.custid_个人客户号 = custid_个人客户号;
    }

    public String getAccname_姓名() {
        return accname_姓名;
    }

    public void setAccname_姓名(String accname_姓名) {
        this.accname_姓名 = accname_姓名;
    }

    public String getCertitype_证件类型() {
        return certitype_证件类型;
    }

    public void setCertitype_证件类型(String certitype_证件类型) {
        this.certitype_证件类型 = certitype_证件类型;
    }

    public String getCertinum_证件号码() {
        return certinum_证件号码;
    }

    public void setCertinum_证件号码(String certinum_证件号码) {
        this.certinum_证件号码 = certinum_证件号码;
    }

    public String getFrzflag_冻结标志() {
        return frzflag_冻结标志;
    }

    public void setFrzflag_冻结标志(String frzflag_冻结标志) {
        this.frzflag_冻结标志 = frzflag_冻结标志;
    }

    public String getIndiacctype_个人账户类型() {
        return indiacctype_个人账户类型;
    }

    public void setIndiacctype_个人账户类型(String indiacctype_个人账户类型) {
        this.indiacctype_个人账户类型 = indiacctype_个人账户类型;
    }

    public String getIndiaccstate_个人账户状态() {
        return indiaccstate_个人账户状态;
    }

    public void setIndiaccstate_个人账户状态(String indiaccstate_个人账户状态) {
        this.indiaccstate_个人账户状态 = indiaccstate_个人账户状态;
    }

    public Date getOpnaccdate_开户日期() {
        return opnaccdate_开户日期;
    }

    public void setOpnaccdate_开户日期(Date opnaccdate_开户日期) {
        this.opnaccdate_开户日期 = opnaccdate_开户日期;
    }

    public Date getClsaccdate_销户日期() {
        return clsaccdate_销户日期;
    }

    public void setClsaccdate_销户日期(Date clsaccdate_销户日期) {
        this.clsaccdate_销户日期 = clsaccdate_销户日期;
    }

    public Date getLasttransdate_上笔发生日期() {
        return lasttransdate_上笔发生日期;
    }

    public void setLasttransdate_上笔发生日期(Date lasttransdate_上笔发生日期) {
        this.lasttransdate_上笔发生日期 = lasttransdate_上笔发生日期;
    }

    public Date getLastdrawdate_上笔提取日期() {
        return lastdrawdate_上笔提取日期;
    }

    public void setLastdrawdate_上笔提取日期(Date lastdrawdate_上笔提取日期) {
        this.lastdrawdate_上笔提取日期 = lastdrawdate_上笔提取日期;
    }

    public Date getBegintdate_起息日期() {
        return begintdate_起息日期;
    }

    public void setBegintdate_起息日期(Date begintdate_起息日期) {
        this.begintdate_起息日期 = begintdate_起息日期;
    }

    public Date getTrustdate_托管日期() {
        return trustdate_托管日期;
    }

    public void setTrustdate_托管日期(Date trustdate_托管日期) {
        this.trustdate_托管日期 = trustdate_托管日期;
    }

    public BigDecimal getLastbal_上日余额() {
        return lastbal_上日余额;
    }

    public void setLastbal_上日余额(BigDecimal lastbal_上日余额) {
        this.lastbal_上日余额 = lastbal_上日余额;
    }

    public BigDecimal getFrzamt() {
        return frzamt;
    }

    public void setFrzamt(BigDecimal frzamt) {
        this.frzamt = frzamt;
    }

    public BigDecimal getStpayamt() {
        return stpayamt;
    }

    public void setStpayamt(BigDecimal stpayamt) {
        this.stpayamt = stpayamt;
    }

    public BigDecimal getKeepbal() {
        return keepbal;
    }

    public void setKeepbal(BigDecimal keepbal) {
        this.keepbal = keepbal;
    }

    public BigDecimal getBal_余额() {
        return bal_余额;
    }

    public void setBal_余额(BigDecimal bal_余额) {
        this.bal_余额 = bal_余额;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }










}
