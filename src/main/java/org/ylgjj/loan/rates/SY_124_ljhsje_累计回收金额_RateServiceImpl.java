package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN101_贷款明细账;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.统计周期编码;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.ylgjj.loan.history_stream.HistoryServiceImpl.run统计周期编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_124_ljhsje_累计回收金额_RateServiceImpl extends RateServiceBaseImpl {


    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_124_ljhsje_累计回收金额;


  //  //
    public void trans() {
        planProcess(LocalDate.parse("2015-10-01",df),LocalDate.now(),统计周期编码.H__03_每月,e_指标_rate_sy);

        transfer累计ToPro(LocalDate.parse("2015-10-01", df), e_指标_rate_sy,Double.class.getName());
    }






    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
if(rateHistories.size()==0) return;Double rateHistory_环比 = rateHistories_环比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToDouble(e->e.getDoubleValue()).sum();

        Double rateHistory_同比 = rateHistories_同比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToDouble(e->e.getDoubleValue()).sum();;
        Double rateHistory = rateHistories
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToDouble(e->e.getDoubleValue()).sum();

        h1.setLjhsje_累计回收金额_NUMBER_18_2(rateHistory.intValue());
        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/(rateHistory_环比!=0? rateHistory_环比:-1));

        h1.setLjhbhsje_累计环比回收金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/(rateHistory_同比!=0? rateHistory_同比:-1));

        h1.setLjsnhsje_累计同比回收金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }














    public void planProcess(LocalDate beginDate, LocalDate endDate, 统计周期编码 period, E_指标_RATE_SY e_指标_rate_sy) {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        //  RateAnalysisStream rateAnalysisStream = history(LocalDate.now().minusDays(20000),LocalDate.now());
        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDate,endDate, period);

        for(Triplet<Long,LocalDate,LocalDate> triplet:triplets){

            StopWatch timer = new StopWatch();
            timer.start();
            RateAnalysisStream rateAnalysisStream = history(triplet.getValue1(),triplet.getValue2(),false);
            if(rateAnalysisStream!= null){
                rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());
                rateAnalysisStream.setDuration(timer.getTime());
                //rateAnalysisTable.setAanalysedBeginDate(rateAnalysisStream.getBeginDate());
                rateAnalysisTable.setAanalysedEndDate(rateAnalysisStream.getEndDate());
                updateRateTable(rateAnalysisTable,rateAnalysisStream);
            }
        }

    }


    public RateAnalysisStream history(LocalDate beginDate,LocalDate endDate,Boolean acc) {

        List<LN101_贷款明细账> ln003_合同信息s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(beginDate.minusDays(1),endDate.plusDays(1));
        System.out.println("-----------------------------"+ ln003_合同信息s.size());

        List<Pair<LocalDate,Double>> triplets = ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getTransdate不可为空交易日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{

                    double diff = e.getValue().stream()
                            //       .filter(x->x.getDcflag不可为空_借贷标志().equals("1"))
                            .mapToDouble(x->{

                                if(x.getDcflag不可为空_借贷标志().equals("2")){
                                    return x.getTransamt不可为空_交易金额().doubleValue();
                                }

                                return 0;

                            })
                            .sum();

                    return Pair.with(e.getKey(),diff);
                }).collect(Collectors.toList());


        saveDeltaDouble(triplets,e_指标_rate_sy);

        if(triplets.isEmpty())
            return null;
        return new RateAnalysisStream(beginDate,endDate);

    }



}
