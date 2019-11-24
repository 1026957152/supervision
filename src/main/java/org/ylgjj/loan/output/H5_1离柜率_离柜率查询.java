package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H5_1离柜率_离柜率查询 {


    private String jgbm_管理机构编码_String;
    private String jgmc_管理机构_String;
    private String ksrq_汇总日期_date;
    private String qd_渠道_varchar_6;
    private double lgl_离柜率_Double;
    private int wthdbs_核定笔数_Int;
    private int wtxxbgbs_信息变更笔数_Int;
    private int wtztbgbs_账户状态变更笔数_Int;
    private int wtjcjsbs_缴存基数笔数_Int;
    private int wttqbs_提取笔数_Int;
    private int wtdkbs_贷款笔数_Int;
    private int wttqhkbs_提前还款笔数_Int;
    private int wtchdjybs_对冲签约笔数_Int;
    private double gzlgl_缴存离柜率_Double;
    private double dklgl_贷款离柜率_Double;
    private double zqlgl_提取离柜率_Double;
    private double zxlgl_中心离柜率_Double;




}