package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "LN014")

public class LN0014_Trading_house_贷款房屋信息 {



    @Id
    @Column(name = "loancontrcode")
    private String loancontrcode0合同代码;


    @Column(name = "protonum")

    private String protonum_0_项目协议号;
    @Column(name = "buyhousetype")

    private String buyhousetype_0_购房类型;

    @Column(name = "houseright")

    private String houseright_0_房屋产权性质;

    @Column(name = "housetype")

    private String housetype_0_房屋类型;



    private String housestruct;
    @Column(name = "houseaddr")
    private String houseaddr_1_房屋坐落;

    @Column(name = "straddr")

    private String straddr_1_行政街号地址;
    
    private BigDecimal buyhousearea;
    private BigDecimal tnhousearea;

    @Column(name = "sfhousemoney")

    private BigDecimal sfhousemoney_0_首付款;
    @Column(name = "buyhoudate")

    private Date buyhoudate_0_购房日期;
    @Column(name = "buyhouseamt")


    private BigDecimal buyhouseamt_0_购房房款总额_成交价;
    @Column(name = "evalvalue")

    private BigDecimal evalvalue_1_房屋评估价值;
    private Date secfinishdate;
    private Date ceroutdate;
    private String seller;
    private Integer loanhousenum;


    private String cerrightnum;
    private String saleslicensenum;
    private String housecontrnum;
    private Date deliverdate;
    private String landrightnum;

    private Date landdate;


    public String getLoancontrcode0合同代码() {
        return loancontrcode0合同代码;
    }

    public void setLoancontrcode0合同代码(String loancontrcode0合同代码) {
        this.loancontrcode0合同代码 = loancontrcode0合同代码;
    }

    public String getProtonum_0_项目协议号() {
        return protonum_0_项目协议号;
    }

    public void setProtonum_0_项目协议号(String protonum_0_项目协议号) {
        this.protonum_0_项目协议号 = protonum_0_项目协议号;
    }

    public String getBuyhousetype_0_购房类型() {
        return buyhousetype_0_购房类型;
    }

    public void setBuyhousetype_0_购房类型(String buyhousetype_0_购房类型) {
        this.buyhousetype_0_购房类型 = buyhousetype_0_购房类型;
    }

    public String getHouseright_0_房屋产权性质() {
        return houseright_0_房屋产权性质;
    }

    public void setHouseright_0_房屋产权性质(String houseright_0_房屋产权性质) {
        this.houseright_0_房屋产权性质 = houseright_0_房屋产权性质;
    }

    public String getHousetype_0_房屋类型() {
        return housetype_0_房屋类型;
    }

    public void setHousetype_0_房屋类型(String housetype_0_房屋类型) {
        this.housetype_0_房屋类型 = housetype_0_房屋类型;
    }

    public String getHousestruct() {
        return housestruct;
    }

    public void setHousestruct(String housestruct) {
        this.housestruct = housestruct;
    }

    public String getHouseaddr_1_房屋坐落() {
        return houseaddr_1_房屋坐落;
    }

    public void setHouseaddr_1_房屋坐落(String houseaddr_1_房屋坐落) {
        this.houseaddr_1_房屋坐落 = houseaddr_1_房屋坐落;
    }

    public String getStraddr_1_行政街号地址() {
        return straddr_1_行政街号地址;
    }

    public void setStraddr_1_行政街号地址(String straddr_1_行政街号地址) {
        this.straddr_1_行政街号地址 = straddr_1_行政街号地址;
    }

    public BigDecimal getBuyhousearea() {
        return buyhousearea;
    }

    public void setBuyhousearea(BigDecimal buyhousearea) {
        this.buyhousearea = buyhousearea;
    }

    public BigDecimal getTnhousearea() {
        return tnhousearea;
    }

    public void setTnhousearea(BigDecimal tnhousearea) {
        this.tnhousearea = tnhousearea;
    }

    public BigDecimal getSfhousemoney_0_首付款() {
        return sfhousemoney_0_首付款;
    }

    public void setSfhousemoney_0_首付款(BigDecimal sfhousemoney_0_首付款) {
        this.sfhousemoney_0_首付款 = sfhousemoney_0_首付款;
    }

    public Date getBuyhoudate_0_购房日期() {
        return buyhoudate_0_购房日期;
    }

    public void setBuyhoudate_0_购房日期(Date buyhoudate_0_购房日期) {
        this.buyhoudate_0_购房日期 = buyhoudate_0_购房日期;
    }

    public BigDecimal getBuyhouseamt_0_购房房款总额_成交价() {
        return buyhouseamt_0_购房房款总额_成交价;
    }

    public void setBuyhouseamt_0_购房房款总额_成交价(BigDecimal buyhouseamt_0_购房房款总额_成交价) {
        this.buyhouseamt_0_购房房款总额_成交价 = buyhouseamt_0_购房房款总额_成交价;
    }

    public BigDecimal getEvalvalue_1_房屋评估价值() {
        return evalvalue_1_房屋评估价值;
    }

    public void setEvalvalue_1_房屋评估价值(BigDecimal evalvalue_1_房屋评估价值) {
        this.evalvalue_1_房屋评估价值 = evalvalue_1_房屋评估价值;
    }

    public Date getSecfinishdate() {
        return secfinishdate;
    }

    public void setSecfinishdate(Date secfinishdate) {
        this.secfinishdate = secfinishdate;
    }

    public Date getCeroutdate() {
        return ceroutdate;
    }

    public void setCeroutdate(Date ceroutdate) {
        this.ceroutdate = ceroutdate;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getLoanhousenum() {
        return loanhousenum;
    }

    public void setLoanhousenum(Integer loanhousenum) {
        this.loanhousenum = loanhousenum;
    }

    public String getCerrightnum() {
        return cerrightnum;
    }

    public void setCerrightnum(String cerrightnum) {
        this.cerrightnum = cerrightnum;
    }

    public String getSaleslicensenum() {
        return saleslicensenum;
    }

    public void setSaleslicensenum(String saleslicensenum) {
        this.saleslicensenum = saleslicensenum;
    }

    public String getHousecontrnum() {
        return housecontrnum;
    }

    public void setHousecontrnum(String housecontrnum) {
        this.housecontrnum = housecontrnum;
    }

    public Date getDeliverdate() {
        return deliverdate;
    }

    public void setDeliverdate(Date deliverdate) {
        this.deliverdate = deliverdate;
    }

    public String getLandrightnum() {
        return landrightnum;
    }

    public void setLandrightnum(String landrightnum) {
        this.landrightnum = landrightnum;
    }

    public Date getLanddate() {
        return landdate;
    }

    public void setLanddate(Date landdate) {
        this.landdate = landdate;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;







}
