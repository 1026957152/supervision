package org.ylgjj.loan.domain_flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "unitManagementAccount")

public class UnitManagementAccount  extends BaseDomain{

    @Column(name = "no")
    private String no;


    @Column(name = "status")
    private String status;  // 开户，销户，封存。


    @Column(name = "tranDate")
    private Date tranDate;  // 开户，销户，封存，缓缴


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
