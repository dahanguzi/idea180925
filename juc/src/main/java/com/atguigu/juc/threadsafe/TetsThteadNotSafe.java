package com.atguigu.juc.threadsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

//写时复制CopyOnWriteArratList
/*
    1、高并发时，使用ArrayList会产生什么异常？java.util.ConcurrentModificationException java并发修改异常
    2、为什么会产生此种异常？ArrayList是线程不安全的
    3、如何解决？换用另外一种ArrayList:CopyOnWriteArrayList
    4、与此相似的集合形式还有哪些？HashSet、HashMap
*/
public class TetsThteadNotSafe {
    public static void main(String[] args) {
        List list = new CopyOnWriteArrayList();
        for(int i = 1;i<=30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
