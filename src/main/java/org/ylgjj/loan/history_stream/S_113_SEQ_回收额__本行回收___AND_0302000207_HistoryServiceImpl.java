package org.ylgjj.loan.history_stream;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.*;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.E_LN006_贷款分期还款计划_curseqStatusEnum;
import org.ylgjj.loan.enumT.E_LN008_借款人信息_借款人类型;
import org.ylgjj.loan.outputenum.E_住建部编码_收入水平;
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
public class S_113_SEQ_回收额__本行回收___AND_0302000207_HistoryServiceImpl extends HistoryServiceImpl{
    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_113_SEQ_回收额__本行回收___AND_0302000207;

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



        AnalysisTable rateAnalysisTable = analysisTableRepository.findByTargetNo(statisticalIndexCodeEnum.get指标编码());

        if(rateAnalysisTable == null){
            return;
        }


        if(rateAnalysisTable.getAnalysedEndDate()== null){
            delete(statisticalIndexCodeEnum.get指标名称());

            LocalDate beginDate =  LocalDate.now().minusDays(2000);
            LocalDate endDate = LocalDate.now();

            StopWatch timer = new StopWatch();
            timer.start();

            流水_单位缴存spanTimeSpan( beginDate,endDate);


            rateAnalysisTable.setAnalysedBeginDate(beginDate);
            rateAnalysisTable.setAnalysedEndDate(endDate);
            AnalysisStream rateAnalysisStream = new AnalysisStream();
            rateAnalysisStream.setBeginDate(beginDate);
            rateAnalysisStream.setEndDate(endDate);
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisStream.setStockOrAdditional("Stock");
            updateRateTable(rateAnalysisTable,rateAnalysisStream);


        }else{

            LocalDate beginDate =  rateAnalysisTable.getAnalysedEndDate();
            LocalDate endDate = LocalDate.now();

            StopWatch timer = new StopWatch();
            timer.start();

            流水_单位缴存spanTimeSpan( beginDate,endDate);


            rateAnalysisTable.setAnalysedEndDate(endDate);
            AnalysisStream rateAnalysisStream = new AnalysisStream();
            rateAnalysisStream.setBeginDate(beginDate);
            rateAnalysisStream.setEndDate(endDate);
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisStream.setStockOrAdditional("Additional");
            updateRateTable(rateAnalysisTable,rateAnalysisStream);
        }




        //    targetHistory( LocalDate.now().minusDays(20000),LocalDate.now());
    }

    public void 流水_单位缴存spanTimeSpan(LocalDate beginDateTotal, LocalDate endDateTotal) {
        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
        Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;

        //List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期Between(beginDateTotal.minusDays(1),endDateTotal.plusDays(1));
        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);


        List<LN006_贷款分期还款计划> ln006__贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByRepaydate1还款日期Between(beginDateTotal.minusDays(1),endDateTotal.plusDays(1));



        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,statisticalIndexCodeEnum);

        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();




            ln006__贷款分期还款计划s
                    .stream()
                    .filter(x->x.getRepaydate1还款日期().isAfter(beginDate) && x.getRepaydate1还款日期().isBefore(endDate))
                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                LN003_合同信息 ln003_合同信息 = ln003_合同信息_repository.findByLoancontrcode合同代码(e.getLoancontrcode0合同代码());

                //    DP005_单位分户账 dp005_单位分户账 = finalDp005_work_unit_单位分户账Map.get(e.getCurseqstate本期状态());
                //     CM001_单位基本资料表 cm001_单位基本资料表 = finalCm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());

                LN008_借款人信息 ln008_借款人信息 = ln008_借款人信息MapAll(null).get(e.getLoancontrcode0合同代码())
                        .stream().filter(x->x.getIndiacctype_1_个人账户类型().equals(E_LN008_借款人信息_借款人类型.借款人.getText())).findFirst().get();

                DP005_单位分户账 dp005_单位分户账 = dp005_单位分户账Map.get(ln008_借款人信息.getUnitaccnum_1_单位账号());
                //   CM001_单位基本资料表 cm001_单位基本资料表 = cm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());

                return Triplet.with(e,ln003_合同信息,ln008_借款人信息);
            })
                    .collect(Collectors.groupingBy(e -> e.getValue1().getInstcode_机构代码())).entrySet().forEach(dimension1 -> {
                // TODO 按照 经济类型
                dimension1.getValue().stream().collect(Collectors.groupingBy(e -> {

                    return E_住建部编码_收入水平.from(2019,e.getValue2().getBasenum_0_缴存基数().doubleValue());


                })).entrySet().forEach(dimension2 -> {


                    StreamHistory loanHistory  = new StreamHistory(beginDate,endDate,statisticalIndexCodeEnum);
                    loanHistory.setDimension1(dimension1.getKey()); // 机构名称
                    loanHistory.setDimension2(dimension2.getKey().get名称()); // 机构名称
                    loanHistory.setSeqNum(t.getValue0());



                    Double value = dimension2.getValue().stream()
                            // .filter(z->z.getValue0().getCurseqstate本期状态().equals(CurrentSequencePaymentStatusEnum.提前全部.getText()))
                            .filter(z->{
                                return true;//z.getValue4().stream().filter(g->g.getAgentbankcode不可为空_经办银行().equals(z.getValue5().getAgentbankcode_经办银行())).count()>0;
                            })
                            .mapToDouble(cc->cc.getValue0().getPlanint本期应还利息0().add(cc.getValue0().getPlanprin0本期应还本金()).doubleValue()).sum();
                    loanHistory.setDeltaDoubleValue(value);

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
                run统计周期编码(beginDateTotal,endDateTotal,statisticalIndexCodeEnum);
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
                                statisticalIndexCodeEnum);


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
