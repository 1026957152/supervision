package org.ylgjj.loan.api;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.output.H5_1离柜率_离柜率查询;
import org.ylgjj.loan.pojo.Output_totalcount;
import org.ylgjj.loan.pojo.QueryH8_1银行专户余额_银行专户余额查询;
import org.ylgjj.loan.pojo.QueryH_5_1离柜率_离柜率查询;
import org.ylgjj.loan.service.H5离柜率ServiceImpl;
import org.ylgjj.loan.service.H8银行专户余额ServiceImpl;

import javax.validation.Valid;

/**
 * Created by zohu on 6/29/2015.
 */
@Api
@RestController
@RequestMapping("/JG/zjlxjk")
public class H5离柜率Controller {


    @Autowired
    H5离柜率ServiceImpl h5离柜率Service;




    @RequestMapping(value = "/lgl_cx.service", method = RequestMethod.POST)
    @ResponseBody

    public Output_totalcount H5_1离柜率_离柜率查询(@Valid @RequestBody QueryH_5_1离柜率_离柜率查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output_totalcount.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h5离柜率Service.H5_1离柜率_离柜率查询(query);
    }




















}












