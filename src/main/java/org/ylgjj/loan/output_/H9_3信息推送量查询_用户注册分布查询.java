package org.ylgjj.loan.output_;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H9_3信息推送量查询_用户注册分布查询 {


    @JsonProperty("bm")
    @JSONField(name="bm")
    private String bm_注册渠道;

    @JsonProperty("count")
    @JSONField(name="count")
    private String count_人数;

}