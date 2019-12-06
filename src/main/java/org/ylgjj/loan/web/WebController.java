package org.ylgjj.loan.web;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.GitProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.ylgjj.loan.api.H2业务指标Controller;
import org.ylgjj.loan.api.SupervisionController;
import org.ylgjj.loan.domain.DP204_个人缴存变更登记簿;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.flow.TableMetadata;
import org.ylgjj.loan.model.ApiUrl;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.pojo.ListItem;
import org.ylgjj.loan.repository_flow.TableMetadataRepository;
import org.ylgjj.loan.repository_flow.YourHistoryRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Controller
    public class WebController {



    @Autowired
    private GitProperties git;
    NumberFormat nf = NumberFormat.getPercentInstance();

    @Autowired
    private TableMetadataRepository tableMetadataRepository;


        @GetMapping("/")

        public ModelAndView home(HttpServletRequest request) {



            ModelAndView modelAndView = new ModelAndView("/index");




            List<ListItem> items = StatisticalIndexCodeEnum.retriveTypese();
            modelAndView.addObject("statisticalIndexCodeEnums", items);
            modelAndView.addObject("statisticalIndexEnums", StatisticalIndexCodeEnum.retriveTypese());

            modelAndView.addObject("rates", E_指标_RATE_SY.retriveTypese());



            modelAndView.addObject("apis", SupervisionController.api);
            List<ListItem> indexes__url = items.stream().map(e->{

                String userUrl =  linkTo(methodOn(WebController.class).detail(null)).withSelfRel().getHref();
                e.setUrl(userUrl);
                return e;
            }).collect(Collectors.toList());

            Map<Boolean,List<ListItem>> indexes = indexes__url.stream().collect(Collectors.groupingBy(ListItem::isCompleted));

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


            List<TableMetadata> metadata = tableMetadataRepository.findAll();
            //TableMetadata metadata = tableMetadataRepository.findByTableName("myTable");

            modelAndView.addObject("metadatas", metadata);
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
    }
