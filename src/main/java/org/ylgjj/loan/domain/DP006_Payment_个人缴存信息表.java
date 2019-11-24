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

@Table(name = "DP006")//归集子系统

public class DP006_Payment_个人缴存信息表 {

    @Id
    @Column(name = "accnum")
    private String accnum个人账号;

    @Column(name = "custid")
    private String custid个人客户号;



    @Column(name = "attworkdate")
    private Date attworkdate_参加工作时间;
    private String begpayym;

    @Column(name = "lpaym")
    private String lpaym_缴至年月;


    @Column(name = "basenum")
    private BigDecimal basenum_缴存基数;


    
    private String proptype;

    @Column(name = "fundsouflag")
    private String fundsouflag_资金来源标志;

    @Column(name = "unitprop")
    private BigDecimal unitprop_单位比例;

    @Column(name = "unitastprop")
    private BigDecimal unitastprop_单位辅助比例;

    @Column(name = "indiprop")
    private BigDecimal indiprop_个人缴存比例;


    @Column(name = "unitpayamt")
    private BigDecimal unitpayamt_单位月汇缴金额;
    private BigDecimal unitapayamt;

    @Column(name = "indipayamt")
    private BigDecimal indipayamt_个人月汇缴金额;



    private BigDecimal indipaysum;
    private String indipaymap;
    private String indibpaymap;
    private BigDecimal byearbal;


    @Column(name = "ydrawamt")
    private BigDecimal ydrawamt_年提取额;


    public BigDecimal getYdrawamt_年提取额() {
        return ydrawamt_年提取额;
    }

    public void setYdrawamt_年提取额(BigDecimal ydrawamt_年提取额) {
        this.ydrawamt_年提取额 = ydrawamt_年提取额;
    }

    public String getCustid个人客户号() {
        return custid个人客户号;
    }

    public void setCustid个人客户号(String custid个人客户号) {
        this.custid个人客户号 = custid个人客户号;
    }

    public Date getAttworkdate_参加工作时间() {
        return attworkdate_参加工作时间;
    }

    public void setAttworkdate_参加工作时间(Date attworkdate_参加工作时间) {
        this.attworkdate_参加工作时间 = attworkdate_参加工作时间;
    }

    public String getBegpayym() {
        return begpayym;
    }

    public void setBegpayym(String begpayym) {
        this.begpayym = begpayym;
    }

    public String getLpaym_缴至年月() {
        return lpaym_缴至年月;
    }

    public void setLpaym_缴至年月(String lpaym_缴至年月) {
        this.lpaym_缴至年月 = lpaym_缴至年月;
    }

    public BigDecimal getBasenum_缴存基数() {
        return basenum_缴存基数;
    }

    public void setBasenum_缴存基数(BigDecimal basenum_缴存基数) {
        this.basenum_缴存基数 = basenum_缴存基数;
    }

    public String getProptype() {
        return proptype;
    }

    public void setProptype(String proptype) {
        this.proptype = proptype;
    }

    public String getFundsouflag_资金来源标志() {
        return fundsouflag_资金来源标志;
    }

    public void setFundsouflag_资金来源标志(String fundsouflag_资金来源标志) {
        this.fundsouflag_资金来源标志 = fundsouflag_资金来源标志;
    }

    public BigDecimal getUnitprop_单位比例() {
        return unitprop_单位比例;
    }

    public void setUnitprop_单位比例(BigDecimal unitprop_单位比例) {
        this.unitprop_单位比例 = unitprop_单位比例;
    }

    public BigDecimal getUnitastprop_单位辅助比例() {
        return unitastprop_单位辅助比例;
    }

    public void setUnitastprop_单位辅助比例(BigDecimal unitastprop_单位辅助比例) {
        this.unitastprop_单位辅助比例 = unitastprop_单位辅助比例;
    }

    public BigDecimal getIndiprop_个人缴存比例() {
        return indiprop_个人缴存比例;
    }

    public void setIndiprop_个人缴存比例(BigDecimal indiprop_个人缴存比例) {
        this.indiprop_个人缴存比例 = indiprop_个人缴存比例;
    }

    public BigDecimal getUnitpayamt_单位月汇缴金额() {
        return unitpayamt_单位月汇缴金额;
    }

    public void setUnitpayamt_单位月汇缴金额(BigDecimal unitpayamt_单位月汇缴金额) {
        this.unitpayamt_单位月汇缴金额 = unitpayamt_单位月汇缴金额;
    }

    public BigDecimal getUnitapayamt() {
        return unitapayamt;
    }

    public void setUnitapayamt(BigDecimal unitapayamt) {
        this.unitapayamt = unitapayamt;
    }

    public BigDecimal getIndipayamt_个人月汇缴金额() {
        return indipayamt_个人月汇缴金额;
    }

    public void setIndipayamt_个人月汇缴金额(BigDecimal indipayamt_个人月汇缴金额) {
        this.indipayamt_个人月汇缴金额 = indipayamt_个人月汇缴金额;
    }

    public BigDecimal getIndipaysum() {
        return indipaysum;
    }

    public void setIndipaysum(BigDecimal indipaysum) {
        this.indipaysum = indipaysum;
    }

    public String getIndipaymap() {
        return indipaymap;
    }

    public void setIndipaymap(String indipaymap) {
        this.indipaymap = indipaymap;
    }

    public String getIndibpaymap() {
        return indibpaymap;
    }

    public void setIndibpaymap(String indibpaymap) {
        this.indibpaymap = indibpaymap;
    }

    public BigDecimal getByearbal() {
        return byearbal;
    }

    public void setByearbal(BigDecimal byearbal) {
        this.byearbal = byearbal;
    }

    public String getAccnum个人账号() {
        return accnum个人账号;
    }

    public void setAccnum个人账号(String accnum个人账号) {
        this.accnum个人账号 = accnum个人账号;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;








}
