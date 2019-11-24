package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

/*@Entity
*/

public class LN010_mortgager_key implements Serializable {
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

    public LN010_mortgager_key() {
    }






    @Id
    private String loancontrcode;

    @Id
    private String mortseqnum;
    @Id
    private Integer seqnum;
    @Id
    private String chgnum;

    public String getChgnum() {
        return chgnum;
    }

    public void setChgnum(String chgnum) {
        this.chgnum = chgnum;
    }


    public String getMortseqnum() {
        return mortseqnum;
    }

    public void setMortseqnum(String mortseqnum) {
        this.mortseqnum = mortseqnum;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }





}
