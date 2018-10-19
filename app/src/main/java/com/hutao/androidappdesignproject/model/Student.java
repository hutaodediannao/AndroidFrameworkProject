package com.hutao.androidappdesignproject.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 描述: 学生表
 * 作者: 胡涛
 * 时间: 2018-10-18 8:39
 */
@Entity
public class Student {

    @Id
    private Long _id;
    @Unique
    private String name;
    private int age;
    private String city;

    public Student() {
    }

    @Generated(hash = 1138355004)
    public Student(Long _id, String name, int age, String city) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
