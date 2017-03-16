package com.blsmart.controller;

import com.blsmart.domain.Girl;
import com.blsmart.domain.Result;
import com.blsmart.respository.GirlRespository;
import com.blsmart.service.GirlService;
import com.blsmart.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * RESTful API 设计
 * |请求类型|请求路径|功能
 * |GET|/girls|获取女生列表|
 * |POST|/girls|添加一个女生|
 * |GET|/girls/id|通过 id 查询一个女生|
 * |PUT|/girls/id|通过 id 更新一个女生|
 * |DELETE|girls/id|通过 id 删除一个女生|
 * |GET|girls/age/{age}|通过 age 获取女生列表|
 * |POST|girls/two|模拟测试事物处理|
 * |GET|girls/getAge/{id}|通过 id 查询女生年龄,模拟实现统一异常处理|
 *
 * Created by charspan on 15/03/2017.
 */
@RestController
@RequestMapping(value = "/girls")
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlService girlService;

    //获取女生列表
    @GetMapping("")
    public Result<List<Girl>> getGirlList() {
        return ResultUtil.success(girlService.getGirlList());
    }

    //添加女生,用 @Valid 过滤
    @PostMapping("")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlService.addGirl(girl));
    }

    //通过 id 查找女生
    @GetMapping(value = "/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlService.findById(id);
    }

    //更新女生 Content-Type = application/x-www-form-urlencoded 且 age >= 18
    @PutMapping(value = "/{id}")
    public Result<Girl> girlUpdate(@PathVariable("id") Integer id, @Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setId(id);
        return ResultUtil.success(girlService.addGirl(girl));
    }

    //通过 id 删除女生
    @DeleteMapping(value = "/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlService.deleteGirl(id);
    }

    //通过年龄查询女生
    @GetMapping(value = "/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlService.getGirlByAge(age);
    }


    //事务处理
    @PostMapping(value = "/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    //通过 id 查询女生年龄
    @GetMapping(value = "getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
