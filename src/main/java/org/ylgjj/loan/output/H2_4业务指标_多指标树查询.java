package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_4业务指标_多指标树查询 {


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
    private Integer level_级别_int;

    @JsonProperty("xmsm")
    @JSONField(name="xmsm")
    private String xmsm_指标说明_String;

    @JsonProperty("xsjd")
    @JSONField(name="xsjd")
    private Integer xsjd_显示精度_int;

    @JsonProperty("tjlxbm")
    @JSONField(name="tjlxbm")
    private String tjlxbm_统计类型编码_String;

    @JsonProperty("xm_unit")
    @JSONField(name="xm_unit")
    private String xm_unit_指标单位_String;

    @JsonProperty("yybm")
    @JSONField(name="yybm")
    private String yybm_应用代码;


    public String getBm_指标编码_String() {
        return bm_指标编码_String;
    }

    public void setBm_指标编码_String(String bm_指标编码_String) {
        this.bm_指标编码_String = bm_指标编码_String;
    }

    public String getMc_指标名称_String() {
        return mc_指标名称_String;
    }

    public void setMc_指标名称_String(String mc_指标名称_String) {
        this.mc_指标名称_String = mc_指标名称_String;
    }

    public String getParent_父节点_String() {
        return parent_父节点_String;
    }

    public void setParent_父节点_String(String parent_父节点_String) {
        this.parent_父节点_String = parent_父节点_String;
    }

    public Integer getLevel_级别_int() {
        return level_级别_int;
    }

    public void setLevel_级别_int(Integer level_级别_int) {
        this.level_级别_int = level_级别_int;
    }

    public String getXmsm_指标说明_String() {
        return xmsm_指标说明_String;
    }

    public void setXmsm_指标说明_String(String xmsm_指标说明_String) {
        this.xmsm_指标说明_String = xmsm_指标说明_String;
    }

    public Integer getXsjd_显示精度_int() {
        return xsjd_显示精度_int;
    }

    public void setXsjd_显示精度_int(Integer xsjd_显示精度_int) {
        this.xsjd_显示精度_int = xsjd_显示精度_int;
    }

    public String getTjlxbm_统计类型编码_String() {
        return tjlxbm_统计类型编码_String;
    }

    public void setTjlxbm_统计类型编码_String(String tjlxbm_统计类型编码_String) {
        this.tjlxbm_统计类型编码_String = tjlxbm_统计类型编码_String;
    }

    public String getXm_unit_指标单位_String() {
        return xm_unit_指标单位_String;
    }

    public void setXm_unit_指标单位_String(String xm_unit_指标单位_String) {
        this.xm_unit_指标单位_String = xm_unit_指标单位_String;
    }

    public void setYybm_应用代码(String yybm_应用代码) {
        this.yybm_应用代码 = yybm_应用代码;
    }

    public String getYybm_应用代码() {
        return yybm_应用代码;
    }
}