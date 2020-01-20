package com.ylf.demo.kafka.kafkaAPI;

import java.io.Serializable;

/**
 * @author: leifeng.ye
 * @date: 2020-01-16
 * @desc:
 */
public class Student implements Serializable {
    private Integer age;
    private String name;

    @Override
    public String toString(){
        return "姓名:"+this.name+" 年龄:"+this.age;
    }

    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
