package org.ylgjj.loan.pojo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.NotBlank;

public class QueryH_2_5_业务指标_多维度查询 {
       // @NotBlank
        String zjbzxbm;



        //@NotBlank
        String dimension1;
       // @NotBlank
        String dimension2;
     //   @NotBlank
        String dimension3;

       // @NotBlank
        String tjzq;//	统计周期	String	输入(必传)

       // @NotBlank
        String rows;//	rows	行	String	输入(必传)

      //  @NotBlank
        String order;//	order		String	输入(必传)
       @NotBlank
        String target;//	target	目标	String	输入(必传)
       // @NotBlank
        String level;//级别	String	输入(必传)

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

        public QueryH_2_5_业务指标_多维度查询() {
        }

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

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    ;

}
