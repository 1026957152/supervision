package org.ylgjj.loan.service;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.LoanCache;
import org.ylgjj.loan.output.H10_1逾期监管_逾期监管汇总查询;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanCacheRepository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class H10_1逾期监管_逾期监管汇总查询ServiceImpl {

    @Autowired
    private LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;
    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private LN005_贷款分户信息_Repository lN005_贷款分户信息RepositoryLN005;
    @Autowired
    private LN014_贷款房屋信息Repository ln014__贷款房屋信息Repository;
    @Autowired
    private LN008_借款人类型Repository ln008_借款人类型Repository;

    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;

    @Autowired
    private PB008_clerk_info_Repository pb008_柜员信息表_repository;



    @Autowired
    private LN001_申请审批信息Repository ln001_申请审批信息Repository;


    @Autowired
    private CM001_单位基本资料表Repository cm001单位基本资料表Repository;
    @Autowired
    private DP008_单位明细账_Repository dp008__单位明细账_repository;
    @Autowired
    private LoanCacheRepository loanCacheRepository;

    public Output H10_1逾期监管_逾期监管汇总查询(String zjbzxbm) {
        //List<DP202_单位缴存变更登记簿> dp021_单位缴存登记薄s = dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期(LocalDate.now());
        List<LoanCache> ln003__合同信息s = loanCacheRepository.findAll();

        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+ ln003__合同信息s.size());

        Map<Integer, List<Triplet<LoanCache, Double,Double>>>  a = ln003__合同信息s.stream().map(e->{
            List<LN005_贷款分户信息> ln005__贷款分户信息s = lN005_贷款分户信息RepositoryLN005.findByloancontrcode合同代码(e.getJkhtbh_合同编号_String());

            Triplet<LoanCache, Double,Double> triplet =
                    Triplet.with(e, e.getDkye_贷款余额_double(), 1.0D);
            return triplet ;

        }).collect(Collectors.toList()).stream().collect(  // 机构分类
                Collectors.groupingBy(e->e.getValue0().getDqyqcs当前逾期次数int())
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
            return a.get(e).stream().mapToDouble(fff->fff.getValue1()).sum();
        }).sum();



   //     Double 金额 = a.keySet().stream().filter(e->e >=1 && e <3).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1().getCurbal_当前余额().doubleValue()).sum()).sum();



        H10_1逾期监管_逾期监管汇总查询 h10_2逾期监管_逾期监管明细查询  = new H10_1逾期监管_逾期监管汇总查询();


        Integer s = a.keySet().stream().filter(e->e >=1 && e <3).mapToInt(e-> a.get(e).size()).sum();
        Double 金额 = a.keySet().stream().filter(e->e >=1 && e <3).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1()).sum()).sum();

        h10_2逾期监管_逾期监管明细查询.setYq1_1个月_含_以上_3个月以下笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYqje1_1个月_含_以上_3个月以下金额(金额);


        s = a.keySet().stream().filter(e->e >=3 && e <6).mapToInt(e-> a.get(e).size()).sum();
        Double 金额yqje2 = a.keySet().stream().filter(e->e >=3 && e <6).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1()).sum()).sum();


        h10_2逾期监管_逾期监管明细查询.setYq2_3个月_含_以上_6个月以下笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYqje2_3个月_含_以上_6个月以下金额(金额yqje2);

        s = a.keySet().stream().filter(e->e >=6 && e <12).mapToInt(e-> a.get(e).size()).sum();
        金额 = a.keySet().stream().filter(e->e >=6 && e <12).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1()).sum()).sum();

        h10_2逾期监管_逾期监管明细查询.setYq3_6个月_含_以上_1年以下笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYqje3_6个月_含_以上_1年以下金额(金额);


        s = a.keySet().stream().filter(e->e >=12 && e <36).mapToInt(e-> a.get(e).size()).sum();
        金额 = a.keySet().stream().filter(e->e >=12 && e <36).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1()).sum()).sum();

        h10_2逾期监管_逾期监管明细查询.setYq4_1年_含_以上_3年以下笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYqje4_1年_含_以上_3年以下金额(金额);

        s = a.keySet().stream().filter(e->e >=36 ).mapToInt(e-> a.get(e).size()).sum();
        金额 = a.keySet().stream().filter(e->e >=36).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1()).sum()).sum();

        h10_2逾期监管_逾期监管明细查询.setYq5_3年_含_以上笔数(s);
        h10_2逾期监管_逾期监管明细查询.setYqje5_3年_含_以上金额(金额);


        金额 = a.keySet().stream().filter(e->e >=6 && e<12).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1()).sum()).sum();
        h10_2逾期监管_逾期监管明细查询.setYqje3_6个月_含_以上_1年以下金额(金额);

        Double 金额ysdkye6 = a.keySet().stream().filter(e->e >=6 ).mapToDouble(e-> a.get(e).stream().mapToDouble(ddd->ddd.getValue1()).sum()).sum();

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
