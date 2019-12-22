package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H3_3结算监控_银行实时交易 {


    @JsonProperty("id")
    @JSONField(name="id")
    private String id_唯一标识;

    @JsonProperty("fsefx")
    @JSONField(name="fsefx")
    private String fsefx_发生额方向; //01：转入，02：支出
    @JsonProperty("fse")
    @JSONField(name="fse")
    private Double fse_发生额;

    @JsonProperty("ye")
    @JSONField(name="ye")
    private Double ye_余额;

    @JsonProperty("sszh")
    @JSONField(name="sszh")
    private String sszh_银行编码;
    private String bm;

    private String mc;

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getId_唯一标识() {
        return id_唯一标识;
    }

    public void setId_唯一标识(String id_唯一标识) {
        this.id_唯一标识 = id_唯一标识;
    }

    public String getFsefx_发生额方向() {
        return fsefx_发生额方向;
    }

    public void setFsefx_发生额方向(String fsefx_发生额方向) {
        this.fsefx_发生额方向 = fsefx_发生额方向;
    }

    public double getFse_发生额() {
        return fse_发生额;
    }

    public void setFse_发生额(double fse_发生额) {
        this.fse_发生额 = fse_发生额;
    }

    public Double getYe_余额() {
        return ye_余额;
    }

    public void setYe_余额(Double ye_余额) {
        this.ye_余额 = ye_余额;
    }

    public String getSszh_银行编码() {
        return sszh_银行编码;
    }

    public void setSszh_银行编码(String sszh_银行编码) {
        this.sszh_银行编码 = sszh_银行编码;
    }
}