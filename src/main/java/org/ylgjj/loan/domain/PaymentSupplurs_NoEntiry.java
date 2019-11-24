package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yuan zhao  on 08/10/2015.
 */


public class PaymentSupplurs_NoEntiry {


    public String getUnitcustid() {
        return unitcustid;
    }

    public void setUnitcustid(String unitcustid) {
        this.unitcustid = unitcustid;
    }

    public String getUnitaccname() {
        return unitaccname;
    }

    public void setUnitaccname(String unitaccname) {
        this.unitaccname = unitaccname;
    }

    private String unitcustid;



    private String unitaccname;


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
