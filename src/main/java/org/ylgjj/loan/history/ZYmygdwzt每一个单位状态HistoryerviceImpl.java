package org.ylgjj.loan.history;


import org.javatuples.Septet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.E_DP202_单位缴存变更登记簿_变更类型;
import org.ylgjj.loan.domain_flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.util.DateUtilsss;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ZY每一个单位状态HistoryerviceImpl")
public class ZYmygdwzt每一个单位状态HistoryerviceImpl {


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

    public List<Septet<DP004_单位缴存信息表,
            CM001_单位基本资料表,
            DP005_单位分户账,

            List<DP021_单位缴存登记簿>,
            List<DW025_公积金提取审核登记表>,

            List<DP008_单位明细账>,
            List<DP202_单位缴存变更登记簿>>> 历史倒推_某一日的缴存(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (!initComplte) {
            //     dp005_workUnit_单位分户账_repository.findAll();
            dp004__单位缴存信息表s = dp004_unit_payment_info单位缴存信息表Repository.findAll();
            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));
            dp005_work_unit_单位分户账Map = dp005__单位分户账_repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitaccnum单位账号(), a -> a));


            initComplte = true;


        }


        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(localDate);
        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP008_单位明细账> DP008_单位明细账s = dp008__单位明细账_repository.findByTransdate不可为空交易日期(localDate);


        List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);

        Map<String, List<DP021_单位缴存登记簿>> dp021_单位缴存登记簿Map
                = dp021_单位缴存登记簿s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum单位账号()));
        Map<String, List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum单位账号()));

        Map<String, List<DP008_单位明细账>> DP008_单位明细账Map
                = DP008_单位明细账s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum不可为空单位账号()));


        Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map
                = dp202_单位缴存变更登记簿s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum不可为空单位账号()));

        //List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期Between(ldt_ksrq,ldt_jsrq);


        return dp004__单位缴存信息表s.stream().collect(Collectors.toList()).stream().map(e -> {
                    //TODO        获得某一日的缴存列表;


                    DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


                    return Septet.with(e,
                            cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                            dp005__单位分户账,
                            dp021_单位缴存登记簿Map.get(e.getUnitaccnum单位账号()),
                            dw025_公积金提取审核登记表Map.get(e.getUnitaccnum单位账号()),

                            DP008_单位明细账Map.get(e.getUnitaccnum单位账号()),
                            dp202_单位缴存变更登记簿Map.get(e.getUnitaccnum单位账号()));
                }).collect(Collectors.toList());

    }













    //TODO 存储统计信息
    @Transactional
    public void saveHistoryOneTime(LocalDate n, List<Septet<
            DP004_单位缴存信息表,
            CM001_单位基本资料表, DP005_单位分户账,

            List<DP021_单位缴存登记簿>,
            List<DW025_公积金提取审核登记表>,
            List<DP008_单位明细账>,
            List<DP202_单位缴存变更登记簿>>> inputs) {

        inputs.stream().collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {
            String 机构编码 = eee.getKey();




/*

            S_6_SEQ_新增单位数_AND_0301000501("0301","0301000501","新增单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    S_7_SEQ_销户单位数_AND_0301000601("0301","0301000601","销户单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    S_8_SEQ_封存单位数_AND_0301000701("0301","0301000701","封存单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),


                    S_9_SEQ_缓缴单位数_AND_0301000801("0301","0301000801","缓缴单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),


*/



                    // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {



                LoanHistory loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_6_SEQ_新增单位数_AND_0301000501);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setIntValue(o.getValue().stream().map(h->h.getValue2().getOpnaccdate开户日期().equals(n)).count()); // 银行名称
                loanHistoryRepository.save(loanHistory);


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_7_SEQ_销户单位数_AND_0301000601);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setIntValue(o.getValue().stream().map(h->h.getValue6().stream().
                        filter(i->{
                            return i.getTransdate不可为空交易日期().equals(n)
                                    && i.getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_5_正常状态销户);
                        }) )
                        .count()); // 银行名称
                loanHistoryRepository.save(loanHistory);



                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_8_SEQ_封存单位数_AND_0301000701);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setIntValue(o.getValue().stream().map(h->h.getValue6().stream().
                        filter(i->{
                            return i.getTransdate不可为空交易日期().equals(n)
                                    && i.getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_4_封存);
                        }) )
                        .count()); // 银行名称
                loanHistoryRepository.save(loanHistory);







                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_8_SEQ_封存单位数_AND_0301000701);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setIntValue(o.getValue().stream().map(h->h.getValue6().stream().
                        filter(i->{
                            return i.getTransdate不可为空交易日期().equals(n)
                                    && i.getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_4_封存);
                        }) )
                        .count()); // 银行名称
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_8_SEQ_封存单位数_AND_0301000701);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setIntValue(o.getValue().stream().map(h->h.getValue6().stream().
                        filter(i->{
                            return i.getTransdate不可为空交易日期().equals(n)
                                    && i.getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_4_封存);
                        }) )
                        .count()); // 银行名称
                loanHistoryRepository.save(loanHistory);




                Map<String,List<String>> result = o.getValue().stream().map(h->   Collections.max(h.getValue6().stream().
                        filter(i->{
                            return i.getTransdate不可为空交易日期().isBefore(n) || i.getTransdate不可为空交易日期().isEqual(n)
                                    && i.getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_4_封存);
                        }).collect(Collectors.toList()), Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay())).getChgtype_不可为空_变更类型() ).collect(Collectors.groupingBy(m->m));


                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_14_SEQ_销户总单位数_AND_0301002201);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setIntValue(result.get(E_DP202_单位缴存变更登记簿_变更类型.E_5_正常状态销户.getText()).size()); // 银行名称
                loanHistoryRepository.save(loanHistory);
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_15_SEQ_正常总单位数_AND_0301002301);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setIntValue(result.get(E_DP202_单位缴存变更登记簿_变更类型.E_3_转入后正常状态.getText()).size()); // 银行名称
                loanHistoryRepository.save(loanHistory);

                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_16_SEQ_封存总单位数_AND_0301002401);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setIntValue(result.get(E_DP202_单位缴存变更登记簿_变更类型.E_4_封存.getText()).size()); // 银行名称
                loanHistoryRepository.save(loanHistory);




            //    Collections.max(a.get(true)
       /*         S_14_SEQ_销户总单位数_AND_0301002201("0301","0301002201","销户总单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                        S_15_SEQ_正常总单位数_AND_0301002301("0301","0301002301","正常总单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                        S_16_SEQ_封存总单位数_AND_0301002401("0301","0301002401","封存总单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
*/





                //S_12_SEQ_补缴单位数_AND_0301001101("0301","0301001101","补缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),


                 loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_12_SEQ_补缴单位数_AND_0301001101);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setIntValue(
                        o.getValue().stream()
                                .filter(p->{
                                    return p.getValue3().stream().filter(x->x.getRegdate不可为空登记日期().equals(n))
                                            .filter(x->x.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.不定额补缴))
                                            .filter(x->x.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常全额补缴))
                                            .filter(x->x.getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.正常差额补缴))
                                            .count()>0;
                                }).count()


                );
                loanHistoryRepository.save(loanHistory);




              //  S_13_SEQ_开户总单位数_AND_0301002101("0301","0301002101","开户总单位数"," ","01","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_13_SEQ_开户总单位数_AND_0301002101);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setIntValue(
                        o.getValue().stream()
                                .filter(p->{
                                    return p.getValue2().getOpnaccdate开户日期().equals(n);
                                }).count()
                );
                loanHistoryRepository.save(loanHistory);






              //  S_48_SEQ_应归集额_AND_0301007101("0301","0301007101","应归集额"," ","03","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",true),
                    //    S_49_SEQ_实归集额_AND_0301007201("0301","0301007201","实归集额"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",true),
                   //     S_50_SEQ_实归集额__缴存基数___AND_0301007202("0301","0301007202","实归集额(缴存基数)"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1"," ",false),
                   //     S_51_SEQ_实归集额__月缴存额___AND_0301007203("0301","0301007203","实归集额(月缴存额)"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1"," ",false),




                        //  S_48_SEQ_应归集额_AND_0301007101
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_48_SEQ_应归集额_AND_0301007101);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(
                        o.getValue().stream()
                                .filter(p->{

                                    return p.getValue2().getOpnaccdate开户日期().equals(n);
                                }).mapToDouble(j->j.getValue0().getBasenum_缴存基数()).sum()
                );
                loanHistoryRepository.save(loanHistory);



                //  S_49_SEQ_实归集额_AND_0301007201
                loanHistory = new LoanHistory(n,StatisticalIndexCodeEnum.S_49_SEQ_实归集额_AND_0301007201);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex单位性质(o.getKey()); // 银行名称
                loanHistory.setDoubleValue(
                        o.getValue().stream()
                               .mapToDouble(j->j.getValue3().stream()
                                .filter(g->g.getInaccdate不可为空入账日期().equals(n))
                                .mapToDouble(g->g.getFactpayamt_实际缴款金额().doubleValue()).sum()).sum()
                );
                loanHistoryRepository.save(loanHistory);
            });
            //S_49_SEQ_实归集额_AND_0301007201("0301","0301007201","实归集额"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",true),
             //       S_50_SEQ_实归集额__缴存基数___AND_0301007202("0301","0301007202","实归集额(缴存基数)"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1"," ",false),
              //      S_51_SEQ_实归集额__月缴存额___AND_0301007203("0301","0301007203","实归集额(月缴存额)"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1"," ",false),



/*


            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue1().getUnitkind_单位性质())).entrySet()
                    .stream().forEach(uuu->{
                LoanHistory loanHistory = new LoanHistory(n);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称




                uuu.getValue().stream().forEach(ff->{
                    List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = ff.getValue6();
                    List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = ff.getValue3();
                    List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = ff.getValue4();
                    List<DP008_单位明细账> DP008_单位明细账s = ff.getValue5();
                });









*/
/*
                loanHistory.setValue缴存人数(uuu.getValue().stream().count());  //
                loanHistory.setValue缴存额总额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //

                loanHistory.setValue提取人数(uuu.getValue().stream().count());  //
                loanHistory.setValue提取总额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //


                loanHistory.setValue销户单位数(uuu.getValue().stream().count());  //
                loanHistory.setValue封存单位数(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //
*//*







                loanHistoryRepository.save(loanHistory);
            });
*/




/*            // TODO 按照 贷款年限计算
            eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue0().getApploanterm_贷款申请年限())).entrySet()
                    .stream().forEach(uuu->{
                LoanHistory loanHistory = new LoanHistory(n);
                loanHistory.setIndex银行名称(机构编码); // 机构名称
                loanHistory.setIndex贷款申请年限(uuu.getKey()); // 银行名称



                loanHistory.setValue贷款笔数(uuu.getValue().stream().count());  //
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //

                loanHistoryRepository.save(loanHistory);
            });*/


        });
    }


    //TODO 存储统计信息
    public void saveHistorySpan(LocalDate ldt_ksrq, LocalDate js) {
        // LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq, js);


        for (int i = 0; i <= abs(num); i++) {
            LocalDate n = ldt_ksrq.minusDays(i);

            List<Septet<DP004_单位缴存信息表, CM001_单位基本资料表, DP005_单位分户账,

                    List<DP021_单位缴存登记簿>, List<DW025_公积金提取审核登记表>,

                    List<DP008_单位明细账>,
                    List<DP202_单位缴存变更登记簿>>> aa = 历史倒推_某一日的缴存(n);
            saveHistoryOneTime(n, aa);
        }
    }


   //
    public void run() {

       // DateUtils.truncate(LocalDate.now(), Calendar.DAY_OF_MONTH);
      //  DateUtils.ceiling(LocalDate.now(), Calendar.DAY_OF_MONTH);

        // DateUtils.truncate();
        saveHistorySpan(LocalDate.now(), LocalDate.now().minusDays(5));
    }








    }
