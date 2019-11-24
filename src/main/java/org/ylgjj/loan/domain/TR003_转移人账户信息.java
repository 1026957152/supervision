package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(TR003_key.class)
@Entity
@Table(name = "TR003")

public class TR003_转移人账户信息 {

    @Id
    @Column(name = "lxhbh")
    private String lxhbh_不可为空_联系函编号;

    @Id
    @Column(name = "jylx")
    private String jylx_不可为空_交易类型;

    @Column(name = "plbh")
    private String plbh_不可为空_批量编号;



    @Column(name = "zybj")
    private String zybj_不可为空_转移本金;
    @Column(name = "zylx")
    private String zylx_不可为空_转移利息;
    @Column(name = "zyje")
    private String zyje_不可为空_转移金额;
    @Column(name = "khrq")
    private String khrq_不可为空_开户日期;
    @Column(name = "jzny")
    private String jzny_不可为空_本年缴至年月;
    @Column(name = "hjbz")
    private String hjbz_不可为空_连续6个月汇缴标志 ; //		1-是,2-否	0:
    @Column(name = "dkcs")
    private String dkcs_可为空_在转出地使用住房公积金贷款次数;
    @Column(name = "dkbz")
    private String dkbz_不可为空_贷款标志; //	1-是,2-否	0:
    @Column(name = "ptpdbz")
    private String ptpdbz_不可为空_骗提骗贷标志;  //	1-是,2-否
    @Column(name = "zchdbz")
    private String zchdbz_可为空_转出核对标志; //	1-成功,2-失败	1:
    @Column(name = "sbyy")
    private String sbyy_可为空_失败原因;
    @Column(name = "fkdm")
    private String fkdm_可为空_反馈代码;  //	0-已完成, 1-失败, 2-处理中	1:
    @Column(name = "fkxx")
    private String fkxx_可为空_反馈信息;
    @Column(name = "jyrq")
    private String jyrq_不可为空_交易日期;
    @Column(name = "ywlsh")
    private String ywlsh_不可为空_业务流水号;




    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



    ;


}
