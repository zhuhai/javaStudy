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
    public void hdel(String key, Object...fields) {
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
    public Long sadd(String key, Object...values) {
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
    public Long srem(String key, Object...values) {
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


    /**
     * 实现命令ZADD KEY SCORE MEMBER 将元素member及其score加入到有序集合key中
     * @param key
     * @param value
     * @param score
     * @return
     */
    public Boolean zadd(String key, Serializable value, double score) {
        return redisCacheTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 实现命令ZSCORE KEY MEMBER 返回有序集合key中元素member的score值
     * @param key
     * @param value
     * @return
     */
    public Double zscore(String key, Serializable value) {
        return redisCacheTemplate.opsForZSet().score(key, value);
    }

    /**
     * 实现命令ZCARD KEY 返回有序集合key中的元素数量
     * @param key
     * @return
     */
    public Long zcard(String key) {
        return redisCacheTemplate.opsForZSet().zCard(key);
    }

    /**
     * 实现命令ZCOUNT KEY min max 返回有序集合key中元素score在min和max之间（包含min和max）的数量
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zcount(String key, double min, double max) {
        return redisCacheTemplate.opsForZSet().count(key, min, max);
    }

    /**
     * 实现命令ZRANGE KEY start end 返回有序集合key中指定区间的元素，成员位置按照score值递增排序
     * @param key
     * @param start
     * @param end
     * @param <T>
     * @return
     */
    public <T> Set<T> zrange(String key, long start, long end) {
        return (Set<T>) redisCacheTemplate.opsForZSet().range(key, start, end);
    }

    /**
     * 实现命令ZREVRANGE KEY start end 返回有序集合key中指定区间的元素，成员位置按照score值递减排序
     * @param key
     * @param start
     * @param end
     * @param <T>
     * @return
     */
    public <T> Set<T> zrevRange(String key, long start, long end) {
        return (Set<T>) redisCacheTemplate.opsForZSet().reverseRange(key, start, end);
    }

    /**
     * 实现命令ZRANGEBYSCORE key min max 返回有序集key中，所有score值介于min和max之间(包括min,max)的成员。有序集成员按score值递增排列。
     * @param key
     * @param min
     * @param max
     * @param <T>
     * @return
     */
    public <T> Set<T> zrangeByScore(String key, double min, double max) {
        return (Set<T>) redisCacheTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * 实现命令ZRANK key member 返回有序集合key中元素member的排名，排名按scroe值递增排序，排名从0开始
     * @param key
     * @param member
     * @return
     */
    public Long zrank(String key, Serializable member) {
        return redisCacheTemplate.opsForZSet().rank(key, member);

    }


    /**
     * 实现命令ZREVRANK key member 返回有序集合key中元素member的排名，排名按scroe值递减排序，排名从0开始
     * @param key
     * @param member
     * @return
     */
    public Long zrevRank(String key, Serializable member) {
        return redisCacheTemplate.opsForZSet().reverseRank(key, member);

    }

    /**
     * 实现命令ZREM key member[member...] 删除有序集合key中指定的元素member
     * @param key
     * @param members
     * @return
     */
    public Long zrem(String key, Object...members) {
        return redisCacheTemplate.opsForZSet().remove(key, members);
    }


    /**
     * 实现命令ZREMRANGEBYRANK key start end 移除有序集key中，指定排名(rank)区间内的所有成员。
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Long zremRangeByRank(String key, long start, long end) {
        return redisCacheTemplate.opsForZSet().removeRange(key, start, end);
    }


    /**
     * 实现命令ZREMRANGEBYSCORE key min max 移除有序集合key中，所有score值介于min和max之间（包含min和max）的元素
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zremRangeByScore(String key, double min, double max) {
        return redisCacheTemplate.opsForZSet().removeRangeByScore(key, min, max);
    }
}
