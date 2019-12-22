package org.ylgjj.loan.history_stream;


import org.javatuples.Quartet;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.CollectHistory;
import org.ylgjj.loan.domain_flow.TargetHistory;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.CM001_单位基本资料表Repository;
import org.ylgjj.loan.repository.DP005_单位分户账_Repository;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;

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
public class S_241_SEQ_贷款购房建筑面积_AND_0302040004_HistoryServiceImpl extends HistoryServiceImpl{
    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_241_SEQ_贷款购房建筑面积_AND_0302040004;

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



    //@PostConstruct
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
        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
        Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;


        List<LN003_合同信息> ln003__合同信息s = ln003_合同信息_repository.findAll();

        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = ln003__合同信息s.stream().map(e->e.getLoancontrcode合同代码()).distinct().collect(Collectors.toList());


        Map<String,LN005_贷款分户信息> ln005_贷款分户信息Map = ln005_贷款分户信息MapAll();

        Map<String,LN014_贷款房屋信息> ln014_贷款房屋信息Map =  ln014_贷款房屋信息MapAll(dp);

        Map<String,List<LN008_借款人信息>> ln008_借款人信息Map = ln008_借款人信息MapAll(dp);


        ln003__合同信息s
                .stream()
                // .filter(x->x.getLoandate放款日期().isAfter(beginDate) && x.getLoandate放款日期().isBefore(endDate))
                .collect(Collectors.toList()).stream().map(e -> {
            //TODO        获得某一日的缴存列表;



            return Quartet.with(e,
                    ln005_贷款分户信息Map.get(e.getLoancontrnum_借款合同号()),
                    ln014_贷款房屋信息Map.get(e.getLoancontrnum_借款合同号()),
                    ln008_借款人信息Map.get(e.getLoancontrnum_借款合同号()));

        }).collect(Collectors.groupingBy(e->e.getValue0().getLoandate放款日期()))

                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .forEach(e -> {

                    TargetHistory loanHistory  = new TargetHistory(e.getKey(),
                            statisticalIndexCodeEnum);


                    Double value= e.getValue().stream().mapToDouble(j->{
                        if(j.getValue2() == null){
                               System.out.println("000000000找不到房子的价格 null"+j.getValue0().toString());
                            System.out.print(":"+j.getValue0().getLoancontrcode合同代码());

                            return 0;
                        }else{
                            return  j.getValue2().getTnhousearea不可为空_购房面积().doubleValue();
                        }

                    }).sum();

                    loanHistory.setDeltaDoubleValue(value);
                    targetHistoryRepository.save(loanHistory);




                });



    }



}
