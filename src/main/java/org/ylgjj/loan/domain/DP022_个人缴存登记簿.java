package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "DP022")

public class DP022_个人缴存登记簿 {


    @Id
    @Column(name = "seqno")
    private String seqno_序号;

    @Column(name = "regnum")
    private String regnum_登记号;
    @Column(name = "regdate")
    private LocalDate regdate登记日期;

    @Column(name = "unitaccnum")
    private String unitaccnum_单位账号;

    @Column(name = "accnum")
    private String accnum个人账号;

/*
    seqno	0		0:不可为空	序号
    regnum	0		0:不可为空	登记号
    regdate	0		0:不可为空	登记日期
    unitaccnum	0		0:不可为空	单位账号
    accnum	0		0:不可为空	个人账号
*/


    @Column(name = "begym")
    @DateTimeFormat(pattern = "yyyyMM")
    //@DateTimeFormat(pattern = "yyyyMM")//格式：年月
    private String begym开始年月;
    @DateTimeFormat(pattern = "yyyyMM")
    @Column(name = "endym")
  //  @DateTimeFormat(pattern = "yyyyMM")//格式：年月
    private String endym截止年月;


    @Column(name = "basenum")
    private String basenum_缴存基数;

    @Column(name = "unitprop")
    private String unitprop_单位比例;

    @Column(name = "unitastprop")
    private String unitastprop_单位辅助比例;

    @Column(name = "indiprop")
    private String indiprop_个人缴存比例;

/*    begym	0		1:可为空	开始年月
    endym	0		1:可为空	截止年月
    basenum	0		0:不可为空	缴存基数
    unitprop	0		0:不可为空	单位比例
    unitastprop			0:不可为空	单位辅助比例
    indiprop	0		0:不可为空	个人缴存比例*/

    @Column(name = "indipayamt")
    private String indipayamt_个人月汇缴金额;

    @Column(name = "payamt")
    private BigDecimal payamt_缴存金额;
    @Column(name = "unitpayamt")
    private BigDecimal unitpayamt_单位月汇缴金额0;


    @Column(name = "fundsouflag")
    private String fundsouflag_资金来源标志;


    @Column(name = "dptype")
    private String dptype_缴存类型;

    public BigDecimal getUnitpayamt_单位月汇缴金额0() {
        return unitpayamt_单位月汇缴金额0;
    }

    public void setUnitpayamt_单位月汇缴金额0(BigDecimal unitpayamt_单位月汇缴金额0) {
        this.unitpayamt_单位月汇缴金额0 = unitpayamt_单位月汇缴金额0;
    }

    @Column(name = "colpaytype")
    private String colpaytype_汇缴类型0;
/*    unitpayamt	0		0:不可为空	单位月汇缴金额
    unitapayamt			0:不可为空	单位辅助月汇缴金额
    indipayamt	0		0:不可为空	个人月汇缴金额
    payamt	0		0:不可为空	缴存金额
    fundsouflag		"0-自筹,
            1-财政"	0:不可为空	资金来源标志
    dptype		"0-预缴,
            1-汇缴,
            2-正常全额补缴,
            3-正常差额补缴,
            4-不定额补缴,
            5-退缴
9-异地转入"	0:不可为空	缴存类型

    colpaytype		"0-全部,
            1-单位部分,
            2-个人部分,
            3-单位辅助部分,
            4-单位部分+个人,
            5-单位辅助+个人"	0:不可为空	汇缴类型*/



    @Column(name = "inaccstate")
    private String inaccstate_入账状态;



    @Column(name = "inaccdate")
    private LocalDateTime inaccdate_入账日期;



    @Column(name = "timestamp")
    private String timestamp_时间戳;

    @Column(name = "agentinstcode")
    private String agentinstcode_经办机构;

    @Column(name = "accinstcode")
    private String accinstcode_账户机构;


/*    transtype	同dp008		0:不可为空	交易类型
    inaccstate		0-未入账,1-入账	0:不可为空	入账状态
    inaccdate	0		0:不可为空	入账日期


    inacchostsernum	0		0:不可为空	入账主机流水号
    timestamp	0		0:不可为空	时间戳
    backincrebal	0		1:可为空	退缴使用增量余额
    backkeepbal	0		1:可为空	退缴使用存量余额
    backindipaymap		0-未汇缴,1-已汇缴	1:可为空	退缴个人位图
    agentinstcode	0		0:不可为空	经办机构
    accinstcode	0		0:不可为空	账户机构
    agentbankcode	0		0:不可为空	经办银行
    accbankcode	0		0:不可为空	账户银行
    centerid	0		0:不可为空	城市中心代码
    freeuse1			1:可为空	备用字符
    freeuse2			1:可为空	备用金额
    freeuse3			1:可为空	备用日期
    freeuse4			1:可为空	备用数值*/



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public String getSeqno_序号() {
        return seqno_序号;
    }

    public void setSeqno_序号(String seqno_序号) {
        this.seqno_序号 = seqno_序号;
    }

    public String getRegnum_登记号() {
        return regnum_登记号;
    }

    public void setRegnum_登记号(String regnum_登记号) {
        this.regnum_登记号 = regnum_登记号;
    }

    public LocalDate getRegdate登记日期() {
        return regdate登记日期;
    }

    public void setRegdate登记日期(LocalDate regdate登记日期) {
        this.regdate登记日期 = regdate登记日期;
    }

    public String getUnitaccnum_单位账号() {
        return unitaccnum_单位账号;
    }

    public void setUnitaccnum_单位账号(String unitaccnum_单位账号) {
        this.unitaccnum_单位账号 = unitaccnum_单位账号;
    }

    public String getAccnum个人账号() {
        return accnum个人账号;
    }

    public void setAccnum个人账号(String accnum个人账号) {
        this.accnum个人账号 = accnum个人账号;
    }

    public String getBegym开始年月() {
        return begym开始年月;
    }

    public void setBegym开始年月(String begym开始年月) {
        this.begym开始年月 = begym开始年月;
    }

    public String getEndym截止年月() {
        return endym截止年月;
    }

    public void setEndym截止年月(String endym_截止年月) {
        this.endym截止年月 = endym_截止年月;
    }

    public String getBasenum_缴存基数() {
        return basenum_缴存基数;
    }

    public void setBasenum_缴存基数(String basenum_缴存基数) {
        this.basenum_缴存基数 = basenum_缴存基数;
    }

    public String getUnitprop_单位比例() {
        return unitprop_单位比例;
    }

    public void setUnitprop_单位比例(String unitprop_单位比例) {
        this.unitprop_单位比例 = unitprop_单位比例;
    }

    public String getUnitastprop_单位辅助比例() {
        return unitastprop_单位辅助比例;
    }

    public void setUnitastprop_单位辅助比例(String unitastprop_单位辅助比例) {
        this.unitastprop_单位辅助比例 = unitastprop_单位辅助比例;
    }

    public String getIndiprop_个人缴存比例() {
        return indiprop_个人缴存比例;
    }

    public void setIndiprop_个人缴存比例(String indiprop_个人缴存比例) {
        this.indiprop_个人缴存比例 = indiprop_个人缴存比例;
    }

    public String getIndipayamt_个人月汇缴金额() {
        return indipayamt_个人月汇缴金额;
    }

    public void setIndipayamt_个人月汇缴金额(String indipayamt_个人月汇缴金额) {
        this.indipayamt_个人月汇缴金额 = indipayamt_个人月汇缴金额;
    }

    public BigDecimal getPayamt_缴存金额() {
        return payamt_缴存金额;
    }

    public void setPayamt_缴存金额(BigDecimal payamt_缴存金额) {
        this.payamt_缴存金额 = payamt_缴存金额;
    }

    public String getFundsouflag_资金来源标志() {
        return fundsouflag_资金来源标志;
    }

    public void setFundsouflag_资金来源标志(String fundsouflag_资金来源标志) {
        this.fundsouflag_资金来源标志 = fundsouflag_资金来源标志;
    }

    public String getDptype_缴存类型() {
        return dptype_缴存类型;
    }

    public void setDptype_缴存类型(String dptype_缴存类型) {
        this.dptype_缴存类型 = dptype_缴存类型;
    }

    public String getColpaytype_汇缴类型0() {
        return colpaytype_汇缴类型0;
    }

    public void setColpaytype_汇缴类型0(String colpaytype_汇缴类型0) {
        this.colpaytype_汇缴类型0 = colpaytype_汇缴类型0;
    }

    public String getInaccstate_入账状态() {
        return inaccstate_入账状态;
    }

    public void setInaccstate_入账状态(String inaccstate_入账状态) {
        this.inaccstate_入账状态 = inaccstate_入账状态;
    }

    public LocalDateTime getInaccdate_入账日期() {
        return inaccdate_入账日期;
    }

    public void setInaccdate_入账日期(LocalDateTime inaccdate_入账日期) {
        this.inaccdate_入账日期 = inaccdate_入账日期;
    }

    public String getTimestamp_时间戳() {
        return timestamp_时间戳;
    }

    public void setTimestamp_时间戳(String timestamp_时间戳) {
        this.timestamp_时间戳 = timestamp_时间戳;
    }

    public String getAgentinstcode_经办机构() {
        return agentinstcode_经办机构;
    }

    public void setAgentinstcode_经办机构(String agentinstcode_经办机构) {
        this.agentinstcode_经办机构 = agentinstcode_经办机构;
    }

    public String getAccinstcode_账户机构() {
        return accinstcode_账户机构;
    }

    public void setAccinstcode_账户机构(String accinstcode_账户机构) {
        this.accinstcode_账户机构 = accinstcode_账户机构;
    }
}
