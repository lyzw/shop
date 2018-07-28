package com.sapling.shop.biz.common.web;

import com.sapling.shop.biz.common.constants.ReturnCode;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/12
 * @since v1.0
 */
public class BaseResponse {

    private String retCode;
    private String retMsg;
    private Long retTime;
    private Object data;

    public BaseResponse() {

    }

    public BaseResponse(String retCode, String retMsg, Long retTime, Object data) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.retTime = retTime;
        this.data = data;
    }

    public static BaseResponse fail(String retCode, String retMsg) {
        return new BaseResponse(retCode, retMsg, System.currentTimeMillis(), null);
    }

    public static BaseResponse success(Object data) {
        return new BaseResponse(ReturnCode.SUCCESS, ReturnCode.RET_MSG_SUCCESS, System.currentTimeMillis(), data);
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Long getRetTime() {
        return retTime;
    }

    public void setRetTime(Long retTime) {
        this.retTime = retTime;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
