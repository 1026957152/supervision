package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */


@Entity

@Table(name = "DP095")

public class DP008_单位明细账 {
    //DP095_PK_1_3:索引_accinstcode,accflag,calintdate








    @Id
    @Column(name = "seqno")
    private long seqno_0_不可为空_序号;


    @Column(name = "transdate")
    private LocalDate transdate不可为空交易日期;

    @Column(name = "unitaccnum")
    private String unitaccnum_0_不可为空_单位账号;


    @Column(name = "accflag")
    private String dcflag_不可为空_借贷标志; //1-借,2-贷


    @Column(name = "subcode")
    private String subcode_0_不可为空_科目控制字;

    @Column(name = "unitcustid")
    private String unitcustid_0_不可为空_单位客户号;



    @Column(name = "entrytranscode")
    private String entrytranscode_0_可为空_分录交易码;
    @Column(name = "begym")
    private String begym_0_可为空_开始年月;
    @Column(name = "endym")
    private String endym_0_可为空_截止年月;
    @Column(name = "peoplenum")
    private long peoplenum_0_不可为空_人数;











    @Column(name = "dcflag")
    private String dcflag;
    @Column(name = "amt")
    private double amt_0_不可为空_发生额;
    @Column(name = "lbal")
    private double lbal_0_不可为空_上笔余额;
    @Column(name = "bal")
    private double bal_0_不可为空_余额;
    @Column(name = "summarycode")
    private String summarycode不可为空摘要代码;
    @Column(name = "remark")
    private String remark__可为空_备注;
    @Column(name = "transtype")
    private String transtype_不可为空_交易类型_;//0-正常,1-红字,2-蓝字,6-撤销,7-当日冲正,8-冲账,9-抹账_0:;
    @Column(name = "vounum")
    private String vounum_0_可为空_业务凭证号;
    @Column(name = "timestamp")
    private String timestamp_0_不可为空_时间戳;
    @Column(name = "hostsernum")
    private long hostsernum_0_不可为空_主机流水号;












    @Column(name = "corrdate")
    private java.sql.Date corrdate_0_不可为空_冲正日期;
    @Column(name = "corrsernum")
    private long corrsernum_0_不可为空_冲正流水号;
    @Column(name = "allexchgflag")
    private String allexchgflag_不可为空_通兑标志; //_0-通兑,1-非通兑_0:
    @Column(name = "transchannel")
    private String transchannel__不可为空_交易渠道;
    @Column(name = "agentinstcode")
    private String agentinstcode_0_不可为空_经办机构;
    @Column(name = "accinstcode")
    private String accinstcode_0_不可为空_账户机构;
    @Column(name = "agentbankcode")
    private String agentbankcode_0_不可为空_经办银行;
    @Column(name = "accbankcode")
    private String accbankcode_0_不可为空_账户银行;
    @Column(name = "agentop")
    private String agentop_0_不可为空_经办柜员;
    @Column(name = "centerid")
    private String centerid_0_不可为空_城市中心代码;
    @Column(name = "freeuse1")
    private String freeuse1__可为空_备用字符;
    @Column(name = "freeuse2")
    private double freeuse2__可为空_备用金额;
    @Column(name = "freeuse3")
    private java.sql.Date freeuse3__可为空_备用日期;
    @Column(name = "freeuse4")
    private long freeuse4__可为空_备用数值;

    public long getSeqno_0_不可为空_序号() {
        return seqno_0_不可为空_序号;
    }

    public void setSeqno_0_不可为空_序号(long seqno_0_不可为空_序号) {
        this.seqno_0_不可为空_序号 = seqno_0_不可为空_序号;
    }

    public LocalDate getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(LocalDate transdate不可为空交易日期) {
        this.transdate不可为空交易日期 = transdate不可为空交易日期;
    }

    public String getUnitaccnum_0_不可为空_单位账号() {
        return unitaccnum_0_不可为空_单位账号;
    }

    public void setUnitaccnum_0_不可为空_单位账号(String unitaccnum_0_不可为空_单位账号) {
        this.unitaccnum_0_不可为空_单位账号 = unitaccnum_0_不可为空_单位账号;
    }

    public String getDcflag_不可为空_借贷标志() {
        return dcflag_不可为空_借贷标志;
    }

    public void setDcflag_不可为空_借贷标志(String dcflag_不可为空_借贷标志) {
        this.dcflag_不可为空_借贷标志 = dcflag_不可为空_借贷标志;
    }

    public String getSubcode_0_不可为空_科目控制字() {
        return subcode_0_不可为空_科目控制字;
    }

    public void setSubcode_0_不可为空_科目控制字(String subcode_0_不可为空_科目控制字) {
        this.subcode_0_不可为空_科目控制字 = subcode_0_不可为空_科目控制字;
    }

    public String getUnitcustid_0_不可为空_单位客户号() {
        return unitcustid_0_不可为空_单位客户号;
    }

    public void setUnitcustid_0_不可为空_单位客户号(String unitcustid_0_不可为空_单位客户号) {
        this.unitcustid_0_不可为空_单位客户号 = unitcustid_0_不可为空_单位客户号;
    }

    public String getEntrytranscode_0_可为空_分录交易码() {
        return entrytranscode_0_可为空_分录交易码;
    }

    public void setEntrytranscode_0_可为空_分录交易码(String entrytranscode_0_可为空_分录交易码) {
        this.entrytranscode_0_可为空_分录交易码 = entrytranscode_0_可为空_分录交易码;
    }

    public String getBegym_0_可为空_开始年月() {
        return begym_0_可为空_开始年月;
    }

    public void setBegym_0_可为空_开始年月(String begym_0_可为空_开始年月) {
        this.begym_0_可为空_开始年月 = begym_0_可为空_开始年月;
    }

    public String getEndym_0_可为空_截止年月() {
        return endym_0_可为空_截止年月;
    }

    public void setEndym_0_可为空_截止年月(String endym_0_可为空_截止年月) {
        this.endym_0_可为空_截止年月 = endym_0_可为空_截止年月;
    }

    public long getPeoplenum_0_不可为空_人数() {
        return peoplenum_0_不可为空_人数;
    }

    public void setPeoplenum_0_不可为空_人数(long peoplenum_0_不可为空_人数) {
        this.peoplenum_0_不可为空_人数 = peoplenum_0_不可为空_人数;
    }

    public String getDcflag() {
        return dcflag;
    }

    public void setDcflag(String dcflag) {
        this.dcflag = dcflag;
    }

    public double getAmt_0_不可为空_发生额() {
        return amt_0_不可为空_发生额;
    }

    public void setAmt_0_不可为空_发生额(double amt_0_不可为空_发生额) {
        this.amt_0_不可为空_发生额 = amt_0_不可为空_发生额;
    }

    public double getLbal_0_不可为空_上笔余额() {
        return lbal_0_不可为空_上笔余额;
    }

    public void setLbal_0_不可为空_上笔余额(double lbal_0_不可为空_上笔余额) {
        this.lbal_0_不可为空_上笔余额 = lbal_0_不可为空_上笔余额;
    }

    public double getBal_0_不可为空_余额() {
        return bal_0_不可为空_余额;
    }

    public void setBal_0_不可为空_余额(double bal_0_不可为空_余额) {
        this.bal_0_不可为空_余额 = bal_0_不可为空_余额;
    }

    public String getSummarycode不可为空摘要代码() {
        return summarycode不可为空摘要代码;
    }

    public void setSummarycode不可为空摘要代码(String summarycode不可为空摘要代码) {
        this.summarycode不可为空摘要代码 = summarycode不可为空摘要代码;
    }

    public String getRemark__可为空_备注() {
        return remark__可为空_备注;
    }

    public void setRemark__可为空_备注(String remark__可为空_备注) {
        this.remark__可为空_备注 = remark__可为空_备注;
    }

    public String getTranstype_不可为空_交易类型_() {
        return transtype_不可为空_交易类型_;
    }

    public void setTranstype_不可为空_交易类型_(String transtype_不可为空_交易类型_) {
        this.transtype_不可为空_交易类型_ = transtype_不可为空_交易类型_;
    }

    public String getVounum_0_可为空_业务凭证号() {
        return vounum_0_可为空_业务凭证号;
    }

    public void setVounum_0_可为空_业务凭证号(String vounum_0_可为空_业务凭证号) {
        this.vounum_0_可为空_业务凭证号 = vounum_0_可为空_业务凭证号;
    }

    public String getTimestamp_0_不可为空_时间戳() {
        return timestamp_0_不可为空_时间戳;
    }

    public void setTimestamp_0_不可为空_时间戳(String timestamp_0_不可为空_时间戳) {
        this.timestamp_0_不可为空_时间戳 = timestamp_0_不可为空_时间戳;
    }

    public long getHostsernum_0_不可为空_主机流水号() {
        return hostsernum_0_不可为空_主机流水号;
    }

    public void setHostsernum_0_不可为空_主机流水号(long hostsernum_0_不可为空_主机流水号) {
        this.hostsernum_0_不可为空_主机流水号 = hostsernum_0_不可为空_主机流水号;
    }

    public Date getCorrdate_0_不可为空_冲正日期() {
        return corrdate_0_不可为空_冲正日期;
    }

    public void setCorrdate_0_不可为空_冲正日期(Date corrdate_0_不可为空_冲正日期) {
        this.corrdate_0_不可为空_冲正日期 = corrdate_0_不可为空_冲正日期;
    }

    public long getCorrsernum_0_不可为空_冲正流水号() {
        return corrsernum_0_不可为空_冲正流水号;
    }

    public void setCorrsernum_0_不可为空_冲正流水号(long corrsernum_0_不可为空_冲正流水号) {
        this.corrsernum_0_不可为空_冲正流水号 = corrsernum_0_不可为空_冲正流水号;
    }

    public String getAllexchgflag_不可为空_通兑标志() {
        return allexchgflag_不可为空_通兑标志;
    }

    public void setAllexchgflag_不可为空_通兑标志(String allexchgflag_不可为空_通兑标志) {
        this.allexchgflag_不可为空_通兑标志 = allexchgflag_不可为空_通兑标志;
    }

    public String getTranschannel__不可为空_交易渠道() {
        return transchannel__不可为空_交易渠道;
    }

    public void setTranschannel__不可为空_交易渠道(String transchannel__不可为空_交易渠道) {
        this.transchannel__不可为空_交易渠道 = transchannel__不可为空_交易渠道;
    }

    public String getAgentinstcode_0_不可为空_经办机构() {
        return agentinstcode_0_不可为空_经办机构;
    }

    public void setAgentinstcode_0_不可为空_经办机构(String agentinstcode_0_不可为空_经办机构) {
        this.agentinstcode_0_不可为空_经办机构 = agentinstcode_0_不可为空_经办机构;
    }

    public String getAccinstcode_0_不可为空_账户机构() {
        return accinstcode_0_不可为空_账户机构;
    }

    public void setAccinstcode_0_不可为空_账户机构(String accinstcode_0_不可为空_账户机构) {
        this.accinstcode_0_不可为空_账户机构 = accinstcode_0_不可为空_账户机构;
    }

    public String getAgentbankcode_0_不可为空_经办银行() {
        return agentbankcode_0_不可为空_经办银行;
    }

    public void setAgentbankcode_0_不可为空_经办银行(String agentbankcode_0_不可为空_经办银行) {
        this.agentbankcode_0_不可为空_经办银行 = agentbankcode_0_不可为空_经办银行;
    }

    public String getAccbankcode_0_不可为空_账户银行() {
        return accbankcode_0_不可为空_账户银行;
    }

    public void setAccbankcode_0_不可为空_账户银行(String accbankcode_0_不可为空_账户银行) {
        this.accbankcode_0_不可为空_账户银行 = accbankcode_0_不可为空_账户银行;
    }

    public String getAgentop_0_不可为空_经办柜员() {
        return agentop_0_不可为空_经办柜员;
    }

    public void setAgentop_0_不可为空_经办柜员(String agentop_0_不可为空_经办柜员) {
        this.agentop_0_不可为空_经办柜员 = agentop_0_不可为空_经办柜员;
    }

    public String getCenterid_0_不可为空_城市中心代码() {
        return centerid_0_不可为空_城市中心代码;
    }

    public void setCenterid_0_不可为空_城市中心代码(String centerid_0_不可为空_城市中心代码) {
        this.centerid_0_不可为空_城市中心代码 = centerid_0_不可为空_城市中心代码;
    }

    public String getFreeuse1__可为空_备用字符() {
        return freeuse1__可为空_备用字符;
    }

    public void setFreeuse1__可为空_备用字符(String freeuse1__可为空_备用字符) {
        this.freeuse1__可为空_备用字符 = freeuse1__可为空_备用字符;
    }

    public double getFreeuse2__可为空_备用金额() {
        return freeuse2__可为空_备用金额;
    }

    public void setFreeuse2__可为空_备用金额(double freeuse2__可为空_备用金额) {
        this.freeuse2__可为空_备用金额 = freeuse2__可为空_备用金额;
    }

    public Date getFreeuse3__可为空_备用日期() {
        return freeuse3__可为空_备用日期;
    }

    public void setFreeuse3__可为空_备用日期(Date freeuse3__可为空_备用日期) {
        this.freeuse3__可为空_备用日期 = freeuse3__可为空_备用日期;
    }

    public long getFreeuse4__可为空_备用数值() {
        return freeuse4__可为空_备用数值;
    }

    public void setFreeuse4__可为空_备用数值(long freeuse4__可为空_备用数值) {
        this.freeuse4__可为空_备用数值 = freeuse4__可为空_备用数值;
    }





    /*



 */



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
