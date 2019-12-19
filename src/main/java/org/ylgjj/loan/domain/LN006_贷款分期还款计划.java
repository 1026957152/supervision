package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(LN006_RepaymentPlan_key.class)
@Entity

@Table(name = "LN006")

public class LN006_贷款分期还款计划 {


/*

    curseqstate本期状态		"0-未还,
            1-正常归还,
            2-逾期归还,
            3-提前部分,
            4-提前全部,
            9-逾期"	0:不可为空	本期状态
    fullrepayflag			0:不可为空	全额还款标志
    forcededflag强扣标志1		"1-是,
            0-否"	0:不可为空	强扣标志
    claimflag		"1-是,
            0-否"	0:不可为空	理赔标志
    canverflag		"1-是,
            0-否"	0:不可为空	核销标志
    derateflag		"0-否,
            1-罚息,
            2-利息,
            3-罚息+利息"	0:不可为空	减免息标志
    delayflag		"1-是,
            0-否"	0:不可为空	缓息标志
    suspnflag		"1-是,
            0-否"	0:不可为空	停息标志
    deductflag		"1-是,
            0-否"	0:不可为空	扣除标志
    repaymode		"1-等额本息,
            2-等额本金,
            3-等本等息,
            4-利随本清"	0:不可为空	还款方式
    accinstcode			0:不可为空	账户机构*/


    @Column(name = "repaymode")
    private String repaymode0还款方式;


    @Id

    @Column(name = "loancontrcode")
    private String loancontrcode0合同代码;

    @Id
    @Column(name = "termnum")
    private Integer termnum0第N期;

    @Column(name = "seqno")
    private String seqno0序号;




/*    repaydate1还款日期			1:可为空	还款日期
    initialbal0期初余额			1:可为空	期初余额
    planprin0本期应还本金 本期应还本金		0:不可为空	应还本金
    planint本期应还利息0 本期应还利息		0:不可为空	应还利息
    oweprin本期未还本金0 本期未还本金		1:可为空	欠还本金
    oweint	本期未还利息		1:可为空	欠还利息
    specdealint特殊处理利息0			1:可为空	特殊处理利息
    repaypun实还罚息1			1:可为空	实还罚息
    owepun未还罚息1			1:可为空	未还罚息
    lastcalpundate上次罚息计息日1			1:可为空	上次罚息计息日*/
    @Column(name = "loanaccnum")
    private String loanaccnum0贷款账号;

    @Column(name = "subcode")
    private String subcode0科目控制字;

    @Column(name = "begdate")
    private LocalDate begdate0开始日期;
    @Column(name = "enddate")
    private LocalDate enddate0终止日期;

    @Column(name = "repaydate")
    private LocalDate repaydate1还款日期;

    @Column(name = "initialbal")
    private BigDecimal initialbal0期初余额;

    @Column(name = "planprin")
    private BigDecimal planprin0本期应还本金;

    @Column(name = "planint")
    private BigDecimal planint本期应还利息0;
    @Column(name = "oweprin")
    private BigDecimal oweprin本期未还本金0;

    @Column(name = "oweint")
    private BigDecimal oweint本期未还利息0;

    @Column(name = "specdealint")
    private BigDecimal specdealint特殊处理利息0;
    @Column(name = "repaypun")
    private BigDecimal repaypun实还罚息1;
    @Column(name = "forcededflag")
    private String forcededflag强扣标志1;

    public String getForcededflag强扣标志1() {
        return forcededflag强扣标志1;
    }

    public void setForcededflag强扣标志1(String forcededflag强扣标志1) {
        this.forcededflag强扣标志1 = forcededflag强扣标志1;
    }


    @Column(name = "owepun")
    private String owepun未还罚息1;

    @Column(name = "lastcalpundate")
    private Date lastcalpundate上次罚息计息日1;

    @Column(name = "curseqstate")
    private String curseqstate本期状态;


    public String getLoancontrcode0合同代码() {
        return loancontrcode0合同代码;
    }

    public void setLoancontrcode0合同代码(String loancontrcode0合同代码) {
        this.loancontrcode0合同代码 = loancontrcode0合同代码;
    }

    public Integer getTermnum0第N期() {
        return termnum0第N期;
    }

    public void setTermnum0第N期(Integer termnum0第N期) {
        this.termnum0第N期 = termnum0第N期;
    }

    public String getSeqno0序号() {
        return seqno0序号;
    }

    public void setSeqno0序号(String seqno0序号) {
        this.seqno0序号 = seqno0序号;
    }

    public String getLoanaccnum0贷款账号() {
        return loanaccnum0贷款账号;
    }

    public void setLoanaccnum0贷款账号(String loanaccnum0贷款账号) {
        this.loanaccnum0贷款账号 = loanaccnum0贷款账号;
    }

    public String getSubcode0科目控制字() {
        return subcode0科目控制字;
    }

    public void setSubcode0科目控制字(String subcode0科目控制字) {
        this.subcode0科目控制字 = subcode0科目控制字;
    }

    public LocalDate getBegdate0开始日期() {
        return begdate0开始日期;
    }

    public void setBegdate0开始日期(LocalDate begdate0开始日期) {
        this.begdate0开始日期 = begdate0开始日期;
    }

    public LocalDate getEnddate0终止日期() {
        return enddate0终止日期;
    }

    public void setEnddate0终止日期(LocalDate enddate0终止日期) {
        this.enddate0终止日期 = enddate0终止日期;
    }

    public LocalDate getRepaydate1还款日期() {
        return repaydate1还款日期;
    }

    public void setRepaydate1还款日期(LocalDate repaydate1还款日期) {
        this.repaydate1还款日期 = repaydate1还款日期;
    }

    public BigDecimal getInitialbal0期初余额() {
        return initialbal0期初余额;
    }

    public void setInitialbal0期初余额(BigDecimal initialbal0期初余额) {
        this.initialbal0期初余额 = initialbal0期初余额;
    }

    public BigDecimal getPlanprin0本期应还本金() {
        return planprin0本期应还本金;
    }

    public void setPlanprin0本期应还本金(BigDecimal planprin0本期应还本金) {
        this.planprin0本期应还本金 = planprin0本期应还本金;
    }

    public BigDecimal getPlanint本期应还利息0() {
        return planint本期应还利息0;
    }

    public void setPlanint本期应还利息0(BigDecimal planint本期应还利息0) {
        this.planint本期应还利息0 = planint本期应还利息0;
    }

    public BigDecimal getOweprin本期未还本金0() {
        return oweprin本期未还本金0;
    }

    public void setOweprin本期未还本金0(BigDecimal oweprin本期未还本金0) {
        this.oweprin本期未还本金0 = oweprin本期未还本金0;
    }

    public BigDecimal getSpecdealint特殊处理利息0() {
        return specdealint特殊处理利息0;
    }

    public void setSpecdealint特殊处理利息0(BigDecimal specdealint特殊处理利息0) {
        this.specdealint特殊处理利息0 = specdealint特殊处理利息0;
    }

    public BigDecimal getRepaypun实还罚息1() {
        return repaypun实还罚息1;
    }

    public void setRepaypun实还罚息1(BigDecimal repaypun实还罚息1) {
        this.repaypun实还罚息1 = repaypun实还罚息1;
    }

    public String getOwepun未还罚息1() {
        return owepun未还罚息1;
    }

    public void setOwepun未还罚息1(String owepun未还罚息1) {
        this.owepun未还罚息1 = owepun未还罚息1;
    }

    public Date getLastcalpundate上次罚息计息日1() {
        return lastcalpundate上次罚息计息日1;
    }

    public void setLastcalpundate上次罚息计息日1(Date lastcalpundate上次罚息计息日1) {
        this.lastcalpundate上次罚息计息日1 = lastcalpundate上次罚息计息日1;
    }

    public String getCurseqstate本期状态() {
        return curseqstate本期状态;
    }

    public void setCurseqstate本期状态(String curseqstate本期状态) {
        this.curseqstate本期状态 = curseqstate本期状态;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getRepaymode0还款方式() {
        return repaymode0还款方式;
    }

    public void setRepaymode0还款方式(String repaymode0还款方式) {
        this.repaymode0还款方式 = repaymode0还款方式;
    }

    public BigDecimal getOweint本期未还利息0() {
        return oweint本期未还利息0;
    }

    public void setOweint本期未还利息0(BigDecimal oweint本期未还利息0) {
        this.oweint本期未还利息0 = oweint本期未还利息0;
    }
}
