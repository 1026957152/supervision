package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.domain_flow.Target_业务指标记录;
import org.ylgjj.loan.output.H2_2业务指标_常用指标数据查询;
import org.ylgjj.loan.pojo.*;


import org.ylgjj.loan.repository_flow.Target_业务指标记录Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H2统计指标ServiceImpl")
public class H2统计指标ServiceImpl {

    @Autowired
    private Target_业务指标记录Repository Target_业务指标记录Repository;




    public ReturnResult 逾期监管汇总查询(String zjbzxbm) {
        return null;
    }

    @Transactional
    public Output H_2_1_业务指标_添加常用指标(QueryH_2_1_业务指标_添加常用指标 query) {


        List<Target_业务指标记录> y = Target_业务指标记录Repository.findByXmbm(query.getXmbm());

        if(y.isEmpty()){
            Target_业务指标记录 ii = new Target_业务指标记录();
            ii.setUserid(query.getUserid());
            ii.setXmbm(query.getUserid());
            ii = Target_业务指标记录Repository.save(ii);
        }
        Output output = new Output();
        output.setSuccess(true);
        return output;
    }


    public Output H_2_2_业务指标_查询常用指标(QueryH_2_2_业务指标_查询常用指标 query) {

        List<Target_业务指标记录> y = Target_业务指标记录Repository.findAll();


        Output output = new Output();
        output.setData(y.stream().map(e->{
            H2_2业务指标_常用指标数据查询 h2_2业务指标_常用指标数据查询 = new H2_2业务指标_常用指标数据查询();
            h2_2业务指标_常用指标数据查询.setXmbm_指标编码_String_输出(e.getXmbm());
            h2_2业务指标_常用指标数据查询.setXmmc_指标名称_String_输出(e.getXmbm());
            h2_2业务指标_常用指标数据查询.setZjbzxbm_住建部中心编码_String_输出(e.getXmbm());
            return h2_2业务指标_常用指标数据查询;
        }).collect(Collectors.toList()));
        output.setSuccess(true);
        return output;

    }

    public Output H_2_3_业务指标_常用指标数据查询(QueryH_2_3_业务指标_常用指标数据查询 query) {
        return null;
    }

    public Output H_2_4_业务指标_多指标树查询(QueryH_2_4_业务指标_多指标树查询 query) {
        return null;
    }

    public Output H_2_6_业务指标_网格查询(QueryH_2_6_业务指标_网格查询 query) {
        return null;
    }

    public Output H_2_7_业务指标_表格查询(QueryH_2_7_业务指标_表格查询 query) {
        return null;
    }
}
