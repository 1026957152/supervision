package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */
@IdClass(FD045_key.class)
@Entity
@Table(name = "FD045")

public class FD045_资金划转业务登记文件 {
    @Id
    @Column(name = "CENTERID")
    private String CENTERID_不可为空_城市中心代码;



    @Id
    @Column(name = "TRANSDATE")
    private LocalDate TRANSDATE不可为空交易日期;
    @Id
    @Column(name = "HOSTSERNUM")
    private String HOSTSERNUM_不可为空_主机流水号;











    @Column(name = "TRSOUTINST")
    private String TRSOUTINST_不可为空_转出机构;



    @Column(name = "TRSOUTBANK")
    private String TRSOUTBANK_不可为空_转出银行;

    @Column(name = "TRSOUTFUNDKIND")
    private String TRSOUTFUNDKIND_不可为空_转出资金性质; //01-住房公积金存款,02-增值收益存款	0:不可为空	转出资金性质





    @Column(name = "TRSOUTBANKACC")
    private String TRSOUTBANKACC_不可为空_转出银行账户;

    @Column(name = "TRSININST")
    private String TRSININST_不可为空_转入机构;









    @Column(name = "TRSINBANK")
    private String TRSINBANK_不可为空_转入银行;



/*    @Column(name = "BANKACCNUM")
    private String BANKACCNUM_不可为空_银行账号;*/

    @Column(name = "TRSINFUNDKIND")
    private String TRSINFUNDKIND_不可为空_转入资金性质1; //-住房公积金存款(归集户),2-增值收益存款(收益户)	0:不可为空
    @Column(name = "TRSINBANKACC")
    private String TRSINBANKACC_不可为空_转入银行账户;




    @Column(name = "REGSTATE")
    private String REGSTATE_不可为空_登记状态 ;// 0-正常,9-作废	0:






    @Column(name = "TRANSFERAMT")
    private double TRANSFERAMT不可为空划转金额;


    @Column(name = "TRANSFERREASON")
    private String TRANSFERREASON_可为空_划转原因;

    @Column(name = "AGENTINSTCODE")
    private String AGENTINSTCODE_可为空_经办机构; //0=正常,7=冲账,8=被冲,9=无效	0:不可为空
    @Column(name = "AGENTOP")
    private String AGENTOP_可为空_经办柜员; //公共码表,用于区分归集、个贷等


    public String getCENTERID_不可为空_城市中心代码() {
        return CENTERID_不可为空_城市中心代码;
    }

    public void setCENTERID_不可为空_城市中心代码(String CENTERID_不可为空_城市中心代码) {
        this.CENTERID_不可为空_城市中心代码 = CENTERID_不可为空_城市中心代码;
    }

    public LocalDate getTRANSDATE不可为空交易日期() {
        return TRANSDATE不可为空交易日期;
    }

    public void setTRANSDATE不可为空交易日期(LocalDate TRANSDATE不可为空交易日期) {
        this.TRANSDATE不可为空交易日期 = TRANSDATE不可为空交易日期;
    }

    public String getHOSTSERNUM_不可为空_主机流水号() {
        return HOSTSERNUM_不可为空_主机流水号;
    }

    public void setHOSTSERNUM_不可为空_主机流水号(String HOSTSERNUM_不可为空_主机流水号) {
        this.HOSTSERNUM_不可为空_主机流水号 = HOSTSERNUM_不可为空_主机流水号;
    }

    public String getTRSOUTINST_不可为空_转出机构() {
        return TRSOUTINST_不可为空_转出机构;
    }

    public void setTRSOUTINST_不可为空_转出机构(String TRSOUTINST_不可为空_转出机构) {
        this.TRSOUTINST_不可为空_转出机构 = TRSOUTINST_不可为空_转出机构;
    }

    public String getTRSOUTBANK_不可为空_转出银行() {
        return TRSOUTBANK_不可为空_转出银行;
    }

    public void setTRSOUTBANK_不可为空_转出银行(String TRSOUTBANK_不可为空_转出银行) {
        this.TRSOUTBANK_不可为空_转出银行 = TRSOUTBANK_不可为空_转出银行;
    }

    public String getTRSOUTFUNDKIND_不可为空_转出资金性质() {
        return TRSOUTFUNDKIND_不可为空_转出资金性质;
    }

    public void setTRSOUTFUNDKIND_不可为空_转出资金性质(String TRSOUTFUNDKIND_不可为空_转出资金性质) {
        this.TRSOUTFUNDKIND_不可为空_转出资金性质 = TRSOUTFUNDKIND_不可为空_转出资金性质;
    }

    public String getTRSOUTBANKACC_不可为空_转出银行账户() {
        return TRSOUTBANKACC_不可为空_转出银行账户;
    }

    public void setTRSOUTBANKACC_不可为空_转出银行账户(String TRSOUTBANKACC_不可为空_转出银行账户) {
        this.TRSOUTBANKACC_不可为空_转出银行账户 = TRSOUTBANKACC_不可为空_转出银行账户;
    }

    public String getTRSININST_不可为空_转入机构() {
        return TRSININST_不可为空_转入机构;
    }

    public void setTRSININST_不可为空_转入机构(String TRSININST_不可为空_转入机构) {
        this.TRSININST_不可为空_转入机构 = TRSININST_不可为空_转入机构;
    }

    public String getTRSINBANK_不可为空_转入银行() {
        return TRSINBANK_不可为空_转入银行;
    }

    public void setTRSINBANK_不可为空_转入银行(String TRSINBANK_不可为空_转入银行) {
        this.TRSINBANK_不可为空_转入银行 = TRSINBANK_不可为空_转入银行;
    }

/*
    public String getBANKACCNUM_不可为空_银行账号() {
        return BANKACCNUM_不可为空_银行账号;
    }

    public void setBANKACCNUM_不可为空_银行账号(String BANKACCNUM_不可为空_银行账号) {
        this.BANKACCNUM_不可为空_银行账号 = BANKACCNUM_不可为空_银行账号;
    }
*/

    public String getTRSINFUNDKIND_不可为空_转入资金性质1() {
        return TRSINFUNDKIND_不可为空_转入资金性质1;
    }

    public void setTRSINFUNDKIND_不可为空_转入资金性质1(String TRSINFUNDKIND_不可为空_转入资金性质1) {
        this.TRSINFUNDKIND_不可为空_转入资金性质1 = TRSINFUNDKIND_不可为空_转入资金性质1;
    }

    public String getTRSINBANKACC_不可为空_转入银行账户() {
        return TRSINBANKACC_不可为空_转入银行账户;
    }

    public void setTRSINBANKACC_不可为空_转入银行账户(String TRSINBANKACC_不可为空_转入银行账户) {
        this.TRSINBANKACC_不可为空_转入银行账户 = TRSINBANKACC_不可为空_转入银行账户;
    }

    public String getREGSTATE_不可为空_登记状态() {
        return REGSTATE_不可为空_登记状态;
    }

    public void setREGSTATE_不可为空_登记状态(String REGSTATE_不可为空_登记状态) {
        this.REGSTATE_不可为空_登记状态 = REGSTATE_不可为空_登记状态;
    }

    public double getTRANSFERAMT不可为空划转金额() {
        return TRANSFERAMT不可为空划转金额;
    }

    public void setTRANSFERAMT不可为空划转金额(double TRANSFERAMT不可为空划转金额) {
        this.TRANSFERAMT不可为空划转金额 = TRANSFERAMT不可为空划转金额;
    }

    public String getTRANSFERREASON_可为空_划转原因() {
        return TRANSFERREASON_可为空_划转原因;
    }

    public void setTRANSFERREASON_可为空_划转原因(String TRANSFERREASON_可为空_划转原因) {
        this.TRANSFERREASON_可为空_划转原因 = TRANSFERREASON_可为空_划转原因;
    }

    public String getAGENTINSTCODE_可为空_经办机构() {
        return AGENTINSTCODE_可为空_经办机构;
    }

    public void setAGENTINSTCODE_可为空_经办机构(String AGENTINSTCODE_可为空_经办机构) {
        this.AGENTINSTCODE_可为空_经办机构 = AGENTINSTCODE_可为空_经办机构;
    }

    public String getAGENTOP_可为空_经办柜员() {
        return AGENTOP_可为空_经办柜员;
    }

    public void setAGENTOP_可为空_经办柜员(String AGENTOP_可为空_经办柜员) {
        this.AGENTOP_可为空_经办柜员 = AGENTOP_可为空_经办柜员;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



    ;
}
