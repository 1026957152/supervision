package org.ylgjj.loan.pojo;

public class QueryH10_2逾期监管_逾期监管明细查询 {

      //  @NotBlank
        String zjbzxbm; //zjbzxbm	住建部中心编码	String	输入(必传)	  长度：6，举例：C61010
      //  @NotBlank
        Integer pageSize; //pageSize	分页每页显示条数	Int		10
      //  @NotBlank
        Integer pageNumber; //pageNumber	分页显示页面	int		1
     //   @NotBlank
        String bm;




        /*        bm	逾期分类编码	String		01:1个月（含）以上、3个月以下
        02:3个月（含）以上、6个月以下
        03:6个月（含）以上、1年以下
        04:1年（含）以上、3年以下
        05:3年（含）以上详细信息
        06:六期（含）以上详细信息
                */
        public String getZjbzxbm() {
            return zjbzxbm;
        }

        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
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

        public QueryH10_2逾期监管_逾期监管明细查询() {
        }
    }