package com.blsmart.controller;

import com.blsmart.properties.BoyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by charspan on 15/03/2017.
 */
/**
 * @Controller 处理 http 请求
 * @RestController Spring4之后新加的注解,远来返回 json 需要@ ResponseBody 配合@ Controller
 * @RequestMapping 配置 url 映射
 */
@RestController
public class HelloController {

    //配置内容的注入
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;
    @Autowired
    private BoyProperties boyProperties;


    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello SpringBoot! <br> " +
                "cupSize is " + cupSize + ", age is " + age + ". <br> " +
                "content is " + content + ". <br>" +
                boyProperties.toString();
    }
}
