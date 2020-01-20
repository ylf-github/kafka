package com.ylf.demo.kafka.util;

import org.apache.kafka.common.serialization.Serializer;

/**
 * @author: leifeng.ye
 * @date: 2020-01-20
 * @desc:
 */
public class KafkaEncoder implements Serializer<Object> {
    @Override
    public byte[] serialize(String s, Object o) {
        return EntitySerialize.entityToByte(o);
    }
}
