package org.ylgjj.loan.web;




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
import org.ylgjj.loan.model.ApiUrl;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.pojo.ListItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Controller
    public class WebController {




        @GetMapping("/")

        public ModelAndView home(HttpServletRequest request) {



            ModelAndView modelAndView = new ModelAndView("/index");




            List<ListItem> items = StatisticalIndexCodeEnum.retriveTypese();
            modelAndView.addObject("statisticalIndexCodeEnums", items);
            modelAndView.addObject("apis", SupervisionController.api);
            List<ListItem> indexes__url = items.stream().map(e->{

                String userUrl =  linkTo(methodOn(H2业务指标Controller.class).H_2_5_业务指标_多维度查询(null,null)).withSelfRel().getHref();
                e.setUrl(userUrl);
                return e;
            }).collect(Collectors.toList());

            Map<Boolean,List<ListItem>> indexes = indexes__url.stream().collect(Collectors.groupingBy(ListItem::isCompleted));
            NumberFormat nf = NumberFormat.getPercentInstance();
            modelAndView.addObject("indexRate", nf.format(indexes.get(true).size()/items.size()));

            Map<Boolean,List<ApiUrl>> apis = SupervisionController.api.stream().collect(Collectors.groupingBy(ApiUrl::is是否完成));
            ;

            nf.setMaximumFractionDigits(1);//这个1的意识是保存结果到小数点后几位，但是特别声明：这个结果已经先＊100了。
            //System.out.println();//自动四舍五入。
            modelAndView.addObject("rate", nf.format(apis.get(true).size()/SupervisionController.api.size()));

            return modelAndView;


        }
    }
