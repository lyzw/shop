package com.sapling.shop.biz.common.web;

import com.sapling.shop.biz.common.constants.Constants;
import com.sapling.shop.biz.common.mybatis.model.Customer;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 以登陆
 *
 * @author weizhou
 * @version v1.0
 * @date 2018/8/1
 * @since v1.0
 */
public class CustLogedInBaseController extends BaseController {

    public HttpServletRequest request() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public HttpServletResponse response() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public Customer getCustomer() {
        return (Customer) request().getAttribute(Constants.REQUEST_LOGIN_CUSTOMER);
    }

    public String token() {
        return request().getHeader(Constants.HEADER_AUTH_TOKEN);
    }
}
