package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H1_1监管主要指标查询_公积金年度查询 {







    private String id_编号;
    private String zjbzxbm_住建部中心编码;
    private String bbxm_年度编码;

    private String bbmc_年度名称;

    public String getId_编号() {
        return id_编号;
    }

    public void setId_编号(String id_编号) {
        this.id_编号 = id_编号;
    }

    public String getZjbzxbm_住建部中心编码() {
        return zjbzxbm_住建部中心编码;
    }

    public void setZjbzxbm_住建部中心编码(String zjbzxbm_住建部中心编码) {
        this.zjbzxbm_住建部中心编码 = zjbzxbm_住建部中心编码;
    }

    public String getBbxm_年度编码() {
        return bbxm_年度编码;
    }

    public void setBbxm_年度编码(String bbxm_年度编码) {
        this.bbxm_年度编码 = bbxm_年度编码;
    }

    public String getBbmc_年度名称() {
        return bbmc_年度名称;
    }

    public void setBbmc_年度名称(String bbmc_年度名称) {
        this.bbmc_年度名称 = bbmc_年度名称;
    }
}