package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "CM081")

public class CM081_sms_短信密码签订登记簿 {
















   // @Column(name = "unitcustid")
    private String transdate;



    @Id    @Column(name = "pubaccnum")

    private String pubaccnum通用帐号0;
    @Column(name = "certinum")
    private String certinum证件号码1;

    @Column(name = "type")
    private String type业务类型0;  //1-签约手机2密码设置

    @Column(name = "phone")
    private String phone手机号1;

    @Column(name = "password")
    private String password;

    @Column(name = "validflag")
    private String validflag是否有效0;

    private String agentinstcode;
    private String agentop;
    private String timestamp;
    private String agrtondate;
    private String agrtoffdate;


    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate;
    }

    public String getPubaccnum通用帐号0() {
        return pubaccnum通用帐号0;
    }

    public void setPubaccnum通用帐号0(String pubaccnum通用帐号0) {
        this.pubaccnum通用帐号0 = pubaccnum通用帐号0;
    }

    public String getCertinum证件号码1() {
        return certinum证件号码1;
    }

    public void setCertinum证件号码1(String certinum证件号码1) {
        this.certinum证件号码1 = certinum证件号码1;
    }

    public String getType业务类型0() {
        return type业务类型0;
    }

    public void setType业务类型0(String type业务类型0) {
        this.type业务类型0 = type业务类型0;
    }

    public String getPhone手机号1() {
        return phone手机号1;
    }

    public void setPhone手机号1(String phone手机号1) {
        this.phone手机号1 = phone手机号1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidflag是否有效0() {
        return validflag是否有效0;
    }

    public void setValidflag是否有效0(String validflag是否有效0) {
        this.validflag是否有效0 = validflag是否有效0;
    }

    public String getAgentinstcode() {
        return agentinstcode;
    }

    public void setAgentinstcode(String agentinstcode) {
        this.agentinstcode = agentinstcode;
    }

    public String getAgentop() {
        return agentop;
    }

    public void setAgentop(String agentop) {
        this.agentop = agentop;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAgrtondate() {
        return agrtondate;
    }

    public void setAgrtondate(String agrtondate) {
        this.agrtondate = agrtondate;
    }

    public String getAgrtoffdate() {
        return agrtoffdate;
    }

    public void setAgrtoffdate(String agrtoffdate) {
        this.agrtoffdate = agrtoffdate;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
