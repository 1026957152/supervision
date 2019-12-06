package org.ylgjj.loan.rate;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_DW025_公积金提取审核登记表_提取原因_WithdrawReasonEnum;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.outputenum.E_指标_RATE_SY;
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

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("HX_Rate环比同比HistoryerviceImpl")
public class HX_Rate环比同比HistoryerviceImpl {


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;


    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Map<E_指标_RATE_SY,Object> SY_1_ljjzzdws_建制总单位数(String ksrq, String jsrq) {
        String name = E_指标_RATE_SY.SY_1_ljjzzdws_建制总单位数.name();
      //  StatisticalIndexCodeEnum valueOf1 = StatisticalIndexCodeEnum.S_5_SEQ_实存单位数_AND_0301000401;
        StatisticalIndexCodeEnum valueOf1 = StatisticalIndexCodeEnum.S_13_SEQ_开户总单位数_AND_0301002101;
        LocalDate ldt_ksrq = LocalDate.parse(ksrq, df);
        LocalDate ldt_jsrq = LocalDate.parse(jsrq, df);
        System.out.println("------------------------- index no index " + valueOf1.get指标编码() + ldt_ksrq + "__" + ldt_jsrq);
        LocalDate ldt_ksrq_同比 = ldt_ksrq.minusMonths(12);
        LocalDate ldt_jsrq_同比 = ldt_jsrq.minusMonths(12);
        LocalDate ldt_ksrq_环比 = ldt_ksrq.minusMonths(1);
        LocalDate ldt_jsrq_环比 = ldt_jsrq.minusMonths(1);
        List<LoanHistory> histories = loanHistoryRepository.findByIndexNoAndDateBetween(valueOf1.get指标编码(), ldt_ksrq, ldt_jsrq);

        List<LoanHistory> histories_同比 = loanHistoryRepository.findByIndexNoAndDateBetween(valueOf1.get指标编码(), ldt_ksrq_同比, ldt_jsrq_同比);
        List<LoanHistory> histories_环比 = loanHistoryRepository.findByIndexNoAndDateBetween(valueOf1.get指标编码(), ldt_ksrq_环比, ldt_jsrq_环比);


        double 现在 = histories.stream().mapToInt(e -> e.getIntValue().intValue()).sum();
        double 同比 = histories_同比.stream().mapToInt(e -> e.getIntValue().intValue()).sum() / 现在==0? 1:现在 ;
        double 环比 = histories_环比.stream().mapToInt(e -> e.getIntValue().intValue()).sum() / 现在==0? 1:现在 ;

        Map map = new HashMap();
        map.put(E_指标_RATE_SY.SY_1_ljjzzdws_建制总单位数,histories.size());
        map.put(E_指标_RATE_SY.SY_2_ljhbjzzdws_环比建制总单位数,同比);
        map.put(E_指标_RATE_SY.SY_3_ljsnjzzdws_同比建制总单位数,同比);
/*
        StatisticalIndexCodeEnum.S_5_SEQ_实存单位数_AND_0301000401;
        String name = E_指标_RATE_SY.SY_2_ljhbjzzdws_环比建制总单位数
        String name = E_指标_RATE_SY.SY_3_ljsnjzzdws_同比建制总单位数*/
return map;
    }
    public void SY_4_ljjzxhdws_建制销户单位数(String dimension1, String dimension2, String dimension3, 统计周期编码 period, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq)
    {
        String name = E_指标_RATE_SY.SY_4_ljjzxhdws_建制销户单位数.name();
        String name_ = StatisticalIndexCodeEnum.S_7_SEQ_销户单位数_AND_0301000601.name();

    }


    public void SY_7_ljjzfxhdws_建制非销户单位数(String dimension1, String dimension2, String dimension3, 统计周期编码 period, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq)
    {
        String name = E_指标_RATE_SY.SY_7_ljjzfxhdws_建制非销户单位数.name();
        String name_ = StatisticalIndexCodeEnum.S_15_SEQ_正常总单位数_AND_0301002301.name();
        String name__ = StatisticalIndexCodeEnum.S_16_SEQ_封存总单位数_AND_0301002401.name();

    }




    public Output SY_4_ljjzx建制销户单位数(String dimension1, String dimension2, String dimension3, 统计周期编码 period, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq){

        LocalDate ldt_ksrq = LocalDate.parse(ksrq, df);
        LocalDate ldt_jsrq = LocalDate.parse(jsrq, df);

        List<LoanHistory> histories = loanHistoryRepository.findByIndexNoAndDateBetween(valueOf1.get指标编码(), ldt_ksrq, ldt_jsrq);

      /*
        String name = E_指标_RATE_SY.SY_10_ljjzfcdws_建制封存单位数
        StatisticalIndexCodeEnum.S_16_SEQ_封存总单位数_AND_0301002401




        String name = E_指标_RATE_SY.SY_13_ljjzzcdws_建制正常单位数
        StatisticalIndexCodeEnum.S_15_SEQ_正常总单位数_AND_0301002301




        String name = E_指标_RATE_SY.SY_16_ljjzhjdws_建制缓缴单位数
        StatisticalIndexCodeEnum.S_9_SEQ_缓缴单位数_AND_0301000801





        String name = E_指标_RATE_SY.SY_19_ljjzzrs_建制总人数
        String name = E_指标_RATE_SY.SY_22_ljjzxhrs_建制销户人数
        String name = E_指标_RATE_SY.SY_25_ljjzfxhrs_建制非销户人数
        String name = E_指标_RATE_SY.SY_28_ljjzfcrs_建制封存人数
        String name = E_指标_RATE_SY.SY_31_ljjzzcrs_建制正常人数
        String name = E_指标_RATE_SY.SY_34_ljjzdjrs_建制冻结人数





        String name = E_指标_RATE_SY.SY_37_ljhse_累计回收额
        String name = E_指标_RATE_SY.SY_40_ljhsdkje_历史累计回收额
        String name = E_指标_RATE_SY.SY_43_ljyqdked_逾期贷款额度
        String name = E_指标_RATE_SY.SY_46_ljzldkbs_存量贷款笔数
        String name = E_指标_RATE_SY.SY_48_ljsnzldkbs_同比存量贷款笔数


        String name = E_指标_RATE_SY.SY_50_ljhbthreeyqhs_环比三期以上笔数*/

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
             //   maps.put("target",name);
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
