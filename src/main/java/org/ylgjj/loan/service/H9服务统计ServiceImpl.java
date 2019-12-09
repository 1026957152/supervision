package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.api.H9服务统计Controller;
import org.ylgjj.loan.domain.Data;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;

import org.ylgjj.loan.domain_zongfu.Mi029_综合服务个人用户基础信息表;
import org.ylgjj.loan.domain_zongfu.Mi0312_渠道用户登录ID辅助控制表;
import org.ylgjj.loan.domain_zongfu.Mi107_业务日志;
import org.ylgjj.loan.output.*;
import org.ylgjj.loan.outputenum.E_业务类型_综服_HX;
import org.ylgjj.loan.outputenum.E_渠道_HX;
import org.ylgjj.loan.pojo.*;
import org.ylgjj.loan.repository.AN004Repository;
import org.ylgjj.loan.repository.PB010_bank_info_大行信息表Repository;
import org.ylgjj.loan.repository_zhongfu.MI029_综合服务个人用户基础信息表_Repository;
import org.ylgjj.loan.repository_zhongfu.Mi0312_渠道用户登录ID辅助控制表_Repository;
import org.ylgjj.loan.repository_zhongfu.Mi107_业务日志_Repository;
import org.ylgjj.loan.util.CardJunit;
/*
import org.ylgjj.loan.repository_zhongfu.MI007_系统码表_Repository;
import org.ylgjj.loan.repository_zhongfu.MI029_综合服务个人用户基础信息表_Repository;
*/

import javax.annotation.PostConstruct;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H9服务统计ServiceImpl")
public class H9服务统计ServiceImpl {

/*
    @Autowired
    private MI029_综合服务个人用户基础信息表_Repository mi029_综合服务个人用户基础信息表_repository;
    @Autowired
    private MI007_系统码表_Repository mi007_系统码表_repository;
*/
@Autowired
private MI029_综合服务个人用户基础信息表_Repository mi029_综合服务个人用户基础信息表_repository;
    @Autowired
    private Mi0312_渠道用户登录ID辅助控制表_Repository mi0312_渠道用户登录ID辅助控制表_repository;

    @Autowired
    private Mi107_业务日志_Repository mi107_业务日志_repository;


    public Output H_9_1_服务统计_信息推送量查询(H9服务统计Controller.QueryH_9_1_服务统计_信息推送量查询 query) {

        H9_1信息推送量查询_信息推送量查询 h4_1业务统计_获取各渠道业务统计数据 = new H9_1信息推送量查询_信息推送量查询();
        DoubleSummaryStatistics 归集 = null;//归集(query);

        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据);
        output.setData(a);
        return output;
    }


    public Output H_9_2_服务统计_渠道访问总量查询(QueryH_9_2_服务统计_渠道访问总量查询 query) {



        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        Output output = new Output();
        output.setSuccess(true);
        output.setData(mi107_业务日志s.stream().collect(Collectors.groupingBy(e->e.getChanneltype())).entrySet().stream().map(e->{
            H9_8信息推送量查询_各渠道API总量 aa = new H9_8信息推送量查询_各渠道API总量();
            aa.setBm_渠道编码(E_渠道_HX.fromString(e.getKey()).get名称());
            aa.setCount_条数(Integer.valueOf(e.getValue().size()).toString());
            return aa;
        }).collect(Collectors.toList()));
        return output;
/*
        List<MI007_系统码表> mi007_系统码表s = mi007_系统码表_repository.findByUPDICID(402);

        Output output = new Output();
        mi007_系统码表s.stream().map(e->e.toString());
*//*


       // output.setData(mi007_系统码表s.stream().map(e->{

            H9_2信息推送量查询_渠道访问总量查询 h4_1业务统计_获取各渠道业务统计数据 = new H9_2信息推送量查询_渠道访问总量查询();


*//*           h4_1业务统计_获取各渠道业务统计数据.setBm_渠道分类编码(e.getITEMID());
          h4_1业务统计_获取各渠道业务统计数据.setMc_渠道分类名称(e.getITEMVAL());*//*
          h4_1业务统计_获取各渠道业务统计数据.setCount_数量(100);
            return h4_1业务统计_获取各渠道业务统计数据;
        }).collect(Collectors.toList()));
        return output;*/


    }
    

    public Output H_9_3_服务统计_用户注册分布查询(H9服务统计Controller.QueryH_9_3_服务统计_用户注册分布查询 query) {

        H9_3信息推送量查询_用户注册分布查询 h4_1业务统计_获取各渠道业务统计数据 = new H9_3信息推送量查询_用户注册分布查询();

        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据);
        output.setData(a);
        return output;
    }

    public Output H_9_4_服务统计_用户性别查询(QueryH_9_4_服务统计_用户性别查询 query) {

        List<Mi029_综合服务个人用户基础信息表> count = mi029_综合服务个人用户基础信息表_repository.findAll();
        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.addAll( count.stream().filter(e->e.getSex()!= null).collect(Collectors.groupingBy(e->{

            try {
                return CardJunit.identityCard18_Sex(e.getCertinum());
            } catch (Exception ex) {
                ex.printStackTrace();
                return e.getSex();
            }
        })).entrySet().stream().map(e->{
            H9_4信息推送量查询_用户性别查询 h4_1业务统计_获取各渠道业务统计数据_man = new H9_4信息推送量查询_用户性别查询();
            h4_1业务统计_获取各渠道业务统计数据_man.setMc_性别(e.getKey());
            h4_1业务统计_获取各渠道业务统计数据_man.setCount_人数(Integer.valueOf(e.getValue().size()).toString());
            return h4_1业务统计_获取各渠道业务统计数据_man;
        }).collect(Collectors.toList()));
        output.setData(a);
        return output;
    }


    public Output H_9_7_服务统计_用户年龄信息查询(QueryH_9_7_服务统计_用户年龄信息查询 query) {

        List<Mi029_综合服务个人用户基础信息表> count = mi029_综合服务个人用户基础信息表_repository.findAll();

        H9_7信息推送量查询_用户年龄信息查询 h9_7信息推送量查询_用户年龄信息查询 = new H9_7信息推送量查询_用户年龄信息查询();

        count.stream().filter(e->{
            if(e.getCertinum()== null){
                System.out.println("getCertinum 为空");
            }
            return e.getCertinum()!= null;

        }).collect(Collectors.groupingBy(e->{
            Map map = new HashMap();


            try {
                map = CardJunit.identityCard18(e.getCertinum());
                if((Integer)map.get("age")<= 20){
                    return 1;
                }
                if((Integer)map.get("age")<= 40 && (Integer)map.get("age")> 20){
                    return 2;
                }
                if((Integer)map.get("age")<= 60 && (Integer)map.get("age")> 40){
                    return 3;
                }
                if((Integer)map.get("age")>= 60){
                    return 4;
                }
                return 0;
            } catch (Exception ex) {
                ex.printStackTrace();
                return 0;
            }


        })).entrySet().stream().forEach(e->{
            System.out.println("H9_7信息推送量查询_用户年龄信息查询 ---------- "+ e.getKey());
            if(e.getKey()== 1){
                h9_7信息推送量查询_用户年龄信息查询.setNl1_年龄_小于20岁(Integer.valueOf(e.getValue().size()).toString());
            }
            if(e.getKey()== 2){
                h9_7信息推送量查询_用户年龄信息查询.setNl2_年龄_20_40(Integer.valueOf(e.getValue().size()).toString());
            }
            if(e.getKey()== 3){
                h9_7信息推送量查询_用户年龄信息查询.setNl3_年龄_40_60(Integer.valueOf(e.getValue().size()).toString());
            }
            if(e.getKey()== 4){
                h9_7信息推送量查询_用户年龄信息查询.setNl4_年龄_60岁以上(Integer.valueOf(e.getValue().size()).toString());
            }


        });

        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h9_7信息推送量查询_用户年龄信息查询);
        output.setData(a);
        return output;
    }

    public Output H_9_5_服务统计_短信发送量查询(H9服务统计Controller.QueryH_9_5_服务统计_短信发送量查询 query) {
        return null;
    }

    public Output H_9_6_服务统计_渠道登录次数查询(QueryH_9_6_服务统计_渠道登录次数查询 query) {

        List<Mi0312_渠道用户登录ID辅助控制表> mi0312_渠道用户登录ID辅助控制表s = mi0312_渠道用户登录ID辅助控制表_repository.findAll();
        Output output = new Output();
        output.setSuccess(true);
        output.setData(mi0312_渠道用户登录ID辅助控制表s.stream().collect(Collectors.groupingBy(e->{
            return e.getChannel();
        })).entrySet().stream().map(e->{
            H9_6信息推送量查询_渠道登录次数查询 h9_6信息推送量查询_渠道登录次数查询 = new H9_6信息推送量查询_渠道登录次数查询();
            h9_6信息推送量查询_渠道登录次数查询.setName_渠道名称(E_渠道_HX.valueOf(e.getKey()).name());
            h9_6信息推送量查询_渠道登录次数查询.setCount_条数(Integer.toString(e.getValue().size()));
            return h9_6信息推送量查询_渠道登录次数查询;
        }).collect(Collectors.toList()));
        return output;
    }

    public Output H_9_8_服务统计_各渠道API总量(QueryH_9_8_服务统计_各渠道API总量 query) {



        List<Mi107_业务日志> mi107_业务日志s = mi107_业务日志_repository.findAll();

        Output output = new Output();
        output.setSuccess(true);
        output.setData(mi107_业务日志s.stream().collect(Collectors.groupingBy(e->e.getChanneltype())).entrySet().stream().map(e->{
            H9_8信息推送量查询_各渠道API总量 aa = new H9_8信息推送量查询_各渠道API总量();
            aa.setBm_渠道编码(E_渠道_HX.fromString(e.getKey()).get名称());
            aa.setCount_条数(Integer.valueOf(e.getValue().size()).toString());
            return aa;
        }).collect(Collectors.toList()));
        return output;
    }


//@PostConstruct
    public void H_9_4_服务统计_用户性别查询() {

    List<Mi029_综合服务个人用户基础信息表> count = mi029_综合服务个人用户基础信息表_repository.findAll();

    count.stream().filter(e->{
        if(e.getSex()== null){
            System.out.println("性别信息为空");
        }
        return e.getSex()!= null;

    }).collect(Collectors.groupingBy(e->{

        try {
            return CardJunit.identityCard18_Sex(e.getCertinum());
        } catch (Exception ex) {
            ex.printStackTrace();
            return e.getSex();
        }
        // return e.getSex();
    })).entrySet().stream().map(e->{
        System.out.println("mi029_综合服务个人用户基础信息表_repository ---------- "+ e.getKey());
        H9_4信息推送量查询_用户性别查询 h4_1业务统计_获取各渠道业务统计数据_man = new H9_4信息推送量查询_用户性别查询();
        h4_1业务统计_获取各渠道业务统计数据_man.setMc_性别(e.getKey());
        h4_1业务统计_获取各渠道业务统计数据_man.setCount_人数(Integer.valueOf(e.getValue().size()).toString());
        return h4_1业务统计_获取各渠道业务统计数据_man;
    });
     //   System.out.println("mi029_综合服务个人用户基础信息表_repository ---------- "+ count);






   count.stream().filter(e->{
        if(e.getCertinum()== null){
            System.out.println("getCertinum 为空");
        }
        return e.getCertinum()!= null;

    }).collect(Collectors.groupingBy(e->{
        Map map = new HashMap();


       try {
           map = CardJunit.identityCard18(e.getCertinum());
           if((Integer)map.get("age")<= 20){
               return 1;
           }
           if((Integer)map.get("age")<= 40 && (Integer)map.get("age")> 20){
               return 2;
           }
           if((Integer)map.get("age")<= 60 && (Integer)map.get("age")> 40){
               return 3;
           }
           if((Integer)map.get("age")>= 60){
               return 4;
           }
           return 0;
       } catch (Exception ex) {
           System.out.println("--e.getCertinum()---------------"+e.getCertinum());
           ex.printStackTrace();
           return 0;
       }


    })).entrySet().stream().forEach(e->{
        System.out.println("H9_7信息推送量查询_用户年龄信息查询 ---------- "+ e.getKey());
        H9_7信息推送量查询_用户年龄信息查询 h9_7信息推送量查询_用户年龄信息查询 = new H9_7信息推送量查询_用户年龄信息查询();
        if(e.getKey()== 1){
            h9_7信息推送量查询_用户年龄信息查询.setNl1_年龄_小于20岁(Integer.valueOf(e.getValue().size()).toString());
        }
       if(e.getKey()== 2){
           h9_7信息推送量查询_用户年龄信息查询.setNl2_年龄_20_40(Integer.valueOf(e.getValue().size()).toString());
       }
       if(e.getKey()== 3){
           h9_7信息推送量查询_用户年龄信息查询.setNl3_年龄_40_60(Integer.valueOf(e.getValue().size()).toString());
       }
       if(e.getKey()== 4){
           h9_7信息推送量查询_用户年龄信息查询.setNl4_年龄_60岁以上(Integer.valueOf(e.getValue().size()).toString());
       }


    });


    }

}
