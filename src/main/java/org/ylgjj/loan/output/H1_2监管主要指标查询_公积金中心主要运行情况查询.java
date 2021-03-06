package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H1_2监管主要指标查询_公积金中心主要运行情况查询 {


    @JsonProperty("zjbbm")
    @JSONField(name="zjbbm")
    private int zjbbm_住建部编码_VARCHAR6;

    @JsonProperty("tjrq")
    @JSONField(name="tjrq")
    private int tjrq_统计日期_String;

    @JsonProperty("ljjzzdws")
    @JSONField(name="ljjzzdws")
    private int ljjzzdws_建制总单位数_NUMBER_18_2;

    @JsonProperty("ljhbjzzdws")
    @JSONField(name="ljhbjzzdws")
    private double ljhbjzzdws_环比建制总单位数_NUMBER_18_0;

    @JsonProperty("ljsnjzzdws")
    @JSONField(name="ljsnjzzdws")
    private double ljsnjzzdws_同比建制总单位数_NUMBER_18_0;

    @JsonProperty("ljjzxhdws")
    @JSONField(name="ljjzxhdws")
    private int ljjzxhdws_建制销户单位数_NUMBER_18_0;

    @JsonProperty("ljhbjzxhdws")
    @JSONField(name="ljhbjzxhdws")
    private double ljhbjzxhdws_环比建制销户单位数_NUMBER_18_0;
    @JsonProperty("ljsnjzxhdws")
    @JSONField(name="ljsnjzxhdws")
    private double ljsnjzxhdws_同比建制销户单位数_NUMBER_18_0;
    @JsonProperty("ljjzfxhdws")
    @JSONField(name="ljjzfxhdws")
    private int ljjzfxhdws_建制非销户单位数_NUMBER_18_0;
    @JsonProperty("ljhbjzfxhdws")
    @JSONField(name="ljhbjzfxhdws")
    private double ljhbjzfxhdws_环比建制非销户单位数_NUMBER_18_0;

    @JsonProperty("ljsnjzfxhdws")
    @JSONField(name="ljsnjzfxhdws")
    private double ljsnjzfxhdws_同比建制非销户单位数_NUMBER_18_0;

    @JsonProperty("ljjzfcdws")
    @JSONField(name="ljjzfcdws")
    private int ljjzfcdws_建制封存单位数_NUMBER_18_0;
    @JsonProperty("ljhbjzfcdws")
    @JSONField(name="ljhbjzfcdws")
    private double ljhbjzfcdws_环比建制封存单位数_NUMBER_18_0;

    @JsonProperty("ljsnjzfcdws")
    @JSONField(name="ljsnjzfcdws")
    private double ljsnjzfcdws_同比建制封存单位数_NUMBER_18_0;

    @JsonProperty("ljjzzcdws")
    @JSONField(name="ljjzzcdws")
    private int ljjzzcdws_建制正常单位数_NUMBER_18_0;

    @JsonProperty("ljhbjzzcdws")
    @JSONField(name="ljhbjzzcdws")
    private double ljhbjzzcdws_环比建制正常单位数_NUMBER_18_0;

    @JsonProperty("ljsnjzzcdws")
    @JSONField(name="ljsnjzzcdws")
    private double ljsnjzzcdws_同比建制正常单位数_NUMBER_18_0;

    @JsonProperty("ljjzhjdws")
    @JSONField(name="ljjzhjdws")
    private int ljjzhjdws_建制缓缴单位数_NUMBER_18_0;

    @JsonProperty("ljhbjzhjdws")
    @JSONField(name="ljhbjzhjdws")
    private double ljhbjzhjdws_环比建制缓缴单位数_NUMBER_18_0;

    @JsonProperty("ljsnjzhjdws")
    @JSONField(name="ljsnjzhjdws")
    private double ljsnjzhjdws_同比建制缓缴单位数_NUMBER_18_0;


    @JsonProperty("ljjzzrs")
    @JSONField(name="ljjzzrs")
    private int ljjzzrs_建制总人数_NUMBER_18_0;

    @JsonProperty("ljhbjzzrs")
    @JSONField(name="ljhbjzzrs")
    private double ljhbjzzrs_环比建制总人数_NUMBER_18_0;

    @JsonProperty("ljsnjzzrs")
    @JSONField(name="ljsnjzzrs")
    private double ljsnjzzrs_同比建制总人数_NUMBER_18_0;

    @JsonProperty("ljjzxhrs")
    @JSONField(name="ljjzxhrs")
    private int ljjzxhrs_建制销户人数_NUMBER_18_0;

    @JsonProperty("ljhbjzxhrs")
    @JSONField(name="ljhbjzxhrs")
    private double ljhbjzxhrs_环比建制销户人数_NUMBER_18_0;

    @JsonProperty("ljsnjzxhrs")
    @JSONField(name="ljsnjzxhrs")
    private double ljsnjzxhrs_同比建制销户人数_NUMBER_18_0;

    @JsonProperty("ljjzfxhrs")
    @JSONField(name="ljjzfxhrs")
    private int ljjzfxhrs_建制非销户人数_NUMBER_18_0;

    @JsonProperty("ljhbjzfxhrs")
    @JSONField(name="ljhbjzfxhrs")
    private double ljhbjzfxhrs_环比建制非销户人数_NUMBER_18_0;

    @JsonProperty("ljsnjzfxhrs")
    @JSONField(name="ljsnjzfxhrs")
    private double ljsnjzfxhrs_同比建制非销户人数_NUMBER_18_0;

    @JsonProperty("ljjzfcrs")
    @JSONField(name="ljjzfcrs")
    private int ljjzfcrs_建制封存人数_NUMBER_18_0;

    @JsonProperty("ljhbjzfcrs")
    @JSONField(name="ljhbjzfcrs")
    private double ljhbjzfcrs_环比建制封存人数_NUMBER_18_0;

    @JsonProperty("ljsnjzfcrs")
    @JSONField(name="ljsnjzfcrs")
    private double ljsnjzfcrs_同比建制封存人数_NUMBER_18_0;

    @JsonProperty("ljjzzcrs")
    @JSONField(name="ljjzzcrs")
    private int ljjzzcrs_建制正常人数_NUMBER_18_0;

    @JsonProperty("ljhbjzzcrs")
    @JSONField(name="ljhbjzzcrs")
    private double ljhbjzzcrs_环比建制正常人数_NUMBER_18_0;

    @JsonProperty("ljsnjzzcrs")
    @JSONField(name="ljsnjzzcrs")
    private double ljsnjzzcrs_同比建制正常人数_NUMBER_18_0;

    @JsonProperty("ljjzdjrs")
    @JSONField(name="ljjzdjrs")
    private int ljjzdjrs_建制冻结人数_NUMBER_18_0;

    @JsonProperty("ljhbjzdjrs")
    @JSONField(name="ljhbjzdjrs")
    private double ljhbjzdjrs_环比建制冻结人数_NUMBER_18_0;

    @JsonProperty("ljsnjzdjrs")
    @JSONField(name="ljsnjzdjrs")
    private double ljsnjzdjrs_同比建制冻结人数_NUMBER_18_0;

    @JsonProperty("ljhse")
    @JSONField(name="ljhse")
    private int ljhse_累计回收额_NUMBER_18_2;

    @JsonProperty("ljhbhse")
    @JSONField(name="ljhbhse")
    private double ljhbhse_环比累计回收额_NUMBER_18_2;

    @JsonProperty("ljsnhse")
    @JSONField(name="ljsnhse")
    private double ljsnhse_同比累计回收额_NUMBER_18_2;

    @JsonProperty("ljhsdkje")
    @JSONField(name="ljhsdkje")
    private int ljhsdkje_历史累计回收额_NUMBER_18_2;

    @JsonProperty("ljhbhsdkje")
    @JSONField(name="ljhbhsdkje")
    private double ljhbhsdkje_历史累计回收额环比_NUMBER_18_2;

    @JsonProperty("ljsnhsdkje")
    @JSONField(name="ljsnhsdkje")
    private double ljsnhsdkje_历史累计回收额同比_NUMBER_18_2;

    @JsonProperty("ljyqdked")
    @JSONField(name="ljyqdked")
    private int ljyqdked_逾期贷款额度_NUMBER_18_2;

    @JsonProperty("ljhbyqdked")
    @JSONField(name="ljhbyqdked")
    private double ljhbyqdked_环比逾期贷款额度_NUMBER_18_2;

    @JsonProperty("ljsnyqdked")
    @JSONField(name="ljsnyqdked")
    private double ljsnyqdked_同比逾期贷款额度_NUMBER_18_2;

    @JsonProperty("ljzldkbs")
    @JSONField(name="ljzldkbs")
    private int ljzldkbs_存量贷款笔数_NUMBER_18_0;
    @JsonProperty("ljhbzldkbs")
    @JSONField(name="ljhbzldkbs")
    private double ljhbzldkbs_环比存量贷款笔数_NUMBER_18_0;

    @JsonProperty("ljsnzldkbs")
    @JSONField(name="ljsnzldkbs")
    private double ljsnzldkbs_同比存量贷款笔数_NUMBER_18_0;

    @JsonProperty("ljthreeyqhs")
    @JSONField(name="ljthreeyqhs")
    private int ljthreeyqhs_三期以上笔数_NUMBER_18_0;

    @JsonProperty("ljhbthreeyqhs")
    @JSONField(name="ljhbthreeyqhs")
    private double ljhbthreeyqhs_环比三期以上笔数_NUMBER_18_0;

    @JsonProperty("ljsnthreeyqhs")
    @JSONField(name="ljsnthreeyqhs")
    private double ljsnthreeyqhs_同比三期以上笔数_NUMBER_18_0;


    @JsonProperty("ljsixyqhs")
    @JSONField(name="ljsixyqhs")
    private int ljsixyqhs_六期以上笔数_NUMBER_18_0;

    @JsonProperty("ljhbsixyqhs")
    @JSONField(name="ljhbsixyqhs")
    private double ljhbsixyqhs_环比六期以上笔数_NUMBER_18_0;

    @JsonProperty("ljsnsixyqhs")
    @JSONField(name="ljsnsixyqhs")
    private double ljsnsixyqhs_同比六期以上笔数_NUMBER_18_0;

    @JsonProperty("hslx")
    @JSONField(name="hslx")
    private int hslx_回收利息_NUMBER_18_2;
    @JsonProperty("hbhslx")
    @JSONField(name="hbhslx")
    private double hbhslx_环比回收利息_NUMBER_18_2;
    @JsonProperty("snhslx")
    @JSONField(name="snhslx")
    private double snhslx_同比回收利息_NUMBER_18_2;


    @JsonProperty("ljhslx")
    @JSONField(name="ljhslx")
    private int ljhslx_累计回收利息_NUMBER_18_2;
    @JsonProperty("ljhbhslx")
    @JSONField(name="ljhbhslx")
    private double ljhbhslx_累计环比回收利息_NUMBER_18_2;
    @JsonProperty("ljsnhslx")
    @JSONField(name="ljsnhslx")
    private double ljsnhslx_累计同比回收利息_NUMBER_18_2;


    @JsonProperty("nzjxje")
    @JSONField(name="nzjxje")
    private int nzjxje_结转利息额_NUMBER_18_2;
    @JsonProperty("hbnzjxje")
    @JSONField(name="hbnzjxje")
    private double hbnzjxje_环比结转利息额_NUMBER_18_2;
    @JsonProperty("snnzjxje")
    @JSONField(name="snnzjxje")
    private double snnzjxje_同比结转利息额_NUMBER_18_2;
    @JsonProperty("wbzrje")
    @JSONField(name="wbzrje")
    private int wbzrje_外部转入金额_NUMBER_18_2;

    @JsonProperty("hbwbzrje")
    @JSONField(name="hbwbzrje")
    private double hbwbzrje_环比外部转入金额_NUMBER_18_2;

    @JsonProperty("snwbzrje")
    @JSONField(name="snwbzrje")
    private double snwbzrje_同比外部转入金额_NUMBER_18_2;

    @JsonProperty("ljwbzrje")
    @JSONField(name="ljwbzrje")
    private double ljwbzrje_外部转入金额_NUMBER_18_2;

    @JsonProperty("ljhbwbzrje")
    @JSONField(name="ljhbwbzrje")
    private double ljhbwbzrje_环比外部转入金额_NUMBER_18_2;

    @JsonProperty("ljsnwbzrje")
    @JSONField(name="ljsnwbzrje")
    private double ljsnwbzrje_同比外部转入金额_NUMBER_18_2;
    @JsonProperty("wbzcje")
    @JSONField(name="wbzcje")
    private double wbzcje_外部转出金额_NUMBER_18_2;
    @JsonProperty("hbwbzcje")
    @JSONField(name="hbwbzcje")
    private double hbwbzcje_环比外部转出金额_NUMBER_18_2;
    @JsonProperty("snwbzcje")
    @JSONField(name="snwbzcje")
    private double snwbzcje_同比外部转出金额_NUMBER_18_2;
    @JsonProperty("ljwbzcje")
    @JSONField(name="ljwbzcje")
    private double ljwbzcje_累计外部转出金额_NUMBER_18_2;
    @JsonProperty("ljhbwbzcje")
    @JSONField(name="ljhbwbzcje")
    private double ljhbwbzcje_累计环比外部转出金额_NUMBER_18_2;
    @JsonProperty("ljsnwbzcje")
    @JSONField(name="ljsnwbzcje")
    private double ljsnwbzcje_累计环比外部转出金额_NUMBER_18_2;
    @JsonProperty("sjdws")
    @JSONField(name="sjdws")
    private int sjdws_实缴单位数_NUMBER_18_0;
    @JsonProperty("hbsjdws")
    @JSONField(name="hbsjdws")
    private double hbsjdws_环比实缴单位数_NUMBER_18_0;
    @JsonProperty("snsjdws")
    @JSONField(name="snsjdws")
    private double snsjdws_同比实缴单位数_NUMBER_18_0;
    @JsonProperty("sjzgs")
    @JSONField(name="sjzgs")
    private int sjzgs_实缴职工数_NUMBER_18_0;
    @JsonProperty("hbsjzgs")
    @JSONField(name="hbsjzgs")
    private double hbsjzgs_环比实缴职工数_NUMBER_18_0;

    @JsonProperty("snsjzgs")
    @JSONField(name="snsjzgs")
    private double snsjzgs_同比实缴职工数_NUMBER_18_0;

    @JsonProperty("jcye")
    @JSONField(name="jcye")
    private double jcye_缴存余额_NUMBER_18_2;

    @JsonProperty("hbjcye")
    @JSONField(name="hbjcye")
    private double hbjcye_环比缴存余额_NUMBER_18_2;

    @JsonProperty("snjcye")
    @JSONField(name="snjcye")
    private double snjcye_同比缴存余额_NUMBER_18_2;

    @JsonProperty("xkhdws")
    @JSONField(name="xkhdws")
    private int xkhdws_新开户单位_NUMBER_18_0;

    @JsonProperty("hbxkhdws")
    @JSONField(name="hbxkhdws")
    private double hbxkhdws_环比新开户单位_NUMBER_18_0;

    @JsonProperty("snxkhdws")
    @JSONField(name="snxkhdws")
    private double snxkhdws_同比新开户单位_NUMBER_18_0;

    @JsonProperty("ljxkhdws")
    @JSONField(name="ljxkhdws")
    private int ljxkhdws_累计新开户单位_NUMBER_18_0;

    @JsonProperty("ljhbxkhdws")
    @JSONField(name="ljhbxkhdws")
    private double ljhbxkhdws_累计环比新开户单位_NUMBER_18_0;

    @JsonProperty("ljsnxkhdws")
    @JSONField(name="ljsnxkhdws")
    private double ljsnxkhdws_累计同比新开户单位_NUMBER_18_0;

    @JsonProperty("xkhzgs")
    @JSONField(name="xkhzgs")
    private int xkhzgs_新开户职工_NUMBER_18_0;

    @JsonProperty("hbxkhzgs")
    @JSONField(name="hbxkhzgs")
    private double hbxkhzgs_环比新开户职工_NUMBER_18_0;

    @JsonProperty("snxkhzgs")
    @JSONField(name="snxkhzgs")
    private double snxkhzgs_同比新开户职工_NUMBER_18_0;

    @JsonProperty("ljxkhzgs")
    @JSONField(name="ljxkhzgs")
    private int ljxkhzgs_累计新开户职工_NUMBER_18_0;

    @JsonProperty("ljhbxkhzgs")
    @JSONField(name="ljhbxkhzgs")
    private double ljhbxkhzgs_累计环比新开户职工_NUMBER_18_0;

    @JsonProperty("ljsnxkhzgs")
    @JSONField(name="ljsnxkhzgs")
    private double ljsnxkhzgs_累计同比新开户职工_NUMBER_18_0;

    @JsonProperty("ljjce")
    @JSONField(name="ljjce")
    private double ljjce_累计缴存额_NUMBER_18_2;

    @JsonProperty("ljhbjce")
    @JSONField(name="ljhbjce")
    private double ljhbjce_环比累计缴存额_NUMBER_18_2;

    @JsonProperty("ljsnjce")
    @JSONField(name="ljsnjce")
    private double ljsnjce_同比累计缴存额_NUMBER_18_2;



    @JsonProperty("sjce")
    @JSONField(name="sjce")
    private double sjce_实缴存额_NUMBER_18_2;

    @JsonProperty("hbsjce")
    @JSONField(name="hbsjce")
    private double hbsjce_环比实缴存额_NUMBER_18_2;

    @JsonProperty("snsjce")
    @JSONField(name="snsjce")
    private double snsjce_同比实缴存额_NUMBER_18_2;

    @JsonProperty("ljsjce")
    @JSONField(name="ljsjce")
    private double ljsjce_累计实缴存额_NUMBER_18_2;

    @JsonProperty("ljhbsjce")
    @JSONField(name="ljhbsjce")
    private double ljhbsjce_累计环比实缴存额_NUMBER_18_2;

    @JsonProperty("ljsnsjce")
    @JSONField(name="ljsnsjce")
    private double ljsnsjce_累计同比实缴存额_NUMBER_18_2;

    @JsonProperty("ljtqe_")
    @JSONField(name="ljtqe_")
    private double ljtqe_历史累计提取额_提取原因_NUMBER_18_2;

    @JsonProperty("ljhbtqe")
    @JSONField(name="ljhbtqe")
    private double ljhbtqe_环比历史累计提取额_提取原因_NUMBER_18_2;
    @JsonProperty("ljsntqe")
    @JSONField(name="ljsntqe")

    private double ljsntqe_同比历史累计提取额_提取原因_NUMBER_18_2;

    @JsonProperty("tqje")
    @JSONField(name="tqje")
    private double tqje_提取金额_NUMBER_18_2;

    @JsonProperty("hbtqje")
    @JSONField(name="hbtqje")
    private double hbtqje_环比提取金额_NUMBER_18_2;

    @JsonProperty("sntqje")
    @JSONField(name="sntqje")
    private double sntqje_同比提取金额_NUMBER_18_2;

    @JsonProperty("ljtqje")
    @JSONField(name="ljtqje")
    private double ljtqje_累计提取金额_NUMBER_18_2;

    @JsonProperty("ljhbtqje")
    @JSONField(name="ljhbtqje")
    private double ljhbtqje_累计环比提取金额_NUMBER_18_2;

    @JsonProperty("ljsntqje")
    @JSONField(name="ljsntqje")
    private double ljsntqje_累计同比提取金额_NUMBER_18_2;


    @JsonProperty("ffje")
    @JSONField(name="ffje")
    private double ffje_发放金额_NUMBER_18_2;

    @JsonProperty("hbffje")
    @JSONField(name="hbffje")
    private double hbffje_环比发放金额_NUMBER_18_2;

    @JsonProperty("snffje")
    @JSONField(name="snffje")
    private double snffje_同比发放金额_NUMBER_18_2;

    @JsonProperty("ljffje")
    @JSONField(name="ljffje")
    private double ljffje_累计发放金额_NUMBER_18_2;

    @JsonProperty("ljhbffje")
    @JSONField(name="ljhbffje")
    private double ljhbffje_累计环比发放金额_NUMBER_18_2;

    @JsonProperty("ljsnffje")
    @JSONField(name="ljsnffje")
    private double ljsnffje_累计同比发放金额_NUMBER_18_2;

    @JsonProperty("hsje")
    @JSONField(name="hsje")

    private double hsje_回收金额_NUMBER_18_2;

    @JsonProperty("hbhsje")
    @JSONField(name="hbhsje")
    private double hbhsje_环比回收金额_NUMBER_18_2;
    @JsonProperty("snhsje")
    @JSONField(name="snhsje")

    private double snhsje_同比回收金额_NUMBER_18_2;
    @JsonProperty("ljhsje")
    @JSONField(name="ljhsje")
    private double ljhsje_累计回收金额_NUMBER_18_2;
    @JsonProperty("ljhbhsje")
    @JSONField(name="ljhbhsje")

    private double ljhbhsje_累计环比回收金额_NUMBER_18_2;

    @JsonProperty("ljsnhsje")
    @JSONField(name="ljsnhsje")
    private double ljsnhsje_累计同比回收金额_NUMBER_18_2;


    @JsonProperty("ljffdkje")
    @JSONField(name="ljffdkje")
    private double ljffdkje_累计发放贷款金额_NUMBER_18_2;

    @JsonProperty("ljhbffdkje")
    @JSONField(name="ljhbffdkje")
    private double ljhbffdkje_累计环比发放贷款金额_NUMBER_18_2;

    @JsonProperty("ljsnffdkje")
    @JSONField(name="ljsnffdkje")
    private double ljsnffdkje_累计同比发放贷款金额_NUMBER_18_2;
    @JsonProperty("yqdkje")
    @JSONField(name="yqdkje")
    private double yqdkje_逾期贷款金额_NUMBER_18_2;

    @JsonProperty("dkye")
    @JSONField(name="dkye")
    private double dkye_贷款余额_NUMBER_18_2;

    @JsonProperty("hbdkye")
    @JSONField(name="hbdkye")
    private double hbdkye_环比贷款余额_NUMBER_18_2;

    @JsonProperty("sndkye")
    @JSONField(name="sndkye")
    private double sndkye_同比贷款余额_NUMBER_18_2;



    @JsonProperty("ffbs")
    @JSONField(name="ffbs")
    private double ffbs_发放笔数_NUMBER_18_0;

    @JsonProperty("hbffbs")
    @JSONField(name="hbffbs")
    private double hbffbs_环比发放笔数_NUMBER_18_0;

    @JsonProperty("snffbs")
    @JSONField(name="snffbs")
    private double snffbs_同比发放笔数_NUMBER_18_0;

    @JsonProperty("ljffbs")
    @JSONField(name="ljffbs")
    private double ljffbs_累计发放笔数_NUMBER_18_0;

    @JsonProperty("ljhbffbs")
    @JSONField(name="ljhbffbs")
    private double ljhbffbs_累计环比发放笔数_NUMBER_18_0;

    @JsonProperty("ljsnffbs")
    @JSONField(name="ljsnffbs")
    private double ljsnffbs_累计同比发放笔数_NUMBER_18_0;

    @JsonProperty("zzsyje")
    @JSONField(name="zzsyje")
    private double zzsyje_增长收益金额_NUMBER_18_2;

    @JsonProperty("xmdkye")
    @JSONField(name="xmdkye")
    private double xmdkye_项目贷款余额_NUMBER_18_2;

    @JsonProperty("gzye")
    @JSONField(name="gzye")
    private double gzye_国债金额_NUMBER_18_2;
    @JsonProperty("hqzhye")
    @JSONField(name="hqzhye")
    private double hqzhye_活期账户余额_NUMBER_18_2;

    @JsonProperty("ywsrje")
    @JSONField(name="ywsrje")
    private double ywsrje_业务收入金额_NUMBER_18_2;

    @JsonProperty("ywzcje")
    @JSONField(name="ywzcje")
    private double ywzcje_业务收出金额_NUMBER_18_2;

    @JsonProperty("sjlzzf")
    @JSONField(name="sjlzzf")
    private double sjlzzf_上缴的保障房建设资金_NUMBER_18_2;

    @JsonProperty("fplzzf")
    @JSONField(name="fplzzf")
    private double fplzzf_计提的保障房建设资金_NUMBER_18_2;

    @JsonProperty("gthdbs")
    @JSONField(name="gthdbs")
    private int gthdbs_柜台核定笔数_NUMBER_18_0;

    @JsonProperty("wthdbs")
    @JSONField(name="wthdbs")
    private int wthdbs_网上核定笔数_NUMBER_18_0;

    @JsonProperty("gtxxbgbs")
    @JSONField(name="gtxxbgbs")
    private int gtxxbgbs_柜台信息变更笔数_NUMBER_18_0;

    @JsonProperty("wtxxbgbs")
    @JSONField(name="wtxxbgbs")
    private int wtxxbgbs_网上信息变更笔数_NUMBER_18_0;

    @JsonProperty("gtztbgbs")
    @JSONField(name="gtztbgbs")
    private int gtztbgbs_柜台状态变更笔数_NUMBER_18_0;

    @JsonProperty("wtztbgbs")
    @JSONField(name="wtztbgbs")
    private int wtztbgbs_网上状态变更笔数_NUMBER_18_0;

    @JsonProperty("gtjcjsbs")
    @JSONField(name="gtjcjsbs")
    private int gtjcjsbs_柜台缴存基数变更笔数_NUMBER_18_0;

    @JsonProperty("wtjcjsbs")
    @JSONField(name="wtjcjsbs")
    private int wtjcjsbs_网上缴存基数变更笔数_NUMBER_18_0;

    @JsonProperty("gttqbs")
    @JSONField(name="gttqbs")
    private int gttqbs_柜台提取笔数_NUMBER_18_0;

    @JsonProperty("wttqbs")
    @JSONField(name="wttqbs")
    private int wttqbs_网上提取笔数_NUMBER_18_0;

    @JsonProperty("gtdkbs")
    @JSONField(name="gtdkbs")
    private int gtdkbs_柜台贷款笔数_NUMBER_18_0;

    @JsonProperty("wtdkbs")
    @JSONField(name="wtdkbs")
    private int wtdkbs_网上贷款笔数_NUMBER_18_0;

    @JsonProperty("gttqhkbs")
    @JSONField(name="gttqhkbs")
    private int gttqhkbs_柜台提前还款笔数_NUMBER_18_0;

    @JsonProperty("wttqhkbs")
    @JSONField(name="wttqhkbs")
    private int wttqhkbs_网上提取还款笔数_NUMBER_18_0;

    @JsonProperty("gtchdjybs")
    @JSONField(name="gtchdjybs")
    private int gtchdjybs_柜台冲还贷笔数_NUMBER_18_0;

    @JsonProperty("wtchdjybs")
    @JSONField(name="wtchdjybs")
    private int wtchdjybs_网厅冲还贷总笔数_NUMBER_18_0;

    @JsonProperty("gjzbs")
    @JSONField(name="gjzbs")
    private int gjzbs_归集总笔数_NUMBER_18_0;

    @JsonProperty("wtgjzbs")
    @JSONField(name="wtgjzbs")
    private int wtgjzbs_网厅归集总笔数_NUMBER_18_0;

    @JsonProperty("tqzbs")
    @JSONField(name="tqzbs")
    private int tqzbs_提取总笔数_NUMBER_18_0;

    @JsonProperty("wttqzbs")
    @JSONField(name="wttqzbs")
    private int wttqzbs_网厅提取总笔数_NUMBER_18_0;

    @JsonProperty("dkzbs")
    @JSONField(name="dkzbs")

    private int dkzbs_贷款总笔数_NUMBER_18_0;

    @JsonProperty("wtdkzbs")
    @JSONField(name="wtdkzbs")
    private int wtdkzbs_网厅贷款总笔数_NUMBER_18_0;

    @JsonProperty("tqlgl")
    @JSONField(name="tqlgl")
    private double tqlgl_提取离柜率_NUMBER_18_2;

    @JsonProperty("gjlgl")
    @JSONField(name="gjlgl")
    private double gjlgl_归集离柜率_NUMBER_18_2;



    @JsonProperty("dklgl")
    @JSONField(name="dklgl")
    private double dklgl_贷款离柜率_NUMBER_18_2;

    @JsonProperty("zxlgl")
    @JSONField(name="zxlgl")
    private double zxlgl_中心离柜率_NUMBER_18_2;

    @JsonProperty("tqcsbs")
    @JSONField(name="tqcsbs")
    private int tqcsbs_提取超时笔数_NUMBER_18_0;


    @JsonProperty("dkcsbs")
    @JSONField(name="dkcsbs")
    private int dkcsbs_贷款超时笔数_NUMBER_18_0;


    @JsonProperty("dkzcspsj")
    @JSONField(name="dkzcspsj")
    private int dkzcspsj_贷款最长审批时间_NUMBER_18_2;

    @JsonProperty("dkpjspts")
    @JSONField(name="dkpjspts")
    private int dkpjspts_贷款平均审批天数_NUMBER_18_2;





    public int getZjbbm_住建部编码_VARCHAR6() {
        return zjbbm_住建部编码_VARCHAR6;
    }

    public void setZjbbm_住建部编码_VARCHAR6(int zjbbm_住建部编码_VARCHAR6) {
        this.zjbbm_住建部编码_VARCHAR6 = zjbbm_住建部编码_VARCHAR6;
    }

    public int getTjrq_统计日期_String() {
        return tjrq_统计日期_String;
    }

    public void setTjrq_统计日期_String(int tjrq_统计日期_String) {
        this.tjrq_统计日期_String = tjrq_统计日期_String;
    }

    public int getLjjzzdws_建制总单位数_NUMBER_18_2() {
        return ljjzzdws_建制总单位数_NUMBER_18_2;
    }

    public void setLjjzzdws_建制总单位数_NUMBER_18_2(int ljjzzdws_建制总单位数_NUMBER_18_2) {
        this.ljjzzdws_建制总单位数_NUMBER_18_2 = ljjzzdws_建制总单位数_NUMBER_18_2;
    }

    public double getLjhbjzzdws_环比建制总单位数_NUMBER_18_0() {
        return ljhbjzzdws_环比建制总单位数_NUMBER_18_0;
    }

    public void setLjhbjzzdws_环比建制总单位数_NUMBER_18_0(double ljhbjzzdws_环比建制总单位数_NUMBER_18_0) {
        this.ljhbjzzdws_环比建制总单位数_NUMBER_18_0 = ljhbjzzdws_环比建制总单位数_NUMBER_18_0;
    }

    public double getLjsnjzzdws_同比建制总单位数_NUMBER_18_0() {
        return ljsnjzzdws_同比建制总单位数_NUMBER_18_0;
    }

    public void setLjsnjzzdws_同比建制总单位数_NUMBER_18_0(double ljsnjzzdws_同比建制总单位数_NUMBER_18_0) {
        this.ljsnjzzdws_同比建制总单位数_NUMBER_18_0 = ljsnjzzdws_同比建制总单位数_NUMBER_18_0;
    }

    public int getLjjzxhdws_建制销户单位数_NUMBER_18_0() {
        return ljjzxhdws_建制销户单位数_NUMBER_18_0;
    }

    public void setLjjzxhdws_建制销户单位数_NUMBER_18_0(int ljjzxhdws_建制销户单位数_NUMBER_18_0) {
        this.ljjzxhdws_建制销户单位数_NUMBER_18_0 = ljjzxhdws_建制销户单位数_NUMBER_18_0;
    }

    public double getLjhbjzxhdws_环比建制销户单位数_NUMBER_18_0() {
        return ljhbjzxhdws_环比建制销户单位数_NUMBER_18_0;
    }

    public void setLjhbjzxhdws_环比建制销户单位数_NUMBER_18_0(double ljhbjzxhdws_环比建制销户单位数_NUMBER_18_0) {
        this.ljhbjzxhdws_环比建制销户单位数_NUMBER_18_0 = ljhbjzxhdws_环比建制销户单位数_NUMBER_18_0;
    }

    public double getLjsnjzxhdws_同比建制销户单位数_NUMBER_18_0() {
        return ljsnjzxhdws_同比建制销户单位数_NUMBER_18_0;
    }

    public void setLjsnjzxhdws_同比建制销户单位数_NUMBER_18_0(double ljsnjzxhdws_同比建制销户单位数_NUMBER_18_0) {
        this.ljsnjzxhdws_同比建制销户单位数_NUMBER_18_0 = ljsnjzxhdws_同比建制销户单位数_NUMBER_18_0;
    }

    public int getLjjzfxhdws_建制非销户单位数_NUMBER_18_0() {
        return ljjzfxhdws_建制非销户单位数_NUMBER_18_0;
    }

    public void setLjjzfxhdws_建制非销户单位数_NUMBER_18_0(int ljjzfxhdws_建制非销户单位数_NUMBER_18_0) {
        this.ljjzfxhdws_建制非销户单位数_NUMBER_18_0 = ljjzfxhdws_建制非销户单位数_NUMBER_18_0;
    }

    public double getLjhbjzfxhdws_环比建制非销户单位数_NUMBER_18_0() {
        return ljhbjzfxhdws_环比建制非销户单位数_NUMBER_18_0;
    }

    public void setLjhbjzfxhdws_环比建制非销户单位数_NUMBER_18_0(double ljhbjzfxhdws_环比建制非销户单位数_NUMBER_18_0) {
        this.ljhbjzfxhdws_环比建制非销户单位数_NUMBER_18_0 = ljhbjzfxhdws_环比建制非销户单位数_NUMBER_18_0;
    }

    public double getLjsnjzfxhdws_同比建制非销户单位数_NUMBER_18_0() {
        return ljsnjzfxhdws_同比建制非销户单位数_NUMBER_18_0;
    }

    public void setLjsnjzfxhdws_同比建制非销户单位数_NUMBER_18_0(double ljsnjzfxhdws_同比建制非销户单位数_NUMBER_18_0) {
        this.ljsnjzfxhdws_同比建制非销户单位数_NUMBER_18_0 = ljsnjzfxhdws_同比建制非销户单位数_NUMBER_18_0;
    }

    public int getLjjzfcdws_建制封存单位数_NUMBER_18_0() {
        return ljjzfcdws_建制封存单位数_NUMBER_18_0;
    }

    public void setLjjzfcdws_建制封存单位数_NUMBER_18_0(int ljjzfcdws_建制封存单位数_NUMBER_18_0) {
        this.ljjzfcdws_建制封存单位数_NUMBER_18_0 = ljjzfcdws_建制封存单位数_NUMBER_18_0;
    }

    public double getLjhbjzfcdws_环比建制封存单位数_NUMBER_18_0() {
        return ljhbjzfcdws_环比建制封存单位数_NUMBER_18_0;
    }

    public void setLjhbjzfcdws_环比建制封存单位数_NUMBER_18_0(double ljhbjzfcdws_环比建制封存单位数_NUMBER_18_0) {
        this.ljhbjzfcdws_环比建制封存单位数_NUMBER_18_0 = ljhbjzfcdws_环比建制封存单位数_NUMBER_18_0;
    }

    public double getLjsnjzfcdws_同比建制封存单位数_NUMBER_18_0() {
        return ljsnjzfcdws_同比建制封存单位数_NUMBER_18_0;
    }

    public void setLjsnjzfcdws_同比建制封存单位数_NUMBER_18_0(double ljsnjzfcdws_同比建制封存单位数_NUMBER_18_0) {
        this.ljsnjzfcdws_同比建制封存单位数_NUMBER_18_0 = ljsnjzfcdws_同比建制封存单位数_NUMBER_18_0;
    }

    public int getLjjzzcdws_建制正常单位数_NUMBER_18_0() {
        return ljjzzcdws_建制正常单位数_NUMBER_18_0;
    }

    public void setLjjzzcdws_建制正常单位数_NUMBER_18_0(int ljjzzcdws_建制正常单位数_NUMBER_18_0) {
        this.ljjzzcdws_建制正常单位数_NUMBER_18_0 = ljjzzcdws_建制正常单位数_NUMBER_18_0;
    }

    public double getLjhbjzzcdws_环比建制正常单位数_NUMBER_18_0() {
        return ljhbjzzcdws_环比建制正常单位数_NUMBER_18_0;
    }

    public void setLjhbjzzcdws_环比建制正常单位数_NUMBER_18_0(double ljhbjzzcdws_环比建制正常单位数_NUMBER_18_0) {
        this.ljhbjzzcdws_环比建制正常单位数_NUMBER_18_0 = ljhbjzzcdws_环比建制正常单位数_NUMBER_18_0;
    }

    public double getLjsnjzzcdws_同比建制正常单位数_NUMBER_18_0() {
        return ljsnjzzcdws_同比建制正常单位数_NUMBER_18_0;
    }

    public void setLjsnjzzcdws_同比建制正常单位数_NUMBER_18_0(double ljsnjzzcdws_同比建制正常单位数_NUMBER_18_0) {
        this.ljsnjzzcdws_同比建制正常单位数_NUMBER_18_0 = ljsnjzzcdws_同比建制正常单位数_NUMBER_18_0;
    }

    public int getLjjzhjdws_建制缓缴单位数_NUMBER_18_0() {
        return ljjzhjdws_建制缓缴单位数_NUMBER_18_0;
    }

    public void setLjjzhjdws_建制缓缴单位数_NUMBER_18_0(int ljjzhjdws_建制缓缴单位数_NUMBER_18_0) {
        this.ljjzhjdws_建制缓缴单位数_NUMBER_18_0 = ljjzhjdws_建制缓缴单位数_NUMBER_18_0;
    }

    public double getLjhbjzhjdws_环比建制缓缴单位数_NUMBER_18_0() {
        return ljhbjzhjdws_环比建制缓缴单位数_NUMBER_18_0;
    }

    public void setLjhbjzhjdws_环比建制缓缴单位数_NUMBER_18_0(double ljhbjzhjdws_环比建制缓缴单位数_NUMBER_18_0) {
        this.ljhbjzhjdws_环比建制缓缴单位数_NUMBER_18_0 = ljhbjzhjdws_环比建制缓缴单位数_NUMBER_18_0;
    }

    public double getLjsnjzhjdws_同比建制缓缴单位数_NUMBER_18_0() {
        return ljsnjzhjdws_同比建制缓缴单位数_NUMBER_18_0;
    }

    public void setLjsnjzhjdws_同比建制缓缴单位数_NUMBER_18_0(double ljsnjzhjdws_同比建制缓缴单位数_NUMBER_18_0) {
        this.ljsnjzhjdws_同比建制缓缴单位数_NUMBER_18_0 = ljsnjzhjdws_同比建制缓缴单位数_NUMBER_18_0;
    }

    public int getLjjzzrs_建制总人数_NUMBER_18_0() {
        return ljjzzrs_建制总人数_NUMBER_18_0;
    }

    public void setLjjzzrs_建制总人数_NUMBER_18_0(int ljjzzrs_建制总人数_NUMBER_18_0) {
        this.ljjzzrs_建制总人数_NUMBER_18_0 = ljjzzrs_建制总人数_NUMBER_18_0;
    }

    public double getLjhbjzzrs_环比建制总人数_NUMBER_18_0() {
        return ljhbjzzrs_环比建制总人数_NUMBER_18_0;
    }

    public void setLjhbjzzrs_环比建制总人数_NUMBER_18_0(double ljhbjzzrs_环比建制总人数_NUMBER_18_0) {
        this.ljhbjzzrs_环比建制总人数_NUMBER_18_0 = ljhbjzzrs_环比建制总人数_NUMBER_18_0;
    }

    public double getLjsnjzzrs_同比建制总人数_NUMBER_18_0() {
        return ljsnjzzrs_同比建制总人数_NUMBER_18_0;
    }

    public void setLjsnjzzrs_同比建制总人数_NUMBER_18_0(double ljsnjzzrs_同比建制总人数_NUMBER_18_0) {
        this.ljsnjzzrs_同比建制总人数_NUMBER_18_0 = ljsnjzzrs_同比建制总人数_NUMBER_18_0;
    }

    public int getLjjzxhrs_建制销户人数_NUMBER_18_0() {
        return ljjzxhrs_建制销户人数_NUMBER_18_0;
    }

    public void setLjjzxhrs_建制销户人数_NUMBER_18_0(int ljjzxhrs_建制销户人数_NUMBER_18_0) {
        this.ljjzxhrs_建制销户人数_NUMBER_18_0 = ljjzxhrs_建制销户人数_NUMBER_18_0;
    }

    public double getLjhbjzxhrs_环比建制销户人数_NUMBER_18_0() {
        return ljhbjzxhrs_环比建制销户人数_NUMBER_18_0;
    }

    public void setLjhbjzxhrs_环比建制销户人数_NUMBER_18_0(double ljhbjzxhrs_环比建制销户人数_NUMBER_18_0) {
        this.ljhbjzxhrs_环比建制销户人数_NUMBER_18_0 = ljhbjzxhrs_环比建制销户人数_NUMBER_18_0;
    }

    public double getLjsnjzxhrs_同比建制销户人数_NUMBER_18_0() {
        return ljsnjzxhrs_同比建制销户人数_NUMBER_18_0;
    }

    public void setLjsnjzxhrs_同比建制销户人数_NUMBER_18_0(double ljsnjzxhrs_同比建制销户人数_NUMBER_18_0) {
        this.ljsnjzxhrs_同比建制销户人数_NUMBER_18_0 = ljsnjzxhrs_同比建制销户人数_NUMBER_18_0;
    }

    public int getLjjzfxhrs_建制非销户人数_NUMBER_18_0() {
        return ljjzfxhrs_建制非销户人数_NUMBER_18_0;
    }

    public void setLjjzfxhrs_建制非销户人数_NUMBER_18_0(int ljjzfxhrs_建制非销户人数_NUMBER_18_0) {
        this.ljjzfxhrs_建制非销户人数_NUMBER_18_0 = ljjzfxhrs_建制非销户人数_NUMBER_18_0;
    }

    public double getLjhbjzfxhrs_环比建制非销户人数_NUMBER_18_0() {
        return ljhbjzfxhrs_环比建制非销户人数_NUMBER_18_0;
    }

    public void setLjhbjzfxhrs_环比建制非销户人数_NUMBER_18_0(double ljhbjzfxhrs_环比建制非销户人数_NUMBER_18_0) {
        this.ljhbjzfxhrs_环比建制非销户人数_NUMBER_18_0 = ljhbjzfxhrs_环比建制非销户人数_NUMBER_18_0;
    }

    public double getLjsnjzfxhrs_同比建制非销户人数_NUMBER_18_0() {
        return ljsnjzfxhrs_同比建制非销户人数_NUMBER_18_0;
    }

    public void setLjsnjzfxhrs_同比建制非销户人数_NUMBER_18_0(double ljsnjzfxhrs_同比建制非销户人数_NUMBER_18_0) {
        this.ljsnjzfxhrs_同比建制非销户人数_NUMBER_18_0 = ljsnjzfxhrs_同比建制非销户人数_NUMBER_18_0;
    }

    public int getLjjzfcrs_建制封存人数_NUMBER_18_0() {
        return ljjzfcrs_建制封存人数_NUMBER_18_0;
    }

    public void setLjjzfcrs_建制封存人数_NUMBER_18_0(int ljjzfcrs_建制封存人数_NUMBER_18_0) {
        this.ljjzfcrs_建制封存人数_NUMBER_18_0 = ljjzfcrs_建制封存人数_NUMBER_18_0;
    }

    public double getLjhbjzfcrs_环比建制封存人数_NUMBER_18_0() {
        return ljhbjzfcrs_环比建制封存人数_NUMBER_18_0;
    }

    public void setLjhbjzfcrs_环比建制封存人数_NUMBER_18_0(double ljhbjzfcrs_环比建制封存人数_NUMBER_18_0) {
        this.ljhbjzfcrs_环比建制封存人数_NUMBER_18_0 = ljhbjzfcrs_环比建制封存人数_NUMBER_18_0;
    }

    public double getLjsnjzfcrs_同比建制封存人数_NUMBER_18_0() {
        return ljsnjzfcrs_同比建制封存人数_NUMBER_18_0;
    }

    public void setLjsnjzfcrs_同比建制封存人数_NUMBER_18_0(double ljsnjzfcrs_同比建制封存人数_NUMBER_18_0) {
        this.ljsnjzfcrs_同比建制封存人数_NUMBER_18_0 = ljsnjzfcrs_同比建制封存人数_NUMBER_18_0;
    }

    public int getLjjzzcrs_建制正常人数_NUMBER_18_0() {
        return ljjzzcrs_建制正常人数_NUMBER_18_0;
    }

    public void setLjjzzcrs_建制正常人数_NUMBER_18_0(int ljjzzcrs_建制正常人数_NUMBER_18_0) {
        this.ljjzzcrs_建制正常人数_NUMBER_18_0 = ljjzzcrs_建制正常人数_NUMBER_18_0;
    }

    public double getLjhbjzzcrs_环比建制正常人数_NUMBER_18_0() {
        return ljhbjzzcrs_环比建制正常人数_NUMBER_18_0;
    }

    public void setLjhbjzzcrs_环比建制正常人数_NUMBER_18_0(double ljhbjzzcrs_环比建制正常人数_NUMBER_18_0) {
        this.ljhbjzzcrs_环比建制正常人数_NUMBER_18_0 = ljhbjzzcrs_环比建制正常人数_NUMBER_18_0;
    }

    public double getLjsnjzzcrs_同比建制正常人数_NUMBER_18_0() {
        return ljsnjzzcrs_同比建制正常人数_NUMBER_18_0;
    }

    public void setLjsnjzzcrs_同比建制正常人数_NUMBER_18_0(double ljsnjzzcrs_同比建制正常人数_NUMBER_18_0) {
        this.ljsnjzzcrs_同比建制正常人数_NUMBER_18_0 = ljsnjzzcrs_同比建制正常人数_NUMBER_18_0;
    }

    public int getLjjzdjrs_建制冻结人数_NUMBER_18_0() {
        return ljjzdjrs_建制冻结人数_NUMBER_18_0;
    }

    public void setLjjzdjrs_建制冻结人数_NUMBER_18_0(int ljjzdjrs_建制冻结人数_NUMBER_18_0) {
        this.ljjzdjrs_建制冻结人数_NUMBER_18_0 = ljjzdjrs_建制冻结人数_NUMBER_18_0;
    }

    public double getLjhbjzdjrs_环比建制冻结人数_NUMBER_18_0() {
        return ljhbjzdjrs_环比建制冻结人数_NUMBER_18_0;
    }

    public void setLjhbjzdjrs_环比建制冻结人数_NUMBER_18_0(double ljhbjzdjrs_环比建制冻结人数_NUMBER_18_0) {
        this.ljhbjzdjrs_环比建制冻结人数_NUMBER_18_0 = ljhbjzdjrs_环比建制冻结人数_NUMBER_18_0;
    }

    public double getLjsnjzdjrs_同比建制冻结人数_NUMBER_18_0() {
        return ljsnjzdjrs_同比建制冻结人数_NUMBER_18_0;
    }

    public void setLjsnjzdjrs_同比建制冻结人数_NUMBER_18_0(double ljsnjzdjrs_同比建制冻结人数_NUMBER_18_0) {
        this.ljsnjzdjrs_同比建制冻结人数_NUMBER_18_0 = ljsnjzdjrs_同比建制冻结人数_NUMBER_18_0;
    }

    public int getLjhse_累计回收额_NUMBER_18_2() {
        return ljhse_累计回收额_NUMBER_18_2;
    }

    public void setLjhse_累计回收额_NUMBER_18_2(int ljhse_累计回收额_NUMBER_18_2) {
        this.ljhse_累计回收额_NUMBER_18_2 = ljhse_累计回收额_NUMBER_18_2;
    }

    public double getLjhbhse_环比累计回收额_NUMBER_18_2() {
        return ljhbhse_环比累计回收额_NUMBER_18_2;
    }

    public void setLjhbhse_环比累计回收额_NUMBER_18_2(double ljhbhse_环比累计回收额_NUMBER_18_2) {
        this.ljhbhse_环比累计回收额_NUMBER_18_2 = ljhbhse_环比累计回收额_NUMBER_18_2;
    }

    public double getLjsnhse_同比累计回收额_NUMBER_18_2() {
        return ljsnhse_同比累计回收额_NUMBER_18_2;
    }

    public void setLjsnhse_同比累计回收额_NUMBER_18_2(double ljsnhse_同比累计回收额_NUMBER_18_2) {
        this.ljsnhse_同比累计回收额_NUMBER_18_2 = ljsnhse_同比累计回收额_NUMBER_18_2;
    }

    public int getLjhsdkje_历史累计回收额_NUMBER_18_2() {
        return ljhsdkje_历史累计回收额_NUMBER_18_2;
    }

    public void setLjhsdkje_历史累计回收额_NUMBER_18_2(int ljhsdkje_历史累计回收额_NUMBER_18_2) {
        this.ljhsdkje_历史累计回收额_NUMBER_18_2 = ljhsdkje_历史累计回收额_NUMBER_18_2;
    }

    public double getLjhbhsdkje_历史累计回收额环比_NUMBER_18_2() {
        return ljhbhsdkje_历史累计回收额环比_NUMBER_18_2;
    }

    public void setLjhbhsdkje_历史累计回收额环比_NUMBER_18_2(double ljhbhsdkje_历史累计回收额环比_NUMBER_18_2) {
        this.ljhbhsdkje_历史累计回收额环比_NUMBER_18_2 = ljhbhsdkje_历史累计回收额环比_NUMBER_18_2;
    }

    public double getLjsnhsdkje_历史累计回收额同比_NUMBER_18_2() {
        return ljsnhsdkje_历史累计回收额同比_NUMBER_18_2;
    }

    public void setLjsnhsdkje_历史累计回收额同比_NUMBER_18_2(double ljsnhsdkje_历史累计回收额同比_NUMBER_18_2) {
        this.ljsnhsdkje_历史累计回收额同比_NUMBER_18_2 = ljsnhsdkje_历史累计回收额同比_NUMBER_18_2;
    }

    public int getLjyqdked_逾期贷款额度_NUMBER_18_2() {
        return ljyqdked_逾期贷款额度_NUMBER_18_2;
    }

    public void setLjyqdked_逾期贷款额度_NUMBER_18_2(int ljyqdked_逾期贷款额度_NUMBER_18_2) {
        this.ljyqdked_逾期贷款额度_NUMBER_18_2 = ljyqdked_逾期贷款额度_NUMBER_18_2;
    }

    public double getLjhbyqdked_环比逾期贷款额度_NUMBER_18_2() {
        return ljhbyqdked_环比逾期贷款额度_NUMBER_18_2;
    }

    public void setLjhbyqdked_环比逾期贷款额度_NUMBER_18_2(double ljhbyqdked_环比逾期贷款额度_NUMBER_18_2) {
        this.ljhbyqdked_环比逾期贷款额度_NUMBER_18_2 = ljhbyqdked_环比逾期贷款额度_NUMBER_18_2;
    }

    public double getLjsnyqdked_同比逾期贷款额度_NUMBER_18_2() {
        return ljsnyqdked_同比逾期贷款额度_NUMBER_18_2;
    }

    public void setLjsnyqdked_同比逾期贷款额度_NUMBER_18_2(double ljsnyqdked_同比逾期贷款额度_NUMBER_18_2) {
        this.ljsnyqdked_同比逾期贷款额度_NUMBER_18_2 = ljsnyqdked_同比逾期贷款额度_NUMBER_18_2;
    }

    public int getLjzldkbs_存量贷款笔数_NUMBER_18_0() {
        return ljzldkbs_存量贷款笔数_NUMBER_18_0;
    }

    public void setLjzldkbs_存量贷款笔数_NUMBER_18_0(int ljzldkbs_存量贷款笔数_NUMBER_18_0) {
        this.ljzldkbs_存量贷款笔数_NUMBER_18_0 = ljzldkbs_存量贷款笔数_NUMBER_18_0;
    }

    public double getLjhbzldkbs_环比存量贷款笔数_NUMBER_18_0() {
        return ljhbzldkbs_环比存量贷款笔数_NUMBER_18_0;
    }

    public void setLjhbzldkbs_环比存量贷款笔数_NUMBER_18_0(double ljhbzldkbs_环比存量贷款笔数_NUMBER_18_0) {
        this.ljhbzldkbs_环比存量贷款笔数_NUMBER_18_0 = ljhbzldkbs_环比存量贷款笔数_NUMBER_18_0;
    }

    public double getLjsnzldkbs_同比存量贷款笔数_NUMBER_18_0() {
        return ljsnzldkbs_同比存量贷款笔数_NUMBER_18_0;
    }

    public void setLjsnzldkbs_同比存量贷款笔数_NUMBER_18_0(double ljsnzldkbs_同比存量贷款笔数_NUMBER_18_0) {
        this.ljsnzldkbs_同比存量贷款笔数_NUMBER_18_0 = ljsnzldkbs_同比存量贷款笔数_NUMBER_18_0;
    }

    public int getLjthreeyqhs_三期以上笔数_NUMBER_18_0() {
        return ljthreeyqhs_三期以上笔数_NUMBER_18_0;
    }

    public void setLjthreeyqhs_三期以上笔数_NUMBER_18_0(int ljthreeyqhs_三期以上笔数_NUMBER_18_0) {
        this.ljthreeyqhs_三期以上笔数_NUMBER_18_0 = ljthreeyqhs_三期以上笔数_NUMBER_18_0;
    }

    public double getLjhbthreeyqhs_环比三期以上笔数_NUMBER_18_0() {
        return ljhbthreeyqhs_环比三期以上笔数_NUMBER_18_0;
    }

    public void setLjhbthreeyqhs_环比三期以上笔数_NUMBER_18_0(double ljhbthreeyqhs_环比三期以上笔数_NUMBER_18_0) {
        this.ljhbthreeyqhs_环比三期以上笔数_NUMBER_18_0 = ljhbthreeyqhs_环比三期以上笔数_NUMBER_18_0;
    }

    public double getLjsnthreeyqhs_同比三期以上笔数_NUMBER_18_0() {
        return ljsnthreeyqhs_同比三期以上笔数_NUMBER_18_0;
    }

    public void setLjsnthreeyqhs_同比三期以上笔数_NUMBER_18_0(double ljsnthreeyqhs_同比三期以上笔数_NUMBER_18_0) {
        this.ljsnthreeyqhs_同比三期以上笔数_NUMBER_18_0 = ljsnthreeyqhs_同比三期以上笔数_NUMBER_18_0;
    }

    public int getLjsixyqhs_六期以上笔数_NUMBER_18_0() {
        return ljsixyqhs_六期以上笔数_NUMBER_18_0;
    }

    public void setLjsixyqhs_六期以上笔数_NUMBER_18_0(int ljsixyqhs_六期以上笔数_NUMBER_18_0) {
        this.ljsixyqhs_六期以上笔数_NUMBER_18_0 = ljsixyqhs_六期以上笔数_NUMBER_18_0;
    }

    public double getLjhbsixyqhs_环比六期以上笔数_NUMBER_18_0() {
        return ljhbsixyqhs_环比六期以上笔数_NUMBER_18_0;
    }

    public void setLjhbsixyqhs_环比六期以上笔数_NUMBER_18_0(double ljhbsixyqhs_环比六期以上笔数_NUMBER_18_0) {
        this.ljhbsixyqhs_环比六期以上笔数_NUMBER_18_0 = ljhbsixyqhs_环比六期以上笔数_NUMBER_18_0;
    }

    public double getLjsnsixyqhs_同比六期以上笔数_NUMBER_18_0() {
        return ljsnsixyqhs_同比六期以上笔数_NUMBER_18_0;
    }

    public void setLjsnsixyqhs_同比六期以上笔数_NUMBER_18_0(double ljsnsixyqhs_同比六期以上笔数_NUMBER_18_0) {
        this.ljsnsixyqhs_同比六期以上笔数_NUMBER_18_0 = ljsnsixyqhs_同比六期以上笔数_NUMBER_18_0;
    }

    public int getHslx_回收利息_NUMBER_18_2() {
        return hslx_回收利息_NUMBER_18_2;
    }

    public void setHslx_回收利息_NUMBER_18_2(int hslx_回收利息_NUMBER_18_2) {
        this.hslx_回收利息_NUMBER_18_2 = hslx_回收利息_NUMBER_18_2;
    }

    public double getHbhslx_环比回收利息_NUMBER_18_2() {
        return hbhslx_环比回收利息_NUMBER_18_2;
    }

    public void setHbhslx_环比回收利息_NUMBER_18_2(double hbhslx_环比回收利息_NUMBER_18_2) {
        this.hbhslx_环比回收利息_NUMBER_18_2 = hbhslx_环比回收利息_NUMBER_18_2;
    }

    public double getSnhslx_同比回收利息_NUMBER_18_2() {
        return snhslx_同比回收利息_NUMBER_18_2;
    }

    public void setSnhslx_同比回收利息_NUMBER_18_2(double snhslx_同比回收利息_NUMBER_18_2) {
        this.snhslx_同比回收利息_NUMBER_18_2 = snhslx_同比回收利息_NUMBER_18_2;
    }

    public int getLjhslx_累计回收利息_NUMBER_18_2() {
        return ljhslx_累计回收利息_NUMBER_18_2;
    }

    public void setLjhslx_累计回收利息_NUMBER_18_2(int ljhslx_累计回收利息_NUMBER_18_2) {
        this.ljhslx_累计回收利息_NUMBER_18_2 = ljhslx_累计回收利息_NUMBER_18_2;
    }

    public double getLjhbhslx_累计环比回收利息_NUMBER_18_2() {
        return ljhbhslx_累计环比回收利息_NUMBER_18_2;
    }

    public void setLjhbhslx_累计环比回收利息_NUMBER_18_2(double ljhbhslx_累计环比回收利息_NUMBER_18_2) {
        this.ljhbhslx_累计环比回收利息_NUMBER_18_2 = ljhbhslx_累计环比回收利息_NUMBER_18_2;
    }

    public double getLjsnhslx_累计同比回收利息_NUMBER_18_2() {
        return ljsnhslx_累计同比回收利息_NUMBER_18_2;
    }

    public void setLjsnhslx_累计同比回收利息_NUMBER_18_2(double ljsnhslx_累计同比回收利息_NUMBER_18_2) {
        this.ljsnhslx_累计同比回收利息_NUMBER_18_2 = ljsnhslx_累计同比回收利息_NUMBER_18_2;
    }

    public int getNzjxje_结转利息额_NUMBER_18_2() {
        return nzjxje_结转利息额_NUMBER_18_2;
    }

    public void setNzjxje_结转利息额_NUMBER_18_2(int nzjxje_结转利息额_NUMBER_18_2) {
        this.nzjxje_结转利息额_NUMBER_18_2 = nzjxje_结转利息额_NUMBER_18_2;
    }

    public double getHbnzjxje_环比结转利息额_NUMBER_18_2() {
        return hbnzjxje_环比结转利息额_NUMBER_18_2;
    }

    public void setHbnzjxje_环比结转利息额_NUMBER_18_2(double hbnzjxje_环比结转利息额_NUMBER_18_2) {
        this.hbnzjxje_环比结转利息额_NUMBER_18_2 = hbnzjxje_环比结转利息额_NUMBER_18_2;
    }

    public double getSnnzjxje_同比结转利息额_NUMBER_18_2() {
        return snnzjxje_同比结转利息额_NUMBER_18_2;
    }

    public void setSnnzjxje_同比结转利息额_NUMBER_18_2(double snnzjxje_同比结转利息额_NUMBER_18_2) {
        this.snnzjxje_同比结转利息额_NUMBER_18_2 = snnzjxje_同比结转利息额_NUMBER_18_2;
    }

    public int getWbzrje_外部转入金额_NUMBER_18_2() {
        return wbzrje_外部转入金额_NUMBER_18_2;
    }

    public void setWbzrje_外部转入金额_NUMBER_18_2(int wbzrje_外部转入金额_NUMBER_18_2) {
        this.wbzrje_外部转入金额_NUMBER_18_2 = wbzrje_外部转入金额_NUMBER_18_2;
    }

    public double getHbwbzrje_环比外部转入金额_NUMBER_18_2() {
        return hbwbzrje_环比外部转入金额_NUMBER_18_2;
    }

    public void setHbwbzrje_环比外部转入金额_NUMBER_18_2(double hbwbzrje_环比外部转入金额_NUMBER_18_2) {
        this.hbwbzrje_环比外部转入金额_NUMBER_18_2 = hbwbzrje_环比外部转入金额_NUMBER_18_2;
    }

    public double getSnwbzrje_同比外部转入金额_NUMBER_18_2() {
        return snwbzrje_同比外部转入金额_NUMBER_18_2;
    }

    public void setSnwbzrje_同比外部转入金额_NUMBER_18_2(double snwbzrje_同比外部转入金额_NUMBER_18_2) {
        this.snwbzrje_同比外部转入金额_NUMBER_18_2 = snwbzrje_同比外部转入金额_NUMBER_18_2;
    }

    public double getLjwbzrje_外部转入金额_NUMBER_18_2() {
        return ljwbzrje_外部转入金额_NUMBER_18_2;
    }

    public void setLjwbzrje_外部转入金额_NUMBER_18_2(double ljwbzrje_外部转入金额_NUMBER_18_2) {
        this.ljwbzrje_外部转入金额_NUMBER_18_2 = ljwbzrje_外部转入金额_NUMBER_18_2;
    }

    public double getLjhbwbzrje_环比外部转入金额_NUMBER_18_2() {
        return ljhbwbzrje_环比外部转入金额_NUMBER_18_2;
    }

    public void setLjhbwbzrje_环比外部转入金额_NUMBER_18_2(double ljhbwbzrje_环比外部转入金额_NUMBER_18_2) {
        this.ljhbwbzrje_环比外部转入金额_NUMBER_18_2 = ljhbwbzrje_环比外部转入金额_NUMBER_18_2;
    }

    public double getLjsnwbzrje_同比外部转入金额_NUMBER_18_2() {
        return ljsnwbzrje_同比外部转入金额_NUMBER_18_2;
    }

    public void setLjsnwbzrje_同比外部转入金额_NUMBER_18_2(double ljsnwbzrje_同比外部转入金额_NUMBER_18_2) {
        this.ljsnwbzrje_同比外部转入金额_NUMBER_18_2 = ljsnwbzrje_同比外部转入金额_NUMBER_18_2;
    }

    public double getWbzcje_外部转出金额_NUMBER_18_2() {
        return wbzcje_外部转出金额_NUMBER_18_2;
    }

    public void setWbzcje_外部转出金额_NUMBER_18_2(double wbzcje_外部转出金额_NUMBER_18_2) {
        this.wbzcje_外部转出金额_NUMBER_18_2 = wbzcje_外部转出金额_NUMBER_18_2;
    }

    public double getHbwbzcje_环比外部转出金额_NUMBER_18_2() {
        return hbwbzcje_环比外部转出金额_NUMBER_18_2;
    }

    public void setHbwbzcje_环比外部转出金额_NUMBER_18_2(double hbwbzcje_环比外部转出金额_NUMBER_18_2) {
        this.hbwbzcje_环比外部转出金额_NUMBER_18_2 = hbwbzcje_环比外部转出金额_NUMBER_18_2;
    }

    public double getSnwbzcje_同比外部转出金额_NUMBER_18_2() {
        return snwbzcje_同比外部转出金额_NUMBER_18_2;
    }

    public void setSnwbzcje_同比外部转出金额_NUMBER_18_2(double snwbzcje_同比外部转出金额_NUMBER_18_2) {
        this.snwbzcje_同比外部转出金额_NUMBER_18_2 = snwbzcje_同比外部转出金额_NUMBER_18_2;
    }

    public double getLjwbzcje_累计外部转出金额_NUMBER_18_2() {
        return ljwbzcje_累计外部转出金额_NUMBER_18_2;
    }

    public void setLjwbzcje_累计外部转出金额_NUMBER_18_2(double ljwbzcje_累计外部转出金额_NUMBER_18_2) {
        this.ljwbzcje_累计外部转出金额_NUMBER_18_2 = ljwbzcje_累计外部转出金额_NUMBER_18_2;
    }

    public double getLjhbwbzcje_累计环比外部转出金额_NUMBER_18_2() {
        return ljhbwbzcje_累计环比外部转出金额_NUMBER_18_2;
    }

    public void setLjhbwbzcje_累计环比外部转出金额_NUMBER_18_2(double ljhbwbzcje_累计环比外部转出金额_NUMBER_18_2) {
        this.ljhbwbzcje_累计环比外部转出金额_NUMBER_18_2 = ljhbwbzcje_累计环比外部转出金额_NUMBER_18_2;
    }

    public double getLjsnwbzcje_累计环比外部转出金额_NUMBER_18_2() {
        return ljsnwbzcje_累计环比外部转出金额_NUMBER_18_2;
    }

    public void setLjsnwbzcje_累计环比外部转出金额_NUMBER_18_2(double ljsnwbzcje_累计环比外部转出金额_NUMBER_18_2) {
        this.ljsnwbzcje_累计环比外部转出金额_NUMBER_18_2 = ljsnwbzcje_累计环比外部转出金额_NUMBER_18_2;
    }

    public int getSjdws_实缴单位数_NUMBER_18_0() {
        return sjdws_实缴单位数_NUMBER_18_0;
    }

    public void setSjdws_实缴单位数_NUMBER_18_0(int sjdws_实缴单位数_NUMBER_18_0) {
        this.sjdws_实缴单位数_NUMBER_18_0 = sjdws_实缴单位数_NUMBER_18_0;
    }

    public double getHbsjdws_环比实缴单位数_NUMBER_18_0() {
        return hbsjdws_环比实缴单位数_NUMBER_18_0;
    }

    public void setHbsjdws_环比实缴单位数_NUMBER_18_0(double hbsjdws_环比实缴单位数_NUMBER_18_0) {
        this.hbsjdws_环比实缴单位数_NUMBER_18_0 = hbsjdws_环比实缴单位数_NUMBER_18_0;
    }

    public double getSnsjdws_同比实缴单位数_NUMBER_18_0() {
        return snsjdws_同比实缴单位数_NUMBER_18_0;
    }

    public void setSnsjdws_同比实缴单位数_NUMBER_18_0(double snsjdws_同比实缴单位数_NUMBER_18_0) {
        this.snsjdws_同比实缴单位数_NUMBER_18_0 = snsjdws_同比实缴单位数_NUMBER_18_0;
    }

    public int getSjzgs_实缴职工数_NUMBER_18_0() {
        return sjzgs_实缴职工数_NUMBER_18_0;
    }

    public void setSjzgs_实缴职工数_NUMBER_18_0(int sjzgs_实缴职工数_NUMBER_18_0) {
        this.sjzgs_实缴职工数_NUMBER_18_0 = sjzgs_实缴职工数_NUMBER_18_0;
    }

    public double getHbsjzgs_环比实缴职工数_NUMBER_18_0() {
        return hbsjzgs_环比实缴职工数_NUMBER_18_0;
    }

    public void setHbsjzgs_环比实缴职工数_NUMBER_18_0(double hbsjzgs_环比实缴职工数_NUMBER_18_0) {
        this.hbsjzgs_环比实缴职工数_NUMBER_18_0 = hbsjzgs_环比实缴职工数_NUMBER_18_0;
    }

    public double getSnsjzgs_同比实缴职工数_NUMBER_18_0() {
        return snsjzgs_同比实缴职工数_NUMBER_18_0;
    }

    public void setSnsjzgs_同比实缴职工数_NUMBER_18_0(double snsjzgs_同比实缴职工数_NUMBER_18_0) {
        this.snsjzgs_同比实缴职工数_NUMBER_18_0 = snsjzgs_同比实缴职工数_NUMBER_18_0;
    }

    public double getJcye_缴存余额_NUMBER_18_2() {
        return jcye_缴存余额_NUMBER_18_2;
    }

    public void setJcye_缴存余额_NUMBER_18_2(double jcye_缴存余额_NUMBER_18_2) {
        this.jcye_缴存余额_NUMBER_18_2 = jcye_缴存余额_NUMBER_18_2;
    }

    public double getHbjcye_环比缴存余额_NUMBER_18_2() {
        return hbjcye_环比缴存余额_NUMBER_18_2;
    }

    public void setHbjcye_环比缴存余额_NUMBER_18_2(double hbjcye_环比缴存余额_NUMBER_18_2) {
        this.hbjcye_环比缴存余额_NUMBER_18_2 = hbjcye_环比缴存余额_NUMBER_18_2;
    }

    public double getSnjcye_同比缴存余额_NUMBER_18_2() {
        return snjcye_同比缴存余额_NUMBER_18_2;
    }

    public void setSnjcye_同比缴存余额_NUMBER_18_2(double snjcye_同比缴存余额_NUMBER_18_2) {
        this.snjcye_同比缴存余额_NUMBER_18_2 = snjcye_同比缴存余额_NUMBER_18_2;
    }

    public int getXkhdws_新开户单位_NUMBER_18_0() {
        return xkhdws_新开户单位_NUMBER_18_0;
    }

    public void setXkhdws_新开户单位_NUMBER_18_0(int xkhdws_新开户单位_NUMBER_18_0) {
        this.xkhdws_新开户单位_NUMBER_18_0 = xkhdws_新开户单位_NUMBER_18_0;
    }

    public double getHbxkhdws_环比新开户单位_NUMBER_18_0() {
        return hbxkhdws_环比新开户单位_NUMBER_18_0;
    }

    public void setHbxkhdws_环比新开户单位_NUMBER_18_0(double hbxkhdws_环比新开户单位_NUMBER_18_0) {
        this.hbxkhdws_环比新开户单位_NUMBER_18_0 = hbxkhdws_环比新开户单位_NUMBER_18_0;
    }

    public double getSnxkhdws_同比新开户单位_NUMBER_18_0() {
        return snxkhdws_同比新开户单位_NUMBER_18_0;
    }

    public void setSnxkhdws_同比新开户单位_NUMBER_18_0(double snxkhdws_同比新开户单位_NUMBER_18_0) {
        this.snxkhdws_同比新开户单位_NUMBER_18_0 = snxkhdws_同比新开户单位_NUMBER_18_0;
    }

    public int getLjxkhdws_累计新开户单位_NUMBER_18_0() {
        return ljxkhdws_累计新开户单位_NUMBER_18_0;
    }

    public void setLjxkhdws_累计新开户单位_NUMBER_18_0(int ljxkhdws_累计新开户单位_NUMBER_18_0) {
        this.ljxkhdws_累计新开户单位_NUMBER_18_0 = ljxkhdws_累计新开户单位_NUMBER_18_0;
    }

    public double getLjhbxkhdws_累计环比新开户单位_NUMBER_18_0() {
        return ljhbxkhdws_累计环比新开户单位_NUMBER_18_0;
    }

    public void setLjhbxkhdws_累计环比新开户单位_NUMBER_18_0(double ljhbxkhdws_累计环比新开户单位_NUMBER_18_0) {
        this.ljhbxkhdws_累计环比新开户单位_NUMBER_18_0 = ljhbxkhdws_累计环比新开户单位_NUMBER_18_0;
    }

    public double getLjsnxkhdws_累计同比新开户单位_NUMBER_18_0() {
        return ljsnxkhdws_累计同比新开户单位_NUMBER_18_0;
    }

    public void setLjsnxkhdws_累计同比新开户单位_NUMBER_18_0(double ljsnxkhdws_累计同比新开户单位_NUMBER_18_0) {
        this.ljsnxkhdws_累计同比新开户单位_NUMBER_18_0 = ljsnxkhdws_累计同比新开户单位_NUMBER_18_0;
    }

    public int getXkhzgs_新开户职工_NUMBER_18_0() {
        return xkhzgs_新开户职工_NUMBER_18_0;
    }

    public void setXkhzgs_新开户职工_NUMBER_18_0(int xkhzgs_新开户职工_NUMBER_18_0) {
        this.xkhzgs_新开户职工_NUMBER_18_0 = xkhzgs_新开户职工_NUMBER_18_0;
    }

    public double getHbxkhzgs_环比新开户职工_NUMBER_18_0() {
        return hbxkhzgs_环比新开户职工_NUMBER_18_0;
    }

    public void setHbxkhzgs_环比新开户职工_NUMBER_18_0(double hbxkhzgs_环比新开户职工_NUMBER_18_0) {
        this.hbxkhzgs_环比新开户职工_NUMBER_18_0 = hbxkhzgs_环比新开户职工_NUMBER_18_0;
    }

    public double getSnxkhzgs_同比新开户职工_NUMBER_18_0() {
        return snxkhzgs_同比新开户职工_NUMBER_18_0;
    }

    public void setSnxkhzgs_同比新开户职工_NUMBER_18_0(double snxkhzgs_同比新开户职工_NUMBER_18_0) {
        this.snxkhzgs_同比新开户职工_NUMBER_18_0 = snxkhzgs_同比新开户职工_NUMBER_18_0;
    }

    public int getLjxkhzgs_累计新开户职工_NUMBER_18_0() {
        return ljxkhzgs_累计新开户职工_NUMBER_18_0;
    }

    public void setLjxkhzgs_累计新开户职工_NUMBER_18_0(int ljxkhzgs_累计新开户职工_NUMBER_18_0) {
        this.ljxkhzgs_累计新开户职工_NUMBER_18_0 = ljxkhzgs_累计新开户职工_NUMBER_18_0;
    }

    public double getLjhbxkhzgs_累计环比新开户职工_NUMBER_18_0() {
        return ljhbxkhzgs_累计环比新开户职工_NUMBER_18_0;
    }

    public void setLjhbxkhzgs_累计环比新开户职工_NUMBER_18_0(double ljhbxkhzgs_累计环比新开户职工_NUMBER_18_0) {
        this.ljhbxkhzgs_累计环比新开户职工_NUMBER_18_0 = ljhbxkhzgs_累计环比新开户职工_NUMBER_18_0;
    }

    public double getLjsnxkhzgs_累计同比新开户职工_NUMBER_18_0() {
        return ljsnxkhzgs_累计同比新开户职工_NUMBER_18_0;
    }

    public void setLjsnxkhzgs_累计同比新开户职工_NUMBER_18_0(double ljsnxkhzgs_累计同比新开户职工_NUMBER_18_0) {
        this.ljsnxkhzgs_累计同比新开户职工_NUMBER_18_0 = ljsnxkhzgs_累计同比新开户职工_NUMBER_18_0;
    }

    public double getLjjce_累计缴存额_NUMBER_18_2() {
        return ljjce_累计缴存额_NUMBER_18_2;
    }

    public void setLjjce_累计缴存额_NUMBER_18_2(double ljjce_累计缴存额_NUMBER_18_2) {
        this.ljjce_累计缴存额_NUMBER_18_2 = ljjce_累计缴存额_NUMBER_18_2;
    }

    public double getLjhbjce_环比累计缴存额_NUMBER_18_2() {
        return ljhbjce_环比累计缴存额_NUMBER_18_2;
    }

    public void setLjhbjce_环比累计缴存额_NUMBER_18_2(double ljhbjce_环比累计缴存额_NUMBER_18_2) {
        this.ljhbjce_环比累计缴存额_NUMBER_18_2 = ljhbjce_环比累计缴存额_NUMBER_18_2;
    }

    public double getLjsnjce_同比累计缴存额_NUMBER_18_2() {
        return ljsnjce_同比累计缴存额_NUMBER_18_2;
    }

    public void setLjsnjce_同比累计缴存额_NUMBER_18_2(double ljsnjce_同比累计缴存额_NUMBER_18_2) {
        this.ljsnjce_同比累计缴存额_NUMBER_18_2 = ljsnjce_同比累计缴存额_NUMBER_18_2;
    }

    public double getSjce_实缴存额_NUMBER_18_2() {
        return sjce_实缴存额_NUMBER_18_2;
    }

    public void setSjce_实缴存额_NUMBER_18_2(double sjce_实缴存额_NUMBER_18_2) {
        this.sjce_实缴存额_NUMBER_18_2 = sjce_实缴存额_NUMBER_18_2;
    }

    public double getHbsjce_环比实缴存额_NUMBER_18_2() {
        return hbsjce_环比实缴存额_NUMBER_18_2;
    }

    public void setHbsjce_环比实缴存额_NUMBER_18_2(double hbsjce_环比实缴存额_NUMBER_18_2) {
        this.hbsjce_环比实缴存额_NUMBER_18_2 = hbsjce_环比实缴存额_NUMBER_18_2;
    }

    public double getSnsjce_同比实缴存额_NUMBER_18_2() {
        return snsjce_同比实缴存额_NUMBER_18_2;
    }

    public void setSnsjce_同比实缴存额_NUMBER_18_2(double snsjce_同比实缴存额_NUMBER_18_2) {
        this.snsjce_同比实缴存额_NUMBER_18_2 = snsjce_同比实缴存额_NUMBER_18_2;
    }

    public double getLjsjce_累计实缴存额_NUMBER_18_2() {
        return ljsjce_累计实缴存额_NUMBER_18_2;
    }

    public void setLjsjce_累计实缴存额_NUMBER_18_2(double ljsjce_累计实缴存额_NUMBER_18_2) {
        this.ljsjce_累计实缴存额_NUMBER_18_2 = ljsjce_累计实缴存额_NUMBER_18_2;
    }

    public double getLjhbsjce_累计环比实缴存额_NUMBER_18_2() {
        return ljhbsjce_累计环比实缴存额_NUMBER_18_2;
    }

    public void setLjhbsjce_累计环比实缴存额_NUMBER_18_2(double ljhbsjce_累计环比实缴存额_NUMBER_18_2) {
        this.ljhbsjce_累计环比实缴存额_NUMBER_18_2 = ljhbsjce_累计环比实缴存额_NUMBER_18_2;
    }

    public double getLjsnsjce_累计同比实缴存额_NUMBER_18_2() {
        return ljsnsjce_累计同比实缴存额_NUMBER_18_2;
    }

    public void setLjsnsjce_累计同比实缴存额_NUMBER_18_2(double ljsnsjce_累计同比实缴存额_NUMBER_18_2) {
        this.ljsnsjce_累计同比实缴存额_NUMBER_18_2 = ljsnsjce_累计同比实缴存额_NUMBER_18_2;
    }

    public double getLjtqe_历史累计提取额_提取原因_NUMBER_18_2() {
        return ljtqe_历史累计提取额_提取原因_NUMBER_18_2;
    }

    public void setLjtqe_历史累计提取额_提取原因_NUMBER_18_2(double ljtqe_历史累计提取额_提取原因_NUMBER_18_2) {
        this.ljtqe_历史累计提取额_提取原因_NUMBER_18_2 = ljtqe_历史累计提取额_提取原因_NUMBER_18_2;
    }

    public double getLjhbtqe_环比历史累计提取额_提取原因_NUMBER_18_2() {
        return ljhbtqe_环比历史累计提取额_提取原因_NUMBER_18_2;
    }

    public void setLjhbtqe_环比历史累计提取额_提取原因_NUMBER_18_2(double ljhbtqe_环比历史累计提取额_提取原因_NUMBER_18_2) {
        this.ljhbtqe_环比历史累计提取额_提取原因_NUMBER_18_2 = ljhbtqe_环比历史累计提取额_提取原因_NUMBER_18_2;
    }

    public double getLjsntqe_同比历史累计提取额_提取原因_NUMBER_18_2() {
        return ljsntqe_同比历史累计提取额_提取原因_NUMBER_18_2;
    }

    public void setLjsntqe_同比历史累计提取额_提取原因_NUMBER_18_2(double ljsntqe_同比历史累计提取额_提取原因_NUMBER_18_2) {
        this.ljsntqe_同比历史累计提取额_提取原因_NUMBER_18_2 = ljsntqe_同比历史累计提取额_提取原因_NUMBER_18_2;
    }

    public double getTqje_提取金额_NUMBER_18_2() {
        return tqje_提取金额_NUMBER_18_2;
    }

    public void setTqje_提取金额_NUMBER_18_2(double tqje_提取金额_NUMBER_18_2) {
        this.tqje_提取金额_NUMBER_18_2 = tqje_提取金额_NUMBER_18_2;
    }

    public double getHbtqje_环比提取金额_NUMBER_18_2() {
        return hbtqje_环比提取金额_NUMBER_18_2;
    }

    public void setHbtqje_环比提取金额_NUMBER_18_2(double hbtqje_环比提取金额_NUMBER_18_2) {
        this.hbtqje_环比提取金额_NUMBER_18_2 = hbtqje_环比提取金额_NUMBER_18_2;
    }

    public double getSntqje_同比提取金额_NUMBER_18_2() {
        return sntqje_同比提取金额_NUMBER_18_2;
    }

    public void setSntqje_同比提取金额_NUMBER_18_2(double sntqje_同比提取金额_NUMBER_18_2) {
        this.sntqje_同比提取金额_NUMBER_18_2 = sntqje_同比提取金额_NUMBER_18_2;
    }

    public double getLjtqje_累计提取金额_NUMBER_18_2() {
        return ljtqje_累计提取金额_NUMBER_18_2;
    }

    public void setLjtqje_累计提取金额_NUMBER_18_2(double ljtqje_累计提取金额_NUMBER_18_2) {
        this.ljtqje_累计提取金额_NUMBER_18_2 = ljtqje_累计提取金额_NUMBER_18_2;
    }

    public double getLjhbtqje_累计环比提取金额_NUMBER_18_2() {
        return ljhbtqje_累计环比提取金额_NUMBER_18_2;
    }

    public void setLjhbtqje_累计环比提取金额_NUMBER_18_2(double ljhbtqje_累计环比提取金额_NUMBER_18_2) {
        this.ljhbtqje_累计环比提取金额_NUMBER_18_2 = ljhbtqje_累计环比提取金额_NUMBER_18_2;
    }

    public double getLjsntqje_累计同比提取金额_NUMBER_18_2() {
        return ljsntqje_累计同比提取金额_NUMBER_18_2;
    }

    public void setLjsntqje_累计同比提取金额_NUMBER_18_2(double ljsntqje_累计同比提取金额_NUMBER_18_2) {
        this.ljsntqje_累计同比提取金额_NUMBER_18_2 = ljsntqje_累计同比提取金额_NUMBER_18_2;
    }

    public double getFfje_发放金额_NUMBER_18_2() {
        return ffje_发放金额_NUMBER_18_2;
    }

    public void setFfje_发放金额_NUMBER_18_2(double ffje_发放金额_NUMBER_18_2) {
        this.ffje_发放金额_NUMBER_18_2 = ffje_发放金额_NUMBER_18_2;
    }

    public double getHbffje_环比发放金额_NUMBER_18_2() {
        return hbffje_环比发放金额_NUMBER_18_2;
    }

    public void setHbffje_环比发放金额_NUMBER_18_2(double hbffje_环比发放金额_NUMBER_18_2) {
        this.hbffje_环比发放金额_NUMBER_18_2 = hbffje_环比发放金额_NUMBER_18_2;
    }

    public double getSnffje_同比发放金额_NUMBER_18_2() {
        return snffje_同比发放金额_NUMBER_18_2;
    }

    public void setSnffje_同比发放金额_NUMBER_18_2(double snffje_同比发放金额_NUMBER_18_2) {
        this.snffje_同比发放金额_NUMBER_18_2 = snffje_同比发放金额_NUMBER_18_2;
    }

    public double getLjffje_累计发放金额_NUMBER_18_2() {
        return ljffje_累计发放金额_NUMBER_18_2;
    }

    public void setLjffje_累计发放金额_NUMBER_18_2(double ljffje_累计发放金额_NUMBER_18_2) {
        this.ljffje_累计发放金额_NUMBER_18_2 = ljffje_累计发放金额_NUMBER_18_2;
    }

    public double getLjhbffje_累计环比发放金额_NUMBER_18_2() {
        return ljhbffje_累计环比发放金额_NUMBER_18_2;
    }

    public void setLjhbffje_累计环比发放金额_NUMBER_18_2(double ljhbffje_累计环比发放金额_NUMBER_18_2) {
        this.ljhbffje_累计环比发放金额_NUMBER_18_2 = ljhbffje_累计环比发放金额_NUMBER_18_2;
    }

    public double getLjsnffje_累计同比发放金额_NUMBER_18_2() {
        return ljsnffje_累计同比发放金额_NUMBER_18_2;
    }

    public void setLjsnffje_累计同比发放金额_NUMBER_18_2(double ljsnffje_累计同比发放金额_NUMBER_18_2) {
        this.ljsnffje_累计同比发放金额_NUMBER_18_2 = ljsnffje_累计同比发放金额_NUMBER_18_2;
    }

    public double getHsje_回收金额_NUMBER_18_2() {
        return hsje_回收金额_NUMBER_18_2;
    }

    public void setHsje_回收金额_NUMBER_18_2(double hsje_回收金额_NUMBER_18_2) {
        this.hsje_回收金额_NUMBER_18_2 = hsje_回收金额_NUMBER_18_2;
    }

    public double getHbhsje_环比回收金额_NUMBER_18_2() {
        return hbhsje_环比回收金额_NUMBER_18_2;
    }

    public void setHbhsje_环比回收金额_NUMBER_18_2(double hbhsje_环比回收金额_NUMBER_18_2) {
        this.hbhsje_环比回收金额_NUMBER_18_2 = hbhsje_环比回收金额_NUMBER_18_2;
    }

    public double getSnhsje_同比回收金额_NUMBER_18_2() {
        return snhsje_同比回收金额_NUMBER_18_2;
    }

    public void setSnhsje_同比回收金额_NUMBER_18_2(double snhsje_同比回收金额_NUMBER_18_2) {
        this.snhsje_同比回收金额_NUMBER_18_2 = snhsje_同比回收金额_NUMBER_18_2;
    }

    public double getLjhsje_累计回收金额_NUMBER_18_2() {
        return ljhsje_累计回收金额_NUMBER_18_2;
    }

    public void setLjhsje_累计回收金额_NUMBER_18_2(double ljhsje_累计回收金额_NUMBER_18_2) {
        this.ljhsje_累计回收金额_NUMBER_18_2 = ljhsje_累计回收金额_NUMBER_18_2;
    }

    public double getLjhbhsje_累计环比回收金额_NUMBER_18_2() {
        return ljhbhsje_累计环比回收金额_NUMBER_18_2;
    }

    public void setLjhbhsje_累计环比回收金额_NUMBER_18_2(double ljhbhsje_累计环比回收金额_NUMBER_18_2) {
        this.ljhbhsje_累计环比回收金额_NUMBER_18_2 = ljhbhsje_累计环比回收金额_NUMBER_18_2;
    }

    public double getLjsnhsje_累计同比回收金额_NUMBER_18_2() {
        return ljsnhsje_累计同比回收金额_NUMBER_18_2;
    }

    public void setLjsnhsje_累计同比回收金额_NUMBER_18_2(double ljsnhsje_累计同比回收金额_NUMBER_18_2) {
        this.ljsnhsje_累计同比回收金额_NUMBER_18_2 = ljsnhsje_累计同比回收金额_NUMBER_18_2;
    }

    public double getLjffdkje_累计发放贷款金额_NUMBER_18_2() {
        return ljffdkje_累计发放贷款金额_NUMBER_18_2;
    }

    public void setLjffdkje_累计发放贷款金额_NUMBER_18_2(double ljffdkje_累计发放贷款金额_NUMBER_18_2) {
        this.ljffdkje_累计发放贷款金额_NUMBER_18_2 = ljffdkje_累计发放贷款金额_NUMBER_18_2;
    }

    public double getLjhbffdkje_累计环比发放贷款金额_NUMBER_18_2() {
        return ljhbffdkje_累计环比发放贷款金额_NUMBER_18_2;
    }

    public void setLjhbffdkje_累计环比发放贷款金额_NUMBER_18_2(double ljhbffdkje_累计环比发放贷款金额_NUMBER_18_2) {
        this.ljhbffdkje_累计环比发放贷款金额_NUMBER_18_2 = ljhbffdkje_累计环比发放贷款金额_NUMBER_18_2;
    }

    public double getLjsnffdkje_累计同比发放贷款金额_NUMBER_18_2() {
        return ljsnffdkje_累计同比发放贷款金额_NUMBER_18_2;
    }

    public void setLjsnffdkje_累计同比发放贷款金额_NUMBER_18_2(double ljsnffdkje_累计同比发放贷款金额_NUMBER_18_2) {
        this.ljsnffdkje_累计同比发放贷款金额_NUMBER_18_2 = ljsnffdkje_累计同比发放贷款金额_NUMBER_18_2;
    }

    public double getYqdkje_逾期贷款金额_NUMBER_18_2() {
        return yqdkje_逾期贷款金额_NUMBER_18_2;
    }

    public void setYqdkje_逾期贷款金额_NUMBER_18_2(double yqdkje_逾期贷款金额_NUMBER_18_2) {
        this.yqdkje_逾期贷款金额_NUMBER_18_2 = yqdkje_逾期贷款金额_NUMBER_18_2;
    }

    public double getDkye_贷款余额_NUMBER_18_2() {
        return dkye_贷款余额_NUMBER_18_2;
    }

    public void setDkye_贷款余额_NUMBER_18_2(double dkye_贷款余额_NUMBER_18_2) {
        this.dkye_贷款余额_NUMBER_18_2 = dkye_贷款余额_NUMBER_18_2;
    }

    public double getHbdkye_环比贷款余额_NUMBER_18_2() {
        return hbdkye_环比贷款余额_NUMBER_18_2;
    }

    public void setHbdkye_环比贷款余额_NUMBER_18_2(double hbdkye_环比贷款余额_NUMBER_18_2) {
        this.hbdkye_环比贷款余额_NUMBER_18_2 = hbdkye_环比贷款余额_NUMBER_18_2;
    }

    public double getSndkye_同比贷款余额_NUMBER_18_2() {
        return sndkye_同比贷款余额_NUMBER_18_2;
    }

    public void setSndkye_同比贷款余额_NUMBER_18_2(double sndkye_同比贷款余额_NUMBER_18_2) {
        this.sndkye_同比贷款余额_NUMBER_18_2 = sndkye_同比贷款余额_NUMBER_18_2;
    }

    public double getFfbs_发放笔数_NUMBER_18_0() {
        return ffbs_发放笔数_NUMBER_18_0;
    }

    public void setFfbs_发放笔数_NUMBER_18_0(double ffbs_发放笔数_NUMBER_18_0) {
        this.ffbs_发放笔数_NUMBER_18_0 = ffbs_发放笔数_NUMBER_18_0;
    }

    public double getHbffbs_环比发放笔数_NUMBER_18_0() {
        return hbffbs_环比发放笔数_NUMBER_18_0;
    }

    public void setHbffbs_环比发放笔数_NUMBER_18_0(double hbffbs_环比发放笔数_NUMBER_18_0) {
        this.hbffbs_环比发放笔数_NUMBER_18_0 = hbffbs_环比发放笔数_NUMBER_18_0;
    }

    public double getSnffbs_同比发放笔数_NUMBER_18_0() {
        return snffbs_同比发放笔数_NUMBER_18_0;
    }

    public void setSnffbs_同比发放笔数_NUMBER_18_0(double snffbs_同比发放笔数_NUMBER_18_0) {
        this.snffbs_同比发放笔数_NUMBER_18_0 = snffbs_同比发放笔数_NUMBER_18_0;
    }

    public double getLjffbs_累计发放笔数_NUMBER_18_0() {
        return ljffbs_累计发放笔数_NUMBER_18_0;
    }

    public void setLjffbs_累计发放笔数_NUMBER_18_0(double ljffbs_累计发放笔数_NUMBER_18_0) {
        this.ljffbs_累计发放笔数_NUMBER_18_0 = ljffbs_累计发放笔数_NUMBER_18_0;
    }

    public double getLjhbffbs_累计环比发放笔数_NUMBER_18_0() {
        return ljhbffbs_累计环比发放笔数_NUMBER_18_0;
    }

    public void setLjhbffbs_累计环比发放笔数_NUMBER_18_0(double ljhbffbs_累计环比发放笔数_NUMBER_18_0) {
        this.ljhbffbs_累计环比发放笔数_NUMBER_18_0 = ljhbffbs_累计环比发放笔数_NUMBER_18_0;
    }

    public double getLjsnffbs_累计同比发放笔数_NUMBER_18_0() {
        return ljsnffbs_累计同比发放笔数_NUMBER_18_0;
    }

    public void setLjsnffbs_累计同比发放笔数_NUMBER_18_0(double ljsnffbs_累计同比发放笔数_NUMBER_18_0) {
        this.ljsnffbs_累计同比发放笔数_NUMBER_18_0 = ljsnffbs_累计同比发放笔数_NUMBER_18_0;
    }

    public double getZzsyje_增长收益金额_NUMBER_18_2() {
        return zzsyje_增长收益金额_NUMBER_18_2;
    }

    public void setZzsyje_增长收益金额_NUMBER_18_2(double zzsyje_增长收益金额_NUMBER_18_2) {
        this.zzsyje_增长收益金额_NUMBER_18_2 = zzsyje_增长收益金额_NUMBER_18_2;
    }

    public double getXmdkye_项目贷款余额_NUMBER_18_2() {
        return xmdkye_项目贷款余额_NUMBER_18_2;
    }

    public void setXmdkye_项目贷款余额_NUMBER_18_2(double xmdkye_项目贷款余额_NUMBER_18_2) {
        this.xmdkye_项目贷款余额_NUMBER_18_2 = xmdkye_项目贷款余额_NUMBER_18_2;
    }

    public double getGzye_国债金额_NUMBER_18_2() {
        return gzye_国债金额_NUMBER_18_2;
    }

    public void setGzye_国债金额_NUMBER_18_2(double gzye_国债金额_NUMBER_18_2) {
        this.gzye_国债金额_NUMBER_18_2 = gzye_国债金额_NUMBER_18_2;
    }

    public double getHqzhye_活期账户余额_NUMBER_18_2() {
        return hqzhye_活期账户余额_NUMBER_18_2;
    }

    public void setHqzhye_活期账户余额_NUMBER_18_2(double hqzhye_活期账户余额_NUMBER_18_2) {
        this.hqzhye_活期账户余额_NUMBER_18_2 = hqzhye_活期账户余额_NUMBER_18_2;
    }

    public double getYwsrje_业务收入金额_NUMBER_18_2() {
        return ywsrje_业务收入金额_NUMBER_18_2;
    }

    public void setYwsrje_业务收入金额_NUMBER_18_2(double ywsrje_业务收入金额_NUMBER_18_2) {
        this.ywsrje_业务收入金额_NUMBER_18_2 = ywsrje_业务收入金额_NUMBER_18_2;
    }

    public double getYwzcje_业务收出金额_NUMBER_18_2() {
        return ywzcje_业务收出金额_NUMBER_18_2;
    }

    public void setYwzcje_业务收出金额_NUMBER_18_2(double ywzcje_业务收出金额_NUMBER_18_2) {
        this.ywzcje_业务收出金额_NUMBER_18_2 = ywzcje_业务收出金额_NUMBER_18_2;
    }

    public double getSjlzzf_上缴的保障房建设资金_NUMBER_18_2() {
        return sjlzzf_上缴的保障房建设资金_NUMBER_18_2;
    }

    public void setSjlzzf_上缴的保障房建设资金_NUMBER_18_2(double sjlzzf_上缴的保障房建设资金_NUMBER_18_2) {
        this.sjlzzf_上缴的保障房建设资金_NUMBER_18_2 = sjlzzf_上缴的保障房建设资金_NUMBER_18_2;
    }

    public double getFplzzf_计提的保障房建设资金_NUMBER_18_2() {
        return fplzzf_计提的保障房建设资金_NUMBER_18_2;
    }

    public void setFplzzf_计提的保障房建设资金_NUMBER_18_2(double fplzzf_计提的保障房建设资金_NUMBER_18_2) {
        this.fplzzf_计提的保障房建设资金_NUMBER_18_2 = fplzzf_计提的保障房建设资金_NUMBER_18_2;
    }

    public int getGthdbs_柜台核定笔数_NUMBER_18_0() {
        return gthdbs_柜台核定笔数_NUMBER_18_0;
    }

    public void setGthdbs_柜台核定笔数_NUMBER_18_0(int gthdbs_柜台核定笔数_NUMBER_18_0) {
        this.gthdbs_柜台核定笔数_NUMBER_18_0 = gthdbs_柜台核定笔数_NUMBER_18_0;
    }

    public int getWthdbs_网上核定笔数_NUMBER_18_0() {
        return wthdbs_网上核定笔数_NUMBER_18_0;
    }

    public void setWthdbs_网上核定笔数_NUMBER_18_0(int wthdbs_网上核定笔数_NUMBER_18_0) {
        this.wthdbs_网上核定笔数_NUMBER_18_0 = wthdbs_网上核定笔数_NUMBER_18_0;
    }

    public int getGtxxbgbs_柜台信息变更笔数_NUMBER_18_0() {
        return gtxxbgbs_柜台信息变更笔数_NUMBER_18_0;
    }

    public void setGtxxbgbs_柜台信息变更笔数_NUMBER_18_0(int gtxxbgbs_柜台信息变更笔数_NUMBER_18_0) {
        this.gtxxbgbs_柜台信息变更笔数_NUMBER_18_0 = gtxxbgbs_柜台信息变更笔数_NUMBER_18_0;
    }

    public int getWtxxbgbs_网上信息变更笔数_NUMBER_18_0() {
        return wtxxbgbs_网上信息变更笔数_NUMBER_18_0;
    }

    public void setWtxxbgbs_网上信息变更笔数_NUMBER_18_0(int wtxxbgbs_网上信息变更笔数_NUMBER_18_0) {
        this.wtxxbgbs_网上信息变更笔数_NUMBER_18_0 = wtxxbgbs_网上信息变更笔数_NUMBER_18_0;
    }

    public int getGtztbgbs_柜台状态变更笔数_NUMBER_18_0() {
        return gtztbgbs_柜台状态变更笔数_NUMBER_18_0;
    }

    public void setGtztbgbs_柜台状态变更笔数_NUMBER_18_0(int gtztbgbs_柜台状态变更笔数_NUMBER_18_0) {
        this.gtztbgbs_柜台状态变更笔数_NUMBER_18_0 = gtztbgbs_柜台状态变更笔数_NUMBER_18_0;
    }

    public int getWtztbgbs_网上状态变更笔数_NUMBER_18_0() {
        return wtztbgbs_网上状态变更笔数_NUMBER_18_0;
    }

    public void setWtztbgbs_网上状态变更笔数_NUMBER_18_0(int wtztbgbs_网上状态变更笔数_NUMBER_18_0) {
        this.wtztbgbs_网上状态变更笔数_NUMBER_18_0 = wtztbgbs_网上状态变更笔数_NUMBER_18_0;
    }

    public int getGtjcjsbs_柜台缴存基数变更笔数_NUMBER_18_0() {
        return gtjcjsbs_柜台缴存基数变更笔数_NUMBER_18_0;
    }

    public void setGtjcjsbs_柜台缴存基数变更笔数_NUMBER_18_0(int gtjcjsbs_柜台缴存基数变更笔数_NUMBER_18_0) {
        this.gtjcjsbs_柜台缴存基数变更笔数_NUMBER_18_0 = gtjcjsbs_柜台缴存基数变更笔数_NUMBER_18_0;
    }

    public int getWtjcjsbs_网上缴存基数变更笔数_NUMBER_18_0() {
        return wtjcjsbs_网上缴存基数变更笔数_NUMBER_18_0;
    }

    public void setWtjcjsbs_网上缴存基数变更笔数_NUMBER_18_0(int wtjcjsbs_网上缴存基数变更笔数_NUMBER_18_0) {
        this.wtjcjsbs_网上缴存基数变更笔数_NUMBER_18_0 = wtjcjsbs_网上缴存基数变更笔数_NUMBER_18_0;
    }

    public int getGttqbs_柜台提取笔数_NUMBER_18_0() {
        return gttqbs_柜台提取笔数_NUMBER_18_0;
    }

    public void setGttqbs_柜台提取笔数_NUMBER_18_0(int gttqbs_柜台提取笔数_NUMBER_18_0) {
        this.gttqbs_柜台提取笔数_NUMBER_18_0 = gttqbs_柜台提取笔数_NUMBER_18_0;
    }

    public int getWttqbs_网上提取笔数_NUMBER_18_0() {
        return wttqbs_网上提取笔数_NUMBER_18_0;
    }

    public void setWttqbs_网上提取笔数_NUMBER_18_0(int wttqbs_网上提取笔数_NUMBER_18_0) {
        this.wttqbs_网上提取笔数_NUMBER_18_0 = wttqbs_网上提取笔数_NUMBER_18_0;
    }

    public int getGtdkbs_柜台贷款笔数_NUMBER_18_0() {
        return gtdkbs_柜台贷款笔数_NUMBER_18_0;
    }

    public void setGtdkbs_柜台贷款笔数_NUMBER_18_0(int gtdkbs_柜台贷款笔数_NUMBER_18_0) {
        this.gtdkbs_柜台贷款笔数_NUMBER_18_0 = gtdkbs_柜台贷款笔数_NUMBER_18_0;
    }

    public int getWtdkbs_网上贷款笔数_NUMBER_18_0() {
        return wtdkbs_网上贷款笔数_NUMBER_18_0;
    }

    public void setWtdkbs_网上贷款笔数_NUMBER_18_0(int wtdkbs_网上贷款笔数_NUMBER_18_0) {
        this.wtdkbs_网上贷款笔数_NUMBER_18_0 = wtdkbs_网上贷款笔数_NUMBER_18_0;
    }

    public int getGttqhkbs_柜台提前还款笔数_NUMBER_18_0() {
        return gttqhkbs_柜台提前还款笔数_NUMBER_18_0;
    }

    public void setGttqhkbs_柜台提前还款笔数_NUMBER_18_0(int gttqhkbs_柜台提前还款笔数_NUMBER_18_0) {
        this.gttqhkbs_柜台提前还款笔数_NUMBER_18_0 = gttqhkbs_柜台提前还款笔数_NUMBER_18_0;
    }

    public int getWttqhkbs_网上提取还款笔数_NUMBER_18_0() {
        return wttqhkbs_网上提取还款笔数_NUMBER_18_0;
    }

    public void setWttqhkbs_网上提取还款笔数_NUMBER_18_0(int wttqhkbs_网上提取还款笔数_NUMBER_18_0) {
        this.wttqhkbs_网上提取还款笔数_NUMBER_18_0 = wttqhkbs_网上提取还款笔数_NUMBER_18_0;
    }

    public int getGtchdjybs_柜台冲还贷笔数_NUMBER_18_0() {
        return gtchdjybs_柜台冲还贷笔数_NUMBER_18_0;
    }

    public void setGtchdjybs_柜台冲还贷笔数_NUMBER_18_0(int gtchdjybs_柜台冲还贷笔数_NUMBER_18_0) {
        this.gtchdjybs_柜台冲还贷笔数_NUMBER_18_0 = gtchdjybs_柜台冲还贷笔数_NUMBER_18_0;
    }

    public int getWtchdjybs_网厅冲还贷总笔数_NUMBER_18_0() {
        return wtchdjybs_网厅冲还贷总笔数_NUMBER_18_0;
    }

    public void setWtchdjybs_网厅冲还贷总笔数_NUMBER_18_0(int wtchdjybs_网厅冲还贷总笔数_NUMBER_18_0) {
        this.wtchdjybs_网厅冲还贷总笔数_NUMBER_18_0 = wtchdjybs_网厅冲还贷总笔数_NUMBER_18_0;
    }

    public int getGjzbs_归集总笔数_NUMBER_18_0() {
        return gjzbs_归集总笔数_NUMBER_18_0;
    }

    public void setGjzbs_归集总笔数_NUMBER_18_0(int gjzbs_归集总笔数_NUMBER_18_0) {
        this.gjzbs_归集总笔数_NUMBER_18_0 = gjzbs_归集总笔数_NUMBER_18_0;
    }

    public int getWtgjzbs_网厅归集总笔数_NUMBER_18_0() {
        return wtgjzbs_网厅归集总笔数_NUMBER_18_0;
    }

    public void setWtgjzbs_网厅归集总笔数_NUMBER_18_0(int wtgjzbs_网厅归集总笔数_NUMBER_18_0) {
        this.wtgjzbs_网厅归集总笔数_NUMBER_18_0 = wtgjzbs_网厅归集总笔数_NUMBER_18_0;
    }

    public int getTqzbs_提取总笔数_NUMBER_18_0() {
        return tqzbs_提取总笔数_NUMBER_18_0;
    }

    public void setTqzbs_提取总笔数_NUMBER_18_0(int tqzbs_提取总笔数_NUMBER_18_0) {
        this.tqzbs_提取总笔数_NUMBER_18_0 = tqzbs_提取总笔数_NUMBER_18_0;
    }

    public int getWttqzbs_网厅提取总笔数_NUMBER_18_0() {
        return wttqzbs_网厅提取总笔数_NUMBER_18_0;
    }

    public void setWttqzbs_网厅提取总笔数_NUMBER_18_0(int wttqzbs_网厅提取总笔数_NUMBER_18_0) {
        this.wttqzbs_网厅提取总笔数_NUMBER_18_0 = wttqzbs_网厅提取总笔数_NUMBER_18_0;
    }

    public int getDkzbs_贷款总笔数_NUMBER_18_0() {
        return dkzbs_贷款总笔数_NUMBER_18_0;
    }

    public void setDkzbs_贷款总笔数_NUMBER_18_0(int dkzbs_贷款总笔数_NUMBER_18_0) {
        this.dkzbs_贷款总笔数_NUMBER_18_0 = dkzbs_贷款总笔数_NUMBER_18_0;
    }

    public int getWtdkzbs_网厅贷款总笔数_NUMBER_18_0() {
        return wtdkzbs_网厅贷款总笔数_NUMBER_18_0;
    }

    public void setWtdkzbs_网厅贷款总笔数_NUMBER_18_0(int wtdkzbs_网厅贷款总笔数_NUMBER_18_0) {
        this.wtdkzbs_网厅贷款总笔数_NUMBER_18_0 = wtdkzbs_网厅贷款总笔数_NUMBER_18_0;
    }

    public double getTqlgl_提取离柜率_NUMBER_18_2() {
        return tqlgl_提取离柜率_NUMBER_18_2;
    }

    public void setTqlgl_提取离柜率_NUMBER_18_2(double tqlgl_提取离柜率_NUMBER_18_2) {
        this.tqlgl_提取离柜率_NUMBER_18_2 = tqlgl_提取离柜率_NUMBER_18_2;
    }

    public double getGjlgl_归集离柜率_NUMBER_18_2() {
        return gjlgl_归集离柜率_NUMBER_18_2;
    }

    public void setGjlgl_归集离柜率_NUMBER_18_2(double gjlgl_归集离柜率_NUMBER_18_2) {
        this.gjlgl_归集离柜率_NUMBER_18_2 = gjlgl_归集离柜率_NUMBER_18_2;
    }

    public double getDklgl_贷款离柜率_NUMBER_18_2() {
        return dklgl_贷款离柜率_NUMBER_18_2;
    }

    public void setDklgl_贷款离柜率_NUMBER_18_2(double dklgl_贷款离柜率_NUMBER_18_2) {
        this.dklgl_贷款离柜率_NUMBER_18_2 = dklgl_贷款离柜率_NUMBER_18_2;
    }

    public double getZxlgl_中心离柜率_NUMBER_18_2() {
        return zxlgl_中心离柜率_NUMBER_18_2;
    }

    public void setZxlgl_中心离柜率_NUMBER_18_2(double zxlgl_中心离柜率_NUMBER_18_2) {
        this.zxlgl_中心离柜率_NUMBER_18_2 = zxlgl_中心离柜率_NUMBER_18_2;
    }

    public int getTqcsbs_提取超时笔数_NUMBER_18_0() {
        return tqcsbs_提取超时笔数_NUMBER_18_0;
    }

    public void setTqcsbs_提取超时笔数_NUMBER_18_0(int tqcsbs_提取超时笔数_NUMBER_18_0) {
        this.tqcsbs_提取超时笔数_NUMBER_18_0 = tqcsbs_提取超时笔数_NUMBER_18_0;
    }

    public int getDkcsbs_贷款超时笔数_NUMBER_18_0() {
        return dkcsbs_贷款超时笔数_NUMBER_18_0;
    }

    public void setDkcsbs_贷款超时笔数_NUMBER_18_0(int dkcsbs_贷款超时笔数_NUMBER_18_0) {
        this.dkcsbs_贷款超时笔数_NUMBER_18_0 = dkcsbs_贷款超时笔数_NUMBER_18_0;
    }

    public int getDkzcspsj_贷款最长审批时间_NUMBER_18_2() {
        return dkzcspsj_贷款最长审批时间_NUMBER_18_2;
    }

    public void setDkzcspsj_贷款最长审批时间_NUMBER_18_2(int dkzcspsj_贷款最长审批时间_NUMBER_18_2) {
        this.dkzcspsj_贷款最长审批时间_NUMBER_18_2 = dkzcspsj_贷款最长审批时间_NUMBER_18_2;
    }

    public int getDkpjspts_贷款平均审批天数_NUMBER_18_2() {
        return dkpjspts_贷款平均审批天数_NUMBER_18_2;
    }

    public void setDkpjspts_贷款平均审批天数_NUMBER_18_2(int dkpjspts_贷款平均审批天数_NUMBER_18_2) {
        this.dkpjspts_贷款平均审批天数_NUMBER_18_2 = dkpjspts_贷款平均审批天数_NUMBER_18_2;
    }
}