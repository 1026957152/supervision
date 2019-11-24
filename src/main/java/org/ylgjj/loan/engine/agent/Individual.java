package org.ylgjj.loan.engine.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Individual {
    private String 个人账户余额;
    private String 个人账户状态;
    private String 个人缴存列表; //按月在增加

    private String 个人提取列表; //随机增加






    public Individual(String s, String 监管主要指标查询, String 公积金年度查询, String s1) {

     //   服务编号 = s;
       // 服务名称 = 监管主要指标查询+"-"+公积金年度查询;
      //  服务地址 = s1;
    }

}