package com.blsmart;

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

}
