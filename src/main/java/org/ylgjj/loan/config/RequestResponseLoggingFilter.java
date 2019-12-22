package org.ylgjj.loan.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//@Order(2)
public class RequestResponseLoggingFilter implements  Filter {
    Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
    @Override
    public void doFilter(
      ServletRequest request,
      ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
  
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.info(
          "Logging Request  {} : {}", req.getMethod(), 
          req.getRequestURI());
        chain.doFilter(request, response);
        logger.info(
          "Logging Response :{}", 
          res.getContentType());
    }
 
    // other methods
}