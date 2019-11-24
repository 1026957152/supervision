package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "CM002")

public class CM002_个人基本资料表 {



    @Id

   @Column(name = "custid")
    private String custid_个人客户号;


    @Column(name = "accname")
    private String accname_个人姓名;


    @Column(name = "sex")
    private String sex_性别;

    @Column(name = "inmspell")
    private String inmspell_个人姓名全拼;



    @Column(name = "zip")
    private String zip;

    @Column(name = "marstatus")
    private String marstatus_婚姻状况;

    @Column(name = "famaddr")
    private String famaddr_家庭住址;

    public String getFamaddr_家庭住址() {
        return famaddr_家庭住址;
    }

    public void setFamaddr_家庭住址(String famaddr_家庭住址) {
        this.famaddr_家庭住址 = famaddr_家庭住址;
    }

    @Column(name = "birthday")
    private String birthday_出生日期;


    @Column(name = "certinum")
    private String certinum;

    @Column(name = "agentinstcode")
    private String agentinstcode_经办机构;


    @Column(name = "opnaccdate")
    private String opnaccdate_开户日期;


    @Column(name = "validflag")
    private String validflag;


    @Column(name = "handset")
    private String handset_手机;

    @Column(name = "phone")
    private String phone_电话;

    @Column(name = "email")
    private String email;
    private String msn;
    private String qq;

    @Column(name = "attworkdate")
    private Date attworkdate;

    @Column(name = "unitaccname")
    private String unitaccname;

    @Column(name = "belongtodept")
    private String belongtodept;

    @Column(name = "workid")
    private String workid;


    public String getHandset_手机() {
        return handset_手机;
    }

    public void setHandset_手机(String handset_手机) {
        this.handset_手机 = handset_手机;
    }

    public String getPhone_电话() {
        return phone_电话;
    }

    public void setPhone_电话(String phone_电话) {
        this.phone_电话 = phone_电话;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getAttworkdate() {
        return attworkdate;
    }

    public void setAttworkdate(Date attworkdate) {
        this.attworkdate = attworkdate;
    }

    public String getUnitaccname() {
        return unitaccname;
    }

    public void setUnitaccname(String unitaccname) {
        this.unitaccname = unitaccname;
    }

    public String getBelongtodept() {
        return belongtodept;
    }

    public void setBelongtodept(String belongtodept) {
        this.belongtodept = belongtodept;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getCustid_个人客户号() {
        return custid_个人客户号;
    }

    public void setCustid_个人客户号(String custid_个人客户号) {
        this.custid_个人客户号 = custid_个人客户号;
    }

    public String getAccname_个人姓名() {
        return accname_个人姓名;
    }

    public void setAccname_个人姓名(String accname_个人姓名) {
        this.accname_个人姓名 = accname_个人姓名;
    }

    public String getSex_性别() {
        if("1".equals(sex_性别)){
            return "M";
        }
        if("0".equals(sex_性别)){
            return "F";
        }
        return "";
    }

    public void setSex_性别(String sex_性别) {
        this.sex_性别 = sex_性别;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMarstatus_婚姻状况() {
        return marstatus_婚姻状况;
    }

    public void setMarstatus_婚姻状况(String marstatus_婚姻状况) {
        this.marstatus_婚姻状况 = marstatus_婚姻状况;
    }

    public String getBirthday_出生日期() {
        return birthday_出生日期;
    }

    public void setBirthday_出生日期(String birthday_出生日期) {
        this.birthday_出生日期 = birthday_出生日期;
    }

    public String getCertinum() {
        return certinum;
    }

    public void setCertinum(String certinum) {
        this.certinum = certinum;
    }

    public String getAgentinstcode_经办机构() {
        return agentinstcode_经办机构;
    }

    public void setAgentinstcode_经办机构(String agentinstcode_经办机构) {
        this.agentinstcode_经办机构 = agentinstcode_经办机构;
    }

    public String getOpnaccdate_开户日期() {
        return opnaccdate_开户日期;
    }

    public void setOpnaccdate_开户日期(String opnaccdate_开户日期) {
        this.opnaccdate_开户日期 = opnaccdate_开户日期;
    }

    public String getValidflag() {
        return validflag;
    }

    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    public CM002_个人基本资料表() {
    }

    public String getInmspell_个人姓名全拼() {
        return inmspell_个人姓名全拼;
    }

    public void setInmspell_个人姓名全拼(String inmspell_个人姓名全拼) {
        this.inmspell_个人姓名全拼 = inmspell_个人姓名全拼;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;
}
