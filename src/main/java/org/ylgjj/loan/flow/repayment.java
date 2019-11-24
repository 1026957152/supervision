package org.ylgjj.loan.flow;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.ylgjj.loan.domain.AN001_key;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity
@Table(name = "overdue")

public class repayment extends BaseFlowDomain {

    @Column(name = "settletranscode")
    private String settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;



    @Column(name = "centerid")
    private String centerid_不可为空_城市代码;







    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getSettletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码() {
        return settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;
    }

    public void setSettletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码(String settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码) {
        this.settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码 = settletranscode__交易码_两位序号渠道号码_不可为空_交易渠道码;
    }

    public String getCenterid_不可为空_城市代码() {
        return centerid_不可为空_城市代码;
    }

    public void setCenterid_不可为空_城市代码(String centerid_不可为空_城市代码) {
        this.centerid_不可为空_城市代码 = centerid_不可为空_城市代码;
    }
}
