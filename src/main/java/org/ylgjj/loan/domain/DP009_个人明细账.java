package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by yuan zhao  on 08/10/2015.
 */


@Entity

@Table(name = "DP009")

public class DP009_个人明细账 {
    //DP095_PK_1	3:索引	accinstcode,accflag,calintdate


    @Id
    @Column(name = "seqno")
    private long seqno;

    private java.sql.Date transdate;
    private String accnum;
    private String unitaccnum;
    private String mergoaccnum;
    private String custid;
    private String accname;
    private String subcode;
    private String entrytranscode;
    private String begym;
    private String endym;
    private String dcflag;
    private double amt;
    private double keepamt;
    private double increamt;
    private double basenum;
    private double unitprop;
    private double unitastprop;
    private double indiprop;
    private double bal;
    private String summarycode;
    private String remark;
    private String transtype;
    private String vounum;
    private String timestamp;
    private long hostsernum;
    private java.sql.Date corrdate;
    private long corrsernum;
    private String allexchgflag;
    private String transchannel;
    private String agentinstcode;
    private String accinstcode;
    private String agentbankcode;
    private String accbankcode;
    private String agentop;
    private String centerid;
    private String freeuse1;
    private double freeuse2;
    private java.sql.Date freeuse3;
    private long freeuse4;


/*

seqno	0		0:不可为空	序号
transdate	0		0:不可为空	交易日期
accnum	0		0:不可为空	个人账号
unitaccnum	0		0:不可为空	单位账号
mergoaccnum	串联用		1:可为空	并出个人账号
custid	0		0:不可为空	个人客户号
accname	0		0:不可为空	姓名
subcode	0		1:可为空	科目控制字
entrytranscode	0		1:可为空	分录交易码
begym	0		1:可为空	开始年月
endym	0		1:可为空	截止年月
dcflag		1-借,2-贷	0:不可为空	借贷标志
amt	0		0:不可为空	发生额
keepamt			1:可为空	存量发生额
increamt			1:可为空	增量发生额
basenum	0		0:不可为空	缴存基数
unitprop	0		0:不可为空	单位比例
unitastprop	dp004.PROPTYPE为0时有值		0:不可为空	单位辅助比例
indiprop	0		0:不可为空	个人缴存比例
bal	0		0:不可为空	余额
summarycode			0:不可为空	摘要代码
remark	提取原因、缴存类型等		1:可为空	备注
transtype	同dp008		0:不可为空	交易类型
vounum	0		1:可为空	业务凭证号
timestamp	0		0:不可为空	时间戳
hostsernum	0		0:不可为空	主机流水号
corrdate	0		0:不可为空	冲正日期
corrsernum	0		0:不可为空	冲正流水号
allexchgflag		0-通兑,1-非通兑	0:不可为空	通兑标志
transchannel			0:不可为空	交易渠道
agentinstcode	0		0:不可为空	经办机构
accinstcode	0		0:不可为空	账户机构
agentbankcode	0		0:不可为空	经办银行
accbankcode	0		0:不可为空	账户银行
agentop	0		0:不可为空	经办柜员
centerid	0		0:不可为空	城市中心代码
freeuse1			1:可为空	备用字符
freeuse2			1:可为空	备用金额
freeuse3			1:可为空	备用日期
freeuse4			1:可为空	备用数值




* */



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
