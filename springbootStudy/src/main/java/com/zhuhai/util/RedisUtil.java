package com.zhuhai.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/26
 * Time: 22:04
 *
 * @author: hai
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Serializable> redisCacheTemplate;


    /**
     * 实现命令ttl,返回指定key的剩余生存时间，单位秒
     * @param key
     * @return
     */
    public Long ttl(String key) {
        return redisCacheTemplate.getExpire(key);
    }

    /**
     * 实现命令ttl,返回指定key的剩余生存时间，单位由调用者指定
     * @param key
     * @param timeUnit
     * @return
     */
    public Long ttl(String key, TimeUnit timeUnit) {
        return redisCacheTemplate.getExpire(key, timeUnit);
    }

    /**
     * 实现命令expire，给指定的key设置生存时间，单位秒
     * @param key
     * @param timeout
     */
    public void expire(String key, long timeout) {
        redisCacheTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 实现命令incr 给指定的key每次增加1
     * @param key
     * @return
     */
    public Long incr(String key) {
        return redisCacheTemplate.opsForValue().increment(key);
    }

    /**
     * 实现命令incrBy 给指定的key增加指定的值
     * @param key
     * @param delta
     * @return
     */
    public Long incrBy(String key, long delta) {
        return redisCacheTemplate.opsForValue().increment(key, delta);
    }

    public Double incrBy(String key, double delta) {
        return redisCacheTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 实现命令keys
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern) {
        return redisCacheTemplate.keys(pattern);
    }

    /**
     * 实现命令del，删除指定的key
     * @param key
     * @return
     */
    public boolean del(String key) {
        return redisCacheTemplate.delete(key);
    }

    /**
     * 删除一组key
     * @param keys
     * @return
     */
    public long del(Set<String> keys) {
        return redisCacheTemplate.delete(keys);
    }

    /**
     * 实现命令set
     * @param key
     * @param value
     */
    public <T> void set(String key, Serializable value) {
        redisCacheTemplate.opsForValue().set(key, value);
    }

    /**
     * 实现命令set 设置值的同时设置生存时间，单位秒
     * @param key
     * @param value
     * @param timeout
     */
    public void set(String key, Serializable value, long timeout) {
        redisCacheTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }


    /**
     * 实现命令key 获取key的值
     * @param key
     * @return
     */
    public <T> T get(String key) {
        return (T) redisCacheTemplate.opsForValue().get(key);
    }

}
