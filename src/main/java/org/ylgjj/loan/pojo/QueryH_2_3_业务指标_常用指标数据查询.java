package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH_2_3_业务指标_常用指标数据查询 {
        @NotBlank
        String zjbzxbm;
    @NotBlank
    String xmbm_指标编码; //String	输入(必传)	对应编码规则中统计指标编码的指标编码，举例：0301000101

        @NotBlank
        String ksrq; //开始日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        String jsrq; //结束日期	String	输入(必传)	长度：10，举例：2019-07-03
        public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }

        public String getKsrq() {
            return ksrq;
        }

    public String getXmbm_指标编码() {
        return xmbm_指标编码;
    }

    public void setXmbm_指标编码(String xmbm_指标编码) {
        this.xmbm_指标编码 = xmbm_指标编码;
    }

    public void setKsrq(String ksrq) {
            this.ksrq = ksrq;
        }

        public String getJsrq() {
            return jsrq;
        }

        public void setJsrq(String jsrq) {
            this.jsrq = jsrq;
        }
    }