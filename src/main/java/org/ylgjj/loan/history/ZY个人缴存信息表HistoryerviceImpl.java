package org.ylgjj.loan.history;


import org.javatuples.Octet;
import org.javatuples.Septet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.H_DP204_个人缴存变更登记簿_变更类型;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ZY个人缴存信息表HistoryerviceImpl")
public class ZY个人缴存信息表HistoryerviceImpl {

    private static final Logger logger = LoggerFactory.getLogger(ZY个人缴存信息表HistoryerviceImpl.class);
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
    private DP009_个人明细账_Repository dp009_个人明细账_repository;




    @Autowired
    private LoanHistoryRepository loanHistoryRepository;


    boolean initComplte = false;
    List<DP006_个人缴存信息表> dp006__个人缴存信息表s = null;

    Map<String,CM002_个人基本资料表> cm002_个人基本资料表Map = null;
    Map<String, DP007_个人分户账> dp007_individual_sub_account_个人分户账Map = null;

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
    Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;

    List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = null;
    List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = null;
    List<DP009_个人明细账> dp009_个人明细账s = null;
    List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = null;
    //TODO 历史倒推


    public  void 历史倒推_某一日的缴存(LocalDate beginDate,LocalDate endDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(!initComplte){
            dp006__个人缴存信息表s = dp006__个人缴存信息表_repository.findAll();

            logger.debug("装载 dp006_payment_个人缴存信息表s completed");
         //   cm002_个人基本资料表Map = cm002个人基本资料表Repository.findAll().stream().collect(Collectors.toMap(e->e.getCustid_个人客户号(), a->a));

            logger.debug("装载 cm002_个人基本资料表Map completed");

        //    dp007_individual_sub_account_个人分户账Map = dp007_individual_sub_account个人分户账Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccnum_个人账号(),a->a));
            logger.debug("装载 dp007_individual_sub_account_个人分户账Map completed");
            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));

            logger.debug("装载 cm001_单位基本资料表Map completed");
          dp005_work_unit_单位分户账Map = dp005__单位分户账_repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitaccnum单位账号(), a -> a));

            logger.debug("装载 dp005_work_unit_单位分户账Map completed");
            dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findAll();

            logger.debug("装载 dp204_个人缴存变更登记簿s completed");
         //   dp009_个人明细账s = dp009_个人明细账_repository.findAll();

            logger.debug("装载 dp009_个人明细账_repository completed");
            dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findAll();

            logger.debug("装载 dp022_个人缴存登记簿s completed");
            dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findAll();

            logger.debug("装载 dw025_公积金提取审核登记表s completed");
            initComplte= true;
        }



        Map<String,List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map
                = dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum个人账号()));

/*
        Map<String,List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));
        Map<String,List<DP009_个人明细账>> dp009_个人明细账Map
                = dp009_个人明细账s.stream().collect(Collectors.groupingBy(e->e.getAccnum_不可为空_个人账号()));
*/




        Map<String,List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map
                = dp204_个人缴存变更登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));







        dp022_个人缴存登记簿s.stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;




            DP007_个人分户账 dp007__个人分户账 = dp007_individual_sub_account个人分户账Repository.findByAccnum个人账号(e.getAccnum个人账号());

            DP005_单位分户账 dp005__单位分户账 = dp005__单位分户账_repository.findByUnitaccnum单位账号(dp007__个人分户账.getUnitaccnum_单位账号());


            CM001_单位基本资料表 cm001_单位基本资料表 = cm001单位基本资料表Repository.findByUnitcustid单位客户号(dp005__单位分户账.getUnitcustid_单位客户号());

            return Octet.with(e,
                    cm001_单位基本资料表,
                       null,// cm002_个人基本资料表Map.get(dp007_individual_sub_account_个人分户账.getCustid_个人客户号()),
                    dp007__个人分户账,
                        dp022_个人缴存登记簿Map.get(e.getAccnum个人账号()),
                          null,//   dw025_公积金提取审核登记表Map.get(e.getAccnum个人账号()),
                      null,//  dp009_个人明细账Map.get(e.getAccnum个人账号()),
                        dp204_个人缴存变更登记簿Map.get(e.getAccnum个人账号()));
        }).collect(Collectors.groupingBy(e->e.getValue0().getAgentinstcode_经办机构())).entrySet().forEach(eee->{


                  String 机构编码 = eee.getKey();



                  // TODO 按照 经济类型
   /*               eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue1().getUnitkind_单位性质())).entrySet()
                          .stream().forEach(o->{

                      LoanHistory loanHistory = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_22_SEQ_实缴人数__按年___AND_0301003206);
                      loanHistory.setIndex机构编码(机构编码); // 机构名称
                      loanHistory.setIndex经济类型(o.getKey());
                      loanHistory.setIntValue(o.getValue().stream()
                              .collect(Collectors.groupingBy(x->x.getValue0().getAccnum个人账号()))
                              .entrySet()
                              .stream().map(g->{
                                   return g.getValue().stream()
                                          .filter(x-> Collections.max(x.getValue7().stream()
                                                  .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                                  .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                                  .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                                  .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(beginDate))


                                                  .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))

                                                  .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))

                                          .filter(q->q.getValue4().stream()
                                                      .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                                      .filter(f->{
                                                          LocalDate date = LocalDate.parse(f.getBegym开始年月(),df);
                                                          return date.isAfter(beginDate) && date.isBefore(endDate);
                                                      }).count() > 0)

                                           .count()>0;
                              })

                              .count());
                      loanHistoryRepository.save(loanHistory);

                  });*/



            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue1().getUnitkind_单位性质())).entrySet()
                    .stream().forEach(o->{

                LoanHistory loanHistory = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_22_SEQ_实缴人数__按年___AND_0301003206);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(o.getKey());
                loanHistory.setIntValue(o.getValue().stream()
                        .collect(Collectors.groupingBy(x->x.getValue0().getAccnum个人账号()))
                        .entrySet()
                        .stream().map(g->{
                            return g.getValue().stream()
                                    .filter(x-> Collections.max(x.getValue7().stream()
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(beginDate))


                                            .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))

                                            .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))

                                    .filter(q->q.getValue4().stream()
                                            .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                            .filter(f->{
                                                LocalDate date = LocalDate.parse(f.getBegym开始年月(),df);
                                                return date.isAfter(beginDate) && date.isBefore(endDate);
                                            }).count() > 0)

                                    .count()>0;
                        })

                        .count());
                loanHistoryRepository.save(loanHistory);




                     loanHistory = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_25_SEQ_实缴人数__个人缴存基数___AND_0301003209);
                    loanHistory.setIndex机构编码(机构编码); // 机构名称
                    loanHistory.setIndex经济类型(o.getKey());
                    loanHistory.setIntValue(o.getValue().stream()
                            .collect(Collectors.groupingBy(x->x.getValue5()))
                            .entrySet()
                            .stream().map(g->{
                                return g.getValue().stream()
                                        .filter(x-> Collections.max(x.getValue7().stream()
                                                .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                                .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                                .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                                .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(beginDate))


                                                .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))

                                                .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))

                                        .filter(q->q.getValue4().stream()
                                                .filter(i->i.getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                                .filter(f->{
                                                    LocalDate date = LocalDate.parse(f.getBegym开始年月(),df);
                                                    return date.isAfter(beginDate) && date.isBefore(endDate);
                                                }).count() > 0)

                                        .count()>0;
                            })

                            .count());
                    loanHistoryRepository.save(loanHistory);


                o.getValue().stream().collect(Collectors.groupingBy(x->x.getValue0().getBasenum_缴存基数()))

                        .entrySet()
                        .stream().forEach(g->{

                    LoanHistory loanHistory_ = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_26_SEQ_实缴人数__月缴存额___AND_0301003210);
                    loanHistory_.setIndex机构编码(机构编码); // 机构名称
                    loanHistory_.setIndex经济类型(o.getKey());
                    loanHistory_.setIndex缴存基数(g.getKey());

                    //loanHistory_.setIntValue();
                    loanHistoryRepository.save(loanHistory_);
                            ;


                     g.getValue().stream().collect(Collectors.groupingBy(i->i.getValue0().getAccnum个人账号()))
                             .entrySet().stream()
                            .filter(q->q.getValue().stream()
                                    .filter(i->i.getValue0().getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                    .filter(f->{
                                        LocalDate date = LocalDate.parse(f.getValue0().getBegym开始年月(),df);
                                        return date.isAfter(beginDate) && date.isBefore(endDate);
                                    }).count() > 0)

                            .count();


                });





            });



        });

    }













    public  void 历史倒推_某一日的缴存_一个区间(LocalDate beginDate,LocalDate endDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByRegdate登记日期Between(beginDate,endDate);


        dp022_个人缴存登记簿s.stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;


            DP007_个人分户账 dp007__个人分户账 = dp007_individual_sub_account_个人分户账Map.get(e.getAccnum个人账号());

            DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getAgentinstcode_经办机构());


            List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByAccnum不可为空个人账号(e.getAccnum个人账号());
            return Octet.with(e,
                    cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                    null,// cm002_个人基本资料表Map.get(dp007_individual_sub_account_个人分户账.getCustid_个人客户号()),
                    dp007__个人分户账,
                    null,//dp022_个人缴存登记簿Map.get(e.getAccnum个人账号()),
                    null,//   dw025_公积金提取审核登记表Map.get(e.getAccnum个人账号()),
                    null,//  dp009_个人明细账Map.get(e.getAccnum个人账号()),
                    dp204_个人缴存变更登记簿s);

        }).collect(Collectors.groupingBy(e->e.getValue0().getAgentinstcode_经办机构())).entrySet().forEach(eee->{


            String 机构编码 = eee.getKey();


            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue1().getUnitkind_单位性质())).entrySet()
                    .stream().forEach(o->{





                LoanHistory loanHistory = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_28_SEQ_实缴人次_AND_0301003301);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(o.getKey());
                loanHistory.setIntValue(o.getValue().stream()
                        .collect(Collectors.groupingBy(x->x.getValue0().getRegnum_登记号()))
                        .entrySet()
                        .stream().filter(g->{
                            return g.getValue().stream()
                                    .filter(x-> Collections.max(x.getValue7().stream()
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(beginDate))
                                            .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                            .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                    .filter(i->i.getValue0().getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                    .filter(f->{
                                        LocalDate date = LocalDate.parse(f.getValue0().getBegym开始年月(),df);
                                        return date.isAfter(beginDate) && date.isBefore(endDate);
                                    }).count() > 0;
                        })

                        .count());
                loanHistoryRepository.save(loanHistory);










                loanHistory = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_18_SEQ_实缴人数_AND_0301003201);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(o.getKey());
                loanHistory.setIntValue(o.getValue().stream()
                        .collect(Collectors.groupingBy(x->x.getValue0().getAccnum个人账号()))
                        .entrySet()
                        .stream().filter(g->{
                            return g.getValue().stream()
                                    .filter(x-> Collections.max(x.getValue7().stream()
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(beginDate))
                                            .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                            .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                    .filter(i->i.getValue0().getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                    .filter(f->{
                                        LocalDate date = LocalDate.parse(f.getValue0().getBegym开始年月(),df);
                                        return date.isAfter(beginDate) && date.isBefore(endDate);
                                    }).count() > 0;
                        })

                        .count());
                loanHistoryRepository.save(loanHistory);









                loanHistory = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_22_SEQ_实缴人数__按年___AND_0301003206);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(o.getKey());
                loanHistory.setIntValue(o.getValue().stream()
                        .collect(Collectors.groupingBy(x->x.getValue0().getAccnum个人账号()))
                        .entrySet()
                        .stream().filter(g->{
                            return g.getValue().stream()
                                    .filter(x-> Collections.max(x.getValue7().stream()
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(beginDate))
                                            .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                            .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                    .filter(i->i.getValue0().getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                    .filter(f->{
                                                LocalDate date = LocalDate.parse(f.getValue0().getBegym开始年月(),df);
                                                return date.isAfter(beginDate) && date.isBefore(endDate);
                                            }).count() > 0;
                        })

                        .count());
                loanHistoryRepository.save(loanHistory);





              //  //("0301","0301020503","当年缴存额(收入水平)","当年缴存额(收入水平包含低收入、中收入、高收入)","25","03","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","1"," ",false),


                loanHistory = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_85_SEQ_当年缴存额__收入水平___AND_0301020503);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(o.getKey());
                loanHistory.setDoubleValue(o.getValue().stream()
                        .filter(i->i.getValue0().getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                        .filter(f->{
                            LocalDate date = LocalDate.parse(f.getValue0().getBegym开始年月(),df);
                            return date.isAfter(beginDate) && date.isBefore(endDate);
                        })
                        .mapToDouble(g->{
                            return g.getValue0().getPayamt_缴存金额().doubleValue();
                        }).sum());
                loanHistoryRepository.save(loanHistory);





















                o.getValue().stream().collect(Collectors.groupingBy(x->x.getValue0().getBasenum_缴存基数()))

                        .entrySet()
                        .stream().forEach(g->{

                    LoanHistory loanHistory_ = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_25_SEQ_实缴人数__个人缴存基数___AND_0301003209);
                    loanHistory_.setIndex机构编码(机构编码); // 机构名称
                    loanHistory_.setIndex经济类型(o.getKey());
                    loanHistory_.setIndex缴存基数(g.getKey());

                    loanHistory_.setIntValue(g.getValue().stream().collect(Collectors.groupingBy(i->i.getValue0().getAccnum个人账号()))
                            .entrySet().stream()
                            .filter(q->q.getValue().stream()
                                    .filter(i->i.getValue0().getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                    .filter(f->{
                                        LocalDate date = LocalDate.parse(f.getValue0().getBegym开始年月(),df);
                                        return date.isAfter(beginDate) && date.isBefore(endDate);
                                    }).count() > 0)

                            .count());
                    loanHistoryRepository.save(loanHistory_);
                    ;



                });











                //S_87_SEQ_当年缴存人数__收入水平___AND_0301020507("0301","0301020507","当年缴存人数(收入水平)","当年缴存人数(收入水平包含低收入、中收入、高收入)","25","06","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","1"," ",false),

                //当年缴存人数
             //   S_22_SEQ_实缴人数__按年___AND_0301003206
                loanHistory = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_87_SEQ_当年缴存人数__收入水平___AND_0301020507);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(o.getKey());
                loanHistory.setIntValue(o.getValue().stream()
                        .collect(Collectors.groupingBy(x->x.getValue0().getAccnum个人账号()))
                        .entrySet()
                        .stream().filter(g->{
                            return g.getValue().stream()
                                    .filter(x-> Collections.max(x.getValue7().stream()
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(beginDate))
                                            .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                            .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                    .filter(i->i.getValue0().getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                    .filter(f->{
                                        LocalDate date = LocalDate.parse(f.getValue0().getBegym开始年月(),df);
                                        return date.isAfter(beginDate) && date.isBefore(endDate);
                                    }).count() > 0;
                        })

                        .count());
                loanHistoryRepository.save(loanHistory);











            });



        });

    }









    public  void 历史倒推_某一日的缴存_实存人数_一个区间(LocalDate beginDate,LocalDate endDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<DP009_个人明细账> dp009_个人明细账s =   dp009_个人明细账_repository.findByTransdate不可为空交易日期Between(beginDate,endDate);

        dp009_个人明细账s.stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;

            DP007_个人分户账 dp007__个人分户账 = dp007_individual_sub_account个人分户账Repository.findByAccnum个人账号(e.getAccnum不可为空个人账号());

            DP005_单位分户账 dp005__单位分户账 = dp005__单位分户账_repository.findByUnitaccnum单位账号(dp007__个人分户账.getUnitaccnum_单位账号());


            List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByAccnum不可为空个人账号(e.getAccnum不可为空个人账号());


            CM001_单位基本资料表 cm001_单位基本资料表 = cm001单位基本资料表Repository.findByUnitcustid单位客户号(dp005__单位分户账.getUnitcustid_单位客户号());

            return Octet.with(e,
                    cm001_单位基本资料表,
                    null,// cm002_个人基本资料表Map.get(dp007_individual_sub_account_个人分户账.getCustid_个人客户号()),
                    dp007__个人分户账,
                    null,//dp022_个人缴存登记簿Map.get(e.getAccnum个人账号()),
                    null,//   dw025_公积金提取审核登记表Map.get(e.getAccnum个人账号()),
                    null,//  dp009_个人明细账Map.get(e.getAccnum个人账号()),
                    dp204_个人缴存变更登记簿s);
        }).collect(Collectors.groupingBy(e->e.getValue0().getAccinstcode_不可为空_账户机构())).entrySet().forEach(eee->{


            String 机构编码 = eee.getKey();

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue1().getUnitkind_单位性质())).entrySet()
                    .stream().forEach(o->{

                LoanHistory loanHistory = new LoanHistory(beginDate, StatisticalIndexCodeEnum.S_42_SEQ_实存人数_AND_0301005101);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(o.getKey());
                loanHistory.setIntValue(o.getValue().stream()
                        .collect(Collectors.groupingBy(x->x.getValue3().getCertinum_证件号码()))
                        .entrySet()
                        .stream().map(g->{

                           Double min =  Collections.min(g.getValue().stream()
               /*                     .filter(c->c.get().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                    .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                    .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                    .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(beginDate))*/
                                    .collect(Collectors.toList()),Comparator.comparingLong(l->l.getValue0().getTransdate不可为空交易日期().toEpochDay()))
                            .getValue0().getBal_不可为空_余额() ;

                            Double max =  Collections.max(g.getValue().stream()
                                    /*                     .filter(c->c.get().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                                         .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                                         .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                                         .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(beginDate))*/
                                    .collect(Collectors.toList()),Comparator.comparingLong(l->l.getValue0().getTransdate不可为空交易日期().toEpochDay()))
                                    .getValue0().getBal_不可为空_余额() ;

                            if( max > 0) return 1;
                            if(max == 0 && min > 0) return 0;

                            return 0;
                        })

                        .count());
                loanHistoryRepository.save(loanHistory);








            });



        });


    }







    public void 流水_单位缴存(LocalDate beginDate,LocalDate endDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");




        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期Between(beginDate,endDate);

        dp021_单位缴存登记簿s.stream().collect(Collectors.toList()).stream().map(e -> {
            //TODO        获得某一日的缴存列表;


            DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());
            List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s1 = dp202_单位缴存变更登记簿_repository.findByUnitaccnum不可为空单位账号(e.getUnitaccnum单位账号());
            List<DP008_单位明细账> DP008_单位明细账s = dp008__单位明细账_repository.findByUnitaccnum不可为空单位账号(e.getUnitaccnum单位账号());


            List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByUnitaccnum单位账号(e.getUnitaccnum单位账号());
            CM001_单位基本资料表 cm001_单位基本资料表s = cm001单位基本资料表Repository.findByUnitcustid单位客户号(dp005__单位分户账.getUnitcustid_单位客户号());

            return Septet.with(e,
                    cm001_单位基本资料表s,
                    dp005__单位分户账,
                    null,//dp004_unit_payment_info_单位缴存信息表Map.get(e.getUnitaccnum单位账号()),
                    dw025_公积金提取审核登记表s,

                    DP008_单位明细账s,
                    dp202_单位缴存变更登记簿s1);
        })

                .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {




                o.getValue().stream().collect(Collectors.groupingBy(c->c.getValue0().getBasenum_缴存基数())).entrySet().stream().forEach(d-> {

                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_50_SEQ_实归集额__缴存基数___AND_0301007202);

                    ;

                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setIndex缴存基数(d.getKey());

                    loanHistory.setIntValue(d.getValue().stream().filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    loanHistoryRepository.save(loanHistory);
                });



                o.getValue().stream().collect(Collectors.groupingBy(c->c.getValue0().getCmpayamt_本月汇缴金额().doubleValue())).entrySet().stream().forEach(d-> {



                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_51_SEQ_实归集额__月缴存额___AND_0301007203);
                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setIndex月缴存额(d.getKey());
                    loanHistory.setIntValue(o.getValue().stream()
                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    loanHistoryRepository.save(loanHistory);
                });





















            });


        });


    }





    public void 职工人数_新开户职工数(LocalDate beginDate,LocalDate endDate) {



        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findAll();




        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(beginDate);
        List<DP008_单位明细账> DP008_单位明细账s = dp008__单位明细账_repository.findByTransdate不可为空交易日期(beginDate);


        List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期(beginDate);


        Map<String, List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum单位账号()));

        Map<String, List<DP008_单位明细账>> DP008_单位明细账Map
                = DP008_单位明细账s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum不可为空单位账号()));


        Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map
                = dp202_单位缴存变更登记簿s.stream().collect(Collectors.groupingBy(e -> e.getUnitaccnum不可为空单位账号()));
















        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期Between(beginDate,endDate);

        dp021_单位缴存登记簿s.stream().collect(Collectors.toList()).stream().map(e -> {
            //TODO        获得某一日的缴存列表;


            DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


            return Septet.with(e,
                    cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                    dp005__单位分户账,
                    null,//dp004_unit_payment_info_单位缴存信息表Map.get(e.getUnitaccnum单位账号()),
                    dw025_公积金提取审核登记表Map.get(e.getUnitaccnum单位账号()),

                    DP008_单位明细账Map.get(e.getUnitaccnum单位账号()),
                    dp202_单位缴存变更登记簿Map.get(e.getUnitaccnum单位账号()));
        })

                .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {




                o.getValue().stream().collect(Collectors.groupingBy(c->c.getValue0().getBasenum_缴存基数())).entrySet().stream().forEach(d-> {

                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_86_SEQ_新开户职工数__收入水平___AND_0301020506);

                    ;

                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setIndex缴存基数(d.getKey());

                    loanHistory.setIntValue(d.getValue().stream().filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    loanHistoryRepository.save(loanHistory);
                });


                //S_86_SEQ_新开户职工数__收入水平___AND_0301020506("0301","0301020506","新开户职工数(收入水平)","新开户职工数(收入水平包含低收入、中收入、高收入)","25","06","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","0"," ",false),

                o.getValue().stream().collect(Collectors.groupingBy(c->c.getValue0().getCmpayamt_本月汇缴金额().doubleValue())).entrySet().stream().forEach(d-> {



                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_51_SEQ_实归集额__月缴存额___AND_0301007203);
                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setIndex月缴存额(d.getKey());
                    loanHistory.setIntValue(o.getValue().stream()
                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    loanHistoryRepository.save(loanHistory);
                });





















            });


        });


    }























  //
    public void run() {
        历史倒推_某一日的缴存(LocalDate.now().minusDays(20),LocalDate.now());


        logger.debug("装载 dp204_个人缴存变更登记簿s completed");
        List<DP009_个人明细账> dp009_个人明细账s =   dp009_个人明细账s = dp009_个人明细账_repository.findAll();

        cm002_个人基本资料表Map = cm002个人基本资料表Repository.findAll().stream().collect(Collectors.toMap(e->e.getCustid_个人客户号(), a->a));


        dp006__个人缴存信息表s = dp006__个人缴存信息表_repository.findAll();
        dp005_work_unit_单位分户账Map = dp005__单位分户账_repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitaccnum单位账号(), a -> a));

/*
        实存人数

        S_42_SEQ_实存人数_AND_0301005101("0301","0301005101","实存人数"," ","02","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),

*/




    }








}
