package com.pp.common.utils.redis;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/******************************

 * 功　　能：Redis工具类
 *****************************************/
@Component
public class RedisUtils {
    @SuppressWarnings("rawtypes")
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 判断redis缓冲中是否存在这个key
     *
     * @param key 指定的key
     * @return 有这个key返回true 没有返回false
     */
    public Boolean containKey(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        Object result = null;
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        if (result == null) {
            return null;
        }
        return result.toString();
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        result = true;

        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        result = true;
        return result;
    }

    public boolean hmset(String key, Map<String, String> value) {
        boolean result = false;
        redisTemplate.opsForHash().putAll(key, value);
        result = true;
        return result;
    }

    public Map<String, String> hmget(String key) {
        Map<String, String> result = null;
        result = redisTemplate.opsForHash().entries(key);
        return result;
    }

    public String hmget(String key, String key2) {
        Object result = null;
        result = redisTemplate.opsForHash().get(key, key2);
        if (result == null) {
            return null;
        }
        return result.toString();
    }

    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<String, String> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void pushMsg(String name, String msg) {
        redisTemplate.opsForList().leftPush(name, msg);
    }

    public String popMsg(String name) {
        return (String) redisTemplate.opsForList().rightPop(name);
    }

    public List<Object> achieveListMsg(String name) {
        List<Object> msgs = redisTemplate.opsForList().range(name, 0, redisTemplate.opsForList().size(name));
        return msgs;
    }
}
