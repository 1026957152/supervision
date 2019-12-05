package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H9_8信息推送量查询_各渠道API总量 {









    private String name_渠道名称;
    private String bm_渠道编码;
    private String count_条数;

    public String getName_渠道名称() {
        return name_渠道名称;
    }

    public void setName_渠道名称(String name_渠道名称) {
        this.name_渠道名称 = name_渠道名称;
    }

    public String getBm_渠道编码() {
        return bm_渠道编码;
    }

    public void setBm_渠道编码(String bm_渠道编码) {
        this.bm_渠道编码 = bm_渠道编码;
    }

    public String getCount_条数() {
        return count_条数;
    }

    public void setCount_条数(String count_条数) {
        this.count_条数 = count_条数;
    }
}