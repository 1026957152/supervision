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
    private double zybj_不可为空_转移本金;
    @Column(name = "zylx")
    private double zylx_不可为空_转移利息;
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

    public String getLxhbh_不可为空_联系函编号() {
        return lxhbh_不可为空_联系函编号;
    }

    public void setLxhbh_不可为空_联系函编号(String lxhbh_不可为空_联系函编号) {
        this.lxhbh_不可为空_联系函编号 = lxhbh_不可为空_联系函编号;
    }

    public String getJylx_不可为空_交易类型() {
        return jylx_不可为空_交易类型;
    }

    public void setJylx_不可为空_交易类型(String jylx_不可为空_交易类型) {
        this.jylx_不可为空_交易类型 = jylx_不可为空_交易类型;
    }

    public String getPlbh_不可为空_批量编号() {
        return plbh_不可为空_批量编号;
    }

    public void setPlbh_不可为空_批量编号(String plbh_不可为空_批量编号) {
        this.plbh_不可为空_批量编号 = plbh_不可为空_批量编号;
    }

    public double getZybj_不可为空_转移本金() {
        return zybj_不可为空_转移本金;
    }

    public void setZybj_不可为空_转移本金(double zybj_不可为空_转移本金) {
        this.zybj_不可为空_转移本金 = zybj_不可为空_转移本金;
    }

    public double getZylx_不可为空_转移利息() {
        return zylx_不可为空_转移利息;
    }

    public void setZylx_不可为空_转移利息(double zylx_不可为空_转移利息) {
        this.zylx_不可为空_转移利息 = zylx_不可为空_转移利息;
    }

    public String getZyje_不可为空_转移金额() {
        return zyje_不可为空_转移金额;
    }

    public void setZyje_不可为空_转移金额(String zyje_不可为空_转移金额) {
        this.zyje_不可为空_转移金额 = zyje_不可为空_转移金额;
    }

    public String getKhrq_不可为空_开户日期() {
        return khrq_不可为空_开户日期;
    }

    public void setKhrq_不可为空_开户日期(String khrq_不可为空_开户日期) {
        this.khrq_不可为空_开户日期 = khrq_不可为空_开户日期;
    }

    public String getJzny_不可为空_本年缴至年月() {
        return jzny_不可为空_本年缴至年月;
    }

    public void setJzny_不可为空_本年缴至年月(String jzny_不可为空_本年缴至年月) {
        this.jzny_不可为空_本年缴至年月 = jzny_不可为空_本年缴至年月;
    }

    public String getHjbz_不可为空_连续6个月汇缴标志() {
        return hjbz_不可为空_连续6个月汇缴标志;
    }

    public void setHjbz_不可为空_连续6个月汇缴标志(String hjbz_不可为空_连续6个月汇缴标志) {
        this.hjbz_不可为空_连续6个月汇缴标志 = hjbz_不可为空_连续6个月汇缴标志;
    }

    public String getDkcs_可为空_在转出地使用住房公积金贷款次数() {
        return dkcs_可为空_在转出地使用住房公积金贷款次数;
    }

    public void setDkcs_可为空_在转出地使用住房公积金贷款次数(String dkcs_可为空_在转出地使用住房公积金贷款次数) {
        this.dkcs_可为空_在转出地使用住房公积金贷款次数 = dkcs_可为空_在转出地使用住房公积金贷款次数;
    }

    public String getDkbz_不可为空_贷款标志() {
        return dkbz_不可为空_贷款标志;
    }

    public void setDkbz_不可为空_贷款标志(String dkbz_不可为空_贷款标志) {
        this.dkbz_不可为空_贷款标志 = dkbz_不可为空_贷款标志;
    }

    public String getPtpdbz_不可为空_骗提骗贷标志() {
        return ptpdbz_不可为空_骗提骗贷标志;
    }

    public void setPtpdbz_不可为空_骗提骗贷标志(String ptpdbz_不可为空_骗提骗贷标志) {
        this.ptpdbz_不可为空_骗提骗贷标志 = ptpdbz_不可为空_骗提骗贷标志;
    }

    public String getZchdbz_可为空_转出核对标志() {
        return zchdbz_可为空_转出核对标志;
    }

    public void setZchdbz_可为空_转出核对标志(String zchdbz_可为空_转出核对标志) {
        this.zchdbz_可为空_转出核对标志 = zchdbz_可为空_转出核对标志;
    }

    public String getSbyy_可为空_失败原因() {
        return sbyy_可为空_失败原因;
    }

    public void setSbyy_可为空_失败原因(String sbyy_可为空_失败原因) {
        this.sbyy_可为空_失败原因 = sbyy_可为空_失败原因;
    }

    public String getFkdm_可为空_反馈代码() {
        return fkdm_可为空_反馈代码;
    }

    public void setFkdm_可为空_反馈代码(String fkdm_可为空_反馈代码) {
        this.fkdm_可为空_反馈代码 = fkdm_可为空_反馈代码;
    }

    public String getFkxx_可为空_反馈信息() {
        return fkxx_可为空_反馈信息;
    }

    public void setFkxx_可为空_反馈信息(String fkxx_可为空_反馈信息) {
        this.fkxx_可为空_反馈信息 = fkxx_可为空_反馈信息;
    }

    public String getJyrq_不可为空_交易日期() {
        return jyrq_不可为空_交易日期;
    }

    public void setJyrq_不可为空_交易日期(String jyrq_不可为空_交易日期) {
        this.jyrq_不可为空_交易日期 = jyrq_不可为空_交易日期;
    }

    public String getYwlsh_不可为空_业务流水号() {
        return ywlsh_不可为空_业务流水号;
    }

    public void setYwlsh_不可为空_业务流水号(String ywlsh_不可为空_业务流水号) {
        this.ywlsh_不可为空_业务流水号 = ywlsh_不可为空_业务流水号;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



    ;


}
