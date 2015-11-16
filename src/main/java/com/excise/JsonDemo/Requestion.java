package com.excise.JsonDemo;

import com.excise.JsonDemo.requestion.test.Base;
import com.excise.JsonDemo.requestion.test.Sub;
import org.junit.Test;

import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

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
        calPrice(1000, 90, 90);
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

    //复写可变参数方法也要循规蹈矩
    @Test
    public void test06(){

        //向上转型
        Base base=new Sub();
        //base对象是把子类对象做了向上转型，形参列表是由父类决定。
        base.fun(100,50);//调用子类的fun方法。
        //不转型
        Sub sub=new Sub();
        //sub.fun(100,50);编译不通过
    }

    //警惕自增的陷阱
    @Test
    public void test07(){

        //i++：表示先赋值后加一     ++i:表示先加一后赋值
        //解释：i++ 相当于： int temp=count;  count=count+1;  return temp;
        //++i :  int temp=count+1;  return temp;

        //!!!!!!!!!!!!!!!!!!!!!!!!!!
        int count=0;
        for (int i=0;i<10;i++){
            count=count++;
        }
        System.out.println("count="+count);//打印0

        //改进后方可打印=========
        int count1=0;
        for (int i=0;i<10;i++){
            count1++;
        }
        System.out.println("count="+count1);//打印10

        //或者
        int count2=0;
        for (int i=0;i<10;i++){
            count2=++count2;
        }
        System.out.println("count="+count2);//打印10

        //i++ ; 它所在语句先执行，然后它再执行。
        //++i ; 它先执行，然后它所在的语句再执行。
        //下面这个练习。
        int t=1;
        ++t;
        System.out.println(++t);
        List list=new ArrayList();
        //String [] l={"123"};
        boolean s =list.add(123);
        list.add(123);
        //list.remove(0);
        System.out.println(list);
//        String [] ss=new String[1];
//        for (int i=0;i<ss.length;i++) {
//            System.out.println(ss[i]);
//        }
    }

    @Test
    public void test08()throws Exception{
        Integer integer=new Integer(2);

        Sub sub=new Sub();
        int has=sub.hashCode();
        System.out.println(Integer.toHexString(has));
        System.out.println(sub.toString());
        Class c=Class.forName("com.excise.JsonDemo.requestion.test.Sub");
        Method [] memthods= c.getDeclaredMethods();
        Sub ss=(Sub)c.newInstance();
        int [] s={1,5,5};
        ss.fun(12,s);
        for (int i=0;i<memthods.length;i++)
        System.out.println(memthods[i]);
        String ss1="sdfasdfasdfa";
        String ss2="sdfasdfasdfa";
        System.out.println(ss1.hashCode());
        System.out.println(ss2.hashCode());
    }

//    public final native void ddd(long timeout);


}
