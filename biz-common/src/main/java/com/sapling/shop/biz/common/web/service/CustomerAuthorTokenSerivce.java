package com.sapling.shop.biz.common.web.service;

import com.sapling.shop.biz.common.mybatis.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/26
 * @since v1.0
 */
@Service
public class CustomerAuthorTokenSerivce {



    @Autowired
    CustomerMapper customerMapper;

    public Object authToken(String token,Class clazz){

        return null;
    }

}
