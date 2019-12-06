package org.ylgjj.loan.flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "collect")

public class collectMonthSet extends BaseFlowDomain {

    @Column(name = "UnitNo")
    private String UnitNo;



    @Column(name = "缴存开始")
    private String DETAILTAG_缴存开始;
    @Column(name = "缴存结束")
    private String ROOTTAG_缴存结束;


    @Column(name = "应缴纳人数")
    private String ROOTTAG_应缴纳人数;


    @Column(name = "实际缴存人数")
    private String ROOTTAG_实际缴存人数;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
