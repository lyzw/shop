package com.sapling.shop.biz.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/16
 * @since v1.0
 */
@Configuration
public class FastjsonMessageConvertor {


    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //使用这种时间格式化会导致所有的时间都会成这个格式，在类中定义的会失效
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteDateUseDateFormat);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //用双引号包住key，防止出现key为数字的时候，某些json包不能处理
        fastJsonConfig.setSerializerFeatures(SerializerFeature.QuoteFieldNames);
        //原样显示null数据（防止丢失key）
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //处理中文乱码
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        return new HttpMessageConverters(fastConverter);
    }
}
