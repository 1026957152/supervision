package org.ylgjj.loan.domain_zongfu;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "MI029")
@Entity
public class Mi029_综合服务个人用户基础信息表 {

  @Id
  private String personalid;
  private String centerid;
  private String username;
  private String certinumtype;
  private String certinum;
  private String certinumcustomerid;
  private String email;
  private String tel;
  private String sex;
  private String birth;
  private String uselevel;
  private String vip;
  private String sensitive;
  private String validflag;
  private String datemodified;
  private String datecreated;
  private String freeuse1;
  private String freeuse2;
  private String freeuse3;
 // private long freeuse4;


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


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getCertinumtype() {
    return certinumtype;
  }

  public void setCertinumtype(String certinumtype) {
    this.certinumtype = certinumtype;
  }


  public String getCertinum() {
    return certinum;
  }

  public void setCertinum(String certinum) {
    this.certinum = certinum;
  }


  public String getCertinumcustomerid() {
    return certinumcustomerid;
  }

  public void setCertinumcustomerid(String certinumcustomerid) {
    this.certinumcustomerid = certinumcustomerid;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }


  public String getUselevel() {
    return uselevel;
  }

  public void setUselevel(String uselevel) {
    this.uselevel = uselevel;
  }


  public String getVip() {
    return vip;
  }

  public void setVip(String vip) {
    this.vip = vip;
  }


  public String getSensitive() {
    return sensitive;
  }

  public void setSensitive(String sensitive) {
    this.sensitive = sensitive;
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



}
