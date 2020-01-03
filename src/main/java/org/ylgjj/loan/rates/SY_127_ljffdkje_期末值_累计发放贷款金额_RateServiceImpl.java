package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.enumT.E_LN003_合同信息_放款标志;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_127_ljffdkje_期末值_累计发放贷款金额_RateServiceImpl extends RateServiceBaseImpl{

    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_127_ljffdkje_累计发放贷款金额;

   //  //

    public void trans() {
        process(LocalDate.parse("2015-10-01",df),LocalDate.now());

        transfer累计ToPro(LocalDate.parse("2015-10-01", df), e_指标_rate_sy,Double.class.getName());

    }



    public void process(LocalDate beginDate,LocalDate endDate) {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        StopWatch timer = new StopWatch();
        timer.start();
        if(rateAnalysisTable.getAanalysedEndDate()== null){

            deleteReduction_流水还原(e_指标_rate_sy);

            RateAnalysisStream rateAnalysisStream = history(beginDate,endDate);
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


    public RateAnalysisStream history(LocalDate beginDate,LocalDate endDate) {


        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByLoandate放款日期BetweenOrderByLoandate放款日期Desc(beginDate.minusDays(1),endDate.plusDays(1));
        System.out.println("-----------------------------"+ ln003_合同信息s.size());

        Map<String,LN003_合同信息> ln003_合同信息Map =ln003_合同信息s.stream().collect(Collectors.toMap(e->e.getLoancontrcode合同代码().trim(), e->e));



        List<Pair<LocalDate,Double>> triplets = ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getLoandate放款日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{

                    double diff = e.getValue().stream()
                            .filter(x->x.getLoanflag().equals(E_LN003_合同信息_放款标志.E_1_是.getText()))

                            /*                    .filter(x->!x.getLoancontrstate_合同状态().equals(E_LN004_合同状态信息_合同状态.E_99_合同废弃.getText()))
                            .filter(x->!x.getLoancontrstate_合同状态().equals(E_LN004_合同状态信息_合同状态.E_00_申请.getText()))
*/
                            .mapToDouble(x->{


                                    return x.getLoanamt_贷款金额().doubleValue();


                            })
                            .sum();

                    return Pair.with(e.getKey(),diff);
                }).collect(Collectors.toList());


        saveDeltaDouble(triplets,e_指标_rate_sy);

        return new RateAnalysisStream(beginDate,endDate);

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

/*        if(rateHistories.size()==0) return;Long rateHistory_环比 = rateHistories_环比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToLong(e->e.getLongValue()).sum();
        Long rateHistory_同比 = rateHistories_同比
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToLong(e->e.getLongValue()).sum();;
        Long rateHistory = rateHistories
                .stream()
                .filter(e->e.getIndexNo().equals(e_指标_rate_sy.get编码()))
                .mapToLong(e->e.getLongValue()).sum();*/


        h1.setLjffdkje_累计发放贷款金额_NUMBER_18_2(rateHistory);

        BigDecimal bigDecimal = BigDecimal.valueOf((rateHistory-rateHistory_环比+0D)/(rateHistory_环比!=0? rateHistory_环比:-1));

        h1.setLjhbffdkje_累计环比发放贷款金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf((rateHistory.intValue()-rateHistory_同比.intValue()+0D)/(rateHistory_同比!=0? rateHistory_同比:-1));

        h1.setLjsnffdkje_累计同比发放贷款金额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }


}
