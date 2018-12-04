package com.platform.client.c3p0;

import java.util.Map;

/**
 * Created by kris on 2017/7/9.
 */
public class MapHolder {

    private final static ThreadLocal<Map<String,Object>> mapThreadLocal = new ThreadLocal<>();

    public static void saveMap(Map<String,Object> map){
        mapThreadLocal.set(map);
    }

    public static Map<String,Object> getMap() {
       return mapThreadLocal.get();
    }

    public void clearMap(){
        mapThreadLocal.remove();
    }
}
