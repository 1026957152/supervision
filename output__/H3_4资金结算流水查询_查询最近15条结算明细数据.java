package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H3_4资金结算流水查询_查询最近15条结算明细数据 {


    private String input_zjbzxbm_住建部中心编码;
    private String id_序号;
    private String blqd_办理渠道;
    private String yhmc_银行名称;
    private String jysj_交易时间;
    private String zhaiyao_摘要;

    public String getInput_zjbzxbm_住建部中心编码() {
        return input_zjbzxbm_住建部中心编码;
    }

    public void setInput_zjbzxbm_住建部中心编码(String input_zjbzxbm_住建部中心编码) {
        this.input_zjbzxbm_住建部中心编码 = input_zjbzxbm_住建部中心编码;
    }

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