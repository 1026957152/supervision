package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_渠道_核心_调整_HX {

    H_bb_日终类("bb","日终类", Arrays.asList("bb")),


    H_00_柜台("00","柜台", Arrays.asList("0","00")),

    H_10_APP("10","APP", Arrays.asList("10")),
    H_20_微信("20","微信", Arrays.asList("20")),
    H_30_网站("30","网站", Arrays.asList("30")),
    H_40_网厅("40","网厅", Arrays.asList("19","11","40")),
    H_50_自助终端("50","自助终端", Arrays.asList("50")),
    H_60_服务热线("60","服务热线", Arrays.asList("60")),

    H_70_手机短信("70","手机短信", Arrays.asList("70")),
    H_80_微博("80","微博", Arrays.asList("80")),

    H_90支付宝("90","支付宝", Arrays.asList("90")),

            ;



    private final String 编码;
    private final String 名称;
    private final List<String> codes;

    public List<String> getCodes() {
        return codes;
    }

    public String get编码() {
        return 编码;
    }

    public String get名称() {
        return 名称;
    }

    E_渠道_核心_调整_HX(String 编码, String 名称, List<String> codes) {
        this.编码 = 编码;
        this.名称 = 名称;
        this.codes = codes;

    }
    public static E_渠道_核心_调整_HX fromString(String text) {
        for (E_渠道_核心_调整_HX status : E_渠道_核心_调整_HX.values()) {
            if (status.get编码().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }
    public static E_渠道_核心_调整_HX fromOld(String text) {
        for (E_渠道_核心_调整_HX status : E_渠道_核心_调整_HX.values()) {
            if (status.getCodes().contains(text.trim()) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status--------------- " + text);
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
