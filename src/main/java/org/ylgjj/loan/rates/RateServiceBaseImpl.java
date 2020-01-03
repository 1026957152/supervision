package org.ylgjj.loan.rates;


import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.DP007_个人分户账;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.enumT.E_dp007_个人分户账_类型;
import org.ylgjj.loan.outputenum.E_HISTORY_数据来源;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.ProRateHistoryRepository;
import org.ylgjj.loan.repository_flow.RateAnalysisTableRepository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import org.ylgjj.loan.repository_flow.RateAnalysisStreamRepository;

import static org.ylgjj.loan.history_stream.HistoryServiceImpl.run统计周期编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class RateServiceBaseImpl {


    @Autowired
    protected LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    protected LN004_合同状态信息Repository ln004_合同状态信息Repository;
    @Autowired
    protected LN101_贷款明细账_Repository ln101_贷款明细账_repository;
    @Autowired
    protected DP008_单位明细账_Repository dp008_单位明细账_repository;
    @Autowired
    protected DP009_个人明细账_Repository dp009_个人明细账_repository;
    @Autowired
    protected DP204_个人缴存变更登记簿_Repository dp204_个人缴存变更登记簿_repository;

    @Autowired
    protected DP030_单位缓缴登记簿_Repository dp030_单位缓缴登记簿_repository;
    @Autowired
    protected RateHistoryRepository rateHistoryRepository;

    protected DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    protected RateAnalysisStreamRepository rateAnalysisStreamRepository;
    @Autowired
    protected RateAnalysisTableRepository rateAnalysisTableRepository;

    @Autowired
    protected DP004_单位缴存信息表_Repository dp004_单位缴存信息表_repository;
    @Autowired
    protected ProRateHistoryRepository proRateHistoryRepository;



    @Autowired
    protected DW025_公积金提取审核登记表_Repository dw025_公积金提取审核登记表_repository;
    @Autowired
    protected DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;
    @Autowired
    protected DP034_公积金开销户登记簿_Repository dp034_公积金开销户登记簿_repository;
    @Autowired
    protected DP005_单位分户账_Repository dp005_单位分户账_repository;
    @Autowired
    protected DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;

    @Autowired
    protected DP007_个人分户账_Repository dp007_个人分户账_repository;



    @Autowired
    protected DP006_个人缴存信息表_Repository dp006_个人缴存信息表_repository;


    @Autowired
    protected DP093_冻结解冻登记簿_Repository dp093_冻结解冻登记簿_repository;

    @Autowired
    protected DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;

    @Autowired
    protected CM001_单位基本资料表Repository cm001_单位基本资料表Repository;

    @Autowired
    protected TR100_转移接续登记簿Repository tr100_转移接续登记簿Repository;


    @Transactional
    public void saveAccDouble(List<Pair<LocalDate,Double>> triplets, E_指标_RATE_SY e_指标_rate_sy) {
        triplets.stream().forEach(e->{
            RateHistory rateHistory = rateHistoryRepository.findByIndexNoAndDateAndType(e_指标_rate_sy.get编码(),e.getValue0(),E_HISTORY_数据来源.Reduction_流水还原.get编码());
            if(rateHistory== null) {
                rateHistory = new RateHistory(e.getValue0(), e_指标_rate_sy,E_HISTORY_数据来源.Reduction_流水还原);
                rateHistory.setDoubleValue(e.getValue1());
                rateHistoryRepository.save(rateHistory);
            }
            System.out.println("-----------"+ e.toString());
        });

    }
    @Transactional
    public void saveDeltaDouble(List<Pair<LocalDate,Double>> triplets, E_指标_RATE_SY e_指标_rate_sy) {
        triplets.stream().forEach(e->{
            RateHistory rateHistory = rateHistoryRepository.findByIndexNoAndDateAndType(e_指标_rate_sy.get编码(),e.getValue0(),E_HISTORY_数据来源.Reduction_流水还原.get编码());
            if(rateHistory== null) {
                rateHistory = new RateHistory(e.getValue0(), e_指标_rate_sy,E_HISTORY_数据来源.Reduction_流水还原);
                rateHistory.setDeltaDoubleValue(e.getValue1());
                rateHistoryRepository.save(rateHistory);
            }
            System.out.println("-----------"+ e.toString());
        });

    }
    @Transactional
    public void saveAccLong(List<Pair<LocalDate,Long>> triplets, E_指标_RATE_SY e_指标_rate_sy) {
        triplets.stream().forEach(e->{
            RateHistory rateHistory = rateHistoryRepository.findByIndexNoAndDateAndType(e_指标_rate_sy.get编码(),e.getValue0(),E_HISTORY_数据来源.Reduction_流水还原.get编码());
            if(rateHistory== null) {
                rateHistory = new RateHistory(e.getValue0(), e_指标_rate_sy,E_HISTORY_数据来源.Reduction_流水还原);
                rateHistory.setLongValue(e.getValue1());
                rateHistoryRepository.save(rateHistory);
            }
            System.out.println("-----------"+ e.toString());
        });

    }


    @Transactional
    public void saveDeltaLong(List<Pair<LocalDate,Long>> triplets, E_指标_RATE_SY e_指标_rate_sy) {
        triplets.stream().forEach(e->{
            RateHistory rateHistory = rateHistoryRepository.findByIndexNoAndDateAndType(e_指标_rate_sy.get编码(),e.getValue0(),E_HISTORY_数据来源.Reduction_流水还原.get编码());
            if(rateHistory== null) {
                rateHistory = new RateHistory(e.getValue0(), e_指标_rate_sy,E_HISTORY_数据来源.Reduction_流水还原);
                rateHistory.setDeltaLongValue(e.getValue1());
                rateHistoryRepository.save(rateHistory);
            }
            System.out.println("-----------"+ e.toString());
        });

    }




    @Transactional
    public void saveAccLongRealtime(Long value, LocalDate now,E_指标_RATE_SY e_指标_rate_sy) {
        RateHistory rateHistory = rateHistoryRepository.findByIndexNoAndDateAndType(e_指标_rate_sy.get编码(),now,E_HISTORY_数据来源.Realtime_State.get编码());
        if(rateHistory== null) {
            rateHistory = new RateHistory(LocalDate.now(), e_指标_rate_sy, E_HISTORY_数据来源.Realtime_State);
            rateHistory.setLongValue(value);

            rateHistoryRepository.save(rateHistory);
        }
    }

    @Transactional
    public void saveAccDoubleRealtime(Double value, LocalDate now,E_指标_RATE_SY e_指标_rate_sy) {
        RateHistory rateHistory = rateHistoryRepository.findByIndexNoAndDateAndType(e_指标_rate_sy.get编码(),now,E_HISTORY_数据来源.Realtime_State.get编码());
        if(rateHistory== null) {
            rateHistory = new RateHistory(LocalDate.now(), e_指标_rate_sy, E_HISTORY_数据来源.Realtime_State);
            rateHistory.setDoubleValue(value);
            rateHistoryRepository.save(rateHistory);
        }
    }








    @Modifying
    @Transactional
    public void updateRateTable(RateAnalysisTable rateAnalysisTable, RateAnalysisStream rateAnalysisStream) {
        rateAnalysisStream.setRateTableId(rateAnalysisTable.getId());
        rateAnalysisStreamRepository.save(rateAnalysisStream);

        rateAnalysisTable.setUpdateTime(LocalDateTime.now().toLocalDate());
        rateAnalysisTableRepository.save(rateAnalysisTable);

    }

    public Triplet<Long,Long,Long> queryLong期末(E_指标_RATE_SY e_指标_rate_sy, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {


        if(rateHistories.size()==0) return Triplet.with(0L,0L,0L);


        Optional<ProRateHistory> optionalRateHistory_环比 = rateHistories_环比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .findFirst();
        Long rateHistory_环比 = optionalRateHistory_环比.isPresent()? optionalRateHistory_环比.get().getLongValue(): 0;


        Optional<ProRateHistory> optionalRateHistory_同比 = rateHistories_同比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .findFirst();
        Long rateHistory_同比 = optionalRateHistory_同比.isPresent()? optionalRateHistory_同比.get().getLongValue(): 0;

        Optional<ProRateHistory> optionalRateHistory = rateHistories
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .findFirst();
        Long rateHistory = optionalRateHistory.isPresent()? optionalRateHistory.get().getLongValue(): 0;


        System.out.println("-==="+e_指标_rate_sy.get名称());
        System.out.println("-=rateHistory=="+rateHistory);
    //    System.out.println("-=optionalRateHistory_环比=="+optionalRateHistory_环比.get());
      //  System.out.println("-=optionalRateHistory_同比=="+optionalRateHistory_同比.get());
        return Triplet.with(rateHistory,rateHistory_环比,rateHistory_同比);




    }

    public Triplet<Long,Long,Long> queryLong本期值(E_指标_RATE_SY e_指标_rate_sy, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {


        if(rateHistories.size()==0) return Triplet.with(0L,0L,0L);


        Long rateHistory_环比 = rateHistories_环比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToLong(e->e.getDeltaLongValue()).sum();

        System.out.println("--rateHistories_环比--------"+rateHistories_环比);

        Long rateHistory_同比  = rateHistories_同比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToLong(e->e.getDeltaLongValue()).sum();

        Long rateHistory = rateHistories
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToLong(e->e.getDeltaLongValue()).sum();


        System.out.println("-==="+e_指标_rate_sy.get名称());
        System.out.println("-=rateHistory=="+rateHistory);
        //    System.out.println("-=optionalRateHistory_环比=="+optionalRateHistory_环比.get());
        //  System.out.println("-=optionalRateHistory_同比=="+optionalRateHistory_同比.get());
        return Triplet.with(rateHistory,rateHistory_环比,rateHistory_同比);




    }
    public Triplet<Double,Double,Double> queryDouble本期值(E_指标_RATE_SY e_指标_rate_sy, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {


        if(rateHistories.size()==0) return Triplet.with(0d,0d,0d);


        Double rateHistory_环比 = rateHistories_环比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToDouble(e->e.getDeltaDoubleValue()).sum();

        System.out.println("--rateHistories_环比--------"+rateHistories_环比);

        Double rateHistory_同比  = rateHistories_同比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToDouble(e->e.getDeltaDoubleValue()).sum();

        Double rateHistory = rateHistories
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToDouble(e->e.getDeltaDoubleValue()).sum();


        System.out.println("-==="+e_指标_rate_sy.get名称());
        System.out.println("-=rateHistory=="+rateHistory);
        //    System.out.println("-=optionalRateHistory_环比=="+optionalRateHistory_环比.get());
        //  System.out.println("-=optionalRateHistory_同比=="+optionalRateHistory_同比.get());
        return Triplet.with(rateHistory,rateHistory_环比,rateHistory_同比);




    }

    public Triplet<Double,Double,Double> queryDouble期末(E_指标_RATE_SY e_指标_rate_sy, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {


        if(rateHistories.size()==0) return Triplet.with(0d,0d,0d);


        Optional<ProRateHistory> optionalRateHistory_环比 = rateHistories_环比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .findFirst();
        Double rateHistory_环比 = optionalRateHistory_环比.isPresent()? optionalRateHistory_环比.get().getDoubleValue(): 0;


        Optional<ProRateHistory> optionalRateHistory_同比 = rateHistories_同比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .findFirst();
        Double rateHistory_同比 = optionalRateHistory_同比.isPresent()? optionalRateHistory_同比.get().getDoubleValue(): 0;

        Optional<ProRateHistory> optionalRateHistory = rateHistories
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .findFirst();
        Double rateHistory = optionalRateHistory.isPresent()? optionalRateHistory.get().getDoubleValue(): 0;


        System.out.println("-==="+e_指标_rate_sy.get名称());
        System.out.println("-=rateHistory=="+rateHistory);
        //    System.out.println("-=optionalRateHistory_环比=="+optionalRateHistory_环比.get());
        //  System.out.println("-=optionalRateHistory_同比=="+optionalRateHistory_同比.get());
        return Triplet.with(rateHistory,rateHistory_环比,rateHistory_同比);




    }











    public void complete(E_指标_RATE_SY e_指标_rate_sy,统计周期编码 周期) {

        List<RateHistory> rateHistories_所有 = rateHistoryRepository.findByIndexNo(e_指标_rate_sy.get编码());







        Optional<RateHistory> 合同信息_optional_first = rateHistories_所有.stream()
                .filter(e->!e.getDate().equals(LocalDate.parse("1899-12-31",df)))

                .sorted(Comparator.comparingLong(e->e.getDate().toEpochDay()))
                .findFirst();

        Optional<RateHistory> 合同信息_optional_end = rateHistories_所有.stream()
                .filter(e->!e.getDate().equals(LocalDate.parse("1899-12-31",df)))

                .sorted(Comparator.comparingLong(e->-e.getDate().toEpochDay()))
                .findFirst();


        List<Triplet<Long, LocalDate, LocalDate>> triplets_enum = run统计周期编码(合同信息_optional_first.get().getDate(),合同信息_optional_end.get().getDate(), 周期);

        for(Triplet<Long, LocalDate, LocalDate> triplet_peried: triplets_enum){



            if(triplet_peried.getValue1().isBefore(LocalDate.now().plusDays(1))){
                completeSave(triplet_peried.getValue1(),e_指标_rate_sy);
            }

            if(triplet_peried.getValue2().isBefore(LocalDate.now().plusDays(1))){
                completeSave(triplet_peried.getValue2(),e_指标_rate_sy);
            }



        }




    }



    @Transactional
    public void completeSave(LocalDate rateHistory,E_指标_RATE_SY e_指标_rate_sy){


        RateHistory rateHistory_new = rateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(),rateHistory);

        if(rateHistory_new==null){
            rateHistory_new= new RateHistory();
            rateHistory_new.setIndexNo(e_指标_rate_sy.get编码());
            rateHistory_new.setDate(rateHistory);
            rateHistory_new.setType(E_HISTORY_数据来源.fill.get编码());
            rateHistory_new.setDoubleValue(null);
            rateHistory_new.setLongValue(null);
            rateHistory_new.setDeltaDoubleValue(0D);
            rateHistory_new.setDeltaLongValue(0L);

            rateHistoryRepository.save(rateHistory_new);
        }

    }




    Map<String, DP007_个人分户账> dp007_个人分户账Map = null;
    public Map<String, DP007_个人分户账> dp007_个人分户账MapAll() {


        if(dp007_个人分户账Map == null){

            dp007_个人分户账Map =  dp007_个人分户账_repository.findAll()
                    .stream()
                    .filter(e->e.getIndiacctype个人账户类型().equals(E_dp007_个人分户账_类型.E_1_正常.getText()))
                    .collect(Collectors.toMap(e -> e.getAccnum_个人账号(),e->e));
        }
        return dp007_个人分户账Map;
    }

    List<DP007_个人分户账> dp007_个人分户账List = null;
    public List<DP007_个人分户账> dp007_个人分户账List() {


        if(dp007_个人分户账List == null){

            dp007_个人分户账List =  dp007_个人分户账_repository.findAll()
                    .stream()
                    .filter(e->e.getIndiacctype个人账户类型().equals(E_dp007_个人分户账_类型.E_1_正常.getText()))
                    .collect(Collectors.toList());
        }
        return dp007_个人分户账List;
    }


    public void deleteAll(E_指标_RATE_SY e_指标_rate_sy) {

        rateHistoryRepository.deleteByIndexNo(e_指标_rate_sy.get编码());
    }
    public void deleteReduction_流水还原(E_指标_RATE_SY e_指标_rate_sy) {

        rateHistoryRepository.deleteByIndexNoAndTypeIn(e_指标_rate_sy.get编码(),Arrays.asList(E_HISTORY_数据来源.Reduction_流水还原.get编码(),E_HISTORY_数据来源.fill.get编码()));
    }


    public void deleteReduction_流水还原_Pro(E_指标_RATE_SY e_指标_rate_sy) {

        proRateHistoryRepository.deleteByIndexNo(e_指标_rate_sy.get编码());
    }






    @Transactional
    protected void transfer期末ToPro(E_指标_RATE_SY e_指标_rate_sy) {



        List<RateHistory> rateHistories1 = rateHistoryRepository.findByIndexNo(e_指标_rate_sy.get编码())
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDate())).entrySet().stream().map(e -> {
                    Optional<RateHistory> o = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).findFirst();
                    if (o.isPresent()) {
                        return o.get();
                    } else {
                        Optional<RateHistory> p = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).findFirst();
                        if(p.isPresent()){
                            return p.get();
                        }else{
                            Optional<RateHistory> t = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).findFirst();

                            if(t.isPresent()){
                                return t.get();
                            }else{
                                return null;
                            }

                        }

                    }
                }).filter(e->e!= null).sorted(Comparator.comparingLong(e -> -e.getDate().toEpochDay())).collect(Collectors.toList());//.collect(Collectors.toList());


        RateHistory preAcc = null;
        for (RateHistory rateHistory : rateHistories1) {
            System.out.println(rateHistory.getDate()+"------------------------"+rateHistory.getType());
            System.out.println(rateHistory.getDate()+"------------------------"+rateHistory.toString());

            if (preAcc != null) {
                if (preAcc.getLongValue() != null) {
                    rateHistory.setLongValue(preAcc.getLongValue() - rateHistory.getDeltaLongValue());
                }
            }

            preAcc = rateHistory;

        }

        rateHistories1.forEach(e -> {

            System.out.println("------------------------"+e.toString());
            ProRateHistory proRateHistory = proRateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(), e.getDate());
            if (proRateHistory == null) {
                proRateHistory = new ProRateHistory(e);
            }else{
                proRateHistory.setLongValue(e.getLongValue());
                proRateHistory.setDeltaLongValue(e.getDeltaLongValue());
                proRateHistory.setDoubleValue(e.getDoubleValue());
                proRateHistory.setDeltaDoubleValue(e.getDeltaDoubleValue());
            }
            proRateHistoryRepository.save(proRateHistory);

        });


    }


    @Transactional
    protected void transfer累计ToPro从后(E_指标_RATE_SY e_指标_rate_sy) {



        List<RateHistory> rateHistories1 = rateHistoryRepository.findByIndexNo(e_指标_rate_sy.get编码())
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDate())).entrySet().stream().map(e -> {
                    Optional<RateHistory> o = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).findFirst();
                    if (o.isPresent()) {
                        return o.get();
                    } else {
                        Optional<RateHistory> p = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).findFirst();
                        if(p.isPresent()){
                            return p.get();
                        }else{
                            Optional<RateHistory> t = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).findFirst();

                            if(t.isPresent()){
                                return t.get();
                            }else{
                                return null;
                            }

                        }

                    }
                }).filter(e->e!= null).sorted(Comparator.comparingLong(e -> e.getDate().toEpochDay())).collect(Collectors.toList());//.collect(Collectors.toList());


        Long valueLong = 0L;
        Double valueDouble = 0D;
        for (RateHistory rateHistory : rateHistories1) {
            System.out.println(rateHistory.getDate()+"------------------------"+rateHistory.getType());
            System.out.println(rateHistory.getDate()+"------------------------"+rateHistory.toString());
            valueDouble += rateHistory.getDeltaDoubleValue();
            valueLong += rateHistory.getDeltaLongValue();
            rateHistory.setLongValue(valueLong);
            rateHistory.setDoubleValue(valueDouble);


        }

        rateHistories1.forEach(e -> {

            System.out.println("------------------------"+e.toString());
            ProRateHistory proRateHistory = proRateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(), e.getDate());
            if (proRateHistory == null) {
                proRateHistory = new ProRateHistory(e);
            }else{
                proRateHistory.setLongValue(e.getLongValue());
                proRateHistory.setDeltaLongValue(e.getDeltaLongValue());
                proRateHistory.setDoubleValue(e.getDoubleValue());
                proRateHistory.setDeltaDoubleValue(e.getDeltaDoubleValue());
            }
            proRateHistoryRepository.save(proRateHistory);

        });


    }





    @Transactional
    protected void transfer累计ToPro从后(LocalDate parse, E_指标_RATE_SY e_指标_rate_sy, String doubleClass) {


        List<RateHistory> rateHistories1 = rateHistoryRepository.findByIndexNo(e_指标_rate_sy.get编码())
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDate())).entrySet().stream().map(e -> {
                    System.out.println("pppppp"+e);
                    Long count = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).count();
                    if(count>0){
                        return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).findFirst().get();
                    }else{
                        Long count_ = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).count();
                        if(count_ > 0) {
                            return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).findFirst().get();
                        }else{
                            Long count_2 = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).count();
                            if (count_2>0){
                                return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).findFirst().get();

                            }else{
                                return null;
                            }
                        }

                    }


                }).filter(e->e!= null).sorted(Comparator.comparingLong(e -> e.getDate().toEpochDay())).collect(Collectors.toList());//.collect(Collectors.toList());





        RateHistory rateHistorySecond =rateHistories1.stream().sorted(Comparator.comparingLong(e -> -e.getDate().toEpochDay())).findFirst().get();
        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(parse,rateHistorySecond.getDate(),统计周期编码.H__01_每日);

        triplets.forEach(e -> {
            ProRateHistory proRateHistory = proRateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(), e.getValue1());
            if (proRateHistory == null) {
                proRateHistory = new ProRateHistory(e_指标_rate_sy,e.getValue1());
            }

            if(doubleClass.equals(Double.class.getName())){

                RateHistory frontValue = rateHistories1.stream()
                        .filter(x->x.getDate().isAfter(e.getValue1().minusDays(1)))
                        .filter(x->x.getType().equals(e.getValue1().minusDays(1))).findFirst().get();

                List<RateHistory> value_ = rateHistories1.stream()
                        .filter(x->x.getDate().isAfter(e.getValue1().minusDays(1)))
                        .filter(x->x.getDate().isBefore(frontValue.getDate().minusDays(1)))
                        .collect(Collectors.toList());


                Double value = value_.stream().mapToDouble(x->{
                            System.out.println("----找到一个"+x.toString());
                            return x.getDeltaDoubleValue();
                        }).sum();

                proRateHistory.setDoubleValue(frontValue.getDoubleValue() - value);


            }
            if(doubleClass.equals(Long.class.getName())){
                Long value = rateHistories1.stream()
                        .filter(x->x.getDate().isBefore(e.getValue1().plusDays(1)))
                        .mapToLong(x->{
                            System.out.println("----找到一个"+x.toString());
                            return x.getDeltaLongValue();
                        }).sum();

                proRateHistory.setLongValue(value);
            }
            //proRateHistory.setDeltaDoubleValue(e.getValue1());
            //System.out.println("------------存储了一个 数据啊啊啊");
            proRateHistoryRepository.save(proRateHistory);

        });









    }


    @Transactional
    protected void transfer累计ToPro(LocalDate parse, E_指标_RATE_SY e_指标_rate_sy, String doubleClass) {


        List<RateHistory> rateHistories1 = rateHistoryRepository.findByIndexNo(e_指标_rate_sy.get编码())
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDate())).entrySet().stream().map(e -> {
                    System.out.println("pppppp"+e);
                    Long count = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).count();
                    if(count>0){
                        return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).findFirst().get();
                    }else{
                        Long count_ = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).count();
                        if(count_ > 0) {
                            return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).findFirst().get();
                        }else{
                            Long count_2 = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).count();
                            if (count_2>0){
                                return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).findFirst().get();

                            }else{
                                return null;
                            }
                        }

                    }


                }).filter(e->e!= null).sorted(Comparator.comparingLong(e -> e.getDate().toEpochDay())).collect(Collectors.toList());//.collect(Collectors.toList());





        RateHistory rateHistorySecond =rateHistories1.stream().sorted(Comparator.comparingLong(e -> -e.getDate().toEpochDay())).findFirst().get();
        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(parse,rateHistorySecond.getDate(),统计周期编码.H__01_每日);

        triplets.forEach(e -> {
            ProRateHistory proRateHistory = proRateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(), e.getValue1());
            if (proRateHistory == null) {
                proRateHistory = new ProRateHistory(e_指标_rate_sy,e.getValue1());
            }

            if(doubleClass.equals(Double.class.getName())){
                Double value = rateHistories1.stream()
                        .filter(x->x.getDate().isBefore(e.getValue1().plusDays(1)))
                        .mapToDouble(x->{
                            System.out.println("----找到一个"+x.toString());
                            return x.getDeltaDoubleValue();
                        }).sum();

                proRateHistory.setDoubleValue(value);
            }
            if(doubleClass.equals(Long.class.getName())){
                Long value = rateHistories1.stream()
                        .filter(x->x.getDate().isBefore(e.getValue1().plusDays(1)))
                        .mapToLong(x->{
                            System.out.println("----找到一个"+x.toString());
                            return x.getDeltaLongValue();
                        }).sum();

                proRateHistory.setLongValue(value);
            }
            //proRateHistory.setDeltaDoubleValue(e.getValue1());
            System.out.println("------------存储了一个 数据啊啊啊");
            proRateHistoryRepository.save(proRateHistory);

        });









    }


    @Transactional
    protected void transfer累计ToProFrom前(LocalDate parse, E_指标_RATE_SY e_指标_rate_sy, String doubleClass) {


        List<RateHistory> rateHistories1 = rateHistoryRepository.findByIndexNo(e_指标_rate_sy.get编码())
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDate())).entrySet().stream().map(e -> {
                    System.out.println("pppppp"+e);
                    Long count = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).count();
                    if(count>0){
                        return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).findFirst().get();
                    }else{
                        Long count_ = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).count();
                        if(count_ > 0) {
                            return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).findFirst().get();
                        }else{
                            Long count_2 = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).count();
                            if (count_2>0){
                                return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).findFirst().get();

                            }else{
                                return null;
                            }
                        }

                    }


                }).filter(e->e!= null).sorted(Comparator.comparingLong(e -> e.getDate().toEpochDay())).collect(Collectors.toList());//.collect(Collectors.toList());





        RateHistory rateHistorySecond =rateHistories1.stream().sorted(Comparator.comparingLong(e -> -e.getDate().toEpochDay())).findFirst().get();
        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(parse,rateHistorySecond.getDate(),统计周期编码.H__01_每日);

        triplets.forEach(e -> {
            ProRateHistory proRateHistory = proRateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(), e.getValue1());
            if (proRateHistory == null) {
                proRateHistory = new ProRateHistory(e_指标_rate_sy,e.getValue1());
            }

            if(doubleClass.equals(Double.class.getName())){
                Double value = rateHistories1.stream()
                        .filter(x->x.getDate().isBefore(e.getValue1().plusDays(1)))
                        .mapToDouble(x->{
                            System.out.println("----找到一个"+x.toString());
                            return x.getDeltaDoubleValue();
                        }).sum();

                proRateHistory.setDoubleValue(value);
            }
            if(doubleClass.equals(Integer.class.getName())){
                Long value = rateHistories1.stream()
                        .filter(x->x.getDate().isBefore(e.getValue1().plusDays(1)))
                        .mapToLong(x->{
                            System.out.println("----找到一个"+x.toString());
                            return x.getDeltaLongValue();
                        }).sum();

                proRateHistory.setLongValue(value);
            }
            //proRateHistory.setDeltaDoubleValue(e.getValue1());
            System.out.println("------------存储了一个 数据啊啊啊");
            proRateHistoryRepository.save(proRateHistory);

        });









    }

    @Transactional
    protected void transfer本年累计ToPro(E_指标_RATE_SY e_指标_rate_sy, String doubleClass) {

        List<RateHistory> rateHistories1 = rateHistoryRepository.findByIndexNo(e_指标_rate_sy.get编码())
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDate())).entrySet().stream().map(e -> {
                    System.out.println("pppppp"+e);
                    Long count = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).count();
                    if(count>0){
                        return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).findFirst().get();
                    }else{
                        Long count_ = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).count();
                        if(count_ > 0) {
                            return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).findFirst().get();
                        }else{
                            Long count_2 = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).count();
                            if (count_2>0){
                                return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).findFirst().get();

                            }else{
                                return null;
                            }
                        }

                    }


                }).filter(e->e!= null).sorted(Comparator.comparingLong(e -> e.getDate().toEpochDay())).collect(Collectors.toList());//.collect(Collectors.toList());



        Map<Integer,List<RateHistory>> maps = rateHistories1.stream().collect(Collectors.groupingBy(e->e.getDate().getYear()));


        RateHistory rateHistory = rateHistories1.stream().sorted(Comparator.comparingLong(e -> e.getDate().toEpochDay())).findFirst().get();

        RateHistory rateHistorySecond =rateHistories1.stream().sorted(Comparator.comparingLong(e -> -e.getDate().toEpochDay())).findFirst().get();


        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(rateHistory.getDate(),rateHistorySecond.getDate(),统计周期编码.H__01_每日);

        triplets.forEach(e -> {
            ProRateHistory proRateHistory = proRateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(), e.getValue1());
            if (proRateHistory == null) {
                proRateHistory = new ProRateHistory(e_指标_rate_sy,e.getValue1());
            }

            if(doubleClass.equals(Double.class.getName())){
                Double value = maps.get(e.getValue1().getYear()).stream()
                        .filter(x->x.getDate().isBefore(e.getValue1().plusDays(1)))
                        .mapToDouble(x->{
                            System.out.println("----找到一个"+x.toString());
                            return x.getDeltaDoubleValue();
                        }).sum();

                proRateHistory.setDoubleValue(value);
            }
            if(doubleClass.equals(Long.class.getName())){
                Long value = maps.get(e.getValue1().getYear()).stream()
                        .filter(x->x.getDate().isBefore(e.getValue1().plusDays(1)))
                        .mapToLong(x->{
                            System.out.println("----找到一个"+x.toString());
                            return x.getDeltaLongValue();
                        }).sum();

                proRateHistory.setLongValue(value);
            }
            //proRateHistory.setDeltaDoubleValue(e.getValue1());
            System.out.println("------------存储了一个 数据啊啊啊");
            proRateHistoryRepository.save(proRateHistory);

        });


    }





    @Transactional
    protected void transfer本期值ToPro(E_指标_RATE_SY e_指标_rate_sy, String doubleClass) {


        List<RateHistory> rateHistories1 = rateHistoryRepository.findByIndexNo(e_指标_rate_sy.get编码())
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDate())).entrySet().stream().map(e -> {
                    System.out.println("pppppp"+e);
                    Long count = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).count();
                    if(count>0){
                        return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Realtime_State.get编码())).findFirst().get();
                    }else{
                        Long count_ = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).count();
                        if(count_ > 0) {
                            return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.Reduction_流水还原.get编码())).findFirst().get();
                        }else{
                            Long count_2 = e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).count();
                            if (count_2>0){
                                return e.getValue().stream().filter(x -> x.getType().equals(E_HISTORY_数据来源.fill.get编码())).findFirst().get();

                            }else{
                                return null;
                            }
                        }

                    }


                }).filter(e->e!= null).sorted(Comparator.comparingLong(e -> e.getDate().toEpochDay())).collect(Collectors.toList());//.collect(Collectors.toList());




        Map<LocalDate,RateHistory> maps = rateHistories1.stream().collect(Collectors.toMap(e->e.getDate(),e->e));
        RateHistory rateHistory = rateHistories1.stream().sorted(Comparator.comparingLong(e -> e.getDate().toEpochDay())).findFirst().get();
        RateHistory rateHistorySecond =rateHistories1.stream().sorted(Comparator.comparingLong(e -> -e.getDate().toEpochDay())).findFirst().get();
        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(rateHistory.getDate(),rateHistorySecond.getDate(),统计周期编码.H__01_每日);

        triplets.forEach(e -> {
            ProRateHistory proRateHistory = proRateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(), e.getValue1());
            if (proRateHistory == null) {
                proRateHistory = new ProRateHistory(e_指标_rate_sy,e.getValue1());
            }

            if(doubleClass.equals(Double.class.getName())){
                RateHistory value = maps.get(e.getValue1());
                if(value!= null){
                    System.out.println("----------------- 找到了"+value.getDeltaDoubleValue());

                    proRateHistory.setDeltaDoubleValue(value.getDeltaDoubleValue());
                }else{
                    System.out.println("----------------- 找不到");
                    proRateHistory.setDeltaDoubleValue(0D);
                }
            }


            if(doubleClass.equals(Long.class.getName())){
                RateHistory value = maps.get(e.getValue1());
                if(value!= null){
                    proRateHistory.setDeltaLongValue(value.getDeltaLongValue());
                }else{
                    proRateHistory.setDeltaLongValue(0L);
                }
            }
            //proRateHistory.setDeltaDoubleValue(e.getValue1());
            System.out.println("------------存储了一个 数据啊啊啊");
            proRateHistoryRepository.save(proRateHistory);

        });

    }

}
