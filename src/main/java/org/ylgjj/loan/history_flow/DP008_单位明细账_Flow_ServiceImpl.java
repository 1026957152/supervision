package org.ylgjj.loan.history_flow;


import org.javatuples.Septet;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Math.abs;
import static org.ylgjj.loan.history_flow.DP021_单位缴存登记簿_Flow_HistoryerviceImpl.run统计周期编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("DP008_单位明细账_Flow_ServiceImpl")
public class DP008_单位明细账_Flow_ServiceImpl {


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
    private PB017_公共流水登记簿_Repository public_flowing公共流水登记簿Repository;











    @Autowired
    private LoanHistoryRepository loanHistoryRepository;





    boolean initComplte = false;
    List<DP004_单位缴存信息表> dp004__单位缴存信息表s = null;

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
    Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;
    Map<String, List<LN008_借款人信息>> ln008_borrower_info_借款人信息Map = null;

    //TODO 历史倒推

    public void 历史倒推_某一日的缴存(LocalDate beginDateTotal,LocalDate endDateTotal) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!initComplte) {
            //     dp005_workUnit_单位分户账_repository.findAll();
            dp004__单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findAll();
            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));
            dp005_work_unit_单位分户账Map = dp005__单位分户账_repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitaccnum单位账号(), a -> a));


            initComplte = true;


        }


        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(beginDateTotal);
        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(beginDateTotal);
        List<DP008_单位明细账> DP008_单位明细账s = dp008__单位明细账_repository.findByTransdate不可为空交易日期(beginDateTotal);


        List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期(beginDateTotal);

        Map<String, List<DP021_单位缴存登记簿>> dp021_单位缴存登记簿Map
                = dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum单位账号()));
        Map<String, List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum单位账号()));

        Map<String, List<DP008_单位明细账>> DP008_单位明细账Map
                = DP008_单位明细账s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum不可为空单位账号()));


        Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map
                = dp202_单位缴存变更登记簿s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum不可为空单位账号()));










        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_5_SEQ_实存单位数_AND_0301000401);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();




            DP008_单位明细账s
                    .stream()
                    .filter(x->x.getTransdate不可为空交易日期().isAfter(beginDate) && x.getTransdate不可为空交易日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;


                DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum不可为空单位账号());


                return Triplet.with(e,
                        cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                        dp005__单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    // S_2_SEQ_实缴单位数_AND_0301000201("0301","0301000201","实缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    //      S_3_SEQ_实缴单位数__按年___AND_0301000202("0301","0301000202","实缴单位数(按年)"," ","01","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),


                    //      S_66_SEQ_暂存款余额_AND_0301008102
                    LoanHistory loanHistory = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_5_SEQ_实存单位数_AND_0301000401);

                    ; //增加 实存单位数;



                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex经济类型(o.getKey()); // 银行名称
                    loanHistory.setIntValue(o.getValue().stream().collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).entrySet().stream()
                            .mapToInt(p-> {

                                return p.getValue().stream().mapToInt(j -> {
                                    if (j.getValue0().getBal_0_不可为空_余额() == 0 && j.getValue0().getLbal_0_不可为空_上笔余额() > 0)
                                        return -1;
                                    if (j.getValue0().getBal_0_不可为空_余额() > 0 && j.getValue0().getLbal_0_不可为空_上笔余额() == 0)
                                        return 1;
                                    return 0;
                                }).sum();

                            }).sum());  //
                    loanHistoryRepository.save(loanHistory);


                });


            });




        });











        DP008_单位明细账s.stream().collect(Collectors.toList()).stream().map(e -> {
                    //TODO        获得某一日的缴存列表;


                    DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum不可为空单位账号());


                    return Septet.with(e,
                            cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                            dp005__单位分户账,
                            dp021_单位缴存登记簿Map.get(e.getUnitaccnum不可为空单位账号()),
                            dw025_公积金提取审核登记表Map.get(e.getUnitaccnum不可为空单位账号()),

                            DP008_单位明细账Map.get(e.getUnitaccnum不可为空单位账号()),
                            dp202_单位缴存变更登记簿Map.get(e.getUnitaccnum不可为空单位账号()));
                }).collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {
            String 机构编码 = eee.getKey();






        });

    }















    }
