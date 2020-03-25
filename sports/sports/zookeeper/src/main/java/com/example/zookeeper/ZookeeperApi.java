package com.example.zookeeper;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.proto.WatcherEvent;

public class ZookeeperApi extends WatcherEvent implements Watcher {
    private static int time = 30 * 1000;

    public void main() throws Exception {

     //   ZooKeeper zooKeeper0 = new ZooKeeper(
         //       "192.168.20.179:2181,192.168.20.179:2182,192.168.20.179:2183", time, this);
        ZooKeeper zooKeeper = new ZooKeeper(
                "192.168.20.179:2181,192.168.20.179:2182,192.168.20.179:2183", time, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
        String s = zooKeeper.create("/vn", "penta kill".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("the return of creative :" + s);
        String s1 = new String(zooKeeper.getData("/vn", this, new Stat()));
        System.out.println("acquire data is :"+s1);

    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("route: " + watchedEvent.getPath());
        System.out.println("state: " + watchedEvent.getState().name());
        System.out.println("type: " + watchedEvent.getType().getIntValue());
    }

    public static void main(String[] args) throws Exception {
        ZookeeperApi api = new ZookeeperApi();
        api.main();
    }
}
