package com.sapling.shop.biz.common.exception;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/8/7
 * @since v1.0
 */
public class NotEnoughPermissionException extends ShopBaseException {

    public NotEnoughPermissionException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public NotEnoughPermissionException(String message, String errorCode, String errorMsg) {
        super(message, errorCode, errorMsg);
    }

    public NotEnoughPermissionException(String message, Throwable cause, String errorCode, String errorMsg) {
        super(message, cause, errorCode, errorMsg);
    }

    public NotEnoughPermissionException(Throwable cause, String errorCode, String errorMsg) {
        super(cause, errorCode, errorMsg);
    }

    public NotEnoughPermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode, String errorMsg) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode, errorMsg);
    }
}
