package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */


@Entity

@Table(name = "DP009")

public class DP009_个人明细账 {
    //DP095_PK_1_3:索引_accinstcode,accflag,calintdate


    @Id
    @Column(name = "seqno")
    private long seqno_不可为空_序号;








    @Column(name = "transdate")
    private LocalDate transdate不可为空交易日期;
    @Column(name = "accnum")
    private String accnum_不可为空_个人账号;

    @Column(name = "unitaccnum")
    private String unitaccnum_不可为空_单位账号;

    @Column(name = "mergoaccnum")
    private String mergoaccnum_可为空_并出个人账号; //串联用_1:;

    @Column(name = "custid")
    private String custid_不可为空_个人客户号;

    @Column(name = "accname")
    private String accname_不可为空_姓名;

    @Column(name = "subcode")
    private String subcode_可为空_科目控制字;











    @Column(name = "entrytranscode")
    private String entrytranscode_可为空_分录交易码;

    @Column(name = "begym")
    private String begym_可为空_开始年月;

    @Column(name = "endym")
    private String endym_可为空_截止年月;

    @Column(name = "dcflag")
    private String dcflag_不可为空_借贷标志; //_1-借,2-贷_0:;

    @Column(name = "amt")
    private double amt_不可为空_发生额;

    @Column(name = "keepamt")
    private double keepamt_可为空_存量发生额;

    @Column(name = "increamt")
    private double increamt_可为空_增量发生额;

    @Column(name = "basenum")
    private double basenum_不可为空_缴存基数;



    @Column(name = "unitprop")
    private double unitprop_不可为空_单位比例;














    @Column(name = "unitastprop")
    private double unitastprop_单位辅助比例 ;//dp004.PROPTYPE为0时有值不可为空_;

    @Column(name = "indiprop")
    private double indiprop_不可为空_个人缴存比例;

    @Column(name = "bal")
    private double bal_不可为空_余额;

    @Column(name = "summarycode")
    private String summarycode_不可为空_摘要代码;

    @Column(name = "remark")
    private String remark_可为空_备注; //提取原因、缴存类型等_1:

    @Column(name = "transtype")
    private String transtype_同dp008不可为空_交易类型;

    @Column(name = "vounum")
    private String vounum_可为空_业务凭证号;

    @Column(name = "timestamp")
    private String timestamp_不可为空_时间戳;

    @Column(name = "hostsernum")
    private long hostsernum_不可为空_主机流水号;

    @Column(name = "corrdate")
    private java.sql.Date corrdate_不可为空_冲正日期;

    @Column(name = "corrsernum")
    private long corrsernum_不可为空_冲正流水号;

    @Column(name = "allexchgflag")
    private String allexchgflag_不可为空_通兑标志; //0-通兑,1-非通兑_0:

    @Column(name = "transchannel")
    private String transchannel_不可为空_交易渠道;

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

    @Column(name = "freeuse1")
    private String freeuse1_可为空_备用字符;

    @Column(name = "freeuse2")
    private double freeuse2_可为空_备用金额;

    @Column(name = "freeuse3")
    private java.sql.Date freeuse3_可为空_备用日期;

    @Column(name = "freeuse4")
    private long freeuse4_可为空_备用数值;


/*




















* */

    public long getSeqno_不可为空_序号() {
        return seqno_不可为空_序号;
    }

    public void setSeqno_不可为空_序号(long seqno_不可为空_序号) {
        this.seqno_不可为空_序号 = seqno_不可为空_序号;
    }

    public LocalDate getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(LocalDate transdate不可为空交易日期) {
        this.transdate不可为空交易日期 = transdate不可为空交易日期;
    }

    public String getAccnum_不可为空_个人账号() {
        return accnum_不可为空_个人账号;
    }

    public void setAccnum_不可为空_个人账号(String accnum_不可为空_个人账号) {
        this.accnum_不可为空_个人账号 = accnum_不可为空_个人账号;
    }

    public String getUnitaccnum_不可为空_单位账号() {
        return unitaccnum_不可为空_单位账号;
    }

    public void setUnitaccnum_不可为空_单位账号(String unitaccnum_不可为空_单位账号) {
        this.unitaccnum_不可为空_单位账号 = unitaccnum_不可为空_单位账号;
    }

    public String getMergoaccnum_可为空_并出个人账号() {
        return mergoaccnum_可为空_并出个人账号;
    }

    public void setMergoaccnum_可为空_并出个人账号(String mergoaccnum_可为空_并出个人账号) {
        this.mergoaccnum_可为空_并出个人账号 = mergoaccnum_可为空_并出个人账号;
    }

    public String getCustid_不可为空_个人客户号() {
        return custid_不可为空_个人客户号;
    }

    public void setCustid_不可为空_个人客户号(String custid_不可为空_个人客户号) {
        this.custid_不可为空_个人客户号 = custid_不可为空_个人客户号;
    }

    public String getAccname_不可为空_姓名() {
        return accname_不可为空_姓名;
    }

    public void setAccname_不可为空_姓名(String accname_不可为空_姓名) {
        this.accname_不可为空_姓名 = accname_不可为空_姓名;
    }

    public String getSubcode_可为空_科目控制字() {
        return subcode_可为空_科目控制字;
    }

    public void setSubcode_可为空_科目控制字(String subcode_可为空_科目控制字) {
        this.subcode_可为空_科目控制字 = subcode_可为空_科目控制字;
    }

    public String getEntrytranscode_可为空_分录交易码() {
        return entrytranscode_可为空_分录交易码;
    }

    public void setEntrytranscode_可为空_分录交易码(String entrytranscode_可为空_分录交易码) {
        this.entrytranscode_可为空_分录交易码 = entrytranscode_可为空_分录交易码;
    }

    public String getBegym_可为空_开始年月() {
        return begym_可为空_开始年月;
    }

    public void setBegym_可为空_开始年月(String begym_可为空_开始年月) {
        this.begym_可为空_开始年月 = begym_可为空_开始年月;
    }

    public String getEndym_可为空_截止年月() {
        return endym_可为空_截止年月;
    }

    public void setEndym_可为空_截止年月(String endym_可为空_截止年月) {
        this.endym_可为空_截止年月 = endym_可为空_截止年月;
    }

    public String getDcflag_不可为空_借贷标志() {
        return dcflag_不可为空_借贷标志;
    }

    public void setDcflag_不可为空_借贷标志(String dcflag_不可为空_借贷标志) {
        this.dcflag_不可为空_借贷标志 = dcflag_不可为空_借贷标志;
    }

    public double getAmt_不可为空_发生额() {
        return amt_不可为空_发生额;
    }

    public void setAmt_不可为空_发生额(double amt_不可为空_发生额) {
        this.amt_不可为空_发生额 = amt_不可为空_发生额;
    }

    public double getKeepamt_可为空_存量发生额() {
        return keepamt_可为空_存量发生额;
    }

    public void setKeepamt_可为空_存量发生额(double keepamt_可为空_存量发生额) {
        this.keepamt_可为空_存量发生额 = keepamt_可为空_存量发生额;
    }

    public double getIncreamt_可为空_增量发生额() {
        return increamt_可为空_增量发生额;
    }

    public void setIncreamt_可为空_增量发生额(double increamt_可为空_增量发生额) {
        this.increamt_可为空_增量发生额 = increamt_可为空_增量发生额;
    }

    public double getBasenum_不可为空_缴存基数() {
        return basenum_不可为空_缴存基数;
    }

    public void setBasenum_不可为空_缴存基数(double basenum_不可为空_缴存基数) {
        this.basenum_不可为空_缴存基数 = basenum_不可为空_缴存基数;
    }

    public double getUnitprop_不可为空_单位比例() {
        return unitprop_不可为空_单位比例;
    }

    public void setUnitprop_不可为空_单位比例(double unitprop_不可为空_单位比例) {
        this.unitprop_不可为空_单位比例 = unitprop_不可为空_单位比例;
    }

    public double getUnitastprop_单位辅助比例() {
        return unitastprop_单位辅助比例;
    }

    public void setUnitastprop_单位辅助比例(double unitastprop_单位辅助比例) {
        this.unitastprop_单位辅助比例 = unitastprop_单位辅助比例;
    }

    public double getIndiprop_不可为空_个人缴存比例() {
        return indiprop_不可为空_个人缴存比例;
    }

    public void setIndiprop_不可为空_个人缴存比例(double indiprop_不可为空_个人缴存比例) {
        this.indiprop_不可为空_个人缴存比例 = indiprop_不可为空_个人缴存比例;
    }

    public double getBal_不可为空_余额() {
        return bal_不可为空_余额;
    }

    public void setBal_不可为空_余额(double bal_不可为空_余额) {
        this.bal_不可为空_余额 = bal_不可为空_余额;
    }

    public String getSummarycode_不可为空_摘要代码() {
        return summarycode_不可为空_摘要代码;
    }

    public void setSummarycode_不可为空_摘要代码(String summarycode_不可为空_摘要代码) {
        this.summarycode_不可为空_摘要代码 = summarycode_不可为空_摘要代码;
    }

    public String getRemark_可为空_备注() {
        return remark_可为空_备注;
    }

    public void setRemark_可为空_备注(String remark_可为空_备注) {
        this.remark_可为空_备注 = remark_可为空_备注;
    }

    public String getTranstype_同dp008不可为空_交易类型() {
        return transtype_同dp008不可为空_交易类型;
    }

    public void setTranstype_同dp008不可为空_交易类型(String transtype_同dp008不可为空_交易类型) {
        this.transtype_同dp008不可为空_交易类型 = transtype_同dp008不可为空_交易类型;
    }

    public String getVounum_可为空_业务凭证号() {
        return vounum_可为空_业务凭证号;
    }

    public void setVounum_可为空_业务凭证号(String vounum_可为空_业务凭证号) {
        this.vounum_可为空_业务凭证号 = vounum_可为空_业务凭证号;
    }

    public String getTimestamp_不可为空_时间戳() {
        return timestamp_不可为空_时间戳;
    }

    public void setTimestamp_不可为空_时间戳(String timestamp_不可为空_时间戳) {
        this.timestamp_不可为空_时间戳 = timestamp_不可为空_时间戳;
    }

    public long getHostsernum_不可为空_主机流水号() {
        return hostsernum_不可为空_主机流水号;
    }

    public void setHostsernum_不可为空_主机流水号(long hostsernum_不可为空_主机流水号) {
        this.hostsernum_不可为空_主机流水号 = hostsernum_不可为空_主机流水号;
    }

    public Date getCorrdate_不可为空_冲正日期() {
        return corrdate_不可为空_冲正日期;
    }

    public void setCorrdate_不可为空_冲正日期(Date corrdate_不可为空_冲正日期) {
        this.corrdate_不可为空_冲正日期 = corrdate_不可为空_冲正日期;
    }

    public long getCorrsernum_不可为空_冲正流水号() {
        return corrsernum_不可为空_冲正流水号;
    }

    public void setCorrsernum_不可为空_冲正流水号(long corrsernum_不可为空_冲正流水号) {
        this.corrsernum_不可为空_冲正流水号 = corrsernum_不可为空_冲正流水号;
    }

    public String getAllexchgflag_不可为空_通兑标志() {
        return allexchgflag_不可为空_通兑标志;
    }

    public void setAllexchgflag_不可为空_通兑标志(String allexchgflag_不可为空_通兑标志) {
        this.allexchgflag_不可为空_通兑标志 = allexchgflag_不可为空_通兑标志;
    }

    public String getTranschannel_不可为空_交易渠道() {
        return transchannel_不可为空_交易渠道;
    }

    public void setTranschannel_不可为空_交易渠道(String transchannel_不可为空_交易渠道) {
        this.transchannel_不可为空_交易渠道 = transchannel_不可为空_交易渠道;
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

    public String getFreeuse1_可为空_备用字符() {
        return freeuse1_可为空_备用字符;
    }

    public void setFreeuse1_可为空_备用字符(String freeuse1_可为空_备用字符) {
        this.freeuse1_可为空_备用字符 = freeuse1_可为空_备用字符;
    }

    public double getFreeuse2_可为空_备用金额() {
        return freeuse2_可为空_备用金额;
    }

    public void setFreeuse2_可为空_备用金额(double freeuse2_可为空_备用金额) {
        this.freeuse2_可为空_备用金额 = freeuse2_可为空_备用金额;
    }

    public Date getFreeuse3_可为空_备用日期() {
        return freeuse3_可为空_备用日期;
    }

    public void setFreeuse3_可为空_备用日期(Date freeuse3_可为空_备用日期) {
        this.freeuse3_可为空_备用日期 = freeuse3_可为空_备用日期;
    }

    public long getFreeuse4_可为空_备用数值() {
        return freeuse4_可为空_备用数值;
    }

    public void setFreeuse4_可为空_备用数值(long freeuse4_可为空_备用数值) {
        this.freeuse4_可为空_备用数值 = freeuse4_可为空_备用数值;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
