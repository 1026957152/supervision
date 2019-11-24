package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class Query {
/*
    @NotBlank
    String zjbzxbm;*/
    @NotBlank
    String xingming;

    @NotBlank
    String zjhm;

    @NotBlank
    String appid;

    @NotBlank
    String sign;

    @NotBlank
    String zjhlx;

    @NotBlank
    String citybm;

    public String getZjhlx() {
        return zjhlx;
    }

    public void setZjhlx(String zjhlx) {
        this.zjhlx = zjhlx;
    }

    public String getCitybm() {
        return citybm;
    }

    public void setCitybm(String citybm) {
        this.citybm = citybm;
    }

/*
    public String getZjbzxbm() {
        return zjbzxbm;
    }

    public void setZjbzxbm(String zjbzxbm) {
        this.zjbzxbm = zjbzxbm;
    }
*/

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }



    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
