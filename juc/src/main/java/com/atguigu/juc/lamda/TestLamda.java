package com.atguigu.juc.lamda;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    1、lamda表达式的语法
        复制小括号，写死箭头号，落地大括号
 */
public class TestLamda {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{for(int i = 1;i<=60;i++) ticket.sale(); },"A").start();
        new Thread(()->{for(int i = 1;i<=60;i++) ticket.sale(); },"B").start();
        new Thread(()->{for(int i = 1;i<=60;i++) ticket.sale(); },"C").start();
    }
}

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