package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.api.H4业务统计Controller;
import org.ylgjj.loan.domain.DP021_单位缴存登记簿;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.enumT.H单位公积金缴存登记簿_入账状态;
import org.ylgjj.loan.output.H4_1业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.output.H5_1离柜率_离柜率查询;
import org.ylgjj.loan.pojo.QueryH_4_1_业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;
import org.ylgjj.loan.repository.PB010_bank_info_大行信息表Repository;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import static java.util.stream.Collectors.summarizingDouble;

/**
 * Created by silence yuan on 2015/7/25.
 */
// TODO 按渠道分配，如何区分托收是否按渠道分配
@Service("H5离柜率ServiceImpl")
public class H5离柜率ServiceImpl {

    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private PB010_bank_info_大行信息表Repository pb010_bank_info_大行信息表Repository;



    public ReturnResult 逾期监管汇总查询(String zjbzxbm) {
        return null;
    }

    public Output H_4_1_业务统计_获取各渠道业务统计数据(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        H5_1离柜率_离柜率查询 h4_1业务统计_获取各渠道业务统计数据 = new H5_1离柜率_离柜率查询();
        DoubleSummaryStatistics 归集 = 归集(query);


/*        h4_1业务统计_获取各渠道业务统计数据.setGjbs_归集_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setGjje_归集金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setGjzb_归集占比_Double(1.0D);

        h4_1业务统计_获取各渠道业务统计数据.setDkbs_贷款笔数_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setDkje_贷款金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setDkzb_贷款占比_Double(1.0D);

        h4_1业务统计_获取各渠道业务统计数据.setTqbs_提取笔数_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setTqje_提取金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setTqzb_提取占比_Double(1.0D);


        h4_1业务统计_获取各渠道业务统计数据.setTqbs_提取笔数_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setTqje_提取金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setTqzb_提取占比_Double(1.0D);*/
        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据);
        output.setData(a);
        return output;
    }







    public DoubleSummaryStatistics 贷款(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s =null;// dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(query.getKsrq(),query.getJsrq());
        return dp021_单位缴存登记簿s.stream().filter(e->e.getInaccstate_入账状态().equals(H单位公积金缴存登记簿_入账状态.入账.getText()))
                .collect(summarizingDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()));

    }



    public DoubleSummaryStatistics 归集(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = null;// dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(query.getKsrq(),query.getJsrq());
        return dp021_单位缴存登记簿s.stream().filter(e->e.getInaccstate_入账状态().equals(H单位公积金缴存登记簿_入账状态.入账.getText()))
                .collect(summarizingDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()));

    }
}
