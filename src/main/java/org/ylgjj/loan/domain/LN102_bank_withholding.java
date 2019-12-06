package org.ylgjj.loan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(LN102_bank_withholding_key.class)
@Entity

@Table(name = "LN102")

public class LN102_bank_withholding {



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

    public String getHostsernum() {
        return hostsernum;
    }

    public void setHostsernum(String hostsernum) {
        this.hostsernum = hostsernum;
    }

    private String chkflag;//检查标志

    public String getChkflag() {
        return chkflag;
    }

    public void setChkflag(String chkflag) {
        this.chkflag = chkflag;
    }

    public String getAgentinstcode() {
        return agentinstcode;
    }

    private String agentinstcode; //

    public void setAgentinstcode(String agentinstcode) {
        this.agentinstcode = agentinstcode;
    }

    private String loanaccnum;

    private String dedaccnum; //

    private String oppinstcode;//dedaccnum

    private String agentbankcode;//agentbankcode

    public String getDedaccnum() {
        return dedaccnum;
    }

    public void setDedaccnum(String dedaccnum) {
        this.dedaccnum = dedaccnum;
    }

    public String getOppinstcode() {
        return oppinstcode;
    }

    public void setOppinstcode(String oppinstcode) {
        this.oppinstcode = oppinstcode;
    }

    public String getAgentbankcode() {
        return agentbankcode;
    }

    public void setAgentbankcode(String agentbankcode) {
        this.agentbankcode = agentbankcode;
    }

    public String getTermnum() {
        return termnum;
    }

    public void setTermnum(String termnum) {
        this.termnum = termnum;
    }

    public String getAccbankcode() {
        return accbankcode;
    }

    public void setAccbankcode(String accbankcode) {
        this.accbankcode = accbankcode;
    }

    private String dedtype;
    //1-银行代扣,
    //2-公积金代扣
    private String termnum;
    private Date planrepaydate; //planrepaydate


  @JsonFormat(pattern = "yyyy-MM-dd")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transdate;//实际扣款日期

   @JsonFormat(pattern = "yyyy-MM-dd")
   // @DateTimeFormat(pattern = "yyyy-MM-dd")

    public Date getPlanrepaydate() {
        return planrepaydate;
    }

    public void setPlanrepaydate(Date planrepaydate) {
        this.planrepaydate = planrepaydate;
    }

    public String getDedstate() {
        return dedstate;
    }

    public void setDedstate(String dedstate) {
        this.dedstate = dedstate;
    }

    public String getDedtype() {
        return dedtype;
    }

    public void setDedtype(String dedtype) {
        this.dedtype = dedtype;
    }

    public String getPlandedprin() {
        return plandedprin;
    }

    public void setPlandedprin(String plandedprin) {
        this.plandedprin = plandedprin;
    }

    public String getPlandedint() {
        return plandedint;
    }

    public void setPlandedint(String plandedint) {
        this.plandedint = plandedint;
    }

    public String getOwepun() {
        return owepun;
    }

    public void setOwepun(String owepun) {
        this.owepun = owepun;
    }

    public String getRepayprin() {
        return repayprin;
    }

    public void setRepayprin(String repayprin) {
        this.repayprin = repayprin;
    }

    public String getRepayint() {
        return repayint;
    }

    public void setRepayint(String repayint) {
        this.repayint = repayint;
    }

    public String getRepaypun() {
        return repaypun;
    }

    public void setRepaypun(String repaypun) {
        this.repaypun = repaypun;
    }

    public String getRepayoverdueprin() {
        return repayoverdueprin;
    }

    public void setRepayoverdueprin(String repayoverdueprin) {
        this.repayoverdueprin = repayoverdueprin;
    }

    public String getRepayoverdueint() {
        return repayoverdueint;
    }

    public void setRepayoverdueint(String repayoverdueint) {
        this.repayoverdueint = repayoverdueint;
    }

    private String dedstate;//代扣状态
//de  dedflag

    private String dedflag;//代扣状态  RecordedFlagEnum



    private String inaccflag;//入账标志
//0-未入账,
 //   4-已入账
//    X-扣款失败但已处理

    public String getCertinum() {
        return certinum;
    }

    public void setCertinum(String certinum) {
        this.certinum = certinum;
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public Date getTransdate() {
        return transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    public String getLoancontrcode() {
        return loancontrcode;
    }

    public void setLoancontrcode(String loancontrcode) {
        this.loancontrcode = loancontrcode;
    }

    public String getLoanaccnum() {
        return loanaccnum;
    }

    public void setLoanaccnum(String loanaccnum) {
        this.loanaccnum = loanaccnum;
    }

    public String getDedflag() {
        return dedflag;
    }

    public void setDedflag(String dedflag) {
        this.dedflag = dedflag;
    }

    public String getInaccflag() {
        return inaccflag;
    }

    public void setInaccflag(String inaccflag) {
        this.inaccflag = inaccflag;
    }

    private String accname;

    private String certinum;

    private String accbankcode;
    private String plandedprin; //本期应代扣本金

    private String plandedint; //本期应代扣利息

    private String owepun; //欠还罚息


    private String repayprin; //实还本金


    private String repayint; //实还利息

    private String repaypun; //实还罚息

    private String repayoverdueprin; //实还逾期本金

    private String repayoverdueint; //实还逾期利息







    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
