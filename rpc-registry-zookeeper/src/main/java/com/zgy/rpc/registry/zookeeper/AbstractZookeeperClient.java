package com.zgy.rpc.registry.zookeeper;

import java.net.URL;

/**
 * Created by Rayee on 2019/8/10.
 */
public abstract class AbstractZookeeperClient implements ZookeeperClient {

    private volatile boolean closed = false;

    private URL url;

    public AbstractZookeeperClient(URL url) {
        this.url = url;
    }

    @Override
    public void create(String path, boolean persistent) {
        int i = path.lastIndexOf("/");
        if (i > 0) {
            create(path.substring(0, i), true);
        }
        if (persistent) {
            createPersistent(path);
        } else {
            createEphemeral(path);
        }
    }

    @Override
    public URL getUrl() {
        return url;
    }

    @Override
    public void close() {
        if (closed) {
            return;
        }
        closed = true;
        try {
            doClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test(String path) {
        int i = path.lastIndexOf("/");
        if (i > 0) {
            test(path.substring(0, i));
        }
        System.out.println(path);
    }

    protected abstract void doClose();

    protected abstract void createPersistent(String path);

    protected abstract void createEphemeral(String path);

    public static void main(String[] args) {
        test("/a/b/c/d");
    }
}
