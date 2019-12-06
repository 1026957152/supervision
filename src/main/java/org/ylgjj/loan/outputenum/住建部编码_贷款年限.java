package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum 住建部编码_贷款年限 {
    H__1_5年_含("01","1-5年(含)"),
    H__5_10年_含("02","5-10年(含)"),
    H__10_15年_含("03","10-15年(含)"),
    H__15_20年_含("04","15-20年(含)"),
    H__20_25年_含("05","20-25年(含)"),
    H__25_30年_含("06","25-30年(含)"),




;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;





    住建部编码_贷款年限(String 编码, String 名称) {
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
