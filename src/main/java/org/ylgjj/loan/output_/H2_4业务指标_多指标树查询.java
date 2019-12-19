package org.ylgjj.loan.output_;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_4业务指标_多指标树查询 {

    @JsonProperty("success")
    @JSONField(name="success")
    private boolean success_添加成功或者失败_Boolean;

    @JsonProperty("bm")
    @JSONField(name="bm")
    private String bm_指标编码_String;

    @JsonProperty("mc")
    @JSONField(name="mc")
    private String mc_指标名称_String;

    @JsonProperty("parent")
    @JSONField(name="parent")
    private String parent_父节点_String;

    @JsonProperty("level")
    @JSONField(name="level")
    private int level_级别_int;

    @JsonProperty("xmsm")
    @JSONField(name="xmsm")
    private String xmsm_指标说明_String;

    @JsonProperty("xsjd")
    @JSONField(name="xsjd")
    private int xsjd_显示精度_int;

    @JsonProperty("tjlxbm")
    @JSONField(name="tjlxbm")
    private String tjlxbm_统计类型编码_String;

    @JsonProperty("xm_unit")
    @JSONField(name="xm_unit")
    private String xm_unit_指标单位_String;

}