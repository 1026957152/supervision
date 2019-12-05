package org.ylgjj.loan.api;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.ylgjj.loan.config.ConfigProperties;
import org.ylgjj.loan.domain.Query;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.model.ApiUrl;
import org.ylgjj.loan.service.CustomerService;

import javax.validation.Valid;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/JG")
public class SupervisionController {



    static public List<ApiUrl> api = new ArrayList<ApiUrl>();

    static public ApiUrl H1_1 = new ApiUrl("1.1",
            "1监管主要指标查询",
            "1.1公积金年度查询",
            "http://ip:port/JG/common/get_zbnd.service",true);

    static public ApiUrl H1_2 = new ApiUrl("1.1",
            "1监管主要指标查询",
            "1.2公积金中心主要运行情况查询",
            "http://ip:port/JG/common/get_business_data.service", false);



    static public ApiUrl H1_3 = new ApiUrl("1.1",
            "1监管主要指标查询",
            "1.3指标明细查询",
            "http://ip:port/JG/dzbfx/more_grid_cx.service", false);

    static public ApiUrl H1_4 = new ApiUrl("1.1",
            "1监管主要指标查询",
            "1.4离柜率明细查询",
            "http://ip:port/JG/common/get_fwxl.service", false);

    static {
        api.add(H1_1);
        api.add(H1_2);
        api.add(H1_3);
        api.add(H1_4);
    }

    static public ApiUrl H2_1 = new ApiUrl("1.1",
            "业务指标",
            "添加常用指标",
            "http://ip:port/JG/dzbfx/more_target_add.service", true);

    static public ApiUrl H2_2 = new ApiUrl("1.1",
            "2业务指标",
            "2.2查询常用指标",
            "http://ip:port/JG/dzbfx/more_target_cx.service", true);

    static public ApiUrl H2_3 = new ApiUrl("1.1",
            "2业务指标",
            "2.3常用指标数据查询",
            "http://ip:port/JG/dzbfx/more_target_value_cx.service", false);


    static public ApiUrl H2_4 = new ApiUrl("1.1",
            "2业务指标",
            "2.4多指标树查询",
            "http://ip:port/JG/dzbfx/more_tree_cx.service", false);

    static public ApiUrl H2_5 = new ApiUrl("1.1",
            "2业务指标",
            "2.5多维度查询",
            "http://ip:port/JG/dzbfx/more_dimension_cx.service", false);
    static public ApiUrl H2_6 = new ApiUrl("1.1",
            "2业务指标",
            "2.6网格查询",
            "http://ip:port/JG/dzbfx/more_grid_cx.service", false);


    static public ApiUrl H2_7 = new ApiUrl("1.1",
            "2业务指标",
            "2.7表格查询",
            "http://ip:port/JG/dzbfx/more_chart_cx.service", false);

    static {
        api.add(H2_1);
        api.add(H2_2);
        api.add(H2_3);
        api.add(H2_4);
        api.add(H2_5);
        api.add(H2_6);
        api.add(H2_7);
    }
    static public ApiUrl H3_1 = new ApiUrl("1.1",
            "3结算监控",
            "3.1银行查询-查询所有关联银行，按总行区分",
            "http://ip:port/JG/zjlxjk/get_all_bank.service", true);

    static public ApiUrl H3_2 = new ApiUrl("1.1",
            "3银行余额查询",
            "3.2银行余额查询",
            "http://ip:port/JG/zjlxjk/get_bank_ye.service", true);

    static public ApiUrl H3_3 = new ApiUrl("1.1",
            "3银行余额查询",
            "3.3银行实时交易",
            "http://ip:port/JG/zjlxjk/get_all_bank_sszhmx.service", true);
    static public ApiUrl H3_4 = new ApiUrl("1.1",
            "3银行余额查询",
            "3.4金结算流水查询-查询最近15条结算明细数据",
            "http://ip:port/JG/zjlxjk/get_jymx.service", true);

    static public ApiUrl H3_5 = new ApiUrl("1.1",
            "3银行余额查询",
            "3.4资金结算流水查询-查询历史结算明细数据",
            "http://ip:port/JG/zjlxjk/get_yhlsjymx.service", true);

    static {
        api.add(H3_1);
        api.add(H3_2);
        api.add(H3_3);
        api.add(H3_4);
        api.add(H3_5);

    }
    static public ApiUrl H4_1 = new ApiUrl("1.1",
            "4业务统计",
            "4.1业务统计——获取各渠道业务统计数据",
            "http://ip:port/JG/bbgl/ywtj_cx.service", true);
    static {
        api.add(H4_1);


    }
    static public ApiUrl H5_1 = new ApiUrl("1.1",
            "5离柜率",
            "5.1离柜率查询",
            "http://ip:port/JG/zjlxjk/lgl_cx.service", false);
    static {
        api.add(H5_1);
    }

    static public ApiUrl H6_1 = new ApiUrl("1.1",
            "6抵押办理时间",
            "6.1抵押物数据查询",
            "http://ip:port/JG/dyw/get_dywData.service", false);


    static public ApiUrl H6_2 = new ApiUrl("1.1",
            "6抵押办理时间",
            "6.2抵押物明细数据查询",
            "http://ip:port/JG/dyw/get_dywmx.service", true);

    static {
        api.add(H6_1);
        api.add(H6_2);
    }


    static public ApiUrl H7_1 = new ApiUrl("1.1",
            "7大额资金监控",
            "7.1监控数据明细查询",
            "http://ip:port/JG/zjlxjk/dezjjk_cx.service", true);

    static public ApiUrl H7_2 = new ApiUrl("1.1",
            "7大额资金监控",
            "7.2大额资金监控汇总数据查询",
            "http://ip:port/JG/zjlxjk/dezjjk_chart_cx.service", true);
    static {
        api.add(H7_1);
        api.add(H7_2);
    }


    static public ApiUrl H8_1 = new ApiUrl("1.1",
            "8银行专户余额",
            "8.1银行专户余额查询",
            "http://ip:port/JG/zjlxjk/yhzhye_table_cx.service", true);

    static {
        api.add(H8_1);

    }
    static public ApiUrl H9_1 = new ApiUrl("1.1",
            "9服务统计",
            "9.1信息推送量查询",
            "http://ip:port/JG/zhfwpt/xxtsl_cx.service", false);
    static public ApiUrl H9_2 = new ApiUrl("1.1",
            "9服务统计",
            "9.2渠道访问总量查询",

            "http://ip:port/JG/zhfwpt/qdfwzl_cx.service", false);
    static public ApiUrl H9_3 = new ApiUrl("1.1",
            "9服务统计",
            "9.3用户注册分布查询",
            "http://ip:port/JG/zhfwpt/yhzcfb_cx.service", false);
    static public ApiUrl H9_4 = new ApiUrl("1.1",
            "9服务统计",
            "9.4用户性别查询",
            "http://ip:port/JG/zhfwpt/yhxbxx_cx.service", true);

    static public ApiUrl H9_5 = new ApiUrl("1.1",
            "9服务统计",
            "9.5短信发送量查询",
            "http://ip:port/JG/zhfwpt/sms_cx.service", false);
    static public ApiUrl H9_6 = new ApiUrl("1.1",
            "9服务统计",
            "9.6渠道登录次数查询",
            "http://ip:port/JG/zhfwpt/qdlogin.service", true);
    static public ApiUrl H9_7 = new ApiUrl("1.1",
            "9服务统计",
            "9.7用户年龄信息查询",
            "http://ip:port/JG/zhfwpt/yhnlxx_cx.service", true);

    static public ApiUrl H9_8 = new ApiUrl("1.1",
            "9服务统计",
            "9.8各渠道API总量",
            "http://ip:port/JG/zhfwpt/lyqd_cx.service", true);

    static {
        api.add(H9_1);
        api.add(H9_2);
        api.add(H9_3);
        api.add(H9_4);
        api.add(H9_5);
        api.add(H9_6);
        api.add(H9_7);
        api.add(H9_8);
    }





    static public ApiUrl H10_1 = new ApiUrl("1.1",
            "10逾期监管",
            "10.1逾期监管汇总查询",
            "http://ip:port/JG/yqqk/get_yqqk_DataCx.service", true);
    static public ApiUrl H10_2 = new ApiUrl("1.1",
            "10逾期监管",
            "10.2逾期监管明细查询",
            "http://ip:port/JG/yqqk/jg_yqqk_gdyqqk_tc.service", true);

    static {
        api.add(H10_1);
        api.add(H10_2);
    }


    static final String H_1_1_监管主要指标查询_公积金年度查询 = "/JG/common/get_zbnd.service";
    static final String H_1_2_监管主要指标查询_指标明细查询 = "/JG/common/get_business_data.service";
    static final String H_1_3_监管主要指标查询_指标明细查询 = "/JG/dzbfx/more_grid_cx.service";
    static final String H_1_3_监管主要指标查询_公积金年度查询 = "/JG/common/get_fwxl.service";

    static final String H_2_1_业务指标_添加常用指标 = "/JG/dzbfx/more_target_add.service";
    static final String H_2_2_业务指标_查询常用指标 = "/JG/dzbfx/more_target_cx.service";
    static final String H_2_3_业务指标_常用指标数据查询 = "/JG/dzbfx/more_target_value_cx.service";
    static final String H_2_4_业务指标_多指标树查询 = "/JG/dzbfx/more_tree_cx.service";

    static final String H_2_5_业务指标_多维度查询 = "/JG/dzbfx/more_dimension_cx.service";
    static final String H_2_6_业务指标_网格查询 = "/JG/dzbfx/more_grid_cx.service";
    static final String H_2_7_业务指标_表格查询 = "/JG/dzbfx/more_chart_cx.service";

    static final String H_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分 = "/JG/zjlxjk/get_all_bank.service";
    static final String H_3_2_银行余额查询_银行余额查询 = "/JG/zjlxjk/get_bank_ye.service";
    static final String H_3_3_银行余额查询_银行实时交易 = "/JG/zjlxjk/get_all_bank_sszhmx.service";
    static final String H_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据 = "/JG/zjlxjk/get_jymx.service";
    static final String H_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据 = "/JG/zjlxjk/get_yhlsjymx.service";

    static final String H_4_1_业务统计_获取各渠道业务统计数据 = "/JG/bbgl/ywtj_cx.service";

    static final String H_5_1_离柜率_离柜率查询 = "/JG/zjlxjk/lgl_cx.service";

    static final String H_6_1_抵押办理时间_抵押物数据查询 = "/JG/dyw/get_dywData.service";
    static final String H_6_2_抵押办理时间_抵押物明细数据查询 = "/JG/dyw/get_dywmx.service";

    static final String H_7_1_大额资金监控_监控数据明细查询 = "/JG/zjlxjk/dezjjk_cx.service";
    static final String H_7_2_大额资金监控_大额资金监控汇总数据查询 = "/JG/zjlxjk/dezjjk_chart_cx.service";

    static final String H_8_1_银行专户余额_银行专户余额查询 = "/JG/zjlxjk/yhzhye_table_cx.service";

    static final String H_9_1_服务统计_信息推送量查询 = "/JG/zhfwpt/xxtsl_cx.service";
    static final String H_9_2_服务统计_渠道访问总量查询 = "/JG/zhfwpt/qdfwzl_cx.service";
    static final String H_9_3_服务统计_用户注册分布查询 = "/JG/zhfwpt/yhzcfb_cx.service";
    static final String H_9_4_服务统计_用户性别查询 = "/JG/zhfwpt/yhxbxx_cx.service";
    static final String H_9_5_服务统计_短信发送量查询 = "/JG/zhfwpt/sms_cx.service";
    static final String H_9_6_服务统计_渠道登录次数查询 = "/JG/zhfwpt/qdlogin.service";
    static final String H_9_7_服务统计_用户年龄信息查询 = "/JG/zhfwpt/yhnlxx_cx.service";
    static final String H_9_8_服务统计_各渠道API总量 = "/JG/zhfwpt/lyqd_cx.service";

    static final String H_10_1_逾期监管_逾期监管汇总查询 = "/JG/yqqk/get_yqqk_DataCx.service";
    static final String H_10_2_逾期监管_逾期监管明细查询 = "/JG/yqqk/jg_yqqk_gdyqqk_tc.service";




 /*   static final String H_1_1_监管主要指标查询_公积金年度查询 = "http://ip:port/JG/common/get_zbnd.service";
    static final String H_1_2_监管主要指标查询_指标明细查询 = "http://ip:port/JG/common/get_business_data.service";
    static final String H_1_3_监管主要指标查询_指标明细查询 = "http://ip:port/JG/dzbfx/more_grid_cx.service";
    static final String H_1_3_监管主要指标查询_公积金年度查询 = "http://ip:port/JG/common/get_fwxl.service";

    static final String H_2_1_业务指标_添加常用指标 = "http://ip:port/JG/dzbfx/more_target_add.service";
    static final String H_2_2_业务指标_查询常用指标 = "http://ip:port/JG/dzbfx/more_target_cx.service";
    static final String H_2_3_业务指标_常用指标数据查询 = "http://ip:port/JG/dzbfx/more_target_value_cx.service";
    static final String H_2_4_业务指标_多指标树查询 = "http://ip:port/JG/common/get_fwxl.service";
    static final String H_2_5_业务指标_多维度查询 = "http://ip:port/JG/dzbfx/more_tree_cx.service";
    static final String H_2_6_业务指标_网格查询 = "http://ip:port/JG/dzbfx/more_grid_cx.service";
    static final String H_2_7_业务指标_表格查询 = "http://ip:port/JG/dzbfx/more_chart_cx.service";

    static final String H_3_1_银行余额查询_银行查询_查询所有关联银行_按总行区分 = "http://ip:port/JG/zjlxjk/get_all_bank.service";
    static final String H_3_2_银行余额查询_银行余额查询 = "http://ip:port/JG/zjlxjk/get_bank_ye.service";
    static final String H_3_3_银行余额查询_银行实时交易 = "http://ip:port/JG/zjlxjk/get_all_bank_sszhmx.service";
    static final String H_3_4_银行余额查询_金结算流水查询_查询最近15条结算明细数据 = "http://ip:port/JG/zjlxjk/get_jymx.service";
    static final String H_3_5_银行余额查询_资金结算流水查询_查询历史结算明细数据 = "http://ip:port/JG/zjlxjk/get_yhlsjymx.service";

    static final String H_4_1_业务统计_获取各渠道业务统计数据 = "http://ip:port/JG/bbgl/ywtj_cx.service";

    static final String H_5_1_离柜率_离柜率查询 = "http://ip:port/JG/zjlxjk/lgl_cx.service";

    static final String H_6_1_抵押办理时间_抵押物数据查询 = "http://ip:port/JG/dyw/get_dywData.service";
    static final String H_6_2_抵押办理时间_抵押物明细数据查询 = "http://ip:port/JG/dyw/get_dywmx.service";

    static final String H_7_1_大额资金监控_监控数据明细查询 = "http://ip:port/JG/zjlxjk/dezjjk_cx.service";
    static final String H_7_2_大额资金监控_大额资金监控汇总数据查询 = "http://ip:port/JG/zjlxjk/dezjjk_chart_cx.service";

    static final String H_8_1_银行专户余额_银行专户余额查询 = "http://ip:port/JG/zjlxjk/yhzhye_table_cx.service";

    static final String H_9_1_服务统计_信息推送量查询 = "http://ip:port/JG/zhfwpt/xxtsl_cx.service";
    static final String H_9_2_服务统计_渠道访问总量查询 = "http://ip:port/JG/zhfwpt/qdfwzl_cx.service";
    static final String H_9_3_服务统计_用户注册分布查询 = "http://ip:port/JG/zhfwpt/yhzcfb_cx.service";
    static final String H_9_4_服务统计_用户性别查询 = "http://ip:port/JG/zhfwpt/yhxbxx_cx.service";
    static final String H_9_5_服务统计_短信发送量查询 = "http://ip:port/JG/zhfwpt/sms_cx.service";
    static final String H_9_6_服务统计_渠道登录次数查询 = "http://ip:port/JG/zhfwpt/qdlogin.service";
    static final String H_9_7_服务统计_用户年龄信息查询 = "http://ip:port/JG/zhfwpt/yhnlxx_cx.service";
    static final String H_9_8_服务统计_各渠道API总量 = "http://ip:port/JG/zhfwpt/lyqd_cx.service";

    static final String H_10_1_逾期监管_逾期监管汇总查询 = "http://ip:port/JG/yqqk/get_yqqk_DataCx.service";
    static final String H_10_2_逾期监管_逾期监管明细查询 = "http://ip:port/JG/yqqk/jg_yqqk_gdyqqk_tc.service";*/
    static final String a = "";
    enum ConstantEnum {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    @Autowired
    CustomerService customerService;
    @Autowired
    ConfigProperties configProperties;

    @RequestMapping(value = a, method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult url(@Valid /*@RequestBody*/ Query query,  Errors errors)  {
        if (errors.hasErrors()) {
            return ReturnResult.情况4_入参数格式错误("");
          //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());
/*        if(bindException.getMessage() != null){
            return ReturnResult.情况4_入参数格式错误(bindException.getMessage());
        }*/



        System.out.println("----------------- "+  configProperties.toString());
        return customerService.queryLoanee(query);
    }


    @RequestMapping(value = "/static-builder", method = RequestMethod.POST)
    @ResponseBody
    public String static_builder(@Valid /*@RequestBody*/ Query query,  Errors errors)  {
        String jws = Jwts.builder()
                .setIssuer("Stormpath")
                .setSubject("msilverman")
                .claim("name", "Micah Silverman")
                .claim("scope", "admins")
                // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
                .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
                // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
                .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
                )
                .compact();
        return jws;
    }
/*
    @RequestMapping(value = "/parser", method = GET)
    public JwtResponse parser(@RequestParam String jwt) throws UnsupportedEncodingException {
        Jws<Claims> jws = Jwts.parser()
                .setSigningKeyResolver(
                        TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
                     //   secretService.getSigningKeyResolver()

                )
                .parseClaimsJws(jwt);

        return new JwtResponse(jws);
    }

*/


}
