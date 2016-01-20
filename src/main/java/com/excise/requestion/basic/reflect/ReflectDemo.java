package com.excise.requestion.basic.reflect;

import java.lang.reflect.Method;

/**
 * Created by mgq on 2016/1/19.
 */
public class ReflectDemo {
    public static void main(String[] args)throws Exception{
        try {
//            A a=new A();
//            a.getClass();
            Class a=Class.forName("com.excise.requestion.basic.reflect.A");
            A aa=(A)a.newInstance();
            String resultt=aa.upperOrLower("sljfkl","解决");
            System.out.println(resultt);
//        Method method= a.getMethod("print");//执行无参数方法
//        method.invoke(new Object(){});
//        Method method=a.getMethod("print",int.class,int.class);
//            Method method=a.getMethod("print",new Class[]{int.class,int.class});
//            method.invoke(aa,2,3);
            Method method=a.getMethod("diff",new Class[]{int.class,int.class});
            Object result=method.invoke(aa,2,3);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

class A{
    public static void print(){
        System.out.println("无参方法执行。。。。。");
    }
    public static void print(int i,int j){
        System.out.println("整数型："+(i+j));
    }
    public static void print(String s,String t){
        System.out.println("字符串：" + s.toUpperCase() + "," + t.toLowerCase());
    }
    public static int diff(int a,int b){
        return a-b;
    }
    public String upperOrLower(String upper,String low){
        if(null==upper || "".equals(upper)|| null==low || "".equals(low))
            return null;
        return upper.toUpperCase()+low.toLowerCase();
    }
}
