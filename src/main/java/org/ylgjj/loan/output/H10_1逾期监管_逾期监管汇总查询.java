package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.ylgjj.loan.config.Constants;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H10_1逾期监管_逾期监管汇总查询 {


    @JsonProperty("zxjgbm")
    @JSONField(name="zxjgbm")
    private String output_zxjgbm_办理渠道 = Constants.zjbzxbm_住建部中心编码;


    @JsonProperty("zxjgmc")
    @JSONField(name="zxjgmc")
    private String zxjgmc_中心机构名称 = Constants.zxjgmc_中心机构名称;
    @JsonProperty("yq1")
    @JSONField(name="yq1")
    private int yq1_1个月_含_以上_3个月以下笔数;

    @JsonProperty("yqje1")
    @JSONField(name="yqje1")
    private double yqje1_1个月_含_以上_3个月以下金额;

    @JsonProperty("yq2")
    @JSONField(name="yq2")
    private int yq2_3个月_含_以上_6个月以下笔数;

    @JsonProperty("yqje2")
    @JSONField(name="yqje2")
    private double yqje2_3个月_含_以上_6个月以下金额;

    @JsonProperty("yq3")
    @JSONField(name="yq3")
    private int yq3_6个月_含_以上_1年以下笔数;

    @JsonProperty("yqje3")
    @JSONField(name="yqje3")
    private double yqje3_6个月_含_以上_1年以下金额;

    @JsonProperty("yq4")
    @JSONField(name="yq4")
    private int yq4_1年_含_以上_3年以下笔数;

    @JsonProperty("yqje4")
    @JSONField(name="yqje4")
    private double yqje4_1年_含_以上_3年以下金额;

    @JsonProperty("yq5")
    @JSONField(name="yq5")
    private int yq5_3年_含_以上笔数;

    @JsonProperty("yqje5")
    @JSONField(name="yqje5")
    private double yqje5_3年_含_以上金额;

    @JsonProperty("yq6")
    @JSONField(name="yq6")
    private int yq6_六期_含_以上笔数;

    @JsonProperty("ysdkye6")
    @JSONField(name="ysdkye6")
    private double ysdkye6_六期_含_以上金额;

    @JsonProperty("dkye")
    @JSONField(name="dkye")
    private int dkye_贷款余额;

    @JsonProperty("yql")
    @JSONField(name="yql")
    private double yql_逾期率; //((yqje2+ysdkye6)/dkye)*1000; #0.00数值格式化

    @JsonProperty("yqlbfb")
    @JSONField(name="yqlbfb")
    private double yqlbfb; //((yqje2+ysdkye6)/dkye)*1000;

    public String getOutput_zxjgbm_办理渠道() {
        return output_zxjgbm_办理渠道;
    }

    public void setOutput_zxjgbm_办理渠道(String output_zxjgbm_办理渠道) {
        this.output_zxjgbm_办理渠道 = output_zxjgbm_办理渠道;
    }

    public int getYq1_1个月_含_以上_3个月以下笔数() {
        return yq1_1个月_含_以上_3个月以下笔数;
    }

    public void setYq1_1个月_含_以上_3个月以下笔数(int yq1_1个月_含_以上_3个月以下笔数) {
        this.yq1_1个月_含_以上_3个月以下笔数 = yq1_1个月_含_以上_3个月以下笔数;
    }

    public double getYqje1_1个月_含_以上_3个月以下金额() {
        return yqje1_1个月_含_以上_3个月以下金额;
    }

    public void setYqje1_1个月_含_以上_3个月以下金额(double yqje1_1个月_含_以上_3个月以下金额) {
        this.yqje1_1个月_含_以上_3个月以下金额 = yqje1_1个月_含_以上_3个月以下金额;
    }

    public int getYq2_3个月_含_以上_6个月以下笔数() {
        return yq2_3个月_含_以上_6个月以下笔数;
    }

    public void setYq2_3个月_含_以上_6个月以下笔数(int yq2_3个月_含_以上_6个月以下笔数) {
        this.yq2_3个月_含_以上_6个月以下笔数 = yq2_3个月_含_以上_6个月以下笔数;
    }

    public double getYqje2_3个月_含_以上_6个月以下金额() {
        return yqje2_3个月_含_以上_6个月以下金额;
    }

    public void setYqje2_3个月_含_以上_6个月以下金额(double yqje2_3个月_含_以上_6个月以下金额) {
        this.yqje2_3个月_含_以上_6个月以下金额 = yqje2_3个月_含_以上_6个月以下金额;
    }

    public int getYq3_6个月_含_以上_1年以下笔数() {
        return yq3_6个月_含_以上_1年以下笔数;
    }

    public void setYq3_6个月_含_以上_1年以下笔数(int yq3_6个月_含_以上_1年以下笔数) {
        this.yq3_6个月_含_以上_1年以下笔数 = yq3_6个月_含_以上_1年以下笔数;
    }

    public double getYqje3_6个月_含_以上_1年以下金额() {
        return yqje3_6个月_含_以上_1年以下金额;
    }

    public void setYqje3_6个月_含_以上_1年以下金额(double yqje3_6个月_含_以上_1年以下金额) {
        this.yqje3_6个月_含_以上_1年以下金额 = yqje3_6个月_含_以上_1年以下金额;
    }

    public int getYq4_1年_含_以上_3年以下笔数() {
        return yq4_1年_含_以上_3年以下笔数;
    }

    public void setYq4_1年_含_以上_3年以下笔数(int yq4_1年_含_以上_3年以下笔数) {
        this.yq4_1年_含_以上_3年以下笔数 = yq4_1年_含_以上_3年以下笔数;
    }

    public double getYqje4_1年_含_以上_3年以下金额() {
        return yqje4_1年_含_以上_3年以下金额;
    }

    public void setYqje4_1年_含_以上_3年以下金额(double yqje4_1年_含_以上_3年以下金额) {
        this.yqje4_1年_含_以上_3年以下金额 = yqje4_1年_含_以上_3年以下金额;
    }

    public int getYq5_3年_含_以上笔数() {
        return yq5_3年_含_以上笔数;
    }

    public void setYq5_3年_含_以上笔数(int yq5_3年_含_以上笔数) {
        this.yq5_3年_含_以上笔数 = yq5_3年_含_以上笔数;
    }

    public double getYqje5_3年_含_以上金额() {
        return yqje5_3年_含_以上金额;
    }

    public void setYqje5_3年_含_以上金额(double yqje5_3年_含_以上金额) {
        this.yqje5_3年_含_以上金额 = yqje5_3年_含_以上金额;
    }

    public int getYq6_六期_含_以上笔数() {
        return yq6_六期_含_以上笔数;
    }

    public void setYq6_六期_含_以上笔数(int yq6_六期_含_以上笔数) {
        this.yq6_六期_含_以上笔数 = yq6_六期_含_以上笔数;
    }

    public double getYsdkye6_六期_含_以上金额() {
        return ysdkye6_六期_含_以上金额;
    }

    public void setYsdkye6_六期_含_以上金额(double ysdkye6_六期_含_以上金额) {
        this.ysdkye6_六期_含_以上金额 = ysdkye6_六期_含_以上金额;
    }

    public int getDkye_贷款余额() {
        return dkye_贷款余额;
    }

    public void setDkye_贷款余额(int dkye_贷款余额) {
        this.dkye_贷款余额 = dkye_贷款余额;
    }

    public double getYql_逾期率() {
        return yql_逾期率;
    }

    public void setYql_逾期率(double yql_逾期率) {
        this.yql_逾期率 = yql_逾期率;
    }

    public double getYqlbfb() {
        return yqlbfb;
    }

    public void setYqlbfb(double yqlbfb) {
        this.yqlbfb = yqlbfb;
    }
}