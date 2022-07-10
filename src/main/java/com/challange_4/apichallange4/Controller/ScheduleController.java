package com.challange_4.apichallange4.Controller;


import com.challange_4.apichallange4.Dto.ScheduleDto;
import com.challange_4.apichallange4.Entity.Schedule;
import com.challange_4.apichallange4.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @PostMapping("api/schedule/submit/{ScheduleId}")
    public ResponseEntity<?> schedules_submit(@RequestBody ScheduleDto scheduleDto, @PathVariable(name = "ScheduleId") int ScheduleId){
        Schedule responEntity = scheduleService.schedules_submit(scheduleDto,ScheduleId);
        return new ResponseEntity<>(responEntity, HttpStatus.CREATED);
    }

}
