package com.platform.client.service;

import com.platform.base.cache.MemcacheCache;
import com.platform.base.cache.MemcacheCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/23.
 */
@Service
public class CacheService {

    @Autowired
    MemcacheCacheManager memcacheCacheManager;
    public  String getHello(){

        memcacheCacheManager.getCache("most").put("key","123456");
        System.out.println("------------first time invoker------");
        return "999999";
    }
    public  String getCache(){

      String value = (String) ((MemcacheCache) memcacheCacheManager.getCache("most")).getCacheValue("key");
        System.out.println("------------second time invoker------");
        return "111111";
    }
}
