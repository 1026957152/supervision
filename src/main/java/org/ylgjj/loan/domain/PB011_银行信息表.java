package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "PB011")

public class PB011_银行信息表 {




    @Id
    private String bankcode;

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    private String banknam1;

    private String banknam2;
    private String bankname;
    private String SUPERBANKCODE;

    public String getSUPERBANKCODE() {
        return SUPERBANKCODE;
    }

    public void setSUPERBANKCODE(String SUPERBANKCODE) {
        this.SUPERBANKCODE = SUPERBANKCODE;
    }

    public String getBanknam1() {
        return banknam1;
    }

    public void setBanknam1(String banknam1) {
        this.banknam1 = banknam1;
    }

    public String getBanknam2() {
        return banknam2;
    }

    public void setBanknam2(String banknam2) {
        this.banknam2 = banknam2;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
