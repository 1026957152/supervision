package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H3_2结算监控_银行余额查询 {




    private String bm_银行编码;
    private String mc_银行名称;
    private double fse_发生额;
    private double sre_收入额;
    private double zce_支出额;

}