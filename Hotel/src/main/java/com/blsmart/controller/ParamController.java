package com.blsmart.controller;

/**
 * Created by charspan on 15/03/2017.
 */

import org.springframework.web.bind.annotation.*;

/**
 * @PathVariable 获取 url 中的数据
 * @RequestParam 获取请求参数的值
 * @GetMapping 组合注解
 */
@RestController
public class ParamController {

    //http://localhost:8081/param1/22  也可以..{id}/param/
    @RequestMapping(value = "/param1/{id}", method = RequestMethod.GET)
    public String param1(@PathVariable("id") Integer id) {
        return "id: " + id;
    }

    //http://localhost:8081/param2?id=22
    //@RequestParam("id")
    //@RequestMapping 太长用 @GetMapping 或者 @PostMapping 等待
    @RequestMapping(value = "/param2", method = RequestMethod.GET)
    public String param2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id: " + myId;
    }

}
