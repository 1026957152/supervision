package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

/*@Entity
*/

public class LN009_key implements Serializable {
    private static final long serialVersionUID = 1L;


    public LN009_key() {
    }




    @Column(name = "loancontrcode")
    private String loancontrcode_不可为空_合同代码;


    @Column(name = "mortseqnum")
    private String mortseqnum_不可为空_抵押物序号;


    @Column(name = "chgnum")
    private String chgnum_不可为空_变更序号;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLoancontrcode_不可为空_合同代码() {
        return loancontrcode_不可为空_合同代码;
    }

    public void setLoancontrcode_不可为空_合同代码(String loancontrcode_不可为空_合同代码) {
        this.loancontrcode_不可为空_合同代码 = loancontrcode_不可为空_合同代码;
    }

    public String getMortseqnum_不可为空_抵押物序号() {
        return mortseqnum_不可为空_抵押物序号;
    }

    public void setMortseqnum_不可为空_抵押物序号(String mortseqnum_不可为空_抵押物序号) {
        this.mortseqnum_不可为空_抵押物序号 = mortseqnum_不可为空_抵押物序号;
    }

    public String getChgnum_不可为空_变更序号() {
        return chgnum_不可为空_变更序号;
    }

    public void setChgnum_不可为空_变更序号(String chgnum_不可为空_变更序号) {
        this.chgnum_不可为空_变更序号 = chgnum_不可为空_变更序号;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }





}
