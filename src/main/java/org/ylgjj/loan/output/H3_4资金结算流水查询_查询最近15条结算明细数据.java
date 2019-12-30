package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H3_4资金结算流水查询_查询最近15条结算明细数据 {




    @JsonProperty("id")
    @JSONField(name="id")
    private String id_序号;


    @JsonProperty("blqd")
    @JSONField(name="blqd")
    private String blqd_办理渠道;


    @JsonProperty("yhmc")
    @JSONField(name="yhmc")
    private String yhmc_银行名称;


    @JsonProperty("jysj")
    @JSONField(name="jysj")
    private String jysj_交易时间;


    @JsonProperty("zhaiyao")
    @JSONField(name="zhaiyao")
    private String zhaiyao_摘要;


    public String getId_序号() {
        return id_序号;
    }

    public void setId_序号(String id_序号) {
        this.id_序号 = id_序号;
    }

    public String getBlqd_办理渠道() {
        return blqd_办理渠道;
    }

    public void setBlqd_办理渠道(String blqd_办理渠道) {
        this.blqd_办理渠道 = blqd_办理渠道;
    }

    public String getYhmc_银行名称() {
        return yhmc_银行名称;
    }

    public void setYhmc_银行名称(String yhmc_银行名称) {
        this.yhmc_银行名称 = yhmc_银行名称;
    }

    public String getJysj_交易时间() {
        return jysj_交易时间;
    }

    public void setJysj_交易时间(String jysj_交易时间) {
        this.jysj_交易时间 = jysj_交易时间;
    }

    public String getZhaiyao_摘要() {
        return zhaiyao_摘要;
    }

    public void setZhaiyao_摘要(String zhaiyao_摘要) {
        this.zhaiyao_摘要 = zhaiyao_摘要;
    }
}