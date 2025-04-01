package com.example.java_adv.controller;

import com.example.java_adv.services.ParseService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ParseController {

    private ParseService parseService = new ParseService();

    @GetMapping("/parse-page")
    public String showParsePage() {
        return "parse";
    }

    @GetMapping("/parse-d")
    public String parseWebsite(@RequestParam("url") String url, Model model) {
        try {
            String title = parseService.getPageTitle(url);
            model.addAttribute("title", title);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Невірний URL. Введіть коректний сайт з http:// або https://");
        } catch (IOException e) {
            model.addAttribute("error", "Не вдалося отримати заголовок. Переконайтеся, що сайт доступний.");
        }
        return "parse";
    }
}
