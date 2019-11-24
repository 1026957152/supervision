package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum SY_H7大额资金监控 {

    je0_金额_500以下("01","je0_金额_500以下"),

    je1_金额_500__1000("01","je1_金额_500__1000"),
    je2_金额_1000__1500("05","je2_金额_1000__1500"),
    je3_金额_1500__2000("02","je3_金额_1500__2000"),
    je4_金额_2000以上("03","je4_金额_2000以上"),






;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;





    private SY_H7大额资金监控(String 编码, String 名称) {
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
