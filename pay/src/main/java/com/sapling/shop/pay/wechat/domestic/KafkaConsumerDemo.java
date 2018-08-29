package com.sapling.shop.pay.wechat.domestic;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/8/26
 * @since v1.0
 */
public class KafkaConsumerDemo {

    public static void main(String[] args) {
        Properties props = new Properties();
        //设置服务器地址
        props.put("bootstrap.servers", "localhost:9092");
        //设置消费组id
        props.put("group.id", "test");
        //设置是否自动提交
        props.put("enable.auto.commit", "true");
        //自动提交时间间隔
        props.put("auto.commit.interval.ms", "1000");
        //键的序列化方式
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //值的序列化方式
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        @SuppressWarnings("resource")
        //订阅Topic
                KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test"));
        Map topics = consumer.listTopics();
        System.out.println("topics === " + topics);
        //定时轮训，获取数据信息
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);


            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
    }
}
