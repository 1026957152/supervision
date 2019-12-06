package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_逾期期次_HX {


    HX__PF03TRANCODE_PF03DESC_PF03SUBID_PF03ATTR("PF03TRANCODE","PF03DESC","PF03SUBID","PF03ATTR"),
    HX__000001_加法运算_st_10000000("000001","加法运算","st","10000000"),
    HX__000002_测试db2加锁_1_st_10000000("000002","测试db2加锁_1","st","10000000"),

;
    //private String inaccflag;//入账标志
//__,


    //   __
//    __



    private final String PF03TRANCODE;
    private final String PF03DESC;
    private final String PF03SUBID;
    private final String PF03ATTR;




    E_逾期期次_HX(String PF03TRANCODE, String PF03DESC, String PF03SUBID, String PF03ATTR) {
        this.PF03TRANCODE = PF03TRANCODE;
        this.PF03DESC = PF03DESC;

        this.PF03SUBID = PF03SUBID;
        this.PF03ATTR = PF03ATTR;

    }

}
