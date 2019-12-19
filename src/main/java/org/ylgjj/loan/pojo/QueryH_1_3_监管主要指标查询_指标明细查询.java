package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH_1_3_监管主要指标查询_指标明细查询 {

        @NotBlank
        String zjbzxbm; //zjbzxbm	住建部中心编码	String	输入(必传)	  长度：6，举例：C61010

        @NotBlank
        String dimension1; //维度1	String	输入(必传)
        @NotBlank
        String dimension2; //维度2	String	输入(必传)
        @NotBlank
        String dimension3; //维度3	String	输入(必传)
        @NotBlank
        String tjzq; //统计周期	String	输入(必传) 对应编码规则中统计周期编码的编码值
        @NotBlank
        String rows; //行	String	输入(必传) 可以忽略

        @NotBlank
        String order; //String	输入(必传) 举例：1,2,3,4或者4,3,2,1任意排序组合

        @NotBlank
        String target; //目标	String	输入(必传) 对应编码规则中统计指标编码的指标编码，举例：0301000101












        @NotBlank
        String ksrq; //开始日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        String jsrq; //结束日期	String	输入(必传)	长度：10，举例：2019-07-03

        public String getDimension1() {
            return dimension1;
        }

        public void setDimension1(String dimension1) {
            this.dimension1 = dimension1;
        }

        public String getDimension2() {
            return dimension2;
        }

        public void setDimension2(String dimension2) {
            this.dimension2 = dimension2;
        }

        public String getDimension3() {
            return dimension3;
        }

        public void setDimension3(String dimension3) {
            this.dimension3 = dimension3;
        }

        public String getTjzq() {
            return tjzq;
        }

        public void setTjzq(String tjzq) {
            this.tjzq = tjzq;
        }

        public String getRows() {
            return rows;
        }

        public void setRows(String rows) {
            this.rows = rows;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

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


    }