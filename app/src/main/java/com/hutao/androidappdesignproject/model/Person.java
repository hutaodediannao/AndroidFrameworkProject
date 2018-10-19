package com.hutao.androidappdesignproject.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 描述: 测试数据库model
 * 作者: 胡涛
 * 时间: 2018-10-17 17:16
 */

@Entity(nameInDb = "HuTao_" + "person")
public class Person{

    @Id(autoincrement = true)
    private Long _id;
    private String city;
    private String avator;
    private String name;
    private int age;
    private boolean isStudent;

    public Person(String city, String avator, String name, int age, boolean isStudent) {
        this.city = city;
        this.avator = avator;
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }

    @Generated(hash = 1970748029)
    public Person(Long _id, String city, String avator, String name, int age,
            boolean isStudent) {
        this._id = _id;
        this.city = city;
        this.avator = avator;
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvator() {
        return this.avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsStudent() {
        return this.isStudent;
    }

    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    @Override
    public String toString() {
        return "\n{" +
                "_id=" + _id +
                ", city='" + city + '\'' +
                ", avator='" + avator + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isStudent=" + isStudent +
                '}';
    }
}
