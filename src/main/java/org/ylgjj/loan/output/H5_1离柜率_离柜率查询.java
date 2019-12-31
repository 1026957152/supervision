package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H5_1离柜率_离柜率查询 {

    @JsonProperty("jgbm")
    @JSONField(name="jgbm")
    private String jgbm_管理机构编码_String;

    @JsonProperty("jgmc")
    @JSONField(name="jgmc")
    private String jgmc_管理机构_String;

    @JsonProperty("ksrq")
    @JSONField(name="ksrq")
    private String ksrq_汇总日期_date;

    @JsonProperty("qd")
    @JSONField(name="qd")
    private String qd_渠道_varchar_6;

    @JsonProperty("lgl")
    @JSONField(name="lgl")
    private double lgl_离柜率_Double;

    @JsonProperty("wthdbs")
    @JSONField(name="wthdbs")
    private int wthdbs_核定笔数_Int;

    @JsonProperty("gthdbs")
    @JSONField(name="gthdbs")
    private int gthdbs_柜台核定笔数_Int;
    @JsonProperty("gtxxbgbs")
    @JSONField(name="gtxxbgbs")
    private int gtxxbgbs_信息变更笔数_Int;
    @JsonProperty("wtxxbgbs")
    @JSONField(name="wtxxbgbs")
    private int wtxxbgbs_信息变更笔数_Int;


    @JsonProperty("gtztbgbs")
    @JSONField(name="gtztbgbs")
    private int gtztbgbs_账户状态变更笔数_Int;

    @JsonProperty("wtztbgbs")
    @JSONField(name="wtztbgbs")
    private int wtztbgbs_账户状态变更笔数_Int;


    @JsonProperty("gtjcjsbs")
    @JSONField(name="gtjcjsbs")
    private int gtjcjsbs_缴存基数笔数_Int;
    @JsonProperty("wtjcjsbs")
    @JSONField(name="wtjcjsbs")
    private int wtjcjsbs_缴存基数笔数_Int;


    @JsonProperty("gttqbs")
    @JSONField(name="gttqbs")
    private int gttqbs_提取笔数_Int;
    @JsonProperty("wttqbs")
    @JSONField(name="wttqbs")
    private int wttqbs_提取笔数_Int;


    @JsonProperty("gtdkbs")
    @JSONField(name="gtdkbs")
    private int gtdkbs_贷款笔数_Int;
    @JsonProperty("wtdkbs")
    @JSONField(name="wtdkbs")
    private int wtdkbs_贷款笔数_Int;


    @JsonProperty("gttqhkbs")
    @JSONField(name="gttqhkbs")
    private int gttqhkbs_提前还款笔数_Int;
    @JsonProperty("wttqhkbs")
    @JSONField(name="wttqhkbs")
    private int wttqhkbs_提前还款笔数_Int;

    public int getGthdbs_柜台核定笔数_Int() {
        return gthdbs_柜台核定笔数_Int;
    }

    public void setGthdbs_柜台核定笔数_Int(int gthdbs_柜台核定笔数_Int) {
        this.gthdbs_柜台核定笔数_Int = gthdbs_柜台核定笔数_Int;
    }

    public int getGtxxbgbs_信息变更笔数_Int() {
        return gtxxbgbs_信息变更笔数_Int;
    }

    public void setGtxxbgbs_信息变更笔数_Int(int gtxxbgbs_信息变更笔数_Int) {
        this.gtxxbgbs_信息变更笔数_Int = gtxxbgbs_信息变更笔数_Int;
    }

    public int getGtztbgbs_账户状态变更笔数_Int() {
        return gtztbgbs_账户状态变更笔数_Int;
    }

    public void setGtztbgbs_账户状态变更笔数_Int(int gtztbgbs_账户状态变更笔数_Int) {
        this.gtztbgbs_账户状态变更笔数_Int = gtztbgbs_账户状态变更笔数_Int;
    }

    public int getGtjcjsbs_缴存基数笔数_Int() {
        return gtjcjsbs_缴存基数笔数_Int;
    }

    public void setGtjcjsbs_缴存基数笔数_Int(int gtjcjsbs_缴存基数笔数_Int) {
        this.gtjcjsbs_缴存基数笔数_Int = gtjcjsbs_缴存基数笔数_Int;
    }

    public int getGttqbs_提取笔数_Int() {
        return gttqbs_提取笔数_Int;
    }

    public void setGttqbs_提取笔数_Int(int gttqbs_提取笔数_Int) {
        this.gttqbs_提取笔数_Int = gttqbs_提取笔数_Int;
    }

    public int getGtdkbs_贷款笔数_Int() {
        return gtdkbs_贷款笔数_Int;
    }

    public void setGtdkbs_贷款笔数_Int(int gtdkbs_贷款笔数_Int) {
        this.gtdkbs_贷款笔数_Int = gtdkbs_贷款笔数_Int;
    }

    public int getGttqhkbs_提前还款笔数_Int() {
        return gttqhkbs_提前还款笔数_Int;
    }

    public void setGttqhkbs_提前还款笔数_Int(int gttqhkbs_提前还款笔数_Int) {
        this.gttqhkbs_提前还款笔数_Int = gttqhkbs_提前还款笔数_Int;
    }

    public int getGtchdjybs_对冲签约笔数_Int() {
        return gtchdjybs_对冲签约笔数_Int;
    }

    public void setGtchdjybs_对冲签约笔数_Int(int gtchdjybs_对冲签约笔数_Int) {
        this.gtchdjybs_对冲签约笔数_Int = gtchdjybs_对冲签约笔数_Int;
    }

    @JsonProperty("gtchdjybs")
    @JSONField(name="gtchdjybs")
    private int gtchdjybs_对冲签约笔数_Int;
    @JsonProperty("wtchdjybs")
    @JSONField(name="wtchdjybs")
    private int wtchdjybs_对冲签约笔数_Int;



    @JsonProperty("gzlgl")
    @JSONField(name="gzlgl")
    private double gzlgl_缴存离柜率_Double;

    @JsonProperty("dklgl")
    @JSONField(name="dklgl")
    private double dklgl_贷款离柜率_Double;

    @JsonProperty("zqlgl")
    @JSONField(name="zqlgl")
    private double zqlgl_提取离柜率_Double;

    @JsonProperty("zxlgl")
    @JSONField(name="zxlgl")
    private double zxlgl_中心离柜率_Double;


    public String getJgbm_管理机构编码_String() {
        return jgbm_管理机构编码_String;
    }

    public void setJgbm_管理机构编码_String(String jgbm_管理机构编码_String) {
        this.jgbm_管理机构编码_String = jgbm_管理机构编码_String;
    }

    public String getJgmc_管理机构_String() {
        return jgmc_管理机构_String;
    }

    public void setJgmc_管理机构_String(String jgmc_管理机构_String) {
        this.jgmc_管理机构_String = jgmc_管理机构_String;
    }

    public String getKsrq_汇总日期_date() {
        return ksrq_汇总日期_date;
    }

    public void setKsrq_汇总日期_date(String ksrq_汇总日期_date) {
        this.ksrq_汇总日期_date = ksrq_汇总日期_date;
    }

    public String getQd_渠道_varchar_6() {
        return qd_渠道_varchar_6;
    }

    public void setQd_渠道_varchar_6(String qd_渠道_varchar_6) {
        this.qd_渠道_varchar_6 = qd_渠道_varchar_6;
    }

    public double getLgl_离柜率_Double() {
        return lgl_离柜率_Double;
    }

    public void setLgl_离柜率_Double(double lgl_离柜率_Double) {
        this.lgl_离柜率_Double = lgl_离柜率_Double;
    }

    public int getWthdbs_核定笔数_Int() {
        return wthdbs_核定笔数_Int;
    }

    public void setWthdbs_核定笔数_Int(int wthdbs_核定笔数_Int) {
        this.wthdbs_核定笔数_Int = wthdbs_核定笔数_Int;
    }

    public int getWtxxbgbs_信息变更笔数_Int() {
        return wtxxbgbs_信息变更笔数_Int;
    }

    public void setWtxxbgbs_信息变更笔数_Int(int wtxxbgbs_信息变更笔数_Int) {
        this.wtxxbgbs_信息变更笔数_Int = wtxxbgbs_信息变更笔数_Int;
    }

    public int getWtztbgbs_账户状态变更笔数_Int() {
        return wtztbgbs_账户状态变更笔数_Int;
    }

    public void setWtztbgbs_账户状态变更笔数_Int(int wtztbgbs_账户状态变更笔数_Int) {
        this.wtztbgbs_账户状态变更笔数_Int = wtztbgbs_账户状态变更笔数_Int;
    }

    public int getWtjcjsbs_缴存基数笔数_Int() {
        return wtjcjsbs_缴存基数笔数_Int;
    }

    public void setWtjcjsbs_缴存基数笔数_Int(int wtjcjsbs_缴存基数笔数_Int) {
        this.wtjcjsbs_缴存基数笔数_Int = wtjcjsbs_缴存基数笔数_Int;
    }

    public int getWttqbs_提取笔数_Int() {
        return wttqbs_提取笔数_Int;
    }

    public void setWttqbs_提取笔数_Int(int wttqbs_提取笔数_Int) {
        this.wttqbs_提取笔数_Int = wttqbs_提取笔数_Int;
    }

    public int getWtdkbs_贷款笔数_Int() {
        return wtdkbs_贷款笔数_Int;
    }

    public void setWtdkbs_贷款笔数_Int(int wtdkbs_贷款笔数_Int) {
        this.wtdkbs_贷款笔数_Int = wtdkbs_贷款笔数_Int;
    }

    public int getWttqhkbs_提前还款笔数_Int() {
        return wttqhkbs_提前还款笔数_Int;
    }

    public void setWttqhkbs_提前还款笔数_Int(int wttqhkbs_提前还款笔数_Int) {
        this.wttqhkbs_提前还款笔数_Int = wttqhkbs_提前还款笔数_Int;
    }

    public int getWtchdjybs_对冲签约笔数_Int() {
        return wtchdjybs_对冲签约笔数_Int;
    }

    public void setWtchdjybs_对冲签约笔数_Int(int wtchdjybs_对冲签约笔数_Int) {
        this.wtchdjybs_对冲签约笔数_Int = wtchdjybs_对冲签约笔数_Int;
    }

    public double getGzlgl_缴存离柜率_Double() {
        return gzlgl_缴存离柜率_Double;
    }

    public void setGzlgl_缴存离柜率_Double(double gzlgl_缴存离柜率_Double) {
        this.gzlgl_缴存离柜率_Double = gzlgl_缴存离柜率_Double;
    }

    public double getDklgl_贷款离柜率_Double() {
        return dklgl_贷款离柜率_Double;
    }

    public void setDklgl_贷款离柜率_Double(double dklgl_贷款离柜率_Double) {
        this.dklgl_贷款离柜率_Double = dklgl_贷款离柜率_Double;
    }

    public double getZqlgl_提取离柜率_Double() {
        return zqlgl_提取离柜率_Double;
    }

    public void setZqlgl_提取离柜率_Double(double zqlgl_提取离柜率_Double) {
        this.zqlgl_提取离柜率_Double = zqlgl_提取离柜率_Double;
    }

    public double getZxlgl_中心离柜率_Double() {
        return zxlgl_中心离柜率_Double;
    }

    public void setZxlgl_中心离柜率_Double(double zxlgl_中心离柜率_Double) {
        this.zxlgl_中心离柜率_Double = zxlgl_中心离柜率_Double;
    }
}