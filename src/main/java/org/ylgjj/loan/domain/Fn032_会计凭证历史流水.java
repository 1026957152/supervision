package org.ylgjj.loan.domain;


import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@IdClass(FN032_key.class)
@Entity
@Table(name = "Fn032")
public class Fn032_会计凭证历史流水 {


  @Id
  @Column(name = "accsetid")
  private String accsetid_ACCSETID_不可为空_账套标识;//
  @Id
  @Column(name = "accvoudate")
  private java.sql.Date accvoudate_ACCVOUDATE_不可为空_会计凭证日期;//
  @Id
  @Column(name = "instcode")
  private String instcode_INSTCODE_不可为空_机构代码;//
  @Id
  @Column(name = "accvoucode")
  private String accvoucode_ACCVOUCODE_不可为空_会计凭证编码;//		凭证ID
  @Id
  @Column(name = "accvouseqno")
  private long accvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号;//




  @Column(name = "entrytranscode")
  private String entrytranscode_ENTRYTRANSCODE_不可为空_分录交易码;//
  @Column(name = "entryitemseqno")
  private long entryitemseqno_ENTRYITEMSEQNO_不可为空_分录项序号;//
  @Column(name = "transdate")
  private LocalDate transdate不可为空交易日期;//
  @Column(name = "hostsernum")
  private long hostsernum_HOSTSERNUM_不可为空_主机流水号;//
  @Column(name = "jrnseqno")
  private long jrnseqno_JRNSEQNO_不可为空_流水序号;//
  @Column(name = "subcode")
  private String subcode不可为空科目控制字;//
  @Column(name = "dcflag")
  private String dcflag_DCFLAG_不可为空_借贷标志;//	1-借,2-贷
  @Column(name = "damt")
  private double damt_DAMT_不可为空_借方发生额;//
  @Column(name = "camt")
  private double camt_CAMT_不可为空_贷方发生额;//
  @Column(name = "summarycode")
  private String summarycode_SUMMARYCODE_不可为空_摘要码;//
  @Column(name = "accvousummary")
  private String accvousummary_ACCVOUSUMMARY_不可为空_会计凭证摘要;//
  @Column(name = "accvoustate")
  private String accvoustate_ACCVOUSTATE_不可为空_会计凭证状态;//	0-正常,7-冲账,8-被冲,9-无效
  @Column(name = "corraccvoucode")
  private String corraccvoucode_CORRACCVOUCODE_可为空_被冲正会计凭证编码;//
  @Column(name = "accvouchkflag")
  private String accvouchkflag_ACCVOUCHKFLAG_不可为空_会计凭证审核标志;//	0-未审核,1-已审核
  @Column(name = "timestamp")
  private String timestamp_TIMESTAMP_不可为空_时间戳;//
  @Column(name = "attachsheets")
  private long attachsheets_ATTACHSHEETS_可为空_附件张数;//
  @Column(name = "accvounum")
  private String accvounum_ACCVOUNUM_可为空_会计凭证号;//
  @Column(name = "accvoudes")
  private String accvoudes_ACCVOUDES_可为空_会计凭证描述;//
  @Column(name = "agentinstcode")
  private String agentinstcode_AGENTINSTCODE_可为空_经办机构;//
  @Column(name = "agentop")
  private String agentop_AGENTOP_可为空_经办柜员;//
  @Column(name = "inputop")
  private String inputop_INPUTOP_可为空_录入柜员;//		制单
  @Column(name = "chkop")
  private String chkop_CHKOP_可为空_复核柜员;//		复核
  @Column(name = "approveop")
  private String approveop_APPROVEOP_可为空_审批柜员;//		审核
  @Column(name = "authop")
  private String authop_AUTHOP_可为空_授权柜员;//		授权
  @Column(name = "settleop")
  private String settleop_SETTLEOP_可为空_结算柜员;//		记账
  @Column(name = "accbankcode")
  private String accbankcode;
  @Column(name = "agentbankcode")
  private String agentbankcode;
  @Column(name = "freeuse1")
  private String freeuse1_FREEUSE1_可为空_备用字符;
  @Column(name = "freeuse2")
  private double freeuse2_FREEUSE2_可为空_备用金额;
  @Column(name = "freeuse3")
  private java.sql.Date freeuse3_FREEUSE3_可为空_备用日期;
  @Column(name = "freeuse4")
  private long freeuse4_FREEUSE4_可为空_备用数值;

  public String getAccsetid_ACCSETID_不可为空_账套标识() {
    return accsetid_ACCSETID_不可为空_账套标识;
  }

  public void setAccsetid_ACCSETID_不可为空_账套标识(String accsetid_ACCSETID_不可为空_账套标识) {
    this.accsetid_ACCSETID_不可为空_账套标识 = accsetid_ACCSETID_不可为空_账套标识;
  }

  public Date getAccvoudate_ACCVOUDATE_不可为空_会计凭证日期() {
    return accvoudate_ACCVOUDATE_不可为空_会计凭证日期;
  }

  public void setAccvoudate_ACCVOUDATE_不可为空_会计凭证日期(Date accvoudate_ACCVOUDATE_不可为空_会计凭证日期) {
    this.accvoudate_ACCVOUDATE_不可为空_会计凭证日期 = accvoudate_ACCVOUDATE_不可为空_会计凭证日期;
  }

  public String getInstcode_INSTCODE_不可为空_机构代码() {
    return instcode_INSTCODE_不可为空_机构代码;
  }

  public void setInstcode_INSTCODE_不可为空_机构代码(String instcode_INSTCODE_不可为空_机构代码) {
    this.instcode_INSTCODE_不可为空_机构代码 = instcode_INSTCODE_不可为空_机构代码;
  }

  public String getAccvoucode_ACCVOUCODE_不可为空_会计凭证编码() {
    return accvoucode_ACCVOUCODE_不可为空_会计凭证编码;
  }

  public void setAccvoucode_ACCVOUCODE_不可为空_会计凭证编码(String accvoucode_ACCVOUCODE_不可为空_会计凭证编码) {
    this.accvoucode_ACCVOUCODE_不可为空_会计凭证编码 = accvoucode_ACCVOUCODE_不可为空_会计凭证编码;
  }

  public long getAccvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号() {
    return accvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号;
  }

  public void setAccvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号(long accvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号) {
    this.accvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号 = accvouseqno_ACCVOUSEQNO_不可为空_会计凭证序号;
  }

  public String getEntrytranscode_ENTRYTRANSCODE_不可为空_分录交易码() {
    return entrytranscode_ENTRYTRANSCODE_不可为空_分录交易码;
  }

  public void setEntrytranscode_ENTRYTRANSCODE_不可为空_分录交易码(String entrytranscode_ENTRYTRANSCODE_不可为空_分录交易码) {
    this.entrytranscode_ENTRYTRANSCODE_不可为空_分录交易码 = entrytranscode_ENTRYTRANSCODE_不可为空_分录交易码;
  }

  public long getEntryitemseqno_ENTRYITEMSEQNO_不可为空_分录项序号() {
    return entryitemseqno_ENTRYITEMSEQNO_不可为空_分录项序号;
  }

  public void setEntryitemseqno_ENTRYITEMSEQNO_不可为空_分录项序号(long entryitemseqno_ENTRYITEMSEQNO_不可为空_分录项序号) {
    this.entryitemseqno_ENTRYITEMSEQNO_不可为空_分录项序号 = entryitemseqno_ENTRYITEMSEQNO_不可为空_分录项序号;
  }

  public LocalDate getTransdate不可为空交易日期() {
    return transdate不可为空交易日期;
  }

  public void setTransdate不可为空交易日期(LocalDate transdate不可为空交易日期) {
    this.transdate不可为空交易日期 = transdate不可为空交易日期;
  }

  public long getHostsernum_HOSTSERNUM_不可为空_主机流水号() {
    return hostsernum_HOSTSERNUM_不可为空_主机流水号;
  }

  public void setHostsernum_HOSTSERNUM_不可为空_主机流水号(long hostsernum_HOSTSERNUM_不可为空_主机流水号) {
    this.hostsernum_HOSTSERNUM_不可为空_主机流水号 = hostsernum_HOSTSERNUM_不可为空_主机流水号;
  }

  public long getJrnseqno_JRNSEQNO_不可为空_流水序号() {
    return jrnseqno_JRNSEQNO_不可为空_流水序号;
  }

  public void setJrnseqno_JRNSEQNO_不可为空_流水序号(long jrnseqno_JRNSEQNO_不可为空_流水序号) {
    this.jrnseqno_JRNSEQNO_不可为空_流水序号 = jrnseqno_JRNSEQNO_不可为空_流水序号;
  }

  public String getSubcode不可为空科目控制字() {
    return subcode不可为空科目控制字;
  }

  public void setSubcode不可为空科目控制字(String subcode_SUBCODE_不可为空_科目控制字) {
    this.subcode不可为空科目控制字 = subcode_SUBCODE_不可为空_科目控制字;
  }

  public String getDcflag_DCFLAG_不可为空_借贷标志() {
    return dcflag_DCFLAG_不可为空_借贷标志;
  }

  public void setDcflag_DCFLAG_不可为空_借贷标志(String dcflag_DCFLAG_不可为空_借贷标志) {
    this.dcflag_DCFLAG_不可为空_借贷标志 = dcflag_DCFLAG_不可为空_借贷标志;
  }

  public double getDamt_DAMT_不可为空_借方发生额() {
    return damt_DAMT_不可为空_借方发生额;
  }

  public void setDamt_DAMT_不可为空_借方发生额(double damt_DAMT_不可为空_借方发生额) {
    this.damt_DAMT_不可为空_借方发生额 = damt_DAMT_不可为空_借方发生额;
  }

  public double getCamt_CAMT_不可为空_贷方发生额() {
    return camt_CAMT_不可为空_贷方发生额;
  }

  public void setCamt_CAMT_不可为空_贷方发生额(double camt_CAMT_不可为空_贷方发生额) {
    this.camt_CAMT_不可为空_贷方发生额 = camt_CAMT_不可为空_贷方发生额;
  }

  public String getSummarycode_SUMMARYCODE_不可为空_摘要码() {
    return summarycode_SUMMARYCODE_不可为空_摘要码;
  }

  public void setSummarycode_SUMMARYCODE_不可为空_摘要码(String summarycode_SUMMARYCODE_不可为空_摘要码) {
    this.summarycode_SUMMARYCODE_不可为空_摘要码 = summarycode_SUMMARYCODE_不可为空_摘要码;
  }

  public String getAccvousummary_ACCVOUSUMMARY_不可为空_会计凭证摘要() {
    return accvousummary_ACCVOUSUMMARY_不可为空_会计凭证摘要;
  }

  public void setAccvousummary_ACCVOUSUMMARY_不可为空_会计凭证摘要(String accvousummary_ACCVOUSUMMARY_不可为空_会计凭证摘要) {
    this.accvousummary_ACCVOUSUMMARY_不可为空_会计凭证摘要 = accvousummary_ACCVOUSUMMARY_不可为空_会计凭证摘要;
  }

  public String getAccvoustate_ACCVOUSTATE_不可为空_会计凭证状态() {
    return accvoustate_ACCVOUSTATE_不可为空_会计凭证状态;
  }

  public void setAccvoustate_ACCVOUSTATE_不可为空_会计凭证状态(String accvoustate_ACCVOUSTATE_不可为空_会计凭证状态) {
    this.accvoustate_ACCVOUSTATE_不可为空_会计凭证状态 = accvoustate_ACCVOUSTATE_不可为空_会计凭证状态;
  }

  public String getCorraccvoucode_CORRACCVOUCODE_可为空_被冲正会计凭证编码() {
    return corraccvoucode_CORRACCVOUCODE_可为空_被冲正会计凭证编码;
  }

  public void setCorraccvoucode_CORRACCVOUCODE_可为空_被冲正会计凭证编码(String corraccvoucode_CORRACCVOUCODE_可为空_被冲正会计凭证编码) {
    this.corraccvoucode_CORRACCVOUCODE_可为空_被冲正会计凭证编码 = corraccvoucode_CORRACCVOUCODE_可为空_被冲正会计凭证编码;
  }

  public String getAccvouchkflag_ACCVOUCHKFLAG_不可为空_会计凭证审核标志() {
    return accvouchkflag_ACCVOUCHKFLAG_不可为空_会计凭证审核标志;
  }

  public void setAccvouchkflag_ACCVOUCHKFLAG_不可为空_会计凭证审核标志(String accvouchkflag_ACCVOUCHKFLAG_不可为空_会计凭证审核标志) {
    this.accvouchkflag_ACCVOUCHKFLAG_不可为空_会计凭证审核标志 = accvouchkflag_ACCVOUCHKFLAG_不可为空_会计凭证审核标志;
  }

  public String getTimestamp_TIMESTAMP_不可为空_时间戳() {
    return timestamp_TIMESTAMP_不可为空_时间戳;
  }

  public void setTimestamp_TIMESTAMP_不可为空_时间戳(String timestamp_TIMESTAMP_不可为空_时间戳) {
    this.timestamp_TIMESTAMP_不可为空_时间戳 = timestamp_TIMESTAMP_不可为空_时间戳;
  }

  public long getAttachsheets_ATTACHSHEETS_可为空_附件张数() {
    return attachsheets_ATTACHSHEETS_可为空_附件张数;
  }

  public void setAttachsheets_ATTACHSHEETS_可为空_附件张数(long attachsheets_ATTACHSHEETS_可为空_附件张数) {
    this.attachsheets_ATTACHSHEETS_可为空_附件张数 = attachsheets_ATTACHSHEETS_可为空_附件张数;
  }

  public String getAccvounum_ACCVOUNUM_可为空_会计凭证号() {
    return accvounum_ACCVOUNUM_可为空_会计凭证号;
  }

  public void setAccvounum_ACCVOUNUM_可为空_会计凭证号(String accvounum_ACCVOUNUM_可为空_会计凭证号) {
    this.accvounum_ACCVOUNUM_可为空_会计凭证号 = accvounum_ACCVOUNUM_可为空_会计凭证号;
  }

  public String getAccvoudes_ACCVOUDES_可为空_会计凭证描述() {
    return accvoudes_ACCVOUDES_可为空_会计凭证描述;
  }

  public void setAccvoudes_ACCVOUDES_可为空_会计凭证描述(String accvoudes_ACCVOUDES_可为空_会计凭证描述) {
    this.accvoudes_ACCVOUDES_可为空_会计凭证描述 = accvoudes_ACCVOUDES_可为空_会计凭证描述;
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

  public String getInputop_INPUTOP_可为空_录入柜员() {
    return inputop_INPUTOP_可为空_录入柜员;
  }

  public void setInputop_INPUTOP_可为空_录入柜员(String inputop_INPUTOP_可为空_录入柜员) {
    this.inputop_INPUTOP_可为空_录入柜员 = inputop_INPUTOP_可为空_录入柜员;
  }

  public String getChkop_CHKOP_可为空_复核柜员() {
    return chkop_CHKOP_可为空_复核柜员;
  }

  public void setChkop_CHKOP_可为空_复核柜员(String chkop_CHKOP_可为空_复核柜员) {
    this.chkop_CHKOP_可为空_复核柜员 = chkop_CHKOP_可为空_复核柜员;
  }

  public String getApproveop_APPROVEOP_可为空_审批柜员() {
    return approveop_APPROVEOP_可为空_审批柜员;
  }

  public void setApproveop_APPROVEOP_可为空_审批柜员(String approveop_APPROVEOP_可为空_审批柜员) {
    this.approveop_APPROVEOP_可为空_审批柜员 = approveop_APPROVEOP_可为空_审批柜员;
  }

  public String getAuthop_AUTHOP_可为空_授权柜员() {
    return authop_AUTHOP_可为空_授权柜员;
  }

  public void setAuthop_AUTHOP_可为空_授权柜员(String authop_AUTHOP_可为空_授权柜员) {
    this.authop_AUTHOP_可为空_授权柜员 = authop_AUTHOP_可为空_授权柜员;
  }

  public String getSettleop_SETTLEOP_可为空_结算柜员() {
    return settleop_SETTLEOP_可为空_结算柜员;
  }

  public void setSettleop_SETTLEOP_可为空_结算柜员(String settleop_SETTLEOP_可为空_结算柜员) {
    this.settleop_SETTLEOP_可为空_结算柜员 = settleop_SETTLEOP_可为空_结算柜员;
  }

  public String getAccbankcode() {
    return accbankcode;
  }

  public void setAccbankcode(String accbankcode) {
    this.accbankcode = accbankcode;
  }

  public String getAgentbankcode() {
    return agentbankcode;
  }

  public void setAgentbankcode(String agentbankcode) {
    this.agentbankcode = agentbankcode;
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
}
