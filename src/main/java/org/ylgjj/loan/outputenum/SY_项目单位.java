package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum SY_项目单位 {


    H_01_元_金额价格("01","元_金额价格"),
    H_05_平方米_面积("05","平方米_面积"),
    H_02_个_人数("02","个_人数"),
    H_03_户数_贷款户数("03","户数_贷款户数"),
    H_04_笔_贷款("04","笔_贷款"),





;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;





    SY_项目单位(String 编码, String 名称) {
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
