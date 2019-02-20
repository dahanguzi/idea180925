package com.atguigu.juc.threadrelevantclass;
/*
    获取线程的第三种方式
    实现Callable接口
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class TestCallable {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new MyThread());

        new Thread(futureTask,"A").start();
        try {
            System.out.println(Thread.currentThread().getName()+"\t"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("***************come in call()");
        return 123;
    }
}