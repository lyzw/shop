package com.sapling.shop.biz.common.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.sapling.common.tools.collection.MapUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/15
 * @since v1.0
 */
//@Configuration
public class WebFastjsonConfig implements WebMvcConfigurer {


    ///这种貌似没有效果，在使用的时候，WebMvcConfigurer.super.configureMessageConverters(converters);
    //converters中还是可以看到jackson的转换器
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteDateUseDateFormat);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //用双引号包住key，防止出现key为数字的时候，某些json包不能处理
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.QuoteFieldNames);
        //原样显示null数据（防止丢失key）
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //处理中文乱码
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);

        converters.add(fastConverter);
    }


}
