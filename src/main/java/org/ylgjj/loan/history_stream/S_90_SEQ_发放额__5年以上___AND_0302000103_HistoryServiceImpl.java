package org.ylgjj.loan.history_stream;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.*;
import org.ylgjj.loan.enumT.E_LN008_借款人信息_借款人类型;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class S_90_SEQ_发放额__5年以上___AND_0302000103_HistoryServiceImpl extends HistoryServiceImpl{
    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_90_SEQ_发放额__5年以上___AND_0302000103;




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
            delete(statisticalIndexCodeEnum.get指标名称());

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




        //    targetHistory( LocalDate.now().minusDays(20000),LocalDate.now());
    }




    public void 流水_单位缴存spanTimeSpan(LocalDate beginDateTotal, LocalDate endDateTotal) {

        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByLoandate放款日期Between(beginDateTotal.minusDays(1),endDateTotal.plusDays(1));
        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);
        System.out.println("beginDate-ln003_合同信息s----size-----"+ ln003_合同信息s.size());



        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,statisticalIndexCodeEnum);
        System.out.println("triplets-ln003_合同信息s----triplets-----"+ triplets.size());
        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();
            System.out.println(beginDate+"beginDate- endDate----"+ endDate);
            ln003_合同信息s
                    .stream()
                    .filter(x->x.getLoandate放款日期().isAfter(beginDate.minusDays(1)) && x.getLoandate放款日期().isBefore(endDate.plusDays(1)))
                    .map(x -> {
                //TODO        获得某一日的缴存列表;


                        System.out.println("beginDate-ln003_合同信息s----size-----"+ x.toString());
                return Pair.with(x,null
/*                        ln005_贷款分户信息MapAll().get(e.getLoancontrnum_借款合同号()),
                        ln014_贷款房屋信息MapAll(null).get(e.getLoancontrnum_借款合同号()),
                        ln008_借款人信息MapAll(null).get(e.getLoancontrnum_借款合同号())*/);
            })
                    .collect(Collectors.groupingBy(e -> e.getValue0().getInstcode_机构代码())).entrySet()
                    .forEach(dimension1 -> {


                dimension1.getValue().stream().collect(Collectors.groupingBy(dimension2->dimension2.getValue0().getAgentbankcode_经办银行()))
                        .entrySet().stream().forEach(dimension2->{
                    StreamHistory loanHistory  = new StreamHistory(beginDate,endDate,statisticalIndexCodeEnum);

                    loanHistory.setDimension1(dimension1.getKey()); // 机构名称
                    loanHistory.setDimension2(dimension2.getKey()); // 机构名称
                    loanHistory.setSeqNum(t.getValue0());

                    Double value = dimension2.getValue()
                            .stream()
                            .filter(x->x.getValue0().getLoanterm_贷款期限()> 12*5)
                            .mapToDouble(j->{
                        return  j.getValue0().getLoanamt_贷款金额().doubleValue();
                    }).sum();
                    loanHistory.setDeltaLongValue(value.longValue());
                    streamHistoryRepository.save(loanHistory);
                });

            });

        });










    }




    public void targetHistory(LocalDate beginDateTotal, LocalDate endDateTotal) {
        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
        Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;



        List<DW025_公积金提取审核登记表> dw145_提取结算登记簿s = dw025_公积金提取审核登记表_repository.findAll();

        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = dw145_提取结算登记簿s.stream().map(e->e.getUnitaccnum单位账号()).distinct().collect(Collectors.toList());



        cm001_单位基本资料表Map = cm001_单位基本资料表Map(dp);

        dp005_work_unit_单位分户账Map = dp005_单位分户账Map(dp);

        Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map = dp202_单位缴存变更登记簿Map(dp);
        List<Triplet<Long,LocalDate,LocalDate>> triplets =
                run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_65_SEQ_归集余额_AND_0301008101);
        Map<String, CM001_单位基本资料表> finalCm001_单位基本资料表Map = cm001_单位基本资料表Map;
        Map<String, DP005_单位分户账> finalDp005_work_unit_单位分户账Map = dp005_work_unit_单位分户账Map;
        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dw145_提取结算登记簿s
                    .stream()
                    //.filter(x->x.getTransdate不可为空交易日期().isAfter(beginDate) && x.getTransdate不可为空交易日期().isBefore(endDate))
                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_单位分户账 dp005_单位分户账 = finalDp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());
                CM001_单位基本资料表 cm001_单位基本资料表 = finalCm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());

                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_单位分户账);


            }).collect(Collectors.groupingBy(e->e.getValue0().getTransdate交易日期()))

                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                    .forEach(e -> {

                        TargetHistory loanHistory  = new TargetHistory(e.getKey(),
                                StatisticalIndexCodeEnum.S_65_SEQ_归集余额_AND_0301008101);


                        Long value= e.getValue().stream()
                                .filter(i->i.getValue0().getApprstate_审批状态().equals("d"))
                                .filter(i->i.getValue0().getTransdate交易日期().equals(beginDate))
                                //    .filter(x->x.get().equals(n))

                                .count();

                        loanHistory.setDeltaLongValue(value.longValue());
                        targetHistoryRepository.save(loanHistory);




                    });







        });










    }

}
