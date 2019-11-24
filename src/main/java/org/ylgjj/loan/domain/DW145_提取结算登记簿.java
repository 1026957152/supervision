package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "DW145")

public class DW145_提取结算登记簿 {




    @Id
    @Column(name = "SEQNO")
    private String SEQNO_序号0;

    @Column(name = "TRANSDATE")
    private LocalDate TRANSDATE交易日期0;


    @Column(name = "ACCINSTCODE")
    private String ACCINSTCODE_账户机构0;




    @Column(name = "ACCNUM")
    private String ACCNUM_个人账号0;




    @Column(name = "APPRNUM")
    private String apprnum审批号0;



    @Column(name = "settlemode")
    private String settlemode结算方式1;


    @Column(name = "PAPERRELATION")
    private String PAPERRELATION_收款账号与提取人关系0;
//1-本人联名卡,2-本人借记卡,3-带领人联名卡,4-带领人借记卡,5-单位统一代理账户,6-外市电汇账号,9-其它


    @Column(name = "DPAYAMT")
    private BigDecimal DPAYAMT_中心提取金额0;
    @Column(name = "DPAYDATE")
    private Date DPAYDATE中心付款时间0;

    public String getSEQNO_序号0() {
        return SEQNO_序号0;
    }

    public void setSEQNO_序号0(String SEQNO_序号0) {
        this.SEQNO_序号0 = SEQNO_序号0;
    }

    public LocalDate getTRANSDATE交易日期0() {
        return TRANSDATE交易日期0;
    }

    public void setTRANSDATE交易日期0(LocalDate TRANSDATE交易日期0) {
        this.TRANSDATE交易日期0 = TRANSDATE交易日期0;
    }

    public String getACCINSTCODE_账户机构0() {
        return ACCINSTCODE_账户机构0;
    }

    public void setACCINSTCODE_账户机构0(String ACCINSTCODE_账户机构0) {
        this.ACCINSTCODE_账户机构0 = ACCINSTCODE_账户机构0;
    }

    public String getACCNUM_个人账号0() {
        return ACCNUM_个人账号0;
    }

    public void setACCNUM_个人账号0(String ACCNUM_个人账号0) {
        this.ACCNUM_个人账号0 = ACCNUM_个人账号0;
    }

    public String getApprnum审批号0() {
        return apprnum审批号0;
    }

    public void setApprnum审批号0(String apprnum审批号0) {
        this.apprnum审批号0 = apprnum审批号0;
    }

    public String getSettlemode结算方式1() {
        return settlemode结算方式1;
    }

    public void setSettlemode结算方式1(String settlemode结算方式1) {
        this.settlemode结算方式1 = settlemode结算方式1;
    }

    public String getPAPERRELATION_收款账号与提取人关系0() {
        return PAPERRELATION_收款账号与提取人关系0;
    }

    public void setPAPERRELATION_收款账号与提取人关系0(String PAPERRELATION_收款账号与提取人关系0) {
        this.PAPERRELATION_收款账号与提取人关系0 = PAPERRELATION_收款账号与提取人关系0;
    }

    public BigDecimal getDPAYAMT_中心提取金额0() {
        return DPAYAMT_中心提取金额0;
    }

    public void setDPAYAMT_中心提取金额0(BigDecimal DPAYAMT_中心提取金额0) {
        this.DPAYAMT_中心提取金额0 = DPAYAMT_中心提取金额0;
    }

    public Date getDPAYDATE中心付款时间0() {
        return DPAYDATE中心付款时间0;
    }

    public void setDPAYDATE中心付款时间0(Date DPAYDATE中心付款时间0) {
        this.DPAYDATE中心付款时间0 = DPAYDATE中心付款时间0;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
