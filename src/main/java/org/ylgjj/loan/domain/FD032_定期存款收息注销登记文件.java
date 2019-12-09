package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@IdClass(FD032_key.class)
@Entity

@Table(name = "FD032")

public class FD032_定期存款收息注销登记文件 {
    //DP095_PK_1_3:索引_accinstcode,accflag,calintdate








    @Id
    @Column(name = "centerid")
    private String centerid_CENTERID_不可为空_城市中心代码;//



    @Id
    @Column(name = "depocode")
    private String depocode_DEPOCODE_不可为空_存单编码;//
    @Id
    @Column(name = "transdate")
    private java.sql.Date transdate_TRANSDATE_不可为空_交易日期;//
    @Id
    @Column(name = "hostsernum")
    private long hostsernum_HOSTSERNUM_不可为空_主机流水号;//

    @Column(name = "opnaccbank")
    private String opnaccbank_OPNACCBANK_不可为空_开户银行;//

    @Column(name = "deponum")
    private String deponum_DEPONUM_不可为空_存单号;//

    @Column(name = "trsoutbank")
    private String trsoutbank_TRSOUTBANK_不可为空_转出银行;//

    @Column(name = "incintdate")
    private java.sql.Date incintdate_INCINTDATE_不可为空_收息日期;//

    @Column(name = "incintbegdate")
    private java.sql.Date incintbegdate_INCINTBEGDATE_不可为空_收息起日;//

    @Column(name = "incintenddate")
    private java.sql.Date incintenddate_INCINTENDDATE_不可为空_收息止日;//

    @Column(name = "offtype")
    private String offtype_OFFTYPE_可为空_注销类型;//	1-到期,2-提前支取,3-冲账注销,4-本金转存,5-本息转存

    @Column(name = "incintmode")
    private String incintmode_INCINTMODE_可为空_收息方式;//	1-到期收息,2-按年收息

    @Column(name = "depoamt")
    private double depoamt_DEPOAMT_不可为空_存单金额;//

    @Column(name = "currincintamt")
    private double currincintamt_CURRINCINTAMT_可为空_本次收息金额;//

    @Column(name = "currintinc")
    private double currintinc_CURRINTINC_可为空_本次利息收入;//

    @Column(name = "prininaccbank")
    private String prininaccbank_PRININACCBANK_可为空_本金入账银行;//

    @Column(name = "prininaccbankacc")
    private String prininaccbankacc_PRININACCBANKACC_可为空_本金入账银行账户;//

    @Column(name = "intinaccbank")
    private String intinaccbank_INTINACCBANK_可为空_利息入账银行;//

    @Column(name = "intinaccbankacc")
    private String intinaccbankacc_INTINACCBANKACC_可为空_利息入账银行账号;//

    @Column(name = "linkman")
    private String linkman_LINKMAN_可为空_联系人;//

    @Column(name = "linkphone")
    private String linkphone_LINKPHONE_可为空_联系电话;//

    @Column(name = "agentinstcode")
    private String agentinstcode_AGENTINSTCODE_可为空_经办机构;//

    @Column(name = "agentop")
    private String agentop_AGENTOP_可为空_经办柜员;//

    @Column(name = "freeuse1")
    private String freeuse1_FREEUSE1_可为空_备用字符;//

    @Column(name = "freeuse2")
    private double freeuse2_FREEUSE2_可为空_备用金额;//

    @Column(name = "freeuse3")
    private java.sql.Date freeuse3_FREEUSE3_可为空_备用日期;//

    @Column(name = "freeuse4")
    private long freeuse4_FREEUSE4_可为空_备用数值;//

    public String getCenterid_CENTERID_不可为空_城市中心代码() {
        return centerid_CENTERID_不可为空_城市中心代码;
    }

    public void setCenterid_CENTERID_不可为空_城市中心代码(String centerid_CENTERID_不可为空_城市中心代码) {
        this.centerid_CENTERID_不可为空_城市中心代码 = centerid_CENTERID_不可为空_城市中心代码;
    }

    public String getDepocode_DEPOCODE_不可为空_存单编码() {
        return depocode_DEPOCODE_不可为空_存单编码;
    }

    public void setDepocode_DEPOCODE_不可为空_存单编码(String depocode_DEPOCODE_不可为空_存单编码) {
        this.depocode_DEPOCODE_不可为空_存单编码 = depocode_DEPOCODE_不可为空_存单编码;
    }

    public Date getTransdate_TRANSDATE_不可为空_交易日期() {
        return transdate_TRANSDATE_不可为空_交易日期;
    }

    public void setTransdate_TRANSDATE_不可为空_交易日期(Date transdate_TRANSDATE_不可为空_交易日期) {
        this.transdate_TRANSDATE_不可为空_交易日期 = transdate_TRANSDATE_不可为空_交易日期;
    }

    public long getHostsernum_HOSTSERNUM_不可为空_主机流水号() {
        return hostsernum_HOSTSERNUM_不可为空_主机流水号;
    }

    public void setHostsernum_HOSTSERNUM_不可为空_主机流水号(long hostsernum_HOSTSERNUM_不可为空_主机流水号) {
        this.hostsernum_HOSTSERNUM_不可为空_主机流水号 = hostsernum_HOSTSERNUM_不可为空_主机流水号;
    }

    public String getOpnaccbank_OPNACCBANK_不可为空_开户银行() {
        return opnaccbank_OPNACCBANK_不可为空_开户银行;
    }

    public void setOpnaccbank_OPNACCBANK_不可为空_开户银行(String opnaccbank_OPNACCBANK_不可为空_开户银行) {
        this.opnaccbank_OPNACCBANK_不可为空_开户银行 = opnaccbank_OPNACCBANK_不可为空_开户银行;
    }

    public String getDeponum_DEPONUM_不可为空_存单号() {
        return deponum_DEPONUM_不可为空_存单号;
    }

    public void setDeponum_DEPONUM_不可为空_存单号(String deponum_DEPONUM_不可为空_存单号) {
        this.deponum_DEPONUM_不可为空_存单号 = deponum_DEPONUM_不可为空_存单号;
    }

    public String getTrsoutbank_TRSOUTBANK_不可为空_转出银行() {
        return trsoutbank_TRSOUTBANK_不可为空_转出银行;
    }

    public void setTrsoutbank_TRSOUTBANK_不可为空_转出银行(String trsoutbank_TRSOUTBANK_不可为空_转出银行) {
        this.trsoutbank_TRSOUTBANK_不可为空_转出银行 = trsoutbank_TRSOUTBANK_不可为空_转出银行;
    }

    public Date getIncintdate_INCINTDATE_不可为空_收息日期() {
        return incintdate_INCINTDATE_不可为空_收息日期;
    }

    public void setIncintdate_INCINTDATE_不可为空_收息日期(Date incintdate_INCINTDATE_不可为空_收息日期) {
        this.incintdate_INCINTDATE_不可为空_收息日期 = incintdate_INCINTDATE_不可为空_收息日期;
    }

    public Date getIncintbegdate_INCINTBEGDATE_不可为空_收息起日() {
        return incintbegdate_INCINTBEGDATE_不可为空_收息起日;
    }

    public void setIncintbegdate_INCINTBEGDATE_不可为空_收息起日(Date incintbegdate_INCINTBEGDATE_不可为空_收息起日) {
        this.incintbegdate_INCINTBEGDATE_不可为空_收息起日 = incintbegdate_INCINTBEGDATE_不可为空_收息起日;
    }

    public Date getIncintenddate_INCINTENDDATE_不可为空_收息止日() {
        return incintenddate_INCINTENDDATE_不可为空_收息止日;
    }

    public void setIncintenddate_INCINTENDDATE_不可为空_收息止日(Date incintenddate_INCINTENDDATE_不可为空_收息止日) {
        this.incintenddate_INCINTENDDATE_不可为空_收息止日 = incintenddate_INCINTENDDATE_不可为空_收息止日;
    }

    public String getOfftype_OFFTYPE_可为空_注销类型() {
        return offtype_OFFTYPE_可为空_注销类型;
    }

    public void setOfftype_OFFTYPE_可为空_注销类型(String offtype_OFFTYPE_可为空_注销类型) {
        this.offtype_OFFTYPE_可为空_注销类型 = offtype_OFFTYPE_可为空_注销类型;
    }

    public String getIncintmode_INCINTMODE_可为空_收息方式() {
        return incintmode_INCINTMODE_可为空_收息方式;
    }

    public void setIncintmode_INCINTMODE_可为空_收息方式(String incintmode_INCINTMODE_可为空_收息方式) {
        this.incintmode_INCINTMODE_可为空_收息方式 = incintmode_INCINTMODE_可为空_收息方式;
    }

    public double getDepoamt_DEPOAMT_不可为空_存单金额() {
        return depoamt_DEPOAMT_不可为空_存单金额;
    }

    public void setDepoamt_DEPOAMT_不可为空_存单金额(double depoamt_DEPOAMT_不可为空_存单金额) {
        this.depoamt_DEPOAMT_不可为空_存单金额 = depoamt_DEPOAMT_不可为空_存单金额;
    }

    public double getCurrincintamt_CURRINCINTAMT_可为空_本次收息金额() {
        return currincintamt_CURRINCINTAMT_可为空_本次收息金额;
    }

    public void setCurrincintamt_CURRINCINTAMT_可为空_本次收息金额(double currincintamt_CURRINCINTAMT_可为空_本次收息金额) {
        this.currincintamt_CURRINCINTAMT_可为空_本次收息金额 = currincintamt_CURRINCINTAMT_可为空_本次收息金额;
    }

    public double getCurrintinc_CURRINTINC_可为空_本次利息收入() {
        return currintinc_CURRINTINC_可为空_本次利息收入;
    }

    public void setCurrintinc_CURRINTINC_可为空_本次利息收入(double currintinc_CURRINTINC_可为空_本次利息收入) {
        this.currintinc_CURRINTINC_可为空_本次利息收入 = currintinc_CURRINTINC_可为空_本次利息收入;
    }

    public String getPrininaccbank_PRININACCBANK_可为空_本金入账银行() {
        return prininaccbank_PRININACCBANK_可为空_本金入账银行;
    }

    public void setPrininaccbank_PRININACCBANK_可为空_本金入账银行(String prininaccbank_PRININACCBANK_可为空_本金入账银行) {
        this.prininaccbank_PRININACCBANK_可为空_本金入账银行 = prininaccbank_PRININACCBANK_可为空_本金入账银行;
    }

    public String getPrininaccbankacc_PRININACCBANKACC_可为空_本金入账银行账户() {
        return prininaccbankacc_PRININACCBANKACC_可为空_本金入账银行账户;
    }

    public void setPrininaccbankacc_PRININACCBANKACC_可为空_本金入账银行账户(String prininaccbankacc_PRININACCBANKACC_可为空_本金入账银行账户) {
        this.prininaccbankacc_PRININACCBANKACC_可为空_本金入账银行账户 = prininaccbankacc_PRININACCBANKACC_可为空_本金入账银行账户;
    }

    public String getIntinaccbank_INTINACCBANK_可为空_利息入账银行() {
        return intinaccbank_INTINACCBANK_可为空_利息入账银行;
    }

    public void setIntinaccbank_INTINACCBANK_可为空_利息入账银行(String intinaccbank_INTINACCBANK_可为空_利息入账银行) {
        this.intinaccbank_INTINACCBANK_可为空_利息入账银行 = intinaccbank_INTINACCBANK_可为空_利息入账银行;
    }

    public String getIntinaccbankacc_INTINACCBANKACC_可为空_利息入账银行账号() {
        return intinaccbankacc_INTINACCBANKACC_可为空_利息入账银行账号;
    }

    public void setIntinaccbankacc_INTINACCBANKACC_可为空_利息入账银行账号(String intinaccbankacc_INTINACCBANKACC_可为空_利息入账银行账号) {
        this.intinaccbankacc_INTINACCBANKACC_可为空_利息入账银行账号 = intinaccbankacc_INTINACCBANKACC_可为空_利息入账银行账号;
    }

    public String getLinkman_LINKMAN_可为空_联系人() {
        return linkman_LINKMAN_可为空_联系人;
    }

    public void setLinkman_LINKMAN_可为空_联系人(String linkman_LINKMAN_可为空_联系人) {
        this.linkman_LINKMAN_可为空_联系人 = linkman_LINKMAN_可为空_联系人;
    }

    public String getLinkphone_LINKPHONE_可为空_联系电话() {
        return linkphone_LINKPHONE_可为空_联系电话;
    }

    public void setLinkphone_LINKPHONE_可为空_联系电话(String linkphone_LINKPHONE_可为空_联系电话) {
        this.linkphone_LINKPHONE_可为空_联系电话 = linkphone_LINKPHONE_可为空_联系电话;
    }

    public String getAgentinstcode_AGENTINSTCODE_可为空_经办机构() {
        return agentinstcode_AGENTINSTCODE_可为空_经办机构;
    }

    public void setAgentinstcode_AGENTINSTCODE_可为空_经办机构(String agentinstcode_AGENTINSTCODE_可为空_经办机构) {
        this.agentinstcode_AGENTINSTCODE_可为空_经办机构 = agentinstcode_AGENTINSTCODE_可为空_经办机构;
    }

    public String getAgentop_AGENTOP_可为空_经办柜员() {
        return agentop_AGENTOP_可为空_经办柜员;
    }

    public void setAgentop_AGENTOP_可为空_经办柜员(String agentop_AGENTOP_可为空_经办柜员) {
        this.agentop_AGENTOP_可为空_经办柜员 = agentop_AGENTOP_可为空_经办柜员;
    }

    public String getFreeuse1_FREEUSE1_可为空_备用字符() {
        return freeuse1_FREEUSE1_可为空_备用字符;
    }

    public void setFreeuse1_FREEUSE1_可为空_备用字符(String freeuse1_FREEUSE1_可为空_备用字符) {
        this.freeuse1_FREEUSE1_可为空_备用字符 = freeuse1_FREEUSE1_可为空_备用字符;
    }

    public double getFreeuse2_FREEUSE2_可为空_备用金额() {
        return freeuse2_FREEUSE2_可为空_备用金额;
    }

    public void setFreeuse2_FREEUSE2_可为空_备用金额(double freeuse2_FREEUSE2_可为空_备用金额) {
        this.freeuse2_FREEUSE2_可为空_备用金额 = freeuse2_FREEUSE2_可为空_备用金额;
    }

    public Date getFreeuse3_FREEUSE3_可为空_备用日期() {
        return freeuse3_FREEUSE3_可为空_备用日期;
    }

    public void setFreeuse3_FREEUSE3_可为空_备用日期(Date freeuse3_FREEUSE3_可为空_备用日期) {
        this.freeuse3_FREEUSE3_可为空_备用日期 = freeuse3_FREEUSE3_可为空_备用日期;
    }

    public long getFreeuse4_FREEUSE4_可为空_备用数值() {
        return freeuse4_FREEUSE4_可为空_备用数值;
    }

    public void setFreeuse4_FREEUSE4_可为空_备用数值(long freeuse4_FREEUSE4_可为空_备用数值) {
        this.freeuse4_FREEUSE4_可为空_备用数值 = freeuse4_FREEUSE4_可为空_备用数值;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
