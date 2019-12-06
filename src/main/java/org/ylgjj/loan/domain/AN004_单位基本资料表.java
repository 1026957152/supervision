package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(AN004_key.class)
@Entity
@Table(name = "AN004")

public class AN004_单位基本资料表 {



    @Id

    @Column(name = "TRANSDATE")
    private String transdate_不可为空_交易日期;


    @Id

    @Column(name = "hostsernum")
    private String hostsernum_不可为空_业务流水号;
    @Id

    @Column(name = "BATCHSEQ")
    private String BATCHSEQ_不可为空_批量包批次号;



    @Column(name = "settletranscode")
    private String settletranscode交易渠道码_可为空;




    @Column(name = "MACHINETIME")
    private String MACHINETIME交易时间_可为空;
    @Column(name = "BANKCODE")
    private String BANKCODE银行代码_可为空;


    @Column(name = "instcode")
    private String instcode机构代码_可为空;

    @Column(name = "payerbankacc")
    private String payerbankacc付款人账户_可为空;


    @Column(name = "payerbankacc2")
    private String payerbankacc付款人账户2_可为空;

    @Column(name = "payerbankaccnm")
    private String payerbankaccnm付款人户名_可为空;


    @Column(name = "payerbankaccnm2")
    private String 付款人户名2付款人户名_可为空;

    @Column(name = "payeebankacc")
    private String payeebankacc收款人账户_可为空;
    @Column(name = "payeebankacc2")
    private String payeebankacc2收款人账户2_可为空;

    @Column(name = "payeebankaccnm")
    private String payeebankaccnm收款人户名_可为空;

    @Column(name = "payeebankaccnm2")
    private String payeebankaccnm2收款人户名2_可为空;

    @Column(name = "AMT")
    private String AMT交易金额_可为空;
    @Column(name = "AMT1")
    private String AMT1交易金额1_可为空;
    @Column(name = "AMT2")
    private String AMT2交易金额2_可为空;

    @Column(name = "settlehostsernum")
    private String settlehostsernum结算流水号_可为空;
    @Column(name = "bankhostsernum")
    private String bankhostsernum银行流水号_可为空;

    @Column(name = "bankresdcode")
    private String bankresdcode银行返回码_可为空;

    @Column(name = "bankresdinfo")
    private String bankresdinfo银行返回描述_可为空;

    @Column(name = "bankresddate")
    private String bankresddate银行返回日期_可为空;
    @Column(name = "errcode")
    private String errcode错误代码_可为空;
    @Column(name = "reason")
    private String reason描述_可为空;
    @Column(name = "settletransstate")
    private String settletransstate交易状态_可为空;

    @Column(name = "sendtobankflag")
    private String sendtobankflag发送接收标志_可为空;

    @Column(name = "settletransusage")
    private String settletransusage交易用途_可为空;


    @Column(name = "FREEUSE1")
    private String FREEUSE1备注1_可为空;
    @Column(name = "FREEUSE2")
    private String FREEUSE2备注2_可为空;
    @Column(name = "FREEUSE3")
    private String FREEUSE3备注3_可为空;
    @Column(name = "FREEUSE4")
    private String FREEUSE4备注4_可为空;


    public String getTransdate_不可为空_交易日期() {
        return transdate_不可为空_交易日期;
    }

    public void setTransdate_不可为空_交易日期(String transdate_不可为空_交易日期) {
        this.transdate_不可为空_交易日期 = transdate_不可为空_交易日期;
    }

    public String getHostsernum_不可为空_业务流水号() {
        return hostsernum_不可为空_业务流水号;
    }

    public void setHostsernum_不可为空_业务流水号(String hostsernum_不可为空_业务流水号) {
        this.hostsernum_不可为空_业务流水号 = hostsernum_不可为空_业务流水号;
    }

    public String getBATCHSEQ_不可为空_批量包批次号() {
        return BATCHSEQ_不可为空_批量包批次号;
    }

    public void setBATCHSEQ_不可为空_批量包批次号(String BATCHSEQ_不可为空_批量包批次号) {
        this.BATCHSEQ_不可为空_批量包批次号 = BATCHSEQ_不可为空_批量包批次号;
    }

    public String getSettletranscode交易渠道码_可为空() {
        return settletranscode交易渠道码_可为空;
    }

    public void setSettletranscode交易渠道码_可为空(String settletranscode交易渠道码_可为空) {
        this.settletranscode交易渠道码_可为空 = settletranscode交易渠道码_可为空;
    }

    public String getMACHINETIME交易时间_可为空() {
        return MACHINETIME交易时间_可为空;
    }

    public void setMACHINETIME交易时间_可为空(String MACHINETIME交易时间_可为空) {
        this.MACHINETIME交易时间_可为空 = MACHINETIME交易时间_可为空;
    }

    public String getBANKCODE银行代码_可为空() {
        return BANKCODE银行代码_可为空;
    }

    public void setBANKCODE银行代码_可为空(String BANKCODE银行代码_可为空) {
        this.BANKCODE银行代码_可为空 = BANKCODE银行代码_可为空;
    }

    public String getInstcode机构代码_可为空() {
        return instcode机构代码_可为空;
    }

    public void setInstcode机构代码_可为空(String instcode机构代码_可为空) {
        this.instcode机构代码_可为空 = instcode机构代码_可为空;
    }

    public String getPayerbankacc付款人账户_可为空() {
        return payerbankacc付款人账户_可为空;
    }

    public void setPayerbankacc付款人账户_可为空(String payerbankacc付款人账户_可为空) {
        this.payerbankacc付款人账户_可为空 = payerbankacc付款人账户_可为空;
    }

    public String getPayerbankacc付款人账户2_可为空() {
        return payerbankacc付款人账户2_可为空;
    }

    public void setPayerbankacc付款人账户2_可为空(String payerbankacc付款人账户2_可为空) {
        this.payerbankacc付款人账户2_可为空 = payerbankacc付款人账户2_可为空;
    }

    public String getPayerbankaccnm付款人户名_可为空() {
        return payerbankaccnm付款人户名_可为空;
    }

    public void setPayerbankaccnm付款人户名_可为空(String payerbankaccnm付款人户名_可为空) {
        this.payerbankaccnm付款人户名_可为空 = payerbankaccnm付款人户名_可为空;
    }

    public String get付款人户名2付款人户名_可为空() {
        return 付款人户名2付款人户名_可为空;
    }

    public void set付款人户名2付款人户名_可为空(String 付款人户名2付款人户名_可为空) {
        this.付款人户名2付款人户名_可为空 = 付款人户名2付款人户名_可为空;
    }

    public String getPayeebankacc收款人账户_可为空() {
        return payeebankacc收款人账户_可为空;
    }

    public void setPayeebankacc收款人账户_可为空(String payeebankacc收款人账户_可为空) {
        this.payeebankacc收款人账户_可为空 = payeebankacc收款人账户_可为空;
    }

    public String getPayeebankacc2收款人账户2_可为空() {
        return payeebankacc2收款人账户2_可为空;
    }

    public void setPayeebankacc2收款人账户2_可为空(String payeebankacc2收款人账户2_可为空) {
        this.payeebankacc2收款人账户2_可为空 = payeebankacc2收款人账户2_可为空;
    }

    public String getPayeebankaccnm收款人户名_可为空() {
        return payeebankaccnm收款人户名_可为空;
    }

    public void setPayeebankaccnm收款人户名_可为空(String payeebankaccnm收款人户名_可为空) {
        this.payeebankaccnm收款人户名_可为空 = payeebankaccnm收款人户名_可为空;
    }

    public String getPayeebankaccnm2收款人户名2_可为空() {
        return payeebankaccnm2收款人户名2_可为空;
    }

    public void setPayeebankaccnm2收款人户名2_可为空(String payeebankaccnm2收款人户名2_可为空) {
        this.payeebankaccnm2收款人户名2_可为空 = payeebankaccnm2收款人户名2_可为空;
    }

    public String getAMT交易金额_可为空() {
        return AMT交易金额_可为空;
    }

    public void setAMT交易金额_可为空(String AMT交易金额_可为空) {
        this.AMT交易金额_可为空 = AMT交易金额_可为空;
    }

    public String getAMT1交易金额1_可为空() {
        return AMT1交易金额1_可为空;
    }

    public void setAMT1交易金额1_可为空(String AMT1交易金额1_可为空) {
        this.AMT1交易金额1_可为空 = AMT1交易金额1_可为空;
    }

    public String getAMT2交易金额2_可为空() {
        return AMT2交易金额2_可为空;
    }

    public void setAMT2交易金额2_可为空(String AMT2交易金额2_可为空) {
        this.AMT2交易金额2_可为空 = AMT2交易金额2_可为空;
    }

    public String getSettlehostsernum结算流水号_可为空() {
        return settlehostsernum结算流水号_可为空;
    }

    public void setSettlehostsernum结算流水号_可为空(String settlehostsernum结算流水号_可为空) {
        this.settlehostsernum结算流水号_可为空 = settlehostsernum结算流水号_可为空;
    }

    public String getBankhostsernum银行流水号_可为空() {
        return bankhostsernum银行流水号_可为空;
    }

    public void setBankhostsernum银行流水号_可为空(String bankhostsernum银行流水号_可为空) {
        this.bankhostsernum银行流水号_可为空 = bankhostsernum银行流水号_可为空;
    }

    public String getBankresdcode银行返回码_可为空() {
        return bankresdcode银行返回码_可为空;
    }

    public void setBankresdcode银行返回码_可为空(String bankresdcode银行返回码_可为空) {
        this.bankresdcode银行返回码_可为空 = bankresdcode银行返回码_可为空;
    }

    public String getBankresdinfo银行返回描述_可为空() {
        return bankresdinfo银行返回描述_可为空;
    }

    public void setBankresdinfo银行返回描述_可为空(String bankresdinfo银行返回描述_可为空) {
        this.bankresdinfo银行返回描述_可为空 = bankresdinfo银行返回描述_可为空;
    }

    public String getBankresddate银行返回日期_可为空() {
        return bankresddate银行返回日期_可为空;
    }

    public void setBankresddate银行返回日期_可为空(String bankresddate银行返回日期_可为空) {
        this.bankresddate银行返回日期_可为空 = bankresddate银行返回日期_可为空;
    }

    public String getErrcode错误代码_可为空() {
        return errcode错误代码_可为空;
    }

    public void setErrcode错误代码_可为空(String errcode错误代码_可为空) {
        this.errcode错误代码_可为空 = errcode错误代码_可为空;
    }

    public String getReason描述_可为空() {
        return reason描述_可为空;
    }

    public void setReason描述_可为空(String reason描述_可为空) {
        this.reason描述_可为空 = reason描述_可为空;
    }

    public String getSettletransstate交易状态_可为空() {
        return settletransstate交易状态_可为空;
    }

    public void setSettletransstate交易状态_可为空(String settletransstate交易状态_可为空) {
        this.settletransstate交易状态_可为空 = settletransstate交易状态_可为空;
    }

    public String getSendtobankflag发送接收标志_可为空() {
        return sendtobankflag发送接收标志_可为空;
    }

    public void setSendtobankflag发送接收标志_可为空(String sendtobankflag发送接收标志_可为空) {
        this.sendtobankflag发送接收标志_可为空 = sendtobankflag发送接收标志_可为空;
    }

    public String getSettletransusage交易用途_可为空() {
        return settletransusage交易用途_可为空;
    }

    public void setSettletransusage交易用途_可为空(String settletransusage交易用途_可为空) {
        this.settletransusage交易用途_可为空 = settletransusage交易用途_可为空;
    }

    public String getFREEUSE1备注1_可为空() {
        return FREEUSE1备注1_可为空;
    }

    public void setFREEUSE1备注1_可为空(String FREEUSE1备注1_可为空) {
        this.FREEUSE1备注1_可为空 = FREEUSE1备注1_可为空;
    }

    public String getFREEUSE2备注2_可为空() {
        return FREEUSE2备注2_可为空;
    }

    public void setFREEUSE2备注2_可为空(String FREEUSE2备注2_可为空) {
        this.FREEUSE2备注2_可为空 = FREEUSE2备注2_可为空;
    }

    public String getFREEUSE3备注3_可为空() {
        return FREEUSE3备注3_可为空;
    }

    public void setFREEUSE3备注3_可为空(String FREEUSE3备注3_可为空) {
        this.FREEUSE3备注3_可为空 = FREEUSE3备注3_可为空;
    }

    public String getFREEUSE4备注4_可为空() {
        return FREEUSE4备注4_可为空;
    }

    public void setFREEUSE4备注4_可为空(String FREEUSE4备注4_可为空) {
        this.FREEUSE4备注4_可为空 = FREEUSE4备注4_可为空;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
