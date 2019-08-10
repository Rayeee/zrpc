package com.zgy.rpc;

import com.zgy.rpc.common.util.JsonUtils;
import com.zgy.rpc.registry.zookeeper.Constant;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * Created by Rayee on 2019/8/10.
 */
public class RegisterTest {

    private static final ZkClient zkClient = new ZkClient("127.0.0.1:2181", Constant.ZK_SESSION_TIMEOUT, Constant.ZK_CONNECTION_TIMEOUT);

    public static void main(String[] args) {
        String rootPath = "/rpc";
        if (!zkClient.exists(rootPath)) {
            zkClient.createPersistent(rootPath);
        }
        String servicePath = rootPath.concat("/").concat("myService");
        if (!zkClient.exists(servicePath)) {
            zkClient.createPersistent(servicePath);
        }
        String nodeAddress = servicePath.concat("/").concat("127.0.0.1:8000");
        zkClient.createEphemeralSequential(nodeAddress, "127.0.0.1:2181");
        System.out.println("success");
        List<String> childrens = zkClient.getChildren("/rpc");
        JsonUtils.toJson(childrens);
    }

}
