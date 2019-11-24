package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH6_2抵押办理时间_抵押物明细数据查询 {

        @NotBlank
        String zjbzxbm; //zjbzxbm	住建部中心编码	varchar(6)	输入(必传)

    String ksrq; //ksrq	开始日期	date	输入(必传)
    String jsrq; //jsrq	结束日期	date	输入(必传)
    int level; //类型	int	输入(必传)





        public String getZjbzxbm() {
            return zjbzxbm;
        }

        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }
    }