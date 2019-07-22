package util;

import org.apache.zookeeper.*;

/**
 * Created by pfliu on 2019/07/21.
 */
public class ZooKeeperUtil {
    public static void main(String[] args) throws Exception {
        // 初始化
        // 监控所有被触发的事件
        ZooKeeper zk = new ZooKeeper("localhost:" + 2181,
                2000, event -> System.out.println("触发了" + event.getType() + "事件！"));

        // 创建节点
        zk.create("/code", "codeData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/code/son", "codeSonData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        // 获取数据
        System.out.println(new java.lang.String(zk.getData("/code", false, null)));
        System.out.println(new java.lang.String(zk.getData("/code/son", false, null)));

        // 修改节点
        zk.setData("/code", "codeDateAfterUpdate".getBytes(), -1);

        // 判断节点是否存在
        System.out.println(zk.exists("/code/son", false));
        System.out.println(zk.exists("/code/son/noexist", false));

        //删除节点
        try {
            zk.delete("/code", -1);
        } catch (KeeperException e) {
            if (e instanceof KeeperException.NodeExistsException) {
                System.out.println("there is son data in this node.");
            }
        }
        zk.delete("/code/son", -1);
    }
}
