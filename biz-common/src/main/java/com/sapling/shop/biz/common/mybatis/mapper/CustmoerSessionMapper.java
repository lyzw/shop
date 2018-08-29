package com.sapling.shop.biz.common.mybatis.mapper;

import com.sapling.shop.biz.common.annotation.MethodMeasureAnnotation;
import com.sapling.shop.biz.common.mybatis.model.CustmoerSession;
import java.util.List;

public interface CustmoerSessionMapper {

    @MethodMeasureAnnotation
    int deleteByPrimaryKey(Long id);

    @MethodMeasureAnnotation
    int insert(CustmoerSession record);

    @MethodMeasureAnnotation
    CustmoerSession selectByPrimaryKey(Long id);

    @MethodMeasureAnnotation
    List<CustmoerSession> selectAll();

    @MethodMeasureAnnotation
    int updateByPrimaryKey(CustmoerSession record);

    @MethodMeasureAnnotation
    CustmoerSession selectByToken(Long id);


}