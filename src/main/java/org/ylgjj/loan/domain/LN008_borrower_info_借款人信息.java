package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(LN008_borrower_key.class)
@Entity

@Table(name = "LN008")

public class LN008_borrower_info_借款人信息 {

    @Id
    @Column(name = "loancontrcode")
    private String loancontrcode合同代码;
    @Id
    @Column(name = "seqnum")
    private Integer seqnum_序号;

    private Integer chgnum;
    private String handset;


    public BigDecimal getBal_0_账户余额() {
        return bal_0_账户余额;
    }

    public void setBal_0_账户余额(BigDecimal bal_0_账户余额) {
        this.bal_0_账户余额 = bal_0_账户余额;
    }

    public Integer getSeqnum_序号() {
        return seqnum_序号;
    }

    public void setSeqnum_序号(Integer seqnum_序号) {
        this.seqnum_序号 = seqnum_序号;
    }

    public Integer getChgnum() {
        return chgnum;
    }

    public void setChgnum(Integer chgnum) {
        this.chgnum = chgnum;
    }

    public String getLoanrelation_0_借款人关系() {
        return loanrelation_0_借款人关系;
    }

    public void setLoanrelation_0_借款人关系(String loanrelation_0_借款人关系) {
        this.loanrelation_0_借款人关系 = loanrelation_0_借款人关系;
    }

    public String getCertitype_0_证件类型() {
        return certitype_0_证件类型;
    }

    public void setCertitype_0_证件类型(String certitype_0_证件类型) {
        this.certitype_0_证件类型 = certitype_0_证件类型;
    }

    public String getSex_1_性别() {
        return sex_1_性别;
    }

    public void setSex_1_性别(String sex_1_性别) {
        this.sex_1_性别 = sex_1_性别;
    }

    public String getBirthday_1_出生日期() {
        return birthday_1_出生日期;
    }

    public void setBirthday_1_出生日期(String birthday_1_出生日期) {
        this.birthday_1_出生日期 = birthday_1_出生日期;
    }

    public Integer getAge_1_年龄() {
        return age_1_年龄;
    }

    public void setAge_1_年龄(Integer age_1_年龄) {
        this.age_1_年龄 = age_1_年龄;
    }

    public String getMarstatus_0_婚姻状况() {
        return marstatus_0_婚姻状况;
    }

    public void setMarstatus_0_婚姻状况(String marstatus_0_婚姻状况) {
        this.marstatus_0_婚姻状况 = marstatus_0_婚姻状况;
    }

    public String getUnitkind_1_单位性质() {
        return unitkind_1_单位性质;
    }

    public void setUnitkind_1_单位性质(String unitkind_1_单位性质) {
        this.unitkind_1_单位性质 = unitkind_1_单位性质;
    }

    public BigDecimal getTotalprop_0_缴交总比例() {
        return totalprop_0_缴交总比例;
    }

    public void setTotalprop_0_缴交总比例(BigDecimal totalprop_0_缴交总比例) {
        this.totalprop_0_缴交总比例 = totalprop_0_缴交总比例;
    }

    public String getIndiacctype_1_个人账户类型() {
        return indiacctype_1_个人账户类型;
    }

    public void setIndiacctype_1_个人账户类型(String indiacctype_1_个人账户类型) {
        this.indiacctype_1_个人账户类型 = indiacctype_1_个人账户类型;
    }
    @Column(name = "loaneetype")
    private String loaneetype_借款人类型;

    public String getAccname_0_个人姓名() {
        return accname_0_个人姓名;
    }

    public void setAccname_0_个人姓名(String accname_0_个人姓名) {
        this.accname_0_个人姓名 = accname_0_个人姓名;
    }

    @Column(name = "loanopchgtype")
   private String loanopchgtype_0_借款人变更类型;



    @Column(name = "chgreasontype")
      private String chgreasontype_0_变更原因;

    public String getChgreasontype_0_变更原因() {
        return chgreasontype_0_变更原因;
    }

    public void setChgreasontype_0_变更原因(String chgreasontype_0_变更原因) {
        this.chgreasontype_0_变更原因 = chgreasontype_0_变更原因;
    }


    @Column(name = "loanrelation")
    private String loanrelation_0_借款人关系;



    @Column(name = "custid")
    private String custid_0_个人客户号;


    @Column(name = "accname")
    private String accname_0_个人姓名;


    @Column(name = "certitype")
    private String certitype_0_证件类型;

    @Column(name = "certinum")
    private String certinum_0_证件号码;

    @Column(name = "sex")
    private String sex_1_性别;

    @Column(name = "birthday")
    private String birthday_1_出生日期;

    @Column(name = "age")
    private Integer age_1_年龄;

    @Column(name = "marstatus")
    private String marstatus_0_婚姻状况;

    @Column(name = "unitaccname")
    private String unitaccname_1_单位名称;

    @Column(name = "unitkind")
    private String unitkind_1_单位性质;

    @Column(name = "unitaccnum")
    private String unitaccnum_1_单位账号;



    @Column(name = "accnum")
    private String accnum1账号;
    
    @Column(name = "basenum")
    private BigDecimal basenum_0_缴存基数;

    @Column(name = "totalprop")
    private BigDecimal totalprop_0_缴交总比例;

    @Column(name = "indiacctype")
    private String indiacctype_1_个人账户类型;

    @Column(name = "bal")
    private BigDecimal bal_0_账户余额;

    @Column(name = "indiaccstate")
    private String indiaccstate_1_个人账户状态;

    @Column(name = "linkmanphone")
    private String linkmanphone_1_联系人电话;

    @Column(name = "linkman")
    private String linkman_1_联系人;

    @Column(name = "linkmancertitype")
    private String linkmancertitype_1_联系人证件类型;

    @Column(name = "linkmancertinum")
    private String linkmancertinum_1_联系人证件号码;

    @Column(name = "lastdrawdate")
    private Date lastdrawdate_1_上次提取日期;

    @Column(name = "transdate")
    private Date transdate_0_交易日期;



    public Date getTransdate_0_交易日期() {
        return transdate_0_交易日期;
    }

    public void setTransdate_0_交易日期(Date transdate_0_交易日期) {
        this.transdate_0_交易日期 = transdate_0_交易日期;
    }
             /*    private String linkman;

    private String linkmanphone;
    private String linkmancertitype;
    private String linkmancertinum;*/



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getUnitaccnum_1_单位账号() {
        return unitaccnum_1_单位账号;
    }

    public void setUnitaccnum_1_单位账号(String unitaccnum_1_单位账号) {
        this.unitaccnum_1_单位账号 = unitaccnum_1_单位账号;
    }

    public String getLoancontrcode合同代码() {
        return loancontrcode合同代码;
    }

    public void setLoancontrcode合同代码(String loancontrcode合同代码) {
        this.loancontrcode合同代码 = loancontrcode合同代码;
    }

    public String getCertinum_0_证件号码() {
        return certinum_0_证件号码;
    }

    public void setCertinum_0_证件号码(String certinum_0_证件号码) {
        this.certinum_0_证件号码 = certinum_0_证件号码;
    }

/*    public String getLoaneetype() {
        return loaneetype;
    }

    public void setLoaneetype(String loaneetype) {
        this.loaneetype = loaneetype;
    }*/



    public String getIndiaccstate_1_个人账户状态() {
        return indiaccstate_1_个人账户状态;
    }

    public void setIndiaccstate_1_个人账户状态(String indiaccstate_1_个人账户状态) {
        this.indiaccstate_1_个人账户状态 = indiaccstate_1_个人账户状态;
    }

    public String getAccnum1账号() {
        return accnum1账号;
    }

    public void setAccnum1账号(String accnum1账号) {
        this.accnum1账号 = accnum1账号;
    }

    public String getCustid_0_个人客户号() {
        return custid_0_个人客户号;
    }

    public void setCustid_0_个人客户号(String custid_0_个人客户号) {
        this.custid_0_个人客户号 = custid_0_个人客户号;
    }

    public String getLinkmanphone_1_联系人电话() {
        return linkmanphone_1_联系人电话;
    }

    public void setLinkmanphone_1_联系人电话(String linkmanphone_1_联系人电话) {
        this.linkmanphone_1_联系人电话 = linkmanphone_1_联系人电话;
    }

    public String getLoaneetype_借款人类型() {
        return loaneetype_借款人类型;
    }

    public void setLoaneetype_借款人类型(String loaneetype_借款人类型) {
        this.loaneetype_借款人类型 = loaneetype_借款人类型;
    }

    public String getLoanopchgtype_0_借款人变更类型() {
        return loanopchgtype_0_借款人变更类型;
    }

    public void setLoanopchgtype_0_借款人变更类型(String loanopchgtype_0_借款人变更类型) {
        this.loanopchgtype_0_借款人变更类型 = loanopchgtype_0_借款人变更类型;
    }

    public String getLinkman_1_联系人() {
        return linkman_1_联系人;
    }

    public void setLinkman_1_联系人(String linkman_1_联系人) {
        this.linkman_1_联系人 = linkman_1_联系人;
    }

    public String getLinkmancertitype_1_联系人证件类型() {
        return linkmancertitype_1_联系人证件类型;
    }

    public void setLinkmancertitype_1_联系人证件类型(String linkmancertitype_1_联系人证件类型) {
        this.linkmancertitype_1_联系人证件类型 = linkmancertitype_1_联系人证件类型;
    }

    public String getLinkmancertinum_1_联系人证件号码() {
        return linkmancertinum_1_联系人证件号码;
    }

    public void setLinkmancertinum_1_联系人证件号码(String linkmancertinum_1_联系人证件号码) {
        this.linkmancertinum_1_联系人证件号码 = linkmancertinum_1_联系人证件号码;
    }

    public BigDecimal getBasenum_0_缴存基数() {
        return basenum_0_缴存基数;
    }

    public void setBasenum_0_缴存基数(BigDecimal basenum_0_缴存基数) {
        this.basenum_0_缴存基数 = basenum_0_缴存基数;
    }

    public Date getLastdrawdate_1_上次提取日期() {
        return lastdrawdate_1_上次提取日期;
    }

    public void setLastdrawdate_1_上次提取日期(Date lastdrawdate_1_上次提取日期) {
        this.lastdrawdate_1_上次提取日期 = lastdrawdate_1_上次提取日期;
    }

    public String getUnitaccname_1_单位名称() {
        return unitaccname_1_单位名称;
    }

    public void setUnitaccname_1_单位名称(String unitaccname_1_单位名称) {
        this.unitaccname_1_单位名称 = unitaccname_1_单位名称;
    }

    public String getHandset() {
        return handset;
    }

    public void setHandset(String handset) {
        this.handset = handset;
    }





/*

    public String getLinkmanphone() {
        return linkmanphone;
    }

    public void setLinkmanphone(String linkmanphone) {
        this.linkmanphone = linkmanphone;
    }
*/

    ;








}
