package org.ylgjj.loan.flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.ylgjj.loan.domain.AN001_key;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "overdue")

public class loan extends BaseFlowDomain{

    @Column(name = "no")
    private String no;
















    @Column(name = "贷款编号")
    private String TRANSNAME_贷款编号;


    @Column(name = "贷款年限")
    private String CHANIP_贷款年限;
    @Column(name = "房屋性质")
    private String CHANPORT_房屋性质;


    @Column(name = "还款方式")
    private String CHANINFO_还款方式;

    @Column(name = "贷款金额")
    private String CSPFLAG_贷款金额; //0-关,1-开	1:可为空

    @Column(name = "资金来源")
    private String BATFLAG_资金来源; //1-单笔,2-批量,0-其它	0:不可为空

    @Column(name = "贷款用途")
    private String TIMEOUT_贷款用途; //以秒来计算		0:






    @Column(name = "担保方式")
    private String HEADTAG_担保方式;

    @Column(name = "购房面积")
    private String BODYTAG_购房面积;

    @Column(name = "房屋价格")
    private String DETAILTAG_房屋价格;





    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }




}
