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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
}
