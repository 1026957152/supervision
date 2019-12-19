package org.ylgjj.loan.rates;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain_flow.RateAnalysisStream;
import org.ylgjj.loan.domain_flow.RateAnalysisTable;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository.LN004_合同状态信息Repository;
import org.ylgjj.loan.repository_flow.RateAnalysisTableRepository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.ylgjj.loan.repository_flow.RateAnalysisStreamRepository;
/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class RateServiceBaseImpl {


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;

    @Autowired
    protected RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    protected RateAnalysisStreamRepository rateAnalysisStreamRepository;
    @Autowired
    protected RateAnalysisTableRepository rateAnalysisTableRepository;


    @Transactional
    public void updateRateTable(RateAnalysisTable rateAnalysisTable, RateAnalysisStream rateAnalysisStream) {
        rateAnalysisStream.setRateTableId(rateAnalysisTable.getId());
        rateAnalysisStreamRepository.save(rateAnalysisStream);

        rateAnalysisTable.setUpdateTime(LocalDateTime.now().toLocalDate());
        rateAnalysisTableRepository.save(rateAnalysisTable);

    }



}
