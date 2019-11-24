package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

/*@Entity
*/

public class LN011_guarantor_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public String getLoancontrcode() {
        return loancontrcode;
    }

    public void setLoancontrcode(String loancontrcode) {
        this.loancontrcode = loancontrcode;
    }

    public Integer getSeqnum() {
        return seqnum;
    }

    public void setSeqnum(Integer seqnum) {
        this.seqnum = seqnum;
    }

    public LN011_guarantor_key() {
    }

    @Id
    private String loancontrcode;
    @Id
    private Integer seqnum;
    @Id
    private String changetype;

    public String getChangetype() {
        return changetype;
    }

    public void setChangetype(String changetype) {
        this.changetype = changetype;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }





}
