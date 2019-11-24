package org.ylgjj.loan.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiUrl {
    private String 服务编号;
    private String 服务名称;
    private String 服务地址;
    private boolean 是否完成;

    public ApiUrl(String s, String 监管主要指标查询, String 公积金年度查询, String s1, boolean b) {

        服务编号 = s;
        服务名称 = 监管主要指标查询+"-"+公积金年度查询;
        服务地址 = s1;
        是否完成 = b;
    }

    public String get服务编号() {
        return 服务编号;
    }

    public void set服务编号(String 服务编号) {
        this.服务编号 = 服务编号;
    }

    public String get服务名称() {
        return 服务名称;
    }

    public void set服务名称(String 服务名称) {
        this.服务名称 = 服务名称;
    }

    public String get服务地址() {
        return 服务地址;
    }

    public void set服务地址(String 服务地址) {
        this.服务地址 = 服务地址;
    }

    public boolean is是否完成() {
        return 是否完成;
    }

    public void set是否完成(boolean 是否完成) {
        this.是否完成 = 是否完成;
    }
}