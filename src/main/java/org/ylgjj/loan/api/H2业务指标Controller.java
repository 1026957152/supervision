package org.ylgjj.loan.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.pojo.*;
import org.ylgjj.loan.service.*;

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
    H2统计指标ServiceImpl h2统计指标Service;
    @Autowired
    B提取ServiceImpl b提取Service;

    @Autowired
    B开户ServiceImpl b开户Service;



    @RequestMapping(value = "/more_target_add.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_1_业务指标_添加常用指标(
            @Valid @RequestBody QueryH_2_1_业务指标_添加常用指标 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h2统计指标Service.H_2_1_业务指标_添加常用指标(query);
    }







    @RequestMapping(value = "/more_target_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_2_业务指标_查询常用指标(
            @Valid @RequestBody QueryH_2_2_业务指标_查询常用指标 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h2统计指标Service.H_2_2_业务指标_查询常用指标(query);
    }



    @RequestMapping(value = "/more_target_value_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_3_业务指标_常用指标数据查询(
            @Valid @RequestBody QueryH_2_3_业务指标_常用指标数据查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h2统计指标Service.H_2_3_业务指标_常用指标数据查询(query);
    }

    @RequestMapping(value = "/more_tree_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_4_业务指标_多指标树查询(
            @Valid @RequestBody QueryH_2_4_业务指标_多指标树查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h2统计指标Service.H_2_4_业务指标_多指标树查询(query);
    }







    @RequestMapping(value = "/more_dimension_cx.service", method = RequestMethod.GET)
    @ResponseBody
    public Output H_2_5_业务指标_多维度查询(@RequestParam(value = "target") String target,
            /*@Valid @RequestBody*/ QueryH_2_5_业务指标_多维度查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }

        query.setJsrq("2019-11-28");
        query.setKsrq("2019-10-01");
        System.out.println("----------------- "+ query.toString());

        query.setTarget(target);
        if(StatisticalIndexCodeEnum.S_6_SEQ_新增单位数_AND_0301000501.get指标编码().equals(query.getTarget())){
            return b归集Service.S_6_SEQ_新增单位数_AND_0301000501("","",null,
                    null,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }
        if(StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201.get指标编码().equals(query.getTarget())){
            return b归集Service.S_2_SEQ_实缴单位数_AND_0301000201("","",null,
                    null,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }
        if(StatisticalIndexCodeEnum.S_37_SEQ_提取人数__提取原因___AND_0301003911.get指标编码().equals(query.getTarget())){
            return b提取Service.S_37_SEQ_提取人数__提取原因___AND_0301003911("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }










        if(StatisticalIndexCodeEnum.S_58_SEQ_外部转入金额_AND_0301007801.get指标编码().equals(query.getTarget())){
            return b提取Service.S_58_SEQ_外部转入金额_AND_0301007801("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }


        if(StatisticalIndexCodeEnum.S_40_SEQ_外部转入人数_AND_0301004101.get指标编码().equals(query.getTarget())){
            return b开户Service.S_40_SEQ_外部转入人数_AND_0301004101("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }
        if(StatisticalIndexCodeEnum.S_41_SEQ_外部转出人数_AND_0301004201.get指标编码().equals(query.getTarget())){
            return b开户Service.S_41_SEQ_外部转出人数_AND_0301004201("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }
        if(StatisticalIndexCodeEnum.S_59_SEQ_外部转出金额__本金___AND_0301007901.get指标编码().equals(query.getTarget())){
            return b提取Service.S_59_SEQ_外部转出金额__本金___AND_0301007901("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }

        if(StatisticalIndexCodeEnum.S_60_SEQ_外部转出金额__利息___AND_0301007902.get指标编码().equals(query.getTarget())){
            return b提取Service.S_60_SEQ_外部转出金额__利息___AND_0301007902("","",null,
                    统计周期编码.H__03_每月,StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()),query.getKsrq(),query.getJsrq());
        }



        return null;
    }
    @RequestMapping(value = "/more_grid_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_6_业务指标_网格查询(
            @Valid @RequestBody  QueryH_2_6_业务指标_网格查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h2统计指标Service.H_2_6_业务指标_网格查询(query);
    }

    @RequestMapping(value = "/more_chart_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_7_业务指标_表格查询(
            @Valid @RequestBody  QueryH_2_7_业务指标_表格查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h2统计指标Service.H_2_7_业务指标_表格查询(query);
    }


}












