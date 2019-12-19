package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class LN007_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    @Column(name = "loancontrcode")
    private String loancontrcode_不可为空_合同代码;//

    @Column(name = "dedtype")
    private String dedtype_不可为空_代扣类型;//

    public String getLoancontrcode_不可为空_合同代码() {
        return loancontrcode_不可为空_合同代码;
    }

    public void setLoancontrcode_不可为空_合同代码(String loancontrcode_不可为空_合同代码) {
        this.loancontrcode_不可为空_合同代码 = loancontrcode_不可为空_合同代码;
    }

    public String getDedtype_不可为空_代扣类型() {
        return dedtype_不可为空_代扣类型;
    }

    public void setDedtype_不可为空_代扣类型(String dedtype_不可为空_代扣类型) {
        this.dedtype_不可为空_代扣类型 = dedtype_不可为空_代扣类型;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
