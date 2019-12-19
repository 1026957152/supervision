package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "PB007")

public class PB007_机构信息表 {





    @Id
    @Column(name = "INSTID")
    private String instId;


    @Column(name = "CENTERID")
    private String centerId ;


    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    @Column(name = "INSTCODE")

    private String instCode ;
    @Column(name = "INSTNAME")

    private String instName ;

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    /*
    @Column(name = "INSTNAME")

    private String instName ;


    @Column(name = "INSTNAME1")
    private String instName1;

    @Column(name = "INSTNAM2")
    private String instName2;

    @Column(name = "INSTADDR")
    private String instAddr;

    @Column(name = "LINKPHONE")
    private String linkPhone;

    @Column(name = "ZIP")
    private String zip;

    @Column(name = "INSTTYPE")
    private String instType;

    @Column(name = "INSTKIND")
    private String instKind;

    @Column(name = "INSTATTR")
    private String instAttr;


    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public String getInstName1() {
        return instName1;
    }

    public void setInstName1(String instName1) {
        this.instName1 = instName1;
    }

    public String getInstName2() {
        return instName2;
    }

    public void setInstName2(String instName2) {
        this.instName2 = instName2;
    }

    public String getInstAddr() {
        return instAddr;
    }

    public void setInstAddr(String instAddr) {
        this.instAddr = instAddr;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public String getInstKind() {
        return instKind;
    }

    public void setInstKind(String instKind) {
        this.instKind = instKind;
    }

    public String getInstAttr() {
        return instAttr;
    }

    public void setInstAttr(String instAttr) {
        this.instAttr = instAttr;
    }
*/

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
