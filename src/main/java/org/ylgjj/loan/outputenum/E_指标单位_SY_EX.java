package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_指标单位_SY_EX {


    H_01_元("01","元"),
    H_02_个("02","个"),
    H_03_户("03","户"),
    H_04_笔("04","笔"),

    H_05_平方米("05","平方米"),



    //  指标单位	String		01:元；02:个;03：户；04：笔；05：平方米




;



    private final String 编码;
    private final String 名称;


    public String get编码() {
        return 编码;
    }

    public String get名称() {
        return 名称;
    }

    E_指标单位_SY_EX(String 编码, String 名称) {
        this.编码 = 编码;
        this.名称 = 名称;


    }
   


    public static E_指标单位_SY_EX fromString(String text) {
        for (E_指标单位_SY_EX status : E_指标单位_SY_EX.values()) {
            if (status.get编码().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }
/*
    public static 银行编码 fromInt(Integer text) {
        for (银行编码 status : 银行编码.values()) {
            if (status.getId().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }*/

}
