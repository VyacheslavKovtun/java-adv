package com.example.java_adv.controller;

import com.example.java_adv.services.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    private CurrencyService currencyService = new CurrencyService();

    @GetMapping("/currency")
    public String getCurrency() {
        return currencyService.getDollarExchangeRate();
    }
}
