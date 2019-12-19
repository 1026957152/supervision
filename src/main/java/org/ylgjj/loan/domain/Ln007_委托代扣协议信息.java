package org.ylgjj.loan.domain;
import javax.persistence.*;
import java.sql.Date;
@IdClass(LN007_key.class)

@Entity

@Table(name = "Ln007")
public class Ln007_委托代扣协议信息 {

  @Id
  @Column(name = "loancontrcode")
  private String loancontrcode_不可为空_合同代码;//
  @Id
  @Column(name = "dedtype")
  private String dedtype_不可为空_代扣类型;//	"1-银行,
/*
          2-公积金
*/

  @Column(name = "dedseq")
  private long dedseq_不可为空_代扣顺序;//

  @Column(name = "accname")
  private String accname_不可为空_个人姓名;//

  @Column(name = "dedoptype")
  private String dedoptype_不可为空_扣款人类型;//	"0-借款人,
/*          1-共同借款人,
          2-共同还款人"*/

  @Column(name = "dedbankcode")
  private String dedbankcode_可为空_代扣银行;//

  @Column(name = "repaymode")
  private String dedaccnum_不可为空_代扣账号;//

  @Column(name = "certitype")
  private String certitype_不可为空_证件类型;//	"1-身份证,
/*          2-军官证,
          3-护照,
          9-其他"*/

  @Column(name = "certinum")
  private String certinum_不可为空_证件号码;//

  @Column(name = "dedprotonum")
  private String dedprotonum_可为空_委托代扣协议编号;//

  @Column(name = "protostate")
  private String protostate_不可为空_委托代扣协议状态;//	"1-正常,
/*          2-暂停,
          3-终止"*/

  @Column(name = "dedprotoflag")
  private String dedprotoflag_不可为空_委托代扣协议标志;//	"1-签订,
/*          2-解除,
          3-预约,
          4-预约解除"*/

  @Column(name = "transdate")
  private java.sql.Date transdate_不可为空_交易日期;//

  @Column(name = "hostsernum")
  private long hostsernum_不可为空_主机流水号;//

  @Column(name = "agentop")
  private String agentop_不可为空_经办柜员;//

  @Column(name = "freeuse1")
  private String freeuse1_可为空_备用字符;//

  @Column(name = "freeuse2")
  private double freeuse2_可为空_备用金额;//

  @Column(name = "freeuse3")
  private java.sql.Date freeuse3_可为空_备用日期;//

  @Column(name = "freeuse4")
  private long freeuse4_可为空_备用数值;//


  public String getLoancontrcode_不可为空_合同代码() {
    return loancontrcode_不可为空_合同代码;
  }

  public void setLoancontrcode_不可为空_合同代码(String loancontrcode_不可为空_合同代码) {
    this.loancontrcode_不可为空_合同代码 = loancontrcode_不可为空_合同代码;
  }

  public String getDedtype_不可为空_代扣类型() {
    return dedtype_不可为空_代扣类型;
  }

  public void setDedtype_不可为空_代扣类型(String dedtype_不可为空_代扣类型) {
    this.dedtype_不可为空_代扣类型 = dedtype_不可为空_代扣类型;
  }

  public long getDedseq_不可为空_代扣顺序() {
    return dedseq_不可为空_代扣顺序;
  }

  public void setDedseq_不可为空_代扣顺序(long dedseq_不可为空_代扣顺序) {
    this.dedseq_不可为空_代扣顺序 = dedseq_不可为空_代扣顺序;
  }

  public String getAccname_不可为空_个人姓名() {
    return accname_不可为空_个人姓名;
  }

  public void setAccname_不可为空_个人姓名(String accname_不可为空_个人姓名) {
    this.accname_不可为空_个人姓名 = accname_不可为空_个人姓名;
  }

  public String getDedoptype_不可为空_扣款人类型() {
    return dedoptype_不可为空_扣款人类型;
  }

  public void setDedoptype_不可为空_扣款人类型(String dedoptype_不可为空_扣款人类型) {
    this.dedoptype_不可为空_扣款人类型 = dedoptype_不可为空_扣款人类型;
  }

  public String getDedbankcode_可为空_代扣银行() {
    return dedbankcode_可为空_代扣银行;
  }

  public void setDedbankcode_可为空_代扣银行(String dedbankcode_可为空_代扣银行) {
    this.dedbankcode_可为空_代扣银行 = dedbankcode_可为空_代扣银行;
  }

  public String getDedaccnum_不可为空_代扣账号() {
    return dedaccnum_不可为空_代扣账号;
  }

  public void setDedaccnum_不可为空_代扣账号(String dedaccnum_不可为空_代扣账号) {
    this.dedaccnum_不可为空_代扣账号 = dedaccnum_不可为空_代扣账号;
  }

  public String getCertitype_不可为空_证件类型() {
    return certitype_不可为空_证件类型;
  }

  public void setCertitype_不可为空_证件类型(String certitype_不可为空_证件类型) {
    this.certitype_不可为空_证件类型 = certitype_不可为空_证件类型;
  }

  public String getCertinum_不可为空_证件号码() {
    return certinum_不可为空_证件号码;
  }

  public void setCertinum_不可为空_证件号码(String certinum_不可为空_证件号码) {
    this.certinum_不可为空_证件号码 = certinum_不可为空_证件号码;
  }

  public String getDedprotonum_可为空_委托代扣协议编号() {
    return dedprotonum_可为空_委托代扣协议编号;
  }

  public void setDedprotonum_可为空_委托代扣协议编号(String dedprotonum_可为空_委托代扣协议编号) {
    this.dedprotonum_可为空_委托代扣协议编号 = dedprotonum_可为空_委托代扣协议编号;
  }

  public String getProtostate_不可为空_委托代扣协议状态() {
    return protostate_不可为空_委托代扣协议状态;
  }

  public void setProtostate_不可为空_委托代扣协议状态(String protostate_不可为空_委托代扣协议状态) {
    this.protostate_不可为空_委托代扣协议状态 = protostate_不可为空_委托代扣协议状态;
  }

  public String getDedprotoflag_不可为空_委托代扣协议标志() {
    return dedprotoflag_不可为空_委托代扣协议标志;
  }

  public void setDedprotoflag_不可为空_委托代扣协议标志(String dedprotoflag_不可为空_委托代扣协议标志) {
    this.dedprotoflag_不可为空_委托代扣协议标志 = dedprotoflag_不可为空_委托代扣协议标志;
  }

  public Date getTransdate_不可为空_交易日期() {
    return transdate_不可为空_交易日期;
  }

  public void setTransdate_不可为空_交易日期(Date transdate_不可为空_交易日期) {
    this.transdate_不可为空_交易日期 = transdate_不可为空_交易日期;
  }

  public long getHostsernum_不可为空_主机流水号() {
    return hostsernum_不可为空_主机流水号;
  }

  public void setHostsernum_不可为空_主机流水号(long hostsernum_不可为空_主机流水号) {
    this.hostsernum_不可为空_主机流水号 = hostsernum_不可为空_主机流水号;
  }

  public String getAgentop_不可为空_经办柜员() {
    return agentop_不可为空_经办柜员;
  }

  public void setAgentop_不可为空_经办柜员(String agentop_不可为空_经办柜员) {
    this.agentop_不可为空_经办柜员 = agentop_不可为空_经办柜员;
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
