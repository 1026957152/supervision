package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_指标分类编码_SY {
    SY1_S_01__单位数分析__parent__level__yybm ("parent","level","0301","01","单位数分析 "),
    SY2_S_02__人数人次分析__parent__level__yybm ("parent","level","0301","02","人数人次分析 "),
    SY3_S_03__汇补缴分析__parent__level__yybm ("parent","level","0301","03","汇补缴分析 "),
    SY4_S_04__提取分析__parent__level__yybm ("parent","level","0301","04","提取分析 "),
    SY5_S_05__历史累计分析__parent__level__yybm ("parent","level","0301","05","历史累计分析 "),
    SY6_S_06__归集指标__parent__level__yybm ("parent","level","0301","06","归集指标 "),
    SY7_S_07__发放额及户数分析__parent__level__yybm ("parent","level","0302","07","发放额及户数分析 "),
    SY8_S_08__回收额及户数分析__parent__level__yybm ("parent","level","0302","08","回收额及户数分析 "),
    SY9_S_09__结清额及户数分析__parent__level__yybm ("parent","level","yybm","09","结清额及户数分析 "),
    SY10_S_10__回收利息及罚息分析__parent__level__yybm ("parent","level","yybm","10","回收利息及罚息分析 "),
    SY11_S_11__贷款应收分析__parent__level__yybm ("parent","level","yybm","11","贷款应收分析 "),
    SY12_S_12__逾期及户数分析__parent__level__yybm ("parent","level","yybm","12","逾期及户数分析 "),
    SY13_S_13__贷款余额分析__parent__level__yybm ("parent","level","yybm","13","贷款余额分析 "),
    SY14_S_14__历史累计发放额及户数分析__parent__level__yybm ("parent","level","0302","14","历史累计发放额及户数分析 "),
    SY15_S_15__历史累计回收额及户数分析__parent__level__yybm ("parent","level","0302","15","历史累计回收额及户数分析 "),
    SY16_S_16__历史累计结清额及户数分析__parent__level__yybm ("parent","level","0302","16","历史累计结清额及户数分析 "),
    SY17_S_17__历史累计回收利息及罚息分析__parent__level__yybm ("parent","level","0302","17","历史累计回收利息及罚息分析 "),
    SY18_S_18__历史累计逾期分析__parent__level__yybm ("parent","level","0302","18","历史累计逾期分析 "),
    SY19_S_19__贷款指标__parent__level__yybm ("parent","level","yybm","19","贷款指标 "),
    SY20_S_20__购房面积分析__parent__level__yybm ("parent","level","0302","20","购房面积分析 "),
    SY21_S_21__贷款金额比例分析__parent__level__yybm ("parent","level","yybm","21","贷款金额比例分析 "),
    SY22_S_22__贷款年限分析__parent__level__yybm ("parent","level","yybm","22","贷款年限分析 "),
    SY23_S_23__担保方式分析__parent__level__yybm ("parent","level","yybm","23","担保方式分析 "),
    SY24_S_24__购房类型分析__parent__level__yybm ("parent","level","yybm","24","购房类型分析 "),
    SY25_S_25__收入水平分析__parent__level__yybm ("parent","level","0302","25","收入水平分析 "),
    SY26_S_26__贷款职工人数分析__parent__level__yybm ("parent","level","yybm","26","贷款职工人数分析 "),
    SY27_S_81__资产负债__parent__level__yybm ("parent","level","yybm","81","资产负债 "),
    SY28_S_82__银行存款__parent__level__yybm ("parent","level","yybm","82","银行存款 "),
    SY29_S_83__业务收入__parent__level__yybm ("parent","level","yybm","83","业务收入 "),
    SY30_S_84__业务支出__parent__level__yybm ("parent","level","yybm","84","业务支出 "),
    SY31_S_85__增值收益__parent__level__yybm ("parent","level","yybm","85","增值收益 "),
    SY32_S_86__财务指标__parent__level__yybm ("parent","level","yybm","86","财务指标 "),

    ;


    private final String parent_父节点;
    private final String level_级别;
    private final String yybm_应用代码;
    private final String 编码;

    private final String 名称;

    public String getParent_父节点() {
        return parent_父节点;
    }

    public String getLevel_级别() {
        return level_级别;
    }

    public String getYybm_应用代码() {
        return yybm_应用代码;
    }

    public String get编码() {
        return 编码;
    }

    public String get名称() {
        return 名称;
    }



    E_指标分类编码_SY(String parent_父节点,String level_级别,String yybm_应用代码,String 编码, String 名称) {
        this.parent_父节点 = parent_父节点;
        this.level_级别 = level_级别;
        this.yybm_应用代码 = yybm_应用代码;
        this.编码 = 编码;
        this.名称 = 名称;


    }
   


    public static E_指标分类编码_SY fromString(String text) {
        for (E_指标分类编码_SY status : E_指标分类编码_SY.values()) {
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
