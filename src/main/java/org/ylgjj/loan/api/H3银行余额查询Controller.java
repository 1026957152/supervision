package org.ylgjj.loan.api;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.pojo.QueryH_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分;
import org.ylgjj.loan.pojo.QueryH_3_2_银行余额查询_银行余额查询;
import org.ylgjj.loan.repository.FD045_资金划转业务登记文件Repository;
import org.ylgjj.loan.service.H10逾期监管ServiceImpl;
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








    public class QueryH_3_3_银行余额查询_银行实时交易 {
        @NotBlank
        String zjbzxbm;
        @NotBlank
        String ksrq; //开始日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        String jsrq; //结束日期	String	输入(必传)	长度：10，举例：2019-07-03
        public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }

        public String getKsrq() {
            return ksrq;
        }

        public void setKsrq(String ksrq) {
            this.ksrq = ksrq;
        }

        public String getJsrq() {
            return jsrq;
        }

        public void setJsrq(String jsrq) {
            this.jsrq = jsrq;
        }
    }


    @ApiIgnore
    @RequestMapping(value = "/get_all_bank_sszhmx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_3_3_银行余额查询_银行实时交易(@Valid /*@RequestBody*/ @RequestBody  QueryH_3_3_银行余额查询_银行实时交易 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h3银行实时交易Service.H_3_3_银行余额查询_银行实时交易(query);
    }


    public class QueryH_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据 {
        @NotBlank
        String zjbzxbm;
        @NotBlank
        String ksrq; //开始日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        String jsrq; //结束日期	String	输入(必传)	长度：10，举例：2019-07-03
        public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }

        public String getKsrq() {
            return ksrq;
        }

        public void setKsrq(String ksrq) {
            this.ksrq = ksrq;
        }

        public String getJsrq() {
            return jsrq;
        }

        public void setJsrq(String jsrq) {
            this.jsrq = jsrq;
        }
    }

    @RequestMapping(value = "/get_jymx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据(
            @Valid /*@RequestBody*/ @RequestBody  QueryH_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h3银行实时交易Service.H_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据(query);
    }



    public class QueryH_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据 {

        @NotBlank
        String zjbzxbm; //zjbzxbm	住建部中心编码	String	输入(必传)	  长度：6，举例：C61010
        @NotBlank
        String ksrq; //开始日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        String jsrq; //结束日期	String	输入(必传)	长度：10，举例：2019-07-03
        @NotBlank
        Integer pagesize; //pageSize	分页每页显示条数	Int		10
        @NotBlank
        Integer pagenum; //pageNumber	分页显示页面	int		1
        @NotBlank
        String bm;
        public String getZjbzxbm() {
            return zjbzxbm;
        }
        public void setZjbzxbm(String zjbzxbm) {
            this.zjbzxbm = zjbzxbm;
        }

        public String getKsrq() {
            return ksrq;
        }

        public void setKsrq(String ksrq) {
            this.ksrq = ksrq;
        }

        public String getJsrq() {
            return jsrq;
        }

        public void setJsrq(String jsrq) {
            this.jsrq = jsrq;
        }

        public Integer getPagesize() {
            return pagesize;
        }

        public void setPagesize(Integer pagesize) {
            this.pagesize = pagesize;
        }

        public Integer getPagenum() {
            return pagenum;
        }

        public void setPagenum(Integer pagenum) {
            this.pagenum = pagenum;
        }

        public String getBm() {
            return bm;
        }

        public void setBm(String bm) {
            this.bm = bm;
        }
    }
    @ApiIgnore
    @RequestMapping(value = "/get_yhlsjymx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据(
            @Valid /*@RequestBody*/ @RequestBody  QueryH_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h3银行实时交易Service.H_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据(query);
    }







}












