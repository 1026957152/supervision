package org.ylgjj.loan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(LN101_key.class)
@Entity

@Table(name = "LN101")

public class LN101_贷款明细账 {





   // loancontrcode,SEQNO



    @Id
    @Column(name = "seqno")
    private String seqno不可为空_序号;
    @Id
    @Column(name = "loancontrcode")
    private String loancontrcode不可为空_合同代码;

    @Column(name = "termnum")
    private Integer termnum不可为空_期号; //第N期		0:

    @Column(name = "loanaccnum")
    private String loanaccnum不可为空_贷款账号;




    @Column(name = "transdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate transdate不可为空交易日期;

    @Column(name = "subcode")
    private String subcode不可为空_科目控制字;
    @Column(name = "entrytranscode")
    private String entrytranscode不可为空_分录代码;
    @Column(name = "summarycode")
    private String summarycode不可为空摘要码;
/*    summarycode	"(摘要码待定)应该包括:贷款发放
    正常归还
            逾期归还
    提前部分
            提前全部
    结转逾期"		0:不可为空	摘要码*/




    @Column(name = "dcflag")
    private String dcflag不可为空_借贷标志;  //    dcflag		"1-借方,2-贷方"	0:


    @Column(name = "transamt") //发生额
    private BigDecimal transamt不可为空_交易金额;
    @Column(name = "loanbal")
    private BigDecimal loanbal不可为空_账户余额;
    @Column(name = "fundsource")
    private String fundsource不可为空_资金来源;
/*    fundsource		"1-住房公积金,
            2-现金,
            3-保证金,
            4-抵债资产,
            5-风险准备金"	0:*/







    @Column(name = "loanfundtype")
    private String loanfundtype不可为空_贷款资金类型;
/*    loanfundtype		"01-正常本金,
            02-正常利息,
            11-逾期本金,
            12-应收利息,
            13-罚息"	0:不可为空_贷款资金类型*/



    @Column(name = "assetsavemode")
    private String assetsavemode不可为空_资产保全方式;
/*    assetsavemode		"1-强扣,
            2-理赔,
            3-清偿(抵债资产),
                    4-核销"	0:*/


    @Column(name = "settlemode")
    private String settlemode不可为空_结算方式;
/*    settlemode		"1-中心内部,
            2-现金,
            3-支票,
            4-委托扣款,
            5-电子转账"	0:不可为空_结算方式*/


    @Column(name = "transstate")
    private String transstate不可为空_交易状态;
/*    transstate		"0-正常,
            1-红字,
            2-蓝字,
            6-撤销,
            7-当日冲正,
            8-冲账,
            9-抹账"	0:不可为空_交易状态*/
    @Column(name = "repayaccnum")
    private String repayaccnum可为空_还款账号;




    @Column(name = "hostsernum")
    private Integer hostsernum不可为空_主机流水号;
    @Column(name = "machinetime")
    private String machinetime不可为空_机器时间;
    @Column(name = "corrdate")
    private Date corrdate可为空_抹账冲正日期;
    @Column(name = "corrhostsernum")
    private Integer corrhostsernum可为空_冲正流水号;

    @Column(name = "transchannel")
    private String transchannel不可为空_交易渠道;

    @Column(name = "allexchgflag")
    private String allexchgflag不可为空_通兑标志;
/*    		"0-通兑,
            1-非通兑"	0:*/


    @Column(name = "settleop")
    private String settleop不可为空_结算柜员;

    @Column(name = "agentinstcode")
    private String agentinstcode不可为空_经办机构;


    @Column(name = "agentbankcode")
    private String agentbankcode不可为空_经办银行;

    @Column(name = "accinstcode")
    private String accinstcode不可为空_账户机构;

    @Column(name = "accbankcode")
    private String accbankcode不可为空_账户银行;

    @Column(name = "freeuse1")
    private String freeuse1可为空_备用字符;
    @Column(name = "freeuse2")
    private String freeuse2可为空_备用金额;

    @Column(name = "freeuse3")
    private String freeuse3可为空_备用日期;

    @Column(name = "freeuse4")
    private String freeuse4可为空_备用数值;

    public String getSeqno不可为空_序号() {
        return seqno不可为空_序号;
    }

    public void setSeqno不可为空_序号(String seqno不可为空_序号) {
        this.seqno不可为空_序号 = seqno不可为空_序号;
    }

    public String getLoancontrcode不可为空_合同代码() {
        return loancontrcode不可为空_合同代码;
    }

    public void setLoancontrcode不可为空_合同代码(String loancontrcode不可为空_合同代码) {
        this.loancontrcode不可为空_合同代码 = loancontrcode不可为空_合同代码;
    }

    public Integer getTermnum不可为空_期号() {
        return termnum不可为空_期号;
    }

    public void setTermnum不可为空_期号(Integer termnum不可为空_期号) {
        this.termnum不可为空_期号 = termnum不可为空_期号;
    }

    public String getLoanaccnum不可为空_贷款账号() {
        return loanaccnum不可为空_贷款账号;
    }

    public void setLoanaccnum不可为空_贷款账号(String loanaccnum不可为空_贷款账号) {
        this.loanaccnum不可为空_贷款账号 = loanaccnum不可为空_贷款账号;
    }

    public LocalDate getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(LocalDate transdate不可为空交易日期) {
        this.transdate不可为空交易日期 = transdate不可为空交易日期;
    }

    public String getSubcode不可为空_科目控制字() {
        return subcode不可为空_科目控制字;
    }

    public void setSubcode不可为空_科目控制字(String subcode不可为空_科目控制字) {
        this.subcode不可为空_科目控制字 = subcode不可为空_科目控制字;
    }

    public String getEntrytranscode不可为空_分录代码() {
        return entrytranscode不可为空_分录代码;
    }

    public void setEntrytranscode不可为空_分录代码(String entrytranscode不可为空_分录代码) {
        this.entrytranscode不可为空_分录代码 = entrytranscode不可为空_分录代码;
    }

    public String getSummarycode不可为空摘要码() {
        return summarycode不可为空摘要码;
    }

    public void setSummarycode不可为空摘要码(String summarycode不可为空_摘要码) {
        this.summarycode不可为空摘要码 = summarycode不可为空_摘要码;
    }

    public String getDcflag不可为空_借贷标志() {
        return dcflag不可为空_借贷标志;
    }

    public void setDcflag不可为空_借贷标志(String dcflag不可为空_借贷标志) {
        this.dcflag不可为空_借贷标志 = dcflag不可为空_借贷标志;
    }

    public BigDecimal getTransamt不可为空_交易金额() {
        return transamt不可为空_交易金额;
    }

    public void setTransamt不可为空_交易金额(BigDecimal transamt不可为空_交易金额) {
        this.transamt不可为空_交易金额 = transamt不可为空_交易金额;
    }

    public BigDecimal getLoanbal不可为空_账户余额() {
        return loanbal不可为空_账户余额;
    }

    public void setLoanbal不可为空_账户余额(BigDecimal loanbal不可为空_账户余额) {
        this.loanbal不可为空_账户余额 = loanbal不可为空_账户余额;
    }

    public String getFundsource不可为空_资金来源() {
        return fundsource不可为空_资金来源;
    }

    public void setFundsource不可为空_资金来源(String fundsource不可为空_资金来源) {
        this.fundsource不可为空_资金来源 = fundsource不可为空_资金来源;
    }

    public String getLoanfundtype不可为空_贷款资金类型() {
        return loanfundtype不可为空_贷款资金类型;
    }

    public void setLoanfundtype不可为空_贷款资金类型(String loanfundtype不可为空_贷款资金类型) {
        this.loanfundtype不可为空_贷款资金类型 = loanfundtype不可为空_贷款资金类型;
    }

    public String getAssetsavemode不可为空_资产保全方式() {
        return assetsavemode不可为空_资产保全方式;
    }

    public void setAssetsavemode不可为空_资产保全方式(String assetsavemode不可为空_资产保全方式) {
        this.assetsavemode不可为空_资产保全方式 = assetsavemode不可为空_资产保全方式;
    }

    public String getSettlemode不可为空_结算方式() {
        return settlemode不可为空_结算方式;
    }

    public void setSettlemode不可为空_结算方式(String settlemode不可为空_结算方式) {
        this.settlemode不可为空_结算方式 = settlemode不可为空_结算方式;
    }

    public String getTransstate不可为空_交易状态() {
        return transstate不可为空_交易状态;
    }

    public void setTransstate不可为空_交易状态(String transstate不可为空_交易状态) {
        this.transstate不可为空_交易状态 = transstate不可为空_交易状态;
    }

    public String getRepayaccnum可为空_还款账号() {
        return repayaccnum可为空_还款账号;
    }

    public void setRepayaccnum可为空_还款账号(String repayaccnum可为空_还款账号) {
        this.repayaccnum可为空_还款账号 = repayaccnum可为空_还款账号;
    }

    public Integer getHostsernum不可为空_主机流水号() {
        return hostsernum不可为空_主机流水号;
    }

    public void setHostsernum不可为空_主机流水号(Integer hostsernum不可为空_主机流水号) {
        this.hostsernum不可为空_主机流水号 = hostsernum不可为空_主机流水号;
    }

    public String getMachinetime不可为空_机器时间() {
        return machinetime不可为空_机器时间;
    }

    public void setMachinetime不可为空_机器时间(String machinetime不可为空_机器时间) {
        this.machinetime不可为空_机器时间 = machinetime不可为空_机器时间;
    }

    public Date getCorrdate可为空_抹账冲正日期() {
        return corrdate可为空_抹账冲正日期;
    }

    public void setCorrdate可为空_抹账冲正日期(Date corrdate可为空_抹账冲正日期) {
        this.corrdate可为空_抹账冲正日期 = corrdate可为空_抹账冲正日期;
    }

    public Integer getCorrhostsernum可为空_冲正流水号() {
        return corrhostsernum可为空_冲正流水号;
    }

    public void setCorrhostsernum可为空_冲正流水号(Integer corrhostsernum可为空_冲正流水号) {
        this.corrhostsernum可为空_冲正流水号 = corrhostsernum可为空_冲正流水号;
    }

    public String getTranschannel不可为空_交易渠道() {
        return transchannel不可为空_交易渠道;
    }

    public void setTranschannel不可为空_交易渠道(String transchannel不可为空_交易渠道) {
        this.transchannel不可为空_交易渠道 = transchannel不可为空_交易渠道;
    }

    public String getAllexchgflag不可为空_通兑标志() {
        return allexchgflag不可为空_通兑标志;
    }

    public void setAllexchgflag不可为空_通兑标志(String allexchgflag不可为空_通兑标志) {
        this.allexchgflag不可为空_通兑标志 = allexchgflag不可为空_通兑标志;
    }

    public String getSettleop不可为空_结算柜员() {
        return settleop不可为空_结算柜员;
    }

    public void setSettleop不可为空_结算柜员(String settleop不可为空_结算柜员) {
        this.settleop不可为空_结算柜员 = settleop不可为空_结算柜员;
    }

    public String getAgentinstcode不可为空_经办机构() {
        return agentinstcode不可为空_经办机构;
    }

    public void setAgentinstcode不可为空_经办机构(String agentinstcode不可为空_经办机构) {
        this.agentinstcode不可为空_经办机构 = agentinstcode不可为空_经办机构;
    }

    public String getAgentbankcode不可为空_经办银行() {
        return agentbankcode不可为空_经办银行;
    }

    public void setAgentbankcode不可为空_经办银行(String agentbankcode不可为空_经办银行) {
        this.agentbankcode不可为空_经办银行 = agentbankcode不可为空_经办银行;
    }

    public String getAccinstcode不可为空_账户机构() {
        return accinstcode不可为空_账户机构;
    }

    public void setAccinstcode不可为空_账户机构(String accinstcode不可为空_账户机构) {
        this.accinstcode不可为空_账户机构 = accinstcode不可为空_账户机构;
    }

    public String getAccbankcode不可为空_账户银行() {
        return accbankcode不可为空_账户银行;
    }

    public void setAccbankcode不可为空_账户银行(String accbankcode不可为空_账户银行) {
        this.accbankcode不可为空_账户银行 = accbankcode不可为空_账户银行;
    }

    public String getFreeuse1可为空_备用字符() {
        return freeuse1可为空_备用字符;
    }

    public void setFreeuse1可为空_备用字符(String freeuse1可为空_备用字符) {
        this.freeuse1可为空_备用字符 = freeuse1可为空_备用字符;
    }

    public String getFreeuse2可为空_备用金额() {
        return freeuse2可为空_备用金额;
    }

    public void setFreeuse2可为空_备用金额(String freeuse2可为空_备用金额) {
        this.freeuse2可为空_备用金额 = freeuse2可为空_备用金额;
    }

    public String getFreeuse3可为空_备用日期() {
        return freeuse3可为空_备用日期;
    }

    public void setFreeuse3可为空_备用日期(String freeuse3可为空_备用日期) {
        this.freeuse3可为空_备用日期 = freeuse3可为空_备用日期;
    }

    public String getFreeuse4可为空_备用数值() {
        return freeuse4可为空_备用数值;
    }

    public void setFreeuse4可为空_备用数值(String freeuse4可为空_备用数值) {
        this.freeuse4可为空_备用数值 = freeuse4可为空_备用数值;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
