package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H9_4信息推送量查询_用户性别查询 {



    private String mc_性别;
    private String count_人数;

    public String getMc_性别() {
        return mc_性别;
    }

    public void setMc_性别(String mc_性别) {
        this.mc_性别 = mc_性别;
    }

    public String getCount_人数() {
        return count_人数;
    }

    public void setCount_人数(String count_人数) {
        this.count_人数 = count_人数;
    }
}