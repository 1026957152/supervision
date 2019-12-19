package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 *
 *
 *
 select DISTINCT  SPYEAR , SPAMT from re401

 */
public enum E_社平工资_HX {


    H_2015("2015",14080.00),
    H_2016("2016",14080.00),
    H_2017("2017",15329.01),
    H_2018("2018",16317.00),
    H_2019("2019",16780.00),
            ;



    private final String 编码;
    private final double 名称;


    public String get编码() {
        return 编码;
    }

    public double get名称() {
        return 名称;
    }

    E_社平工资_HX(String 编码, double 名称) {
        this.编码 = 编码;
        this.名称 = 名称;


    }
    public static E_社平工资_HX fromString(String text) {
        for (E_社平工资_HX status : E_社平工资_HX.values()) {
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
