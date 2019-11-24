package org.ylgjj.loan.domain;

import java.math.BigDecimal;

public class Data {

    String xmjp;//姓名简拼
    String xb;//性别
    String grzh; //个人帐号/公积金帐号
    String grbh; //个人编号
    String zjhlx; // 证件类型
    String csrq; // 出生日期
    String cjgzsj; // 参加工作时间
    String grzhzt; //个人账户状态

    BigDecimal sqgzze; //税前工资总额
    BigDecimal gjjye; //公积金余额

    String zzdh; //住宅电话;
    String sjh; //手机号;















    String jtdz; //联系地址（家庭）;


    String dwmc; //单位名称;
    String dwdjh; //单位登记号（单位帐号）

    String khglbbh; //开户管理部编号
    String zzjgdm; //单位组织机构代码
    String yyzz; //营业执照号

    String xzbm ; // 单位性质编码
    String dwdz; // 单位地址

    String dwjezt; // 单位缴存状态
    String dwjczjy; // 单位缴存资金来源

    String dwlxfs; // 单位联系方式




    String fxr; // 发薪日

    String dwkhrq ; // 单位开户日期（单位登记日期）
    String dwfdrdbr; // 单位法定代表人
    String dwfdrzjlx; // 单位法定人代表证件类型
    String dwfdrzjhm; // 单位法定人代表证件号码







    String cjnyr; // 初缴年月
    String jznyr; // 缴至年月



    String dwjcbl; //  近12个自然月单位缴存比例
    String grjcbl; //  近12个自然月个人缴存比例

    Integer jccs; // 累计缴存次数

    String lxjcdwmc  = ""; // 当月缴存单位名称；
    String lxdwjce  = ""; // 近12个自然月单位缴存额
    String lxgrjce  = ""; // 近12个自然月个人缴存额

    String zhycjcrq  = ""; // 最近一次缴存日期


    String dqgjjnd  = ""; // 当前公积金年度



    BigDecimal tqljje ; // 累积提取额

    String lxtqyy ; // 近12个月自然月提取原因
    String lxtqsj ; // 近12个月自然月提取时间
    String lxtqfs ; // 近12个月自然月提取方式

    String lxtqje ; // 近12个月自然月提取金额






    String dkbh  = "";//	公积金贷款编号
    BigDecimal dkje;//	公积金贷款金额

    String dkqx  = "";//	公积金贷款期限
    String dkhkfs  = "";//	公积金贷款还款方式  输出	3.2.4贷款还款方式
    BigDecimal dkyhke;//	公积金贷款月还款额	decimal(12,2)	输出


    String dkqsrq  = "";//	公积金贷款起始日期	date	输出	格式：yyyy-mm-dd
    String dkdqrq  = "";//	公积金贷款到期日期	date	输出	格式：yyyy-mm-dd

    String dkjqrq  = "";//	公积金贷款结清日期	date	输出	格式：yyyy-mm-dd



    BigDecimal dkye;//	公积金贷款余额	decimal(12,2)	输出


    String gtdkrxm  = "";//	共同贷款人姓名
    String gtdkrsfzh  = "";//	共同贷款人身份证号

    String gtdkrsfjlgjj  = "";//	共同贷款人是否建立公积金   输出	1是，0否

    String dkzt = "";//	贷款状态	char	输出	00-结清；01-未发放；02-正常；03-逾期


    Integer dklsyqcs;//	公积金贷款历史逾期次数

    String zdlxyqcs;//	最大连续逾期次数	char	输出

    String grgfdz;//	个人购房地址	char	输出

    BigDecimal fwgmjszj ;//	房屋购买计税价格	decimal(12,2)	输出


    public BigDecimal getDkje() {
        return dkje;
    }

    public void setDkje(BigDecimal dkje) {
        this.dkje = dkje;
    }

    public String getDkqx() {
        return dkqx;
    }

    public void setDkqx(String dkqx) {
        this.dkqx = dkqx;
    }

    public String getDkhkfs() {
        return dkhkfs;
    }

    public void setDkhkfs(String dkhkfs) {
        this.dkhkfs = dkhkfs;
    }

    public BigDecimal getDkyhke() {
        return dkyhke;
    }

    public void setDkyhke(BigDecimal dkyhke) {
        this.dkyhke = dkyhke;
    }

    public String getDkqsrq() {
        return dkqsrq;
    }

    public void setDkqsrq(String dkqsrq) {
        this.dkqsrq = dkqsrq;
    }

    public String getDkdqrq() {
        return dkdqrq;
    }

    public void setDkdqrq(String dkdqrq) {
        this.dkdqrq = dkdqrq;
    }

    public String getDkjqrq() {
        return dkjqrq;
    }

    public void setDkjqrq(String dkjqrq) {
        this.dkjqrq = dkjqrq;
    }

    public BigDecimal getDkye() {
        return dkye;
    }

    public void setDkye(BigDecimal dkye) {
        this.dkye = dkye;
    }

    public String getGtdkrxm() {
        return gtdkrxm;
    }

    public void setGtdkrxm(String gtdkrxm) {
        this.gtdkrxm = gtdkrxm;
    }

    public String getGtdkrsfzh() {
        return gtdkrsfzh;
    }

    public void setGtdkrsfzh(String gtdkrsfzh) {
        this.gtdkrsfzh = gtdkrsfzh;
    }

    public String getGtdkrsfjlgjj() {
        return gtdkrsfjlgjj;
    }

    public void setGtdkrsfjlgjj(String gtdkrsfjlgjj) {
        this.gtdkrsfjlgjj = gtdkrsfjlgjj;
    }

    public String getDkzt() {
        return dkzt;
    }

    public void setDkzt(String dkzt) {
        this.dkzt = dkzt;
    }

    public Integer getDklsyqcs() {
        return dklsyqcs;
    }

    public void setDklsyqcs(Integer dklsyqcs) {
        this.dklsyqcs = dklsyqcs;
    }

    public String getZdlxyqcs() {
        return zdlxyqcs;
    }

    public void setZdlxyqcs(String zdlxyqcs) {
        this.zdlxyqcs = zdlxyqcs;
    }

    public String getGrgfdz() {
        return grgfdz;
    }

    public void setGrgfdz(String grgfdz) {
        this.grgfdz = grgfdz;
    }

    public BigDecimal getFwgmjszj() {
        return fwgmjszj;
    }

    public void setFwgmjszj(BigDecimal fwgmjszj) {
        this.fwgmjszj = fwgmjszj;
    }

    public String getXmjp() {
        return xmjp;
    }

    public void setXmjp(String xmjp) {
        this.xmjp = xmjp;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getGrzh() {
        return grzh;
    }

    public void setGrzh(String grzh) {
        this.grzh = grzh;
    }

    public String getGrbh() {
        return grbh;
    }

    public void setGrbh(String grbh) {
        this.grbh = grbh;
    }

    public String getZjhlx() {
        return zjhlx;
    }

    public void setZjhlx(String zjhlx) {
        this.zjhlx = zjhlx;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getCjgzsj() {
        return cjgzsj;
    }

    public void setCjgzsj(String cjgzsj) {
        this.cjgzsj = cjgzsj;
    }

    public String getGrzhzt() {
        return grzhzt;
    }

    public void setGrzhzt(String grzhzt) {
        this.grzhzt = grzhzt;
    }

    public BigDecimal getSqgzze() {
        return sqgzze;
    }

    public void setSqgzze(BigDecimal sqgzze) {
        this.sqgzze = sqgzze;
    }

    public BigDecimal getGjjye() {
        return gjjye;
    }

    public void setGjjye(BigDecimal gjjye) {
        this.gjjye = gjjye;
    }

    public String getZzdh() {
        return zzdh;
    }

    public void setZzdh(String zzdh) {
        this.zzdh = zzdh;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh;
    }

    public String getJtdz() {
        return jtdz;
    }

    public void setJtdz(String jtdz) {
        this.jtdz = jtdz;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getDwdjh() {
        return dwdjh;
    }

    public void setDwdjh(String dwdjh) {
        this.dwdjh = dwdjh;
    }

    public String getKhglbbh() {
        return khglbbh;
    }

    public void setKhglbbh(String khglbbh) {
        this.khglbbh = khglbbh;
    }

    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }

    public String getYyzz() {
        return yyzz;
    }

    public void setYyzz(String yyzz) {
        this.yyzz = yyzz;
    }

    public String getXzbm() {
        return xzbm;
    }

    public void setXzbm(String xzbm) {
        this.xzbm = xzbm;
    }

    public String getDwdz() {
        return dwdz;
    }

    public void setDwdz(String dwdz) {
        this.dwdz = dwdz;
    }

    public String getDwjezt() {
        return dwjezt;
    }

    public void setDwjezt(String dwjezt) {
        this.dwjezt = dwjezt;
    }

    public String getDwjczjy() {
        return dwjczjy;
    }

    public void setDwjczjy(String dwjczjy) {
        this.dwjczjy = dwjczjy;
    }

    public String getDwlxfs() {
        return dwlxfs;
    }

    public void setDwlxfs(String dwlxfs) {
        this.dwlxfs = dwlxfs;
    }

    public String getFxr() {
        return fxr;
    }

    public void setFxr(String fxr) {
        this.fxr = fxr;
    }

    public String getDwkhrq() {
        return dwkhrq;
    }

    public void setDwkhrq(String dwkhrq) {
        this.dwkhrq = dwkhrq;
    }

    public String getDwfdrdbr() {
        return dwfdrdbr;
    }

    public void setDwfdrdbr(String dwfdrdbr) {
        this.dwfdrdbr = dwfdrdbr;
    }

    public String getDwfdrzjlx() {
        return dwfdrzjlx;
    }

    public void setDwfdrzjlx(String dwfdrzjlx) {
        this.dwfdrzjlx = dwfdrzjlx;
    }

    public String getDwfdrzjhm() {
        return dwfdrzjhm;
    }

    public void setDwfdrzjhm(String dwfdrzjhm) {
        this.dwfdrzjhm = dwfdrzjhm;
    }

    public String getCjnyr() {
        return cjnyr;
    }

    public void setCjnyr(String cjnyr) {
        this.cjnyr = cjnyr;
    }

    public String getJznyr() {
        return jznyr;
    }

    public void setJznyr(String jznyr) {
        this.jznyr = jznyr;
    }

    public String getDwjcbl() {
        return dwjcbl;
    }

    public void setDwjcbl(String dwjcbl) {
        this.dwjcbl = dwjcbl;
    }

    public String getGrjcbl() {
        return grjcbl;
    }

    public void setGrjcbl(String grjcbl) {
        this.grjcbl = grjcbl;
    }

    public Integer getJccs() {
        return jccs;
    }

    public void setJccs(Integer jccs) {
        this.jccs = jccs;
    }

    public String getLxjcdwmc() {
        return lxjcdwmc;
    }

    public void setLxjcdwmc(String lxjcdwmc) {
        this.lxjcdwmc = lxjcdwmc;
    }

    public String getLxdwjce() {
        return lxdwjce;
    }

    public void setLxdwjce(String lxdwjce) {
        this.lxdwjce = lxdwjce;
    }

    public String getLxgrjce() {
        return lxgrjce;
    }

    public void setLxgrjce(String lxgrjce) {
        this.lxgrjce = lxgrjce;
    }

    public String getZhycjcrq() {
        return zhycjcrq;
    }

    public void setZhycjcrq(String zhycjcrq) {
        this.zhycjcrq = zhycjcrq;
    }

    public String getDqgjjnd() {
        return dqgjjnd;
    }

    public void setDqgjjnd(String dqgjjnd) {
        this.dqgjjnd = dqgjjnd;
    }

    public BigDecimal getTqljje() {
        return tqljje;
    }

    public void setTqljje(BigDecimal tqljje) {
        this.tqljje = tqljje;
    }

    public String getLxtqyy() {
        return lxtqyy;
    }

    public void setLxtqyy(String lxtqyy) {
        this.lxtqyy = lxtqyy;
    }

    public String getLxtqsj() {
        return lxtqsj;
    }

    public void setLxtqsj(String lxtqsj) {
        this.lxtqsj = lxtqsj;
    }

    public String getLxtqfs() {
        return lxtqfs;
    }

    public void setLxtqfs(String lxtqfs) {
        this.lxtqfs = lxtqfs;
    }

    public String getLxtqje() {
        return lxtqje;
    }

    public void setLxtqje(String lxtqje) {
        this.lxtqje = lxtqje;
    }

    public String getDkbh() {
        return dkbh;
    }

    public void setDkbh(String dkbh) {
        this.dkbh = dkbh;
    }
}