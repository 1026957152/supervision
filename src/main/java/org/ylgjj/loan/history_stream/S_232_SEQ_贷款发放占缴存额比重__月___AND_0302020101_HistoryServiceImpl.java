package org.ylgjj.loan.history_stream;


import org.apache.commons.lang3.tuple.Triple;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.CollectHistory;
import org.ylgjj.loan.domain_flow.TargetHistory;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.E_LN003_合同信息_合同状态;
import org.ylgjj.loan.enumT.E_LN003_合同信息_放款标志;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.CM001_单位基本资料表Repository;
import org.ylgjj.loan.repository.DP005_单位分户账_Repository;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class S_232_SEQ_贷款发放占缴存额比重__月___AND_0302020101_HistoryServiceImpl extends HistoryServiceImpl{
    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_232_SEQ_贷款发放占缴存额比重__月___AND_0302020101;

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
        targetHistory_( LocalDate.now().minusDays(20000),LocalDate.now());
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
        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
        Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;


/*
        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findAll();

        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);



        List<Pair<LocalDate,Double>> sourceList_单位缴存 = dp021_单位缴存登记簿s.stream()
                .collect(Collectors.groupingBy(e->e.getInaccdate不可为空入账日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e -> {
                    return Pair.with(e.getKey(),e.getValue().stream().mapToDouble(x->x.getFactpayamt_实际缴款金额().doubleValue()).sum());

                }).collect(Collectors.toList());*/



        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findAll();
        List<Pair<LocalDate,Double>> sourceList_合同信息 = ln003_合同信息s.

                stream()
                .filter(e->e.getLoanflag().equals(E_LN003_合同信息_放款标志.E_1_是.getText()))
                .filter(e->!e.getLoancontrstate_合同状态().equals(E_LN003_合同信息_合同状态.合同废弃.getText()))
                .filter(e->!e.getLoandate放款日期().equals(LocalDate.parse("1899-12-31",df_never)))

                .collect(Collectors.groupingBy(e->e.getLoandate放款日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e -> {

                    Double value = e.getValue().stream().mapToDouble(x->x.getLoanamt_贷款金额().doubleValue()).sum();

                    return Pair.with(e.getKey(),value);

                }).collect(Collectors.toList());




        sourceList_合同信息.forEach(e->{
            System.out.println(e.getValue0()+"----------"+e.getValue1());
        });

        Map<LocalDate,Pair<LocalDate,Double>> 合同信息_Map = sourceList_合同信息.stream().collect(Collectors.toMap(e->e.getValue0(),e->e));




        Optional<Pair<LocalDate,Double>> 合同信息_optional_first = sourceList_合同信息.stream()
                .sorted(Comparator.comparingLong(e->e.getValue0().toEpochDay()))
                .findFirst();



        Double total = 0d;
        List<Triplet<Long,LocalDate,LocalDate>> triplets =
                run统计周期编码(合同信息_optional_first.get().getValue0(),endDateTotal, 统计周期编码.H__01_每日);
        for(Triplet<Long,LocalDate,LocalDate> t:triplets){

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            Pair<LocalDate,Double> current =  合同信息_Map.get(beginDate);
            total +=current!=null? current.getValue1():0d;


/*            Optional<Pair<LocalDate,Double>> 合同信息_optional = sourceList_合同信息.stream()
                    .filter(e->e.getValue0().isBefore(beginDate.plusDays(1)))
                    .sorted(Comparator.comparingLong(e->-e.getValue0().toEpochDay()))
                    .findFirst();*/



            TargetHistory loanHistory  = new TargetHistory(beginDate,
                    statisticalIndexCodeEnum);
            loanHistory.setDeltaDoubleValue(current!=null? current.getValue1():0d);
            loanHistory.setDoubleValue(total);
            targetHistoryRepository.save(loanHistory);




/*
  */


/*            Optional<Pair<LocalDate,Double>> 单位缴存_optional = sourceList_单位缴存.stream()
                    .filter(e->e.getValue0().isBefore(beginDate.plusDays(1)))
                    .sorted(Comparator.comparingLong(e->-e.getValue0().toEpochDay()))
                    .findFirst();*/

  //          Double value_单位缴存 =   单位缴存_optional.isPresent()?单位缴存_optional.get().getValue1():0d;

/*            Double value_合同信息=   合同信息_optional.isPresent()?合同信息_optional.get().getValue1():0d;
            TargetHistory loanHistory  = new TargetHistory(beginDate,
                    statisticalIndexCodeEnum);


            loanHistory.setDeltaDoubleValue(value_合同信息);
            //      loanHistory.setDoubleValue(value_单位缴存);
            targetHistoryRepository.save(loanHistory);
            if(合同信息_optional.isPresent()){
                System.out.println(合同信息_optional.get().getValue1());

            }*/







        };

    }















    public void targetHistory_(LocalDate beginDateTotal, LocalDate endDateTotal) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findAll();
        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<Pair<LocalDate,Double>> sourceList_单位缴存 = dp021_单位缴存登记簿s
                .stream()
                .filter(e->!e.getInaccdate不可为空入账日期().equals(LocalDate.parse("1899-12-31",df_never)))
                .collect(Collectors.groupingBy(e->e.getInaccdate不可为空入账日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e -> {
                    return Pair.with(e.getKey(),e.getValue().stream().mapToDouble(x->x.getFactpayamt_实际缴款金额().doubleValue()).sum());

                }).collect(Collectors.toList());

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");




        sourceList_单位缴存.forEach(e->{
            System.out.println(e.getValue0()+"----------"+e.getValue1());
        });

        Map<LocalDate,Pair<LocalDate,Double>> 合同信息_Map = sourceList_单位缴存.stream().collect(Collectors.toMap(e->e.getValue0(),e->e));


        Optional<Pair<LocalDate,Double>> 合同信息_optional_first = sourceList_单位缴存.stream()
                .sorted(Comparator.comparingLong(e->e.getValue0().toEpochDay()))
                .findFirst();



        Double total = 0d;
        List<Triplet<Long,LocalDate,LocalDate>> triplets =
                run统计周期编码(合同信息_optional_first.get().getValue0(),endDateTotal, 统计周期编码.H__01_每日);
        for(Triplet<Long,LocalDate,LocalDate> t:triplets){

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            Pair<LocalDate,Double> current =  合同信息_Map.get(beginDate);
            total +=current!=null? current.getValue1():0d;


/*            Optional<Pair<LocalDate,Double>> 合同信息_optional = sourceList_合同信息.stream()
                    .filter(e->e.getValue0().isBefore(beginDate.plusDays(1)))
                    .sorted(Comparator.comparingLong(e->-e.getValue0().toEpochDay()))
                    .findFirst();*/

/*            TargetHistory loanHistory  = new TargetHistory(beginDate,
                    statisticalIndexCodeEnum);
            loanHistory.setDeltaDoubleValue(current!=null? current.getValue1():0d);
            loanHistory.setDoubleValue(total);
            targetHistoryRepository.save(loanHistory);*/
        };

    }

}
