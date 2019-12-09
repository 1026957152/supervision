package org.ylgjj.loan.api;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.pojo.QueryH10_1逾期监管_逾期监管汇总查询;
import org.ylgjj.loan.pojo.QueryH10_2逾期监管_逾期监管明细查询;
import org.ylgjj.loan.service.H10逾期监管ServiceImpl;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * Created by zohu on 6/29/2015.
 */

@Api
@RestController
@RequestMapping("/JG/yqqk")
public class H10逾期监管Controller {



    @Autowired
    H10逾期监管ServiceImpl h10逾期监管Service;



    @RequestMapping(value = "/get_yqqk_DataCx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H10_1逾期监管_逾期监管汇总查询(@Valid @RequestBody QueryH10_1逾期监管_逾期监管汇总查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h10逾期监管Service.H10_1逾期监管_逾期监管汇总查询(query.getZjbzxbm());
    }


        @RequestMapping(value = "/jg_yqqk_gdyqqk_tc.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H10_2逾期监管_逾期监管明细查询(@Valid @RequestBody QueryH10_2逾期监管_逾期监管明细查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }


        System.out.println("----------------- "+ query.toString());

        return h10逾期监管Service.H10_2逾期监管_逾期监管明细查询(query);
    }




}












