package org.ylgjj.loan.domain_sms;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Sms_Sm_Sendmsg_History")
@Entity
public class SmsSmSendmsgHistory {
  @Id
  private String smsid;
  private String mobilephone;
  private String contcode;
  private String battchid;
  private String smid;
  private String smstype;
  private String smscode;
  private String smsclass;
  private String smstime;
  private String opinstcode;
  private String oprcode;
  private String opdate;
  private String sendmsg;
  private String delaytime;
  private String instcode;
  private String insttime;
  private String miseqno;
  private String msgid;
  private String sendversion;
  private String province;
  private String smsgrouptype;
  private String smsshortid;
  private String errorcode;
  private String errormsg;
  private String sendyyscode;
  private long smscount;
  private String smscontent;
  private long transtimes;
  private String modelid;
  private String yyssmsid;
  private String resultcode;
  private String billingcode;


  public String getSmsid() {
    return smsid;
  }

  public void setSmsid(String smsid) {
    this.smsid = smsid;
  }


  public String getMobilephone() {
    return mobilephone;
  }

  public void setMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
  }


  public String getContcode() {
    return contcode;
  }

  public void setContcode(String contcode) {
    this.contcode = contcode;
  }


  public String getBattchid() {
    return battchid;
  }

  public void setBattchid(String battchid) {
    this.battchid = battchid;
  }


  public String getSmid() {
    return smid;
  }

  public void setSmid(String smid) {
    this.smid = smid;
  }


  public String getSmstype() {
    return smstype;
  }

  public void setSmstype(String smstype) {
    this.smstype = smstype;
  }


  public String getSmscode() {
    return smscode;
  }

  public void setSmscode(String smscode) {
    this.smscode = smscode;
  }


  public String getSmsclass() {
    return smsclass;
  }

  public void setSmsclass(String smsclass) {
    this.smsclass = smsclass;
  }


  public String getSmstime() {
    return smstime;
  }

  public void setSmstime(String smstime) {
    this.smstime = smstime;
  }


  public String getOpinstcode() {
    return opinstcode;
  }

  public void setOpinstcode(String opinstcode) {
    this.opinstcode = opinstcode;
  }


  public String getOprcode() {
    return oprcode;
  }

  public void setOprcode(String oprcode) {
    this.oprcode = oprcode;
  }


  public String getOpdate() {
    return opdate;
  }

  public void setOpdate(String opdate) {
    this.opdate = opdate;
  }


  public String getSendmsg() {
    return sendmsg;
  }

  public void setSendmsg(String sendmsg) {
    this.sendmsg = sendmsg;
  }


  public String getDelaytime() {
    return delaytime;
  }

  public void setDelaytime(String delaytime) {
    this.delaytime = delaytime;
  }


  public String getInstcode() {
    return instcode;
  }

  public void setInstcode(String instcode) {
    this.instcode = instcode;
  }


  public String getInsttime() {
    return insttime;
  }

  public void setInsttime(String insttime) {
    this.insttime = insttime;
  }


  public String getMiseqno() {
    return miseqno;
  }

  public void setMiseqno(String miseqno) {
    this.miseqno = miseqno;
  }


  public String getMsgid() {
    return msgid;
  }

  public void setMsgid(String msgid) {
    this.msgid = msgid;
  }


  public String getSendversion() {
    return sendversion;
  }

  public void setSendversion(String sendversion) {
    this.sendversion = sendversion;
  }


  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }


  public String getSmsgrouptype() {
    return smsgrouptype;
  }

  public void setSmsgrouptype(String smsgrouptype) {
    this.smsgrouptype = smsgrouptype;
  }


  public String getSmsshortid() {
    return smsshortid;
  }

  public void setSmsshortid(String smsshortid) {
    this.smsshortid = smsshortid;
  }


  public String getErrorcode() {
    return errorcode;
  }

  public void setErrorcode(String errorcode) {
    this.errorcode = errorcode;
  }


  public String getErrormsg() {
    return errormsg;
  }

  public void setErrormsg(String errormsg) {
    this.errormsg = errormsg;
  }


  public String getSendyyscode() {
    return sendyyscode;
  }

  public void setSendyyscode(String sendyyscode) {
    this.sendyyscode = sendyyscode;
  }


  public long getSmscount() {
    return smscount;
  }

  public void setSmscount(long smscount) {
    this.smscount = smscount;
  }


  public String getSmscontent() {
    return smscontent;
  }

  public void setSmscontent(String smscontent) {
    this.smscontent = smscontent;
  }


  public long getTranstimes() {
    return transtimes;
  }

  public void setTranstimes(long transtimes) {
    this.transtimes = transtimes;
  }


  public String getModelid() {
    return modelid;
  }

  public void setModelid(String modelid) {
    this.modelid = modelid;
  }


  public String getYyssmsid() {
    return yyssmsid;
  }

  public void setYyssmsid(String yyssmsid) {
    this.yyssmsid = yyssmsid;
  }


  public String getResultcode() {
    return resultcode;
  }

  public void setResultcode(String resultcode) {
    this.resultcode = resultcode;
  }


  public String getBillingcode() {
    return billingcode;
  }

  public void setBillingcode(String billingcode) {
    this.billingcode = billingcode;
  }

}
