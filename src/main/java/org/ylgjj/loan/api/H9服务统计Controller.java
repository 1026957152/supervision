package org.ylgjj.loan.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.service.H9服务统计ServiceImpl;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/JG/zhfwpt")
public class H9服务统计Controller {




    @Autowired
    H9服务统计ServiceImpl h9服务统计Service;


    public class QueryH_9_1_服务统计_信息推送量查询 {
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

    @RequestMapping(value = "/xxtsl_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_9_1_服务统计_信息推送量查询(
            @Valid @RequestBody  QueryH_9_1_服务统计_信息推送量查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h9服务统计Service.H_9_1_服务统计_信息推送量查询(query);
    }


    public class QueryH_9_2_服务统计_渠道访问总量查询 {
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

    @RequestMapping(value = "/qdfwzl_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_9_2_服务统计_渠道访问总量查询(
            @Valid @RequestBody  QueryH_9_2_服务统计_渠道访问总量查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h9服务统计Service.H_9_2_服务统计_渠道访问总量查询(query);
    }
    public class QueryH_9_3_服务统计_用户注册分布查询 {
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

    @RequestMapping(value = "/yhzcfb_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_9_3_服务统计_用户注册分布查询(
            @Valid @RequestBody  QueryH_9_3_服务统计_用户注册分布查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h9服务统计Service.H_9_3_服务统计_用户注册分布查询(query);
    }












    public class QueryH_9_4_服务统计_用户性别查询 {
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

    @RequestMapping(value = "/yhxbxx_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_9_4_服务统计_用户性别查询(
            @Valid @RequestBody  QueryH_9_4_服务统计_用户性别查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h9服务统计Service.H_9_4_服务统计_用户性别查询(query);
    }




    public class QueryH_9_5_服务统计_短信发送量查询 {
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

    @RequestMapping(value = "/sms_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_9_5_服务统计_短信发送量查询(
            @Valid @RequestBody  QueryH_9_5_服务统计_短信发送量查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h9服务统计Service.H_9_5_服务统计_短信发送量查询(query);
    }



    public class QueryH_9_6_服务统计_渠道登录次数查询 {
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

    @RequestMapping(value = "/qdlogin.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_9_6_服务统计_渠道登录次数查询(
            @Valid @RequestBody  QueryH_9_6_服务统计_渠道登录次数查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h9服务统计Service.H_9_6_服务统计_渠道登录次数查询(query);
    }





    public class QueryH_9_7_服务统计_用户年龄信息查询 {
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

    @RequestMapping(value = "/yhnlxx_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_9_7_服务统计_用户年龄信息查询(
            @Valid @RequestBody  QueryH_9_7_服务统计_用户年龄信息查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h9服务统计Service.H_9_7_服务统计_用户年龄信息查询(query);
    }



    public class QueryH_9_8_服务统计_各渠道API总量 {
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

    @RequestMapping(value = "/lyqd_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_9_8_服务统计_各渠道API总量(
            @Valid @RequestBody  QueryH_9_8_服务统计_各渠道API总量 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
        return h9服务统计Service.H_9_8_服务统计_各渠道API总量(query);
    }
}












