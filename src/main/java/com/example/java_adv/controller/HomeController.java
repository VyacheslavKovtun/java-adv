package com.example.java_adv.controller;

import com.example.java_adv.services.CurrencyService;
import com.example.java_adv.services.ParseService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/report-page")
    public String reportPage() {
        return "excel";
    }

    @GetMapping("/currency-page")
    public String currencyPage(Model model) {
        String jsonData = currencyService.getDollarExchangeRate();
        model.addAttribute("json", jsonData);
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, String>> data = mapper.readValue(jsonData, new TypeReference<List<Map<String, String>>>() {});
            model.addAttribute("data", data);
        } catch (Exception e) {
            model.addAttribute("data", null);
        }
        return "currency";
    }
}
