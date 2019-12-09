package org.ylgjj.loan.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="用户的实体对象")
public class QueryH_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分 {
     //   @NotBlank
     @ApiModelProperty(value="用户id",name="id",required=true)
        String zjbzxbm ;  //住建部中心编码
        public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }
    }
