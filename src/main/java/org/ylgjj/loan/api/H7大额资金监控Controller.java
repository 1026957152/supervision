package org.ylgjj.loan.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.pojo.QueryH_7_1_大额资金监控_监控数据明细查询;
import org.ylgjj.loan.pojo.QueryH_7_2_大额资金监控_大额资金监控汇总数据查询;
import org.ylgjj.loan.repository.FD045_资金划转业务登记文件Repository;
import org.ylgjj.loan.service.H3银行实时交易ServiceImpl;
import org.ylgjj.loan.service.H7大额资金监控ServiceImpl;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/JG/zjlxjk")
public class H7大额资金监控Controller {


    @Autowired
    FD045_资金划转业务登记文件Repository fd045_资金划转业务登记文件Repository;


    @Autowired
    H7大额资金监控ServiceImpl h7大额资金监控Service;



    @RequestMapping(value = "/dezjjk_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_7_1_大额资金监控_监控数据明细查询(@Valid /*@RequestBody*/ @RequestBody QueryH_7_1_大额资金监控_监控数据明细查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }

        System.out.println("----------------- "+ query.toString());

        return  h7大额资金监控Service.H_7_1_大额资金监控_监控数据明细查询(query.getZjbzxbm(),query.getKsrq(),query.getJsrq());
    }



    @RequestMapping(value = "/dezjjk_chart_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_7_2_大额资金监控_大额资金监控汇总数据查询(@Valid /*@RequestBody*/ @RequestBody QueryH_7_2_大额资金监控_大额资金监控汇总数据查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }

        System.out.println("----------------- "+ query.toString());
        return h7大额资金监控Service.H_7_2_大额资金监控_大额资金监控汇总数据查询(query);
    }



}












