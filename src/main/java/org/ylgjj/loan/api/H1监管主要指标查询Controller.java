package org.ylgjj.loan.api;


import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.pojo.QueryH_1_2_监管主要指标查询_公积金中心主要运行情况查询;
import org.ylgjj.loan.pojo.QueryH_1_3_监管主要指标查询_指标明细查询;
import org.ylgjj.loan.pojo.QueryH_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分;
import org.ylgjj.loan.service.H1_2监管主要指标查询_公积金中心主要运行情况查询ServiceImpl;
import org.ylgjj.loan.service.H1_3监管主要指标查询_指标明细查询ServiceImpl;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/JG/common")
@Api//(tags = "H1监管主要指标查询Controller")
public class H1监管主要指标查询Controller {



    @Autowired
    H1_2监管主要指标查询_公积金中心主要运行情况查询ServiceImpl h1_2监管主要指标查询_公积金中心主要运行情况查询Service;
    @Autowired
    H1_3监管主要指标查询_指标明细查询ServiceImpl h1_3监管主要指标查询_指标明细查询Service;


   // @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, paramType = "body", dataType = "QueryH_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分")

/*    @ApiImplicitParams({
            @ApiImplicitParam(name = "zjbzxbm",paramType = "query",value = "住建部中心编码",required = true),
         //   @ApiImplicitParam(name = "age",paramType = "query",value = "年龄",required = true)
    })*/
/*    @ApiResponses({
            @ApiResponse(code = 401,message = "你没权限"),
            @ApiResponse(code = 403,message = "你被禁止访问了"),
            @ApiResponse(code = 404,message = "没找到，哈哈哈")
    })*/
   // @ApiOperation("获取个人信息") //说明方法的作用
    @RequestMapping(value = "/get_zbnd.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_1_1_监管主要指标查询_公积金年度查询(
            @Valid @RequestBody QueryH_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h1_2监管主要指标查询_公积金中心主要运行情况查询Service.H_1_1_监管主要指标查询_公积金年度查询(query.getZjbzxbm());

        //return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();


    }


    @RequestMapping(value = "/get_business_data.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_1_2_监管主要指标查询_公积金中心主要运行情况查询(/*@Valid */@RequestBody QueryH_1_2_监管主要指标查询_公积金中心主要运行情况查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
/*        query.setKsrq("2019-09-11");
        query.setJsrq("2019-11-30");*/
        System.out.println("----------------- "+ query.toString());

        return h1_2监管主要指标查询_公积金中心主要运行情况查询Service.H_1_2_监管主要指标查询_公积金中心主要运行情况查询(
                query.getKsrq(),
                query.getJsrq()
                );
    }



    //TODO ??????? dzbfx

    @RequestMapping(value = "/more_grid_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_1_3_监管主要指标查询_指标明细查询(@Valid /*@RequestBody*/ @RequestBody QueryH_1_3_监管主要指标查询_指标明细查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }


        try{
            return h1_3监管主要指标查询_指标明细查询Service.H_1_3_监管主要指标查询_指标明细查询(query);
        }catch (Exception e){

            Output output = new Output();
            output.setSuccess(false);
            output.setMessage(e.toString());
            return output;
        }


    }
    @ApiIgnore
    @RequestMapping(value = "/get_fwxl.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_1_4_监管主要指标查询_离柜率明细查询(@Valid /*@RequestBody*/ @RequestBody QueryH_1_3_监管主要指标查询_指标明细查询 query, Errors errors)  {
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












