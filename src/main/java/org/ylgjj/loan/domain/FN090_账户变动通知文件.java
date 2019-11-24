package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
//@IdClass(FN090_key.class)
@Entity
@Table(name = "Fn090")

public class FN090_账户变动通知文件 {
   // transdate,bankhostsernum,bankaccnum




//    @Id
    @Column(name = "transdate")
    private LocalDate transdate不可为空写入日期;//


    @Id
    @Column(name = "bankhostsernum")
    private String bankhostsernum不可为空银行主机流水号;//


  //  @Id
    @Column(name = "amt")
    private double 	amt__不可为空__金额;//

//    @Id
@Column(name = "bankaccnum")
    private String bankaccnum不可为空账号;//

    public LocalDate getTransdate不可为空写入日期() {
        return transdate不可为空写入日期;
    }

    public void setTransdate不可为空写入日期(LocalDate transdate不可为空写入日期) {
        this.transdate不可为空写入日期 = transdate不可为空写入日期;
    }

    public String getBankhostsernum不可为空银行主机流水号() {
        return bankhostsernum不可为空银行主机流水号;
    }

    public void setBankhostsernum不可为空银行主机流水号(String bankhostsernum不可为空银行主机流水号) {
        this.bankhostsernum不可为空银行主机流水号 = bankhostsernum不可为空银行主机流水号;
    }

    public double getAmt__不可为空__金额() {
        return amt__不可为空__金额;
    }

    public void setAmt__不可为空__金额(double amt__不可为空__金额) {
        this.amt__不可为空__金额 = amt__不可为空__金额;
    }

    public String getBankaccnum不可为空账号() {
        return bankaccnum不可为空账号;
    }

    public void setBankaccnum不可为空账号(String bankaccnum不可为空账号) {
        this.bankaccnum不可为空账号 = bankaccnum不可为空账号;
    }


    @Column(name = "seqno")
    private String 	seqno__不可为空__序号;//
    @Column(name = "opbankaccnum")
    private String 	opbankaccnum__可为空__对方银行账号;//
    @Column(name = "opbankaccname")
    private String 	opbankaccname__可为空__对方账户名;//

    @Column(name = "trandate")
    private String 	trandate__不可为空__交易日期;//
    @Column(name = "time")
    private String 	time__可为空__交易时间;//
    @Column(name = "sumamt")
    private String 	sumamt__可为空__可用金额;//
    @Column(name = "orgcode")
    private String 	orgcode__可为空__开户机构号;//
    @Column(name = "remark")
    private String 	remark__可为空__备注;//
    @Column(name = "currno")
    private String 	currno__可为空__币种;//
    @Column(name = "curriden")
    private String 	curriden__可为空__钞汇;//	1-钞；2-汇
    @Column(name = "currbal")
    private double 	currbal__不可为空__余额;//
    @Column(name = "bal")
    private String 	bal__可为空__可透支余额;//
    @Column(name = "vouclass")
    private String 	vouclass__可为空__凭证种类;//
    @Column(name = "vounum")
    private String 	vounum__可为空__凭证号码;//
    @Column(name = "depoaccnum")
    private String 	depoaccnum__可为空__交易对手行号;//
    @Column(name = "summary")
    private String 	summary__可为空__摘要;//
    @Column(name = "state")
    private String 	state__可为空__冲正标识;//	Y-冲正,N-未冲正
    @Column(name = "volseqnum")
    private String 	volseqnum__可为空__笔号;//
    @Column(name = "volnum")
    private String 	volnum__可为空__册号;//
    @Column(name = "transcode")
    private String 	transcode__可为空__交易代码;//
    @Column(name = "freeuse1")
    private String 	freeuse1__可为空__备用字符;//
    @Column(name = "freeuse2")
    private String 	freeuse2__可为空__备用金额;//
    @Column(name = "freeuse3")
    private String 	freeuse3__可为空__备用日期;//
    @Column(name = "freeuse4")
    private String 	freeuse4__可为空__备用数值;//

    public String getSeqno__不可为空__序号() {
        return seqno__不可为空__序号;
    }

    public void setSeqno__不可为空__序号(String seqno__不可为空__序号) {
        this.seqno__不可为空__序号 = seqno__不可为空__序号;
    }

    public String getOpbankaccnum__可为空__对方银行账号() {
        return opbankaccnum__可为空__对方银行账号;
    }

    public void setOpbankaccnum__可为空__对方银行账号(String opbankaccnum__可为空__对方银行账号) {
        this.opbankaccnum__可为空__对方银行账号 = opbankaccnum__可为空__对方银行账号;
    }

    public String getOpbankaccname__可为空__对方账户名() {
        return opbankaccname__可为空__对方账户名;
    }

    public void setOpbankaccname__可为空__对方账户名(String opbankaccname__可为空__对方账户名) {
        this.opbankaccname__可为空__对方账户名 = opbankaccname__可为空__对方账户名;
    }

    public String getTrandate__不可为空__交易日期() {
        return trandate__不可为空__交易日期;
    }

    public void setTrandate__不可为空__交易日期(String trandate__不可为空__交易日期) {
        this.trandate__不可为空__交易日期 = trandate__不可为空__交易日期;
    }

    public String getTime__可为空__交易时间() {
        return time__可为空__交易时间;
    }

    public void setTime__可为空__交易时间(String time__可为空__交易时间) {
        this.time__可为空__交易时间 = time__可为空__交易时间;
    }

    public String getSumamt__可为空__可用金额() {
        return sumamt__可为空__可用金额;
    }

    public void setSumamt__可为空__可用金额(String sumamt__可为空__可用金额) {
        this.sumamt__可为空__可用金额 = sumamt__可为空__可用金额;
    }

    public String getOrgcode__可为空__开户机构号() {
        return orgcode__可为空__开户机构号;
    }

    public void setOrgcode__可为空__开户机构号(String orgcode__可为空__开户机构号) {
        this.orgcode__可为空__开户机构号 = orgcode__可为空__开户机构号;
    }

    public String getRemark__可为空__备注() {
        return remark__可为空__备注;
    }

    public void setRemark__可为空__备注(String remark__可为空__备注) {
        this.remark__可为空__备注 = remark__可为空__备注;
    }

    public String getCurrno__可为空__币种() {
        return currno__可为空__币种;
    }

    public void setCurrno__可为空__币种(String currno__可为空__币种) {
        this.currno__可为空__币种 = currno__可为空__币种;
    }

    public String getCurriden__可为空__钞汇() {
        return curriden__可为空__钞汇;
    }

    public void setCurriden__可为空__钞汇(String curriden__可为空__钞汇) {
        this.curriden__可为空__钞汇 = curriden__可为空__钞汇;
    }

    public double getCurrbal__不可为空__余额() {
        return currbal__不可为空__余额;
    }

    public void setCurrbal__不可为空__余额(double currbal__不可为空__余额) {
        this.currbal__不可为空__余额 = currbal__不可为空__余额;
    }

    public String getBal__可为空__可透支余额() {
        return bal__可为空__可透支余额;
    }

    public void setBal__可为空__可透支余额(String bal__可为空__可透支余额) {
        this.bal__可为空__可透支余额 = bal__可为空__可透支余额;
    }

    public String getVouclass__可为空__凭证种类() {
        return vouclass__可为空__凭证种类;
    }

    public void setVouclass__可为空__凭证种类(String vouclass__可为空__凭证种类) {
        this.vouclass__可为空__凭证种类 = vouclass__可为空__凭证种类;
    }

    public String getVounum__可为空__凭证号码() {
        return vounum__可为空__凭证号码;
    }

    public void setVounum__可为空__凭证号码(String vounum__可为空__凭证号码) {
        this.vounum__可为空__凭证号码 = vounum__可为空__凭证号码;
    }

    public String getDepoaccnum__可为空__交易对手行号() {
        return depoaccnum__可为空__交易对手行号;
    }

    public void setDepoaccnum__可为空__交易对手行号(String depoaccnum__可为空__交易对手行号) {
        this.depoaccnum__可为空__交易对手行号 = depoaccnum__可为空__交易对手行号;
    }

    public String getSummary__可为空__摘要() {
        return summary__可为空__摘要;
    }

    public void setSummary__可为空__摘要(String summary__可为空__摘要) {
        this.summary__可为空__摘要 = summary__可为空__摘要;
    }

    public String getState__可为空__冲正标识() {
        return state__可为空__冲正标识;
    }

    public void setState__可为空__冲正标识(String state__可为空__冲正标识) {
        this.state__可为空__冲正标识 = state__可为空__冲正标识;
    }

    public String getVolseqnum__可为空__笔号() {
        return volseqnum__可为空__笔号;
    }

    public void setVolseqnum__可为空__笔号(String volseqnum__可为空__笔号) {
        this.volseqnum__可为空__笔号 = volseqnum__可为空__笔号;
    }

    public String getVolnum__可为空__册号() {
        return volnum__可为空__册号;
    }

    public void setVolnum__可为空__册号(String volnum__可为空__册号) {
        this.volnum__可为空__册号 = volnum__可为空__册号;
    }

    public String getTranscode__可为空__交易代码() {
        return transcode__可为空__交易代码;
    }

    public void setTranscode__可为空__交易代码(String transcode__可为空__交易代码) {
        this.transcode__可为空__交易代码 = transcode__可为空__交易代码;
    }

    public String getFreeuse1__可为空__备用字符() {
        return freeuse1__可为空__备用字符;
    }

    public void setFreeuse1__可为空__备用字符(String freeuse1__可为空__备用字符) {
        this.freeuse1__可为空__备用字符 = freeuse1__可为空__备用字符;
    }

    public String getFreeuse2__可为空__备用金额() {
        return freeuse2__可为空__备用金额;
    }

    public void setFreeuse2__可为空__备用金额(String freeuse2__可为空__备用金额) {
        this.freeuse2__可为空__备用金额 = freeuse2__可为空__备用金额;
    }

    public String getFreeuse3__可为空__备用日期() {
        return freeuse3__可为空__备用日期;
    }

    public void setFreeuse3__可为空__备用日期(String freeuse3__可为空__备用日期) {
        this.freeuse3__可为空__备用日期 = freeuse3__可为空__备用日期;
    }

    public String getFreeuse4__可为空__备用数值() {
        return freeuse4__可为空__备用数值;
    }

    public void setFreeuse4__可为空__备用数值(String freeuse4__可为空__备用数值) {
        this.freeuse4__可为空__备用数值 = freeuse4__可为空__备用数值;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
