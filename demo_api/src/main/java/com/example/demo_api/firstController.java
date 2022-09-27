package com.example.demo_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;






@RestController
//@Api
public class firstController {
    //@ApiOperation(value = "csye6225API")
    @GetMapping(produces = "application/json",value="/welcome")
    @ResponseBody
    public String first_api(){
        
        return "Welcome to my first API project.";
    }
  


}
