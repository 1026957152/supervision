package org.ylgjj.loan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name = " Cm051")
public class Cm051_客户信息变更登记薄 {

  @Id
  @Column(name = "apprnum")
  private String apprnum_不可为空_审批号;//

  @Column(name = "transdate")
  private java.sql.Date transdate_不可为空_交易日期;//
  @Column(name = "hostsernum")
  private long hostsernum_不可为空_主机流水号;//

  @Column(name = "pubcustid")
  private String pubcustid_可为空_通用客户号;//		客户变更类型为1,2时有效
  @Column(name = "custchgtype")
  private String custchgtype_不可为空_客户变更类型;//	"1-单位,2-个人"

  @Column(name = "agentinstcode")
  private String agentinstcode_可为空_经办机构;//		登记渠道=1时非空

  @Column(name = "agentop")
  private String agentop_不可为空_经办柜员;//

  @Column(name = "chkop")
  private String chkop_可为空_复核柜员;//
  @Column(name = "approveop")
  private String approveop_可为空_审批柜员;//
  @Column(name = "machinetime")
  private String machinetime_不可为空_机器时间;//

  @Column(name = "apprstate")
  private String apprstate_不可为空_审批状态;//	"1-已初审,2-已复核,3-已审批,7-已完成,8-已冲销,9-已撤消"

  @Column(name = "transchannel")
  private String transchannel_不可为空_交易渠道;//

  @Column(name = "centerid")
  private String centerid_不可为空_城市中心代码;//
  @Column(name = "freeuse1")
  private String freeuse1_可为空_备用字符;//

  @Column(name = "freeuse2")
  private double freeuse2_可为空_备用金额;//

  @Column(name = "freeuse3")
  private java.sql.Date freeuse3_可为空_备用日期;//

  @Column(name = "freeuse4")
  private long freeuse4_可为空_备用数值;//

  @Column(name = "apprreason")
  private String apprreason_可为空_审批原因;//


  public String getApprnum_不可为空_审批号() {
    return apprnum_不可为空_审批号;
  }

  public void setApprnum_不可为空_审批号(String apprnum_不可为空_审批号) {
    this.apprnum_不可为空_审批号 = apprnum_不可为空_审批号;
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

  public String getPubcustid_可为空_通用客户号() {
    return pubcustid_可为空_通用客户号;
  }

  public void setPubcustid_可为空_通用客户号(String pubcustid_可为空_通用客户号) {
    this.pubcustid_可为空_通用客户号 = pubcustid_可为空_通用客户号;
  }

  public String getCustchgtype_不可为空_客户变更类型() {
    return custchgtype_不可为空_客户变更类型;
  }

  public void setCustchgtype_不可为空_客户变更类型(String custchgtype_不可为空_客户变更类型) {
    this.custchgtype_不可为空_客户变更类型 = custchgtype_不可为空_客户变更类型;
  }

  public String getAgentinstcode_可为空_经办机构() {
    return agentinstcode_可为空_经办机构;
  }

  public void setAgentinstcode_可为空_经办机构(String agentinstcode_可为空_经办机构) {
    this.agentinstcode_可为空_经办机构 = agentinstcode_可为空_经办机构;
  }

  public String getAgentop_不可为空_经办柜员() {
    return agentop_不可为空_经办柜员;
  }

  public void setAgentop_不可为空_经办柜员(String agentop_不可为空_经办柜员) {
    this.agentop_不可为空_经办柜员 = agentop_不可为空_经办柜员;
  }

  public String getChkop_可为空_复核柜员() {
    return chkop_可为空_复核柜员;
  }

  public void setChkop_可为空_复核柜员(String chkop_可为空_复核柜员) {
    this.chkop_可为空_复核柜员 = chkop_可为空_复核柜员;
  }

  public String getApproveop_可为空_审批柜员() {
    return approveop_可为空_审批柜员;
  }

  public void setApproveop_可为空_审批柜员(String approveop_可为空_审批柜员) {
    this.approveop_可为空_审批柜员 = approveop_可为空_审批柜员;
  }

  public String getMachinetime_不可为空_机器时间() {
    return machinetime_不可为空_机器时间;
  }

  public void setMachinetime_不可为空_机器时间(String machinetime_不可为空_机器时间) {
    this.machinetime_不可为空_机器时间 = machinetime_不可为空_机器时间;
  }

  public String getApprstate_不可为空_审批状态() {
    return apprstate_不可为空_审批状态;
  }

  public void setApprstate_不可为空_审批状态(String apprstate_不可为空_审批状态) {
    this.apprstate_不可为空_审批状态 = apprstate_不可为空_审批状态;
  }

  public String getTranschannel_不可为空_交易渠道() {
    return transchannel_不可为空_交易渠道;
  }

  public void setTranschannel_不可为空_交易渠道(String transchannel_不可为空_交易渠道) {
    this.transchannel_不可为空_交易渠道 = transchannel_不可为空_交易渠道;
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

  public String getApprreason_可为空_审批原因() {
    return apprreason_可为空_审批原因;
  }

  public void setApprreason_可为空_审批原因(String apprreason_可为空_审批原因) {
    this.apprreason_可为空_审批原因 = apprreason_可为空_审批原因;
  }
}
