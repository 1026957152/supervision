package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH8_1银行专户余额_银行专户余额查询 {
        @NotBlank
        String zjbzxbm;


      @NotBlank
        String jsrq; //结束日期	String	输入(必传)	长度：10，举例：2019-07-03
        public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }



        public String getJsrq() {
            return jsrq;
        }

        public void setJsrq(String jsrq) {
            this.jsrq = jsrq;
        }


    }