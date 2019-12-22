package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(FD029_key.class)
@Entity
@Table(name = "FD029")

public class FD029_定期存款分户文件 {








    @Id
    @Column(name = "centerid")
    private String centerid_不可为空_城市中心代码;

    @Id
    @Column(name = "depocode")
    private String depocode_不可为空_存单编码;

    @Column(name = "transdate")
    private LocalDate transdate不可为空交易日期;

    @Column(name = "hostsernum")
    private long hostsernum_不可为空_主机流水号;

    @Column(name = "deponum")
    private String deponum_不可为空_存单号;

    @Column(name = "opnaccinst")
    private String opnaccinst_不可为空_开户机构;

    @Column(name = "opnaccbank")
    private String opnaccbank_不可为空_开户银行;

    @Column(name = "opnaccbanknm")
    private String opnaccbanknm_可为空_开户银行名称;

    @Column(name = "opnaccbankacc")
    private String opnaccbankacc_可为空_开户银行账户;

    @Column(name = "offdate")
    private java.sql.Date offdate_可为空_注销日期;



    @Column(name = "fundkind")
    private String fundkind_不可为空_资金性质;//_01=住房公积金存款，03=增值收益存款_01-住房公积金存款,03-增值收益存款

    @Column(name = "trsoutinst")
    private String trsoutinst_不可为空_转出机构;

    @Column(name = "trsoutbank")
    private String trsoutbank_不可为空_转出银行;

    @Column(name = "depotype")
    private String depotype_不可为空_存单类型;//_1=定期存款，2=通知存款_1-定期存款,2-通知存款

    @Column(name = "termtype")
    private String termtype_不可为空_期限类型;//_Y=年，M=月，D=日_Y-年,M-月,D-日

    @Column(name = "depoterm")
    private long depoterm_不可为空_存单期限;

    @Column(name = "depobegdate")
    private java.sql.Date depobegdate_不可为空_存单开户日;//_开始日期

    @Column(name = "depoenddate")
    private java.sql.Date depoenddate_不可为空_存单到期日;//_结束日期

    @Column(name = "expcalbegdate")
    private java.sql.Date expcalbegdate_不可为空_计息起日;//_到期收息时同开户日；按年收息时日期为最后一次收息日的下一天

    @Column(name = "deporate")
    private double deporate_可为空_存单利率;

    @Column(name = "depoamt")
    private double depoamt_不可为空_存单金额;

    @Column(name = "currbal")
    private double currbal_不可为空_当前余额;



    @Column(name = "lastexpintdate")
    private java.sql.Date lastexpintdate_可为空_上次计息日期;

    @Column(name = "lastincintdate")
    private java.sql.Date lastincintdate_可为空_上次收息日期;

    @Column(name = "expintmode")
    private String expintmode_可为空_计息方式;//_0=不计息，1=按月计息，2=按季计息_0-不计息,1-按月计息,2-按季计息

    @Column(name = "incintmode")
    private String incintmode_可为空_收息方式;//_1=到期收息，2=按年收息_1-到期收息,2-按年收息

    @Column(name = "depostate")
    private String depostate_不可为空_存单状态;//_0=正常，9=注销_0-正常,9-注销

    @Column(name = "fundkindadjflag")
    private String fundkindadjflag_可为空_资金性质调整标志;//_0=未做调整 1=做过调整_0-未做调整,1-做过调整

    @Column(name = "offtype")
    private String offtype_不可为空_注销类型;//_0=正常，1=到期，2=提前支取，3=冲账注销，4=本金转存，5=本息转存_0-正常,1-到期,2-提前支取,3-冲账注销,4-本金转存,5-本息转存

    @Column(name = "incintsum")
    private double incintsum_可为空_收息总额;//_总收息额，年收息的话，累加

    @Column(name = "expcalsum")
    private double expcalsum_可为空_计息总额;//_计提累加，收息时，清零

    @Column(name = "adjdate")
    private java.sql.Date adjdate_可为空_调整日期;//_最后一次调整日期

    @Column(name = "subcode")
    private String subcode_可为空_科目控制字;

    @Column(name = "linkman")
    private String linkman_可为空_联系人;

    @Column(name = "linkphone")
    private String linkphone_可为空_联系电话;


    @Column(name = "remark")
    private String remark_可为空_备注;

    @Column(name = "flag")
    private String flag_可为空_标志;    //__0-线下,1-结算

    @Column(name = "validflag")
    private String validflag_可为空_有效标志;    //__0-否,1-是

    @Column(name = "redepotype")
    private String redepotype_可为空_转存类型;

    @Column(name = "intincfundacc")
    private String intincfundacc_可为空_利息收款账户;

    @Column(name = "depoaccnum")
    private String depoaccnum_可为空_定期账号;

    @Column(name = "bankaccnm")
    private String bankaccnm_可为空_银行账户名称;

    @Column(name = "volnum")
    private String volnum_可为空_册号;

    @Column(name = "volseqnum")
    private String volseqnum_可为空_序号;

    @Column(name = "bankhostsernum")
    private String bankhostsernum_可为空_银行主机流水号;

    @Column(name = "freeuse1")
    private String freeuse1_可为空_备用字符;

    @Column(name = "freeuse2")
    private double freeuse2_可为空_备用金额;

    @Column(name = "freeuse3")
    private java.sql.Date freeuse3_可为空_备用日期;

    @Column(name = "freeuse4")
    private long freeuse4_可为空_备用数值;






    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public String getCenterid_不可为空_城市中心代码() {
        return centerid_不可为空_城市中心代码;
    }

    public void setCenterid_不可为空_城市中心代码(String centerid_不可为空_城市中心代码) {
        this.centerid_不可为空_城市中心代码 = centerid_不可为空_城市中心代码;
    }

    public String getDepocode_不可为空_存单编码() {
        return depocode_不可为空_存单编码;
    }

    public void setDepocode_不可为空_存单编码(String depocode_不可为空_存单编码) {
        this.depocode_不可为空_存单编码 = depocode_不可为空_存单编码;
    }

    public LocalDate getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(LocalDate transdate_不可为空_交易日期) {
        this.transdate不可为空交易日期 = transdate_不可为空_交易日期;
    }

    public long getHostsernum_不可为空_主机流水号() {
        return hostsernum_不可为空_主机流水号;
    }

    public void setHostsernum_不可为空_主机流水号(long hostsernum_不可为空_主机流水号) {
        this.hostsernum_不可为空_主机流水号 = hostsernum_不可为空_主机流水号;
    }

    public String getDeponum_不可为空_存单号() {
        return deponum_不可为空_存单号;
    }

    public void setDeponum_不可为空_存单号(String deponum_不可为空_存单号) {
        this.deponum_不可为空_存单号 = deponum_不可为空_存单号;
    }

    public String getOpnaccinst_不可为空_开户机构() {
        return opnaccinst_不可为空_开户机构;
    }

    public void setOpnaccinst_不可为空_开户机构(String opnaccinst_不可为空_开户机构) {
        this.opnaccinst_不可为空_开户机构 = opnaccinst_不可为空_开户机构;
    }

    public String getOpnaccbank_不可为空_开户银行() {
        return opnaccbank_不可为空_开户银行;
    }

    public void setOpnaccbank_不可为空_开户银行(String opnaccbank_不可为空_开户银行) {
        this.opnaccbank_不可为空_开户银行 = opnaccbank_不可为空_开户银行;
    }

    public String getOpnaccbanknm_可为空_开户银行名称() {
        return opnaccbanknm_可为空_开户银行名称;
    }

    public void setOpnaccbanknm_可为空_开户银行名称(String opnaccbanknm_可为空_开户银行名称) {
        this.opnaccbanknm_可为空_开户银行名称 = opnaccbanknm_可为空_开户银行名称;
    }

    public String getOpnaccbankacc_可为空_开户银行账户() {
        return opnaccbankacc_可为空_开户银行账户;
    }

    public void setOpnaccbankacc_可为空_开户银行账户(String opnaccbankacc_可为空_开户银行账户) {
        this.opnaccbankacc_可为空_开户银行账户 = opnaccbankacc_可为空_开户银行账户;
    }

    public Date getOffdate_可为空_注销日期() {
        return offdate_可为空_注销日期;
    }

    public void setOffdate_可为空_注销日期(Date offdate_可为空_注销日期) {
        this.offdate_可为空_注销日期 = offdate_可为空_注销日期;
    }

    public String getFundkind_不可为空_资金性质() {
        return fundkind_不可为空_资金性质;
    }

    public void setFundkind_不可为空_资金性质(String fundkind_不可为空_资金性质) {
        this.fundkind_不可为空_资金性质 = fundkind_不可为空_资金性质;
    }

    public String getTrsoutinst_不可为空_转出机构() {
        return trsoutinst_不可为空_转出机构;
    }

    public void setTrsoutinst_不可为空_转出机构(String trsoutinst_不可为空_转出机构) {
        this.trsoutinst_不可为空_转出机构 = trsoutinst_不可为空_转出机构;
    }

    public String getTrsoutbank_不可为空_转出银行() {
        return trsoutbank_不可为空_转出银行;
    }

    public void setTrsoutbank_不可为空_转出银行(String trsoutbank_不可为空_转出银行) {
        this.trsoutbank_不可为空_转出银行 = trsoutbank_不可为空_转出银行;
    }

    public String getDepotype_不可为空_存单类型() {
        return depotype_不可为空_存单类型;
    }

    public void setDepotype_不可为空_存单类型(String depotype_不可为空_存单类型) {
        this.depotype_不可为空_存单类型 = depotype_不可为空_存单类型;
    }

    public String getTermtype_不可为空_期限类型() {
        return termtype_不可为空_期限类型;
    }

    public void setTermtype_不可为空_期限类型(String termtype_不可为空_期限类型) {
        this.termtype_不可为空_期限类型 = termtype_不可为空_期限类型;
    }

    public long getDepoterm_不可为空_存单期限() {
        return depoterm_不可为空_存单期限;
    }

    public void setDepoterm_不可为空_存单期限(long depoterm_不可为空_存单期限) {
        this.depoterm_不可为空_存单期限 = depoterm_不可为空_存单期限;
    }

    public Date getDepobegdate_不可为空_存单开户日() {
        return depobegdate_不可为空_存单开户日;
    }

    public void setDepobegdate_不可为空_存单开户日(Date depobegdate_不可为空_存单开户日) {
        this.depobegdate_不可为空_存单开户日 = depobegdate_不可为空_存单开户日;
    }

    public Date getDepoenddate_不可为空_存单到期日() {
        return depoenddate_不可为空_存单到期日;
    }

    public void setDepoenddate_不可为空_存单到期日(Date depoenddate_不可为空_存单到期日) {
        this.depoenddate_不可为空_存单到期日 = depoenddate_不可为空_存单到期日;
    }

    public Date getExpcalbegdate_不可为空_计息起日() {
        return expcalbegdate_不可为空_计息起日;
    }

    public void setExpcalbegdate_不可为空_计息起日(Date expcalbegdate_不可为空_计息起日) {
        this.expcalbegdate_不可为空_计息起日 = expcalbegdate_不可为空_计息起日;
    }

    public double getDeporate_可为空_存单利率() {
        return deporate_可为空_存单利率;
    }

    public void setDeporate_可为空_存单利率(double deporate_可为空_存单利率) {
        this.deporate_可为空_存单利率 = deporate_可为空_存单利率;
    }

    public double getDepoamt_不可为空_存单金额() {
        return depoamt_不可为空_存单金额;
    }

    public void setDepoamt_不可为空_存单金额(double depoamt_不可为空_存单金额) {
        this.depoamt_不可为空_存单金额 = depoamt_不可为空_存单金额;
    }

    public double getCurrbal_不可为空_当前余额() {
        return currbal_不可为空_当前余额;
    }

    public void setCurrbal_不可为空_当前余额(double currbal_不可为空_当前余额) {
        this.currbal_不可为空_当前余额 = currbal_不可为空_当前余额;
    }

    public Date getLastexpintdate_可为空_上次计息日期() {
        return lastexpintdate_可为空_上次计息日期;
    }

    public void setLastexpintdate_可为空_上次计息日期(Date lastexpintdate_可为空_上次计息日期) {
        this.lastexpintdate_可为空_上次计息日期 = lastexpintdate_可为空_上次计息日期;
    }

    public Date getLastincintdate_可为空_上次收息日期() {
        return lastincintdate_可为空_上次收息日期;
    }

    public void setLastincintdate_可为空_上次收息日期(Date lastincintdate_可为空_上次收息日期) {
        this.lastincintdate_可为空_上次收息日期 = lastincintdate_可为空_上次收息日期;
    }

    public String getExpintmode_可为空_计息方式() {
        return expintmode_可为空_计息方式;
    }

    public void setExpintmode_可为空_计息方式(String expintmode_可为空_计息方式) {
        this.expintmode_可为空_计息方式 = expintmode_可为空_计息方式;
    }

    public String getIncintmode_可为空_收息方式() {
        return incintmode_可为空_收息方式;
    }

    public void setIncintmode_可为空_收息方式(String incintmode_可为空_收息方式) {
        this.incintmode_可为空_收息方式 = incintmode_可为空_收息方式;
    }

    public String getDepostate_不可为空_存单状态() {
        return depostate_不可为空_存单状态;
    }

    public void setDepostate_不可为空_存单状态(String depostate_不可为空_存单状态) {
        this.depostate_不可为空_存单状态 = depostate_不可为空_存单状态;
    }

    public String getFundkindadjflag_可为空_资金性质调整标志() {
        return fundkindadjflag_可为空_资金性质调整标志;
    }

    public void setFundkindadjflag_可为空_资金性质调整标志(String fundkindadjflag_可为空_资金性质调整标志) {
        this.fundkindadjflag_可为空_资金性质调整标志 = fundkindadjflag_可为空_资金性质调整标志;
    }

    public String getOfftype_不可为空_注销类型() {
        return offtype_不可为空_注销类型;
    }

    public void setOfftype_不可为空_注销类型(String offtype_不可为空_注销类型) {
        this.offtype_不可为空_注销类型 = offtype_不可为空_注销类型;
    }

    public double getIncintsum_可为空_收息总额() {
        return incintsum_可为空_收息总额;
    }

    public void setIncintsum_可为空_收息总额(double incintsum_可为空_收息总额) {
        this.incintsum_可为空_收息总额 = incintsum_可为空_收息总额;
    }

    public double getExpcalsum_可为空_计息总额() {
        return expcalsum_可为空_计息总额;
    }

    public void setExpcalsum_可为空_计息总额(double expcalsum_可为空_计息总额) {
        this.expcalsum_可为空_计息总额 = expcalsum_可为空_计息总额;
    }

    public Date getAdjdate_可为空_调整日期() {
        return adjdate_可为空_调整日期;
    }

    public void setAdjdate_可为空_调整日期(Date adjdate_可为空_调整日期) {
        this.adjdate_可为空_调整日期 = adjdate_可为空_调整日期;
    }

    public String getSubcode_可为空_科目控制字() {
        return subcode_可为空_科目控制字;
    }

    public void setSubcode_可为空_科目控制字(String subcode_可为空_科目控制字) {
        this.subcode_可为空_科目控制字 = subcode_可为空_科目控制字;
    }

    public String getLinkman_可为空_联系人() {
        return linkman_可为空_联系人;
    }

    public void setLinkman_可为空_联系人(String linkman_可为空_联系人) {
        this.linkman_可为空_联系人 = linkman_可为空_联系人;
    }

    public String getLinkphone_可为空_联系电话() {
        return linkphone_可为空_联系电话;
    }

    public void setLinkphone_可为空_联系电话(String linkphone_可为空_联系电话) {
        this.linkphone_可为空_联系电话 = linkphone_可为空_联系电话;
    }

    public String getRemark_可为空_备注() {
        return remark_可为空_备注;
    }

    public void setRemark_可为空_备注(String remark_可为空_备注) {
        this.remark_可为空_备注 = remark_可为空_备注;
    }

    public String getFlag_可为空_标志() {
        return flag_可为空_标志;
    }

    public void setFlag_可为空_标志(String flag_可为空_标志) {
        this.flag_可为空_标志 = flag_可为空_标志;
    }

    public String getValidflag_可为空_有效标志() {
        return validflag_可为空_有效标志;
    }

    public void setValidflag_可为空_有效标志(String validflag_可为空_有效标志) {
        this.validflag_可为空_有效标志 = validflag_可为空_有效标志;
    }

    public String getRedepotype_可为空_转存类型() {
        return redepotype_可为空_转存类型;
    }

    public void setRedepotype_可为空_转存类型(String redepotype_可为空_转存类型) {
        this.redepotype_可为空_转存类型 = redepotype_可为空_转存类型;
    }

    public String getIntincfundacc_可为空_利息收款账户() {
        return intincfundacc_可为空_利息收款账户;
    }

    public void setIntincfundacc_可为空_利息收款账户(String intincfundacc_可为空_利息收款账户) {
        this.intincfundacc_可为空_利息收款账户 = intincfundacc_可为空_利息收款账户;
    }

    public String getDepoaccnum_可为空_定期账号() {
        return depoaccnum_可为空_定期账号;
    }

    public void setDepoaccnum_可为空_定期账号(String depoaccnum_可为空_定期账号) {
        this.depoaccnum_可为空_定期账号 = depoaccnum_可为空_定期账号;
    }

    public String getBankaccnm_可为空_银行账户名称() {
        return bankaccnm_可为空_银行账户名称;
    }

    public void setBankaccnm_可为空_银行账户名称(String bankaccnm_可为空_银行账户名称) {
        this.bankaccnm_可为空_银行账户名称 = bankaccnm_可为空_银行账户名称;
    }

    public String getVolnum_可为空_册号() {
        return volnum_可为空_册号;
    }

    public void setVolnum_可为空_册号(String volnum_可为空_册号) {
        this.volnum_可为空_册号 = volnum_可为空_册号;
    }

    public String getVolseqnum_可为空_序号() {
        return volseqnum_可为空_序号;
    }

    public void setVolseqnum_可为空_序号(String volseqnum_可为空_序号) {
        this.volseqnum_可为空_序号 = volseqnum_可为空_序号;
    }

    public String getBankhostsernum_可为空_银行主机流水号() {
        return bankhostsernum_可为空_银行主机流水号;
    }

    public void setBankhostsernum_可为空_银行主机流水号(String bankhostsernum_可为空_银行主机流水号) {
        this.bankhostsernum_可为空_银行主机流水号 = bankhostsernum_可为空_银行主机流水号;
    }

    public String getFreeuse1_可为空_备用字符() {
        return freeuse1_可为空_备用字符;
    }

    public void setFreeuse1_可为空_备用字符(String freeuse1_可为空_备用字符) {
        this.freeuse1_可为空_备用字符 = freeuse1_可为空_备用字符;
    }

    public double getFreeuse2_可为空_备用金额() {
        return freeuse2_可为空_备用金额;
    }

    public void setFreeuse2_可为空_备用金额(double freeuse2_可为空_备用金额) {
        this.freeuse2_可为空_备用金额 = freeuse2_可为空_备用金额;
    }

    public Date getFreeuse3_可为空_备用日期() {
        return freeuse3_可为空_备用日期;
    }

    public void setFreeuse3_可为空_备用日期(Date freeuse3_可为空_备用日期) {
        this.freeuse3_可为空_备用日期 = freeuse3_可为空_备用日期;
    }

    public long getFreeuse4_可为空_备用数值() {
        return freeuse4_可为空_备用数值;
    }

    public void setFreeuse4_可为空_备用数值(long freeuse4_可为空_备用数值) {
        this.freeuse4_可为空_备用数值 = freeuse4_可为空_备用数值;
    }
}
