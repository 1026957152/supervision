package org.ylgjj.loan.engine.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class organization {
    private String 服务编号;
    private String 服务名称;
    private String 服务地址;

    private String 单位账户余额;
    private String 单位账户状态;
    private String 单位缴存列表; //按月在增加



    public organization(String s, String 监管主要指标查询, String 公积金年度查询, String s1) {

        服务编号 = s;
        服务名称 = 监管主要指标查询+"-"+公积金年度查询;
        服务地址 = s1;
    }

}