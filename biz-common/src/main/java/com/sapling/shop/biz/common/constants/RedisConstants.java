package com.sapling.shop.biz.common.constants;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/29
 * @since v1.0
 */
public class RedisConstants {

    public static final String REDIS_PREFIX = "shop";

    public static final String REDIS_SEPARATOR = ":";

    public static final String REDIS_TOKEN_PRIFEX =
            REDIS_PREFIX + REDIS_SEPARATOR + "token" + REDIS_SEPARATOR;
}
