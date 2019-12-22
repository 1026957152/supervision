package org.ylgjj.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.ylgjj.loan.config.RequestResponseLoggingFilter;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "jpaAuditorConfiguration")
@EnableScheduling
public class LoanApplication {
	@Bean
	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter(){
		FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean
				= new FilterRegistrationBean<>();

		registrationBean.setFilter(new RequestResponseLoggingFilter());
		registrationBean.addUrlPatterns("/JG/*");

		return registrationBean;
	}
	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
