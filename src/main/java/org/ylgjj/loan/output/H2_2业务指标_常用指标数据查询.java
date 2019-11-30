package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_2业务指标_常用指标数据查询 {

    private String zjbzxbm_住建部中心编码_String_输出;
    private String xmbm_指标编码_String_输出;
    private String xmmc_指标名称_String_输出;

    public String getZjbzxbm_住建部中心编码_String_输出() {
        return zjbzxbm_住建部中心编码_String_输出;
    }

    public void setZjbzxbm_住建部中心编码_String_输出(String zjbzxbm_住建部中心编码_String_输出) {
        this.zjbzxbm_住建部中心编码_String_输出 = zjbzxbm_住建部中心编码_String_输出;
    }

    public String getXmbm_指标编码_String_输出() {
        return xmbm_指标编码_String_输出;
    }

    public void setXmbm_指标编码_String_输出(String xmbm_指标编码_String_输出) {
        this.xmbm_指标编码_String_输出 = xmbm_指标编码_String_输出;
    }

    public String getXmmc_指标名称_String_输出() {
        return xmmc_指标名称_String_输出;
    }

    public void setXmmc_指标名称_String_输出(String xmmc_指标名称_String_输出) {
        this.xmmc_指标名称_String_输出 = xmmc_指标名称_String_输出;
    }
}