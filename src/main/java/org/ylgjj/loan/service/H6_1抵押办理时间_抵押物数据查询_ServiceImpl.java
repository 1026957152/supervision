package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_LN004_合同状态信息_合同状态;
import org.ylgjj.loan.output.H6_1抵押办理时间_抵押物数据查询;
import org.ylgjj.loan.repository.*;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class H6_1抵押办理时间_抵押物数据查询_ServiceImpl {

    @Autowired
    private LN009_抵押物信息_mortgager_goods_info_Repository ln009_抵押物信息_mortgager_goods_info_repository;


    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;

    public static <T> List<List<T>> chopped(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }
    public Map<String, List<LN004_合同状态信息>> dp005_单位分户账Map(List<String> dp) {



        return chopped(dp,1000).stream().map(x->{
            return ln004_合同状态信息Repository.findByLoancontrcodeIn(x)
                    .stream().collect(Collectors.toList());
        }).flatMap(s -> s.stream()).collect(Collectors.groupingBy(r -> r.getLoancontrcode()));

/*
        List<MyObject> list = services.stream()
                .flatMap()
                .collect(Collectors.toList());*/

    }

    public Output H6_1抵押办理时间_抵押物数据查询(String zjbzxbm) {


        List<LN009_抵押物信息mortgager_goods_info> ln009_抵押物信息mortgager_goods_infos = ln009_抵押物信息_mortgager_goods_info_repository.findAll();

        List<String> list = ln009_抵押物信息mortgager_goods_infos.stream().map(e->e.getLoancontrcode_不可为空_合同代码()).collect(Collectors.toList());

        System.out.println("----------------找到抵押物——————————-"+ ln009_抵押物信息mortgager_goods_infos.size());


        Map<String,List<LN004_合同状态信息>> ln = dp005_单位分户账Map(list);

        System.out.println("----------------找到抵押物贷款信息 _______——————————-"+ ln.size());

       // ln009_抵押物信息mortgager_goods_infos.stream().collect()
        H6_1抵押办理时间_抵押物数据查询 h6_1抵押办理时间_抵押物数据查询 = new H6_1抵押办理时间_抵押物数据查询();


        ln.entrySet().stream().collect(Collectors.groupingBy(e->{
            Optional<LN004_合同状态信息> ln004_合同状态信息_02_合同签订 =  e.getValue()
                    .stream().filter(x->x.getLoancontrstate().equals(E_LN004_合同状态信息_合同状态.E_02_合同签订.getText())).findFirst();

            Optional<LN004_合同状态信息> ln004_合同状态信息_06_放款申请 =  e.getValue()
                    .stream().filter(x->x.getLoancontrstate().equals(E_LN004_合同状态信息_合同状态.E_06_放款申请.getText())).findFirst();

            if(ln004_合同状态信息_02_合同签订.isPresent() && ln004_合同状态信息_06_放款申请.isPresent()){
                try {
                    Long duration = Duration
                            .between(ln004_合同状态信息_02_合同签订.get().getTransdate().atStartOfDay(),ln004_合同状态信息_06_放款申请.get().getTransdate().atStartOfDay())
                            .toDays();

                    if(duration < 7){
                        return "Day1_7天以内";
                    }
                    if(duration >7 && duration < 15){
                        return "Day2_7__15天";
                    }
                    if(duration >15 && duration < 30){
                        return "Day3_15__30天";
                    }
                    if(duration >30){
                        return "Day4_30天以上";
                    }
                }catch (Exception exce){
                    System.out.println("--问题-ln004_合同状态信息_02_合同签订"+ ln004_合同状态信息_02_合同签订.get().getTransdate());
                    System.out.println("--问题-ln004_合同状态信息_06_放款申请"+ ln004_合同状态信息_06_放款申请.get().getTransdate());

                    exce.printStackTrace();

                }



            }else{
                System.out.println("--------------- 没找到放款信息");
            }
            return "未知";
        }))
                .entrySet()

                .forEach(e->{
            if(e.getKey().equals("Day1_7天以内")){
                h6_1抵押办理时间_抵押物数据查询.setDay1_7天以内_varchar__20___输出(Integer.valueOf(e.getValue().size()).toString());
            }
            if(e.getKey().equals("Day2_7__15天")){
                h6_1抵押办理时间_抵押物数据查询.setDay2_7__15天_varchar__20___输出(Integer.valueOf(e.getValue().size()).toString());
            }
            if(e.getKey().equals("Day3_15__30天")){
                h6_1抵押办理时间_抵押物数据查询.setDay3_15__30天_varchar__20___输出(Integer.valueOf(e.getValue().size()).toString());
            }
            if(e.getKey().equals("Day4_30天以上")){
                h6_1抵押办理时间_抵押物数据查询.setDay4_30天以上_varchar__20___输出(Integer.valueOf(e.getValue().size()).toString());
            }





        });




        Output output = new Output();
        output.setData(Arrays.asList(h6_1抵押办理时间_抵押物数据查询));
        return output;
    }





}
