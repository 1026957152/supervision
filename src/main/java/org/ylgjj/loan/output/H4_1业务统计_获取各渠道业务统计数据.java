package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H4_1业务统计_获取各渠道业务统计数据 {



    @JsonProperty("blqdmc")
    @JSONField(name="blqdmc")
    private String blqdmc_办理渠道_varchar_20;
    @JsonProperty("gjbs")
    @JSONField(name="gjbs")
    private int gjbs_归集_Int;
    @JsonProperty("gjje")
    @JSONField(name="gjje")
    private double gjje_归集金额_Double;
    @JsonProperty("gjzb")
    @JSONField(name="gjzb")
    private double gjzb_归集占比_Double;
    @JsonProperty("tqbs")
    @JSONField(name="tqbs")
    private int tqbs_提取笔数_Int;
    @JsonProperty("tqje")
    @JSONField(name="tqje")
    private double tqje_提取金额_Double;
    @JsonProperty("tqzb")
    @JSONField(name="tqzb")
    private double tqzb_提取占比_Double;
    @JsonProperty("dkbs")
    @JSONField(name="dkbs")
    private int dkbs_贷款笔数_Int;
    @JsonProperty("dkje")
    @JSONField(name="dkje")
    private double dkje_贷款金额_Double;
    @JsonProperty("dkzb")
    @JSONField(name="dkzb")
    private double dkzb_贷款占比_Double;
    @JsonProperty("dktqhkbs")
    @JSONField(name="dktqhkbs")
    private int dktqhkbs_提前还贷笔数_Int;
    @JsonProperty("dktqhkje")
    @JSONField(name="dktqhkje")
    private double dktqhkje_提前还贷金额_Double;
    @JsonProperty("dktqhkzb")
    @JSONField(name="dktqhkzb")
    private double dktqhkzb_提前还贷占比_Double;
    @JsonProperty("tqywchdbs")
    @JSONField(name="tqywchdbs")

    private int tqywchdbs_提取业务偿还贷笔数_Int;
    @JsonProperty("Tqywchdje")
    @JSONField(name="Tqywchdje")
    private double Tqywchdje_提取业务偿还贷金额_Double;
    @JsonProperty("tqywchdzb")
    @JSONField(name="tqywchdzb")
    private double tqywchdzb_提取业务偿还贷占比_Double;

    public String getBlqdmc_办理渠道_varchar_20() {
        return blqdmc_办理渠道_varchar_20;
    }

    public void setBlqdmc_办理渠道_varchar_20(String blqdmc_办理渠道_varchar_20) {
        this.blqdmc_办理渠道_varchar_20 = blqdmc_办理渠道_varchar_20;
    }

    public int getGjbs_归集_Int() {
        return gjbs_归集_Int;
    }

    public void setGjbs_归集_Int(int gjbs_归集_Int) {
        this.gjbs_归集_Int = gjbs_归集_Int;
    }

    public double getGjje_归集金额_Double() {
        return gjje_归集金额_Double;
    }

    public void setGjje_归集金额_Double(double gjje_归集金额_Double) {
        this.gjje_归集金额_Double = gjje_归集金额_Double;
    }

    public double getGjzb_归集占比_Double() {
        return gjzb_归集占比_Double;
    }

    public void setGjzb_归集占比_Double(double gjzb_归集占比_Double) {
        this.gjzb_归集占比_Double = gjzb_归集占比_Double;
    }

    public int getTqbs_提取笔数_Int() {
        return tqbs_提取笔数_Int;
    }

    public void setTqbs_提取笔数_Int(int tqbs_提取笔数_Int) {
        this.tqbs_提取笔数_Int = tqbs_提取笔数_Int;
    }

    public double getTqje_提取金额_Double() {
        return tqje_提取金额_Double;
    }

    public void setTqje_提取金额_Double(double tqje_提取金额_Double) {
        this.tqje_提取金额_Double = tqje_提取金额_Double;
    }

    public double getTqzb_提取占比_Double() {
        return tqzb_提取占比_Double;
    }

    public void setTqzb_提取占比_Double(double tqzb_提取占比_Double) {
        this.tqzb_提取占比_Double = tqzb_提取占比_Double;
    }

    public int getDkbs_贷款笔数_Int() {
        return dkbs_贷款笔数_Int;
    }

    public void setDkbs_贷款笔数_Int(int dkbs_贷款笔数_Int) {
        this.dkbs_贷款笔数_Int = dkbs_贷款笔数_Int;
    }

    public double getDkje_贷款金额_Double() {
        return dkje_贷款金额_Double;
    }

    public void setDkje_贷款金额_Double(double dkje_贷款金额_Double) {
        this.dkje_贷款金额_Double = dkje_贷款金额_Double;
    }

    public double getDkzb_贷款占比_Double() {
        return dkzb_贷款占比_Double;
    }

    public void setDkzb_贷款占比_Double(double dkzb_贷款占比_Double) {
        this.dkzb_贷款占比_Double = dkzb_贷款占比_Double;
    }

    public int getDktqhkbs_提前还贷笔数_Int() {
        return dktqhkbs_提前还贷笔数_Int;
    }

    public void setDktqhkbs_提前还贷笔数_Int(int dktqhkbs_提前还贷笔数_Int) {
        this.dktqhkbs_提前还贷笔数_Int = dktqhkbs_提前还贷笔数_Int;
    }

    public double getDktqhkje_提前还贷金额_Double() {
        return dktqhkje_提前还贷金额_Double;
    }

    public void setDktqhkje_提前还贷金额_Double(double dktqhkje_提前还贷金额_Double) {
        this.dktqhkje_提前还贷金额_Double = dktqhkje_提前还贷金额_Double;
    }

    public double getDktqhkzb_提前还贷占比_Double() {
        return dktqhkzb_提前还贷占比_Double;
    }

    public void setDktqhkzb_提前还贷占比_Double(double dktqhkzb_提前还贷占比_Double) {
        this.dktqhkzb_提前还贷占比_Double = dktqhkzb_提前还贷占比_Double;
    }

    public int getTqywchdbs_提取业务偿还贷笔数_Int() {
        return tqywchdbs_提取业务偿还贷笔数_Int;
    }

    public void setTqywchdbs_提取业务偿还贷笔数_Int(int tqywchdbs_提取业务偿还贷笔数_Int) {
        this.tqywchdbs_提取业务偿还贷笔数_Int = tqywchdbs_提取业务偿还贷笔数_Int;
    }

    public double getTqywchdje_提取业务偿还贷金额_Double() {
        return Tqywchdje_提取业务偿还贷金额_Double;
    }

    public void setTqywchdje_提取业务偿还贷金额_Double(double tqywchdje_提取业务偿还贷金额_Double) {
        Tqywchdje_提取业务偿还贷金额_Double = tqywchdje_提取业务偿还贷金额_Double;
    }

    public double getTqywchdzb_提取业务偿还贷占比_Double() {
        return tqywchdzb_提取业务偿还贷占比_Double;
    }

    public void setTqywchdzb_提取业务偿还贷占比_Double(double tqywchdzb_提取业务偿还贷占比_Double) {
        this.tqywchdzb_提取业务偿还贷占比_Double = tqywchdzb_提取业务偿还贷占比_Double;
    }
}