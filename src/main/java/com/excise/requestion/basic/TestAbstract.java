package com.excise.requestion.basic;

/**
 * Created by mgq on 2015/11/17.
 */
public abstract class TestAbstract {

    private Integer s;

    private String ss;

    TestAbstract(Integer i,String j){
        this.s=i;
        this.ss=j;
    }


    public void test01(){
        System.out.println("测试抽象类"+s+ss);
    }
}
