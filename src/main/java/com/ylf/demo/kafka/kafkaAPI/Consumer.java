package com.ylf.demo.kafka.kafkaAPI;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Properties;

/**
 * @author: leifeng.ye
 * @date: 2020-01-16
 * @desc:
 */
public class Consumer {
    static Logger log = LoggerFactory.getLogger(Consumer.class);

    private static final String TOPIC = "ylf";
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
            ConsumerRecords<String, String> records = consumer.poll(10);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
            }
        }
    }

}
