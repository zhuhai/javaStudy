package com.zhuhai.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Map;
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
    public Boolean del(String key) {
        return redisCacheTemplate.delete(key);
    }

    /**
     * 删除一组key
     * @param keys
     * @return
     */
    public Long del(Set<String> keys) {
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


    /**
     * 实现命令 hset key field value
     * @param key
     * @param filed
     * @param value
     */
    public void hset(String key, String filed, Serializable value) {
        redisCacheTemplate.opsForHash().put(key, filed, value);
    }

    /**
     * 实现命令 hget key field
     * @param key
     * @param filed
     * @param <T>
     * @return
     */
    public <T> T hget(String key, String filed) {
        return (T) redisCacheTemplate.opsForHash().get(key, filed);
    }

    /**
     * 实现命令 hdel key field[field...]
     * @param key
     * @param fields
     */
    public void hdel(String key, String...fields) {
        redisCacheTemplate.opsForHash().delete(key, fields);
    }

    /**
     * 实现命令 hgetAll key
     * @param key
     * @return
     */
    public Map<Object, Object> hgetAll(String key) {
        return redisCacheTemplate.opsForHash().entries(key);
    }

    /**
     * 实现命令 HEXISTS key field
     * @param key
     * @param field
     * @return
     */
    public Boolean hexists(String key, String field) {
        return redisCacheTemplate.opsForHash().hasKey(key, field);
    }


    /**
     * 实现命令 LPUSH key value 将value插入到列表key的表头
     * @param key
     * @param value
     * @return 列表的长度
     */
    public Long lpush(String key, Serializable value) {
        return redisCacheTemplate.opsForList().leftPush(key, value);
    }


    /**
     * 实现命令 LPOP key 移除并返回列表的头元素
     * @param key
     * @return
     */
    public <T> T lpop(String key) {
        return (T) redisCacheTemplate.opsForList().leftPop(key);
    }

    /**
     * 实现命令RPUSH key value 将value插入到列表key的表尾
     * @param key
     * @param value
     * @return 列表的长度
     */
    public Long rpush(String key, Serializable value) {
        return redisCacheTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 实现命令 RPOP key 移除并返回列表的尾元素
     * @param key
     * @param <T>
     * @return
     */
    public <T> T rpop(String key) {
        return (T) redisCacheTemplate.opsForList().rightPop(key);
    }

    /**
     * 实现命令 SADD key value[value...] 将一个或多个元素添加到集合key中
     * @param key
     * @param values
     * @return
     */
    public Long sadd(String key, Serializable...values) {
        return redisCacheTemplate.opsForSet().add(key, values);
    }

    /**
     * 实现命令 SMEMBERS KEY 返回集合key中的所有元素
     * @param key
     * @param <T>
     * @return
     */
    public <T> Set<T> smembers(String key) {
        return (Set<T>) redisCacheTemplate.opsForSet().members(key);
    }

    /**
     * 实现命令 SREM KEY value[value...]
     * @param key
     * @param values
     * @return
     */
    public Long srem(String key, Serializable...values) {
        return redisCacheTemplate.opsForSet().remove(key, values);
    }

    /**
     * 实现命令 SCARD key 返回集合key的元素数量
     * @param key
     * @return
     */
    public Long scard(String key) {
        return redisCacheTemplate.opsForSet().size(key);
    }


    public Boolean zadd(String key, Serializable value, double score) {
        return redisCacheTemplate.opsForZSet().add(key, value, score);
    }


}
