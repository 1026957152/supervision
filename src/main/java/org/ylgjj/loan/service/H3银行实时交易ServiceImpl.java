package org.ylgjj.loan.service;


import org.apache.commons.io.IOUtils;
import org.javatuples.Quartet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.history_stream.HistoryServiceImpl;
import org.ylgjj.loan.output.*;
import org.ylgjj.loan.outputenum.E_银行编码_HX;
import org.ylgjj.loan.pojo.QueryH_3_2_银行余额查询_银行余额查询;
import org.ylgjj.loan.pojo.QueryH_3_3_银行余额查询_银行实时交易;
import org.ylgjj.loan.pojo.QueryH_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据;
import org.ylgjj.loan.pojo.QueryH_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据;
import org.ylgjj.loan.repository.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */
//TODO 患有 两个
@Service
public class H3银行实时交易ServiceImpl extends HistoryServiceImpl {

    @Autowired
    private AN004Repository an004Repository;
    @Autowired
    private PB010_大行信息表Repository pb010__大行信息表Repository;

    @Autowired
    FD045_资金划转业务登记文件Repository fd045_资金划转业务登记文件Repository;

    @Autowired
    FD012_银行存款账号登记文件Repository fd012_银行存款账号登记文件Repository;

    @Autowired
    FN090_账户变动通知文件_Repository fn090_账户变动通知文件_repository;

    @Autowired
    PB011_银行信息表Repository pb011_银行信息表_repository;



    @Autowired
    ResourceLoader resourceLoader;

    public Output H_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分(String zjbzxbm) {

        Arrays.stream(E_银行编码_HX.values()).forEach(e->{

        });


        List<PB010_大行信息表> pb010__大行信息表s = pb010__大行信息表Repository.findAll();
        Output output = new Output();
        output.setData(pb010__大行信息表s.stream().map(e->{
            H3_1结算监控_银行查询 object = new H3_1结算监控_银行查询();

            object.setMc_银行名称(e.getBanknam1_不可为空_银行简称());

            Resource resource = resourceLoader.getResource("classpath:banklogo/"+E_银行编码_HX.fromString(e.getBankcode_不可为空_银行代码()).getLogoPath());

            try {
                InputStream input = resource.getInputStream();
                byte[] bytes = IOUtils.toByteArray(input);

                String encoded = Base64.getEncoder().encodeToString(bytes);
                object.setId_银行logo图片(encoded);

                File file = resource.getFile();
            } catch (IOException ee) {
                ee.printStackTrace();
            }
            object.setBm_银行编码(e.getBankcode_不可为空_银行代码());
            return object;
        }).collect(Collectors.toList()));
        return output;
    }

    public Output H_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据(QueryH_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据 query) {

        Page<AN004_单位基本资料表> page = an004Repository.findAllByOrderByTransdate不可为空交易日期Desc(PageRequest.of(1,15));

        Output output = new Output();
        output.setSuccess(true);
        output.setData(page.getContent()
                .stream()
                .filter(e->{

                    if( pb010_大行信息表Map().get("00"+e.getBANKCODE银行代码_可为空().trim()) != null){
                        return true;
                    }else{
                        System.out.println("=============:"+"00"+e.getBANKCODE银行代码_可为空());
                        return false;
                    }
                })

                .map(e->{
            H3_4资金结算流水查询_查询最近15条结算明细数据 object = new H3_4资金结算流水查询_查询最近15条结算明细数据();



                    LocalDateTime ldt = LocalDateTime.parse(e.getMACHINETIME交易时间_可为空().substring(0,19), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    String out2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ldt);

                    object.setBlqd_办理渠道(e.getSettletranscode交易渠道码_可为空());
            object.setYhmc_银行名称(pb010_大行信息表Map().get("00"+e.getBANKCODE银行代码_可为空().trim()).getBANKNAME_不可为空_银行名称());
            object.setId_序号(e.getSettlehostsernum结算流水号_可为空());
            object.setJysj_交易时间(out2);
            object.setZhaiyao_摘要(e.getPayerbankaccnm付款人户名_可为空()+" 转出到 "+e.getPayeebankaccnm收款人户名_可为空()+","+e.getSettletransusage交易用途_可为空()+" "+e.getReason描述_可为空());
            return object;
        }).collect(Collectors.toList()));
        return output;
    }


    public Output H_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据(QueryH_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据 query) {
        Page<AN004_单位基本资料表> page = an004Repository.findAll(PageRequest.of(query.getPagenum(),query.getPagesize()));

        Output output = new Output();
        output.setData(page.getContent().stream().map(e->{
            H3_5资金结算流水查询_查询历史结算明细数据 object = new H3_5资金结算流水查询_查询历史结算明细数据();


            object.setBlqd_办理渠道(e.getSettletranscode交易渠道码_可为空());
            object.setId_序号(e.getSettlehostsernum结算流水号_可为空());
            object.setYhmc_银行名称(e.getBANKCODE银行代码_可为空());  // TODO 要银行枚举
            object.setJysj_交易时间(e.getTransdate不可为空交易日期());
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


    public Output H_3_3_银行余额查询_银行实时交易(QueryH_3_3_银行余额查询_银行实时交易 query) {

     //   List<FD012_银行存款账号登记文件> fd012_银行存款账号登记文件s = fd012_银行存款账号登记文件Repository.findAll();
/*        Map<String,FD012_银行存款账号登记文件> fd012_银行存款账号登记文件Map = fd012_银行存款账号登记文件Repository
                .findAll().stream().collect(Collectors.groupingBy(e->e.getBANKACCNUM_不可为空_银行账号().trim()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e->e.getKey(),e->e.getValue().get(0)));*/
        DateTimeFormatter df_ = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df_);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df_);

        List<FN090_账户变动通知文件> fn090_账户变动通知文件s  = fn090_账户变动通知文件_repository.findByTransdate不可为空写入日期Between(ldt_ksrq,ldt_jsrq);

        System.out.println("--------------"+fn090_账户变动通知文件s.size());
        Output output = new Output();
        output.setSuccess(true);

        ;;

        output.setData(fn090_账户变动通知文件s
                .stream()
                .filter(e->{
                    if(fd012_银行存款账号登记文件Map().get(e.getBankaccnum不可为空账号().trim())!= null){
                        return true;
                    }else{
                        System.out.println("-找不到银行账户-------------------"+e.getBankaccnum不可为空账号());
                        return false;
                    }
                })
                .collect(Collectors.groupingBy(e->{
                    return pb011_银行信息表Map().get(fd012_银行存款账号登记文件Map().get(e.getBankaccnum不可为空账号()).getBANKCODE_不可为空_银行代码()).getSUPERBANKCODE();
                }))
                .entrySet()
                .stream()
                .map(e->{
                    H3_3结算监控_银行实时交易 object = new H3_3结算监控_银行实时交易();


                    // object.setId_唯一标识(e.getBankhostsernum不可为空银行主机流水号());
                    //  object.setFsefx_发生额方向(e.getAmt__不可为空__金额()>0?"01":"02") ;  //01：转入，02：支出
                    object.setFse_发生额(BigDecimal.valueOf(e.getValue().stream().mapToDouble(x->x.getAmt__不可为空__金额()).sum()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());//e.getValue().getAmt__不可为空__金额());  // TODO 要银行枚举
                    object.setYe_余额(BigDecimal.valueOf(e.getValue().stream().sorted(Comparator.comparingLong(x -> -x.getTransdate不可为空写入日期().toEpochDay())).findFirst().get().getCurrbal__不可为空__余额()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
                    //    object.setSszh_银行编码(fd012_银行存款账号登记文件Map.get(e.getBankaccnum不可为空账号().trim()).getBANKCODE_不可为空_银行代码());
                    object.setBm(e.getKey());
                    object.setMc(pb010_大行信息表Map().get(e.getKey()).getBANKNAME_不可为空_银行名称());
                    object.setSszh_银行编码(e.getKey());
                    return object;
                }).collect(Collectors.toList()));
        return output;
    }







    public Output H_3_2_银行余额查询_银行余额查询(@Valid QueryH_3_2_银行余额查询_银行余额查询 query) {

        List<FD012_银行存款账号登记文件> fd012_银行存款账号登记文件s = fd012_银行存款账号登记文件Repository.findAll();


        DecimalFormat df = new DecimalFormat("0.0000");



   /*

        List<H3_2结算监控_银行余额查询> aaaaa = fd012_银行存款账号登记文件s.stream().map(e->{



            H3_2结算监控_银行余额查询 h8_1银行专户余额_银行专户余额查询 = new H3_2结算监控_银行余额查询();
            h8_1银行专户余额_银行专户余额查询.setBm_银行编码(e.getBANKCODE_不可为空_银行代码());
            ;
            //h8_1银行专户余额_银行专户余额查询.setMc_银行名称(e.getBANKACCNM_不可为空_银行账户名称());

            h8_1银行专户余额_银行专户余额查询.setMc_银行名称(pb011_bank_infoMap.get(e.getBANKCODE_不可为空_银行代码()).getBanknam1());

            Page<FN090_账户变动通知文件> fn090_账户变动通知文件s = fn090_账户变动通知文件_repository.
                    findByBankaccnum不可为空账号OrderByTransdate不可为空写入日期DescBankhostsernum不可为空银行主机流水号Desc(e.getBANKACCNUM_不可为空_银行账号(), PageRequest.of(0, 10));
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



*/


        DateTimeFormatter df_ = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df_);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df_);

        List<FN090_账户变动通知文件> fn090_账户变动通知文件s  = fn090_账户变动通知文件_repository.findByTransdate不可为空写入日期Between(ldt_ksrq,ldt_jsrq);





        Output output = new Output();
        output.setData(fd012_银行存款账号登记文件s.stream().map(e->{


            double 支出额= fn090_账户变动通知文件s.stream()
                    .filter(x->x.getBankaccnum不可为空账号().equals(e.getBANKACCNUM_不可为空_银行账号()))
                    .filter(x->x.getAmt__不可为空__金额()<0)
                    .mapToDouble(x-> x.getAmt__不可为空__金额()).sum();
            double 收入额= fn090_账户变动通知文件s.stream()
                    .filter(x->x.getBankaccnum不可为空账号().equals(e.getBANKACCNUM_不可为空_银行账号()))
                    .filter(x->x.getAmt__不可为空__金额()>0)
                    .mapToDouble(x-> x.getAmt__不可为空__金额()).sum();
            double 发生额 = abs(支出额) + abs(收入额);

            return Quartet.with(e,发生额,abs(收入额),abs(支出额));


        }).collect(Collectors.groupingBy(e->pb011_银行信息表Map().get(e.getValue0().getBANKCODE_不可为空_银行代码()).getSUPERBANKCODE()))

                .entrySet().stream()
                .map(e->{
                    H3_2结算监控_银行余额查询 h8_1银行专户余额_银行专户余额查询 = new H3_2结算监控_银行余额查询();
                    h8_1银行专户余额_银行专户余额查询.setBm_银行编码(e.getKey());
                    h8_1银行专户余额_银行专户余额查询.setMc_银行名称(pb010_大行信息表Map().get(e.getKey()).getBANKNAME_不可为空_银行名称());
                    h8_1银行专户余额_银行专户余额查询
                            .setFse_发生额(BigDecimal.valueOf(e.getValue().stream().mapToDouble(x->x.getValue1()).sum()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
                    h8_1银行专户余额_银行专户余额查询
                            .setSre_收入额(BigDecimal.valueOf(e.getValue().stream().mapToDouble(x->x.getValue2()).sum()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());

                    h8_1银行专户余额_银行专户余额查询
                            .setZce_支出额(BigDecimal.valueOf(e.getValue().stream().mapToDouble(x->x.getValue3()).sum()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
                    return h8_1银行专户余额_银行专户余额查询;
                }).collect(Collectors.toList()));
        return output;
    }
}
