package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.apis.ApiServiceImpl;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_LN004_合同状态信息_合同状态;
import org.ylgjj.loan.enumT.E_LN008_借款人信息_借款人类型;
import org.ylgjj.loan.domain_flow.ApiCacheAnalysisTable;
import org.ylgjj.loan.domain_flow.MortgagerCache;
import org.ylgjj.loan.output.H6_2抵押办理时间_抵押物明细数据查询;
import org.ylgjj.loan.pojo.QueryH6_2抵押办理时间_抵押物明细数据查询;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.ApiCacheAnalysisTableRepository;
import org.ylgjj.loan.repository_flow.MortgagerCacheRepository;

import javax.validation.Valid;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.ylgjj.loan.history_flow.BaseServiceImpl.chopped;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class H6_2抵押办理时间_抵押物明细数据查询_ServiceImpl {

    @Autowired
    private LN009_抵押物信息_mortgager_goods_info_Repository ln009_抵押物信息_mortgager_goods_info_repository;

    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;


    @Autowired
    private LN005_贷款分户信息_Repository lN005_贷款分户信息RepositoryLN005;


    @Autowired
    private LN008_借款人类型Repository ln008_借款人类型Repository;

    @Autowired
    private ApiServiceImpl apiService;
    @Autowired
    private MortgagerCacheRepository mortgagerCacheRepository;

    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;

    @Autowired
    private ApiCacheAnalysisTableRepository apiCacheAnalysisTableRepository;
    public Map<String, List<LN004_合同状态信息>> dp005_单位分户账Map(List<String> dp) {



        return chopped(dp,1000).stream().map(x->{
            return ln004_合同状态信息Repository.findByLoancontrcodeIn(x)
                    .stream().collect(Collectors.toList());
        }).flatMap(s -> s.stream()).collect(Collectors.groupingBy(r -> r.getLoancontrcode()));



    }

    public Output H6_2抵押办理时间_抵押物明细数据查询(@Valid QueryH6_2抵押办理时间_抵押物明细数据查询 zjbzxbm) {



            ApiCacheAnalysisTable apiCacheAnalysisTable = apiCacheAnalysisTableRepository.findByIndexNo("060201");
            if(apiCacheAnalysisTable.getLastId()== null) {
                ;
                apiService.updateLastId(apiCacheAnalysisTable,cache().toString());

            }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(zjbzxbm.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(zjbzxbm.getJsrq(),df);
        List<MortgagerCache> ln009_抵押物信息mortgager_goods_infos =
                mortgagerCacheRepository.findByDkffrq发放日期Between(ldt_ksrq,ldt_jsrq);


        System.out.println("------------- 找到的 抵押物是多少"+ ln009_抵押物信息mortgager_goods_infos.size());
        Output output = new Output();
        output.setData(ln009_抵押物信息mortgager_goods_infos.stream().map(e->{
            H6_2抵押办理时间_抵押物明细数据查询 h6_2抵押办理时间_抵押物明细数据查询 = new H6_2抵押办理时间_抵押物明细数据查询();



            h6_2抵押办理时间_抵押物明细数据查询.setJkhtbh_借款人合同编号(e.getJkhtbh_借款人合同编号());


            h6_2抵押办理时间_抵押物明细数据查询.setJkrgjjzh_借款人公积金账号(e.getJkrgjjzh_借款人公积金账号());
            h6_2抵押办理时间_抵押物明细数据查询.setJkrxm_借款人姓名(e.getJkrxm_借款人姓名());

            h6_2抵押办理时间_抵押物明细数据查询.setDkffe_贷款金额(e.getDkffe_贷款金额());


                h6_2抵押办理时间_抵押物明细数据查询.setDkll_贷款利率(e.getDkll_贷款利率());
            h6_2抵押办理时间_抵押物明细数据查询.setDksqnx_贷款年限(e.getDksqnx_贷款年限());
            h6_2抵押办理时间_抵押物明细数据查询.setSprq_审批日期(e.getSprq审批日期()+"");
            h6_2抵押办理时间_抵押物明细数据查询.setDkffrq_发放日期(e.getDkffrq发放日期().toString());
            return h6_2抵押办理时间_抵押物明细数据查询;
        }).collect(Collectors.toList()));
        return output;
    }

    public Integer cache() {

        List<LN009_抵押物信息mortgager_goods_info> ln009_抵押物信息mortgager_goods_infos =
                ln009_抵押物信息_mortgager_goods_info_repository.findAll();

        System.out.println("------------- 找到的 抵押物是多少"+ ln009_抵押物信息mortgager_goods_infos.size());

        List<String> list = ln009_抵押物信息mortgager_goods_infos.stream().map(e->e.getLoancontrcode_不可为空_合同代码()).collect(Collectors.toList());

        System.out.println("----------------找到抵押物——————————-"+ ln009_抵押物信息mortgager_goods_infos.size());

        Map<String,List<LN008_借款人信息>> ln008_借款人类型Map =  ln008_借款人类型Repository.findAll()
                .stream().collect(Collectors.groupingBy(e->e.getLoancontrcode合同代码()));


        Map<String,List<LN005_贷款分户信息>> ln005__贷款分户信息Map = lN005_贷款分户信息RepositoryLN005.findAll()
                .stream().collect(Collectors.groupingBy(e->e.getLoancontrcode合同代码()));

        Map<String,List<LN004_合同状态信息>> dp005_单位分户账Map = dp005_单位分户账Map(list);


        Map<String,LN003_合同信息> ln003_合同信息Map = ln003_合同信息_repository.findAll()
                .stream().collect(Collectors.toMap(e->e.getLoancontrcode合同代码(),e->e));


        mortgagerCacheRepository.saveAll(ln009_抵押物信息mortgager_goods_infos.stream()

                //.filter(e->e.getMortstate_不可为空_抵押状态_().equals())
                .map(e->{

            MortgagerCache h6_2抵押办理时间_抵押物明细数据查询 = new MortgagerCache();


            LN003_合同信息 ln003__合同信息 = ln003_合同信息Map.get(e.getLoancontrcode_不可为空_合同代码());

            if(ln003__合同信息 == null){
                System.out.println("---------------------------- 找不到合同信息的抵押物 "+ e.toString());
                return null;
            }

            h6_2抵押办理时间_抵押物明细数据查询.setJkhtbh_借款人合同编号(ln003__合同信息.getLoancontrnum_借款合同号());


            List<LN008_借款人信息> borrower_info_借款人信息s = ln008_借款人类型Map.getOrDefault(e.getLoancontrcode_不可为空_合同代码(),new ArrayList<>());

            LN008_借款人信息 borrower_info_借款人信息 = borrower_info_借款人信息s.stream().filter(bbb->bbb.getLoaneetype_借款人类型().equals(E_LN008_借款人信息_借款人类型.借款人.getText())).findFirst().get();

            h6_2抵押办理时间_抵押物明细数据查询.setJkrgjjzh_借款人公积金账号(borrower_info_借款人信息.getAccnum1账号());
            h6_2抵押办理时间_抵押物明细数据查询.setJkrxm_借款人姓名(borrower_info_借款人信息.getAccname_0_个人姓名());

            h6_2抵押办理时间_抵押物明细数据查询.setDkffe_贷款金额(ln003__合同信息.getLoanamt_贷款金额().doubleValue());



            List<LN005_贷款分户信息> ln005__贷款分户信息s = ln005__贷款分户信息Map.getOrDefault(e.getLoancontrcode_不可为空_合同代码(),new ArrayList<>());


            Optional<LN005_贷款分户信息> ln005_lone_sub_account_贷款分户信息_optional = ln005__贷款分户信息s.stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).findAny();

            if(ln005_lone_sub_account_贷款分户信息_optional.isPresent()){

                LN005_贷款分户信息 ln005__贷款分户信息 = ln005_lone_sub_account_贷款分户信息_optional.get();
                h6_2抵押办理时间_抵押物明细数据查询.setDkll_贷款利率(ln005__贷款分户信息.getCurrate_执行利率());
            }else{
                //   h6_2抵押办理时间_抵押物明细数据查询.setDkll_贷款利率(ln005_lone_sub_account_贷款分户信息.getCurrate_执行利率());
            }

            h6_2抵押办理时间_抵押物明细数据查询.setDksqnx_贷款年限(ln003__合同信息.getLoanterm_贷款期限());

          //  h6_2抵押办理时间_抵押物明细数据查询.setSprq审批日期(e.getCeroutdate_可为空_出证日期());
            h6_2抵押办理时间_抵押物明细数据查询.setDkffrq发放日期(ln003__合同信息.getLoandate放款日期());

            Optional<LN004_合同状态信息> ln004_合同状态信息_02_合同签订 =  dp005_单位分户账Map.get(ln003__合同信息.getLoancontrcode合同代码())
                    .stream().filter(x->x.getLoancontrstate().equals(E_LN004_合同状态信息_合同状态.E_02_合同签订.getText())).findFirst();
            Optional<LN004_合同状态信息> ln004_合同状态信息_06_放款申请 =  dp005_单位分户账Map.get(ln003__合同信息.getLoancontrcode合同代码())
                    .stream().filter(x->x.getLoancontrstate().equals(E_LN004_合同状态信息_合同状态.E_06_放款申请.getText())).findFirst();


            if(ln004_合同状态信息_02_合同签订.isPresent() && ln004_合同状态信息_06_放款申请.isPresent()){

                    Long duration = Duration
                            .between(ln004_合同状态信息_02_合同签订.get().getTransdate().atStartOfDay(),ln004_合同状态信息_06_放款申请.get().getTransdate().atStartOfDay())
                            .toDays();
                h6_2抵押办理时间_抵押物明细数据查询.setDuration(duration);

                }


            return h6_2抵押办理时间_抵押物明细数据查询;
        }).filter(e->e!= null).collect(Collectors.toList()));
        return ln009_抵押物信息mortgager_goods_infos.size();
    }



}
