package com.challange_4.apichallange4.Controller;

import com.challange_4.apichallange4.Service.ReportService;
import com.challange_4.apichallange4.Service.ViewInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReportController {
    @Autowired
    ReportService reportService;
    @Autowired
    ViewInvoiceService viewInvoiceService;

    @GetMapping(value = "/invoice/{format}/{idUsers}", produces = "application/pdf")
    public byte[] getInvoice(@PathVariable("format") String format, @PathVariable("idUsers") Integer iduser) throws Exception{
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("UserParam", iduser);
        return reportService.generate_pdf (parameters, "Invoice");
    }


}
