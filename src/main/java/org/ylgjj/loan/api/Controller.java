package org.ylgjj.loan.api;


import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ylgjj.loan.config.ConfigProperties;
import org.ylgjj.loan.domain.Query;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.model.JwtResponse;
import org.ylgjj.loan.service.CustomerService;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.BindException;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by zohu on 6/29/2015.
 */
@RestController
@RequestMapping("/loan_share/public/xfd")
public class Controller {






    @Autowired
    CustomerService customerService;

    @Autowired
    ConfigProperties configProperties;

    @RequestMapping(value = "/gjjgrzhxxcx.service", method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult url(@Valid /*@RequestBody*/ @RequestBody  Query query, Errors errors)  {
        if (errors.hasErrors()) {
            return ReturnResult.情况4_入参数格式错误(errors.toString());
          //  return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        if(!query.getAppid().equals(configProperties.getIcbc().getAppid())){
            return ReturnResult.情况3_您没有权限访问("APPID 非法");

        }
        System.out.println("----------------- "+  configProperties.toString());

        System.out.println("----------------- "+ query.toString());
/*        if(bindException.getMessage() != null){
            return ReturnResult.情况4_入参数格式错误(bindException.getMessage());
        }*/
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
