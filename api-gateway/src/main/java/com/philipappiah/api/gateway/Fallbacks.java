package com.philipappiah.api.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Fallbacks {


    @GetMapping(path = "/userServiceFallback")
    public String userServiceFallback(){
        return "User service is taking longer than expected. Please try again";
    }

    
    @GetMapping(path = "/departmentServiceFallback")
    public String departmentServiceFallback(){
        return "Department service is taking longer than expected. Please try again";
    }
    
}
