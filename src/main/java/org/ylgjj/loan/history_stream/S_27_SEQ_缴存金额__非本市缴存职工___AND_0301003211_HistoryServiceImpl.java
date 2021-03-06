package org.ylgjj.loan.history_stream;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.CollectHistory;
import org.ylgjj.loan.domain_flow.StreamHistory;
import org.ylgjj.loan.domain_flow.TargetHistory;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.E_TR002_联系函基础信息_联系函状态;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.CM001_单位基本资料表Repository;
import org.ylgjj.loan.repository.DP005_单位分户账_Repository;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class S_27_SEQ_缴存金额__非本市缴存职工___AND_0301003211_HistoryServiceImpl extends HistoryServiceImpl{
    StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_27_SEQ_缴存金额__非本市缴存职工___AND_0301003211;

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


        List<TR100_转移接续登记簿> tr100_转移接续登记簿s = tr100_转移接续登记簿Repository
                .findByJyrq不可为空交易日期BetweenOrderByJyrq不可为空交易日期Desc(beginDateTotal.minusDays(1),endDateTotal.plusDays(1));

        //  Map<String,List<TR100_转移接续登记簿>> stringListMap = tr100_转移接续登记簿s.stream().collect(Collectors.groupingBy(e->e.getLxhbh_不可为空_联系函编号()));


        Map<String,List<TR002_联系函基础信息>> tr002_联系函基础信息Map = tr002_联系函基础信息_repository
                .findAll().stream().collect(Collectors.groupingBy(e->e.getLxhbh_不可为空_联系函编号()));


/*
        Map<String,TR003_转移人账户信息> tr003_转移人账户信息Map = tr003_转移人账户信息_repository
                .findAll().stream().collect(Collectors.toMap(e->e.getLxhbh_不可为空_联系函编号(),e->e));
*/



        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,statisticalIndexCodeEnum);


        triplets.stream().forEach(t->{

            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            tr100_转移接续登记簿s
                    .stream()
                    .filter(x->x.getTransdate不可为空交易日期().isAfter(beginDate.minusDays(1)) && x.getTransdate不可为空交易日期().isBefore(endDate.plusDays(1)))

                    .filter(x->x.getJylx_不可为空_交易类型().equals("1"))  ////_1-转入,2-转出_0:;
                    .filter(x->x.getLxhzt_不可为空_联系函状态().equals(E_TR002_联系函基础信息_联系函状态.E_00_正常状态.getText()))

                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;



                // TR003_转移人账户信息 tr003_转移人账户信息 = tr003_转移人账户信息Map.get(e.getLxhbh_不可为空_联系函编号());

                List<TR002_联系函基础信息> tr002_联系函基础信息s = tr002_联系函基础信息Map.get(e.getLxhbh_不可为空_联系函编号());


                //tr002_联系函基础信息s.get(0).getYgrzh_不可为空_原个人账号();

                Optional<TR002_联系函基础信息> tr002_联系函基础信息Optional = tr002_联系函基础信息s
                        .stream()
                        .filter(x->x.getLxhzt_不可为空_联系函状态().equals(E_TR002_联系函基础信息_联系函状态.E_00_正常状态.getText()))
                        .findFirst();

                if(tr002_联系函基础信息Optional.isPresent()){
                    DP007_个人分户账 dp007_个人分户账 = dp007_个人分户账MapAll().get(tr002_联系函基础信息Optional.get().getYgrzh_不可为空_原个人账号());

                    DP005_单位分户账 dp005_单位分户账 = dp005_单位分户账MapAll().get(dp007_个人分户账.getUnitaccnum_单位账号());

                    CM001_单位基本资料表 cm001_单位基本资料表 = cm001_单位基本资料表MapAll().get(dp005_单位分户账.getUnitcustid_单位客户号());
                    return Triplet.with(e,
                            cm001_单位基本资料表,
                            dp005_单位分户账);
                }else{
                    return null;
                }




            }).filter(e->e!=null)
                    .collect(Collectors.groupingBy(e -> e.getValue0().getInstcode_不可为空_机构代码())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {

                    System.out.println("-------------------"+ eee.getKey());
                    System.out.println("-------------------"+ o.getKey());
                    StreamHistory loanHistory  = new StreamHistory(beginDate,endDate,statisticalIndexCodeEnum);


                    loanHistory.setDimension1(eee.getKey()); // 机构名称
                    loanHistory.setDimension2(o.getKey()); // 银行名称

                    loanHistory.setSeqNum(t.getValue0());



                    Long value = o.getValue().stream()

                            .count();
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
                run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_27_SEQ_缴存金额__非本市缴存职工___AND_0301003211);
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
                                StatisticalIndexCodeEnum.S_27_SEQ_缴存金额__非本市缴存职工___AND_0301003211);



                        Double value= e.getValue().stream()
                                .filter(i->i.getValue0().getColpaytype_汇缴类型0().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴))
                                .filter(i->i.getValue0().getRegdate登记日期().equals(beginDate))
                                .mapToDouble(g->g.getValue0().getPayamt_缴存金额().doubleValue()).sum();;

                        loanHistory.setDoubleValue(value.longValue());
                        targetHistoryRepository.save(loanHistory);




                    });







        });










    }

}
