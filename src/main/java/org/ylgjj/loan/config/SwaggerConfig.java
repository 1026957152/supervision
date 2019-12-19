package org.ylgjj.loan.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.GitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置类
 * 在与spring boot集成时，放在与Application.java同级的目录下。
 * 通过@Configuration注解，让Spring来加载该类配置。
 * 再通过@EnableSwagger2注解来启用Swagger2。
 */
//@SpringBootApplication        //same as @Configuration+@EnableAutoConfiguration+@ComponentScan
@Configuration
@EnableSwagger2  //启动swagger注解
public class SwaggerConfig implements WebMvcConfigurer {


    @Autowired
    private GitProperties git;


    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//api接口包扫描路径
                .paths(PathSelectors.any()) //可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */

    private ApiInfo apiInfo() {

     String a=   "当前接口并未做缓存或优化，避免大时间间隔数据抽取, h-9服务统计-controller 需要读入所有注册用户身份证，未作存量数据缓存，返回时间较久。" +
             "\n这些问题需要一天左右时间可解决";
        return new ApiInfoBuilder()
                .title("榆林住房公积金省监管平台 API "+git.get("build.version"))  //设置文档的标题
                .description("\n"+a) //设置文档的描述
            //    .termsOfServiceUrl("http://192.168.10.3/")
                .contact(new Contact("神玥软件","","0311-85138610"))
       // modelAndView.addObject("version", git.get("build.version"));
                .version("1.0")
                .build();
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//    }

}