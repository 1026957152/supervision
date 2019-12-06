package org.ylgjj.loan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(TR002_key.class)
@Entity
@Table(name = "TR002")

public class TR002_联系函基础信息 {
  //  plbh,lxhbh





    //lxhbh,jylx




    @Column(name = "plbh")
    private String plbh_不可为空_批量编号;

    @Id
    @Column(name = "lxhbh")
    private String lxhbh_不可为空_联系函编号;


    @Id
    @Column(name = "jylx")
    private String jylx_不可为空_交易类型;


    @Column(name = "lxhzt")
    private String lxhzt_不可为空_联系函状态;


  //  @DateTimeFormat(pattern = "yyyyMMdd")
  //  @JsonFormat(pattern = "yyyyMMdd")
    @Column(name = "lxhlrrq")
    private String lxhlrrq不可为空联系函录入日期;
            
            
    @Column(name = "xingming")
    private String xingming_不可为空_姓名;
            
            
    @Column(name = "zjlx")
    private String zjlx_不可为空_证件类型;
            
            
    @Column(name = "zjhm")
    private String zjhm_不可为空_证件号码;
            
            
    @Column(name = "ydwmc")
    private String ydwmc_不可为空_原单位名称;
            
    @Column(name = "ygrzh")
    private String ygrzh_不可为空_原个人账号;
    @Column(name = "grzh")
    private String grzh_可为空_个人账号;
    @Column(name = "dwzh")
    private String dwzh_可为空_单位账号;
    @Column(name = "dwmc")
    private String dwmc_可为空_单位名称;
    @Column(name = "sjhm")
    private String sjhm_可为空_手机号码;
    @Column(name = "cxyy")
    private String cxyy_可为空_撤销原因;
    @Column(name = "jyrq")
    private String jyrq_不可为空_交易日期;
    @Column(name = "ywlsh")
    private String ywlsh_不可为空_业务流水号;
    @Column(name = "freeuse1")
    private String freeuse1_可为空_备用字符;
    @Column(name = "freeuse2")
    private double freeuse2_可为空_备用金额;
    @Column(name = "freeuse3")
    private java.sql.Date freeuse3_可为空_备用日期;
    @Column(name = "freeuse4")
    private long freeuse4_可为空_备用数值;
    @Column(name = "freeuse5")
    private String freeuse5_可为空_备用字符;
    @Column(name = "freeuse6")
    private String freeuse6_可为空_备用字符;






    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public String getPlbh_不可为空_批量编号() {
        return plbh_不可为空_批量编号;
    }

    public void setPlbh_不可为空_批量编号(String plbh_不可为空_批量编号) {
        this.plbh_不可为空_批量编号 = plbh_不可为空_批量编号;
    }

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

    public String getLxhzt_不可为空_联系函状态() {
        return lxhzt_不可为空_联系函状态;
    }

    public void setLxhzt_不可为空_联系函状态(String lxhzt_不可为空_联系函状态) {
        this.lxhzt_不可为空_联系函状态 = lxhzt_不可为空_联系函状态;
    }

    public String getLxhlrrq不可为空联系函录入日期() {
        return lxhlrrq不可为空联系函录入日期;
    }

    public void setLxhlrrq不可为空联系函录入日期(String lxhlrrq不可为空联系函录入日期) {
        this.lxhlrrq不可为空联系函录入日期 = lxhlrrq不可为空联系函录入日期;
    }

    public String getXingming_不可为空_姓名() {
        return xingming_不可为空_姓名;
    }

    public void setXingming_不可为空_姓名(String xingming_不可为空_姓名) {
        this.xingming_不可为空_姓名 = xingming_不可为空_姓名;
    }

    public String getZjlx_不可为空_证件类型() {
        return zjlx_不可为空_证件类型;
    }

    public void setZjlx_不可为空_证件类型(String zjlx_不可为空_证件类型) {
        this.zjlx_不可为空_证件类型 = zjlx_不可为空_证件类型;
    }

    public String getZjhm_不可为空_证件号码() {
        return zjhm_不可为空_证件号码;
    }

    public void setZjhm_不可为空_证件号码(String zjhm_不可为空_证件号码) {
        this.zjhm_不可为空_证件号码 = zjhm_不可为空_证件号码;
    }

    public String getYdwmc_不可为空_原单位名称() {
        return ydwmc_不可为空_原单位名称;
    }

    public void setYdwmc_不可为空_原单位名称(String ydwmc_不可为空_原单位名称) {
        this.ydwmc_不可为空_原单位名称 = ydwmc_不可为空_原单位名称;
    }

    public String getYgrzh_不可为空_原个人账号() {
        return ygrzh_不可为空_原个人账号;
    }

    public void setYgrzh_不可为空_原个人账号(String ygrzh_不可为空_原个人账号) {
        this.ygrzh_不可为空_原个人账号 = ygrzh_不可为空_原个人账号;
    }

    public String getGrzh_可为空_个人账号() {
        return grzh_可为空_个人账号;
    }

    public void setGrzh_可为空_个人账号(String grzh_可为空_个人账号) {
        this.grzh_可为空_个人账号 = grzh_可为空_个人账号;
    }

    public String getDwzh_可为空_单位账号() {
        return dwzh_可为空_单位账号;
    }

    public void setDwzh_可为空_单位账号(String dwzh_可为空_单位账号) {
        this.dwzh_可为空_单位账号 = dwzh_可为空_单位账号;
    }

    public String getDwmc_可为空_单位名称() {
        return dwmc_可为空_单位名称;
    }

    public void setDwmc_可为空_单位名称(String dwmc_可为空_单位名称) {
        this.dwmc_可为空_单位名称 = dwmc_可为空_单位名称;
    }

    public String getSjhm_可为空_手机号码() {
        return sjhm_可为空_手机号码;
    }

    public void setSjhm_可为空_手机号码(String sjhm_可为空_手机号码) {
        this.sjhm_可为空_手机号码 = sjhm_可为空_手机号码;
    }

    public String getCxyy_可为空_撤销原因() {
        return cxyy_可为空_撤销原因;
    }

    public void setCxyy_可为空_撤销原因(String cxyy_可为空_撤销原因) {
        this.cxyy_可为空_撤销原因 = cxyy_可为空_撤销原因;
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

    public String getFreeuse1_可为空_备用字符() {
        return freeuse1_可为空_备用字符;
    }

    public void setFreeuse1_可为空_备用字符(String freeuse1_可为空_备用字符) {
        this.freeuse1_可为空_备用字符 = freeuse1_可为空_备用字符;
    }

    public double getFreeuse2_可为空_备用金额() {
        return freeuse2_可为空_备用金额;
    }

    public void setFreeuse2_可为空_备用金额(double freeuse2_可为空_备用金额) {
        this.freeuse2_可为空_备用金额 = freeuse2_可为空_备用金额;
    }

    public Date getFreeuse3_可为空_备用日期() {
        return freeuse3_可为空_备用日期;
    }

    public void setFreeuse3_可为空_备用日期(Date freeuse3_可为空_备用日期) {
        this.freeuse3_可为空_备用日期 = freeuse3_可为空_备用日期;
    }

    public long getFreeuse4_可为空_备用数值() {
        return freeuse4_可为空_备用数值;
    }

    public void setFreeuse4_可为空_备用数值(long freeuse4_可为空_备用数值) {
        this.freeuse4_可为空_备用数值 = freeuse4_可为空_备用数值;
    }

    public String getFreeuse5_可为空_备用字符() {
        return freeuse5_可为空_备用字符;
    }

    public void setFreeuse5_可为空_备用字符(String freeuse5_可为空_备用字符) {
        this.freeuse5_可为空_备用字符 = freeuse5_可为空_备用字符;
    }

    public String getFreeuse6_可为空_备用字符() {
        return freeuse6_可为空_备用字符;
    }

    public void setFreeuse6_可为空_备用字符(String freeuse6_可为空_备用字符) {
        this.freeuse6_可为空_备用字符 = freeuse6_可为空_备用字符;
    }


}
