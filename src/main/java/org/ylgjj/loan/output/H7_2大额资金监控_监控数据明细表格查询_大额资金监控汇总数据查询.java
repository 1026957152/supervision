package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H7_2大额资金监控_监控数据明细表格查询_大额资金监控汇总数据查询 {


    // fd045	资金划转业务登记文件				存放中心各银行专户间互相划转资金的相关信息。		ac045，主要取消了财务日期、账套。
    @JsonProperty("jgmc")
    @JSONField(name="jgmc")
    private String jgmc_机构名称;

    @JsonProperty("sprq")
    @JSONField(name="sprq")
    private String sprq_审批日期;

    @JsonProperty("zjytbm")
    @JSONField(name="zjytbm")
    private String zjytbm_业务类型编码;

    @JsonProperty("zjytmc")
    @JSONField(name="zjytmc")
    private String zjytmc_业务类型;

    @JsonProperty("syje")
    @JSONField(name="syje")
    private String syje_金额_万元;

    @JsonProperty("skzhhm")
    @JSONField(name="skzhhm")
    private String skzhhm_收款户名;

    @JsonProperty("skkhyh")
    @JSONField(name="skkhyh")
    private String skkhyh_收款银行;

    @JsonProperty("zrzh")
    @JSONField(name="zrzh")
    private String zrzh_收款账号;

    @JsonProperty("fkzhhm")
    @JSONField(name="fkzhhm")
    private String fkzhhm_付款户名;

    @JsonProperty("fkkhyh")
    @JSONField(name="fkkhyh")
    private String fkkhyh_付款银行;

    @JsonProperty("yhzh")
    @JSONField(name="yhzh")
    private String yhzh_付款账号;

    @JsonProperty("squname")
    @JSONField(name="squname")
    private String squname_发起人;

    @JsonProperty("spczy")
    @JSONField(name="spczy")
    private String spczy_审批人;

    @JsonProperty("bz")
    @JSONField(name="bz")
    private String bz_备注;

    @JsonProperty("zjbzxbm")
    @JSONField(name="zjbzxbm")
    private String zjbzxbm_住建部中心编码;


    public String getJgmc_机构名称() {
        return jgmc_机构名称;
    }

    public void setJgmc_机构名称(String jgmc_机构名称) {
        this.jgmc_机构名称 = jgmc_机构名称;
    }

    public String getSprq_审批日期() {
        return sprq_审批日期;
    }

    public void setSprq_审批日期(String sprq_审批日期) {
        this.sprq_审批日期 = sprq_审批日期;
    }

    public String getZjytbm_业务类型编码() {
        return zjytbm_业务类型编码;
    }

    public void setZjytbm_业务类型编码(String zjytbm_业务类型编码) {
        this.zjytbm_业务类型编码 = zjytbm_业务类型编码;
    }

    public String getZjytmc_业务类型() {
        return zjytmc_业务类型;
    }

    public void setZjytmc_业务类型(String zjytmc_业务类型) {
        this.zjytmc_业务类型 = zjytmc_业务类型;
    }

    public String getSyje_金额_万元() {
        return syje_金额_万元;
    }

    public void setSyje_金额_万元(String syje_金额_万元) {
        this.syje_金额_万元 = syje_金额_万元;
    }

    public String getSkzhhm_收款户名() {
        return skzhhm_收款户名;
    }

    public void setSkzhhm_收款户名(String skzhhm_收款户名) {
        this.skzhhm_收款户名 = skzhhm_收款户名;
    }

    public String getSkkhyh_收款银行() {
        return skkhyh_收款银行;
    }

    public void setSkkhyh_收款银行(String skkhyh_收款银行) {
        this.skkhyh_收款银行 = skkhyh_收款银行;
    }

    public String getZrzh_收款账号() {
        return zrzh_收款账号;
    }

    public void setZrzh_收款账号(String zrzh_收款账号) {
        this.zrzh_收款账号 = zrzh_收款账号;
    }

    public String getFkzhhm_付款户名() {
        return fkzhhm_付款户名;
    }

    public void setFkzhhm_付款户名(String fkzhhm_付款户名) {
        this.fkzhhm_付款户名 = fkzhhm_付款户名;
    }

    public String getFkkhyh_付款银行() {
        return fkkhyh_付款银行;
    }

    public void setFkkhyh_付款银行(String fkkhyh_付款银行) {
        this.fkkhyh_付款银行 = fkkhyh_付款银行;
    }

    public String getYhzh_付款账号() {
        return yhzh_付款账号;
    }

    public void setYhzh_付款账号(String yhzh_付款账号) {
        this.yhzh_付款账号 = yhzh_付款账号;
    }

    public String getSquname_发起人() {
        return squname_发起人;
    }

    public void setSquname_发起人(String squname_发起人) {
        this.squname_发起人 = squname_发起人;
    }

    public String getSpczy_审批人() {
        return spczy_审批人;
    }

    public void setSpczy_审批人(String spczy_审批人) {
        this.spczy_审批人 = spczy_审批人;
    }

    public String getBz_备注() {
        return bz_备注;
    }

    public void setBz_备注(String bz_备注) {
        this.bz_备注 = bz_备注;
    }

    public String getZjbzxbm_住建部中心编码() {
        return zjbzxbm_住建部中心编码;
    }

    public void setZjbzxbm_住建部中心编码(String zjbzxbm_住建部中心编码) {
        this.zjbzxbm_住建部中心编码 = zjbzxbm_住建部中心编码;
    }
}