package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_1业务指标_添加常用指标 {

    @JsonProperty("success")
    @JSONField(name="success")
    private boolean success_添加成功或者失败_Boolean;

}