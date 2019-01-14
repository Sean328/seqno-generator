package com.xxl.common;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author lixin
 * @date 2019-01-02 17:50
 **/
@Service
public class PostConstructService {

    private String name;
    private Integer age;
    private String gender;

    @PostConstruct
    private void init(){
        this.name = "xxl";
        this.age = 18;
        this.gender = "男";
    }

    public void sout(){
        System.out.println(name + age + gender);
    }

}
