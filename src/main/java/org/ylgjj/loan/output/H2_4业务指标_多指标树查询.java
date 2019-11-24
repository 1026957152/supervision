package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_4业务指标_多指标树查询 {


    private boolean success_添加成功或者失败_Boolean;
    private String bm_指标编码_String;
    private String mc_指标名称_String;
    private String parent_父节点_String;
    private int level_级别_int;
    private String xmsm_指标说明_String;
    private int xsjd_显示精度_int;
    private String tjlxbm_统计类型编码_String;
    private String xm_unit_指标单位_String;

}