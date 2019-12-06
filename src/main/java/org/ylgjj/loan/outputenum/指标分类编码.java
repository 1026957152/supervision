package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum 指标分类编码 {

    H_01_单位数分析("01","单位数分析"),
    H_02_人数人次分析("02","人数人次分析"),
    H_03_汇补缴分析("03","汇补缴分析"),
    H_04_提取分析("04","提取分析"),
    H_05_历史累计分析("05","历史累计分析"),
    H_06_归集指标("06","归集指标"),
    H_07_发放额及户数分析("07","发放额及户数分析"),
    H_8_回收额及户数分析("08","回收额及户数分析"),
    H_9_结清额及户数分析("09","结清额及户数分析"),
    H_10_回收利息及罚息分析("10","回收利息及罚息分析"),
    H_11_贷款应收分析("11","贷款应收分析"),
    H_12_逾期及户数分析("12","逾期及户数分析"),
    H_13_贷款余额分析("13","贷款余额分析"),
    H_14_历史累计发放额及户数分析("14","历史累计发放额及户数分析"),
    H_14_历史累计回收额及户数分析("15","历史累计回收额及户数分析"),
    H_16_历史累计结清额及户数分析("16","历史累计结清额及户数分析"),
    H_17_历史累计回收利息及罚息分析("17","历史累计回收利息及罚息分析"),
    H_18_历史累计逾期分析("18","历史累计逾期分析"),
    H_19_贷款指标("19","贷款指标"),
    H_20_购房面积分析("20","购房面积分析"),
    H_21_贷款金额比例分析("21","贷款金额比例分析"),
    H_22_贷款年限分析("22","贷款年限分析"),
    H_23_担保方式分析("23","担保方式分析"),
    H_24_购房类型分析("24","购房类型分析"),
    H_25_收入水平分析("25","收入水平分析"),
    H_26_贷款职工人数分析("26","贷款职工人数分析"),
    H_81_资产负债("81","资产负债"),
    H_282_银行存款("82","银行存款"),
    H_83_业务收入("83","业务收入"),
    H_84_业务支出("84","业务支出"),
    H_85_增值收益("85","增值收益"),
    H_86_财务指标("86","财务指标"),





;
    //private String inaccflag;//入账标志
//-,


    //   -
//    -



    private final String 编码;
    private final String 名称;





    指标分类编码(String 编码, String 名称) {
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
