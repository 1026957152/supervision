package org.ylgjj.loan.api;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.pojo.Output_totalcount;
import org.ylgjj.loan.pojo.QueryH_4_1_业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.service.H4_1_业务统计_获取各渠道业务统计数据ServiceImpl;

import javax.validation.Valid;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController

@Api
@RequestMapping("/JG/bbgl")
public class H4业务统计Controller {




    @Autowired
    H4_1_业务统计_获取各渠道业务统计数据ServiceImpl h41业务统计获取各渠道业务统计数据ServiceImpl;



    @RequestMapping(value = "/ywtj_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output_totalcount H_4_1_业务统计_获取各渠道业务统计数据(
            @Valid @RequestBody QueryH_4_1_业务统计_获取各渠道业务统计数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output_totalcount.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h41业务统计获取各渠道业务统计数据ServiceImpl.H_4_1_业务统计_获取各渠道业务统计数据(query);
    }




}












