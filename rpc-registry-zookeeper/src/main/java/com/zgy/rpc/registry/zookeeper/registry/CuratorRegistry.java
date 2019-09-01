package com.zgy.rpc.registry.zookeeper.registry;

import com.zgy.rpc.registry.ServiceRegistry;
import com.zgy.rpc.registry.zookeeper.client.ZookeeperClient;
import com.zgy.rpc.registry.zookeeper.client.curator.CuratorZookeeperClient;

/**
 * Created by Rayee on 2019/8/10.
 */
public class CuratorRegistry implements ServiceRegistry {

    private ZookeeperClient client;

    public CuratorRegistry(String address) {
        client = new CuratorZookeeperClient(address);
    }

    @Override
    public void register(String serviceName) {
        client.create(serviceName, true);
    }

    @Override
    public void register(String serviceName, String serviceAddress) {
        //do nothing
    }
}
