package com.challange_4.apichallange4.Controller;

import com.challange_4.apichallange4.Entity.MasterSeats;
import com.challange_4.apichallange4.Service.MasterSeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MasterSeatsController {
    @Autowired
    MasterSeatsService masterSeatsService;

    @GetMapping("api/studio/check/seats/")
    public ResponseEntity<?> get_seats_byStatus(@RequestParam(value = "status") boolean status ){
        List<MasterSeats> get_status = masterSeatsService.get_studioBy_status(status);
        return new ResponseEntity<>(get_status, HttpStatus.ACCEPTED);
    }
}
