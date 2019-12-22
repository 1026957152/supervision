package org.ylgjj.loan.pojo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.NotBlank;

public class QueryH_2_5_业务指标_多维度查询 {
        @NotBlank
        String zjbzxbm;



       @NotBlank
        String target;//	target	目标	String	输入(必传)

    public String getZjbzxbm() {
        return zjbzxbm;
    }

    public void setZjbzxbm(String zjbzxbm) {
        this.zjbzxbm = zjbzxbm;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
