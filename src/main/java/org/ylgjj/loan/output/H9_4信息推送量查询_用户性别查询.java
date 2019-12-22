package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H9_4信息推送量查询_用户性别查询 {


    @JsonProperty("mc")
    @JSONField(name="mc")
    private String mc_性别;

    @JsonProperty("count")
    @JSONField(name="count")
    private String count_人数;

    public String getMc_性别() {
        return mc_性别;
    }

    public void setMc_性别(String mc_性别) {
        this.mc_性别 = mc_性别;
    }

    public String getCount_人数() {
        return count_人数;
    }

    public void setCount_人数(String count_人数) {
        this.count_人数 = count_人数;
    }
}