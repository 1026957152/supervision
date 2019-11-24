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

@Table(name = "CM001")

public class CM001_单位基本资料表 {



    @Id

    @Column(name = "unitcustid")
    private String unitcustid单位客户号;

    @Column(name = "unitaccname")
    private String unitaccname_单位名称;

    @Column(name = "orgcode")
    private String orgcode_组织机构代码;

    @Column(name = "licensenum")
    private String licensenum_营业执照号码;

    
    @Column(name = "unitkind")
    private String unitkind_单位性质;


    @Column(name = "unitaddr")
    private String unitaddr_单位地址;

    @Column(name = "leglaccname")
    private String leglaccname_单位法人代表;

    @Column(name = "leglcertitype")
    private String leglcertitype_法人代表证件类型1;

    public String getLeglcertitype_法人代表证件类型1() {
        return leglcertitype_法人代表证件类型1;
    }

    public void setLeglcertitype_法人代表证件类型1(String leglcertitype_法人代表证件类型1) {
        this.leglcertitype_法人代表证件类型1 = leglcertitype_法人代表证件类型1;
    }

    @Column(name = "leglcertinum")
    private String leglcertinum_法人代表证件号码0;

    @Column(name = "unitlinkman")
    private String unitlinkman_单位联系人;

    @Column(name = "unitlinkphone")
    private String unitlinkphone_联系电话;

    @Column(name = "agentinstcode")
    private String agentinstcode_经办机构;

    @Column(name = "salday")
    private String salday_发薪日;


    public String getOrgcode_组织机构代码() {
        return orgcode_组织机构代码;
    }

    public void setOrgcode_组织机构代码(String orgcode_组织机构代码) {
        this.orgcode_组织机构代码 = orgcode_组织机构代码;
    }

    public String getLicensenum_营业执照号码() {
        return licensenum_营业执照号码;
    }

    public void setLicensenum_营业执照号码(String licensenum_营业执照号码) {
        this.licensenum_营业执照号码 = licensenum_营业执照号码;
    }

    public String getAgentinstcode_经办机构() {
        return agentinstcode_经办机构;
    }

    public void setAgentinstcode_经办机构(String agentinstcode_经办机构) {
        this.agentinstcode_经办机构 = agentinstcode_经办机构;
    }

    public String getSalday_发薪日() {
        return salday_发薪日;
    }

    public void setSalday_发薪日(String salday_发薪日) {
        this.salday_发薪日 = salday_发薪日;
    }

    public String getUnitaddr_单位地址() {
        return unitaddr_单位地址;
    }

    public void setUnitaddr_单位地址(String unitaddr_单位地址) {
        this.unitaddr_单位地址 = unitaddr_单位地址;
    }

    public String getLeglaccname_单位法人代表() {
        return leglaccname_单位法人代表;
    }

    public void setLeglaccname_单位法人代表(String leglaccname_单位法人代表) {
        this.leglaccname_单位法人代表 = leglaccname_单位法人代表;
    }

    public String getLeglcertinum_法人代表证件号码0() {
        return leglcertinum_法人代表证件号码0;
    }

    public void setLeglcertinum_法人代表证件号码0(String leglcertinum_法人代表证件号码0) {
        this.leglcertinum_法人代表证件号码0 = leglcertinum_法人代表证件号码0;
    }

    public String getUnitlinkman_单位联系人() {
        return unitlinkman_单位联系人;
    }

    public void setUnitlinkman_单位联系人(String unitlinkman_单位联系人) {
        this.unitlinkman_单位联系人 = unitlinkman_单位联系人;
    }

    public String getUnitlinkphone_联系电话() {
        return unitlinkphone_联系电话;
    }

    public void setUnitlinkphone_联系电话(String unitlinkphone_联系电话) {
        this.unitlinkphone_联系电话 = unitlinkphone_联系电话;
    }

    public String getUnitkind_单位性质() {
        return unitkind_单位性质;
    }

    public void setUnitkind_单位性质(String unitkind_单位性质) {
        this.unitkind_单位性质 = unitkind_单位性质;
    }

    public CM001_单位基本资料表() {
    }

    public String getUnitaccname_单位名称() {
        return unitaccname_单位名称;
    }

    public void setUnitaccname_单位名称(String unitaccname_单位名称) {
        this.unitaccname_单位名称 = unitaccname_单位名称;
    }

    public String getUnitcustid单位客户号() {
        return unitcustid单位客户号;
    }

    public void setUnitcustid单位客户号(String unitcustid单位客户号) {
        this.unitcustid单位客户号 = unitcustid单位客户号;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



    ;





}
