package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH_2_1_业务指标_添加常用指标 {


        @NotBlank
        String zjbzxbm;
        @NotBlank
        String xmbm; //指标编码	String	输入(必传)	对应编码规则中统计指标编码的指标编码，举例：0301000101
        @NotBlank
        String userid; //监管平台用户id	long	输入(必传)	监管平台的用户id
        public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }

    public String getXmbm() {
        return xmbm;
    }

    public void setXmbm(String xmbm) {
        this.xmbm = xmbm;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}