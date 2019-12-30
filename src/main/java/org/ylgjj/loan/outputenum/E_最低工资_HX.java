package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_最低工资_HX {


    H_2019_1800("2019",1800d),
    H_2018_微信("20",1800d),
    H_2017_网站("30",1800d),
    H_2016_网厅("40",1800d),
    H_2015_自助终端("50",1800d),
    H_2014_服务热线("60",1800d),


            ;



    private final String 编码;
    private final Double 名称;


    public String get编码() {
        return 编码;
    }

    public Double get名称() {
        return 名称;
    }

    E_最低工资_HX(String 编码, Double 名称) {
        this.编码 = 编码;
        this.名称 = 名称;


    }
    public static E_最低工资_HX fromString(String text) {
        for (E_最低工资_HX status : E_最低工资_HX.values()) {
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
