package com.example.java_adv.services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class ExcelService {

    public byte[] generateExcelReport() {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Report");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Назва");
            header.createCell(2).setCellValue("Значення");

            for (int i = 1; i <= 5; i++) {
                Row row = sheet.createRow(i);
                row.createCell(0).setCellValue(i);
                row.createCell(1).setCellValue("Пункт " + i);
                row.createCell(2).setCellValue(Math.random() * 100);
            }

            workbook.write(bos);
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
