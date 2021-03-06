package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH_7_1_大额资金监控_监控数据明细查询 {

        @NotBlank
        String zjbzxbm; //zjbzxbm	住建部中心编码	String	输入(必传)	  长度：6，举例：C61010
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

        public void setKsrq(String ksrq) {
                this.ksrq = ksrq;
        }

        public String getJsrq() {
                return jsrq;
        }

        public void setJsrq(String jsrq) {
                this.jsrq = jsrq;
        }

/*    zjbzxbm	住建部中心编码	String	输入(必传)	 长度：6，举例：C61010
    ksrq	开始日期	String	输入(必传)	长度：10，举例：2019-07-03
    jsrq	结束日期	String	输入(必传)	长度：10，举例：2019-07-03*/

}

