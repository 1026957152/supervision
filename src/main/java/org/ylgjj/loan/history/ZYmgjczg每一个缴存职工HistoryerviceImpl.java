package org.ylgjj.loan.history;


import org.javatuples.Octet;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_DP007_个人分户账_个人账户状态;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.H_DP204_个人缴存变更登记簿_变更类型;
import org.ylgjj.loan.domain_flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.repository_flow.YourHistoryRepository;
import org.ylgjj.loan.util.DateUtilsss;
import org.ylgjj.loan.util.NativePlace;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ZY每一个缴存职工HistoryerviceImpl")
public class ZYmgjczg每一个缴存职工HistoryerviceImpl {


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
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    private DP009_个人明细账_Repository dp009_个人明细账_repository;


    @Autowired
    private YourHistoryRepository yourHistoryRepository;


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;


    boolean initComplte = false;
    List<DP006_个人缴存信息表> dp006__个人缴存信息表s = null;

    Map<String,CM002_个人基本资料表> cm002_个人基本资料表Map = null;
    Map<String, DP007_个人分户账> dp007_individual_sub_account_个人分户账Map = null;

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
    //TODO 历史倒推




    public  List<Octet<DP006_个人缴存信息表,
            CM001_单位基本资料表,
            CM002_个人基本资料表,
            DP007_个人分户账,
            List<DP022_个人缴存登记簿>,
            List<DW025_公积金提取审核登记表>,
            List<DP009_个人明细账>,
            List<DP204_个人缴存变更登记簿>
            >> 历史倒推_某一日的缴存(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(!initComplte){
            dp006__个人缴存信息表s = dp006__个人缴存信息表_repository.findAll();

            cm002_个人基本资料表Map = cm002个人基本资料表Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccname_个人姓名(), a->a));
            dp007_individual_sub_account_个人分户账Map = dp007_individual_sub_account个人分户账Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccnum_个人账号(),a->a));

            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));

            initComplte= true;
        }


        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByRegdate登记日期(localDate);
        List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByTransdate不可为空交易日期(localDate);
        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);

        Map<String,List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map
                = dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum个人账号()));
        Map<String,List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));

        Map<String,List<DP009_个人明细账>> dp009_个人明细账Map
                = dp009_个人明细账s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));


        Map<String,List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map
                = dp204_个人缴存变更登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));




              return  dp006__个人缴存信息表s.stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;


            DP007_个人分户账 dp005_work_unit_单位分户账 = dp007_individual_sub_account_个人分户账Map.get(e.getAccnum个人账号());


                return Octet.with(e,
                        cm001_单位基本资料表Map.get(dp005_work_unit_单位分户账.getUnitaccnum_单位账号()),
                        cm002_个人基本资料表Map.get(dp005_work_unit_单位分户账.getCustid_个人客户号()),
                        dp005_work_unit_单位分户账,
                        dp022_个人缴存登记簿Map.get(e.getAccnum个人账号()),
                        dw025_公积金提取审核登记表Map.get(e.getAccnum个人账号()),
                        dp009_个人明细账Map.get(e.getAccnum个人账号()),
                        dp204_个人缴存变更登记簿Map.get(e.getAccnum个人账号()));
        }).collect(Collectors.toList());

    }








    //TODO 存储统计信息
    public void saveHistoryOneTime(LocalDate n,
                                   List<Octet<DP006_个人缴存信息表,
            CM001_单位基本资料表,
            CM002_个人基本资料表,
                                           DP007_个人分户账,
            List<DP022_个人缴存登记簿>,
            List<DW025_公积金提取审核登记表>,
            List<DP009_个人明细账>,
            List<DP204_个人缴存变更登记簿>
            >>  inputs) {

        inputs.stream().collect(Collectors.groupingBy(e->e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee->{
            String 机构编码 = eee.getKey();

/*

            S_31_SEQ_新增人数_AND_0301003601("0301","0301003601","新增人数"," ","02","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    S_32_SEQ_新增人数__非本市缴存职工___AND_0301003602("0301","0301003602","新增人数（非本市缴存职工）"," ","02","01","bm_khjg","机构"," "," "," "," ","0"," ",false),
                    S_33_SEQ_封存人数_AND_0301003701("0301","0301003701","封存人数"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    S_34_SEQ_销户人数_AND_0301003801("0301","0301003801","销户人数"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
*/


            //S_39_SEQ_提取人次__提取原因___AND_0301004011("0301","0301004011","提取人次(提取原因)"," ","02","03","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","0","02",true),


            eee.getValue().stream()
                    .flatMap(k->k.getValue5().stream().map(c-> Pair.with(k.getValue0(),c)))
                    .collect(Collectors.groupingBy(j->j.getValue1().getDrawreason_提取原因()))
                    .entrySet().forEach(p->{
                LoanHistory loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_39_SEQ_提取人次__提取原因___AND_0301004011);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex提取原因(p.getKey());

                loanHistory.setIntValue(p.getValue().size());  //
                loanHistoryRepository.save(loanHistory);
            });



            eee.getValue().stream().collect(Collectors.groupingBy(e->{
                return e.getValue1().getUnitkind_单位性质();
            })).entrySet().forEach(o-> {
                        LoanHistory loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_39_SEQ_提取人次__提取原因___AND_0301004011);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());

                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->! NativePlace.isYulin(x.getValue3().getCertinum_证件号码()))
                                .filter(x->x.getValue3().getOpnaccdate开户日期().equals(n)
                                ).count());  //
                        loanHistoryRepository.save(loanHistory);

                    });





                    eee.getValue().stream().collect(Collectors.groupingBy(e->e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o->{

                        LoanHistory loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_32_SEQ_新增人数__非本市缴存职工___AND_0301003602);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());


                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->! NativePlace.isYulin(x.getValue3().getCertinum_证件号码()))
                                .filter(x->x.getValue3().getOpnaccdate开户日期().equals(n)
                                ).count());  //

                        loanHistoryRepository.save(loanHistory);



                       // S_21_SEQ_新开户职工数__非本市缴存职工___AND_0301003205("0301","0301003205","新开户职工数（非本市缴存职工）"," ","02","06","bm_khjg","机构","bm_bi_khnx","开户年限"," "," ","0"," ",true),

                                    loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_21_SEQ_新开户职工数__非本市缴存职工___AND_0301003205);
                                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                                    loanHistory.setIndex经济类型(o.getKey());


                                    loanHistory.setIntValue(o.getValue().stream()
                                            .filter(x->! NativePlace.isYulin(x.getValue3().getCertinum_证件号码()))
                                            .filter(x->x.getValue3().getOpnaccdate开户日期().equals(n)
                                            ).count());  //

                                    loanHistoryRepository.save(loanHistory);






                                loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_31_SEQ_新增人数_AND_0301003601);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());
                        loanHistory.setIntValue(o.getValue().stream().filter(x->x.getValue3().getOpnaccdate开户日期().equals(n)).count());  //
                        loanHistoryRepository.save(loanHistory);

                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_34_SEQ_销户人数_AND_0301003801);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());


                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->! NativePlace.isYulin(x.getValue3().getCertinum_证件号码()))
                                .filter(x->x.getValue3().getOpnaccdate开户日期().equals(n)
                                ).count());  //

                        loanHistoryRepository.save(loanHistory);





                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_33_SEQ_封存人数_AND_0301003701);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());
                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->! NativePlace.isYulin(x.getValue3().getCertinum_证件号码()))
                                .filter(x->x.getValue3().getOpnaccdate开户日期().equals(n)
                                ).count());  //

                        loanHistoryRepository.save(loanHistory);





                      //  S_43_SEQ_开户总人数_AND_0301005201("0301","0301005201","开户总人数"," ","02","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                               // S_44_SEQ_正常总人数_AND_0301005301("0301","0301005301","正常总人数"," ","02","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                              //  S_45_SEQ_封存总人数_AND_0301005401("0301","0301005401","封存总人数"," ","02","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                               // S_46_SEQ_销户总人数_AND_0301005501("0301","0301005501","销户总人数"," ","02","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),


                                loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_45_SEQ_封存总人数_AND_0301005401);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());



                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->!x.getValue7().isEmpty())
                                .filter(x-> Collections.max(x.getValue7().stream()
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(n))

                                        .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                        .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText())).count());

                        loanHistoryRepository.save(loanHistory);




                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_44_SEQ_正常总人数_AND_0301005301);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());
                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->!x.getValue7().isEmpty())
                                .filter(x-> Collections.max(x.getValue7().stream()
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(n))
                                        .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                        .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText())).count());

                        loanHistoryRepository.save(loanHistory);




                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_46_SEQ_销户总人数_AND_0301005501);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());


                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->x.getValue3().getIndiaccstate_个人账户状态().equals(E_DP007_个人分户账_个人账户状态.销户))
                                .filter(x->x.getValue3().getClsaccdate销户日期().minusDays(1).isBefore(n))
                                .count());  //

                        loanHistoryRepository.save(loanHistory);



                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_46_SEQ_销户总人数_AND_0301005501);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());


                        loanHistory.setIntValue(o.getValue().stream()
                               // .filter(x->x.getValue3().getIndiaccstate_个人账户状态().equals(E_DP007_个人分户账_个人账户状态.销户))
                                .filter(x->x.getValue3().getOpnaccdate开户日期().minusDays(1).isBefore(n))
                                .count());  //

                        loanHistoryRepository.save(loanHistory);
/*
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称


                loanHistory.setValue缴存人数(uuu.getValue().stream().count());  //
                loanHistory.setValue缴存额总额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //

                loanHistory.setValue提取人数(uuu.getValue().stream().count());  //
                loanHistory.setValue提取总额(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //


                loanHistory.setValue销户单位数(uuu.getValue().stream().count());  //
                loanHistory.setValue封存单位数(uuu.getValue().stream().mapToDouble(cc->cc.getValue0().getLoanamt_贷款金额().doubleValue()).sum());  //
*/


                  //      S_47_SEQ_冻结总人数_AND_0301005601("0301","0301005601","冻结总人数"," ","02","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
























                      //  S_17_SEQ_应缴人数_AND_0301003101("0301","0301003101","应缴人数"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",true),
                       //         S_18_SEQ_实缴人数_AND_0301003201("0301","0301003201","实缴人数"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",true),

                        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMM");
/*                        LocalDate ldt_ksrq = LocalDate.parse(ksrq,df);
                        LocalDate ldt_jsrq = LocalDate.parse(jsrq,df);*/



                       // S_22_SEQ_实缴人数__按年___AND_0301003206("0301","0301003206","实缴人数(按年)"," ","02","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),


































                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_18_SEQ_实缴人数_AND_0301003201);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());
                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->!x.getValue4().isEmpty())
                                .filter(x-> Collections.max(x.getValue7().stream()
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(n))
                                        .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                        .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                .filter(q->{
                                    return q.getValue4().stream()
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴))
                                            .filter(f->{
                                                LocalDate date = LocalDate.parse(f.getBegym开始年月(),df);
                                                return date.getMonthValue() == n.getMonthValue() && date.getYear() == n.getYear();
                                            }).count() > 0;
                                })
                                .count());

                        loanHistoryRepository.save(loanHistory);










                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_17_SEQ_应缴人数_AND_0301003101);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());
                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->!x.getValue4().isEmpty())
                                .filter(x-> Collections.max(x.getValue7().stream()
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(n))
                                        .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                        .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                .filter(q->{
                                    return q.getValue4().stream()
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴))
                                            .filter(f->{
                                                LocalDate date = LocalDate.parse(f.getBegym开始年月(),df);
                                                return date.getMonthValue() == n.getMonthValue() && date.getYear() == n.getYear();
                                            }).count() > 0;
                                })
                                .count());

                        loanHistoryRepository.save(loanHistory);





                       // S_29_SEQ_补缴人数_AND_0301003401("0301","0301003401","补缴人数"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                            //    S_30_SEQ_未缴人数_AND_0301003501("0301","0301003501","未缴人数"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                                loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_30_SEQ_未缴人数_AND_0301003501);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());
                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->!x.getValue4().isEmpty())
                                .filter(x-> Collections.max(x.getValue7().stream()
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(n))
                                        .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                        .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                .filter(q->{
                                    return q.getValue4().stream()
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴))
                                            .filter(f->{
                                                LocalDate date = LocalDate.parse(f.getBegym开始年月(),df);
                                                return date.getMonthValue() == n.getMonthValue() && date.getYear() == n.getYear();
                                            }).count() > 0;
                                })
                                .count());

                        loanHistoryRepository.save(loanHistory);





                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_29_SEQ_补缴人数_AND_0301003401);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());
                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->!x.getValue4().isEmpty())
                                .filter(x-> Collections.max(x.getValue7().stream()
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(n))
                                        .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                        .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                .filter(q->{
                                    return q.getValue4().stream()
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴))
                                            .filter(f->{
                                                LocalDate date = LocalDate.parse(f.getBegym开始年月(),df);
                                                return date.getMonthValue() == n.getMonthValue() && date.getYear() == n.getYear();
                                            }).count() > 0;
                                })
                                .count());

                        loanHistoryRepository.save(loanHistory);










                        //   S_27_SEQ_缴存金额__非本市缴存职工___AND_0301003211("0301","0301003211","缴存金额（非本市缴存职工）"," ","03","06","bm_khjg","机构","bm_bi_khnx","开户年限"," "," ","1"," ",true),

                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_27_SEQ_缴存金额__非本市缴存职工___AND_0301003211);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());


                        loanHistory.setDoubleValue(o.getValue().stream()
                                .filter(x->! NativePlace.isYulin(x.getValue3().getCertinum_证件号码()))
                                .filter(x->x.getValue3().getOpnaccdate开户日期().equals(n) )

                                .mapToDouble(q->{
                                    return q.getValue4().stream()
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴))
                                            .filter(i->i.getRegdate登记日期().equals(n))
                                           .mapToDouble(g->g.getPayamt_缴存金额().doubleValue()).sum();
                                })

                                .sum()



                        );  //

                        loanHistoryRepository.save(loanHistory);



















                        //S_64_SEQ_非正常账户余额_AND_0301008004("0301","0301008004","非正常账户余额"," ","03","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","03",false),

                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_64_SEQ_非正常账户余额_AND_0301008004);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());
                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->!x.getValue4().isEmpty())
                                .filter(x-> Collections.max(x.getValue7().stream()
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                        .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                        .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(n))
                                        .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                        .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))

                                .mapToDouble(q->{
                                    return Collections.max(q.getValue6().stream()
                                            .filter(i->i.getTransdate不可为空交易日期().plusDays(1).isAfter(n))
                                            .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay())).getBal_不可为空_余额();

                                })
                                .count());

                        loanHistoryRepository.save(loanHistory);





                       // S_65_SEQ_归集余额_AND_0301008101("0301","0301008101","归集余额"," ","03","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),

                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_65_SEQ_归集余额_AND_0301008101);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());
                        loanHistory.setIntValue(o.getValue().stream()
                                .filter(x->!x.getValue4().isEmpty())

                                .mapToDouble(q->{
                                    return Collections.max(q.getValue6().stream()
                                            .filter(i->i.getTransdate不可为空交易日期().plusDays(1).isAfter(n))
                                            .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay())).getBal_不可为空_余额();

                                })
                                .count());

                        loanHistoryRepository.save(loanHistory);








                     //   S_52_SEQ_补缴金额_AND_0301007301("0301","0301007301","补缴金额"," ","03","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),
                                loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_52_SEQ_补缴金额_AND_0301007301);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());


                        loanHistory.setDoubleValue(o.getValue().stream()
                                .filter(x->! NativePlace.isYulin(x.getValue3().getCertinum_证件号码()))
                                .filter(x->x.getValue3().getOpnaccdate开户日期().equals(n) )

                                .mapToDouble(q->{
                                    return q.getValue4().stream()
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.正常差额补缴))
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.正常全额补缴))
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.不定额补缴))
                                            .filter(i->i.getRegdate登记日期().equals(n))
                                            .mapToDouble(g->g.getPayamt_缴存金额().doubleValue()).sum();
                                })

                                .sum()



                        );  //

                        loanHistoryRepository.save(loanHistory);














                        //   S_52_SEQ_补缴金额_AND_0301007301("0301","0301007301","补缴金额"," ","03","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),
                        loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_52_SEQ_补缴金额_AND_0301007301);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());


                        loanHistory.setDoubleValue(o.getValue().stream()

                            //    .filter(x->x.get().equals(n))

                                .mapToDouble(q->{
                                    return q.getValue4().stream()
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.正常差额补缴))
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.正常全额补缴))
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.不定额补缴))
                                            .filter(i->i.getRegdate登记日期().equals(n))
                                            .mapToDouble(g->g.getPayamt_缴存金额().doubleValue()).sum();
                                }).sum()



                        );  //

                        loanHistoryRepository.save(loanHistory);






                       // S_38_SEQ_提取人次_AND_0301004001("0301","0301004001","提取人次"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",true),

                                //   S_52_SEQ_补缴金额_AND_0301007301("0301","0301007301","补缴金额"," ","03","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),
                                loanHistory = new LoanHistory(n, StatisticalIndexCodeEnum.S_38_SEQ_提取人次_AND_0301004001);
                        loanHistory.setIndex机构编码(机构编码); // 机构名称
                        loanHistory.setIndex经济类型(o.getKey());


                        loanHistory.setDoubleValue(o.getValue().stream()

                                //    .filter(x->x.get().equals(n))

                                .mapToLong(q->{
                                    return q.getValue5().stream()
                                            .filter(i->i.getApprstate_审批状态().equals("d"))
                                            .filter(i->i.getTransdate交易日期().equals(n))
                                            .count();
                                }).sum()



                        );  //

                        loanHistoryRepository.save(loanHistory);

                    });













        });
    }










    //TODO 存储统计信息
    public void saveHistorySpan(LocalDate ldt_ksrq,LocalDate js) {
        LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq,year_before);


        for(int i=0; i<=abs(num); i++) {
            LocalDate n = ldt_ksrq.minusDays(i);

            List<Octet<DP006_个人缴存信息表,
                    CM001_单位基本资料表,
                    CM002_个人基本资料表,
                    DP007_个人分户账,
                    List<DP022_个人缴存登记簿>,
                    List<DW025_公积金提取审核登记表>,
                    List<DP009_个人明细账>,
                    List<DP204_个人缴存变更登记簿>
                    >>   aa = 历史倒推_某一日的缴存(n);
            saveHistoryOneTime(n,aa);
        }
    }




    public void run() {
        saveHistorySpan(LocalDate.now(),null);
    }




    //TODO ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？获取当前的一个状态
    public void saveHistoryOneTime(LocalDate localDate) {

        //从时间变化的列表中，抽取变化时记录的 状态。

   //     private BigDecimal loanbal不可为空_账户余额;
        List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);


    }




    public DP009_个人明细账 DP021_单位缴存登记簿_flowing(List<DP009_个人明细账> dp009_个人明细账s, LocalDate n) {

        System.out.println("------- 正在处理 的时间"+n);


/*
        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByTransdate不可为空交易日期(localDate);
        List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByTransdate不可为空交易日期(localDate);
        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);
*/

        Map<Boolean,List<DP009_个人明细账>> a = dp009_个人明细账s.stream().collect(Collectors.groupingBy(x->x.getTransdate不可为空交易日期().isBefore(n)));

        System.out.println("--分开的----- 之前的"+(a.get(true).size()));
        System.out.println("--分开的----- 之前的"+(a.get(false) == null));
        //System.out.println("--分开的----- 之前的"+(a.get(true).size() ==0? null : a.get(true).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //   System.out.println("--分开的----- 之h偶的"+(a.get(false)  ==null? "null" : a.get(false).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //List<DP021_单位缴存登记簿> greaterList = ee.getValue().stream().filter(x->x.getRegdate不可为空登记日期().isBefore(n)).collect(Collectors.toList());

        if(a.get(true).isEmpty()){
            System.out.println("------- 返回时空的啊啊啊啊");
            return null;
        }


        DP009_个人明细账 lastContact = Collections.max(a.get(true),
                Comparator.comparing(DP009_个人明细账::getTransdate不可为空交易日期));

        System.out.println("------- 找的一个最近的登记表啊啊"+lastContact.getTransdate不可为空交易日期());
        System.out.println("------- 缴存人数 "+lastContact.getBal_不可为空_余额());
        System.out.println("------- 缴存基数 "+lastContact.getBasenum_不可为空_缴存基数());
        System.out.println("------- 缴存基数 "+lastContact.getKeepamt_可为空_存量发生额());
        System.out.println("------- 缴存基数 "+lastContact.getIndiprop_不可为空_个人缴存比例());
        System.out.println("------- 缴存基数 "+lastContact.getUnitprop_不可为空_单位比例());
        System.out.println("------- 缴存基数 "+lastContact.getIncreamt_可为空_增量发生额());
        return lastContact;


    }


}
