package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_2业务指标_常用指标数据查询 {

    private String tbl_同比值_String_输出;
    private String hbl_环比值_String_输出;
    private long bqz_本期值_long_输出;

    public String getTbl_同比值_String_输出() {
        return tbl_同比值_String_输出;
    }

    public void setTbl_同比值_String_输出(String tbl_同比值_String_输出) {
        this.tbl_同比值_String_输出 = tbl_同比值_String_输出;
    }

    public String getHbl_环比值_String_输出() {
        return hbl_环比值_String_输出;
    }

    public void setHbl_环比值_String_输出(String hbl_环比值_String_输出) {
        this.hbl_环比值_String_输出 = hbl_环比值_String_输出;
    }

    public long getBqz_本期值_long_输出() {
        return bqz_本期值_long_输出;
    }

    public void setBqz_本期值_long_输出(long bqz_本期值_long_输出) {
        this.bqz_本期值_long_输出 = bqz_本期值_long_输出;
    }
}