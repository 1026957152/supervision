package org.ylgjj.loan.history;


import org.javatuples.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.repository_flow.YourHistoryRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ZY每一个单位HistoryerviceImpl")
public class ZYmygdw每一个单位HistoryerviceImpl {


    @Autowired
    private CM002_个人基本资料表Repository cm002个人基本资料表Repository;
    @Autowired
    private DP034_公积金开销户登记簿_Repository dp034_公积金开销户登记簿_repository;


    @Autowired
    private LN008_借款人类型Repository lN008_借款人类型Repository;

    @Autowired
    private LN014_贷款房屋信息Repository ln014__贷款房屋信息Repository;
    @Autowired
    private LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;


    @Autowired
    private DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;


    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private DW025_公积金提取审核登记表_Repository dW025__公积金提取审核登记表_Repository;

    @Autowired
    private DP007_个人分户账_Repository dp007_individual_sub_account个人分户账Repository;
    @Autowired
    private DP006_个人缴存信息表_Repository dp006__个人缴存信息表_repository;


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;


    @Autowired
    private DP204_个人缴存变更登记簿_Repository dp204_个人缴存变更登记簿_repository;
    @Autowired
    private DW145_提取结算登记薄_Repository dw145_提取结算登记薄_repository;


    @Autowired
    private CM081_sms_短信密码签订登记簿_Repository cm081_sms_短信密码签订登记簿_repository;

    @Autowired
    private DP004_单位缴存信息表_Repository dp004_unit_payment_info单位缴存信息表Repository;

    @Autowired
    private DP005_单位分户账_Repository dp005__单位分户账_repository;

    @Autowired
    private CM001_单位基本资料表Repository cm001单位基本资料表Repository;
    @Autowired
    private DP008_单位明细账_Repository dp008__单位明细账_repository;
    @Autowired
    private DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;
    @Autowired
    private PB017_public_flowing公共流水登记簿Repository public_flowing公共流水登记簿Repository;


    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    private LN005_贷款分户信息_Repository lN005_贷款分户信息RepositoryLN005;


    @Autowired
    private YourHistoryRepository yourHistoryRepository;


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;



    @Autowired
    private TR100_转移接续登记簿Repository tr100_转移接续登记簿Repository;

    @Autowired
    private TR003_转移人账户信息_Repository tr003_转移人账户信息_repository;

    @Autowired
    private TR002_联系函基础信息_Repository tr002_联系函基础信息_repository;





    boolean initComplte = false;
    List<DP004_单位缴存信息表> dp004__单位缴存信息表s = null;
    Map<String, DP004_单位缴存信息表> dp004_unit_payment_info_单位缴存信息表Map = null;

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
    Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;
    Map<String, List<LN008_借款人信息>> ln008_borrower_info_借款人信息Map = null;






    public void 流水_单位缴存(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!initComplte) {
            //     dp005_workUnit_单位分户账_repository.findAll();
            dp004__单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findAll();
            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));
            dp005_work_unit_单位分户账Map = dp005__单位分户账_repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitaccnum单位账号(), a -> a));
            dp004_unit_payment_info_单位缴存信息表Map = dp004__单位缴存信息表s.stream().collect(Collectors.toMap(e->e.getUnitaccnum单位账号(), a->a));

            initComplte = true;


        }


        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(localDate);
        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP008_单位明细账> dp008_institution_detail_单位明细账s = dp008__单位明细账_repository.findByTransdate不可为空交易日期(localDate);


        List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);

        Map<String, List<DP021_单位缴存登记簿>> dp021_单位缴存登记簿Map
                = dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum单位账号()));
        Map<String, List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum单位账号()));

        Map<String, List<DP008_单位明细账>> dp008_institution_detail_单位明细账Map
                = dp008_institution_detail_单位明细账s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum不可为空单位账号()));


        Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map
                = dp202_单位缴存变更登记簿s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum不可为空单位账号()));











        dp005__单位分户账_repository.findAll().stream().map(e -> {
            //TODO        获得某一日的缴存列表;


            DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


            return Septet.with(e,
                    cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                    dp021_单位缴存登记簿Map.get(e.getUnitaccnum单位账号()),
                    dp004_unit_payment_info_单位缴存信息表Map.get(e.getUnitaccnum单位账号()),
                    dw025_公积金提取审核登记表Map.get(e.getUnitaccnum单位账号()),

                    dp008_institution_detail_单位明细账Map.get(e.getUnitaccnum单位账号()),
                    dp202_单位缴存变更登记簿Map.get(e.getUnitaccnum单位账号()));
        })              .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                //      S_66_SEQ_暂存款余额_AND_0301008102

                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(o.getValue().stream()


                        .mapToDouble(d->{


                            return d.getValue0().getBal_余额().doubleValue()+
                                    d.getValue2().stream()
                                            .filter(x->x.getInaccdate不可为空入账日期().isAfter(localDate))
                                            .mapToDouble(x->{
                                if(x.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText())){
                                    return x.getUpaytotamt_应缴总额().doubleValue();
                                }else{
                                    return -x.getUprepayamt_预缴户转出金额().doubleValue();
                                }
                            }).sum();


                        }).sum()
                );  //
                loanHistoryRepository.save(loanHistory);






             //   S_4_SEQ_未缴单位数_AND_0301000301("0301","0301000301","未缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                //        S_5_SEQ_实存单位数_AND_0301000401("0301","0301000401","实存单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),



                loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_4_SEQ_未缴单位数_AND_0301000301);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex经济类型(o.getKey()); // 银行名称
                loanHistory.setIntValue(o.getValue().stream()


                        .filter(d->{


                            return d.getValue2().stream()

                                            .filter(x->x.getInaccdate不可为空入账日期().equals(localDate))
                                            .filter(x->x.getBegym_开始年月().equals(localDate))

                                            .mapToInt(x->{
                                                if(x.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText())){
                                                    return 0;
                                                }else{
                                                    return 1;
                                                }
                                            }).sum()> 0;


                        }).count()
                );  //
                loanHistoryRepository.save(loanHistory);



                loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_5_SEQ_实存单位数_AND_0301000401);

                loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                loanHistory.setIndex经济类型(o.getKey()); // 银行名称
                loanHistory.setIntValue(o.getValue().stream()


                        .filter(d->{


                            return d.getValue2().stream()

                                    .filter(x->x.getInaccdate不可为空入账日期().equals(localDate))
                                    .filter(x->x.getBegym_开始年月().equals(localDate))

                                    .mapToInt(x->{
                                        if(x.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText())){
                                            return 1;
                                        }else{
                                            return 0;
                                        }
                                    }).sum()> 0;


                        }).count()
                );  //
                loanHistoryRepository.save(loanHistory);
            });


        });









        dp021_单位缴存登记簿s.stream().collect(Collectors.toList()).stream().map(e -> {
                    //TODO        获得某一日的缴存列表;


                    DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                    return Septet.with(e,
                            cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                            dp005__单位分户账,
                            dp004_unit_payment_info_单位缴存信息表Map.get(e.getUnitaccnum单位账号()),
                            dw025_公积金提取审核登记表Map.get(e.getUnitaccnum单位账号()),

                            dp008_institution_detail_单位明细账Map.get(e.getUnitaccnum单位账号()),
                            dp202_单位缴存变更登记簿Map.get(e.getUnitaccnum单位账号()));
                })

                        .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                    // TODO 按照 经济类型
                    eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                       // S_2_SEQ_实缴单位数_AND_0301000201("0301","0301000201","实缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                          //      S_3_SEQ_实缴单位数__按年___AND_0301000202("0301","0301000202","实缴单位数(按年)"," ","01","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),

                                LoanHistory loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201);


                        loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                        loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                        loanHistory.setIntValue(o.getValue().stream()

                                .filter(x->x.getValue0().getEndym_截止年月().equals(localDate.with(TemporalAdjusters.firstDayOfMonth())))
                                .filter(x->x.getValue0().getBegym_开始年月().equals(localDate.with(TemporalAdjusters.lastDayOfMonth())))
                                .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                        loanHistoryRepository.save(loanHistory);

                        loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_3_SEQ_实缴单位数__按年___AND_0301000202);


                        loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                        loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                        loanHistory.setIntValue(o.getValue().stream()

                                .filter(x->x.getValue0().getEndym_截止年月().equals(localDate.with(TemporalAdjusters.firstDayOfMonth())))
                                .filter(x->x.getValue0().getBegym_开始年月().equals(localDate.with(TemporalAdjusters.lastDayOfMonth())))
                                .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                        loanHistoryRepository.save(loanHistory);


















                     //   S_66_SEQ_暂存款余额_AND_0301008102("0301","0301008102","暂存款余额"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),


                       // S_11_SEQ_缴暂存款净额_AND_0301001001("0301","0301001001","缴暂存款净额"," ","03","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1"," ",false),

                        //S_1_SEQ_暂存款笔数_AND_0301000101("0301","0301000101","暂存款笔数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","04",true),


                        loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101);


                        loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                        loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                        loanHistory.setIntValue(o.getValue().stream()

                                .filter(x->x.getValue0().getEndym_截止年月().equals(localDate.with(TemporalAdjusters.firstDayOfMonth())))
                                .filter(x->x.getValue0().getBegym_开始年月().equals(localDate.with(TemporalAdjusters.lastDayOfMonth())))
                                .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                                .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                        loanHistoryRepository.save(loanHistory);



                        loanHistory  = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_11_SEQ_缴暂存款净额_AND_0301001001);


                        loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                        loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                        loanHistory.setDoubleValue(o.getValue().stream()

                                .filter(x->x.getValue0().getEndym_截止年月().equals(localDate.with(TemporalAdjusters.firstDayOfMonth())))
                                .filter(x->x.getValue0().getBegym_开始年月().equals(localDate.with(TemporalAdjusters.lastDayOfMonth())))
                                //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                                //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                                .mapToDouble(x->{
                                    if(x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText())){
                                        return x.getValue0().getUpaytotamt_应缴总额().doubleValue();
                                    }else{
                                        return -x.getValue0().getUprepayamt_预缴户转出金额().doubleValue();
                                    }

                                }).sum()
                                );  //
                        loanHistoryRepository.save(loanHistory);
                    });


                });


    }





}
