package org.ylgjj.loan.domain_flow;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "loan_cache")

public class LoanCache extends BaseDomain{

    @JsonProperty("jkhtbh")
    @JSONField(name="jkhtbh")
    @Column(name = "jkhtbh")
    // @JSONField(name="jkhtbh")
    private String jkhtbh_合同编号_String;


    @JsonProperty("dkffrq")
    @JSONField(name="dkffrq")
    @Column(name = "dkffrq")

    // @JSONField(name="dkffrq")
    private LocalDate dkffrq发放日期String;


    @JsonProperty("dkffe")
    @JSONField(name="dkffe")
    @Column(name = "dkffe")
    // @JSONField(name="dkffe")
    private double dkffe_发放金额_double;


    @JsonProperty("dkye")
    @JSONField(name="dkye")
    @Column(name = "dkye")
    // @JSONField(name="dkye")
    private double dkye_贷款余额_double;


    @JsonProperty("dqyqbj")
    @JSONField(name="dqyqbj")
    @Column(name = "dqyqbj")
    // @JSONField(name="dqyqbj")
    private double dqyqbj_当前逾期本金_double;




    @JsonProperty("dqyqcs")
    @JSONField(name="dqyqcs")
    @Column(name = "dqyqcs")
    // @JSONField(name="dqyqcs")
    private int dqyqcs当前逾期次数int;


    @JsonProperty("ljyqqs")
    @JSONField(name="ljyqqs")
    @Column(name = "ljyqqs")
    // @JSONField(name="ljyqqs")
    private int ljyqqs_累计逾期次数_int;


    @JsonProperty("yqkssj")
    @JSONField(name="yqkssj")
    @Column(name = "yqkssj")
    // @JSONField(name="yqkssj")
    private LocalDate yqkssj_逾期开始日期_String;


    @JsonProperty("yqts")
    @JSONField(name="yqts")
    @Column(name = "yqts")
    // @JSONField(name="yqts")
    private int yqts_逾期天数_int;


    @JsonProperty("grjcjs")
    @JSONField(name="grjcjs")
    @Column(name = "grjcjs")
    // @JSONField(name="grjcjs")
    private double grjcjs_主借款人月缴存基数_double;


    @JsonProperty("grztmc")
    @JSONField(name="grztmc")
    @Column(name = "grztmc")
    // @JSONField(name="grztmc")
    private String grztmc_主借款人账户状态_String;


    @JsonProperty("dqjhhkje")
    @JSONField(name="dqjhhkje")
    @Column(name = "dqjhhkje")
    // @JSONField(name="dqjhhkje")
    private double dqjhhkje_月还款额_double;


    @JsonProperty("spczyxm")
    @JSONField(name="spczyxm")
    @Column(name = "spczyxm")
    // @JSONField(name="spczyxm")
    private String spczyxm_审批人_String;

    @JsonProperty("dwmc")
    @JSONField(name="dwmc")
    @Column(name = "dwmc")
    // @JSONField(name="dwmc")
    private String dwmc_单位名称_String;


    @JsonProperty("jkrgjjzh")
    @JSONField(name="jkrgjjzh")
    @Column(name = "jkrgjjzh")
    // @JSONField(name="jkrgjjzh")
    private String jkrgjjzh_借款人公积金账号_String;


    @JsonProperty("jkrxm")
    @JSONField(name="jkrxm")
    @Column(name = "jkrxm")
    // @JSONField(name="jkrxm")
    private String jkrxm_借款人姓名_String;

    @JsonProperty("jkrzjh")
    @JSONField(name="jkrzjh")
    @Column(name = "jkrzjh")
    // @JSONField(name="jkrzjh")
    private String jkrzjh_借款人证件号码_String;

    @JsonProperty("dblxmc")
    @JSONField(name="dblxmc")
    @Column(name = "dblxmc")
    // @JSONField(name="dblxmc")
    private String dblxmc_担保类型_String;

    @JsonProperty("fwzl")
    @JSONField(name="fwzl")
    @Column(name = "fwzl")
    // @JSONField(name="fwzl")
    private String fwzl_房屋地址_String;

    @JsonProperty("hkfsmc")
    @JSONField(name="hkfsmc")
    @Column(name = "hkfsmc")
    // @JSONField(name="hkfsmc")
    private String hkfsmc_还款方式_String;

    @JsonProperty("fwxzmc")
    @JSONField(name="fwxzmc")
    @Column(name = "fwxzmc")
    // @JSONField(name="fwxzmc")
    private String fwxzmc_房屋性质_String;


    public String getJkhtbh_合同编号_String() {
        return jkhtbh_合同编号_String;
    }

    public void setJkhtbh_合同编号_String(String jkhtbh_合同编号_String) {
        this.jkhtbh_合同编号_String = jkhtbh_合同编号_String;
    }

    public LocalDate getDkffrq发放日期String() {
        return dkffrq发放日期String;
    }

    public void setDkffrq发放日期String(LocalDate dkffrq_发放日期_String) {
        this.dkffrq发放日期String = dkffrq_发放日期_String;
    }

    public double getDkffe_发放金额_double() {
        return dkffe_发放金额_double;
    }

    public void setDkffe_发放金额_double(double dkffe_发放金额_double) {
        this.dkffe_发放金额_double = dkffe_发放金额_double;
    }

    public double getDkye_贷款余额_double() {
        return dkye_贷款余额_double;
    }

    public void setDkye_贷款余额_double(double dkye_贷款余额_double) {
        this.dkye_贷款余额_double = dkye_贷款余额_double;
    }

    public double getDqyqbj_当前逾期本金_double() {
        return dqyqbj_当前逾期本金_double;
    }

    public void setDqyqbj_当前逾期本金_double(double dqyqbj_当前逾期本金_double) {
        this.dqyqbj_当前逾期本金_double = dqyqbj_当前逾期本金_double;
    }

    public int getDqyqcs当前逾期次数int() {
        return dqyqcs当前逾期次数int;
    }

    public void setDqyqcs当前逾期次数int(int dqyqcs_当前逾期次数_int) {
        this.dqyqcs当前逾期次数int = dqyqcs_当前逾期次数_int;
    }

    public int getLjyqqs_累计逾期次数_int() {
        return ljyqqs_累计逾期次数_int;
    }

    public void setLjyqqs_累计逾期次数_int(int ljyqqs_累计逾期次数_int) {
        this.ljyqqs_累计逾期次数_int = ljyqqs_累计逾期次数_int;
    }

    public LocalDate getYqkssj_逾期开始日期_String() {
        return yqkssj_逾期开始日期_String;
    }

    public void setYqkssj_逾期开始日期_String(LocalDate yqkssj_逾期开始日期_String) {
        this.yqkssj_逾期开始日期_String = yqkssj_逾期开始日期_String;
    }

    public int getYqts_逾期天数_int() {
        return yqts_逾期天数_int;
    }

    public void setYqts_逾期天数_int(int yqts_逾期天数_int) {
        this.yqts_逾期天数_int = yqts_逾期天数_int;
    }

    public double getGrjcjs_主借款人月缴存基数_double() {
        return grjcjs_主借款人月缴存基数_double;
    }

    public void setGrjcjs_主借款人月缴存基数_double(double grjcjs_主借款人月缴存基数_double) {
        this.grjcjs_主借款人月缴存基数_double = grjcjs_主借款人月缴存基数_double;
    }

    public String getGrztmc_主借款人账户状态_String() {
        return grztmc_主借款人账户状态_String;
    }

    public void setGrztmc_主借款人账户状态_String(String grztmc_主借款人账户状态_String) {
        this.grztmc_主借款人账户状态_String = grztmc_主借款人账户状态_String;
    }

    public double getDqjhhkje_月还款额_double() {
        return dqjhhkje_月还款额_double;
    }

    public void setDqjhhkje_月还款额_double(double dqjhhkje_月还款额_double) {
        this.dqjhhkje_月还款额_double = dqjhhkje_月还款额_double;
    }

    public String getSpczyxm_审批人_String() {
        return spczyxm_审批人_String;
    }

    public void setSpczyxm_审批人_String(String spczyxm_审批人_String) {
        this.spczyxm_审批人_String = spczyxm_审批人_String;
    }

    public String getDwmc_单位名称_String() {
        return dwmc_单位名称_String;
    }

    public void setDwmc_单位名称_String(String dwmc_单位名称_String) {
        this.dwmc_单位名称_String = dwmc_单位名称_String;
    }

    public String getJkrgjjzh_借款人公积金账号_String() {
        return jkrgjjzh_借款人公积金账号_String;
    }

    public void setJkrgjjzh_借款人公积金账号_String(String jkrgjjzh_借款人公积金账号_String) {
        this.jkrgjjzh_借款人公积金账号_String = jkrgjjzh_借款人公积金账号_String;
    }

    public String getJkrxm_借款人姓名_String() {
        return jkrxm_借款人姓名_String;
    }

    public void setJkrxm_借款人姓名_String(String jkrxm_借款人姓名_String) {
        this.jkrxm_借款人姓名_String = jkrxm_借款人姓名_String;
    }

    public String getJkrzjh_借款人证件号码_String() {
        return jkrzjh_借款人证件号码_String;
    }

    public void setJkrzjh_借款人证件号码_String(String jkrzjh_借款人证件号码_String) {
        this.jkrzjh_借款人证件号码_String = jkrzjh_借款人证件号码_String;
    }

    public String getDblxmc_担保类型_String() {
        return dblxmc_担保类型_String;
    }

    public void setDblxmc_担保类型_String(String dblxmc_担保类型_String) {
        this.dblxmc_担保类型_String = dblxmc_担保类型_String;
    }

    public String getFwzl_房屋地址_String() {
        return fwzl_房屋地址_String;
    }

    public void setFwzl_房屋地址_String(String fwzl_房屋地址_String) {
        this.fwzl_房屋地址_String = fwzl_房屋地址_String;
    }

    public String getHkfsmc_还款方式_String() {
        return hkfsmc_还款方式_String;
    }

    public void setHkfsmc_还款方式_String(String hkfsmc_还款方式_String) {
        this.hkfsmc_还款方式_String = hkfsmc_还款方式_String;
    }

    public String getFwxzmc_房屋性质_String() {
        return fwxzmc_房屋性质_String;
    }

    public void setFwxzmc_房屋性质_String(String fwxzmc_房屋性质_String) {
        this.fwxzmc_房屋性质_String = fwxzmc_房屋性质_String;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }




}
