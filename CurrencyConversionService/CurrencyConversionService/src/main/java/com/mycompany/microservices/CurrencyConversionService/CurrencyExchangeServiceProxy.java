/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.microservices.CurrencyConversionService;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author krish
 */



@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface  CurrencyExchangeServiceProxy {
    
    @GetMapping("/currency-exchange-service/currency-Exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);    
 }
