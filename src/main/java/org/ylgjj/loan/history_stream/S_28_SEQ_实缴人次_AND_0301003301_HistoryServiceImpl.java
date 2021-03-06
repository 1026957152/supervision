package org.ylgjj.loan.history_stream;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.CollectHistory;
import org.ylgjj.loan.domain_flow.StreamHistory;
import org.ylgjj.loan.domain_flow.TargetHistory;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.H_DP204_个人缴存变更登记簿_变更类型;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.CM001_单位基本资料表Repository;
import org.ylgjj.loan.repository.DP005_单位分户账_Repository;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class S_28_SEQ_实缴人次_AND_0301003301_HistoryServiceImpl extends HistoryServiceImpl{
    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_28_SEQ_实缴人次_AND_0301003301;

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


        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101);
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

                    StreamHistory loanHistory  = new StreamHistory(beginDate,endDate,statisticalIndexCodeEnum);


                    loanHistory.setTargetNo(eee.getKey()); // 机构名称
                    loanHistory.setDimension1(eee.getKey()); // 机构名称
                    loanHistory.setDimension2(o.getKey()); // 银行名称
                    loanHistory.setSeqNum(t.getValue0());


                    Integer value= o.getValue().stream()
                            .filter(x->{
                                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMM");


                                LocalDate startA = beginDate.with(TemporalAdjusters.firstDayOfYear());
                                LocalDate stopA = beginDate.with(TemporalAdjusters.lastDayOfYear());

                                YearMonth localDate_begin = YearMonth.parse(x.getValue0().getBegym_开始年月(),df);
                                YearMonth localDate_end = YearMonth.parse(x.getValue0().getEndym_截止年月(),df);
                                LocalDate startB = localDate_begin.atDay(1);
                                LocalDate stopB = localDate_end.atEndOfMonth();




                                Boolean overlaps = (
                                        ( startA.isBefore( stopB ) )
                                                &&
                                                ( stopA.isAfter( startB ) )
                                ) ;

                                //   YearMonth myYearMonth = YearMonth.from(beginDate);

                                return overlaps;

                            })
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .mapToInt(x->x.getValue0().getCmpaynum_本月汇缴人数())
                            .sum();

                    loanHistory.setDeltaLongValue(value.longValue());
                    streamHistoryRepository.save(loanHistory);

                });


            });







        });










    }

    public void targetHistory(LocalDate beginDateTotal, LocalDate endDateTotal) {
        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
        Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;


        //  List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s = dp202_单位缴存变更登记簿_repository.findAll();
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s
                = dp022_个人缴存登记薄Repository.findAll();//.collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));


        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = dp022_个人缴存登记簿s.stream().map(e->e.getAccnum个人账号()).distinct().collect(Collectors.toList());



        cm001_单位基本资料表Map = cm001_单位基本资料表Map(dp);

        dp005_work_unit_单位分户账Map = dp005_单位分户账Map(dp);

        Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map = dp202_单位缴存变更登记簿Map(dp);
        List<Triplet<Long,LocalDate,LocalDate>> triplets =
                run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_28_SEQ_实缴人次_AND_0301003301);
        Map<String, CM001_单位基本资料表> finalCm001_单位基本资料表Map = cm001_单位基本资料表Map;
        Map<String, DP005_单位分户账> finalDp005_work_unit_单位分户账Map = dp005_work_unit_单位分户账Map;
        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp022_个人缴存登记簿s
                    .stream()
                    //.filter(x->x.getTransdate不可为空交易日期().isAfter(beginDate) && x.getTransdate不可为空交易日期().isBefore(endDate))
                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_单位分户账 dp005_单位分户账 = finalDp005_work_unit_单位分户账Map.get(e.getUnitaccnum_单位账号());
                CM001_单位基本资料表 cm001_单位基本资料表 = finalCm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());

                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_单位分户账);


            }).collect(Collectors.groupingBy(e->e.getValue2().getOpnaccdate开户日期()))

                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                    .forEach(e -> {

                        TargetHistory loanHistory  = new TargetHistory(e.getKey(),
                                StatisticalIndexCodeEnum.S_28_SEQ_实缴人次_AND_0301003301);



      /*                  Double value= e.getValue().stream()
                                .filter(i->i.getValue0().getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴))
                                .filter(i->i.getValue0().getRegdate登记日期().equals(beginDate))
                                .mapToDouble(g->g.getValue0().getPayamt_缴存金额().doubleValue()).sum();;
                                */

                        Long value = e.getValue().stream()
                                .collect(Collectors.groupingBy(x->x.getValue0().getRegnum_登记号()))
                                .entrySet()
                                .stream().filter(g->{
                            return g.getValue().stream()
                /*                    .filter(x-> Collections.max(x.getValue7().stream()
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_2_启封.getText()))
                                            .filter(c->c.getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))
                                            .filter(c->c.getTransdate不可为空交易日期().plusDays(1).isAfter(beginDate))
                                            .collect(Collectors.toList()),Comparator.comparingLong(l->l.getTransdate不可为空交易日期().toEpochDay()))
                                            .getChgtype_不可为空_变更类型().equals(H_DP204_个人缴存变更登记簿_变更类型.E_4_封存.getText()))*/
                                    .filter(i->i.getValue0().getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                                    .filter(f->{
                                        LocalDate date = LocalDate.parse(f.getValue0().getBegym开始年月(),df);
                                        return date.isAfter(beginDate) && date.isBefore(endDate);
                                    }).count() > 0;
                        })

                                .count();
                        loanHistory.setLongValue(value.longValue());
                        targetHistoryRepository.save(loanHistory);




                    });







        });










    }

}
