package com.challange_4.apichallange4.Controller;

import com.challange_4.apichallange4.Dto.CostumerDto;
import com.challange_4.apichallange4.Entity.Costumer;
import com.challange_4.apichallange4.Service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CostumerController {
    @Autowired
    CostumerService usersService;

    @PostMapping("api/Users/save")
    public ResponseEntity<Object> submit_users(@RequestBody CostumerDto usersDto){
        usersService.save_users(usersDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("api/Users/display")
    public ResponseEntity<?> users_display() {
        List<Costumer> users = usersService.users_display();
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }

    @GetMapping("api/Users/display/{id_users}")
    public ResponseEntity<?> users_display_byID(@PathVariable int id_users){
        List<Costumer> users = usersService.users_display_byID(id_users);

        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("api/Users/delete/{id_users}")
    public ResponseEntity<?> users_delete_byID(@PathVariable int id_users){
        usersService.users_delete_byID(id_users);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("api/Users/update/{id_users}")
    public ResponseEntity<?> users_update_byID(@PathVariable int id_users,@RequestBody CostumerDto usersDto)throws Exception{
        usersService.users_update_byID(id_users,usersDto);
        List<Costumer> users = usersService.users_display_byID(id_users);
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }

}
