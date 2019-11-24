package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@IdClass(PB002_key.class)
@Entity

@Table(name = "PB010")

public class PB002_摘要码信息表 {


    @Id
    @Column(name = "centerid")
    private String centerid_不可为空_城市中心代码;


    @Id
    @Column(name = "summarycode")
    private String summarycode_不可为空_摘要码; //9开头凭证摘要,1-8开头业务摘要		0:不可为空	摘要码




    @Column(name = "summarydes")
    private String summarydes_不可为空_摘要描述;

    @Column(name = "freeuse1")
    private String freeuse1_不可为空_备用金额;

    @Column(name = "freeuse2")
    private String freeuse2_可为空_备用金额;
    @Column(name = "freeuse3")
    private String freeuse3_可为空_备用日期;
    @Column(name = "freeuse4")
    private String freeuse4_可为空_备用数值;
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;
}
