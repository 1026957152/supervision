package org.ylgjj.loan.domain;


import javax.persistence.*;

@IdClass(FN022_key.class)
@Entity
@Table(name = "FN022")
public class Fn022_会计凭证流水 {

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
  private java.sql.Date transdate_TRANSDATE_不可为空_交易日期;//
  @Column(name = "hostsernum")
  private long hostsernum_HOSTSERNUM_不可为空_主机流水号;//
  @Column(name = "jrnseqno")
  private long jrnseqno_JRNSEQNO_不可为空_流水序号;//
  @Column(name = "subcode")
  private String subcode_SUBCODE_不可为空_科目控制字;//
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




}
