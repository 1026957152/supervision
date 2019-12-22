package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.domain_flow.Target_业务指标记录;
import org.ylgjj.loan.output.H2_2业务指标_常用指标数据查询;
import org.ylgjj.loan.output.H2_4业务指标_多指标树查询;
import org.ylgjj.loan.output.H2_5业务指标_查询常用指标;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.pojo.*;


import org.ylgjj.loan.repository_flow.Target_业务指标记录Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class H2_业务指标_ServiceImpl {

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

    public Output H_2_4_业务指标_多指标树查询(QueryH_2_4_业务指标_多指标树查询 query) {


        ;

        E_应用代码_SY_EX.values();

        System.out.println("--------"+query.toString());
        Output output = new Output();
        output.setData(Arrays.stream(E_指标分类编码_SY.values())
                .filter(e->e.getYybm_应用代码().equals(query.getYybm_应用代码()))
             //   .filter(e->e.getParent_父节点().equals(query.getParent_父节点()))
              //  .filter(e->e.getLevel_级别().equals(query.getLevel_级别()))

                .map(e->{
                    H2_4业务指标_多指标树查询 h2_4业务指标_多指标树查询 = new H2_4业务指标_多指标树查询();
                    h2_4业务指标_多指标树查询.setBm_指标编码_String(e.get编码());
                    h2_4业务指标_多指标树查询.setLevel_级别_int(null);
                    h2_4业务指标_多指标树查询.setMc_指标名称_String(e.get名称());

                    h2_4业务指标_多指标树查询.setParent_父节点_String(e.getParent_父节点());
                    h2_4业务指标_多指标树查询.setYybm_应用代码(e.getYybm_应用代码());

                    h2_4业务指标_多指标树查询.setXmsm_指标说明_String("");

                    E_指标单位_SY_EX.values();
                    h2_4业务指标_多指标树查询.setXsjd_显示精度_int(null);

                    E_统计类型编码_SY_EX.values();

                    h2_4业务指标_多指标树查询.setTjlxbm_统计类型编码_String("");
                    return h2_4业务指标_多指标树查询;

                }).collect(Collectors.toList()));
        output.setSuccess(true);
        return output;



    }


    public Output H_2_5_业务指标_多维度查询(QueryH_2_5_业务指标_多维度查询 query) {

        StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.fromString指标编码(query.getTarget());
        statisticalIndexCodeEnum.get统计周期();
        H2_5业务指标_查询常用指标 h2_5业务指标_查询常用指标_1 = new H2_5业务指标_查询常用指标();

        h2_5业务指标_查询常用指标_1.setBm_维度编码_String(statisticalIndexCodeEnum.get维度一());
        h2_5业务指标_查询常用指标_1.setMc_维度名称_String(statisticalIndexCodeEnum.get维度一描述());


        H2_5业务指标_查询常用指标 h2_5业务指标_查询常用指标_2 = new H2_5业务指标_查询常用指标();
        h2_5业务指标_查询常用指标_2.setBm_维度编码_String(statisticalIndexCodeEnum.get维度二());
        h2_5业务指标_查询常用指标_2.setMc_维度名称_String(statisticalIndexCodeEnum.get维度二描述());


        H2_5业务指标_查询常用指标 h2_5业务指标_查询常用指标_3 = new H2_5业务指标_查询常用指标();
        h2_5业务指标_查询常用指标_3.setBm_维度编码_String(statisticalIndexCodeEnum.get维度三());
        h2_5业务指标_查询常用指标_3.setMc_维度名称_String(statisticalIndexCodeEnum.get维度三描述());


        Output output = new Output();
        output.setData(Arrays.asList(h2_5业务指标_查询常用指标_1,
                h2_5业务指标_查询常用指标_2,
                h2_5业务指标_查询常用指标_3)
                .stream().collect(Collectors.toList()));
        output.setSuccess(true);
        return output;
    }
}
