package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(LN005_key.class)
@Entity

@Table(name = "LN005")

public class LN005_贷款分户信息 {



/*"*列名
        （16位字符）"	列注释	属性	*空否标志	列中文描述
    loancontrcode_合同代码			0:不可为空	合同代码
    loanacctype		"01-正常贷款,
            02-逾期贷款,
            03-应收利息(表内),
13-应收利息(表外),
18-表外罚息"	0:不可为空	贷款分户类型
 */





    @Id
    @Column(name = "loancontrcode")
    private String loancontrcode合同代码;
    @Id
    @Column(name = "loanacctype")
    private String loanacctype_贷款分户类型;
/*
    loanacctype		"01-正常贷款,
            02-逾期贷款,
            03-应收利息(表内),
13-应收利息(表外),
18-表外罚息"	0:不可为空	贷款分户类型*/
@Id
    @Column(name = "loanaccnum")
    private String loanaccnum_贷款账号;


    @Column(name = "fundsource")
    private String fundsource_资金来源;
/*    fundsource_资金来源		"1-公积金,
            2-售房款,
            3-维修基金,
            9-其他"	0:不可为空	资金来源*/


    @Column(name = "subcode")
    private String subcode_科目控制字;

    @Column(name = "specflag")
    private String specflag_特殊标志;
/*    dcflag		"1-借方,
            2-贷方"	0:不可为空	借贷标志*/


    @Column(name = "dcflag")
    private String dcflag_借贷标志;

    @Column(name = "lastbal")
    private BigDecimal lastbal_上日余额;

    @Column(name = "curbal")
    private BigDecimal curbal_当前余额;

    @Column(name = "dailybal")
    private String dailybal_日终余额;


/*    specflag_特殊标志		"1-缓息,
            2-停息,
            3-理赔,             0-无"	1:可为空	特殊标志

    lastbal_上日余额			0:不可为空	上日余额
    curbal_当前余额			0:不可为空	当前余额*/





    public String getDailybal_日终余额() {
        return dailybal_日终余额;
    }

    public void setDailybal_日终余额(String dailybal_日终余额) {
        this.dailybal_日终余额 = dailybal_日终余额;
    }


    public BigDecimal getCurbal_当前余额() {
        return curbal_当前余额;
    }

    public void setCurbal_当前余额(BigDecimal curbal_当前余额) {
        this.curbal_当前余额 = curbal_当前余额;
    }

    public BigDecimal getLastbal_上日余额() {
        return lastbal_上日余额;
    }

    public void setLastbal_上日余额(BigDecimal lastbal_上日余额) {
        this.lastbal_上日余额 = lastbal_上日余额;
    }




    @Column(name = "intaccuamt")
    private String intaccuamt_积数;


    @Column(name = "accudays")
    private String accudays_积数天数;

    @Column(name = "rateadjflag")
    private String rateadjflag_利率调整标志;



    @Column(name = "repaydate")
    private String repaydate_还款日期;





    @Column(name = "currate")
    private double currate_执行利率;

    @Column(name = "oweamt")
    private String oweamt_欠还金额;


    @Column(name = "begintdate")
    private String begintdate_当期起息日期;


    @Column(name = "lastratedate")
    private String lastratedate_上次利率调整日期;

    @Column(name = "lastcalintdate")
    private String lastcalintdate_上次计息日期;


    @Column(name = "planprin")
    private String planprin_当期计划扣本金;


    @Column(name = "currintamt")
    private double currintamt_当期利息金额;



    @Column(name = "currintdays")
    private String currintdays_还款日期;

    @Column(name = "monthrepayamt")
    private BigDecimal monthrepayamt_贷款月还款额_本金_;

    public String getFundsource_资金来源() {
        return fundsource_资金来源;
    }

    public void setFundsource_资金来源(String fundsource_资金来源) {
        this.fundsource_资金来源 = fundsource_资金来源;
    }

    public String getSubcode_科目控制字() {
        return subcode_科目控制字;
    }

    public void setSubcode_科目控制字(String subcode_科目控制字) {
        this.subcode_科目控制字 = subcode_科目控制字;
    }

    public String getSpecflag_特殊标志() {
        return specflag_特殊标志;
    }

    public void setSpecflag_特殊标志(String specflag_特殊标志) {
        this.specflag_特殊标志 = specflag_特殊标志;
    }

    public String getDcflag_借贷标志() {
        return dcflag_借贷标志;
    }

    public void setDcflag_借贷标志(String dcflag_借贷标志) {
        this.dcflag_借贷标志 = dcflag_借贷标志;
    }

    public String getIntaccuamt_积数() {
        return intaccuamt_积数;
    }

    public void setIntaccuamt_积数(String intaccuamt_积数) {
        this.intaccuamt_积数 = intaccuamt_积数;
    }

    public String getAccudays_积数天数() {
        return accudays_积数天数;
    }

    public void setAccudays_积数天数(String accudays_积数天数) {
        this.accudays_积数天数 = accudays_积数天数;
    }

    public String getRateadjflag_利率调整标志() {
        return rateadjflag_利率调整标志;
    }

    public void setRateadjflag_利率调整标志(String rateadjflag_利率调整标志) {
        this.rateadjflag_利率调整标志 = rateadjflag_利率调整标志;
    }

    public String getRepaydate_还款日期() {
        return repaydate_还款日期;
    }

    public void setRepaydate_还款日期(String repaydate_还款日期) {
        this.repaydate_还款日期 = repaydate_还款日期;
    }

    public double getCurrate_执行利率() {
        return currate_执行利率;
    }

    public void setCurrate_执行利率(double currate_执行利率) {
        this.currate_执行利率 = currate_执行利率;
    }

    public String getBegintdate_当期起息日期() {
        return begintdate_当期起息日期;
    }

    public void setBegintdate_当期起息日期(String begintdate_当期起息日期) {
        this.begintdate_当期起息日期 = begintdate_当期起息日期;
    }

    public String getLastratedate_上次利率调整日期() {
        return lastratedate_上次利率调整日期;
    }

    public void setLastratedate_上次利率调整日期(String lastratedate_上次利率调整日期) {
        this.lastratedate_上次利率调整日期 = lastratedate_上次利率调整日期;
    }

    public String getLastcalintdate_上次计息日期() {
        return lastcalintdate_上次计息日期;
    }

    public void setLastcalintdate_上次计息日期(String lastcalintdate_上次计息日期) {
        this.lastcalintdate_上次计息日期 = lastcalintdate_上次计息日期;
    }

    public String getPlanprin_当期计划扣本金() {
        return planprin_当期计划扣本金;
    }

    public void setPlanprin_当期计划扣本金(String planprin_当期计划扣本金) {
        this.planprin_当期计划扣本金 = planprin_当期计划扣本金;
    }

    public double getCurrintamt_当期利息金额() {
        return currintamt_当期利息金额;
    }

    public void setCurrintamt_当期利息金额(double currintamt_当期利息金额) {
        this.currintamt_当期利息金额 = currintamt_当期利息金额;
    }

    public String getCurrintdays_还款日期() {
        return currintdays_还款日期;
    }

    public void setCurrintdays_还款日期(String currintdays_还款日期) {
        this.currintdays_还款日期 = currintdays_还款日期;
    }

    public BigDecimal getMonthrepayamt_贷款月还款额_本金_() {
        return monthrepayamt_贷款月还款额_本金_;
    }

    public void setMonthrepayamt_贷款月还款额_本金_(BigDecimal monthrepayamt_贷款月还款额_本金_) {
        this.monthrepayamt_贷款月还款额_本金_ = monthrepayamt_贷款月还款额_本金_;
    }
    /*    oweamt_欠还金额 loanacctype=18时为欠本息合计；loanacctype=01时为未生成还款计划的本金		1:可为空	欠还金额*/


/*    intaccuamt			0:不可为空	积数
    accudays			0:不可为空	积数天数*/


/*    rateadjflag_利率调整标志		"1-是,
            0-否"	0:不可为空	利率调整标志
    ratetype		"1-日利率,
            2-月利率,
            3-年利率"	0:不可为空	利率类型
    currate_执行利率			0:不可为空	执行利率
    begintdate_当期起息日期			0:不可为空	当期起息日期
    lastratedate_上次利率调整日期			1:可为空	上次利率调整日期
    lastcalintdate_上次计息日期			1:可为空	上次计息日期
    planprin_当期计划扣本金			0:不可为空	当期计划扣本金
    currintamt_当期利息金额			0:不可为空	当期利息金额
    currintdays_还款日期			0:不可为空	当期已记利息天数
    monthrepayamt_贷款月还款额_本金_			0:不可为空	贷款月还款额（本金）
    repaydate_还款日期			0:不可为空	还款日期
    lasttransdate			0:不可为空	上笔交易日期
    accinstcode			0:不可为空	账户机构
    agentbankcode			0:不可为空	经办银行*/





    public String getOweamt_欠还金额() {
        return oweamt_欠还金额;
    }

    public void setOweamt_欠还金额(String oweamt_欠还金额) {
        this.oweamt_欠还金额 = oweamt_欠还金额;
    }

    public String getLoanacctype_贷款分户类型() {
        return loanacctype_贷款分户类型;
    }

    public void setLoanacctype_贷款分户类型(String loanacctype_贷款分户类型) {
        this.loanacctype_贷款分户类型 = loanacctype_贷款分户类型;
    }

    public String getLoanaccnum_贷款账号() {
        return loanaccnum_贷款账号;
    }

    public void setLoanaccnum_贷款账号(String loanaccnum_贷款账号) {
        this.loanaccnum_贷款账号 = loanaccnum_贷款账号;
    }


    public String getLoancontrcode合同代码() {
        return loancontrcode合同代码;
    }

    public void setLoancontrcode合同代码(String loancontrcode合同代码) {
        this.loancontrcode合同代码 = loancontrcode合同代码;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
