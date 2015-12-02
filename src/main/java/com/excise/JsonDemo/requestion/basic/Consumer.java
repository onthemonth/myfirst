package com.excise.JsonDemo.requestion.basic;

/**
 * Created by mgq on 2015/12/1.
 */
public class Consumer {

    public static void main(String[] args){
        //反序列化
        Person person=(Person)SerializationUtils.readObject();
        System.out.println(person.getName()+"---"+person.getAge());
    }
}
