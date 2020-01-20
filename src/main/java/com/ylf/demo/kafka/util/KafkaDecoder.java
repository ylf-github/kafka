package com.ylf.demo.kafka.util;


import org.apache.kafka.common.serialization.Deserializer;

/**
 * @author: leifeng.ye
 * @date: 2020-01-20
 * @desc:
 */
public class KafkaDecoder implements Deserializer<Object> {
    @Override
    public Object deserialize(String s, byte[] bytes) {
        return EntitySerialize.byteToEnyity(bytes);
    }
}
