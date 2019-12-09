package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

import org.ylgjj.loan.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_逾期分类编码_SY {

    H_01_1个月__含__以上__3个月以下("01","1个月（含）以上、3个月以下"),
    H_02_3个月__含__以上__6个月以下("02","3个月（含）以上、6个月以下"),
    H_03_6个月__含__以上__1年以下("03","6个月（含）以上、1年以下"),

    H_04_1年__含__以上__3年以下("04","1年（含）以上、3年以下"),
    H_05_3年__含__以上详细信息("05","3年（含）以上详细信息"),
    H_06_六期__含__以上详细信息("06","六期（含）以上详细信息"),


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
        for (E_逾期分类编码_SY status : E_逾期分类编码_SY.values()) {
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

    E_逾期分类编码_SY(String 编码, String 名称) {
        this.编码 = 编码;
        this.名称 = 名称;


    }
   


    public static E_逾期分类编码_SY fromString(String text) {
        for (E_逾期分类编码_SY status : E_逾期分类编码_SY.values()) {
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
