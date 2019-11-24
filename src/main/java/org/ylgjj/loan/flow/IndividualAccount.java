package org.ylgjj.loan.flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.ylgjj.loan.domain.AN001_key;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "overdue")

public class IndividualAccount extends BaseFlowDomain {

    @Column(name = "no")
    private String settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;



    @Column(name = "status") //开户;正常;封存;销户;冻结
    private String status;



    @Column(name = "date")
    private Date date;






    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
