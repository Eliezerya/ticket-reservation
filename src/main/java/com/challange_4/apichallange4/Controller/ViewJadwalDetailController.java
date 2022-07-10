package com.challange_4.apichallange4.Controller;

import com.challange_4.apichallange4.Entity.ViewJadwalDetail;
import com.challange_4.apichallange4.Service.ViewJadwalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewJadwalDetailController {
    @Autowired
    ViewJadwalDetailService viewJadwalDetailService;

    @GetMapping("api/view/jadwal")
    public ResponseEntity<?> view_jadwal_detail(){
        return new ResponseEntity<>(viewJadwalDetailService.display_all(), HttpStatus.ACCEPTED);
    }
}
