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
@IdClass(LN004_contract_state_key.class)
@Entity
@Table(name = "LN004")

public class LN004_合同状态信息 {


    @Id
    private String loancontrcode;

    @Id
    private String loancontrstate;
// 00-申请,  01-审批,  02-合同签订,  07-贷款担保,  08-放款通知,  09-放款,  90-合同终止,  98-审批撤销,  99-合同废弃
    @Id
    private String apprnum;



    private String settleop;

    private Date transdate;
    private Integer hostsernum;
    private String agentinstcode;


    public String getLoancontrcode() {
        return loancontrcode;
    }

    public void setLoancontrcode(String loancontrcode) {
        this.loancontrcode = loancontrcode;
    }

    public String getLoancontrstate() {
        return loancontrstate;
    }

    public void setLoancontrstate(String loancontrstate) {
        this.loancontrstate = loancontrstate;
    }

    public String getApprnum() {
        return apprnum;
    }

    public void setApprnum(String apprnum) {
        this.apprnum = apprnum;
    }

    public String getSettleop() {
        return settleop;
    }

    public void setSettleop(String settleop) {
        this.settleop = settleop;
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

    public String getAgentinstcode() {
        return agentinstcode;
    }

    public void setAgentinstcode(String agentinstcode) {
        this.agentinstcode = agentinstcode;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
