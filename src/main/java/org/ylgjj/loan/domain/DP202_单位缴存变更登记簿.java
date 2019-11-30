package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "DP202")

public class DP202_单位缴存变更登记簿 {


    @Id
    @Column(name = "seqno")
    private long seqno_不可为空_序号;

    @Column(name = "apprnum")
    private String apprnum_不可为空_审批号;
    @Column(name = "regnum")
    private String regnum_可为空_登记号;
    @Column(name = "transdate")
    private LocalDate transdate不可为空交易日期;
    @Column(name = "unitaccnum")
    private String unitaccnum不可为空单位账号;
    @Column(name = "unitcustid")
    private String unitcustid不可为空单位客户号;
    @Column(name = "onym")
    private String onym_可为空_启用年月;
    @Column(name = "lpaym")
    private String lpaym_可为空_缴至年月;
    @Column(name = "chgtype")
    private String chgtype_不可为空_变更类型;


/*  chgtype		"1-新增个人,
          2-启封,
          3-转入后正常状态,AN125
          4-封存,
          5-正常状态销户,
          6-正常状态转出,
          7-正常状态被合并,
          8-基数变更,
          9-比例变更"	0:_不可为空_变更类型*/




    @Column(name = "validflag")
    private String validflag_不可为空_有效标志; //0-有效,9-无效	0:
    @Column(name = "finchgnum")
    private long finchgnum_不可为空_财政变更人数; //finchgnum	增加记正，减少记负		0:
    @Column(name = "selchgnum")
    private long selchgnum_不可为空_自筹变更人数;// selchgnum	增加记正，减少记负		0:
    @Column(name = "finpayamt")
    private double finpayamt_不可为空_财政汇缴金额; // finpayamt	增加记正，减少记负		0:
    @Column(name = "selpayamt")
    private double selpayamt_不可为空_自筹汇缴金额; //selpayamt	增加记正，减少记负		0:
    @Column(name = "bfchgbasenum")
    private double bfchgbasenum_不可为空_变更前基数;
    @Column(name = "afchgbasenum")
    private double afchgbasenum_不可为空_变更后基数;
    @Column(name = "propchgtype")
    private String propchgtype_可为空_比例变更类型;
/*  propchgtype		"0-无变化,
          1-正常比例,
          2-高比例,
          3-特殊比例"	1:_可为空_比例变更类型*/


    @Column(name = "bfchgunitprop")
    private double bfchgunitprop不可为空_变更前单位比例;
    @Column(name = "afchgunitprop")
    private double afchgunitprop不可为空_变更后单位比例;
    @Column(name = "bfchgindiprop")
    private double bfchgindiprop不可为空_变更前个人比例;
    @Column(name = "afchgindiprop")
    private double afchgindiprop不可为空_变更后个人比例;
    @Column(name = "timestamp")
    private String timestamp不可为空_时间戳;
    @Column(name = "hostsernum")
    private long hostsernum不可为空_主机流水号;
    @Column(name = "agentinstcode")
    private String agentinstcode不可为空_经办机构;
    @Column(name = "accinstcode")
    private String accinstcode不可为空_账户机构;
    @Column(name = "agentbankcode")
    private String agentbankcode不可为空_经办银行;
    @Column(name = "accbankcode")
    private String accbankcode不可为空_账户银行;
    @Column(name = "agentop")
    private String agentop不可为空_经办柜员;
    @Column(name = "centerid")
    private String centerid不可为空_城市中心代码;
    @Column(name = "authfilenum")
    private String authfilenum可为空_批准文号;
    @Column(name = "postil")
    private String postil可为空_批复;
    @Column(name = "chgreason")
    private String chgreason可为空_调整原因;
    @Column(name = "freeuse1")
    private String freeuse1可为空_备用字符;
    @Column(name = "freeuse2")
    private double freeuse2可为空_备用金额;
    @Column(name = "freeuse3")
    private LocalDate freeuse3可为空_备用日期;
    @Column(name = "freeuse4")
    private long freeuse4可为空_备用数值;


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public long getSeqno_不可为空_序号() {
        return seqno_不可为空_序号;
    }

    public void setSeqno_不可为空_序号(long seqno_不可为空_序号) {
        this.seqno_不可为空_序号 = seqno_不可为空_序号;
    }

    public String getApprnum_不可为空_审批号() {
        return apprnum_不可为空_审批号;
    }

    public void setApprnum_不可为空_审批号(String apprnum_不可为空_审批号) {
        this.apprnum_不可为空_审批号 = apprnum_不可为空_审批号;
    }

    public String getRegnum_可为空_登记号() {
        return regnum_可为空_登记号;
    }

    public void setRegnum_可为空_登记号(String regnum_可为空_登记号) {
        this.regnum_可为空_登记号 = regnum_可为空_登记号;
    }

    public LocalDate getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(LocalDate transdate不可为空交易日期) {
        this.transdate不可为空交易日期 = transdate不可为空交易日期;
    }

    public String getUnitaccnum不可为空单位账号() {
        return unitaccnum不可为空单位账号;
    }

    public void setUnitaccnum不可为空单位账号(String unitaccnum不可为空单位账号) {
        this.unitaccnum不可为空单位账号 = unitaccnum不可为空单位账号;
    }

    public String getUnitcustid不可为空单位客户号() {
        return unitcustid不可为空单位客户号;
    }

    public void setUnitcustid不可为空单位客户号(String unitcustid不可为空单位客户号) {
        this.unitcustid不可为空单位客户号 = unitcustid不可为空单位客户号;
    }

    public String getOnym_可为空_启用年月() {
        return onym_可为空_启用年月;
    }

    public void setOnym_可为空_启用年月(String onym_可为空_启用年月) {
        this.onym_可为空_启用年月 = onym_可为空_启用年月;
    }

    public String getLpaym_可为空_缴至年月() {
        return lpaym_可为空_缴至年月;
    }

    public void setLpaym_可为空_缴至年月(String lpaym_可为空_缴至年月) {
        this.lpaym_可为空_缴至年月 = lpaym_可为空_缴至年月;
    }

    public String getChgtype_不可为空_变更类型() {
        return chgtype_不可为空_变更类型;
    }

    public void setChgtype_不可为空_变更类型(String chgtype_不可为空_变更类型) {
        this.chgtype_不可为空_变更类型 = chgtype_不可为空_变更类型;
    }

    public String getValidflag_不可为空_有效标志() {
        return validflag_不可为空_有效标志;
    }

    public void setValidflag_不可为空_有效标志(String validflag_不可为空_有效标志) {
        this.validflag_不可为空_有效标志 = validflag_不可为空_有效标志;
    }

    public long getFinchgnum_不可为空_财政变更人数() {
        return finchgnum_不可为空_财政变更人数;
    }

    public void setFinchgnum_不可为空_财政变更人数(long finchgnum_不可为空_财政变更人数) {
        this.finchgnum_不可为空_财政变更人数 = finchgnum_不可为空_财政变更人数;
    }

    public long getSelchgnum_不可为空_自筹变更人数() {
        return selchgnum_不可为空_自筹变更人数;
    }

    public void setSelchgnum_不可为空_自筹变更人数(long selchgnum_不可为空_自筹变更人数) {
        this.selchgnum_不可为空_自筹变更人数 = selchgnum_不可为空_自筹变更人数;
    }

    public double getFinpayamt_不可为空_财政汇缴金额() {
        return finpayamt_不可为空_财政汇缴金额;
    }

    public void setFinpayamt_不可为空_财政汇缴金额(double finpayamt_不可为空_财政汇缴金额) {
        this.finpayamt_不可为空_财政汇缴金额 = finpayamt_不可为空_财政汇缴金额;
    }

    public double getSelpayamt_不可为空_自筹汇缴金额() {
        return selpayamt_不可为空_自筹汇缴金额;
    }

    public void setSelpayamt_不可为空_自筹汇缴金额(double selpayamt_不可为空_自筹汇缴金额) {
        this.selpayamt_不可为空_自筹汇缴金额 = selpayamt_不可为空_自筹汇缴金额;
    }

    public double getBfchgbasenum_不可为空_变更前基数() {
        return bfchgbasenum_不可为空_变更前基数;
    }

    public void setBfchgbasenum_不可为空_变更前基数(double bfchgbasenum_不可为空_变更前基数) {
        this.bfchgbasenum_不可为空_变更前基数 = bfchgbasenum_不可为空_变更前基数;
    }

    public double getAfchgbasenum_不可为空_变更后基数() {
        return afchgbasenum_不可为空_变更后基数;
    }

    public void setAfchgbasenum_不可为空_变更后基数(double afchgbasenum_不可为空_变更后基数) {
        this.afchgbasenum_不可为空_变更后基数 = afchgbasenum_不可为空_变更后基数;
    }

    public String getPropchgtype_可为空_比例变更类型() {
        return propchgtype_可为空_比例变更类型;
    }

    public void setPropchgtype_可为空_比例变更类型(String propchgtype_可为空_比例变更类型) {
        this.propchgtype_可为空_比例变更类型 = propchgtype_可为空_比例变更类型;
    }

    public double getBfchgunitprop不可为空_变更前单位比例() {
        return bfchgunitprop不可为空_变更前单位比例;
    }

    public void setBfchgunitprop不可为空_变更前单位比例(double bfchgunitprop不可为空_变更前单位比例) {
        this.bfchgunitprop不可为空_变更前单位比例 = bfchgunitprop不可为空_变更前单位比例;
    }

    public double getAfchgunitprop不可为空_变更后单位比例() {
        return afchgunitprop不可为空_变更后单位比例;
    }

    public void setAfchgunitprop不可为空_变更后单位比例(double afchgunitprop不可为空_变更后单位比例) {
        this.afchgunitprop不可为空_变更后单位比例 = afchgunitprop不可为空_变更后单位比例;
    }

    public double getBfchgindiprop不可为空_变更前个人比例() {
        return bfchgindiprop不可为空_变更前个人比例;
    }

    public void setBfchgindiprop不可为空_变更前个人比例(double bfchgindiprop不可为空_变更前个人比例) {
        this.bfchgindiprop不可为空_变更前个人比例 = bfchgindiprop不可为空_变更前个人比例;
    }

    public double getAfchgindiprop不可为空_变更后个人比例() {
        return afchgindiprop不可为空_变更后个人比例;
    }

    public void setAfchgindiprop不可为空_变更后个人比例(double afchgindiprop不可为空_变更后个人比例) {
        this.afchgindiprop不可为空_变更后个人比例 = afchgindiprop不可为空_变更后个人比例;
    }

    public String getTimestamp不可为空_时间戳() {
        return timestamp不可为空_时间戳;
    }

    public void setTimestamp不可为空_时间戳(String timestamp不可为空_时间戳) {
        this.timestamp不可为空_时间戳 = timestamp不可为空_时间戳;
    }

    public long getHostsernum不可为空_主机流水号() {
        return hostsernum不可为空_主机流水号;
    }

    public void setHostsernum不可为空_主机流水号(long hostsernum不可为空_主机流水号) {
        this.hostsernum不可为空_主机流水号 = hostsernum不可为空_主机流水号;
    }

    public String getAgentinstcode不可为空_经办机构() {
        return agentinstcode不可为空_经办机构;
    }

    public void setAgentinstcode不可为空_经办机构(String agentinstcode不可为空_经办机构) {
        this.agentinstcode不可为空_经办机构 = agentinstcode不可为空_经办机构;
    }

    public String getAccinstcode不可为空_账户机构() {
        return accinstcode不可为空_账户机构;
    }

    public void setAccinstcode不可为空_账户机构(String accinstcode不可为空_账户机构) {
        this.accinstcode不可为空_账户机构 = accinstcode不可为空_账户机构;
    }

    public String getAgentbankcode不可为空_经办银行() {
        return agentbankcode不可为空_经办银行;
    }

    public void setAgentbankcode不可为空_经办银行(String agentbankcode不可为空_经办银行) {
        this.agentbankcode不可为空_经办银行 = agentbankcode不可为空_经办银行;
    }

    public String getAccbankcode不可为空_账户银行() {
        return accbankcode不可为空_账户银行;
    }

    public void setAccbankcode不可为空_账户银行(String accbankcode不可为空_账户银行) {
        this.accbankcode不可为空_账户银行 = accbankcode不可为空_账户银行;
    }

    public String getAgentop不可为空_经办柜员() {
        return agentop不可为空_经办柜员;
    }

    public void setAgentop不可为空_经办柜员(String agentop不可为空_经办柜员) {
        this.agentop不可为空_经办柜员 = agentop不可为空_经办柜员;
    }

    public String getCenterid不可为空_城市中心代码() {
        return centerid不可为空_城市中心代码;
    }

    public void setCenterid不可为空_城市中心代码(String centerid不可为空_城市中心代码) {
        this.centerid不可为空_城市中心代码 = centerid不可为空_城市中心代码;
    }

    public String getAuthfilenum可为空_批准文号() {
        return authfilenum可为空_批准文号;
    }

    public void setAuthfilenum可为空_批准文号(String authfilenum可为空_批准文号) {
        this.authfilenum可为空_批准文号 = authfilenum可为空_批准文号;
    }

    public String getPostil可为空_批复() {
        return postil可为空_批复;
    }

    public void setPostil可为空_批复(String postil可为空_批复) {
        this.postil可为空_批复 = postil可为空_批复;
    }

    public String getChgreason可为空_调整原因() {
        return chgreason可为空_调整原因;
    }

    public void setChgreason可为空_调整原因(String chgreason可为空_调整原因) {
        this.chgreason可为空_调整原因 = chgreason可为空_调整原因;
    }

    public String getFreeuse1可为空_备用字符() {
        return freeuse1可为空_备用字符;
    }

    public void setFreeuse1可为空_备用字符(String freeuse1可为空_备用字符) {
        this.freeuse1可为空_备用字符 = freeuse1可为空_备用字符;
    }

    public double getFreeuse2可为空_备用金额() {
        return freeuse2可为空_备用金额;
    }

    public void setFreeuse2可为空_备用金额(double freeuse2可为空_备用金额) {
        this.freeuse2可为空_备用金额 = freeuse2可为空_备用金额;
    }

    public LocalDate getFreeuse3可为空_备用日期() {
        return freeuse3可为空_备用日期;
    }

    public void setFreeuse3可为空_备用日期(LocalDate freeuse3可为空_备用日期) {
        this.freeuse3可为空_备用日期 = freeuse3可为空_备用日期;
    }

    public long getFreeuse4可为空_备用数值() {
        return freeuse4可为空_备用数值;
    }

    public void setFreeuse4可为空_备用数值(long freeuse4可为空_备用数值) {
        this.freeuse4可为空_备用数值 = freeuse4可为空_备用数值;
    }
}
