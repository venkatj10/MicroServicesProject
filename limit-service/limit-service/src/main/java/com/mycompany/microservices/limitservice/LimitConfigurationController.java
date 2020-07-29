/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.microservices.limitservice;
import com.mycompany.microservices.limitservice.Bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author krish
 */

@RestController
public class LimitConfigurationController {
    
    
    @Autowired
    Configuration configuration;
    
    
    
    @GetMapping("/limitService/limits")
    public LimitConfiguration limitconfig(){
        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());  
        }
        
        
    
    
    @GetMapping("/limitService-hystrix/limits")
    @HystrixCommand(fallbackMethod="faultTolerantlimitConfig")
    public LimitConfiguration limitconfigFaultTolerant(){
          throw new RuntimeException("Not Available");
        }
    
    
    public LimitConfiguration faultTolerantlimitConfig(){
      return new LimitConfiguration(111,1);   
    }
    
    
    }