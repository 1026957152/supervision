package org.ylgjj.loan.rate;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.住建部编码_单位经济类型;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum.S_5_SEQ_实存单位数_AND_0301000401;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("HX_RateHistoryerviceImpl")
public class HX_RateHistoryerviceImpl {


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;


    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Output commom(String dimension1, String dimension2, String dimension3, 统计周期编码 period, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_40_SEQ_外部转入人数_AND_0301004101.name();





        //dW025_公积金提取审核登记表_Repository.findAll();
/*        统计周期编码.H__03_每月;

        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        LocalDate ldt_ksrq = LocalDate.parse(ksrq,df);
        LocalDate ldt_jsrq = LocalDate.parse(jsrq,df);




        System.out.println("------------------------- index no index "+ valueOf1.get指标编码()+ldt_ksrq+ "__"+ldt_jsrq);

        List<LoanHistory> histories = loanHistoryRepository.findByIndexNoAndDateBetween(valueOf1.get指标编码(),ldt_ksrq,ldt_jsrq);

        System.out.println("------------------------- index no index "+ histories);

        Map<String,List<LoanHistory>> a = histories.stream().collect(Collectors.groupingBy(e->e.getIndex机构编码()));

/*            Streams.mapWithIndex(studentList.stream(),(t, index)->{
                System.out.println(t.getName());
                System.out.println(index);
                return t.getName();
            }).count();*/

/*        统计周期编码.H__03_每月;

        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
         SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });

        Arrays.stream(E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum.values()).forEach(e->{
        });


        List<Map> mmmm = new ArrayList<>();
        a.entrySet().stream().map(e->{


            return e.getValue().stream().collect(Collectors.groupingBy(g->g.getIndex经济类型())).entrySet().stream().map(h->{


                Map maps = new LinkedHashMap();
                maps.put("target",name);
                maps.put("dimension1",e.getKey());
                maps.put("dimension2",h.getKey());

/*                for(int i= 0 ; i< h.getValue().size(); i++){
                    maps.put("value"+i,h.getValue().get(i).getValue贷款笔数()+"="+h.getValue().get(i).getDate());

                }*/
                List<Triplet<Integer,LocalDate,LocalDate>> rangDates = null;
                if(period.equals(统计周期编码.H__03_每月)) {
                    long count = ldt_ksrq.until(ldt_jsrq, ChronoUnit.MONTHS);
                    rangDates =
                            IntStream.range(0, Long.valueOf(count).intValue()+1)
                                    .mapToObj(i -> {
                                        System.out.println("------------rangDates--i-----i----i--"+i);
                                        LocalDate now = ldt_ksrq.plusMonths(i);
                                        LocalDate monthBegin = now.withDayOfMonth(1);
                                        LocalDate monthEnd = now.plusMonths(1).withDayOfMonth(1).minusDays(1);
                                        return Triplet.with(i,monthBegin,monthEnd);
                                    } )
                                    .collect(Collectors.toList());//2015/12/01　〜 2015/12/31

                }


                System.out.println("------------rangDates-------------"+rangDates.toString());
                List<Triplet<Integer,LocalDate, LocalDate>> finalRangDates = rangDates;
                Map<Triplet<Integer,LocalDate, LocalDate>,List<LoanHistory>> historyMap =  h.getValue().stream().collect(Collectors.groupingBy(j->{

                    for(Triplet<Integer,LocalDate, LocalDate> localDatePair :finalRangDates){
                        if((j.getDate().isAfter(localDatePair.getValue1()) && j.getDate().isBefore(localDatePair.getValue2()) )
                                || j.getDate().isEqual(localDatePair.getValue1()) || j.getDate().isEqual(localDatePair.getValue2()) )
                            return localDatePair;
                    }
                    return null;

                }));

                historyMap.entrySet().forEach(mappp->{

                    maps.put("value"+mappp.getKey().getValue0(),mappp.getValue().stream().map(ll->ll.getId()+"-"+ll.getDate()).collect(Collectors.toList()));
                });


                return maps;

            }).collect(Collectors.toList());





        }).collect(Collectors.toList()).forEach(e->{
            mmmm.addAll(e);
        });

        Output output = new Output();
        output.setData(mmmm);
        output.setSuccess(true);
        return output;
    }



}
