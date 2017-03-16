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
 * Created by charspan on 15/03/2017.
 */
@RestController
@RequestMapping(value = "/girls"/*, method = {
        RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE}*/)
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    /**
     * RESTful API 设计
     * |请求类型|请求路径|功能
     * |GET|/girls|获取女生列表|
     * |POST|/girls|创建一个女生|
     * |GET|/girls/id|通过 id 查询一个女生|
     * |PUT|/girls/id|通过 id 更新一个女生|
     * |DELETE|girls/id|通过 id 删除一个女生|
     */
    //一般情况不能再这里调用 dao
    @Autowired
    private GirlRespository girlRespository;

    @GetMapping("")
    public List<Girl> girlList() {
        logger.info("girlList");
        return girlRespository.findAll();
    }

//    //添加女生
//    @PostMapping("")
//    public Girl girlAdd(@RequestParam("name") String name, @RequestParam("age") Integer age) {
//        Girl girl = new Girl();
//        girl.setName(name);
//        girl.setAge(age);
//        return girlRespository.save(girl);
//    }

    //添加女生
    @PostMapping("")
    //@Valid 过滤
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRespository.save(girl));
    }

    //通过 id 查找女生
    @GetMapping(value = "/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRespository.findOne(id);
    }

    //更新女生
    @PutMapping(value = "/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);
        return girlRespository.save(girl);
    }

    //通过 id 删除女生
    @DeleteMapping(value = "/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRespository.delete(id);
    }

    //通过年龄查询女生
    @GetMapping(value = "/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRespository.findByAge(age);
    }

    @Autowired
    private GirlService girlService;

    //事务处理
    @PostMapping(value = "/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
