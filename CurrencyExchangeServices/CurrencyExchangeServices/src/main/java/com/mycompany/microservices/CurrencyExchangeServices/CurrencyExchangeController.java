/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.microservices.CurrencyExchangeServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author krish
 */

@RestController
public class CurrencyExchangeController {
 private Logger logger = LoggerFactory.getLogger(this.getClass());
 
 
    @Autowired
    Environment environment;

    @Autowired
    ExchangeValueRepository repository;


@GetMapping("/currency-Exchange/from/{from}/to/{to}")
public ExchangeValue getExchangeValue(@PathVariable String from ,@PathVariable String to){
    
 ExchangeValue exchangeValue=repository.findByFromAndTo(from, to);
  logger.info("{}",exchangeValue);
 exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
 return exchangeValue;
}    

}
