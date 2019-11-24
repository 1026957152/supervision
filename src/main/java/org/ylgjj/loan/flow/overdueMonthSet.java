package org.ylgjj.loan.flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.ylgjj.loan.domain.AN001_key;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "overdue")

public class overdueMonthSet extends BaseFlowDomain{

    @Column(name = "settletranscode")
    private String settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;






    @Column(name = "TRANSNAME")
    private String TRANSNAME_不可为空_交易名称;


    @Column(name = "CHANIP")
    private String CHANIP_不可为空_渠道IP;
    @Column(name = "CHANPORT")
    private String CHANPORT_不可为空_渠道端口;


    @Column(name = "CHANINFO")
    private String CHANINFO_不可为空_渠道描述地址;

    @Column(name = "CSPFLAG")
    private String CSPFLAG_可为空_CSP开关; //0-关,1-开	1:可为空

    @Column(name = "BATFLAG")
    private String BATFLAG_可为空_批量标志; //1-单笔,2-批量,0-其它	0:不可为空





    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



    ;

    public String getSettletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码() {
        return settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;
    }

    public void setSettletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码(String settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码) {
        this.settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码 = settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;
    }


    public String getTRANSNAME_不可为空_交易名称() {
        return TRANSNAME_不可为空_交易名称;
    }

    public void setTRANSNAME_不可为空_交易名称(String TRANSNAME_不可为空_交易名称) {
        this.TRANSNAME_不可为空_交易名称 = TRANSNAME_不可为空_交易名称;
    }

    public String getCHANIP_不可为空_渠道IP() {
        return CHANIP_不可为空_渠道IP;
    }

    public void setCHANIP_不可为空_渠道IP(String CHANIP_不可为空_渠道IP) {
        this.CHANIP_不可为空_渠道IP = CHANIP_不可为空_渠道IP;
    }

    public String getCHANPORT_不可为空_渠道端口() {
        return CHANPORT_不可为空_渠道端口;
    }

    public void setCHANPORT_不可为空_渠道端口(String CHANPORT_不可为空_渠道端口) {
        this.CHANPORT_不可为空_渠道端口 = CHANPORT_不可为空_渠道端口;
    }

    public String getCHANINFO_不可为空_渠道描述地址() {
        return CHANINFO_不可为空_渠道描述地址;
    }

    public void setCHANINFO_不可为空_渠道描述地址(String CHANINFO_不可为空_渠道描述地址) {
        this.CHANINFO_不可为空_渠道描述地址 = CHANINFO_不可为空_渠道描述地址;
    }

    public String getCSPFLAG_可为空_CSP开关() {
        return CSPFLAG_可为空_CSP开关;
    }

    public void setCSPFLAG_可为空_CSP开关(String CSPFLAG_可为空_CSP开关) {
        this.CSPFLAG_可为空_CSP开关 = CSPFLAG_可为空_CSP开关;
    }

    public String getBATFLAG_可为空_批量标志() {
        return BATFLAG_可为空_批量标志;
    }

    public void setBATFLAG_可为空_批量标志(String BATFLAG_可为空_批量标志) {
        this.BATFLAG_可为空_批量标志 = BATFLAG_可为空_批量标志;
    }

   }
