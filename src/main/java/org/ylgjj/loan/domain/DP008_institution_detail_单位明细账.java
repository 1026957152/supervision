package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "DP008")//归集子系统

public class DP008_institution_detail_单位明细账 {


/*
    unitcustid_单位客户号	0		0:不可为空	单位客户号
    subcode	0		0:不可为空	科目控制字
    entrytranscode	0		1:可为空	分录交易码



    peoplenum_人数	0		0:不可为空	人数
    dcflag_借贷标志		1-借,2-贷	0:不可为空	借贷标志
    amt_发生额	0		0:不可为空	发生额
    lbal_上笔余额	0		0:不可为空	上笔余额
    bal_余额	0		0:不可为空	余额
    summarycode			0:不可为空	摘要代码
    remark			1:可为空	备注
    transtype_交易类型		0-正常,1-红字,2-蓝字,6-撤销,7-当日冲正,8-冲账,9-抹账	0:不可为空	交易类型
    vounum_业务凭证号	0		1:可为空	业务凭证号
    timestamp_时间戳	0		0:不可为空	时间戳
    hostsernum	0		0:不可为空	主机流水号
    corrdate	0		0:不可为空	冲正日期
    corrsernum	0		0:不可为空	冲正流水号*/


    @Id

    @Column(name = "seqno")
    private Integer seqno_序号;


    @Column(name = "transdate")
    private LocalDate transdate不可为空交易日期;


    @Column(name = "unitaccnum")
    private String unitaccnum单位账号;


    @Column(name = "unitcustid")
    private String unitcustid_单位客户号;


    @Column(name = "subcode")
    private String subcode;


    @Column(name = "entrytranscode")
    private String entrytranscode;


    @Column(name = "begym")
    private String begym_开始年月;

    @Column(name = "endym")
    private String endym_截止年月;


    @Column(name = "peoplenum")
    private Integer peoplenum_人数;

    @Column(name = "dcflag")
    private String dcflag_借贷标志;






    @Column(name = "amt")
    private BigDecimal amt_发生额;



    @Column(name = "lbal")
    private BigDecimal lbal_上笔余额;

    @Column(name = "bal")
    private BigDecimal bal_余额;

    @Column(name = "summarycode")
    private String summarycode;

    @Column(name = "remark")
    private String remark;

    @Column(name = "transtype")
    private String transtype_交易类型;


    @Column(name = "vounum")
    private String vounum_业务凭证号;

    @Column(name = "timestamp")
    private String timestamp_时间戳;


    public Integer getSeqno_序号() {
        return seqno_序号;
    }

    public void setSeqno_序号(Integer seqno_序号) {
        this.seqno_序号 = seqno_序号;
    }

    public LocalDate getTransdate不可为空交易日期() {
        return transdate不可为空交易日期;
    }

    public void setTransdate不可为空交易日期(LocalDate transdate不可为空交易日期) {
        this.transdate不可为空交易日期 = transdate不可为空交易日期;
    }

    public String getUnitaccnum单位账号() {
        return unitaccnum单位账号;
    }

    public void setUnitaccnum单位账号(String unitaccnum单位账号) {
        this.unitaccnum单位账号 = unitaccnum单位账号;
    }

    public String getUnitcustid_单位客户号() {
        return unitcustid_单位客户号;
    }

    public void setUnitcustid_单位客户号(String unitcustid_单位客户号) {
        this.unitcustid_单位客户号 = unitcustid_单位客户号;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    public String getEntrytranscode() {
        return entrytranscode;
    }

    public void setEntrytranscode(String entrytranscode) {
        this.entrytranscode = entrytranscode;
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

    public Integer getPeoplenum_人数() {
        return peoplenum_人数;
    }

    public void setPeoplenum_人数(Integer peoplenum_人数) {
        this.peoplenum_人数 = peoplenum_人数;
    }

    public String getDcflag_借贷标志() {
        return dcflag_借贷标志;
    }

    public void setDcflag_借贷标志(String dcflag_借贷标志) {
        this.dcflag_借贷标志 = dcflag_借贷标志;
    }

    public BigDecimal getAmt_发生额() {
        return amt_发生额;
    }

    public void setAmt_发生额(BigDecimal amt_发生额) {
        this.amt_发生额 = amt_发生额;
    }

    public BigDecimal getLbal_上笔余额() {
        return lbal_上笔余额;
    }

    public void setLbal_上笔余额(BigDecimal lbal_上笔余额) {
        this.lbal_上笔余额 = lbal_上笔余额;
    }

    public BigDecimal getBal_余额() {
        return bal_余额;
    }

    public void setBal_余额(BigDecimal bal_余额) {
        this.bal_余额 = bal_余额;
    }

    public String getSummarycode() {
        return summarycode;
    }

    public void setSummarycode(String summarycode) {
        this.summarycode = summarycode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTranstype_交易类型() {
        return transtype_交易类型;
    }

    public void setTranstype_交易类型(String transtype_交易类型) {
        this.transtype_交易类型 = transtype_交易类型;
    }

    public String getVounum_业务凭证号() {
        return vounum_业务凭证号;
    }

    public void setVounum_业务凭证号(String vounum_业务凭证号) {
        this.vounum_业务凭证号 = vounum_业务凭证号;
    }

    public String getTimestamp_时间戳() {
        return timestamp_时间戳;
    }

    public void setTimestamp_时间戳(String timestamp_时间戳) {
        this.timestamp_时间戳 = timestamp_时间戳;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
