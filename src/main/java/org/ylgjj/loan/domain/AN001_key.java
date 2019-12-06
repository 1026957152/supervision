package org.ylgjj.loan.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuan zhao  on 08/10/2015.
 */



public class AN001_key implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Column(name = "settletranscode")
    private String settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;




    @Column(name = "outranscode")
    private String outranscode_不可为空_外部交易码;
    @Column(name = "centerid")
    private String centerid_不可为空_城市代码;




    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
