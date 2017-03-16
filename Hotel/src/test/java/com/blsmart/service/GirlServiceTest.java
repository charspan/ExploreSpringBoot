package com.blsmart.service;

import com.blsmart.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by charspan on 16/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void insertTwo() throws Exception {

    }

    @Test
    public void findOneTest() {
        Girl girl = girlService.findById(1);
        Assert.assertEquals(new Integer(19), girl.getAge());
    }
}