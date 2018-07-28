package com.sapling.shop.biz.common.web;

import javax.validation.constraints.NotNull;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/12
 * @since v1.0
 */
public class BaseReqeust<T> {

    private String requestId;
    private String version;

    @NotNull(message = "参数内容不能为空")
    private T data;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
