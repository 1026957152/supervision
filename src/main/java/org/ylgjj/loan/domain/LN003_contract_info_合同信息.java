package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "LN003")

public class LN003_contract_info_合同信息 {


    @Id
    @Column(name = "loancontrcode")
    private String loancontrcode合同代码;

    @Column(name = "loancontrnum")
    private String loancontrnum_借款合同号;

    @Column(name = "loanaccnum")
    private String loanaccnum_贷款账号;


    @Column(name = "loanconchgnum")
    private Integer loanconchgnum_合同变更序号;

    @Column(name = "seqnum")
    private Integer seqnum_序号;

    @Column(name = "loanuse")
    private String loanuse_贷款用途;


    @Column(name = "guarmode")
    private String guarmode_担保方式;


    @Column(name = "apprnum")
    private String apprnum_审批号;



    @Column(name = "apploanamt")
    private BigDecimal apploanamt_贷款申请金额;



    @Column(name = "apploanterm")
    private Integer apploanterm_贷款申请年限;


    @Column(name = "lastloanbal")
    private BigDecimal lastloanbal_转公贷原贷款余额;

    @Column(name = "loanpercent")
    private BigDecimal loanpercent_贷款成数;


    @Column(name = "loanamt")
    private BigDecimal loanamt_贷款金额;

    @Column(name = "loanterm")
    private Integer loanterm_贷款期限;



    @Column(name = "remainterm")
    private Integer remainterm_剩余期数;

    @Column(name = "LOANDATE")
    private LocalDate loandate放款日期;


    @Column(name = "loancontrstate")
    private String loancontrstate_合同状态;


    @Column(name = "instcode")
    private String instcode_机构代码;


    @Column(name = "clearstate")
    private String clearstate_结清日期;


    @Column(name = "owecnt")
    private Integer owecnt欠还次数;

    @Column(name = "tolowecnt")
    private Integer tolowecnt_累计欠还次数;


    @Column(name = "suretynum")
    private Integer suretynum_担保人数;

    @Column(name = "loaneenum")
    private Integer loaneenum_借款人人数;


    @Column(name = "agentbankcode")
    private String agentbankcode_经办银行;


    @Column(name = "enddate")
    private Date enddate_到期日期;

    public Date getEnddate_到期日期() {
        return enddate_到期日期;
    }

    public void setEnddate_到期日期(Date enddate_到期日期) {
        this.enddate_到期日期 = enddate_到期日期;
    }

    @Column(name = "cleardate")
    private Date cleardate_结清日期;

    @Column(name = "repaymode")
    private String repaymode_还款方式;


    @Column(name = "repayday")
    private String repayday_还款日;




    public BigDecimal getApploanamt_贷款申请金额() {
        return apploanamt_贷款申请金额;
    }

    public void setApploanamt_贷款申请金额(BigDecimal apploanamt_贷款申请金额) {
        this.apploanamt_贷款申请金额 = apploanamt_贷款申请金额;
    }

    public String getInstcode_机构代码() {
        return instcode_机构代码;
    }

    public void setInstcode_机构代码(String instcode_机构代码) {
        this.instcode_机构代码 = instcode_机构代码;
    }

    public String getRepayday_还款日() {
        return repayday_还款日;
    }

    public void setRepayday_还款日(String repayday_还款日) {
        this.repayday_还款日 = repayday_还款日;
    }

    public String getRepaymode_还款方式() {
        return repaymode_还款方式;
    }

    public void setRepaymode_还款方式(String repaymode_还款方式) {
        this.repaymode_还款方式 = repaymode_还款方式;
    }

    public String getAgentbankcode_经办银行() {
        return agentbankcode_经办银行;
    }

    public void setAgentbankcode_经办银行(String agentbankcode_经办银行) {
        this.agentbankcode_经办银行 = agentbankcode_经办银行;
    }

    public String getInstcode() {
        return instcode_机构代码;
    }

    public void setInstcode(String instcode) {
        this.instcode_机构代码 = instcode;
    }

    public Integer getTolowecnt_累计欠还次数() {
        return tolowecnt_累计欠还次数;
    }

    public void setTolowecnt_累计欠还次数(Integer tolowecnt_累计欠还次数) {
        this.tolowecnt_累计欠还次数 = tolowecnt_累计欠还次数;
    }

    public Integer getSuretynum_担保人数() {
        return suretynum_担保人数;
    }

    public void setSuretynum_担保人数(Integer suretynum_担保人数) {
        this.suretynum_担保人数 = suretynum_担保人数;
    }

    public Integer getLoaneenum_借款人人数() {
        return loaneenum_借款人人数;
    }

    public void setLoaneenum_借款人人数(Integer loaneenum_借款人人数) {
        this.loaneenum_借款人人数 = loaneenum_借款人人数;
    }

    public String getClearstate_结清日期() {
        return clearstate_结清日期;
    }

    public void setClearstate_结清日期(String clearstate_结清日期) {
        this.clearstate_结清日期 = clearstate_结清日期;
    }

    private String loanflag;

    public String getLoanflag() {
        return loanflag;
    }

    public void setLoanflag(String loanflag) {
        this.loanflag = loanflag;
    }

    public String getLoancontrstate_合同状态() {
        return loancontrstate_合同状态;
    }

    public void setLoancontrstate_合同状态(String loancontrstate_合同状态) {
        this.loancontrstate_合同状态 = loancontrstate_合同状态;
    }

    public LocalDate getLoandate放款日期() {
        return loandate放款日期;
    }

    public void setLoandate放款日期(LocalDate loandate放款日期) {
        this.loandate放款日期 = loandate放款日期;
    }

    public String getLoancontrcode合同代码() {
        return loancontrcode合同代码;
    }

    public void setLoancontrcode合同代码(String loancontrcode合同代码) {
        this.loancontrcode合同代码 = loancontrcode合同代码;
    }

    public String getLoancontrnum_借款合同号() {
        return loancontrnum_借款合同号;
    }

    public void setLoancontrnum_借款合同号(String loancontrnum_借款合同号) {
        this.loancontrnum_借款合同号 = loancontrnum_借款合同号;
    }

    public String getLoanaccnum_贷款账号() {
        return loanaccnum_贷款账号;
    }

    public void setLoanaccnum_贷款账号(String loanaccnum_贷款账号) {
        this.loanaccnum_贷款账号 = loanaccnum_贷款账号;
    }

    public Integer getLoanconchgnum_合同变更序号() {
        return loanconchgnum_合同变更序号;
    }

    public void setLoanconchgnum_合同变更序号(Integer loanconchgnum_合同变更序号) {
        this.loanconchgnum_合同变更序号 = loanconchgnum_合同变更序号;
    }

    public Integer getSeqnum_序号() {
        return seqnum_序号;
    }

    public void setSeqnum_序号(Integer seqnum_序号) {
        this.seqnum_序号 = seqnum_序号;
    }

    public String getLoanuse_贷款用途() {
        return loanuse_贷款用途;
    }

    public void setLoanuse_贷款用途(String loanuse_贷款用途) {
        this.loanuse_贷款用途 = loanuse_贷款用途;
    }

    public String getGuarmode_担保方式() {
        return guarmode_担保方式;
    }

    public void setGuarmode_担保方式(String guarmode_担保方式) {
        this.guarmode_担保方式 = guarmode_担保方式;
    }

    public String getApprnum_审批号() {
        return apprnum_审批号;
    }

    public void setApprnum_审批号(String apprnum_审批号) {
        this.apprnum_审批号 = apprnum_审批号;
    }

    public BigDecimal getApploanamt() {
        return apploanamt_贷款申请金额;
    }

    public void setApploanamt(BigDecimal apploanamt) {
        this.apploanamt_贷款申请金额 = apploanamt;
    }

    public Integer getApploanterm_贷款申请年限() {
        return apploanterm_贷款申请年限;
    }

    public void setApploanterm_贷款申请年限(Integer apploanterm_贷款申请年限) {
        this.apploanterm_贷款申请年限 = apploanterm_贷款申请年限;
    }

    public BigDecimal getLastloanbal_转公贷原贷款余额() {
        return lastloanbal_转公贷原贷款余额;
    }

    public void setLastloanbal_转公贷原贷款余额(BigDecimal lastloanbal_转公贷原贷款余额) {
        this.lastloanbal_转公贷原贷款余额 = lastloanbal_转公贷原贷款余额;
    }

    public BigDecimal getLoanpercent_贷款成数() {
        return loanpercent_贷款成数;
    }

    public void setLoanpercent_贷款成数(BigDecimal loanpercent_贷款成数) {
        this.loanpercent_贷款成数 = loanpercent_贷款成数;
    }

    public BigDecimal getLoanamt_贷款金额() {
        return loanamt_贷款金额;
    }

    public void setLoanamt_贷款金额(BigDecimal loanamt_贷款金额) {
        this.loanamt_贷款金额 = loanamt_贷款金额;
    }

    public Integer getLoanterm_贷款期限() {
        return loanterm_贷款期限;
    }

    public void setLoanterm_贷款期限(Integer loanterm_贷款期限) {
        this.loanterm_贷款期限 = loanterm_贷款期限;
    }

    public Integer getRemainterm_剩余期数() {
        return remainterm_剩余期数;
    }

    public void setRemainterm_剩余期数(Integer remainterm_剩余期数) {
        this.remainterm_剩余期数 = remainterm_剩余期数;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public Integer getOwecnt欠还次数() {
        return owecnt欠还次数;
    }

    public void setOwecnt欠还次数(Integer owecnt欠还次数) {
        this.owecnt欠还次数 = owecnt欠还次数;
    }

    public Date getCleardate_结清日期() {
        return cleardate_结清日期;
    }

    public void setCleardate_结清日期(Date cleardate_结清日期) {
        this.cleardate_结清日期 = cleardate_结清日期;
    }

    ;







}
