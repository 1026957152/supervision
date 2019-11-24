package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class FN090_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    @Column(name = "transdate")
    private String 	transdate__不可为空__写入日期;//


    @Column(name = "bankhostsernum")
    private String 	bankhostsernum__不可为空__银行主机流水号;//


    @Column(name = "bankaccnum")
    private String 	bankaccnum__不可为空__账号;//

    @Column(name = "amt")
    private String 	amt__不可为空__金额;//

    public String getTransdate__不可为空__写入日期() {
        return transdate__不可为空__写入日期;
    }

    public void setTransdate__不可为空__写入日期(String transdate__不可为空__写入日期) {
        this.transdate__不可为空__写入日期 = transdate__不可为空__写入日期;
    }

    public String getBankhostsernum__不可为空__银行主机流水号() {
        return bankhostsernum__不可为空__银行主机流水号;
    }

    public void setBankhostsernum__不可为空__银行主机流水号(String bankhostsernum__不可为空__银行主机流水号) {
        this.bankhostsernum__不可为空__银行主机流水号 = bankhostsernum__不可为空__银行主机流水号;
    }

    public String getBankaccnum__不可为空__账号() {
        return bankaccnum__不可为空__账号;
    }

    public void setBankaccnum__不可为空__账号(String bankaccnum__不可为空__账号) {
        this.bankaccnum__不可为空__账号 = bankaccnum__不可为空__账号;
    }

    public String getAmt__不可为空__金额() {
        return amt__不可为空__金额;
    }

    public void setAmt__不可为空__金额(String amt__不可为空__金额) {
        this.amt__不可为空__金额 = amt__不可为空__金额;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;







}
