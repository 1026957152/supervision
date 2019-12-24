package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH_2_2_业务指标_查询常用指标 {
        @NotBlank
        String zjbzxbm;

    @NotBlank
    String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }


    }
