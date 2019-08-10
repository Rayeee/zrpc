package com.zgy.rpc.common.util;

import com.google.gson.Gson;

/**
 * Created by Rayee on 2018/1/23.
 */
public class JsonUtils {

    private static final Gson gson = new Gson();

    public static <E> String toJson(E e){
        return gson.toJson(e);
    }

    public static <E> E fromJson(String str, Class<E> clazz){
        return gson.fromJson(str, clazz);
    }

}
