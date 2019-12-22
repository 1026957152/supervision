package org.ylgjj.loan.outputenum;

//import com.coalvalue.domain.pojo.ListItem;

import org.ylgjj.loan.api.H1监管主要指标查询Controller;
import org.ylgjj.loan.api.H2业务指标Controller;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by silence on 2016/1/18.
 */
public enum E_指标_RATE_SY {


    SY_1_ljjzzdws_建制总单位数("ljjzzdws","建制总单位数",true),
    SY_2_ljhbjzzdws_环比建制总单位数("ljhbjzzdws","环比建制总单位数",true),
    SY_3_ljsnjzzdws_同比建制总单位数("ljsnjzzdws","同比建制总单位数",true),
    SY_4_ljjzxhdws_建制销户单位数("ljjzxhdws","建制销户单位数",true),
    SY_5_ljhbjzxhdws_环比建制销户单位数("ljhbjzxhdws","环比建制销户单位数",true),
    SY_6_ljsnjzxhdws_同比建制销户单位数("ljsnjzxhdws","同比建制销户单位数",true),
    SY_7_ljjzfxhdws_建制非销户单位数("ljjzfxhdws","建制非销户单位数",true),
    SY_8_ljhbjzfxhdws_环比建制非销户单位数("ljhbjzfxhdws","环比建制非销户单位数",true),
    SY_9_ljsnjzfxhdws_同比建制非销户单位数("ljsnjzfxhdws","同比建制非销户单位数",true),
    SY_10_ljjzfcdws_建制封存单位数("ljjzfcdws","建制封存单位数",true),
    SY_11_ljhbjzfcdws_环比建制封存单位数("ljhbjzfcdws","环比建制封存单位数",true),
    SY_12_ljsnjzfcdws_同比建制封存单位数("ljsnjzfcdws","同比建制封存单位数",true),
    SY_13_ljjzzcdws_建制正常单位数("ljjzzcdws","建制正常单位数",true),
    SY_14_ljhbjzzcdws_环比建制正常单位数("ljhbjzzcdws","环比建制正常单位数",true),
    SY_15_ljsnjzzcdws_同比建制正常单位数("ljsnjzzcdws","同比建制正常单位数",true),
    SY_16_ljjzhjdws_建制缓缴单位数("ljjzhjdws","建制缓缴单位数",true),
    SY_17_ljhbjzhjdws_环比建制缓缴单位数("ljhbjzhjdws","环比建制缓缴单位数",true),
    SY_18_ljsnjzhjdws_同比建制缓缴单位数("ljsnjzhjdws","同比建制缓缴单位数",true),
    SY_19_ljjzzrs_建制总人数("ljjzzrs","建制总人数",true),
    SY_20_ljhbjzzrs_环比建制总人数("ljhbjzzrs","环比建制总人数",true),
    SY_21_ljsnjzzrs_同比建制总人数("ljsnjzzrs","同比建制总人数",true),
    SY_22_ljjzxhrs_建制销户人数("ljjzxhrs","建制销户人数",true),
    SY_23_ljhbjzxhrs_环比建制销户人数("ljhbjzxhrs","环比建制销户人数",true),
    SY_24_ljsnjzxhrs_同比建制销户人数("ljsnjzxhrs","同比建制销户人数",true),
    SY_25_ljjzfxhrs_建制非销户人数("ljjzfxhrs","建制非销户人数",true),
    SY_26_ljhbjzfxhrs_环比建制非销户人数("ljhbjzfxhrs","环比建制非销户人数",true),
    SY_27_ljsnjzfxhrs_同比建制非销户人数("ljsnjzfxhrs","同比建制非销户人数",true),







    SY_28_ljjzfcrs_建制封存人数("ljjzfcrs","建制封存人数",true),
    SY_29_ljhbjzfcrs_环比建制封存人数("ljhbjzfcrs","环比建制封存人数",true),
    SY_30_ljsnjzfcrs_同比建制封存人数("ljsnjzfcrs","同比建制封存人数",true),





    SY_31_ljjzzcrs_建制正常人数("ljjzzcrs","建制正常人数",true),
    SY_32_ljhbjzzcrs_环比建制正常人数("ljhbjzzcrs","环比建制正常人数",true),
    SY_33_ljsnjzzcrs_同比建制正常人数("ljsnjzzcrs","同比建制正常人数",true),



    SY_34_ljjzdjrs_建制冻结人数("ljjzdjrs","建制冻结人数",true),
    SY_35_ljhbjzdjrs_环比建制冻结人数("ljhbjzdjrs","环比建制冻结人数",true),
    SY_36_ljsnjzdjrs_同比建制冻结人数("ljsnjzdjrs","同比建制冻结人数",true),


    SY_37_ljhse_累计回收额("ljhse","累计回收额",true),
    SY_38_ljhbhse_环比累计回收额("ljhbhse","环比累计回收额",true),
    SY_39_ljsnhse_同比累计回收额("ljsnhse","同比累计回收额",true),


    SY_40_ljhsdkje_历史累计回收额("ljhsdkje","历史累计回收额",true),
    SY_41_ljhbhsdkje_历史累计回收额环比("ljhbhsdkje","历史累计回收额环比",true),
    SY_42_ljsnhsdkje_历史累计回收额同比("ljsnhsdkje","历史累计回收额同比",true),


    SY_43_ljyqdked_逾期贷款额度("ljyqdked","逾期贷款额度",true),
    SY_44_ljhbyqdked_环比逾期贷款额度("ljhbyqdked","环比逾期贷款额度",true),
    SY_45_ljsnyqdked_同比逾期贷款额度("ljsnyqdked","同比逾期贷款额度",true),



    SY_46_ljzldkbs_存量贷款笔数("ljzldkbs","存量贷款笔数",true),
    SY_47_ljhbzldkbs_环比存量贷款笔数("ljhbzldkbs","环比存量贷款笔数",true),
    SY_48_ljsnzldkbs_同比存量贷款笔数("ljsnzldkbs","同比存量贷款笔数",true),


    SY_49_ljthreeyqhs_三期以上笔数("ljthreeyqhs","三期以上笔数",false),
    SY_50_ljhbthreeyqhs_环比三期以上笔数("ljhbthreeyqhs","环比三期以上笔数",false),
    SY_51_ljsnthreeyqhs_同比三期以上笔数("ljsnthreeyqhs","同比三期以上笔数",false),


    SY_52_ljsixyqhs_六期以上笔数("ljsixyqhs","六期以上笔数",false),
    SY_53_ljhbsixyqhs_环比六期以上笔数("ljhbsixyqhs","环比六期以上笔数",false),
    SY_54_ljsnsixyqhs_同比六期以上笔数("ljsnsixyqhs","同比六期以上笔数",false),


    SY_55_hslx_回收利息("hslx","回收利息",true),
    SY_56_hbhslx_环比回收利息("hbhslx","环比回收利息",true),
    SY_57_snhslx_同比回收利息("snhslx","同比回收利息",true),

    SY_58_ljhslx_累计回收利息("ljhslx","累计回收利息",true),
    SY_59_ljhbhslx_累计环比回收利息("ljhbhslx","累计环比回收利息",true),
    SY_60_ljsnhslx_累计同比回收利息("ljsnhslx","累计同比回收利息",true),


    SY_61_nzjxje_结转利息额("nzjxje","结转利息额",true),
    SY_62_hbnzjxje_环比结转利息额("hbnzjxje","环比结转利息额",true),
    SY_63_snnzjxje_同比结转利息额("snnzjxje","同比结转利息额",true),





    SY_64_wbzrje_外部转入金额("wbzrje","外部转入金额",true),
    SY_65_hbwbzrje_环比外部转入金额("hbwbzrje","环比外部转入金额",true),
    SY_66_snwbzrje_同比外部转入金额("snwbzrje","同比外部转入金额",true),

    SY_67_ljwbzrje_外部转入金额("ljwbzrje","外部转入金额",true),
    SY_68_ljhbwbzrje_环比外部转入金额("ljhbwbzrje","环比外部转入金额",true),
    SY_69_ljsnwbzrje_同比外部转入金额("ljsnwbzrje","同比外部转入金额",true),


    SY_70_wbzcje_外部转出金额("wbzcje","外部转出金额",true),
    SY_71_hbwbzcje_环比外部转出金额("hbwbzcje","环比外部转出金额",true),
    SY_72_snwbzcje_同比外部转出金额("snwbzcje","同比外部转出金额",true),


    SY_73_ljwbzcje_累计外部转出金额("ljwbzcje","累计外部转出金额",true),
    SY_74_ljhbwbzcje_累计环比外部转出金额("ljhbwbzcje","累计环比外部转出金额",true),
    SY_75_ljsnwbzcje_累计环比外部转出金额("ljsnwbzcje","累计环比外部转出金额",true),


    SY_76_sjdws_实缴单位数("sjdws","实缴单位数",true),
    SY_77_hbsjdws_环比实缴单位数("hbsjdws","环比实缴单位数",true),
    SY_78_snsjdws_同比实缴单位数("snsjdws","同比实缴单位数",true),


    SY_79_sjzgs_实缴职工数("sjzgs","实缴职工数",true),
    SY_80_hbsjzgs_环比实缴职工数("hbsjzgs","环比实缴职工数",true),
    SY_81_snsjzgs_同比实缴职工数("snsjzgs","同比实缴职工数",true),



    SY_82_jcye_缴存余额("jcye","缴存余额",true),
    SY_83_hbjcye_环比缴存余额("hbjcye","环比缴存余额",true),
    SY_84_snjcye_同比缴存余额("snjcye","同比缴存余额",true),


    SY_85_xkhdws_新开户单位("xkhdws","新开户单位",true),
    SY_86_hbxkhdws_环比新开户单位("hbxkhdws","环比新开户单位",true),
    SY_87_snxkhdws_同比新开户单位("snxkhdws","同比新开户单位",true),


    SY_88_ljxkhdws_累计新开户单位("ljxkhdws","累计新开户单位",true),
    SY_89_ljhbxkhdws_累计环比新开户单位("ljhbxkhdws","累计环比新开户单位",true),
    SY_90_ljsnxkhdws_累计同比新开户单位("ljsnxkhdws","累计同比新开户单位",true),


    SY_91_xkhzgs_新开户职工("xkhzgs","新开户职工",true),
    SY_92_hbxkhzgs_环比新开户职工("hbxkhzgs","环比新开户职工",true),
    SY_93_snxkhzgs_同比新开户职工("snxkhzgs","同比新开户职工",true),


    SY_94_ljxkhzgs_累计新开户职工("ljxkhzgs","累计新开户职工",true),
    SY_95_ljhbxkhzgs_累计环比新开户职工("ljhbxkhzgs","累计环比新开户职工",true),
    SY_96_ljsnxkhzgs_累计同比新开户职工("ljsnxkhzgs","累计同比新开户职工",true),


    SY_97_ljjce_累计缴存额("ljjce","累计缴存额",true),
    SY_98_ljhbjce_环比累计缴存额("ljhbjce","环比累计缴存额",true),
    SY_99_ljsnjce_同比累计缴存额("ljsnjce","同比累计缴存额",true),


    SY_100_sjce_实缴存额("sjce","实缴存额",true),
    SY_101_hbsjce_环比实缴存额("hbsjce","环比实缴存额",true),
    SY_102_snsjce_同比实缴存额("snsjce","同比实缴存额",true),


    SY_103_ljsjce_累计实缴存额("ljsjce","累计实缴存额",true),
    SY_104_ljhbsjce_累计环比实缴存额("ljhbsjce","累计环比实缴存额",true),
    SY_105_ljsnsjce_累计同比实缴存额("ljsnsjce","累计同比实缴存额",true),


    SY_106_ljtqe_历史累计提取额_提取原因_("ljtqe","历史累计提取额(提取原因)",true),
    SY_107_ljhbtqe_环比历史累计提取额__提取原因__("ljhbtqe","环比历史累计提取额(提取原因)",true),
    SY_108_ljsntqe_同比历史累计提取额__提取原因__("ljsntqe","同比历史累计提取额(提取原因)",true),



    SY_109_tqje_提取金额("tqje","提取金额",true),
    SY_110_hbtqje_环比提取金额("hbtqje","环比提取金额",true),
    SY_111_sntqje_同比提取金额("sntqje","同比提取金额",true),


    SY_112_ljtqje_累计提取金额("ljtqje","累计提取金额",true),
    SY_113_ljhbtqje_累计环比提取金额("ljhbtqje","累计环比提取金额",true),
    SY_114_ljsntqje_累计同比提取金额("ljsntqje","累计同比提取金额",true),



    SY_115_ffje_发放金额("ffje","发放金额",true),
    SY_116_hbffje_环比发放金额("hbffje","环比发放金额",true),
    SY_117_snffje_同比发放金额("snffje","同比发放金额",true),



    SY_118_ljffje_累计发放金额("ljffje","累计发放金额",true),
    SY_119_ljhbffje_累计环比发放金额("ljhbffje","累计环比发放金额",true),
    SY_120_ljsnffje_累计同比发放金额("ljsnffje","累计同比发放金额",true),







    SY_121_hsje_回收金额("hsje","回收金额",true),
    SY_122_hbhsje_环比回收金额("hbhsje","环比回收金额",true),
    SY_123_snhsje_同比回收金额("snhsje","同比回收金额",true),


    SY_124_ljhsje_累计回收金额("ljhsje","累计回收金额",true),
    SY_125_ljhbhsje_累计环比回收金额("ljhbhsje","累计环比回收金额",true),
    SY_126_ljsnhsje_累计同比回收金额("ljsnhsje","累计同比回收金额",true),





    SY_127_ljffdkje_累计发放贷款金额("ljffdkje","累计发放贷款金额",true),
    SY_128_ljhbffdkje_累计环比发放贷款金额("ljhbffdkje","累计环比发放贷款金额",true),
    SY_129_ljsnffdkje_累计同比发放贷款金额("ljsnffdkje","累计同比发放贷款金额",true),


    SY_130_yqdkje_逾期贷款金额("yqdkje","逾期贷款金额",true),


    SY_131_dkye_贷款余额("dkye","贷款余额",true),
    SY_132_hbdkye_环比贷款余额("hbdkye","环比贷款余额",true),
    SY_133_sndkye_同比贷款余额("sndkye","同比贷款余额",true),


    SY_134_ffbs_发放笔数("ffbs","发放笔数",true),
    SY_135_hbffbs_环比发放笔数("hbffbs","环比发放笔数",true),
    SY_136_snffbs_同比发放笔数("snffbs","同比发放笔数",true),


    SY_137_ljffbs_累计发放笔数("ljffbs","累计发放笔数",true),
    SY_138_ljhbffbs_累计环比发放笔数("ljhbffbs","累计环比发放笔数",true),
    SY_139_ljsnffbs_累计同比发放笔数("ljsnffbs","累计同比发放笔数",true),










    SY_140_zzsyje_增长收益金额("zzsyje","增长收益金额",true),


    SY_141_xmdkye_项目贷款余额("xmdkye","项目贷款余额",false),

    SY_142_gzye_国债金额("gzye","国债金额",false),





    SY_143_hqzhye_活期账户余额("hqzhye","活期账户余额",true),
    SY_144_ywsrje_业务收入金额("ywsrje","业务收入金额",true),
    SY_145_ywzcje_业务收出金额("ywzcje","业务收出金额",true),





    SY_146_sjlzzf_上缴的保障房建设资金("sjlzzf","上缴的保障房建设资金",false),
    SY_147_fplzzf_计提的保障房建设资金("fplzzf","计提的保障房建设资金",false),






















    SY_148_gthdbs_柜台核定笔数("gthdbs","柜台核定笔数",true),
    SY_149_wthdbs_网上核定笔数("wthdbs","网上核定笔数",false),
















    SY_150_gtxxbgbs_柜台信息变更笔数("gtxxbgbs","柜台信息变更笔数",true),
    SY_151_wtxxbgbs_网上信息变更笔数("wtxxbgbs","网上信息变更笔数",false),
    SY_152_gtztbgbs_柜台状态变更笔数("gtztbgbs","柜台状态变更笔数",true),
    SY_153_wtztbgbs_网上状态变更笔数("wtztbgbs","网上状态变更笔数",false),
    SY_154_gtjcjsbs_柜台缴存基数变更笔数("gtjcjsbs","柜台缴存基数变更笔数",true),
    SY_155_wtjcjsbs_网上缴存基数变更笔数("wtjcjsbs","网上缴存基数变更笔数",false),
    SY_156_gttqbs_柜台提取笔数("gttqbs","柜台提取笔数",true),
    SY_157_wttqbs_网上提取笔数("wttqbs","网上提取笔数",false),
    SY_158_gtdkbs_柜台贷款笔数("gtdkbs","柜台贷款笔数",true),
    SY_159_wtdkbs_网上贷款笔数("wtdkbs","网上贷款笔数",false),
    SY_160_gttqhkbs_柜台提前还款笔数("gttqhkbs","柜台提前还款笔数",true),
    SY_161_wttqhkbs_网上提取还款笔数("wttqhkbs","网上提取还款笔数",false),
    SY_162_gtchdjybs_柜台冲还贷笔数("gtchdjybs","柜台冲还贷笔数",true),
    SY_163_wtchdjybs_网厅冲还贷总笔数("wtchdjybs","网厅冲还贷总笔数",false),





















    SY_164_gjzbs_归集总笔数("gjzbs","归集总笔数",true),
    SY_165_wtgjzbs_网厅归集总笔数("wtgjzbs","网厅归集总笔数",false),

    SY_166_tqzbs_提取总笔数("tqzbs","提取总笔数",true),
    SY_167_wttqzbs_网厅提取总笔数("wttqzbs","网厅提取总笔数",false),

















    SY_168_dkzbs_贷款总笔数("dkzbs","贷款总笔数",true),
    SY_169_wtdkzbs_网厅贷款总笔数("wtdkzbs","网厅贷款总笔数",false),























    SY_170_tqlgl_提取离柜率("tqlgl","提取离柜率",false),
    SY_171_gjlgl_归集离柜率("gjlgl","归集离柜率",false),
    SY_172_dklgl_贷款离柜率("dklgl","贷款离柜率",false),
    SY_173_zxlgl_中心离柜率("zxlgl","中心离柜率",false),









    SY_174_tqcsbs_提取超时笔数("tqcsbs","提取超时笔数",false),














    SY_175_dkcsbs_贷款超时笔数("dkcsbs","贷款超时笔数",true),
    SY_176_dkzcspsj_贷款最长审批时间("dkzcspsj","贷款最长审批时间",true),
    SY_177_dkpjspts_贷款平均审批天数("dkpjspts","贷款平均审批天数",true),




;


    private final String 编码;
    private final String 名称;
    private final Boolean online;

    public Boolean getOnline() {
        return online;
    }

    public static List<ListItem> retriveTypese() {
        // String userUrl =  linkTo(methodOn(MobileDistributorController.class).detail(null)).withSelfRel().getHref();

        List<ListItem> list = new ArrayList<ListItem>();
        for (E_指标_RATE_SY status : E_指标_RATE_SY.values()) {
            String userUrl =  linkTo(methodOn(H1监管主要指标查询Controller.class).H_1_2_监管主要指标查询_公积金中心主要运行情况查询(null,null)).withSelfRel().getHref();


            ListItem<String> element = new ListItem<String>(status.get编码(), status.get名称(),userUrl,status.getOnline());
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

    E_指标_RATE_SY(String 编码, String 名称,Boolean online) {
        this.编码 = 编码;
        this.名称 = 名称;
        this.online = online;


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
