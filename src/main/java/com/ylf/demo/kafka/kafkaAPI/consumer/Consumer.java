package com.ylf.demo.kafka.kafkaAPI.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author: leifeng.ye
 * @date: 2020-01-16
 * @desc:
 */
public class Consumer {

    private static final String TOPIC = "face";
    private static final String BROKER_LIST = "120.27.246.207:9092";
    private static KafkaConsumer<String,String> consumer = null;
    private static ArrayList<String> list=new ArrayList<>();
    static {
        list.add(TOPIC);
        Properties configs = initConfig();
        consumer = new KafkaConsumer<String, String>(configs);
        consumer.subscribe(list);
    }

    private static Properties initConfig(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers",BROKER_LIST);
        properties.put("group.id","0");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty("enable.auto.commit", "true");
        properties.setProperty("auto.offset.reset", "earliest"); // latest
        return properties;
    }

    public static void main(String[] args) {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.topic()+","+record.partition()+","+record.value());
            }
        }
    }

}
