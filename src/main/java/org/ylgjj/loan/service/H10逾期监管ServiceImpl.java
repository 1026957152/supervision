package org.ylgjj.loan.service;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.*;
import org.ylgjj.loan.output.H10_1逾期监管_逾期监管汇总查询;
import org.ylgjj.loan.output.H10_2逾期监管_逾期监管明细查询;
import org.ylgjj.loan.outputenum.E_逾期分类编码_SY;
import org.ylgjj.loan.pojo.QueryH10_2逾期监管_逾期监管明细查询;
import org.ylgjj.loan.repository.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H10逾期监管ServiceImpl")
public class H10逾期监管ServiceImpl {

    @Autowired
    private LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;
    @Autowired
    private LN003_Contract_info_Repository ln003_contract_info_repository;
    @Autowired
    private LN005_lone_sub_accountRepository lN005_lone_sub_accountRepository;
    @Autowired
    private LN014_TradingHouse_贷款房屋信息Repository ln014_tradingHouse_贷款房屋信息Repository;
    @Autowired
    private LN008_借款人类型Repository ln008_借款人类型Repository;

    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;

    @Autowired
    private PB008_clerk_info_Repository pb008_柜员信息表_repository;



    @Autowired
    private LN001_申请审批信息Repository ln001_申请审批信息Repository;

    public Output H10_2逾期监管_逾期监管明细查询(QueryH10_2逾期监管_逾期监管明细查询 zjbzxbm) {


        E_逾期分类编码_SY yq = E_逾期分类编码_SY.fromString(zjbzxbm.getBm());

        Integer 逾期次数_floor =0;
        Integer 逾期次数_ceiling =0;
        if (yq == E_逾期分类编码_SY.H_01_1个月__含__以上__3个月以下){

            逾期次数_floor = 1;
            逾期次数_ceiling = 3;
        }
        if (yq == E_逾期分类编码_SY.H_02_3个月__含__以上__6个月以下){
            逾期次数_floor = 3;
            逾期次数_ceiling = 6;
        }
        if (yq == E_逾期分类编码_SY.H_03_6个月__含__以上__1年以下){
            逾期次数_floor = 6;
            逾期次数_ceiling = 12;
        }
        if (yq == E_逾期分类编码_SY.H_04_1年__含__以上__3年以下){
            逾期次数_floor = 12;
            逾期次数_ceiling = 36;
        }
        if (yq == E_逾期分类编码_SY.H_05_3年__含__以上详细信息){
            逾期次数_floor = 12;
            逾期次数_ceiling = 36;
        }
        if (yq == E_逾期分类编码_SY.H_06_六期__含__以上详细信息){
            逾期次数_floor = 6;
            逾期次数_ceiling = Integer.MAX_VALUE;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(zjbzxbm.getKsrq_开始日期(),df);
        LocalDate ldt_jsrq = LocalDate.parse(zjbzxbm.getJsrq_结束日期(),df);

        System.out.println("--------getJsrq_开始日期-------"+ldt_jsrq.toString());
        System.out.println("--------getKsrq_结束日期-------"+ldt_jsrq.toString());
        Page<LN003_contract_info_合同信息> ln003_contract_info_合同信息s = ln003_contract_info_repository
                .findByOwecnt欠还次数GreaterThanEqualAndOwecnt欠还次数LessThanAndLoandate放款日期Between(逾期次数_floor,逾期次数_ceiling,
                        ldt_ksrq,ldt_jsrq,
                        PageRequest.of(zjbzxbm.getPageNumber(),zjbzxbm.getPageSize()));



       // ln003_contract_info_repository.findByLoancontrcode合同代码()
/*
        H10_2逾期监管_逾期监管明细查询 h10_2逾期监管_逾期监管明细查询  = new H10_2逾期监管_逾期监管明细查询();

        List<LN006_RepaymentPlan_贷款分期还款计划> ln006_repaymentPlans = ln006_贷款分期还款计划Repository.findByLoancontrcode0合同代码AndBegdate0开始日期After(ln003_contract_info_合同信息.getLoancontrcode合同代码(),start18月);
        //TODO data.setDkzt(ln003_contract_info_合同信息.getOwecnt_欠还次数());


        List<LN006_RepaymentPlan_贷款分期还款计划> ln006_repaymentPlans1 =  ln006_repaymentPlans.stream().filter(e->e.getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.逾期.getText())
                || e.getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.逾期归还.getText())).collect(Collectors.toList());

        LN003_contract_info_合同信息 ln003_contract_info_合同信息 = ln003_contract_info_repository.findByLoancontrcode合同代码(ln008_borrower_info_借款人信息_借款人.getLoancontrcode_合同代码());
*/

        Output output = new Output();
        output.setData(ln003_contract_info_合同信息s.stream().map(e->{
            H10_2逾期监管_逾期监管明细查询 h10_2逾期监管_逾期监管明细查询  = new H10_2逾期监管_逾期监管明细查询();
            h10_2逾期监管_逾期监管明细查询.setJkhtbh_合同编号_String(e.getLoancontrnum_借款合同号());
            h10_2逾期监管_逾期监管明细查询.setYqts_逾期天数_int(e.getOwecnt欠还次数());
            h10_2逾期监管_逾期监管明细查询.setLjyqqs_累计逾期次数_int(e.getTolowecnt_累计欠还次数());
            h10_2逾期监管_逾期监管明细查询.setDkffe_发放金额_double(e.getLoanamt_贷款金额().doubleValue());
            h10_2逾期监管_逾期监管明细查询.setDkffrq_发放日期_String(e.getLoandate放款日期().toString());
            h10_2逾期监管_逾期监管明细查询.setDblxmc_担保类型_String(E_担保方式_GuaranteeTypeEnum_HX.fromString(e.getGuarmode_担保方式()).getDisplayText());
            h10_2逾期监管_逾期监管明细查询.setHkfsmc_还款方式_String(E_还款方式Enum_HX.fromString(e.getRepaymode_还款方式()).getDisplayText());


            List<LN005_lone_sub_account_贷款分户信息> ln005_lone_sub_account_贷款分户信息s = lN005_lone_sub_accountRepository.findByloancontrcode合同代码(e.getLoancontrcode合同代码());
            Optional<LN005_lone_sub_account_贷款分户信息> ln005_lone_sub_account_贷款分户信息_optional = ln005_lone_sub_account_贷款分户信息s.stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).findAny();

            if(ln005_lone_sub_account_贷款分户信息_optional.isPresent()){

                LN005_lone_sub_account_贷款分户信息 ln005_lone_sub_account_贷款分户信息 = ln005_lone_sub_account_贷款分户信息_optional.get();
                h10_2逾期监管_逾期监管明细查询.setDkye_贷款余额_double(ln005_lone_sub_account_贷款分户信息.getCurbal_当前余额().doubleValue());

                h10_2逾期监管_逾期监管明细查询.setDqjhhkje_月还款额_double(ln005_lone_sub_account_贷款分户信息
                        .getMonthrepayamt_贷款月还款额_本金_().doubleValue()+ln005_lone_sub_account_贷款分户信息.getCurrintamt_当期利息金额());

            }else{
                h10_2逾期监管_逾期监管明细查询.setDkye_贷款余额_double(-1l);

                h10_2逾期监管_逾期监管明细查询.setDqjhhkje_月还款额_double(-1d);

            }


            LN0014_Trading_house_贷款房屋信息 ln0014_trading_house_贷款房屋信息 = ln014_tradingHouse_贷款房屋信息Repository.findByLoancontrcode0合同代码(e.getLoancontrcode合同代码());
            h10_2逾期监管_逾期监管明细查询.setFwxzmc_房屋性质_String(E_LN014_贷款房屋信息_房屋类型.fromString(ln0014_trading_house_贷款房屋信息.getHousetype_0_房屋类型()).getDisplayText());
            h10_2逾期监管_逾期监管明细查询.setFwzl_房屋地址_String(ln0014_trading_house_贷款房屋信息.getHouseaddr_1_房屋坐落());



            List<LN008_borrower_info_借款人信息> borrower_info_借款人信息s = ln008_借款人类型Repository.findByloancontrcode合同代码(e.getLoancontrcode合同代码());

            LN008_borrower_info_借款人信息 borrower_info_借款人信息 = borrower_info_借款人信息s.stream().filter(bbb->bbb.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText())).findFirst().get();

            h10_2逾期监管_逾期监管明细查询.setGrztmc_主借款人账户状态_String(borrower_info_借款人信息.getIndiaccstate_1_个人账户状态());
            h10_2逾期监管_逾期监管明细查询.setGrjcjs_主借款人月缴存基数_double(borrower_info_借款人信息.getBasenum_0_缴存基数().doubleValue());
            h10_2逾期监管_逾期监管明细查询.setJkrgjjzh_借款人公积金账号_String(borrower_info_借款人信息.getAccnum1账号());
            h10_2逾期监管_逾期监管明细查询.setDwmc_单位名称_String(borrower_info_借款人信息.getUnitaccname_1_单位名称());

            h10_2逾期监管_逾期监管明细查询.setJkrxm_借款人姓名_String(borrower_info_借款人信息.getAccname_0_个人姓名());
            h10_2逾期监管_逾期监管明细查询.setJkrzjh_借款人证件号码_String(borrower_info_借款人信息.getCertinum_0_证件号码());

            List<LN006_RepaymentPlan_贷款分期还款计划> ln006_repaymentPlan_贷款分期还款计划s  = ln006_贷款分期还款计划Repository.findByLoancontrcode0合同代码OrderByBegdate0开始日期Asc(e.getLoancontrcode合同代码());

            List<LN004_合同状态信息> ln004_合同状态信息s = ln004_合同状态信息Repository.findByLoancontrcode(e.getLoancontrcode合同代码());

          //  ln006_repaymentPlan_贷款分期还款计划s.stream().filter()
            Optional<LN004_合同状态信息> ln004_合同状态信息 = ln004_合同状态信息s.stream()
                    .filter(h->h.getLoancontrstate().equals(E_LN004_合同状态信息_合同状态.E_01_审批.getText()))
                    .findFirst();

            ln004_合同状态信息s.forEach(i->System.out.println("=========E_01_审批 ========="+ i));

            if(ln004_合同状态信息.isPresent()){
                ln004_合同状态信息.get().getApprnum();
            }


            LN001_申请审批信息 ln001_申请审批信息 = ln001_申请审批信息Repository.findByApprnum(e.getApprnum_审批号());




            PB008_柜员信息表 pb008_柜员信息表 = pb008_柜员信息表_repository.findByOperid(ln001_申请审批信息.getApproveop());
            h10_2逾期监管_逾期监管明细查询.setSpczyxm_审批人_String(pb008_柜员信息表.getOpname());

            h10_2逾期监管_逾期监管明细查询.setYqkssj_逾期开始日期_String(ln006_repaymentPlan_贷款分期还款计划s.stream()
                    .filter(h->h.getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期.getText()))
                    .findFirst().get().getBegdate0开始日期().toString());

            double Dqyqbj_当前逾期金额 = ln006_repaymentPlan_贷款分期还款计划s.stream().filter(h->h.getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期))
                    .mapToDouble(h->h.getPlanprin0本期应还本金().add(h.getPlanint本期应还利息0()).doubleValue()).sum();
           // h10_2逾期监管_逾期监管明细查询.setYql_逾期率(Dqyqbj_当前逾期金额/h10_2逾期监管_逾期监管明细查询.getDkye_贷款余额_double());
          //  h10_2逾期监管_逾期监管明细查询.setYqlbfb(12);
            h10_2逾期监管_逾期监管明细查询.setDqyqbj_当前逾期本金_double(ln006_repaymentPlan_贷款分期还款计划s.stream().filter(h->h.getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期))
                    .mapToDouble(h->h.getPlanprin0本期应还本金().doubleValue()).sum());

            //return LocalDate.now().until(endDate, ChronoUnit.DAYS);
            long num = ln006_repaymentPlan_贷款分期还款计划s.stream()
                    .filter(h->h.getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期.getText()))
                    .findFirst().get().getEnddate0终止日期().until(LocalDate.now(), ChronoUnit.DAYS);

            h10_2逾期监管_逾期监管明细查询.setYqts_逾期天数_int(Long.valueOf(num).intValue());
            return h10_2逾期监管_逾期监管明细查询;
        }).collect(Collectors.toList()));
        output.setSuccess(true);

        return output;

    }
    @Autowired
    private CM001_单位基本资料表Repository cm001单位基本资料表Repository;
    @Autowired
    private DP008_institution_detail_单位明细账_Repository dp008_institution_detail_单位明细账_repository;
    @Autowired
    private DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;


    public Output H10_1逾期监管_逾期监管汇总查询(String zjbzxbm) {
        //List<DP202_单位缴存变更登记簿> dp021_单位缴存登记薄s = dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期(LocalDate.now());
        List<LN003_contract_info_合同信息> ln003_contract_info_合同信息s = ln003_contract_info_repository.findByOwecnt欠还次数GreaterThanEqual(6);

        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+ln003_contract_info_合同信息s.size());

        Map<Integer, List<Triplet<LN003_contract_info_合同信息,LN005_lone_sub_account_贷款分户信息,Double>>>  a =ln003_contract_info_合同信息s.stream().map(e->{
            List<LN005_lone_sub_account_贷款分户信息> ln005_lone_sub_account_贷款分户信息s = lN005_lone_sub_accountRepository.findByloancontrcode合同代码(e.getLoancontrcode合同代码());
            Optional<LN005_lone_sub_account_贷款分户信息> ln005_lone_sub_account_贷款分户信息_optional = ln005_lone_sub_account_贷款分户信息s.stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).findFirst();

            Triplet<LN003_contract_info_合同信息,LN005_lone_sub_account_贷款分户信息,Double> triplet =
                    Triplet.with(e, ln005_lone_sub_account_贷款分户信息s.get(0), 1.0D);
            return triplet ;

        }).collect(Collectors.toList()).stream().collect(  // 机构分类
                Collectors.groupingBy(e->e.getValue0().getOwecnt欠还次数())
        );



/*

        List<Triplet<LN003_contract_info_合同信息,LN005_lone_sub_account_贷款分户信息,Double>> sum_余额___pair =  ln003_contract_info_合同信息s.stream().map(e->{
            List<LN005_lone_sub_account_贷款分户信息> ln005_lone_sub_account_贷款分户信息s = lN005_lone_sub_accountRepository.findByloancontrcode合同代码(e.getLoancontrcode合同代码());
            Optional<LN005_lone_sub_account_贷款分户信息> ln005_lone_sub_account_贷款分户信息_optional = ln005_lone_sub_account_贷款分户信息s.stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).findFirst();

            Triplet<LN003_contract_info_合同信息,LN005_lone_sub_account_贷款分户信息,Double> triplet =
                    Triplet.with(e, ln005_lone_sub_account_贷款分户信息s.get(0), 1.0D);
            return triplet ;//Triplet.with(e,ln005_lone_sub_account_贷款分户信息s.get(0),"ddd");
        }).collect(Collectors.toList());
*/
        Double sum_余额 =  a.keySet().stream().mapToDouble(e->{
            return a.get(e).stream().mapToDouble(fff->fff.getValue1().getCurbal_当前余额().doubleValue()).sum();
        }).sum();



   //     Double 金额 = a.keySet().stream().filter(e->e >=1 && e <3).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1().getCurbal_当前余额().doubleValue()).sum()).sum();



        H10_1逾期监管_逾期监管汇总查询 h10_2逾期监管_逾期监管明细查询  = new H10_1逾期监管_逾期监管汇总查询();


        Integer s = a.keySet().stream().filter(e->e >=1 && e <3).mapToInt(e-> a.get(e).size()).sum();
        Double 金额 = a.keySet().stream().filter(e->e >=1 && e <3).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1().getCurbal_当前余额().doubleValue()).sum()).sum();

        h10_2逾期监管_逾期监管明细查询.setYq1_1个月_含_以上_3个月以下笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYqje1_1个月_含_以上_3个月以下金额(金额);


        s = a.keySet().stream().filter(e->e >=3 && e <6).mapToInt(e-> a.get(e).size()).sum();
        Double 金额yqje2 = a.keySet().stream().filter(e->e >=3 && e <6).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1().getCurbal_当前余额().doubleValue()).sum()).sum();


        h10_2逾期监管_逾期监管明细查询.setYq2_3个月_含_以上_6个月以下笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYqje2_3个月_含_以上_6个月以下金额(金额yqje2);

        s = a.keySet().stream().filter(e->e >=6 && e <12).mapToInt(e-> a.get(e).size()).sum();
        金额 = a.keySet().stream().filter(e->e >=6 && e <12).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1().getCurbal_当前余额().doubleValue()).sum()).sum();

        h10_2逾期监管_逾期监管明细查询.setYq3_6个月_含_以上_1年以下笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYqje3_6个月_含_以上_1年以下金额(金额);


        s = a.keySet().stream().filter(e->e >=12 && e <36).mapToInt(e-> a.get(e).size()).sum();
        金额 = a.keySet().stream().filter(e->e >=12 && e <36).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1().getCurbal_当前余额().doubleValue()).sum()).sum();

        h10_2逾期监管_逾期监管明细查询.setYq4_1年_含_以上_3年以下笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYqje4_1年_含_以上_3年以下金额(金额);

        s = a.keySet().stream().filter(e->e >=36 ).mapToInt(e-> a.get(e).size()).sum();
        金额 = a.keySet().stream().filter(e->e >=36).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1().getCurbal_当前余额().doubleValue()).sum()).sum();

        h10_2逾期监管_逾期监管明细查询.setYq5_3年_含_以上笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYqje5_3年_含_以上金额(金额);


        金额 = a.keySet().stream().filter(e->e >=6 && e<12).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1().getCurbal_当前余额().doubleValue()).sum()).sum();
        h10_2逾期监管_逾期监管明细查询.setYqje3_6个月_含_以上_1年以下金额(金额);

        Double 金额ysdkye6 = a.keySet().stream().filter(e->e >=6 ).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1().getCurbal_当前余额().doubleValue()).sum()).sum();

        h10_2逾期监管_逾期监管明细查询.setYq6_六期_含_以上笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYsdkye6_六期_含_以上金额(金额ysdkye6);


       // yql	逾期率	double	输出	((yqje2+ysdkye6)/dkye)*1000; #0.00数值格式化
     //   yqlbfb			输出	((yqje2+ysdkye6)/dkye)*1000;


        h10_2逾期监管_逾期监管明细查询.setDkye_贷款余额(sum_余额.intValue());
        h10_2逾期监管_逾期监管明细查询.setYql_逾期率((金额yqje2 + 金额ysdkye6 / sum_余额.intValue())*1000);
        h10_2逾期监管_逾期监管明细查询.setYqlbfb((金额yqje2 + 金额ysdkye6 / sum_余额.intValue())*1000);
        h10_2逾期监管_逾期监管明细查询.setOutput_zxjgbm_办理渠道("");




        Output output = new Output();
        output.setSuccess(true);
     output.setData(Arrays.asList(h10_2逾期监管_逾期监管明细查询));

        return output;
    }





}
