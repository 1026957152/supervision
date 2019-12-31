package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.config.Constants;
import org.ylgjj.loan.domain.FD045_资金划转业务登记文件;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_FD045_资金划转业务登记文件_划转原因;
import org.ylgjj.loan.history_stream.HistoryServiceImpl;
import org.ylgjj.loan.output.H7_1大额资金监控_监控数据明细查询;
import org.ylgjj.loan.output.H7_2大额资金监控_监控数据明细表格查询_大额资金监控汇总数据查询;
import org.ylgjj.loan.outputenum.SY_H7大额资金监控;
import org.ylgjj.loan.pojo.QueryH_7_2_大额资金监控_大额资金监控汇总数据查询;
import org.ylgjj.loan.repository.FD045_资金划转业务登记文件Repository;
import org.ylgjj.loan.repository.LN009_抵押物信息_mortgager_goods_info_Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H7大额资金监控ServiceImpl")
public class H7大额资金监控ServiceImpl extends HistoryServiceImpl {


    @Autowired
    private FD045_资金划转业务登记文件Repository fd045_资金划转业务登记文件Repository;






    public Output H_7_1_大额资金监控_监控数据明细查询(String zjbzxbm, String ksrq, String jsrq) {

       // List<FD045_资金划转业务登记文件>  fd045_资金划转业务登记文件s = fd045_资金划转业务登记文件Repository.findByTRANSDATE不可为空交易日期(LocalDate.now(),LocalDate.now());


        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(ksrq,df);
        LocalDate ldt_jsrq = LocalDate.parse(jsrq,df);

        List<FD045_资金划转业务登记文件>  fd045_资金划转业务登记文件s = fd045_资金划转业务登记文件Repository.findByTRANSDATE不可为空交易日期Between(ldt_ksrq,ldt_jsrq);




        ;



        Output output = new Output();
        output.setSuccess(true);
        output.setData(fd045_资金划转业务登记文件s.stream().collect(Collectors.groupingBy(e->{
            return E_FD045_资金划转业务登记文件_划转原因.fromString(e.getTRANSFERREASON_可为空_划转原因());
        })).entrySet().stream().map(x->{



            Map<SY_H7大额资金监控, List<FD045_资金划转业务登记文件>> map =  x.getValue()

                    .stream()

                    .collect(Collectors.groupingBy(e->{
                        // e.getTRANSFERREASON_可为空_划转原因();

                        double a = e.getTRANSFERAMT不可为空划转金额();

                        a = a/10000;
                        if( a <500){
                            return SY_H7大额资金监控.je0_金额_500以下;
                        }else
                        if(a>=500 && a <1000){
                            return SY_H7大额资金监控.je1_金额_500__1000;
                        }else
                        if(a>=1000 && a <1500){
                            return SY_H7大额资金监控.je2_金额_1000__1500;
                        }else
                        if(a>=1500 && a <2000){
                            return SY_H7大额资金监控.je3_金额_1500__2000;
                        }else{
                            return SY_H7大额资金监控.je4_金额_2000以上;
                        }
                        //  if(a>=2000){

                        //  }

                    }));

            H7_1大额资金监控_监控数据明细查询 h7_1大额资金监控_监控数据明细查询 = new H7_1大额资金监控_监控数据明细查询();
            h7_1大额资金监控_监控数据明细查询.setZjytmc_业务类型(x.getKey().getDisplayText());
            h7_1大额资金监控_监控数据明细查询.setZjytbm_业务类型编码(x.getKey().getText());
            if(map.get(SY_H7大额资金监控.je1_金额_500__1000)!= null){
                h7_1大额资金监控_监控数据明细查询.
                        setJe1_金额_500_1000(BigDecimal.valueOf(map.get(SY_H7大额资金监控.je1_金额_500__1000).stream().mapToDouble(e->e.getTRANSFERAMT不可为空划转金额()).sum()).toPlainString());

            }else{
                h7_1大额资金监控_监控数据明细查询.
                        setJe1_金额_500_1000("0");
            }
            if(map.get(SY_H7大额资金监控.je2_金额_1000__1500)!= null){
                h7_1大额资金监控_监控数据明细查询.
                        setJe2_金额_1000_1500(BigDecimal.valueOf(map.get(SY_H7大额资金监控.je2_金额_1000__1500).stream().mapToDouble(e->e.getTRANSFERAMT不可为空划转金额()).sum()).toPlainString());

            }else{
                h7_1大额资金监控_监控数据明细查询.
                        setJe2_金额_1000_1500("0");
            }
            if(map.get(SY_H7大额资金监控.je3_金额_1500__2000)!= null){
                h7_1大额资金监控_监控数据明细查询.setJe3_金额_1500_2000(BigDecimal.valueOf(map.get(SY_H7大额资金监控.je3_金额_1500__2000).stream().mapToDouble(e->e.getTRANSFERAMT不可为空划转金额()).sum()).toPlainString());

            }else{
                h7_1大额资金监控_监控数据明细查询.
                        setJe3_金额_1500_2000("0");
            }
            if(map.get(SY_H7大额资金监控.je4_金额_2000以上)!= null){
                h7_1大额资金监控_监控数据明细查询.setJe4_金额_2000以上(BigDecimal.valueOf(map.get(SY_H7大额资金监控.je4_金额_2000以上).stream().mapToDouble(e->e.getTRANSFERAMT不可为空划转金额()).sum()).toPlainString());

            }else{
                h7_1大额资金监控_监控数据明细查询.
                        setJe4_金额_2000以上("0");
            }

            return h7_1大额资金监控_监控数据明细查询;
        }).collect(Collectors.toList()));
        return output;

    }

    public Output H_7_2_大额资金监控_大额资金监控汇总数据查询(QueryH_7_2_大额资金监控_大额资金监控汇总数据查询 query) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df);
       // fd045_资金划转业务登记文件Repository.

    //    List<FD045_资金划转业务登记文件>  fd045_资金划转业务登记文件s = fd045_资金划转业务登记文件Repository.findByDAMT不可为空借方发生额Between(query.getKsje().doubleValue(),query.getJsje().doubleValue());
        List<FD045_资金划转业务登记文件>  fd045_资金划转业务登记文件s = fd045_资金划转业务登记文件Repository.findByTRANSDATE不可为空交易日期Between(ldt_ksrq,ldt_jsrq);

        List map =  fd045_资金划转业务登记文件s.stream().
                map(e->{

                    H7_2大额资金监控_监控数据明细表格查询_大额资金监控汇总数据查询 h7_1大额资金监控_监控数据明细查询 = new H7_2大额资金监控_监控数据明细表格查询_大额资金监控汇总数据查询();

                    System.out.println("-------------------"+e.toString());
                    System.out.println("-------------------"+pb008_柜员信息表Map().toString());
                    h7_1大额资金监控_监控数据明细查询.setJgmc_机构名称(e.getAGENTINSTCODE_可为空_经办机构());
                    h7_1大额资金监控_监控数据明细查询.setSpczy_审批人(pb008_柜员信息表Map().get(e.getAGENTOP_可为空_经办柜员().trim()).getOpname());
                    h7_1大额资金监控_监控数据明细查询.setSprq_审批日期(e.getTRANSDATE不可为空交易日期().toString());
                    h7_1大额资金监控_监控数据明细查询.setZjytbm_业务类型编码(e.getTRANSFERREASON_可为空_划转原因());
                    h7_1大额资金监控_监控数据明细查询.setZjytmc_业务类型(e.getTRSINFUNDKIND_不可为空_转入资金性质1());
                    h7_1大额资金监控_监控数据明细查询.setSyje_金额_万元(BigDecimal.valueOf(e.getTRANSFERAMT不可为空划转金额()).toPlainString());
                    h7_1大额资金监控_监控数据明细查询.setSkzhhm_收款户名(e.getTRSINBANKACC_不可为空_转入银行账户());
                    h7_1大额资金监控_监控数据明细查询.setSkkhyh_收款银行(pb011_银行信息表Map().get(e.getTRSINBANK_不可为空_转入银行()).getBankname());

                    h7_1大额资金监控_监控数据明细查询.setFkzhhm_付款户名(e.getTRSOUTINST_不可为空_转出机构());
                    h7_1大额资金监控_监控数据明细查询.setFkkhyh_付款银行(pb011_银行信息表Map().get(e.getTRSOUTBANK_不可为空_转出银行()).getBankname());
                    h7_1大额资金监控_监控数据明细查询.setYhzh_付款账号(e.getTRSOUTBANKACC_不可为空_转出银行账户());

                    h7_1大额资金监控_监控数据明细查询.setSquname_发起人(pb008_柜员信息表Map().get(e.getAGENTOP_可为空_经办柜员()).getOpname());

                    h7_1大额资金监控_监控数据明细查询.setBz_备注(e.getTRANSFERREASON_可为空_划转原因());
                    h7_1大额资金监控_监控数据明细查询.setZjbzxbm_住建部中心编码(Constants.zjbzxbm_住建部中心编码);



                    return h7_1大额资金监控_监控数据明细查询;

                }).collect(Collectors.toList());


        Output output = new Output();
        output.setData(map);
        return output;
    }
}
