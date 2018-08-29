package com.sapling.shop.biz.common.exception;

import com.sapling.shop.biz.common.constants.ReturnCode;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/8/7
 * @since v1.0
 */
public class ShopExceptionBuilder {

    public static UnAuthorizedException unAuthorizedException(){
        return new UnAuthorizedException(ReturnCode.UNAUTHORIZED,"未登陆或登陆超时");
    }

    public static NotEnoughPermissionException notEnoughPermissionException(){
        return new NotEnoughPermissionException(ReturnCode.NOT_ENOUGH_PERMISSION,"权限不足");
    }
}
