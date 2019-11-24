package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.api.H9服务统计Controller;
import org.ylgjj.loan.domain.Data;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;

import org.ylgjj.loan.output.*;
import org.ylgjj.loan.repository.AN004Repository;
import org.ylgjj.loan.repository.PB010_bank_info_大行信息表Repository;
/*
import org.ylgjj.loan.repository_zhongfu.MI007_系统码表_Repository;
import org.ylgjj.loan.repository_zhongfu.MI029_综合服务个人用户基础信息表_Repository;
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
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



    public Output H_9_1_服务统计_信息推送量查询(H9服务统计Controller.QueryH_9_1_服务统计_信息推送量查询 query) {

        H9_1信息推送量查询_信息推送量查询 h4_1业务统计_获取各渠道业务统计数据 = new H9_1信息推送量查询_信息推送量查询();
        DoubleSummaryStatistics 归集 = null;//归集(query);

        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据);
        output.setData(a);
        return output;
    }


    public Output H_9_2_服务统计_渠道访问总量查询(H9服务统计Controller.QueryH_9_2_服务统计_渠道访问总量查询 query) {

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

        return null;
    }
    

    public Output H_9_3_服务统计_用户注册分布查询(H9服务统计Controller.QueryH_9_3_服务统计_用户注册分布查询 query) {

        H9_3信息推送量查询_用户注册分布查询 h4_1业务统计_获取各渠道业务统计数据 = new H9_3信息推送量查询_用户注册分布查询();

        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据);
        output.setData(a);
        return output;
    }

    public Output H_9_4_服务统计_用户性别查询(H9服务统计Controller.QueryH_9_4_服务统计_用户性别查询 query) {

/*        List<MI029_综合服务个人用户基础信息表> mi029_综合服务个人用户基础信息表s = mi029_综合服务个人用户基础信息表_repository.findAll();




        mi029_综合服务个人用户基础信息表s.stream().forEach(e->{
            if(e.getCERTINUM()== ""){
                nl1_年龄_小于20岁++;
            }
            if(e.getCERTINUM()== ""){
                nl1_年龄_小于20岁++;
            }
            if(e.getCERTINUM()== ""){
                nl1_年龄_小于20岁++;
            }
            if(e.getCERTINUM()== ""){
                nl1_年龄_小于20岁++;
            }
        });*/
        H9_4信息推送量查询_用户性别查询 h4_1业务统计_获取各渠道业务统计数据_man = new H9_4信息推送量查询_用户性别查询();

        h4_1业务统计_获取各渠道业务统计数据_man.setCount_人数(nl1_年龄_小于20岁.toString());
        h4_1业务统计_获取各渠道业务统计数据_man.setMc_性别(nl1_年龄_小于20岁.toString());
        H9_4信息推送量查询_用户性别查询 h4_1业务统计_获取各渠道业务统计数据_femail = new H9_4信息推送量查询_用户性别查询();

        h4_1业务统计_获取各渠道业务统计数据_femail.setCount_人数(nl1_年龄_小于20岁.toString());
        h4_1业务统计_获取各渠道业务统计数据_femail.setMc_性别(nl1_年龄_小于20岁.toString());
        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据_man);
        a.add(h4_1业务统计_获取各渠道业务统计数据_femail);
        output.setData(a);
        return output;
    }


/*
    public Output H_9_5_服务统计_短信发送量查询(H9服务统计Controller.QueryH_9_5_服务统计_短信发送量查询 query) {

        H9_5信息推送量查询_短信发送量查询 h4_1业务统计_获取各渠道业务统计数据 = new H9_5信息推送量查询_短信发送量查询();

        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据);
        output.setData(a);
        return output;
    }


    public Output H_9_6_服务统计_渠道登录次数查询(H9服务统计Controller.QueryH_9_6_服务统计_渠道登录次数查询 query) {

        H9_6信息推送量查询_渠道登录次数查询 h4_1业务统计_获取各渠道业务统计数据 = new H9_6信息推送量查询_渠道登录次数查询();

        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据);
        output.setData(a);
        return output;
    }*/

    static Integer nl1_年龄_小于20岁 = null,nl2_年龄_20_40,nl3_年龄_40_60,nl4_年龄_60岁以上= null;

    public Output H_9_7_服务统计_用户年龄信息查询(H9服务统计Controller.QueryH_9_7_服务统计_用户年龄信息查询 query) {

       // List<MI029_综合服务个人用户基础信息表> mi029_综合服务个人用户基础信息表s = mi029_综合服务个人用户基础信息表_repository.findAll();
        H9_7信息推送量查询_用户年龄信息查询 h4_1业务统计_获取各渠道业务统计数据 = new H9_7信息推送量查询_用户年龄信息查询();


/*

        mi029_综合服务个人用户基础信息表s.stream().forEach(e->{
            if(e.getCERTINUM()== ""){
                nl1_年龄_小于20岁++;
            }
            if(e.getCERTINUM()== ""){
                nl1_年龄_小于20岁++;
            }
            if(e.getCERTINUM()== ""){
                nl1_年龄_小于20岁++;
            }
            if(e.getCERTINUM()== ""){
                nl1_年龄_小于20岁++;
            }
        });*/
        h4_1业务统计_获取各渠道业务统计数据.setNl1_年龄_小于20岁(nl1_年龄_小于20岁.toString());
        h4_1业务统计_获取各渠道业务统计数据.setNl1_年龄_小于20岁(nl1_年龄_小于20岁.toString());
        h4_1业务统计_获取各渠道业务统计数据.setNl1_年龄_小于20岁(nl1_年龄_小于20岁.toString());
        h4_1业务统计_获取各渠道业务统计数据.setNl1_年龄_小于20岁(nl1_年龄_小于20岁.toString());
        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据);
        output.setData(a);
        return output;
    }

    public Output H_9_5_服务统计_短信发送量查询(H9服务统计Controller.QueryH_9_5_服务统计_短信发送量查询 query) {
        return null;
    }

    public Output H_9_6_服务统计_渠道登录次数查询(H9服务统计Controller.QueryH_9_6_服务统计_渠道登录次数查询 query) {
        return null;
    }

    public Output H_9_8_服务统计_各渠道API总量(H9服务统计Controller.QueryH_9_8_服务统计_各渠道API总量 query) {
        return null;
    }

/*    public Output H_9_8_服务统计_各渠道API总量(H9服务统计Controller.QueryH_9_8_服务统计_各渠道API总量 query) {

        H9_8信息推送量查询_各渠道API总量 h4_1业务统计_获取各渠道业务统计数据 = new H9_8信息推送量查询_各渠道API总量();

        Output output = new Output();
        List<Object> a = new ArrayList<>();
        a.add(h4_1业务统计_获取各渠道业务统计数据);
        output.setData(a);
        return output;
    }*/
}
