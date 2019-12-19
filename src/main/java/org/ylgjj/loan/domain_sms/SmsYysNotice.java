package org.ylgjj.loan.domain_sms;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Sms_YYS_NOTICE")
@Entity
public class SmsYysNotice {

  private long sumrecord;
  private long successnum;
  private long failnum;
  private String yyscode;
  private String yysname;
  private String smid;
  private String inserttime;

  @Id
  private String yysnoticeid;
  private String statisticdate;
  private String ext;
  private String instcode;
  private long sendfailnum;
  private long nosendfailnum;
  private long jfsuccessnum;


  public long getSumrecord() {
    return sumrecord;
  }

  public void setSumrecord(long sumrecord) {
    this.sumrecord = sumrecord;
  }


  public long getSuccessnum() {
    return successnum;
  }

  public void setSuccessnum(long successnum) {
    this.successnum = successnum;
  }


  public long getFailnum() {
    return failnum;
  }

  public void setFailnum(long failnum) {
    this.failnum = failnum;
  }


  public String getYyscode() {
    return yyscode;
  }

  public void setYyscode(String yyscode) {
    this.yyscode = yyscode;
  }


  public String getYysname() {
    return yysname;
  }

  public void setYysname(String yysname) {
    this.yysname = yysname;
  }


  public String getSmid() {
    return smid;
  }

  public void setSmid(String smid) {
    this.smid = smid;
  }


  public String getInserttime() {
    return inserttime;
  }

  public void setInserttime(String inserttime) {
    this.inserttime = inserttime;
  }


  public String getYysnoticeid() {
    return yysnoticeid;
  }

  public void setYysnoticeid(String yysnoticeid) {
    this.yysnoticeid = yysnoticeid;
  }


  public String getStatisticdate() {
    return statisticdate;
  }

  public void setStatisticdate(String statisticdate) {
    this.statisticdate = statisticdate;
  }


  public String getExt() {
    return ext;
  }

  public void setExt(String ext) {
    this.ext = ext;
  }


  public String getInstcode() {
    return instcode;
  }

  public void setInstcode(String instcode) {
    this.instcode = instcode;
  }


  public long getSendfailnum() {
    return sendfailnum;
  }

  public void setSendfailnum(long sendfailnum) {
    this.sendfailnum = sendfailnum;
  }


  public long getNosendfailnum() {
    return nosendfailnum;
  }

  public void setNosendfailnum(long nosendfailnum) {
    this.nosendfailnum = nosendfailnum;
  }


  public long getJfsuccessnum() {
    return jfsuccessnum;
  }

  public void setJfsuccessnum(long jfsuccessnum) {
    this.jfsuccessnum = jfsuccessnum;
  }

}
