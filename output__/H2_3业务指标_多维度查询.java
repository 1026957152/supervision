package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H2_3业务指标_多维度查询 {


    private String tbl_同比值_String;
    private String hbl_环比值_String;
    private String bqz_本期值_long;

    public String getTbl_同比值_String() {
        return tbl_同比值_String;
    }

    public void setTbl_同比值_String(String tbl_同比值_String) {
        this.tbl_同比值_String = tbl_同比值_String;
    }

    public String getHbl_环比值_String() {
        return hbl_环比值_String;
    }

    public void setHbl_环比值_String(String hbl_环比值_String) {
        this.hbl_环比值_String = hbl_环比值_String;
    }

    public String getBqz_本期值_long() {
        return bqz_本期值_long;
    }

    public void setBqz_本期值_long(String bqz_本期值_long) {
        this.bqz_本期值_long = bqz_本期值_long;
    }
}