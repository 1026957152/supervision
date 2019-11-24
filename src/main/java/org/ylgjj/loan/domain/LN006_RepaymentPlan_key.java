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

public class LN006_RepaymentPlan_key implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id

    @Column(name = "loancontrcode")
    private String loancontrcode0合同代码;

    @Id
    @Column(name = "termnum")
    private Integer termnum0第N期;

    public String getLoancontrcode0合同代码() {
        return loancontrcode0合同代码;
    }

    public void setLoancontrcode0合同代码(String loancontrcode0合同代码) {
        this.loancontrcode0合同代码 = loancontrcode0合同代码;
    }

    public Integer getTermnum0第N期() {
        return termnum0第N期;
    }

    public void setTermnum0第N期(Integer termnum0第N期) {
        this.termnum0第N期 = termnum0第N期;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }





}
