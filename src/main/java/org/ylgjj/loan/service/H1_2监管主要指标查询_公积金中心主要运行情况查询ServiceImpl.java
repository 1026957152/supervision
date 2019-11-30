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

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H1_2监管主要指标查询_公积金中心主要运行情况查询ServiceImpl")
public class H1_2监管主要指标查询_公积金中心主要运行情况查询ServiceImpl {

    @Autowired
    private AN004Repository an004Repository;


    @Autowired
    private PB010_bank_info_大行信息表Repository pb010_bank_info_大行信息表Repository;

    @Autowired
    private LN003_Contract_info_Repository ln003_contract_info_repository;


    public Page<LN003_contract_info_合同信息> queryAdvice(Pageable pageable) {
       // List<LN003_contract_info_合同信息> ln003_contract_info_合同信息s =  ln003_contract_info_repository.findByLoandateBetween(new Date(),new Date());


        return null;
    }

    public Output H_1_1_监管主要指标查询_公积金年度查询(String zjbzxbm) {
        H1_1监管主要指标查询_公积金年度查询 h1_1监管主要指标查询_公积金年度查询 = new H1_1监管主要指标查询_公积金年度查询();
        h1_1监管主要指标查询_公积金年度查询.setBbmc_年度名称("");
        h1_1监管主要指标查询_公积金年度查询.setBbxm_年度编码("");
        h1_1监管主要指标查询_公积金年度查询.setId_编号("");

        h1_1监管主要指标查询_公积金年度查询.setZjbzxbm_住建部中心编码("");
        Output output = new Output();

        output.setData(Arrays.asList(h1_1监管主要指标查询_公积金年度查询));
        return output;

    }
}
