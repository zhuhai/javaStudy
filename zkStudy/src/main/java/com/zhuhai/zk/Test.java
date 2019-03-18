package com.zhuhai.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.utils.CloseableUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/12/16
 * Time: 21:44
 *
 * @author: hai
 */
public class Test {

    public static void main(String[] args) {
        String connectionString = "127.0.0.1:2181";
        RetryPolicy retryPolicy = new RetryNTimes(3, 2000);
        CuratorFramework client = CuratorFrameworkFactory.newClient(connectionString, retryPolicy);
        client.start();
        System.out.println(client.getState().name());
        try {
            List<String> paths = client.getChildren().forPath("/");
            for (String path : paths) {
                System.out.println(path);
            }
            //client.create().withMode(CreateMode.PERSISTENT).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath("/lock");
            /*final NodeCache nodeCache = new NodeCache(client, "/lock");
            nodeCache.getListenable().addListener(new NodeCacheListener() {
                @Override
                public void nodeChanged() throws Exception {
                    ChildData currentData = nodeCache.getCurrentData();
                    System.out.println("ZNode节点发生变化，path=" + currentData.getPath());
                    System.out.println("ZNode节点发生变化，data=" + currentData.getData().toString());
                    System.out.println("ZNode节点发生变化，stat=" + currentData.getStat());
                }
            });
            nodeCache.start();*/

            final PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/lock", true);
            pathChildrenCache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
            List<ChildData> currentDataList = pathChildrenCache.getCurrentData();
            for (ChildData childData : currentDataList) {
                System.out.println("节点：" + childData.getPath() + "数据为：" + new String(childData.getData()));
            }

            pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
                @Override
                public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                    if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_ADDED)) {
                        System.out.println("增加子节点" + event.getData().getPath() + "，节点数据是：" + new String(event.getData().getData()));
                    } else if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)) {
                        System.out.println("删除子节点" + event.getData().getPath() + "，节点数据是：" + new String(event.getData().getData()));
                    } else if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)) {
                        System.out.println("修改子节点" + event.getData().getPath() + "，节点数据是：" + new String(event.getData().getData()));
                    }
                }
            });

            Thread.sleep(600000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }



    }


}
