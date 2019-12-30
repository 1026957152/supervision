package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

import org.ylgjj.loan.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_住建部编码_收入水平 {

    H__低收入("01","低收入"),
    H__中等收入("02","中等收入"),
    H__高收入("03","高收入"),



;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;

    public static List<ListItem> retriveTypese() {
        // String userUrl =  linkTo(methodOn(MobileDistributorController.class).detail(null)).withSelfRel().getHref();

        List<ListItem> list = new ArrayList<ListItem>();
        for (E_住建部编码_收入水平 status : E_住建部编码_收入水平.values()) {
            ListItem<String> element = new ListItem<String>(status.get编码(), status.get名称(), status.get名称());
            list.add(element);
        }

        return list;

    }

    public static E_住建部编码_收入水平 from(int i, double doubleValue) {
        if(E_最低工资_HX.H_2019_1800.get名称() >= doubleValue){
            return E_住建部编码_收入水平.H__中等收入;
        }
        if(E_最低工资_HX.H_2019_1800.get名称()*3 >= doubleValue && E_最低工资_HX.H_2019_1800.get名称() < doubleValue){
            return E_住建部编码_收入水平.H__低收入;
        }
        if(E_最低工资_HX.H_2019_1800.get名称()*3 < doubleValue){
            return E_住建部编码_收入水平.H__高收入;
        }
        return null;
    }

    public String get编码() {
        return 编码;
    }

    public String get名称() {
        return 名称;
    }

    E_住建部编码_收入水平(String 编码, String 名称) {
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
