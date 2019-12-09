package org.ylgjj.loan.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QueryH10_2逾期监管_逾期监管明细查询 {
    @JsonProperty("zjbzxbm")
    @JSONField(name="zjbzxbm")
       @NotBlank
        String zjbzxbm_住建部中心编码; //zjbzxbm	住建部中心编码	String	输入(必传)	  长度：6，举例：C61010



      @JsonProperty("pageSize")
      @JSONField(name="pageSize")
      @NotNull
        Integer pageSize; //pageSize	分页每页显示条数	Int		10

      @JsonProperty("pageNumber")
      @JSONField(name="pageNumber")
      @NotNull
        Integer pageNumber; //pageNumber	分页显示页面	int		1




      @NotBlank

    @JsonProperty("bm")
    @JSONField(name="bm")
        String bm;

    @NotBlank
    @JsonProperty("ksrq")
    @JSONField(name="ksrq")
    String ksrq_开始日期;

    @NotBlank
    @JsonProperty("jsrq")
    @JSONField(name="jsrq")
    String jsrq_结束日期;





        /*        bm	逾期分类编码	String		01:1个月（含）以上、3个月以下
        02:3个月（含）以上、6个月以下
        03:6个月（含）以上、1年以下
        04:1年（含）以上、3年以下
        05:3年（含）以上详细信息
        06:六期（含）以上详细信息
                */
        public String getZjbzxbm_住建部中心编码() {
            return zjbzxbm_住建部中心编码;
        }

        public void setZjbzxbm_住建部中心编码(String zjbzxbm_住建部中心编码) {
            this.zjbzxbm_住建部中心编码 = zjbzxbm_住建部中心编码;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }

        public String getBm() {
            return bm;
        }

        public void setBm(String bm) {
            this.bm = bm;
        }

    public String getKsrq_开始日期() {
        return ksrq_开始日期;
    }

    public void setKsrq_开始日期(String ksrq_开始日期) {
        this.ksrq_开始日期 = ksrq_开始日期;
    }

    public String getJsrq_结束日期() {
        return jsrq_结束日期;
    }

    public void setJsrq_结束日期(String jsrq_结束日期) {
        this.jsrq_结束日期 = jsrq_结束日期;
    }

    public QueryH10_2逾期监管_逾期监管明细查询() {
        }
    }