package org.ylgjj.loan.flowoutput;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.H个人缴存变更登记簿_变更类型;
import org.ylgjj.loan.outputenum.E_银行编码_HX;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.UnitManagementAccountRepository;
import org.ylgjj.loan.util.DateUtilsss;

import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("BFlowoutputServiceImpl")
public class BFlowoutputServiceImpl {


    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;
    @Autowired
    private CM002Repository cm002Repository;
    @Autowired
    private DP034_公积金开销户登记簿_Repository dp034_公积金开销户登记簿_repository;


    @Autowired
    private LN008_借款人类型Repository lN008_借款人类型Repository;

    @Autowired
    private LN014_TradingHouse_贷款房屋信息Repository ln014_tradingHouse_贷款房屋信息Repository;
    @Autowired
    private LN006_贷款分期还款计划Repository ln006_贷款分期还款计划Repository;




    @Autowired
    private DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;


    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private DW025_公积金提取审核登记表_Repository dW025__公积金提取审核登记表_Repository;

    @Autowired
    private DP007_individual_sub_account_个人分户账_Repository dp007_individual_sub_account个人分户账Repository;
    @Autowired
    private DP006_Payment_个人缴存信息表_Repository dp006_payment_个人缴存信息表_repository;


    @Autowired
    private LN003_Contract_info_Repository ln003_contract_info_repository;


    @Autowired
    private DP204_个人缴存变更登记簿_Repository dp204_个人缴存变更登记簿_repository;
    @Autowired
    private DW145_提取结算登记薄_Repository dw145_提取结算登记薄_repository;



    @Autowired
    private CM081_sms_短信密码签订登记簿_Repository cm081_sms_短信密码签订登记簿_repository;

    @Autowired
    private DP004_unit_payment_info_单位缴存信息表_Repository dp004_unit_payment_info单位缴存信息表Repository;

    @Autowired
    private DP005_WorkUnit_单位分户账_Repository dp005_workUnit_单位分户账_repository;

    @Autowired
    private CM001_单位基本资料表Repository cm001单位基本资料表Repository;
    @Autowired
    private DP008_institution_detail_单位明细账_Repository dp008_institution_detail_单位明细账_repository;
    @Autowired
    private DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;
    @Autowired
    private PB017_public_flowing公共流水登记簿Repository public_flowing公共流水登记簿Repository;

    @Autowired
    private UnitManagementAccountRepository unitManagementAccountRepository;

    @Autowired
    private PB011_bank_infor_Repository pb011_bank_infor_repository;


   // @PostConstruct
   // @Transactional
    public void 日单位状态变更时间序列() {

        long count = dp202_单位缴存变更登记簿_repository.count();
        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+count);


        LocalDate start = LocalDate.parse("2018-08-28");
        LocalDate end = LocalDate.parse("2018-09-30");

        LocalDate now = LocalDate.now();
        LocalDate year_before = now.minusMonths(1);
        long num = DateUtilsss.until(year_before);


        for(int i=0; i<=abs(num); i++){
            LocalDate n = now.minusDays(i);
/*            private LocalDateTime regdate不可为空登记日期;
            @Column(name = "inaccdate")
            private LocalDateTime inaccdate不可为空入账日期;*/


           // findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);

            List<DP202_单位缴存变更登记簿> dp021_单位缴存登记薄s = dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期(n);

            System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+dp021_单位缴存登记薄s.size());
            // dp021_单位缴存登记薄s.stream().map(e->e.getFactpayamt_实际缴款金额()).collect(Static);

/*            DoubleSummaryStatistics ageSummary = dp021_单位缴存登记薄s.stream()
                    .collect(Collectors.summarizingDouble(p -> p.getFactpayamt_实际缴款金额().doubleValue()));*/
        }

    }

    public long 某单位当日情况_应缴(String unitnum,LocalDate 日期) {

        long count = dp202_单位缴存变更登记簿_repository.count();
        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+count);

        List<DP202_单位缴存变更登记簿> dp021_单位缴存登记薄s = dp202_单位缴存变更登记簿_repository.findByUnitcustid不可为空单位客户号(unitnum);
        Optional<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿 = dp021_单位缴存登记薄s.stream().filter(e->e.getTransdate不可为空交易日期().isBefore(日期.plusDays(1))).findFirst();

        if(dp202_单位缴存变更登记簿.isPresent()){
            return dp202_单位缴存变更登记簿.get().getFinchgnum_不可为空_财政变更人数();
        }

        return 0;
    }


    public long 某单位当日情况_提取人数(String unitnum,LocalDate 日期) {

        long count = dp202_单位缴存变更登记簿_repository.count();
        System.out.println("--日归集时间序列 dp202_单位缴存变更登记簿_repository---"+count);

        List<DP202_单位缴存变更登记簿> dp021_单位缴存登记薄s = dp202_单位缴存变更登记簿_repository.findByUnitcustid不可为空单位客户号(unitnum);
        Optional<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿 = dp021_单位缴存登记薄s.stream().filter(e->e.getTransdate不可为空交易日期().isBefore(日期.plusDays(1))).findFirst();

        if(dp202_单位缴存变更登记簿.isPresent()){
            return dp202_单位缴存变更登记簿.get().getFinchgnum_不可为空_财政变更人数();
        }

        return 0;
    }

   // @PostConstruct
    //@Transactional
    public void 日归集时间序列() {

        long count = dp021_单位缴存登记薄Repository.count();


        System.out.println("--日归集时间序列 dp021_单位缴存登记薄Repository---"+count);
        LocalDate start = LocalDate.parse("2018-08-28");
        LocalDate end = LocalDate.parse("2018-09-30");

        LocalDate now = LocalDate.now();
        LocalDate year_before = now.minusMonths(1);
        long num = DateUtilsss.until(year_before);


        for(int i=0; i<= abs(num); i++){
            LocalDate n = now.minusDays(i);
/*            private LocalDateTime regdate不可为空登记日期;
            @Column(name = "inaccdate")
            private LocalDateTime inaccdate不可为空入账日期;*/
            //findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);
            List<DP021_单位缴存登记簿> dp021_单位缴存登记薄s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期(n);
           // dp021_单位缴存登记薄s.stream().map(e->e.getFactpayamt_实际缴款金额()).collect(Static);
            System.out.println("--日归集时间序列 dp021_单位缴存登记薄s---"+dp021_单位缴存登记薄s.size());
            DoubleSummaryStatistics ageSummary = dp021_单位缴存登记薄s.stream()
                    .collect(Collectors.summarizingDouble(p -> p.getFactpayamt_实际缴款金额().doubleValue()));
        }

    }



    //@PostConstruct
    //@Transactional
    public void 日提取时间序列() {

        long count = dw145_提取结算登记薄_repository.count();

        System.out.println("--日提取时间序列 dw145_提取结算登记薄_repository---"+count);

        LocalDate start = LocalDate.parse("2018-08-28");
        LocalDate end = LocalDate.parse("2018-09-30");

        LocalDate now = LocalDate.now();
        LocalDate year_before = now.minusMonths(1);
      //  long num = DateUtilsss.until(year_before);
        long num = DateUtilsss.until(year_before);
        int a = (int)num ;
        System.out.println("-dw145_提取结算登记薄_repository -until---"+Long.valueOf(num).toString());
        System.out.println("-dw145_提取结算登记薄_repository -until---"+(a<10));
        System.out.println("-dw145_提取结算登记薄_repository -until---"+a);

        //开始遍历

        for(int i=0; i <= abs(num); i++){

            System.out.println("- -until---"+i);
            LocalDate n = now.minusDays(i);

            System.out.println("- -until---"+n);
/*            private LocalDateTime regdate不可为空登记日期;
            @Column(name = "inaccdate")
            private LocalDateTime inaccdate不可为空入账日期;*/


           // findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);

            List<DW145_提取结算登记簿> dp021_单位缴存登记薄s = dw145_提取结算登记薄_repository.findByTRANSDATE交易日期0(n);

            System.out.println("多少笔记录-----------------"+dp021_单位缴存登记薄s.size());
/*            DoubleSummaryStatistics ageSummary = dp021_单位缴存登记薄s.stream()
                    .collect(Collectors.summarizingDouble(p -> p.getFactpayamt_实际缴款金额().doubleValue()));*/
        }

    }



   // @PostConstruct
   // @Transactional
    public void 日个人变更数量() {

        long count = dp204_个人缴存变更登记簿_repository.count();
        System.out.println("--日变更时间序列 DP204_个人缴存变更登记簿---"+count);


        LocalDate start = LocalDate.parse("2018-08-28");
        LocalDate end = LocalDate.parse("2018-09-30");

        LocalDate now = LocalDate.now();
        LocalDate year_before = now.minusMonths(1);
        long num = DateUtilsss.until(year_before);


        for(int i=0; i<=abs(num); i++){
            LocalDate n = now.minusDays(i);
/*            private LocalDateTime regdate不可为空登记日期;
            @Column(name = "inaccdate")
            private LocalDateTime inaccdate不可为空入账日期;*/


            // findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);

            List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByTransdate不可为空交易日期(n);

            System.out.println("--日变更时间序列 DP204_个人缴存变更登记簿---"+dp204_个人缴存变更登记簿s.size());

            Map<String, List<DP204_个人缴存变更登记簿>> maps___ = dp204_个人缴存变更登记簿s.stream().collect(  // 机构分类
                    Collectors.groupingBy(DP204_个人缴存变更登记簿::getChgtype_不可为空_变更类型)
            );


            maps___.entrySet().stream().forEach(e->{
                long ageSummary = e.getValue().stream().map(a->a.getAccnum_不可为空_个人账号()).count();
                System.out.println(H个人缴存变更登记簿_变更类型.fromString(e.getKey()).getDisplayText()+"--统计"+ageSummary);
            });

            // dp204_个人缴存变更登记簿s.stream().map(e->e.getFactpayamt_实际缴款金额()).collect(Static);

/*            DoubleSummaryStatistics ageSummary = dp204_个人缴存变更登记簿s.stream()
                    .collect(Collectors.summarizingDouble(p -> p.getFactpayamt_实际缴款金额().doubleValue()));*/
        }

    }







  //  @PostConstruct
    // @Transactional
    public void 日个贷款信息数量() {


        List<PB011_bank_info> pb011_bank_infos = pb011_bank_infor_repository.findAll();

        Map<String, String> map =  pb011_bank_infos.stream().collect(Collectors.toMap(PB011_bank_info::getBankcode, PB011_bank_info::getSUPERBANKCODE));


        long count = ln003_contract_info_repository.count();
        System.out.println("--日变更时间序列 DP204_个人缴存变更登记簿---"+count);


        LocalDate start = LocalDate.parse("2018-08-28");
        LocalDate end = LocalDate.parse("2018-09-30");

        LocalDate now = LocalDate.now();
        LocalDate year_before = now.minusMonths(1);
        long num = DateUtilsss.until(year_before);


        for(int i=0; i<=abs(num); i++){
            LocalDate n = now.minusDays(i);
/*            private LocalDateTime regdate不可为空登记日期;
            @Column(name = "inaccdate")
            private LocalDateTime inaccdate不可为空入账日期;*/


            // findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);

            List<LN003_contract_info_合同信息> dp204_个人缴存变更登记簿s = ln003_contract_info_repository.findByLoandate放款日期(n);

            System.out.println("--日变更时间序列 DP204_个人缴存变更登记簿---"+dp204_个人缴存变更登记簿s.size());

/*            Map<String, List<LN003_contract_info_合同信息>> maps___ = dp204_个人缴存变更登记簿s.stream().collect(  // 机构分类
                    Collectors.groupingBy(LN003_contract_info_合同信息::getAgentbankcode_经办银行)
            );*/

            Map<String, List<LN003_contract_info_合同信息>> maps___ = dp204_个人缴存变更登记簿s.stream().collect(  // 机构分类
                    Collectors.groupingBy(e->{
                        return map.get(e.getAgentbankcode_经办银行());
                    })
            );

           /* Collectors.toMap(
                    person -> person.getAge(),
                    person -> person.getName(), (pName1, pName2) -> pName1+"|"+pName2)
*/
            maps___.entrySet().stream().forEach(e->{
                long ageSummary = e.getValue().stream().map(a->a.getLoancontrnum_借款合同号()).count();
                System.out.println(E_银行编码_HX.fromString(e.getKey()).get银行名称()+"--统计"+ageSummary);
            });




            // dp204_个人缴存变更登记簿s.stream().map(e->e.getFactpayamt_实际缴款金额()).collect(Static);

/*            DoubleSummaryStatistics ageSummary = dp204_个人缴存变更登记簿s.stream()
                    .collect(Collectors.summarizingDouble(p -> p.getFactpayamt_实际缴款金额().doubleValue()));*/
        }

    }






  //  @PostConstruct
    // @Transactional
    public void 日个还款数量() {


        List<PB011_bank_info> pb011_bank_infos = pb011_bank_infor_repository.findAll();

        Map<String, String> map =  pb011_bank_infos.stream().collect(Collectors.toMap(PB011_bank_info::getBankcode, PB011_bank_info::getSUPERBANKCODE));


        long count = ln003_contract_info_repository.count();
        System.out.println("--日个还款数量 DP204_个人缴存变更登记簿---"+count);


        LocalDate start = LocalDate.parse("2018-08-28");
        LocalDate end = LocalDate.parse("2018-09-30");

        LocalDate now = LocalDate.now();
        LocalDate year_before = now.minusMonths(1);
        long num = DateUtilsss.until(year_before);


        for(int i=0; i<=abs(num); i++){
            LocalDate n = now.minusDays(i);
/*            private LocalDateTime regdate不可为空登记日期;
            @Column(name = "inaccdate")
            private LocalDateTime inaccdate不可为空入账日期;*/


            // findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);

            List<LN101_贷款明细账_account> ln101_贷款明细账_accounts = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(n);

            System.out.println("--日个还款数量 LN101_贷款明细账_account---"+ln101_贷款明细账_accounts.size());

/*            Map<String, List<LN003_contract_info_合同信息>> maps___ = dp204_个人缴存变更登记簿s.stream().collect(  // 机构分类
                    Collectors.groupingBy(LN003_contract_info_合同信息::getAgentbankcode_经办银行)
            );*/

            Map<String, List<LN101_贷款明细账_account>> maps___ = ln101_贷款明细账_accounts.stream().collect(  // 机构分类
                    Collectors.groupingBy(e->{
                        return map.get(e.getAccbankcode不可为空_账户银行());
                    })
            );





           /* Collectors.toMap(
                    person -> person.getAge(),
                    person -> person.getName(), (pName1, pName2) -> pName1+"|"+pName2);//


*/
            maps___.entrySet().stream().forEach(e->{
                long ageSummary = e.getValue().stream().map(a->a.getAccbankcode不可为空_账户银行()).count();
                System.out.println(E_银行编码_HX.fromString(e.getKey()).get银行名称()+"--统计"+ageSummary);
            });




            // dp204_个人缴存变更登记簿s.stream().map(e->e.getFactpayamt_实际缴款金额()).collect(Static);
/*            DoubleSummaryStatistics ageSummary = dp204_个人缴存变更登记簿s.stream()
                    .collect(Collectors.summarizingDouble(p -> p.getFactpayamt_实际缴款金额().doubleValue()));*/

        }

    }









    public static void main(String[] argus) {


     //   System.out.println("--日提取时间序列 dw145_提取结算登记薄_repository---"+count);

        LocalDate start = LocalDate.parse("2018-08-28");
        LocalDate end = LocalDate.parse("2018-09-30");

        LocalDate now = LocalDate.now();
        LocalDate year_before = now.minusMonths(1);
        //  long num = DateUtilsss.until(year_before);
        long num = DateUtilsss.until(year_before);
        int a = (int)num ;

        System.out.println("-dw145_提取结算登记薄_repository -until---"+Long.valueOf(num).toString());
        System.out.println("-dw145_提取结算登记薄_repository -until---"+(a<10));
        System.out.println("-dw145_提取结算登记薄_repository -until---"+(a-1));
        if(a>10){
            System.out.println("- -a>10---"+a);
        }else{
            System.out.println("- -a<=10---"+a);
        }
        System.out.println("-dw145_提取结算登记薄_repository -until---"+a);

        //开始遍历

        for(int j=0;j<abs(num);j++){

            System.out.println(j);
        }
        for(int i=0; i <= abs(num); i++){

            System.out.println("- -until---"+i);
            LocalDate n = now.minusDays(i);
/*            private LocalDateTime regdate不可为空登记日期;
            @Column(name = "inaccdate")
            private LocalDateTime inaccdate不可为空入账日期;*/


            // findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);

         //   List<DW145_提取结算登记簿> dp021_单位缴存登记薄s = dw145_提取结算登记薄_repository.findByTRANSDATE交易日期0(n);
            // dp021_单位缴存登记薄s.stream().map(e->e.getFactpayamt_实际缴款金额()).collect(Static);

            System.out.println("多少笔记录-----------------"+ i);
/*            DoubleSummaryStatistics ageSummary = dp021_单位缴存登记薄s.stream()
                    .collect(Collectors.summarizingDouble(p -> p.getFactpayamt_实际缴款金额().doubleValue()));*/
        }

    }

}
