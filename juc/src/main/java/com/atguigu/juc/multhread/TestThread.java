package com.atguigu.juc.multhread;

import org.springframework.stereotype.Controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    1、线程    操作      资源类
    2、高内聚   低耦合
 */
public class TestThread {
    public static void main(String[] args) {
        Ticket t1 = new Ticket();
        //第一个线程对象
        new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i = 1;i<=40;i++){
                    t1.sale();
                }
            }
            },"A").start();
        //第二个线程对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i<=40;i++){
                    t1.sale();
                }
            }
        },"B").start();
        //第二个线程对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i<=40;i++){
                    t1.sale();
                }
            }
        },"C").start();
        }
}

/*class MyThread extends Thread implements Runnable{

}*/

class Ticket{
    private int tickets = 50;
    private Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try{
            if(tickets > 0){
                System.out.println(Thread.currentThread().getName()+"\t售出第"+(tickets--)+"张票，还剩余"+tickets+"张");
            }
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            lock.unlock();
        }

    }
}