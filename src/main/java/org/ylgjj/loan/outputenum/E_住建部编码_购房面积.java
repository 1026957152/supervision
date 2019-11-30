package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

import org.ylgjj.loan.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_住建部编码_购房面积 {

    H__90_含_m以下("01","90(含)㎡以下",0,90),
    H__90_144_含_m("02","90-144（含）㎡",90,144),
    H__144m以上("03","144㎡以上",144,Double.MAX_VALUE),




;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;
    private final double floor;
    private final double ceiling;
    public static List<ListItem> retriveTypese() {
        // String userUrl =  linkTo(methodOn(MobileDistributorController.class).detail(null)).withSelfRel().getHref();

        List<ListItem> list = new ArrayList<ListItem>();
        for (E_住建部编码_购房面积 status : E_住建部编码_购房面积.values()) {
            ListItem<String> element = new ListItem<String>(status.get编码(), status.get名称(), status.get名称());
            list.add(element);
        }

        return list;

    }


    public String get编码() {
        return 编码;
    }

    public String get名称() {
        return 名称;
    }

    public double getFloor() {
        return floor;
    }

    public double getCeiling() {
        return ceiling;
    }

    private E_住建部编码_购房面积(String 编码, String 名称, double floor, double ceiling) {
        this.编码 = 编码;
        this.名称 = 名称;

        this.floor = floor;
        this.ceiling = ceiling;
    }

    public static E_住建部编码_购房面积 fromValue(double ceiling) {

        if(ceiling <= H__90_含_m以下.floor ){
            return H__90_含_m以下;
        }
        if(ceiling < H__90_144_含_m.floor && H__90_144_含_m.ceiling >= ceiling  ){
            return H__90_144_含_m;
        }
        if(ceiling > H__144m以上.ceiling ){
            return H__144m以上;
        }


        return null;
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
