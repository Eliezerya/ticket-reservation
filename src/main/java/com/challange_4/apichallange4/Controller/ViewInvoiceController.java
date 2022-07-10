package com.challange_4.apichallange4.Controller;

import com.challange_4.apichallange4.Service.ViewInvoiceService;
import com.challange_4.apichallange4.Service.ViewInvoiceService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ViewInvoiceController {
    @Autowired
    ViewInvoiceService viewInvoiceService;
    @Autowired
    ViewInvoiceService2 viewInvoiceService2;

    @GetMapping("export/{format}/{idUser}")
    public String exportReport(@PathVariable("format") String format, @PathVariable("idUser") Integer idUser)throws Exception{

        return viewInvoiceService.report(format,idUser);

    }

    @GetMapping(value = "export/{format}/{idUsers}",produces = "application/pdf")
    public byte[] getInvoice(@PathVariable("format") String format,@PathVariable("idUsers") Integer idUsers) throws
            JRException, FileNotFoundException, SQLException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("parameters", idUsers);
        return viewInvoiceService2.generate_pdf(parameters, "gg");
    }

}
