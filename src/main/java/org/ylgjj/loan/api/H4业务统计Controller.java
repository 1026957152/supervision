package org.ylgjj.loan.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.pojo.QueryH_4_1_业务统计_获取各渠道业务统计数据;
import org.ylgjj.loan.repository.FD045_资金划转业务登记文件Repository;
import org.ylgjj.loan.service.H3银行实时交易ServiceImpl;
import org.ylgjj.loan.service.H4业务统计ServiceImpl;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/JG/bbgl")
public class H4业务统计Controller {




    @Autowired
    H4业务统计ServiceImpl h4业务统计ServiceImpl;



    @RequestMapping(value = "/ywtj_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_4_1_业务统计_获取各渠道业务统计数据(
            @Valid @RequestBody QueryH_4_1_业务统计_获取各渠道业务统计数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h4业务统计ServiceImpl.H_4_1_业务统计_获取各渠道业务统计数据(query);
    }




}












