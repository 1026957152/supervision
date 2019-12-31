package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.config.Constants;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_zongfu.Mi107_业务日志;
import org.ylgjj.loan.enumT.H单位公积金缴存登记簿_入账状态;
import org.ylgjj.loan.history_stream.HistoryServiceImpl;
import org.ylgjj.loan.output.H5_1离柜率_离柜率查询;
import org.ylgjj.loan.outputenum.E_业务类型_综服_HX;
import org.ylgjj.loan.outputenum.E_交易码_HX;
import org.ylgjj.loan.outputenum.E_渠道_核心_调整_HX;
import org.ylgjj.loan.pojo.Output_totalcount;
import org.ylgjj.loan.pojo.QueryH_4_1_业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.pojo.QueryH_5_1离柜率_离柜率查询;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_zhongfu.Mi107_业务日志_Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summarizingDouble;

/**
 * Created by silence yuan on 2015/7/25.
 */
// TODO 按渠道分配，如何区分托收是否按渠道分配
@Service("H5离柜率ServiceImpl")
public class H5离柜率ServiceImpl extends HistoryServiceImpl {

    @PersistenceContext(unitName = "primaryPersistenceUnit")
    protected EntityManager em;
    @Autowired
    private PB017_公共流水登记簿_Repository pb017_公共流水登记簿_repository;

    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private PB010_大行信息表Repository pb010__大行信息表Repository;

    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;


    @Autowired
    private DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;

    @Autowired
    private DW145_提取结算登记薄_Repository dw145_提取结算登记薄_repository;

    @Autowired
    private DP204_个人缴存变更登记簿_Repository dp204_个人缴存变更登记簿_repository;



    @Autowired
    private DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;




    @Autowired
    private Mi107_业务日志_Repository mi107_业务日志_repository;

    @Autowired
    private Cm052_客户信息变更明细表Repository cm052_客户信息变更明细表Repository;

    @Autowired
    private Cm051_客户信息变更登记薄Repository cm051_客户信息变更登记薄Repository;


    @Autowired
    private LN007_委托代扣协议信息Repository ln007_委托代扣协议信息Repository;

    @Autowired
    private DW025_公积金提取审核登记表_Repository dW025__公积金提取审核登记表_Repository;


    public ReturnResult 逾期监管汇总查询(String zjbzxbm) {
        return null;
    }

   // @PostConstruct
/*
    public void H5_1离柜率_离柜率查询() {


*/
/*        String hql = "select count\(*\),TRANSCHANNEL,SUMMARYCODE,(select SUMMARYDES from  pb002 where pb002.SUMMARYCODE=pb017.SUMMARYCODE) where   from pb017 group by TRANSCHANNEL,SUMMARYCODE" ;
        javax.persistence.Query query_ = em.createQuery(hql);
        List<Object> list = query_.getResultList();*//*

        List<PB017_公共流水登记簿_Repository.PB017公共流水登记簿Dto> objects = pb017_公共流水登记簿_repository.findByChannel(LocalDate.now(),LocalDate.now());
        //System.out.println("-----------"+objects.toString());
        objects.forEach(e->{
            System.out.println(e.getCc());
            System.out.println(e.getFirstname());
            System.out.println(e.getLastname());
            System.out.println(e.getDesciption());
        });


        objects.stream().collect(Collectors.groupingBy(e->e.getFirstname())).entrySet()
                .stream().map(e->{
            H5_1离柜率_离柜率查询 h5_1离柜率_离柜率查询 = new H5_1离柜率_离柜率查询();
            h5_1离柜率_离柜率查询.setJgbm_管理机构编码_String(Constants.zjbzxbm_住建部中心编码);
            h5_1离柜率_离柜率查询.setJgmc_管理机构_String(Constants.zjbzxbm_住建部中心编码);
            h5_1离柜率_离柜率查询.setKsrq_汇总日期_date(Constants.zjbzxbm_住建部中心编码);
            h5_1离柜率_离柜率查询.setQd_渠道_varchar_6(e.getKey());

            h5_1离柜率_离柜率查询.setWtchdjybs_对冲签约笔数_Int(e.getValue().stream().filter(x->{
                return 冲还贷_核心(null).contains(x.getLastname());
            }).mapToInt(x->x.getCc().intValue()).sum());


            h5_1离柜率_离柜率查询.setWtdkbs_贷款笔数_Int(e.getValue().stream().filter(x->{
                return 信息变更_核心(null).contains(x.getLastname());
            }).mapToInt(x->x.getCc().intValue()).sum());
            h5_1离柜率_离柜率查询.setWthdbs_核定笔数_Int(e.getValue().stream().filter(x->{
                return 信息变更_核心(null).contains(x.getLastname());
            }).mapToInt(x->x.getCc().intValue()).sum());
            h5_1离柜率_离柜率查询.setWtztbgbs_账户状态变更笔数_Int(e.getValue().stream().filter(x->{
                return 信息变更_核心(null).contains(x.getLastname());
            }).mapToInt(x->x.getCc().intValue()).sum());





            h5_1离柜率_离柜率查询.setWtjcjsbs_缴存基数笔数_Int(e.getValue().stream().filter(x->{
                return 缴存基数_核心(null).contains(x.getLastname());
            }).mapToInt(x->x.getCc().intValue()).sum());
            h5_1离柜率_离柜率查询.setWttqbs_提取笔数_Int(e.getValue().stream().filter(x->{
                return 提取_核心(null).contains(x.getLastname());
            }).mapToInt(x->x.getCc().intValue()).sum());

            h5_1离柜率_离柜率查询.setWttqhkbs_提前还款笔数_Int(e.getValue().stream().filter(x->{
                return 提取还款_提前还款(null).contains(x.getLastname());
            }).mapToInt(x->x.getCc().intValue()).sum());


            h5_1离柜率_离柜率查询.setWtxxbgbs_信息变更笔数_Int(e.getValue().stream().filter(x->{
                return 信息变更_核心(null).contains(x.getLastname());
            }).mapToInt(x->x.getCc().intValue()).sum());

            e.getValue().stream().filter(x->{
                return 信息变更_核心(null).contains(x.getLastname());
            }).mapToInt(x->x.getCc().intValue()).sum();


            h5_1离柜率_离柜率查询.setDklgl_贷款离柜率_Double(0d);
            h5_1离柜率_离柜率查询.setGzlgl_缴存离柜率_Double(0d);
            h5_1离柜率_离柜率查询.setZqlgl_提取离柜率_Double(0d);
            h5_1离柜率_离柜率查询.setLgl_离柜率_Double(0d);
            h5_1离柜率_离柜率查询.setZxlgl_中心离柜率_Double(0d);
            return h5_1离柜率_离柜率查询;

        }).collect(Collectors.toList());




*/
/*
        objects.stream().filter(e->{
            return 提取还款_提前还款(null).contains(e.getFirstname());
        }).collect(Collectors.groupingBy(e->e.getFirstname())).entrySet().stream().map(e->{
            ;
            return Pair.with(e.getKey(),e.getValue().stream().mapToLong(x->x.getCc()).sum());
        });

        objects.stream().filter(e->{
            return 提取_核心(null).contains(e.getFirstname());
        }).collect(Collectors.groupingBy(e->e.getFirstname())).entrySet().stream().map(e->{
            ;
            return Pair.with(e.getKey(),e.getValue().stream().mapToLong(x->x.getCc()).sum());
        });

        objects.stream().filter(e->{
            return 冲还贷_核心(null).contains(e.getFirstname());
        }).collect(Collectors.groupingBy(e->e.getFirstname())).entrySet().stream().map(e->{
            ;
            return Pair.with(e.getKey(),e.getValue().stream().mapToLong(x->x.getCc()).sum());
        });

        objects.stream().filter(e->{
            return 缴存基数_核心(null).contains(e.getFirstname());
        }).collect(Collectors.groupingBy(e->e.getFirstname())).entrySet().stream().map(e->{
            ;
            return Pair.with(e.getKey(),e.getValue().stream().mapToLong(x->x.getCc()).sum());
        });
        objects.stream().filter(e->{
            return 归集_核心(null).contains(e.getFirstname());
        }).collect(Collectors.groupingBy(e->e.getFirstname())).entrySet().stream().map(e->{
            ;
            return Pair.with(e.getKey(),e.getValue().stream().mapToLong(x->x.getCc()).sum());
        });

 *//*



    }
*/
















    public Output_totalcount H5_1离柜率_离柜率查询(QueryH_5_1离柜率_离柜率查询 query) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df);
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df);
        List<PB017_公共流水登记簿_Repository.PB017公共流水登记簿Dto> objects = pb017_公共流水登记簿_repository.findByChannel(ldt_ksrq,ldt_jsrq);
        //System.out.println("-----------"+objects.toString());
        objects.forEach(e->{
            System.out.println(e.getCc());
            System.out.println(e.getAccinstcode());
            System.out.println(e.getTranschannel());
            System.out.println(e.getDesciption());
        });



        Output_totalcount output = new Output_totalcount();


 ;

        output.setData(objects.stream()
                .collect(Collectors.groupingBy(e->e.getAccinstcode()))
                .entrySet()
                .stream().map(f->{

                    return f.getValue().stream().collect(Collectors.groupingBy(e->e.getTranschannel())).entrySet()
                            .stream().map(e->{
                                H5_1离柜率_离柜率查询 h5_1离柜率_离柜率查询 = new H5_1离柜率_离柜率查询();
                                h5_1离柜率_离柜率查询.setJgbm_管理机构编码_String(Constants.zjbzxbm_住建部中心编码);
                                h5_1离柜率_离柜率查询.setJgmc_管理机构_String(pb007_机构信息表Map().get(f.getKey()).getInstName());

                                h5_1离柜率_离柜率查询.setKsrq_汇总日期_date(ldt_jsrq.toString());

                                h5_1离柜率_离柜率查询.setQd_渠道_varchar_6(E_渠道_核心_调整_HX.fromOld(e.getKey()).get名称());

                                h5_1离柜率_离柜率查询.setWtchdjybs_对冲签约笔数_Int(e.getValue().stream().filter(x->{
                                    return 冲还贷_核心(null).contains(x.getTranschannel());
                                }).mapToInt(x->x.getCc().intValue()).sum());
                                h5_1离柜率_离柜率查询.setGtchdjybs_对冲签约笔数_Int(0);

                                h5_1离柜率_离柜率查询.setWtdkbs_贷款笔数_Int(e.getValue().stream().filter(x->{
                                    return 信息变更_核心(null).contains(x.getTranschannel());
                                }).mapToInt(x->x.getCc().intValue()).sum());
                                h5_1离柜率_离柜率查询.setGtdkbs_贷款笔数_Int(0);

                                h5_1离柜率_离柜率查询.setWthdbs_核定笔数_Int(e.getValue().stream().filter(x->{
                                    return 信息变更_核心(null).contains(x.getTranschannel());
                                }).mapToInt(x->x.getCc().intValue()).sum());
                                h5_1离柜率_离柜率查询.setGthdbs_柜台核定笔数_Int(0);

                                h5_1离柜率_离柜率查询.setWtztbgbs_账户状态变更笔数_Int(e.getValue().stream().filter(x->{
                                    return 信息变更_核心(null).contains(x.getTranschannel());
                                }).mapToInt(x->x.getCc().intValue()).sum());
                                h5_1离柜率_离柜率查询.setGtztbgbs_账户状态变更笔数_Int(0);




                                h5_1离柜率_离柜率查询.setWtjcjsbs_缴存基数笔数_Int(e.getValue().stream().filter(x->{
                                    return 缴存基数_核心(null).contains(x.getTranschannel());
                                }).mapToInt(x->x.getCc().intValue()).sum());
                                h5_1离柜率_离柜率查询.setGtjcjsbs_缴存基数笔数_Int(0);

                                h5_1离柜率_离柜率查询.setWttqbs_提取笔数_Int(e.getValue().stream().filter(x->{
                                    return 提取_核心(null).contains(x.getTranschannel());
                                }).mapToInt(x->x.getCc().intValue()).sum());
                                h5_1离柜率_离柜率查询.setGttqbs_提取笔数_Int(0);

                                h5_1离柜率_离柜率查询.setWttqhkbs_提前还款笔数_Int(e.getValue().stream().filter(x->{
                                    return 提取还款_提前还款(null).contains(x.getTranschannel());
                                }).mapToInt(x->x.getCc().intValue()).sum());
                                h5_1离柜率_离柜率查询.setGttqhkbs_提前还款笔数_Int(0);

                                h5_1离柜率_离柜率查询.setWtxxbgbs_信息变更笔数_Int(e.getValue().stream().filter(x->{
                                    return 信息变更_核心(null).contains(x.getTranschannel());
                                }).mapToInt(x->x.getCc().intValue()).sum());
                                h5_1离柜率_离柜率查询.setGtxxbgbs_信息变更笔数_Int(0);


                                e.getValue().stream().filter(x->{
                                    return 信息变更_核心(null).contains(x.getTranschannel());
                                }).mapToInt(x->x.getCc().intValue()).sum();
                                h5_1离柜率_离柜率查询.setGtxxbgbs_信息变更笔数_Int(0);

                                h5_1离柜率_离柜率查询.setDklgl_贷款离柜率_Double(0d);
                                h5_1离柜率_离柜率查询.setGzlgl_缴存离柜率_Double(0d);
                                h5_1离柜率_离柜率查询.setZqlgl_提取离柜率_Double(0d);
                                h5_1离柜率_离柜率查询.setLgl_离柜率_Double(0d);
                                h5_1离柜率_离柜率查询.setZxlgl_中心离柜率_Double(0d);
                                return h5_1离柜率_离柜率查询;

                            }).collect(Collectors.toList());


                }).flatMap(s->s.stream()).collect(Collectors.toList()));

            ;


        output.setTotalcount(output.getData().size());
        output.setSuccess(true);
        return output;
    }
        public Output H5_1离柜率_离柜率查询_backup(QueryH_5_1离柜率_离柜率查询 query) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df);



        H5_1离柜率_离柜率查询 h5_1离柜率_离柜率查询 = new H5_1离柜率_离柜率查询();







/*
        private String jgbm_管理机构编码_String;
        private String jgmc_管理机构_String;
        private String ksrq_汇总日期_date;
        private String qd_渠道_varchar_6;
        private double lgl_离柜率_Double;
        private int wthdbs_核定笔数_Int;
        private double zxlgl_中心离柜率_Double;
        private int wtztbgbs_账户状态变更笔数_Int;
*/

/*
        private int wthdbs_核定笔数_Int;
        HX__118001_汇缴登记_dp_10111000("118001","汇缴登记","dp","10111000"),
                HX__118002_预缴登记_dp_10111000("118002","预缴登记","dp","10111000"),
                HX__118003_补缴登记_dp_10111000("118003","补缴登记","dp","10111000"),

*/






                // private int wtxxbgbs_信息变更笔数_Int;
        h5_1离柜率_离柜率查询.setWtxxbgbs_信息变更笔数_Int(信息变更(ldt_jsrq).intValue());


       // E_5876_个人账户冻结和解冻("5876","个人账户冻结和解冻"),

       // private int wtjcjsbs_缴存基数笔数_Int;



        h5_1离柜率_离柜率查询.setWtjcjsbs_缴存基数笔数_Int(缴存基数(ldt_jsrq).intValue());




       // private int wttqhkbs_提前还款笔数_Int;
        //private int wtchdjybs_对冲签约笔数_Int;






        h5_1离柜率_离柜率查询.setWttqhkbs_提前还款笔数_Int(提取还款(ldt_jsrq).intValue());
        h5_1离柜率_离柜率查询.setWtchdjybs_对冲签约笔数_Int(冲还贷(ldt_jsrq).intValue());


       // private double gzlgl_缴存离柜率_Double;
        //private double dklgl_贷款离柜率_Double;
        //private double zqlgl_提取离柜率_Double;




        List<DW025_公积金提取审核登记表> dw025_公积金提取审核登记表s = dW025__公积金提取审核登记表_Repository.findByTransdate交易日期Between(ldt_jsrq,ldt_ksrq);
        h5_1离柜率_离柜率查询.setWttqbs_提取笔数_Int(dw025_公积金提取审核登记表s.size());
        h5_1离柜率_离柜率查询.setZqlgl_提取离柜率_Double(提取(ldt_jsrq)/dw025_公积金提取审核登记表s.size());




        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByRegdate登记日期Between(ldt_jsrq,ldt_ksrq);

       // h5_1离柜率_离柜率查询.setGzlgl_缴存离柜率_Double(dp022_个人缴存登记簿s.size());
        h5_1离柜率_离柜率查询.setGzlgl_缴存离柜率_Double(归集(ldt_ksrq)/dp022_个人缴存登记簿s.size());



        List<DP202_单位缴存变更登记簿> dp202_单位缴存变更登记簿s =dp202_单位缴存变更登记簿_repository.findByTransdate不可为空交易日期Between(ldt_jsrq,ldt_ksrq);
        List<DP204_个人缴存变更登记簿> dp204_个人缴存变更登记簿s = dp204_个人缴存变更登记簿_repository.findByTransdate不可为空交易日期Between(ldt_jsrq,ldt_ksrq);
        h5_1离柜率_离柜率查询.setWtxxbgbs_信息变更笔数_Int(dp204_个人缴存变更登记簿s.size()+dp202_单位缴存变更登记簿s.size());



        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h5_1离柜率_离柜率查询);
        output.setData(a);
        return output;
    }







    public DoubleSummaryStatistics 贷款(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s =null;// dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(query.getKsrq(),query.getJsrq());
        return dp021_单位缴存登记簿s.stream().filter(e->e.getInaccstate_入账状态().equals(H单位公积金缴存登记簿_入账状态.入账.getText()))
                .collect(summarizingDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()));

    }



    public DoubleSummaryStatistics 归集(QueryH_4_1_业务统计_获取各渠道业务统计数据 query) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = null;// dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(query.getKsrq(),query.getJsrq());
        return dp021_单位缴存登记簿s.stream().filter(e->e.getInaccstate_入账状态().equals(H单位公积金缴存登记簿_入账状态.入账.getText()))
                .collect(summarizingDouble(e->e.getFactpayamt_实际缴款金额().doubleValue()));

    }
















    public Long 缴存基数(LocalDate localDate) {
        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();
        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5813_缴存基数调整
        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).count();
    }

    public Long 信息变更(LocalDate localDate) {
        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();
        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5857_职工信息变更,
                E_业务类型_综服_HX.E_5867_单位缴存登记信息变更
        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).count();
    }



    public Long 提取(LocalDate localDate) {
        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();
        List<String> 业务s = Arrays.asList(E_业务类型_综服_HX.E_5367_物业费提取,
                E_业务类型_综服_HX.E_5368_偿还公积金贷款提取,
                E_业务类型_综服_HX.E_5372_租房提取,
                E_业务类型_综服_HX.E_5373_其他住房消费类提取,
                E_业务类型_综服_HX.E_5391_住宅专项维修基金提取,
                E_业务类型_综服_HX.E_5392_贷款首付提取,
                E_业务类型_综服_HX.E_5393_偿还商业贷提取
        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).count();
    }






    public Long 贷款(LocalDate localDate) {


        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(E_业务类型_综服_HX.E_5367_物业费提取,
                E_业务类型_综服_HX.E_5378_签订贷款业务网上办理协议,
                E_业务类型_综服_HX.E_5361_贷款还款,


                E_业务类型_综服_HX.E_5879_贷款审核,
                E_业务类型_综服_HX.E_5880_合同签约,
                E_业务类型_综服_HX.E_5881_担保落实,

                E_业务类型_综服_HX.E_5882_贷款审批,
                E_业务类型_综服_HX.E_5883_贷款发放


        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).count();



    }


    public Long 提取还款(LocalDate localDate) {


        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5887_提前还款


        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).count();



    }


    public Long 冲还贷(LocalDate localDate) {
        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5368_偿还公积金贷款提取

        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).count();

    }

    public List<String> 冲还贷_核心(LocalDate localDate) {
     //   List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5368_偿还公积金贷款提取

        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return 业务s;

    }
    public  List<String> 归集_核心(LocalDate localDate) {
        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5875_灵活就业人员缴存,
                E_业务类型_综服_HX.E_5351_缴存预约,
                E_业务类型_综服_HX.E_5486_预缴入账,
                E_业务类型_综服_HX.E_5487_补缴入账,
                E_业务类型_综服_HX.E_5858_单位暂存款登记,
                E_业务类型_综服_HX.E_5859_单位缴存入账


        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return 业务s;

    }
    public List<String> 提取还款_提前还款(LocalDate localDate) {

        List<String> 业务s = Arrays.asList(
                E_交易码_HX.HX__120805_提前还款登记撤销_ln_10011000


        ).stream().map(e->e.getPF03TRANCODE()).collect(Collectors.toList());
        return 业务s;



    }
    public List<String> 提取_核心(LocalDate localDate) {
        List<String> 业务s = Arrays.asList(E_业务类型_综服_HX.E_5367_物业费提取,
                E_业务类型_综服_HX.E_5368_偿还公积金贷款提取,
                E_业务类型_综服_HX.E_5372_租房提取,
                E_业务类型_综服_HX.E_5373_其他住房消费类提取,
                E_业务类型_综服_HX.E_5391_住宅专项维修基金提取,
                E_业务类型_综服_HX.E_5392_贷款首付提取,
                E_业务类型_综服_HX.E_5393_偿还商业贷提取
        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return 业务s;
    }
    public List<String> 信息变更_核心(LocalDate localDate) {

        List<String> 业务s = Arrays.asList(

                E_交易码_HX.HX__122030_借款人基本信息变更_ln_10000000,
                E_交易码_HX.HX__160006_变更单位全部基本资料_cm_10111000,
                E_交易码_HX.HX__160011_变更单位常用基本资料_cm_10111000,
                E_交易码_HX.HX__160015_变更个人基本资料_cm_10111000,
                E_交易码_HX.HX__160115_网厅个人基本资料变更_cm_10000000,
                E_交易码_HX.HX__168010_网厅单位基本资料变更_cm_10111000,
                E_交易码_HX.HX__168110_新网厅单位资料变更_cm_10000000,
                E_交易码_HX.HX__430006_个人查询密码变更_qr_10111000,
                E_交易码_HX.HX__430010_单位查询密码变更_qr_10111000,
                E_交易码_HX.HX__430207_查询机单位密码变更_qr_10000000,
                E_交易码_HX.HX__110069_网厅缴存基数变更_dp_10100000,
                E_交易码_HX.HX__111020_个人基数变更_dp_10111000,
                E_交易码_HX.HX__111036_自由职业者协议变更_dp_10111000,
                E_交易码_HX.HX__111039_军转干部协议变更_dp_10111000,
                E_交易码_HX.HX__115022_网厅单位比例变更_dp_10000000,
                E_交易码_HX.HX__111041_委托收款合同变更_dp_10111000,
                E_交易码_HX.HX__116002_灵活就业人员缴存基数变更_dp_11111000,
                E_交易码_HX.HX__116003_灵活就业人员缴存比例变更_dp_11111000,

                E_交易码_HX.HX__120100_抵押人变更_ln_10000000,
                E_交易码_HX.HX__120101_抵押物变更_ln_10000000,

                E_交易码_HX.HX__120108_质押人变更_ln_10100000,
                E_交易码_HX.HX__120109_质押物变更_ln_10000000,
                E_交易码_HX.HX__120149_借款人变更_ln_10111000,
                E_交易码_HX.HX__120153_还款方式变更_ln_10111000,


                E_交易码_HX.HX__121401_担保方式变更_ln_10111000,
                E_交易码_HX.HX__121501_公积金担保变更_ln_10111000,
                E_交易码_HX.HX__121502_保人关系变更_ln_10000000,
                E_交易码_HX.HX__121023_开发商保证金开户银行信息变更_ln_10111000,
                E_交易码_HX.HX__122030_借款人基本信息变更_ln_10000000,
                E_交易码_HX.HX__120385_贷后信息变更查询_ln_10011000



        ).stream().map(e->e.getPF03TRANCODE()).collect(Collectors.toList());



        return 业务s;
    }
    public List<String> 缴存基数_核心(LocalDate localDate) {

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5813_缴存基数调整
        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return 业务s;
    }


    public Long 归集(LocalDate localDate) {
        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5875_灵活就业人员缴存,
                E_业务类型_综服_HX.E_5351_缴存预约,
                E_业务类型_综服_HX.E_5486_预缴入账,
                E_业务类型_综服_HX.E_5487_补缴入账,
                E_业务类型_综服_HX.E_5858_单位暂存款登记,
                E_业务类型_综服_HX.E_5859_单位缴存入账


        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        return mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).count();

    }


}
