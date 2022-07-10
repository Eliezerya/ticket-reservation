package com.challange_4.apichallange4.Service;

import com.challange_4.apichallange4.Entity.ViewInvoice;
import com.challange_4.apichallange4.Repository.ViewInvoiceRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ViewInvoiceService {
    @Autowired
    ViewInvoiceRepo viewInvoiceRepo;

    public String report(String format, Integer user) throws Exception{
        String path = "C:\\Users\\andel\\IdeaProjects\\api-challange4\\target\\pdf";
        List<ViewInvoice> lsVwInvoice = viewInvoiceRepo.findByIdUsers(user);
        File file = ResourceUtils.getFile("C:\\Users\\andel\\IdeaProjects\\api-challange4\\src\\main\\resources\\Invoice.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(lsVwInvoice,false);

        Map<String,Object> paramater = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramater,jrBeanCollectionDataSource);

        if (format.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\Invoice.pdf");
        }
        return "File have Generated, path : "+path;
    }
}
