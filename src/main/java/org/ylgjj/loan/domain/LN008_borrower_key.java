package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

/*@Entity
*/

public class LN008_borrower_key implements Serializable {
    private static final long serialVersionUID = 1L;



    public LN008_borrower_key() {
    }



    @Column(name = "loancontrcode")
    private String loancontrcode合同代码;

    @Column(name = "seqnum")
    private Integer seqnum_序号;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLoancontrcode合同代码() {
        return loancontrcode合同代码;
    }

    public void setLoancontrcode合同代码(String loancontrcode合同代码) {
        this.loancontrcode合同代码 = loancontrcode合同代码;
    }

    public Integer getSeqnum_序号() {
        return seqnum_序号;
    }

    public void setSeqnum_序号(Integer seqnum_序号) {
        this.seqnum_序号 = seqnum_序号;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }





}
