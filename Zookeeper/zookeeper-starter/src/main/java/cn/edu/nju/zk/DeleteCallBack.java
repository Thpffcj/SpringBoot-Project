package cn.edu.nju.zk;

import org.apache.zookeeper.AsyncCallback;

/**
 * Created by Thpffcj on 2018/4/24.
 */
public class DeleteCallBack implements AsyncCallback.VoidCallback {

    @Override
    public void processResult(int rc, String path, Object ctx) {
        System.out.println("删除节点" + path);
        System.out.println((String)ctx);
    }
}
