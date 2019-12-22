package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_7业务指标_表格查询 {


    @JsonProperty("dimension1")
    @JSONField(name="dimension1")
    private String dimension1_维度编码_String;

    @JsonProperty("dimensionmc1")
    @JSONField(name="dimensionmc1")
    private String dimensionmc1_维度名称_String;

    @JsonProperty("value1")
    @JSONField(name="value1")
    private String value1_指标值_String;

    @JsonProperty("only")
    @JSONField(name="only")
    private String only_本次查询的唯一标识符_String;


}