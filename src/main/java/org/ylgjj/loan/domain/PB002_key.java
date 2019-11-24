package org.ylgjj.loan.domain;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;


public class PB002_key implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(name = "centerid")
    private String centerid_不可为空_城市中心代码;



    @Column(name = "summarycode")
    private String summarycode_不可为空_摘要码; //9开头凭证摘要,1-8开头业务摘要		0:不可为空	摘要码



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getCenterid_不可为空_城市中心代码() {
        return centerid_不可为空_城市中心代码;
    }

    public void setCenterid_不可为空_城市中心代码(String centerid_不可为空_城市中心代码) {
        this.centerid_不可为空_城市中心代码 = centerid_不可为空_城市中心代码;
    }

    public String getSummarycode_不可为空_摘要码() {
        return summarycode_不可为空_摘要码;
    }

    public void setSummarycode_不可为空_摘要码(String summarycode_不可为空_摘要码) {
        this.summarycode_不可为空_摘要码 = summarycode_不可为空_摘要码;
    }
}

