package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_zongfu.Mi107_业务日志;
import org.ylgjj.loan.enumT.H单位公积金缴存登记簿_入账状态;
import org.ylgjj.loan.output.H5_1离柜率_离柜率查询;
import org.ylgjj.loan.outputenum.E_业务类型_综服_HX;
import org.ylgjj.loan.pojo.QueryH_4_1_业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.pojo.QueryH_5_1离柜率_离柜率查询;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_zhongfu.Mi107_业务日志_Repository;

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
public class H5离柜率ServiceImpl {

    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;


    @Autowired
    private PB010_bank_info_大行信息表Repository pb010_bank_info_大行信息表Repository;

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

    public Output H5_1离柜率_离柜率查询(QueryH_5_1离柜率_离柜率查询 query) {


        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df);



        H5_1离柜率_离柜率查询 h5_1离柜率_离柜率查询 = new H5_1离柜率_离柜率查询();




/*        h4_1业务统计_获取各渠道业务统计数据.setGjbs_归集_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setGjje_归集金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setGjzb_归集占比_Double(1.0D);

        h4_1业务统计_获取各渠道业务统计数据.setDkbs_贷款笔数_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setDkje_贷款金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setDkzb_贷款占比_Double(1.0D);

        h4_1业务统计_获取各渠道业务统计数据.setTqbs_提取笔数_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setTqje_提取金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setTqzb_提取占比_Double(1.0D);


        h4_1业务统计_获取各渠道业务统计数据.setTqbs_提取笔数_Int(Long.valueOf(归集.getCount()).intValue());
        h4_1业务统计_获取各渠道业务统计数据.setTqje_提取金额_Double(归集.getSum());
        h4_1业务统计_获取各渠道业务统计数据.setTqzb_提取占比_Double(1.0D);*/





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
