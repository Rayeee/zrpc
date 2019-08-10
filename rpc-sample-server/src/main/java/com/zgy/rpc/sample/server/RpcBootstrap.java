package com.zgy.rpc.sample.server;

import com.zgy.rpc.common.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RpcBootstrap {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcBootstrap.class);

    public static void main(String[] args) {
        LOGGER.debug("start server");
        try {
            new ClassPathXmlApplicationContext("spring.xml");
        }catch (Exception e){
            System.out.println(JsonUtils.toJson(e));
        }

    }
}
