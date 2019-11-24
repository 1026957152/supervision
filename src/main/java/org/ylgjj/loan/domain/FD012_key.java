package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class FD012_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }




    @Column(name = "centerid")
    private String CENTERID_不可为空_城市中心代码;

    @Column(name = "bankcode")
    private String BANKCODE_不可为空_银行代码;

    @Column(name = "bankaccnum")
    private String BANKACCNUM_不可为空_银行账号;

    @Column(name = "fundkind")
    private String FUNDKIND_不可为空_资金性质;//01-住房公积金存款,03-增值收益存款_
    @Column(name = "bankaccstate")
    private String BANKACCSTATE_不可为空_银行账户状态; //0-正常,9-注销_


    public String getCENTERID_不可为空_城市中心代码() {
        return CENTERID_不可为空_城市中心代码;
    }

    public void setCENTERID_不可为空_城市中心代码(String CENTERID_不可为空_城市中心代码) {
        this.CENTERID_不可为空_城市中心代码 = CENTERID_不可为空_城市中心代码;
    }

    public String getBANKCODE_不可为空_银行代码() {
        return BANKCODE_不可为空_银行代码;
    }

    public void setBANKCODE_不可为空_银行代码(String BANKCODE_不可为空_银行代码) {
        this.BANKCODE_不可为空_银行代码 = BANKCODE_不可为空_银行代码;
    }

    public String getBANKACCNUM_不可为空_银行账号() {
        return BANKACCNUM_不可为空_银行账号;
    }

    public void setBANKACCNUM_不可为空_银行账号(String BANKACCNUM_不可为空_银行账号) {
        this.BANKACCNUM_不可为空_银行账号 = BANKACCNUM_不可为空_银行账号;
    }

    public String getFUNDKIND_不可为空_资金性质() {
        return FUNDKIND_不可为空_资金性质;
    }

    public void setFUNDKIND_不可为空_资金性质(String FUNDKIND_不可为空_资金性质) {
        this.FUNDKIND_不可为空_资金性质 = FUNDKIND_不可为空_资金性质;
    }

    public String getBANKACCSTATE_不可为空_银行账户状态() {
        return BANKACCSTATE_不可为空_银行账户状态;
    }

    public void setBANKACCSTATE_不可为空_银行账户状态(String BANKACCSTATE_不可为空_银行账户状态) {
        this.BANKACCSTATE_不可为空_银行账户状态 = BANKACCSTATE_不可为空_银行账户状态;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;







}
