package org.ylgjj.loan.history_stream;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Triplet;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.AnalysisStream;
import org.ylgjj.loan.domain_flow.AnalysisTable;
import org.ylgjj.loan.domain_flow.CollectHistory;
import org.ylgjj.loan.domain_flow.TargetHistory;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class S_21_SEQ_新开户职工数__非本市缴存职工___AND_0301003205_HistoryServiceImpl extends HistoryServiceImpl{


    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203;


    public void process() {



        AnalysisTable analysisTable = analysisTableRepository.findByTargetNo(statisticalIndexCodeEnum.get指标编码());

        if(analysisTable == null){
            return;
        }


        if(analysisTable.getAnalysedEndDate()== null){
            deleteSteam(statisticalIndexCodeEnum.get指标编码());

            LocalDate beginDate =  LocalDate.now().minusDays(2000);
            LocalDate endDate = LocalDate.now();

            StopWatch timer = new StopWatch();
            timer.start();

            流水_单位缴存spanTimeSpan( beginDate,endDate);


            analysisTable.setAnalysedBeginDate(beginDate);
            analysisTable.setAnalysedEndDate(endDate);
            AnalysisStream analysisStream = new AnalysisStream();
            analysisStream.setBeginDate(beginDate);
            analysisStream.setEndDate(endDate);
            analysisStream.setDuration(timer.getTime());
            analysisStream.setStockOrAdditional("Stock");
            updateRateTable(analysisTable,analysisStream);


        }else{

            LocalDate beginDate =  analysisTable.getAnalysedEndDate();
            LocalDate endDate = LocalDate.now();

            StopWatch timer = new StopWatch();
            timer.start();

            流水_单位缴存spanTimeSpan( beginDate,endDate);


            analysisTable.setAnalysedEndDate(endDate);
            AnalysisStream rateAnalysisStream = new AnalysisStream();
            rateAnalysisStream.setBeginDate(beginDate);
            rateAnalysisStream.setEndDate(endDate);
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisStream.setStockOrAdditional("Additional");
            updateRateTable(analysisTable,rateAnalysisStream);
        }

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

                    CollectHistory loanHistory  = new CollectHistory(beginDate,StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101);


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





        List<DP007_个人分户账> dp007_个人分户账s = dp007_个人分户账_repository.findAll().stream().filter(e->e.getIndiacctype个人账户类型().equals("")).collect(Collectors.toList());


        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = dp007_个人分户账s.stream().map(e->e.getUnitaccnum_单位账号()).distinct().collect(Collectors.toList());



        cm001_单位基本资料表Map = cm001_单位基本资料表Map(dp);

        dp005_work_unit_单位分户账Map = dp005_单位分户账Map(dp);

        Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map = dp202_单位缴存变更登记簿Map(dp);
        List<Triplet<Long,LocalDate,LocalDate>> triplets =
                run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_21_SEQ_新开户职工数__非本市缴存职工___AND_0301003205);
        Map<String, CM001_单位基本资料表> finalCm001_单位基本资料表Map = cm001_单位基本资料表Map;
        Map<String, DP005_单位分户账> finalDp005_work_unit_单位分户账Map = dp005_work_unit_单位分户账Map;
        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp007_个人分户账s
                    .stream()
                    //.filter(x->x.getTransdate不可为空交易日期().isAfter(beginDate) && x.getTransdate不可为空交易日期().isBefore(endDate))
                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_单位分户账 dp005_单位分户账 = finalDp005_work_unit_单位分户账Map.get(e.getUnitaccnum_单位账号());
                CM001_单位基本资料表 cm001_单位基本资料表 = finalCm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());

                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_单位分户账);


            }).collect(Collectors.groupingBy(e->e.getValue0().getOpnaccdate开户日期()))

                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                    .forEach(e -> {

                        TargetHistory loanHistory  = new TargetHistory(e.getKey(),
                                StatisticalIndexCodeEnum.S_21_SEQ_新开户职工数__非本市缴存职工___AND_0301003205);


                        Long value= e.getValue()
                                .stream()
                                .count();

                        loanHistory.setDoubleValue(value.longValue());
                        targetHistoryRepository.save(loanHistory);




            });







        });










    }

}
