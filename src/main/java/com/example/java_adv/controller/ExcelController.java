package com.example.java_adv.controller;

import com.example.java_adv.services.ExcelService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelController {

    private ExcelService excelService = new ExcelService();

    @GetMapping("/excel")
    public ResponseEntity<byte[]> generateReport() {
        byte[] excelBytes = excelService.generateExcelReport();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.xlsx");

        return ResponseEntity.ok().headers(headers).body(excelBytes);
    }
}
