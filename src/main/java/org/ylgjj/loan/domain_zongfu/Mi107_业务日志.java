package org.ylgjj.loan.domain_zongfu;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "MI107")
@Entity
public class Mi107_业务日志 {


  @Id
  private long seqno;
  private String centerid;
  private String useridtype;
  private String userid;
  private String channeltype;
  private String transdate;
  private String transtype;
  private String transname;
  private String versionno;
  private String devtype;
  private String devid;
  private String requesttime;
  private String responsetime;
  private long secondsafter;
  private String validflag;
  private java.sql.Date datemodified;
  private String transtime;
  private double money;
  private String appid;
  private String pid;
  private String usertype;
  private String ipaddress;
  private String macaddress;
  private String serverip;
  private String serverport;
  private String runstatus;
  private String runmessage;
  private String requrl;
  private String freeuse1;
  private String freeuse2;
  private String freeuse3;
  private long freeuse4;


  public long getSeqno() {
    return seqno;
  }

  public void setSeqno(long seqno) {
    this.seqno = seqno;
  }


  public String getCenterid() {
    return centerid;
  }

  public void setCenterid(String centerid) {
    this.centerid = centerid;
  }


  public String getUseridtype() {
    return useridtype;
  }

  public void setUseridtype(String useridtype) {
    this.useridtype = useridtype;
  }


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }


  public String getChanneltype() {
    return channeltype;
  }

  public void setChanneltype(String channeltype) {
    this.channeltype = channeltype;
  }


  public String getTransdate() {
    return transdate;
  }

  public void setTransdate(String transdate) {
    this.transdate = transdate;
  }


  public String getTranstype() {
    return transtype;
  }

  public void setTranstype(String transtype) {
    this.transtype = transtype;
  }


  public String getTransname() {
    return transname;
  }

  public void setTransname(String transname) {
    this.transname = transname;
  }


  public String getVersionno() {
    return versionno;
  }

  public void setVersionno(String versionno) {
    this.versionno = versionno;
  }


  public String getDevtype() {
    return devtype;
  }

  public void setDevtype(String devtype) {
    this.devtype = devtype;
  }


  public String getDevid() {
    return devid;
  }

  public void setDevid(String devid) {
    this.devid = devid;
  }


  public String getRequesttime() {
    return requesttime;
  }

  public void setRequesttime(String requesttime) {
    this.requesttime = requesttime;
  }


  public String getResponsetime() {
    return responsetime;
  }

  public void setResponsetime(String responsetime) {
    this.responsetime = responsetime;
  }


  public long getSecondsafter() {
    return secondsafter;
  }

  public void setSecondsafter(long secondsafter) {
    this.secondsafter = secondsafter;
  }


  public String getValidflag() {
    return validflag;
  }

  public void setValidflag(String validflag) {
    this.validflag = validflag;
  }


  public java.sql.Date getDatemodified() {
    return datemodified;
  }

  public void setDatemodified(java.sql.Date datemodified) {
    this.datemodified = datemodified;
  }


  public String getTranstime() {
    return transtime;
  }

  public void setTranstime(String transtime) {
    this.transtime = transtime;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public String getUsertype() {
    return usertype;
  }

  public void setUsertype(String usertype) {
    this.usertype = usertype;
  }


  public String getIpaddress() {
    return ipaddress;
  }

  public void setIpaddress(String ipaddress) {
    this.ipaddress = ipaddress;
  }


  public String getMacaddress() {
    return macaddress;
  }

  public void setMacaddress(String macaddress) {
    this.macaddress = macaddress;
  }


  public String getServerip() {
    return serverip;
  }

  public void setServerip(String serverip) {
    this.serverip = serverip;
  }


  public String getServerport() {
    return serverport;
  }

  public void setServerport(String serverport) {
    this.serverport = serverport;
  }


  public String getRunstatus() {
    return runstatus;
  }

  public void setRunstatus(String runstatus) {
    this.runstatus = runstatus;
  }


  public String getRunmessage() {
    return runmessage;
  }

  public void setRunmessage(String runmessage) {
    this.runmessage = runmessage;
  }


  public String getRequrl() {
    return requrl;
  }

  public void setRequrl(String requrl) {
    this.requrl = requrl;
  }


  public String getFreeuse1() {
    return freeuse1;
  }

  public void setFreeuse1(String freeuse1) {
    this.freeuse1 = freeuse1;
  }


  public String getFreeuse2() {
    return freeuse2;
  }

  public void setFreeuse2(String freeuse2) {
    this.freeuse2 = freeuse2;
  }


  public String getFreeuse3() {
    return freeuse3;
  }

  public void setFreeuse3(String freeuse3) {
    this.freeuse3 = freeuse3;
  }


  public long getFreeuse4() {
    return freeuse4;
  }

  public void setFreeuse4(long freeuse4) {
    this.freeuse4 = freeuse4;
  }

}
