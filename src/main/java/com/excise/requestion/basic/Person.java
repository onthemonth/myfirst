package com.excise.requestion.basic;

import java.io.Serializable;

/**
 * Created by mgq on 2015/12/1.
 */
public class Person implements Serializable {

    private static final long serialVersionUID=123L;

    private String name;

    private String age;

    private String sex;

    private String birth;

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
