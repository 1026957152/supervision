package org.ylgjj.loan.history_stream;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.*;
import org.ylgjj.loan.enumT.E_CM001_单位基本资料表_单位性质;
import org.ylgjj.loan.enumT.E_DP005_单位分户账_单位账户类型;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class S_6_SEQ_新增单位数_AND_0301000501_HistoryServiceImpl extends HistoryServiceImpl{
    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_6_SEQ_新增单位数_AND_0301000501;








    public void test() {

        List<Triplet<Long,LocalDate,LocalDate>> t = run统计周期编码( LocalDate.now().minusDays(3),LocalDate.now(),StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);

        System.out.println( t+"dddddddddddddddddd");
    }




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



        List<DP005_单位分户账> dp005_单位分户账s =  dp005__单位分户账_repository.findAll()
                .stream()
                .filter(e->e.getUnitacctype单位账户类型().equals(E_DP005_单位分户账_单位账户类型.普通.getText()))
                .collect(Collectors.toList());

        List<DP004_单位缴存信息表> dp004_单位缴存信息表s = dp004_单位缴存信息表_repository.findAll();
        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = dp004_单位缴存信息表s.stream().map(e->e.getUnitaccnum单位账号()).distinct().collect(Collectors.toList());



            cm001_单位基本资料表Map = cm001_单位基本资料表Map(dp);




        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,statisticalIndexCodeEnum);
        Map<String, CM001_单位基本资料表> finalCm001_单位基本资料表Map = cm001_单位基本资料表Map;

        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp005_单位分户账s
                    .stream()
                    .filter(x->x.getOpnaccdate开户日期().isAfter(beginDate.minusDays(1)) && x.getOpnaccdate开户日期().isBefore(endDate.plusDays(1)))
                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                CM001_单位基本资料表 cm001_单位基本资料表 = finalCm001_单位基本资料表Map.get(e.getUnitcustid_单位客户号());


                return Pair.with(e,
                        cm001_单位基本资料表);
            })
                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(dimension1 -> {

                // TODO 按照 经济类型
                dimension1.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(dimension2 -> {

                    StreamHistory loanHistory  = new StreamHistory(t.getValue0(),beginDate,endDate,statisticalIndexCodeEnum);

                    loanHistory.setDimension1(pb007_机构信息表Map().get(dimension1.getKey()).getInstName()); // 机构名称
                    loanHistory.setDimension2(E_CM001_单位基本资料表_单位性质.fromString(dimension2.getKey()).getDisplayText()); // 机构名称


                    Long value=dimension2.getValue().stream().count();


                    loanHistory.setDeltaLongValue(value.longValue());

                    streamHistoryRepository.save(loanHistory);



                });


            });







        });










    }



    public void targetHistory(LocalDate beginDateTotal, LocalDate endDateTotal) {
        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
        Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;


        List<DP004_单位缴存信息表> dp004_单位缴存信息表s = dp004_单位缴存信息表_repository.findAll();


        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = dp004_单位缴存信息表s.stream().map(e->e.getUnitaccnum单位账号()).distinct().collect(Collectors.toList());



        cm001_单位基本资料表Map = cm001_单位基本资料表Map(dp);

        dp005_work_unit_单位分户账Map = dp005_单位分户账Map(dp);


        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_6_SEQ_新增单位数_AND_0301000501);
        Map<String, CM001_单位基本资料表> finalCm001_单位基本资料表Map = cm001_单位基本资料表Map;
        Map<String, DP005_单位分户账> finalDp005_work_unit_单位分户账Map = dp005_work_unit_单位分户账Map;
        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp004_单位缴存信息表s
                    .stream()
                    //.filter(x->x.getTransdate不可为空交易日期().isAfter(beginDate) && x.getTransdate不可为空交易日期().isBefore(endDate))
                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_单位分户账 dp005_单位分户账 = finalDp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());
                CM001_单位基本资料表 cm001_单位基本资料表 = finalCm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());


                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_单位分户账);


            }).collect(Collectors.groupingBy(e->e.getValue2().getOpnaccdate开户日期()))

                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                    .forEach(e -> {

                        TargetHistory loanHistory  = new TargetHistory(e.getKey(),StatisticalIndexCodeEnum.S_6_SEQ_新增单位数_AND_0301000501);


                        Long count=e.getValue().stream().map(h->h.getValue2().getOpnaccdate开户日期().equals(beginDate)).count();


                       // loanHistory.setLongValue(count.longValue());
                        loanHistory.setDeltaLongValue(count.longValue());
                        targetHistoryRepository.save(loanHistory);




            });







        });










    }

    public static void main(String[] args){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

        //    LocalDate ldt_jsrq = LocalDate.parse("200612", df);
        LocalDate startA = LocalDate.parse("20060101",df);
        LocalDate stopA = LocalDate.parse("20060102",df);

        LocalDate startB = LocalDate.parse("20060101",df);
        LocalDate stopB = LocalDate.parse("20060102",df);
        Boolean overlaps = (
                ( startA.isBefore( stopB ) )
                        &&
                        ( stopA.isAfter( startB ) ));


        System.out.println(overlaps);

    }
}
