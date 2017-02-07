package com.wyx.service.redis;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/2
 * Time: 下午6:17
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RedisClientService {

    private static final Logger log = LoggerFactory.getLogger(RedisClientService.class);
    /**
     * string 操作
     */
    @Autowired
    @Qualifier("valueOperations")
    private ValueOperations<String, Object> valueOperations;


    @Autowired
    private RedisTemplate redisTemplate;


    public void set(String key, Object o) {
        if (StringUtils.isNotEmpty(key) && o != null) {
            try {
                valueOperations.set(key, o);
            } catch (Throwable e) {
                log.error("set error :" + e);
            }
        }
    }

    public void setx(String key, Object value, int timeout) {
        valueOperations.set(key, value, timeout, TimeUnit.SECONDS);

    }

    public Object get(String key) {
        if (StringUtils.isNotEmpty(key)) {
            try {
                Object s = valueOperations.get(key);
                if (s == null) {
                    s = valueOperations.get(key);
                }
                return s;
            } catch (Throwable e) {
                log.error("get error :" + e);
            }
        }
        return null;
    }

    public Set<String> keys(String parrten) {
        if (StringUtils.isNotEmpty(parrten)) {
            try {
                Set<String> s = valueOperations.getOperations().keys(parrten);

                return s;
            } catch (Throwable e) {
                log.error("get error :" + e);
            }
        }
        return null;
    }


    public Boolean contains(String key) throws Exception {
        return valueOperations.getOperations().hasKey(key);

    }


    /**
     * @param key
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }


}

