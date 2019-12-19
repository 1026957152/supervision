package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

import org.ylgjj.loan.domain.CM001_单位基本资料表;

import java.time.LocalDate;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_TABLE_HX {

    dp004_单位缴存信息表Map("555	7020","单位托收回单打印"),
    dw025_公积金提取审核登记表Map("5001","个人账户基本信息查询"),
    dp202_单位缴存变更登记簿Map("5002","个人账户明细查询"),
    dp008_单位明细账Map("5002","个人账户明细查询"),



    dp005_单位分户账Map("555	7020","单位托收回单打印"),
    cm001_单位基本资料表Map("5001","个人账户基本信息查询"),

    ln101_贷款明细账_accounts("555	7020","单位托收回单打印"),
    ln0014_贷款房屋信息Map("5001","个人账户基本信息查询"),

    ln008_借款人信息Map("555	7020","单位托收回单打印"),
    ln003_合同信息Map("5001","个人账户基本信息查询"),

    ln003_合同信息s("555	7020","单位托收回单打印"),
    ln005_贷款分户信息Map("5001","个人账户基本信息查询"),

    DP204_个人缴存变更登记簿("5001","个人账户基本信息查询"),

    DP009_个人明细账("5001","个人账户基本信息查询"),
    DW025_公积金提取审核登记表("5001","个人账户基本信息查询"),
    DP022_个人缴存登记簿("5001","个人账户基本信息查询"),
    DP007_个人分户账("5001","个人账户基本信息查询"),
    CM002_个人基本资料表("5001","个人账户基本信息查询"),


    CM001_单位基本资料表("5001","个人账户基本信息查询"),
    DP006_个人缴存信息表("5001","个人账户基本信息查询"),



    TR003_转移人账户信息("5001","个人账户基本信息查询"),
    TR002_联系函基础信息("5001","个人账户基本信息查询"),
    TR077_转移接续临时表("5001","个人账户基本信息查询"),






            ;





    private final String 编码;
    private final String 名称;


    public String get编码() {
        return 编码;
    }

    public String get名称() {
        return 名称;
    }

    E_TABLE_HX(String 编码, String 名称) {
        this.编码 = 编码;
        this.名称 = 名称;


    }
    public static E_TABLE_HX fromString(String text) {
        for (E_TABLE_HX status : E_TABLE_HX.values()) {
            if (status.get编码().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

/*
    public static 银行编码 fromString(String text) {
        for (银行编码 status : 银行编码.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static 银行编码 fromInt(Integer text) {
        for (银行编码 status : 银行编码.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }*/
}
