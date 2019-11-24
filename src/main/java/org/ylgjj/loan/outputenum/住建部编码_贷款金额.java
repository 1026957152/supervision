package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum 住建部编码_贷款金额 {


    H__5_10万_含("01","5_10万(含)"),
    H__10_20万_含("02","10-20万(含)"),
    H__20_30万_含("03","20-30万(含)"),
    H__30_40万_含("04","30-40万(含)"),
    H__40_50万_含("05","40-50万(含)"),
    H__50_60万_含("06","50-60万(含)"),
    H__60_70万_含("07","60-70万(含)"),
    H__70_80万_含("08","70-80万(含)"),
    H__80万以上_不含("09","80万以上(不含)"),



;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;





    private 住建部编码_贷款金额(String 编码, String 名称) {
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
