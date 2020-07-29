/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.microservices.CurrencyConversionService;

import java.math.BigDecimal;

/**
 *
 * @author krish
 */
public class CurrencyConversionBean {
    
    
    int id;
    String from;
    String to;
    BigDecimal ConversionMultiple;
    BigDecimal quantity;
    BigDecimal totalCalculatedAmount;
    int port;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return ConversionMultiple;
    }

    public void setConversionMultiple(BigDecimal ConversionMultiple) {
        this.ConversionMultiple = ConversionMultiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public CurrencyConversionBean(int id, String from, String to, BigDecimal ConversionMultiple, BigDecimal quantity, BigDecimal totalCalculatedAmount, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.ConversionMultiple = ConversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.port = port;
    }

    public CurrencyConversionBean() {
    }
    
}
