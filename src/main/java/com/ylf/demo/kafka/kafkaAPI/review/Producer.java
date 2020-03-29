package com.ylf.demo.kafka.kafkaAPI.review;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author: leifeng.ye
 * @date: 2020-03-29
 * @desc:
 */
public class Producer {

    static Properties properties;

    public static void init(){
        properties=new Properties();
        properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,"hello");
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,true);
        properties.put(ProducerConfig.ACKS_CONFIG,"-1");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"120.27.246.207:9092");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
    }

    public static void main(String[] args) {
        init();
        KafkaProducer producer=new KafkaProducer(properties);
        producer.initTransactions();
        producer.beginTransaction();
        for(int i=0;i<3;i++){
                      producer.send(new ProducerRecord("review", "" + i), new Callback() {
                          @Override
                          public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                              if(e!=null){
                                e.printStackTrace();
                              }
                              else {
                                  System.out.println(recordMetadata.partition()+" "+recordMetadata.offset());
                              }
                          }
                      });

        }
        producer.commitTransaction();
        producer.close();
    }
}
