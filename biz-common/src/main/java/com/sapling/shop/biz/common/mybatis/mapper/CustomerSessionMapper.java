package com.sapling.shop.biz.common.mybatis.mapper;

import com.sapling.shop.biz.common.mybatis.model.CustomerSession;

import java.util.List;

public interface CustomerSessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerSession record);

    CustomerSession selectByPrimaryKey(Long id);

    List<CustomerSession> selectAll();

    int updateByPrimaryKey(CustomerSession record);

    CustomerSession selectByAuthToken(String token);
}