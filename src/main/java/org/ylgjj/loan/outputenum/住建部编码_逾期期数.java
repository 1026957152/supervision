package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum 住建部编码_逾期期数 {

    H__1_3期_不含3期("01","1-3期(不含3期)"),
    H__3_6期_含3_6期_不含 ("02","3-6期(含3_6期(不含))"),
    H__6期以上_含6期("03","6期以上(含6期)"),




;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;





    住建部编码_逾期期数(String 编码, String 名称) {
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
