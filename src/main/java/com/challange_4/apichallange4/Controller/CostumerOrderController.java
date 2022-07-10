package com.challange_4.apichallange4.Controller;

import com.challange_4.apichallange4.Dto.CustomerOrderDto;
import com.challange_4.apichallange4.Service.CostumerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostumerOrderController {
    @Autowired
    CostumerOrderService costumerOrderService;
    @PostMapping("api/order/save")
    public ResponseEntity<?> save_customer(@RequestBody CustomerOrderDto customerOrderDto){
        costumerOrderService.customer_save(customerOrderDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
