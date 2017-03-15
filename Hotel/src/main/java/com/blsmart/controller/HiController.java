package com.blsmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by charspan on 15/03/2017.
 */
@Controller
//@ResponseBody
//@Controller + @ResponseBody = @RestController
//http://localhost:8081/Hello/hi
@RequestMapping("/Hello")
public class HiController {

    // 不写 method 都支持 GET POST
    @RequestMapping(value = {"/hi","/Hi"}, method = RequestMethod.GET)
    public String hi() {
        return "index";
    }

}
