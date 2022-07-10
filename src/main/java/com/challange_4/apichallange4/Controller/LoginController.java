package com.challange_4.apichallange4.Controller;

import com.challange_4.apichallange4.Entity.User;
import com.challange_4.apichallange4.Service.Impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserLoginServiceImpl userLoginService;

    @PostMapping("/registration")
    public ResponseEntity<?> registration (@RequestBody User user ){
//        Map <String, String> map = new HashMap<>();
        User userLogin = userLoginService.findByUsername(user.getEmail());
        if (userLogin !=null){
//            map.put(user.getUsername(), "username already exist");
            return new ResponseEntity<>(userLogin, HttpStatus.BAD_REQUEST);
        }else {
            userLoginService.saveUser(user);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
