package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

import org.ylgjj.loan.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum 统计周期编码 {


    H__06_每年("06","每年"),
    H__05_半年("05","半年"),
    H__04_每季("04","每季"),
    H__03_每月("03","每月"),
    H__02_每周("02","每周"),
    H__01_每日("01","每日"),

  


;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;





    统计周期编码(String 编码, String 名称) {
        this.编码 = 编码;
        this.名称 = 名称;


    }

    public String get编码() {
        return 编码;
    }

    public String get名称() {
        return 名称;
    }

    public static List<ListItem> retriveTypese() {
        // String userUrl =  linkTo(methodOn(MobileDistributorController.class).detail(null)).withSelfRel().getHref();

        List<ListItem> list = new ArrayList<ListItem>();
        for (统计周期编码 status : 统计周期编码.values()) {
            ListItem<String> element = new ListItem<String>(status.get编码(), status.get名称(), status.get名称());
            list.add(element);
        }

        return list;

    }

    public static 统计周期编码 fromString(String text) {
        for (统计周期编码 status : 统计周期编码.values()) {
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
