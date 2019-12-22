package org.ylgjj.loan.history_stream;


import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.CollectHistory;
import org.ylgjj.loan.domain_flow.TargetHistory;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.E_LN006_贷款分期还款计划_curseqStatusEnum;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.CM001_单位基本资料表Repository;
import org.ylgjj.loan.repository.DP005_单位分户账_Repository;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class S_235_SEQ_住房公积金个贷逾期率__月___AND_0302020401_HistoryServiceImpl extends HistoryServiceImpl{
    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_235_SEQ_住房公积金个贷逾期率__月___AND_0302020401;

    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private DP005_单位分户账_Repository dp005__单位分户账_repository;

    @Autowired
    private CM001_单位基本资料表Repository cm001单位基本资料表Repository;









    public void test() {

        List<Triplet<Long,LocalDate,LocalDate>> t = run统计周期编码( LocalDate.now().minusDays(3),LocalDate.now(),StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);

        System.out.println( t+"dddddddddddddddddd");
    }




    public void process() {

       //流水_单位缴存spanTimeSpan( LocalDate.now().minusDays(20000),LocalDate.now());
        targetHistory( LocalDate.now().minusDays(20000),LocalDate.now());
    }




    public void 流水_单位缴存spanTimeSpan(LocalDate beginDateTotal, LocalDate endDateTotal) {
        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
        Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期Between(beginDateTotal.minusDays(1),endDateTotal.plusDays(1));
        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = dp021_单位缴存登记簿s.stream().map(e->e.getUnitaccnum单位账号()).distinct().collect(Collectors.toList());



            cm001_单位基本资料表Map = cm001_单位基本资料表Map(dp);

        dp005_work_unit_单位分户账Map = dp005_单位分户账Map(dp);


        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,statisticalIndexCodeEnum);
        Map<String, CM001_单位基本资料表> finalCm001_单位基本资料表Map = cm001_单位基本资料表Map;
        Map<String, DP005_单位分户账> finalDp005_work_unit_单位分户账Map = dp005_work_unit_单位分户账Map;
        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))
                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_单位分户账 dp005_单位分户账 = finalDp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());
                CM001_单位基本资料表 cm001_单位基本资料表 = finalCm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());


                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_单位分户账);
            })
                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {

                    CollectHistory loanHistory  = new CollectHistory(beginDate,statisticalIndexCodeEnum);


                    loanHistory.setIndexNo(eee.getKey()); // 机构名称
                    loanHistory.setDimension1(eee.getKey()); // 机构名称
                    loanHistory.setDimension2(o.getKey()); // 银行名称

                    loanHistory.setBeginDate(beginDate);
                    loanHistory.setEndDate(endDate);
                    loanHistory.setSeqNum(t.getValue0());



                    loanHistory.setLongValue(o.getValue().stream()
                           // .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                       //     .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            .count());  //
                    collectHistoryRepository.save(loanHistory);



                });


            });







        });










    }



    public void targetHistory(LocalDate beginDateTotal, LocalDate endDateTotal) {



        List<String> list = Arrays.asList(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期,E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还).stream().map(E->E.getText()).collect(Collectors.toList());

        List<LN006_贷款分期还款计划> ln006_贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByCurseqstate本期状态In(list);



        Double value_逾期归还 = ln006_贷款分期还款计划s
                .stream()
                .filter(e->e.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                .collect(Collectors.groupingBy(e->e.getRepaydate1还款日期()))
                .entrySet()
                .stream()

                .mapToDouble(f->{


            Double count_逾期归还 = f.getValue()
                    .stream()
                    .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期归还.getText()))
                    .filter(x->x.getRepaydate1还款日期().isAfter(f.getKey()))
                    //     .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                    .mapToDouble(x->x.getInitialbal0期初余额().doubleValue()).sum();

            return count_逾期归还;

        }).sum();

        Double value_逾期 = ln006_贷款分期还款计划s
                .stream()
                .filter(e->e.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                .collect(Collectors.groupingBy(e->e.getEnddate0终止日期()))
                .entrySet()
                .stream()

                .mapToDouble(f->{


                    Double count_逾期 = f.getValue()
                            .stream()

                            .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                            .filter(x->x.getEnddate0终止日期().isBefore(f.getKey()))
                            //   .filter(x->x.getRepaydate1还款日期().isAfter(e.getValue1()))
                            //     .filter(x->x.getCurseqstate本期状态().equals(E_LN006_贷款分期还款计划_curseqStatusEnum.逾期.getText()))
                            .mapToDouble(x->x.getInitialbal0期初余额().doubleValue()).sum();
                    ;

                    return count_逾期;
                }).sum();







        List<LN101_贷款明细账> ln101_贷款明细账s = ln101_贷款明细账_repository.findAll();

        System.out.println("获得贷款明细"+ ln101_贷款明细账s.size());

        List<DP008_单位明细账> dp008_单位明细账s = dp008__单位明细账_repository.findAll();

        System.out.println("dp008_单位明细账s"+ dp008_单位明细账s.size());
        List<Pair<LocalDate,Double>> sourceList_单位明细账 = dp008_单位明细账s.stream().collect(Collectors.groupingBy(e->e.getTransdate不可为空交易日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e -> {
                    return Pair.with(e.getKey(),e.getValue().stream().mapToDouble(x->x.getAmt_0_不可为空_发生额()).sum());

                }).collect(Collectors.toList());



        List<Pair<LocalDate,Double>> sourceList_贷款明细账 = ln101_贷款明细账s.stream().collect(Collectors.groupingBy(e->e.getTransdate不可为空交易日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e -> {
                    return Pair.with(e.getKey(),e.getValue().stream().mapToDouble(x->x.getTransamt不可为空_交易金额().doubleValue()).sum());

                }).collect(Collectors.toList());



        Double num = 0d;
        List<Triplet<LocalDate,Double,Double>> triplets_单位明细账 = new ArrayList<>();
        for(Pair<LocalDate,Double> triplet: sourceList_单位明细账){

            num += triplet.getValue1();
            triplets_单位明细账.add(Triplet.with(triplet.getValue0(),triplet.getValue1(),num));
        }

        num = 0d;
        List<Triplet<LocalDate,Double,Double>> triplets_贷款明细账 = new ArrayList<>();
        for(Pair<LocalDate,Double> triplet: sourceList_贷款明细账){

            num += triplet.getValue1();
            triplets_贷款明细账.add(Triplet.with(triplet.getValue0(),triplet.getValue1(),num));
        }


        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal, 统计周期编码.H__01_每日);

        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();


            Double 缴存余额_ = triplets_单位明细账.stream()
                    .filter(e->e.getValue0().isBefore(beginDate.plusDays(1)))
                    .sorted(Comparator.comparingLong(e->-e.getValue0().toEpochDay()))
                    .findFirst().get().getValue2();

            Double 贷款余额 = triplets_贷款明细账.stream()
                    .filter(e->e.getValue0().isBefore(beginDate.plusDays(1)))
                    .sorted(Comparator.comparingLong(e->-e.getValue0().toEpochDay()))
                    .findFirst().get().getValue2();


            TargetHistory loanHistory  = new TargetHistory(beginDate,
                    StatisticalIndexCodeEnum.S_65_SEQ_归集余额_AND_0301008101);


            Double value= 贷款余额/缴存余额_ ;

            loanHistory.setDoubleValue(value.longValue());
            targetHistoryRepository.save(loanHistory);






        });












    }


}
