package com.pp.redis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @program: tp-workflow
 * @Description:
 * @Author: Shen.Sun
 * @create: 2020-04-26 16:10
 **/
public class RedisLock {

    private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);

    private StringRedisTemplate redisStringTemplate;

    private volatile boolean isLocked = false;

    /**
     * 锁标志对应的key
     */
    private String key;

    /**
     * 默认超时时间 ms
     **/
    private long timeOut;

    public RedisLock(StringRedisTemplate redisStringTemplate, String key, long timeOut) {
        this.redisStringTemplate = redisStringTemplate;
        this.key = key;
        this.timeOut = timeOut;
    }

    /**
     * 是否存在锁
     * <p>
     * 锁标志对应的key
     *
     * @return
     */
    public boolean isLock() {
        return redisStringTemplate.hasKey(this.key);
    }

    /**
     * 保护处理
     */
    private void protection() {
        //当获取锁失败时,判断该key值存在并且没有设置过期时间
        if (redisStringTemplate.getExpire(this.key) == -1) {
            String currentValueStr = redisStringTemplate.opsForValue().get(this.key); //redis里的时间
            //依照该key值存入的时间和当前时间进行对比,如果过期了,那么就删除这个key,否则重新设置超时时间
            if (currentValueStr != null && Long.parseLong(currentValueStr) < System
                    .currentTimeMillis()) {
                redisStringTemplate.delete(this.key);
            } else {
                redisStringTemplate.expire(this.key, timeOut, TimeUnit.MILLISECONDS);
            }
        }
    }

    /**
     * 尝试获取锁-业务互斥锁（同一时刻只有一个业务在处理）
     * <p>
     * key     请求锁key
     * <p>
     * timeout 请求锁的超时时间(ms)
     * <p>
     * value   存储到redis中的锁标志
     *
     * @return
     */
    public boolean tryMutexLock() {
        //获取当前系统时间,毫微秒
        long nowTime = System.currentTimeMillis();
        //请求锁超时时间，毫秒
        String expireStr = String.valueOf(nowTime + timeOut);
        try {
            //将锁作为key存储到redis缓存中，存储成功则获得锁
            if (redisStringTemplate.opsForValue().setIfAbsent(this.key, expireStr)) {
                redisStringTemplate.expire(this.key, timeOut, TimeUnit.MILLISECONDS);
                isLocked = true;
                logger.debug("加锁成功[key,value]=[" + key + "," + expireStr + "]");
                //上锁成功结束请求
                return true;
            }
            // 获取锁失败,判断key没有设置超时时间，为key设置一个超时时间,防止程序在执行expire命令失败产生死锁
            protection();
        } catch (Exception e) {
            protection();
            logger.error("redis加锁异常,[key=" + key + "],[value=" + expireStr + "]" + e);
        }
        return false;
    }

    public void unlock() {
        //释放锁
        if (isLocked) {
            redisStringTemplate.delete(this.key);
            logger.debug("解锁锁成功[key]=[" + key + "]");
        }
    }
}
