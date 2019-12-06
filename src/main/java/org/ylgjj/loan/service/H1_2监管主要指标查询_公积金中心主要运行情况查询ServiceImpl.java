package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.output.H1_1监管主要指标查询_公积金年度查询;
import org.ylgjj.loan.repository.AN004Repository;
import org.ylgjj.loan.repository.LN003_Contract_info_Repository;
import org.ylgjj.loan.repository.PB010_bank_info_大行信息表Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.ylgjj.loan.config.Constants.zjbzxbm_住建部中心编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H1_2监管主要指标查询_公积金中心主要运行情况查询ServiceImpl")
public class H1_2监管主要指标查询_公积金中心主要运行情况查询ServiceImpl {



    public Output H_1_1_监管主要指标查询_公积金年度查询(String zjbzxbm) {


        LocalDate localDate = LocalDate.now();

        Output output = new Output();

        output.setData(IntStream.of(1,2,4).mapToObj(e->{
            H1_1监管主要指标查询_公积金年度查询 h1_1监管主要指标查询_公积金年度查询 = new H1_1监管主要指标查询_公积金年度查询();
            h1_1监管主要指标查询_公积金年度查询.setBbmc_年度名称(localDate.minusYears(e).getYear()+"");
            h1_1监管主要指标查询_公积金年度查询.setBbxm_年度编码(localDate.minusYears(e).getYear()+"");
            h1_1监管主要指标查询_公积金年度查询.setId_编号(Integer.valueOf(e).toString());
            h1_1监管主要指标查询_公积金年度查询.setZjbzxbm_住建部中心编码(zjbzxbm_住建部中心编码);
            return h1_1监管主要指标查询_公积金年度查询;
        }).collect(Collectors.toList()));
        return output;

    }
}
