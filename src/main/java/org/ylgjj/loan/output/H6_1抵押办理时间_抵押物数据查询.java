package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H6_1抵押办理时间_抵押物数据查询 {

    @JsonProperty("day1")
    @JSONField(name="day1")
    private String day1_7天以内_varchar__20___输出;

    @JsonProperty("day2")
    @JSONField(name="day2")
    private String day2_7__15天_varchar__20___输出;

    @JsonProperty("day3")
    @JSONField(name="day3")
    private String day3_15__30天_varchar__20___输出;

    @JsonProperty("day4")
    @JSONField(name="day4")
    private String day4_30天以上_varchar__20___输出;

    @JsonProperty("zjbzxbm")
    @JSONField(name="zjbzxbm")
    private String zjbzxbm_住建部中心编码_varchar__60___输出;


    public String getDay1_7天以内_varchar__20___输出() {
        return day1_7天以内_varchar__20___输出;
    }

    public void setDay1_7天以内_varchar__20___输出(String day1_7天以内_varchar__20___输出) {
        this.day1_7天以内_varchar__20___输出 = day1_7天以内_varchar__20___输出;
    }

    public String getDay2_7__15天_varchar__20___输出() {
        return day2_7__15天_varchar__20___输出;
    }

    public void setDay2_7__15天_varchar__20___输出(String day2_7__15天_varchar__20___输出) {
        this.day2_7__15天_varchar__20___输出 = day2_7__15天_varchar__20___输出;
    }

    public String getDay3_15__30天_varchar__20___输出() {
        return day3_15__30天_varchar__20___输出;
    }

    public void setDay3_15__30天_varchar__20___输出(String day3_15__30天_varchar__20___输出) {
        this.day3_15__30天_varchar__20___输出 = day3_15__30天_varchar__20___输出;
    }

    public String getDay4_30天以上_varchar__20___输出() {
        return day4_30天以上_varchar__20___输出;
    }

    public void setDay4_30天以上_varchar__20___输出(String day4_30天以上_varchar__20___输出) {
        this.day4_30天以上_varchar__20___输出 = day4_30天以上_varchar__20___输出;
    }

    public String getZjbzxbm_住建部中心编码_varchar__60___输出() {
        return zjbzxbm_住建部中心编码_varchar__60___输出;
    }

    public void setZjbzxbm_住建部中心编码_varchar__60___输出(String zjbzxbm_住建部中心编码_varchar__60___输出) {
        this.zjbzxbm_住建部中心编码_varchar__60___输出 = zjbzxbm_住建部中心编码_varchar__60___输出;
    }

    public enum Status {
        SUCCESS, ERROR
    }

    public H6_1抵押办理时间_抵押物数据查询() {
    }

}