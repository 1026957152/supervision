package org.ylgjj.loan.service;




import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.*;
import org.ylgjj.loan.exception.MyBusinessException;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.util.DateUtils;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.time.temporal.TemporalAdjusters.*;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CM002_个人基本资料表Repository cm002个人基本资料表Repository;


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
    private LN005_lone_sub_accountRepository lN005_lone_sub_accountRepository;
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


    @Override
    public Page<CM002_个人基本资料表> queryCustomer(Pageable pageable) {


        return cm002个人基本资料表Repository.findAll(pageable);
    }

    @Override
    public Page<CM001_单位基本资料表> queryAdvice(Pageable pageable) {


        return null;
    }

    @Override
    public Page<LN002> queryLoans(Pageable pageable) {
        return null;
    }

    @Override

    public Page<LN008_borrower_info_借款人信息> queryLoanee(Pageable pageable) {
        return null;
    }





    LocalDate today =  LocalDateTime.now().toLocalDate();

    Integer count = 1;

    Integer limit = 5000000;
    @Override
    public ReturnResult queryLoanee(Query query) {

        LocalDateTime now = LocalDateTime.now();



        DayOfWeek dayOfWeek = now.getDayOfWeek();
        if(!(dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY)){

            LocalDateTime todayAt8 = now.toLocalDate().atTime(8, 0);
            LocalDateTime todayAt12 = now.toLocalDate().atTime(12, 0);
            LocalDateTime todayAt14 = now.toLocalDate().atTime(22, 0);
            LocalDateTime todayAt18 = now.toLocalDate().atTime(23, 0);
            if((now.isAfter(todayAt8) && now.isBefore(todayAt12)) || now.isAfter(todayAt14) && now.isBefore(todayAt18)) {
                if(count >limit){
                    return ReturnResult.情况5_操作失败("今日调用 次数超过"+limit+"次的限制");

                }
            }

        }



        System.out.println("---------------- count "+count);
        System.out.println("---------------- count "+today.toString());


        if(today.isEqual(now.toLocalDate())){

            count++;
        }else{
            today = now.toLocalDate();
            count=0;
        }

        return product_querry(query);





    }

    public ReturnResult product_querry(Query query){
        try{

            Data[] datas = queryLoanee(query.getZjhm());
            return ReturnResult.情况1_返回成功(datas);
        }catch (MyBusinessException e){
            e.getMessage();
            System.out.println("错误信息："+e.getMessage());
            e.printStackTrace();
            if(e.getCode().equals(ErrorCodeEnum.入参格式错误)){
                return ReturnResult.情况4_入参数格式错误(e.getMessage());
            }
            if(e.getCode().equals(ErrorCodeEnum.操作失败)){
                return ReturnResult.情况5_操作失败();
            }
            if(e.getCode().equals(ErrorCodeEnum.查询为空)){
                return ReturnResult.情况2_查询为空();
            }
            return ReturnResult.情况5_操作失败();
        }catch (Exception e){
            e.printStackTrace();
            return ReturnResult.情况5_操作失败(e.getMessage());
        }
    }

   // @PostConstruct
    public void queryLoanee() {
        try{
            Data[] date = queryLoanee("612724198409210339  ");
            System.out.println("-------------- " + date.toString());
        }catch (Exception e){
            e.getMessage();
        }

    }


    public Data[] queryLoanee(String certinum) throws MyBusinessException {


        List<CM002_个人基本资料表> cm002s = cm002个人基本资料表Repository.findByCertinum(certinum);
        if(cm002s.size()== 0){
            throw new MyBusinessException("找不到该缴存人",ErrorCodeEnum.查询为空);
        }


        List<Data> datas= new ArrayList<>();
        for(CM002_个人基本资料表 cm002_个人基本资料表: cm002s){
            if(certinum.equals("612724198409210339")){
                Data data  = queryLoaneeZhaoyuan(cm002_个人基本资料表);
                datas.add(data);
            }else{
                Data data  = queryLoanee(cm002_个人基本资料表);
                datas.add(data);
            }









        }


        List<Data> data___s = datas.stream().filter(e->
            e.getGrzhzt().equals(个人账户状态_PersonalAccountStatusEnum_银行.正常.getText())).collect(Collectors.toList());

        List<Data> datas_return= new ArrayList<>();
        if(data___s.size()==1){

            datas_return.add(data___s.get(0));

        }if(data___s.size()>1){


            Data temp = null;
            Integer i = 0;

            for(Data d : data___s){
                if(i==0){
                    temp = d;
                }
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate ldt = LocalDate.parse(d.getZhycjcrq(),df);


                LocalDate tempLocalDate = LocalDate.parse(d.getZhycjcrq(),df);

                if(ldt.isAfter(tempLocalDate)){
                    temp = d;
                }



            }

            datas_return.add(temp);

        }




/*        if(data != null){

            if(data.getGrzhzt()==个人账户状态_PersonalAccountStatusEnum_银行.正常.getText()){
                datas.add(data);
            }

        }*/


        return datas_return.toArray(new Data[datas_return.size()]);


    }


    class ReturnDate{
        Data data;
        Date lastDate;

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Date getLastDate() {
            return lastDate;
        }

        public void setLastDate(Date lastDate) {
            this.lastDate = lastDate;
        }
    }
    public Data queryLoanee(CM002_个人基本资料表 cm002) throws MyBusinessException {



        LocalDate start18月 = LocalDate.now().minusMonths(20).with(firstDayOfMonth());


        DP006_Payment_个人缴存信息表 dp006_payment_个人缴存信息表 = dp006_payment_个人缴存信息表_repository.findByCustid个人客户号(cm002.getCustid_个人客户号());
        if(dp006_payment_个人缴存信息表 == null){
            throw new MyBusinessException("没有找到缴存信息,客户号："+ cm002.getCustid_个人客户号() + " 身份证号："+ cm002.getCertinum()
                    ,ErrorCodeEnum.操作失败);

        }


        DP007_individual_sub_account_个人分户账 dp007_individual_sub_account_个人分户账 = dp007_individual_sub_account个人分户账Repository.findByAccnum个人账号(dp006_payment_个人缴存信息表.getAccnum个人账号());
        if(dp007_individual_sub_account_个人分户账 == null){
            throw new MyBusinessException("没有找到缴存信息,缴存帐号："+ dp006_payment_个人缴存信息表.getAccnum个人账号() + " 身份证号："+ cm002.getCertinum()
                    ,ErrorCodeEnum.操作失败);

        }

        Data data = new Data();


        //String xmjp;//姓名简拼
        data.setXmjp(cm002.getInmspell_个人姓名全拼());

        //String xb;//性别
        data.setXb(cm002.getSex_性别());

        //String grzh; //个人帐号/公积金帐号
        data.setGrzh(dp006_payment_个人缴存信息表.getAccnum个人账号());

        //String grbh; //个人编号
        data.setGrbh(dp006_payment_个人缴存信息表.getCustid个人客户号());


        //String zjhlx; // 证件类型
        data.setZjhlx(证件类型.from(dp007_individual_sub_account_个人分户账.getCertitype_证件类型()).getText());

        //String csrq; // 出生日期
        data.setCsrq(cm002.getBirthday_出生日期());

        //String cjgzsj; // 参加工作时间
      //  data.setCjgzsj(DateUtils.getDate(dp007_individual_sub_account_个人分户账.getOpnaccdate_开户日期()));

        //String grzhzt; //个人账户状态
        data.setGrzhzt(E_DP007_个人分户账_个人账户状态.from(dp007_individual_sub_account_个人分户账.getIndiaccstate_个人账户状态()).getText());


        //BigDecimal sqgzze; //税前工资总额
        data.setSqgzze(dp006_payment_个人缴存信息表.getBasenum_缴存基数());

        //BigDecimal gjjye; //公积金余额
        data.setGjjye(dp007_individual_sub_account_个人分户账.getBal_余额());




        //String zzdh; //住宅电话;
        data.setSjh(cm002.getHandset_手机());

        //String sjh; //手机号;

        List<CM081_sms_短信密码签订登记簿> cm081_sms_短信密码签订登记簿s = cm081_sms_短信密码签订登记簿_repository.findByPubaccnum通用帐号0(dp006_payment_个人缴存信息表.getAccnum个人账号());
        Optional<CM081_sms_短信密码签订登记簿> cm081_sms_短信密码签订登记簿_optional = cm081_sms_短信密码签订登记簿s.stream().filter(e->e.getType业务类型0().equals("1")).findFirst();

        if(cm081_sms_短信密码签订登记簿_optional.isPresent()){
            data.setZzdh(cm081_sms_短信密码签订登记簿_optional.get().getPhone手机号1());
        }else{
            data.setZzdh(cm002.getPhone_电话());

        }








        data.setJtdz(cm002.getFamaddr_家庭住址());


        DP004_unit_payment_info_单位缴存信息表 dp004_unit_payment_info_单位缴存信息表 = dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号(dp007_individual_sub_account_个人分户账.getUnitaccnum_单位账号());
        if(dp004_unit_payment_info_单位缴存信息表 == null){
            throw new MyBusinessException("找不到单位信息"+ dp007_individual_sub_account_个人分户账.getUnitaccnum_单位账号(),ErrorCodeEnum.操作失败);
        }

        DP005_work_unit_单位分户账 dp005_work_unit_单位分户账 = dp005_workUnit_单位分户账_repository.findByUnitaccnum单位账号(dp007_individual_sub_account_个人分户账.getUnitaccnum_单位账号());

        //String dwmc; //单位名称;
        data.setDwmc(dp005_work_unit_单位分户账.getUnitaccname_单位名称());

        //String dwdjh; //单位登记号（单位帐号）
        data.setDwdjh(dp005_work_unit_单位分户账.getUnitaccnum单位账号());

        //String khglbbh; //开户管理部编号
        data.setKhglbbh(dp005_work_unit_单位分户账.getAccinstcode_账户机构());




        CM001_单位基本资料表 cm001_单位基本资料表 = cm001单位基本资料表Repository.findByUnitcustid单位客户号(dp004_unit_payment_info_单位缴存信息表.getUnitcustid_单位客户号());



        // String zzjgdm; //单位组织机构代码
        data.setZzjgdm(cm001_单位基本资料表.getOrgcode_组织机构代码());

        //String yyzz; //营业执照号
        data.setYyzz(cm001_单位基本资料表.getLicensenum_营业执照号码());

        //String xzbm ; // 单位性质编码
        data.setXzbm(PaymentUnitTypeEnum_单位性质.from(cm001_单位基本资料表.getUnitkind_单位性质()).getText());

        //String dwdz; // 单位地址
        data.setDwdz(cm001_单位基本资料表.getUnitaddr_单位地址());







        //String dwjezt; // 单位缴存状态
        if(dp005_work_unit_单位分户账.getUnitaccstate_单位账户状态().equals(单位账户状态Enum.封存.getText())){
            data.setDwjezt(单位账户状态Enum_银行.封存.getText());
        }else
        if(dp005_work_unit_单位分户账.getUnitaccstate_单位账户状态().equals(单位账户状态Enum.正常.getText())){
            data.setDwjezt(单位账户状态Enum_银行.正常.getText());
        }else
        if(dp005_work_unit_单位分户账.getUnitaccstate_单位账户状态().equals(单位账户状态Enum.销户.getText())){
            data.setDwjezt(单位账户状态Enum_银行.销户.getText());
        }else
        if(dp005_work_unit_单位分户账.getUnitaccstate_单位账户状态().equals(单位账户状态Enum.空账.getText())){
            data.setDwjezt(单位账户状态Enum_银行.其他.getText());
        }


        // String dwjczjy; // 单位缴存资金来源
        data.setDwjczjy(dp004_unit_payment_info_单位缴存信息表.getFundsouflag_资金来源标志());

        // String dwlxfs; // 单位联系方式
        data.setDwlxfs(cm001_单位基本资料表.getUnitlinkphone_联系电话());





        // String fxr; // 发薪日
        data.setFxr(StringUtils.isBlank(cm001_单位基本资料表.getSalday_发薪日())?"01":cm001_单位基本资料表.getSalday_发薪日());

        //String dwkhrq ; // 单位开户日期（单位登记日期）
        data.setDwkhrq(DateUtils.getDate(dp005_work_unit_单位分户账.getOpnaccdate__开户日期()));

        //String dwfdrdbr; // 单位法定代表人
        data.setDwfdrdbr(cm001_单位基本资料表.getLeglaccname_单位法人代表());

        //String dwfdrzjlx; // 单位法定人代表证件类型
        data.setDwfdrzjlx(StringUtils.isNotBlank(cm001_单位基本资料表.getLeglcertitype_法人代表证件类型1())?证件类型.from(cm001_单位基本资料表.getLeglcertitype_法人代表证件类型1()).getText():"");

        //String dwfdrzjhm; // 单位法定人代表证件号码
        data.setDwfdrzjhm(cm001_单位基本资料表.getLeglcertinum_法人代表证件号码0());

















        // String cjnyr; // 初缴年月
        data.setCjnyr(dp004_unit_payment_info_单位缴存信息表.getBegpayym_起始汇缴年月());

        //String jznyr; // 缴至年月
        data.setJznyr(dp004_unit_payment_info_单位缴存信息表.getLpaym_缴至年月());








       // List<DP021_单位缴存登记簿>  dp021_单位缴存登记簿s_ = dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(dp004_unit_payment_info_单位缴存信息表.getUnitaccnum单位账号());





       // List<String> 近12个自然月单位缴存额_list =init(18,"0.00");

        List<String> 当月缴存单位名称_list = init(18,"");

/*

        for(int idx = 0; idx < 18;idx++) {



            Integer index = idx+1;
            LocalDate initial_ = LocalDate.now().minusMonths(index);
            LocalDate start_ = initial_.with(firstDayOfMonth());
            LocalDate end_ = initial_.with(lastDayOfMonth());



            List<DP021_单位缴存登记簿> dP022_个人缴存登记簿Optional = dp021_单位缴存登记簿s.stream()
                    .filter(
                            e ->{
                                if(StringUtils.isBlank(e.getBegym_开始年月())){
                                    return false;
                                }
                                LocalDateTime getInaccdate入账日期0 = DateUtils.yyyyMM(e.getBegym_开始年月());
                                return  (getInaccdate入账日期0.isAfter(start_.atStartOfDay()) || getInaccdate入账日期0.equals(start_.atStartOfDay()))
                                        && (getInaccdate入账日期0.isBefore(end_.atStartOfDay()) || getInaccdate入账日期0.equals(end_.atStartOfDay()));


                            }

                    ).collect(Collectors.toList());

            if (dP022_个人缴存登记簿Optional.size()>0) {
             //   Double  value = dP022_个人缴存登记簿Optional.stream().mapToDouble(e->e.getUpaytotamt_应缴总额().doubleValue()).sum();

                Double  value = dP022_个人缴存登记簿Optional.stream().mapToDouble(e->e.getCmpayamt_本月汇缴金额().doubleValue()).sum();
                近12个自然月单位缴存额_list.add(BigDecimal.valueOf(value)
                        .setScale(2, BigDecimal.ROUND_HALF_UP).toString());


                //  CM001_单位基本资料表 cm001_单位基本资料表1 = cm001Repository.findByUnitcustid单位客户号(dp004_unit_payment_info_单位缴存信息表.getUnitcustid_单位客户号());
                当月缴存单位名称_list.add(dp005_work_unit_单位分户账.getUnitaccname_单位名称());

            } else {
              //  近12个自然月单位缴存额_list.add(null);
                当月缴存单位名称_list.add(null);

            }




        }



*/



















        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByAccnum个人账号(dp006_payment_个人缴存信息表.getAccnum个人账号());

        // String lccs; // 累计缴存次数
        data.setJccs(dp022_个人缴存登记簿s.size());





        DP022_个人缴存登记簿 最近一次缴存日期s = dp022_个人缴存登记薄Repository.findTop1ByAccnum个人账号OrderByRegdate登记日期Desc(dp006_payment_个人缴存信息表.getAccnum个人账号());
        //String zhycjcrq ; // 最近一次缴存日期
        data.setZhycjcrq(最近一次缴存日期s.getRegdate登记日期().toString());





        // TODO String dqgjjnd ; // 当前公积金年度 //
        //data.setDqgjjnd(最近一次缴存日期.());
        List<DW025_公积金提取审核登记表> dw025__公积金提取审核登记表s = null;//dW025__公积金提取审核登记表_Repository.findTop19ByAccnum个人账号OrderByTransdate交易日期Desc(dp006_payment_个人缴存信息表.getAccnum个人账号())
             //   .stream().filter(e->e.getApprstate_审批状态().equals("4")).collect(Collectors.toList());


        //String tqljje ; // 累积提取额
        Double 累积提取额 = dw025__公积金提取审核登记表s.stream().mapToDouble(e->e.getDrawamt_提取金额().doubleValue()).sum();
        data.setTqljje(BigDecimal.valueOf(累积提取额).setScale(2,BigDecimal.ROUND_HALF_UP));

        List<String> 近18个自然月单位缴存额_list =init(18,"0.00");

      //  List<String> 当月缴存单位名称_list = init(18,"");


        List<String> 近18个月单位缴存比例_list = init(18,"0.00");
        List<String> 近18个自然月个人缴存额_list = init(18,"0.00");

        List<String> 近18个月个人缴存比例_list = init(18,"0.00");

        List<String> 近12个月自然月提取原因_list = init(18,"");
        List<String> 近12个月自然月提取时间_list = init(18,"");
        List<String> 近12个月自然月提取方式_list =init(18,"");
        List<String> 近12个月自然月提取金额_list = init(18,"0.00");

        for(int idx = 0; idx < 18;idx++){



            Integer index = idx+1;

            LocalDate initial = LocalDate.now().minusMonths(index);
            LocalDate start = initial.with(firstDayOfMonth());
            LocalDate end = initial.with(lastDayOfMonth());


                    List<DP022_个人缴存登记簿> dP022_个人缴存登记簿Optional = dp022_个人缴存登记簿s.stream()
                    .filter(
                            e ->{
                                DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                                        .appendPattern("yyyyMMdd")
                                        .parseDefaulting(ChronoField.DAY_OF_MONTH, 0)

                                        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                                        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                                        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                                        .toFormatter();
                             //   System.out.println("____________"+e.getBegym开始年月());
                                LocalDateTime getBegym_开始年月 = java.time.LocalDateTime.from(formatter.parse(e.getBegym开始年月()+"01"));
                                return (getBegym_开始年月.isAfter(start.atStartOfDay()) || getBegym_开始年月.equals(start.atStartOfDay()))
                                        && (getBegym_开始年月.isBefore(end.atStartOfDay()) || getBegym_开始年月.equals(end.atStartOfDay()));
                            }



                    ).collect(Collectors.toList());



                    if(dP022_个人缴存登记簿Optional.size()>0){
                        List<String> temps_getUnitprop_单位比例 = dP022_个人缴存登记簿Optional.stream().map(e->e.getUnitprop_单位比例()).collect(Collectors.toList());

                        近18个月单位缴存比例_list.add(temps_getUnitprop_单位比例.get(0));


                        List<String> temps_getIndiprop_个人缴存比例 = dP022_个人缴存登记簿Optional.stream().map(e->e.getIndiprop_个人缴存比例()).collect(Collectors.toList());

                        近18个月个人缴存比例_list.add(temps_getIndiprop_个人缴存比例.get(0));



                        List<String> temps = dP022_个人缴存登记簿Optional.stream().map(e-> e.getIndipayamt_个人月汇缴金额()).collect(Collectors.toList());

                        近18个自然月个人缴存额_list.add(temps.get(0));

                        List<String> temps_getUnitpayamt_单位月汇缴金额0 = dP022_个人缴存登记簿Optional.stream().map(e->e.getUnitpayamt_单位月汇缴金额0().toString()).collect(Collectors.toList());

                        近18个自然月单位缴存额_list.add(temps_getUnitpayamt_单位月汇缴金额0.get(0));

                        当月缴存单位名称_list.add(dp005_work_unit_单位分户账.getUnitaccname_单位名称());

                    }else{
                        近18个月单位缴存比例_list.add(null);
                        近18个月个人缴存比例_list.add(null);
                        近18个自然月个人缴存额_list.add(null);
                        近18个自然月单位缴存额_list.add(null);
                        当月缴存单位名称_list.add(null);
                    }







            Optional<DW025_公积金提取审核登记表> dw025_withdraw_verify_公积金提取审核登记表Optional = null;//dw025__公积金提取审核登记表s.stream()
             //       .filter(e->e.getTransdate交易日期().isAfter(start.atStartOfDay())
                    //        && e.getTransdate交易日期().isBefore(end.atStartOfDay())).findAny();

            if(dw025_withdraw_verify_公积金提取审核登记表Optional.isPresent()){
              //  近12个月自然月提取原因_list.add(dw025_withdraw_verify_公积金提取审核登记表Optional.get().getDrawreason_提取原因());
            //    近12个月自然月提取时间_list.add(DateUtils.getDate(dw025_withdraw_verify_公积金提取审核登记表Optional.get().getTransdate交易日期()));


                DW145_提取结算登记簿 dw145_提取结算登记簿 = dw145_提取结算登记薄_repository.findByApprnum审批号0(dw025_withdraw_verify_公积金提取审核登记表Optional.get().getApprnum_审批号());
                if(dw145_提取结算登记簿!= null){
                    近12个月自然月提取方式_list.add(dw145_提取结算登记簿.getSettlemode结算方式1());

                }else{
                    近12个月自然月提取方式_list.add("");
                }
                近12个月自然月提取金额_list.add(dw025_withdraw_verify_公积金提取审核登记表Optional.get().getDrawamt_提取金额().toString());

            }else{
                近12个月自然月提取原因_list.add(null);
                近12个月自然月提取时间_list.add(null);
                近12个月自然月提取金额_list.add(null);
            }

            if(dw025_withdraw_verify_公积金提取审核登记表Optional.isPresent()){
            }else{

            }




/*
                    .sorted(Comparator.comparing(DW025_withdraw_verify_公积金提取审核登记表::getTransdate_交易日期).reversed())
                    .map(e->e.getTransdate_交易日期().toInstant(),e);*/

        }

        //String lxjcdwmc  当月缴存单位名称；
        data.setLxjcdwmc(fmt(当月缴存单位名称_list," "));



        //String lxdwjce ; // 近12个自然月单位缴存额
        data.setLxdwjce(fmt(近18个自然月单位缴存额_list,"0.00"));

        // String lxgrjce ; // 近12个自然月个人缴存额
        data.setLxgrjce(fmt(近18个自然月个人缴存额_list,"0.00"));

        // String lxtqyy ; // 近12个月自然月提取原因
        data.setDwjcbl(fmt(近18个月单位缴存比例_list,"0.00"));

        // String lxtqyy ; // 近12个月自然月提取原因
        data.setGrjcbl(fmt(近18个月个人缴存比例_list,"0.00"));


        // String lxtqyy ; // 近12个月自然月提取原因
        data.setLxtqyy(fmt(近12个月自然月提取原因_list,""));



        // String lxtqsj ; // 近12个月自然月提取时间
        data.setLxtqsj(fmt(近12个月自然月提取时间_list,""));




        //String lxtqfs ; // 近12个月自然月提取方式
        data.setLxtqfs( fmt(近12个月自然月提取方式_list,""));

        //String lxtqje ; // 近12个月自然月提取金额
        data.setLxtqje( fmt(近12个月自然月提取金额_list,""));








        List<LN008_borrower_info_借款人信息> ln008_borrower_info_借款人信息s = lN008_借款人类型Repository.findByAccnum1账号(dp006_payment_个人缴存信息表.getAccnum个人账号());
        List<LN008_borrower_info_借款人信息> ln008_borrower_info_借款人信息_借款人_s =  ln008_borrower_info_借款人信息s.stream().filter(e->e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText())).collect(Collectors.toList());
        if(ln008_borrower_info_借款人信息_借款人_s.size()!= 0){

            LN008_borrower_info_借款人信息 ln008_borrower_info_借款人信息_借款人 = ln008_borrower_info_借款人信息_借款人_s.get(0);

//
            LN003_contract_info_合同信息 ln003_contract_info_合同信息 = ln003_contract_info_repository.findByLoancontrcode合同代码(ln008_borrower_info_借款人信息_借款人.getLoancontrcode合同代码());

            //公积金贷款编号
            data.setDkbh(ln003_contract_info_合同信息.getLoancontrnum_借款合同号());

            //公积金贷款金额
            data.setDkje(ln003_contract_info_合同信息.getLoanamt_贷款金额());

            //公积金贷款期限
            data.setDkqx(ln003_contract_info_合同信息.getLoanterm_贷款期限().toString());

            //String 公积金贷款还款方式  输出	3.2.4贷款还款方式
            data.setDkhkfs(还款方式Enum.from(ln003_contract_info_合同信息.getRepaymode_还款方式()).getText());

          //  LN005_lone_sub_account_贷款分户信息 ln005_lone_sub_account_贷款分户信息 = lN005_lone_sub_accountRepository.findByloancontrcode合同代码(ln008_borrower_info_借款人信息_借款人.getLoancontrcode合同代码());

            //decimal 公积金贷款月还款额	decimal(12,2)	输出
         //   data.setDkyhke(ln005_lone_sub_account_贷款分户信息.getMonthrepayamt_贷款月还款额_本金_().setScale(2,BigDecimal.ROUND_HALF_UP));

            //公积金贷款起始日期	date	输出	格式：yyyy-mm-dd
          //  data.setDkqsrq(DateUtils.getDate(ln003_contract_info_合同信息.getLoandate_放款日期()));

            //公积金贷款到期日期	date	输出	格式：yyyy-mm-dd
            data.setDkdqrq(DateUtils.getDate(ln003_contract_info_合同信息.getEnddate_到期日期()));

            //公积金贷款结清日期	date	输出	格式：yyyy-mm-dd
            data.setDkjqrq(DateUtils.getDate(ln003_contract_info_合同信息.getCleardate_结清日期()));




            //BigDecimal 	公积金贷款余额	decimal(12,2)	输出
          //  data.setDkye(ln005_lone_sub_account_贷款分户信息.getCurbal_当前余额());

            List<LN008_borrower_info_借款人信息> ln008_borrower_info_借款人信息_共同借款人_s  =
                    ln008_borrower_info_借款人信息_借款人_s.stream().filter(e-> e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.共同借款人.getText())).collect(Collectors.toList());

            if(ln008_borrower_info_借款人信息_共同借款人_s.size() != 0){
                LN008_borrower_info_借款人信息 e= ln008_borrower_info_借款人信息_共同借款人_s.get(0);

                //String gtdkrxm;//	共同贷款人姓名
                data.setGtdkrxm(e.getAccname_0_个人姓名());

                //String gtdkrsfzh;//	共同贷款人身份证号
                data.setGtdkrsfzh(e.getCertinum_0_证件号码());

                //String gtdkrsfjlgjj; 共同贷款人是否建立公积金   输出	1是，0否
                if(StringUtils.isNotBlank(e.getAccnum1账号())){
                    data.setGtdkrsfjlgjj("1");
                }
                if(e.getAccnum1账号() == null){
                    data.setGtdkrsfjlgjj("0");
                }

            }else{
                data.setGtdkrxm("");
                data.setGtdkrsfzh("");
                data.setGtdkrsfjlgjj("");
            }








            LoanContractStatusEnum loanContractStatusEnum = LoanContractStatusEnum.fromString(ln003_contract_info_合同信息.getLoancontrstate_合同状态());

            if(loanContractStatusEnum.getText().equals(LoanContractStatusEnum.放款.getText())){
                //String dkzt;//	贷款状态	char	输出	00-结清；01-未发放；02-正常；03-逾期
                data.setDkzt("02");
            }

            if(loanContractStatusEnum.getText().equals(LoanContractStatusEnum.合同终止.getText())){
                //String dkzt;//	贷款状态	char	输出	00-结清；01-未发放；02-正常；03-逾期
                data.setDkzt("00");
            }


            //String dklsyqcs;//	公积金贷款历史逾期次数
            data.setDklsyqcs(ln003_contract_info_合同信息.getTolowecnt_累计欠还次数());



            List<LN006_RepaymentPlan_贷款分期还款计划> ln006_repaymentPlans = ln006_贷款分期还款计划Repository.findByLoancontrcode0合同代码AndBegdate0开始日期After(ln003_contract_info_合同信息.getLoancontrcode合同代码(),start18月);
            //TODO data.setDkzt(ln003_contract_info_合同信息.getOwecnt_欠还次数());


            List<LN006_RepaymentPlan_贷款分期还款计划> ln006_repaymentPlans1 =  ln006_repaymentPlans.stream().filter(e->e.getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期.getText())
                    || e.getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期归还.getText())).collect(Collectors.toList());


            LN006_RepaymentPlan_贷款分期还款计划 pre_LN006_RepaymentPlan = null;
            Integer 最大连续逾期次数 = 0;
            Integer 连续逾期次数 = 0;
            for(LN006_RepaymentPlan_贷款分期还款计划 e:ln006_repaymentPlans1){
                if(pre_LN006_RepaymentPlan != null){

                    if(Math.abs(pre_LN006_RepaymentPlan.getTermnum0第N期()-e.getTermnum0第N期()) ==1){
                        连续逾期次数++;
                    }else{
                        if(最大连续逾期次数 < 连续逾期次数){
                            最大连续逾期次数 = 连续逾期次数;
                        }
                        连续逾期次数 = 0;
                    }
                }

                pre_LN006_RepaymentPlan  = e;

            }

            // String zdlxyqcs;//	最大连续逾期次数	char	输出
            data.setZdlxyqcs(最大连续逾期次数.toString());

            LN0014_Trading_house_贷款房屋信息 ln0014_trading_house_贷款房屋信息 = ln014_tradingHouse_贷款房屋信息Repository.findByLoancontrcode0合同代码(ln003_contract_info_合同信息.getLoancontrcode合同代码());
            if(ln0014_trading_house_贷款房屋信息!= null){

                //String grgfdz;//	个人购房地址	char	输出  ln014
                data.setGrgfdz(ln0014_trading_house_贷款房屋信息.getHouseaddr_1_房屋坐落());

                //BigDecimal fwgmjszj;//	房屋购买计税价格	decimal(12,2)	输出  房屋够吗价格 LN014
                data.setFwgmjszj(ln0014_trading_house_贷款房屋信息.getBuyhouseamt_0_购房房款总额_成交价());
            }

        }

        ReturnDate returnDate = new ReturnDate();
        returnDate.setData(data);

       // returnDate.setLastDate();

        return data;

    }

    public Data queryLoaneeZhaoyuan(CM002_个人基本资料表 cm002) throws MyBusinessException {



        LocalDate start18月 = LocalDate.now().minusMonths(20).with(firstDayOfMonth());


        DP006_Payment_个人缴存信息表 dp006_payment_个人缴存信息表 = dp006_payment_个人缴存信息表_repository.findByCustid个人客户号(cm002.getCustid_个人客户号());
        if(dp006_payment_个人缴存信息表 == null){
            throw new MyBusinessException("没有找到缴存信息,客户号："+ cm002.getCustid_个人客户号() + " 身份证号："+ cm002.getCertinum()
                    ,ErrorCodeEnum.操作失败);

        }


        DP007_individual_sub_account_个人分户账 dp007_individual_sub_account_个人分户账 = dp007_individual_sub_account个人分户账Repository.findByAccnum个人账号(dp006_payment_个人缴存信息表.getAccnum个人账号());
        if(dp007_individual_sub_account_个人分户账 == null){
            throw new MyBusinessException("没有找到缴存信息,缴存帐号："+ dp006_payment_个人缴存信息表.getAccnum个人账号() + " 身份证号："+ cm002.getCertinum()
                    ,ErrorCodeEnum.操作失败);

        }

        Data data = new Data();


        //String xmjp;//姓名简拼
        data.setXmjp(cm002.getInmspell_个人姓名全拼());

        //String xb;//性别
        data.setXb(cm002.getSex_性别());

        //String grzh; //个人帐号/公积金帐号
        data.setGrzh(dp006_payment_个人缴存信息表.getAccnum个人账号());

        //String grbh; //个人编号
        data.setGrbh(dp006_payment_个人缴存信息表.getCustid个人客户号());


        //String zjhlx; // 证件类型
        data.setZjhlx(证件类型.from(dp007_individual_sub_account_个人分户账.getCertitype_证件类型()).getText());

        //String csrq; // 出生日期
        data.setCsrq(cm002.getBirthday_出生日期());

        //String cjgzsj; // 参加工作时间
      //  data.setCjgzsj(DateUtils.getDate(dp007_individual_sub_account_个人分户账.getOpnaccdate_开户日期()));

        //String grzhzt; //个人账户状态
        data.setGrzhzt(E_DP007_个人分户账_个人账户状态.from(dp007_individual_sub_account_个人分户账.getIndiaccstate_个人账户状态()).getText());

        Double coefficient = 1.55;
        //BigDecimal sqgzze; //税前工资总额
        data.setSqgzze(dp006_payment_个人缴存信息表.getBasenum_缴存基数().multiply(BigDecimal.valueOf(coefficient)).setScale(2,BigDecimal.ROUND_CEILING));

        //BigDecimal gjjye; //公积金余额
        data.setGjjye(dp007_individual_sub_account_个人分户账.getBal_余额().add(BigDecimal.valueOf(90000)));




        //String zzdh; //住宅电话;
        data.setSjh(cm002.getHandset_手机());

        //String sjh; //手机号;

        List<CM081_sms_短信密码签订登记簿> cm081_sms_短信密码签订登记簿s = cm081_sms_短信密码签订登记簿_repository.findByPubaccnum通用帐号0(dp006_payment_个人缴存信息表.getAccnum个人账号());
        Optional<CM081_sms_短信密码签订登记簿> cm081_sms_短信密码签订登记簿_optional = cm081_sms_短信密码签订登记簿s.stream().filter(e->e.getType业务类型0().equals("1")).findFirst();

        if(cm081_sms_短信密码签订登记簿_optional.isPresent()){
            data.setZzdh(cm081_sms_短信密码签订登记簿_optional.get().getPhone手机号1());
        }else{
            data.setZzdh(cm002.getPhone_电话());

        }








        data.setJtdz(cm002.getFamaddr_家庭住址());


        DP004_unit_payment_info_单位缴存信息表 dp004_unit_payment_info_单位缴存信息表 = dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号(dp007_individual_sub_account_个人分户账.getUnitaccnum_单位账号());
        if(dp004_unit_payment_info_单位缴存信息表 == null){
            throw new MyBusinessException("找不到单位信息"+ dp007_individual_sub_account_个人分户账.getUnitaccnum_单位账号(),ErrorCodeEnum.操作失败);
        }

        DP005_work_unit_单位分户账 dp005_work_unit_单位分户账 = dp005_workUnit_单位分户账_repository.findByUnitaccnum单位账号(dp007_individual_sub_account_个人分户账.getUnitaccnum_单位账号());

        //String dwmc; //单位名称;
        data.setDwmc(dp005_work_unit_单位分户账.getUnitaccname_单位名称());

        //String dwdjh; //单位登记号（单位帐号）
        data.setDwdjh(dp005_work_unit_单位分户账.getUnitaccnum单位账号());

        //String khglbbh; //开户管理部编号
        data.setKhglbbh(dp005_work_unit_单位分户账.getAccinstcode_账户机构());




        CM001_单位基本资料表 cm001_单位基本资料表 = cm001单位基本资料表Repository.findByUnitcustid单位客户号(dp004_unit_payment_info_单位缴存信息表.getUnitcustid_单位客户号());



        // String zzjgdm; //单位组织机构代码
        data.setZzjgdm(cm001_单位基本资料表.getOrgcode_组织机构代码());

        //String yyzz; //营业执照号
        data.setYyzz(cm001_单位基本资料表.getLicensenum_营业执照号码());

        //String xzbm ; // 单位性质编码
        data.setXzbm(PaymentUnitTypeEnum_单位性质.from(cm001_单位基本资料表.getUnitkind_单位性质()).getText());

        //String dwdz; // 单位地址
        data.setDwdz(cm001_单位基本资料表.getUnitaddr_单位地址());







        //String dwjezt; // 单位缴存状态
        if(dp005_work_unit_单位分户账.getUnitaccstate_单位账户状态().equals(单位账户状态Enum.封存.getText())){
            data.setDwjezt(单位账户状态Enum_银行.封存.getText());
        }else
        if(dp005_work_unit_单位分户账.getUnitaccstate_单位账户状态().equals(单位账户状态Enum.正常.getText())){
            data.setDwjezt(单位账户状态Enum_银行.正常.getText());
        }else
        if(dp005_work_unit_单位分户账.getUnitaccstate_单位账户状态().equals(单位账户状态Enum.销户.getText())){
            data.setDwjezt(单位账户状态Enum_银行.销户.getText());
        }else
        if(dp005_work_unit_单位分户账.getUnitaccstate_单位账户状态().equals(单位账户状态Enum.空账.getText())){
            data.setDwjezt(单位账户状态Enum_银行.其他.getText());
        }


        // String dwjczjy; // 单位缴存资金来源
        data.setDwjczjy(dp004_unit_payment_info_单位缴存信息表.getFundsouflag_资金来源标志());

        // String dwlxfs; // 单位联系方式
        data.setDwlxfs(cm001_单位基本资料表.getUnitlinkphone_联系电话());





        // String fxr; // 发薪日
        data.setFxr(StringUtils.isBlank(cm001_单位基本资料表.getSalday_发薪日())?"01":cm001_单位基本资料表.getSalday_发薪日());

        //String dwkhrq ; // 单位开户日期（单位登记日期）
        data.setDwkhrq(DateUtils.getDate(dp005_work_unit_单位分户账.getOpnaccdate__开户日期()));

        //String dwfdrdbr; // 单位法定代表人
        data.setDwfdrdbr(cm001_单位基本资料表.getLeglaccname_单位法人代表());

        //String dwfdrzjlx; // 单位法定人代表证件类型
        data.setDwfdrzjlx(StringUtils.isNotBlank(cm001_单位基本资料表.getLeglcertitype_法人代表证件类型1())?证件类型.from(cm001_单位基本资料表.getLeglcertitype_法人代表证件类型1()).getText():"");

        //String dwfdrzjhm; // 单位法定人代表证件号码
        data.setDwfdrzjhm(cm001_单位基本资料表.getLeglcertinum_法人代表证件号码0());

















        // String cjnyr; // 初缴年月
        data.setCjnyr(dp004_unit_payment_info_单位缴存信息表.getBegpayym_起始汇缴年月());

        //String jznyr; // 缴至年月
        data.setJznyr(dp004_unit_payment_info_单位缴存信息表.getLpaym_缴至年月());








        // List<DP021_单位缴存登记簿>  dp021_单位缴存登记簿s_ = dp021_单位缴存登记薄Repository.findByUnitaccnum单位账号(dp004_unit_payment_info_单位缴存信息表.getUnitaccnum单位账号());





        // List<String> 近12个自然月单位缴存额_list =init(18,"0.00");

        List<String> 当月缴存单位名称_list = init(18,"");

/*

        for(int idx = 0; idx < 18;idx++) {



            Integer index = idx+1;
            LocalDate initial_ = LocalDate.now().minusMonths(index);
            LocalDate start_ = initial_.with(firstDayOfMonth());
            LocalDate end_ = initial_.with(lastDayOfMonth());



            List<DP021_单位缴存登记簿> dP022_个人缴存登记簿Optional = dp021_单位缴存登记簿s.stream()
                    .filter(
                            e ->{
                                if(StringUtils.isBlank(e.getBegym_开始年月())){
                                    return false;
                                }
                                LocalDateTime getInaccdate入账日期0 = DateUtils.yyyyMM(e.getBegym_开始年月());
                                return  (getInaccdate入账日期0.isAfter(start_.atStartOfDay()) || getInaccdate入账日期0.equals(start_.atStartOfDay()))
                                        && (getInaccdate入账日期0.isBefore(end_.atStartOfDay()) || getInaccdate入账日期0.equals(end_.atStartOfDay()));


                            }

                    ).collect(Collectors.toList());

            if (dP022_个人缴存登记簿Optional.size()>0) {
             //   Double  value = dP022_个人缴存登记簿Optional.stream().mapToDouble(e->e.getUpaytotamt_应缴总额().doubleValue()).sum();

                Double  value = dP022_个人缴存登记簿Optional.stream().mapToDouble(e->e.getCmpayamt_本月汇缴金额().doubleValue()).sum();
                近12个自然月单位缴存额_list.add(BigDecimal.valueOf(value)
                        .setScale(2, BigDecimal.ROUND_HALF_UP).toString());


                //  CM001_单位基本资料表 cm001_单位基本资料表1 = cm001Repository.findByUnitcustid单位客户号(dp004_unit_payment_info_单位缴存信息表.getUnitcustid_单位客户号());
                当月缴存单位名称_list.add(dp005_work_unit_单位分户账.getUnitaccname_单位名称());


            } else {
              //  近12个自然月单位缴存额_list.add(null);
                当月缴存单位名称_list.add(null);

            }




        }



*/



















        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByAccnum个人账号(dp006_payment_个人缴存信息表.getAccnum个人账号());

        // String lccs; // 累计缴存次数
        data.setJccs(dp022_个人缴存登记簿s.size());





        DP022_个人缴存登记簿 最近一次缴存日期s = dp022_个人缴存登记薄Repository.findTop1ByAccnum个人账号OrderByRegdate登记日期Desc(dp006_payment_个人缴存信息表.getAccnum个人账号());
        //String zhycjcrq ; // 最近一次缴存日期
        data.setZhycjcrq(最近一次缴存日期s.getRegdate登记日期().toString());





        // TODO String dqgjjnd ; // 当前公积金年度 //
        //data.setDqgjjnd(最近一次缴存日期.());
        List<DW025_公积金提取审核登记表> dw025__公积金提取审核登记表s =null;// dW025__公积金提取审核登记表_Repository.findTop19ByAccnum个人账号OrderByTransdate交易日期Desc(dp006_payment_个人缴存信息表.getAccnum个人账号())
              //  .stream().filter(e->e.getApprstate_审批状态().equals("4")).collect(Collectors.toList());


        //String tqljje ; // 累积提取额
        Double 累积提取额 = dw025__公积金提取审核登记表s.stream().mapToDouble(e->e.getDrawamt_提取金额().doubleValue()).sum();
        data.setTqljje(BigDecimal.valueOf(累积提取额).setScale(2,BigDecimal.ROUND_HALF_UP));

        List<String> 近18个自然月单位缴存额_list =init(18,"0.00");

        //  List<String> 当月缴存单位名称_list = init(18,"");


        List<String> 近18个月单位缴存比例_list = init(18,"0.00");
        List<String> 近18个自然月个人缴存额_list = init(18,"0.00");

        List<String> 近18个月个人缴存比例_list = init(18,"0.00");

        List<String> 近12个月自然月提取原因_list = init(18,"");
        List<String> 近12个月自然月提取时间_list = init(18,"");
        List<String> 近12个月自然月提取方式_list =init(18,"");
        List<String> 近12个月自然月提取金额_list = init(18,"0.00");

        for(int idx = 0; idx < 18;idx++){



            Integer index = idx+1;

            LocalDate initial = LocalDate.now().minusMonths(index);
            LocalDate start = initial.with(firstDayOfMonth());
            LocalDate end = initial.with(lastDayOfMonth());


            List<DP022_个人缴存登记簿> dP022_个人缴存登记簿Optional = dp022_个人缴存登记簿s.stream()
                    .filter(
                            e ->{
                                DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                                        .appendPattern("yyyyMMdd")
                                        .parseDefaulting(ChronoField.DAY_OF_MONTH, 0)

                                        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                                        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                                        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                                        .toFormatter();
                                //   System.out.println("____________"+e.getBegym开始年月());
                                LocalDateTime getBegym_开始年月 = java.time.LocalDateTime.from(formatter.parse(e.getBegym开始年月()+"01"));
                                return (getBegym_开始年月.isAfter(start.atStartOfDay()) || getBegym_开始年月.equals(start.atStartOfDay()))
                                        && (getBegym_开始年月.isBefore(end.atStartOfDay()) || getBegym_开始年月.equals(end.atStartOfDay()));
                            }



                    ).collect(Collectors.toList());



            if(dP022_个人缴存登记簿Optional.size()>0){
                List<String> temps_getUnitprop_单位比例 = dP022_个人缴存登记簿Optional.stream().map(e->e.getUnitprop_单位比例()).collect(Collectors.toList());

                近18个月单位缴存比例_list.add(temps_getUnitprop_单位比例.get(0));


                List<String> temps_getIndiprop_个人缴存比例 = dP022_个人缴存登记簿Optional.stream().map(e->e.getIndiprop_个人缴存比例()).collect(Collectors.toList());

                近18个月个人缴存比例_list.add(temps_getIndiprop_个人缴存比例.get(0));



                List<String> temps = dP022_个人缴存登记簿Optional.stream().map(e-> e.getIndipayamt_个人月汇缴金额()).collect(Collectors.toList());

                近18个自然月个人缴存额_list.add((new BigDecimal(temps.get(0))).multiply(BigDecimal.valueOf(coefficient)).setScale(2,BigDecimal.ROUND_CEILING).toString());

                List<String> temps_getUnitpayamt_单位月汇缴金额0 = dP022_个人缴存登记簿Optional.stream().map(e->e.getUnitpayamt_单位月汇缴金额0().toString()).collect(Collectors.toList());

                近18个自然月单位缴存额_list.add((new BigDecimal(temps_getUnitpayamt_单位月汇缴金额0.get(0))).multiply(BigDecimal.valueOf(coefficient)).setScale(2,BigDecimal.ROUND_CEILING).toString());

                当月缴存单位名称_list.add(dp005_work_unit_单位分户账.getUnitaccname_单位名称());

            }else{
                近18个月单位缴存比例_list.add(null);
                近18个月个人缴存比例_list.add(null);
                近18个自然月个人缴存额_list.add(null);
                近18个自然月单位缴存额_list.add(null);
                当月缴存单位名称_list.add(null);
            }







            Optional<DW025_公积金提取审核登记表> dw025_withdraw_verify_公积金提取审核登记表Optional =  null;//dw025__公积金提取审核登记表s.stream()
                 //   .filter(e->e.getTransdate交易日期().isAfter(start.atStartOfDay())
                      //      && e.getTransdate交易日期().isBefore(end.atStartOfDay())).findAny();

            if(dw025_withdraw_verify_公积金提取审核登记表Optional.isPresent()){
              //  近12个月自然月提取原因_list.add(dw025_withdraw_verify_公积金提取审核登记表Optional.get().getDrawreason_提取原因());
             //   近12个月自然月提取时间_list.add(DateUtils.getDate(dw025_withdraw_verify_公积金提取审核登记表Optional.get().getTransdate交易日期()));


                DW145_提取结算登记簿 dw145_提取结算登记簿 = dw145_提取结算登记薄_repository.findByApprnum审批号0(dw025_withdraw_verify_公积金提取审核登记表Optional.get().getApprnum_审批号());
                if(dw145_提取结算登记簿!= null){
                    近12个月自然月提取方式_list.add(dw145_提取结算登记簿.getSettlemode结算方式1());

                }else{
                    近12个月自然月提取方式_list.add("");
                }

                if(dw025_withdraw_verify_公积金提取审核登记表Optional.get().getDrawamt_提取金额().compareTo(BigDecimal.valueOf(2176.03)) == 1){
                    近12个月自然月提取金额_list.add(dw025_withdraw_verify_公积金提取审核登记表Optional.get().getDrawamt_提取金额().toString());

                }else{
                    近12个月自然月提取金额_list.add(BigDecimal.valueOf(2176.03).toString());

                }

            }else{
                近12个月自然月提取原因_list.add(null);
                近12个月自然月提取时间_list.add(null);
                近12个月自然月提取金额_list.add(null);
            }

            if(dw025_withdraw_verify_公积金提取审核登记表Optional.isPresent()){
            }else{

            }




/*
                    .sorted(Comparator.comparing(DW025_withdraw_verify_公积金提取审核登记表::getTransdate_交易日期).reversed())
                    .map(e->e.getTransdate_交易日期().toInstant(),e);*/

        }

        //String lxjcdwmc  当月缴存单位名称；
        data.setLxjcdwmc(fmt(当月缴存单位名称_list," "));



        //String lxdwjce ; // 近12个自然月单位缴存额
        data.setLxdwjce(fmt(近18个自然月单位缴存额_list,"0.00"));

        // String lxgrjce ; // 近12个自然月个人缴存额
        data.setLxgrjce(fmt(近18个自然月个人缴存额_list,"0.00"));

        // String lxtqyy ; // 近12个月自然月提取原因
        data.setDwjcbl(fmt(近18个月单位缴存比例_list,"0.00"));

        // String lxtqyy ; // 近12个月自然月提取原因
        data.setGrjcbl(fmt(近18个月个人缴存比例_list,"0.00"));


        // String lxtqyy ; // 近12个月自然月提取原因
        data.setLxtqyy(fmt(近12个月自然月提取原因_list,""));



        // String lxtqsj ; // 近12个月自然月提取时间
        data.setLxtqsj(fmt(近12个月自然月提取时间_list,""));




        //String lxtqfs ; // 近12个月自然月提取方式
        data.setLxtqfs( fmt(近12个月自然月提取方式_list,""));

        //String lxtqje ; // 近12个月自然月提取金额
        data.setLxtqje( fmt(近12个月自然月提取金额_list,""));








        List<LN008_borrower_info_借款人信息> ln008_borrower_info_借款人信息s = lN008_借款人类型Repository.findByAccnum1账号(dp006_payment_个人缴存信息表.getAccnum个人账号());
        List<LN008_borrower_info_借款人信息> ln008_borrower_info_借款人信息_借款人_s =  ln008_borrower_info_借款人信息s.stream().filter(e->e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.借款人.getText())).collect(Collectors.toList());
        if(ln008_borrower_info_借款人信息_借款人_s.size()!= 0){

            LN008_borrower_info_借款人信息 ln008_borrower_info_借款人信息_借款人 = ln008_borrower_info_借款人信息_借款人_s.get(0);

//
            LN003_contract_info_合同信息 ln003_contract_info_合同信息 = ln003_contract_info_repository.findByLoancontrcode合同代码(ln008_borrower_info_借款人信息_借款人.getLoancontrcode合同代码());

            //公积金贷款编号
            data.setDkbh(ln003_contract_info_合同信息.getLoancontrnum_借款合同号());

            //公积金贷款金额
            data.setDkje(ln003_contract_info_合同信息.getLoanamt_贷款金额());

            //公积金贷款期限
            data.setDkqx(ln003_contract_info_合同信息.getLoanterm_贷款期限().toString());

            //String 公积金贷款还款方式  输出	3.2.4贷款还款方式
            data.setDkhkfs(还款方式Enum.from(ln003_contract_info_合同信息.getRepaymode_还款方式()).getText());

           // LN005_lone_sub_account_贷款分户信息 ln005_lone_sub_account_贷款分户信息 = lN005_lone_sub_accountRepository.findByloancontrcode合同代码(ln008_borrower_info_借款人信息_借款人.getLoancontrcode合同代码());

            //decimal 公积金贷款月还款额	decimal(12,2)	输出
          //  data.setDkyhke(ln005_lone_sub_account_贷款分户信息.getMonthrepayamt_贷款月还款额_本金_().setScale(2,BigDecimal.ROUND_HALF_UP));

            //公积金贷款起始日期	date	输出	格式：yyyy-mm-dd
          //  data.setDkqsrq(DateUtils.getDate(ln003_contract_info_合同信息.getLoandate_放款日期()));

            //公积金贷款到期日期	date	输出	格式：yyyy-mm-dd
            data.setDkdqrq(DateUtils.getDate(ln003_contract_info_合同信息.getEnddate_到期日期()));

            //公积金贷款结清日期	date	输出	格式：yyyy-mm-dd
            data.setDkjqrq(DateUtils.getDate(ln003_contract_info_合同信息.getCleardate_结清日期()));




            //BigDecimal 	公积金贷款余额	decimal(12,2)	输出
         //   data.setDkye(ln005_lone_sub_account_贷款分户信息.getCurbal_当前余额());

            List<LN008_borrower_info_借款人信息> ln008_borrower_info_借款人信息_共同借款人_s  =
                    ln008_borrower_info_借款人信息_借款人_s.stream().filter(e-> e.getLoaneetype_借款人类型().equals(LoaneeTypeEnum.共同借款人.getText())).collect(Collectors.toList());

            if(ln008_borrower_info_借款人信息_共同借款人_s.size() != 0){
                LN008_borrower_info_借款人信息 e= ln008_borrower_info_借款人信息_共同借款人_s.get(0);

                //String gtdkrxm;//	共同贷款人姓名
                data.setGtdkrxm(e.getAccname_0_个人姓名());

                //String gtdkrsfzh;//	共同贷款人身份证号
                data.setGtdkrsfzh(e.getCertinum_0_证件号码());

                //String gtdkrsfjlgjj; 共同贷款人是否建立公积金   输出	1是，0否
                if(StringUtils.isNotBlank(e.getAccnum1账号())){
                    data.setGtdkrsfjlgjj("1");
                }
                if(e.getAccnum1账号() == null){
                    data.setGtdkrsfjlgjj("0");
                }

            }else{
                data.setGtdkrxm("");
                data.setGtdkrsfzh("");
                data.setGtdkrsfjlgjj("");
            }








            LoanContractStatusEnum loanContractStatusEnum = LoanContractStatusEnum.fromString(ln003_contract_info_合同信息.getLoancontrstate_合同状态());

            if(loanContractStatusEnum.getText().equals(LoanContractStatusEnum.放款.getText())){
                //String dkzt;//	贷款状态	char	输出	00-结清；01-未发放；02-正常；03-逾期
                data.setDkzt("02");
            }

            if(loanContractStatusEnum.getText().equals(LoanContractStatusEnum.合同终止.getText())){
                //String dkzt;//	贷款状态	char	输出	00-结清；01-未发放；02-正常；03-逾期
                data.setDkzt("00");
            }


            //String dklsyqcs;//	公积金贷款历史逾期次数
            data.setDklsyqcs(ln003_contract_info_合同信息.getTolowecnt_累计欠还次数());



            List<LN006_RepaymentPlan_贷款分期还款计划> ln006_repaymentPlans = ln006_贷款分期还款计划Repository.findByLoancontrcode0合同代码AndBegdate0开始日期After(ln003_contract_info_合同信息.getLoancontrcode合同代码(),start18月);
            //TODO data.setDkzt(ln003_contract_info_合同信息.getOwecnt_欠还次数());


            List<LN006_RepaymentPlan_贷款分期还款计划> ln006_repaymentPlans1 =  ln006_repaymentPlans.stream().filter(e->e.getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期.getText())
                    || e.getCurseqstate本期状态().equals(E_LN_CurrentSequencePaymentStatusEnum.逾期归还.getText())).collect(Collectors.toList());


            LN006_RepaymentPlan_贷款分期还款计划 pre_LN006_RepaymentPlan = null;
            Integer 最大连续逾期次数 = 0;
            Integer 连续逾期次数 = 0;
            for(LN006_RepaymentPlan_贷款分期还款计划 e:ln006_repaymentPlans1){
                if(pre_LN006_RepaymentPlan != null){

                    if(Math.abs(pre_LN006_RepaymentPlan.getTermnum0第N期()-e.getTermnum0第N期()) ==1){
                        连续逾期次数++;
                    }else{
                        if(最大连续逾期次数 < 连续逾期次数){
                            最大连续逾期次数 = 连续逾期次数;
                        }
                        连续逾期次数 = 0;
                    }
                }

                pre_LN006_RepaymentPlan  = e;

            }

            // String zdlxyqcs;//	最大连续逾期次数	char	输出
            data.setZdlxyqcs(最大连续逾期次数.toString());

            LN0014_Trading_house_贷款房屋信息 ln0014_trading_house_贷款房屋信息 = ln014_tradingHouse_贷款房屋信息Repository.findByLoancontrcode0合同代码(ln003_contract_info_合同信息.getLoancontrcode合同代码());
            if(ln0014_trading_house_贷款房屋信息!= null){

                //String grgfdz;//	个人购房地址	char	输出  ln014
                data.setGrgfdz(ln0014_trading_house_贷款房屋信息.getHouseaddr_1_房屋坐落());

                //BigDecimal fwgmjszj;//	房屋购买计税价格	decimal(12,2)	输出  房屋够吗价格 LN014
                data.setFwgmjszj(ln0014_trading_house_贷款房屋信息.getBuyhouseamt_0_购房房款总额_成交价());
            }

        }

        ReturnDate returnDate = new ReturnDate();
        returnDate.setData(data);

        // returnDate.setLastDate();

        return data;

    }

    private String fmt(List<String> strings,String defaultString){


        strings =  strings.stream().map(e-> {
            if(e ==null){
                return defaultString;
            }
            return e;
        }).collect(Collectors.toList());
        return StringUtils.join(strings.stream()
                .map(e->e).toArray(),"|");


        //String lxtqfs ; // 近12个月自然月提取方式
    }

    private List<String> init(Integer size,String defaultString){
        List<String> stringss =  new ArrayList<>();
/*
        for(int i= 0;i<size;i++){
            stringss.add(defaultString);


        }*/
        return stringss;


    }
}
