package org.ylgjj.loan.output_;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_6业务指标_网格查询 {


    @JsonProperty("dimension1")
    @JSONField(name="dimension1")
    private String dimension1_维度编码_String_输出;
    @JsonProperty("dimensionmc1")
    @JSONField(name="dimensionmc1")
    private String dimensionmc1_维度名称_String_输出;

    @JsonProperty("value1")
    @JSONField(name="value1")
    private String value1_指标值_String_输出;

    @JsonProperty("only")
    @JSONField(name="only")
    private String only_本次查询的唯一标识符_String_输出;

}