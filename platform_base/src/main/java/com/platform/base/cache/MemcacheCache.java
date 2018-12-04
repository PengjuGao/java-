package com.platform.base.cache;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.spy.memcached.MemcachedClient;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.util.Assert;



public class MemcacheCache implements Cache  {

    private MemcachedClient client;

    private String name;

    public static final int DEFAULT_CACHETIME = 60 * 60 * 24 * 10;//默认缓存10天

    public static final int TEST_CACHETIME = 60 * 60 / 2;//测试缓存30分钟

    public MemcacheCache() {}

    public MemcacheCache(MemcachedClient client, String name) {
        Assert.notNull(client, "Memcache client must not be null");
        this.client = client;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.client;
    }

    @Override
    public ValueWrapper get(Object key) {
        Object value = null;
        try{ value = this.client.get(getCacheKey(key));}
        catch (Exception e){e.printStackTrace();}
        return (value != null ? new SimpleValueWrapper(value) : null);
    }

    @Override
    public void put(Object key, Object value) {
        if (value != null) {
            this.client.set(getCacheKey(key), getCacheTime(key), value);
        }
    }

    public void put(Object key,Object value,int exp) {
        if (value != null) {
            this.client.set(getCacheKey(key),exp, value);
        }
    }

    @Override
    public void evict(Object key) {
        this.client.delete(getCacheKey(key));
    }

    @Override
    public void clear() {
        this.client.flush();
    }

    private String toString(Object object) {
        if (object == null) {
            return null;
        } else if (object instanceof String) {
            return (String) object;
        } else {
            return object.toString();
        }
    }

    @SuppressWarnings("unchecked")
	private String getCacheKey(Object key) {
        String strKey = toString(key).toUpperCase();
        Matcher matcher = Pattern.compile("_T_\\d+$").matcher(strKey);
        if (matcher.find()) strKey = strKey.replaceFirst("_T_\\d+$", "");
        String reg = "\\[(.*?)]";
        matcher = Pattern.compile(reg).matcher(strKey);

        Boolean isList = Boolean.FALSE;
        StringBuilder resultBuilder = new StringBuilder();
        while (matcher.find()) {
            isList = Boolean.TRUE;
            for (int i = 0; i < matcher.groupCount(); i++) {
                //[1,2,3,4]去掉[和] 结果为1,2,3,4
                String value = matcher.group(i).replaceAll("\\[|]|\\s", "");
                String values[] = value.split(",");
                //是否全为数字
                Boolean isNumber = Pattern.compile("^[0-9]").matcher(value.replaceAll(",", "")).find();
                //全为数字
                @SuppressWarnings("rawtypes")
				Set set;
                if (isNumber) {
                    set = new TreeSet<Long>(new Comparator<Long>() {
                        @Override
                        public int compare(Long o1, Long o2) {
                            return (o1.equals(o2)?0:(o1>o2?-1:1));
                        }
                    });
                    for (String val : values) set.add(Long.valueOf(val));
                } else {//字符串
                    set = new TreeSet<String>(new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return o1.compareTo(o2);
                        }
                    });
                    Collections.addAll(set, values);
                }
                resultBuilder.append(set.toString().replaceAll("\\s", "")).append("_");
            }
        }
        if (isList) {
            String result = resultBuilder.substring(0, resultBuilder.length() - 1);
            strKey = strKey.replaceAll(reg, "") + "_" + result.hashCode();
        }
        return strKey;
    }

    private Integer getCacheTime(Object key) {
        String strKey = toString(key);
        Matcher matcher = Pattern.compile("_T_\\d+$").matcher(strKey);
        if (matcher.find())
            return Integer.valueOf(matcher.group(0).replace("_T_", ""));
        return DEFAULT_CACHETIME;
    }

    public void setClient(MemcachedClient client) {
        this.client = client;
    }

    public MemcachedClient getClient() {
        return client;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCacheValue(String cacheKey) {
        ValueWrapper valueWrapper = this.get(cacheKey);
        return valueWrapper==null?null:valueWrapper.get();
    }

    @SuppressWarnings("unchecked")
	public <T>T getCacheValue(String cacheKey,Class<T> clazz) {
        ValueWrapper valueWrapper = this.get(cacheKey);
        return valueWrapper==null?null:(T)valueWrapper.get();
    }
}