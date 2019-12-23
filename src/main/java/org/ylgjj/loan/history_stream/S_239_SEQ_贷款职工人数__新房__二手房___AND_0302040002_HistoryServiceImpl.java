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
import org.ylgjj.loan.enumT.E_LN008_借款人信息_借款人类型;
import org.ylgjj.loan.enumT.E_ln008_借款人信息_借款人变更类型;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.CM001_单位基本资料表Repository;
import org.ylgjj.loan.repository.DP005_单位分户账_Repository;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class S_239_SEQ_贷款职工人数__新房__二手房___AND_0302040002_HistoryServiceImpl extends HistoryServiceImpl{
    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_239_SEQ_贷款职工人数__新房__二手房___AND_0302040002;

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


        List<LN003_合同信息> ln003__合同信息s = ln003_合同信息_repository.findAll();
        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);




        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,statisticalIndexCodeEnum);

        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            ln003__合同信息s
                    .stream()
                    .filter(x->x.getLoandate放款日期().isAfter(beginDate) && x.getLoandate放款日期().isBefore(endDate))
                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;


                return Quartet.with(e,
                        ln005_贷款分户信息MapAll().get(e.getLoancontrnum_借款合同号()),
                        ln014_贷款房屋信息MapAll(null).get(e.getLoancontrnum_借款合同号()),
                        ln008_借款人信息MapAll(null).get(e.getLoancontrnum_借款合同号()));
            })
                    .collect(Collectors.groupingBy(e -> e.getValue0().getInstcode_机构代码())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue0().getAgentbankcode_经办银行())).entrySet().forEach(x -> {


                    StreamHistory loanHistory  = new StreamHistory(beginDate,endDate,statisticalIndexCodeEnum);
                    loanHistory.setDimension1(eee.getKey()); // 机构名称
                    loanHistory.setDimension2(x.getKey()); // 机构名称

                    loanHistory.setSeqNum(t.getValue0());

                    Double value = eee.getValue().stream().mapToDouble(j->{
                        return  j.getValue3().stream()
                                .filter(o-> o.getLoaneetype_借款人类型().equals(E_LN008_借款人信息_借款人类型.共同借款人.getText()))
                                .count();
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
                    ln005_贷款分户信息Map.get(e.getLoancontrcode合同代码()),
                    ln014_贷款房屋信息Map.get(e.getLoancontrcode合同代码()),
                    ln008_借款人信息Map.get(e.getLoancontrcode合同代码()));

        }).collect(Collectors.groupingBy(e->e.getValue0().getLoandate放款日期()))

                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .forEach(e -> {

                    TargetHistory loanHistory  = new TargetHistory(e.getKey(),
                            statisticalIndexCodeEnum);


                    Long value= e.getValue().stream().mapToLong(j->{

                        return  j.getValue3().stream()
                                .filter(x->x.getLoanopchgtype_0_借款人变更类型().equals(E_ln008_借款人信息_借款人变更类型.无.getText())).count();

                    }).sum();

                    loanHistory.setDeltaLongValue(value);
                    targetHistoryRepository.save(loanHistory);




                });



    }




}
