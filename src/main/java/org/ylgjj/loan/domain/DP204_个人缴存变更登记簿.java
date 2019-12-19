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

@Table(name = "DP204")

public class DP204_个人缴存变更登记簿 {


    @Id
    @Column(name = "seqno")
    private String seqno_不可为空_序号;




    @Column(name = "apprnum")
    private String apprnum_不可为空_审批号;
    @Column(name = "transdate")
    private LocalDate transdate不可为空交易日期;
    @Column(name = "unitaccnum")
    private String unitaccnum_不可为空_单位账号;

    @Column(name = "accnum")
    private String accnum不可为空个人账号;

    @Column(name = "onym")
    private String onym_可为空_启用年月;
    @Column(name = "lpaym")
    private String lpaym_可为空_缴至年月;

    @Column(name = "chgtype")
    private String chgtype_不可为空_变更类型;
/*    chgtype		"1-新增个人,
            2-启封,
            4-封存,
            8-基数变更,
            9-比例变更"	0:不可为空	变更类型*/

    @Column(name = "validflag")
    private String validflag_不可为空_有效标志;//	0-有效,9-无效	0:不可为空	有效标志

    @Column(name = "fundsouflag")
    private String fundsouflag_不可为空_资金来源标志;//	0-自筹,1-财政	0:不可为空	资金来源标志


    @Column(name = "proptype")
    private String proptype_不可为空_变更比例类型;
/*        		"1-正常比例,
                        2-高比例,
            3-特殊比例"	0:不可为空	变更比例类型*/


    @Column(name = "bfchgbasenum")
    private String bfchgbasenum_不可为空_变更前基数;
    @Column(name = "afchgbasenum")
    private String afchgbasenum_不可为空_变更后基数;


    @Column(name = "bfchgunitprop")
    private String bfchgunitprop_不可为空_变更前单位比例;
    @Column(name = "afchgunitprop")
    private String afchgunitprop_不可为空_变更后单位比例;

    @Column(name = "bfchgunitaprop")
    private String bfchgunitaprop_不可为空_变更前单位比例辅助;



    @Column(name = "afchgunitaprop")
    private String afchgunitaprop_不可为空_变更后单位辅助比例;
    @Column(name = "bfchgindiprop")
    private String bfchgindiprop_不可为空_变更前个人比例;
    @Column(name = "afchgindiprop")
    private String afchgindiprop_不可为空_变更后个人比例;

    @Column(name = "bfchgunitpayamt")
    private String bfchgunitpayamt_不可为空_变更前单位月汇缴金额;
    @Column(name = "bfchgunitapayamt")
    private String bfchgunitapayamt_不可为空_变更前单位辅助月汇缴金额;
    @Column(name = "bfchgindipayamt")
    private String bfchgindipayamt_不可为空_变更前个人月汇缴金额;


    @Column(name = "bfchgindipaysum")
    private String bfchgindipaysum_不可为空_变更前个人汇缴总额;
    @Column(name = "afchgunitpayamt")
    private String afchgunitpayamt_不可为空_变更后单位月汇缴金额;
    @Column(name = "afchgunitapayamt")
    private String afchgunitapayamt_不可为空_变更后单位辅助月汇缴金额;


    @Column(name = "afchgindipayamt")
    private String afchgindipayamt_不可为空_变更后个人月汇缴金额;
    @Column(name = "afchgindipaysum")
    private String afchgindipaysum_不可为空_变更后个人汇缴总额;
    @Column(name = "timestamp")
    private String timestamp_不可为空_时间戳;


    @Column(name = "bpchgflag")
    private String bpchgflag_可为空_基数比例变更标志;
    @Column(name = "sealtype")
    private String sealtype_不可为空_封存类型;
/*        		"1-转移,
                        2-托管,
            3-人工,
            4-销户激活"	1:可为空	*/
    @Column(name = "hostsernum")
    private String hostsernum_不可为空_主机流水号;



    @Column(name = "agentinstcode")
    private String agentinstcode_不可为空_经办机构;
    @Column(name = "accinstcode")
    private String accinstcode_不可为空_账户机构;

    @Column(name = "agentbankcode")
    private String agentbankcode_不可为空_经办银行;
    @Column(name = "accbankcode")
    private String accbankcode_不可为空_账户银行;

    @Column(name = "agentop")
    private String agentop_不可为空_经办柜员;

    @Column(name = "centerid")
    private String centerid_不可为空_城市中心代码;





/*
    seqno	0		0:不可为空	序号
    regnum	0		0:不可为空	登记号
    regdate	0		0:不可为空	登记日期
    unitaccnum	0		0:不可为空	单位账号
    accnum	0		0:不可为空	个人账号
*/



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getSeqno_不可为空_序号() {
        return seqno_不可为空_序号;
    }

    public void setSeqno_不可为空_序号(String seqno_不可为空_序号) {
        this.seqno_不可为空_序号 = seqno_不可为空_序号;
    }

    public String getApprnum_不可为空_审批号() {
        return apprnum_不可为空_审批号;
    }

    public void setApprnum_不可为空_审批号(String apprnum_不可为空_审批号) {
        this.apprnum_不可为空_审批号 = apprnum_不可为空_审批号;
    }

    public LocalDate getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(LocalDate transdate不可为空交易日期) {
        this.transdate不可为空交易日期 = transdate不可为空交易日期;
    }

    public String getUnitaccnum_不可为空_单位账号() {
        return unitaccnum_不可为空_单位账号;
    }

    public void setUnitaccnum_不可为空_单位账号(String unitaccnum_不可为空_单位账号) {
        this.unitaccnum_不可为空_单位账号 = unitaccnum_不可为空_单位账号;
    }

    public String getAccnum不可为空个人账号() {
        return accnum不可为空个人账号;
    }

    public void setAccnum不可为空个人账号(String accnum不可为空个人账号) {
        this.accnum不可为空个人账号 = accnum不可为空个人账号;
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

    public String getFundsouflag_不可为空_资金来源标志() {
        return fundsouflag_不可为空_资金来源标志;
    }

    public void setFundsouflag_不可为空_资金来源标志(String fundsouflag_不可为空_资金来源标志) {
        this.fundsouflag_不可为空_资金来源标志 = fundsouflag_不可为空_资金来源标志;
    }

    public String getProptype_不可为空_变更比例类型() {
        return proptype_不可为空_变更比例类型;
    }

    public void setProptype_不可为空_变更比例类型(String proptype_不可为空_变更比例类型) {
        this.proptype_不可为空_变更比例类型 = proptype_不可为空_变更比例类型;
    }

    public String getBfchgbasenum_不可为空_变更前基数() {
        return bfchgbasenum_不可为空_变更前基数;
    }

    public void setBfchgbasenum_不可为空_变更前基数(String bfchgbasenum_不可为空_变更前基数) {
        this.bfchgbasenum_不可为空_变更前基数 = bfchgbasenum_不可为空_变更前基数;
    }

    public String getAfchgbasenum_不可为空_变更后基数() {
        return afchgbasenum_不可为空_变更后基数;
    }

    public void setAfchgbasenum_不可为空_变更后基数(String afchgbasenum_不可为空_变更后基数) {
        this.afchgbasenum_不可为空_变更后基数 = afchgbasenum_不可为空_变更后基数;
    }

    public String getBfchgunitprop_不可为空_变更前单位比例() {
        return bfchgunitprop_不可为空_变更前单位比例;
    }

    public void setBfchgunitprop_不可为空_变更前单位比例(String bfchgunitprop_不可为空_变更前单位比例) {
        this.bfchgunitprop_不可为空_变更前单位比例 = bfchgunitprop_不可为空_变更前单位比例;
    }

    public String getAfchgunitprop_不可为空_变更后单位比例() {
        return afchgunitprop_不可为空_变更后单位比例;
    }

    public void setAfchgunitprop_不可为空_变更后单位比例(String afchgunitprop_不可为空_变更后单位比例) {
        this.afchgunitprop_不可为空_变更后单位比例 = afchgunitprop_不可为空_变更后单位比例;
    }

    public String getBfchgunitaprop_不可为空_变更前单位比例辅助() {
        return bfchgunitaprop_不可为空_变更前单位比例辅助;
    }

    public void setBfchgunitaprop_不可为空_变更前单位比例辅助(String bfchgunitaprop_不可为空_变更前单位比例辅助) {
        this.bfchgunitaprop_不可为空_变更前单位比例辅助 = bfchgunitaprop_不可为空_变更前单位比例辅助;
    }

    public String getAfchgunitaprop_不可为空_变更后单位辅助比例() {
        return afchgunitaprop_不可为空_变更后单位辅助比例;
    }

    public void setAfchgunitaprop_不可为空_变更后单位辅助比例(String afchgunitaprop_不可为空_变更后单位辅助比例) {
        this.afchgunitaprop_不可为空_变更后单位辅助比例 = afchgunitaprop_不可为空_变更后单位辅助比例;
    }

    public String getBfchgindiprop_不可为空_变更前个人比例() {
        return bfchgindiprop_不可为空_变更前个人比例;
    }

    public void setBfchgindiprop_不可为空_变更前个人比例(String bfchgindiprop_不可为空_变更前个人比例) {
        this.bfchgindiprop_不可为空_变更前个人比例 = bfchgindiprop_不可为空_变更前个人比例;
    }

    public String getAfchgindiprop_不可为空_变更后个人比例() {
        return afchgindiprop_不可为空_变更后个人比例;
    }

    public void setAfchgindiprop_不可为空_变更后个人比例(String afchgindiprop_不可为空_变更后个人比例) {
        this.afchgindiprop_不可为空_变更后个人比例 = afchgindiprop_不可为空_变更后个人比例;
    }

    public String getBfchgunitpayamt_不可为空_变更前单位月汇缴金额() {
        return bfchgunitpayamt_不可为空_变更前单位月汇缴金额;
    }

    public void setBfchgunitpayamt_不可为空_变更前单位月汇缴金额(String bfchgunitpayamt_不可为空_变更前单位月汇缴金额) {
        this.bfchgunitpayamt_不可为空_变更前单位月汇缴金额 = bfchgunitpayamt_不可为空_变更前单位月汇缴金额;
    }

    public String getBfchgunitapayamt_不可为空_变更前单位辅助月汇缴金额() {
        return bfchgunitapayamt_不可为空_变更前单位辅助月汇缴金额;
    }

    public void setBfchgunitapayamt_不可为空_变更前单位辅助月汇缴金额(String bfchgunitapayamt_不可为空_变更前单位辅助月汇缴金额) {
        this.bfchgunitapayamt_不可为空_变更前单位辅助月汇缴金额 = bfchgunitapayamt_不可为空_变更前单位辅助月汇缴金额;
    }

    public String getBfchgindipayamt_不可为空_变更前个人月汇缴金额() {
        return bfchgindipayamt_不可为空_变更前个人月汇缴金额;
    }

    public void setBfchgindipayamt_不可为空_变更前个人月汇缴金额(String bfchgindipayamt_不可为空_变更前个人月汇缴金额) {
        this.bfchgindipayamt_不可为空_变更前个人月汇缴金额 = bfchgindipayamt_不可为空_变更前个人月汇缴金额;
    }

    public String getBfchgindipaysum_不可为空_变更前个人汇缴总额() {
        return bfchgindipaysum_不可为空_变更前个人汇缴总额;
    }

    public void setBfchgindipaysum_不可为空_变更前个人汇缴总额(String bfchgindipaysum_不可为空_变更前个人汇缴总额) {
        this.bfchgindipaysum_不可为空_变更前个人汇缴总额 = bfchgindipaysum_不可为空_变更前个人汇缴总额;
    }

    public String getAfchgunitpayamt_不可为空_变更后单位月汇缴金额() {
        return afchgunitpayamt_不可为空_变更后单位月汇缴金额;
    }

    public void setAfchgunitpayamt_不可为空_变更后单位月汇缴金额(String afchgunitpayamt_不可为空_变更后单位月汇缴金额) {
        this.afchgunitpayamt_不可为空_变更后单位月汇缴金额 = afchgunitpayamt_不可为空_变更后单位月汇缴金额;
    }

    public String getAfchgunitapayamt_不可为空_变更后单位辅助月汇缴金额() {
        return afchgunitapayamt_不可为空_变更后单位辅助月汇缴金额;
    }

    public void setAfchgunitapayamt_不可为空_变更后单位辅助月汇缴金额(String afchgunitapayamt_不可为空_变更后单位辅助月汇缴金额) {
        this.afchgunitapayamt_不可为空_变更后单位辅助月汇缴金额 = afchgunitapayamt_不可为空_变更后单位辅助月汇缴金额;
    }

    public String getAfchgindipayamt_不可为空_变更后个人月汇缴金额() {
        return afchgindipayamt_不可为空_变更后个人月汇缴金额;
    }

    public void setAfchgindipayamt_不可为空_变更后个人月汇缴金额(String afchgindipayamt_不可为空_变更后个人月汇缴金额) {
        this.afchgindipayamt_不可为空_变更后个人月汇缴金额 = afchgindipayamt_不可为空_变更后个人月汇缴金额;
    }

    public String getAfchgindipaysum_不可为空_变更后个人汇缴总额() {
        return afchgindipaysum_不可为空_变更后个人汇缴总额;
    }

    public void setAfchgindipaysum_不可为空_变更后个人汇缴总额(String afchgindipaysum_不可为空_变更后个人汇缴总额) {
        this.afchgindipaysum_不可为空_变更后个人汇缴总额 = afchgindipaysum_不可为空_变更后个人汇缴总额;
    }

    public String getTimestamp_不可为空_时间戳() {
        return timestamp_不可为空_时间戳;
    }

    public void setTimestamp_不可为空_时间戳(String timestamp_不可为空_时间戳) {
        this.timestamp_不可为空_时间戳 = timestamp_不可为空_时间戳;
    }

    public String getBpchgflag_可为空_基数比例变更标志() {
        return bpchgflag_可为空_基数比例变更标志;
    }

    public void setBpchgflag_可为空_基数比例变更标志(String bpchgflag_可为空_基数比例变更标志) {
        this.bpchgflag_可为空_基数比例变更标志 = bpchgflag_可为空_基数比例变更标志;
    }

    public String getSealtype_不可为空_封存类型() {
        return sealtype_不可为空_封存类型;
    }

    public void setSealtype_不可为空_封存类型(String sealtype_不可为空_封存类型) {
        this.sealtype_不可为空_封存类型 = sealtype_不可为空_封存类型;
    }

    public String getHostsernum_不可为空_主机流水号() {
        return hostsernum_不可为空_主机流水号;
    }

    public void setHostsernum_不可为空_主机流水号(String hostsernum_不可为空_主机流水号) {
        this.hostsernum_不可为空_主机流水号 = hostsernum_不可为空_主机流水号;
    }

    public String getAgentinstcode_不可为空_经办机构() {
        return agentinstcode_不可为空_经办机构;
    }

    public void setAgentinstcode_不可为空_经办机构(String agentinstcode_不可为空_经办机构) {
        this.agentinstcode_不可为空_经办机构 = agentinstcode_不可为空_经办机构;
    }

    public String getAccinstcode_不可为空_账户机构() {
        return accinstcode_不可为空_账户机构;
    }

    public void setAccinstcode_不可为空_账户机构(String accinstcode_不可为空_账户机构) {
        this.accinstcode_不可为空_账户机构 = accinstcode_不可为空_账户机构;
    }

    public String getAgentbankcode_不可为空_经办银行() {
        return agentbankcode_不可为空_经办银行;
    }

    public void setAgentbankcode_不可为空_经办银行(String agentbankcode_不可为空_经办银行) {
        this.agentbankcode_不可为空_经办银行 = agentbankcode_不可为空_经办银行;
    }

    public String getAccbankcode_不可为空_账户银行() {
        return accbankcode_不可为空_账户银行;
    }

    public void setAccbankcode_不可为空_账户银行(String accbankcode_不可为空_账户银行) {
        this.accbankcode_不可为空_账户银行 = accbankcode_不可为空_账户银行;
    }

    public String getAgentop_不可为空_经办柜员() {
        return agentop_不可为空_经办柜员;
    }

    public void setAgentop_不可为空_经办柜员(String agentop_不可为空_经办柜员) {
        this.agentop_不可为空_经办柜员 = agentop_不可为空_经办柜员;
    }

    public String getCenterid_不可为空_城市中心代码() {
        return centerid_不可为空_城市中心代码;
    }

    public void setCenterid_不可为空_城市中心代码(String centerid_不可为空_城市中心代码) {
        this.centerid_不可为空_城市中心代码 = centerid_不可为空_城市中心代码;
    }
}
