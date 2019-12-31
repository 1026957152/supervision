package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H8_1银行专户余额_银行专户余额查询 {


/*    @JsonProperty("bm")
    @JSONField(name="bm")
    private String bm_银行编码;

    @JsonProperty("mc")
    @JSONField(name="mc")
    private String mc_银行名称;*/

    @JsonProperty("id")
    @JSONField(name="id")
    private String id_银行logo图片;

    @JsonProperty("zjbmc")
    @JSONField(name="zjbmc")
    private String zjbmc_住建部中心编码_String;

    @JsonProperty("zjbbm")
    @JSONField(name="zjbbm")
    private String zjbbm_住建部中心名称_String;

    @JsonProperty("sszh")
    @JSONField(name="sszh")
    private String sszh_总行编码_String;

    @JsonProperty("zhmc")
    @JSONField(name="zhmc")
    private String zhmc_总行名称_String;

    @JsonProperty("gjzhye")
    @JSONField(name="gjzhye")
    private String gjzhye_活期归集账户余额_String;

    @JsonProperty("dkzhye")
    @JSONField(name="dkzhye")
    private String dkzhye_活期贷款账户余额_String;

    @JsonProperty("zzsyzhye")
    @JSONField(name="zzsyzhye")
    private String zzsyzhye_活期增值收益账户余额_String;

    @JsonProperty("dqgjzhye")
    @JSONField(name="dqgjzhye")
    private String dqgjzhye_定期归集账户余额_String;

    @JsonProperty("dqdkzhye")
    @JSONField(name="dqdkzhye")
    private String dqdkzhye_定期贷款账户余额_String;

    @JsonProperty("dqzzsyzhye")
    @JSONField(name="dqzzsyzhye")
    private String dqzzsyzhye_定期增值收益账户余额_String;

    @JsonProperty("hj")
    @JSONField(name="hj")
    private String hj_合计余额_String;


    public String getId_银行logo图片() {
        return id_银行logo图片;
    }

    public void setId_银行logo图片(String id_银行logo图片) {
        this.id_银行logo图片 = id_银行logo图片;
    }

    public String getZjbmc_住建部中心编码_String() {
        return zjbmc_住建部中心编码_String;
    }

    public void setZjbmc_住建部中心编码_String(String zjbmc_住建部中心编码_String) {
        this.zjbmc_住建部中心编码_String = zjbmc_住建部中心编码_String;
    }

    public String getZjbbm_住建部中心名称_String() {
        return zjbbm_住建部中心名称_String;
    }

    public void setZjbbm_住建部中心名称_String(String zjbbm_住建部中心名称_String) {
        this.zjbbm_住建部中心名称_String = zjbbm_住建部中心名称_String;
    }

    public String getSszh_总行编码_String() {
        return sszh_总行编码_String;
    }

    public void setSszh_总行编码_String(String sszh_总行编码_String) {
        this.sszh_总行编码_String = sszh_总行编码_String;
    }

    public String getZhmc_总行名称_String() {
        return zhmc_总行名称_String;
    }

    public void setZhmc_总行名称_String(String zhmc_总行名称_String) {
        this.zhmc_总行名称_String = zhmc_总行名称_String;
    }

    public String getGjzhye_活期归集账户余额_String() {
        return gjzhye_活期归集账户余额_String;
    }

    public void setGjzhye_活期归集账户余额_String(String gjzhye_活期归集账户余额_String) {
        this.gjzhye_活期归集账户余额_String = gjzhye_活期归集账户余额_String;
    }

    public String getDkzhye_活期贷款账户余额_String() {
        return dkzhye_活期贷款账户余额_String;
    }

    public void setDkzhye_活期贷款账户余额_String(String dkzhye_活期贷款账户余额_String) {
        this.dkzhye_活期贷款账户余额_String = dkzhye_活期贷款账户余额_String;
    }

    public String getZzsyzhye_活期增值收益账户余额_String() {
        return zzsyzhye_活期增值收益账户余额_String;
    }

    public void setZzsyzhye_活期增值收益账户余额_String(String zzsyzhye_活期增值收益账户余额_String) {
        this.zzsyzhye_活期增值收益账户余额_String = zzsyzhye_活期增值收益账户余额_String;
    }

    public String getDqgjzhye_定期归集账户余额_String() {
        return dqgjzhye_定期归集账户余额_String;
    }

    public void setDqgjzhye_定期归集账户余额_String(String dqgjzhye_定期归集账户余额_String) {
        this.dqgjzhye_定期归集账户余额_String = dqgjzhye_定期归集账户余额_String;
    }

    public String getDqdkzhye_定期贷款账户余额_String() {
        return dqdkzhye_定期贷款账户余额_String;
    }

    public void setDqdkzhye_定期贷款账户余额_String(String dqdkzhye_定期贷款账户余额_String) {
        this.dqdkzhye_定期贷款账户余额_String = dqdkzhye_定期贷款账户余额_String;
    }

    public String getDqzzsyzhye_定期增值收益账户余额_String() {
        return dqzzsyzhye_定期增值收益账户余额_String;
    }

    public void setDqzzsyzhye_定期增值收益账户余额_String(String dqzzsyzhye_定期增值收益账户余额_String) {
        this.dqzzsyzhye_定期增值收益账户余额_String = dqzzsyzhye_定期增值收益账户余额_String;
    }

    public String getHj_合计余额_String() {
        return hj_合计余额_String;
    }

    public void setHj_合计余额_String(String hj_合计余额_String) {
        this.hj_合计余额_String = hj_合计余额_String;
    }
}