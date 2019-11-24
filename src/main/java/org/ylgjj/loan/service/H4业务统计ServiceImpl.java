package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.H单位公积金缴存登记簿_入账状态;
import org.ylgjj.loan.output.H4_1业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.outputenum.HX摘要码信息表;
import org.ylgjj.loan.pojo.QueryH_4_1_业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.repository.DP008单位明细账Repository;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;
import org.ylgjj.loan.repository.PB010_bank_info_大行信息表Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summarizingDouble;

/**
 * Created by silence yuan on 2015/7/25.
 */
// TODO 按渠道分配，如何区分托收是否按渠道分配
@Service("H4业务统计ServiceImpl")
public class H4业务统计ServiceImpl {

    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private PB010_bank_info_大行信息表Repository pb010_bank_info_大行信息表Repository;
    @Autowired
    private DP008单位明细账Repository dp008单位明细账Repository;



    public ReturnResult 逾期监管汇总查询(String zjbzxbm) {
        return null;
    }

    public Output H_4_1_业务统计_获取各渠道业务统计数据(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        ;

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df);
        List<String> aa  =Arrays.asList(HX摘要码信息表.HX__85_S_预缴入账_1213,
                HX摘要码信息表.HX__86_S_汇缴入账_1219,
                HX摘要码信息表.HX__87_S_正常全额补缴入账_1220,
                HX摘要码信息表.HX__89_S_不定额补缴入账_1222).stream().map(e->e.get编码()).collect(Collectors.toList());


        List<DP008_单位明细账> dp021_单位缴存登记簿s = dp008单位明细账Repository.findBySummarycode不可为空摘要代码In(aa);


        List<DP008_单位明细账> dp021_单位缴存登记簿s_peried = dp008单位明细账Repository.findBySummarycode不可为空摘要代码InAndsummarycode不可为空摘要代码Between(aa,ldt_ksrq,ldt_jsrq);
        double 发生额_提取= dp021_单位缴存登记簿s.stream().mapToDouble(e->e.getAmt_0_不可为空_发生额()).sum();

        double 比例_提取 = dp021_单位缴存登记簿s_peried.size() / dp021_单位缴存登记簿s.size();

   /*     return dp021_单位缴存登记簿s.stream().filter(e->e.getInaccstate_入账状态().equals(H单位公积金缴存登记簿_入账状态.入账.getText()))
                .collect(summarizingDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()));*/

        H4_1业务统计_获取各渠道业务统计数据 h4_1业务统计_获取各渠道业务统计数据 = new H4_1业务统计_获取各渠道业务统计数据();
        DoubleSummaryStatistics 归集 = 归集(query);
        h4_1业务统计_获取各渠道业务统计数据.setGjbs_归集_Int(dp021_单位缴存登记簿s.size());
        h4_1业务统计_获取各渠道业务统计数据.setGjje_归集金额_Double(发生额_提取);
        h4_1业务统计_获取各渠道业务统计数据.setGjzb_归集占比_Double(比例_提取);






        h4_1业务统计_获取各渠道业务统计数据.setDkbs_贷款笔数_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setDkje_贷款金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setDkzb_贷款占比_Double(1.0D);

        h4_1业务统计_获取各渠道业务统计数据.setDktqhkbs_提前还贷笔数_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setDktqhkje_提前还贷金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setDktqhkzb_提前还贷占比_Double(1.0D);


        h4_1业务统计_获取各渠道业务统计数据.setTqywchdbs_提取业务偿还贷笔数_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setTqywchdje_提取业务偿还贷金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setTqywchdzb_提取业务偿还贷占比_Double(1.0D);
        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据);
        output.setData(a);
        return output;
    }







    public DoubleSummaryStatistics 贷款(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = null;//dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(query.getKsrq(),query.getJsrq());
        return dp021_单位缴存登记簿s.stream().filter(e->e.getInaccstate_入账状态().equals(H单位公积金缴存登记簿_入账状态.入账.getText()))
                .collect(summarizingDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()));

    }



    public DoubleSummaryStatistics 归集(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = null;//dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(query.getKsrq(),query.getJsrq());
        return dp021_单位缴存登记簿s.stream().filter(e->e.getInaccstate_入账状态().equals(H单位公积金缴存登记簿_入账状态.入账.getText()))
                .collect(summarizingDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()));

    }
}
