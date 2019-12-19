package org.ylgjj.loan.domain_flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "collect")

public class Collect extends BaseFlowDomain {

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
