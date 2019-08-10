package com.zgy.rpc.registry.zookeeper;

import com.zgy.rpc.common.LifeCycle;

import java.net.URL;
import java.util.List;

/**
 * Created by Rayee on 2019/8/10.
 */
public interface ZookeeperClient extends LifeCycle {

    void create(String path, boolean persistent);

    void delete(String path);

    List<String> getChildren(String path);

    URL getUrl();

    boolean isConnected();

}
