package com.blsmart.service;

import com.blsmart.enums.ResultEnum;
import com.blsmart.exception.GirlException;
import com.blsmart.respository.GirlRespository;
import com.blsmart.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by charspan on 15/03/2017.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRespository;

    // 同时成功或者失败
    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl();
        girl1.setName("A");
        girl1.setAge(21);
        girlRespository.save(girl1);
        Girl girl2 = new Girl();
        girl2.setName("sdf");
        girl2.setAge(12);
        girlRespository.save(girl2);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRespository.findOne(id);
        System.out.println("girl"+girl);
        Integer age = girl.getAge();
        if (age < 10) {
            // 小学
//            throw new Exception("小学");
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age < 16) {
            //初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else {
            //大学
            throw new GirlException(ResultEnum.HIGHT_SCHOOL);
        }
        // 其他复杂内容
    }

    /**
     * 通过 id 查询
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRespository.findOne(id);
    }

}
