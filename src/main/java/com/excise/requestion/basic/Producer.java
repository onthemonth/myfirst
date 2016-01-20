package com.excise.requestion.basic;

/**
 * Created by mgq on 2015/12/1.
 */
public class Producer {

    public static void main(String[] args){
        Person person=new Person();
        person.setName("呵呵哒");
        person.setAge("22");
        SerializationUtils.writeObject(person);
    }
}
