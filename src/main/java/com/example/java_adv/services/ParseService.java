package com.example.java_adv.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ParseService {
    public String getPageTitle(String url) throws IOException {
        if (!isValidUrl(url)) {
            throw new IllegalArgumentException("The supplied URL, '" + url + "', is malformed. Make sure it is an absolute URL, and starts with 'http://' or 'https://'.");
        }

        Document doc = Jsoup.connect(url).get();
        return doc.title();
    }

    private boolean isValidUrl(String url) {
        return url != null && (url.startsWith("http://") || url.startsWith("https://"));
    }
}
