package com.challange_4.apichallange4.Controller;


import com.challange_4.apichallange4.Dto.SeatDto;
import com.challange_4.apichallange4.Entity.Seat;
import com.challange_4.apichallange4.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SeatController {
    @Autowired
    SeatService seatsService;

    @PostMapping("api/seats/submit")
    public Map<String, Object> seats_submit(@RequestBody SeatDto seatsDto){
        Seat seats = seatsService.seats_submit(seatsDto);

        Map<String, Object> map = new HashMap<>();
        map.put("studio" , seatsDto);
        map.put("detail_studio" , seatsDto.getDetailSeat());

        return map;
    }
}
