package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_5业务指标_查询常用指标 {

    @JsonProperty("bm")
    @JSONField(name="bm")
    private String bm_维度编码_String;

    @JsonProperty("mc")
    @JSONField(name="mc")
    private String mc_维度名称_String;

    public String getBm_维度编码_String() {
        return bm_维度编码_String;
    }

    public void setBm_维度编码_String(String bm_维度编码_String) {
        this.bm_维度编码_String = bm_维度编码_String;
    }

    public String getMc_维度名称_String() {
        return mc_维度名称_String;
    }

    public void setMc_维度名称_String(String mc_维度名称_String) {
        this.mc_维度名称_String = mc_维度名称_String;
    }
}