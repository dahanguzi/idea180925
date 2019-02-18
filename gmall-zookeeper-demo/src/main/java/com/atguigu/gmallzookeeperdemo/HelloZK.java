package com.atguigu.gmallzookeeperdemo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class HelloZK {

    private static final String CONNECTSTRING = "192.168.136.128:2181";
    private static final String PATH = "/atguigu";
    private static final Integer SESSION_TIMEOUT = 20 * 1000;

    /*
        新建zookeeper连接
     */
    public ZooKeeper startZK() throws IOException {
        ZooKeeper zk = new ZooKeeper(CONNECTSTRING, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
        return zk;
    }

    /*
        关闭zookeeper连接
     */
    public void stopZK(ZooKeeper zk) throws InterruptedException {
        if(zk!=null){
            zk.close();
        }

    }

    /*
         创建节点znodes
     */
    public void createNode(ZooKeeper zk,String path,String data) throws KeeperException, InterruptedException {
        zk.create(path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /*
        获取节点
     */
    public String getNode(ZooKeeper zk,String path) throws KeeperException, InterruptedException {

        String result = "";
        byte[] data = zk.getData(path, false, new Stat());
        result = new String(data);
        return result;
    }


    public static void main(String args[]) throws Exception {

        HelloZK helloZK = new HelloZK();
        ZooKeeper zk = helloZK.startZK();
        if(zk.exists(PATH,false) == null){
            helloZK.createNode(zk,PATH,"java0925");
            String node = helloZK.getNode(zk, PATH);
            System.out.print("node="+node);
        }else{
            System.out.print("this node is created!!!");
        }

        helloZK.stopZK(zk);
    }
}
