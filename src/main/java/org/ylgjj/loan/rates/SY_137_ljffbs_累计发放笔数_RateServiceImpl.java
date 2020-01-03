package org.ylgjj.loan.rates;



import org.javatuples.Pair;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.enumT.E_LN003_合同信息_放款标志;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.time.StopWatch;
/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_137_ljffbs_累计发放笔数_RateServiceImpl extends RateServiceBaseImpl{
    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_137_ljffbs_累计发放笔数;




    public void trans() {
        process(LocalDate.parse("2015-10-01",df),LocalDate.now());
      //  deleteReduction_流水还原_Pro(e_指标_rate_sy);
        transfer本年累计ToPro(e_指标_rate_sy, Long.class.getName());

    }

    public void process(LocalDate beginDate,LocalDate endDate) {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        StopWatch timer = new StopWatch();
        timer.start();
        if(true|| rateAnalysisTable.getAanalysedEndDate()== null){

            deleteAll(e_指标_rate_sy);
            deleteReduction_流水还原(e_指标_rate_sy);
            deleteReduction_流水还原_Pro(e_指标_rate_sy);
            RateAnalysisStream rateAnalysisStream =  history(beginDate,endDate);
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisTable.setAanalysedBeginDate(rateAnalysisStream.getBeginDate());
            rateAnalysisTable.setAanalysedEndDate(rateAnalysisStream.getEndDate());
            updateRateTable(rateAnalysisTable,rateAnalysisStream);
        }else{
            //     if(rateAnalysisTable.getAanalysedEndDate().is)
            RateAnalysisStream rateAnalysisStream = history(rateAnalysisTable.getAanalysedEndDate(),LocalDate.now());
            rateAnalysisStream.setDuration(timer.getTime());
            rateAnalysisTable.setAanalysedBeginDate(rateAnalysisStream.getBeginDate());
            rateAnalysisTable.setAanalysedEndDate(rateAnalysisStream.getEndDate());
            updateRateTable(rateAnalysisTable,rateAnalysisStream);
        }


    }

    public RateAnalysisStream history( LocalDate beginDate, LocalDate endDate) {


        StopWatch timer = new StopWatch();
        timer.start();


        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByLoandate放款日期BetweenOrderByLoandate放款日期Desc(beginDate.minusDays(1),endDate.plusDays(1));
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Pair<LocalDate,Long>> sourceList =ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getLoandate放款日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    System.out.println("stream---------"+e.getKey());
                    return Pair.with(e.getKey(),e.getValue()
                            .stream()
                            .filter(x->x.getLoanflag().equals(E_LN003_合同信息_放款标志.E_1_是.getText()))
                            .count());
        }).collect(Collectors.toList());


        saveDeltaLong(sourceList,e_指标_rate_sy);



        return new RateAnalysisStream(beginDate,endDate);

    }



    @Transactional
    public void save(List<Pair<LocalDate,Long>> triplets) {
        triplets.stream().forEach(e->{
            RateHistory rateHistory = rateHistoryRepository.findByIndexNoAndDate(e_指标_rate_sy.get编码(),e.getValue0());
            if(rateHistory== null) {
                rateHistory = new RateHistory(e.getValue0(), e_指标_rate_sy);
                rateHistory.setLongValue(e.getValue1());
                rateHistoryRepository.save(rateHistory);
            }
            System.out.println("-----------"+ e.toString());
        });

    }




    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
Optional<ProRateHistory> rateHistory_环比 = rateHistories_环比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .findFirst();

        Optional<ProRateHistory> rateHistory_同比 = rateHistories_同比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .findFirst();

        Optional<ProRateHistory> rateHistory = rateHistories
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .findFirst();


        if(rateHistory.isPresent())
            h1.setLjffbs_累计发放笔数_NUMBER_18_0(rateHistory.get().getLongValue());
        if(rateHistory.isPresent() && rateHistory_环比.isPresent()){
            BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory.get().getLongValue().intValue()-rateHistory_环比.get().getLongValue().intValue()+0D)/rateHistory_环比.get().getLongValue().intValue());
            h1.setLjhbffbs_累计环比发放笔数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        }



        if(rateHistory.isPresent() && rateHistory_同比.isPresent()){
            BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory.get().getLongValue().intValue()-rateHistory_同比.get().getLongValue().intValue()+0D)/rateHistory_同比.get().getLongValue().intValue());

            h1.setLjsnffbs_累计同比发放笔数_NUMBER_18_0(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        }




    }


}
