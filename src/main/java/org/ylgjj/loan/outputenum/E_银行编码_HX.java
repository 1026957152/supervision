package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

import org.ylgjj.loan.enumT.ErrorCodeEnum;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_银行编码_HX {


    HX__0001_工行("0001","工行","中国工商银行",E_银行编码_H.H__中国工商银行,"bank_gongshang.png"),
    HX__0002_农行("0002","农行","中国农业银行",E_银行编码_H.H__中国农业银行,"bank_nongye.png"),
    HX__0003_中行("0003","中行","中国银行",E_银行编码_H.H__中国银行,"bank_zhongguo.png"),
    HX__0004_建行("0004","建行","中国建设银行",E_银行编码_H.H__中国建设银行,"bank_jianshe.png"),
    HX__0005_交行("0005","交行","中国交通银行",E_银行编码_H.H__中国交通银行,"bank_jiaotong.png"),
    HX__0006_邮储("0006","邮储","中国邮政储蓄银行",E_银行编码_H.H__中国邮政储蓄银行,"bank_youzheng.png"),
    HX__0007_浦发("0007","浦发","上海浦东发展银行",E_银行编码_H.H__上海浦发银行,"bank_shanghaipudongfazhan.png"),
    HX__0008_农商("0008","农商","农村商业银行",E_银行编码_H.H__农村信用社,"bank_shanxixinghe.png"),
    HX__0009_长安("0009","长安","长安银行",E_银行编码_H.H__长安银行,"bank_changan.png"),
    HX__0010_西安("0010","西安","西安银行",E_银行编码_H.H__西安银行,"bank_xian.png"),
    HX__0011_招商("0011","招商","招商银行",E_银行编码_H.H__招商银行,"bank_zhaoshang.png"),
    HX__0012_中信("0012","中信","中信实业银行",E_银行编码_H.H__中信银行,"bank_zhongxin.png"),
    HX__0013_光大("0013","光大","光大银行",E_银行编码_H.H__中国光大银行,"bank_guangda.png"),
    HX__0014_兴业("0014","兴业","兴业银行",E_银行编码_H.H__兴业银行,"bank_xingye.png"),


;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 银行编码;
    private final String 银行名称;
    private final String 银行简称;
    private final E_银行编码_H SY_LINK;

    public String getLogoPath() {
        return logoPath;
    }

    private final String logoPath;

    E_银行编码_HX(String 银行编码, String 银行名称, String 银行简称, E_银行编码_H SY_LINK,String logoPath) {
        this.银行编码 = 银行编码;
        this.银行名称 = 银行名称;

        this.银行简称 = 银行简称;
        this.SY_LINK = SY_LINK;
        this.logoPath = logoPath;

    }

    public String get银行编码() {
        return 银行编码;
    }

    public String get银行名称() {
        return 银行名称;
    }

    public String get银行简称() {
        return 银行简称;
    }

    public E_银行编码_H getSY_LINK() {
        return SY_LINK;
    }

    public static E_银行编码_HX fromString(String text) {
        for (E_银行编码_HX status : E_银行编码_HX.values()) {
            if (status.get银行编码().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }
}
