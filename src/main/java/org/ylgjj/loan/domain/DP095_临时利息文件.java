package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 08/10/2015.
 */


@IdClass(DP095_key.class)
@Entity

@Table(name = "DP095")

public class DP095_临时利息文件 {
    //DP095_PK_1	3:索引	accinstcode,accflag,calintdate
    @Id
    @Column(name = "accflag")
    private String accflag_不可为空_账户标志; //1-预缴户,2-个人公积金	0:不可为空	账户标志

    @Id
    @Column(name = "accinstcode")
    private String accinstcode_不可为空_账户机构; //YYYYMMDD+流水号		0:不可为空
    @Id
    @Column(name = "calintdate")
    private String calintdate_不可为空_结息日期; //



    @Column(name = "pubaccnum")
    private String pubaccnum_不可为空_账户账号; //



    @Column(name = "calintaccname")
    private String calintaccname_不可为空_结息账户名称; //
    @Column(name = "unitaccnum")
    private String unitaccnum_不可为空_单位账号; //
    @Column(name = "seqno")
    private String seqno_不可为空_序号; //

    @Column(name = "subcode")
    private String subcode_不可为空_科目控制字; //
    @Column(name = "keepbal")
    private String keepbal_不可为空_前存量余额; //
    @Column(name = "increbal")
    private String increbal_不可为空_前增量余额; //

    @Column(name = "bfcalintbal")
    private String bfcalintbal_不可为空_结息前总余额; //

    @Column(name = "afcalintbal")
    private String afcalintbal_不可为空_结息后余额; //



    @Column(name = "amt1")
    private String amt1_不可为空_结存量利息; //
    @Column(name = "amt2")
    private String amt2_不可为空_结增量利息; //
    @Column(name = "intamt")
    private String intamt_不可为空_总利息; //
    @Column(name = "keepintaccu")
    private String keepintaccu_不可为空_存量利息积数; //
    @Column(name = "keeprate")
    private String keeprate_不可为空_存量利率; //
    @Column(name = "increintaccu")
    private String increintaccu_不可为空_增量利息积数; //
    @Column(name = "increrate")
    private String increrate_不可为空_增量利率; //
    @Column(name = "fltratecoe")
    private String fltratecoe_不可为空_浮动利率系数; //


    @Column(name = "begintdate")
    private String begintdate_不可为空_起息日期; //

    @Column(name = "calintyear")
    private String calintyear_不可为空_结息年份; //
    @Column(name = "inaccdate")
    private String inaccdate_不可为空_入账日期; //
    @Column(name = "inaccstate")
    private String inaccstate_不可为空_入账状态; //0-未入账,1-已入账	0:不可为空	入账状态
    @Column(name = "inacchostsernum")
    private String inacchostsernum_不可为空_入账主机流水号; //

    @Column(name = "inaccop")
    private String inaccop_可为空_入账柜员; //


    @Column(name = "opname")
    private String opname_不可为空_柜员姓名; //
    @Column(name = "intbillnum")
    private String intbillnum_不可为空_利息单编号; //
    @Column(name = "prtflag")
    private String prtflag_可为空_打印标志; //
    @Column(name = "prtdate")
    private String prtdate_可为空_打印日期; //
    @Column(name = "prttimestamp")
    private String prttimestamp_可为空_打印时间戳; //

    @Column(name = "prttimes")
    private String prttimes_不可为空_打印次数; //
    @Column(name = "transdate")
    private String transdate_不可为空_交易日期; //
    @Column(name = "hostsernum")
    private String hostsernum_不可为空_主机流水号; //
    @Column(name = "timestamp")
    private String timestamp_不可为空_时间戳; //






    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
