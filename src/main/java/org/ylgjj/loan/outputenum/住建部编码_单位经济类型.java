package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

import org.ylgjj.loan.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum 住建部编码_单位经济类型 {


    H__国家机关("001","国家机关"),
    H__国有企业("002","国有企业"),
    H__城镇集体企业("003","城镇集体企业"),
    H__外商投资企业("004","外商投资企业"),
    H__其他城镇企业("005","其他城镇企业"),
    H__民办非企业单位("006","民办非企业单位"),
    H__其他("007","其他"),
    H__自由职业者("008","自由职业者"),
    H__个体工商户("009","个体工商户"),
    H__事业单位("010","事业单位"),
    H__社会团体("011","社会团体"),






;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;


    public String get编码() {
        return 编码;
    }

    public String get名称() {
        return 名称;
    }

    住建部编码_单位经济类型(String 编码, String 名称) {
        this.编码 = 编码;
        this.名称 = 名称;


    }

    public static List<ListItem> retriveTypese() {
        // String userUrl =  linkTo(methodOn(MobileDistributorController.class).detail(null)).withSelfRel().getHref();

        List<ListItem> list = new ArrayList<ListItem>();
        for (住建部编码_单位经济类型 status : 住建部编码_单位经济类型.values()) {
            ListItem<String> element = new ListItem<String>(status.get编码(), status.get名称(), status.get名称());
            list.add(element);
        }

        return list;

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
