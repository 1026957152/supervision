package org.ylgjj.loan.domain;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "DP032")
public class Dp032_个人转移登记簿 {

  @Id
  @Column(name = "seqno")
  private long seqno_不可为空_序号;//

  @Column(name = "transdate")
  private java.sql.Date transdate_不可为空_交易日期;//

  @Column(name = "tsiunitaccnum")
  private String tsiunitaccnum_不可为空_转入单位账号;//

  @Column(name = "tsiunitaccname")
  private String tsiunitaccname_不可为空_转入单位名称;//

  @Column(name = "mergiaccnum")
  private String mergiaccnum_不可为空_转入机构;//

  @Column(name = "tsiinstcode")
  private String tsiinstcode_不可为空_并入个人账号;//

  @Column(name = "tsibank")
  private String tsibank_不可为空_转入银行;//

  @Column(name = "tsounitaccnum")
  private String tsounitaccnum_不可为空_转出单位账号;//

  @Column(name = "tsounitaccname")
  private String tsounitaccname_不可为空_转出单位名称;//

  @Column(name = "tsoinstcode")
  private String tsoinstcode_不可为空_转出机构;//

  @Column(name = "tsobank")
  private String tsobank_不可为空_转出银行;//

  @Column(name = "mergoaccnum")
  private String mergoaccnum_可为空_并出个人账号;//

  @Column(name = "tsoaccname")
  private String tsoaccname_不可为空_转出姓名;//

  @Column(name = "tsiaccname")
  private String tsiaccname_不可为空_转入姓名;//

  @Column(name = "mergicustid")
  private String mergicustid_可为空_并入个人客户号;//

  @Column(name = "mergocustid")
  private String mergocustid_可为空_并出个人客户号;//

  @Column(name = "trsreason")
  private String trsreason_不可为空_转移原因;//

  @Column(name = "trsamt")
  private double trsamt_不可为空_转移金额;//

  @Column(name = "trsintamt")
  private double trsintamt_不可为空_转移时结息金额;//

  @Column(name = "indilpaym")
  private String indilpaym_不可为空_个人缴至年月;//

  @Column(name = "trstype")
  private String trstype_不可为空_转移类型;//_0-托管转出,1-托管转入,2-正常转移,3-个人并户,4-执法扣划,5-调账

  @Column(name = "hostsernum")
  private long hostsernum_不可为空_主机流水号;//
  @Column(name = "transtype")
  private String transtype_不可为空_交易类型;//

  @Column(name = "agentinstcode")
  private String agentinstcode_不可为空_经办机构__因在转出管理部操作__所以与下同__;//

  @Column(name = "accinstcode")
  private String accinstcode_不可为空___原__账户机构;//

  @Column(name = "agentbankcode")
  private String agentbankcode_不可为空_经办银行;//

  @Column(name = "accbankcode")
  private String accbankcode_不可为空_账户银行;//

  @Column(name = "agentop")
  private String agentop_不可为空_经办柜员;//

  @Column(name = "centerid")
  private String centerid_不可为空_城市中心代码;//

  @Column(name = "freeuse1")
  private String freeuse1_可为空_备用字符;//

  @Column(name = "freeuse2")
  private double freeuse2_可为空_备用金额;//

  @Column(name = "freeuse3")
  private java.sql.Date freeuse3_可为空_备用字符;//

  @Column(name = "freeuse4")
  private long freeuse4_可为空_备用金额;//

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

  public long getSeqno_不可为空_序号() {
    return seqno_不可为空_序号;
  }

  public void setSeqno_不可为空_序号(long seqno_不可为空_序号) {
    this.seqno_不可为空_序号 = seqno_不可为空_序号;
  }

  public Date getTransdate_不可为空_交易日期() {
    return transdate_不可为空_交易日期;
  }

  public void setTransdate_不可为空_交易日期(Date transdate_不可为空_交易日期) {
    this.transdate_不可为空_交易日期 = transdate_不可为空_交易日期;
  }

  public String getTsiunitaccnum_不可为空_转入单位账号() {
    return tsiunitaccnum_不可为空_转入单位账号;
  }

  public void setTsiunitaccnum_不可为空_转入单位账号(String tsiunitaccnum_不可为空_转入单位账号) {
    this.tsiunitaccnum_不可为空_转入单位账号 = tsiunitaccnum_不可为空_转入单位账号;
  }

  public String getTsiunitaccname_不可为空_转入单位名称() {
    return tsiunitaccname_不可为空_转入单位名称;
  }

  public void setTsiunitaccname_不可为空_转入单位名称(String tsiunitaccname_不可为空_转入单位名称) {
    this.tsiunitaccname_不可为空_转入单位名称 = tsiunitaccname_不可为空_转入单位名称;
  }

  public String getMergiaccnum_不可为空_转入机构() {
    return mergiaccnum_不可为空_转入机构;
  }

  public void setMergiaccnum_不可为空_转入机构(String mergiaccnum_不可为空_转入机构) {
    this.mergiaccnum_不可为空_转入机构 = mergiaccnum_不可为空_转入机构;
  }

  public String getTsiinstcode_不可为空_并入个人账号() {
    return tsiinstcode_不可为空_并入个人账号;
  }

  public void setTsiinstcode_不可为空_并入个人账号(String tsiinstcode_不可为空_并入个人账号) {
    this.tsiinstcode_不可为空_并入个人账号 = tsiinstcode_不可为空_并入个人账号;
  }

  public String getTsibank_不可为空_转入银行() {
    return tsibank_不可为空_转入银行;
  }

  public void setTsibank_不可为空_转入银行(String tsibank_不可为空_转入银行) {
    this.tsibank_不可为空_转入银行 = tsibank_不可为空_转入银行;
  }

  public String getTsounitaccnum_不可为空_转出单位账号() {
    return tsounitaccnum_不可为空_转出单位账号;
  }

  public void setTsounitaccnum_不可为空_转出单位账号(String tsounitaccnum_不可为空_转出单位账号) {
    this.tsounitaccnum_不可为空_转出单位账号 = tsounitaccnum_不可为空_转出单位账号;
  }

  public String getTsounitaccname_不可为空_转出单位名称() {
    return tsounitaccname_不可为空_转出单位名称;
  }

  public void setTsounitaccname_不可为空_转出单位名称(String tsounitaccname_不可为空_转出单位名称) {
    this.tsounitaccname_不可为空_转出单位名称 = tsounitaccname_不可为空_转出单位名称;
  }

  public String getTsoinstcode_不可为空_转出机构() {
    return tsoinstcode_不可为空_转出机构;
  }

  public void setTsoinstcode_不可为空_转出机构(String tsoinstcode_不可为空_转出机构) {
    this.tsoinstcode_不可为空_转出机构 = tsoinstcode_不可为空_转出机构;
  }

  public String getTsobank_不可为空_转出银行() {
    return tsobank_不可为空_转出银行;
  }

  public void setTsobank_不可为空_转出银行(String tsobank_不可为空_转出银行) {
    this.tsobank_不可为空_转出银行 = tsobank_不可为空_转出银行;
  }

  public String getMergoaccnum_可为空_并出个人账号() {
    return mergoaccnum_可为空_并出个人账号;
  }

  public void setMergoaccnum_可为空_并出个人账号(String mergoaccnum_可为空_并出个人账号) {
    this.mergoaccnum_可为空_并出个人账号 = mergoaccnum_可为空_并出个人账号;
  }

  public String getTsoaccname_不可为空_转出姓名() {
    return tsoaccname_不可为空_转出姓名;
  }

  public void setTsoaccname_不可为空_转出姓名(String tsoaccname_不可为空_转出姓名) {
    this.tsoaccname_不可为空_转出姓名 = tsoaccname_不可为空_转出姓名;
  }

  public String getTsiaccname_不可为空_转入姓名() {
    return tsiaccname_不可为空_转入姓名;
  }

  public void setTsiaccname_不可为空_转入姓名(String tsiaccname_不可为空_转入姓名) {
    this.tsiaccname_不可为空_转入姓名 = tsiaccname_不可为空_转入姓名;
  }

  public String getMergicustid_可为空_并入个人客户号() {
    return mergicustid_可为空_并入个人客户号;
  }

  public void setMergicustid_可为空_并入个人客户号(String mergicustid_可为空_并入个人客户号) {
    this.mergicustid_可为空_并入个人客户号 = mergicustid_可为空_并入个人客户号;
  }

  public String getMergocustid_可为空_并出个人客户号() {
    return mergocustid_可为空_并出个人客户号;
  }

  public void setMergocustid_可为空_并出个人客户号(String mergocustid_可为空_并出个人客户号) {
    this.mergocustid_可为空_并出个人客户号 = mergocustid_可为空_并出个人客户号;
  }

  public String getTrsreason_不可为空_转移原因() {
    return trsreason_不可为空_转移原因;
  }

  public void setTrsreason_不可为空_转移原因(String trsreason_不可为空_转移原因) {
    this.trsreason_不可为空_转移原因 = trsreason_不可为空_转移原因;
  }

  public double getTrsamt_不可为空_转移金额() {
    return trsamt_不可为空_转移金额;
  }

  public void setTrsamt_不可为空_转移金额(double trsamt_不可为空_转移金额) {
    this.trsamt_不可为空_转移金额 = trsamt_不可为空_转移金额;
  }

  public double getTrsintamt_不可为空_转移时结息金额() {
    return trsintamt_不可为空_转移时结息金额;
  }

  public void setTrsintamt_不可为空_转移时结息金额(double trsintamt_不可为空_转移时结息金额) {
    this.trsintamt_不可为空_转移时结息金额 = trsintamt_不可为空_转移时结息金额;
  }

  public String getIndilpaym_不可为空_个人缴至年月() {
    return indilpaym_不可为空_个人缴至年月;
  }

  public void setIndilpaym_不可为空_个人缴至年月(String indilpaym_不可为空_个人缴至年月) {
    this.indilpaym_不可为空_个人缴至年月 = indilpaym_不可为空_个人缴至年月;
  }

  public String getTrstype_不可为空_转移类型() {
    return trstype_不可为空_转移类型;
  }

  public void setTrstype_不可为空_转移类型(String trstype_不可为空_转移类型) {
    this.trstype_不可为空_转移类型 = trstype_不可为空_转移类型;
  }

  public long getHostsernum_不可为空_主机流水号() {
    return hostsernum_不可为空_主机流水号;
  }

  public void setHostsernum_不可为空_主机流水号(long hostsernum_不可为空_主机流水号) {
    this.hostsernum_不可为空_主机流水号 = hostsernum_不可为空_主机流水号;
  }

  public String getTranstype_不可为空_交易类型() {
    return transtype_不可为空_交易类型;
  }

  public void setTranstype_不可为空_交易类型(String transtype_不可为空_交易类型) {
    this.transtype_不可为空_交易类型 = transtype_不可为空_交易类型;
  }

  public String getAgentinstcode_不可为空_经办机构__因在转出管理部操作__所以与下同__() {
    return agentinstcode_不可为空_经办机构__因在转出管理部操作__所以与下同__;
  }

  public void setAgentinstcode_不可为空_经办机构__因在转出管理部操作__所以与下同__(String agentinstcode_不可为空_经办机构__因在转出管理部操作__所以与下同__) {
    this.agentinstcode_不可为空_经办机构__因在转出管理部操作__所以与下同__ = agentinstcode_不可为空_经办机构__因在转出管理部操作__所以与下同__;
  }

  public String getAccinstcode_不可为空___原__账户机构() {
    return accinstcode_不可为空___原__账户机构;
  }

  public void setAccinstcode_不可为空___原__账户机构(String accinstcode_不可为空___原__账户机构) {
    this.accinstcode_不可为空___原__账户机构 = accinstcode_不可为空___原__账户机构;
  }

  public String getAgentbankcode_不可为空_经办银行() {
    return agentbankcode_不可为空_经办银行;
  }

  public void setAgentbankcode_不可为空_经办银行(String agentbankcode_不可为空_经办银行) {
    this.agentbankcode_不可为空_经办银行 = agentbankcode_不可为空_经办银行;
  }

  public String getAccbankcode_不可为空_账户银行() {
    return accbankcode_不可为空_账户银行;
  }

  public void setAccbankcode_不可为空_账户银行(String accbankcode_不可为空_账户银行) {
    this.accbankcode_不可为空_账户银行 = accbankcode_不可为空_账户银行;
  }

  public String getAgentop_不可为空_经办柜员() {
    return agentop_不可为空_经办柜员;
  }

  public void setAgentop_不可为空_经办柜员(String agentop_不可为空_经办柜员) {
    this.agentop_不可为空_经办柜员 = agentop_不可为空_经办柜员;
  }

  public String getCenterid_不可为空_城市中心代码() {
    return centerid_不可为空_城市中心代码;
  }

  public void setCenterid_不可为空_城市中心代码(String centerid_不可为空_城市中心代码) {
    this.centerid_不可为空_城市中心代码 = centerid_不可为空_城市中心代码;
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

  public Date getFreeuse3_可为空_备用字符() {
    return freeuse3_可为空_备用字符;
  }

  public void setFreeuse3_可为空_备用字符(Date freeuse3_可为空_备用字符) {
    this.freeuse3_可为空_备用字符 = freeuse3_可为空_备用字符;
  }

  public long getFreeuse4_可为空_备用金额() {
    return freeuse4_可为空_备用金额;
  }

  public void setFreeuse4_可为空_备用金额(long freeuse4_可为空_备用金额) {
    this.freeuse4_可为空_备用金额 = freeuse4_可为空_备用金额;
  }
}
