package com.ylf.demo.kafka.zookeeper;

import org.apache.zookeeper.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author: leifeng.ye
 * @date: 2020-03-27
 * @desc:
 */
public class ZkClient {
    final static String zkAddress="120.27.246.207:2181";
    final static int sessionTimeOut=20000;
    private static ZooKeeper zooKeeper;

    static {
        try {
            zooKeeper=new ZooKeeper(zkAddress, sessionTimeOut, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void testCreate() throws KeeperException, InterruptedException {
//        String s = zooKeeper.create("/ylf", "叶磊峰".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(s);
//    }

    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        watch();
        Thread.currentThread().join();
    }
      public static void watch() throws KeeperException, InterruptedException, IOException {
            ZooKeeper zk=new ZooKeeper(zkAddress, sessionTimeOut, new Watcher() {
                 @Override
                 public void process(WatchedEvent watchedEvent) {

                 }
             });
          zk.getData("/ylf", new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(watchedEvent.toString());
                    try {
                        watch();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            },null);
        }

}
