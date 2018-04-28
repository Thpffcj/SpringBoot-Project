package cn.edu.nju.curator;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nju.utils.AclUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooDefs.Perms;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

/**
 * Created by Thpffcj on 2018/4/27.
 */
public class CuratorAcl {

    public CuratorFramework client = null;
    public static final String zkServerPath = "192.168.92.130:2181";

    public CuratorAcl() {
        RetryPolicy retryPolicy = new RetryNTimes(3, 5000);
        client = CuratorFrameworkFactory.builder().authorization("digest", "thpffcj:123456".getBytes())
                .connectString(zkServerPath)
                .sessionTimeoutMs(10000).retryPolicy(retryPolicy)
                .namespace("workspace").build();
        client.start();
    }

    public void closeZKClient() {
        if (client != null) {
            this.client.close();
        }
    }

    public static void main(String[] args) throws Exception {
        // 实例化
        CuratorAcl cto = new CuratorAcl();
        boolean isZkCuratorStarted = cto.client.isStarted();
        System.out.println("当前客户的状态：" + (isZkCuratorStarted ? "连接中" : "已关闭"));

        String nodePath = "/acl/father/child/sub";

        List<ACL> acls = new ArrayList<ACL>();
        Id thpffcj1 = new Id("digest", AclUtils.getDigestUserPwd("thpffcj1:123456"));
        Id thpffcj2 = new Id("digest", AclUtils.getDigestUserPwd("thpffcj2:123456"));
        acls.add(new ACL(Perms.ALL, thpffcj1));
        acls.add(new ACL(Perms.READ, thpffcj2));
        acls.add(new ACL(Perms.DELETE | Perms.CREATE, thpffcj2));

        // 创建节点
//		byte[] data = "spiderman".getBytes();
//		cto.client.create().creatingParentsIfNeeded()
//				.withMode(CreateMode.PERSISTENT)
//				.withACL(acls, true)
//				.forPath(nodePath, data);


        cto.client.setACL().withACL(acls).forPath("/curatorNode");

        // 更新节点数据
//		byte[] newData = "batman".getBytes();
//		cto.client.setData().withVersion(0).forPath(nodePath, newData);

        // 删除节点
//		cto.client.delete().guaranteed().deletingChildrenIfNeeded().withVersion(0).forPath(nodePath);

        // 读取节点数据
//		Stat stat = new Stat();
//		byte[] data = cto.client.getData().storingStatIn(stat).forPath(nodePath);
//		System.out.println("节点" + nodePath + "的数据为: " + new String(data));
//		System.out.println("该节点的版本号为: " + stat.getVersion());


        cto.closeZKClient();
        boolean isZkCuratorStarted2 = cto.client.isStarted();
        System.out.println("当前客户的状态：" + (isZkCuratorStarted2 ? "连接中" : "已关闭"));
    }
}
