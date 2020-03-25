package com.example.zookeeper;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.util.StringUtils;

import java.io.IOException;

// TODO: 2019/11/28 zookeeper官方demo

public class OriginalZookeeperDemo {

    private static int time = 30 * 1000;

    public static void main(String[] args) throws Exception {

        Watcher watch_even_has_already = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("watch even has already");
                System.out.println("地址为" + watchedEvent.getPath());
                System.out.println(watchedEvent.getType().getIntValue());
            }
        };
        ZooKeeper zooKeeper = new ZooKeeper(
                "192.168.20.179:2181,192.168.20.179:2182,192.168.20.179:2183", time, watch_even_has_already);
        while (true) {
            if (zooKeeper.getState().equals(ZooKeeper.States.CONNECTED)) {
                //成功連接
                break;
            }

        }
        //String s = zooKeeper.create("/yangxiao", "mydata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        byte[] data = zooKeeper.getData("/yangxiao", watch_even_has_already, null);
        String s = String.valueOf(data);
        System.out.println("得到:" + s);
        Stat stat = zooKeeper.setData("/yangxiao", "chuzhenbo".getBytes(), 1);
        System.out.println(stat.toString());

    }

}
