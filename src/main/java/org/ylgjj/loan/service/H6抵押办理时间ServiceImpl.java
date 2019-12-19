package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.LoaneeTypeEnum;
import org.ylgjj.loan.output.H6_1抵押办理时间_抵押物数据查询;
import org.ylgjj.loan.output.H6_2抵押办理时间_抵押物明细数据查询;
import org.ylgjj.loan.pojo.QueryH6_2抵押办理时间_抵押物明细数据查询;
import org.ylgjj.loan.repository.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H6抵押办理时间ServiceImpl")
public class H6抵押办理时间ServiceImpl {

    @Autowired
    private LN009_抵押物信息_mortgager_goods_info_Repository ln009_抵押物信息_mortgager_goods_info_repository;

    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;


    @Autowired
    private LN005_贷款分户信息_Repository lN005_贷款分户信息RepositoryLN005;


    @Autowired
    private LN008_借款人类型Repository ln008_借款人类型Repository;


    public Output H6_1抵押办理时间_抵押物数据查询(String zjbzxbm) {
        List<LN009_抵押物信息mortgager_goods_info> ln009_抵押物信息mortgager_goods_infos = ln009_抵押物信息_mortgager_goods_info_repository.findTop100By();

        H6_1抵押办理时间_抵押物数据查询 h6_1抵押办理时间_抵押物数据查询 = new H6_1抵押办理时间_抵押物数据查询();

        h6_1抵押办理时间_抵押物数据查询.setDay1_7天以内_varchar__20___输出("");
        h6_1抵押办理时间_抵押物数据查询.setDay2_7__15天_varchar__20___输出("");
        h6_1抵押办理时间_抵押物数据查询.setDay3_15__30天_varchar__20___输出("");
        h6_1抵押办理时间_抵押物数据查询.setDay4_30天以上_varchar__20___输出("");
        h6_1抵押办理时间_抵押物数据查询.setZjbzxbm_住建部中心编码_varchar__60___输出("");


        Output output = new Output();
        output.setData(Arrays.asList(h6_1抵押办理时间_抵押物数据查询));
        return output;
    }

    public Output H6_2抵押办理时间_抵押物明细数据查询(@Valid QueryH6_2抵押办理时间_抵押物明细数据查询 zjbzxbm) {


        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(zjbzxbm.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(zjbzxbm.getJsrq(),df);
        List<LN009_抵押物信息mortgager_goods_info> ln009_抵押物信息mortgager_goods_infos =
                ln009_抵押物信息_mortgager_goods_info_repository.findByTransdate不可为空交易日期Between(ldt_ksrq,ldt_jsrq);


        System.out.println("------------- 找到的 抵押物是多少"+ ln009_抵押物信息mortgager_goods_infos.size());
        Output output = new Output();
        output.setData(ln009_抵押物信息mortgager_goods_infos.stream().map(e->{
            H6_2抵押办理时间_抵押物明细数据查询 h6_2抵押办理时间_抵押物明细数据查询 = new H6_2抵押办理时间_抵押物明细数据查询();


            LN003_合同信息 ln003__合同信息 = ln003_合同信息_repository.findByLoancontrcode合同代码(e.getLoancontrcode_不可为空_合同代码());

            h6_2抵押办理时间_抵押物明细数据查询.setJkhtbh_借款人合同编号(ln003__合同信息.getLoancontrnum_借款合同号());



            List<LN008_借款人信息> borrower_info_借款人信息s = ln008_借款人类型Repository.findByloancontrcode合同代码(e.getLoancontrcode_不可为空_合同代码());

            LN008_借款人信息 borrower_info_借款人信息 = borrower_info_借款人信息s.stream().filter(bbb->bbb.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText())).findFirst().get();

            h6_2抵押办理时间_抵押物明细数据查询.setJkrgjjzh_借款人公积金账号(borrower_info_借款人信息.getAccnum1账号());
            h6_2抵押办理时间_抵押物明细数据查询.setJkrxm_借款人姓名(borrower_info_借款人信息.getAccname_0_个人姓名());

            h6_2抵押办理时间_抵押物明细数据查询.setDkffe_贷款金额(ln003__合同信息.getLoanamt_贷款金额().doubleValue());



            List<LN005_贷款分户信息> ln005__贷款分户信息s = lN005_贷款分户信息RepositoryLN005.findByloancontrcode合同代码(e.getLoancontrcode_不可为空_合同代码());
            Optional<LN005_贷款分户信息> ln005_lone_sub_account_贷款分户信息_optional = ln005__贷款分户信息s.stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).findAny();

            if(ln005_lone_sub_account_贷款分户信息_optional.isPresent()){

                LN005_贷款分户信息 ln005__贷款分户信息 = ln005_lone_sub_account_贷款分户信息_optional.get();
                h6_2抵押办理时间_抵押物明细数据查询.setDkll_贷款利率(ln005__贷款分户信息.getCurrate_执行利率());
            }else{
                //   h6_2抵押办理时间_抵押物明细数据查询.setDkll_贷款利率(ln005_lone_sub_account_贷款分户信息.getCurrate_执行利率());

            }

            h6_2抵押办理时间_抵押物明细数据查询.setDksqnx_贷款年限(ln003__合同信息.getLoanterm_贷款期限());


            h6_2抵押办理时间_抵押物明细数据查询.setSprq_审批日期(e.getCeroutdate_可为空_出证日期());
            h6_2抵押办理时间_抵押物明细数据查询.setDkffrq_发放日期("");
            return h6_2抵押办理时间_抵押物明细数据查询;
        }).collect(Collectors.toList()));
        return output;
    }



}
