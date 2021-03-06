package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H9_7信息推送量查询_用户年龄信息查询 {







    @JsonProperty("nl1")
    @JSONField(name="nl1")

    private String nl1_年龄_小于20岁;

    @JsonProperty("nl2")
    @JSONField(name="nl2")
    private String nl2_年龄_20_40;

    @JsonProperty("nl3")
    @JSONField(name="nl3")
    private String nl3_年龄_40_60;

    @JsonProperty("nl4")
    @JSONField(name="nl4")
    private String nl4_年龄_60岁以上;

    public String getNl1_年龄_小于20岁() {
        return nl1_年龄_小于20岁;
    }

    public void setNl1_年龄_小于20岁(String nl1_年龄_小于20岁) {
        this.nl1_年龄_小于20岁 = nl1_年龄_小于20岁;
    }

    public String getNl2_年龄_20_40() {
        return nl2_年龄_20_40;
    }

    public void setNl2_年龄_20_40(String nl2_年龄_20_40) {
        this.nl2_年龄_20_40 = nl2_年龄_20_40;
    }

    public String getNl3_年龄_40_60() {
        return nl3_年龄_40_60;
    }

    public void setNl3_年龄_40_60(String nl3_年龄_40_60) {
        this.nl3_年龄_40_60 = nl3_年龄_40_60;
    }

    public String getNl4_年龄_60岁以上() {
        return nl4_年龄_60岁以上;
    }

    public void setNl4_年龄_60岁以上(String nl4_年龄_60岁以上) {
        this.nl4_年龄_60岁以上 = nl4_年龄_60岁以上;
    }
}