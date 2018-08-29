package com.sapling.shop.biz.common.web.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sapling.common.tools.common.StringUtil;
import com.sapling.shop.biz.common.config.RedisConfig;
import com.sapling.shop.biz.common.constants.RedisConstants;
import com.sapling.shop.biz.common.mybatis.mapper.CustomerMapper;
import com.sapling.shop.biz.common.mybatis.mapper.CustomerSessionMapper;
import com.sapling.shop.biz.common.mybatis.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/26
 * @since v1.0
 */
@Service
public class CustomerAuthorTokenSerivce {


    @Value("${login.expire.time:10}")
    Long expireTime;

    @Autowired
    RedisConfig redisConfig;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    ValueOperations valueOperations;

    @Autowired
    CustomerSessionMapper customerSessionMapper;


    public Customer authToken(String token) {
        String key = RedisConstants.REDIS_TOKEN_PRIFEX + token;
        String value = String.valueOf(valueOperations.get(key));
        if (StringUtil.isEmpty(value, true)) {
            return null;
        } else {
            Customer customer = JSONObject.parseObject(value, Customer.class);
            return customer;
        }
    }

    /**
     * 刷新token
     *
     * @param token
     */
    public void refreshToken(String token) {
        String key = RedisConstants.REDIS_TOKEN_PRIFEX + token;
        valueOperations.getOperations().expire(key, expireTime, TimeUnit.MINUTES);
    }

    /**
     * 设置token
     *
     * @param token
     * @param customer
     */
    public void setToken(String token, Customer customer) {
        String key = RedisConstants.REDIS_TOKEN_PRIFEX + token;
        valueOperations.set(key, JSON.toJSONString(customer), expireTime, TimeUnit.MINUTES);
    }


    /**
     * 退出登陆
     *
     * @param token
     */
    public void logoutToken(String token) {
        String key = RedisConstants.REDIS_TOKEN_PRIFEX + token;
        valueOperations.getOperations().delete(key);
    }


}
