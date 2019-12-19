package org.ylgjj.loan.domain_flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "mortgager_cache")

public class MortgagerCache extends BaseDomain{



    // LN009	抵押物信息				管理公积金贷款的抵押物等抵押担保信息、及其变更履历。
    // LN010	抵押人信息				管理公积金贷款的抵押人信息、及其变更履历。



    @Column(name = "jkhtbh")
    private String jkhtbh_借款人合同编号;

    @Column(name = "jkrgjjzh")
    private String jkrgjjzh_借款人公积金账号;

    @Column(name = "jkrxm")
    private String jkrxm_借款人姓名;

    @Column(name = "dkffe")
    private double dkffe_贷款金额;

    @Column(name = "dksqnx")
    private int dksqnx_贷款年限;

    @Column(name = "dkll")
    private double dkll_贷款利率;

    @Column(name = "sprq")
    private LocalDate sprq审批日期;

    @Column(name = "dkffrq")
    private LocalDate dkffrq发放日期;
    private Long duration;


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

    public LocalDate getSprq审批日期() {
        return sprq审批日期;
    }

    public void setSprq审批日期(LocalDate sprq_审批日期) {
        this.sprq审批日期 = sprq_审批日期;
    }

    public LocalDate getDkffrq发放日期() {
        return dkffrq发放日期;
    }

    public void setDkffrq发放日期(LocalDate dkffrq_发放日期) {
        this.dkffrq发放日期 = dkffrq_发放日期;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public void setDuration(Long duration) {

        this.duration = duration;
    }

    public Long getDuration() {
        return duration;
    }
}
