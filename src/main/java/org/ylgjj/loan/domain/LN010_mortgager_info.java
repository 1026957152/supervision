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
@IdClass(LN010_mortgager_key.class)
@Entity

@Table(name = "LN010")

public class LN010_mortgager_info {





    @Id
    private String loancontrcode;

    @Id
    private String mortseqnum;
    @Id
    private Integer seqnum;
    @Id
    private String chgnum;









    /*    1-增加保证人,
                2-减少保证人,
                3-变更保证人,
                4-变更保证人信息*/
private String changetype;
/*    1-增加保证人,
            2-减少保证人,
            3-变更保证人,
            4-变更保证人信息*/

    private String chgreasontype;




private String ownrightnum;
    private String mortname;
    private String certitype;

    private String certinum;
    private Date transdate;
    private Integer hostsernum;

    public String getLoancontrcode() {
        return loancontrcode;
    }

    public void setLoancontrcode(String loancontrcode) {
        this.loancontrcode = loancontrcode;
    }

    public String getMortseqnum() {
        return mortseqnum;
    }

    public void setMortseqnum(String mortseqnum) {
        this.mortseqnum = mortseqnum;
    }

    public Integer getSeqnum() {
        return seqnum;
    }

    public void setSeqnum(Integer seqnum) {
        this.seqnum = seqnum;
    }

    public String getChgnum() {
        return chgnum;
    }

    public void setChgnum(String chgnum) {
        this.chgnum = chgnum;
    }

    public String getChangetype() {
        return changetype;
    }

    public void setChangetype(String changetype) {
        this.changetype = changetype;
    }

    public String getChgreasontype() {
        return chgreasontype;
    }

    public void setChgreasontype(String chgreasontype) {
        this.chgreasontype = chgreasontype;
    }

    public String getOwnrightnum() {
        return ownrightnum;
    }

    public void setOwnrightnum(String ownrightnum) {
        this.ownrightnum = ownrightnum;
    }

    public String getMortname() {
        return mortname;
    }

    public void setMortname(String mortname) {
        this.mortname = mortname;
    }

    public String getCertitype() {
        return certitype;
    }

    public void setCertitype(String certitype) {
        this.certitype = certitype;
    }

    public String getCertinum() {
        return certinum;
    }

    public void setCertinum(String certinum) {
        this.certinum = certinum;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public Date getTransdate() {
        return transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    public Integer getHostsernum() {
        return hostsernum;
    }

    public void setHostsernum(Integer hostsernum) {
        this.hostsernum = hostsernum;
    }
}
