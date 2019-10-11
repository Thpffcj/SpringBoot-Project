package cn.edu.nju.curator;

import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.WatchedEvent;

/**
 * Created by Thpffcj on 2018/4/27.
 */
public class MyCuratorWatcher implements CuratorWatcher {

    @Override
    public void process(WatchedEvent event) throws Exception {
        System.out.println("触发watcher，节点路径为：" + event.getPath());
    }
}
