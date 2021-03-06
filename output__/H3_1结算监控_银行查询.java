package org.ylgjj.loan.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class H3_1结算监控_银行查询 {



    private String bm_银行编码;
    private String mc_银行名称;
    private String id_银行logo图片;

    public String getBm_银行编码() {
        return bm_银行编码;
    }

    public void setBm_银行编码(String bm_银行编码) {
        this.bm_银行编码 = bm_银行编码;
    }

    public String getMc_银行名称() {
        return mc_银行名称;
    }

    public void setMc_银行名称(String mc_银行名称) {
        this.mc_银行名称 = mc_银行名称;
    }

    public String getId_银行logo图片() {
        return id_银行logo图片;
    }

    public void setId_银行logo图片(String id_银行logo图片) {
        this.id_银行logo图片 = id_银行logo图片;
    }
}