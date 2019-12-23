package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.domain_flow.BaseFlowDomain;
import org.ylgjj.loan.domain_flow.Collect;
import org.ylgjj.loan.domain_flow.CollectPlan;
import org.ylgjj.loan.domain_flow.UnitManagementAccount;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.CollectPlanRepository;
import org.ylgjj.loan.repository_flow.CollectRepository;
import org.ylgjj.loan.repository_flow.UnitManagementAccountRepository;
import org.ylgjj.loan.util.DateRange;
import org.ylgjj.loan.util.DateUtilsss;
import org.ylgjj.loan.util.个人Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

import org.javatuples.*;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;


/*
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
*/


/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("B归集ServiceImpl")
public class B归集ServiceImpl  {


    @Autowired
    private CM002_个人基本资料表Repository cm002个人基本资料表Repository;


    @Autowired
    private LN008_借款人类型Repository lN008_借款人类型Repository;

    @Autowired
    private LN014_贷款房屋信息Repository ln014__贷款房屋信息Repository;
    @Autowired
    private LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;




    @Autowired
    private DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;


    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private DW025_公积金提取审核登记表_Repository dW025__公积金提取审核登记表_Repository;

    @Autowired
    private DP007_个人分户账_Repository dp007_individual_sub_account个人分户账Repository;
    @Autowired
    private DP006_个人缴存信息表_Repository dp006__个人缴存信息表_repository;


    @Autowired
    private UnitManagementAccountRepository unitManagementAccountRepository;


    @Autowired
    private LN005_贷款分户信息_Repository lN005_贷款分户信息RepositoryLN005;
    @Autowired
    private DW145_提取结算登记薄_Repository dw145_提取结算登记薄_repository;



    @Autowired
    private CM081_sms_短信密码签订登记簿_Repository cm081_sms_短信密码签订登记簿_repository;

    @Autowired
    private DP004_单位缴存信息表_Repository dp004_unit_payment_info单位缴存信息表Repository;

    @Autowired
    private DP005_单位分户账_Repository dp005__单位分户账_repository;

    @Autowired
    private CM001_单位基本资料表Repository cm001单位基本资料表Repository;
    @Autowired
    private DP008_单位明细账_Repository dp008__单位明细账_repository;
    @Autowired
    private DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;
    @Autowired
    private PB017_公共流水登记簿_Repository public_flowing公共流水登记簿Repository;

    @Autowired
    private CollectPlanRepository collectPlanRepository;

    @Autowired
    private CollectRepository collectRepository;

    void partion周期分割(List<BaseFlowDomain> list, 统计周期编码 统计周期编码){

    }




    //TODO 单位号，管理办机构号，归集人数，归集金额
    public List<Quartet<String,String,Integer,Double>> 当日情况_归集_动作(LocalDate 日期) {

        long count = dp008__单位明细账_repository.count();
/*        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+count);

        List<DP202_单位缴存变更登记簿> dp021_单位缴存登记薄s = dp021_单位缴存登记薄Repository.findByTransdate交易日期Desc(日期);
        Optional<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿 = dp021_单位缴存登记薄s.stream().filter(e->e.getTransdate不可为空交易日期().isBefore(日期.plusDays(1))).findFirst();

        if(dp202_单位缴存变更登记簿.isPresent()){
            return dp202_单位缴存变更登记簿.get().getFinchgnum_不可为空_财政变更人数();
        }*/
        System.out.println("----count-----------------"+ count);
        System.out.println("----日期-----------------"+ 日期.toString());
        List<DP008_单位明细账> dp021_单位缴存登记薄s = dp008__单位明细账_repository.findByTransdate不可为空交易日期(日期);
        List<Quartet<String,String,Integer,Double>> list= new ArrayList<>();


        list.addAll(dp021_单位缴存登记薄s.stream().map(e->{
            return new Quartet<String,String,Integer,Double>(e.getUnitaccnum不可为空单位账号(),"88888",Long.valueOf(e.getPeoplenum_0_不可为空_人数()).intValue(),e.getAmt_0_不可为空_发生额());

        }).collect(Collectors.toList()));
        return list;
    }











    //DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //TODO S_2_SEQ_实缴单位数_AND_0301000201
    public Output S_2_SEQ_实缴单位数_AND_0301000201(String dimension1, String dimension2, String dimension3, 统计周期编码 peried, StatisticalIndexCodeEnum target, String ksrq, String jsrq) {
        StatisticalIndexCodeEnum index = StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201;
     //   HX摘要码信息表.HX__1_S_单位正常汇缴入账_9101;
    //    HX摘要码信息表.HX__86_S_汇缴入账_1219;

     //   DP008_单位明细账_Repository

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(ksrq,df);
        LocalDate ldt_jsrq = LocalDate.parse(jsrq,df);


        System.out.println("----ldt_ksrq-----------------"+ ldt_ksrq.toString());
        System.out.println("----ldt_jsrq-----------------"+ ldt_jsrq.toString());

/*        长度：10，举例：2019-07-01
        长度：10，举例：2019-07-03*/


        LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq,year_before);



        List<Map<String, Map<String,List<Quartet<String,String,Integer,Double>>>>> list = new ArrayList();

        for(int i=0; i<=abs(num); i++){
            LocalDate n = ldt_ksrq.minusDays(i);

            List<Quartet<String,String,Integer,Double>> bbb = 当日情况_归集_动作(n);

           Map<String, List<Quartet<String,String,Integer,Double>>> maps___ =bbb.stream().collect(  // 机构分类
                    Collectors.groupingBy(e->e.getValue0()));



            Map<String, Map<String,List<Quartet<String,String,Integer,Double>>>> sssss =
                    maps___.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),a->{
                        return a.getValue().stream().collect(Collectors.groupingBy(cc->cc.getValue1()));
            }));

            list.add(sssss);



        }


      //  System.out.println("----list-----------------"+ list.toString());
        Map mapResult = new LinkedHashMap();
        mapResult.put("dimension1",dimension1);
        mapResult.put("ksrq",ldt_ksrq);
        mapResult.put("jsrq",ldt_jsrq);
        mapResult.put("target",target.get指标编码());
        Integer inde = 1;
        for(Map<String, Map<String,List<Quartet<String,String,Integer,Double>>>> EE :list){


            if(!EE.isEmpty()){
                System.out.println("----keySet-----------------"+ EE.keySet());
                String first = EE.keySet().stream().findFirst().get();
                if(!EE.get(first).isEmpty()){
                    String first1 = EE.get(first).keySet().stream().findFirst().get();

                    System.out.println("----keySet-----------------"+  EE.get(first).keySet());
                    long cccc = EE.get(first).get(first1).stream().map(e->{
                        return e.getValue1();
                    }).count();

                    mapResult.put("value"+inde++,cccc);
                }else{
                    mapResult.put("value1"+inde++,0);
                }
            }



        }


        Output output = new Output();
        output.setData(Arrays.asList(mapResult));
        output.setSuccess(true);




/*        SY_项目单位.H_02_个_人数
        统计周期编码.H__03_每月;
        指标分类编码.H_01_单位数分析;*/
        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });


        return output;

    }

    //TODO S_3_SEQ_实缴单位数__按年___AND_0301000202
    public Output S_3_SEQ_实缴单位数__按年___AND_0301000202(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_3_SEQ_实缴单位数__按年___AND_0301000202.name();
/*        HX摘要码信息表.HX__1_S_单位正常汇缴入账_9101;
        HX摘要码信息表.HX__86_S_汇缴入账_1219;


        SY_项目单位.H_02_个_人数
        统计周期编码.H__06_每年;
        指标分类编码.H_01_单位数分析;*/
        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });







        LocalDateTime ldt_ksrq = LocalDateTime.parse(ksrq,df);
        LocalDateTime ldt_jsrq = LocalDateTime.parse(ksrq,df);
        List<CollectPlan> collectPlans = collectPlanRepository.findByCreateDateBetween(ldt_ksrq,ldt_jsrq);


        Map<String, List<CollectPlan>> maps___ = collectPlans.stream().collect(  // 机构分类
                Collectors.groupingBy(CollectPlan::getAgencyId)
        );

        List maps_ = maps___.entrySet().stream().map(e->{

            Map map_result_element = new HashMap();

            maps___.entrySet().stream().forEach(e2-> {
                map_result_element.put("dimension1", e2.getKey());
   /*                     Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
                        });*/
                Map<String, List<CollectPlan>> maps3 = e2.getValue().stream().collect( // 二维度分类
                        Collectors.groupingBy(CollectPlan::getAgencyId单位经济类型)
                );



                maps3.entrySet().stream().forEach(e3 -> {
                    map_result_element.put("dimension2", e3.getKey());
                    //partion周期分割(e3.getValue(),统计周期编码.H__03_每月);
                    Map<DateRange, List<CollectPlan>> maps4 = e3.getValue().stream().collect( // 二维度分类
                            Collectors.groupingBy(CollectPlan::getDateRange)
                    );

                    Integer indexCount = 0;
                    maps4.entrySet().stream().forEach(e5 -> {
                        String valueIndex = "value"+indexCount;
                        map_result_element.put(valueIndex, e5.getValue().stream().count());

                    });
                });

            });
            return map_result_element;
        }).collect(Collectors.toList());
        Output output = new Output();
        output.setData(maps_);
        return output;
    }






    // TODO S_4_SEQ_未缴单位数_AND_0301000301
    public Output S_4_SEQ_未缴单位数_AND_0301000301(String dimension1, String dimension2, String dimension3, 统计周期编码 H__03_每月, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_4_SEQ_未缴单位数_AND_0301000301.name();


/*        SY_项目单位.H_02_个_人数
        统计周期编码.H__03_每月;
        指标分类编码.H_01_单位数分析;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });







        LocalDateTime ldt_ksrq = LocalDateTime.parse(ksrq,df);
        LocalDateTime ldt_jsrq = LocalDateTime.parse(ksrq,df);
        List<CollectPlan> collectPlans = collectPlanRepository.findByCreateDateBetween(ldt_ksrq,ldt_jsrq);


        Map<String, List<CollectPlan>> maps___ = collectPlans.stream().collect(  // 机构分类
                Collectors.groupingBy(CollectPlan::getAgencyId)
        );

        List maps_ = maps___.entrySet().stream().map(e->{

            Map map_result_element = new HashMap();

            maps___.entrySet().stream().forEach(e2-> {
                map_result_element.put("dimension1", e2.getKey());

   /*                     Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
                        });*/
                Map<String, List<CollectPlan>> maps3 = e2.getValue().stream().collect( // 二维度分类
                        Collectors.groupingBy(CollectPlan::getAgencyId单位经济类型)
                );



                maps3.entrySet().stream().forEach(e3 -> {
                    map_result_element.put("dimension2", e3.getKey());


                      //  partion周期分割(e3.getValue(),H__03_每月 == null?统计周期编码.H__03_每月:H__03_每月);


                    Map<DateRange, List<CollectPlan>> maps4 = e3.getValue().stream().collect( // 二维度分类
                            Collectors.groupingBy(CollectPlan::getDateRange)
                    );

                    Integer indexCount = 0;
                    maps4.entrySet().stream().forEach(e5 -> {
                        String valueIndex = "value"+indexCount;
                        map_result_element.put(valueIndex, e5.getValue().stream().count());

                    });
                });

            });
            return map_result_element;
        }).collect(Collectors.toList());
        Output output = new Output();
        output.setData(maps_);
        return output;
    }






    //TODO S_5_SEQ_实存单位数_AND_0301000401
    public Output S_5_SEQ_实存单位数_AND_0301000401(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_5_SEQ_实存单位数_AND_0301000401.name();


/*        SY_项目单位.H_02_个_人数
        统计周期编码.H__01_每日;
        指标分类编码.H_01_单位数分析;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });









        LocalDateTime ldt_ksrq = LocalDateTime.parse(ksrq,df);
        LocalDateTime ldt_jsrq = LocalDateTime.parse(ksrq,df);
        List<Collect> collectPlans = collectRepository.findByCreateDateBetween(ldt_ksrq,ldt_jsrq);


        Map<String, List<Collect>> maps___ = collectPlans.stream().collect(  // 机构分类
                Collectors.groupingBy(Collect::getAgencyId)
        );

        List maps_ = maps___.entrySet().stream().map(e->{

            Map map_result_element = new HashMap();

            maps___.entrySet().stream().forEach(e2-> {
                map_result_element.put("dimension1", e2.getKey());

   /*                     Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
                        });*/
                Map<String, List<Collect>> maps3 = e2.getValue().stream().collect( // 二维度分类
                        Collectors.groupingBy(Collect::getAgencyId单位经济类型)
                );



                maps3.entrySet().stream().forEach(e3 -> {
                    map_result_element.put("dimension2", e3.getKey());


                   // partion周期分割(e3.getValue(),valueOf == null?统计周期编码.H__01_每日:valueOf);


                    Map<DateRange, List<Collect>> maps4 = e3.getValue().stream().collect( // 二维度分类
                            Collectors.groupingBy(Collect::getDateRange)
                    );

                    Integer indexCount = 0;
                    maps4.entrySet().stream().forEach(e5 -> {
                        String valueIndex = "value"+indexCount;
                        map_result_element.put(valueIndex, e5.getValue().stream().count());

                    });
                });

            });
            return map_result_element;
        }).collect(Collectors.toList());
        Output output = new Output();
        output.setData(maps_);
        return output;
    }

    void partion周期分割(List<CollectPlan> list, 指标分类编码 H_01_单位数分析,SY_项目单位 H_02_个_人数){

    }


   //
    // @Transactional
    public Map 日单位状态变更时间序列(String dimension1, String dimension2) {

        long count = dp202_单位缴存变更登记簿_repository.count();
        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+count);


        LocalDate start = LocalDate.parse("2018-08-28");
        LocalDate end = LocalDate.parse("2018-09-30");

        LocalDate now = LocalDate.now();
        LocalDate year_before = now.minusDays(5);
        long num = DateUtilsss.until(year_before);


         double[] numbers = {1, 2, 3, 4};
         DoubleColumn nc = DoubleColumn.create("nc", numbers);
         System.out.println(nc.print());

        Integer[][] bb = new Integer[E_HX_机构_Institution_info_instCodeEnum.values().length][Long.valueOf(abs(num)).intValue()+1];
         List<Map<String, Map<String,List<Triplet<DP202_单位缴存变更登记簿,CM001_单位基本资料表,Double>>>>> list = new ArrayList();



/*

         List<Table> cuteAnimals =
                 Table.create("Cute Animals");
*/

         Table cuteAnimals =
                 Table.create("Cute Animals");

         cuteAnimals.addColumns(
                 StringColumn.create("机构", Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).map(e->e.getDisplayText()).collect(Collectors.toList())));
        for(int i=0; i<=abs(num); i++){
            LocalDate n = now.minusDays(i);

            List<DP202_单位缴存变更登记簿> dp021_单位缴存登记薄s = dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期(n);

            System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+dp021_单位缴存登记薄s.size());

            Map<String, List<Triplet<DP202_单位缴存变更登记簿,CM001_单位基本资料表,Double>>> maps___ =dp021_单位缴存登记薄s.stream().map(e->{

               CM001_单位基本资料表 cm001_单位基本资料表 = cm001单位基本资料表Repository.findByUnitcustid单位客户号(e.getUnitcustid不可为空单位客户号());
               Triplet<DP202_单位缴存变更登记簿,CM001_单位基本资料表,Double> triplet =
                       Triplet.with(e, cm001_单位基本资料表, 1.0);
               triplet.getValue1();
               return triplet;
            }).collect(Collectors.toList()).stream().collect(  // 机构分类
                   Collectors.groupingBy(e->e.getValue0().getAgentinstcode不可为空_经办机构())
           );



            Map<String, Map<String,List<Triplet<DP202_单位缴存变更登记簿,CM001_单位基本资料表,Double>>>> sssss = maps___.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),a->{
                return a.getValue().stream().collect(Collectors.groupingBy(c->c.getValue1().getUnitkind_单位性质()));
            }));

            list.add(sssss);



/*
            Map<String, List<DP202_单位缴存变更登记簿>> maps___ = dp021_单位缴存登记薄s.stream().collect(  // 机构分类
                    Collectors.groupingBy(DP202_单位缴存变更登记簿::getAgentinstcode不可为空_经办机构)
            );
*/

      //      Map<String, Triplet<DP202_单位缴存变更登记簿,CM001_单位基本资料表,Double>> map =  maps___.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), b->b.getValue()));



           List<List<Triplet<DP202_单位缴存变更登记簿,CM001_单位基本资料表,Double>>> by机构 = Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).map(e->{
                List<Triplet<DP202_单位缴存变更登记簿,CM001_单位基本资料表,Double>> elemtnt = maps___.get(e.getText());

                if(elemtnt!= null){
                    return elemtnt;
                }else{
                    return new ArrayList<Triplet<DP202_单位缴存变更登记簿,CM001_单位基本资料表,Double>>();
                }

            }).collect(Collectors.toList());

          //  System.out.println("---------------------e "+a);


       //    Integer array=.toArray(new Integer[by机构.size()]);

            cuteAnimals.addColumns(
                    DoubleColumn.create(n.toString(), by机构.stream().map(e->e.size()).collect(Collectors.toList())));
//
/*            Integer rowIndex = 0;
            for(List<Triplet<DP202_单位缴存变更登记簿,CM001_单位基本资料表,Double>> e:by机构){
               // System.out.println("----------------rowIndex-----e "+rowIndex+"--"+e);
                bb[rowIndex][i]=  e.size();
                rowIndex++;
            }*/
        }


        Map mapResult = new HashMap();
         mapResult.put("dimension1",dimension1);
         for(Map<String, Map<String,List<Triplet<DP202_单位缴存变更登记簿,CM001_单位基本资料表,Double>>>> EE :list){
             long cccc = EE.get(dimension1).get(dimension2).stream().map(e->{
                 return e.getValue1().getUnitcustid单位客户号();
             }).count();

             mapResult.put("value1",cccc);
         }
/*        for(int i=0;i<bb.length;i++){
            System.out.println("---------------------e ");
            System.out.println(Arrays.toString(bb[i]));
        }*/
         System.out.println(cuteAnimals.print());

         for(Integer count_ = 1; count_< cuteAnimals.columnCount(); count_++){
             System.out.println(cuteAnimals.row(1).getDouble(count_));

         }

         return mapResult;
 /*        String[] animals = {"bear", "cat", "giraffe"};
         double[] cuteness = {90.1, 84.3, 99.7};

         Table cuteAnimals =
                 Table.create("Cute Animals")
                         .addColumns(
                                 StringColumn.create("Animal types", animals),
                                 DoubleColumn.create("rating", cuteness));*/

    }

    //TODO S_6_SEQ_新增单位数_AND_0301000501
    public Output S_6_SEQ_新增单位数_AND_0301000501(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_6_SEQ_新增单位数_AND_0301000501.name();
/*        HX摘要码信息表.HX__69_S_单位开户_1001;
        SY_项目单位.H_02_个_人数
        统计周期编码.H__01_每日;
        指标分类编码.H_01_单位数分析;*/





        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });





        LocalDateTime ldt_ksrq = LocalDateTime.parse(ksrq,df);
        LocalDateTime ldt_jsrq = LocalDateTime.parse(jsrq,df);
        List<UnitManagementAccount> collectPlans = unitManagementAccountRepository.findByCreateDateBetween(ldt_ksrq,ldt_jsrq);


        Output output = new Output();
       output.setData(Arrays.asList(日单位状态变更时间序列(dimension1, dimension2)));
        return output;

    }


    //TODO S_7_SEQ_销户单位数_AND_0301000601
    public Output S_7_SEQ_销户单位数_AND_0301000601(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_7_SEQ_销户单位数_AND_0301000601.name();
/*        HX摘要码信息表.HX__72_S_单位销户_1011;
        HX摘要码信息表.HX__77_S_单位预缴销户_1017;

        SY_项目单位.H_02_个_人数
        统计周期编码.H__01_每日;
        指标分类编码.H_01_单位数分析;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });







        LocalDateTime ldt_ksrq = LocalDateTime.parse(ksrq,df);
        LocalDateTime ldt_jsrq = LocalDateTime.parse(ksrq,df);
        List<UnitManagementAccount> collectPlans = unitManagementAccountRepository.findByCreateDateBetween(ldt_ksrq,ldt_jsrq);


        Map<String, List<BaseFlowDomain>> maps___ = collectPlans.stream().collect(  // 机构分类
                Collectors.groupingBy(BaseFlowDomain::getAgencyId)
        );

        List maps_ = maps___.entrySet().stream().map(e->{
            Map map_result_element = new HashMap();

            maps___.entrySet().stream().forEach(e2-> {
                map_result_element.put("dimension1", e2.getKey());

   /*                     Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
                        });*/
                Map<String, List<BaseFlowDomain>> maps3 = e2.getValue().stream().collect( // 二维度分类
                        Collectors.groupingBy(BaseFlowDomain::getAgencyId单位经济类型)
                );



                maps3.entrySet().stream().forEach(e3 -> {
                    map_result_element.put("dimension2", e3.getKey());
                    partion周期分割(e3.getValue(),valueOf == null?统计周期编码.H__01_每日:valueOf);

                    Map<DateRange, List<BaseFlowDomain>> maps4 = e3.getValue().stream().collect( // 二维度分类
                            Collectors.groupingBy(BaseFlowDomain::getDateRange)
                    );


                    Integer indexCount = 0;
                    maps4.entrySet().stream().forEach(e5 -> {
                        String valueIndex = "value"+indexCount;
                        List<UnitManagementAccount> childs2 = (List)(e5.getValue());
                        map_result_element.put(valueIndex, childs2.stream().count());

                    });
                });

            });
            return map_result_element;
        }).collect(Collectors.toList());
        Output output = new Output();
        output.setData(maps_);
        return output;
    }


    //TODO S_8_SEQ_封存单位数_AND_0301000701
    public Output S_8_SEQ_封存单位数_AND_0301000701(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_8_SEQ_封存单位数_AND_0301000701.name();

/*        SY_项目单位.H_02_个_人数
        统计周期编码.H__01_每日;
        指标分类编码.H_01_单位数分析;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });













        LocalDateTime ldt_ksrq = LocalDateTime.parse(ksrq,df);
        LocalDateTime ldt_jsrq = LocalDateTime.parse(ksrq,df);
        List<UnitManagementAccount> collectPlans = unitManagementAccountRepository.findByCreateDateBetween(ldt_ksrq,ldt_jsrq);


        Map<String, List<BaseFlowDomain>> maps___ = collectPlans.stream().collect(  // 机构分类
                Collectors.groupingBy(BaseFlowDomain::getAgencyId)
        );

        List maps_ = maps___.entrySet().stream().map(e->{
            Map map_result_element = new HashMap();

            maps___.entrySet().stream().forEach(e2-> {
                map_result_element.put("dimension1", e2.getKey());

   /*                     Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
                        });*/
                Map<String, List<BaseFlowDomain>> maps3 = e2.getValue().stream().collect( // 二维度分类
                        Collectors.groupingBy(BaseFlowDomain::getAgencyId单位经济类型)
                );



                maps3.entrySet().stream().forEach(e3 -> {
                    map_result_element.put("dimension2", e3.getKey());
                    partion周期分割(e3.getValue(),valueOf == null?统计周期编码.H__01_每日:valueOf);

                    Map<DateRange, List<BaseFlowDomain>> maps4 = e3.getValue().stream().collect( // 二维度分类
                            Collectors.groupingBy(BaseFlowDomain::getDateRange)
                    );


                    Integer indexCount = 0;
                    maps4.entrySet().stream().forEach(e5 -> {
                        String valueIndex = "value"+indexCount;
                        List<UnitManagementAccount> childs2 = (List)(e5.getValue());
                        map_result_element.put(valueIndex, childs2.stream().count());

                    });
                });

            });
            return map_result_element;
        }).collect(Collectors.toList());
        Output output = new Output();
        output.setData(maps_);
        return output;
    }


    //TODO
    public Output S_9_SEQ_缓缴单位数_AND_0301000801(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_9_SEQ_缓缴单位数_AND_0301000801.name();


/*        dp030_单位缓缴登记簿_repository.findAll();

        SY_项目单位.H_02_个_人数
        统计周期编码.H__01_每日;
        指标分类编码.H_01_单位数分析;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });




        LocalDateTime ldt_ksrq = LocalDateTime.parse(ksrq,df);
        LocalDateTime ldt_jsrq = LocalDateTime.parse(ksrq,df);
        List<UnitManagementAccount> collectPlans = unitManagementAccountRepository.findByCreateDateBetween(ldt_ksrq,ldt_jsrq);


        Map<String, List<BaseFlowDomain>> maps___ = collectPlans.stream().collect(  // 机构分类
                Collectors.groupingBy(BaseFlowDomain::getAgencyId)
        );

        List maps_ = maps___.entrySet().stream().map(e->{
            Map map_result_element = new HashMap();

            maps___.entrySet().stream().forEach(e2-> {
                map_result_element.put("dimension1", e2.getKey());

   /*                     Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
                        });*/
                Map<String, List<BaseFlowDomain>> maps3 = e2.getValue().stream().collect( // 二维度分类
                        Collectors.groupingBy(BaseFlowDomain::getAgencyId单位经济类型)
                );



                maps3.entrySet().stream().forEach(e3 -> {
                    map_result_element.put("dimension2", e3.getKey());
                    partion周期分割(e3.getValue(),valueOf == null?统计周期编码.H__01_每日:valueOf);

                    Map<DateRange, List<BaseFlowDomain>> maps4 = e3.getValue().stream().collect( // 二维度分类
                            Collectors.groupingBy(BaseFlowDomain::getDateRange)
                    );


                    Integer indexCount = 0;
                    maps4.entrySet().stream().forEach(e5 -> {
                        String valueIndex = "value"+indexCount;
                        List<UnitManagementAccount> childs2 = (List)(e5.getValue());
                        map_result_element.put(valueIndex, childs2.stream().count());

                    });
                });

            });
            return map_result_element;
        }).collect(Collectors.toList());
        Output output = new Output();
        output.setData(maps_);
        return output;
    }






    // TODO ????
    public Output S_11_SEQ_缴暂存款净额_AND_0301001001(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_11_SEQ_缴暂存款净额_AND_0301001001.name();

/*        统计周期编码.H__03_每月;
        指标分类编码.H_03_汇补缴分析;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO S_12_SEQ_补缴单位数_AND_0301001101
    public Output S_12_SEQ_补缴单位数_AND_0301001101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_12_SEQ_补缴单位数_AND_0301001101.name();
/*        HX摘要码信息表.HX__87_S_正常全额补缴入账_1220;
        HX摘要码信息表.HX__88_S_正常差额补缴入账_1221;
        HX摘要码信息表.HX__89_S_不定额补缴入账_1222;
       // pb017_public_flowing公共流水登记簿Repository.findAll();


        SY_项目单位.H_02_个_人数
        统计周期编码.H__03_每月;
        指标分类编码.H_01_单位数分析;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });











        LocalDateTime ldt_ksrq = LocalDateTime.parse(ksrq,df);
        LocalDateTime ldt_jsrq = LocalDateTime.parse(ksrq,df);
        List<Collect> collectPlans = collectRepository.findByCreateDateBetween(ldt_ksrq,ldt_jsrq);


        Map<String, List<BaseFlowDomain>> maps___ = collectPlans.stream().collect(  // 机构分类
                Collectors.groupingBy(BaseFlowDomain::getAgencyId)
        );

        List maps_ = maps___.entrySet().stream().map(e->{
            Map map_result_element = new HashMap();

            maps___.entrySet().stream().forEach(e2-> {
                map_result_element.put("dimension1", e2.getKey());
   /*                     Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
                        });*/


                Map<String, List<BaseFlowDomain>> maps3 = e2.getValue().stream().collect( // 二维度分类
                        Collectors.groupingBy(BaseFlowDomain::getAgencyId单位经济类型)
                );



                maps3.entrySet().stream().forEach(e3 -> {
                    map_result_element.put("dimension2", e3.getKey());
                    partion周期分割(e3.getValue(),valueOf == null?统计周期编码.H__01_每日:valueOf);

                    Map<DateRange, List<BaseFlowDomain>> maps4 = e3.getValue().stream().collect( // 二维度分类
                            Collectors.groupingBy(BaseFlowDomain::getDateRange)
                    );



                    Integer indexCount = 0;
                    maps4.entrySet().stream().forEach(e5 -> {
                        String valueIndex = "value"+indexCount;
                        List<Collect> childs2 = (List)(e5.getValue());
                        map_result_element.put(valueIndex, childs2.stream().count());

                    });
                });

            });
            return map_result_element;
        }).collect(Collectors.toList());
        Output output = new Output();
        output.setData(maps_);
        return output;


    }

    // TODO S_13_SEQ_开户总单位数_AND_0301002101
    public Output S_13_SEQ_开户总单位数_AND_0301002101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_13_SEQ_开户总单位数_AND_0301002101.name();

/*
        SY_项目单位.H_02_个_人数
        统计周期编码.H__01_每日;
        指标分类编码.H_01_单位数分析;
*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });


        return null;

    }


    // TODO ???
    public Output S_10_SEQ_比例超限单位数_AND_0301000901(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_15_SEQ_正常总单位数_AND_0301002301.name();


/*        SY_项目单位.H_02_个_人数
        统计周期编码.H__01_每日;
        指标分类编码.H_01_单位数分析;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO ??? S_16_SEQ_封存总单位数_AND_0301002401
    public Output S_16_SEQ_封存总单位数_AND_0301002401(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_16_SEQ_封存总单位数_AND_0301002401.name();


/*        SY_项目单位.H_02_个_人数
        统计周期编码.H__01_每日;
        指标分类编码.H_01_单位数分析;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }


    // TODO ??? S_16_SEQ_封存总单位数_AND_0301002401
    public Output S_17_SEQ_应缴人数_AND_0301003101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_17_SEQ_应缴人数_AND_0301003101.name();

/*        SY_项目单位.H_02_个_人数
        统计周期编码.H__03_每月;
        指标分类编码.H_02_人数人次分析;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }



    // TODO S_22_SEQ_实缴人数__按年___AND_0301003206
    public Output S_22_SEQ_实缴人数__按年___AND_0301003206(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_22_SEQ_实缴人数__按年___AND_0301003206.name();

        dp022_个人缴存登记薄Repository.findAll();

/*        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__06_每年;*/
        //  SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{

        });
        return null;
    }


    // TODO S_25_SEQ_实缴人数__个人缴存基数___AND_0301003209
    public Output S_25_SEQ_实缴人数__个人缴存基数___AND_0301003209(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_25_SEQ_实缴人数__个人缴存基数___AND_0301003209.name();
/*        dW025_公积金提取审核登记表_Repository.findAll();

        // TODO 每类型多少个人


        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;*/
        //  SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{

        });
        return null;

    }

    // TODO S_26_SEQ_实缴人数__月缴存额___AND_0301003210
    public Output S_26_SEQ_实缴人数__月缴存额___AND_0301003210(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_26_SEQ_实缴人数__月缴存额___AND_0301003210.name();
        dp022_个人缴存登记薄Repository.findAll();

        // TODO 每类型多少个人
/*        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;*/
        //  SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });

        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{

        });

        return null;
    }


    // TODO S_27_SEQ_缴存金额__非本市缴存职工___AND_0301003211
    public Output S_27_SEQ_缴存金额__非本市缴存职工___AND_0301003211(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_27_SEQ_缴存金额__非本市缴存职工___AND_0301003211.name();
        dp022_个人缴存登记薄Repository.findAll();
        个人Utils.非本市缴存职工("");

        // TODO 开户年限

        // TODO 每类型多少个人
/*        指标分类编码.H_03_汇补缴分析;
        统计周期编码.H__06_每年;*/
        //  SY_项目单位.H_02_个_人数;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });

/*        Arrays.stream(开户年限.values()).forEach(e->{

        });*/


        return null;
    }


    // TODO
    public Output S_28_SEQ_实缴人次_AND_0301003301(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_28_SEQ_实缴人次_AND_0301003301.name();
        dp022_个人缴存登记薄Repository.findAll();


        // TODO 开户年限

        // TODO 每类型多少个人
/*        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });


        // TODO 每类型多少个人
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO
    public Output S_29_SEQ_补缴人数_AND_0301003401(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_29_SEQ_补缴人数_AND_0301003401.name();
        dp022_个人缴存登记薄Repository.findAll();

        // TODO 每类型多少个人
/*
        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
        SY_项目单位.H_02_个_人数;
*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });


        // TODO 每类型多少个人
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }


    // TODO S_30_SEQ_未缴人数_AND_0301003501
    public Output S_30_SEQ_未缴人数_AND_0301003501(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_30_SEQ_未缴人数_AND_0301003501.name();
        dp022_个人缴存登记薄Repository.findAll();

/*        // TODO 每类型多少个人
        // TODO 每类型多少个人
        指标分类编码.H_02_人数人次分析;
        统计周期编码.H__03_每月;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });


        // TODO 每类型多少个人
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }


    // TODO
    public Output S_48_SEQ_应归集额_AND_0301007101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_48_SEQ_应归集额_AND_0301007101.name();
        dp022_个人缴存登记薄Repository.findAll();
/*        统计周期编码.H__03_每月;
        // TODO 每类型多少个人



        指标分类编码.H_03_汇补缴分析;
        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_49_SEQ_实归集额_AND_0301007201(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_49_SEQ_实归集额_AND_0301007201.name();
        dp022_个人缴存登记薄Repository.findAll();
/*        统计周期编码.H__01_每日;
        // TODO 每类型多少个人

        指标分类编码.H_03_汇补缴分析;
       SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_50_SEQ_实归集额__缴存基数___AND_0301007202(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_50_SEQ_实归集额__缴存基数___AND_0301007202.name();
        dp022_个人缴存登记薄Repository.findAll();
/*        统计周期编码.H__01_每日;
        // TODO 每类型多少个人


        指标分类编码.H_03_汇补缴分析;*/
        // SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_51_SEQ_实归集额__月缴存额___AND_0301007203(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_51_SEQ_实归集额__月缴存额___AND_0301007203.name();
        dp022_个人缴存登记薄Repository.findAll();
/*        统计周期编码.H__01_每日;
        // TODO 每类型多少个人
        指标分类编码.H_03_汇补缴分析;*/
        // SY_项目单位.H_01_元_金额价格;

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_52_SEQ_补缴金额_AND_0301007301(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_52_SEQ_补缴金额_AND_0301007301.name();
        dp021_单位缴存登记薄Repository.findAll();


        // TODO 每类型多少个人
        E_DP021_单位缴存登记簿_缴存类型 E = E_DP021_单位缴存登记簿_缴存类型.正常全额补缴;
        E = E_DP021_单位缴存登记簿_缴存类型.正常全额补缴;
        E = E_DP021_单位缴存登记簿_缴存类型.不定额补缴;




/*        指标分类编码.H_03_汇补缴分析;
        统计周期编码 A =统计周期编码.H__03_每月;
        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO
    public Output S_61_SEQ_结转利息额_AND_0301008001(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_61_SEQ_结转利息额_AND_0301008001.name();
/*        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人


        指标分类编码.H_03_汇补缴分析;
        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }
    // TODO S_62_SEQ_结转利息额__正常职工结转___AND_0301008002
    public Output S_62_SEQ_结转利息额__正常职工结转___AND_0301008002(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_62_SEQ_结转利息额__正常职工结转___AND_0301008002.name();
/*        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人


        指标分类编码.H_03_汇补缴分析;

        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }
    // TODO
    public Output S_63_SEQ_结转利息额__非正常职工结转___AND_0301008003(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_63_SEQ_结转利息额__非正常职工结转___AND_0301008003.name();
/*        dW025_公积金提取审核登记表_Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人


        指标分类编码.H_03_汇补缴分析;
        SY_项目单位.H_01_元_金额价格;*/
        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }


    // TODO
    public Output S_64_SEQ_非正常账户余额_AND_0301008004(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_64_SEQ_非正常账户余额_AND_0301008004.name();
        dp006__个人缴存信息表_repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        // TODO 每类型多少个人


/*        指标分类编码.H_03_汇补缴分析;

        SY_项目单位.H_03_户数_贷款户数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }
    // TODO
    public Output S_65_SEQ_归集余额_AND_0301008101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_65_SEQ_归集余额_AND_0301008101.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人

/*
        指标分类编码.H_03_汇补缴分析;

        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }

    // TODO
    public Output S_66_SEQ_暂存款余额_AND_0301008102(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人

/*        指标分类编码.H_03_汇补缴分析;

        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO
    public Output S_67_SEQ_历史累计归集额_AND_0301010101(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_67_SEQ_历史累计归集额_AND_0301010101.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人




/*        指标分类编码.H_05_历史累计分析;
        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_68_SEQ_历史累计补缴额_AND_0301010201
    public Output S_68_SEQ_历史累计补缴额_AND_0301010201(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_68_SEQ_历史累计补缴额_AND_0301010201.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        // TODO 每类型多少个人


/*
        指标分类编码.H_05_历史累计分析;
        SY_项目单位.H_01_元_金额价格;
*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });
        return null;
    }

    // TODO S_69_SEQ_历史累计外部转入额_AND_0301010501
    public Output S_69_SEQ_历史累计外部转入额_AND_0301010501(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_69_SEQ_历史累计外部转入额_AND_0301010501.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        // TODO 每类型多少个人


/*        指标分类编码.H_05_历史累计分析;
        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO S_70_SEQ_历史累计外部转出额_AND_0301010601
    public Output S_70_SEQ_历史累计外部转出额_AND_0301010601(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_70_SEQ_历史累计外部转出额_AND_0301010601.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        // TODO 每类型多少个人


/*        指标分类编码.H_05_历史累计分析;
        SY_项目单位.H_01_元_金额价格;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO S_73_SEQ_历史累计归集人数_AND_0301010801
    public Output S_73_SEQ_历史累计归集人数_AND_0301010801(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_73_SEQ_历史累计归集人数_AND_0301010801.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__01_每日;
        // TODO 每类型多少个人

/*      指标分类编码.H_05_历史累计分析;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }

    // TODO S_74_SEQ_历史累计补缴人数_AND_0301010901
    public Output S_74_SEQ_历史累计补缴人数_AND_0301010901(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_74_SEQ_历史累计补缴人数_AND_0301010901.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;
        // TODO 每类型多少个人


/*        指标分类编码.H_05_历史累计分析;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(住建部编码_单位经济类型.values()).forEach(e->{
        });

        return null;
    }




    // TODO S_85_SEQ_当年缴存额__收入水平___AND_0301020503
    public Output S_85_SEQ_当年缴存额__收入水平___AND_0301020503(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        String name = StatisticalIndexCodeEnum.S_85_SEQ_当年缴存额__收入水平___AND_0301020503.name();
        dp021_单位缴存登记薄Repository.findAll();
        统计周期编码 A =统计周期编码.H__03_每月;


/*
        指标分类编码.H_25_收入水平分析;
        SY_项目单位.H_02_个_人数;*/

        Arrays.stream(E_HX_机构_Institution_info_instCodeEnum.values()).forEach(e->{
        });
        Arrays.stream(E_住建部编码_收入水平.values()).forEach(e->{
        });

        return null;
    }
}
