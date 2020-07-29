/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.microservices.CurrencyConversionService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author krish
 */
@RestController
public class CurrencyConversionController {
    
    @Autowired
    CurrencyExchangeServiceProxy proxy;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @GetMapping("/currencyConverter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean currencyConverter(@PathVariable String from,@PathVariable String to,
            @PathVariable BigDecimal quantity){
        
      Map<String,String> uriVariables  =new HashMap<String,String>();
      uriVariables.put("from", from);
      uriVariables.put("to",to);  
      
      	ResponseEntity<CurrencyConversionBean> responseEntity=new RestTemplate()
                .getForEntity("http://localhost:8000/currency-Exchange/from/{from}/to/{to}",
        CurrencyConversionBean.class, uriVariables);
      
      CurrencyConversionBean currencyConversionBean=responseEntity.getBody();
      
      return new CurrencyConversionBean(currencyConversionBean.getId(),
      from,to,currencyConversionBean.getConversionMultiple(),quantity,
      quantity.multiply(currencyConversionBean.getConversionMultiple()),currencyConversionBean.getPort());
    } 
    
    
    
    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean currencyConverterUsingFeign(@PathVariable String from,@PathVariable String to,
    @PathVariable BigDecimal quantity ){ 
      CurrencyConversionBean currencyConversionBean=proxy.retriveExchangeValue(from, to);
      
      logger.info("{}", currencyConversionBean);
      
      return new CurrencyConversionBean(currencyConversionBean.getId(),
      from,to,currencyConversionBean.getConversionMultiple(),quantity,
      quantity.multiply(currencyConversionBean.getConversionMultiple()),currencyConversionBean.getPort());    
    }
    
    
    
}
