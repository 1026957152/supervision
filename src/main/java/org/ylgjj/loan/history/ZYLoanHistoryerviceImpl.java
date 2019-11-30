package org.ylgjj.loan.history;


import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.LoaneeTypeEnum;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.outputenum.E_住建部编码_收入水平;
import org.ylgjj.loan.outputenum.E_住建部编码_购房面积;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.repository_flow.YourHistoryRepository;
import org.ylgjj.loan.util.DateUtilsss;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;
import static org.ylgjj.loan.outputenum.E_指标_RATE_SY.SY_140_zzsyje_增长收益金额;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ZYLoanHistoryerviceImpl")
public class ZYLoanHistoryerviceImpl {


    @Autowired
    private CM002_个人基本资料表Repository cm002个人基本资料表Repository;
    @Autowired
    private DP034_公积金开销户登记簿_Repository dp034_公积金开销户登记簿_repository;


    @Autowired
    private LN008_借款人类型Repository lN008_借款人类型Repository;

    @Autowired
    private LN014_TradingHouse_贷款房屋信息Repository ln014_tradingHouse_贷款房屋信息Repository;
    @Autowired
    private LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;




    @Autowired
    private DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;


    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private DW025_公积金提取审核登记表_Repository dW025__公积金提取审核登记表_Repository;

    @Autowired
    private DP007_individual_sub_account_个人分户账_Repository dp007_individual_sub_account个人分户账Repository;
    @Autowired
    private DP006_Payment_个人缴存信息表_Repository dp006_payment_个人缴存信息表_repository;


    @Autowired
    private LN003_Contract_info_Repository ln003_contract_info_repository;


    @Autowired
    private DP204_个人缴存变更登记簿_Repository dp204_个人缴存变更登记簿_repository;
    @Autowired
    private DW145_提取结算登记薄_Repository dw145_提取结算登记薄_repository;



    @Autowired
    private CM081_sms_短信密码签订登记簿_Repository cm081_sms_短信密码签订登记簿_repository;

    @Autowired
    private DP004_unit_payment_info_单位缴存信息表_Repository dp004_unit_payment_info单位缴存信息表Repository;

    @Autowired
    private DP005_WorkUnit_单位分户账_Repository dp005_workUnit_单位分户账_repository;

    @Autowired
    private CM001_单位基本资料表Repository cm001单位基本资料表Repository;
    @Autowired
    private DP008_institution_detail_单位明细账_Repository dp008_institution_detail_单位明细账_repository;
    @Autowired
    private DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;
    @Autowired
    private PB017_public_flowing公共流水登记簿Repository public_flowing公共流水登记簿Repository;


    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    private LN005_lone_sub_accountRepository lN005_lone_sub_accountRepository;
    @Autowired
    private YourHistoryRepository yourHistoryRepository;


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;










    //也是按照放款的一个流水在进行啊啊。
    //TODO 存储统计信息
    public void 历史累计saveHistoryOneTime(LocalDate n, List<Quintet<LN003_contract_info_合同信息,
            LN005_lone_sub_account_贷款分户信息,
            LN0014_Trading_house_贷款房屋信息,
            List<LN008_borrower_info_借款人信息>,
            Double>> inputs) {

        inputs.stream().collect(Collectors.groupingBy(e->e.getValue0().getInstcode_机构代码())).entrySet().forEach(eee->{
            String 机构编码 = eee.getKey();


/*
            SY_140_zzsyje_增长收益金额("zzsyje","增长收益金额"),
                    SY_141_xmdkye_项目贷款余额("xmdkye","项目贷款余额"),
                    SY_142_gzye_国债金额("gzye","国债金额"),
                    SY_143_hqzhye_活期账户余额("hqzhye","活期账户余额"),
                    SY_144_ywsrje_业务收入金额("ywsrje","业务收入金额"),
                    SY_145_ywzcje_业务收出金额("ywzcje","业务收出金额"),
                    SY_146_sjlzzf_上缴的保障房建设资金("sjlzzf","上缴的保障房建设资金"),
                    SY_147_fplzzf_计提的保障房建设资金("fplzzf","计提的保障房建设资金"),
                    SY_148_gthdbs_柜台核定笔数("gthdbs","柜台核定笔数"),
                    SY_149_wthdbs_网上核定笔数("wthdbs","网上核定笔数"),
                    SY_150_gtxxbgbs_柜台信息变更笔数("gtxxbgbs","柜台信息变更笔数"),
                    SY_151_wtxxbgbs_网上信息变更笔数("wtxxbgbs","网上信息变更笔数"),
                    SY_152_gtztbgbs_柜台状态变更笔数("gtztbgbs","柜台状态变更笔数"),
                    SY_153_wtztbgbs_网上状态变更笔数("wtztbgbs","网上状态变更笔数"),
                    SY_154_gtjcjsbs_柜台缴存基数变更笔数("gtjcjsbs","柜台缴存基数变更笔数"),
                    SY_155_wtjcjsbs_网上缴存基数变更笔数("wtjcjsbs","网上缴存基数变更笔数"),
                    SY_156_gttqbs_柜台提取笔数("gttqbs","柜台提取笔数"),
                    SY_157_wttqbs_网上提取笔数("wttqbs","网上提取笔数"),
                    SY_158_gtdkbs_柜台贷款笔数("gtdkbs","柜台贷款笔数"),
                    SY_159_wtdkbs_网上贷款笔数("wtdkbs","网上贷款笔数"),
                    SY_160_gttqhkbs_柜台提前还款笔数("gttqhkbs","柜台提前还款笔数"),
                    SY_161_wttqhkbs_网上提取还款笔数("wttqhkbs","网上提取还款笔数"),
                    SY_162_gtchdjybs_柜台冲还贷笔数("gtchdjybs","柜台冲还贷笔数"),
                    SY_163_wtchdjybs_网厅冲还贷总笔数("wtchdjybs","网厅冲还贷总笔数"),
                    SY_164_gjzbs_归集总笔数("gjzbs","归集总笔数"),
                    SY_165_wtgjzbs_网厅归集总笔数("wtgjzbs","网厅归集总笔数"),
                    SY_166_tqzbs_提取总笔数("tqzbs","提取总笔数"),
                    SY_167_wttqzbs_网厅提取总笔数("wttqzbs","网厅提取总笔数"),
                    SY_168_dkzbs_贷款总笔数("dkzbs","贷款总笔数"),
                    SY_169_wtdkzbs_网厅贷款总笔数("wtdkzbs","网厅贷款总笔数"),
                    SY_170_tqlgl_提取离柜率("tqlgl","提取离柜率"),
                    SY_171_gjlgl_归集离柜率("gjlgl","归集离柜率"),
                    SY_172_dklgl_贷款离柜率("dklgl","贷款离柜率"),
                    SY_173_zxlgl_中心离柜率("zxlgl","中心离柜率"),
                    SY_174_tqcsbs_提取超时笔数("tqcsbs","提取超时笔数"),
                    SY_175_dkcsbs_贷款超时笔数("dkcsbs","贷款超时笔数"),
                    SY_176_dkzcspsj_贷款最长审批时间("dkzcspsj","贷款最长审批时间"),
                    SY_177_dkpjspts_贷款平均审批天数("dkpjspts","贷款平均审批天数"),*/


        });
    }





}
