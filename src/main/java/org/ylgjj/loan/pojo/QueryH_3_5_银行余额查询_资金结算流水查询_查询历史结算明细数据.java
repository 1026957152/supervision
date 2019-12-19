package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据 {

        @NotBlank
        String zjbzxbm; //zjbzxbm	住建部中心编码	String	输入(必传)	  长度：6，举例：C61010
        @NotBlank
        String ksrq; //开始日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        String jsrq; //结束日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        Integer pagesize; //pageSize	分页每页显示条数	Int		10
        @NotBlank
        Integer pagenum; //pageNumber	分页显示页面	int		1
        @NotBlank
        String bm;
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

        public Integer getPagesize() {
            return pagesize;
        }

        public void setPagesize(Integer pagesize) {
            this.pagesize = pagesize;
        }

        public Integer getPagenum() {
            return pagenum;
        }

        public void setPagenum(Integer pagenum) {
            this.pagenum = pagenum;
        }

        public String getBm() {
            return bm;
        }

        public void setBm(String bm) {
            this.bm = bm;
        }
    }