package com.ylf.demo.kafka.kafkaAPI;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author: leifeng.ye
 * @date: 2020-02-04
 * @desc:
 */
public class PartitionProducer {
    private static String TOPIC="face";
    private static String BROKER_LIST="120.27.246.207:9092";
    private static KafkaProducer<String,String> producer=null;

    static {
        Properties properties=initConfig();
        producer=new KafkaProducer<String, String>(properties);
    }

    private static Properties initConfig(){
        Properties properties=new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,BROKER_LIST);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.ylf.demo.kafka.kafkaAPI.partition.MyPartitioner");
        return properties;
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            ProducerRecord<String,String> record=null;
            record=new ProducerRecord<String,String>(TOPIC,"hello world");
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if(e!=null){
                        System.out.println("error");
                    }
                    else{
                        System.out.println((String.format("offset:%s,partition:%s",recordMetadata.offset(),recordMetadata.partition())));
                    }
                }
            });
        }
        producer.close();
    }
}
