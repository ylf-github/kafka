package com.ylf.demo.kafka.kafkaAPI.review;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author: leifeng.ye
 * @date: 2020-03-29
 * @desc:
 */
public class Consumer {
    static Properties properties;
    public static void init(){
        properties=new Properties();
        properties.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG,"read_committed");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"2");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"120.27.246.207:9092");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
    }

    public static void main(String[] args) {
        init();
        KafkaConsumer consumer=new KafkaConsumer(properties);
        consumer.subscribe(Arrays.asList("review"));
        while (true){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.topic()+","+record.partition()+","+record.value());
            }
            consumer.commitAsync();
        }
    }

}
