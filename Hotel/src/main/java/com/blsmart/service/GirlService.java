package com.blsmart.service;

import com.blsmart.enums.ResultEnum;
import com.blsmart.exception.GirlException;
import com.blsmart.respository.GirlRespository;
import com.blsmart.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by charspan on 15/03/2017.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRespository;

    /**
     * 添加女生
     *
     * @param girl
     * @return
     */
    public Girl addGirl(Girl girl) {
        return girlRespository.save(girl);
    }

    /**
     * 通过 id 删除女生
     *
     * @param id
     * @return
     */
    public boolean deleteGirl(Integer id) {
        Girl girl = findById(id);
        if (girl.getName() != null) {
            girlRespository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过 id 查找女生
     *
     * @param id
     * @return
     */
    public Girl findById(Integer id) {
        return girlRespository.findOne(id);
    }

    /**
     * 获取所有女生列表
     *
     * @return
     */
    public List<Girl> getGirlList() {
        return girlRespository.findAll();
    }

    /**
     * 通过年龄女生列表
     *
     * @param age
     * @return
     */
    public List<Girl> getGirlByAge(Integer age) {
        return girlRespository.findByAge(age);
    }

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
        System.out.println("girl" + girl);
        Integer age = girl.getAge();
        if (age < 10) {
            // 小学
//            throw new Exception("小学");
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age < 16) {
            //初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        } else {
            //大学
            throw new GirlException(ResultEnum.HIGHT_SCHOOL);
        }
        // 其他复杂内容
    }

}
