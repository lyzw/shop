package com.sapling.shop.biz.common.mybatis.mapper;

import com.sapling.shop.biz.common.mybatis.model.SysUser;
import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    SysUser selectByUserName(String userName);
}