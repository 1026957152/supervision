package org.ylgjj.loan.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.pojo.QueryH_1_2_监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.repository.FD045_资金划转业务登记文件Repository;
import org.ylgjj.loan.service.H1_2监管主要指标查询_公积金中心主要运行情况查询ServiceImpl;
import org.ylgjj.loan.service.H1_3监管主要指标查询_指标明细查询ServiceImpl;
import org.ylgjj.loan.service.H3银行实时交易ServiceImpl;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/JG/common")
public class H1监管主要指标查询Controller {



    @Autowired
    H1_2监管主要指标查询_公积金中心主要运行情况查询ServiceImpl h1_2监管主要指标查询_公积金中心主要运行情况查询Service;
    @Autowired
    H1_3监管主要指标查询_指标明细查询ServiceImpl h1_3监管主要指标查询_指标明细查询Service;


    public class QueryH_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分 {
        @NotBlank
        String zjbzxbm;
        public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }
    }

    @RequestMapping(value = "/get_zbnd.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_1_1_监管主要指标查询_公积金年度查询(
            @Valid @RequestBody  QueryH_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h1_2监管主要指标查询_公积金中心主要运行情况查询Service.H_1_1_监管主要指标查询_公积金年度查询(query.getZjbzxbm());

        //return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();


    }


    @RequestMapping(value = "/get_business_data.service", method = RequestMethod.GET)
    @ResponseBody
    public Output H_1_2_监管主要指标查询_公积金中心主要运行情况查询(/*@Valid *//*@RequestBody*//* @RequestBody */QueryH_1_2_监管主要指标查询_公积金中心主要运行情况查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        query.setKsrq("2019-09-11");
        query.setJsrq("2019-11-30");
        System.out.println("----------------- "+ query.toString());

        return h1_3监管主要指标查询_指标明细查询Service.H_1_2_监管主要指标查询_公积金中心主要运行情况查询(
                query.getKsrq(),
                query.getJsrq()
                );
    }



    public class QueryH_1_2_监管主要指标查询_指标明细查询 {

        @NotBlank
        String zjbzxbm; //zjbzxbm	住建部中心编码	String	输入(必传)	  长度：6，举例：C61010

        @NotBlank
        String dimension1; //维度1	String	输入(必传)
        @NotBlank
        String dimension2; //维度2	String	输入(必传)
        @NotBlank
        String dimension3; //维度3	String	输入(必传)
        @NotBlank
        String tjzq; //统计周期	String	输入(必传) 对应编码规则中统计周期编码的编码值
        @NotBlank
        String rows; //行	String	输入(必传) 可以忽略

        @NotBlank
        String order; //String	输入(必传) 举例：1,2,3,4或者4,3,2,1任意排序组合

        @NotBlank
        String target; //目标	String	输入(必传) 对应编码规则中统计指标编码的指标编码，举例：0301000101












        @NotBlank
        String ksrq; //开始日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        String jsrq; //结束日期	String	输入(必传)	长度：10，举例：2019-07-03

        public String getDimension1() {
            return dimension1;
        }

        public void setDimension1(String dimension1) {
            this.dimension1 = dimension1;
        }

        public String getDimension2() {
            return dimension2;
        }

        public void setDimension2(String dimension2) {
            this.dimension2 = dimension2;
        }

        public String getDimension3() {
            return dimension3;
        }

        public void setDimension3(String dimension3) {
            this.dimension3 = dimension3;
        }

        public String getTjzq() {
            return tjzq;
        }

        public void setTjzq(String tjzq) {
            this.tjzq = tjzq;
        }

        public String getRows() {
            return rows;
        }

        public void setRows(String rows) {
            this.rows = rows;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }

        public String getKsrq() {
            return ksrq;
        }

        public void setKsrq(String ksrq) {
            this.ksrq = ksrq;
        }

        public String getJsrq() {
            return jsrq;
        }

        public void setJsrq(String jsrq) {
            this.jsrq = jsrq;
        }


    }
    //TODO ??????? dzbfx

    @RequestMapping(value = "/more_grid_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_1_3_监管主要指标查询_指标明细查询(@Valid /*@RequestBody*/ @RequestBody  QueryH_1_2_监管主要指标查询_指标明细查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }


        System.out.println("----------------- "+ query.toString());

        return h1_3监管主要指标查询_指标明细查询Service.H_1_2_监管主要指标查询_指标明细查询(
                query.getDimension1(),
                query.getDimension2(),
                query.getDimension3(),
                统计周期编码.valueOf(query.getTjzq()),
                StatisticalIndexCodeEnum.valueOf(query.getTarget()),
                query.getKsrq(),
                query.getJsrq()
        );
    }

    @RequestMapping(value = "/get_fwxl.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_1_4_监管主要指标查询_离柜率明细查询(@Valid /*@RequestBody*/ @RequestBody  QueryH_1_2_监管主要指标查询_指标明细查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }


        System.out.println("----------------- "+ query.toString());

        return h1_3监管主要指标查询_指标明细查询Service.H_1_4_监管主要指标查询_离柜率明细查询(
                query.getDimension1(),
                query.getDimension2(),
                query.getDimension3(),
                统计周期编码.valueOf(query.getTjzq()),
                StatisticalIndexCodeEnum.valueOf(query.getTarget()),
                query.getKsrq(),
                query.getJsrq()
        );
    }




}












