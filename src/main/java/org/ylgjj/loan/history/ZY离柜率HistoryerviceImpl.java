package org.ylgjj.loan.history;


import org.javatuples.Quartet;
import org.javatuples.Sextet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_zongfu.Mi107_业务日志;
import org.ylgjj.loan.enumT.LoaneeTypeEnum;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.outputenum.E_业务类型_综服_HX;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.repository_zhongfu.Mi107_业务日志_Repository;
import org.ylgjj.loan.util.DateUtilsss;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ZY离柜率HistoryerviceImpl")
public class ZY离柜率HistoryerviceImpl {


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
    private Mi107_业务日志_Repository mi107_业务日志_repository;


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;




    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    private LN005_贷款分户信息_Repository lN005_贷款分户信息RepositoryLN005;
    @Autowired
    private LN004_合同状态信息Repository ln004_合同状态信息Repository;


    @Autowired
    private LoanHistoryRepository loanHistoryRepository;



    boolean initComplte = false;
    List<LN003_合同信息> ln003__合同信息s = null;
    Map<String, LN005_贷款分户信息> ln005_lone_sub_account_贷款分户信息Map = null;
    Map<String, LN014_贷款房屋信息> ln0014_trading_house_贷款房屋信息Map = null;
    Map<String,List<LN008_借款人信息>> ln008_borrower_info_借款人信息Map = null;




    //TODO 历史倒推
    // TODO S_140_SEQ_贷款余额_AND_0302000801
    public void 历史倒推_某一日的贷款(LocalDate n) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(!initComplte){
            ln003__合同信息s = ln003_合同信息_repository.findAll();
            List<LN005_贷款分户信息> ln005__贷款分户信息s = lN005_贷款分户信息RepositoryLN005.findAll().stream().filter(bb->bb.getLoanacctype_贷款分户类型().equals("01")).collect(Collectors.toList());
            ln005_lone_sub_account_贷款分户信息Map = ln005__贷款分户信息s.stream().collect(Collectors.toMap(e->e.getLoancontrcode合同代码(), e->e));

            ln0014_trading_house_贷款房屋信息Map = ln014__贷款房屋信息Repository.findAll().stream().collect(Collectors.toMap(e->e.getLoancontrcode0合同代码(), e->e));

            ln008_borrower_info_借款人信息Map = lN008_借款人类型Repository.findAll().stream().filter(e->e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText()))
                    .collect(Collectors.groupingBy(e->e.getLoancontrcode合同代码()));
            initComplte= true;
        }








        LoanHistory loanHistory_ = new LoanHistory(n,StatisticalIndexCodeEnum.S_240_SEQ_共同借款人人数_AND_0302040003);






         Double a = ln004_合同状态信息Repository.findAll().stream().map(e-> {

            //TODO        获得某一日的贷款余额;
            List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(n);
            Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();

            List<LN006_贷款分期还款计划> ln006__贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByLoancontrcode0合同代码(e.getLoancontrcode());


            if(ln101_贷款明细账_account.isPresent()){
                return Sextet.with(e,
                        ln005_lone_sub_account_贷款分户信息Map.get(e.getLoancontrcode()),
                        ln0014_trading_house_贷款房屋信息Map.get(e.getLoancontrcode()),
                        ln008_borrower_info_借款人信息Map.get(e.getLoancontrcode()),
                        ln101_贷款明细账_s, ln006__贷款分期还款计划s);
            }else{
                return null;
            }
        }).collect(Collectors.toList()).stream().filter(ee->ee!= null)
                .collect(Collectors.groupingBy(e->e.getValue0().getLoancontrcode())).entrySet().stream()

                 .filter(x->x.getValue().stream().filter(f->f.getValue0().getTransdate().equals(n)).count()>0)
                 .mapToDouble(x->x.getValue().get(0).getValue2().getHousetype_0_房屋类型().length()).max().getAsDouble();


        loanHistory_.setDoubleValue(a);  //
        loanHistoryRepository.save(loanHistory_);
















        a = ln004_合同状态信息Repository.findAll().stream().map(e-> {

            //TODO        获得某一日的贷款余额;
            List<LN101_贷款明细账> ln101_贷款明细账_s = ln101_贷款明细账_repository.findByTransdate不可为空交易日期(n);
            Optional<LN101_贷款明细账> ln101_贷款明细账_account = ln101_贷款明细账_s.stream().findFirst();

            List<LN006_贷款分期还款计划> ln006__贷款分期还款计划s = ln006_贷款分期还款计划Repository.findByLoancontrcode0合同代码(e.getLoancontrcode());


            if(ln101_贷款明细账_account.isPresent()){
                return Sextet.with(e,
                        ln005_lone_sub_account_贷款分户信息Map.get(e.getLoancontrcode()),
                        ln0014_trading_house_贷款房屋信息Map.get(e.getLoancontrcode()),
                        ln008_borrower_info_借款人信息Map.get(e.getLoancontrcode()),
                        ln101_贷款明细账_s, ln006__贷款分期还款计划s);
            }else{
                return null;
            }
        }).collect(Collectors.toList()).stream().filter(ee->ee!= null)
                .collect(Collectors.groupingBy(e->e.getValue0().getLoancontrcode())).entrySet().stream()

                .filter(x->x.getValue().stream().filter(f->f.getValue0().getTransdate().equals(n)).count()>0)
                .mapToDouble(x->x.getValue().get(0).getValue2().getHousetype_0_房屋类型().length()).max().getAsDouble();


        loanHistory_.setDoubleValue(a);  //
        loanHistoryRepository.save(loanHistory_);
    }

















    //TODO 存储统计信息
    public void saveHistorySpan(LocalDate ldt_ksrq,LocalDate js) {
        LocalDate year_before = ldt_ksrq.minusDays(5);
        long num = DateUtilsss.until(ldt_ksrq,year_before);

        List<Map<String, Map<String,List<Quartet<String,String,Integer,Double>>>>> list = new ArrayList();

        for(int i=0; i<=abs(num); i++) {
            LocalDate n = ldt_ksrq.minusDays(i);

          历史倒推_某一日的贷款(n);
        }
    }




    public void run() {
        saveHistorySpan(LocalDate.now(),null);
    }



















    private int gtjcjsbs_柜台缴存基数变更笔数_NUMBER_18_0;
    private int wtjcjsbs_网上缴存基数变更笔数_NUMBER_18_0;
    //E_5813_缴存基数调整;
    //TODO ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？获取当前的一个状态
    public void saveHistoryOneTime(LocalDate localDate) {


        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();



    }






    //？？？？？？？？？
    private int gthdbs_柜台核定笔数_NUMBER_18_0;
    private int wthdbs_网上核定笔数_NUMBER_18_0;
    private int gtxxbgbs_柜台信息变更笔数_NUMBER_18_0;
    private int wtxxbgbs_网上信息变更笔数_NUMBER_18_0;
    private int gtztbgbs_柜台状态变更笔数_NUMBER_18_0;
    private int wtztbgbs_网上状态变更笔数_NUMBER_18_0;













    private int gttqbs_柜台提取笔数_NUMBER_18_0;
    private int wttqbs_网上提取笔数_NUMBER_18_0;


    public void 提取(LocalDate localDate) {


        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(E_业务类型_综服_HX.E_5367_物业费提取,
                E_业务类型_综服_HX.E_5368_偿还公积金贷款提取,
                E_业务类型_综服_HX.E_5372_租房提取,
                E_业务类型_综服_HX.E_5373_其他住房消费类提取,
                E_业务类型_综服_HX.E_5391_住宅专项维修基金提取,
                E_业务类型_综服_HX.E_5392_贷款首付提取,
                E_业务类型_综服_HX.E_5393_偿还商业贷提取
                ).stream().map(e->e.get编码()).collect(Collectors.toList());
        mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).collect(Collectors.toList());

    }








    private int gtdkbs_柜台贷款笔数_NUMBER_18_0;
    private int wtdkbs_网上贷款笔数_NUMBER_18_0;





    public void 贷款(LocalDate localDate) {


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
        mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).collect(Collectors.toList());



    }




    private int gttqhkbs_柜台提前还款笔数_NUMBER_18_0;
    private int wttqhkbs_网上提取还款笔数_NUMBER_18_0;


    public void 提取还款(LocalDate localDate) {


        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5887_提前还款


        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).collect(Collectors.toList());



    }

    @Autowired
    private LN007_委托代扣协议信息Repository ln007_委托代扣协议信息Repository;


    private int gtchdjybs_柜台冲还贷笔数_NUMBER_18_0;
    private int wtchdjybs_网厅冲还贷总笔数_NUMBER_18_0;

    public void 冲还贷(LocalDate localDate) {
        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5368_偿还公积金贷款提取

        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).collect(Collectors.toList());

    }








    private int gjzbs_归集总笔数_NUMBER_18_0;
    private int wtgjzbs_网厅归集总笔数_NUMBER_18_0;

    public void 归集(LocalDate localDate) {
        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        List<String> 业务s = Arrays.asList(
                E_业务类型_综服_HX.E_5875_灵活就业人员缴存,
                E_业务类型_综服_HX.E_5351_缴存预约,
                E_业务类型_综服_HX.E_5486_预缴入账,
                E_业务类型_综服_HX.E_5487_补缴入账,
                E_业务类型_综服_HX.E_5858_单位暂存款登记,
                E_业务类型_综服_HX.E_5859_单位缴存入账


        ).stream().map(e->e.get编码()).collect(Collectors.toList());
        mi107_业务日志s.stream().filter(e->业务s.contains(e.getTranstype())).collect(Collectors.toList());

    }







    private int tqzbs_提取总笔数_NUMBER_18_0;
    private int wttqzbs_网厅提取总笔数_NUMBER_18_0;
    private int dkzbs_贷款总笔数_NUMBER_18_0;
    private int wtdkzbs_网厅贷款总笔数_NUMBER_18_0;



    private double tqlgl_提取离柜率_NUMBER_18_2;
    private double gjlgl_归集离柜率_NUMBER_18_2;
    private double dklgl_贷款离柜率_NUMBER_18_2;
    private double zxlgl_中心离柜率_NUMBER_18_2;
}
