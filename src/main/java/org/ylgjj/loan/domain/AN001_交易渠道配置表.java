package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(AN001_key.class)
@Entity
@Table(name = "AN001")

public class AN001_交易渠道配置表 {
    @Id
    @Column(name = "settletranscode")
    private String settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;



    @Id
    @Column(name = "outranscode")
    private String outranscode_不可为空_外部交易码;
    @Id
    @Column(name = "centerid")
    private String centerid_不可为空_城市代码;



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

    @Column(name = "TIMEOUT")
    private String TIMEOUT_不可为空_超时时间; //以秒来计算		0:

    @Column(name = "ENCFLAG")
    private String ENCFLAG_可为空_加密标志; //1-加密,0-解密	1:

    @Column(name = "SERIFLAG")
    private String SERIFLAG_可为空_序列化报文标志; //1-是,0-否	1:可为空

    @Column(name = "HEADTAG")
    private String HEADTAG_可为空_报文头标签;

    @Column(name = "BODYTAG")
    private String BODYTAG_可为空_报文体标签;

    @Column(name = "DETAILTAG")
    private String DETAILTAG_可为空_明细标签;
    @Column(name = "ROOTTAG")
    private String ROOTTAG_可为空_根标签;




    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public String getSettletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码() {
        return settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;
    }

    public void setSettletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码(String settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码) {
        this.settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码 = settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;
    }

    public String getOutranscode_不可为空_外部交易码() {
        return outranscode_不可为空_外部交易码;
    }

    public void setOutranscode_不可为空_外部交易码(String outranscode_不可为空_外部交易码) {
        this.outranscode_不可为空_外部交易码 = outranscode_不可为空_外部交易码;
    }

    public String getCenterid_不可为空_城市代码() {
        return centerid_不可为空_城市代码;
    }

    public void setCenterid_不可为空_城市代码(String centerid_不可为空_城市代码) {
        this.centerid_不可为空_城市代码 = centerid_不可为空_城市代码;
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

    public String getTIMEOUT_不可为空_超时时间() {
        return TIMEOUT_不可为空_超时时间;
    }

    public void setTIMEOUT_不可为空_超时时间(String TIMEOUT_不可为空_超时时间) {
        this.TIMEOUT_不可为空_超时时间 = TIMEOUT_不可为空_超时时间;
    }

    public String getENCFLAG_可为空_加密标志() {
        return ENCFLAG_可为空_加密标志;
    }

    public void setENCFLAG_可为空_加密标志(String ENCFLAG_可为空_加密标志) {
        this.ENCFLAG_可为空_加密标志 = ENCFLAG_可为空_加密标志;
    }

    public String getSERIFLAG_可为空_序列化报文标志() {
        return SERIFLAG_可为空_序列化报文标志;
    }

    public void setSERIFLAG_可为空_序列化报文标志(String SERIFLAG_可为空_序列化报文标志) {
        this.SERIFLAG_可为空_序列化报文标志 = SERIFLAG_可为空_序列化报文标志;
    }

    public String getHEADTAG_可为空_报文头标签() {
        return HEADTAG_可为空_报文头标签;
    }

    public void setHEADTAG_可为空_报文头标签(String HEADTAG_可为空_报文头标签) {
        this.HEADTAG_可为空_报文头标签 = HEADTAG_可为空_报文头标签;
    }

    public String getBODYTAG_可为空_报文体标签() {
        return BODYTAG_可为空_报文体标签;
    }

    public void setBODYTAG_可为空_报文体标签(String BODYTAG_可为空_报文体标签) {
        this.BODYTAG_可为空_报文体标签 = BODYTAG_可为空_报文体标签;
    }

    public String getDETAILTAG_可为空_明细标签() {
        return DETAILTAG_可为空_明细标签;
    }

    public void setDETAILTAG_可为空_明细标签(String DETAILTAG_可为空_明细标签) {
        this.DETAILTAG_可为空_明细标签 = DETAILTAG_可为空_明细标签;
    }

    public String getROOTTAG_可为空_根标签() {
        return ROOTTAG_可为空_根标签;
    }

    public void setROOTTAG_可为空_根标签(String ROOTTAG_可为空_根标签) {
        this.ROOTTAG_可为空_根标签 = ROOTTAG_可为空_根标签;
    }
}
