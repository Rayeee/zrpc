package com.zgy.rpc.registry.zookeeper;

/**
 * Created by Rayee on 2019/8/10.
 */
public interface StateListener {

    int DISCONNECTED = 0;

    int CONNECTED = 1;

    int RECONNECTED = 2;

}
