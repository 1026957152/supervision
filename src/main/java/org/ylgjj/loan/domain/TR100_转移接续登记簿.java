package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(TR100_key.class)
@Entity
@Table(name = "TR100")

public class TR100_转移接续登记簿 {
  //  plbh,lxhbh


    @Column(name = "ywlsh")
    private String ywlsh_不可为空_业务流水号;

    @Id
    @Column(name = "plbh")
    private String plbh_不可为空_批量编号;
    @Id
    @Column(name = "lxhbh")
    private String lxhbh_不可为空_联系函编号;









    @Column(name = "machinetime")
    private String machinetime_不可为空_机器时间 ;


    @Column(name = "appop")
    private String appop_可为空_申请柜员;



    @Column(name = "chkop")
    private String chkop_可为空_复核柜员;


    @Column(name = "approveop")
    private String approveop_可为空_审批柜员;



    @Column(name = "instcode")
    private String instcode_不可为空_机构代码;


    @Column(name = "yhdm")
    private String yhdm_可为空_银行代码;


    @Column(name = "jyrq")
    private String jyrq不可为空交易日期;


    @Column(name = "transdate")
    private LocalDate transdate不可为空交易日期;


    @Column(name = "hostsernum")
    private String hostsernum_不可为空_主机流水号;


    @Column(name = "freeuse1")
    private String freeuse1_可为空_备用字符;



    @Column(name = "freeuse2")
    private String freeuse2_可为空_备用金额;



    @Column(name = "freeuse3")
    private String freeuse3_可为空_备用日期;



    @Column(name = "freeuse4")
    private String freeuse4_可为空_备用数值;









    @Column(name = "ywbs")
    private String ywbs_不可为空_业务标识; ;//_0-单笔,1-批量_0:



    @Column(name = "jylx")
    private String jylx_不可为空_交易类型; //_1-转入,2-转出_0:;
    @Column(name = "lxhzt")
    private String lxhzt_不可为空_联系函状态;




    @Column(name = "summarycode")
    private String summarycode_不可为空_摘要码;



    @Column(name = "amt")
    private String amt_不可为空_金额;


    public String getYwlsh_不可为空_业务流水号() {
        return ywlsh_不可为空_业务流水号;
    }

    public void setYwlsh_不可为空_业务流水号(String ywlsh_不可为空_业务流水号) {
        this.ywlsh_不可为空_业务流水号 = ywlsh_不可为空_业务流水号;
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

    public String getMachinetime_不可为空_机器时间() {
        return machinetime_不可为空_机器时间;
    }

    public void setMachinetime_不可为空_机器时间(String machinetime_不可为空_机器时间) {
        this.machinetime_不可为空_机器时间 = machinetime_不可为空_机器时间;
    }

    public String getAppop_可为空_申请柜员() {
        return appop_可为空_申请柜员;
    }

    public void setAppop_可为空_申请柜员(String appop_可为空_申请柜员) {
        this.appop_可为空_申请柜员 = appop_可为空_申请柜员;
    }

    public String getChkop_可为空_复核柜员() {
        return chkop_可为空_复核柜员;
    }

    public void setChkop_可为空_复核柜员(String chkop_可为空_复核柜员) {
        this.chkop_可为空_复核柜员 = chkop_可为空_复核柜员;
    }

    public String getApproveop_可为空_审批柜员() {
        return approveop_可为空_审批柜员;
    }

    public void setApproveop_可为空_审批柜员(String approveop_可为空_审批柜员) {
        this.approveop_可为空_审批柜员 = approveop_可为空_审批柜员;
    }

    public String getInstcode_不可为空_机构代码() {
        return instcode_不可为空_机构代码;
    }

    public void setInstcode_不可为空_机构代码(String instcode_不可为空_机构代码) {
        this.instcode_不可为空_机构代码 = instcode_不可为空_机构代码;
    }

    public String getYhdm_可为空_银行代码() {
        return yhdm_可为空_银行代码;
    }

    public void setYhdm_可为空_银行代码(String yhdm_可为空_银行代码) {
        this.yhdm_可为空_银行代码 = yhdm_可为空_银行代码;
    }

    public String getJyrq不可为空交易日期() {
        return jyrq不可为空交易日期;
    }

    public void setJyrq不可为空交易日期(String jyrq不可为空交易日期) {
        this.jyrq不可为空交易日期 = jyrq不可为空交易日期;
    }

    public LocalDate getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(LocalDate transdate不可为空交易日期) {
        this.transdate不可为空交易日期 = transdate不可为空交易日期;
    }

    public String getHostsernum_不可为空_主机流水号() {
        return hostsernum_不可为空_主机流水号;
    }

    public void setHostsernum_不可为空_主机流水号(String hostsernum_不可为空_主机流水号) {
        this.hostsernum_不可为空_主机流水号 = hostsernum_不可为空_主机流水号;
    }

    public String getFreeuse1_可为空_备用字符() {
        return freeuse1_可为空_备用字符;
    }

    public void setFreeuse1_可为空_备用字符(String freeuse1_可为空_备用字符) {
        this.freeuse1_可为空_备用字符 = freeuse1_可为空_备用字符;
    }

    public String getFreeuse2_可为空_备用金额() {
        return freeuse2_可为空_备用金额;
    }

    public void setFreeuse2_可为空_备用金额(String freeuse2_可为空_备用金额) {
        this.freeuse2_可为空_备用金额 = freeuse2_可为空_备用金额;
    }

    public String getFreeuse3_可为空_备用日期() {
        return freeuse3_可为空_备用日期;
    }

    public void setFreeuse3_可为空_备用日期(String freeuse3_可为空_备用日期) {
        this.freeuse3_可为空_备用日期 = freeuse3_可为空_备用日期;
    }

    public String getFreeuse4_可为空_备用数值() {
        return freeuse4_可为空_备用数值;
    }

    public void setFreeuse4_可为空_备用数值(String freeuse4_可为空_备用数值) {
        this.freeuse4_可为空_备用数值 = freeuse4_可为空_备用数值;
    }

    public String getYwbs_不可为空_业务标识() {
        return ywbs_不可为空_业务标识;
    }

    public void setYwbs_不可为空_业务标识(String ywbs_不可为空_业务标识) {
        this.ywbs_不可为空_业务标识 = ywbs_不可为空_业务标识;
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

    public String getSummarycode_不可为空_摘要码() {
        return summarycode_不可为空_摘要码;
    }

    public void setSummarycode_不可为空_摘要码(String summarycode_不可为空_摘要码) {
        this.summarycode_不可为空_摘要码 = summarycode_不可为空_摘要码;
    }

    public String getAmt_不可为空_金额() {
        return amt_不可为空_金额;
    }

    public void setAmt_不可为空_金额(String amt_不可为空_金额) {
        this.amt_不可为空_金额 = amt_不可为空_金额;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



    ;


}
