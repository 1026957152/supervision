package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_7业务指标_表格查询 {

    private String dimension1_维度编码_String;
    private String dimensionmc1_维度名称_String;
    private String value1_指标值_String;
    private String only_本次查询的唯一标识符_String;


}