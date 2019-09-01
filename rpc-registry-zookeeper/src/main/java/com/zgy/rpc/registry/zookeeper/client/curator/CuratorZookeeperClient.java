package com.zgy.rpc.registry.zookeeper.client.curator;

import com.zgy.rpc.registry.zookeeper.client.AbstractZookeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;

import java.net.URL;
import java.util.List;

/**
 * Created by Rayee on 2019/8/10.
 */
public class CuratorZookeeperClient extends AbstractZookeeperClient {

    private CuratorFramework client;

    public CuratorZookeeperClient(String url) {
        super(url);
        client = CuratorFrameworkFactory.builder()
                .connectString(url)
                .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))
                .connectionTimeoutMs(5000)
                .sessionTimeoutMs(60000).build();
//        client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
//            @Override
//            public void stateChanged(CuratorFramework curatorFramework, ConnectionState state) {
//                if (state == ConnectionState.CONNECTED) {
//
//                }
//            }
//        });
    }

    @Override
    protected void createPersistent(String path) {
        try {
            client.create().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void createEphemeral(String path) {
        try {
            client.create().withMode(CreateMode.EPHEMERAL).forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String path) {
        try {
            client.delete().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getChildren(String path) {
        try {
            return client.getChildren().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isConnected() {
        return client.getZookeeperClient().isConnected();
    }

    @Override
    protected void doClose() {
        client.close();
    }


}
