package org.ylgjj.loan.api;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.pojo.*;
import org.ylgjj.loan.service.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/JG/dzbfx")
@Api
public class H2业务指标Controller {




    @Autowired
    H2_业务指标_ServiceImpl h2统计指标Service;


    @Autowired
    H2_7_业务指标_表格查询_ServiceImpl h27_业务指标_表格查询_service;
    @Autowired
    H2_6_业务指标_网格查询_ServiceImpl h2_6_业务指标_网格查询_service;
    @Autowired
    H2_3_业务指标_常用指标数据查询_ServiceImpl h2_3_业务指标_常用指标数据查询_service;


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
    public Output_data H_2_3_业务指标_常用指标数据查询(
            @Valid @RequestBody QueryH_2_3_业务指标_常用指标数据查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output_data.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h2_3_业务指标_常用指标数据查询_service.H_2_3_业务指标_常用指标数据查询(query);
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







    @RequestMapping(value = "/more_dimension_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_2_5_业务指标_多维度查询(@Valid @RequestBody QueryH_2_5_业务指标_多维度查询 query, Errors errors)  {
        return h2统计指标Service.H_2_5_业务指标_多维度查询(query);
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


        return h2_6_业务指标_网格查询_service.H_2_6_业务指标_网格查询(query);


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
        return h27_业务指标_表格查询_service.H_2_7_业务指标_表格查询(query);
    }


}












