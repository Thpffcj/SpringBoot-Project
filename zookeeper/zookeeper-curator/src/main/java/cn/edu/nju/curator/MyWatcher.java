package cn.edu.nju.curator;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by Thpffcj on 2018/4/27.
 */
public class MyWatcher implements Watcher {

    @Override
    public void process(WatchedEvent event) {
        System.out.println("触发watcher，节点路径为：" + event.getPath());
    }
}
