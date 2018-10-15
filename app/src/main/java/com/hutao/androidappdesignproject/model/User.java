package com.hutao.androidappdesignproject.model;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * 描述: Databinging 的model类
 * 作者: 胡涛
 * 时间: 2018-10-15 11:33
 */
public class User {

    private ObservableField<String> name;
    private ObservableInt age;
    private ObservableBoolean isHappy;

    public User(String name, int age, boolean isHappy) {
        this.name = new ObservableField<>(name);
        this.age = new ObservableInt(age);
        this.isHappy = new ObservableBoolean(isHappy);
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableInt getAge() {
        return age;
    }

    public void setAge(ObservableInt age) {
        this.age = age;
    }

    public ObservableBoolean getIsHappy() {
        return isHappy;
    }

    public void setIsHappy(ObservableBoolean isHappy) {
        this.isHappy = isHappy;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name.get() +
                ", age=" + age.get() +
                ", isHappy=" + isHappy.get() +
                '}';
    }
}
