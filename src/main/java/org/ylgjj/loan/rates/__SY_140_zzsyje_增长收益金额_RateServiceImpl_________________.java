package org.ylgjj.loan.rates;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Fn032_会计凭证历史流水;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.E_科目字典_HX;
import org.ylgjj.loan.repository.Fn032_会计凭证历史流水_Repository;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class __SY_140_zzsyje_增长收益金额_RateServiceImpl_________________ {


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private Fn032_会计凭证历史流水_Repository fn032_会计凭证历史流水_repository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public void process() {


        List<String> strins = Arrays.asList(E_科目字典_HX.E_102_增值收益存款_增值收益存款_102000_1_102000,
                E_科目字典_HX.E_10201_活期存款_增值收益存款__活期存款_102001_2_102000,
                E_科目字典_HX.E_10202_定期存款_增值收益存款__定期存款_102002_2_102000

        ).stream().map(e -> e.get科目号()).collect(Collectors.toList());

        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<Fn032_会计凭证历史流水> ln003_合同信息s = fn032_会计凭证历史流水_repository
                .findBySubcode不可为空科目控制字InAndTransdate不可为空交易日期BetweenOrderByTransdate不可为空交易日期Desc(strins, LocalDate.now().minusDays(20000), LocalDate.now());
        System.out.println("-----------------------------" + ln003_合同信息s.size());


        List<Triplet<LocalDate, Integer, Long>> sourceList = ln003_合同信息s.stream().collect(Collectors.groupingBy(e -> e.getTransdate不可为空交易日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e -> e.getKey().toEpochDay()))
                .map(e -> {
                    System.out.println("stream---------" + e.getKey());
                    return Triplet.with(e.getKey(), e.getValue().size(), 0L);
                }).collect(Collectors.toList());

        Long num = 0L;

        List<Triplet<LocalDate, Integer, Long>> triplets = new ArrayList<>();
        for (Triplet<LocalDate, Integer, Long> triplet : sourceList) {

            num += triplet.getValue1();
            triplet.setAt2(num);
            triplets.add(Triplet.with(triplet.getValue0(), triplet.getValue1(), num));
        }

        triplets.stream().forEach(e -> {
            System.out.println("-----------" + e.toString());
        });


        RateHistory rateHistory = new RateHistory();
        rateHistory.setIndexNo(E_指标_RATE_SY.SY_177_dkpjspts_贷款平均审批天数.get编码());
        rateHistoryRepository.save(rateHistory);


    }


}