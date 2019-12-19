package org.ylgjj.loan.web;




import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.GitProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.ylgjj.loan.api.H2业务指标Controller;
import org.ylgjj.loan.api.SupervisionController;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.flow.AnalysisStream;
import org.ylgjj.loan.flow.AnalysisTable;
import org.ylgjj.loan.flow.StreamHistory;
import org.ylgjj.loan.history_flow.BaseServiceImpl;
import org.ylgjj.loan.model.ApiUrl;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.pojo.ListItem;
import org.ylgjj.loan.pojo.QueryH_1_3_监管主要指标查询_指标明细查询;
import org.ylgjj.loan.repository_flow.*;
import org.ylgjj.loan.service.AnalysisServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Controller
    public class WebController extends BaseServiceImpl {



    @Autowired
    private GitProperties git;


    NumberFormat nf = NumberFormat.getPercentInstance();

    @Autowired
    private TableMetadataRepository tableMetadataRepository;
    @Autowired
    private AnalysisTableRepository analysisTableRepository;

    @Autowired
    private AnalysisStreamRepository analysisStreamRepository;
    @Autowired
    private AnalysisServiceImpl analysisServiceImpl;


    @Autowired
    private StreamHistoryRepository streamHistoryRepository;


        @GetMapping("/")

        public ModelAndView home(HttpServletRequest request) {



            ModelAndView modelAndView = new ModelAndView("/index");




            List<ListItem> items = StatisticalIndexCodeEnum.retriveTypese();

            modelAndView.addObject("rates", E_指标_RATE_SY.retriveTypese());



            modelAndView.addObject("apis", SupervisionController.api);

            Map<String,AnalysisTable> analysisTables = analysisTableRepository.findAll().stream().collect(Collectors.toMap(e->e.getIndexNo(),e->e));

            List<Map> indexes__url = Arrays.stream(StatisticalIndexCodeEnum.values()).map(e->{

                Map map = new HashMap();
                String userUrl =  linkTo(methodOn(WebController.class).detail(null)).withSelfRel().getHref();
                map.put("url",userUrl);
                map.put("id",e.get指标编码());
                map.put("displayValue",e.get指标名称());
                map.put("completed",e.get是否完成());

                AnalysisTable analysisTable = analysisTables.get(e.get指标编码());
                map.put("modifyDate",analysisTable.getModifyDate());
                map.put("createDate",analysisTable.getCreateDate());
                return map;
            }).collect(Collectors.toList());
            modelAndView.addObject("statisticalIndexEnums",indexes__url);

            modelAndView.addObject("statisticalIndexCodeEnums", indexes__url);


            Map<Boolean,List<ListItem>> indexes = items.stream().collect(Collectors.groupingBy(ListItem::isCompleted));

            modelAndView.addObject("indexRate", nf.format((indexes.get(true) == null?0 :indexes.get(true).size()+0d)/items.size()));

            Map<Boolean,List<ApiUrl>> apis = SupervisionController.api.stream().collect(Collectors.groupingBy(ApiUrl::is是否完成));

            nf.setMaximumFractionDigits(1);//这个1的意识是保存结果到小数点后几位，但是特别声明：这个结果已经先＊100了。
            //System.out.println();//自动四舍五入。
            System.out.println("apis.get(true).size()");
            System.out.println(apis.get(true).size());
            System.out.println(SupervisionController.api.size());
            System.out.println("apis.get(true).size()");
            modelAndView.addObject("rate", nf.format((apis.get(true).size()+0d)/SupervisionController.api.size()));

            modelAndView.addObject("version", git.get("build.version"));

            modelAndView.addObject("git", git.toString()+git.get("build.version")+"--"+git.get("branch"));

            List<Map> idea = new ArrayList<>();
            Map map = new HashMap();
            List<String> flow = new ArrayList<>();
            flow.add("DP021_单位缴存登记簿");
            flow.add("DW025_公积金提取审核登记表");
            flow.add("DP008_单位明细账");
            flow.add("DP202_单位缴存变更登记簿");
            map.put("flow", flow);
            List<String> state = new ArrayList<>();
            state.add("DP004_unit_payment_info_单位缴存信息表");
            state.add("CM001_单位基本资料表");
            state.add("DP005_work_unit_单位分户账");

            map.put("state", state);

            idea.add(map);

            modelAndView.addObject("ideas", idea);


/*            List<TableMetadata> metadata = tableMetadataRepository.findAll();
            //TableMetadata metadata = tableMetadataRepository.findByTableName("myTable");

            modelAndView.addObject("metadatas", metadata);*/

            String analysisUrl =  linkTo(methodOn(WebController.class).analysis(null,null)).withSelfRel().getHref();
            modelAndView.addObject("analysisUrl",analysisUrl);
            return modelAndView;


        }

    @GetMapping("/detail")
    public ModelAndView detail(HttpServletRequest request) {



        ModelAndView modelAndView = new ModelAndView("/detail");






        modelAndView.addObject("apis", SupervisionController.api);

        modelAndView.addObject("E统计周期编码s", 统计周期编码.retriveTypese());
        modelAndView.addObject("E_HX_机构_Institution_info_instCodeEnums", E_HX_机构_Institution_info_instCodeEnum.retriveTypese());
        modelAndView.addObject("E_银行编码_HEnums", E_银行编码_H.retriveTypese());


        modelAndView.addObject("住建部编码_单位经济类型Enums", 住建部编码_单位经济类型.retriveTypese());
        modelAndView.addObject("E_住建部编码_收入水平Enums", E_住建部编码_收入水平.retriveTypese());
        modelAndView.addObject("E_住建部编码_购房面积Enums", E_住建部编码_购房面积.retriveTypese());
        List<Map> items = StatisticalIndexCodeEnum.retriveTypeseMap();
        modelAndView.addObject("statisticalIndexCodeEnums", items);
        //      modelAndView.addObject("statisticalIndexEnums", StatisticalIndexCodeEnum.retriveTypeseValues());


        modelAndView.addObject("apis", SupervisionController.api);
        List<Map> indexes__url = items.stream().map(e->{


            String userUrl =  linkTo(methodOn(H2业务指标Controller.class).H_2_5_业务指标_多维度查询((String)e.get("指标编码"),null,null)).withSelfRel().getHref();
            e.put("url",userUrl);
            return e;
        }).collect(Collectors.toList());

        Map<Boolean,List<Map>> indexes = indexes__url.stream().collect(Collectors.groupingBy(e->(Boolean)e.get("是否完成")));

        modelAndView.addObject("version", git.get("build.version"));

        modelAndView.addObject("git", git.toString()+git.get("build.version")+"--"+git.get("branch"));

        return modelAndView;


    }



    @GetMapping("/test")
    public ModelAndView test(HttpServletRequest request) {



        ModelAndView modelAndView = new ModelAndView("/test");




        modelAndView.addObject("E统计周期编码s", 统计周期编码.retriveTypese());
        modelAndView.addObject("E_HX_机构_Institution_info_instCodeEnums", E_HX_机构_Institution_info_instCodeEnum.retriveTypese());
        modelAndView.addObject("E_银行编码_HEnums", E_银行编码_H.retriveTypese());


        modelAndView.addObject("住建部编码_单位经济类型Enums", 住建部编码_单位经济类型.retriveTypese());
        modelAndView.addObject("E_住建部编码_收入水平Enums", E_住建部编码_收入水平.retriveTypese());
        modelAndView.addObject("E_住建部编码_购房面积Enums", E_住建部编码_购房面积.retriveTypese());
        List<Map> items = StatisticalIndexCodeEnum.retriveTypeseMap();
        modelAndView.addObject("statisticalIndexCodeEnums", items);
        //      modelAndView.addObject("statisticalIndexEnums", StatisticalIndexCodeEnum.retriveTypeseValues());



        modelAndView.addObject("version", git.get("build.version"));

        modelAndView.addObject("git", git.toString()+git.get("build.version")+"--"+git.get("branch"));

        return modelAndView;


    }




    @GetMapping("/指标明细查询")
    public ModelAndView 指标明细查询(HttpServletRequest request) {



        ModelAndView modelAndView = new ModelAndView("/1_3_指标明细查询");




        modelAndView.addObject("E统计周期编码s", 统计周期编码.retriveTypese());
        modelAndView.addObject("E_HX_机构_Institution_info_instCodeEnums", E_HX_机构_Institution_info_instCodeEnum.retriveTypese());
        modelAndView.addObject("E_银行编码_HEnums", E_银行编码_H.retriveTypese());


        modelAndView.addObject("住建部编码_单位经济类型Enums", 住建部编码_单位经济类型.retriveTypese());
        modelAndView.addObject("E_住建部编码_收入水平Enums", E_住建部编码_收入水平.retriveTypese());
        modelAndView.addObject("E_住建部编码_购房面积Enums", E_住建部编码_购房面积.retriveTypese());
        List<Map> items = StatisticalIndexCodeEnum.retriveTypeseMap();
        modelAndView.addObject("statisticalIndexCodeEnums", items);

        modelAndView.addObject("version", git.get("build.version"));

        modelAndView.addObject("git", git.toString()+git.get("build.version")+"--"+git.get("branch"));
        String userUrl =  linkTo(methodOn(WebController.class).H_1_3_监管主要指标查询_指标明细查询(null,null)).withSelfRel().getHref();
        modelAndView.addObject("url",userUrl);
        return modelAndView;


    }


    @RequestMapping(value = "/more_grid_cx.service", method = RequestMethod.POST)
    @ResponseBody
    public Output H_1_3_监管主要指标查询_指标明细查询(@RequestBody QueryH_1_3_监管主要指标查询_指标明细查询 query, Errors errors)  {
        if (errors.hasErrors()) {
            return Output.情况4_入参数格式错误(errors.toString());
            //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        System.out.println("----------------- "+ query.toString());

       // StatisticalIndexCodeEnum.S_118_SEQ_回收额__冲还贷___AND_0302000213.get指标编码()

        List<StreamHistory> loanHistories  = streamHistoryRepository.findByIndexNo(StatisticalIndexCodeEnum.fromString指标编码(query.getTarget()).get指标编码());


        Output output = new Output();
        output.setData(        loanHistories.stream().map(e->{

        //    e.setIndex机构编码(pb007_机构信息表Map().get(e.getIndex机构编码()).getInstName());
         //   e.setIndex银行名称(pb011_银行信息表Map().get(e.getIndex银行名称()).getBankname());
            return e;
        }).collect(Collectors.toList()));
        output.setSuccess(true);
        return output;
    }

    @RequestMapping(value = "/JG/analysis", method = RequestMethod.GET)
    @ResponseBody
    public Page<Map> analysis(QueryH_1_3_监管主要指标查询_指标明细查询 query, @PageableDefault(sort="createDate",direction= Sort.Direction.DESC) Pageable pageable)  {


        Page<AnalysisTable> loanHistories  = analysisTableRepository.findByOrderBySeqAsc(pageable);

;

        Page<Map> page = loanHistories.map(new Function<AnalysisTable, Map>() {
            public Map apply(AnalysisTable collaborator) {

                ObjectMapper m = new ObjectMapper();
                Map<String,Object> map = m.convertValue(collaborator,Map.class);

                StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.fromString指标编码(collaborator.getIndexNo());
                map.put("id", collaborator.getId());
                map.put("createDate", collaborator.getCreateDate());
                map.put("modifyDate",collaborator.getModifyDate());
                map.put("name",statisticalIndexCodeEnum.get指标名称());
                map.put("period",统计周期编码.fromString(statisticalIndexCodeEnum.get统计周期()).get名称());
                String producerUrl  = linkTo(methodOn(WebController.class).index_detail(collaborator.getIndexNo(), null)).toUri().getRawPath();
                map.put("url",producerUrl);


                return map;
            }
        });


        return page;
    }
    @RequestMapping(value = "/index_detail/{type}", method = RequestMethod.GET)
    //@GetMapping("/index_detail")
    public ModelAndView index_detail(@PathVariable("type") String type,HttpServletRequest request) {

        AnalysisTable analysisTable  = analysisTableRepository.findByIndexNo(type);

        ;


        ModelAndView modelAndView = new ModelAndView("/index_detail");
        String producerUrl  = linkTo(methodOn(WebController.class).analysisStream(analysisTable.getIndexNo(), null)).toUri().getRawPath();


        modelAndView.addObject("streamUrl",producerUrl);
        String updateImmediatelyUrl  = linkTo(methodOn(WebController.class).updateImmediatelyUrl(analysisTable.getIndexNo(), null)).toUri().getRawPath();

        modelAndView.addObject("updateImmediatelyUrl",updateImmediatelyUrl);

        String historyImmediatelyUrl  = linkTo(methodOn(WebController.class).historyImmediatelyUrl(analysisTable.getIndexNo(), null)).toUri().getRawPath();

        modelAndView.addObject("historyImmediatelyUrl",historyImmediatelyUrl);








        ObjectMapper m = new ObjectMapper();
        Map<String,Object> map = m.convertValue(analysisTable,Map.class);

        StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.fromString指标编码(analysisTable.getIndexNo());
        map.put("id", analysisTable.getId());
        map.put("createDate", analysisTable.getCreateDate());
        map.put("modifyDate",analysisTable.getModifyDate());
        map.put("name",statisticalIndexCodeEnum.get指标名称());
        map.put("period",统计周期编码.fromString(statisticalIndexCodeEnum.get统计周期()).get名称());
        //String producerUrl  = linkTo(methodOn(WebController.class).index_detail(analysisTable.getIndexNo(), null)).toUri().getRawPath();
        //map.put("url",producerUrl);




        modelAndView.addObject("analysisTable", map);


        modelAndView.addObject("E统计周期编码s", 统计周期编码.retriveTypese());
        modelAndView.addObject("E_HX_机构_Institution_info_instCodeEnums", E_HX_机构_Institution_info_instCodeEnum.retriveTypese());
        modelAndView.addObject("E_银行编码_HEnums", E_银行编码_H.retriveTypese());


        modelAndView.addObject("住建部编码_单位经济类型Enums", 住建部编码_单位经济类型.retriveTypese());
        modelAndView.addObject("E_住建部编码_收入水平Enums", E_住建部编码_收入水平.retriveTypese());
        modelAndView.addObject("E_住建部编码_购房面积Enums", E_住建部编码_购房面积.retriveTypese());





        modelAndView.addObject("version", git.get("build.version"));

        modelAndView.addObject("git", git.toString()+git.get("build.version")+"--"+git.get("branch"));

        return modelAndView;


    }











    @RequestMapping(value = "/JG/analysisStream/{type}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Map> analysisStream( @PathVariable("type") String type, @PageableDefault(sort="createDate",direction= Sort.Direction.DESC) Pageable pageable)  {


        Page<AnalysisStream> loanHistories  = analysisStreamRepository.findAll(pageable);

        ;

        Page<Map> page = loanHistories.map(new Function<AnalysisStream, Map>() {
            public Map apply(AnalysisStream collaborator) {

                ObjectMapper m = new ObjectMapper();
                Map<String,Object> map = m.convertValue(collaborator,Map.class);


                map.put("id", collaborator.getId());
                map.put("createDate", collaborator.getCreateDate());
                map.put("modifyDate",collaborator.getModifyDate());
                map.put("beginDateTime",collaborator.getBeginDateTime());
                map.put("endDateTime",collaborator.getEndDateTime());
                map.put("beginDate",collaborator.getBeginDate());
                map.put("endDate",collaborator.getEndDate());
                if(collaborator.getBeginDateTime()!= null && collaborator.getEndDateTime()!= null){
                    map.put("duration",Duration.between(collaborator.getBeginDateTime(),collaborator.getEndDateTime()).toString());

                }

/*                String producerUrl  = linkTo(methodOn(WebController.class).index_detail(collaborator.getIndexNo(), null)).toUri().getRawPath();
                map.put("url",producerUrl);*/


                return map;
            }
        });


        return page;
    }


    @RequestMapping(value = "/JG/updateImmediatelyUrl/{no}", method = RequestMethod.POST)
    @ResponseBody
    public Map updateImmediatelyUrl(
                              @PathVariable(value = "no",required = false) String no, Authentication authentication) {

        logger.debug("we get collaborator id is {} , personids is {} {}",  no);

        Map data = new HashMap();
        data.put("status", true);
        try {


            analysisServiceImpl.updateImmediately(StatisticalIndexCodeEnum.fromString指标编码(no));
            //TODO



        } catch (Exception e) {
            e.printStackTrace();

            data.put("status", false);
            data.put("message", "系统异常！");
        }
        return data;

    }



    @RequestMapping(value = "/JG/historyImmediatelyUrl/{no}", method = RequestMethod.POST)
    @ResponseBody
    public Map historyImmediatelyUrl(
            @PathVariable(value = "no",required = false) String no, Authentication authentication) {

        logger.debug("we get collaborator id is {} , personids is {} {}",  no);

        Map data = new HashMap();
        data.put("status", true);
        try {


            boolean bool = analysisServiceImpl.historyImmediately(StatisticalIndexCodeEnum.fromString指标编码(no));
            //TODO

            if(!bool){
                data.put("status", bool);
                data.put("message", "正在history！");
            }else{

            }



        } catch (Exception e) {
            e.printStackTrace();

            data.put("status", false);
            data.put("message", "系统异常！");
        }
        return data;

    }


}
