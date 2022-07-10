package com.challange_4.apichallange4.Service;


import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    ApplicationContext context;
    @Autowired
    JdbcTemplate jdbcTemplate;

    RestTemplate restTemplate;

    public byte[] generate_pdf(Map<String, Object> parameters, String reportName){
        try {
            Resource resource = context.getResource("classpath:/Invoice.jrxml");
            InputStream inputStream = resource.getInputStream();

            JasperReport report = JasperCompileManager.compileReport(inputStream);

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, jdbcTemplate.getDataSource().getConnection());

            byte[] result = JasperExportManager.exportReportToPdf (jasperPrint);

            System.out.println("--- Yey Bisa");
            return result;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
