package org.ylgjj.loan.service;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain_flow.StreamHistory;
import org.ylgjj.loan.history_stream.HistoryServiceImpl;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.pojo.*;
import org.ylgjj.loan.repository_flow.StreamHistoryRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class H2_6_业务指标_网格查询_ServiceImpl extends HistoryServiceImpl {

    @Autowired
    private StreamHistoryRepository StreamHistoryRepository;

    @Autowired
    B归集ServiceImpl b归集Service;

    @Autowired
    B提取ServiceImpl b提取Service;

    @Autowired
    B开户ServiceImpl b开户Service;


    public Output H_2_6_业务指标_网格查询(QueryH_2_6_业务指标_网格查询 query) {




        query.setJsrq("2019-11-28");
        query.setKsrq("2019-10-01");
        System.out.println("----------------- "+ query.toString());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df);


        StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.fromString指标编码(query.getTarget());


        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(ldt_ksrq,ldt_jsrq,统计周期编码.fromString(statisticalIndexCodeEnum.get统计周期()));
     
        LocalDate localDate_begin = triplets.stream().sorted(Comparator.comparingLong(e->-e.getValue2().toEpochDay())).map(e->e.getValue2()).findFirst().get();
        LocalDate localDate_end = triplets.stream().sorted(Comparator.comparingLong(e->e.getValue1().toEpochDay())).map(e->e.getValue2()).findFirst().get();
        
        List<StreamHistory> targetHistories = StreamHistoryRepository.findByTargetNoAndDateBetweenOrderByDateDesc(statisticalIndexCodeEnum.get指标编码(),localDate_begin,localDate_end);

        targetHistories
                .stream()
                .filter(e->{

                    if(query.getDimension1()!= null){
                        Stream< String > stream = Arrays.stream( query.getDimension1().split( "," ) );
                        return stream.anyMatch(x -> x.equals(e.getDimension1()));
                    }
                    if(query.getDimension1()!= null && query.getDimension2()!= null){
                        Stream< String > stream_1 = Arrays.stream( query.getDimension1().split( "," ) );
                        Stream< String > stream_2 = Arrays.stream( query.getDimension2().split( "," ) );

                        Boolean bool_1 = stream_1.anyMatch(x -> x.equals(e.getDimension1()));
                        Boolean bool_2 = stream_2.anyMatch(x -> x.equals(e.getDimension2()));
                    }

                    return true;
                }).collect(Collectors.toList());


        
        if(StatisticalIndexCodeEnum.S_6_SEQ_新增单位数_AND_0301000501.get指标编码().equals(query.getTarget())){
            return b归集Service.S_6_SEQ_新增单位数_AND_0301000501("","",null,
                    null,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }
        if(StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201.get指标编码().equals(query.getTarget())){
            return b归集Service.S_2_SEQ_实缴单位数_AND_0301000201("","",null,
                    null,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }
        if(StatisticalIndexCodeEnum.S_37_SEQ_提取人数__提取原因___AND_0301003911.get指标编码().equals(query.getTarget())){
            return b提取Service.S_37_SEQ_提取人数__提取原因___AND_0301003911("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }










        if(StatisticalIndexCodeEnum.S_58_SEQ_外部转入金额_AND_0301007801.get指标编码().equals(query.getTarget())){
            return b提取Service.S_58_SEQ_外部转入金额_AND_0301007801("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }


        if(StatisticalIndexCodeEnum.S_40_SEQ_外部转入人数_AND_0301004101.get指标编码().equals(query.getTarget())){
            return b开户Service.S_40_SEQ_外部转入人数_AND_0301004101("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }
        if(StatisticalIndexCodeEnum.S_41_SEQ_外部转出人数_AND_0301004201.get指标编码().equals(query.getTarget())){
            return b开户Service.S_41_SEQ_外部转出人数_AND_0301004201("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }
        if(StatisticalIndexCodeEnum.S_59_SEQ_外部转出金额__本金___AND_0301007901.get指标编码().equals(query.getTarget())){
            return b提取Service.S_59_SEQ_外部转出金额__本金___AND_0301007901("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }

        if(StatisticalIndexCodeEnum.S_60_SEQ_外部转出金额__利息___AND_0301007902.get指标编码().equals(query.getTarget())){
            return b提取Service.S_60_SEQ_外部转出金额__利息___AND_0301007902("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }



        return null;

    }

    public Output H_2_7_业务指标_表格查询(QueryH_2_7_业务指标_表格查询 query) {
        return null;
    }
}
