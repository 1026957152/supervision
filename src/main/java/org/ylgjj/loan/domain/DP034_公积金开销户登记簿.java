package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */


@IdClass(DP034_key.class)
@Entity

@Table(name = "DP034")

public class DP034_公积金开销户登记簿 {

    @Id

    @Column(name = "apprnum")
    private String apprnum审批号; //YYYYMMDD+流水号		0:不可为空
    @Id
    @Column(name = "hostsernum")
    private String hostsernum_不可为空_主机流水号; //


    @Column(name = "transdate")
    private LocalDate transdate不可为空交易日期;



    @Column(name = "unitaccnum")
    private String unitaccnum_不可为空_单位账号;

    @Column(name = "accnum")
    private String accnum_不可为空_个人账号;


    @Column(name = "ocflag")
    private String ocflag_不可为空_开销户标志; //0-开户,1-销户,2-销户激活,9-撤销	0:不可为空

    @Column(name = "closereason")
    private String closereason_可为空_注销原因; //1-公积金销户提取,2-公积金并户,3-公积金零额销户,4-公积金转移销户,5-公积金外市转出	1:可为空

    @Column(name = "accflag")
    private String accflag_不可为空_账户标志; //0-单位户,1-预缴户,2-个人户	0:

    @Column(name = "ocamt")
    private String ocamt_不可为空_开销户金额; //

    @Column(name = "keepbal")
    private String keepbal_可为空_存量余额; // 销户时的
    @Column(name = "increbal")
    private String increbal_可为空_增量余额; // 销户时的
    @Column(name = "intamt")
    private String intamt_可为空_结息金额; // 销户时的
    @Column(name = "keepintaccu")
    private String keepintaccu_可为空_存量利息积数; // 销户时的

    @Column(name = "increintaccu")
    private String increintaccu_可为空_增量利息积数; // 销户时的

    @Column(name = "accinstcode")
    private String accinstcode_不可为空_账户机构; //
    @Column(name = "agentinstcode")
    private String agentinstcode_不可为空_经办机构; //

    @Column(name = "agentbankcode")
    private String agentbankcode_不可为空_经办银行; //


    @Column(name = "timestamp")
    private String timestamp_不可为空_时间戳; //
    @Column(name = "instance")
    private String instance_不可为空_实例号; //
    @Column(name = "agentop")
    private String agentop_不可为空_经办柜员; //
    @Column(name = "remark")
    private String remark_可为空_备注; //


    public String getApprnum审批号() {
        return apprnum审批号;
    }

    public void setApprnum审批号(String apprnum审批号) {
        this.apprnum审批号 = apprnum审批号;
    }

    public String getHostsernum_不可为空_主机流水号() {
        return hostsernum_不可为空_主机流水号;
    }

    public void setHostsernum_不可为空_主机流水号(String hostsernum_不可为空_主机流水号) {
        this.hostsernum_不可为空_主机流水号 = hostsernum_不可为空_主机流水号;
    }

    public LocalDate getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(LocalDate transdate不可为空交易日期) {
        this.transdate不可为空交易日期 = transdate不可为空交易日期;
    }

    public String getUnitaccnum_不可为空_单位账号() {
        return unitaccnum_不可为空_单位账号;
    }

    public void setUnitaccnum_不可为空_单位账号(String unitaccnum_不可为空_单位账号) {
        this.unitaccnum_不可为空_单位账号 = unitaccnum_不可为空_单位账号;
    }

    public String getAccnum_不可为空_个人账号() {
        return accnum_不可为空_个人账号;
    }

    public void setAccnum_不可为空_个人账号(String accnum_不可为空_个人账号) {
        this.accnum_不可为空_个人账号 = accnum_不可为空_个人账号;
    }

    public String getOcflag_不可为空_开销户标志() {
        return ocflag_不可为空_开销户标志;
    }

    public void setOcflag_不可为空_开销户标志(String ocflag_不可为空_开销户标志) {
        this.ocflag_不可为空_开销户标志 = ocflag_不可为空_开销户标志;
    }

    public String getClosereason_可为空_注销原因() {
        return closereason_可为空_注销原因;
    }

    public void setClosereason_可为空_注销原因(String closereason_可为空_注销原因) {
        this.closereason_可为空_注销原因 = closereason_可为空_注销原因;
    }

    public String getAccflag_不可为空_账户标志() {
        return accflag_不可为空_账户标志;
    }

    public void setAccflag_不可为空_账户标志(String accflag_不可为空_账户标志) {
        this.accflag_不可为空_账户标志 = accflag_不可为空_账户标志;
    }

    public String getOcamt_不可为空_开销户金额() {
        return ocamt_不可为空_开销户金额;
    }

    public void setOcamt_不可为空_开销户金额(String ocamt_不可为空_开销户金额) {
        this.ocamt_不可为空_开销户金额 = ocamt_不可为空_开销户金额;
    }

    public String getKeepbal_可为空_存量余额() {
        return keepbal_可为空_存量余额;
    }

    public void setKeepbal_可为空_存量余额(String keepbal_可为空_存量余额) {
        this.keepbal_可为空_存量余额 = keepbal_可为空_存量余额;
    }

    public String getIncrebal_可为空_增量余额() {
        return increbal_可为空_增量余额;
    }

    public void setIncrebal_可为空_增量余额(String increbal_可为空_增量余额) {
        this.increbal_可为空_增量余额 = increbal_可为空_增量余额;
    }

    public String getIntamt_可为空_结息金额() {
        return intamt_可为空_结息金额;
    }

    public void setIntamt_可为空_结息金额(String intamt_可为空_结息金额) {
        this.intamt_可为空_结息金额 = intamt_可为空_结息金额;
    }

    public String getKeepintaccu_可为空_存量利息积数() {
        return keepintaccu_可为空_存量利息积数;
    }

    public void setKeepintaccu_可为空_存量利息积数(String keepintaccu_可为空_存量利息积数) {
        this.keepintaccu_可为空_存量利息积数 = keepintaccu_可为空_存量利息积数;
    }

    public String getIncreintaccu_可为空_增量利息积数() {
        return increintaccu_可为空_增量利息积数;
    }

    public void setIncreintaccu_可为空_增量利息积数(String increintaccu_可为空_增量利息积数) {
        this.increintaccu_可为空_增量利息积数 = increintaccu_可为空_增量利息积数;
    }

    public String getAccinstcode_不可为空_账户机构() {
        return accinstcode_不可为空_账户机构;
    }

    public void setAccinstcode_不可为空_账户机构(String accinstcode_不可为空_账户机构) {
        this.accinstcode_不可为空_账户机构 = accinstcode_不可为空_账户机构;
    }

    public String getAgentinstcode_不可为空_经办机构() {
        return agentinstcode_不可为空_经办机构;
    }

    public void setAgentinstcode_不可为空_经办机构(String agentinstcode_不可为空_经办机构) {
        this.agentinstcode_不可为空_经办机构 = agentinstcode_不可为空_经办机构;
    }

    public String getAgentbankcode_不可为空_经办银行() {
        return agentbankcode_不可为空_经办银行;
    }

    public void setAgentbankcode_不可为空_经办银行(String agentbankcode_不可为空_经办银行) {
        this.agentbankcode_不可为空_经办银行 = agentbankcode_不可为空_经办银行;
    }

    public String getTimestamp_不可为空_时间戳() {
        return timestamp_不可为空_时间戳;
    }

    public void setTimestamp_不可为空_时间戳(String timestamp_不可为空_时间戳) {
        this.timestamp_不可为空_时间戳 = timestamp_不可为空_时间戳;
    }

    public String getInstance_不可为空_实例号() {
        return instance_不可为空_实例号;
    }

    public void setInstance_不可为空_实例号(String instance_不可为空_实例号) {
        this.instance_不可为空_实例号 = instance_不可为空_实例号;
    }

    public String getAgentop_不可为空_经办柜员() {
        return agentop_不可为空_经办柜员;
    }

    public void setAgentop_不可为空_经办柜员(String agentop_不可为空_经办柜员) {
        this.agentop_不可为空_经办柜员 = agentop_不可为空_经办柜员;
    }

    public String getRemark_可为空_备注() {
        return remark_可为空_备注;
    }

    public void setRemark_可为空_备注(String remark_可为空_备注) {
        this.remark_可为空_备注 = remark_可为空_备注;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
