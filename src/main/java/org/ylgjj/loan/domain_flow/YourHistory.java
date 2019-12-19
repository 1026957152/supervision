package org.ylgjj.loan.domain_flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "history")

public class YourHistory extends BaseFlowDomain {

    @Column(name = "UnitNo")
    private String UnitNo;


    @Column(name = "时间")
    private String 时间;
    @Column(name = "值")
    private String 值;


    @Column(name = "管理部")
    private String 管理部;


    @Column(name = "银行代码")
    private String 银行代码;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getUnitNo() {
        return UnitNo;
    }

    public void setUnitNo(String unitNo) {
        UnitNo = unitNo;
    }

    public String get时间() {
        return 时间;
    }

    public void set时间(String 时间) {
        this.时间 = 时间;
    }

    public String get值() {
        return 值;
    }

    public void set值(String 值) {
        this.值 = 值;
    }

    public String get管理部() {
        return 管理部;
    }

    public void set管理部(String 管理部) {
        this.管理部 = 管理部;
    }

    public String get银行代码() {
        return 银行代码;
    }

    public void set银行代码(String 银行代码) {
        this.银行代码 = 银行代码;
    }

}
