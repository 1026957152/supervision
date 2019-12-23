package org.ylgjj.loan.history_stream;


import org.javatuples.Quartet;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.CollectHistory;
import org.ylgjj.loan.domain_flow.StreamHistory;
import org.ylgjj.loan.domain_flow.TargetHistory;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.E_DP202_单位缴存变更登记簿_变更类型;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.CM001_单位基本资料表Repository;
import org.ylgjj.loan.repository.DP005_单位分户账_Repository;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;
import org.ylgjj.loan.util.NativePlace;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class S_33_问_SEQ_封存人数_AND_0301003701_HistoryServiceImpl extends HistoryServiceImpl{
    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_33_SEQ_封存人数_AND_0301003701;

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
        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findAll();
        // List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期Between(beginDateTotal.minusDays(1),endDateTotal.plusDays(1));
        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = dp204_个人缴存变更登记簿s.stream().map(e->e.getAccnum不可为空个人账号()).distinct().collect(Collectors.toList());






        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,statisticalIndexCodeEnum);


        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp204_个人缴存变更登记簿s
                    .stream()
                    .filter(x->x.getTransdate不可为空交易日期().isAfter(beginDate.minusDays(1)) && x.getTransdate不可为空交易日期().isBefore(endDate.plusDays(1)))
                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;



                DP007_个人分户账 dp007_个人分户账 = dp007_个人分户账MapAll().get(e.getAccnum不可为空个人账号());

                DP005_单位分户账 dp005_单位分户账 = dp005_单位分户账MapAll().get(dp007_个人分户账.getUnitaccnum_单位账号());

                CM001_单位基本资料表 cm001_单位基本资料表 = cm001_单位基本资料表MapAll().get(dp005_单位分户账.getUnitcustid_单位客户号());


                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_单位分户账);
            })
                    .collect(Collectors.groupingBy(e -> e.getValue0().getAgentinstcode_不可为空_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {

                    System.out.println("-------------------"+ eee.getKey());
                    System.out.println("-------------------"+ o.getKey());
                    StreamHistory loanHistory  = new StreamHistory(beginDate,endDate,statisticalIndexCodeEnum);


                    loanHistory.setDimension1(eee.getKey()); // 机构名称
                    loanHistory.setDimension2(o.getKey()); // 银行名称

                    loanHistory.setSeqNum(t.getValue0());




                    Integer value = o.getValue().stream()

                            .filter(x->x.getValue0().getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_4_封存.getText()))
                            .mapToInt(x->{
                                if(x.getValue0().getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_4_封存.getText())){
                                    return 1;
                                }
                                if(x.getValue0().getChgtype_不可为空_变更类型().equals(E_DP202_单位缴存变更登记簿_变更类型.E_2_启封.getText())){
                                    return -1;
                                }
                                return 0;
                            })
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
        List<DP006_个人缴存信息表> dp006__个人缴存信息表s = dp006_个人缴存信息表_repository.findAll();

        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = dp006__个人缴存信息表s.stream().map(e->e.getAccnum个人账号()).distinct().collect(Collectors.toList());



        cm001_单位基本资料表Map = cm001_单位基本资料表Map(dp);

        dp005_work_unit_单位分户账Map = dp005_单位分户账Map(dp);

        Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map = dp202_单位缴存变更登记簿Map(dp);
        List<Triplet<Long,LocalDate,LocalDate>> triplets =
                run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_33_SEQ_封存人数_AND_0301003701);
        Map<String, CM001_单位基本资料表> finalCm001_单位基本资料表Map = cm001_单位基本资料表Map;
        Map<String, DP005_单位分户账> finalDp005_work_unit_单位分户账Map = dp005_work_unit_单位分户账Map;
        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp006__个人缴存信息表s
                    .stream()
                    //.filter(x->x.getTransdate不可为空交易日期().isAfter(beginDate) && x.getTransdate不可为空交易日期().isBefore(endDate))
                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;
                DP007_个人分户账 dp005_work_unit_单位分户账 = dp007_个人分户账Map(dp).get(e.getAccnum个人账号());

                DP005_单位分户账 dp005_单位分户账 = finalDp005_work_unit_单位分户账Map.get(dp005_work_unit_单位分户账.getUnitaccnum_单位账号());
                CM001_单位基本资料表 cm001_单位基本资料表 = finalCm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());

                return Quartet.with(e,
                        cm001_单位基本资料表,
                        dp005_单位分户账,dp005_work_unit_单位分户账);


            }).collect(Collectors.groupingBy(e->e.getValue2().getOpnaccdate开户日期()))

                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                    .forEach(e -> {

                        TargetHistory loanHistory  = new TargetHistory(e.getKey(),
                                StatisticalIndexCodeEnum.S_33_SEQ_封存人数_AND_0301003701);

                        Long value =e.getValue()
                                .stream()
                                .filter(x->! NativePlace.isYulin(x.getValue3().getCertinum_证件号码()))
                                .filter(x->x.getValue3().getOpnaccdate开户日期().equals(beginDate)).count();
                        loanHistory.setLongValue(value.longValue());
                        targetHistoryRepository.save(loanHistory);




                    });







        });










    }

}
