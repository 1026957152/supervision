package org.ylgjj.loan.api;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.pojo.*;
import org.ylgjj.loan.repository.FD045_资金划转业务登记文件Repository;
import org.ylgjj.loan.service.H3银行实时交易ServiceImpl;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Created by zohu on 6/29/2015.
 */
@Api//(tags = "H3银行余额查询Controller")
@RestController
@RequestMapping("/JG/zjlxjk")
public class H3银行余额查询Controller {


    @Autowired
    FD045_资金划转业务登记文件Repository fd045_资金划转业务登记文件Repository;


    @Autowired
    H3银行实时交易ServiceImpl h3银行实时交易Service;



    @RequestMapping(value = "/get_all_bank.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分(
            @Valid @RequestBody QueryH_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h3银行实时交易Service.H_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分(query.getZjbzxbm());
    }


    @RequestMapping(value = "/get_bank_ye.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_3_2_银行余额查询_银行余额查询(@Valid /*@RequestBody*/ @RequestBody QueryH_3_2_银行余额查询_银行余额查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }

        System.out.println("----------------- "+ query.toString());
        return  h3银行实时交易Service.H_3_2_银行余额查询_银行余额查询(query);
    }











    @RequestMapping(value = "/get_all_bank_sszhmx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_3_3_银行余额查询_银行实时交易(@Valid @RequestBody QueryH_3_3_银行余额查询_银行实时交易 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h3银行实时交易Service.H_3_3_银行余额查询_银行实时交易(query);
    }




    @RequestMapping(value = "/get_jymx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据(
            @Valid  @RequestBody QueryH_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h3银行实时交易Service.H_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据(query);
    }





    @RequestMapping(value = "/get_yhlsjymx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据(
            @Valid  @RequestBody QueryH_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h3银行实时交易Service.H_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据(query);
    }







}












