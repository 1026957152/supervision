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

@Table(name = "DP005")

public class DP005_work_unit_单位分户账 {

    @Id
    @Column(name = "unitaccnum")
    private String unitaccnum单位账号;

    @Column(name = "unitcustid")
    private String unitcustid_单位客户号;


    @Column(name = "unitaccname")
    private String unitaccname_单位名称;

    @Column(name = "subcode")
    private String subcode;

    @Column(name = "exttranslvl")
    private String exttranslvl;

    @Column(name = "unitaccstate")
    private String unitaccstate_单位账户状态;


    @Column(name = "frzflag")
    private String frzflag_冻结标志;

    @Column(name = "unitacctype")
    private String unitacctype_单位账户类型;


    @Column(name = "lastbal")
    private BigDecimal lastbal_上日余额;


    @Column(name = "frzamt")
    private BigDecimal frzamt_冻结金额;

    @Column(name = "stpayamt")
    private BigDecimal stpayamt;

    @Column(name = "bal")
    private BigDecimal bal_余额;

    @Column(name = "lasttransdate")
    private Date lasttransdate_上笔发生日期;

    @Column(name = "begintdate")
    private Date begintdate_起息日期;

    @Column(name = "opnaccdate")
    private Date opnaccdate__开户日期;

    @Column(name = "clsaccdate")
    private Date clsaccdate_销户日期;

    @Column(name = "intaccu")
    private BigDecimal intaccu;

    @Column(name = "calintflag")
    private String calintflag;

    @Column(name = "accinstcode")
    private String accinstcode_账户机构;

    public String getAccinstcode_账户机构() {
        return accinstcode_账户机构;
    }

    public void setAccinstcode_账户机构(String accinstcode_账户机构) {
        this.accinstcode_账户机构 = accinstcode_账户机构;
    }

    public String getUnitaccnum单位账号() {
        return unitaccnum单位账号;
    }

    public void setUnitaccnum单位账号(String unitaccnum单位账号) {
        this.unitaccnum单位账号 = unitaccnum单位账号;
    }

    public String getUnitcustid_单位客户号() {
        return unitcustid_单位客户号;
    }

    public void setUnitcustid_单位客户号(String unitcustid_单位客户号) {
        this.unitcustid_单位客户号 = unitcustid_单位客户号;
    }

    public String getUnitaccname_单位名称() {
        return unitaccname_单位名称;
    }

    public void setUnitaccname_单位名称(String unitaccname_单位名称) {
        this.unitaccname_单位名称 = unitaccname_单位名称;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    public String getExttranslvl() {
        return exttranslvl;
    }

    public void setExttranslvl(String exttranslvl) {
        this.exttranslvl = exttranslvl;
    }

    public String getUnitaccstate_单位账户状态() {
        return unitaccstate_单位账户状态;
    }

    public void setUnitaccstate_单位账户状态(String unitaccstate_单位账户状态) {
        this.unitaccstate_单位账户状态 = unitaccstate_单位账户状态;
    }

    public String getFrzflag_冻结标志() {
        return frzflag_冻结标志;
    }

    public void setFrzflag_冻结标志(String frzflag_冻结标志) {
        this.frzflag_冻结标志 = frzflag_冻结标志;
    }

    public String getUnitacctype_单位账户类型() {
        return unitacctype_单位账户类型;
    }

    public void setUnitacctype_单位账户类型(String unitacctype_单位账户类型) {
        this.unitacctype_单位账户类型 = unitacctype_单位账户类型;
    }

    public BigDecimal getLastbal_上日余额() {
        return lastbal_上日余额;
    }

    public void setLastbal_上日余额(BigDecimal lastbal_上日余额) {
        this.lastbal_上日余额 = lastbal_上日余额;
    }

    public BigDecimal getFrzamt_冻结金额() {
        return frzamt_冻结金额;
    }

    public void setFrzamt_冻结金额(BigDecimal frzamt_冻结金额) {
        this.frzamt_冻结金额 = frzamt_冻结金额;
    }

    public BigDecimal getStpayamt() {
        return stpayamt;
    }

    public void setStpayamt(BigDecimal stpayamt) {
        this.stpayamt = stpayamt;
    }

    public BigDecimal getBal_余额() {
        return bal_余额;
    }

    public void setBal_余额(BigDecimal bal_余额) {
        this.bal_余额 = bal_余额;
    }

    public Date getLasttransdate_上笔发生日期() {
        return lasttransdate_上笔发生日期;
    }

    public void setLasttransdate_上笔发生日期(Date lasttransdate_上笔发生日期) {
        this.lasttransdate_上笔发生日期 = lasttransdate_上笔发生日期;
    }

    public Date getBegintdate_起息日期() {
        return begintdate_起息日期;
    }

    public void setBegintdate_起息日期(Date begintdate_起息日期) {
        this.begintdate_起息日期 = begintdate_起息日期;
    }

    public Date getOpnaccdate__开户日期() {
        return opnaccdate__开户日期;
    }

    public void setOpnaccdate__开户日期(Date opnaccdate__开户日期) {
        this.opnaccdate__开户日期 = opnaccdate__开户日期;
    }

    public Date getClsaccdate_销户日期() {
        return clsaccdate_销户日期;
    }

    public void setClsaccdate_销户日期(Date clsaccdate_销户日期) {
        this.clsaccdate_销户日期 = clsaccdate_销户日期;
    }

    public BigDecimal getIntaccu() {
        return intaccu;
    }

    public void setIntaccu(BigDecimal intaccu) {
        this.intaccu = intaccu;
    }

    public String getCalintflag() {
        return calintflag;
    }

    public void setCalintflag(String calintflag) {
        this.calintflag = calintflag;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
