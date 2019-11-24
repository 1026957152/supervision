package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(LN011_guarantor_key.class)
@Entity

@Table(name = "LN011")

public class LN011_guarantor_info {






    @Id

    private String loancontrcode;

    private Integer seqnum;

    private Integer chgnum;




    private String custid;

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    /*    1-增加保证人,
                2-减少保证人,
                3-变更保证人,
                4-变更保证人信息*/
    private String suretytype;
/*    1-增加保证人,
            2-减少保证人,
            3-变更保证人,
            4-变更保证人信息*/



    private String suretyname;
    private String certinum;
    private String sex;

    private String handset;
    private String accnum;
    private String birthday;
    private String linkaddr;

    private Integer hostsernum;

    public Integer getHostsernum() {
        return hostsernum;
    }

    public void setHostsernum(Integer hostsernum) {
        this.hostsernum = hostsernum;
    }

    public String getLinkaddr() {
        return linkaddr;
    }

    public void setLinkaddr(String linkaddr) {
        this.linkaddr = linkaddr;
    }

    public String getSuretyname() {
        return suretyname;
    }

    public void setSuretyname(String suretyname) {
        this.suretyname = suretyname;
    }

    public String getCertinum() {
        return certinum;
    }

    public void setCertinum(String certinum) {
        this.certinum = certinum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHandset() {
        return handset;
    }

    public void setHandset(String handset) {
        this.handset = handset;
    }

    public String getAccnum() {
        return accnum;
    }

    public void setAccnum(String accnum) {
        this.accnum = accnum;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    private String famlinkphone;
    private String unitlinkphone;

    public String getFamlinkphone() {
        return famlinkphone;
    }

    public void setFamlinkphone(String famlinkphone) {
        this.famlinkphone = famlinkphone;
    }

    public String getUnitlinkphone() {
        return unitlinkphone;
    }

    public void setUnitlinkphone(String unitlinkphone) {
        this.unitlinkphone = unitlinkphone;
    }

    public String getUnitaccnum() {
        return unitaccnum;
    }

    public void setUnitaccnum(String unitaccnum) {
        this.unitaccnum = unitaccnum;
    }

    private String unitaccnum;


    public String getUnitaccname() {
        return unitaccname;
    }

    public void setUnitaccname(String unitaccname) {
        this.unitaccname = unitaccname;
    }


    public String getChangetype() {
        return changetype;
    }

    public void setChangetype(String changetype) {
        this.changetype = changetype;
    }



    public String getIndiaccstate() {
        return indiaccstate;
    }

    public void setIndiaccstate(String indiaccstate) {
        this.indiaccstate = indiaccstate;
    }




    private String unitaccname;

    private String changetype;

    private String chgreasontype;


    private String indiaccstate;

    public Date getTransdate() {
        return transdate;
    }

    public String getChgreasontype() {
        return chgreasontype;
    }

    public void setChgreasontype(String chgreasontype) {
        this.chgreasontype = chgreasontype;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    private Date transdate;


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

    public Integer getChgnum() {
        return chgnum;
    }

    public void setChgnum(Integer chgnum) {
        this.chgnum = chgnum;
    }




    public String getSuretytype() {
        return suretytype;
    }

    public void setSuretytype(String suretytype) {
        this.suretytype = suretytype;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }








}
