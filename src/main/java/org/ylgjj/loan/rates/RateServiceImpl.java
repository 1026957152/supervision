package org.ylgjj.loan.rates;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository_flow.RateAnalysisStreamRepository;
import org.ylgjj.loan.repository_flow.RateAnalysisTableRepository;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class RateServiceImpl {


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private RateAnalysisStreamRepository rateAnalysisStreamRepository;
    @Autowired
    private RateAnalysisTableRepository rateAnalysisTableRepository;


    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");



  //@PostConstruct
    @Transactional
    public void CONFIG() {
        List<E_指标_RATE_SY> statisticalIndexCodeEnums = Arrays.stream(E_指标_RATE_SY.values()).collect(Collectors.toList());


        IntStream.range(0,statisticalIndexCodeEnums.size()).forEach(e->{

            E_指标_RATE_SY statisticalIndexCodeEnum=    statisticalIndexCodeEnums.get(e);
            RateAnalysisTable analysisTable = rateAnalysisTableRepository.findByIndexNo(statisticalIndexCodeEnum.get编码());


            if(analysisTable== null){
                analysisTable = new RateAnalysisTable();
                analysisTable.setIndexNo(statisticalIndexCodeEnum.get编码());
                analysisTable.setName(statisticalIndexCodeEnum.get名称());
                analysisTable.setSeq(e);

                rateAnalysisTableRepository.save(analysisTable);
            }


        });


    }




   // @Scheduled(fixedRate = 1000*60*118)
    public void process() {


        sy_25_ljjzfxhrs_建制非销户人数_rateService.realTime();
        sy_28_ljjzfcrs_建制封存人数_rateServiceImpl__.realTime();

    }



    @Autowired
    private SY_137_ljffbs_累计发放笔数_RateServiceImpl sy_137_ljffbs_累计发放笔数_rateService;
    @Autowired
    private SY_134_ffbs_发放笔数_RateServiceImpl sy_134_ffbs_发放笔数_rateService;
    @Autowired
    private SY_127_ljffdkje_期末值_累计发放贷款金额_RateServiceImpl sy_127_ljffdkje_累计发放贷款金额_rateService;
    @Autowired
    private SY_166_tqzbs_提取总笔数_RateServiceImpl sy_166_tqzbs_提取总笔数_rateService;
    @Autowired
    private SY_131_dkye_贷款余额_RateServiceImpl sy_131_dkye_贷款余额_rateService;
    @Autowired
    private SY_143_hqzhye_活期账户余额_RateServiceImpl sy_143_hqzhye_活期账户余额_rateService;
    @Autowired
    private SY_49_ljthreeyqhs_三期以上笔数_RateServiceImpl sy_49_ljthreeyqhs_三期以上笔数_rateService;
    @Autowired
    private SY_52_ljsixyqhs_六期以上笔数_RateServiceImpl sy_52_ljsixyqhs_六期以上笔数_rateService;
    @Autowired
    private SY_121_hsje_回收金额_RateServiceImpl sy_121_hsje_回收金额_rateService;


    @Autowired
    private SY_124_ljhsje_累计回收金额_RateServiceImpl sy_124_ljhsje_累计回收金额_rateService;

    @Autowired
    private SY_19_ljjzzrs_建制总人数_RateServiceImpl sy_19_ljjzzrs_建制总人数_rateService;
    @Autowired
    private SY_55_hslx_回收利息_RateServiceImpl sy_55_hslx_回收利息_rateService;


    @Autowired
    private SY_58_ljhslx_累计回收利息_RateServiceImpl sy_58_ljhslx_累计回收利息_rateService;
    @Autowired
    private SY_46_ljzldkbs_存量贷款笔数_RateServiceImpl sy_46_ljzldkbs_存量贷款笔数_rateService;

    @Autowired
    private SY_118_ljffje_累计发放金额_RateServiceImpl sy_118_ljffje_累计发放金额_rateService;
    @Autowired
    private SY_112_ljtqje_累计提取金额_RateServiceImpl sy_112_ljtqje_累计提取金额_rateService;
    @Autowired
    private SY_109_tqje_提取金额_RateServiceImpl sy_109_tqje_提取金额_rateService;
    @Autowired
    private SY_106_ljtqe_历史累计提取额_提取原因_RateServiceImpl sy_106_ljtqe_历史累计提取额_提取原因_rateService;
    @Autowired
    private SY_103_ljsjce_累计实缴存额_RateServiceImpl sy_103_ljsjce_累计实缴存额_rateService;

    @Autowired
    private SY_100_sjce_实缴存额_RateServiceImpl sy_100_sjce_实缴存额_rateService;
    @Autowired
    private SY_97_ljjce_累计缴存额_RateServiceImpl sy_97_ljjce_累计缴存额_rateService;
    @Autowired
    private SY_94_ljxkhzgs_累计新开户职工_RateServiceImpl sy_94_ljxkhzgs_累计新开户职工_rateService;

    @Autowired
    private SY_82_jcye_缴存余额_RateServiceImpl sy_82_jcye_缴存余额_rateService;
    @Autowired
    private SY_88_ljxkhdws_累计新开户单位_RateServiceImpl sy_88_ljxkhdws_累计新开户单位_rateService;
    @Autowired
    private SY_85_xkhdws_新开户单位_RateServiceImpl sy_85_xkhdws_新开户单位_rateService;


    @Autowired
    private SY_76_sjdws_实缴单位数_RateServiceImpl sy_76_sjdws_实缴单位数_rateService;
    @Autowired
    private SY_79_sjzgs_实缴职工数_RateServiceImpl sy_79_sjzgs_实缴职工数_rateService;
    @Autowired
    private SY_70_wbzcje_外部转出金额_RateServiceImpl sy_70_wbzcje_外部转出金额_rateService;
    @Autowired
    private SY_73_ljwbzcje_累计外部转出金额_RateServiceImpl sy_73_ljwbzcje_累计外部转出金额_rateService;
    @Autowired
    private SY_64_wbzrje_外部转入金额_RateServiceImpl sy_64_wbzrje_外部转入金额_rateService;

    @Autowired
    private SY_67_ljwbzrje_外部转入金额_RateServiceImpl sy_67_ljwbzrje_外部转入金额_rateService;


    @Autowired
    private SY_37_ljhse_累计回收额_RateServiceImpl sy_37_ljhse_累计回收额_rateService;


    @Autowired
    private SY_40_ljhsdkje_历史累计回收额_RateServiceImpl sy_40_ljhsdkje_历史累计回收额_rateService;

    @Autowired
    private SY_34_ljjzdjrs_建制冻结人数_RateServiceImpl sy_34_ljjzdjrs_建制冻结人数_rateService;
    @Autowired
    private SY_31_ljjzzcrs_建制正常人数_RateServiceImpl sy_31_ljjzzcrs_建制正常人数_rateService;

    @Autowired
    private SY_25_ljjzfxhrs_建制非销户人数_RateServiceImpl sy_25_ljjzfxhrs_建制非销户人数_rateService;
    @Autowired
    private SY_28_ljjzfcrs_建制封存人数_RateServiceImpl__ sy_28_ljjzfcrs_建制封存人数_rateServiceImpl__;

    @Autowired
    private SY_22_ljjzxhrs_建制销户人数_RateServiceImpl sy_22_ljjzxhrs_建制销户人数_rateService;
    @Autowired
    private SY_16_ljjzhjdws_建制缓缴单位数_RateServiceImpl sy_16_ljjzhjdws_建制缓缴单位数_rateService;
    @Autowired
    private SY_13_ljjzzcdws_建制正常单位数_RateServiceImpl sy_13_ljjzzcdws_建制正常单位数_rateService;

    @Autowired
    private SY_10_ljjzfcdws_问题_建制封存单位数_RateServiceImpl sy_10_ljjzfcdws_建制封存单位数_rateService;

    @Autowired
    private SY_7_ljjzfxhdws_建制非销户单位数_RateServiceImpl sy_7_ljjzfxhdws_建制非销户单位数_rateService;

    @Autowired
    private SY_4_ljjzxhdws_建制销户单位数_RateServiceImpl sy_4_ljjzxhdws_建制销户单位数_rateService;

    @Autowired
    private SY_1_ljjzzdws_建制总单位数_RateServiceImpl sy_1_ljjzzdws_建制总单位数_rateService;

    @Autowired
    private SY_144_ywsrje_业务收入金额_RateServiceImpl sy_144_ywsrje_业务收入金额_rateService;
    @Autowired
    private SY_145_ywzcje_业务收出金额_RateServiceImpl sy_145_ywzcje_业务收出金额_rateService;
    @Autowired
    private SY_168_dkzbs_贷款总笔数_RateServiceImpl sy_168_dkzbs_贷款总笔数_rateService;
    @Autowired
    private SY_164_gjzbs_归集总笔数_RateServiceImpl sy_164_gjzbs_归集总笔数_rateService;


    @Autowired
    private SY_176_dkzcspsj_贷款最长审批时间_RateServiceImpl sy_176_dkzcspsj_贷款最长审批时间_rateService;

    @Autowired
    private SY_177_dkpjspts_贷款平均审批天数_RateServiceImpl sy_177_dkpjspts_贷款平均审批天数_rateService;


    @Autowired
    private SY_130_yqdkje_逾期贷款金额_RateServiceImpl sy_130_yqdkje_逾期贷款金额_rateService;
    @Autowired
    private SY_140_zzsyje_增长收益金额_RateServiceImpl sy_140_zzsyje_增长收益金额_rateService;

    @Autowired
    private SY_115_ffje_发放金额_RateServiceImpl sy_115_ffje_发放金额_rateService;



}
