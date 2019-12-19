package org.ylgjj.loan.history_flow;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.domain_flow.Config;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.ConfigRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Peter Xu on 01/08/2015.
 */

@Component
public class BaseServiceImpl implements BaseService {

    protected transient Logger logger = LoggerFactory.getLogger(getClass());
   // @PersistenceContext
    protected EntityManager em;





    @Autowired
    private DP022_个人缴存登记薄Repository dp022_个人缴存登记薄Repository;


    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;
    @Autowired
    private PB007_机构信息表_Repository pb007_机构信息表_repository;
    @Autowired
    private PB011_银行信息表Repository pb011_银行信息表Repository;


    @Autowired
    private DW025_公积金提取审核登记表_Repository dW025__公积金提取审核登记表_Repository;

    @Autowired
    private DP007_个人分户账_Repository dp007_individual_sub_account个人分户账Repository;
    @Autowired
    private DP006_个人缴存信息表_Repository dp006__个人缴存信息表_repository;
    @Autowired
    private LN014_贷款房屋信息Repository ln014__贷款房屋信息Repository;
    @Autowired
    private LN008_借款人类型Repository ln008_借款人类型Repository;


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private DP009_个人明细账_Repository dp009_个人明细账_repository;


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
    private DP008_单位明细账_Repository dp008_单位明细账_repository;
    @Autowired
    private DP202_单位缴存变更登记簿_Repository dp202_单位缴存变更登记簿_repository;
    @Autowired
    private PB017_public_flowing公共流水登记簿Repository public_flowing公共流水登记簿Repository;


    @Autowired
    private LN101_贷款明细账_Repository ln101_贷款明细账_repository;

    @Autowired
    private LN005_贷款分户信息_Repository lN005_贷款分户信息RepositoryLN005;




    @Autowired
    private TR100_转移接续登记簿Repository tr100_转移接续登记簿Repository;

    @Autowired
    private TR003_转移人账户信息_Repository tr003_转移人账户信息_repository;

    @Autowired
    private TR002_联系函基础信息_Repository tr002_联系函基础信息_repository;


    @Autowired
    private ConfigRepository configRepository;



/*    boolean initComplte = false;
    List<DP004_单位缴存信息表> dp004__单位缴存信息表s = null;
    Map<String, DP004_单位缴存信息表> dp004_unit_payment_info_单位缴存信息表Map = null;

    Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = null;
    Map<String, DP005_单位分户账> dp005_单位分户账Map = null;
    Map<String, List<LN008_借款人信息>> ln008_borrower_info_借款人信息Map = null;




    Map<String,List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map = null;
    Map<String,List<DP008_institution_detail_单位明细账>> dp008_institution_detail_单位明细账Map = null;
    Map<String,List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map = null;
    Map<String,List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map = null;

    Map<String,List<DP009_个人明细账>> dp009_个人明细账Map = null;
    Map<String,List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map = null;*/
// chops a list into non-view sublists of length L


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
    public Map<String, DP005_单位分户账> dp005_单位分户账Map(List<String> dp) {



            return chopped(dp,1000).stream().map(x->{
                return dp005__单位分户账_repository.findByUnitaccnum单位账号In(x)
                        .stream().collect(Collectors.toList());
            }).flatMap(s -> s.stream()).collect(Collectors.toMap(r -> r.getUnitaccnum单位账号(), r -> r));

/*
        List<MyObject> list = services.stream()
                .flatMap()
                .collect(Collectors.toList());*/


    }



    public Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map(List<String> dp) {
      //  List<DP005_单位分户账> dp005_单位分户账Map = dp005_workUnit_单位分户账_repository.findByUnitaccnum单位账号In(dp);


        List<DP005_单位分户账> dp005_单位分户账Map = chopped(dp,1000).stream().map(x->{
            return dp005__单位分户账_repository.findByUnitaccnum单位账号In(x)
                    .stream().collect(Collectors.toList());
        }).flatMap(s -> s.stream()).collect(Collectors.toList());

            //    .stream().collect(Collectors.toMap(x -> x.getUnitaccnum单位账号(), x -> x));

        return chopped(dp005_单位分户账Map.stream().map(x -> x.getUnitcustid_单位客户号()).collect(Collectors.toList()),1000).stream().map(x->{
            return cm001单位基本资料表Repository.findByUnitcustid单位客户号In(x)
                    .stream().collect(Collectors.toList());
        }).flatMap(s -> s.stream()).collect(Collectors.toMap(r -> r.getUnitcustid单位客户号(), r -> r));


    }


    public Map<String, DP004_单位缴存信息表> dp004_单位缴存信息表Map(List<String> dp) {

        return  dp004_unit_payment_info单位缴存信息表Repository.findByUnitaccnum单位账号In(dp)
                .stream().collect(Collectors.toMap(x -> x.getUnitaccnum单位账号(), x -> x));
    }




    public Map<String, List<DW025_公积金提取审核登记表>> dw025_公积金提取审核登记表Map(List<String> dp) {

        return              dW025__公积金提取审核登记表_Repository.findByUnitaccnum单位账号In(dp)
                        .stream().collect(Collectors.groupingBy(x -> x.getUnitaccnum单位账号()));
    }


    public Map<String, List<DP008_单位明细账>> dp008_单位明细账Map(List<String> dp) {


        return dp008_单位明细账_repository.findByUnitaccnum不可为空单位账号In(dp)
                        .stream().collect(Collectors.groupingBy(x -> x.getUnitaccnum不可为空单位账号()));

    }

    public Map<String, List<DP202_单位缴存变更登记簿>> dp202_单位缴存变更登记簿Map(List<String> dp) {
        return dp202_单位缴存变更登记簿_repository.findByUnitaccnum不可为空单位账号In(dp)
                .stream().collect(Collectors.groupingBy(x -> x.getUnitaccnum不可为空单位账号()));

    }


    public Map<String, List<DP204_个人缴存变更登记簿>> dp204_个人缴存变更登记簿Map(List<String> dp) {
        return dp204_个人缴存变更登记簿_repository.findByAccnum不可为空个人账号In(dp)
                .stream().collect(Collectors.groupingBy(x -> x.getAccnum不可为空个人账号()));

    }


    public Map<String, List<DP009_个人明细账>> dp009_个人明细账Map(List<String> dp) {
        List<DP009_个人明细账> dp009_个人明细账s = dp009_个人明细账_repository.findByAccnum不可为空个人账号In(dp);


        return dp009_个人明细账s.stream().collect(Collectors.groupingBy(e -> e.getAccnum不可为空个人账号()));




    }

    public Map<String, List<DP022_个人缴存登记簿>> dp022_个人缴存登记簿Map(List<String> dp) {
        List<DP022_个人缴存登记簿> dp022_个人缴存登记簿s = dp022_个人缴存登记薄Repository.findByAccnum个人账号In(dp);

        return dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e -> e.getAccnum个人账号()));


    }




    public Map<String, List<LN005_贷款分户信息>> ln005_贷款分户信息Map(List<String> dp) {
        List<LN005_贷款分户信息> dp022_个人缴存登记簿s = lN005_贷款分户信息RepositoryLN005.findByloancontrcode合同代码In(dp);


            return dp022_个人缴存登记簿s.stream()
                   // .filter(e->e.getLoanacctype_贷款分户类型().equals("01"))
                    .collect(Collectors.groupingBy(e -> e.getLoancontrcode合同代码()));



    }

    public Map<String, LN014_贷款房屋信息> ln014_贷款房屋信息Map(List<String> dp) {
        List<LN014_贷款房屋信息> dp022_个人缴存登记簿s = ln014__贷款房屋信息Repository.findByLoancontrcode0合同代码In(dp);

        return dp022_个人缴存登记簿s.stream().collect(Collectors.toMap(e -> e.getLoancontrcode0合同代码(),e->e));


    }
    public Map<String, List<LN008_借款人信息>> ln008_借款人信息Map(List<String> dp) {
        List<LN008_借款人信息> dp022_个人缴存登记簿s = ln008_借款人类型Repository.findByloancontrcode合同代码In(dp);

        return dp022_个人缴存登记簿s.stream().collect(Collectors.groupingBy(e -> e.getLoancontrcode合同代码()));


    }

    public Map<String, LN003_合同信息> ln003_合同信息Map(List<String> dp) {
        List<LN003_合同信息> dp022_个人缴存登记簿s = ln003_合同信息_repository.findByLoancontrcode合同代码In(dp);

        return dp022_个人缴存登记簿s.stream().collect(Collectors.toMap(e -> e.getLoancontrcode合同代码(),e->e));


    }



    Map<String, PB007_机构信息表> pb007_机构信息表Map = null;
    public Map<String, PB007_机构信息表> pb007_机构信息表Map() {

        if(pb007_机构信息表Map == null){

            pb007_机构信息表Map =  pb007_机构信息表_repository.findAll().stream().collect(Collectors.toMap(e -> e.getInstCode(),e->e));
        }
        return pb007_机构信息表Map;
    }


    Map<String, PB011_银行信息表> pb011_银行信息表Map = null;

    public Map<String, PB011_银行信息表> pb011_银行信息表Map() {

        if(pb011_银行信息表Map == null){

            pb011_银行信息表Map =  pb011_银行信息表Repository.findAll().stream().collect(Collectors.toMap(e -> e.getBankcode(),e->e));
        }
        return pb011_银行信息表Map;
    }


    Map<String, Config> configMap = null;
    public Map<String, Config> configMap() {

        if(configMap == null){

            configMap =  configRepository.findAll().stream().collect(Collectors.toMap(e -> e.getName(),e->e));
        }
        return configMap;
    }

}
