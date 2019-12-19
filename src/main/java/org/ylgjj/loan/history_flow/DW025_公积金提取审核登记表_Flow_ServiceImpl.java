package org.ylgjj.loan.history_flow;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.repository_flow.YourHistoryRepository;
import org.ylgjj.loan.util.DateUtilsss;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("DW025_公积金提取审核登记表_Flow_ServiceImpl")
public class DW025_公积金提取审核登记表_Flow_ServiceImpl {


    @Autowired
    private CM002_个人基本资料表Repository cm002个人基本资料表Repository;
    @Autowired
    private DP034_公积金开销户登记簿_Repository dp034_公积金开销户登记簿_repository;


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
    private LN003_合同信息_Repository ln003_合同信息_repository;


    @Autowired
    private DP204_个人缴存变更登记簿_Repository dp204_个人缴存变更登记簿_repository;
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
    private PB017_public_flowing公共流水登记簿Repository public_flowing公共流水登记簿Repository;


    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    private DP009_个人明细账_Repository dp009_个人明细账_repository;


    @Autowired
    private YourHistoryRepository yourHistoryRepository;


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;


    boolean initComplte = false;
    List<DP006_个人缴存信息表> dp006__个人缴存信息表s = null;

    Map<String,CM002_个人基本资料表> cm002_个人基本资料表Map = null;
    Map<String, DP007_个人分户账> dp007_individual_sub_account_个人分户账Map = null;

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
    Map<String, DP005_单位分户账> dp005_work_unit_单位分户账Map = null;
    Map<String,List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map = null;
    //TODO 历史倒推

    public  void 历史倒推_某一日的缴存(LocalDate localDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

/*
        if(!initComplte){
            dp006_payment_个人缴存信息表s = dp006_payment_个人缴存信息表_repository.findAll();

            cm002_个人基本资料表Map = cm002个人基本资料表Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccname_个人姓名(), a->a));
            dp007_individual_sub_account_个人分户账Map = dp007_individual_sub_account个人分户账Repository.findAll().stream().collect(Collectors.toMap(e->e.getAccnum_个人账号(),a->a));

            cm001_单位基本资料表Map = cm001单位基本资料表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitcustid单位客户号(), a -> a));
            dp005_work_unit_单位分户账Map = dp005_workUnit_单位分户账_repository.findAll().stream().collect(Collectors.toMap(e -> e.getUnitaccnum单位账号(), a -> a));

            initComplte= true;
        }


        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByRegdate登记日期(localDate);
        List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByTransdate不可为空交易日期(localDate);
        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);

        Map<String,List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map
                = dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e->e.getAccnum个人账号()));
        Map<String,List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map
                = dw025_公积金提取审核登记表s.stream().collect(Collectors.groupingBy(e->e.getUnitaccnum单位账号()));

        Map<String,List<DP009_个人明细账>> dp009_个人明细账Map
                = dp009_个人明细账s.stream().collect(Collectors.groupingBy(e->e.getAccnum不可为空个人账号()));

*/

/*
        if(maps.contains(E_TABLE_HX.DP204_个人缴存变更登记簿)){
            dp204_个人缴存变更登记簿Map = dp204_个人缴存变更登记簿_repository.findByAccnum不可为空个人账号In(dp)
                    .stream().collect(Collectors.groupingBy(x->x.getAccnum不可为空个人账号()));
        }
*/














        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s1 = dW025__公积金提取审核登记表_Repository.findAll();


              dw025_公积金提取审核登记表s1.stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;
              DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());

                  return Triplet.with(e,
                          cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                        dp204_个人缴存变更登记簿Map.get(e.getAccnum个人账号()));

        }).collect(Collectors.groupingBy(e->e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee->{
            String 机构编码 = eee.getKey();




            //S_36_SEQ_提取人数_AND_0301003901("0301","0301003901","提取人数"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
            //    S_37_SEQ_提取人数__提取原因___AND_0301003911("0301","0301003911","提取人数(提取原因)"," ","02","03","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","0","02",true),

            //  S_53_SEQ_提取本金_AND_0301007601("0301","0301007601","提取本金"," ","04","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),
            // S_55_SEQ_提取本金__提取原因___AND_0301007611("0301","0301007611","提取本金(提取原因)"," ","04","01","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","1","01",false),
            // S_56_SEQ_提取利息_AND_0301007701("0301","0301007701","提取利息"," ","04","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),
            //  S_57_SEQ_提取利息__提取原因___AND_0301007711("0301","0301007711","提取利息(提取原因)"," ","04","01","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","1","01",false),



            // S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203("0301","0301003203","提取人数（非本市缴存职工）"," ","02","06","bm_khjg","机构","bm_bi_khnx","开户年限"," "," ","0"," ",false),
            //S_23_SEQ_提取金额__非本市缴存职工___AND_0301003207("0301","0301003207","提取金额（非本市缴存职工）"," ","04","01","bm_khjg","机构"," "," "," "," ","1"," ",false),






            //   S_20_SEQ_提取金额__收入水平___AND_0301003204("0301","0301003204","提取金额(收入水平)","提取金额(收入水平包含低收入、中收入、高收入)","25","01","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","1"," ",false),




            eee.getValue().stream().collect(Collectors.groupingBy(e->{
                return  e.getValue2().stream().filter(i->i.getTransdate不可为空交易日期().isBefore(localDate)).findFirst().get().getBfchgbasenum_不可为空_变更前基数();

            })).entrySet().forEach(o->{
                // StatisticalIndexCodeEnum.S_20_SEQ_提取金额__收入水平___AND_0301003204
                LoanHistory loanHistory = new LoanHistory(localDate, StatisticalIndexCodeEnum.S_20_SEQ_提取金额__收入水平___AND_0301003204);
                loanHistory.setIndex收入水平(o.getKey()); // 银行名称
                loanHistory.setValue贷款金额(o.getValue().stream().mapToDouble(k->k.getValue0().getINTAMT_不可为空_提取的结息金额()).sum());  //
                loanHistoryRepository.save(loanHistory);


            });




        });





















        dw025_公积金提取审核登记表s1.stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;


            DP007_个人分户账 dp007__个人分户账 = dp007_individual_sub_account_个人分户账Map.get(e.getAccnum个人账号());

            DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


            return Triplet.with(e,
                    cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                    dp007__个人分户账);
        }).collect(Collectors.groupingBy(e->e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee->{
            String 机构编码 = eee.getKey();


            //S_36_SEQ_提取人数_AND_0301003901("0301","0301003901","提取人数"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
            //    S_37_SEQ_提取人数__提取原因___AND_0301003911("0301","0301003911","提取人数(提取原因)"," ","02","03","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","0","02",true),

            //  S_53_SEQ_提取本金_AND_0301007601("0301","0301007601","提取本金"," ","04","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),
            // S_55_SEQ_提取本金__提取原因___AND_0301007611("0301","0301007611","提取本金(提取原因)"," ","04","01","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","1","01",false),
            // S_56_SEQ_提取利息_AND_0301007701("0301","0301007701","提取利息"," ","04","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),
            //  S_57_SEQ_提取利息__提取原因___AND_0301007711("0301","0301007711","提取利息(提取原因)"," ","04","01","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","1","01",false),



            // S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203("0301","0301003203","提取人数（非本市缴存职工）"," ","02","06","bm_khjg","机构","bm_bi_khnx","开户年限"," "," ","0"," ",false),
            //S_23_SEQ_提取金额__非本市缴存职工___AND_0301003207("0301","0301003207","提取金额（非本市缴存职工）"," ","04","01","bm_khjg","机构"," "," "," "," ","1"," ",false),






            //   S_20_SEQ_提取金额__收入水平___AND_0301003204("0301","0301003204","提取金额(收入水平)","提取金额(收入水平包含低收入、中收入、高收入)","25","01","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","1"," ",false),






            //S_57_SEQ_提取利息__提取原因___AND_0301007711
            eee.getValue().stream().collect(Collectors.groupingBy(e->e.getValue0().getDrawreason_提取原因())).entrySet().forEach(o->{


                // StatisticalIndexCodeEnum.S_57_SEQ_提取利息__提取原因___AND_0301007711

                LoanHistory loanHistory = new LoanHistory(localDate, StatisticalIndexCodeEnum.S_57_SEQ_提取利息__提取原因___AND_0301007711);
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setValue贷款金额(o.getValue().stream().mapToDouble(k->k.getValue0().getINTAMT_不可为空_提取的结息金额()).sum());  //
                loanHistoryRepository.save(loanHistory);


                // StatisticalIndexCodeEnum.S_57_SEQ_提取利息__提取原因___AND_0301007711

                loanHistory = new LoanHistory(localDate, StatisticalIndexCodeEnum.S_55_SEQ_提取本金__提取原因___AND_0301007611);
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setValue贷款金额(o.getValue().stream().mapToDouble(k->k.getValue0().getINCREBAL_不可为空_提取的增量金额()+k.getValue0().getKEEPBAL_不可为空_提取的存量金额()).sum());  //
                loanHistoryRepository.save(loanHistory);


                //StatisticalIndexCodeEnum.S_36_SEQ_提取人数_AND_0301003901
                loanHistory = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_36_SEQ_提取人数_AND_0301003901);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                loanHistory.setValue贷款金额(o.getValue().stream().count());  //
                loanHistoryRepository.save(loanHistory);


            });









        });




















        dw025_公积金提取审核登记表s1.stream().collect(Collectors.toList()).stream().map(e->{
            //TODO        获得某一日的缴存列表;


            DP007_个人分户账 dp007__个人分户账 = dp007_individual_sub_account_个人分户账Map.get(e.getAccnum个人账号());

            DP005_单位分户账 dp005__单位分户账 = dp005_work_unit_单位分户账Map.get(e.getUnitaccnum单位账号());


            return Triplet.with(e,
                    cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                    dp007__个人分户账);

        }).collect(Collectors.groupingBy(e->e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee->{
            String 机构编码 = eee.getKey();




            //S_36_SEQ_提取人数_AND_0301003901("0301","0301003901","提取人数"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
            //    S_37_SEQ_提取人数__提取原因___AND_0301003911("0301","0301003911","提取人数(提取原因)"," ","02","03","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","0","02",true),

            //  S_53_SEQ_提取本金_AND_0301007601("0301","0301007601","提取本金"," ","04","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),
            // S_55_SEQ_提取本金__提取原因___AND_0301007611("0301","0301007611","提取本金(提取原因)"," ","04","01","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","1","01",false),
            // S_56_SEQ_提取利息_AND_0301007701("0301","0301007701","提取利息"," ","04","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",false),
            //  S_57_SEQ_提取利息__提取原因___AND_0301007711("0301","0301007711","提取利息(提取原因)"," ","04","01","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","1","01",false),



            // S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203("0301","0301003203","提取人数（非本市缴存职工）"," ","02","06","bm_khjg","机构","bm_bi_khnx","开户年限"," "," ","0"," ",false),
            //S_23_SEQ_提取金额__非本市缴存职工___AND_0301003207("0301","0301003207","提取金额（非本市缴存职工）"," ","04","01","bm_khjg","机构"," "," "," "," ","1"," ",false),






            //   S_20_SEQ_提取金额__收入水平___AND_0301003204("0301","0301003204","提取金额(收入水平)","提取金额(收入水平包含低收入、中收入、高收入)","25","01","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","1"," ",false),




            // TODO 按照 经济类型
            eee.getValue().stream().collect(Collectors.groupingBy(a->a.getValue1().getUnitkind_单位性质())).entrySet()
                    .stream().forEach(uuu->{

                //StatisticalIndexCodeEnum.S_57_SEQ_提取利息__提取原因___AND_0301007711
                LoanHistory loanHistory = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_56_SEQ_提取利息_AND_0301007701);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(k->k.getValue0().getINTAMT_不可为空_提取的结息金额()).sum());  //
                loanHistoryRepository.save(loanHistory);

                //StatisticalIndexCodeEnum.S_53_SEQ_提取本金_AND_0301007601
                loanHistory = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_53_SEQ_提取本金_AND_0301007601);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(k->k.getValue0().getKEEPBAL_不可为空_提取的存量金额()+k.getValue0().getINCREBAL_不可为空_提取的增量金额()).sum());  //
                loanHistoryRepository.save(loanHistory);

                //StatisticalIndexCodeEnum.S_36_SEQ_提取人数_AND_0301003901
                loanHistory = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_36_SEQ_提取人数_AND_0301003901);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().count());  //
                loanHistoryRepository.save(loanHistory);


                //StatisticalIndexCodeEnum.S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203
                loanHistory = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_19_SEQ_提取人数__非本市缴存职工___AND_0301003203);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(k->k.getValue0().getKEEPBAL_不可为空_提取的存量金额()+k.getValue0().getINCREBAL_不可为空_提取的增量金额()).sum());  //
                loanHistoryRepository.save(loanHistory);


                // StatisticalIndexCodeEnum.S_23_SEQ_提取金额__非本市缴存职工___AND_0301003207
                loanHistory = new LoanHistory(localDate,StatisticalIndexCodeEnum.S_23_SEQ_提取金额__非本市缴存职工___AND_0301003207);
                loanHistory.setIndex机构编码(机构编码); // 机构名称
                loanHistory.setIndex经济类型(uuu.getKey()); // 银行名称
                loanHistory.setValue贷款金额(uuu.getValue().stream().mapToDouble(k->k.getValue0().getKEEPBAL_不可为空_提取的存量金额()+k.getValue0().getINCREBAL_不可为空_提取的增量金额()).sum());  //
                loanHistoryRepository.save(loanHistory);




/*

            S_24_SEQ_提取人次__收入水平___AND_0301003208("0301","0301003208","提取人次(收入水平)","提取人次(收入水平包含低收入、中收入、高收入)","25","03","bm_khjg","机构","bm_bi_srsp","收入水平"," "," ","0"," ",false),
                    S_38_SEQ_提取人次_AND_0301004001("0301","0301004001","提取人次"," ","02","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    S_39_SEQ_提取人次__提取原因___AND_0301004011("0301","0301004011","提取人次(提取原因)"," ","02","03","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","0","02",false),
                    S_54_SEQ_提取本金__跨中心转出___AND_0301007602("0301","0301007602","提取本金(跨中心转出)"," ","04","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1"," ",false),
*/


            });





        });





















    }












/*
    S_71_SEQ_历史累计提取额_AND_0301010701("0301","0301010701","历史累计提取额"," ","05","01","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","1","01",true),
    S_72_SEQ_历史累计提取额__提取原因___AND_0301010711("0301","0301010711","历史累计提取额(提取原因)"," ","05","01","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","1","01",true),


    S_75_SEQ_历史累计提取人数_AND_0301011001("0301","0301011001","历史累计提取人数"," ","05","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",true),
    S_76_SEQ_历史累计提取人数__提取原因___AND_0301011002("0301","0301011002","历史累计提取人数(提取原因)"," ","05","03","bm_khjg","机构","bm_gz_tqyy","提取原因"," "," ","0","02",true),
*/







    //TODO 存储统计信息
    public void saveHistorySpan(LocalDate ldt_ksrq,LocalDate js) {
        LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq,year_before);


        for(int i=0; i<=abs(num); i++) {
            LocalDate n = ldt_ksrq.minusDays(i);


        }
    }




    public void run() {
        saveHistorySpan(LocalDate.now(),null);
    }




    //TODO ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？获取当前的一个状态
    public void saveHistoryOneTime(LocalDate localDate) {

        //从时间变化的列表中，抽取变化时记录的 状态。

   //     private BigDecimal loanbal不可为空_账户余额;
        List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(localDate);


    }




    public DP009_个人明细账 DP021_单位缴存登记簿_flowing(List<DP009_个人明细账> dp009_个人明细账s, LocalDate n) {

        System.out.println("------- 正在处理 的时间"+n);


/*
        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期(localDate);
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByTransdate不可为空交易日期(localDate);
        List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByTransdate不可为空交易日期(localDate);
        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByTransdate不可为空交易日期(localDate);
*/

        Map<Boolean,List<DP009_个人明细账>> a = dp009_个人明细账s.stream().collect(Collectors.groupingBy(x->x.getTransdate不可为空交易日期().isBefore(n)));

        System.out.println("--分开的----- 之前的"+(a.get(true).size()));
        System.out.println("--分开的----- 之前的"+(a.get(false) == null));
        //System.out.println("--分开的----- 之前的"+(a.get(true).size() ==0? null : a.get(true).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //   System.out.println("--分开的----- 之h偶的"+(a.get(false)  ==null? "null" : a.get(false).stream().map(h->h.getRegdate不可为空登记日期()).collect(Collectors.toList())));
        //List<DP021_单位缴存登记簿> greaterList = ee.getValue().stream().filter(x->x.getRegdate不可为空登记日期().isBefore(n)).collect(Collectors.toList());

        if(a.get(true).isEmpty()){
            System.out.println("------- 返回时空的啊啊啊啊");
            return null;
        }


        DP009_个人明细账 lastContact = Collections.max(a.get(true),
                Comparator.comparing(DP009_个人明细账::getTransdate不可为空交易日期));

        System.out.println("------- 找的一个最近的登记表啊啊"+lastContact.getTransdate不可为空交易日期());
        System.out.println("------- 缴存人数 "+lastContact.getBal_不可为空_余额());
        System.out.println("------- 缴存基数 "+lastContact.getBasenum_不可为空_缴存基数());
        System.out.println("------- 缴存基数 "+lastContact.getKeepamt_可为空_存量发生额());
        System.out.println("------- 缴存基数 "+lastContact.getIndiprop_不可为空_个人缴存比例());
        System.out.println("------- 缴存基数 "+lastContact.getUnitprop_不可为空_单位比例());
        System.out.println("------- 缴存基数 "+lastContact.getIncreamt_可为空_增量发生额());
        return lastContact;


    }


}
