package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H7_1大额资金监控_监控数据明细查询 {


    @JsonProperty("zjytbm")
    @JSONField(name="zjytbm")
    private String zjytbm_业务类型编码;

    @JsonProperty("zjytmc")
    @JSONField(name="zjytmc")
    private String zjytmc_业务类型;

    @JsonProperty("je1")
    @JSONField(name="je1")
    private String je1_金额_500_1000;

    @JsonProperty("je2")
    @JSONField(name="je2")
    private String je2_金额_1000_1500;

    @JsonProperty("je3")
    @JSONField(name="je3")
    private String je3_金额_1500_2000;

    @JsonProperty("je4")
    @JSONField(name="je4")
    private String je4_金额_2000以上;

    @JsonProperty("zjbzxbm")
    @JSONField(name="zjbzxbm")
    private String zjbzxbm_住建部中心编码;

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

    public String getJe1_金额_500_1000() {
        return je1_金额_500_1000;
    }

    public void setJe1_金额_500_1000(String je1_金额_500_1000) {
        this.je1_金额_500_1000 = je1_金额_500_1000;
    }

    public String getJe2_金额_1000_1500() {
        return je2_金额_1000_1500;
    }

    public void setJe2_金额_1000_1500(String je2_金额_1000_1500) {
        this.je2_金额_1000_1500 = je2_金额_1000_1500;
    }

    public String getJe3_金额_1500_2000() {
        return je3_金额_1500_2000;
    }

    public void setJe3_金额_1500_2000(String je3_金额_1500_2000) {
        this.je3_金额_1500_2000 = je3_金额_1500_2000;
    }

    public String getJe4_金额_2000以上() {
        return je4_金额_2000以上;
    }

    public void setJe4_金额_2000以上(String je4_金额_2000以上) {
        this.je4_金额_2000以上 = je4_金额_2000以上;
    }

    public String getZjbzxbm_住建部中心编码() {
        return zjbzxbm_住建部中心编码;
    }

    public void setZjbzxbm_住建部中心编码(String zjbzxbm_住建部中心编码) {
        this.zjbzxbm_住建部中心编码 = zjbzxbm_住建部中心编码;
    }
}