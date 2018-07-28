package com.sapling.shop.biz.common.constants;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/15
 * @since v1.0
 */
public class ReturnCode {

    public static final String SUCCESS = "000000";

    //1+为通用的异常
    //参数不合法
    public static final String ILLEGAL_ARGUMENT = "100001";
    //记录不存在，适用于查询、修改等操作
    public static final String RECORD_NOT_EXISTS = "100002";
    //记录已经存在，适用于创建新的记录
    public static final String RECORD_ALREADY_EXISTS = "100003";

    //9+为系统级别异常
    public static final String SYSTEM_ERROR = "999999";

    public static final String RET_MSG_SUCCESS = "SUCCESS";
}
