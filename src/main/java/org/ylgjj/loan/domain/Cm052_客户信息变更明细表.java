package org.ylgjj.loan.domain;
import org.ylgjj.loan.domain.AN001_key;

import javax.persistence.*;


@Entity
@Table(name = "Cm052")
public class Cm052_客户信息变更明细表 {

  @Id
  @Column(name = "apprnum")
  private String apprnum_apprnum_不可为空_审批号;//"CM051.APPNUM
  //CM053.APPNUM
  //CM054.APPNUM"
  @Column(name = "pubcustid")
  private String pubcustid_pubcustid_可为空_通用客户号;//单位、个人资料变更有效


  @Column(name = "tabname")
  private String tabname_tabname_不可为空_表名;//

  @Column(name = "fieldname")
  private String fieldname_fieldname_不可为空_字段名;//

  @Column(name = "settletranscode")
  private String bfchgval_bfchgval_可为空_修改前值;//

  @Column(name = "afchgval")
  private String afchgval_afchgval_可为空_修改后值;//

  @Column(name = "transchannel")
  private String transchannel_transchannel_不可为空_交易渠道;//

  @Column(name = "centerid")
  private String centerid_centerid_不可为空_城市中心代码;//

  @Column(name = "freeuse1")
  private String freeuse1_freeuse1_可为空_备用字符;//

  @Column(name = "freeuse2")
  private double freeuse2_freeuse2_可为空_备用金额;//

  @Column(name = "freeuse3")
  private java.sql.Date freeuse3_freeuse3_可为空_备用日期;//
  @Column(name = "freeuse4")
  private long freeuse4_freeuse4_可为空_备用数值;//



}
