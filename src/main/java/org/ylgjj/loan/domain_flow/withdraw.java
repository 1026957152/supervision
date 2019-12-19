package org.ylgjj.loan.domain_flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "withdraw")

public class withdraw extends BaseFlowDomain{

    @Column(name = "no")
    private String no;






    @Column(name = "reason")
    private String reason提取原因;


    @Column(name = "amount")
    private String amount提取金额;


    @Column(name = "principal_amount")
    private BigDecimal principalAmount提取本金;

    @Column(name = "interest_amount")
    private BigDecimal interestAmount提取利息;





    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }




}
