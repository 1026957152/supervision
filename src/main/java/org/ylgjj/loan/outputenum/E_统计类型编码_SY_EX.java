package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_统计类型编码_SY_EX {


    H_01_本期发生("01","本期发生"),
    H_02_个人贷款("02","本年累计"),
    H_03_历史累计("03","历史累计"),

  //  指标单位	String		01:元；02:个;03：户；04：笔；05：平方米




;



    private final String 编码;
    private final String 名称;





    E_统计类型编码_SY_EX(String 编码, String 名称) {
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
