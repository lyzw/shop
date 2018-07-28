package com.sapling.shop.biz.common.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/12
 * @since v1.0
 */
public class BaseController<T> {

    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {

    }
}
