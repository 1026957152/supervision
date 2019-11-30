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

@Table(name = "DP021")

public class DP021_单位缴存登记簿 {

    @Id

    @Column(name = "seqno")
    private String seqno序号;

    public String getSeqno序号() {
        return seqno序号;
    }

    public void setSeqno序号(String seqno序号) {
        this.seqno序号 = seqno序号;
    }

    @Column(name = "unitaccnum")
    private String unitaccnum单位账号;

    @Column(name = "unitpreaccnum")
    private String unitpreaccnum_单位预缴账号;

    @Column(name = "begym")
    private String begym_开始年月;

    @Column(name = "endym")
    private String endym_截止年月;


    @Column(name = "dptype")
    private String dptype_缴存类型;

/*    //
    dptype		"0-预缴,
            1-汇缴,
            2-正常全额补缴,
            3-正常差额补缴,
            4-不定额补缴,
            5-退缴
9-异地转入"	0:不可为空	缴存类型*/


    @Column(name = "fundsouflag")
    private String fundsouflag_资金来源标志;
/*    fundsouflag		"0-自筹,
            1-财政,
            2-自筹和财政结合"	0:不可为空	资金来源标志*/

    @Column(name = "paymode")
    private String paymode_缴款方式;
/*    paymode		"1-支票,
            2-现金,
            3-预缴,
            4-其它,
            5-通知,
            6-托收,
            7-实时结算,
            8-上级预缴转入"	0:不可为空	缴款方式*/




    @Column(name = "basenum")
    private String basenum_缴存基数;
    @Column(name = "regnum")
    private String regnum_登记号;


    @Column(name = "regdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//格式：年-月-日
    private LocalDate regdate不可为空登记日期;
    @Column(name = "inaccdate")
    private LocalDate inaccdate不可为空入账日期;


    @Column(name = "paychgflag")
    private String paychgflag_汇缴额变化标志;
    @Column(name = "lmpaynum")
    private String lmpaynum_上月汇缴人数;

    @Column(name = "lmpayamt")
    private String lmpayamt_上月汇缴金额;

    @Column(name = "cmpaynum")
    private Integer cmpaynum_本月汇缴人数;

    @Column(name = "cmpayamt")
    private BigDecimal cmpayamt_本月汇缴金额;

    @Column(name = "peoplenum")
    private Integer peoplenum_人数;


/*
    cmaddpaynum	0		0:不可为空	本月增加汇缴人数
    cmaddpayamt	与人数有关的增加		0:不可为空	本月增加汇缴金额
    chgaddpayamt			0:不可为空	汇缴金额变动增加金额
    cmdecpaynum	0		0:不可为空	本月减少汇缴人数
    cmdecpayamt	与人数有关的减少		0:不可为空	本月减少汇缴金额
    chgdecpayamt			0:不可为空	汇缴金额变动减少金额*/



/*
    unitnorprop	0		0:不可为空	单位正常比例
    unithigprop	0		0:不可为空	单位高比例
    unitspeprop	0		0:不可为空	单位特殊比例
    unitastprop	单位正常比例类型为0时有值		0:不可为空	单位辅助比例
    indinorprop	0		0:不可为空	个人正常比例
    indihigprop	0		0:不可为空	个人高比例
    indispeprop	0		0:不可为空	个人特殊比例
*/


    @Column(name = "monpayamt")
    private String monpayamt_月应缴金额;
    @Column(name = "upaytotamt")
    private BigDecimal upaytotamt_应缴总额;
    @Column(name = "factpayamt")
    private BigDecimal factpayamt_实际缴款金额;
    @Column(name = "uprepayamt")
    private BigDecimal uprepayamt_预缴户转出金额;
    @Column(name = "uprepayinamt")
    private String uprepayinamt_预缴户转入金额;
    @Column(name = "inaccstate")
    private String inaccstate_入账状态; // 汇缴入账，预缴肯定入账了。，汇缴可能无入账。



    public LocalDate getInaccdate不可为空入账日期() {
        return inaccdate不可为空入账日期;
    }

    public void setInaccdate不可为空入账日期(LocalDate inaccdate不可为空入账日期) {
        this.inaccdate不可为空入账日期 = inaccdate不可为空入账日期;
    }

    @Column(name = "agentinstcode")
    private String agentinstcode_经办机构;
    @Column(name = "accinstcode")
    private String accinstcode_账户机构;


    @Column(name = "bankpaydate")
    private String bankpaydate_可为空_银行划款日期;

    public String getBankpaydate_可为空_银行划款日期() {
        return bankpaydate_可为空_银行划款日期;
    }

    public void setBankpaydate_可为空_银行划款日期(String bankpaydate_可为空_银行划款日期) {
        this.bankpaydate_可为空_银行划款日期 = bankpaydate_可为空_银行划款日期;
    }

/*    monpayamt	当月		0:不可为空	月应缴金额
    upaytotamt	汇总信息		0:不可为空	应缴总额
    factpayamt	汇总信息		0:不可为空	实际缴款金额
    uprepayamt	汇总信息		0:不可为空	预缴户转出金额
    uprepayinamt	汇总信息		0:不可为空	预缴户转入金额
    diskflag		1-单笔,2-批量	1:可为空	报盘手工录入标志
    supunitaccnum			1:可为空	上级单位账号
    colpaytype		"0-全部,
            1-单位部分,
            2-个人部分,
            3-单位辅助部分,
            4-单位部分+个人,
            5-单位辅助+个人"	0:不可为空	汇缴类型
    transtype	同dp008		0:不可为空	交易类型
    payvounum	0		1:可为空	缴存业务凭证号
    inaccstate		0-未入账,1-入账	0:不可为空	入账状态
    inaccdate	0		0:不可为空	入账日期
    inacchostsernum	0		0:不可为空	入账主机流水号
    timestamp	0		0:不可为空	时间戳
    agentinstcode	0		0:不可为空	经办机构
    accinstcode	0		0:不可为空	账户机构
    agentbankcode	划入银行		0:不可为空	经办银行
    accbankcode	0		0:不可为空	账户银行
    inputop	0		0:不可为空	录入柜员
    authop	0		1:可为空	授权柜员
    inaccop	0		1:可为空	入账柜员
    centerid	0		0:不可为空	城市中心代码
    cstcollbankcode	实时结算时记录付款信息		1:可为空	单位托收银行码
    cstcollbankacc	实时结算时记录付款信息		1:可为空	单位托收银行账号
    cstbankaccname	实时结算时记录付款信息		1:可为空	单位托收银行账户名称
    chkstate		00-柜面托收登记,01-柜面托付已发起,02-柜面托收失败,03-柜面托收入账,04-柜员托收登记失败重新发起托收,10-自动托收登记,11-自动托付已发起 ,12-自动托收失败,13-自动托收入账	1:可为空	托收状态
    falsereason			1:可为空	托收失败原因
    chkflag		00-核对成功,11-核对失败,17-银行没有返回,18-银行返回失败,19-银行返回成功表示有误	1:可为空	核对标志
    chkresucode			1:可为空	核对结果摘要码
    bankpaydate			1:可为空	银行划款日期
    filename	托收包的文件名称		1:可为空	托收文件名称
    freeuse1			1:可为空	备用字符
    freeuse2			1:可为空	备用金额
    freeuse3			1:可为空	备用日期
    freeuse4			1:可为空	备用数值*/


    public String getUnitaccnum单位账号() {
        return unitaccnum单位账号;
    }

    public void setUnitaccnum单位账号(String unitaccnum单位账号) {
        this.unitaccnum单位账号 = unitaccnum单位账号;
    }

    public String getUnitpreaccnum_单位预缴账号() {
        return unitpreaccnum_单位预缴账号;
    }

    public void setUnitpreaccnum_单位预缴账号(String unitpreaccnum_单位预缴账号) {
        this.unitpreaccnum_单位预缴账号 = unitpreaccnum_单位预缴账号;
    }

    public String getBegym_开始年月() {
        return begym_开始年月;
    }

    public void setBegym_开始年月(String begym_开始年月) {
        this.begym_开始年月 = begym_开始年月;
    }

    public String getEndym_截止年月() {
        return endym_截止年月;
    }

    public void setEndym_截止年月(String endym_截止年月) {
        this.endym_截止年月 = endym_截止年月;
    }

    public String getDptype_缴存类型() {
        return dptype_缴存类型;
    }

    public void setDptype_缴存类型(String dptype_缴存类型) {
        this.dptype_缴存类型 = dptype_缴存类型;
    }

    public String getFundsouflag_资金来源标志() {
        return fundsouflag_资金来源标志;
    }

    public void setFundsouflag_资金来源标志(String fundsouflag_资金来源标志) {
        this.fundsouflag_资金来源标志 = fundsouflag_资金来源标志;
    }

    public String getPaymode_缴款方式() {
        return paymode_缴款方式;
    }

    public void setPaymode_缴款方式(String paymode_缴款方式) {
        this.paymode_缴款方式 = paymode_缴款方式;
    }

    public String getBasenum_缴存基数() {
        return basenum_缴存基数;
    }

    public void setBasenum_缴存基数(String basenum_缴存基数) {
        this.basenum_缴存基数 = basenum_缴存基数;
    }

    public String getRegnum_登记号() {
        return regnum_登记号;
    }

    public void setRegnum_登记号(String regnum_登记号) {
        this.regnum_登记号 = regnum_登记号;
    }

    public LocalDate getRegdate不可为空登记日期() {
        return regdate不可为空登记日期;
    }

    public void setRegdate不可为空登记日期(LocalDate regdate不可为空登记日期) {
        this.regdate不可为空登记日期 = regdate不可为空登记日期;
    }

    public String getPaychgflag_汇缴额变化标志() {
        return paychgflag_汇缴额变化标志;
    }

    public void setPaychgflag_汇缴额变化标志(String paychgflag_汇缴额变化标志) {
        this.paychgflag_汇缴额变化标志 = paychgflag_汇缴额变化标志;
    }

    public String getLmpaynum_上月汇缴人数() {
        return lmpaynum_上月汇缴人数;
    }

    public void setLmpaynum_上月汇缴人数(String lmpaynum_上月汇缴人数) {
        this.lmpaynum_上月汇缴人数 = lmpaynum_上月汇缴人数;
    }

    public String getLmpayamt_上月汇缴金额() {
        return lmpayamt_上月汇缴金额;
    }

    public void setLmpayamt_上月汇缴金额(String lmpayamt_上月汇缴金额) {
        this.lmpayamt_上月汇缴金额 = lmpayamt_上月汇缴金额;
    }

    public Integer getCmpaynum_本月汇缴人数() {
        return cmpaynum_本月汇缴人数;
    }

    public void setCmpaynum_本月汇缴人数(Integer cmpaynum_本月汇缴人数) {
        this.cmpaynum_本月汇缴人数 = cmpaynum_本月汇缴人数;
    }

    public BigDecimal getCmpayamt_本月汇缴金额() {
        return cmpayamt_本月汇缴金额;
    }

    public void setCmpayamt_本月汇缴金额(BigDecimal cmpayamt_本月汇缴金额) {
        this.cmpayamt_本月汇缴金额 = cmpayamt_本月汇缴金额;
    }

    public Integer getPeoplenum_人数() {
        return peoplenum_人数;
    }

    public void setPeoplenum_人数(Integer peoplenum_人数) {
        this.peoplenum_人数 = peoplenum_人数;
    }

    public String getMonpayamt_月应缴金额() {
        return monpayamt_月应缴金额;
    }

    public void setMonpayamt_月应缴金额(String monpayamt_月应缴金额) {
        this.monpayamt_月应缴金额 = monpayamt_月应缴金额;
    }

    public BigDecimal getUpaytotamt_应缴总额() {
        return upaytotamt_应缴总额;
    }

    public void setUpaytotamt_应缴总额(BigDecimal upaytotamt_应缴总额) {
        this.upaytotamt_应缴总额 = upaytotamt_应缴总额;
    }

    public BigDecimal getFactpayamt_实际缴款金额() {
        return factpayamt_实际缴款金额;
    }

    public void setFactpayamt_实际缴款金额(BigDecimal factpayamt_实际缴款金额) {
        this.factpayamt_实际缴款金额 = factpayamt_实际缴款金额;
    }

    public BigDecimal getUprepayamt_预缴户转出金额() {
        return uprepayamt_预缴户转出金额;
    }

    public void setUprepayamt_预缴户转出金额(BigDecimal uprepayamt_预缴户转出金额) {
        this.uprepayamt_预缴户转出金额 = uprepayamt_预缴户转出金额;
    }

    public String getUprepayinamt_预缴户转入金额() {
        return uprepayinamt_预缴户转入金额;
    }

    public void setUprepayinamt_预缴户转入金额(String uprepayinamt_预缴户转入金额) {
        this.uprepayinamt_预缴户转入金额 = uprepayinamt_预缴户转入金额;
    }

    public String getInaccstate_入账状态() {
        return inaccstate_入账状态;
    }

    public void setInaccstate_入账状态(String inaccstate_入账状态) {
        this.inaccstate_入账状态 = inaccstate_入账状态;
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

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
