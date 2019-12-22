package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_4业务指标_多指标树查询 {



    private String bm_指标编码_String;
    private String mc_指标名称_String;
    private String parent_父节点_String;
    private Integer level_级别_int;
    private String xmsm_指标说明_String;
    private Integer xsjd_显示精度_int;
    private String tjlxbm_统计类型编码_String;
    private String xm_unit_指标单位_String;
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