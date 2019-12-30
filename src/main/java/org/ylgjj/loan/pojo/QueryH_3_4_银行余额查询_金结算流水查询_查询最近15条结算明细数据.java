package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据 {
       // @NotBlank
        String zjbzxbm;
/*        @NotBlank
        String ksrq; //开始日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        String jsrq; //结束日期	String	输入(必传)	长度：10，举例：2019-07-03*/
        public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }

    }