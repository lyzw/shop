package com.sapling.shop.biz.common.mybatis.mapper;

import com.sapling.shop.biz.common.mybatis.model.SysSessionToken;
import java.util.List;

public interface SysSessionTokenMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysSessionToken record);

    SysSessionToken selectByPrimaryKey(Long id);

    List<SysSessionToken> selectAll();

    int updateByPrimaryKey(SysSessionToken record);
}