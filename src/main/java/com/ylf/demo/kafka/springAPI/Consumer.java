package com.ylf.demo.kafka.springAPI;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: leifeng.ye
 * @date: 2020-01-20
 * @desc:
 */
@Component
public class Consumer {
    @KafkaListener(topics = "ylf")
    public void  listen(ConsumerRecord<String,String> record){
        System.out.printf("topic=%s,offset=%d,value=%s\n",record.topic(),record.offset(),record.value());
    }
}
