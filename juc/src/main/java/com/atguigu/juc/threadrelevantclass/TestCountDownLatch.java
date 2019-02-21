package com.atguigu.juc.threadrelevantclass;


import lombok.Getter;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public static void main(String[] args) throws Exception {
        CountDownLatch ountDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            //final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t国被灭");
                ountDownLatch.countDown();
            },WarringStates.foreach_Enum(i).getRetMessage()).start();
        }
        ountDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"**********一统华夏");
    }
}

