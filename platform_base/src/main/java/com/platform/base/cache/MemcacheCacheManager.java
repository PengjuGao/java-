package com.platform.base.cache;
import java.util.Collection;

import net.spy.memcached.MemcachedClient;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

public class MemcacheCacheManager extends AbstractCacheManager {

    private Collection<Cache> caches;

    private MemcachedClient client;

    public MemcacheCacheManager() {
    }

    public MemcacheCacheManager(MemcachedClient client) {
        setClient(client);
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches;
    }

    public Cache getCache(String name) {
        if (client == null) {
            throw new IllegalStateException("MemcacheClient must not be null.");
        }
        Cache cache = super.getCache(name);
        if (cache == null) {
            cache = new MemcacheCache(client, name);
            addCache(cache);
        }
        return cache;
    }

    @SuppressWarnings("unused")
	private void updateCaches() {
        if (caches != null) {
            for (Cache cache : caches) {
                if (cache instanceof MemcacheCache) {
                    MemcacheCache memcacheCache = (MemcacheCache) cache;
                    memcacheCache.setClient(client);
                }
            }
        }
    }

    public Collection<Cache> getCaches() {
        return caches;
    }

    public void setCaches(Collection<Cache> caches) {
        this.caches = caches;
    }

    public MemcachedClient getClient() {
        return client;
    }

    public void setClient(MemcachedClient client) {
        this.client = client;
    }


}