package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_6业务指标_网格查询 {

    private String dimension1_维度编码_String_输出;
    private String dimensionmc1_维度名称_String_输出;
    private String value1_指标值_String_输出;
    private String only_本次查询的唯一标识符_String_输出;

}