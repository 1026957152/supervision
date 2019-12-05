package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_渠道_HX {


    H_10_APP("10","APP"),
    H_20_微信("20","微信"),
    H_30_网站("30","网站"),
    H_40_网厅("40","网厅"),
    H_50_自助终端("50","自助终端"),
    H_60_服务热线("60","服务热线"),

    H_70_手机短信("70","手机短信"),
    H_80_微博("80","微博"),

    H_90支付宝("90","支付宝"),

            ;



    private final String 编码;
    private final String 名称;


    public String get编码() {
        return 编码;
    }

    public String get名称() {
        return 名称;
    }

    private E_渠道_HX(String 编码, String 名称) {
        this.编码 = 编码;
        this.名称 = 名称;


    }
    public static E_渠道_HX fromString(String text) {
        for (E_渠道_HX status : E_渠道_HX.values()) {
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
