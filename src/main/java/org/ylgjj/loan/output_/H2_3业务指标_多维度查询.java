package org.ylgjj.loan.output_;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_3业务指标_多维度查询 {

    @JsonProperty("bm")
    @JSONField(name="bm")
    private String bm_维度编码_String;

    @JsonProperty("mc")
    @JSONField(name="mc")
    private String mc_维度名称_String;

}