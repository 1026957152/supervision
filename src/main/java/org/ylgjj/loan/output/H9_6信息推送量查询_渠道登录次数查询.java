package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H9_6信息推送量查询_渠道登录次数查询 {


    public String getName_渠道名称() {
        return name_渠道名称;
    }

    public void setName_渠道名称(String name_渠道名称) {
        this.name_渠道名称 = name_渠道名称;
    }

    public String getCount_条数() {
        return count_条数;
    }

    public void setCount_条数(String count_条数) {
        this.count_条数 = count_条数;
    }



    @JsonProperty("name")
    @JSONField(name="name")
    private String name_渠道名称;


    @JsonProperty("count")
    @JSONField(name="count")
    private String count_条数;

}