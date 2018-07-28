package com.sapling.shop.biz.common.filter;

import com.sapling.common.tools.common.StringUtil;
import com.sapling.shop.biz.common.constants.Constants;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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
public class AuthTokenFilter implements Filter {

//    @Value("cache.jedis.enable")


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        String method = ((HttpServletRequest) request).getMethod();
        if (method.equals("OPTIONS")) {
            rep.setStatus(HttpServletResponse.SC_OK);
        } else {
            String token = req.getHeader(Constants.HEADER_AUTH_TOKEN);
            if (StringUtil.isEmpty(token, true)) {
                rep.setStatus(HttpStatus.SC_UNAUTHORIZED);
            }else{
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }

}
