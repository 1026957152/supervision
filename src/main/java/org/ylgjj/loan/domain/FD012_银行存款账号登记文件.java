package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(FD012_key.class)
@Entity
@Table(name = "FD012")

public class FD012_银行存款账号登记文件 {





    @Id
    @Column(name = "centerid")
    private String CENTERID_不可为空_城市中心代码;
    @Id
    @Column(name = "bankcode")
    private String BANKCODE_不可为空_银行代码;
    @Id
    @Column(name = "bankaccnum")
    private String BANKACCNUM_不可为空_银行账号;
    @Id
    @Column(name = "fundkind")
    private String FUNDKIND_不可为空_资金性质;//01-住房公积金存款,03-增值收益存款_
    @Id
    @Column(name = "bankaccstate")
    private String BANKACCSTATE_不可为空_银行账户状态; //0-正常,9-注销_




    @Column(name = "instcode")
    private String INSTCODE_不可为空_机构代码;




    @Column(name = "transdate")
    private LocalDate TRANSDATE不可为空交易日期;











    @Column(name = "validflag")
    private String validflag_可为空_银行标志; //0-普通,1-提取行_

    @Column(name = "bankaccnm")
    private String BANKACCNM_不可为空_银行账户名称;

    @Column(name = "linkman")
    private String LINKMAN_可为空_联系人;

    @Column(name = "linkphone")
    private String LINKPHONE_可为空_联系电话;

    @Column(name = "agentinstcode")
    private String AGENTINSTCODE_可为空_经办机构;

    @Column(name = "agentop")
    private String AGENTOP_可为空_经办柜员;




    @Column(name = "opnaccdate")
    private java.sql.Date opnaccdate;

    @Column(name = "clsaccdate")
    private java.sql.Date clsaccdate;

    @Column(name = "freeuse1")
    private String FREEUSE1_可为空_备用字符;

    @Column(name = "freeuse2")
    private double FREEUSE2_可为空_备用金额;

    @Column(name = "freeuse3")
    private java.sql.Date FREEUSE3_可为空_备用日期;

    @Column(name = "freeuse4")
    private long FREEUSE4_可为空_备用数值;



    public String getCENTERID_不可为空_城市中心代码() {
        return CENTERID_不可为空_城市中心代码;
    }

    public void setCENTERID_不可为空_城市中心代码(String CENTERID_不可为空_城市中心代码) {
        this.CENTERID_不可为空_城市中心代码 = CENTERID_不可为空_城市中心代码;
    }

    public String getINSTCODE_不可为空_机构代码() {
        return INSTCODE_不可为空_机构代码;
    }

    public void setINSTCODE_不可为空_机构代码(String INSTCODE_不可为空_机构代码) {
        this.INSTCODE_不可为空_机构代码 = INSTCODE_不可为空_机构代码;
    }

    public String getBANKCODE_不可为空_银行代码() {
        return BANKCODE_不可为空_银行代码;
    }

    public void setBANKCODE_不可为空_银行代码(String BANKCODE_不可为空_银行代码) {
        this.BANKCODE_不可为空_银行代码 = BANKCODE_不可为空_银行代码;
    }

    public String getBANKACCNUM_不可为空_银行账号() {
        return BANKACCNUM_不可为空_银行账号;
    }

    public void setBANKACCNUM_不可为空_银行账号(String BANKACCNUM_不可为空_银行账号) {
        this.BANKACCNUM_不可为空_银行账号 = BANKACCNUM_不可为空_银行账号;
    }

    public LocalDate getTRANSDATE不可为空交易日期() {
        return TRANSDATE不可为空交易日期;
    }

    public void setTRANSDATE不可为空交易日期(LocalDate TRANSDATE_不可为空_交易日期) {
        this.TRANSDATE不可为空交易日期 = TRANSDATE_不可为空_交易日期;
    }

    public String getFUNDKIND_不可为空_资金性质() {
        return FUNDKIND_不可为空_资金性质;
    }

    public void setFUNDKIND_不可为空_资金性质(String FUNDKIND_不可为空_资金性质) {
        this.FUNDKIND_不可为空_资金性质 = FUNDKIND_不可为空_资金性质;
    }

    public String getValidflag_可为空_银行标志() {
        return validflag_可为空_银行标志;
    }

    public void setValidflag_可为空_银行标志(String validflag_可为空_银行标志) {
        this.validflag_可为空_银行标志 = validflag_可为空_银行标志;
    }

    public String getBANKACCNM_不可为空_银行账户名称() {
        return BANKACCNM_不可为空_银行账户名称;
    }

    public void setBANKACCNM_不可为空_银行账户名称(String BANKACCNM_不可为空_银行账户名称) {
        this.BANKACCNM_不可为空_银行账户名称 = BANKACCNM_不可为空_银行账户名称;
    }

    public String getBANKACCSTATE_不可为空_银行账户状态() {
        return BANKACCSTATE_不可为空_银行账户状态;
    }

    public void setBANKACCSTATE_不可为空_银行账户状态(String BANKACCSTATE_不可为空_银行账户状态) {
        this.BANKACCSTATE_不可为空_银行账户状态 = BANKACCSTATE_不可为空_银行账户状态;
    }

    public String getLINKMAN_可为空_联系人() {
        return LINKMAN_可为空_联系人;
    }

    public void setLINKMAN_可为空_联系人(String LINKMAN_可为空_联系人) {
        this.LINKMAN_可为空_联系人 = LINKMAN_可为空_联系人;
    }

    public String getLINKPHONE_可为空_联系电话() {
        return LINKPHONE_可为空_联系电话;
    }

    public void setLINKPHONE_可为空_联系电话(String LINKPHONE_可为空_联系电话) {
        this.LINKPHONE_可为空_联系电话 = LINKPHONE_可为空_联系电话;
    }

    public String getAGENTINSTCODE_可为空_经办机构() {
        return AGENTINSTCODE_可为空_经办机构;
    }

    public void setAGENTINSTCODE_可为空_经办机构(String AGENTINSTCODE_可为空_经办机构) {
        this.AGENTINSTCODE_可为空_经办机构 = AGENTINSTCODE_可为空_经办机构;
    }

    public String getAGENTOP_可为空_经办柜员() {
        return AGENTOP_可为空_经办柜员;
    }

    public void setAGENTOP_可为空_经办柜员(String AGENTOP_可为空_经办柜员) {
        this.AGENTOP_可为空_经办柜员 = AGENTOP_可为空_经办柜员;
    }

    public Date getOpnaccdate() {
        return opnaccdate;
    }

    public void setOpnaccdate(Date opnaccdate) {
        this.opnaccdate = opnaccdate;
    }

    public Date getClsaccdate() {
        return clsaccdate;
    }

    public void setClsaccdate(Date clsaccdate) {
        this.clsaccdate = clsaccdate;
    }

    public String getFREEUSE1_可为空_备用字符() {
        return FREEUSE1_可为空_备用字符;
    }

    public void setFREEUSE1_可为空_备用字符(String FREEUSE1_可为空_备用字符) {
        this.FREEUSE1_可为空_备用字符 = FREEUSE1_可为空_备用字符;
    }

    public double getFREEUSE2_可为空_备用金额() {
        return FREEUSE2_可为空_备用金额;
    }

    public void setFREEUSE2_可为空_备用金额(double FREEUSE2_可为空_备用金额) {
        this.FREEUSE2_可为空_备用金额 = FREEUSE2_可为空_备用金额;
    }

    public Date getFREEUSE3_可为空_备用日期() {
        return FREEUSE3_可为空_备用日期;
    }

    public void setFREEUSE3_可为空_备用日期(Date FREEUSE3_可为空_备用日期) {
        this.FREEUSE3_可为空_备用日期 = FREEUSE3_可为空_备用日期;
    }

    public long getFREEUSE4_可为空_备用数值() {
        return FREEUSE4_可为空_备用数值;
    }

    public void setFREEUSE4_可为空_备用数值(long FREEUSE4_可为空_备用数值) {
        this.FREEUSE4_可为空_备用数值 = FREEUSE4_可为空_备用数值;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



  }
