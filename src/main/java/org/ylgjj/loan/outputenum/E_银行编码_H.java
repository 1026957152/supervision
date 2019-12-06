package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_银行编码_H {

    H__中国人民银行("0000","中国人民银行","央行"),
    H__中国建设银行("0001","中国建设银行","建设银行"),
    H__中国工商银行("0002","中国工商银行","工商银行"),
    H__中国农业银行("0003","中国农业银行","农业银行"),
    H__中国银行("0004","中国银行","中国银行"),
    H__中国交通银行("0005","中国交通银行","交通银行"),
    H__中国光大银行("0006","中国光大银行","光大银行"),
    H__恒丰银行("0007","恒丰银行","恒丰银行"),
    H__华夏银行("0008","华夏银行","华夏银行"),
    H__中国民生银行("0009","中国民生银行","民生银行"),
    H__北京银行("0010","北京银行","北京银行"),
    H__上海浦发银行("0011","上海浦发银行","浦发银行"),
    H__兴业银行("0012","兴业银行","兴业银行"),
    H__招商银行("0013","招商银行","招商银行"),
    H__浙商银行("0014","浙商银行","浙商银行"),
    H__中信银行("0015","中信银行","中信银行"),
    H__中国邮政储蓄银行("0016","中国邮政储蓄银行","邮政储蓄"),
    H__农村信用社("0017","农村信用社","农村信用社"),
    H__渤海银行("0018","渤海银行","渤海银行"),
    H__晋商银行("0019","晋商银行","晋商银行"),
    H__昆仑银行("0020","昆仑银行","昆仑银行"),
    H__青海银行("0021","青海银行","青海银行"),
    H__西宁农商银行("0022","西宁农商银行","农商银行"),
    H__中国农业发展银行("0023","中国农业发展银行","农发银行"),
    H__长安银行("0031","长安银行","长安银行"),
    H__平安银行("0033","平安银行","平安银行"),
    H__支付宝("0099","支付宝","支付宝"),
    H__西安银行("0036","西安银行","西安银行"),


;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -


    				
    private final String 银行编码;
    private final String 银行名称;
    private final String 银行简称;




    E_银行编码_H(String 银行编码, String 银行名称, String 银行简称) {
        this.银行编码 = 银行编码;
        this.银行名称 = 银行名称;

        this.银行简称 = 银行简称;

    }


    public static List<ListItem> retriveTypese() {
        // String userUrl =  linkTo(methodOn(MobileDistributorController.class).detail(null)).withSelfRel().getHref();

        List<ListItem> list = new ArrayList<ListItem>();
        for (E_HX_机构_Institution_info_instCodeEnum status : E_HX_机构_Institution_info_instCodeEnum.values()) {
            ListItem<String> element = new ListItem<String>(status.getText(), status.getDisplayText(), status.getHelpMessage());
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
