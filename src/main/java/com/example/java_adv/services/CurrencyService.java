package com.example.java_adv.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {
    private static final String PRIVATBANK_API = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

    public String getDollarExchangeRate() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(PRIVATBANK_API, String.class);

        return response.getBody();
    }
}
