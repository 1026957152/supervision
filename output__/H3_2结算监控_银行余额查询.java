package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H3_2结算监控_银行余额查询 {




    private String bm_银行编码;
    private String mc_银行名称;
    private double fse_发生额;
    private double sre_收入额;
    private double zce_支出额;

    public String getBm_银行编码() {
        return bm_银行编码;
    }

    public void setBm_银行编码(String bm_银行编码) {
        this.bm_银行编码 = bm_银行编码;
    }

    public String getMc_银行名称() {
        return mc_银行名称;
    }

    public void setMc_银行名称(String mc_银行名称) {
        this.mc_银行名称 = mc_银行名称;
    }

    public double getFse_发生额() {
        return fse_发生额;
    }

    public void setFse_发生额(double fse_发生额) {
        this.fse_发生额 = fse_发生额;
    }

    public double getSre_收入额() {
        return sre_收入额;
    }

    public void setSre_收入额(double sre_收入额) {
        this.sre_收入额 = sre_收入额;
    }

    public double getZce_支出额() {
        return zce_支出额;
    }

    public void setZce_支出额(double zce_支出额) {
        this.zce_支出额 = zce_支出额;
    }
}