package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
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
    private Date transdate不可为空交易日期;



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





    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
