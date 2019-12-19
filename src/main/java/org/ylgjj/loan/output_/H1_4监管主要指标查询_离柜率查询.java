package org.ylgjj.loan.output_;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H1_4监管主要指标查询_离柜率查询 {

    @JsonProperty("total")
    @JSONField(name="total")

    private int total_总条数_Int;

    @JsonProperty("jgbm")
    @JSONField(name="jgbm")
    private String jgbm_管理部编码_String;

    @JsonProperty("jgmc")
    @JSONField(name="jgmc")
    private String jgmc_管理部名称_String;

    @JsonProperty("bl")
    @JSONField(name="bl")
    private double bl_逾期率_double;




}