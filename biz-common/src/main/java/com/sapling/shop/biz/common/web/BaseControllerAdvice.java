package com.sapling.shop.biz.common.web;

import com.sapling.common.exception.SaplingException;
import com.sapling.shop.biz.common.constants.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/15
 * @since v1.0
 */

@ControllerAdvice(basePackages = "com.sapling.shop")
@RestController
public class BaseControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseControllerAdvice.class);

    /**
     * 方法参数异常处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse processIllegalArgumentsException(HttpServletRequest request, IllegalArgumentException e) {
        LOGGER.error("参数异常{}", e);
        return BaseResponse.fail(ReturnCode.ILLEGAL_ARGUMENT, "缺少必要的参数");
    }

    /**
     * 方法参数异常处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse processIllegalArgumentsException(HttpServletRequest request, MissingServletRequestParameterException e) {
        return BaseResponse.fail(ReturnCode.ILLEGAL_ARGUMENT, "缺少必要的参数");
    }

    /**
     * 方法参数异常处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(SaplingException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse processSaplingException(HttpServletRequest request, SaplingException e) {
        return BaseResponse.fail(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * token不存在异常处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse processUnknownException(HttpServletRequest request, Exception e) {
        LOGGER.error("发生异常", e);
        return BaseResponse.fail(ReturnCode.SYSTEM_ERROR, "系统内部异常，请联系管理员");
    }

}
