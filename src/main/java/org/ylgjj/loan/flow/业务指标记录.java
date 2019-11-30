package org.ylgjj.loan.flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "业务指标记录")

public class 业务指标记录 extends BaseFlowDomain {

    @Column(name = "xmbm")
    private String xmbm;


    @Column(name = "userid")
    private String userid;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getXmbm() {
        return xmbm;
    }

    public void setXmbm(String xmbm) {
        this.xmbm = xmbm;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    ;

}
