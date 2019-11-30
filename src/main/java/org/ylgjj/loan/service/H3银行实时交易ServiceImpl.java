package org.ylgjj.loan.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.api.H3银行余额查询Controller;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.*;
import org.ylgjj.loan.exception.MyBusinessException;
import org.ylgjj.loan.output.*;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.util.DateUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

/**
 * Created by silence yuan on 2015/7/25.
 */
//TODO 患有 两个
@Service("H3银行实时交易ServiceImpl")
public class H3银行实时交易ServiceImpl  {

    @Autowired
    private AN004Repository an004Repository;
    @Autowired
    private PB010_bank_info_大行信息表Repository pb010_bank_info_大行信息表Repository;

    @Autowired
    FD045_资金划转业务登记文件Repository fd045_资金划转业务登记文件Repository;

    @Autowired
    FD012_银行存款账号登记文件Repository fd012_银行存款账号登记文件Repository;

    @Autowired
    FN090_账户变动通知文件_Repository fn090_账户变动通知文件_repository;



    public Output H_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分(String zjbzxbm) {

        List<PB010_bank_info_大行信息表> pb010_bank_info_大行信息表s = pb010_bank_info_大行信息表Repository.findAll();
        Output output = new Output();
        output.setData(pb010_bank_info_大行信息表s.stream().map(e->{
            H3_1结算监控_银行查询 object = new H3_1结算监控_银行查询();

            object.setMc_银行名称(e.getBanknam1_不可为空_银行简称());
            object.setId_银行logo图片(e.getBanknam1_不可为空_银行简称());
            object.setBm_银行编码(e.getBankcode_不可为空_银行代码());
            return object;
        }).collect(Collectors.toList()));
        return output;
    }

    public Output H_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据(H3银行余额查询Controller.QueryH_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据 query) {

        Page<AN004_单位基本资料表> page = an004Repository.findAll(PageRequest.of(1,10));

        Output output = new Output();
        output.setData(page.getContent().stream().map(e->{
            H3_4资金结算流水查询_查询最近15条结算明细数据 object = new H3_4资金结算流水查询_查询最近15条结算明细数据();


            object.setBlqd_办理渠道(e.getSettletranscode交易渠道码_可为空());
            object.setId_序号(e.getSettlehostsernum结算流水号_可为空());
            object.setJysj_交易时间(e.getTransdate_不可为空_交易日期());
            object.setZhaiyao_摘要(e.getSettletransusage交易用途_可为空());
            return object;
        }).collect(Collectors.toList()));
        return output;
    }


    public Output H_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据(H3银行余额查询Controller.QueryH_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据 query) {
        Page<AN004_单位基本资料表> page = an004Repository.findAll(PageRequest.of(query.getPagenum(),query.getPagesize()));

        Output output = new Output();
        output.setData(page.getContent().stream().map(e->{
            H3_5资金结算流水查询_查询历史结算明细数据 object = new H3_5资金结算流水查询_查询历史结算明细数据();


            object.setBlqd_办理渠道(e.getSettletranscode交易渠道码_可为空());
            object.setId_序号(e.getSettlehostsernum结算流水号_可为空());
            object.setYhmc_银行名称(e.getBANKCODE银行代码_可为空());  // TODO 要银行枚举
            object.setJysj_交易时间(e.getTransdate_不可为空_交易日期());
            object.setZhaiyao_摘要(e.getSettletransusage交易用途_可为空());
            return object;
        }).collect(Collectors.toList()));
        return output;
    }
    private String id_唯一标识;
    private String fsefx_发生额方向; //01：转入，02：支出
    private BigDecimal fse_发生额;
    private BigDecimal ye_余额;
    private String sszh_银行编码;
    public Output H_3_3_银行余额查询_银行实时交易(H3银行余额查询Controller.QueryH_3_3_银行余额查询_银行实时交易 query) {
        List<FD045_资金划转业务登记文件> page = null;//fd045_资金划转业务登记文件Repository.findByTRANSDATE_不可为空_交易日期Between(query.getKsrq(),query.getJsrq());

        Output output = new Output();
        output.setData(page.stream().map(e->{
            H3_3结算监控_银行实时交易 object = new H3_3结算监控_银行实时交易();


/*            object.setId_唯一标识(e.get());
            object.setFsefx_发生额方向(e.getSettlehostsernum结算流水号_可为空());
            object.setFse_发生额(e.getBANKCODE银行代码_可为空());  // TODO 要银行枚举
            object.setYe_余额(e.getTransdate_不可为空_交易日期());
            object.setSszh_银行编码(e.getSettletransusage交易用途_可为空());*/
            return object;
        }).collect(Collectors.toList()));
        return output;
    }







    public Output H_3_2_银行余额查询_银行余额查询(String zjbzxbm) {

        List<FD012_银行存款账号登记文件> fd012_银行存款账号登记文件s = fd012_银行存款账号登记文件Repository.findAll();

        DecimalFormat df = new DecimalFormat("0.0000");
        List<H3_2结算监控_银行余额查询> aaaaa = fd012_银行存款账号登记文件s.stream().map(e->{
            H3_2结算监控_银行余额查询 h8_1银行专户余额_银行专户余额查询 = new H3_2结算监控_银行余额查询();
            h8_1银行专户余额_银行专户余额查询.setBm_银行编码(e.getBANKCODE_不可为空_银行代码());
            h8_1银行专户余额_银行专户余额查询.setMc_银行名称(e.getBANKACCNM_不可为空_银行账户名称());


            Page<FN090_账户变动通知文件> fn090_账户变动通知文件s = fn090_账户变动通知文件_repository.
                    findByBankaccnum不可为空账号OrderByTransdate不可为空写入日期DescBankhostsernum不可为空银行主机流水号Desc(e.getBANKACCNUM_不可为空_银行账号(), PageRequest.of(0, 10));
            ;
            if(!fn090_账户变动通知文件s.getContent().isEmpty()){
                System.out.println("账户余额："+fn090_账户变动通知文件s.getContent().get(0).getCurrbal__不可为空__余额());
                h8_1银行专户余额_银行专户余额查询
                        .setFse_发生额(Double.valueOf(fn090_账户变动通知文件s.getContent().get(0).getCurrbal__不可为空__余额()));

            }else{
                h8_1银行专户余额_银行专户余额查询
                        .setFse_发生额(0);
            }





            return h8_1银行专户余额_银行专户余额查询;

        }).collect(Collectors.toList());
        Output output = new Output();
        output.setData(aaaaa);
        return output;
    }
}
