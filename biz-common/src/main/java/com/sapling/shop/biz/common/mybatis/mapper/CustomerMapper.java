package com.sapling.shop.biz.common.mybatis.mapper;

import com.sapling.shop.biz.common.mybatis.model.Customer;
import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    Customer selectByPrimaryKey(Long id);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);

    Customer selectByUserName(String userName);
}