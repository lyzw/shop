package com.sapling.shop.biz.common.filter;

import com.alibaba.fastjson.JSON;
import com.sapling.common.exception.SaplingException;
import com.sapling.common.tools.common.StringUtil;
import com.sapling.shop.biz.common.constants.Constants;
import com.sapling.shop.biz.common.constants.ReturnCode;
import com.sapling.shop.biz.common.exception.UnAuthorizedException;
import com.sapling.shop.biz.common.mybatis.model.Customer;
import com.sapling.shop.biz.common.web.BaseResponse;
import com.sapling.shop.biz.common.web.service.CustomerAuthorTokenSerivce;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/17
 * @since v1.0
 */
@Configuration
@ConfigurationProperties
@Component
public class AuthTokenFilter implements Filter {

    @Value("${auth.exclude.urls:11}")
    String excludeUrls;

    private static final String SEPARATOR_EXCLUDE_URL = ",";
    @Autowired
    CustomerAuthorTokenSerivce authorTokenSerivce;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        String method = ((HttpServletRequest) request).getMethod();
        String url = ((HttpServletRequest) request).getRequestURI();
        boolean flag = false;
        if (HttpMethod.OPTIONS.name().equals(method)) {
            rep.setStatus(HttpServletResponse.SC_OK);
        }
        String[] excludeArray = excludeUrls.split(SEPARATOR_EXCLUDE_URL);
        if (excludeArray != null && excludeArray.length >0 ) {
            for (String excludeUrl : excludeArray) {
                //以*结尾的则是匹配以*前开头的url
                if (excludeUrl.endsWith("*")) {
                    if (url.startsWith(excludeUrl.substring(0,excludeUrl.length()-1))) {
                        flag = true;
                        break;
                    }
                    //否则全路径进行匹配
                } else {
                    if (url.equals(excludeUrl)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        if (!flag) {
            String token = req.getHeader(Constants.HEADER_AUTH_TOKEN);
            if (StringUtil.isEmpty(token, true)) {
                rep.setStatus(HttpStatus.SC_UNAUTHORIZED);
            } else {
                Customer customer = authorTokenSerivce.authToken(token);
                if (customer == null) {
                    ((HttpServletResponse) response).setStatus(HttpStatus.SC_UNAUTHORIZED);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write(JSON.toJSONString(BaseResponse.fail(ReturnCode.UNAUTHORIZED,"未登陆或者登陆超时")));
                } else {
                    request.setAttribute(Constants.REQUEST_LOGIN_CUSTOMER, customer);
                    authorTokenSerivce.refreshToken(token);
                    chain.doFilter(request, response);
                }
            }
        } else {
            chain.doFilter(request, response);
        }

    }


    @Override
    public void destroy() {

    }

}
