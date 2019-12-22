package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH_2_4_业务指标_多指标树查询 {
        @NotBlank
        String zjbzxbm;
    @NotBlank

    private String parent_父节点;
    @NotBlank
    private String level_级别;

    @NotBlank
    private String yybm_应用代码;

    public String getParent_父节点() {
        return parent_父节点;
    }

    public void setParent_父节点(String parent_父节点) {
        this.parent_父节点 = parent_父节点;
    }

    public String getLevel_级别() {
        return level_级别;
    }

    public void setLevel_级别(String level_级别) {
        this.level_级别 = level_级别;
    }

    public String getYybm_应用代码() {
        return yybm_应用代码;
    }

    public void setYybm_应用代码(String yybm_应用代码) {
        this.yybm_应用代码 = yybm_应用代码;
    }

    public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }


    }
