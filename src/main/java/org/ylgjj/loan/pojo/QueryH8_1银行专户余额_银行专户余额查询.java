package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH8_1银行专户余额_银行专户余额查询 {
        @NotBlank
        String zjbzxbm;
      //  @NotBlank
        String ksrq; //开始日期	String	输入(必传)	长度：10，举例：2019-07-03
      //  @NotBlank
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

     //   @NotBlank
        Integer ksje;//ksje	开始金额(金额范围)	Int	输入(必传)	500W

    //    @NotBlank
        Integer jsje;//	结束金额(金额范围)	int	输入(必传)	0W

     //   @NotBlank
        Integer page;//	页码	Int	输入(必传)

    //    @NotBlank
        Integer size;//	每页显示条数	int	输入(必传)


        public Integer getKsje() {
            return ksje;
        }

        public void setKsje(Integer ksje) {
            this.ksje = ksje;
        }

        public Integer getJsje() {
            return jsje;
        }

        public void setJsje(Integer jsje) {
            this.jsje = jsje;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }
    }