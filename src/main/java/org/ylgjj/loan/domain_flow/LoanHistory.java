package org.ylgjj.loan.domain_flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "Loan_History")

public class LoanHistory extends BaseDomain{

    @Column(name = "no")
    private String no;

    @Column(name = "date")
    private LocalDate date;

    private String index机构编码;
    private String index银行名称;

    private Integer index贷款申请年限;
    private String index还款方式;
    private String index担保方式;
    private String index贷款用途;
    private String index房屋类型;
    private String index购房面积;
    private String index单位性质;
    private Integer index开户年限;
    private Integer index贷款次数;
    private Integer index贷款时缴存年限;
    private String index缴存状态;
    private String index收入水平;
    private Double index贷款金额与房屋价格占比;
    private String index经济类型;



    private long value贷款笔数;
    private double value贷款金额;
    private String index提取原因;
    private String indexNo;
    private Long intValue;
    private double doubleValue;
    private String index资金来源;
    private Integer index逾期次数;
    private Double index缴存基数;
    private double index实归集额;
    private Double index月缴存额;
    private Long seqNum;

    public LoanHistory(LocalDate n) {
        this.date = n;
    }
    public LoanHistory(LocalDate n,StatisticalIndexCodeEnum index) {
        this.date = n;
        indexNo = index.get指标编码();
    }

    public LoanHistory() {
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public void setIndex机构编码(String index机构编码) {
        this.index机构编码 = index机构编码;
    }

    public String getIndex机构编码() {
        return index机构编码;
    }

    public void setIndex银行名称(String index银行名称) {
        this.index银行名称 = index银行名称;
    }

    public String getIndex银行名称() {
        return index银行名称;
    }

    public void setValue贷款笔数(long value贷款笔数) {
        this.value贷款笔数 = value贷款笔数;
    }

    public long getValue贷款笔数() {
        return value贷款笔数;
    }

    public void setValue贷款金额(double value贷款金额) {
        this.value贷款金额 = value贷款金额;
    }

    public double getValue贷款金额() {
        return value贷款金额;
    }

    public void setIndex贷款申请年限(Integer index贷款申请年限) {
        this.index贷款申请年限 = index贷款申请年限;
    }

    public Integer getIndex贷款申请年限() {
        return index贷款申请年限;
    }

    public void setIndex还款方式(String index还款方式) {
        this.index还款方式 = index还款方式;
    }

    public String getIndex还款方式() {
        return index还款方式;
    }

    public void setIndex担保方式(String index担保方式) {
        this.index担保方式 = index担保方式;
    }

    public String getIndex担保方式() {
        return index担保方式;
    }

    public void setIndex贷款用途(String index贷款用途) {
        this.index贷款用途 = index贷款用途;
    }

    public String getIndex贷款用途() {
        return index贷款用途;
    }

    public void setIndex房屋类型(String index房屋类型) {
        this.index房屋类型 = index房屋类型;
    }

    public String getIndex房屋类型() {
        return index房屋类型;
    }

    public void setIndex购房面积(String index购房面积) {
        this.index购房面积 = index购房面积;
    }

    public String getIndex购房面积() {
        return index购房面积;
    }

    public void setIndex单位性质(String index单位性质) {
        this.index单位性质 = index单位性质;
    }

    public String getIndex单位性质() {
        return index单位性质;
    }

    public void setIndex开户年限(Integer index开户年限) {
        this.index开户年限 = index开户年限;
    }

    public Integer getIndex开户年限() {
        return index开户年限;
    }

    public void setIndex贷款次数(Integer index贷款次数) {
        this.index贷款次数 = index贷款次数;
    }

    public Integer getIndex贷款次数() {
        return index贷款次数;
    }

    public void setIndex贷款时缴存年限(Integer index贷款时缴存年限) {
        this.index贷款时缴存年限 = index贷款时缴存年限;
    }

    public Integer getIndex贷款时缴存年限() {
        return index贷款时缴存年限;
    }

    public void setIndex缴存状态(String index缴存状态) {
        this.index缴存状态 = index缴存状态;
    }

    public String getIndex缴存状态() {
        return index缴存状态;
    }

    public void setIndex收入水平(String index收入水平) {
        this.index收入水平 = index收入水平;
    }

    public String getIndex收入水平() {
        return index收入水平;
    }

    public void setIndex贷款金额与房屋价格占比(Double index贷款金额与房屋价格占比) {
        this.index贷款金额与房屋价格占比 = index贷款金额与房屋价格占比;
    }

    public Double getIndex贷款金额与房屋价格占比() {
        return index贷款金额与房屋价格占比;
    }

    public void setIndex经济类型(String index经济类型) {
        this.index经济类型 = index经济类型;
    }

    public String getIndex经济类型() {
        return index经济类型;
    }

    public void setIndex提取原因(String index提取原因) {

        this.index提取原因 = index提取原因;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getIndex提取原因() {
        return index提取原因;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIntValue(long intValue) {
        this.intValue = intValue;
    }

    public Long getIntValue() {
        return intValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setIndex资金来源(String index资金来源) {
        this.index资金来源 = index资金来源;
    }

    public String getIndex资金来源() {
        return index资金来源;
    }

    public void setIndex逾期次数(Integer index逾期次数) {
        this.index逾期次数 = index逾期次数;
    }

    public Integer getIndex逾期次数() {
        return index逾期次数;
    }

    public void setIndex缴存基数(Double index缴存基数) {
        this.index缴存基数 = index缴存基数;
    }

    public Double getIndex缴存基数() {
        return index缴存基数;
    }

    public void setIndex实归集额(double index实归集额) {
        this.index实归集额 = index实归集额;
    }

    public double getIndex实归集额() {
        return index实归集额;
    }

    public void setIndex月缴存额(Double index月缴存额) {

        this.index月缴存额 = index月缴存额;
    }

    public Double getIndex月缴存额() {
        return index月缴存额;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }

    public Long getSeqNum() {
        return seqNum;
    }
}
