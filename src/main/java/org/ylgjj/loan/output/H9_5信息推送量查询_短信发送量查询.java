package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H9_5信息推送量查询_短信发送量查询 {





    private String name_发送状态;
    private String count_条数;

    public String getName_发送状态() {
        return name_发送状态;
    }

    public void setName_发送状态(String name_发送状态) {
        this.name_发送状态 = name_发送状态;
    }

    public String getCount_条数() {
        return count_条数;
    }

    public void setCount_条数(String count_条数) {
        this.count_条数 = count_条数;
    }
}