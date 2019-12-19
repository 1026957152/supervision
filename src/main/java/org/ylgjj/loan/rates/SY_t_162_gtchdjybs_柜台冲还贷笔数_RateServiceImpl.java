package org.ylgjj.loan.rates;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN003_合同信息;
import org.ylgjj.loan.domain_zongfu.Mi107_业务日志;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.outputenum.E_业务类型_综服_HX;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository.LN004_合同状态信息Repository;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;
import org.ylgjj.loan.repository_zhongfu.Mi107_业务日志_Repository;

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
public class SY_t_162_gtchdjybs_柜台冲还贷笔数_RateServiceImpl extends RateServiceBaseImpl {

    E_指标_RATE_SY e_指标_rate_sy = E_指标_RATE_SY.SY_162_gtchdjybs_柜台冲还贷笔数;
    @Autowired
    private Mi107_业务日志_Repository mi107_业务日志_repository;
    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;

    @Autowired
    private RateHistoryRepository rateHistoryRepository;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");



    public Long 冲还贷(LocalDate localDate) {
        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5368_偿还公积金贷款提取

        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).count();

    }

    public void process() {




        //List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByOrderByLoandate放款日期Desc();
        List<LN003_合同信息> ln003_合同信息s = ln003_合同信息_repository.findByLoandate放款日期BetweenOrderByLoandate放款日期Desc(LocalDate.now().minusDays(20000),LocalDate.now());
        System.out.println("-----------------------------"+ ln003_合同信息s.size());


        List<Triplet<LocalDate,Integer,Long>> sourceList =ln003_合同信息s.stream().collect(Collectors.groupingBy(e->e.getLoandate放款日期())).entrySet()
                .stream()
                .sorted(Comparator.comparingLong(e->e.getKey().toEpochDay()))
                .map(e->{
                    System.out.println("stream---------"+e.getKey());
                    return Triplet.with(e.getKey(),e.getValue().size(),0L);
        }).collect(Collectors.toList());

        Long num = 0L;

        List<Triplet<LocalDate,Integer,Long>> triplets = new ArrayList<>();
        for(Triplet<LocalDate,Integer,Long> triplet: sourceList){

            num += triplet.getValue1();
            triplet.setAt2(num);
            triplets.add(Triplet.with(triplet.getValue0(),triplet.getValue1(),num));
        }

        triplets.stream().forEach(e->{
            System.out.println("-----------"+ e.toString());
        });


        RateHistory rateHistory = new RateHistory();
        rateHistory.setIndexNo(E_指标_RATE_SY.SY_177_dkpjspts_贷款平均审批天数.get编码());
        rateHistoryRepository.save(rateHistory);







    }




}
