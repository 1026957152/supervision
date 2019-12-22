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

@Service
public class H2_7_业务指标_表格查询_ServiceImpl {

    @Autowired
    private Target_业务指标记录Repository Target_业务指标记录Repository;


    public Output H_2_7_业务指标_表格查询(QueryH_2_7_业务指标_表格查询 query) {
        return null;
    }
}
