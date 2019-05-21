package cn.edu.nju.zk;

import org.apache.zookeeper.AsyncCallback;

import java.util.List;

/**
 * Created by Thpffcj on 2018/4/24.
 */
public class ChildrenCallBack implements AsyncCallback.ChildrenCallback {

    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children) {
        for (String s : children) {
            System.out.println(s);
        }
        System.out.println("ChildrenCallback:" + path);
        System.out.println((String) ctx);
    }
}
