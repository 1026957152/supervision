package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class LN102_bank_withholding_key implements Serializable {
    private static final long serialVersionUID = 1L;







    @Id

    private String loancontrcode;

    @Id

    private String hostsernum;
    @Id

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLoancontrcode() {
        return loancontrcode;
    }

    public void setLoancontrcode(String loancontrcode) {
        this.loancontrcode = loancontrcode;
    }

    public String getHostsernum() {
        return hostsernum;
    }

    public void setHostsernum(String hostsernum) {
        this.hostsernum = hostsernum;
    }



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
