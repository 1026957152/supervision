package org.ylgjj.loan.output_;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H9_2信息推送量查询_渠道访问总量查询 {


    @JsonProperty("bm")
    @JSONField(name="bm")
    private String bm_渠道分类编码;

    @JsonProperty("mc")
    @JSONField(name="mc")
    private String mc_渠道分类名称;

    @JsonProperty("count")
    @JSONField(name="count")
    private int count_数量;

    public String getBm_渠道分类编码() {
        return bm_渠道分类编码;
    }

    public void setBm_渠道分类编码(String bm_渠道分类编码) {
        this.bm_渠道分类编码 = bm_渠道分类编码;
    }

    public String getMc_渠道分类名称() {
        return mc_渠道分类名称;
    }

    public void setMc_渠道分类名称(String mc_渠道分类名称) {
        this.mc_渠道分类名称 = mc_渠道分类名称;
    }

    public int getCount_数量() {
        return count_数量;
    }

    public void setCount_数量(int count_数量) {
        this.count_数量 = count_数量;
    }
}