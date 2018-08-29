package com.sapling.shop.biz.common.exception;

import com.sapling.common.exception.SaplingException;
import com.sapling.shop.biz.common.constants.ReturnCode;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/26
 * @since v1.0
 */
public class ShopBaseException extends SaplingException {


    public ShopBaseException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ShopBaseException(String message, String errorCode, String errorMsg) {
        super(message, errorCode, errorMsg);
    }

    public ShopBaseException(String message, Throwable cause, String errorCode, String errorMsg) {
        super(message, cause, errorCode, errorMsg);
    }

    public ShopBaseException(Throwable cause, String errorCode, String errorMsg) {
        super(cause, errorCode, errorMsg);
    }

    public ShopBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode, String errorMsg) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode, errorMsg);
    }
}
