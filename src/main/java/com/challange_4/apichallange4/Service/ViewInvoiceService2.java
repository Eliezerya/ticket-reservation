package com.challange_4.apichallange4.Service;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;

@Service
public class ViewInvoiceService2 {
    @Autowired
    ApplicationContext context;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public byte[] generate_pdf (Map<String, Object> parameters, String reportName) {
        try{
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost/reservasi_tiket_db",
//                    "root",
//                    "");
            Connection conn = jdbcTemplate.getDataSource().getConnection();
            Resource resource = context.getResource("file:C:/Users/User/IdeaProjects/api-challenge4/src/main/resources/Invoice.jrxml");
            InputStream inputStream = resource.getInputStream();
            JRDataSource datasource = new JREmptyDataSource();
            JasperReport report = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, conn);
//            new JRMapArrayDataSource(new Object[] { parameters})
//            jdbcTemplate.getDataSource().getConnection()
            byte[] result = JasperExportManager.exportReportToPdf(jasperPrint);
            System.out.println("Tch Done");
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
