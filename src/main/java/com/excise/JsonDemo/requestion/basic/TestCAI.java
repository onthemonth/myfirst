package com.excise.JsonDemo.requestion.basic;

/**
 * Created by mgq on 2015/11/18.
 */
public class TestCAI extends TestAbstract {

    TestCAI(Integer i, String j) {
        super(i, j);
    }

    public static void main(String [] args){
        TestCAI testCAI=new TestCAI(3,"dd");

        testCAI.test01();
    }
}
