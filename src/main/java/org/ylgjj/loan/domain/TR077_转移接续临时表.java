package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(TR077_key.class)
@Entity
@Table(name = "TR077")

public class TR077_转移接续临时表 {
  //  instance,zjhm
  @Id
    @Column(name = "instance")
    private long instance_不可为空_实例号;//

    @Id
    @Column(name = "zjhm")
    private String zjhm_不可为空_证件号码;//

    @Column(name = "jyrq")
    private String jyrq_可为空_交易日期;//

    @Column(name = "plbh")
    private String plbh_可为空_批量编号;//
    @Column(name = "ywbs")
    private String ywbs_可为空_业务标识;//	0-单笔,1-批量
    @Column(name = "jylx")
    private String jylx_可为空_交易类型;//	1-转入,2-转出
    @Column(name = "zrzxyh")
    private String zrzxyh_可为空_转入中心银行;//
    @Column(name = "zrzxyhzh")
    private String zrzxyhzh_可为空_转入中心银行账号;//
    @Column(name = "zrzxyhzhmc")
    private String zrzxyhzhmc_可为空_转入中心银行账户名称;//
    @Column(name = "zrzxjg")
    private String zrzxjg_可为空_转入中心机构;//
    @Column(name = "zrzxdh")
    private String zrzxdh_可为空_转入中心电话;//
    @Column(name = "zcjgbh")
    private String zcjgbh_可为空_转出机构编号;//
    @Column(name = "zczxmc")
    private String zczxmc_可为空_转出中心名称;//
    @Column(name = "lxhbh")
    private String lxhbh_可为空_联系函编号;//
    @Column(name = "lxhzt")
    private String lxhzt_可为空_联系函状态;//
    @Column(name = "lxhlrrq")
    private String lxhlrrq_可为空_联系函录入日期;//
    @Column(name = "xingming")
    private String xingming_可为空_姓名;//
    @Column(name = "zjlx")
    private String zjlx_可为空_证件类型;//


    @Column(name = "ydwmc")
    private String ydwmc_可为空_原单位名称;//
    @Column(name = "ygrzh")
    private String ygrzh_可为空_原个人账号;//
    @Column(name = "grzh")
    private String grzh_可为空_个人账号;//
    @Column(name = "dwzh")
    private String dwzh_可为空_单位账号;//
    @Column(name = "dwmc")
    private String dwmc_可为空_单位名称;//
    @Column(name = "sjhm")
    private String sjhm_可为空_手机号码;//
    @Column(name = "zybj")
    private Double zybj_可为空_转移本金;//
    @Column(name = "zylx")
    private Double zylx_可为空_转移利息;//
    @Column(name = "zyje")
    private Double zyje_可为空_转移金额;//
    @Column(name = "khrq")
    private String khrq_可为空_开户日期;//
    @Column(name = "jzny")
    private String jzny_可为空_本年缴至年月;//
    @Column(name = "hjbz")
    private String hjbz_可为空_连续6个月汇缴标志;//	1-是,2-否
    @Column(name = "dkcs")
    private Long dkcs_可为空_在转出地使用住房公积金贷款次数;//
    @Column(name = "dkbz")
    private String dkbz_可为空_贷款标志;//	1-是,2-否
    @Column(name = "ptpdbz")
    private String ptpdbz_可为空_骗提骗贷标志;//	1-是,2-否
    @Column(name = "zchdbz")
    private String zchdbz_可为空_转出核对标志;//	1-成功,2-失败
    @Column(name = "sbyy")
    private String sbyy_可为空_失败原因;//
    @Column(name = "fkdm")
    private String fkdm_可为空_反馈代码;//	0-已完成, 1-失败, 2-处理中
    @Column(name = "fkxx")
    private String fkxx_可为空_反馈信息;//
    @Column(name = "cxyy")
    private String cxyy_可为空_撤销原因;//
    @Column(name = "freeuse1")
    private String freeuse1_可为空_备用字符;//
    @Column(name = "freeuse2")
    private Double freeuse2_可为空_备用金额;//
    @Column(name = "freeuse3")
    private java.sql.Date freeuse3_可为空_备用日期;//
    @Column(name = "freeuse4")
    private Long freeuse4_可为空_备用数值;//
    @Column(name = "freeuse5")
    private String freeuse5_可为空_备用字符;//
    @Column(name = "freeuse6")
    private String freeuse6_可为空_备用字符;//
    @Column(name = "trjbrxm")
    private String trjbrxm_可为空_TR经办人姓名;//
    @Column(name = "trjbrsjhm")
    private String trjbrsjhm_可为空_TR手机号码;//
    @Column(name = "trjbrzjhm")
    private String trjbrzjhm_可为空_TR经办人证件号;//	


    public long getInstance_不可为空_实例号() {
        return instance_不可为空_实例号;
    }

    public void setInstance_不可为空_实例号(long instance_不可为空_实例号) {
        this.instance_不可为空_实例号 = instance_不可为空_实例号;
    }

    public String getJyrq_可为空_交易日期() {
        return jyrq_可为空_交易日期;
    }

    public void setJyrq_可为空_交易日期(String jyrq_可为空_交易日期) {
        this.jyrq_可为空_交易日期 = jyrq_可为空_交易日期;
    }

    public String getPlbh_可为空_批量编号() {
        return plbh_可为空_批量编号;
    }

    public void setPlbh_可为空_批量编号(String plbh_可为空_批量编号) {
        this.plbh_可为空_批量编号 = plbh_可为空_批量编号;
    }

    public String getYwbs_可为空_业务标识() {
        return ywbs_可为空_业务标识;
    }

    public void setYwbs_可为空_业务标识(String ywbs_可为空_业务标识) {
        this.ywbs_可为空_业务标识 = ywbs_可为空_业务标识;
    }

    public String getJylx_可为空_交易类型() {
        return jylx_可为空_交易类型;
    }

    public void setJylx_可为空_交易类型(String jylx_可为空_交易类型) {
        this.jylx_可为空_交易类型 = jylx_可为空_交易类型;
    }

    public String getZrzxyh_可为空_转入中心银行() {
        return zrzxyh_可为空_转入中心银行;
    }

    public void setZrzxyh_可为空_转入中心银行(String zrzxyh_可为空_转入中心银行) {
        this.zrzxyh_可为空_转入中心银行 = zrzxyh_可为空_转入中心银行;
    }

    public String getZrzxyhzh_可为空_转入中心银行账号() {
        return zrzxyhzh_可为空_转入中心银行账号;
    }

    public void setZrzxyhzh_可为空_转入中心银行账号(String zrzxyhzh_可为空_转入中心银行账号) {
        this.zrzxyhzh_可为空_转入中心银行账号 = zrzxyhzh_可为空_转入中心银行账号;
    }

    public String getZrzxyhzhmc_可为空_转入中心银行账户名称() {
        return zrzxyhzhmc_可为空_转入中心银行账户名称;
    }

    public void setZrzxyhzhmc_可为空_转入中心银行账户名称(String zrzxyhzhmc_可为空_转入中心银行账户名称) {
        this.zrzxyhzhmc_可为空_转入中心银行账户名称 = zrzxyhzhmc_可为空_转入中心银行账户名称;
    }

    public String getZrzxjg_可为空_转入中心机构() {
        return zrzxjg_可为空_转入中心机构;
    }

    public void setZrzxjg_可为空_转入中心机构(String zrzxjg_可为空_转入中心机构) {
        this.zrzxjg_可为空_转入中心机构 = zrzxjg_可为空_转入中心机构;
    }

    public String getZrzxdh_可为空_转入中心电话() {
        return zrzxdh_可为空_转入中心电话;
    }

    public void setZrzxdh_可为空_转入中心电话(String zrzxdh_可为空_转入中心电话) {
        this.zrzxdh_可为空_转入中心电话 = zrzxdh_可为空_转入中心电话;
    }

    public String getZcjgbh_可为空_转出机构编号() {
        return zcjgbh_可为空_转出机构编号;
    }

    public void setZcjgbh_可为空_转出机构编号(String zcjgbh_可为空_转出机构编号) {
        this.zcjgbh_可为空_转出机构编号 = zcjgbh_可为空_转出机构编号;
    }

    public String getZczxmc_可为空_转出中心名称() {
        return zczxmc_可为空_转出中心名称;
    }

    public void setZczxmc_可为空_转出中心名称(String zczxmc_可为空_转出中心名称) {
        this.zczxmc_可为空_转出中心名称 = zczxmc_可为空_转出中心名称;
    }

    public String getLxhbh_可为空_联系函编号() {
        return lxhbh_可为空_联系函编号;
    }

    public void setLxhbh_可为空_联系函编号(String lxhbh_可为空_联系函编号) {
        this.lxhbh_可为空_联系函编号 = lxhbh_可为空_联系函编号;
    }

    public String getLxhzt_可为空_联系函状态() {
        return lxhzt_可为空_联系函状态;
    }

    public void setLxhzt_可为空_联系函状态(String lxhzt_可为空_联系函状态) {
        this.lxhzt_可为空_联系函状态 = lxhzt_可为空_联系函状态;
    }

    public String getLxhlrrq_可为空_联系函录入日期() {
        return lxhlrrq_可为空_联系函录入日期;
    }

    public void setLxhlrrq_可为空_联系函录入日期(String lxhlrrq_可为空_联系函录入日期) {
        this.lxhlrrq_可为空_联系函录入日期 = lxhlrrq_可为空_联系函录入日期;
    }

    public String getXingming_可为空_姓名() {
        return xingming_可为空_姓名;
    }

    public void setXingming_可为空_姓名(String xingming_可为空_姓名) {
        this.xingming_可为空_姓名 = xingming_可为空_姓名;
    }

    public String getZjlx_可为空_证件类型() {
        return zjlx_可为空_证件类型;
    }

    public void setZjlx_可为空_证件类型(String zjlx_可为空_证件类型) {
        this.zjlx_可为空_证件类型 = zjlx_可为空_证件类型;
    }

    public String getZjhm_不可为空_证件号码() {
        return zjhm_不可为空_证件号码;
    }

    public void setZjhm_不可为空_证件号码(String zjhm_不可为空_证件号码) {
        this.zjhm_不可为空_证件号码 = zjhm_不可为空_证件号码;
    }

    public String getYdwmc_可为空_原单位名称() {
        return ydwmc_可为空_原单位名称;
    }

    public void setYdwmc_可为空_原单位名称(String ydwmc_可为空_原单位名称) {
        this.ydwmc_可为空_原单位名称 = ydwmc_可为空_原单位名称;
    }

    public String getYgrzh_可为空_原个人账号() {
        return ygrzh_可为空_原个人账号;
    }

    public void setYgrzh_可为空_原个人账号(String ygrzh_可为空_原个人账号) {
        this.ygrzh_可为空_原个人账号 = ygrzh_可为空_原个人账号;
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

    public Double getZybj_可为空_转移本金() {
        return zybj_可为空_转移本金;
    }

    public void setZybj_可为空_转移本金(Double zybj_可为空_转移本金) {
        this.zybj_可为空_转移本金 = zybj_可为空_转移本金;
    }

    public Double getZylx_可为空_转移利息() {
        return zylx_可为空_转移利息;
    }

    public void setZylx_可为空_转移利息(Double zylx_可为空_转移利息) {
        this.zylx_可为空_转移利息 = zylx_可为空_转移利息;
    }

    public Double getZyje_可为空_转移金额() {
        return zyje_可为空_转移金额;
    }

    public void setZyje_可为空_转移金额(Double zyje_可为空_转移金额) {
        this.zyje_可为空_转移金额 = zyje_可为空_转移金额;
    }

    public String getKhrq_可为空_开户日期() {
        return khrq_可为空_开户日期;
    }

    public void setKhrq_可为空_开户日期(String khrq_可为空_开户日期) {
        this.khrq_可为空_开户日期 = khrq_可为空_开户日期;
    }

    public String getJzny_可为空_本年缴至年月() {
        return jzny_可为空_本年缴至年月;
    }

    public void setJzny_可为空_本年缴至年月(String jzny_可为空_本年缴至年月) {
        this.jzny_可为空_本年缴至年月 = jzny_可为空_本年缴至年月;
    }

    public String getHjbz_可为空_连续6个月汇缴标志() {
        return hjbz_可为空_连续6个月汇缴标志;
    }

    public void setHjbz_可为空_连续6个月汇缴标志(String hjbz_可为空_连续6个月汇缴标志) {
        this.hjbz_可为空_连续6个月汇缴标志 = hjbz_可为空_连续6个月汇缴标志;
    }

    public Long getDkcs_可为空_在转出地使用住房公积金贷款次数() {
        return dkcs_可为空_在转出地使用住房公积金贷款次数;
    }

    public void setDkcs_可为空_在转出地使用住房公积金贷款次数(Long dkcs_可为空_在转出地使用住房公积金贷款次数) {
        this.dkcs_可为空_在转出地使用住房公积金贷款次数 = dkcs_可为空_在转出地使用住房公积金贷款次数;
    }

    public String getDkbz_可为空_贷款标志() {
        return dkbz_可为空_贷款标志;
    }

    public void setDkbz_可为空_贷款标志(String dkbz_可为空_贷款标志) {
        this.dkbz_可为空_贷款标志 = dkbz_可为空_贷款标志;
    }

    public String getPtpdbz_可为空_骗提骗贷标志() {
        return ptpdbz_可为空_骗提骗贷标志;
    }

    public void setPtpdbz_可为空_骗提骗贷标志(String ptpdbz_可为空_骗提骗贷标志) {
        this.ptpdbz_可为空_骗提骗贷标志 = ptpdbz_可为空_骗提骗贷标志;
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

    public String getCxyy_可为空_撤销原因() {
        return cxyy_可为空_撤销原因;
    }

    public void setCxyy_可为空_撤销原因(String cxyy_可为空_撤销原因) {
        this.cxyy_可为空_撤销原因 = cxyy_可为空_撤销原因;
    }

    public String getFreeuse1_可为空_备用字符() {
        return freeuse1_可为空_备用字符;
    }

    public void setFreeuse1_可为空_备用字符(String freeuse1_可为空_备用字符) {
        this.freeuse1_可为空_备用字符 = freeuse1_可为空_备用字符;
    }

    public Double getFreeuse2_可为空_备用金额() {
        return freeuse2_可为空_备用金额;
    }

    public void setFreeuse2_可为空_备用金额(Double freeuse2_可为空_备用金额) {
        this.freeuse2_可为空_备用金额 = freeuse2_可为空_备用金额;
    }

    public Date getFreeuse3_可为空_备用日期() {
        return freeuse3_可为空_备用日期;
    }

    public void setFreeuse3_可为空_备用日期(Date freeuse3_可为空_备用日期) {
        this.freeuse3_可为空_备用日期 = freeuse3_可为空_备用日期;
    }

    public Long getFreeuse4_可为空_备用数值() {
        return freeuse4_可为空_备用数值;
    }

    public void setFreeuse4_可为空_备用数值(Long freeuse4_可为空_备用数值) {
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

    public String getTrjbrxm_可为空_TR经办人姓名() {
        return trjbrxm_可为空_TR经办人姓名;
    }

    public void setTrjbrxm_可为空_TR经办人姓名(String trjbrxm_可为空_TR经办人姓名) {
        this.trjbrxm_可为空_TR经办人姓名 = trjbrxm_可为空_TR经办人姓名;
    }

    public String getTrjbrsjhm_可为空_TR手机号码() {
        return trjbrsjhm_可为空_TR手机号码;
    }

    public void setTrjbrsjhm_可为空_TR手机号码(String trjbrsjhm_可为空_TR手机号码) {
        this.trjbrsjhm_可为空_TR手机号码 = trjbrsjhm_可为空_TR手机号码;
    }

    public String getTrjbrzjhm_可为空_TR经办人证件号() {
        return trjbrzjhm_可为空_TR经办人证件号;
    }

    public void setTrjbrzjhm_可为空_TR经办人证件号(String trjbrzjhm_可为空_TR经办人证件号) {
        this.trjbrzjhm_可为空_TR经办人证件号 = trjbrzjhm_可为空_TR经办人证件号;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
