package com.excise.JsonDemo.requestion.thread;

import java.util.ArrayList;

/**
 * Created by mgq on 2015/11/16.
 */
public class ThreadDemo {

    public static void main(String[] args)  {
        final InsertData insertData = new InsertData();

        new Thread() {
            public void run() {
                insertData.insert(Thread.currentThread());
            };
        }.start();


        new Thread() {
            public void run() {
                insertData.insert(Thread.currentThread());
            };
        }.start();
    }
}

class InsertData {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    //此种情况会出现两个线程同时插入的情况，两个线程交替插入数据   这是synchronized同步方法
    /*public void insert(Thread thread){
        for(int i=0;i<50;i++){
            System.out.println(thread.getName()+"在插入数据"+i);
            arrayList.add(i);
        }
    }*/
    //只有拿到锁的线程执行完成后，另一个线程才会继续插入 synchronized同步方法
    /*public synchronized void insert(Thread thread){
        for(int i=0;i<50;i++){
            System.out.println(thread.getName()+"在插入数据"+i);
            arrayList.add(i);
        }
    }*/
    //同步代码块
    /*public void insert(Thread thread){
        synchronized (this) {
        for(int i=0;i<50;i++){
                System.out.println(thread.getName() + "在插入数据" + i);
                arrayList.add(i);
            }
        }
    }*/
    //同步代码块
    Object object=new Object();
    public void insert(Thread thread){
        synchronized (object) {
            for(int i=0;i<50;i++){
                System.out.println(thread.getName() + "在插入数据" + i);
                arrayList.add(i);
            }
        }
    }
}
