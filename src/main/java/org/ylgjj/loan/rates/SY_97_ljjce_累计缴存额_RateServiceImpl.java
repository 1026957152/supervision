package org.ylgjj.loan.rates;


import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.DP021_单位缴存登记簿;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class SY_97_ljjce_累计缴存额_RateServiceImpl extends RateServiceBaseImpl{

    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_97_ljjce_累计缴存额;



  //  //
    public void groupProcess(){
        process(LocalDate.parse("2015-10-01",df),LocalDate.now());
        transfer本期值ToPro(e_指标_rate_sy,Double.class.getName());
    }

    public void process(LocalDate localDate,LocalDate endDate) {
        RateAnalysisTable rateAnalysisTable = rateAnalysisTableRepository.findByIndexNo(e_指标_rate_sy.get编码());

        if(rateAnalysisTable == null){
            return;
        }
        StopWatch timer = new StopWatch();
        timer.start();
        if(rateAnalysisTable.getAanalysedEndDate()== null){

            rateHistoryRepository.deleteByIndexNo(e_指标_rate_sy.get编码());

            RateAnalysisStream rateAnalysisStream = history(localDate,endDate);
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





        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<DP021_单位缴存登记簿> ln003_合同信息s = dp021_单位缴存登记薄Repository.findByInaccdate不可为空入账日期BetweenOrderByInaccdate不可为空入账日期Desc(beginDate,endDate);
        System.out.println("-----------------------------"+ ln003_合同信息s.size());




        List<Pair<LocalDate,Double>> triplets = ln003_合同信息s
                .stream()
                .collect(Collectors.groupingBy(e->e.getInaccdate不可为空入账日期()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{

                    double diff = e.getValue().stream()
                            //       .filter(x->x.getDcflag不可为空_借贷标志().equals("1"))
                            .mapToDouble(x->{

                                if(x.getInaccstate_入账状态().equals("1")){
                                    return x.getUprepayamt_预缴户转出金额().doubleValue();
                                }

                                return 0;

                            })
                            .sum();

                    return Pair.with(e.getKey(),diff);
                }).collect(Collectors.toList());



        saveDeltaDouble(triplets,e_指标_rate_sy);

        return new RateAnalysisStream(beginDate,endDate);

    }






    @Transactional
    public void save(List<Triplet<LocalDate,Integer,Double>> triplets) {
        triplets.stream().forEach(e->{

            RateHistory rateHistory = new RateHistory();
            rateHistory.setIndexNo(e_指标_rate_sy.get编码());
            rateHistory.setDoubleValue(e.getValue2());
            rateHistory.setDate(e.getValue0());
            rateHistoryRepository.save(rateHistory);

            System.out.println("-----------"+ e.toString());
        });

    }



    public void query(H1_2监管主要指标查询_公积金中心主要运行情况查询 h1, List<ProRateHistory> rateHistories, List<ProRateHistory> rateHistories_环比, List<ProRateHistory> rateHistories_同比) {
if(rateHistories.size()==0) return;



        Triplet<Double,Double,Double> triplet = queryDouble本期值(e_指标_rate_sy,rateHistories,rateHistories_环比,rateHistories_同比);

        Double rateHistory_环比 =triplet.getValue1();
        Double rateHistory_同比 = triplet.getValue2();
        Double rateHistory = triplet.getValue0();


        h1.setLjjce_累计缴存额_NUMBER_18_2(rateHistory);

        BigDecimal bigDecimal = BigDecimal.valueOf(rateHistory_环比);

        h1.setLjhbjce_环比累计缴存额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigDecimal = BigDecimal.valueOf(rateHistory_同比);

        h1.setLjsnjce_同比累计缴存额_NUMBER_18_2(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

    }
}
