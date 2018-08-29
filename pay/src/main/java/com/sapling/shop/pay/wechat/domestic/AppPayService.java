package com.sapling.shop.pay.wechat.domestic;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.*;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/8/9
 * @since v1.0
 */
public class AppPayService {


    @Autowired
    WechatDomesticPayConfig config;

    /**
     * app支付统一下单
     *
     * @param deviceInfo 设备信息
     * @param summary    商品描述
     * @param detail     商品详情
     * @param attach     附加数据
     * @param orderNo    商品订单号
     * @param currency   币种，默认为CNY
     * @param amount     总金额，单位为分
     * @param userIp     用户ip
     * @param startTime  订单开始时间
     * @param endTime    订单失效时间
     * @param goodsTag   订单优惠标记
     * @param notifyUrl  通知地址
     * @param limitPay   限定交易类型
     * @param sceneInfo  场景信息
     */
    public void unifiedorder(String deviceInfo, String summary, String detail,
                             String attach, String orderNo, String currency,
                             Integer amount, String userIp, Date startTime, Date endTime,
                             String goodsTag, String notifyUrl, String limitPay,
                             String sceneInfo) {
        Map map = new HashMap<>();
//        JSONObject jsonObject = JSONObject.wrap(map);


    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"1","2"});
        String[] args2 = new String[list.size()];
        list.toArray(args2);
        AppPayService.test(args2);
    }

    public static void test(String... args){

    }
}
