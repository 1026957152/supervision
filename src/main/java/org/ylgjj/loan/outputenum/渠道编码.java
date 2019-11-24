package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum 渠道编码 {



    H__柜台("zxb","柜台"),
    H__网厅_单位版("wt_01","网厅-单位版"),
    H__网厅_个人版("wt_02","网厅-个人版"),
    H__网厅_开发商版("wt_03","网厅-开发商版"),
    H__手机公积金("app_12329","手机公积金"),
    H__微信("wx","微信"),
    H__支付宝城市服务("alipay","支付宝城市服务"),



;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;





    private 渠道编码(String 编码, String 名称) {
        this.编码 = 编码;
        this.名称 = 名称;


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
