package org.ylgjj.loan.rates;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.flow.AnalysisTable;
import org.ylgjj.loan.flow.RateAnalysisTable;
import org.ylgjj.loan.flow.RateHistory;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository.LN004_合同状态信息Repository;
import org.ylgjj.loan.repository_flow.RateAnalysisStreamRepository;
import org.ylgjj.loan.repository_flow.RateAnalysisTableRepository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class RateServiceImpl {


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private RateAnalysisStreamRepository rateAnalysisStreamRepository;
    @Autowired
    private RateAnalysisTableRepository rateAnalysisTableRepository;

    @Autowired
    private SY_137_ljffbs_累计发放笔数_RateServiceImpl sy_137_ljffbs_累计发放笔数_rateService;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");



  //
    @Transactional
    public void S_83_SEQ_住房公积金使用率_AND_0301020501__() {
        List<E_指标_RATE_SY> statisticalIndexCodeEnums = Arrays.stream(E_指标_RATE_SY.values()).collect(Collectors.toList());


        IntStream.range(0,statisticalIndexCodeEnums.size()).forEach(e->{

            E_指标_RATE_SY statisticalIndexCodeEnum=    statisticalIndexCodeEnums.get(e);
            RateAnalysisTable analysisTable = rateAnalysisTableRepository.findByIndexNo(statisticalIndexCodeEnum.get编码());


            if(analysisTable== null){
                analysisTable = new RateAnalysisTable();
                analysisTable.setIndexNo(statisticalIndexCodeEnum.get编码());
                analysisTable.setName(statisticalIndexCodeEnum.get名称());
                analysisTable.setSeq(e);

                rateAnalysisTableRepository.save(analysisTable);
            }


        });


    }




    @Scheduled(fixedRate = 1000*60*118)
    public void process() {

        sy_137_ljffbs_累计发放笔数_rateService.update();



    }




}
