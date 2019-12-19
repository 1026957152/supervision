package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@IdClass(PB010_key.class)
@Entity

@Table(name = "PB010")

public class PB010_大行信息表 {


    @Id
    @Column(name = "CENTERID")
    private String CENTERID_不可为空_城市中心代码;


    @Id
    @Column(name = "bankcode")
    private String bankcode_不可为空_银行代码;

    @Column(name = "banknam1")
    private String banknam1_不可为空_银行简称;

    @Column(name = "banknam2")
    private String banknam2_不可为空_银行简称2;

    @Column(name = "BANKNAME")
    private String BANKNAME_不可为空_银行名称;

    public String getCENTERID_不可为空_城市中心代码() {
        return CENTERID_不可为空_城市中心代码;
    }

    public void setCENTERID_不可为空_城市中心代码(String CENTERID_不可为空_城市中心代码) {
        this.CENTERID_不可为空_城市中心代码 = CENTERID_不可为空_城市中心代码;
    }

    public String getBankcode_不可为空_银行代码() {
        return bankcode_不可为空_银行代码;
    }

    public void setBankcode_不可为空_银行代码(String bankcode_不可为空_银行代码) {
        this.bankcode_不可为空_银行代码 = bankcode_不可为空_银行代码;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getBanknam1_不可为空_银行简称() {
        return banknam1_不可为空_银行简称;
    }

    public void setBanknam1_不可为空_银行简称(String banknam1_不可为空_银行简称) {
        this.banknam1_不可为空_银行简称 = banknam1_不可为空_银行简称;
    }

    public String getBanknam2_不可为空_银行简称2() {
        return banknam2_不可为空_银行简称2;
    }

    public void setBanknam2_不可为空_银行简称2(String banknam2_不可为空_银行简称2) {
        this.banknam2_不可为空_银行简称2 = banknam2_不可为空_银行简称2;
    }

    public String getBANKNAME_不可为空_银行名称() {
        return BANKNAME_不可为空_银行名称;
    }

    public void setBANKNAME_不可为空_银行名称(String BANKNAME_不可为空_银行名称) {
        this.BANKNAME_不可为空_银行名称 = BANKNAME_不可为空_银行名称;
    }
}
