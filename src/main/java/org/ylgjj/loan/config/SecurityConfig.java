package org.ylgjj.loan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


   @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("USER", "ADMIN");
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**",
                "/components/**",
                "/js/**",
                "/images/**",
                "/api/v1/**",
                "/login/sentSMSCodeToUser",

        "/captch/**"

/*                "/lib/**",
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**"*/
                );



    }

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/指标明细查询",
            "/指标明细查询",


            "/",
            "/JG/**",
            "/more_grid_cx.service",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
        .antMatchers(AUTH_WHITELIST).permitAll()  // whitelist Swagger UI resources

                //.antMatchers("/swagger-ui.html").permitAll()
              //  .antMatchers("/**").permitAll()

               // .antMatchers("/JG/**").permitAll()
                .and().authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
        .and().csrf().disable();
    }

/*
  @Override
    protected void configure(HttpSecurity http) throws Exception { // @formatter:off
        http.requestMatchers(

        ).requestMatchers(                new NegatedRequestMatcher(
                new OrRequestMatcher(
                        new AntPathRequestMatcher("/login"),
                        new AntPathRequestMatcher("/logout"),
                        new AntPathRequestMatcher("/health"),
                        new AntPathRequestMatcher("/user/me"),


                        new AntPathRequestMatcher("/oauth/authorize"),
                        new AntPathRequestMatcher("/oauth/confirm_access")
                )
        ))
                .antMatchers("/login", // 这些会调整到 login AccessDenie  会 跳转到 登录界面 登录界面 登录界面
                        "/error",
                        "/error1",
                        "/user/me",

                        "/oauth/token",
                        "/oauth/authorize")  // 这些之外的 不跳转了啊啊啊啊啊。

*/
/*
                .requestMatchers()
               .antMatchers("/login",
                       "/health",
                       "/oauth/token"
*//*
*/
/*                       "/login/sentSMSCodeToUser",
                       "/error",

                       "/oauth/authorize"*//*
*/
/*

               )*//*

               .and()
            .authorizeRequests()
                .antMatchers(
                     "/login",
                        "/api/v1/**",//???
                        "/user/me",//???
                              "/actuator/health",
                        "/register/registerUserByPhone_new",

                        "/createCompany/createUser",
                        "/createCompany/createNewUser",
                        "/createCompany/createNewCompany",
                        "/captch/sentSMSCodeToUser",
                        "/captch/command_auth_locked_user_mobile_with_sms_verification_code_new",
                        "/registerDriver/**",
                        "/error",
                        "/oauth/token"
                ).permitAll()
                .and()
                .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")

        //        .failureHandler(authenticationFailureHandler)
             .failureUrl("/login?authentication_error=true")
                .successForwardUrl("/index")

            .permitAll()
                .and()
*/
/*      .addFilterBefore(
              new CustomFilter(),AnonymousAuthenticationFilter.class)*//*

*/
/*                .addFilterBefore(
                        new CustomFilter(),OAuth2AuthenticationProcessingFilter.class)*//*

                .addFilterBefore(createSMSCustomFilter(), UsernamePasswordAuthenticationFilter.class)
              .addFilterBefore(authenticationFilter(),UsernamePasswordAuthenticationFilter.class)
// .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())

         //    .and()
                 //     .exceptionHandling().authenticationEntryPoint(unauthorizedHandler);//new CustomHttp403ForbiddenEntryPoint("/login"))

       //    .addFilter(new JWTAuthorizationFilter(authenticationManager()))
   */
/*             .and()
            .addFilterBefore(new
                WechatOAuth2ClientContextFilter(), OAuth2ClientAuthenticationProcessingFilter.class)*//*

        ;
    } // @formatter:on

*/









}