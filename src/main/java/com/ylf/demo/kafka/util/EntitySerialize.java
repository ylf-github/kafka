package com.ylf.demo.kafka.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: leifeng.ye
 * @date: 2020-01-20
 * @desc:
 */
public class EntitySerialize {

    public static byte[] entityToByte(Object object){   //序列化对象
        byte[] res=null;
        try{
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArray);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            res=byteArray.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public static Object byteToEnyity(byte[] bytes){  //反序列化
        Object res=null;
        try{
            ByteArrayInputStream byteArray=new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream=new ObjectInputStream(byteArray);
            res=objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
