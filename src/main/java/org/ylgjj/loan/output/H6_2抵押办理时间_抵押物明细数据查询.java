package org.ylgjj.loan.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H6_2抵押办理时间_抵押物明细数据查询 {


   // LN009	抵押物信息				管理公积金贷款的抵押物等抵押担保信息、及其变更履历。
   // LN010	抵押人信息				管理公积金贷款的抵押人信息、及其变更履历。


    @JsonProperty("jkhtbh")
    @JSONField(name="jkhtbh")
    private String jkhtbh_借款人合同编号;

    @JsonProperty("jkrgjjzh")
    @JSONField(name="jkrgjjzh")
    private String jkrgjjzh_借款人公积金账号;

    @JsonProperty("jkrxm")
    @JSONField(name="jkrxm")
    private String jkrxm_借款人姓名;

    @JsonProperty("dkffe")
    @JSONField(name="dkffe")
    private double dkffe_贷款金额;

    @JsonProperty("dksqnx")
    @JSONField(name="dksqnx")
    private int dksqnx_贷款年限;

    @JsonProperty("dkll")
    @JSONField(name="dkll")
    private double dkll_贷款利率;
    @JsonProperty("sprq")
    @JSONField(name="sprq")
    private String sprq_审批日期;

    @JsonProperty("dkffrq")
    @JSONField(name="dkffrq")
    private String dkffrq_发放日期;



    public enum Status {
        SUCCESS, ERROR
    }

    public H6_2抵押办理时间_抵押物明细数据查询() {
    }

    public String getJkhtbh_借款人合同编号() {
        return jkhtbh_借款人合同编号;
    }

    public void setJkhtbh_借款人合同编号(String jkhtbh_借款人合同编号) {
        this.jkhtbh_借款人合同编号 = jkhtbh_借款人合同编号;
    }

    public String getJkrgjjzh_借款人公积金账号() {
        return jkrgjjzh_借款人公积金账号;
    }

    public void setJkrgjjzh_借款人公积金账号(String jkrgjjzh_借款人公积金账号) {
        this.jkrgjjzh_借款人公积金账号 = jkrgjjzh_借款人公积金账号;
    }

    public String getJkrxm_借款人姓名() {
        return jkrxm_借款人姓名;
    }

    public void setJkrxm_借款人姓名(String jkrxm_借款人姓名) {
        this.jkrxm_借款人姓名 = jkrxm_借款人姓名;
    }

    public double getDkffe_贷款金额() {
        return dkffe_贷款金额;
    }

    public void setDkffe_贷款金额(double dkffe_贷款金额) {
        this.dkffe_贷款金额 = dkffe_贷款金额;
    }

    public int getDksqnx_贷款年限() {
        return dksqnx_贷款年限;
    }

    public void setDksqnx_贷款年限(int dksqnx_贷款年限) {
        this.dksqnx_贷款年限 = dksqnx_贷款年限;
    }

    public double getDkll_贷款利率() {
        return dkll_贷款利率;
    }

    public void setDkll_贷款利率(double dkll_贷款利率) {
        this.dkll_贷款利率 = dkll_贷款利率;
    }

    public String getSprq_审批日期() {
        return sprq_审批日期;
    }

    public void setSprq_审批日期(String sprq_审批日期) {
        this.sprq_审批日期 = sprq_审批日期;
    }

    public String getDkffrq_发放日期() {
        return dkffrq_发放日期;
    }

    public void setDkffrq_发放日期(String dkffrq_发放日期) {
        this.dkffrq_发放日期 = dkffrq_发放日期;
    }
}