package org.ylgjj.loan.pojo;

import javax.validation.constraints.NotBlank;

public class QueryH6_1抵押办理时间_抵押物数据查询 {

        @NotBlank
        String zjbzxbm;

        public String getZjbzxbm() {
            return zjbzxbm;
        }

        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }
    }