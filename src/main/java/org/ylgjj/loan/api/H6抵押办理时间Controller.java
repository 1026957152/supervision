package org.ylgjj.loan.api;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.pojo.QueryH10_1逾期监管_逾期监管汇总查询;
import org.ylgjj.loan.pojo.QueryH10_2逾期监管_逾期监管明细查询;
import org.ylgjj.loan.pojo.QueryH6_1抵押办理时间_抵押物数据查询;
import org.ylgjj.loan.pojo.QueryH6_2抵押办理时间_抵押物明细数据查询;
import org.ylgjj.loan.service.H10逾期监管ServiceImpl;
import org.ylgjj.loan.service.H6抵押办理时间ServiceImpl;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/JG/dyw")
@Api
public class H6抵押办理时间Controller {


    @Autowired
    H6抵押办理时间ServiceImpl h6抵押办理时间Service;



    @ApiIgnore
    @RequestMapping(value = "/get_dywData.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H6_1抵押办理时间_抵押物数据查询(@Valid @RequestBody QueryH6_1抵押办理时间_抵押物数据查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h6抵押办理时间Service.H6_1抵押办理时间_抵押物数据查询(query.getZjbzxbm());
    }


    @RequestMapping(value = "/jg_yqqk_gdyqqk_tc.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H6_2抵押办理时间_抵押物明细数据查询(@Valid @RequestBody QueryH6_2抵押办理时间_抵押物明细数据查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h6抵押办理时间Service.H6_2抵押办理时间_抵押物明细数据查询(query);
    }

















}












