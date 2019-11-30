package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "DP093")

public class DP093_冻结解冻登记簿 {
    @Id

    @Column(name = "frzno")
    private String frzno_不可为空_冻结编号;//
    @Column(name = "agentinstcode")
    private String agentinstcode_不可为空_经办机构;//
    @Column(name = "transdate")
    private java.sql.Date transdate_不可为空_交易日期;//
    @Column(name = "frzaccnum")
    private String frzaccnum_不可为空_冻结账户账号;//
    @Column(name = "accflag")
    private String accflag_不可为空_账户标志;//_0-单位户,1-预缴户,2-个人户_0.单位 2.个人
    @Column(name = "frzaccname")
    private String frzaccname_不可为空_冻结账户名称;//
    @Column(name = "frzacctype")
    private String frzacctype_不可为空_冻结账户类型;//
    @Column(name = "frzbusiflag")
    private String frzbusiflag_不可为空_冻结业务标志;//_0-冻结,1-解冻_0.冻结 1.解冻
    @Column(name = "frztype")
    private String frztype_不可为空_冻结类型;//_0-法院执行,1-检察院执行,2-冻结错误,3-冻结期满续冻,4-自动解冻,9-其他_0.法院执行 1.检察院执行 2.冻结错误 3.冻结期满续冻 4.自动解冻 9.其他
    @Column(name = "frzmode")
    private String frzmode_不可为空_冻结方式;//_1.全部冻结 2.部分冻结 3.异地贷款_1.全部冻结 2.部分冻结 3.异地贷款
    @Column(name = "frztimes")
    private long frztimes_不可为空_冻结次数;//
    @Column(name = "frzamt")
    private double frzamt_不可为空_冻结金额;//
    @Column(name = "frozamt")
    private double frozamt_不可为空_已冻金额;//
    @Column(name = "frzreason")
    private String frzreason_可为空_冻结原因;//
    @Column(name = "thawreason")
    private String thawreason_可为空_解冻原因;//
    @Column(name = "bal")
    private double bal_不可为空_余额;//
    @Column(name = "usebal")
    private double usebal_不可为空_可用余额;//
    @Column(name = "frzdodate")
    private java.sql.Date frzdodate_不可为空_冻结执行日期;//
    @Column(name = "enddate")
    private java.sql.Date enddate_不可为空_终止日期;//
    @Column(name = "thawdate")
    private java.sql.Date thawdate_不可为空_解冻日期;//
    @Column(name = "frzop")
    private String frzop_不可为空_冻结柜员;//
    @Column(name = "thawop")
    private String thawop_不可为空_解冻柜员;//
    @Column(name = "powdept")
    private String powdept_可为空_有权部门;//
    @Column(name = "exewritno")
    private String exewritno_可为空_协助执行文书编号;//
    @Column(name = "tipsname")
    private String tipsname_可为空_执法人员姓名;//
    @Column(name = "linkphone")
    private String linkphone_可为空_联系电话;//
    @Column(name = "tipscertinum")
    private String tipscertinum_可为空_执法人证件号码;//
    @Column(name = "freeuse1")
    private String freeuse1_不可为空_备用字符;//
    @Column(name = "freeuse2")
    private double freeuse2_不可为空_备用金额;//
    @Column(name = "freeuse3")
    private java.sql.Date freeuse3_不可为空_备用日期;//
    @Column(name = "freeuse4")
    private long freeuse4_不可为空_备用数值;//



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getFrzno_不可为空_冻结编号() {
        return frzno_不可为空_冻结编号;
    }

    public void setFrzno_不可为空_冻结编号(String frzno_不可为空_冻结编号) {
        this.frzno_不可为空_冻结编号 = frzno_不可为空_冻结编号;
    }

    public String getAgentinstcode_不可为空_经办机构() {
        return agentinstcode_不可为空_经办机构;
    }

    public void setAgentinstcode_不可为空_经办机构(String agentinstcode_不可为空_经办机构) {
        this.agentinstcode_不可为空_经办机构 = agentinstcode_不可为空_经办机构;
    }

    public Date getTransdate_不可为空_交易日期() {
        return transdate_不可为空_交易日期;
    }

    public void setTransdate_不可为空_交易日期(Date transdate_不可为空_交易日期) {
        this.transdate_不可为空_交易日期 = transdate_不可为空_交易日期;
    }

    public String getFrzaccnum_不可为空_冻结账户账号() {
        return frzaccnum_不可为空_冻结账户账号;
    }

    public void setFrzaccnum_不可为空_冻结账户账号(String frzaccnum_不可为空_冻结账户账号) {
        this.frzaccnum_不可为空_冻结账户账号 = frzaccnum_不可为空_冻结账户账号;
    }

    public String getAccflag_不可为空_账户标志() {
        return accflag_不可为空_账户标志;
    }

    public void setAccflag_不可为空_账户标志(String accflag_不可为空_账户标志) {
        this.accflag_不可为空_账户标志 = accflag_不可为空_账户标志;
    }

    public String getFrzaccname_不可为空_冻结账户名称() {
        return frzaccname_不可为空_冻结账户名称;
    }

    public void setFrzaccname_不可为空_冻结账户名称(String frzaccname_不可为空_冻结账户名称) {
        this.frzaccname_不可为空_冻结账户名称 = frzaccname_不可为空_冻结账户名称;
    }

    public String getFrzacctype_不可为空_冻结账户类型() {
        return frzacctype_不可为空_冻结账户类型;
    }

    public void setFrzacctype_不可为空_冻结账户类型(String frzacctype_不可为空_冻结账户类型) {
        this.frzacctype_不可为空_冻结账户类型 = frzacctype_不可为空_冻结账户类型;
    }

    public String getFrzbusiflag_不可为空_冻结业务标志() {
        return frzbusiflag_不可为空_冻结业务标志;
    }

    public void setFrzbusiflag_不可为空_冻结业务标志(String frzbusiflag_不可为空_冻结业务标志) {
        this.frzbusiflag_不可为空_冻结业务标志 = frzbusiflag_不可为空_冻结业务标志;
    }

    public String getFrztype_不可为空_冻结类型() {
        return frztype_不可为空_冻结类型;
    }

    public void setFrztype_不可为空_冻结类型(String frztype_不可为空_冻结类型) {
        this.frztype_不可为空_冻结类型 = frztype_不可为空_冻结类型;
    }

    public String getFrzmode_不可为空_冻结方式() {
        return frzmode_不可为空_冻结方式;
    }

    public void setFrzmode_不可为空_冻结方式(String frzmode_不可为空_冻结方式) {
        this.frzmode_不可为空_冻结方式 = frzmode_不可为空_冻结方式;
    }

    public long getFrztimes_不可为空_冻结次数() {
        return frztimes_不可为空_冻结次数;
    }

    public void setFrztimes_不可为空_冻结次数(long frztimes_不可为空_冻结次数) {
        this.frztimes_不可为空_冻结次数 = frztimes_不可为空_冻结次数;
    }

    public double getFrzamt_不可为空_冻结金额() {
        return frzamt_不可为空_冻结金额;
    }

    public void setFrzamt_不可为空_冻结金额(double frzamt_不可为空_冻结金额) {
        this.frzamt_不可为空_冻结金额 = frzamt_不可为空_冻结金额;
    }

    public double getFrozamt_不可为空_已冻金额() {
        return frozamt_不可为空_已冻金额;
    }

    public void setFrozamt_不可为空_已冻金额(double frozamt_不可为空_已冻金额) {
        this.frozamt_不可为空_已冻金额 = frozamt_不可为空_已冻金额;
    }

    public String getFrzreason_可为空_冻结原因() {
        return frzreason_可为空_冻结原因;
    }

    public void setFrzreason_可为空_冻结原因(String frzreason_可为空_冻结原因) {
        this.frzreason_可为空_冻结原因 = frzreason_可为空_冻结原因;
    }

    public String getThawreason_可为空_解冻原因() {
        return thawreason_可为空_解冻原因;
    }

    public void setThawreason_可为空_解冻原因(String thawreason_可为空_解冻原因) {
        this.thawreason_可为空_解冻原因 = thawreason_可为空_解冻原因;
    }

    public double getBal_不可为空_余额() {
        return bal_不可为空_余额;
    }

    public void setBal_不可为空_余额(double bal_不可为空_余额) {
        this.bal_不可为空_余额 = bal_不可为空_余额;
    }

    public double getUsebal_不可为空_可用余额() {
        return usebal_不可为空_可用余额;
    }

    public void setUsebal_不可为空_可用余额(double usebal_不可为空_可用余额) {
        this.usebal_不可为空_可用余额 = usebal_不可为空_可用余额;
    }

    public Date getFrzdodate_不可为空_冻结执行日期() {
        return frzdodate_不可为空_冻结执行日期;
    }

    public void setFrzdodate_不可为空_冻结执行日期(Date frzdodate_不可为空_冻结执行日期) {
        this.frzdodate_不可为空_冻结执行日期 = frzdodate_不可为空_冻结执行日期;
    }

    public Date getEnddate_不可为空_终止日期() {
        return enddate_不可为空_终止日期;
    }

    public void setEnddate_不可为空_终止日期(Date enddate_不可为空_终止日期) {
        this.enddate_不可为空_终止日期 = enddate_不可为空_终止日期;
    }

    public Date getThawdate_不可为空_解冻日期() {
        return thawdate_不可为空_解冻日期;
    }

    public void setThawdate_不可为空_解冻日期(Date thawdate_不可为空_解冻日期) {
        this.thawdate_不可为空_解冻日期 = thawdate_不可为空_解冻日期;
    }

    public String getFrzop_不可为空_冻结柜员() {
        return frzop_不可为空_冻结柜员;
    }

    public void setFrzop_不可为空_冻结柜员(String frzop_不可为空_冻结柜员) {
        this.frzop_不可为空_冻结柜员 = frzop_不可为空_冻结柜员;
    }

    public String getThawop_不可为空_解冻柜员() {
        return thawop_不可为空_解冻柜员;
    }

    public void setThawop_不可为空_解冻柜员(String thawop_不可为空_解冻柜员) {
        this.thawop_不可为空_解冻柜员 = thawop_不可为空_解冻柜员;
    }

    public String getPowdept_可为空_有权部门() {
        return powdept_可为空_有权部门;
    }

    public void setPowdept_可为空_有权部门(String powdept_可为空_有权部门) {
        this.powdept_可为空_有权部门 = powdept_可为空_有权部门;
    }

    public String getExewritno_可为空_协助执行文书编号() {
        return exewritno_可为空_协助执行文书编号;
    }

    public void setExewritno_可为空_协助执行文书编号(String exewritno_可为空_协助执行文书编号) {
        this.exewritno_可为空_协助执行文书编号 = exewritno_可为空_协助执行文书编号;
    }

    public String getTipsname_可为空_执法人员姓名() {
        return tipsname_可为空_执法人员姓名;
    }

    public void setTipsname_可为空_执法人员姓名(String tipsname_可为空_执法人员姓名) {
        this.tipsname_可为空_执法人员姓名 = tipsname_可为空_执法人员姓名;
    }

    public String getLinkphone_可为空_联系电话() {
        return linkphone_可为空_联系电话;
    }

    public void setLinkphone_可为空_联系电话(String linkphone_可为空_联系电话) {
        this.linkphone_可为空_联系电话 = linkphone_可为空_联系电话;
    }

    public String getTipscertinum_可为空_执法人证件号码() {
        return tipscertinum_可为空_执法人证件号码;
    }

    public void setTipscertinum_可为空_执法人证件号码(String tipscertinum_可为空_执法人证件号码) {
        this.tipscertinum_可为空_执法人证件号码 = tipscertinum_可为空_执法人证件号码;
    }

    public String getFreeuse1_不可为空_备用字符() {
        return freeuse1_不可为空_备用字符;
    }

    public void setFreeuse1_不可为空_备用字符(String freeuse1_不可为空_备用字符) {
        this.freeuse1_不可为空_备用字符 = freeuse1_不可为空_备用字符;
    }

    public double getFreeuse2_不可为空_备用金额() {
        return freeuse2_不可为空_备用金额;
    }

    public void setFreeuse2_不可为空_备用金额(double freeuse2_不可为空_备用金额) {
        this.freeuse2_不可为空_备用金额 = freeuse2_不可为空_备用金额;
    }

    public Date getFreeuse3_不可为空_备用日期() {
        return freeuse3_不可为空_备用日期;
    }

    public void setFreeuse3_不可为空_备用日期(Date freeuse3_不可为空_备用日期) {
        this.freeuse3_不可为空_备用日期 = freeuse3_不可为空_备用日期;
    }

    public long getFreeuse4_不可为空_备用数值() {
        return freeuse4_不可为空_备用数值;
    }

    public void setFreeuse4_不可为空_备用数值(long freeuse4_不可为空_备用数值) {
        this.freeuse4_不可为空_备用数值 = freeuse4_不可为空_备用数值;
    }
}
