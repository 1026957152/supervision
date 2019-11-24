package org.ylgjj.loan.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.pojo.QueryH_2_5_业务指标_多维度查询;
import org.ylgjj.loan.service.B归集ServiceImpl;
import org.ylgjj.loan.service.H4业务统计ServiceImpl;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/JG/dzbfx")
public class H2业务指标Controller {


    @Autowired
    B归集ServiceImpl b归集Service;


    @Autowired
    H4业务统计ServiceImpl h4业务统计ServiceImpl;


    public class QueryH_4_1_业务统计_获取各渠道业务统计数据 {
        @NotBlank
        String zjbzxbm;
        @NotBlank
        String ksrq; //开始日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        String jsrq; //结束日期	String	输入(必传)	长度：10，举例：2019-07-03
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

    @RequestMapping(value = "/more_target_add.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_1_业务指标_添加常用指标(
            @Valid @RequestBody  QueryH_4_1_业务统计_获取各渠道业务统计数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return null;//h4业务统计ServiceImpl.H_4_1_业务统计_获取各渠道业务统计数据(query);
    }

    @RequestMapping(value = "/more_target_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_1_业务指标_查询常用指标(
            @Valid @RequestBody  QueryH_4_1_业务统计_获取各渠道业务统计数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return null;//h4业务统计ServiceImpl.H_4_1_业务统计_获取各渠道业务统计数据(query);
    }
    @RequestMapping(value = "/more_target_value_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_3_业务指标_常用指标数据查询(
            @Valid @RequestBody  QueryH_4_1_业务统计_获取各渠道业务统计数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return null;//h4业务统计ServiceImpl.H_4_1_业务统计_获取各渠道业务统计数据(query);
    }

    @RequestMapping(value = "/more_tree_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_4_业务指标_多指标树查询(
            @Valid @RequestBody  QueryH_4_1_业务统计_获取各渠道业务统计数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return null;//h4业务统计ServiceImpl.H_4_1_业务统计_获取各渠道业务统计数据(query);
    }







    @RequestMapping(value = "/more_dimension_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_5_业务指标_多维度查询(
            @Valid @RequestBody QueryH_2_5_业务指标_多维度查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());

        if(StatisticalIndexCodeEnum.S_6_SEQ_新增单位数_AND_0301000501.get指标编码().equals(query.getTarget())){
            return b归集Service.S_6_SEQ_新增单位数_AND_0301000501("","",null,
                    null,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }
        if(StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201.get指标编码().equals(query.getTarget())){
            return b归集Service.S_2_SEQ_实缴单位数_AND_0301000201("","",null,
                    null,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }


        return null;
    }
    @RequestMapping(value = "/more_grid_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_6_业务指标_网格查询(
            @Valid @RequestBody  QueryH_4_1_业务统计_获取各渠道业务统计数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return null;//h4业务统计ServiceImpl.H_4_1_业务统计_获取各渠道业务统计数据(query);
    }

    @RequestMapping(value = "/more_chart_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_6_业务指标_表格查询(
            @Valid @RequestBody  QueryH_4_1_业务统计_获取各渠道业务统计数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return null;//h4业务统计ServiceImpl.H_4_1_业务统计_获取各渠道业务统计数据(query);
    }


}












