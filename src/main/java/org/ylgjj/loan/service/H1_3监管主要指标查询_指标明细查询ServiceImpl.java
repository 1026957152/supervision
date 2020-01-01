package org.ylgjj.loan.service;


import org.apache.commons.lang3.StringUtils;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.domain_flow.ProRateHistory;
import org.ylgjj.loan.domain_flow.RateHistory;
import org.ylgjj.loan.domain_flow.StreamHistory;
import org.ylgjj.loan.history_stream.S_1_SEQ_暂存款笔数_AND_0301000101_HistoryServiceImpl;
import org.ylgjj.loan.output.H1_2监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.output.H1_4监管主要指标查询_离柜率查询;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.pojo.QueryH_1_3_监管主要指标查询_指标明细查询;
import org.ylgjj.loan.pojo.QueryH_2_6_业务指标_网格查询;
import org.ylgjj.loan.rate.HX_Rate环比同比HistoryerviceImpl;
import org.ylgjj.loan.rates.*;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.RateHistoryRepository;
import org.ylgjj.loan.repository_flow.StreamHistoryRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.ylgjj.loan.history_stream.HistoryServiceImpl.run统计周期编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H1_3监管主要指标查询_指标明细查询ServiceImpl")
public class H1_3监管主要指标查询_指标明细查询ServiceImpl {




    @Autowired
    private StreamHistoryRepository streamHistoryRepository;







    public Output H_1_4_监管主要指标查询_离柜率明细查询(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {

        H1_4监管主要指标查询_离柜率查询 h1_4监管主要指标查询_离柜率查询 = new H1_4监管主要指标查询_离柜率查询();

        Output output = new Output();

        output.setData(Arrays.asList(h1_4监管主要指标查询_离柜率查询));
        return output;
    }



    public Output H_1_3_监管主要指标查询_指标明细查询(QueryH_1_3_监管主要指标查询_指标明细查询 query) {


        //query.setJsrq("2019-11-28");
      //  query.setKsrq("2019-10-01");
        System.out.println("----------------- " + query.toString());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(), df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(), df);


        StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.fromString指标编码(query.getTarget());


        List<Triplet<Long, LocalDate, LocalDate>> triplets = run统计周期编码(ldt_ksrq, ldt_jsrq, 统计周期编码.fromString(statisticalIndexCodeEnum.get统计周期()));

        LocalDate localDate_begin = triplets.stream().sorted(Comparator.comparingLong(e -> e.getValue1().toEpochDay())).map(e -> e.getValue1()).findFirst().get();
        LocalDate localDate_end = triplets.stream().sorted(Comparator.comparingLong(e -> -e.getValue2().toEpochDay())).map(e -> e.getValue2()).findFirst().get();

        List<StreamHistory> targetHistories = streamHistoryRepository.findByTargetNoAndDateBetweenOrderByDateDesc(statisticalIndexCodeEnum.get指标编码(), localDate_begin.minusDays(1), localDate_end.plusDays(1));
        System.out.println("-----------------localDate_begin " + localDate_begin.toString());
        System.out.println("-----------------localDate_end " + localDate_end.toString());
        System.out.println("-----------------targetHistories: " + targetHistories.size());
        triplets.forEach(e->{
            System.out.println("----------------------"+e.toString());
        });
        Output output= new Output();
        output.setSuccess(true);


        output.setData(

                targetHistories
                        .stream()
                        .filter(e -> {

                            if (StringUtils.isNotBlank(query.getDimension1())) {
                                Stream<String> stream = Arrays.stream(query.getDimension1().split(","));
                                return stream.anyMatch(x -> x.equals(e.getDimension1()));
                            }
                            return true;
                        })
                        .filter(e -> {

   /*                 if (query.getDimension1() != null) {
                        Stream<String> stream = Arrays.stream(query.getDimension1().split(","));
                        return stream.anyMatch(x -> x.equals(e.getDimension1()));
                    }
                    if (query.getDimension1() != null && query.getDimension2() != null) {
                        Stream<String> stream_1 = Arrays.stream(query.getDimension1().split(","));
                        Stream<String> stream_2 = Arrays.stream(query.getDimension2().split(","));

                        Boolean bool_1 = stream_1.anyMatch(x -> x.equals(e.getDimension1()));
                        Boolean bool_2 = stream_2.anyMatch(x -> x.equals(e.getDimension2()));
                    }*/

                            return true;
                        })


                        .collect(Collectors.groupingBy(e->e.getDimension1())).entrySet()
                        .stream()

                        .map(e->{


                            if(StringUtils.isBlank(statisticalIndexCodeEnum.get维度三())){
                                return e.getValue()
                                        .stream()
                                        .filter(f -> {

                                            if (StringUtils.isNotBlank(query.getDimension2())) {

                                                Stream<String> stream = Arrays.stream(query.getDimension2().split(","));
                                                return stream.anyMatch(x -> x.equals(f.getDimension2()));
                                            }
                                            return true;
                                        })
                                        .collect(Collectors.groupingBy(x->x.getDimension2())).entrySet()
                                        .stream()
                                        .map(f->{
                                            Map mapResult = new LinkedHashMap();
                                            mapResult.put("dimension1",e.getKey());
                                            mapResult.put("dimension2",f.getKey());
                                            //  mapResult.put("dimension3",p.getKey());
                                            mapResult.put("ksrq",ldt_ksrq);
                                            mapResult.put("jsrq",ldt_jsrq);
                                            mapResult.put("target",statisticalIndexCodeEnum.get指标编码());

                                            Map<LocalDate,StreamHistory> uu = f.getValue().stream().collect(Collectors.toMap(v->v.getDate(),v->v));
                                            IntStream.range(0,triplets.size()).forEach(o->{

                                                StreamHistory streamHistory = uu.get(triplets.get(o).getValue1());
                                                if(streamHistory != null){
                                                    mapResult.put("value"+o,streamHistory.getDeltaLongValue());
                                                }else{
                                                    mapResult.put("value"+o,0);
                                                }

                                            });


                                            return mapResult;


                                        }).collect(Collectors.toList());
                            }else{

                                return e.getValue()
                                        .stream()
                                        .filter(f -> {

                                            if (StringUtils.isNotBlank(query.getDimension2())) {

                                                Stream<String> stream = Arrays.stream(query.getDimension2().split(","));
                                                return stream.anyMatch(x -> x.equals(f.getDimension2()));
                                            }
                                            return true;
                                        })
                                        .collect(Collectors.groupingBy(x->x.getDimension2())).entrySet()
                                        .stream()
                                        .map(f->{


                                            return f.getValue()
                                                    .stream()
                                                    .collect(Collectors.groupingBy(z->z.getDimension3()))
                                                    .entrySet()
                                                    .stream()
                                                    .map(p->{

                                                        Map mapResult = new LinkedHashMap();
                                                        mapResult.put("dimension1",e.getKey());
                                                        mapResult.put("dimension2",f.getKey());
                                                        mapResult.put("dimension3",p.getKey());
                                                        mapResult.put("ksrq",ldt_ksrq);
                                                        mapResult.put("jsrq",ldt_jsrq);
                                                        mapResult.put("target",statisticalIndexCodeEnum.get指标编码());


                                                        IntStream.range(0,p.getValue().size()).forEach(o->{
                                                            mapResult.put("value"+o,p.getValue().get(o));
                                                        });


                                                        return mapResult;
                                                    }).collect(Collectors.toList());


                                        }).flatMap(s -> s.stream()).collect(Collectors.toList());

                            }



                        }).flatMap(s -> s.stream()).collect(Collectors.toList())

        )

        ;

        return output;
    }


}
