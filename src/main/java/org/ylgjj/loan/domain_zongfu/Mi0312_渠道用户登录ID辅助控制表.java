package org.ylgjj.loan.domain_zongfu;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Mi0312")
@Entity
public class Mi0312_渠道用户登录ID辅助控制表 {

  @Id
  private String id;
  private String personalid;
  private String centerid;
  private String channel;
  private String pid;
  private String useridtype;
  private String userid;
  private String sendmessage;
  private String nickname;
  private String status;
  private String validflag;
  private String datemodified;
  private String datecreated;
  private String freeuse1;
  private String freeuse2;
  private String freeuse3;
  private long freeuse4;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getPersonalid() {
    return personalid;
  }

  public void setPersonalid(String personalid) {
    this.personalid = personalid;
  }


  public String getCenterid() {
    return centerid;
  }

  public void setCenterid(String centerid) {
    this.centerid = centerid;
  }


  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
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


  public String getSendmessage() {
    return sendmessage;
  }

  public void setSendmessage(String sendmessage) {
    this.sendmessage = sendmessage;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getValidflag() {
    return validflag;
  }

  public void setValidflag(String validflag) {
    this.validflag = validflag;
  }


  public String getDatemodified() {
    return datemodified;
  }

  public void setDatemodified(String datemodified) {
    this.datemodified = datemodified;
  }


  public String getDatecreated() {
    return datecreated;
  }

  public void setDatecreated(String datecreated) {
    this.datecreated = datecreated;
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
