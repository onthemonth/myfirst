package com.excise.JsonDemo;

import com.excise.JsonDemo.requestion.test.Base;
import com.excise.JsonDemo.requestion.test.Sub;
import org.junit.Test;

import java.text.NumberFormat;

/**
 * Created by mgq on 2015/11/9.
 */
public class Requestion {

    //三元操作符的类型必须一致
    @Test
    public void test03(){

        int i=80;

        String s1=String.valueOf(i<100?90:100);

        String s2=String.valueOf(i<100?90:100.0);
        System.out.println(s1.equals(s2));//false
    }

    //避免带有可变参数的方法重载
    //=============04===========
    @Test
    public void test04(){
        //打九折
        //当这种情况下，程序回去调用简单折扣的
        //原理：int 本身是一个原生类型，而数组本身是一个对象，编译器想要‘偷懒’，于是他会从最简单的猜想，只要符合条件就会通过，于是就出现了这个问题
        calPrice(1000,90);

        //复杂打折
        calPrice(1000,90,90);
    }
    //价格   折扣
    private void calPrice(int price,int disCount){
        float knockdownPrice=price*disCount/100.0f;
        System.out.println("简单折扣后的价格是："+formatCurrency(knockdownPrice));
    }
    //价格   折扣(折上折)
    private void calPrice(int price,int... disCounts){
        float knockdownPrice=price;
        for (int discount:disCounts){
            knockdownPrice=knockdownPrice*discount/100;
        }
        System.out.println("复杂折扣后的价格是："+formatCurrency(knockdownPrice));
    }
    //格式化成本的货币形式
    private String formatCurrency(float price){
        return NumberFormat.getCurrencyInstance().format(price);
    }
    //=============04===========

    //============05============
    //别让null值和空值威胁到可变参数
    @Test
    public void test05(){
        methodA("China",0);
        methodA("China","people");
        //methodA("China");
        //methodA("China",null);  编译报错，这两种情况都符合形参格式，编译器不知道该调用哪个方法，于是报错。
        //解决方法，提前声明
        //String[] s=null;
        //methodA("China",s);
    }
    private void methodA(String str,Integer... is){

    }

    private void methodA(String str,String... strs){

    }

    //============05============

    @Test
    public void test06(){

        //向上转型
        Base base=new Sub();
        base.fun(100,50);
        //不转型
        Sub sub=new Sub();
        //sub.fun(100,50);编译不通过
    }
}
