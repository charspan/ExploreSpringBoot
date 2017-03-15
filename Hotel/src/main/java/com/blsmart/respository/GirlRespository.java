package com.blsmart.respository;

import com.blsmart.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by charspan on 15/03/2017.
 */
//类名 id 类型
public interface GirlRespository extends JpaRepository<Girl, Integer> {

    //通过年龄来查询 方法名不能乱写
    public List<Girl> findByAge(Integer age);

}
