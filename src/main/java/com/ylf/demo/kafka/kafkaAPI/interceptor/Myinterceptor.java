package com.ylf.demo.kafka.kafkaAPI.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author: leifeng.ye
 * @date: 2020-02-04
 * @desc:
 */
public class Myinterceptor implements ProducerInterceptor {

    int success=0;
    int fail=0;

    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        final ProducerRecord<String, String> record = new ProducerRecord<String, String>(producerRecord.topic(), producerRecord.partition(), (String) producerRecord.key(), producerRecord.value() + "拦截");
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
          if(recordMetadata!=null){
              success++;
          }
          else{
              fail++;
          }
    }

    @Override
    public void close() {
        System.out.println("success:"+success);
        System.out.println("fail:"+fail);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
