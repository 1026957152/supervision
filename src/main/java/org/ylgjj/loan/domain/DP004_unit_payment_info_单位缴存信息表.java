package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "DP004")

public class DP004_unit_payment_info_单位缴存信息表 {




    @Id

    @Column(name = "unitaccnum")
    private String unitaccnum单位账号;


    @Column(name = "unitcustid")
    private String unitcustid_单位客户号;








    @Column(name = "fundsouflag")
    private String fundsouflag_资金来源标志;

    @Column(name = "begpayym")
    private String begpayym_起始汇缴年月;


    @Column(name = "lpaym")
    private String lpaym_缴至年月;



    @Column(name = "basenum")
    private String basenum_缴存基数;



    @Column(name = "indinorprop")
    private String indinorprop_个人正常比例;

    @Column(name = "indihigprop")
    private String indihigprop_个人高比例;

    @Column(name = "indispeprop")
    private String indispeprop_个人特殊比例;









    @Column(name = "unitnorprop")
    private String unitnorprop_单位正常比例;

    @Column(name = "unithigprop")
    private String unithigprop_单位高比例;

    @Column(name = "unitspeprop")
    private String unitspeprop_单位特殊比例;


    public String getIndinorprop_个人正常比例() {
        return indinorprop_个人正常比例;
    }

    public void setIndinorprop_个人正常比例(String indinorprop_个人正常比例) {
        this.indinorprop_个人正常比例 = indinorprop_个人正常比例;
    }

    public String getIndihigprop_个人高比例() {
        return indihigprop_个人高比例;
    }

    public void setIndihigprop_个人高比例(String indihigprop_个人高比例) {
        this.indihigprop_个人高比例 = indihigprop_个人高比例;
    }

    public String getIndispeprop_个人特殊比例() {
        return indispeprop_个人特殊比例;
    }

    public void setIndispeprop_个人特殊比例(String indispeprop_个人特殊比例) {
        this.indispeprop_个人特殊比例 = indispeprop_个人特殊比例;
    }

    public String getUnitnorprop_单位正常比例() {
        return unitnorprop_单位正常比例;
    }

    public void setUnitnorprop_单位正常比例(String unitnorprop_单位正常比例) {
        this.unitnorprop_单位正常比例 = unitnorprop_单位正常比例;
    }

    public String getUnithigprop_单位高比例() {
        return unithigprop_单位高比例;
    }

    public void setUnithigprop_单位高比例(String unithigprop_单位高比例) {
        this.unithigprop_单位高比例 = unithigprop_单位高比例;
    }

    public String getUnitspeprop_单位特殊比例() {
        return unitspeprop_单位特殊比例;
    }

    public void setUnitspeprop_单位特殊比例(String unitspeprop_单位特殊比例) {
        this.unitspeprop_单位特殊比例 = unitspeprop_单位特殊比例;
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

    public String getFundsouflag_资金来源标志() {
        return fundsouflag_资金来源标志;
    }

    public void setFundsouflag_资金来源标志(String fundsouflag_资金来源标志) {
        this.fundsouflag_资金来源标志 = fundsouflag_资金来源标志;
    }

    public String getBegpayym_起始汇缴年月() {
        return begpayym_起始汇缴年月;
    }

    public void setBegpayym_起始汇缴年月(String begpayym_起始汇缴年月) {
        this.begpayym_起始汇缴年月 = begpayym_起始汇缴年月;
    }

    public String getLpaym_缴至年月() {
        return lpaym_缴至年月;
    }

    public void setLpaym_缴至年月(String lpaym_缴至年月) {
        this.lpaym_缴至年月 = lpaym_缴至年月;
    }

    public String getBasenum_缴存基数() {
        return basenum_缴存基数;
    }

    public void setBasenum_缴存基数(String basenum_缴存基数) {
        this.basenum_缴存基数 = basenum_缴存基数;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;





}
