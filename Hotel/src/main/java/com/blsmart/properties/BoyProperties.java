package com.blsmart.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by charspan on 15/03/2017.
 */
@Component
@ConfigurationProperties(prefix = "boy")
public class BoyProperties {
    private int age;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BoyProperties{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
